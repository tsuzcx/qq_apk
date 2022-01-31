package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat kCj = null;
  
  public static boolean Dl(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int Dm(int paramInt)
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
  
  public static int Dn(int paramInt)
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
  
  public static int IB(String paramString)
  {
    AppMethodBeat.i(24583);
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      ab.e("MicroMsg.ShakeCardUtil", "string format error");
      AppMethodBeat.o(24583);
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      AppMethodBeat.o(24583);
      return j;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ShakeCardUtil", paramString.toString());
      AppMethodBeat.o(24583);
    }
    return i;
  }
  
  private static boolean clC()
  {
    AppMethodBeat.i(24572);
    int i = clD();
    int j = clE();
    ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      AppMethodBeat.o(24572);
      return false;
    }
    if (j <= 0)
    {
      ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      AppMethodBeat.o(24572);
      return false;
    }
    if (i >= j)
    {
      ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      AppMethodBeat.o(24572);
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(k)));
    if ((k >= i) && (k <= j))
    {
      ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      AppMethodBeat.o(24572);
      return true;
    }
    ab.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    AppMethodBeat.o(24572);
    return false;
  }
  
  private static int clD()
  {
    AppMethodBeat.i(24573);
    aw.aaz();
    int i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yxx, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(24573);
    return i;
  }
  
  private static int clE()
  {
    AppMethodBeat.i(24574);
    aw.aaz();
    int i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yxy, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(24574);
    return i;
  }
  
  public static int clF()
  {
    AppMethodBeat.i(24575);
    aw.aaz();
    int i = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yxD, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(24575);
    return i;
  }
  
  public static String clG()
  {
    AppMethodBeat.i(24576);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxC, "");
    AppMethodBeat.o(24576);
    return str;
  }
  
  public static String clH()
  {
    AppMethodBeat.i(24577);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxz, "");
    AppMethodBeat.o(24577);
    return str;
  }
  
  public static String clI()
  {
    AppMethodBeat.i(24578);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxF, "");
    AppMethodBeat.o(24578);
    return str;
  }
  
  public static String clJ()
  {
    AppMethodBeat.i(24579);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxE, "");
    AppMethodBeat.o(24579);
    return str;
  }
  
  public static String clK()
  {
    AppMethodBeat.i(24580);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxI, "");
    AppMethodBeat.o(24580);
    return str;
  }
  
  public static String clL()
  {
    AppMethodBeat.i(24581);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxH, "");
    AppMethodBeat.o(24581);
    return str;
  }
  
  public static int clM()
  {
    AppMethodBeat.i(24582);
    aw.aaz();
    int i = com.tencent.mm.model.c.getUin();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    ab.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(i)));
    AppMethodBeat.o(24582);
    return i;
  }
  
  public static boolean clN()
  {
    AppMethodBeat.i(24586);
    if ((cli()) && (aa.dsC()))
    {
      AppMethodBeat.o(24586);
      return true;
    }
    AppMethodBeat.o(24586);
    return false;
  }
  
  public static void clh()
  {
    AppMethodBeat.i(24570);
    ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!cli())
    {
      ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (clC())
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yxw, Boolean.TRUE);
        ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
        AppMethodBeat.o(24570);
        return;
      }
      ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      AppMethodBeat.o(24570);
      return;
    }
    ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    if (!clC())
    {
      ab.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yxw, Boolean.FALSE);
    }
    AppMethodBeat.o(24570);
  }
  
  public static boolean cli()
  {
    AppMethodBeat.i(24571);
    if (!aw.RG())
    {
      ab.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      AppMethodBeat.o(24571);
      return false;
    }
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.Ru().get(ac.a.yxw, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(24571);
      return bool;
    }
  }
  
  public static void clj()
  {
    AppMethodBeat.i(24587);
    ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxx, Integer.valueOf(i));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxy, Integer.valueOf(86400 + i));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxz, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxD, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxA, Integer.valueOf(1));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxB, Integer.valueOf(6));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxC, "");
    com.tencent.mm.x.c.PJ().y(262154, true);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxE, String.valueOf(i));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxF, "hello");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxG, "shake card");
    AppMethodBeat.o(24587);
  }
  
  public static void clk()
  {
    AppMethodBeat.i(24588);
    ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxx, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxy, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxz, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxD, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxA, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxB, Integer.valueOf(0));
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxC, "");
    com.tencent.mm.x.c.PJ().y(262154, false);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxE, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxF, "");
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(ac.a.yxG, "");
    AppMethodBeat.o(24588);
  }
  
  public static String ha(long paramLong)
  {
    AppMethodBeat.i(24584);
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (kCj == null) {
      kCj = new SimpleDateFormat("yyyy.MM.dd");
    }
    String str = kCj.format(new Date(paramLong));
    AppMethodBeat.o(24584);
    return str;
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24585);
    ab.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    d.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
    AppMethodBeat.o(24585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */