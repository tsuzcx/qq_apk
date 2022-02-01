package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.e;
import java.util.Map;
import java.util.Set;

public class MultiProcessMMKV
  implements SharedPreferences, SharedPreferences.Editor
{
  private static final String DEFAULT_MULTI_NAME = "MULTIPROCESSMMKV_MULTI_DEFAULT";
  private static final String DEFAULT_SINGLE_NAME = "MULTIPROCESSMMKV_SINGLE_DEFAULT";
  private static final int IDKEY_MMKV = 941;
  private static final int KVID_MMKV = 18378;
  private static final int MAX_LRU_MAP_SIZE = 125;
  public static final int MULTI_PROCESS_MODE = 2;
  private static final String PERSERVED_NAME = "MULTIPROCESSMMKV_PERSERVED_NAME";
  public static final int SINGLE_PROCESS_MODE = 1;
  private static final String TAG = "MicroMsg.MultiProcessMMKV";
  private static ArrayMap<String, MultiProcessMMKV> mmkvCache;
  private static h<String, MultiProcessMMKV> mmkvLruCache;
  private static boolean stingyMode;
  private MMKV mmkv;
  private int mode;
  private String name;
  
  static
  {
    AppMethodBeat.i(156304);
    mmkvCache = new ArrayMap();
    MMKV.class.getClassLoader();
    j.KW("mmkv");
    MMKV.initialize(MMApplicationContext.getContext());
    MMKV.registerHandler(new MultiProcessMMKV.1());
    int i = MMKV.defaultMMKV(2, null).decodeInt("mFdLimit", -1);
    if ((i <= 1024) && (i > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      stingyMode = bool;
      Log.i("MicroMsg.MultiProcessMMKV", "mFdLimit = %d", new Object[] { Integer.valueOf(i) });
      if (stingyMode) {
        mmkvLruCache = new h(125, new f.b()
        {
          public final void preRemoveCallback(String paramAnonymousString, MultiProcessMMKV paramAnonymousMultiProcessMMKV1, MultiProcessMMKV paramAnonymousMultiProcessMMKV2)
          {
            AppMethodBeat.i(263499);
            if (paramAnonymousMultiProcessMMKV2 == null)
            {
              Log.i("MicroMsg.MultiProcessMMKV", "preRemoveCallback newValue == null");
              try
              {
                if ((paramAnonymousString.equals("MULTIPROCESSMMKV_SINGLE_DEFAULT")) || (paramAnonymousString.equals("MULTIPROCESSMMKV_MULTI_DEFAULT")))
                {
                  Log.i("MicroMsg.MultiProcessMMKV", "preRemoveCallback default MMKV, just return");
                  MultiProcessMMKV.mmkvLruCache.put(MultiProcessMMKV.access$000(paramAnonymousMultiProcessMMKV1), paramAnonymousMultiProcessMMKV1);
                  return;
                }
                Log.i("MicroMsg.MultiProcessMMKV", "preRemoveCallback MMKV : %s, will be closed", new Object[] { paramAnonymousString });
                MultiProcessMMKV.access$200(paramAnonymousMultiProcessMMKV1);
                return;
              }
              finally
              {
                AppMethodBeat.o(263499);
              }
            }
            AppMethodBeat.o(263499);
          }
        });
      }
      AppMethodBeat.o(156304);
      return;
    }
  }
  
  private MultiProcessMMKV(String paramString)
  {
    this.name = paramString;
  }
  
  private MultiProcessMMKV(String paramString, int paramInt, MMKV paramMMKV)
  {
    this.mmkv = paramMMKV;
    this.name = paramString;
    this.mode = paramInt;
  }
  
  private int ashmemFD()
  {
    AppMethodBeat.i(263493);
    int i = this.mmkv.ashmemFD();
    AppMethodBeat.o(263493);
    return i;
  }
  
  private int ashmemMetaFD()
  {
    AppMethodBeat.i(263494);
    int i = this.mmkv.ashmemMetaFD();
    AppMethodBeat.o(263494);
    return i;
  }
  
  private void checkReopen(String paramString)
  {
    AppMethodBeat.i(263496);
    if ((!stingyMode) || (mmkvLruCache == null))
    {
      AppMethodBeat.o(263496);
      return;
    }
    mmkvLruCache.checkAndUpTime(paramString);
    if (isClosed()) {
      try
      {
        Log.e("MicroMsg.MultiProcessMMKV", "MMKV : %s has bean closed, reopen now", new Object[] { paramString });
        this.mmkv = getCoreMMKV(this.name, this.mode);
        mmkvLruCache.put(paramString, this);
        return;
      }
      finally
      {
        AppMethodBeat.o(263496);
      }
    }
    AppMethodBeat.o(263496);
  }
  
  private void close()
  {
    AppMethodBeat.i(263485);
    this.mmkv.close();
    AppMethodBeat.o(263485);
  }
  
  public static MultiProcessMMKV.NativeBuffer createNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(263471);
    Object localObject = MMKV.createNativeBuffer(paramInt);
    localObject = new MultiProcessMMKV.NativeBuffer(((e)localObject).pointer, ((e)localObject).size);
    AppMethodBeat.o(263471);
    return localObject;
  }
  
  public static void destroyNativeBuffer(MultiProcessMMKV.NativeBuffer paramNativeBuffer)
  {
    AppMethodBeat.i(263472);
    MMKV.destroyNativeBuffer(new e(paramNativeBuffer.pointer, paramNativeBuffer.size));
    AppMethodBeat.o(263472);
  }
  
  private static void ensureSoLoaded()
  {
    AppMethodBeat.i(156303);
    MMKV.class.getClassLoader();
    j.KW("mmkv");
    AppMethodBeat.o(156303);
  }
  
  private MMKV getCoreMMKV()
  {
    return this.mmkv;
  }
  
  private static MMKV getCoreMMKV(String paramString, int paramInt)
  {
    AppMethodBeat.i(263463);
    try
    {
      MMKV localMMKV = MMKV.mmkvWithID(paramString, paramInt);
      paramString = localMMKV;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MultiProcessMMKV", "getCoreMMKV mode error name : %s ,mode : %d", new Object[] { paramString, Integer.valueOf(paramInt) });
        f.Iyx.idkeyStat(941L, 150L, 1L, true);
        if (paramInt == 2) {
          paramString = MMKV.mmkvWithID(paramString, 1);
        } else {
          paramString = MMKV.mmkvWithID(paramString, paramInt);
        }
      }
    }
    AppMethodBeat.o(263463);
    return paramString;
  }
  
  public static MultiProcessMMKV getCryptMMKV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263452);
    paramString1 = getCryptMMKVReal(paramString1, 2, paramString2);
    AppMethodBeat.o(263452);
    return paramString1;
  }
  
  public static MultiProcessMMKV getCryptMMKVReal(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(263455);
    paramString1 = new MultiProcessMMKV(paramString1, paramInt, MMKV.mmkvWithID(paramString1, paramInt, paramString2));
    AppMethodBeat.o(263455);
    return paramString1;
  }
  
  public static MultiProcessMMKV getDefault()
  {
    AppMethodBeat.i(263457);
    MultiProcessMMKV localMultiProcessMMKV = getMMKV("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.defaultMMKV(2, null));
    AppMethodBeat.o(263457);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getMMKV(String paramString)
  {
    AppMethodBeat.i(156254);
    paramString = getMMKV(paramString, 2, null);
    AppMethodBeat.o(156254);
    return paramString;
  }
  
  public static MultiProcessMMKV getMMKV(String paramString, int paramInt)
  {
    AppMethodBeat.i(156258);
    paramString = getMMKV(paramString, paramInt, null);
    AppMethodBeat.o(156258);
    return paramString;
  }
  
  private static MultiProcessMMKV getMMKV(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156259);
    if ((Util.isNullOrNil(paramString)) || (Util.isEqual(paramString, "MULTIPROCESSMMKV_PERSERVED_NAME")))
    {
      Log.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
      AppMethodBeat.o(156259);
      return null;
    }
    paramString = getMMKVReal(paramString, paramInt, paramMMKV);
    AppMethodBeat.o(156259);
    return paramString;
  }
  
  private static MultiProcessMMKV getMMKVReal(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156260);
    MultiProcessMMKV localMultiProcessMMKV;
    label238:
    for (;;)
    {
      try
      {
        if ((stingyMode) && (mmkvLruCache != null))
        {
          localMultiProcessMMKV = (MultiProcessMMKV)mmkvLruCache.aX(paramString);
          if (localMultiProcessMMKV != null) {
            break;
          }
          if (paramMMKV == null)
          {
            paramMMKV = new MultiProcessMMKV(paramString, paramInt, getCoreMMKV(paramString, paramInt));
            long l = paramMMKV.totalSize();
            if (l > 1048576L)
            {
              Log.e("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, size : %d, please contact with leafjia", new Object[] { paramString, Long.valueOf(l) });
              reportTotalSize(l, paramString);
              if (l > 5242880L)
              {
                f.Iyx.idkeyStat(941L, 100L, 1L, true);
                Log.i("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", new Object[] { Long.valueOf(l) });
                paramMMKV.trim();
                Log.i("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", new Object[] { Long.valueOf(paramMMKV.totalSize()) });
              }
            }
            if ((!stingyMode) || (mmkvLruCache == null)) {
              break label238;
            }
            mmkvLruCache.put(paramString, paramMMKV);
            return paramMMKV;
          }
        }
        else
        {
          localMultiProcessMMKV = (MultiProcessMMKV)mmkvCache.get(paramString);
          continue;
        }
        paramMMKV = new MultiProcessMMKV(paramString, paramInt, paramMMKV);
        continue;
        mmkvCache.put(paramString, paramMMKV);
      }
      finally
      {
        AppMethodBeat.o(156260);
      }
    }
    AppMethodBeat.o(156260);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getMMKVWithAshmemFD(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(263458);
    paramContext = getMMKV(paramString1, paramInt2, MMKV.mmkvWithAshmemID(paramContext, paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(263458);
    return paramContext;
  }
  
  public static MultiProcessMMKV getMMKVWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(263459);
    paramString1 = getMMKV(paramString1, -1, MMKV.mmkvWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(263459);
    return paramString1;
  }
  
  public static MultiProcessMMKV getMMKVWithTransportByName(String paramString)
  {
    AppMethodBeat.i(156261);
    MultiProcessMMKV localMultiProcessMMKV = getMMKV(paramString);
    transport2MMKV(MMApplicationContext.getContext().getSharedPreferences(paramString, 4), localMultiProcessMMKV);
    AppMethodBeat.o(156261);
    return localMultiProcessMMKV;
  }
  
  private int getMode()
  {
    return this.mode;
  }
  
  public static MultiProcessMMKV getMultiDefault()
  {
    AppMethodBeat.i(156256);
    MultiProcessMMKV localMultiProcessMMKV = getDefault();
    AppMethodBeat.o(156256);
    return localMultiProcessMMKV;
  }
  
  private String getName()
  {
    return this.name;
  }
  
  private static MultiProcessMMKV getPerservedMMKV()
  {
    AppMethodBeat.i(263464);
    MultiProcessMMKV localMultiProcessMMKV = getMMKVReal("MULTIPROCESSMMKV_PERSERVED_NAME", 2, null);
    AppMethodBeat.o(263464);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getSingleCryptMMKV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263454);
    paramString1 = getCryptMMKVReal(paramString1, 1, paramString2);
    AppMethodBeat.o(263454);
    return paramString1;
  }
  
  public static MultiProcessMMKV getSingleDefault()
  {
    AppMethodBeat.i(156255);
    MultiProcessMMKV localMultiProcessMMKV = getDefault();
    AppMethodBeat.o(156255);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getSingleMMKV(String paramString)
  {
    AppMethodBeat.i(156257);
    paramString = getMMKV(paramString, 1, null);
    AppMethodBeat.o(156257);
    return paramString;
  }
  
  public static void init() {}
  
  private boolean isClosed()
  {
    AppMethodBeat.i(263495);
    if (mmapID() == null)
    {
      AppMethodBeat.o(263495);
      return true;
    }
    AppMethodBeat.o(263495);
    return false;
  }
  
  private boolean isLegal(String paramString, Object paramObject)
  {
    AppMethodBeat.i(156302);
    checkReopen(getName());
    if ((!Util.isNullOrNil(paramString)) && (paramObject != null) && (!Util.isNullOrNil(getName())))
    {
      AppMethodBeat.o(156302);
      return true;
    }
    AppMethodBeat.o(156302);
    return false;
  }
  
  private String mmapID()
  {
    AppMethodBeat.i(263492);
    String str = this.mmkv.mmapID();
    AppMethodBeat.o(263492);
    return str;
  }
  
  private static void reportTotalSize(long paramLong, String paramString)
  {
    AppMethodBeat.i(263466);
    if (paramLong <= 5242880L) {
      f.Iyx.idkeyStat(941L, 10L, 1L, true);
    }
    for (;;)
    {
      f.Iyx.a(18378, new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(263466);
      return;
      if (paramLong <= 10485760L) {
        f.Iyx.idkeyStat(941L, 11L, 1L, true);
      } else if (paramLong <= 104857600L) {
        f.Iyx.idkeyStat(941L, 12L, 1L, true);
      } else {
        f.Iyx.idkeyStat(941L, 13L, 1L, true);
      }
    }
  }
  
  public static int transport2MMKV(SharedPreferences paramSharedPreferences, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(156253);
    if ((paramSharedPreferences == null) || (paramMultiProcessMMKV == null))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    String str = paramMultiProcessMMKV.getName();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    MultiProcessMMKV localMultiProcessMMKV = getPerservedMMKV();
    Log.i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", new Object[] { str });
    try
    {
      bool = localMultiProcessMMKV.decodeBool(str, false);
      if (bool)
      {
        Log.i("MicroMsg.MultiProcessMMKV", "%s transport2MMKV has Done, return", new Object[] { str });
        AppMethodBeat.o(156253);
        return 0;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        boolean bool = localMultiProcessMMKV.decodeBool(str, false);
      }
      localMultiProcessMMKV.encode(str, true);
      int i = transport2MMKVByForce(paramSharedPreferences, paramMultiProcessMMKV);
      AppMethodBeat.o(156253);
      return i;
    }
  }
  
  public static int transport2MMKVByForce(SharedPreferences paramSharedPreferences, MultiProcessMMKV paramMultiProcessMMKV)
  {
    AppMethodBeat.i(263448);
    f.Iyx.idkeyStat(941L, 2L, 1L, true);
    int i = paramMultiProcessMMKV.importFromSharedPreferences(paramSharedPreferences);
    AppMethodBeat.o(263448);
    return i;
  }
  
  public String[] allKeys()
  {
    AppMethodBeat.i(156286);
    checkReopen(getName());
    try
    {
      String[] arrayOfString1 = this.mmkv.allKeys();
      AppMethodBeat.o(156286);
      return arrayOfString1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        String[] arrayOfString2 = this.mmkv.allKeys();
      }
    }
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(156301);
    checkReopen(getName());
    try
    {
      this.mmkv.clear();
      AppMethodBeat.o(156301);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.clear();
      }
    }
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(156284);
    checkReopen(getName());
    try
    {
      this.mmkv.clearAll();
      AppMethodBeat.o(156284);
      return;
    }
    catch (Throwable localThrowable)
    {
      ensureSoLoaded();
      this.mmkv.clearAll();
      AppMethodBeat.o(156284);
    }
  }
  
  public void clearMemoryCache()
  {
    AppMethodBeat.i(263486);
    checkReopen(getName());
    this.mmkv.clearMemoryCache();
    AppMethodBeat.o(263486);
  }
  
  public boolean commit()
  {
    return true;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(156293);
    checkReopen(getName());
    try
    {
      bool = this.mmkv.contains(paramString);
      AppMethodBeat.o(156293);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        boolean bool = this.mmkv.contains(paramString);
      }
    }
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(156281);
    checkReopen(getName());
    boolean bool = this.mmkv.containsKey(paramString);
    AppMethodBeat.o(156281);
    return bool;
  }
  
  public long count()
  {
    AppMethodBeat.i(263484);
    checkReopen(getName());
    long l = this.mmkv.count();
    AppMethodBeat.o(263484);
    return l;
  }
  
  public boolean decodeBool(String paramString)
  {
    AppMethodBeat.i(263478);
    checkReopen(getName());
    boolean bool = this.mmkv.decodeBool(paramString);
    AppMethodBeat.o(263478);
    return bool;
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156277);
    checkReopen(getName());
    paramBoolean = this.mmkv.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(156277);
    return paramBoolean;
  }
  
  public byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(156279);
    checkReopen(getName());
    paramString = this.mmkv.decodeBytes(paramString);
    AppMethodBeat.o(156279);
    return paramString;
  }
  
  public double decodeDouble(String paramString)
  {
    AppMethodBeat.i(263476);
    checkReopen(getName());
    double d = this.mmkv.decodeDouble(paramString);
    AppMethodBeat.o(263476);
    return d;
  }
  
  public double decodeDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(263477);
    checkReopen(getName());
    paramDouble = this.mmkv.decodeDouble(paramString, paramDouble);
    AppMethodBeat.o(263477);
    return paramDouble;
  }
  
  public float decodeFloat(String paramString)
  {
    AppMethodBeat.i(263474);
    checkReopen(getName());
    float f = this.mmkv.decodeFloat(paramString);
    AppMethodBeat.o(263474);
    return f;
  }
  
  public float decodeFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(263475);
    checkReopen(getName());
    paramFloat = this.mmkv.decodeFloat(paramString, paramFloat);
    AppMethodBeat.o(263475);
    return paramFloat;
  }
  
  public int decodeInt(String paramString)
  {
    AppMethodBeat.i(156272);
    checkReopen(getName());
    int i = this.mmkv.decodeInt(paramString);
    AppMethodBeat.o(156272);
    return i;
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156273);
    checkReopen(getName());
    paramInt = this.mmkv.decodeInt(paramString, paramInt);
    AppMethodBeat.o(156273);
    return paramInt;
  }
  
  public long decodeLong(String paramString)
  {
    AppMethodBeat.i(156274);
    checkReopen(getName());
    long l = this.mmkv.decodeLong(paramString);
    AppMethodBeat.o(156274);
    return l;
  }
  
  public long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156275);
    checkReopen(getName());
    paramLong = this.mmkv.decodeLong(paramString, paramLong);
    AppMethodBeat.o(156275);
    return paramLong;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(156280);
    checkReopen(getName());
    paramString = this.mmkv.decodeParcelable(paramString, paramClass);
    AppMethodBeat.o(156280);
    return paramString;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(263482);
    checkReopen(getName());
    paramString = this.mmkv.decodeParcelable(paramString, paramClass, paramT);
    AppMethodBeat.o(263482);
    return paramString;
  }
  
  public String decodeString(String paramString)
  {
    AppMethodBeat.i(156270);
    checkReopen(getName());
    try
    {
      String str = this.mmkv.decodeString(paramString);
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramString = this.mmkv.decodeString(paramString);
      }
    }
    AppMethodBeat.o(156270);
    return paramString;
  }
  
  public String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156271);
    checkReopen(getName());
    paramString1 = this.mmkv.decodeString(paramString1, paramString2);
    AppMethodBeat.o(156271);
    return paramString1;
  }
  
  public Set<String> decodeStringSet(String paramString)
  {
    AppMethodBeat.i(263479);
    checkReopen(getName());
    paramString = this.mmkv.decodeStringSet(paramString);
    AppMethodBeat.o(263479);
    return paramString;
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156278);
    checkReopen(getName());
    paramString = this.mmkv.decodeStringSet(paramString, paramSet);
    AppMethodBeat.o(156278);
    return paramString;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public boolean encode(String paramString, double paramDouble)
  {
    AppMethodBeat.i(263470);
    if (!isLegal(paramString, Double.valueOf(paramDouble)))
    {
      AppMethodBeat.o(263470);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramDouble);
    AppMethodBeat.o(263470);
    return bool;
  }
  
  public boolean encode(String paramString, float paramFloat)
  {
    AppMethodBeat.i(263469);
    if (!isLegal(paramString, Float.valueOf(paramFloat)))
    {
      AppMethodBeat.o(263469);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramFloat);
    AppMethodBeat.o(263469);
    return bool;
  }
  
  public boolean encode(String paramString, int paramInt)
  {
    AppMethodBeat.i(156263);
    if (!isLegal(paramString, Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(156263);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramInt);
    AppMethodBeat.o(156263);
    return bool;
  }
  
  public boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(156264);
    if (!isLegal(paramString, Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(156264);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramLong);
    AppMethodBeat.o(156264);
    return bool;
  }
  
  public boolean encode(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(156268);
    if (!isLegal(paramString, paramParcelable))
    {
      AppMethodBeat.o(156268);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramParcelable);
    AppMethodBeat.o(156268);
    return bool;
  }
  
  public boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156262);
    if (!isLegal(paramString1, paramString2))
    {
      AppMethodBeat.o(156262);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString1, paramString2);
    AppMethodBeat.o(156262);
    return bool;
  }
  
  public boolean encode(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156266);
    if (!isLegal(paramString, paramSet))
    {
      AppMethodBeat.o(156266);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramSet);
    AppMethodBeat.o(156266);
    return bool;
  }
  
  public boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156265);
    if (!isLegal(paramString, Boolean.valueOf(paramBoolean)))
    {
      AppMethodBeat.o(156265);
      return false;
    }
    try
    {
      boolean bool = this.mmkv.encode(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramBoolean = this.mmkv.encode(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(156265);
    return paramBoolean;
  }
  
  public boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156267);
    if (!isLegal(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(156267);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(156267);
    return bool;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(182044);
    close();
    super.finalize();
    AppMethodBeat.o(182044);
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(156285);
    checkReopen(getName());
    Map localMap = this.mmkv.getAll();
    AppMethodBeat.o(156285);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156292);
    checkReopen(getName());
    try
    {
      boolean bool = this.mmkv.getBoolean(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramBoolean = this.mmkv.getBoolean(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(156292);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156291);
    checkReopen(getName());
    try
    {
      float f = this.mmkv.getFloat(paramString, paramFloat);
      paramFloat = f;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramFloat = this.mmkv.getFloat(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(156291);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156289);
    checkReopen(getName());
    try
    {
      int i = this.mmkv.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramInt = this.mmkv.getInt(paramString, paramInt);
      }
    }
    AppMethodBeat.o(156289);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156290);
    checkReopen(getName());
    try
    {
      long l = this.mmkv.getLong(paramString, paramLong);
      paramLong = l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramLong = this.mmkv.getLong(paramString, paramLong);
      }
    }
    AppMethodBeat.o(156290);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156287);
    checkReopen(getName());
    try
    {
      String str = this.mmkv.getString(paramString1, paramString2);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramString1 = this.mmkv.getString(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(156287);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156288);
    checkReopen(getName());
    try
    {
      Set localSet = this.mmkv.getStringSet(paramString, paramSet);
      paramString = localSet;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        paramString = this.mmkv.getStringSet(paramString, paramSet);
      }
    }
    AppMethodBeat.o(156288);
    return paramString;
  }
  
  public int getValueActualSize(String paramString)
  {
    AppMethodBeat.i(263467);
    int i = this.mmkv.getValueActualSize(paramString);
    AppMethodBeat.o(263467);
    return i;
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(156269);
    checkReopen(getName());
    try
    {
      i = this.mmkv.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(156269);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        int i = this.mmkv.importFromSharedPreferences(paramSharedPreferences);
      }
    }
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156299);
    if (!isLegal(paramString, Boolean.valueOf(paramBoolean)))
    {
      paramString = edit();
      AppMethodBeat.o(156299);
      return paramString;
    }
    try
    {
      this.mmkv.putBoolean(paramString, paramBoolean);
      AppMethodBeat.o(156299);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putBoolean(paramString, paramBoolean);
      }
    }
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156298);
    if (!isLegal(paramString, Float.valueOf(paramFloat)))
    {
      paramString = edit();
      AppMethodBeat.o(156298);
      return paramString;
    }
    try
    {
      this.mmkv.putFloat(paramString, paramFloat);
      AppMethodBeat.o(156298);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putFloat(paramString, paramFloat);
      }
    }
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156296);
    if (!isLegal(paramString, Integer.valueOf(paramInt)))
    {
      paramString = edit();
      AppMethodBeat.o(156296);
      return paramString;
    }
    try
    {
      this.mmkv.putInt(paramString, paramInt);
      AppMethodBeat.o(156296);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putInt(paramString, paramInt);
      }
    }
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156297);
    if (!isLegal(paramString, Long.valueOf(paramLong)))
    {
      paramString = edit();
      AppMethodBeat.o(156297);
      return paramString;
    }
    try
    {
      this.mmkv.putLong(paramString, paramLong);
      AppMethodBeat.o(156297);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putLong(paramString, paramLong);
      }
    }
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156294);
    if (!isLegal(paramString1, paramString2))
    {
      paramString1 = edit();
      AppMethodBeat.o(156294);
      return paramString1;
    }
    try
    {
      this.mmkv.putString(paramString1, paramString2);
      AppMethodBeat.o(156294);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putString(paramString1, paramString2);
      }
    }
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156295);
    if (!isLegal(paramString, paramSet))
    {
      paramString = edit();
      AppMethodBeat.o(156295);
      return paramString;
    }
    try
    {
      this.mmkv.putStringSet(paramString, paramSet);
      AppMethodBeat.o(156295);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.putStringSet(paramString, paramSet);
      }
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(156300);
    checkReopen(getName());
    try
    {
      this.mmkv.remove(paramString);
      AppMethodBeat.o(156300);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ensureSoLoaded();
        this.mmkv.remove(paramString);
      }
    }
  }
  
  public void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(156282);
    checkReopen(getName());
    this.mmkv.removeValueForKey(paramString);
    AppMethodBeat.o(156282);
  }
  
  public void removeValuesForKeys(String[] paramArrayOfString)
  {
    AppMethodBeat.i(263483);
    checkReopen(getName());
    this.mmkv.removeValuesForKeys(paramArrayOfString);
    AppMethodBeat.o(263483);
  }
  
  public long totalSize()
  {
    AppMethodBeat.i(186112);
    checkReopen(getName());
    long l = this.mmkv.totalSize();
    AppMethodBeat.o(186112);
    return l;
  }
  
  public void trim()
  {
    AppMethodBeat.i(263487);
    checkReopen(getName());
    this.mmkv.trim();
    AppMethodBeat.o(263487);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public int writeValueToNativeBuffer(String paramString, MultiProcessMMKV.NativeBuffer paramNativeBuffer)
  {
    AppMethodBeat.i(263473);
    checkReopen(getName());
    paramNativeBuffer = new e(paramNativeBuffer.pointer, paramNativeBuffer.size);
    int i = this.mmkv.writeValueToNativeBuffer(paramString, paramNativeBuffer);
    AppMethodBeat.o(263473);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessMMKV
 * JD-Core Version:    0.7.0.1
 */