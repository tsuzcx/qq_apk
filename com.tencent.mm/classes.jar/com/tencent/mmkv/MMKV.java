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
  private static b gCallbackHandler;
  private static a gContentChangeNotify;
  private static boolean gWantLogReDirecting;
  private static c[] index2LogLevel;
  private static EnumMap<c, Integer> logLevel2Index;
  private static final HashMap<String, Parcelable.Creator<?>> mCreators;
  private static EnumMap<d, Integer> recoverIndex;
  private static String rootDir;
  private long nativeHandle;
  
  static
  {
    AppMethodBeat.i(13527);
    EnumMap localEnumMap = new EnumMap(d.class);
    recoverIndex = localEnumMap;
    localEnumMap.put(d.Zbk, Integer.valueOf(0));
    recoverIndex.put(d.Zbl, Integer.valueOf(1));
    localEnumMap = new EnumMap(c.class);
    logLevel2Index = localEnumMap;
    localEnumMap.put(c.Zbe, Integer.valueOf(0));
    logLevel2Index.put(c.Zbf, Integer.valueOf(1));
    logLevel2Index.put(c.Zbg, Integer.valueOf(2));
    logLevel2Index.put(c.Zbh, Integer.valueOf(3));
    logLevel2Index.put(c.Zbi, Integer.valueOf(4));
    index2LogLevel = new c[] { c.Zbe, c.Zbf, c.Zbg, c.Zbh, c.Zbi };
    rootDir = null;
    mCreators = new HashMap();
    gWantLogReDirecting = false;
    AppMethodBeat.o(13527);
  }
  
  private MMKV(long paramLong)
  {
    this.nativeHandle = paramLong;
  }
  
  private native boolean containsKey(long paramLong, String paramString);
  
  private native long count(long paramLong);
  
  private static native long createNB(int paramInt);
  
  public static e createNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(13518);
    long l = createNB(paramInt);
    if (l <= 0L)
    {
      AppMethodBeat.o(13518);
      return null;
    }
    e locale = new e(l, paramInt);
    AppMethodBeat.o(13518);
    return locale;
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
    AppMethodBeat.i(13460);
    if (rootDir == null)
    {
      localObject = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13460);
      throw ((Throwable)localObject);
    }
    Object localObject = new MMKV(getDefaultMMKV(1, null));
    AppMethodBeat.o(13460);
    return localObject;
  }
  
  public static MMKV defaultMMKV(int paramInt, String paramString)
  {
    AppMethodBeat.i(13461);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13461);
      throw paramString;
    }
    paramString = new MMKV(getDefaultMMKV(paramInt, paramString));
    AppMethodBeat.o(13461);
    return paramString;
  }
  
  private static native void destroyNB(long paramLong, int paramInt);
  
  public static void destroyNativeBuffer(e parame)
  {
    AppMethodBeat.i(13519);
    destroyNB(parame.pointer, parame.size);
    AppMethodBeat.o(13519);
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
    AppMethodBeat.i(13450);
    paramContext = initialize(paramContext.getFilesDir().getAbsolutePath() + "/mmkv", null, c.Zbf);
    AppMethodBeat.o(13450);
    return paramContext;
  }
  
  public static String initialize(Context paramContext, c paramc)
  {
    AppMethodBeat.i(244101);
    paramContext = initialize(paramContext.getFilesDir().getAbsolutePath() + "/mmkv", null, paramc);
    AppMethodBeat.o(244101);
    return paramContext;
  }
  
  public static String initialize(String paramString)
  {
    AppMethodBeat.i(13451);
    paramString = initialize(paramString, null, c.Zbf);
    AppMethodBeat.o(13451);
    return paramString;
  }
  
  public static String initialize(String paramString, a parama)
  {
    AppMethodBeat.i(13452);
    paramString = initialize(paramString, parama, c.Zbf);
    AppMethodBeat.o(13452);
    return paramString;
  }
  
  public static String initialize(String paramString, a parama, c paramc)
  {
    AppMethodBeat.i(244103);
    if (parama != null) {
      "StaticCpp".equals("SharedCpp");
    }
    for (;;)
    {
      rootDir = paramString;
      jniInitialize(paramString, logLevel2Int(paramc));
      AppMethodBeat.o(244103);
      return paramString;
      if ("StaticCpp".equals("SharedCpp")) {
        System.loadLibrary("c++_shared");
      }
      System.loadLibrary("mmkv");
    }
  }
  
  public static String initialize(String paramString, c paramc)
  {
    AppMethodBeat.i(244102);
    paramString = initialize(paramString, null, paramc);
    AppMethodBeat.o(244102);
    return paramString;
  }
  
  public static native boolean isFileValid(String paramString);
  
  private static native void jniInitialize(String paramString, int paramInt);
  
  private static int logLevel2Int(c paramc)
  {
    int j = 1;
    AppMethodBeat.i(244104);
    int i = j;
    switch (1.Zbc[paramc.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(244104);
      return i;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  private static void mmkvLogImp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13525);
    if ((gCallbackHandler != null) && (gWantLogReDirecting))
    {
      gCallbackHandler.mmkvLog(index2LogLevel[paramInt1], paramString1, paramInt2, paramString2, paramString3);
      AppMethodBeat.o(13525);
      return;
    }
    paramString1 = 1.Zbc;
    index2LogLevel[paramInt1].ordinal();
    AppMethodBeat.o(13525);
  }
  
  public static MMKV mmkvWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(13517);
    paramString1 = new MMKV(getMMKVWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(13517);
    return paramString1;
  }
  
  public static MMKV mmkvWithAshmemID(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(13459);
    if (rootDir == null)
    {
      paramContext = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13459);
      throw paramContext;
    }
    Object localObject = MMKVContentProvider.bm(paramContext, Process.myPid());
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      simpleLog(c.Zbh, "process name detect fail, try again later");
      AppMethodBeat.o(13459);
      return null;
    }
    if (((String)localObject).contains(":"))
    {
      localObject = MMKVContentProvider.lR(paramContext);
      if (localObject == null)
      {
        simpleLog(c.Zbh, "MMKVContentProvider has invalid authority");
        AppMethodBeat.o(13459);
        return null;
      }
      simpleLog(c.Zbf, "getting parcelable mmkv in process, Uri = ".concat(String.valueOf(localObject)));
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
          if ((paramContext.Zbo >= 0) && (paramContext.Zbp >= 0)) {}
          for (paramContext = mmkvWithAshmemFD(paramContext.Zbn, paramContext.Zbo, paramContext.Zbp, paramContext.cryptKey);; paramContext = null)
          {
            if (paramContext != null) {
              simpleLog(c.Zbf, paramContext.mmapID() + " fd = " + paramContext.ashmemFD() + ", meta fd = " + paramContext.ashmemMetaFD());
            }
            AppMethodBeat.o(13459);
            return paramContext;
          }
        }
      }
    }
    else
    {
      simpleLog(c.Zbf, "getting mmkv in main process");
      paramContext = new MMKV(getMMKVWithIDAndSize(paramString1, paramInt1, paramInt2 | 0x8, paramString2));
      AppMethodBeat.o(13459);
      return paramContext;
    }
    AppMethodBeat.o(13459);
    return null;
  }
  
  public static MMKV mmkvWithID(String paramString)
  {
    AppMethodBeat.i(13454);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13454);
      throw paramString;
    }
    paramString = new MMKV(getMMKVWithID(paramString, 1, null, null));
    AppMethodBeat.o(13454);
    return paramString;
  }
  
  public static MMKV mmkvWithID(String paramString, int paramInt)
  {
    AppMethodBeat.i(13455);
    if (rootDir == null)
    {
      paramString = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13455);
      throw paramString;
    }
    paramString = new MMKV(getMMKVWithID(paramString, paramInt, null, null));
    AppMethodBeat.o(13455);
    return paramString;
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(13456);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13456);
      throw paramString1;
    }
    paramString1 = new MMKV(getMMKVWithID(paramString1, paramInt, paramString2, null));
    AppMethodBeat.o(13456);
    return paramString1;
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(13458);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13458);
      throw paramString1;
    }
    long l = getMMKVWithID(paramString1, paramInt, paramString2, paramString3);
    if (l == 0L)
    {
      AppMethodBeat.o(13458);
      return null;
    }
    paramString1 = new MMKV(l);
    AppMethodBeat.o(13458);
    return paramString1;
  }
  
  public static MMKV mmkvWithID(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13457);
    if (rootDir == null)
    {
      paramString1 = new IllegalStateException("You should Call MMKV.initialize() first.");
      AppMethodBeat.o(13457);
      throw paramString1;
    }
    long l = getMMKVWithID(paramString1, 1, null, paramString2);
    if (l == 0L)
    {
      AppMethodBeat.o(13457);
      return null;
    }
    paramString1 = new MMKV(l);
    AppMethodBeat.o(13457);
    return paramString1;
  }
  
  private static void onContentChangedByOuterProcess(String paramString) {}
  
  public static native void onExit();
  
  private static int onMMKVCRCCheckFail(String paramString)
  {
    AppMethodBeat.i(13523);
    d locald = d.Zbk;
    if (gCallbackHandler != null) {
      locald = gCallbackHandler.onMMKVCRCCheckFail(paramString);
    }
    simpleLog(c.Zbf, "Recover strategic for " + paramString + " is " + locald);
    paramString = (Integer)recoverIndex.get(locald);
    if (paramString == null)
    {
      AppMethodBeat.o(13523);
      return 0;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(13523);
    return i;
  }
  
  private static int onMMKVFileLengthError(String paramString)
  {
    AppMethodBeat.i(13524);
    d locald = d.Zbk;
    if (gCallbackHandler != null) {
      locald = gCallbackHandler.onMMKVFileLengthError(paramString);
    }
    simpleLog(c.Zbf, "Recover strategic for " + paramString + " is " + locald);
    paramString = (Integer)recoverIndex.get(locald);
    if (paramString == null)
    {
      AppMethodBeat.o(13524);
      return 0;
    }
    int i = paramString.intValue();
    AppMethodBeat.o(13524);
    return i;
  }
  
  public static native int pageSize();
  
  public static void registerContentChangeNotify(a parama)
  {
    AppMethodBeat.i(244155);
    gContentChangeNotify = parama;
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      setWantsContentChangeNotify(bool);
      AppMethodBeat.o(244155);
      return;
    }
  }
  
  public static void registerHandler(b paramb)
  {
    AppMethodBeat.i(13521);
    gCallbackHandler = paramb;
    if (paramb.wantLogRedirecting())
    {
      setCallbackHandler(true, true);
      gWantLogReDirecting = true;
      AppMethodBeat.o(13521);
      return;
    }
    setCallbackHandler(false, true);
    gWantLogReDirecting = false;
    AppMethodBeat.o(13521);
  }
  
  private native void removeValueForKey(long paramLong, String paramString);
  
  private static native void setCallbackHandler(boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void setLogLevel(int paramInt);
  
  public static void setLogLevel(c paramc)
  {
    AppMethodBeat.i(13453);
    setLogLevel(logLevel2Int(paramc));
    AppMethodBeat.o(13453);
  }
  
  private static native void setWantsContentChangeNotify(boolean paramBoolean);
  
  private static void simpleLog(c paramc, String paramString)
  {
    AppMethodBeat.i(13526);
    Object localObject = Thread.currentThread().getStackTrace();
    localObject = localObject[(localObject.length - 1)];
    paramc = (Integer)logLevel2Index.get(paramc);
    if (paramc == null) {}
    for (int i = 0;; i = paramc.intValue())
    {
      mmkvLogImp(i, ((StackTraceElement)localObject).getFileName(), ((StackTraceElement)localObject).getLineNumber(), ((StackTraceElement)localObject).getMethodName(), paramString);
      AppMethodBeat.o(13526);
      return;
    }
  }
  
  private native void sync(boolean paramBoolean);
  
  private native long totalSize(long paramLong);
  
  public static void unregisterContentChangeNotify()
  {
    AppMethodBeat.i(244156);
    gContentChangeNotify = null;
    setWantsContentChangeNotify(false);
    AppMethodBeat.o(244156);
  }
  
  public static void unregisterHandler()
  {
    AppMethodBeat.i(13522);
    gCallbackHandler = null;
    setCallbackHandler(false, false);
    gWantLogReDirecting = false;
    AppMethodBeat.o(13522);
  }
  
  private native int valueSize(long paramLong, String paramString, boolean paramBoolean);
  
  private native int writeValueToNB(long paramLong1, String paramString, long paramLong2, int paramInt);
  
  public native String[] allKeys();
  
  public void apply()
  {
    AppMethodBeat.i(13513);
    sync(false);
    AppMethodBeat.o(13513);
  }
  
  public native int ashmemFD();
  
  public native int ashmemMetaFD();
  
  public void async()
  {
    AppMethodBeat.i(13495);
    sync(false);
    AppMethodBeat.o(13495);
  }
  
  public native void checkContentChangedByOuterProcess();
  
  public native void checkReSetCryptKey(String paramString);
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(13511);
    clearAll();
    AppMethodBeat.o(13511);
    return this;
  }
  
  public native void clearAll();
  
  public native void clearMemoryCache();
  
  public native void close();
  
  public boolean commit()
  {
    AppMethodBeat.i(13512);
    sync(true);
    AppMethodBeat.o(13512);
    return true;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(13514);
    boolean bool = containsKey(paramString);
    AppMethodBeat.o(13514);
    return bool;
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(13490);
    boolean bool = containsKey(this.nativeHandle, paramString);
    AppMethodBeat.o(13490);
    return bool;
  }
  
  public long count()
  {
    AppMethodBeat.i(13491);
    long l = count(this.nativeHandle);
    AppMethodBeat.o(13491);
    return l;
  }
  
  public native String cryptKey();
  
  public boolean decodeBool(String paramString)
  {
    AppMethodBeat.i(13463);
    boolean bool = decodeBool(this.nativeHandle, paramString, false);
    AppMethodBeat.o(13463);
    return bool;
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13464);
    paramBoolean = decodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(13464);
    return paramBoolean;
  }
  
  public byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(13484);
    paramString = decodeBytes(paramString, null);
    AppMethodBeat.o(13484);
    return paramString;
  }
  
  public byte[] decodeBytes(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244136);
    paramString = decodeBytes(this.nativeHandle, paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(244136);
      return paramString;
    }
    AppMethodBeat.o(244136);
    return paramArrayOfByte;
  }
  
  public double decodeDouble(String paramString)
  {
    AppMethodBeat.i(13475);
    double d = decodeDouble(this.nativeHandle, paramString, 0.0D);
    AppMethodBeat.o(13475);
    return d;
  }
  
  public double decodeDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(13476);
    paramDouble = decodeDouble(this.nativeHandle, paramString, paramDouble);
    AppMethodBeat.o(13476);
    return paramDouble;
  }
  
  public float decodeFloat(String paramString)
  {
    AppMethodBeat.i(13472);
    float f = decodeFloat(this.nativeHandle, paramString, 0.0F);
    AppMethodBeat.o(13472);
    return f;
  }
  
  public float decodeFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(13473);
    paramFloat = decodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(13473);
    return paramFloat;
  }
  
  public int decodeInt(String paramString)
  {
    AppMethodBeat.i(13466);
    int i = decodeInt(this.nativeHandle, paramString, 0);
    AppMethodBeat.o(13466);
    return i;
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(13467);
    paramInt = decodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(13467);
    return paramInt;
  }
  
  public long decodeLong(String paramString)
  {
    AppMethodBeat.i(13469);
    long l = decodeLong(this.nativeHandle, paramString, 0L);
    AppMethodBeat.o(13469);
    return l;
  }
  
  public long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(13470);
    paramLong = decodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(13470);
    return paramLong;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(13486);
    paramString = decodeParcelable(paramString, paramClass, null);
    AppMethodBeat.o(13486);
    return paramString;
  }
  
  /* Error */
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass, T paramT)
  {
    // Byte code:
    //   0: sipush 13487
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ifnonnull +11 -> 18
    //   10: sipush 13487
    //   13: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_3
    //   17: areturn
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 117	com/tencent/mmkv/MMKV:nativeHandle	J
    //   23: aload_1
    //   24: invokespecial 530	com/tencent/mmkv/MMKV:decodeBytes	(JLjava/lang/String;)[B
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +11 -> 40
    //   32: sipush 13487
    //   35: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_3
    //   39: areturn
    //   40: invokestatic 560	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   43: astore 5
    //   45: aload 5
    //   47: aload_1
    //   48: iconst_0
    //   49: aload_1
    //   50: arraylength
    //   51: invokevirtual 564	android/os/Parcel:unmarshall	([BII)V
    //   54: aload 5
    //   56: iconst_0
    //   57: invokevirtual 567	android/os/Parcel:setDataPosition	(I)V
    //   60: aload_2
    //   61: invokevirtual 568	java/lang/Class:toString	()Ljava/lang/String;
    //   64: astore 7
    //   66: getstatic 107	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   69: astore 6
    //   71: aload 6
    //   73: monitorenter
    //   74: getstatic 107	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   77: aload 7
    //   79: invokevirtual 569	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 571	android/os/Parcelable$Creator
    //   85: astore 4
    //   87: aload 4
    //   89: astore_1
    //   90: aload 4
    //   92: ifnonnull +36 -> 128
    //   95: aload_2
    //   96: ldc_w 573
    //   99: invokevirtual 577	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   102: aconst_null
    //   103: invokevirtual 580	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 571	android/os/Parcelable$Creator
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_2
    //   113: ifnull +15 -> 128
    //   116: getstatic 107	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   119: aload 7
    //   121: aload_2
    //   122: invokevirtual 583	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_2
    //   127: astore_1
    //   128: aload 6
    //   130: monitorexit
    //   131: aload_1
    //   132: ifnull +64 -> 196
    //   135: aload_1
    //   136: aload 5
    //   138: invokeinterface 587 2 0
    //   143: checkcast 589	android/os/Parcelable
    //   146: astore_1
    //   147: aload 5
    //   149: invokevirtual 592	android/os/Parcel:recycle	()V
    //   152: sipush 13487
    //   155: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: areturn
    //   160: astore_1
    //   161: aload 6
    //   163: monitorexit
    //   164: sipush 13487
    //   167: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: getstatic 94	com/tencent/mmkv/c:Zbh	Lcom/tencent/mmkv/c;
    //   176: aload_1
    //   177: invokevirtual 593	java/lang/Exception:toString	()Ljava/lang/String;
    //   180: invokestatic 306	com/tencent/mmkv/MMKV:simpleLog	(Lcom/tencent/mmkv/c;Ljava/lang/String;)V
    //   183: aload 5
    //   185: invokevirtual 592	android/os/Parcel:recycle	()V
    //   188: sipush 13487
    //   191: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: areturn
    //   196: new 554	java/lang/Exception
    //   199: dup
    //   200: ldc_w 595
    //   203: aload 7
    //   205: invokestatic 323	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   211: invokespecial 596	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   214: astore_1
    //   215: sipush 13487
    //   218: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_1
    //   224: aload 5
    //   226: invokevirtual 592	android/os/Parcel:recycle	()V
    //   229: sipush 13487
    //   232: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   60	74	172	java/lang/Exception
    //   135	147	172	java/lang/Exception
    //   161	172	172	java/lang/Exception
    //   196	223	172	java/lang/Exception
    //   60	74	223	finally
    //   135	147	223	finally
    //   161	172	223	finally
    //   173	183	223	finally
    //   196	223	223	finally
  }
  
  public String decodeString(String paramString)
  {
    AppMethodBeat.i(13478);
    paramString = decodeString(this.nativeHandle, paramString, null);
    AppMethodBeat.o(13478);
    return paramString;
  }
  
  public String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13479);
    paramString1 = decodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(13479);
    return paramString1;
  }
  
  public Set<String> decodeStringSet(String paramString)
  {
    AppMethodBeat.i(13481);
    paramString = decodeStringSet(paramString, null);
    AppMethodBeat.o(13481);
    return paramString;
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(13482);
    paramString = decodeStringSet(paramString, paramSet, HashSet.class);
    AppMethodBeat.o(13482);
    return paramString;
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet, Class<? extends Set> paramClass)
  {
    AppMethodBeat.i(244132);
    paramString = decodeStringSet(this.nativeHandle, paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(244132);
      return paramSet;
    }
    try
    {
      paramClass = (Set)paramClass.newInstance();
      paramClass.addAll(Arrays.asList(paramString));
      AppMethodBeat.o(244132);
      return paramClass;
    }
    catch (IllegalAccessException paramString)
    {
      AppMethodBeat.o(244132);
      return paramSet;
    }
    catch (InstantiationException paramString)
    {
      AppMethodBeat.o(244132);
    }
    return paramSet;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public boolean encode(String paramString, double paramDouble)
  {
    AppMethodBeat.i(13474);
    boolean bool = encodeDouble(this.nativeHandle, paramString, paramDouble);
    AppMethodBeat.o(13474);
    return bool;
  }
  
  public boolean encode(String paramString, float paramFloat)
  {
    AppMethodBeat.i(13471);
    boolean bool = encodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(13471);
    return bool;
  }
  
  public boolean encode(String paramString, int paramInt)
  {
    AppMethodBeat.i(13465);
    boolean bool = encodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(13465);
    return bool;
  }
  
  public boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(13468);
    boolean bool = encodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(13468);
    return bool;
  }
  
  public boolean encode(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(13485);
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, paramParcelable.describeContents());
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    boolean bool = encodeBytes(this.nativeHandle, paramString, paramParcelable);
    AppMethodBeat.o(13485);
    return bool;
  }
  
  public boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13477);
    boolean bool = encodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(13477);
    return bool;
  }
  
  public boolean encode(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(13480);
    boolean bool = encodeSet(this.nativeHandle, paramString, (String[])paramSet.toArray(new String[0]));
    AppMethodBeat.o(13480);
    return bool;
  }
  
  public boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13462);
    paramBoolean = encodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(13462);
    return paramBoolean;
  }
  
  public boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13483);
    boolean bool = encodeBytes(this.nativeHandle, paramString, paramArrayOfByte);
    AppMethodBeat.o(13483);
    return bool;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(13497);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    AppMethodBeat.o(13497);
    throw localUnsupportedOperationException;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13508);
    paramBoolean = decodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(13508);
    return paramBoolean;
  }
  
  public byte[] getBytes(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244145);
    paramString = decodeBytes(paramString, paramArrayOfByte);
    AppMethodBeat.o(244145);
    return paramString;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(13506);
    paramFloat = decodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(13506);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(13502);
    paramInt = decodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(13502);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(13504);
    paramLong = decodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(13504);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13498);
    paramString1 = decodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(13498);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(13500);
    paramString = decodeStringSet(paramString, paramSet);
    AppMethodBeat.o(13500);
    return paramString;
  }
  
  public int getValueActualSize(String paramString)
  {
    AppMethodBeat.i(13489);
    int i = valueSize(this.nativeHandle, paramString, true);
    AppMethodBeat.o(13489);
    return i;
  }
  
  public int getValueSize(String paramString)
  {
    AppMethodBeat.i(13488);
    int i = valueSize(this.nativeHandle, paramString, false);
    AppMethodBeat.o(13488);
    return i;
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(13496);
    paramSharedPreferences = paramSharedPreferences.getAll();
    if ((paramSharedPreferences == null) || (paramSharedPreferences.size() <= 0))
    {
      AppMethodBeat.o(13496);
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
          simpleLog(c.Zbh, "unknown type: " + localObject.getClass());
        }
      }
    }
    int i = paramSharedPreferences.size();
    AppMethodBeat.o(13496);
    return i;
  }
  
  public native void lock();
  
  public native String mmapID();
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(13509);
    encodeBool(this.nativeHandle, paramString, paramBoolean);
    AppMethodBeat.o(13509);
    return this;
  }
  
  public SharedPreferences.Editor putBytes(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244144);
    encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(244144);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(13507);
    encodeFloat(this.nativeHandle, paramString, paramFloat);
    AppMethodBeat.o(13507);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(13503);
    encodeInt(this.nativeHandle, paramString, paramInt);
    AppMethodBeat.o(13503);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(13505);
    encodeLong(this.nativeHandle, paramString, paramLong);
    AppMethodBeat.o(13505);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13499);
    encodeString(this.nativeHandle, paramString1, paramString2);
    AppMethodBeat.o(13499);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(13501);
    encode(paramString, paramSet);
    AppMethodBeat.o(13501);
    return this;
  }
  
  public native boolean reKey(String paramString);
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(13515);
    paramOnSharedPreferenceChangeListener = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(13515);
    throw paramOnSharedPreferenceChangeListener;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(13510);
    removeValueForKey(paramString);
    AppMethodBeat.o(13510);
    return this;
  }
  
  public void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(13493);
    removeValueForKey(this.nativeHandle, paramString);
    AppMethodBeat.o(13493);
  }
  
  public native void removeValuesForKeys(String[] paramArrayOfString);
  
  public void sync()
  {
    AppMethodBeat.i(13494);
    sync(true);
    AppMethodBeat.o(13494);
  }
  
  public long totalSize()
  {
    AppMethodBeat.i(13492);
    long l = totalSize(this.nativeHandle);
    AppMethodBeat.o(13492);
    return l;
  }
  
  public native void trim();
  
  public native boolean tryLock();
  
  public native void unlock();
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(13516);
    paramOnSharedPreferenceChangeListener = new UnsupportedOperationException("Not implement in MMKV");
    AppMethodBeat.o(13516);
    throw paramOnSharedPreferenceChangeListener;
  }
  
  public int writeValueToNativeBuffer(String paramString, e parame)
  {
    AppMethodBeat.i(13520);
    int i = writeValueToNB(this.nativeHandle, paramString, parame.pointer, parame.size);
    AppMethodBeat.o(13520);
    return i;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mmkv.MMKV
 * JD-Core Version:    0.7.0.1
 */