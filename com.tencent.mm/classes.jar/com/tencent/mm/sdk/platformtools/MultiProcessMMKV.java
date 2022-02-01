package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.a;
import com.tencent.mmkv.b;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;
import java.util.Map;
import java.util.Set;

public class MultiProcessMMKV
  implements SharedPreferences, SharedPreferences.Editor
{
  private static final String DEFAULT_MULTI_NAME = "MULTIPROCESSMMKV_MULTI_DEFAULT";
  private static final String DEFAULT_SINGLE_NAME = "MULTIPROCESSMMKV_SINGLE_DEFAULT";
  private static final int IDKEY_MMKV = 941;
  private static final int KVID_MMKV = 18378;
  public static final int MULTI_PROCESS_MODE = 2;
  private static final String PERSERVED_NAME = "MULTIPROCESSMMKV_PERSERVED_NAME";
  public static final int SINGLE_PROCESS_MODE = 1;
  private static final String TAG = "MicroMsg.MultiProcessMMKV";
  private static ArrayMap<String, MultiProcessMMKV> mmkvCache;
  private MMKV mmkv;
  private String name;
  
  static
  {
    AppMethodBeat.i(156304);
    MMKV.class.getClassLoader();
    j.Ed("mmkv");
    MMKV.initialize(MMApplicationContext.getContext());
    mmkvCache = new ArrayMap();
    MMKV.registerHandler(new a()
    {
      public final void mmkvLog(b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(215398);
        Log.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, paramAnonymousString3 });
        AppMethodBeat.o(215398);
      }
      
      public final c onMMKVCRCCheckFail(String paramAnonymousString)
      {
        AppMethodBeat.i(156250);
        Log.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramAnonymousString });
        e.Cxv.idkeyStat(941L, 3L, 1L, true);
        paramAnonymousString = c.RzD;
        AppMethodBeat.o(156250);
        return paramAnonymousString;
      }
      
      public final c onMMKVFileLengthError(String paramAnonymousString)
      {
        AppMethodBeat.i(156251);
        Log.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramAnonymousString });
        e.Cxv.idkeyStat(941L, 4L, 1L, true);
        paramAnonymousString = c.RzD;
        AppMethodBeat.o(156251);
        return paramAnonymousString;
      }
      
      public final boolean wantLogRedirecting()
      {
        return true;
      }
    });
    AppMethodBeat.o(156304);
  }
  
  private MultiProcessMMKV(String paramString)
  {
    this.name = paramString;
  }
  
  private MultiProcessMMKV(String paramString, MMKV paramMMKV)
  {
    this.mmkv = paramMMKV;
    this.name = paramString;
  }
  
  public static NativeBuffer createNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(215412);
    Object localObject = MMKV.createNativeBuffer(paramInt);
    localObject = new NativeBuffer(((d)localObject).pointer, ((d)localObject).size);
    AppMethodBeat.o(215412);
    return localObject;
  }
  
  public static void destroyNativeBuffer(NativeBuffer paramNativeBuffer)
  {
    AppMethodBeat.i(215413);
    MMKV.destroyNativeBuffer(new d(paramNativeBuffer.pointer, paramNativeBuffer.size));
    AppMethodBeat.o(215413);
  }
  
  private static void ensureSoLoaded()
  {
    AppMethodBeat.i(156303);
    MMKV.class.getClassLoader();
    j.Ed("mmkv");
    AppMethodBeat.o(156303);
  }
  
  private MMKV getCoreMMKV()
  {
    return this.mmkv;
  }
  
  public static MultiProcessMMKV getCryptMMKV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215400);
    paramString1 = getCryptMMKVReal(paramString1, 2, paramString2);
    AppMethodBeat.o(215400);
    return paramString1;
  }
  
  public static MultiProcessMMKV getCryptMMKVReal(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(215402);
    paramString1 = new MultiProcessMMKV(paramString1, MMKV.mmkvWithID(paramString1, paramInt, paramString2));
    AppMethodBeat.o(215402);
    return paramString1;
  }
  
  public static MultiProcessMMKV getDefault()
  {
    AppMethodBeat.i(215403);
    MultiProcessMMKV localMultiProcessMMKV = getMMKV("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.defaultMMKV());
    AppMethodBeat.o(215403);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getDefault(int paramInt, String paramString)
  {
    AppMethodBeat.i(215404);
    paramString = MMKV.defaultMMKV(paramInt, paramString);
    if (paramInt == 2)
    {
      paramString = getMMKV("MULTIPROCESSMMKV_MULTI_DEFAULT", paramInt, paramString);
      AppMethodBeat.o(215404);
      return paramString;
    }
    paramString = getMMKV("MULTIPROCESSMMKV_SINGLE_DEFAULT", paramInt, paramString);
    AppMethodBeat.o(215404);
    return paramString;
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
    try
    {
      localMultiProcessMMKV = (MultiProcessMMKV)mmkvCache.get(paramString);
      if (localMultiProcessMMKV == null)
      {
        if (paramMMKV == null) {}
        for (paramMMKV = new MultiProcessMMKV(paramString, MMKV.mmkvWithID(paramString, paramInt));; paramMMKV = new MultiProcessMMKV(paramString, paramMMKV))
        {
          long l = paramMMKV.totalSize();
          if (l > 1048576L)
          {
            Log.e("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, size : %d, please contact with leafjia", new Object[] { paramString, Long.valueOf(l) });
            reportTotalSize(l, paramString);
            if (l > 5242880L)
            {
              e.Cxv.idkeyStat(941L, 100L, 1L, true);
              Log.i("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", new Object[] { Long.valueOf(l) });
              paramMMKV.trim();
              Log.i("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", new Object[] { Long.valueOf(paramMMKV.totalSize()) });
            }
          }
          mmkvCache.put(paramString, paramMMKV);
          return paramMMKV;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(156260);
    }
    AppMethodBeat.o(156260);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getMMKVWithAshmemFD(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(215405);
    paramContext = getMMKV(paramString1, paramInt2, MMKV.mmkvWithAshmemID(paramContext, paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(215405);
    return paramContext;
  }
  
  public static MultiProcessMMKV getMMKVWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(215406);
    paramString1 = getMMKV(paramString1, -1, MMKV.mmkvWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
    AppMethodBeat.o(215406);
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
  
  public static MultiProcessMMKV getMultiDefault()
  {
    AppMethodBeat.i(156256);
    MultiProcessMMKV localMultiProcessMMKV = getMMKV("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.defaultMMKV(2, null));
    AppMethodBeat.o(156256);
    return localMultiProcessMMKV;
  }
  
  private String getName()
  {
    return this.name;
  }
  
  private static MultiProcessMMKV getPerservedMMKV()
  {
    AppMethodBeat.i(215407);
    MultiProcessMMKV localMultiProcessMMKV = getMMKVReal("MULTIPROCESSMMKV_PERSERVED_NAME", 2, null);
    AppMethodBeat.o(215407);
    return localMultiProcessMMKV;
  }
  
  public static MultiProcessMMKV getSingleCryptMMKV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215401);
    paramString1 = getCryptMMKVReal(paramString1, 1, paramString2);
    AppMethodBeat.o(215401);
    return paramString1;
  }
  
  public static MultiProcessMMKV getSingleDefault()
  {
    AppMethodBeat.i(156255);
    MultiProcessMMKV localMultiProcessMMKV = getMMKV("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.defaultMMKV());
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
  
  private boolean isLegal(String paramString, Object paramObject)
  {
    AppMethodBeat.i(156302);
    if ((Util.isNullOrNil(paramString)) || (paramObject == null) || (Util.isNullOrNil(getName())))
    {
      AppMethodBeat.o(156302);
      return false;
    }
    AppMethodBeat.o(156302);
    return true;
  }
  
  private static void reportTotalSize(long paramLong, String paramString)
  {
    AppMethodBeat.i(215408);
    if (paramLong <= 5242880L) {
      e.Cxv.idkeyStat(941L, 10L, 1L, true);
    }
    for (;;)
    {
      e.Cxv.a(18378, new Object[] { paramString, Long.valueOf(paramLong) });
      AppMethodBeat.o(215408);
      return;
      if (paramLong <= 10485760L) {
        e.Cxv.idkeyStat(941L, 11L, 1L, true);
      } else if (paramLong <= 104857600L) {
        e.Cxv.idkeyStat(941L, 12L, 1L, true);
      } else {
        e.Cxv.idkeyStat(941L, 13L, 1L, true);
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
        Log.i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
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
    AppMethodBeat.i(215399);
    e.Cxv.idkeyStat(941L, 2L, 1L, true);
    int i = paramMultiProcessMMKV.importFromSharedPreferences(paramSharedPreferences);
    AppMethodBeat.o(215399);
    return i;
  }
  
  public String[] allKeys()
  {
    AppMethodBeat.i(156286);
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
  
  public int ashmemFD()
  {
    AppMethodBeat.i(215428);
    int i = this.mmkv.ashmemFD();
    AppMethodBeat.o(215428);
    return i;
  }
  
  public int ashmemMetaFD()
  {
    AppMethodBeat.i(215429);
    int i = this.mmkv.ashmemMetaFD();
    AppMethodBeat.o(215429);
    return i;
  }
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(156301);
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
    AppMethodBeat.i(215425);
    this.mmkv.clearMemoryCache();
    AppMethodBeat.o(215425);
  }
  
  public void close()
  {
    AppMethodBeat.i(215424);
    this.mmkv.close();
    AppMethodBeat.o(215424);
  }
  
  public boolean commit()
  {
    return true;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(156293);
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
    boolean bool = this.mmkv.containsKey(paramString);
    AppMethodBeat.o(156281);
    return bool;
  }
  
  public long count()
  {
    AppMethodBeat.i(215423);
    long l = this.mmkv.count();
    AppMethodBeat.o(215423);
    return l;
  }
  
  public boolean decodeBool(String paramString)
  {
    AppMethodBeat.i(215419);
    boolean bool = this.mmkv.decodeBool(paramString);
    AppMethodBeat.o(215419);
    return bool;
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156277);
    paramBoolean = this.mmkv.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(156277);
    return paramBoolean;
  }
  
  public byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(156279);
    paramString = this.mmkv.decodeBytes(paramString);
    AppMethodBeat.o(156279);
    return paramString;
  }
  
  public double decodeDouble(String paramString)
  {
    AppMethodBeat.i(215417);
    double d = this.mmkv.decodeDouble(paramString);
    AppMethodBeat.o(215417);
    return d;
  }
  
  public double decodeDouble(String paramString, double paramDouble)
  {
    AppMethodBeat.i(215418);
    paramDouble = this.mmkv.decodeDouble(paramString, paramDouble);
    AppMethodBeat.o(215418);
    return paramDouble;
  }
  
  public float decodeFloat(String paramString)
  {
    AppMethodBeat.i(215415);
    float f = this.mmkv.decodeFloat(paramString);
    AppMethodBeat.o(215415);
    return f;
  }
  
  public float decodeFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(215416);
    paramFloat = this.mmkv.decodeFloat(paramString, paramFloat);
    AppMethodBeat.o(215416);
    return paramFloat;
  }
  
  public int decodeInt(String paramString)
  {
    AppMethodBeat.i(156272);
    int i = this.mmkv.decodeInt(paramString);
    AppMethodBeat.o(156272);
    return i;
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156273);
    paramInt = this.mmkv.decodeInt(paramString, paramInt);
    AppMethodBeat.o(156273);
    return paramInt;
  }
  
  public long decodeLong(String paramString)
  {
    AppMethodBeat.i(156274);
    long l = this.mmkv.decodeLong(paramString);
    AppMethodBeat.o(156274);
    return l;
  }
  
  public long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156275);
    paramLong = this.mmkv.decodeLong(paramString, paramLong);
    AppMethodBeat.o(156275);
    return paramLong;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(156280);
    paramString = this.mmkv.decodeParcelable(paramString, paramClass);
    AppMethodBeat.o(156280);
    return paramString;
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass, T paramT)
  {
    AppMethodBeat.i(215421);
    paramString = this.mmkv.decodeParcelable(paramString, paramClass, paramT);
    AppMethodBeat.o(215421);
    return paramString;
  }
  
  public String decodeString(String paramString)
  {
    AppMethodBeat.i(156270);
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
    paramString1 = this.mmkv.decodeString(paramString1, paramString2);
    AppMethodBeat.o(156271);
    return paramString1;
  }
  
  public Set<String> decodeStringSet(String paramString)
  {
    AppMethodBeat.i(215420);
    paramString = this.mmkv.decodeStringSet(paramString);
    AppMethodBeat.o(215420);
    return paramString;
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156278);
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
    AppMethodBeat.i(215411);
    if (!isLegal(paramString, Double.valueOf(paramDouble)))
    {
      AppMethodBeat.o(215411);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramDouble);
    AppMethodBeat.o(215411);
    return bool;
  }
  
  public boolean encode(String paramString, float paramFloat)
  {
    AppMethodBeat.i(215410);
    if (!isLegal(paramString, Float.valueOf(paramFloat)))
    {
      AppMethodBeat.o(215410);
      return false;
    }
    boolean bool = this.mmkv.encode(paramString, paramFloat);
    AppMethodBeat.o(215410);
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
    Map localMap = this.mmkv.getAll();
    AppMethodBeat.o(156285);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156292);
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
    AppMethodBeat.i(215409);
    int i = this.mmkv.getValueActualSize(paramString);
    AppMethodBeat.o(215409);
    return i;
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(156269);
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
  
  public String mmapID()
  {
    AppMethodBeat.i(215427);
    String str = this.mmkv.mmapID();
    AppMethodBeat.o(215427);
    return str;
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
    this.mmkv.removeValueForKey(paramString);
    AppMethodBeat.o(156282);
  }
  
  public void removeValuesForKeys(String[] paramArrayOfString)
  {
    AppMethodBeat.i(215422);
    this.mmkv.removeValuesForKeys(paramArrayOfString);
    AppMethodBeat.o(215422);
  }
  
  public long totalSize()
  {
    AppMethodBeat.i(186112);
    long l = this.mmkv.totalSize();
    AppMethodBeat.o(186112);
    return l;
  }
  
  public void trim()
  {
    AppMethodBeat.i(215426);
    this.mmkv.trim();
    AppMethodBeat.o(215426);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public int writeValueToNativeBuffer(String paramString, NativeBuffer paramNativeBuffer)
  {
    AppMethodBeat.i(215414);
    paramNativeBuffer = new d(paramNativeBuffer.pointer, paramNativeBuffer.size);
    int i = this.mmkv.writeValueToNativeBuffer(paramString, paramNativeBuffer);
    AppMethodBeat.o(215414);
    return i;
  }
  
  public static final class NativeBuffer
  {
    public long pointer;
    public int size;
    
    public NativeBuffer(long paramLong, int paramInt)
    {
      this.pointer = paramLong;
      this.size = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessMMKV
 * JD-Core Version:    0.7.0.1
 */