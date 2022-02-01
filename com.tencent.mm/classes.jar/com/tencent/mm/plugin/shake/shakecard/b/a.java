package com.tencent.mm.plugin.shake.shakecard.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat wKu = null;
  
  public static void N(Context paramContext, String paramString1, String paramString2)
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
  
  public static boolean ajd(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int aje(int paramInt)
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
  
  public static int ajf(int paramInt)
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
  
  public static int alv(String paramString)
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
  
  public static void gWW()
  {
    AppMethodBeat.i(28240);
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!gWX())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (gXs())
      {
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acHC, Boolean.TRUE);
        Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!gXs())
    {
      Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acHC, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean gWX()
  {
    AppMethodBeat.i(28241);
    if (!bh.baz())
    {
      Log.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.ban().get(at.a.acHC, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void gWY()
  {
    AppMethodBeat.i(28257);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHD, Integer.valueOf(i));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHE, Integer.valueOf(86400 + i));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHF, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHJ, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHG, Integer.valueOf(1));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHH, Integer.valueOf(6));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHI, "");
    com.tencent.mm.aa.c.aYo().R(262154, true);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHK, String.valueOf(i));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHL, "hello");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHM, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void gWZ()
  {
    AppMethodBeat.i(28258);
    Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHD, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHE, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHF, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHJ, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHG, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHH, Integer.valueOf(0));
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHI, "");
    com.tencent.mm.aa.c.aYo().R(262154, false);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHK, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHL, "");
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acHM, "");
    AppMethodBeat.o(28258);
  }
  
  public static String gXA()
  {
    AppMethodBeat.i(28250);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acHO, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static int gXB()
  {
    AppMethodBeat.i(28252);
    bh.bCz();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    Log.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean gXC()
  {
    AppMethodBeat.i(28256);
    if ((gWX()) && (LocaleUtil.isChineseAppLang()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  private static boolean gXs()
  {
    AppMethodBeat.i(28242);
    int i = gXt();
    int j = gXu();
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
  
  private static int gXt()
  {
    AppMethodBeat.i(28243);
    bh.bCz();
    int i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acHD, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int gXu()
  {
    AppMethodBeat.i(28244);
    bh.bCz();
    int i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acHE, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int gXv()
  {
    AppMethodBeat.i(28245);
    bh.bCz();
    int i = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acHJ, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String gXw()
  {
    AppMethodBeat.i(28246);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acHI, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String gXx()
  {
    AppMethodBeat.i(28247);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acHF, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String gXy()
  {
    AppMethodBeat.i(28248);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acHL, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String gXz()
  {
    AppMethodBeat.i(28249);
    bh.bCz();
    String str = (String)com.tencent.mm.model.c.ban().get(at.a.acHK, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String iY(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (wKu == null) {
      wKu = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = wKu.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.b.a
 * JD-Core Version:    0.7.0.1
 */