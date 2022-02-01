package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Linker
{
  protected static final int ADDRESS_SPACE_RESERVATION = 201326592;
  protected static final int BREAKPAD_GUARD_REGION_BYTES = 16777216;
  public static final int BROWSER_SHARED_RELRO_CONFIG = 1;
  public static final int BROWSER_SHARED_RELRO_CONFIG_ALWAYS = 2;
  public static final int BROWSER_SHARED_RELRO_CONFIG_LOW_RAM_ONLY = 1;
  public static final int BROWSER_SHARED_RELRO_CONFIG_NEVER = 0;
  protected static final boolean DEBUG = false;
  public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
  private static final String LINKER_JNI_LIBRARY = "chromium_android_linker";
  public static final int MEMORY_DEVICE_CONFIG_INIT = 0;
  public static final int MEMORY_DEVICE_CONFIG_LOW = 1;
  public static final int MEMORY_DEVICE_CONFIG_NORMAL = 2;
  private static final String TAG = "Linker";
  private static Linker sSingleton = null;
  private static Object sSingletonLock = new Object();
  private byte _hellAccFlag_;
  protected final Object mLock = new Object();
  
  public static final Linker getInstance()
  {
    synchronized (sSingletonLock)
    {
      if (sSingleton == null)
      {
        sSingleton = LegacyLinker.create();
        new StringBuilder("Using linker: ").append(sSingleton.getClass().getName());
      }
      Linker localLinker = sSingleton;
      return localLinker;
    }
  }
  
  protected static void loadLinkerJniLibrary()
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("chromium_android_linker");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/smtt/library_loader/Linker", "loadLinkerJniLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/smtt/library_loader/Linker", "loadLinkerJniLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  private static native long nativeGetRandomBaseLoadAddress();
  
  protected void closeLibInfoMap(HashMap<String, LibInfo> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext()) {
      ((LibInfo)((Map.Entry)paramHashMap.next()).getValue()).close();
    }
  }
  
  protected Bundle createBundleFromLibInfoMap(HashMap<String, LibInfo> paramHashMap)
  {
    Bundle localBundle = new Bundle(paramHashMap.size());
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localBundle.putParcelable((String)localEntry.getKey(), (Parcelable)localEntry.getValue());
    }
    return localBundle;
  }
  
  protected HashMap<String, LibInfo> createLibInfoMapFromBundle(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (LibInfo)paramBundle.getParcelable(str));
    }
    return localHashMap;
  }
  
  public abstract void disableSharedRelros();
  
  public abstract void finishLibraryLoad();
  
  public abstract long getBaseLoadAddress();
  
  protected long getRandomBaseLoadAddress()
  {
    return nativeGetRandomBaseLoadAddress();
  }
  
  public abstract Bundle getSharedRelros();
  
  public abstract void initServiceProcess(long paramLong);
  
  public abstract boolean isUsingBrowserSharedRelros();
  
  public void loadLibrary(String paramString1, String paramString2)
  {
    loadLibraryImpl(paramString1, paramString2, true);
  }
  
  public abstract String loadLibraryByFd(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong, String paramString, int paramInt);
  
  abstract void loadLibraryImpl(String paramString1, String paramString2, boolean paramBoolean);
  
  public void loadLibraryNoFixedAddress(String paramString1, String paramString2)
  {
    loadLibraryImpl(paramString1, paramString2, false);
  }
  
  public abstract void prepareLibraryLoad();
  
  public abstract void useSharedRelros(Bundle paramBundle);
  
  public static class LibInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<LibInfo> CREATOR;
    public long mLoadAddress;
    public long mLoadSize;
    public int mRelroFd;
    public long mRelroSize;
    public long mRelroStart;
    
    static
    {
      AppMethodBeat.i(53825);
      CREATOR = new Parcelable.Creator()
      {
        public final Linker.LibInfo createFromParcel(Parcel paramAnonymousParcel)
        {
          AppMethodBeat.i(53826);
          paramAnonymousParcel = new Linker.LibInfo(paramAnonymousParcel);
          AppMethodBeat.o(53826);
          return paramAnonymousParcel;
        }
        
        public final Linker.LibInfo[] newArray(int paramAnonymousInt)
        {
          return new Linker.LibInfo[paramAnonymousInt];
        }
      };
      AppMethodBeat.o(53825);
    }
    
    public LibInfo()
    {
      this.mLoadAddress = 0L;
      this.mLoadSize = 0L;
      this.mRelroStart = 0L;
      this.mRelroSize = 0L;
      this.mRelroFd = -1;
    }
    
    public LibInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(53822);
      this.mLoadAddress = paramParcel.readLong();
      this.mLoadSize = paramParcel.readLong();
      this.mRelroStart = paramParcel.readLong();
      this.mRelroSize = paramParcel.readLong();
      paramParcel = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
      if (paramParcel == null) {}
      for (int i = -1;; i = paramParcel.detachFd())
      {
        this.mRelroFd = i;
        AppMethodBeat.o(53822);
        return;
      }
    }
    
    public void close()
    {
      AppMethodBeat.i(53821);
      if (this.mRelroFd >= 0) {}
      try
      {
        ParcelFileDescriptor.adoptFd(this.mRelroFd).close();
        label22:
        this.mRelroFd = -1;
        AppMethodBeat.o(53821);
        return;
      }
      catch (IOException localIOException)
      {
        break label22;
      }
    }
    
    public int describeContents()
    {
      return 1;
    }
    
    public String toString()
    {
      AppMethodBeat.i(53824);
      String str = String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", new Object[] { Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd) });
      AppMethodBeat.o(53824);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(53823);
      if (this.mRelroFd >= 0)
      {
        paramParcel.writeLong(this.mLoadAddress);
        paramParcel.writeLong(this.mLoadSize);
        paramParcel.writeLong(this.mRelroStart);
        paramParcel.writeLong(this.mRelroSize);
        try
        {
          ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.fromFd(this.mRelroFd);
          localParcelFileDescriptor.writeToParcel(paramParcel, 0);
          localParcelFileDescriptor.close();
          AppMethodBeat.o(53823);
          return;
        }
        catch (IOException paramParcel) {}
      }
      AppMethodBeat.o(53823);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.library_loader.Linker
 * JD-Core Version:    0.7.0.1
 */