package com.tencent.xweb.pinus.sdk.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xwalk.core.Log;

public abstract class Linker
{
  protected static final boolean DEBUG = true;
  public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
  protected static final String LINKER_JNI_LIBRARY = "xweb_linker";
  private static final String TAG = "Linker";
  protected static final Object sLock;
  private static Linker sSingleton;
  private byte _hellAccFlag_;
  protected long mBaseLoadAddress = -1L;
  protected boolean mInBrowserProcess = true;
  protected LibInfo mLibInfo;
  protected int mState = 0;
  protected boolean mWaitForSharedRelros;
  
  static
  {
    if (!Linker.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      sLock = new Object();
      return;
    }
  }
  
  public static Linker getInstance()
  {
    synchronized (sLock)
    {
      if (sSingleton == null) {
        sSingleton = new LegacyLinker();
      }
      Linker localLinker = sSingleton;
      return localLinker;
    }
  }
  
  protected static long getRandomBaseLoadAddress()
  {
    long l = nativeGetRandomBaseLoadAddress();
    Log.i("Linker", String.format("Random native base load address: 0x%x", new Object[] { Long.valueOf(l) }));
    return l;
  }
  
  private void loadLinkerJniLibraryLocked()
  {
    assert (this.mState == 0);
    Log.i("Linker", String.format("Loading lib%s.so", new Object[] { "xweb_linker" }));
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("xweb_linker");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/xweb/pinus/sdk/library_loader/Linker", "loadLinkerJniLibraryLocked", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/xweb/pinus/sdk/library_loader/Linker", "loadLinkerJniLibraryLocked", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private static native long nativeGetRandomBaseLoadAddress();
  
  private void setupBaseLoadAddressLocked()
  {
    if (this.mBaseLoadAddress == -1L)
    {
      this.mBaseLoadAddress = getRandomBaseLoadAddress();
      if (this.mBaseLoadAddress == 0L)
      {
        Log.w("Linker", "Disabling shared RELROs due address space pressure");
        this.mWaitForSharedRelros = false;
      }
    }
  }
  
  public abstract int createMemroyFile(String paramString);
  
  public final void disableSharedRelros()
  {
    Log.i("Linker", "disableSharedRelros() called");
    synchronized (sLock)
    {
      this.mInBrowserProcess = false;
      ensureInitializedLocked();
      if ((!$assertionsDisabled) && (this.mState != 1)) {
        throw new AssertionError();
      }
    }
    this.mWaitForSharedRelros = false;
  }
  
  protected final void ensureInitializedLocked()
  {
    if (this.mState != 0) {
      return;
    }
    loadLinkerJniLibraryLocked();
    if (this.mInBrowserProcess) {
      setupBaseLoadAddressLocked();
    }
    this.mState = 1;
  }
  
  public final long getBaseLoadAddress()
  {
    synchronized (sLock)
    {
      ensureInitializedLocked();
      setupBaseLoadAddressLocked();
      Log.i("Linker", String.format("getBaseLoadAddress() returns 0x%x", new Object[] { Long.valueOf(this.mBaseLoadAddress) }));
      long l = this.mBaseLoadAddress;
      return l;
    }
  }
  
  public final Bundle getSharedRelros()
  {
    synchronized (sLock)
    {
      if (this.mState != 2) {
        break label73;
      }
      if ((!$assertionsDisabled) && (!this.mInBrowserProcess)) {
        throw new AssertionError();
      }
    }
    Bundle localBundle = this.mLibInfo.toBundle();
    Log.i("Linker", String.format("getSharedRelros() = %s", new Object[] { localBundle.toString() }));
    return localBundle;
    label73:
    Log.i("Linker", "getSharedRelros() = null");
    return null;
  }
  
  public final void initServiceProcess(long paramLong)
  {
    Log.i("Linker", String.format("initServiceProcess(0x%x) called", new Object[] { Long.valueOf(paramLong) }));
    synchronized (sLock)
    {
      ensureInitializedLocked();
      if ((!$assertionsDisabled) && (this.mState != 1)) {
        throw new AssertionError();
      }
    }
    this.mInBrowserProcess = false;
    this.mWaitForSharedRelros = true;
    this.mBaseLoadAddress = paramLong;
  }
  
  public final void loadLibrary(String paramString, boolean paramBoolean)
  {
    Log.i("Linker", String.format("loadLibrary: %s", new Object[] { paramString }));
    assert (!paramString.equals("xweb_linker"));
    synchronized (sLock)
    {
      loadLibraryImplLocked(paramString, paramBoolean);
      return;
    }
  }
  
  public final void loadLibraryByFd(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Log.i("Linker", String.format("loadLibrary: %s, fd: %d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    assert (!paramString.equals("xweb_linker"));
    synchronized (sLock)
    {
      loadLibraryByFdImplLocked(paramString, paramBoolean1, paramInt, paramBoolean2);
      return;
    }
  }
  
  abstract void loadLibraryByFdImplLocked(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  abstract void loadLibraryImplLocked(String paramString, boolean paramBoolean);
  
  /* Error */
  public final void provideSharedRelros(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 26
    //   2: ldc 214
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 90	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokestatic 96	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: getstatic 55	com/tencent/xweb/pinus/sdk/library_loader/Linker:sLock	Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: getstatic 50	com/tencent/xweb/pinus/sdk/library_loader/Linker:$assertionsDisabled	Z
    //   27: ifne +32 -> 59
    //   30: aload_0
    //   31: getfield 64	com/tencent/xweb/pinus/sdk/library_loader/Linker:mState	I
    //   34: iconst_3
    //   35: if_icmpeq +11 -> 46
    //   38: aload_0
    //   39: getfield 64	com/tencent/xweb/pinus/sdk/library_loader/Linker:mState	I
    //   42: iconst_2
    //   43: if_icmpne +16 -> 59
    //   46: new 101	java/lang/AssertionError
    //   49: dup
    //   50: invokespecial 102	java/lang/AssertionError:<init>	()V
    //   53: athrow
    //   54: astore_1
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: aload_0
    //   60: aload_1
    //   61: invokestatic 218	com/tencent/xweb/pinus/sdk/library_loader/Linker$LibInfo:fromBundle	(Landroid/os/Bundle;)Lcom/tencent/xweb/pinus/sdk/library_loader/Linker$LibInfo;
    //   64: putfield 171	com/tencent/xweb/pinus/sdk/library_loader/Linker:mLibInfo	Lcom/tencent/xweb/pinus/sdk/library_loader/Linker$LibInfo;
    //   67: getstatic 55	com/tencent/xweb/pinus/sdk/library_loader/Linker:sLock	Ljava/lang/Object;
    //   70: invokevirtual 221	java/lang/Object:notifyAll	()V
    //   73: aload_2
    //   74: monitorexit
    //   75: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	Linker
    //   0	76	1	paramBundle	Bundle
    //   21	53	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	46	54	finally
    //   46	54	54	finally
    //   59	75	54	finally
  }
  
  void setApkFilePath(String paramString) {}
  
  protected final void waitForSharedRelrosLocked()
  {
    Log.i("Linker", "waitForSharedRelros() called");
    long l = SystemClock.uptimeMillis();
    while (this.mLibInfo == null) {
      try
      {
        sLock.wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    Log.i("Linker", String.format("Time to wait for shared RELRO: %d ms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) }));
  }
  
  protected static class LibInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LibInfo> CREATOR;
    private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
    public String mLibFilePath;
    public long mLoadAddress;
    public long mLoadSize;
    public int mRelroFd;
    public long mRelroSize;
    public long mRelroStart;
    
    static
    {
      AppMethodBeat.i(213539);
      CREATOR = new Parcelable.Creator()
      {
        public Linker.LibInfo createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(213519);
          paramAnonymousParcel = new Linker.LibInfo(paramAnonymousParcel);
          AppMethodBeat.o(213519);
          return paramAnonymousParcel;
        }
        
        public Linker.LibInfo[] newArray(int paramAnonymousInt)
        {
          return new Linker.LibInfo[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(213539);
    }
    
    LibInfo()
    {
      this.mRelroFd = -1;
    }
    
    LibInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(213521);
      this.mRelroFd = -1;
      this.mLibFilePath = paramParcel.readString();
      this.mLoadAddress = paramParcel.readLong();
      this.mLoadSize = paramParcel.readLong();
      this.mRelroStart = paramParcel.readLong();
      this.mRelroSize = paramParcel.readLong();
      if (paramParcel.readInt() != 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramParcel = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
        if (paramParcel != null) {
          this.mRelroFd = paramParcel.detachFd();
        }
        AppMethodBeat.o(213521);
        return;
      }
      this.mRelroFd = -1;
      AppMethodBeat.o(213521);
    }
    
    public static void closeQuietly(Closeable paramCloseable)
    {
      AppMethodBeat.i(213526);
      if (paramCloseable == null)
      {
        AppMethodBeat.o(213526);
        return;
      }
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(213526);
        return;
      }
      catch (IOException paramCloseable)
      {
        AppMethodBeat.o(213526);
      }
    }
    
    public static LibInfo fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(213532);
      paramBundle = (LibInfo)paramBundle.getParcelable("libinfo");
      AppMethodBeat.o(213532);
      return paramBundle;
    }
    
    public void close()
    {
      AppMethodBeat.i(213547);
      if (this.mRelroFd >= 0)
      {
        closeQuietly(ParcelFileDescriptor.adoptFd(this.mRelroFd));
        this.mRelroFd = -1;
      }
      AppMethodBeat.o(213547);
    }
    
    public int describeContents()
    {
      return 1;
    }
    
    public Bundle toBundle()
    {
      AppMethodBeat.i(213555);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("libinfo", this);
      AppMethodBeat.o(213555);
      return localBundle;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = 0;
      AppMethodBeat.i(213565);
      paramParcel.writeString(this.mLibFilePath);
      paramParcel.writeLong(this.mLoadAddress);
      paramParcel.writeLong(this.mLoadSize);
      paramParcel.writeLong(this.mRelroStart);
      paramParcel.writeLong(this.mRelroSize);
      if (this.mRelroFd >= 0) {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
      if (this.mRelroFd >= 0) {
        try
        {
          ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.fromFd(this.mRelroFd);
          localParcelFileDescriptor.writeToParcel(paramParcel, 0);
          localParcelFileDescriptor.close();
          AppMethodBeat.o(213565);
          return;
        }
        catch (IOException paramParcel)
        {
          Log.e("Linker", "Can't write LibInfo file descriptor to parcel", paramParcel);
        }
      }
      AppMethodBeat.o(213565);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  protected static @interface State
  {
    public static final int DONE = 3;
    public static final int DONE_PROVIDE_RELRO = 2;
    public static final int INITIALIZED = 1;
    public static final int UNINITIALIZED = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.library_loader.Linker
 * JD-Core Version:    0.7.0.1
 */