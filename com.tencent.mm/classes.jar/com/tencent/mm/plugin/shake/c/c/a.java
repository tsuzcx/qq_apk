package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a
{
  private static SimpleDateFormat izc = null;
  
  private static boolean bAk()
  {
    au.Hx();
    int i = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.unG, Integer.valueOf(0))).intValue();
    au.Hx();
    int j = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.unH, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + i + " end time : " + j);
    if (i <= 0)
    {
      y.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + i + " , invalid");
      return false;
    }
    if (j <= 0)
    {
      y.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + j + " , invalid");
      return false;
    }
    if (i >= j)
    {
      y.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
      return false;
    }
    int k = (int)(System.currentTimeMillis() / 1000L);
    y.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + k);
    if ((k >= i) && (k <= j))
    {
      y.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
      return true;
    }
    y.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
    return false;
  }
  
  public static int bAl()
  {
    au.Hx();
    return ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.unM, Integer.valueOf(0))).intValue();
  }
  
  public static String bAm()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unL, "");
  }
  
  public static String bAn()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unI, "");
  }
  
  public static String bAo()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unO, "");
  }
  
  public static String bAp()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unN, "");
  }
  
  public static String bAq()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unR, "");
  }
  
  public static String bAr()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(ac.a.unQ, "");
  }
  
  public static int bAs()
  {
    au.Hx();
    int i = com.tencent.mm.model.c.CK();
    int j = (int)(System.currentTimeMillis() % 10L);
    i = (new Random(i).nextInt(10) + j) % 10;
    y.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + i);
    return i;
  }
  
  public static boolean bAt()
  {
    return (bzP()) && (x.cqF());
  }
  
  public static void bzO()
  {
    y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
    if (!bzP())
    {
      y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
      if (bAk())
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.unF, Boolean.valueOf(true));
        y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
      }
    }
    do
    {
      return;
      y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
      return;
      y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
    } while (bAk());
    y.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unF, Boolean.valueOf(false));
  }
  
  public static boolean bzP()
  {
    if (!au.DK())
    {
      y.e("MicroMsg.ShakeCardUtil", "acc is not ready");
      return false;
    }
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Dz().get(ac.a.unF, Boolean.valueOf(false));
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false) {
      return bool;
    }
  }
  
  public static void bzQ()
  {
    y.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
    int i = (int)(System.currentTimeMillis() / 1000L);
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unG, Integer.valueOf(i));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unH, Integer.valueOf(86400 + i));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unI, "");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unM, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unJ, Integer.valueOf(1));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unK, Integer.valueOf(6));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unL, "");
    com.tencent.mm.y.c.BS().w(262154, true);
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unN, String.valueOf(i));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unO, "hello");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unP, "shake card");
  }
  
  public static void bzR()
  {
    y.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unG, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unH, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unI, "");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unM, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unJ, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unK, Integer.valueOf(0));
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unL, "");
    com.tencent.mm.y.c.BS().w(262154, false);
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unN, "");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unO, "");
    au.Hx();
    com.tencent.mm.model.c.Dz().c(ac.a.unP, "");
  }
  
  public static String ce(long paramLong)
  {
    paramLong = 1000L * paramLong;
    new GregorianCalendar().setTimeInMillis(paramLong);
    if (izc == null) {
      izc = new SimpleDateFormat("yyyy.MM.dd");
    }
    return izc.format(new Date(paramLong));
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    y.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_card_id", paramString1);
    localIntent.putExtra("key_card_ext", paramString2);
    localIntent.putExtra("key_from_scene", 15);
    d.b(paramContext, "card", ".ui.CardDetailUI", localIntent);
  }
  
  public static boolean xl(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 5);
  }
  
  public static int xm(int paramInt)
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
  
  public static int xn(int paramInt)
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
  
  public static int yR(String paramString)
  {
    int i = Color.rgb(66, 66, 66);
    if ((paramString == null) || (paramString.length() < 7) || (!paramString.startsWith("#")))
    {
      y.e("MicroMsg.ShakeCardUtil", "string format error");
      return i;
    }
    try
    {
      paramString = paramString.substring(1).toUpperCase();
      int j = Color.argb(255, Integer.parseInt(paramString.substring(0, 2), 16), Integer.parseInt(paramString.substring(2, 4), 16), Integer.parseInt(paramString.substring(4, 6), 16));
      return j;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ShakeCardUtil", paramString.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.c.a
 * JD-Core Version:    0.7.0.1
 */