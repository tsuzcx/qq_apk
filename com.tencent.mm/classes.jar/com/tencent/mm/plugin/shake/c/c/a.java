package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
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
  private static SimpleDateFormat tGV = null;
  
  public static String GN(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (tGV == null) {
      tGV = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = tGV.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
  
  public static void N(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28255);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    com.tencent.mm.by.c.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(28255);
  }
  
  public static boolean aew(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int aex(int paramInt)
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
  
  public static int aey(int paramInt)
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
  
  public static int arR(String paramString)
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
  
  private static boolean fHC()
  {
    AppMethodBeat.i(28242);
    int i = fHD();
    int j = fHE();
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
  
  private static int fHD()
  {
    AppMethodBeat.i(28243);
    bh.beI();
    int i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vgo, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int fHE()
  {
    AppMethodBeat.i(28244);
    bh.beI();
    int i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vgp, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int fHF()
  {
    AppMethodBeat.i(28245);
    bh.beI();
    int i = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vgu, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String fHG()
  {
    AppMethodBeat.i(28246);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgt, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String fHH()
  {
    AppMethodBeat.i(28247);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgq, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String fHI()
  {
    AppMethodBeat.i(28248);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgw, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String fHJ()
  {
    AppMethodBeat.i(28249);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgv, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String fHK()
  {
    AppMethodBeat.i(28250);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().get(ar.a.Vgz, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static int fHL()
  {
    AppMethodBeat.i(28252);
    bh.beI();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    Log.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean fHM()
  {
    AppMethodBeat.i(28256);
    if ((fHj()) && (LocaleUtil.isChineseAppLang()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  public static void fHi()
  {
    AppMethodBeat.i(28240);
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!fHj())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (fHC())
      {
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.Vgn, Boolean.TRUE);
        Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!fHC())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vgn, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean fHj()
  {
    AppMethodBeat.i(28241);
    if (!bh.aHB())
    {
      Log.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    bh.beI();
    Object localObject = com.tencent.mm.model.c.aHp().get(ar.a.Vgn, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void fHk()
  {
    AppMethodBeat.i(28257);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgo, Integer.valueOf(i));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgp, Integer.valueOf(86400 + i));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgq, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgu, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgr, Integer.valueOf(1));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgs, Integer.valueOf(6));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgt, "");
    com.tencent.mm.aa.c.aFn().D(262154, true);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgv, String.valueOf(i));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgw, "hello");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgx, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void fHl()
  {
    AppMethodBeat.i(28258);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgo, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgp, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgq, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgu, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgr, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgs, Integer.valueOf(0));
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgt, "");
    com.tencent.mm.aa.c.aFn().D(262154, false);
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgv, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgw, "");
    bh.beI();
    com.tencent.mm.model.c.aHp().set(ar.a.Vgx, "");
    AppMethodBeat.o(28258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */