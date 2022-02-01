package com.tencent.smtt.sandbox;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.chromium.base.process_launcher.ICallbackInt;
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
  private final IChildProcessService.Stub mBinder = new IChildProcessService.Stub()
  {
    static
    {
      AppMethodBeat.i(53762);
      if (!ChildProcessService.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(53762);
        return;
      }
    }
    
    public boolean bindToCaller()
    {
      AppMethodBeat.i(53758);
      if ((!$assertionsDisabled) && (!ChildProcessService.this.mBindToCallerCheck))
      {
        ??? = new AssertionError();
        AppMethodBeat.o(53758);
        throw ((Throwable)???);
      }
      if ((!$assertionsDisabled) && (!ChildProcessService.this.mServiceBound))
      {
        ??? = new AssertionError();
        AppMethodBeat.o(53758);
        throw ((Throwable)???);
      }
      synchronized (ChildProcessService.this.mBinderLock)
      {
        int i = Binder.getCallingPid();
        if (ChildProcessService.this.mBoundCallingPid == 0) {
          ChildProcessService.access$302(ChildProcessService.this, i);
        }
        while (ChildProcessService.this.mBoundCallingPid == i)
        {
          AppMethodBeat.o(53758);
          return true;
        }
        Log.e("ChildProcessService", "Service is already bound by pid %d, cannot bind for pid %d", new Object[] { Integer.valueOf(ChildProcessService.this.mBoundCallingPid), Integer.valueOf(i) });
        AppMethodBeat.o(53758);
        return false;
      }
    }
    
    public void crashIntentionallyForTesting()
    {
      AppMethodBeat.i(53761);
      Log.d("ChildProcessService", "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "]... ");
      if ((!$assertionsDisabled) && (!ChildProcessService.this.mServiceBound))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(53761);
        throw localAssertionError;
      }
      AppMethodBeat.o(53761);
    }
    
    public void invokeMiscMethod(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      AppMethodBeat.i(53759);
      Log.d("ChildProcessService", "invokeMiscMethod -- method: " + paramAnonymousString + ", bundle: " + paramAnonymousBundle);
      AppMethodBeat.o(53759);
    }
    
    public void setupConnection(Bundle paramAnonymousBundle, ICallbackInt paramAnonymousICallbackInt, List<IBinder> paramAnonymousList)
    {
      AppMethodBeat.i(53760);
      Log.d("ChildProcessService", "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] args: " + paramAnonymousBundle);
      if ((!$assertionsDisabled) && (!ChildProcessService.this.mServiceBound))
      {
        paramAnonymousBundle = new AssertionError();
        AppMethodBeat.o(53760);
        throw paramAnonymousBundle;
      }
      synchronized (ChildProcessService.this.mBinderLock)
      {
        if ((ChildProcessService.this.mBindToCallerCheck) && (ChildProcessService.this.mBoundCallingPid == 0))
        {
          Log.e("ChildProcessService", "Service has not been bound with bindToCaller()", new Object[0]);
          paramAnonymousICallbackInt.call(-1);
          AppMethodBeat.o(53760);
          return;
        }
        paramAnonymousICallbackInt.call(Process.myPid());
        ChildProcessService.this.processConnectionBundle(paramAnonymousBundle, paramAnonymousList);
        AppMethodBeat.o(53760);
        return;
      }
    }
  };
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
  
  /* Error */
  private void displayLazilyLoadedLibraries()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: aload_0
    //   6: getfield 78	com/tencent/smtt/sandbox/ChildProcessService:mLazilyLoadedLibraryNames	[Ljava/lang/CharSequence;
    //   9: arraylength
    //   10: if_icmpge +123 -> 133
    //   13: aload_0
    //   14: getfield 78	com/tencent/smtt/sandbox/ChildProcessService:mLazilyLoadedLibraryNames	[Ljava/lang/CharSequence;
    //   17: iload_1
    //   18: aaload
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 76	com/tencent/smtt/sandbox/ChildProcessService:mLazilyLoadedLibraryFDs	[Landroid/os/ParcelFileDescriptor;
    //   25: iload_1
    //   26: aaload
    //   27: astore 5
    //   29: iconst_4
    //   30: newarray byte
    //   32: astore 6
    //   34: new 146	java/io/FileInputStream
    //   37: dup
    //   38: aload 5
    //   40: invokevirtual 152	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   43: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   46: astore_3
    //   47: aload_3
    //   48: aload 6
    //   50: invokevirtual 161	java/io/InputStream:read	([B)I
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 164	java/io/InputStream:close	()V
    //   58: ldc 21
    //   60: new 166	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 168
    //   66: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload 4
    //   71: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: ldc 177
    //   76: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 5
    //   81: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: ldc 182
    //   86: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 186	android/os/ParcelFileDescriptor:getFd	()I
    //   94: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 191
    //   99: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: new 193	java/lang/String
    //   105: dup
    //   106: aload 6
    //   108: invokespecial 196	java/lang/String:<init>	([B)V
    //   111: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 67	java/lang/Object
    //   121: invokestatic 206	com/tencent/smtt/sandbox/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: aload_3
    //   129: astore_2
    //   130: goto -126 -> 4
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 164	java/io/InputStream:close	()V
    //   141: return
    //   142: astore_2
    //   143: aload_3
    //   144: ifnull -3 -> 141
    //   147: aload_3
    //   148: invokevirtual 164	java/io/InputStream:close	()V
    //   151: return
    //   152: astore_2
    //   153: return
    //   154: astore_2
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 164	java/io/InputStream:close	()V
    //   163: aload_2
    //   164: athrow
    //   165: astore_2
    //   166: return
    //   167: astore_3
    //   168: goto -5 -> 163
    //   171: astore_3
    //   172: aload_2
    //   173: astore 4
    //   175: aload_3
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: goto -25 -> 155
    //   183: astore_3
    //   184: aload_2
    //   185: astore_3
    //   186: goto -43 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	ChildProcessService
    //   3	125	1	i	int
    //   1	137	2	localObject1	Object
    //   142	1	2	localThrowable1	Throwable
    //   152	1	2	localThrowable2	Throwable
    //   154	10	2	localObject2	Object
    //   165	8	2	localThrowable3	Throwable
    //   176	9	2	localObject3	Object
    //   46	114	3	localFileInputStream	java.io.FileInputStream
    //   167	1	3	localThrowable4	Throwable
    //   171	5	3	localObject4	Object
    //   179	1	3	localObject5	Object
    //   183	1	3	localThrowable5	Throwable
    //   185	1	3	localObject6	Object
    //   19	159	4	localObject7	Object
    //   27	63	5	localParcelFileDescriptor	ParcelFileDescriptor
    //   32	75	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	124	142	java/lang/Throwable
    //   147	151	152	java/lang/Throwable
    //   47	124	154	finally
    //   137	141	165	java/lang/Throwable
    //   159	163	167	java/lang/Throwable
    //   4	47	171	finally
    //   4	47	183	java/lang/Throwable
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
    Log.d("ChildProcessService", "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] bundle: " + paramBundle);
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
      Log.d("ChildProcessService", "#processConnectionBundle# mCommandLineParams:" + Arrays.toString(this.mCommandLineParams));
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
    Log.d("ChildProcessService", "#processConnectionBundle# fds_of_libraryies:" + this.mFdsOfLibraryies);
    Log.d("ChildProcessService", "#processConnectionBundle# bundle.getIntArray ids:".concat(String.valueOf(localObject)));
    if (localObject != null)
    {
      int j = localObject.length;
      this.mFdInfos = new FileDescriptorInfo[j];
      i = 0;
      while (i < j)
      {
        this.mFdInfos[i] = new FileDescriptorInfo(localObject[i], (ParcelFileDescriptor)arrayOfParcelable1[i], arrayOfLong1[i], arrayOfLong2[i]);
        Log.d("ChildProcessService", "#processConnectionBundle# mFdInfos[" + i + "](" + localObject[i] + "," + arrayOfParcelable1[i] + "," + arrayOfLong1[i] + "," + arrayOfLong2[i] + ")");
        i += 1;
      }
    }
    this.mLazilyLoadedLibraryNames = paramBundle.getCharSequenceArray("lazy_load_library_names");
    localObject = paramBundle.getParcelableArray("lazy_load_library_fds");
    Log.d("ChildProcessService", "#processConnectionBundle# mLazilyLoadedLibraryNames length: " + this.mLazilyLoadedLibraryNames.length + ", lazy_fds.length: " + localObject.length);
    if (localObject != null)
    {
      this.mLazilyLoadedLibraryFDs = new ParcelFileDescriptor[this.mLazilyLoadedLibraryNames.length];
      System.arraycopy(localObject, 0, this.mLazilyLoadedLibraryFDs, 0, this.mLazilyLoadedLibraryNames.length);
    }
    g.c();
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
      Log.d("ChildProcessService", "## serviceName=".concat(String.valueOf(str)));
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
      g.a(paramString, getLazilyLoadedLibrary(paramString));
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.d("ChildProcessService", "[" + Thread.currentThread().getStackTrace()[2].getMethodName() + "] intent: " + paramIntent);
    assert (!this.mServiceBound);
    stopSelf();
    this.mBindToCallerCheck = paramIntent.getBooleanExtra("org.chromium.base.process_launcher.extra.bind_to_caller", false);
    this.mServiceBound = true;
    this.mDelegate.onServiceBound(paramIntent);
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(53820);
        ChildProcessService.this.mDelegate.preloadNativeLibrary(ChildProcessService.this.getApplicationContext());
        AppMethodBeat.o(53820);
      }
    });
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Log.d("ChildProcessService", "Creating new ChildProcessService pid=%d", Integer.valueOf(Process.myPid()));
    if (sCreateCalled) {
      throw new RuntimeException("Illegal child process reuse.");
    }
    sCreateCalled = true;
    use_isolated_process = isServiceIsolated(this);
    Log.d("ChildProcessService", "## use_isolated_process=" + use_isolated_process);
    final Context localContext = getApplicationContext();
    ContextUtils.initApplicationContext(localContext);
    this.mDelegate.onServiceCreated();
    Log.d("ChildProcessService", "starting mMainThread thread @pid: " + Process.myPid());
    this.mMainThread = new Thread(new Runnable()
    {
      static
      {
        AppMethodBeat.i(53764);
        if (!ChildProcessService.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          AppMethodBeat.o(53764);
          return;
        }
      }
      
      public void run()
      {
        AppMethodBeat.i(53763);
        Log.i("ChildProcessService", "@mMainThread run... pid: " + Process.myPid() + ", use_isolated_process:" + ChildProcessService.use_isolated_process, new Object[0]);
        try
        {
          if (ChildProcessService.use_isolated_process)
          {
            g.d();
            g.a(ChildProcessService.this);
            Log.i("ChildProcessService", "@mMainThread after prepareLinker", new Object[0]);
          }
          synchronized (ChildProcessService.this.mMainThread)
          {
            if (ChildProcessService.this.mCommandLineParams == null) {
              ChildProcessService.this.mMainThread.wait();
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("ChildProcessService", "%s startup failed: %s", new Object[] { "ChildProcessMain", localInterruptedException });
          AppMethodBeat.o(53763);
          return;
        }
        if ((!$assertionsDisabled) && (!ChildProcessService.this.mServiceBound))
        {
          ??? = new AssertionError();
          AppMethodBeat.o(53763);
          throw ((Throwable)???);
        }
        boolean bool;
        if (ChildProcessService.use_isolated_process) {
          bool = g.a(localContext, ChildProcessService.this.mFdsOfLibraryies);
        }
        for (;;)
        {
          Log.i("ChildProcessService", "@mMainThread loadNativeLibrary successful: ".concat(String.valueOf(bool)), new Object[0]);
          if (!bool)
          {
            Log.e("ChildProcessService", "@mMainThread loadNativeLibrary failed!", new Object[0]);
            System.exit(-1);
            ChildProcessService.this.mDelegate.initCommandLine(ChildProcessService.this.mCommandLineParams);
          }
          synchronized (ChildProcessService.this.mLibraryInitializedLock)
          {
            ChildProcessService.access$1002(ChildProcessService.this, true);
            ChildProcessService.this.mLibraryInitializedLock.notifyAll();
            Log.d("ChildProcessService", "@mMainThread after mLibraryInitializedLock.notifyAll");
            synchronized (ChildProcessService.this.mMainThread)
            {
              ChildProcessService.this.mMainThread.notifyAll();
              if (ChildProcessService.this.mFdInfos != null) {
                break;
              }
              ChildProcessService.this.mMainThread.wait();
            }
            bool = g.a(localContext);
            continue;
            Log.i("ChildProcessService", "@mMainThread loadNativeLibrary successful!", new Object[0]);
            g.e();
          }
        }
        Log.d("ChildProcessService", "@mMainThread after mMainThread.wait");
        SparseArray localSparseArray = ChildProcessService.this.mDelegate.getFileDescriptorsIdsToKeys();
        Log.d("ChildProcessService", "@mMainThread after getFileDescriptorsIdsToKeys");
        int[] arrayOfInt1 = new int[ChildProcessService.this.mFdInfos.length];
        String[] arrayOfString = new String[ChildProcessService.this.mFdInfos.length];
        int[] arrayOfInt2 = new int[ChildProcessService.this.mFdInfos.length];
        long[] arrayOfLong1 = new long[ChildProcessService.this.mFdInfos.length];
        long[] arrayOfLong2 = new long[ChildProcessService.this.mFdInfos.length];
        int i = 0;
        FileDescriptorInfo localFileDescriptorInfo;
        while (i < ChildProcessService.this.mFdInfos.length)
        {
          localFileDescriptorInfo = ChildProcessService.this.mFdInfos[i];
          if (localSparseArray == null) {
            break label712;
          }
          ??? = (String)localSparseArray.get(localFileDescriptorInfo.id);
          break label700;
          if (localFileDescriptorInfo.fd != null) {
            arrayOfInt2[i] = localFileDescriptorInfo.fd.detachFd();
          }
          arrayOfLong1[i] = localFileDescriptorInfo.offset;
          arrayOfLong2[i] = localFileDescriptorInfo.size;
          i += 1;
        }
        label700:
        label712:
        label715:
        for (;;)
        {
          arrayOfInt1[i] = localFileDescriptorInfo.id;
          break;
          Log.d("ChildProcessService", "@mMainThread before RegisterFileDescriptors");
          ChildProcessService.this.mDelegate.RegisterFileDescriptors(arrayOfString, arrayOfInt1, arrayOfInt2, arrayOfLong1, arrayOfLong2);
          Log.d("ChildProcessService", "@mMainThread after RegisterFileDescriptors");
          ChildProcessService.this.mDelegate.onBeforeMain();
          Log.d("ChildProcessService", "@mMainThread after onBeforeMain");
          if (ChildProcessService.this.mActivitySemaphore.tryAcquire())
          {
            Log.d("ChildProcessService", "@mMainThread before startContentMainRunner");
            ChildProcessService.this.mDelegate.startContentMainRunner();
            Log.d("ChildProcessService", "@mMainThread after startContentMainRunner");
            ChildProcessService.this.mDelegate.ExitChildProcess();
            Log.d("ChildProcessService", "@mMainThread after ExitChildProcess");
          }
          AppMethodBeat.o(53763);
          return;
          for (;;)
          {
            if (??? == null) {
              break label715;
            }
            arrayOfString[i] = ???;
            break;
            ??? = null;
          }
        }
      }
    }, "ChildProcessMain");
    this.mMainThread.start();
    Log.i("ChildProcessService", "onCreate end; @pid:" + Process.myPid(), new Object[0]);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("ChildProcessService", "Destroying ChildProcessService pid=%d", new Object[] { Integer.valueOf(Process.myPid()) });
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