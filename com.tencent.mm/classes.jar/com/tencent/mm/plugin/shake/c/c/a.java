package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat oPD = null;
  
  public static void D(Context paramContext, String paramString1, String paramString2)
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
  
  public static boolean Pn(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int Po(int paramInt)
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
  
  public static int Pp(int paramInt)
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
  
  public static int Zh(String paramString)
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
  
  public static void dOI()
  {
    AppMethodBeat.i(28240);
    ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!dOJ())
    {
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (dPc())
      {
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.IpX, Boolean.TRUE);
        ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(28240);
        return;
      }
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(28240);
      return;
    }
    ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!dPc())
    {
      ad.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IpX, Boolean.FALSE);
    }
    AppMethodBeat.o(28240);
  }
  
  public static boolean dOJ()
  {
    AppMethodBeat.i(28241);
    if (!ba.ajx())
    {
      ad.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(28241);
      return false;
    }
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.ajl().get(al.a.IpX, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(28241);
      return bool;
    }
  }
  
  public static void dOK()
  {
    AppMethodBeat.i(28257);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpY, Integer.valueOf(i));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpZ, Integer.valueOf(86400 + i));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqa, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqe, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqb, Integer.valueOf(1));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqc, Integer.valueOf(6));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqd, "");
    com.tencent.mm.z.c.aht().x(262154, true);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqf, String.valueOf(i));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqg, "hello");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqh, "shake card");
    AppMethodBeat.o(28257);
  }
  
  public static void dOL()
  {
    AppMethodBeat.i(28258);
    ad.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpY, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.IpZ, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqa, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqe, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqb, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqc, Integer.valueOf(0));
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqd, "");
    com.tencent.mm.z.c.aht().x(262154, false);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqf, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqg, "");
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(al.a.Iqh, "");
    AppMethodBeat.o(28258);
  }
  
  private static boolean dPc()
  {
    AppMethodBeat.i(28242);
    int i = dPd();
    int j = dPe();
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
  
  private static int dPd()
  {
    AppMethodBeat.i(28243);
    ba.aBQ();
    int i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.IpY, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28243);
    return i;
  }
  
  private static int dPe()
  {
    AppMethodBeat.i(28244);
    ba.aBQ();
    int i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.IpZ, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28244);
    return i;
  }
  
  public static int dPf()
  {
    AppMethodBeat.i(28245);
    ba.aBQ();
    int i = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Iqe, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(28245);
    return i;
  }
  
  public static String dPg()
  {
    AppMethodBeat.i(28246);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqd, "");
    AppMethodBeat.o(28246);
    return str;
  }
  
  public static String dPh()
  {
    AppMethodBeat.i(28247);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqa, "");
    AppMethodBeat.o(28247);
    return str;
  }
  
  public static String dPi()
  {
    AppMethodBeat.i(28248);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqg, "");
    AppMethodBeat.o(28248);
    return str;
  }
  
  public static String dPj()
  {
    AppMethodBeat.i(28249);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqf, "");
    AppMethodBeat.o(28249);
    return str;
  }
  
  public static String dPk()
  {
    AppMethodBeat.i(28250);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqj, "");
    AppMethodBeat.o(28250);
    return str;
  }
  
  public static String dPl()
  {
    AppMethodBeat.i(28251);
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Iqi, "");
    AppMethodBeat.o(28251);
    return str;
  }
  
  public static int dPm()
  {
    AppMethodBeat.i(28252);
    ba.aBQ();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    ad.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(28252);
    return i;
  }
  
  public static boolean dPn()
  {
    AppMethodBeat.i(28256);
    if ((dOJ()) && (ac.fko()))
    {
      AppMethodBeat.o(28256);
      return true;
    }
    AppMethodBeat.o(28256);
    return false;
  }
  
  public static String sm(long paramLong)
  {
    AppMethodBeat.i(28254);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (oPD == null) {
      oPD = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = oPD.format(new Date(paramLong));
    AppMethodBeat.o(28254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */