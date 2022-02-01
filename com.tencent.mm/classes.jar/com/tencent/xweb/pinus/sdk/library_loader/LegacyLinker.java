package com.tencent.xweb.pinus.sdk.library_loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class LegacyLinker
  extends Linker
{
  private static final String TAG = "LegacyLinker";
  
  static
  {
    AppMethodBeat.i(213550);
    if (!LegacyLinker.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(213550);
      return;
    }
  }
  
  private static native boolean nativeAddZipArchivePath(String paramString);
  
  private static native int nativeCreateMemoryFile(String paramString);
  
  private static native boolean nativeCreateSharedRelro(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native boolean nativeLoadLibrary(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native boolean nativeLoadLibraryByFd(String paramString, long paramLong, int paramInt, boolean paramBoolean);
  
  private static native boolean nativeUseSharedRelro(String paramString, Linker.LibInfo paramLibInfo);
  
  private static void useSharedRelrosLocked(Linker.LibInfo paramLibInfo)
  {
    AppMethodBeat.i(213509);
    String str = paramLibInfo.mLibFilePath;
    if (!nativeUseSharedRelro(str, paramLibInfo))
    {
      Log.w("LegacyLinker", String.format("Could not use shared RELRO section for %s", new Object[] { str }));
      AppMethodBeat.o(213509);
      return;
    }
    Log.i("LegacyLinker", String.format("Using shared RELRO section for %s", new Object[] { str }));
    AppMethodBeat.o(213509);
  }
  
  public int createMemroyFile(String paramString)
  {
    AppMethodBeat.i(213588);
    ensureInitializedLocked();
    int i = nativeCreateMemoryFile(paramString);
    AppMethodBeat.o(213588);
    return i;
  }
  
  void loadLibraryByFdImplLocked(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(213581);
    ensureInitializedLocked();
    if ((!$assertionsDisabled) && (this.mState != 1))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(213581);
      throw paramString;
    }
    if (paramBoolean1) {}
    for (long l = this.mBaseLoadAddress; !nativeLoadLibraryByFd(paramString, l, paramInt, paramBoolean2); l = 0L)
    {
      paramString = "Unable to load library: ".concat(String.valueOf(paramString));
      Log.e("LegacyLinker", paramString);
      paramString = new UnsatisfiedLinkError(paramString);
      AppMethodBeat.o(213581);
      throw paramString;
    }
    this.mState = 3;
    AppMethodBeat.o(213581);
  }
  
  void loadLibraryImplLocked(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213572);
    ensureInitializedLocked();
    if ((!$assertionsDisabled) && (this.mState != 1))
    {
      paramString = new AssertionError();
      AppMethodBeat.o(213572);
      throw paramString;
    }
    boolean bool = this.mInBrowserProcess;
    if (paramBoolean) {}
    Linker.LibInfo localLibInfo;
    for (long l = this.mBaseLoadAddress;; l = 0L)
    {
      localLibInfo = new Linker.LibInfo();
      if (nativeLoadLibrary(paramString, l, localLibInfo)) {
        break;
      }
      paramString = "Unable to load library: ".concat(String.valueOf(paramString));
      Log.e("LegacyLinker", paramString);
      paramString = new UnsatisfiedLinkError(paramString);
      AppMethodBeat.o(213572);
      throw paramString;
    }
    localLibInfo.mLibFilePath = paramString;
    if (bool)
    {
      if (!nativeCreateSharedRelro(paramString, this.mBaseLoadAddress, localLibInfo))
      {
        Log.w("LegacyLinker", String.format("Could not create shared RELRO for %s at %x", new Object[] { paramString, Long.valueOf(this.mBaseLoadAddress) }));
        localLibInfo.mRelroFd = -1;
      }
      for (;;)
      {
        this.mLibInfo = localLibInfo;
        useSharedRelrosLocked(this.mLibInfo);
        this.mState = 2;
        AppMethodBeat.o(213572);
        return;
        Log.i("LegacyLinker", String.format("Created shared RELRO for %s at %x: %s", new Object[] { paramString, Long.valueOf(this.mBaseLoadAddress), localLibInfo.toString() }));
      }
    }
    if (this.mWaitForSharedRelros)
    {
      waitForSharedRelrosLocked();
      if ((!$assertionsDisabled) && (!paramString.equals(this.mLibInfo.mLibFilePath)))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(213572);
        throw paramString;
      }
      useSharedRelrosLocked(this.mLibInfo);
      this.mLibInfo.close();
      this.mLibInfo = null;
    }
    this.mState = 3;
    AppMethodBeat.o(213572);
  }
  
  void setApkFilePath(String paramString)
  {
    AppMethodBeat.i(213559);
    synchronized (sLock)
    {
      ensureInitializedLocked();
      nativeAddZipArchivePath(paramString);
      AppMethodBeat.o(213559);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.library_loader.LegacyLinker
 * JD-Core Version:    0.7.0.1
 */