package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat qkZ = null;
  
  public static String AF(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (qkZ == null) {
      qkZ = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = qkZ.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
  
  public static void H(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28255);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    com.tencent.mm.br.c.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(28255);
  }
  
  public static boolean Xx(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int Xy(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 10;
    case 2: 
      return 30;
    case 3: 
      return 60;
    case 4: 
      return 120;
    }
    return 240;
  }
  
  public static int Xz(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 10;
    case 1: 
      return 20;
    case 2: 
      return 30;
    case 3: 
      return 60;
    case 4: 
      return 90;
    case 5: 
      return 120;
    case 6: 
      return 150;
    case 7: 
      return 180;
    case 8: 
      return 240;
    }
    return 300;
  }
  
  public static int ake(String paramString)
  {
    AppMethodBeat.i(28253);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      Log.e("MicroMsg.ShakeCardUtil", "string format error");
      AppMethodBeat.o(28253);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(28253);
      return j;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.ShakeCardUtil", paramString.toString());
      AppMethodBeat.o(28253);
    }
    return i;
  }
  
  private static boolean eUA()
  {
    AppMethodBeat.i(28242);
    int i = eUB();
    int j = eUC();
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (j <= 0)
    {
      Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (i >= j)
    {
      Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      AppMethodBeat.o(28242);
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(k)));
    if ((k >= i) && (k <= j))
    {
      Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      AppMethodBeat.o(28242);
      return true;
    }
    Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    AppMethodBeat.o(28242);
    return false;
  }
  
  private static int eUB()
  {
    AppMethodBeat.i(28243);
    bg.aVF();
    int i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NSq, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int eUC()
  {
    AppMethodBeat.i(28244);
    bg.aVF();
    int i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NSr, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int eUD()
  {
    AppMethodBeat.i(28245);
    bg.aVF();
    int i = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NSw, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String eUE()
  {
    AppMethodBeat.i(28246);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSv, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String eUF()
  {
    AppMethodBeat.i(28247);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSs, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String eUG()
  {
    AppMethodBeat.i(28248);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSy, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String eUH()
  {
    AppMethodBeat.i(28249);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSx, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String eUI()
  {
    AppMethodBeat.i(28250);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSB, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static String eUJ()
  {
    AppMethodBeat.i(28251);
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NSA, "");
    AppMethodBeat.o(28251);
    return str;
  }
  
  public static int eUK()
  {
    AppMethodBeat.i(28252);
    bg.aVF();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    Log.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean eUL()
  {
    AppMethodBeat.i(28256);
    if ((eUh()) && (LocaleUtil.isChineseAppLang()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  public static void eUg()
  {
    AppMethodBeat.i(28240);
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!eUh())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (eUA())
      {
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.NSp, Boolean.TRUE);
        Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!eUA())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NSp, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean eUh()
  {
    AppMethodBeat.i(28241);
    if (!bg.aAc())
    {
      Log.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.azQ().get(ar.a.NSp, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void eUi()
  {
    AppMethodBeat.i(28257);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSq, Integer.valueOf(i));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSr, Integer.valueOf(86400 + i));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSs, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSw, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSt, Integer.valueOf(1));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSu, Integer.valueOf(6));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSv, "");
    com.tencent.mm.y.c.axV().B(262154, true);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSx, String.valueOf(i));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSy, "hello");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSz, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void eUj()
  {
    AppMethodBeat.i(28258);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSq, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSr, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSs, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSw, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSt, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSu, Integer.valueOf(0));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSv, "");
    com.tencent.mm.y.c.axV().B(262154, false);
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSx, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSy, "");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(ar.a.NSz, "");
    AppMethodBeat.o(28258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */