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
import com.tencent.mmkv.c;
import java.util.Map;
import java.util.Set;

public class ay
  implements SharedPreferences, SharedPreferences.Editor
{
  private static ArrayMap<String, ay> IyT;
  public MMKV IyS;
  private String name;
  
  static
  {
    AppMethodBeat.i(156304);
    MMKV.class.getClassLoader();
    j.vN("mmkv");
    MMKV.initialize(ak.getContext());
    IyT = new ArrayMap();
    MMKV.registerHandler(new a()
    {
      public final c aSa(String paramAnonymousString)
      {
        AppMethodBeat.i(156250);
        ae.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramAnonymousString });
        e.ywz.idkeyStat(941L, 3L, 1L, true);
        paramAnonymousString = c.LZl;
        AppMethodBeat.o(156250);
        return paramAnonymousString;
      }
      
      public final c aSb(String paramAnonymousString)
      {
        AppMethodBeat.i(156251);
        ae.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramAnonymousString });
        e.ywz.idkeyStat(941L, 4L, 1L, true);
        paramAnonymousString = c.LZl;
        AppMethodBeat.o(156251);
        return paramAnonymousString;
      }
      
      public final void l(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(156252);
        ae.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, paramAnonymousString3 });
        AppMethodBeat.o(156252);
      }
    });
    AppMethodBeat.o(156304);
  }
  
  private ay(String paramString, MMKV paramMMKV)
  {
    this.IyS = paramMMKV;
    this.name = paramString;
  }
  
  public static int a(SharedPreferences paramSharedPreferences, ay paramay)
  {
    AppMethodBeat.i(156253);
    if ((paramSharedPreferences == null) || (paramay == null))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    String str = paramay.name;
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    ay localay = b("MULTIPROCESSMMKV_PERSERVED_NAME", 2, null);
    ae.i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", new Object[] { str });
    try
    {
      bool = localay.decodeBool(str, false);
      if (bool)
      {
        ae.i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
        AppMethodBeat.o(156253);
        return 0;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        boolean bool = localay.decodeBool(str, false);
      }
      localay.encode(str, true);
      e.ywz.idkeyStat(941L, 2L, 1L, true);
      int i = paramay.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(156253);
      return i;
    }
  }
  
  private static ay a(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156259);
    if ((bu.isNullOrNil(paramString)) || (bu.lX(paramString, "MULTIPROCESSMMKV_PERSERVED_NAME")))
    {
      ae.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
      AppMethodBeat.o(156259);
      return null;
    }
    paramString = b(paramString, paramInt, paramMMKV);
    AppMethodBeat.o(156259);
    return paramString;
  }
  
  public static ay aRW(String paramString)
  {
    AppMethodBeat.i(156254);
    paramString = a(paramString, 2, null);
    AppMethodBeat.o(156254);
    return paramString;
  }
  
  public static ay aRX(String paramString)
  {
    AppMethodBeat.i(156257);
    paramString = a(paramString, 1, null);
    AppMethodBeat.o(156257);
    return paramString;
  }
  
  public static ay aRY(String paramString)
  {
    AppMethodBeat.i(156261);
    ay localay = a(paramString, 2, null);
    a(ak.getContext().getSharedPreferences(paramString, 4), localay);
    AppMethodBeat.o(156261);
    return localay;
  }
  
  private static ay b(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156260);
    ay localay;
    for (;;)
    {
      long l;
      try
      {
        localay = (ay)IyT.get(paramString);
        if (localay != null) {
          break;
        }
        if (paramMMKV == null)
        {
          paramMMKV = new ay(paramString, MMKV.mmkvWithID(paramString, paramInt));
          l = paramMMKV.IyS.totalSize();
          if (l > 1048576L)
          {
            ae.e("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, size : %d, please contact with leafjia", new Object[] { paramString, Long.valueOf(l) });
            if (l > 5242880L) {
              break label241;
            }
            e.ywz.idkeyStat(941L, 10L, 1L, true);
            e.ywz.f(18378, new Object[] { paramString, Long.valueOf(l) });
            if (l > 5242880L)
            {
              e.ywz.idkeyStat(941L, 100L, 1L, true);
              ae.i("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", new Object[] { Long.valueOf(l) });
              paramMMKV.IyS.trim();
              ae.i("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", new Object[] { Long.valueOf(paramMMKV.IyS.totalSize()) });
            }
          }
          IyT.put(paramString, paramMMKV);
          return paramMMKV;
        }
        else
        {
          paramMMKV = new ay(paramString, paramMMKV);
          continue;
        }
        if (l > 10485760L) {
          break label266;
        }
      }
      finally
      {
        AppMethodBeat.o(156260);
      }
      label241:
      e.ywz.idkeyStat(941L, 11L, 1L, true);
      continue;
      label266:
      if (l <= 104857600L) {
        e.ywz.idkeyStat(941L, 12L, 1L, true);
      } else {
        e.ywz.idkeyStat(941L, 13L, 1L, true);
      }
    }
    AppMethodBeat.o(156260);
    return localay;
  }
  
  public static ay fpa()
  {
    AppMethodBeat.i(196741);
    ay localay = a("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.defaultMMKV());
    AppMethodBeat.o(196741);
    return localay;
  }
  
  public static ay fpb()
  {
    AppMethodBeat.i(156255);
    ay localay = a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.defaultMMKV());
    AppMethodBeat.o(156255);
    return localay;
  }
  
  public static ay fpc()
  {
    AppMethodBeat.i(156256);
    ay localay = a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.defaultMMKV(2, null));
    AppMethodBeat.o(156256);
    return localay;
  }
  
  private static void fpd()
  {
    AppMethodBeat.i(156303);
    MMKV.class.getClassLoader();
    j.vN("mmkv");
    AppMethodBeat.o(156303);
  }
  
  public static ay gq(String paramString, int paramInt)
  {
    AppMethodBeat.i(156258);
    paramString = a(paramString, paramInt, null);
    AppMethodBeat.o(156258);
    return paramString;
  }
  
  private int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(156269);
    try
    {
      i = this.IyS.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(156269);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        int i = this.IyS.importFromSharedPreferences(paramSharedPreferences);
      }
    }
  }
  
  public static void init() {}
  
  public final double aRZ(String paramString)
  {
    AppMethodBeat.i(156276);
    double d = this.IyS.decodeDouble(paramString, 1.0D);
    AppMethodBeat.o(156276);
    return d;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(156286);
    try
    {
      String[] arrayOfString1 = this.IyS.allKeys();
      AppMethodBeat.o(156286);
      return arrayOfString1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        String[] arrayOfString2 = this.IyS.allKeys();
      }
    }
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(156301);
    try
    {
      this.IyS.clear();
      AppMethodBeat.o(156301);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.clear();
      }
    }
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(156284);
    try
    {
      this.IyS.clearAll();
      AppMethodBeat.o(156284);
      return;
    }
    catch (Throwable localThrowable)
    {
      fpd();
      this.IyS.clearAll();
      AppMethodBeat.o(156284);
    }
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
      bool = this.IyS.contains(paramString);
      AppMethodBeat.o(156293);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        boolean bool = this.IyS.contains(paramString);
      }
    }
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(156281);
    boolean bool = this.IyS.containsKey(paramString);
    AppMethodBeat.o(156281);
    return bool;
  }
  
  public final long count()
  {
    AppMethodBeat.i(196743);
    long l = this.IyS.count();
    AppMethodBeat.o(196743);
    return l;
  }
  
  public final boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156277);
    paramBoolean = this.IyS.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(156277);
    return paramBoolean;
  }
  
  public final byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(156279);
    paramString = this.IyS.decodeBytes(paramString);
    AppMethodBeat.o(156279);
    return paramString;
  }
  
  public final int decodeInt(String paramString)
  {
    AppMethodBeat.i(156272);
    int i = this.IyS.decodeInt(paramString);
    AppMethodBeat.o(156272);
    return i;
  }
  
  public final int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156273);
    paramInt = this.IyS.decodeInt(paramString, paramInt);
    AppMethodBeat.o(156273);
    return paramInt;
  }
  
  public final long decodeLong(String paramString)
  {
    AppMethodBeat.i(156274);
    long l = this.IyS.decodeLong(paramString);
    AppMethodBeat.o(156274);
    return l;
  }
  
  public final long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156275);
    paramLong = this.IyS.decodeLong(paramString, paramLong);
    AppMethodBeat.o(156275);
    return paramLong;
  }
  
  public final <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(156280);
    paramString = this.IyS.decodeParcelable(paramString, paramClass);
    AppMethodBeat.o(156280);
    return paramString;
  }
  
  public final String decodeString(String paramString)
  {
    AppMethodBeat.i(156270);
    try
    {
      String str = this.IyS.decodeString(paramString);
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramString = this.IyS.decodeString(paramString);
      }
    }
    AppMethodBeat.o(156270);
    return paramString;
  }
  
  public final String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156271);
    paramString1 = this.IyS.decodeString(paramString1, paramString2);
    AppMethodBeat.o(156271);
    return paramString1;
  }
  
  public final Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156278);
    paramString = this.IyS.decodeStringSet(paramString, paramSet);
    AppMethodBeat.o(156278);
    return paramString;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public final boolean encode(String paramString, int paramInt)
  {
    AppMethodBeat.i(156263);
    if (!y(paramString, Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(156263);
      return false;
    }
    boolean bool = this.IyS.encode(paramString, paramInt);
    AppMethodBeat.o(156263);
    return bool;
  }
  
  public final boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(156264);
    if (!y(paramString, Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(156264);
      return false;
    }
    boolean bool = this.IyS.encode(paramString, paramLong);
    AppMethodBeat.o(156264);
    return bool;
  }
  
  public final boolean encode(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(156268);
    if (!y(paramString, paramParcelable))
    {
      AppMethodBeat.o(156268);
      return false;
    }
    boolean bool = this.IyS.encode(paramString, paramParcelable);
    AppMethodBeat.o(156268);
    return bool;
  }
  
  public final boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156262);
    if (!y(paramString1, paramString2))
    {
      AppMethodBeat.o(156262);
      return false;
    }
    boolean bool = this.IyS.encode(paramString1, paramString2);
    AppMethodBeat.o(156262);
    return bool;
  }
  
  public final boolean encode(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156266);
    if (!y(paramString, paramSet))
    {
      AppMethodBeat.o(156266);
      return false;
    }
    boolean bool = this.IyS.encode(paramString, paramSet);
    AppMethodBeat.o(156266);
    return bool;
  }
  
  public final boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156265);
    if (!y(paramString, Boolean.valueOf(paramBoolean)))
    {
      AppMethodBeat.o(156265);
      return false;
    }
    try
    {
      boolean bool = this.IyS.encode(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramBoolean = this.IyS.encode(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(156265);
    return paramBoolean;
  }
  
  public final boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156267);
    if (!y(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(156267);
      return false;
    }
    boolean bool = this.IyS.encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(156267);
    return bool;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(182044);
    this.IyS.close();
    super.finalize();
    AppMethodBeat.o(182044);
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(156285);
    Map localMap = this.IyS.getAll();
    AppMethodBeat.o(156285);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156292);
    try
    {
      boolean bool = this.IyS.getBoolean(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramBoolean = this.IyS.getBoolean(paramString, paramBoolean);
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
      float f = this.IyS.getFloat(paramString, paramFloat);
      paramFloat = f;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramFloat = this.IyS.getFloat(paramString, paramFloat);
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
      int i = this.IyS.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramInt = this.IyS.getInt(paramString, paramInt);
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
      long l = this.IyS.getLong(paramString, paramLong);
      paramLong = l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramLong = this.IyS.getLong(paramString, paramLong);
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
      String str = this.IyS.getString(paramString1, paramString2);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramString1 = this.IyS.getString(paramString1, paramString2);
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
      Set localSet = this.IyS.getStringSet(paramString, paramSet);
      paramString = localSet;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        paramString = this.IyS.getStringSet(paramString, paramSet);
      }
    }
    AppMethodBeat.o(156288);
    return paramString;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156299);
    if (!y(paramString, Boolean.valueOf(paramBoolean)))
    {
      paramString = edit();
      AppMethodBeat.o(156299);
      return paramString;
    }
    try
    {
      this.IyS.putBoolean(paramString, paramBoolean);
      AppMethodBeat.o(156299);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putBoolean(paramString, paramBoolean);
      }
    }
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156298);
    if (!y(paramString, Float.valueOf(paramFloat)))
    {
      paramString = edit();
      AppMethodBeat.o(156298);
      return paramString;
    }
    try
    {
      this.IyS.putFloat(paramString, paramFloat);
      AppMethodBeat.o(156298);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putFloat(paramString, paramFloat);
      }
    }
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156296);
    if (!y(paramString, Integer.valueOf(paramInt)))
    {
      paramString = edit();
      AppMethodBeat.o(156296);
      return paramString;
    }
    try
    {
      this.IyS.putInt(paramString, paramInt);
      AppMethodBeat.o(156296);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putInt(paramString, paramInt);
      }
    }
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156297);
    if (!y(paramString, Long.valueOf(paramLong)))
    {
      paramString = edit();
      AppMethodBeat.o(156297);
      return paramString;
    }
    try
    {
      this.IyS.putLong(paramString, paramLong);
      AppMethodBeat.o(156297);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putLong(paramString, paramLong);
      }
    }
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156294);
    if (!y(paramString1, paramString2))
    {
      paramString1 = edit();
      AppMethodBeat.o(156294);
      return paramString1;
    }
    try
    {
      this.IyS.putString(paramString1, paramString2);
      AppMethodBeat.o(156294);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putString(paramString1, paramString2);
      }
    }
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156295);
    if (!y(paramString, paramSet))
    {
      paramString = edit();
      AppMethodBeat.o(156295);
      return paramString;
    }
    try
    {
      this.IyS.putStringSet(paramString, paramSet);
      AppMethodBeat.o(156295);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.putStringSet(paramString, paramSet);
      }
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(156300);
    try
    {
      this.IyS.remove(paramString);
      AppMethodBeat.o(156300);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fpd();
        this.IyS.remove(paramString);
      }
    }
  }
  
  public final void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(156282);
    this.IyS.removeValueForKey(paramString);
    AppMethodBeat.o(156282);
  }
  
  public final long totalSize()
  {
    AppMethodBeat.i(224222);
    long l = this.IyS.totalSize();
    AppMethodBeat.o(224222);
    return l;
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public final boolean y(String paramString, Object paramObject)
  {
    AppMethodBeat.i(156302);
    if ((bu.isNullOrNil(paramString)) || (paramObject == null) || (bu.isNullOrNil(this.name)))
    {
      AppMethodBeat.o(156302);
      return false;
    }
    AppMethodBeat.o(156302);
    return true;
  }
  
  public static final class a
  {
    public long IyU = 0L;
    public int size = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay
 * JD-Core Version:    0.7.0.1
 */