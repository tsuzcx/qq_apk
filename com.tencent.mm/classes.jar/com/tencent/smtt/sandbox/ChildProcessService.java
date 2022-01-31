package com.tencent.smtt.sandbox;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.smtt.sdk.q;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.chromium.base.process_launcher.IChildProcessService.Stub;

public abstract class ChildProcessService
  extends Service
{
  private static final boolean ENABLE_DEBUG = false;
  private static final String MAIN_THREAD_NAME = "ChildProcessMain";
  private static final String TAG = "ChildProcessService";
  private static boolean sCreateCalled;
  public static boolean use_isolated_process;
  private final Semaphore mActivitySemaphore = new Semaphore(1);
  private boolean mBindToCallerCheck;
  private final IChildProcessService.Stub mBinder = new ChildProcessService.1(this);
  private final Object mBinderLock = new Object();
  private int mBoundCallingPid;
  private String[] mCommandLineParams;
  private final ChildProcessServiceDelegate mDelegate;
  private FileDescriptorInfo[] mFdInfos;
  private ParcelFileDescriptor[] mFdsOfLibraryies = null;
  private ParcelFileDescriptor[] mLazilyLoadedLibraryFDs = null;
  private CharSequence[] mLazilyLoadedLibraryNames = null;
  private boolean mLibraryInitialized;
  private final Object mLibraryInitializedLock = new Object();
  private Thread mMainThread;
  private boolean mServiceBound;
  
  static
  {
    if (!ChildProcessService.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      use_isolated_process = false;
      return;
    }
  }
  
  public ChildProcessService(ChildProcessServiceDelegate paramChildProcessServiceDelegate)
  {
    this.mDelegate = paramChildProcessServiceDelegate;
    ((SandboxContentChildProcessServiceDelegate)this.mDelegate).setService(this);
  }
  
  private void displayLazilyLoadedLibraries()
  {
    int i = 0;
    try
    {
      while (i < this.mLazilyLoadedLibraryNames.length)
      {
        ParcelFileDescriptor localParcelFileDescriptor = this.mLazilyLoadedLibraryFDs[i];
        byte[] arrayOfByte = new byte[4];
        new FileInputStream(localParcelFileDescriptor.getFileDescriptor()).read(arrayOfByte);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private ParcelFileDescriptor getLazilyLoadedLibrary(String paramString)
  {
    int i = 0;
    try
    {
      while (i < this.mLazilyLoadedLibraryNames.length)
      {
        CharSequence localCharSequence = this.mLazilyLoadedLibraryNames[i];
        ParcelFileDescriptor localParcelFileDescriptor = this.mLazilyLoadedLibraryFDs[i];
        boolean bool = paramString.equals(localCharSequence);
        if (bool) {
          return localParcelFileDescriptor;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  private void processConnectionBundle(Bundle paramBundle, List<IBinder> paramList)
  {
    paramBundle.setClassLoader(getApplicationContext().getClassLoader());
    synchronized (this.mMainThread)
    {
      SandboxBuildInfo.setSandboxBuildInfo(paramBundle.getStringArray("sandbox_buildinfo"));
      SandboxSysUtils.setIsLowEndDevice(paramBundle.getBoolean("sandbox_isLowEndDevice"));
      if (this.mCommandLineParams == null)
      {
        this.mCommandLineParams = paramBundle.getStringArray("org.chromium.base.process_launcher.extra.command_line");
        this.mMainThread.notifyAll();
      }
      if ((!$assertionsDisabled) && (this.mCommandLineParams == null)) {
        throw new AssertionError();
      }
    }
    Object localObject = paramBundle.getIntArray("com.google.android.apps.chrome.extra.extraFileIds");
    Parcelable[] arrayOfParcelable1 = paramBundle.getParcelableArray("com.google.android.apps.chrome.extra.extraFileFds");
    long[] arrayOfLong1 = paramBundle.getLongArray("com.google.android.apps.chrome.extra.extraFileOffsets");
    long[] arrayOfLong2 = paramBundle.getLongArray("com.google.android.apps.chrome.extra.extraFileSizes");
    Parcelable[] arrayOfParcelable2 = paramBundle.getParcelableArray("com.google.android.apps.chrome.extra.extraFileFdsOfLibrary");
    this.mFdsOfLibraryies = new ParcelFileDescriptor[arrayOfParcelable2.length];
    int i = 0;
    while (i < arrayOfParcelable2.length)
    {
      this.mFdsOfLibraryies[i] = ((ParcelFileDescriptor)arrayOfParcelable2[i]);
      i += 1;
    }
    if (localObject != null)
    {
      int j = localObject.length;
      this.mFdInfos = new FileDescriptorInfo[j];
      i = 0;
      while (i < j)
      {
        this.mFdInfos[i] = new FileDescriptorInfo(localObject[i], (ParcelFileDescriptor)arrayOfParcelable1[i], arrayOfLong1[i], arrayOfLong2[i]);
        i += 1;
      }
    }
    this.mLazilyLoadedLibraryNames = paramBundle.getCharSequenceArray("lazy_load_library_names");
    localObject = paramBundle.getParcelableArray("lazy_load_library_fds");
    if (localObject != null)
    {
      this.mLazilyLoadedLibraryFDs = new ParcelFileDescriptor[this.mLazilyLoadedLibraryNames.length];
      System.arraycopy(localObject, 0, this.mLazilyLoadedLibraryFDs, 0, this.mLazilyLoadedLibraryNames.length);
    }
    q.c();
    this.mDelegate.onConnectionSetup(paramBundle, paramList);
    this.mMainThread.notifyAll();
  }
  
  public ParcelFileDescriptor getFdByFileName(String paramString)
  {
    int i = 0;
    while (i < this.mLazilyLoadedLibraryNames.length)
    {
      CharSequence localCharSequence = this.mLazilyLoadedLibraryNames[i];
      ParcelFileDescriptor localParcelFileDescriptor = this.mLazilyLoadedLibraryFDs[i];
      if (paramString.equals(localCharSequence)) {
        return localParcelFileDescriptor;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean isServiceIsolated(Service paramService)
  {
    try
    {
      String str = paramService.getClass().getName();
      int i = paramService.getPackageManager().getServiceInfo(new ComponentName(paramService.getApplicationContext().getApplicationInfo().packageName, str), 128).flags;
      return (i & 0x2) != 0;
    }
    catch (PackageManager.NameNotFoundException paramService)
    {
      Log.e("ChildProcessService", "Could not get application info", new Object[] { paramService });
    }
    return false;
  }
  
  public boolean lazyLoadLibraryByName(String paramString)
  {
    try
    {
      q.a(paramString, getLazilyLoadedLibrary(paramString));
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    assert (!this.mServiceBound);
    stopSelf();
    this.mBindToCallerCheck = paramIntent.getBooleanExtra("org.chromium.base.process_launcher.extra.bind_to_caller", false);
    this.mServiceBound = true;
    this.mDelegate.onServiceBound(paramIntent);
    new Handler(Looper.getMainLooper()).post(new ChildProcessService.3(this));
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (sCreateCalled) {
      throw new RuntimeException("Illegal child process reuse.");
    }
    sCreateCalled = true;
    use_isolated_process = isServiceIsolated(this);
    Context localContext = getApplicationContext();
    ContextUtils.initApplicationContext(localContext);
    this.mDelegate.onServiceCreated();
    this.mMainThread = new Thread(new ChildProcessService.2(this, localContext), "ChildProcessMain");
    this.mMainThread.start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mActivitySemaphore.tryAcquire())
    {
      System.exit(0);
      return;
    }
    synchronized (this.mLibraryInitializedLock)
    {
      try
      {
        while (!this.mLibraryInitialized) {
          this.mLibraryInitializedLock.wait();
        }
        localObject2 = finally;
      }
      catch (InterruptedException localInterruptedException)
      {
        this.mDelegate.onDestroy();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ChildProcessService
 * JD-Core Version:    0.7.0.1
 */