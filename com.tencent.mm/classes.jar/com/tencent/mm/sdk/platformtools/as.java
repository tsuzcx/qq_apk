package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.a;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;
import java.util.Map;
import java.util.Set;

public class as
  implements SharedPreferences, SharedPreferences.Editor
{
  private static ArrayMap<String, as> yoU;
  private MMKV hjd;
  private String name;
  
  static
  {
    AppMethodBeat.i(93541);
    k.a("mmkv", MMKV.class.getClassLoader());
    MMKV.initialize(ah.getContext());
    yoU = new ArrayMap();
    MMKV.registerHandler(new a()
    {
      public final c apt(String paramAnonymousString)
      {
        AppMethodBeat.i(93460);
        ab.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramAnonymousString });
        e.qrI.idkeyStat(941L, 3L, 1L, true);
        paramAnonymousString = c.AZV;
        AppMethodBeat.o(93460);
        return paramAnonymousString;
      }
      
      public final c apu(String paramAnonymousString)
      {
        AppMethodBeat.i(93461);
        ab.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramAnonymousString });
        e.qrI.idkeyStat(941L, 4L, 1L, true);
        paramAnonymousString = c.AZV;
        AppMethodBeat.o(93461);
        return paramAnonymousString;
      }
      
      public final void h(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(93462);
        ab.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2, paramAnonymousString3 });
        AppMethodBeat.o(93462);
      }
    });
    AppMethodBeat.o(93541);
  }
  
  private as(String paramString)
  {
    this.name = paramString;
  }
  
  private as(String paramString, MMKV paramMMKV)
  {
    this.hjd = paramMMKV;
    this.name = paramString;
  }
  
  public static int a(SharedPreferences paramSharedPreferences, as paramas)
  {
    AppMethodBeat.i(93496);
    if ((paramSharedPreferences == null) || (paramas == null))
    {
      AppMethodBeat.o(93496);
      return 0;
    }
    String str = paramas.name;
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(93496);
      return 0;
    }
    as localas = ev("MULTIPROCESSMMKV_PERSERVED_NAME", 2);
    ab.i("MicroMsg.MultiProcessMMKV", "transport2MMKV, name : %s", new Object[] { str });
    try
    {
      bool = localas.decodeBool(str, false);
      if (bool)
      {
        ab.i("MicroMsg.MultiProcessMMKV", "transport2MMKV has Done");
        AppMethodBeat.o(93496);
        return 0;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        boolean bool = localas.decodeBool(str, false);
      }
      localas.encode(str, true);
      e.qrI.idkeyStat(941L, 2L, 1L, true);
      int i = paramas.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(93496);
      return i;
    }
  }
  
  public static as apq(String paramString)
  {
    AppMethodBeat.i(93497);
    paramString = eu(paramString, 2);
    AppMethodBeat.o(93497);
    return paramString;
  }
  
  public static as apr(String paramString)
  {
    AppMethodBeat.i(93500);
    as localas = eu(paramString, 2);
    a(ah.getContext().getSharedPreferences(paramString, 4), localas);
    AppMethodBeat.o(93500);
    return localas;
  }
  
  public static d createNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(93508);
    d locald = MMKV.createNativeBuffer(paramInt);
    AppMethodBeat.o(93508);
    return locald;
  }
  
  public static void destroyNativeBuffer(d paramd)
  {
    AppMethodBeat.i(93509);
    MMKV.destroyNativeBuffer(paramd);
    AppMethodBeat.o(93509);
  }
  
  static void dtp()
  {
    AppMethodBeat.i(93538);
    k.a("mmkv", MMKV.class.getClassLoader());
    AppMethodBeat.o(93538);
  }
  
  private static boolean dtq()
  {
    AppMethodBeat.i(93539);
    String str = Build.MODEL;
    if (str == null)
    {
      AppMethodBeat.o(93539);
      return false;
    }
    if ((bo.isEqual(str, "vivo Y66i")) || (bo.isEqual(str, "vivo Y66i A")))
    {
      AppMethodBeat.o(93539);
      return true;
    }
    AppMethodBeat.o(93539);
    return false;
  }
  
  public static as eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(93498);
    if (!isSupported())
    {
      if ((bo.isNullOrNil(paramString)) || (bo.isEqual(paramString, "MULTIPROCESSMMKV_PERSERVED_NAME")))
      {
        ab.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
        AppMethodBeat.o(93498);
        return null;
      }
      a locala = new a(paramString, (byte)0);
      paramString = ev(paramString, paramInt);
      a(locala, paramString);
      AppMethodBeat.o(93498);
      return paramString;
    }
    if ((bo.isNullOrNil(paramString)) || (bo.isEqual(paramString, "MULTIPROCESSMMKV_PERSERVED_NAME")))
    {
      ab.i("MicroMsg.MultiProcessMMKV", "getMMKV name is illegal");
      AppMethodBeat.o(93498);
      return null;
    }
    paramString = ev(paramString, paramInt);
    AppMethodBeat.o(93498);
    return paramString;
  }
  
  private static as ev(String paramString, int paramInt)
  {
    AppMethodBeat.i(93499);
    try
    {
      as localas = (as)yoU.get(paramString);
      if (localas == null)
      {
        localas = new as(paramString, MMKV.mmkvWithID(paramString, paramInt));
        yoU.put(paramString, localas);
        return localas;
      }
      return localas;
    }
    finally
    {
      AppMethodBeat.o(93499);
    }
  }
  
  private static boolean isSupported()
  {
    AppMethodBeat.i(93540);
    if (dtq())
    {
      AppMethodBeat.o(93540);
      return false;
    }
    AppMethodBeat.o(93540);
    return true;
  }
  
  private boolean t(String paramString, Object paramObject)
  {
    AppMethodBeat.i(93537);
    if ((bo.isNullOrNil(paramString)) || (paramObject == null) || (bo.isNullOrNil(this.name)))
    {
      AppMethodBeat.o(93537);
      return false;
    }
    AppMethodBeat.o(93537);
    return true;
  }
  
  public String[] allKeys()
  {
    AppMethodBeat.i(93519);
    try
    {
      String[] arrayOfString1 = this.hjd.allKeys();
      AppMethodBeat.o(93519);
      return arrayOfString1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        String[] arrayOfString2 = this.hjd.allKeys();
      }
    }
  }
  
  public void apply()
  {
    AppMethodBeat.i(93536);
    this.hjd.apply();
    AppMethodBeat.o(93536);
  }
  
  public long aps(String paramString)
  {
    AppMethodBeat.i(93513);
    long l = this.hjd.decodeLong(paramString, 0L);
    AppMethodBeat.o(93513);
    return l;
  }
  
  public SharedPreferences.Editor clear()
  {
    AppMethodBeat.i(93534);
    try
    {
      SharedPreferences.Editor localEditor1 = this.hjd.clear();
      AppMethodBeat.o(93534);
      return localEditor1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        SharedPreferences.Editor localEditor2 = this.hjd.clear();
      }
    }
  }
  
  public boolean commit()
  {
    AppMethodBeat.i(93535);
    try
    {
      bool = this.hjd.commit();
      AppMethodBeat.o(93535);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        boolean bool = this.hjd.commit();
      }
    }
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(93526);
    try
    {
      bool = this.hjd.contains(paramString);
      AppMethodBeat.o(93526);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        boolean bool = this.hjd.contains(paramString);
      }
    }
  }
  
  public boolean containsKey(String paramString)
  {
    AppMethodBeat.i(93516);
    boolean bool = this.hjd.containsKey(paramString);
    AppMethodBeat.o(93516);
    return bool;
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93514);
    paramBoolean = this.hjd.decodeBool(paramString, paramBoolean);
    AppMethodBeat.o(93514);
    return paramBoolean;
  }
  
  public byte[] decodeBytes(String paramString)
  {
    AppMethodBeat.i(93515);
    paramString = this.hjd.decodeBytes(paramString);
    AppMethodBeat.o(93515);
    return paramString;
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(93512);
    paramInt = this.hjd.decodeInt(paramString, paramInt);
    AppMethodBeat.o(93512);
    return paramInt;
  }
  
  public String decodeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139731);
    paramString1 = this.hjd.decodeString(paramString1, paramString2);
    AppMethodBeat.o(139731);
    return paramString1;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public boolean encode(String paramString, int paramInt)
  {
    AppMethodBeat.i(93503);
    if (!t(paramString, Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(93503);
      return false;
    }
    boolean bool = this.hjd.encode(paramString, paramInt);
    AppMethodBeat.o(93503);
    return bool;
  }
  
  public boolean encode(String paramString, long paramLong)
  {
    AppMethodBeat.i(93504);
    if (!t(paramString, Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(93504);
      return false;
    }
    boolean bool = this.hjd.encode(paramString, paramLong);
    AppMethodBeat.o(93504);
    return bool;
  }
  
  public boolean encode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93502);
    if (!t(paramString1, paramString2))
    {
      AppMethodBeat.o(93502);
      return false;
    }
    boolean bool = this.hjd.encode(paramString1, paramString2);
    AppMethodBeat.o(93502);
    return bool;
  }
  
  public boolean encode(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93505);
    if (!t(paramString, Boolean.valueOf(paramBoolean)))
    {
      AppMethodBeat.o(93505);
      return false;
    }
    try
    {
      boolean bool = this.hjd.encode(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramBoolean = this.hjd.encode(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(93505);
    return paramBoolean;
  }
  
  public boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93506);
    if (!t(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(93506);
      return false;
    }
    boolean bool = this.hjd.encode(paramString, paramArrayOfByte);
    AppMethodBeat.o(93506);
    return bool;
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(93518);
    Map localMap = this.hjd.getAll();
    AppMethodBeat.o(93518);
    return localMap;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93525);
    try
    {
      boolean bool = this.hjd.getBoolean(paramString, paramBoolean);
      paramBoolean = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramBoolean = this.hjd.getBoolean(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(93525);
    return paramBoolean;
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(93524);
    try
    {
      float f = this.hjd.getFloat(paramString, paramFloat);
      paramFloat = f;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramFloat = this.hjd.getFloat(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(93524);
    return paramFloat;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(93522);
    try
    {
      int i = this.hjd.getInt(paramString, paramInt);
      paramInt = i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramInt = this.hjd.getInt(paramString, paramInt);
      }
    }
    AppMethodBeat.o(93522);
    return paramInt;
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(93523);
    try
    {
      long l = this.hjd.getLong(paramString, paramLong);
      paramLong = l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramLong = this.hjd.getLong(paramString, paramLong);
      }
    }
    AppMethodBeat.o(93523);
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93520);
    try
    {
      String str = this.hjd.getString(paramString1, paramString2);
      paramString1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString1 = this.hjd.getString(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(93520);
    return paramString1;
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(93521);
    try
    {
      Set localSet = this.hjd.getStringSet(paramString, paramSet);
      paramString = localSet;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.getStringSet(paramString, paramSet);
      }
    }
    AppMethodBeat.o(93521);
    return paramString;
  }
  
  public final int getValueActualSize(String paramString)
  {
    AppMethodBeat.i(93501);
    int i = this.hjd.getValueActualSize(paramString);
    AppMethodBeat.o(93501);
    return i;
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(93507);
    try
    {
      i = this.hjd.importFromSharedPreferences(paramSharedPreferences);
      AppMethodBeat.o(93507);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        int i = this.hjd.importFromSharedPreferences(paramSharedPreferences);
      }
    }
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93532);
    if (!t(paramString, Boolean.valueOf(paramBoolean)))
    {
      paramString = edit();
      AppMethodBeat.o(93532);
      return paramString;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putBoolean(paramString, paramBoolean);
      paramString = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.putBoolean(paramString, paramBoolean);
      }
    }
    AppMethodBeat.o(93532);
    return paramString;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(93531);
    if (!t(paramString, Float.valueOf(paramFloat)))
    {
      paramString = edit();
      AppMethodBeat.o(93531);
      return paramString;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putFloat(paramString, paramFloat);
      paramString = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.putFloat(paramString, paramFloat);
      }
    }
    AppMethodBeat.o(93531);
    return paramString;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(93529);
    if (!t(paramString, Integer.valueOf(paramInt)))
    {
      paramString = edit();
      AppMethodBeat.o(93529);
      return paramString;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putInt(paramString, paramInt);
      paramString = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.putInt(paramString, paramInt);
      }
    }
    AppMethodBeat.o(93529);
    return paramString;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(93530);
    if (!t(paramString, Long.valueOf(paramLong)))
    {
      paramString = edit();
      AppMethodBeat.o(93530);
      return paramString;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putLong(paramString, paramLong);
      paramString = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.putLong(paramString, paramLong);
      }
    }
    AppMethodBeat.o(93530);
    return paramString;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93527);
    if (!t(paramString1, paramString2))
    {
      paramString1 = edit();
      AppMethodBeat.o(93527);
      return paramString1;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putString(paramString1, paramString2);
      paramString1 = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString1 = this.hjd.putString(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(93527);
    return paramString1;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    AppMethodBeat.i(93528);
    if (!t(paramString, paramSet))
    {
      paramString = edit();
      AppMethodBeat.o(93528);
      return paramString;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.hjd.putStringSet(paramString, paramSet);
      paramString = localEditor;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        paramString = this.hjd.putStringSet(paramString, paramSet);
      }
    }
    AppMethodBeat.o(93528);
    return paramString;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public SharedPreferences.Editor remove(String paramString)
  {
    AppMethodBeat.i(93533);
    try
    {
      SharedPreferences.Editor localEditor1 = this.hjd.remove(paramString);
      paramString = localEditor1.remove(paramString);
      AppMethodBeat.o(93533);
      return paramString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dtp();
        SharedPreferences.Editor localEditor2 = this.hjd.remove(paramString);
      }
    }
  }
  
  public void removeValueForKey(String paramString)
  {
    AppMethodBeat.i(93517);
    this.hjd.removeValueForKey(paramString);
    AppMethodBeat.o(93517);
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  
  public final int writeValueToNativeBuffer(String paramString, d paramd)
  {
    AppMethodBeat.i(93510);
    int i = this.hjd.writeValueToNativeBuffer(paramString, paramd);
    AppMethodBeat.o(93510);
    return i;
  }
  
  static final class a
    extends as
    implements SharedPreferences, SharedPreferences.Editor
  {
    private SharedPreferences sp;
    
    private a(String paramString)
    {
      super((byte)0);
      AppMethodBeat.i(93463);
      this.sp = ah.getContext().getSharedPreferences(paramString, 4);
      AppMethodBeat.o(93463);
    }
    
    public final String[] allKeys()
    {
      AppMethodBeat.i(93465);
      String[] arrayOfString = (String[])this.sp.getAll().keySet().toArray(new String[0]);
      AppMethodBeat.o(93465);
      return arrayOfString;
    }
    
    public final void apply()
    {
      AppMethodBeat.i(93482);
      this.sp.edit().apply();
      AppMethodBeat.o(93482);
    }
    
    public final long aps(String paramString)
    {
      AppMethodBeat.i(93491);
      long l = this.sp.getLong(paramString, 0L);
      AppMethodBeat.o(93491);
      return l;
    }
    
    public final SharedPreferences.Editor clear()
    {
      AppMethodBeat.i(93480);
      SharedPreferences.Editor localEditor = this.sp.edit().clear();
      localEditor.apply();
      AppMethodBeat.o(93480);
      return localEditor;
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(93481);
      boolean bool = this.sp.edit().commit();
      AppMethodBeat.o(93481);
      return bool;
    }
    
    public final boolean contains(String paramString)
    {
      AppMethodBeat.i(93472);
      boolean bool = this.sp.contains(paramString);
      AppMethodBeat.o(93472);
      return bool;
    }
    
    public final boolean containsKey(String paramString)
    {
      AppMethodBeat.i(93494);
      boolean bool = this.sp.contains(paramString);
      AppMethodBeat.o(93494);
      return bool;
    }
    
    public final boolean decodeBool(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(93492);
      paramBoolean = this.sp.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(93492);
      return paramBoolean;
    }
    
    public final byte[] decodeBytes(String paramString)
    {
      AppMethodBeat.i(93493);
      paramString = this.sp.getString(paramString, "");
      try
      {
        paramString = Base64.decode(paramString, 0);
        AppMethodBeat.o(93493);
        return paramString;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(93493);
      }
      return null;
    }
    
    public final int decodeInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(93490);
      paramInt = this.sp.getInt(paramString, paramInt);
      AppMethodBeat.o(93490);
      return paramInt;
    }
    
    public final String decodeString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(139730);
      paramString1 = this.sp.getString(paramString1, paramString2);
      AppMethodBeat.o(139730);
      return paramString1;
    }
    
    public final SharedPreferences.Editor edit()
    {
      return this;
    }
    
    public final boolean encode(String paramString, int paramInt)
    {
      AppMethodBeat.i(93484);
      this.sp.edit().putInt(paramString, paramInt).apply();
      AppMethodBeat.o(93484);
      return true;
    }
    
    public final boolean encode(String paramString, long paramLong)
    {
      AppMethodBeat.i(93485);
      this.sp.edit().putLong(paramString, paramLong).apply();
      AppMethodBeat.o(93485);
      return true;
    }
    
    public final boolean encode(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93483);
      this.sp.edit().putString(paramString1, paramString2).apply();
      AppMethodBeat.o(93483);
      return true;
    }
    
    public final boolean encode(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(93486);
      this.sp.edit().putBoolean(paramString, paramBoolean).apply();
      AppMethodBeat.o(93486);
      return true;
    }
    
    public final boolean encode(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(93487);
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
      this.sp.edit().putString(paramString, paramArrayOfByte).apply();
      AppMethodBeat.o(93487);
      return true;
    }
    
    public final Map<String, ?> getAll()
    {
      AppMethodBeat.i(93464);
      Map localMap = this.sp.getAll();
      AppMethodBeat.o(93464);
      return localMap;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(93471);
      paramBoolean = this.sp.getBoolean(paramString, paramBoolean);
      AppMethodBeat.o(93471);
      return paramBoolean;
    }
    
    public final float getFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(93470);
      paramFloat = this.sp.getFloat(paramString, paramFloat);
      AppMethodBeat.o(93470);
      return paramFloat;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(93468);
      try
      {
        int i = this.sp.getInt(paramString, paramInt);
        paramInt = i;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          as.dtp();
          paramInt = this.sp.getInt(paramString, paramInt);
        }
      }
      AppMethodBeat.o(93468);
      return paramInt;
    }
    
    public final long getLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(93469);
      paramLong = this.sp.getLong(paramString, paramLong);
      AppMethodBeat.o(93469);
      return paramLong;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93466);
      paramString1 = this.sp.getString(paramString1, paramString2);
      AppMethodBeat.o(93466);
      return paramString1;
    }
    
    public final Set<String> getStringSet(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(93467);
      paramString = this.sp.getStringSet(paramString, paramSet);
      AppMethodBeat.o(93467);
      return paramString;
    }
    
    public final int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
    {
      AppMethodBeat.i(93488);
      int i = paramSharedPreferences.getAll().size();
      AppMethodBeat.o(93488);
      return i;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(93478);
      paramString = this.sp.edit().putBoolean(paramString, paramBoolean);
      paramString.apply();
      AppMethodBeat.o(93478);
      return paramString;
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(93477);
      paramString = this.sp.edit().putFloat(paramString, paramFloat);
      paramString.apply();
      AppMethodBeat.o(93477);
      return paramString;
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(93475);
      paramString = this.sp.edit().putInt(paramString, paramInt);
      paramString.apply();
      AppMethodBeat.o(93475);
      return paramString;
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(93476);
      paramString = this.sp.edit().putLong(paramString, paramLong);
      paramString.apply();
      AppMethodBeat.o(93476);
      return paramString;
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(93473);
      paramString1 = this.sp.edit().putString(paramString1, paramString2);
      paramString1.apply();
      AppMethodBeat.o(93473);
      return paramString1;
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(93474);
      paramString = this.sp.edit().putStringSet(paramString, paramSet);
      paramString.apply();
      AppMethodBeat.o(93474);
      return paramString;
    }
    
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(93479);
      SharedPreferences.Editor localEditor = this.sp.edit().remove(paramString);
      localEditor.apply();
      paramString = localEditor.remove(paramString);
      AppMethodBeat.o(93479);
      return paramString;
    }
    
    public final void removeValueForKey(String paramString)
    {
      AppMethodBeat.i(93495);
      this.sp.edit().remove(paramString).apply();
      AppMethodBeat.o(93495);
    }
    
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.as
 * JD-Core Version:    0.7.0.1
 */