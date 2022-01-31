package com.tencent.mmkv;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MMKV
  implements SharedPreferences, SharedPreferences.Editor
{
  private static final int ASHMEM_MODE = 8;
  private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
  public static final int MULTI_PROCESS_MODE = 2;
  public static final int SINGLE_PROCESS_MODE = 1;
  private static a gCallbackHandler;
  private static boolean gWantLogReDirecting;
  private static b[] index2LogLevel;
  private static EnumMap<b, Integer> logLevel2Index;
  private static final HashMap<String, Parcelable.Creator<?>> mCreators;
  private static EnumMap<c, Integer> recoverIndex;
  private static String rootDir;
  private long nativeHandle;
  
  static
  {
    AppMethodBeat.i(124036);
    EnumMap localEnumMap = new EnumMap(c.class);
    recoverIndex = localEnumMap;
    localEnumMap.put(c.AZV, Integer.valueOf(0));
    recoverIndex.put(c.AZW, Integer.valueOf(1));
    localEnumMap = new EnumMap(b.class);
    logLevel2Index = localEnumMap;
    localEnumMap.put(b.AZP, Integer.valueOf(0));
    logLevel2Index.put(b.AZQ, Integer.valueOf(1));
    logLevel2Index.put(b.AZR, Integer.valueOf(2));
    logLevel2Index.put(b.AZS, Integer.valueOf(3));
    logLevel2Index.put(b.AZT, Integer.valueOf(4));
    index2LogLevel = new b[] { b.AZP, b.AZQ, b.AZR, b.AZS, b.AZT };
    rootDir = null;
    mCreators = new HashMap();
    gWantLogReDirecting = false;
    AppMethodBeat.o(124036);
  }
  
  private MMKV(long paramLong)
  {
    this.nativeHandle = paramLong;
  }
  
  private native boolean containsKey(long paramLong, String paramString);
  
  private native long count(long paramLong);
  
  private static native long createNB(int paramInt);
  
  public static d createNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(124027);
    long l = createNB(paramInt);
    if (l <= 0L)
    {
      AppMethodBeat.o(124027);
      return null;
    }
    d locald = new d(l, paramInt);
    AppMethodBeat.o(124027);
    return locald;
  }
  
  private native boolean decodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native byte[] decodeBytes(long paramLong, String paramString);
  
  private native double decodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native float decodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native int decodeInt(long paramLong, String paramString, int paramInt);
  
  private native long decodeLong(long paramLong1, String paramString, long paramLong2);
  
  private native String decodeString(long paramLong, String paramString1, String paramString2);
  
  private native String[] decodeStringSet(long paramLong, String paramString);
  
  public static MMKV defaultMMKV()
  {
    AppMethodBeat.i(123972);
    if (rootDir == null)
    {
      localObject = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123972);
      throw ((Throwable)localObject);
    }
    Object localObject = new MMKV(getDefaultMMKV(1, null));
    AppMethodBeat.o(123972);
    return localObject;
  }
  
  public static MMKV defaultMMKV(int paramInt, String paramString)
  {
    AppMethodBeat.i(123973);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123973);
      throw paramString;
    }
    paramString = new MMKV(getDefaultMMKV(paramInt, paramString));
    AppMethodBeat.o(123973);
    return paramString;
  }
  
  private static native void destroyNB(long paramLong, int paramInt);
  
  public static void destroyNativeBuffer(d paramd)
  {
    AppMethodBeat.i(124028);
    destroyNB(paramd.AZY, paramd.size);
    AppMethodBeat.o(124028);
  }
  
  private native boolean encodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native boolean encodeBytes(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private native boolean encodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native boolean encodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native boolean encodeInt(long paramLong, String paramString, int paramInt);
  
  private native boolean encodeLong(long paramLong1, String paramString, long paramLong2);
  
  private native boolean encodeSet(long paramLong, String paramString, String[] paramArrayOfString);
  
  private native boolean encodeString(long paramLong, String paramString1, String paramString2);
  
  private static native long getDefaultMMKV(int paramInt, String paramString);
  
  private static native long getMMKVWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native long getMMKVWithID(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static native long getMMKVWithIDAndSize(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public static String getRootDir()
  {
    return rootDir;
  }
  
  public static String initialize(Context paramContext)
  {
    AppMethodBeat.i(123962);
    paramContext = initialize(paramContext.getFilesDir().getAbsolutePath() + "/mmkv", null);
    AppMethodBeat.o(123962);
    return paramContext;
  }
  
  public static String initialize(String paramString)
  {
    AppMethodBeat.i(123963);
    paramString = initialize(paramString, null);
    AppMethodBeat.o(123963);
    return paramString;
  }
  
  public static String initialize(String paramString, a parama)
  {
    AppMethodBeat.i(123964);
    if (parama != null) {
      "StaticCpp".equals("SharedCpp");
    }
    for (;;)
    {
      rootDir = paramString;
      jniInitialize(paramString);
      AppMethodBeat.o(123964);
      return paramString;
      if ("StaticCpp".equals("SharedCpp")) {
        System.loadLibrary("c++_shared");
      }
      System.loadLibrary("mmkv");
    }
  }
  
  public static native boolean isFileValid(String paramString);
  
  private static native void jniInitialize(String paramString);
  
  private static void mmkvLogImp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124034);
    if ((gCallbackHandler != null) && (gWantLogReDirecting))
    {
      gCallbackHandler.h(paramString1, paramInt2, paramString2, paramString3);
      AppMethodBeat.o(124034);
      return;
    }
    paramString1 = 1.AZN;
    index2LogLevel[paramInt1].ordinal();
    AppMethodBeat.o(124034);
  }
  
  public static MMKV mmkvWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(124026);
    paramString1 = new MMKV(getMMKVWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(124026);
    return paramString1;
  }
  
  public static MMKV mmkvWithAshmemID(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(123971);
    if (rootDir == null)
    {
      paramContext = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123971);
      throw paramContext;
    }
    Object localObject = MMKVContentProvider.aE(paramContext, Process.myPid());
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      simpleLog(b.AZS, "process name detect fail, try again later");
      AppMethodBeat.o(123971);
      return null;
    }
    if (((String)localObject).contains(":"))
    {
      localObject = MMKVContentProvider.iP(paramContext);
      if (localObject == null)
      {
        simpleLog(b.AZS, "MMKVContentProvider has invalid authority");
        AppMethodBeat.o(123971);
        return null;
      }
      simpleLog(b.AZQ, "getting parcelable mmkv in process, Uri = ".concat(String.valueOf(localObject)));
      Bundle localBundle = new Bundle();
      localBundle.putInt("KEY_SIZE", paramInt1);
      localBundle.putInt("KEY_MODE", paramInt2);
      if (paramString2 != null) {
        localBundle.putString("KEY_CRYPT", paramString2);
      }
      paramContext = paramContext.getContentResolver().call((Uri)localObject, "mmkvFromAshmemID", paramString1, localBundle);
      if (paramContext != null)
      {
        paramContext.setClassLoader(ParcelableMMKV.class.getClassLoader());
        paramContext = (ParcelableMMKV)paramContext.getParcelable("KEY");
        if (paramContext != null)
        {
          if ((paramContext.Baa >= 0) && (paramContext.Bab >= 0)) {}
          for (paramContext = mmkvWithAshmemFD(paramContext.AZZ, paramContext.Baa, paramContext.Bab, paramContext.Bac);; paramContext = null)
          {
            if (paramContext != null) {
              simpleLog(b.AZQ, paramContext.mmapID() + " fd = " + paramContext.ashmemFD() + ", meta fd = " + paramContext.ashmemMetaFD());
            }
            AppMethodBeat.o(123971);
            return paramContext;
          }
        }
      }
    }
    else
    {
      simpleLog(b.AZQ, "getting mmkv in main process");
      paramContext = new MMKV(getMMKVWithIDAndSize(paramString1, paramInt1, paramInt2 | 0x8, paramString2));
      AppMethodBeat.o(123971);
      return paramContext;
    }
    AppMethodBeat.o(123971);
    return null;
  }
  
  public static MMKV mmkvWithID(String paramString)
  {
    AppMethodBeat.i(123966);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123966);
      throw paramString;
    }
    paramString = new MMKV(getMMKVWithID(paramString, 1, null, null));
    AppMethodBeat.o(123966);
    return paramString;
  }
  
  public static MMKV mmkvWithID(String paramString, int paramInt)
  {
    AppMethodBeat.i(123967);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123967);
      throw paramString;
    }
    paramString = new MMKV(getMMKVWithID(paramString, paramInt, null, null));
    AppMethodBeat.o(123967);
    return paramString;
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(123968);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123968);
      throw paramString1;
    }
    paramString1 = new MMKV(getMMKVWithID(paramString1, paramInt, paramString2, null));
    AppMethodBeat.o(123968);
    return paramString1;
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123970);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123970);
      throw paramString1;
    }
    long l = getMMKVWithID(paramString1, paramInt, paramString2, paramString3);
    if (l == 0L)
    {
      AppMethodBeat.o(123970);
      return null;
    }
    paramString1 = new MMKV(l);
    AppMethodBeat.o(123970);
    return paramString1;
  }
  
  public static MMKV mmkvWithID(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123969);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(123969);
      throw paramString1;
    }
    long l = getMMKVWithID(paramString1, 1, null, paramString2);
    if (l == 0L)
    {
      AppMethodBeat.o(123969);
      return null;
    }
    paramString1 = new MMKV(l);
    AppMethodBeat.o(123969);
    return paramString1;
  }
  
  public static native void onExit();
  
  private static int onMMKVCRCCheckFail(String paramString)
  {
    AppMethodBeat.i(124032);
    c localc = c.AZV;
    if (gCallbackHandler != null) {
      localc = gCallbackHandler.apt(paramString);
    }
    simpleLog(b.AZQ, "Recover strategic for " + paramString + " is " + localc);
    int i = ((Integer)recoverIndex.get(localc)).intValue();
    AppMethodBeat.o(124032);
    return i;
  }
  
  private static int onMMKVFileLengthError(String paramString)
  {
    AppMethodBeat.i(124033);
    c localc = c.AZV;
    if (gCallbackHandler != null) {
      localc = gCallbackHandler.apu(paramString);
    }
    simpleLog(b.AZQ, "Recover strategic for " + paramString + " is " + localc);
    int i = ((Integer)recoverIndex.get(localc)).intValue();
    AppMethodBeat.o(124033);
    return i;
  }
  
  public static native int pageSize();
  
  public static void registerHandler(a parama)
  {
    AppMethodBeat.i(124030);
    gCallbackHandler = parama;
    setLogReDirecting(true);
    gWantLogReDirecting = true;
    AppMethodBeat.o(124030);
  }
  
  private native void removeValueForKey(long paramLong, String paramString);
  
  private static native void setLogLevel(int paramInt);
  
  public static void setLogLevel(b paramb)
  {
    int j = 1;
    AppMethodBeat.i(123965);
    int i = j;
    switch (1.AZN[paramb.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      setLogLevel(i);
      AppMethodBeat.o(123965);
      return;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  private static native void setLogReDirecting(boolean paramBoolean);
  
  private static void simpleLog(b paramb, String paramString)
  {
    AppMethodBeat.i(124035);
    Object localObject = Thread.currentThread().getStackTrace();
    localObject = localObject[(localObject.length - 1)];
    mmkvLogImp(((Integer)logLevel2Index.get(paramb)).intValue(), ((StackTraceElement)localObject).getFileName(), ((StackTraceElement)localObject).getLineNumber(), ((StackTraceElement)localObject).getMethodName(), paramString);
    AppMethodBeat.o(124035);
  }
  
  private native long totalSize(long paramLong);
  
  public static void unregisterHandler()
  {
    AppMethodBeat.i(124031);
    gCallbackHandler = null;
    setLogReDirecting(false);
    gWantLogReDirecting = false;
    AppMethodBeat.o(124031);
  }
  
  private native int valueSize(long paramLong, String paramString, boolean paramBoolean);
  
  private native int writeValueToNB(long paramLong1, String paramString, long paramLong2, int paramInt);
  
  public native String[] allKeys();
  
  public void apply() {}
  
  public native int ashmemFD();
  
  public native int ashmemMetaFD();
  
  public native void checkReSetCryptKey(String paramString);
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(124021);
    clearAll();
    AppMethodBeat.o(124021);
    return this;
  }
  
  public native void clearAll();
  
  public native void clearMemoryCache();
  
  public native void close();
  
  public boolean commit()
  {
    AppMethodBeat.i(124022);
    sync();
    AppMethodBeat.o(124022);
    return true;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(124023);
    boolean bool = containsKey(paramString);
    AppMethodBeat.o(124023);
    return bool;
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(124002);
    boolean bool = containsKey(this.nativeHandle, paramString);
    AppMethodBeat.o(124002);
    return bool;
  }
  
  public long count()
  {
    AppMethodBeat.i(124003);
    long l = count(this.nativeHandle);
    AppMethodBeat.o(124003);
    return l;
  }
  
  public native String cryptKey();
  
  public boolean decodeBool(String paramString)
  {
    AppMethodBeat.i(123975);
    boolean bool = decodeBool(this.nativeHandle, paramString, false);
    AppMethodBeat.o(123975);
    return bool;
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123976);
    paramBoolean = decodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(123976);
    return paramBoolean;
  }
  
  public byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(123996);
    paramString = decodeBytes(this.nativeHandle, paramString);
    AppMethodBeat.o(123996);
    return paramString;
  }
  
  public double decodeDouble(String paramString)
  {
    AppMethodBeat.i(123987);
    double d = decodeDouble(this.nativeHandle, paramString, 0.0D);
    AppMethodBeat.o(123987);
    return d;
  }
  
  public double decodeDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(123988);
    paramDouble = decodeDouble(this.nativeHandle, paramString, paramDouble);
    AppMethodBeat.o(123988);
    return paramDouble;
  }
  
  public float decodeFloat(String paramString)
  {
    AppMethodBeat.i(123984);
    float f = decodeFloat(this.nativeHandle, paramString, 0.0F);
    AppMethodBeat.o(123984);
    return f;
  }
  
  public float decodeFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(123985);
    paramFloat = decodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(123985);
    return paramFloat;
  }
  
  public int decodeInt(String paramString)
  {
    AppMethodBeat.i(123978);
    int i = decodeInt(this.nativeHandle, paramString, 0);
    AppMethodBeat.o(123978);
    return i;
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(123979);
    paramInt = decodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(123979);
    return paramInt;
  }
  
  public long decodeLong(String paramString)
  {
    AppMethodBeat.i(123981);
    long l = decodeLong(this.nativeHandle, paramString, 0L);
    AppMethodBeat.o(123981);
    return l;
  }
  
  public long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(123982);
    paramLong = decodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(123982);
    return paramLong;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(123998);
    paramString = decodeParcelable(paramString, paramClass, null);
    AppMethodBeat.o(123998);
    return paramString;
  }
  
  /* Error */
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass, T paramT)
  {
    // Byte code:
    //   0: ldc_w 563
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 563
    //   13: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_3
    //   17: areturn
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 116	com/tencent/mmkv/MMKV:nativeHandle	J
    //   23: aload_1
    //   24: invokespecial 529	com/tencent/mmkv/MMKV:decodeBytes	(JLjava/lang/String;)[B
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +11 -> 40
    //   32: ldc_w 563
    //   35: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_3
    //   39: areturn
    //   40: invokestatic 569	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   43: astore 5
    //   45: aload 5
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_1
    //   50: arraylength
    //   51: invokevirtual 573	android/os/Parcel:unmarshall	([BII)V
    //   54: aload 5
    //   56: iconst_0
    //   57: invokevirtual 576	android/os/Parcel:setDataPosition	(I)V
    //   60: aload_2
    //   61: invokevirtual 577	java/lang/Class:toString	()Ljava/lang/String;
    //   64: astore 7
    //   66: getstatic 106	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   69: astore 6
    //   71: aload 6
    //   73: monitorenter
    //   74: getstatic 106	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   77: aload 7
    //   79: invokevirtual 578	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 580	android/os/Parcelable$Creator
    //   85: astore 4
    //   87: aload 4
    //   89: astore_1
    //   90: aload 4
    //   92: ifnonnull +36 -> 128
    //   95: aload_2
    //   96: ldc_w 582
    //   99: invokevirtual 586	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   102: aconst_null
    //   103: invokevirtual 589	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 580	android/os/Parcelable$Creator
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_2
    //   113: ifnull +15 -> 128
    //   116: getstatic 106	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   119: aload 7
    //   121: aload_2
    //   122: invokevirtual 592	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_2
    //   127: astore_1
    //   128: aload 6
    //   130: monitorexit
    //   131: aload_1
    //   132: ifnull +64 -> 196
    //   135: aload_1
    //   136: aload 5
    //   138: invokeinterface 596 2 0
    //   143: checkcast 598	android/os/Parcelable
    //   146: astore_1
    //   147: aload 5
    //   149: invokevirtual 601	android/os/Parcel:recycle	()V
    //   152: ldc_w 563
    //   155: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: areturn
    //   160: astore_1
    //   161: aload 6
    //   163: monitorexit
    //   164: ldc_w 563
    //   167: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: getstatic 93	com/tencent/mmkv/b:AZS	Lcom/tencent/mmkv/b;
    //   176: aload_1
    //   177: invokevirtual 602	java/lang/Exception:toString	()Ljava/lang/String;
    //   180: invokestatic 303	com/tencent/mmkv/MMKV:simpleLog	(Lcom/tencent/mmkv/b;Ljava/lang/String;)V
    //   183: aload 5
    //   185: invokevirtual 601	android/os/Parcel:recycle	()V
    //   188: ldc_w 563
    //   191: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: areturn
    //   196: new 562	java/lang/Exception
    //   199: dup
    //   200: ldc_w 604
    //   203: aload 7
    //   205: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   211: invokespecial 605	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: ldc_w 563
    //   218: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload 5
    //   226: invokevirtual 601	android/os/Parcel:recycle	()V
    //   229: ldc_w 563
    //   232: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	MMKV
    //   0	237	1	paramString	String
    //   0	237	2	paramClass	Class<T>
    //   0	237	3	paramT	T
    //   85	6	4	localCreator	Parcelable.Creator
    //   43	182	5	localParcel	Parcel
    //   64	140	7	str	String
    // Exception table:
    //   from	to	target	type
    //   74	87	160	finally
    //   95	110	160	finally
    //   116	126	160	finally
    //   128	131	160	finally
    //   161	164	160	finally
    //   60	74	172	java/lang/Exception
    //   135	147	172	java/lang/Exception
    //   164	172	172	java/lang/Exception
    //   196	223	172	java/lang/Exception
    //   60	74	223	finally
    //   135	147	223	finally
    //   164	172	223	finally
    //   173	183	223	finally
    //   196	223	223	finally
  }
  
  public String decodeString(String paramString)
  {
    AppMethodBeat.i(123990);
    paramString = decodeString(this.nativeHandle, paramString, null);
    AppMethodBeat.o(123990);
    return paramString;
  }
  
  public String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123991);
    paramString1 = decodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(123991);
    return paramString1;
  }
  
  public Set<String> decodeStringSet(String paramString)
  {
    AppMethodBeat.i(123993);
    paramString = decodeStringSet(paramString, null);
    AppMethodBeat.o(123993);
    return paramString;
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(123994);
    paramString = decodeStringSet(this.nativeHandle, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(123994);
      return paramSet;
    }
    paramString = new HashSet(Arrays.asList(paramString));
    AppMethodBeat.o(123994);
    return paramString;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public boolean encode(String paramString, double paramDouble)
  {
    AppMethodBeat.i(123986);
    boolean bool = encodeDouble(this.nativeHandle, paramString, paramDouble);
    AppMethodBeat.o(123986);
    return bool;
  }
  
  public boolean encode(String paramString, float paramFloat)
  {
    AppMethodBeat.i(123983);
    boolean bool = encodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(123983);
    return bool;
  }
  
  public boolean encode(String paramString, int paramInt)
  {
    AppMethodBeat.i(123977);
    boolean bool = encodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(123977);
    return bool;
  }
  
  public boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(123980);
    boolean bool = encodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(123980);
    return bool;
  }
  
  public boolean encode(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(123997);
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, paramParcelable.describeContents());
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    boolean bool = encodeBytes(this.nativeHandle, paramString, paramParcelable);
    AppMethodBeat.o(123997);
    return bool;
  }
  
  public boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123989);
    boolean bool = encodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(123989);
    return bool;
  }
  
  public boolean encode(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(123992);
    boolean bool = encodeSet(this.nativeHandle, paramString, (String[])paramSet.toArray(new String[paramSet.size()]));
    AppMethodBeat.o(123992);
    return bool;
  }
  
  public boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(123974);
    paramBoolean = encodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(123974);
    return paramBoolean;
  }
  
  public boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123995);
    boolean bool = encodeBytes(this.nativeHandle, paramString, paramArrayOfByte);
    AppMethodBeat.o(123995);
    return bool;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(124007);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    AppMethodBeat.o(124007);
    throw localUnsupportedOperationException;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124018);
    paramBoolean = decodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(124018);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(124016);
    paramFloat = decodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(124016);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(124012);
    paramInt = decodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(124012);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(124014);
    paramLong = decodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(124014);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124008);
    paramString1 = decodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(124008);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(124010);
    paramString = decodeStringSet(paramString, paramSet);
    AppMethodBeat.o(124010);
    return paramString;
  }
  
  public int getValueActualSize(String paramString)
  {
    AppMethodBeat.i(124001);
    int i = valueSize(this.nativeHandle, paramString, true);
    AppMethodBeat.o(124001);
    return i;
  }
  
  public int getValueSize(String paramString)
  {
    AppMethodBeat.i(124000);
    int i = valueSize(this.nativeHandle, paramString, false);
    AppMethodBeat.o(124000);
    return i;
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(124006);
    paramSharedPreferences = paramSharedPreferences.getAll();
    if ((paramSharedPreferences == null) || (paramSharedPreferences.size() <= 0))
    {
      AppMethodBeat.o(124006);
      return 0;
    }
    Iterator localIterator = paramSharedPreferences.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((str != null) && (localObject != null)) {
        if ((localObject instanceof Boolean)) {
          encodeBool(this.nativeHandle, str, ((Boolean)localObject).booleanValue());
        } else if ((localObject instanceof Integer)) {
          encodeInt(this.nativeHandle, str, ((Integer)localObject).intValue());
        } else if ((localObject instanceof Long)) {
          encodeLong(this.nativeHandle, str, ((Long)localObject).longValue());
        } else if ((localObject instanceof Float)) {
          encodeFloat(this.nativeHandle, str, ((Float)localObject).floatValue());
        } else if ((localObject instanceof Double)) {
          encodeDouble(this.nativeHandle, str, ((Double)localObject).doubleValue());
        } else if ((localObject instanceof String)) {
          encodeString(this.nativeHandle, str, (String)localObject);
        } else if ((localObject instanceof Set)) {
          encode(str, (Set)localObject);
        } else {
          simpleLog(b.AZS, "unknown type: " + localObject.getClass());
        }
      }
    }
    int i = paramSharedPreferences.size();
    AppMethodBeat.o(124006);
    return i;
  }
  
  public native void lock();
  
  public native String mmapID();
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124019);
    encodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(124019);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(124017);
    encodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(124017);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(124013);
    encodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(124013);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(124015);
    encodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(124015);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124009);
    encodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(124009);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(124011);
    encode(paramString, paramSet);
    AppMethodBeat.o(124011);
    return this;
  }
  
  public native boolean reKey(String paramString);
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(124024);
    paramOnSharedPreferenceChangeListener = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124024);
    throw paramOnSharedPreferenceChangeListener;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(124020);
    removeValueForKey(paramString);
    AppMethodBeat.o(124020);
    return this;
  }
  
  public void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(124005);
    removeValueForKey(this.nativeHandle, paramString);
    AppMethodBeat.o(124005);
  }
  
  public native void removeValuesForKeys(String[] paramArrayOfString);
  
  public native void sync();
  
  public long totalSize()
  {
    AppMethodBeat.i(124004);
    long l = totalSize(this.nativeHandle);
    AppMethodBeat.o(124004);
    return l;
  }
  
  public native void trim();
  
  public native boolean tryLock();
  
  public native void unlock();
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(124025);
    paramOnSharedPreferenceChangeListener = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(124025);
    throw paramOnSharedPreferenceChangeListener;
  }
  
  public int writeValueToNativeBuffer(String paramString, d paramd)
  {
    AppMethodBeat.i(124029);
    int i = writeValueToNB(this.nativeHandle, paramString, paramd.AZY, paramd.size);
    AppMethodBeat.o(124029);
    return i;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mmkv.MMKV
 * JD-Core Version:    0.7.0.1
 */