package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat omi = null;
  
  public static void A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28255);
    ac.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    d.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(28255);
  }
  
  public static boolean NK(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int NL(int paramInt)
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
  
  public static int NM(int paramInt)
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
  
  public static int Vy(String paramString)
  {
    AppMethodBeat.i(28253);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ac.e("MicroMsg.ShakeCardUtil", "string format error");
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
      ac.e("MicroMsg.ShakeCardUtil", paramString.toString());
      AppMethodBeat.o(28253);
    }
    return i;
  }
  
  private static int dDA()
  {
    AppMethodBeat.i(28243);
    az.ayM();
    int i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GDF, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int dDB()
  {
    AppMethodBeat.i(28244);
    az.ayM();
    int i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GDG, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int dDC()
  {
    AppMethodBeat.i(28245);
    az.ayM();
    int i = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GDL, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String dDD()
  {
    AppMethodBeat.i(28246);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDK, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String dDE()
  {
    AppMethodBeat.i(28247);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDH, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String dDF()
  {
    AppMethodBeat.i(28248);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDN, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String dDG()
  {
    AppMethodBeat.i(28249);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDM, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String dDH()
  {
    AppMethodBeat.i(28250);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDQ, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static String dDI()
  {
    AppMethodBeat.i(28251);
    az.ayM();
    String str = (String)com.tencent.mm.model.c.agA().get(ah.a.GDP, "");
    AppMethodBeat.o(28251);
    return str;
  }
  
  public static int dDJ()
  {
    AppMethodBeat.i(28252);
    az.ayM();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    ac.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean dDK()
  {
    AppMethodBeat.i(28256);
    if ((dDg()) && (ab.eUK()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  public static void dDf()
  {
    AppMethodBeat.i(28240);
    ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!dDg())
    {
      ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (dDz())
      {
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GDE, Boolean.TRUE);
        ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!dDz())
    {
      ac.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GDE, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean dDg()
  {
    AppMethodBeat.i(28241);
    if (!az.agM())
    {
      ac.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    az.ayM();
    Object localObject = com.tencent.mm.model.c.agA().get(ah.a.GDE, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void dDh()
  {
    AppMethodBeat.i(28257);
    ac.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDF, Integer.valueOf(i));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDG, Integer.valueOf(86400 + i));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDH, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDL, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDI, Integer.valueOf(1));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDJ, Integer.valueOf(6));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDK, "");
    com.tencent.mm.y.c.aeH().x(262154, true);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDM, String.valueOf(i));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDN, "hello");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDO, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void dDi()
  {
    AppMethodBeat.i(28258);
    ac.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDF, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDG, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDH, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDL, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDI, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDJ, Integer.valueOf(0));
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDK, "");
    com.tencent.mm.y.c.aeH().x(262154, false);
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDM, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDN, "");
    az.ayM();
    com.tencent.mm.model.c.agA().set(ah.a.GDO, "");
    AppMethodBeat.o(28258);
  }
  
  private static boolean dDz()
  {
    AppMethodBeat.i(28242);
    int i = dDA();
    int j = dDB();
    ac.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      ac.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (j <= 0)
    {
      ac.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      AppMethodBeat.o(28242);
      return false;
    }
    if (i >= j)
    {
      ac.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      AppMethodBeat.o(28242);
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    ac.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(k)));
    if ((k >= i) && (k <= j))
    {
      ac.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      AppMethodBeat.o(28242);
      return true;
    }
    ac.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    AppMethodBeat.o(28242);
    return false;
  }
  
  public static String qn(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (omi == null) {
      omi = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = omi.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */