package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat nJi = null;
  
  public static void B(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28255);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    d.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(28255);
  }
  
  public static boolean LK(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int LL(int paramInt)
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
  
  public static int LM(int paramInt)
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
  
  public static int Rm(String paramString)
  {
    AppMethodBeat.i(28253);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ad.e("MicroMsg.ShakeCardUtil", "string format error");
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
      ad.e("MicroMsg.ShakeCardUtil", paramString.toString());
      AppMethodBeat.o(28253);
    }
    return i;
  }
  
  public static void doV()
  {
    AppMethodBeat.i(28240);
    ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!doW())
    {
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (dpp())
      {
        az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FfQ, Boolean.TRUE);
        ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!dpp())
    {
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FfQ, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean doW()
  {
    AppMethodBeat.i(28241);
    if (!az.afw())
    {
      ad.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    az.arV();
    Object localObject = com.tencent.mm.model.c.afk().get(ae.a.FfQ, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void doX()
  {
    AppMethodBeat.i(28257);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfR, Integer.valueOf(i));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfS, Integer.valueOf(86400 + i));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfT, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfX, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfU, Integer.valueOf(1));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfV, Integer.valueOf(6));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfW, "");
    com.tencent.mm.z.c.adr().x(262154, true);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfY, String.valueOf(i));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfZ, "hello");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fga, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void doY()
  {
    AppMethodBeat.i(28258);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfR, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfS, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfT, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfX, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfU, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfV, Integer.valueOf(0));
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfW, "");
    com.tencent.mm.z.c.adr().x(262154, false);
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfY, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.FfZ, "");
    az.arV();
    com.tencent.mm.model.c.afk().set(ae.a.Fga, "");
    AppMethodBeat.o(28258);
  }
  
  public static boolean dpA()
  {
    AppMethodBeat.i(28256);
    if ((doW()) && (ac.eFq()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  private static boolean dpp()
  {
    AppMethodBeat.i(28242);
    int i = dpq();
    int j = dpr();
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      ad.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (j <= 0)
    {
      ad.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (i >= j)
    {
      ad.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      AppMethodBeat.o(28242);
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(k)));
    if ((k >= i) && (k <= j))
    {
      ad.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      AppMethodBeat.o(28242);
      return true;
    }
    ad.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    AppMethodBeat.o(28242);
    return false;
  }
  
  private static int dpq()
  {
    AppMethodBeat.i(28243);
    az.arV();
    int i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FfR, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int dpr()
  {
    AppMethodBeat.i(28244);
    az.arV();
    int i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FfS, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int dps()
  {
    AppMethodBeat.i(28245);
    az.arV();
    int i = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.FfX, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String dpt()
  {
    AppMethodBeat.i(28246);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.FfW, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String dpu()
  {
    AppMethodBeat.i(28247);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.FfT, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String dpv()
  {
    AppMethodBeat.i(28248);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.FfZ, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String dpw()
  {
    AppMethodBeat.i(28249);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.FfY, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String dpx()
  {
    AppMethodBeat.i(28250);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.Fgc, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static String dpy()
  {
    AppMethodBeat.i(28251);
    az.arV();
    String str = (String)com.tencent.mm.model.c.afk().get(ae.a.Fgb, "");
    AppMethodBeat.o(28251);
    return str;
  }
  
  public static int dpz()
  {
    AppMethodBeat.i(28252);
    az.arV();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    ad.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static String mz(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (nJi == null) {
      nJi = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = nJi.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */