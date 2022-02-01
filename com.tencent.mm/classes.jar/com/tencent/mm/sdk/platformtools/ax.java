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

public class ax
  implements SharedPreferences, SharedPreferences.Editor
{
  private static ArrayMap<String, ax> EVH;
  public MMKV EVG;
  private String name;
  
  static
  {
    AppMethodBeat.i(156304);
    MMKV.class.getClassLoader();
    j.pq("mmkv");
    MMKV.initialize(aj.getContext());
    EVH = new ArrayMap();
    MMKV.registerHandler(new a()
    {
      public final c aFG(String paramAnonymousString)
      {
        AppMethodBeat.i(156250);
        ad.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramAnonymousString });
        e.vIY.idkeyStat(941L, 3L, 1L, true);
        paramAnonymousString = c.IgQ;
        AppMethodBeat.o(156250);
        return paramAnonymousString;
      }
      
      public final c aFH(String paramAnonymousString)
      {
        AppMethodBeat.i(156251);
        ad.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramAnonymousString });
        e.vIY.idkeyStat(941L, 4L, 1L, true);
        paramAnonymousString = c.IgQ;
        AppMethodBeat.o(156251);
        return paramAnonymousString;
      }
      
      public final void h(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(156252);
        ad.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, paramAnonymousString3 });
        AppMethodBeat.o(156252);
      }
    });
    AppMethodBeat.o(156304);
  }
  
  private ax(String paramString, MMKV paramMMKV)
  {
    this.EVG = paramMMKV;
    this.name = paramString;
  }
  
  public static int a(SharedPreferences paramSharedPreferences, ax paramax)
  {
    AppMethodBeat.i(156253);
    if ((paramSharedPreferences == null) || (paramax == null))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    String str = paramax.name;
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(156253);
      return 0;
    }
    ax localax = b("MULTIPROCESSMMKV_PERSERVED_NAME", 2, null);
    ad.i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", new Object[] { str });
    try
    {
      bool = localax.decodeBool(str, false);
      if (bool)
      {
        ad.i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
        AppMethodBeat.o(156253);
        return 0;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        boolean bool = localax.decodeBool(str, false);
      }
      localax.encode(str, true);
      e.vIY.idkeyStat(941L, 2L, 1L, true);
      int i = paramax.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(156253);
      return i;
    }
  }
  
  private static ax a(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156259);
    if ((bt.isNullOrNil(paramString)) || (bt.kU(paramString, "MULTIPROCESSMMKV_PERSERVED_NAME")))
    {
      ad.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
      AppMethodBeat.o(156259);
      return null;
    }
    paramString = b(paramString, paramInt, paramMMKV);
    AppMethodBeat.o(156259);
    return paramString;
  }
  
  public static ax aFC(String paramString)
  {
    AppMethodBeat.i(156254);
    paramString = a(paramString, 2, null);
    AppMethodBeat.o(156254);
    return paramString;
  }
  
  public static ax aFD(String paramString)
  {
    AppMethodBeat.i(156257);
    paramString = a(paramString, 1, null);
    AppMethodBeat.o(156257);
    return paramString;
  }
  
  public static ax aFE(String paramString)
  {
    AppMethodBeat.i(156261);
    ax localax = a(paramString, 2, null);
    a(aj.getContext().getSharedPreferences(paramString, 4), localax);
    AppMethodBeat.o(156261);
    return localax;
  }
  
  private static ax b(String paramString, int paramInt, MMKV paramMMKV)
  {
    AppMethodBeat.i(156260);
    ax localax;
    for (;;)
    {
      long l;
      try
      {
        localax = (ax)EVH.get(paramString);
        if (localax != null) {
          break;
        }
        if (paramMMKV == null)
        {
          paramMMKV = new ax(paramString, MMKV.mmkvWithID(paramString, paramInt));
          l = paramMMKV.EVG.totalSize();
          if (l > 1048576L)
          {
            ad.e("MicroMsg.MultiProcessMMKV", "MMKV file is too big, name : %s, size : %d, please contact with leafjia", new Object[] { paramString, Long.valueOf(l) });
            if (l > 5242880L) {
              break label241;
            }
            e.vIY.idkeyStat(941L, 10L, 1L, true);
            e.vIY.f(18378, new Object[] { paramString, Long.valueOf(l) });
            if (l > 5242880L)
            {
              e.vIY.idkeyStat(941L, 100L, 1L, true);
              ad.i("MicroMsg.MultiProcessMMKV", "start to trim, before size : %d", new Object[] { Long.valueOf(l) });
              paramMMKV.EVG.trim();
              ad.i("MicroMsg.MultiProcessMMKV", "trim is over, after size : %d", new Object[] { Long.valueOf(paramMMKV.EVG.totalSize()) });
            }
          }
          EVH.put(paramString, paramMMKV);
          return paramMMKV;
        }
        else
        {
          paramMMKV = new ax(paramString, paramMMKV);
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
      e.vIY.idkeyStat(941L, 11L, 1L, true);
      continue;
      label266:
      if (l <= 104857600L) {
        e.vIY.idkeyStat(941L, 12L, 1L, true);
      } else {
        e.vIY.idkeyStat(941L, 13L, 1L, true);
      }
    }
    AppMethodBeat.o(156260);
    return localax;
  }
  
  public static ax eGd()
  {
    AppMethodBeat.i(192588);
    ax localax = a("MULTIPROCESSMMKV_MULTI_DEFAULT", 2, MMKV.defaultMMKV());
    AppMethodBeat.o(192588);
    return localax;
  }
  
  public static ax eGe()
  {
    AppMethodBeat.i(156255);
    ax localax = a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.defaultMMKV());
    AppMethodBeat.o(156255);
    return localax;
  }
  
  public static ax eGf()
  {
    AppMethodBeat.i(156256);
    ax localax = a("MULTIPROCESSMMKV_SINGLE_DEFAULT", 1, MMKV.defaultMMKV(2, null));
    AppMethodBeat.o(156256);
    return localax;
  }
  
  private static void eGg()
  {
    AppMethodBeat.i(156303);
    MMKV.class.getClassLoader();
    j.pq("mmkv");
    AppMethodBeat.o(156303);
  }
  
  public static ax fF(String paramString, int paramInt)
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
      i = this.EVG.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(156269);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        int i = this.EVG.importFromSharedPreferences(paramSharedPreferences);
      }
    }
  }
  
  public static void init() {}
  
  public final double aFF(String paramString)
  {
    AppMethodBeat.i(156276);
    double d = this.EVG.decodeDouble(paramString, 1.0D);
    AppMethodBeat.o(156276);
    return d;
  }
  
  public final String[] allKeys()
  {
    AppMethodBeat.i(156286);
    try
    {
      String[] arrayOfString1 = this.EVG.allKeys();
      AppMethodBeat.o(156286);
      return arrayOfString1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        String[] arrayOfString2 = this.EVG.allKeys();
      }
    }
  }
  
  public void apply() {}
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(156301);
    try
    {
      this.EVG.clear();
      AppMethodBeat.o(156301);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.clear();
      }
    }
  }
  
  public final void clearAll()
  {
    AppMethodBeat.i(156284);
    try
    {
      this.EVG.clearAll();
      AppMethodBeat.o(156284);
      return;
    }
    catch (Throwable localThrowable)
    {
      eGg();
      this.EVG.clearAll();
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
      bool = this.EVG.contains(paramString);
      AppMethodBeat.o(156293);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        boolean bool = this.EVG.contains(paramString);
      }
    }
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(156281);
    boolean bool = this.EVG.containsKey(paramString);
    AppMethodBeat.o(156281);
    return bool;
  }
  
  public final long count()
  {
    AppMethodBeat.i(192590);
    long l = this.EVG.count();
    AppMethodBeat.o(192590);
    return l;
  }
  
  public final boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156277);
    paramBoolean = this.EVG.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(156277);
    return paramBoolean;
  }
  
  public final byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(156279);
    paramString = this.EVG.decodeBytes(paramString);
    AppMethodBeat.o(156279);
    return paramString;
  }
  
  public final int decodeInt(String paramString)
  {
    AppMethodBeat.i(156272);
    int i = this.EVG.decodeInt(paramString);
    AppMethodBeat.o(156272);
    return i;
  }
  
  public final int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156273);
    paramInt = this.EVG.decodeInt(paramString, paramInt);
    AppMethodBeat.o(156273);
    return paramInt;
  }
  
  public final long decodeLong(String paramString)
  {
    AppMethodBeat.i(156274);
    long l = this.EVG.decodeLong(paramString);
    AppMethodBeat.o(156274);
    return l;
  }
  
  public final long decodeLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156275);
    paramLong = this.EVG.decodeLong(paramString, paramLong);
    AppMethodBeat.o(156275);
    return paramLong;
  }
  
  public final <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(156280);
    paramString = this.EVG.decodeParcelable(paramString, paramClass);
    AppMethodBeat.o(156280);
    return paramString;
  }
  
  public final String decodeString(String paramString)
  {
    AppMethodBeat.i(156270);
    try
    {
      String str = this.EVG.decodeString(paramString);
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramString = this.EVG.decodeString(paramString);
      }
    }
    AppMethodBeat.o(156270);
    return paramString;
  }
  
  public final String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156271);
    paramString1 = this.EVG.decodeString(paramString1, paramString2);
    AppMethodBeat.o(156271);
    return paramString1;
  }
  
  public final Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156278);
    paramString = this.EVG.decodeStringSet(paramString, paramSet);
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
    if (!z(paramString, Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(156263);
      return false;
    }
    boolean bool = this.EVG.encode(paramString, paramInt);
    AppMethodBeat.o(156263);
    return bool;
  }
  
  public final boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(156264);
    if (!z(paramString, Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(156264);
      return false;
    }
    boolean bool = this.EVG.encode(paramString, paramLong);
    AppMethodBeat.o(156264);
    return bool;
  }
  
  public final boolean encode(String paramString, Parcelable paramParcelable)
  {
    AppMethodBeat.i(156268);
    if (!z(paramString, paramParcelable))
    {
      AppMethodBeat.o(156268);
      return false;
    }
    boolean bool = this.EVG.encode(paramString, paramParcelable);
    AppMethodBeat.o(156268);
    return bool;
  }
  
  public final boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156262);
    if (!z(paramString1, paramString2))
    {
      AppMethodBeat.o(156262);
      return false;
    }
    boolean bool = this.EVG.encode(paramString1, paramString2);
    AppMethodBeat.o(156262);
    return bool;
  }
  
  public final boolean encode(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156266);
    if (!z(paramString, paramSet))
    {
      AppMethodBeat.o(156266);
      return false;
    }
    boolean bool = this.EVG.encode(paramString, paramSet);
    AppMethodBeat.o(156266);
    return bool;
  }
  
  public final boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156265);
    if (!z(paramString, Boolean.valueOf(paramBoolean)))
    {
      AppMethodBeat.o(156265);
      return false;
    }
    try
    {
      boolean bool = this.EVG.encode(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramBoolean = this.EVG.encode(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(156265);
    return paramBoolean;
  }
  
  public final boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156267);
    if (!z(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(156267);
      return false;
    }
    boolean bool = this.EVG.encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(156267);
    return bool;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(182044);
    this.EVG.close();
    super.finalize();
    AppMethodBeat.o(182044);
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(156285);
    Map localMap = this.EVG.getAll();
    AppMethodBeat.o(156285);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156292);
    try
    {
      boolean bool = this.EVG.getBoolean(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramBoolean = this.EVG.getBoolean(paramString, paramBoolean);
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
      float f = this.EVG.getFloat(paramString, paramFloat);
      paramFloat = f;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramFloat = this.EVG.getFloat(paramString, paramFloat);
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
      int i = this.EVG.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramInt = this.EVG.getInt(paramString, paramInt);
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
      long l = this.EVG.getLong(paramString, paramLong);
      paramLong = l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramLong = this.EVG.getLong(paramString, paramLong);
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
      String str = this.EVG.getString(paramString1, paramString2);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramString1 = this.EVG.getString(paramString1, paramString2);
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
      Set localSet = this.EVG.getStringSet(paramString, paramSet);
      paramString = localSet;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        paramString = this.EVG.getStringSet(paramString, paramSet);
      }
    }
    AppMethodBeat.o(156288);
    return paramString;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156299);
    if (!z(paramString, Boolean.valueOf(paramBoolean)))
    {
      paramString = edit();
      AppMethodBeat.o(156299);
      return paramString;
    }
    try
    {
      this.EVG.putBoolean(paramString, paramBoolean);
      AppMethodBeat.o(156299);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putBoolean(paramString, paramBoolean);
      }
    }
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156298);
    if (!z(paramString, Float.valueOf(paramFloat)))
    {
      paramString = edit();
      AppMethodBeat.o(156298);
      return paramString;
    }
    try
    {
      this.EVG.putFloat(paramString, paramFloat);
      AppMethodBeat.o(156298);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putFloat(paramString, paramFloat);
      }
    }
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156296);
    if (!z(paramString, Integer.valueOf(paramInt)))
    {
      paramString = edit();
      AppMethodBeat.o(156296);
      return paramString;
    }
    try
    {
      this.EVG.putInt(paramString, paramInt);
      AppMethodBeat.o(156296);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putInt(paramString, paramInt);
      }
    }
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156297);
    if (!z(paramString, Long.valueOf(paramLong)))
    {
      paramString = edit();
      AppMethodBeat.o(156297);
      return paramString;
    }
    try
    {
      this.EVG.putLong(paramString, paramLong);
      AppMethodBeat.o(156297);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putLong(paramString, paramLong);
      }
    }
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156294);
    if (!z(paramString1, paramString2))
    {
      paramString1 = edit();
      AppMethodBeat.o(156294);
      return paramString1;
    }
    try
    {
      this.EVG.putString(paramString1, paramString2);
      AppMethodBeat.o(156294);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putString(paramString1, paramString2);
      }
    }
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(156295);
    if (!z(paramString, paramSet))
    {
      paramString = edit();
      AppMethodBeat.o(156295);
      return paramString;
    }
    try
    {
      this.EVG.putStringSet(paramString, paramSet);
      AppMethodBeat.o(156295);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.putStringSet(paramString, paramSet);
      }
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(156300);
    try
    {
      this.EVG.remove(paramString);
      AppMethodBeat.o(156300);
      return this;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        eGg();
        this.EVG.remove(paramString);
      }
    }
  }
  
  public final void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(156282);
    this.EVG.removeValueForKey(paramString);
    AppMethodBeat.o(156282);
  }
  
  public final long totalSize()
  {
    AppMethodBeat.i(201315);
    long l = this.EVG.totalSize();
    AppMethodBeat.o(201315);
    return l;
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public final boolean z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(156302);
    if ((bt.isNullOrNil(paramString)) || (paramObject == null) || (bt.isNullOrNil(this.name)))
    {
      AppMethodBeat.o(156302);
      return false;
    }
    AppMethodBeat.o(156302);
    return true;
  }
  
  public static final class a
  {
    public long EVI = 0L;
    public int size = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ax
 * JD-Core Version:    0.7.0.1
 */