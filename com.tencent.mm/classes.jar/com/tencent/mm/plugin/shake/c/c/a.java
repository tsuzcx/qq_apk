package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat oWf = null;
  
  public static void D(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28255);
    ae.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    d.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(28255);
  }
  
  public static boolean PU(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int PV(int paramInt)
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
  
  public static int PW(int paramInt)
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
  
  public static int ZY(String paramString)
  {
    AppMethodBeat.i(28253);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ae.e("MicroMsg.ShakeCardUtil", "string format error");
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
      ae.e("MicroMsg.ShakeCardUtil", paramString.toString());
      AppMethodBeat.o(28253);
    }
    return i;
  }
  
  private static int dSA()
  {
    AppMethodBeat.i(28243);
    bc.aCg();
    int i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IKs, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int dSB()
  {
    AppMethodBeat.i(28244);
    bc.aCg();
    int i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IKt, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int dSC()
  {
    AppMethodBeat.i(28245);
    bc.aCg();
    int i = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IKy, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String dSD()
  {
    AppMethodBeat.i(28246);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKx, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String dSE()
  {
    AppMethodBeat.i(28247);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKu, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String dSF()
  {
    AppMethodBeat.i(28248);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKA, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String dSG()
  {
    AppMethodBeat.i(28249);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKz, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String dSH()
  {
    AppMethodBeat.i(28250);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKD, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static String dSI()
  {
    AppMethodBeat.i(28251);
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.IKC, "");
    AppMethodBeat.o(28251);
    return str;
  }
  
  public static int dSJ()
  {
    AppMethodBeat.i(28252);
    bc.aCg();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    ae.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean dSK()
  {
    AppMethodBeat.i(28256);
    if ((dSg()) && (ad.foi()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  public static void dSf()
  {
    AppMethodBeat.i(28240);
    ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!dSg())
    {
      ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (dSz())
      {
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.IKr, Boolean.TRUE);
        ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!dSz())
    {
      ae.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IKr, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean dSg()
  {
    AppMethodBeat.i(28241);
    if (!bc.ajM())
    {
      ae.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.ajA().get(am.a.IKr, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void dSh()
  {
    AppMethodBeat.i(28257);
    ae.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKs, Integer.valueOf(i));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKt, Integer.valueOf(86400 + i));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKu, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKy, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKv, Integer.valueOf(1));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKw, Integer.valueOf(6));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKx, "");
    com.tencent.mm.y.c.ahI().x(262154, true);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKz, String.valueOf(i));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKA, "hello");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKB, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void dSi()
  {
    AppMethodBeat.i(28258);
    ae.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKs, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKt, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKu, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKy, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKv, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKw, Integer.valueOf(0));
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKx, "");
    com.tencent.mm.y.c.ahI().x(262154, false);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKz, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKA, "");
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(am.a.IKB, "");
    AppMethodBeat.o(28258);
  }
  
  private static boolean dSz()
  {
    AppMethodBeat.i(28242);
    int i = dSA();
    int j = dSB();
    ae.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      ae.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (j <= 0)
    {
      ae.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (i >= j)
    {
      ae.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      AppMethodBeat.o(28242);
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    ae.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(k)));
    if ((k >= i) && (k <= j))
    {
      ae.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      AppMethodBeat.o(28242);
      return true;
    }
    ae.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    AppMethodBeat.o(28242);
    return false;
  }
  
  public static String sz(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (oWf == null) {
      oWf = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = oWf.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */