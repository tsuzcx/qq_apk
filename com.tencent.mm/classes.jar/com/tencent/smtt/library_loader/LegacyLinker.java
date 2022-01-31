package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sandbox.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class LegacyLinker
  extends Linker
{
  static final int BUFFER_SIZE = 1024;
  private static final String TAG = "LegacyLinker";
  static ArrayList<byte[]> buffered_read_data;
  private long mBaseLoadAddress = -1L;
  private boolean mBrowserUsesSharedRelro = false;
  private long mCurrentLoadAddress = -1L;
  private boolean mInBrowserProcess = true;
  private boolean mInitialized = false;
  private HashMap<String, Linker.LibInfo> mLoadedLibraries = null;
  private boolean mPrepareLibraryLoadCalled = false;
  private Bundle mSharedRelros = null;
  private boolean mWaitForSharedRelros = false;
  
  static
  {
    AppMethodBeat.i(138974);
    if (!LegacyLinker.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      buffered_read_data = new ArrayList();
      AppMethodBeat.o(138974);
      return;
    }
  }
  
  static Linker create()
  {
    AppMethodBeat.i(138957);
    LegacyLinker localLegacyLinker = new LegacyLinker();
    AppMethodBeat.o(138957);
    return localLegacyLinker;
  }
  
  private void dumpBundle(Bundle paramBundle) {}
  
  private void ensureInitializedLocked()
  {
    AppMethodBeat.i(138958);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(138958);
      throw localAssertionError;
    }
    if (this.mInitialized)
    {
      AppMethodBeat.o(138958);
      return;
    }
    loadLinkerJniLibrary();
    this.mInitialized = true;
    AppMethodBeat.o(138958);
  }
  
  private static native boolean nativeCreateSharedRelro(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native boolean nativeLoadLibrary(String paramString, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native String nativeLoadLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong, String paramString, int paramInt);
  
  private static native boolean nativeLoadLibraryInZipFile(String paramString1, String paramString2, long paramLong, Linker.LibInfo paramLibInfo);
  
  private static native void nativeRunCallbackOnUiThread(long paramLong);
  
  private static native boolean nativeUseSharedRelro(String paramString, Linker.LibInfo paramLibInfo);
  
  public static void postCallbackOnMainThread(long paramLong)
  {
    AppMethodBeat.i(138970);
    ThreadUtils.postOnUiThread(new LegacyLinker.1(paramLong));
    AppMethodBeat.o(138970);
  }
  
  public static byte[] readLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138972);
    new StringBuilder(" [").append(Thread.currentThread().getStackTrace()[2].getMethodName()).append("] pfd: ").append(paramParcelFileDescriptor).append(", size0: ").append(paramInt2).append(", start_offset: ").append(paramInt1).append(", append: ").append(paramBoolean);
    FileInputStream localFileInputStream = new FileInputStream(paramParcelFileDescriptor.getFileDescriptor());
    paramParcelFileDescriptor = new ByteArrayOutputStream();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i4 = buffered_read_data.size();
    int i = 0;
    int i1 = 0;
    for (;;)
    {
      if (i < i4) {
        try
        {
          i2 = ((byte[])buffered_read_data.get(i)).length;
          i += 1;
          i1 += i2;
        }
        catch (Throwable localThrowable1) {}
      }
    }
    if (i1 - paramInt1 > 0) {}
    for (int i2 = i1 - paramInt1;; i2 = 0)
    {
      i = n;
      int i3;
      if (i4 > 0)
      {
        n = i4 - 1;
        i3 = 0;
        k = j;
        i = m;
        if (n >= 0) {
          k = m;
        }
      }
      for (;;)
      {
        try
        {
          arrayOfByte1 = (byte[])buffered_read_data.get(n);
          i = m;
          if (paramBoolean)
          {
            k = m;
            i = m + arrayOfByte1.length;
            k = i;
            paramParcelFileDescriptor.write(arrayOfByte1);
          }
          k = i;
          m = arrayOfByte1.length;
          i3 += m;
          if ((paramInt1 <= 0) || (i3 < i2)) {
            continue;
          }
          k = j + (i1 - paramInt1);
          j = n;
        }
        catch (Throwable localThrowable2)
        {
          byte[] arrayOfByte1;
          long l;
          m = j;
          j = -1;
          i = k;
          k = m;
          continue;
          if ((i4 <= 0) || (j < 0)) {
            continue;
          }
          if (paramInt2 >= k) {
            continue;
          }
          paramInt1 = paramInt2;
          try
          {
            arrayOfByte2 = (byte[])buffered_read_data.get(j);
            paramParcelFileDescriptor.write(arrayOfByte2, arrayOfByte2.length - k, paramInt1);
            paramInt1 += i;
            j += 1;
            if (j >= i4) {}
          }
          catch (Throwable localThrowable4)
          {
            paramInt1 = i;
          }
          try
          {
            arrayOfByte2 = (byte[])buffered_read_data.get(j);
            paramParcelFileDescriptor.write(arrayOfByte2);
            i = arrayOfByte2.length;
            paramInt1 += i;
          }
          catch (Throwable localThrowable5) {}
          paramInt1 = k;
          continue;
          continue;
          i = 1024;
          continue;
          i = 1024;
          continue;
          paramInt1 = i;
          continue;
        }
        if (paramInt1 <= 0) {
          continue;
        }
        if (paramInt1 - i1 <= 0) {
          continue;
        }
        l = paramInt1 - i1;
        try
        {
          localFileInputStream.skip(l);
          paramInt1 = i;
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            byte[] arrayOfByte2;
            localFileInputStream.close();
          }
          catch (IOException localIOException1)
          {
            try
            {
              paramParcelFileDescriptor.close();
              paramParcelFileDescriptor = paramParcelFileDescriptor.toByteArray();
              buffered_read_data.add(paramParcelFileDescriptor);
              AppMethodBeat.o(138972);
              return paramParcelFileDescriptor;
              localIOException1 = localIOException1;
              continue;
            }
            catch (IOException localIOException2)
            {
              continue;
            }
          }
          continue;
          continue;
          paramInt1 = i;
          continue;
        }
        arrayOfByte1 = new byte[1024];
        if (paramInt2 - paramInt1 >= 1024) {
          continue;
        }
        i = paramInt2 - paramInt1;
        if (i <= 0) {
          continue;
        }
        i = localFileInputStream.read(arrayOfByte1, 0, i);
        if (i <= 0) {
          continue;
        }
        paramInt1 += i;
        paramParcelFileDescriptor.write(arrayOfByte1, 0, i);
        if (paramInt2 - paramInt1 >= 1024) {
          continue;
        }
        i = paramInt2 - paramInt1;
        continue;
        k = i;
        m = arrayOfByte1.length;
        j -= m;
        n -= 1;
        m = i;
        break;
        j = -1;
      }
    }
  }
  
  private void setupBaseLoadAddressLocked()
  {
    AppMethodBeat.i(138967);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(138967);
      throw localAssertionError;
    }
    if (this.mBaseLoadAddress == -1L)
    {
      this.mBaseLoadAddress = getRandomBaseLoadAddress();
      this.mCurrentLoadAddress = this.mBaseLoadAddress;
      if (this.mBaseLoadAddress == 0L)
      {
        this.mBrowserUsesSharedRelro = false;
        this.mWaitForSharedRelros = false;
      }
    }
    AppMethodBeat.o(138967);
  }
  
  private void useSharedRelrosLocked(Bundle paramBundle)
  {
    AppMethodBeat.i(138968);
    if ((!$assertionsDisabled) && (!Thread.holdsLock(this.mLock)))
    {
      paramBundle = new AssertionError();
      AppMethodBeat.o(138968);
      throw paramBundle;
    }
    if (paramBundle == null)
    {
      AppMethodBeat.o(138968);
      return;
    }
    if (this.mLoadedLibraries == null)
    {
      AppMethodBeat.o(138968);
      return;
    }
    paramBundle = createLibInfoMapFromBundle(paramBundle);
    Iterator localIterator = paramBundle.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      nativeUseSharedRelro((String)localEntry.getKey(), (Linker.LibInfo)localEntry.getValue());
    }
    if (!this.mInBrowserProcess) {
      closeLibInfoMap(paramBundle);
    }
    AppMethodBeat.o(138968);
  }
  
  public void disableSharedRelros()
  {
    AppMethodBeat.i(138964);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mInBrowserProcess = false;
      this.mWaitForSharedRelros = false;
      this.mBrowserUsesSharedRelro = false;
      AppMethodBeat.o(138964);
      return;
    }
  }
  
  public void finishLibraryLoad()
  {
    AppMethodBeat.i(138961);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if (this.mLoadedLibraries == null) {
        break label154;
      }
      if (this.mInBrowserProcess)
      {
        this.mSharedRelros = createBundleFromLibInfoMap(this.mLoadedLibraries);
        if (this.mBrowserUsesSharedRelro) {
          useSharedRelrosLocked(this.mSharedRelros);
        }
      }
      if (!this.mWaitForSharedRelros) {
        break label154;
      }
      if ((!$assertionsDisabled) && (this.mInBrowserProcess))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(138961);
        throw localAssertionError;
      }
    }
    for (;;)
    {
      Bundle localBundle = this.mSharedRelros;
      if (localBundle != null) {
        break;
      }
      try
      {
        this.mLock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
      }
    }
    useSharedRelrosLocked(this.mSharedRelros);
    this.mSharedRelros.clear();
    this.mSharedRelros = null;
    label154:
    AppMethodBeat.o(138961);
  }
  
  public long getBaseLoadAddress()
  {
    AppMethodBeat.i(138966);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if (!this.mInBrowserProcess)
      {
        AppMethodBeat.o(138966);
        return 0L;
      }
      setupBaseLoadAddressLocked();
      long l = this.mBaseLoadAddress;
      AppMethodBeat.o(138966);
      return l;
    }
  }
  
  public Bundle getSharedRelros()
  {
    synchronized (this.mLock)
    {
      if (!this.mInBrowserProcess) {
        return null;
      }
      Bundle localBundle = this.mSharedRelros;
      return localBundle;
    }
  }
  
  public void initServiceProcess(long paramLong)
  {
    AppMethodBeat.i(138965);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mInBrowserProcess = false;
      this.mBrowserUsesSharedRelro = false;
      this.mWaitForSharedRelros = true;
      this.mBaseLoadAddress = paramLong;
      this.mCurrentLoadAddress = paramLong;
      AppMethodBeat.o(138965);
      return;
    }
  }
  
  public boolean isUsingBrowserSharedRelros()
  {
    AppMethodBeat.i(138959);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if ((this.mInBrowserProcess) && (this.mBrowserUsesSharedRelro))
      {
        bool = true;
        AppMethodBeat.o(138959);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public void loadLibrary(String paramString1, String paramString2)
  {
    AppMethodBeat.i(138963);
    super.loadLibrary(paramString1, paramString2);
    AppMethodBeat.o(138963);
  }
  
  public String loadLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(138971);
    paramParcelFileDescriptor = nativeLoadLibraryByFd(paramParcelFileDescriptor, paramLong, paramString, paramInt);
    AppMethodBeat.o(138971);
    return paramParcelFileDescriptor;
  }
  
  void loadLibraryImpl(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(138969);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      if ((!$assertionsDisabled) && (!this.mPrepareLibraryLoadCalled))
      {
        paramString1 = new AssertionError();
        AppMethodBeat.o(138969);
        throw paramString1;
      }
    }
    if (this.mLoadedLibraries == null) {
      this.mLoadedLibraries = new HashMap();
    }
    if (this.mLoadedLibraries.containsKey(paramString2))
    {
      AppMethodBeat.o(138969);
      return;
    }
    Linker.LibInfo localLibInfo = new Linker.LibInfo();
    long l1;
    String str;
    if ((paramBoolean) && (((this.mInBrowserProcess) && (this.mBrowserUsesSharedRelro)) || (this.mWaitForSharedRelros)))
    {
      long l2 = this.mCurrentLoadAddress;
      l1 = l2;
      if (l2 > this.mBaseLoadAddress + 201326592L)
      {
        paramString1 = new UnsatisfiedLinkError("Load address outside reservation, for: ".concat(String.valueOf(paramString2)));
        AppMethodBeat.o(138969);
        throw paramString1;
      }
      if (paramString1 != null)
      {
        str = paramString1;
        if (!nativeLoadLibraryInZipFile(paramString1, paramString2, l1, localLibInfo))
        {
          paramString1 = new UnsatisfiedLinkError("Unable to load library: " + paramString2 + ", in: " + paramString1);
          AppMethodBeat.o(138969);
          throw paramString1;
        }
      }
      else
      {
        if (nativeLoadLibrary(paramString2, l1, localLibInfo)) {
          break label364;
        }
        paramString1 = new UnsatisfiedLinkError("Unable to load library: ".concat(String.valueOf(paramString2)));
        AppMethodBeat.o(138969);
        throw paramString1;
      }
    }
    for (;;)
    {
      if (this.mInBrowserProcess) {
        nativeCreateSharedRelro(str, this.mCurrentLoadAddress, localLibInfo);
      }
      if ((l1 != 0L) && (this.mCurrentLoadAddress != 0L)) {
        this.mCurrentLoadAddress = (localLibInfo.mLoadAddress + localLibInfo.mLoadSize + 16777216L);
      }
      this.mLoadedLibraries.put(str, localLibInfo);
      AppMethodBeat.o(138969);
      return;
      l1 = 0L;
      break;
      label364:
      str = paramString2;
    }
  }
  
  public void prepareLibraryLoad()
  {
    AppMethodBeat.i(138960);
    synchronized (this.mLock)
    {
      ensureInitializedLocked();
      this.mPrepareLibraryLoadCalled = true;
      if (this.mInBrowserProcess) {
        setupBaseLoadAddressLocked();
      }
      AppMethodBeat.o(138960);
      return;
    }
  }
  
  public void useSharedRelros(Bundle arg1)
  {
    AppMethodBeat.i(138962);
    Bundle localBundle = null;
    if (??? != null)
    {
      ???.setClassLoader(Linker.LibInfo.class.getClassLoader());
      localBundle = new Bundle(Linker.LibInfo.class.getClassLoader());
      Parcel localParcel = Parcel.obtain();
      ???.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      localBundle.readFromParcel(localParcel);
      localParcel.recycle();
    }
    synchronized (this.mLock)
    {
      this.mSharedRelros = localBundle;
      this.mLock.notifyAll();
      AppMethodBeat.o(138962);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.library_loader.LegacyLinker
 * JD-Core Version:    0.7.0.1
 */