package com.tencent.smtt.library_loader;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Iterator;
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
  protected final Object mLock = new Object();
  
  public static final Linker getInstance()
  {
    synchronized (sSingletonLock)
    {
      if (sSingleton == null) {
        sSingleton = LegacyLinker.create();
      }
      Linker localLinker = sSingleton;
      return localLinker;
    }
  }
  
  protected static void loadLinkerJniLibrary()
  {
    System.loadLibrary("chromium_android_linker");
  }
  
  private static native long nativeGetRandomBaseLoadAddress();
  
  protected void closeLibInfoMap(HashMap<String, Linker.LibInfo> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext()) {
      ((Linker.LibInfo)((Map.Entry)paramHashMap.next()).getValue()).close();
    }
  }
  
  protected Bundle createBundleFromLibInfoMap(HashMap<String, Linker.LibInfo> paramHashMap)
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
  
  protected HashMap<String, Linker.LibInfo> createLibInfoMapFromBundle(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Linker.LibInfo)paramBundle.getParcelable(str));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.library_loader.Linker
 * JD-Core Version:    0.7.0.1
 */