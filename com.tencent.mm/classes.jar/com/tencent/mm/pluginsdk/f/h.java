package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class h
{
  private static long vMH;
  private static boolean vMI = false;
  
  public static String aY(String paramString, long paramLong)
  {
    AppMethodBeat.i(79458);
    paramString = android.text.format.DateFormat.format(paramString, paramLong).toString();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(79458);
      return "";
    }
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("0")) {
      paramString = str.substring(1);
    }
    AppMethodBeat.o(79458);
    return paramString;
  }
  
  public static String ah(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(79457);
    long l1 = 1000L * paramInt;
    Object localObject1 = new GregorianCalendar();
    if (l1 < 3600000L)
    {
      AppMethodBeat.o(79457);
      return "";
    }
    Object localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
    long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = r(paramContext, l2) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131300084) + " " + r(paramContext, l2) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131300067) + " " + r(paramContext, l2) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131300076) + " " + r(paramContext, l2) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131300066) + " " + r(paramContext, l2) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    localObject2 = new GregorianCalendar();
    ((GregorianCalendar)localObject2).setTimeInMillis(l1);
    paramInt = ((GregorianCalendar)localObject2).get(11);
    int i;
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      paramContext = ai(paramContext, i) + " " + aj(paramContext, paramInt) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) + 1 == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      localObject2 = new StringBuilder();
      switch (i)
      {
      default: 
        localObject1 = "";
      }
      for (;;)
      {
        paramContext = (String)localObject1 + " " + aj(paramContext, paramInt) + ";" + aY(paramContext.getString(2131300061), l1);
        AppMethodBeat.o(79457);
        return paramContext;
        localObject1 = paramContext.getString(2131300071);
        continue;
        localObject1 = paramContext.getString(2131300069);
        continue;
        localObject1 = paramContext.getString(2131300073);
        continue;
        localObject1 = paramContext.getString(2131300074);
        continue;
        localObject1 = paramContext.getString(2131300072);
        continue;
        localObject1 = paramContext.getString(2131300068);
        continue;
        localObject1 = paramContext.getString(2131300070);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1))
    {
      paramContext = android.text.format.DateFormat.format(paramContext.getString(2131300031), l1) + " " + aj(paramContext, paramInt) + ";" + aY(paramContext.getString(2131300061), l1);
      AppMethodBeat.o(79457);
      return paramContext;
    }
    paramContext = android.text.format.DateFormat.format(paramContext.getString(2131300050), l1) + " " + aj(paramContext, paramInt) + ";" + aY(paramContext.getString(2131300061), l1);
    AppMethodBeat.o(79457);
    return paramContext;
  }
  
  public static String ai(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(79459);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(79459);
      return "";
    case 1: 
      paramContext = paramContext.getString(2131300080);
      AppMethodBeat.o(79459);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131300078);
      AppMethodBeat.o(79459);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131300082);
      AppMethodBeat.o(79459);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131300083);
      AppMethodBeat.o(79459);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131300081);
      AppMethodBeat.o(79459);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131300077);
      AppMethodBeat.o(79459);
      return paramContext;
    }
    paramContext = paramContext.getString(2131300079);
    AppMethodBeat.o(79459);
    return paramContext;
  }
  
  private static CharSequence aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(79462);
    if (paramInt < 0)
    {
      AppMethodBeat.o(79462);
      return "";
    }
    if (paramInt < 6L)
    {
      paramContext = paramContext.getString(2131300035);
      AppMethodBeat.o(79462);
      return paramContext;
    }
    if (paramInt < 12L)
    {
      paramContext = paramContext.getString(2131300054);
      AppMethodBeat.o(79462);
      return paramContext;
    }
    if (paramInt < 13L)
    {
      paramContext = paramContext.getString(2131300060);
      AppMethodBeat.o(79462);
      return paramContext;
    }
    if (paramInt < 18L)
    {
      paramContext = paramContext.getString(2131300021);
      AppMethodBeat.o(79462);
      return paramContext;
    }
    paramContext = paramContext.getString(2131300042);
    AppMethodBeat.o(79462);
    return paramContext;
  }
  
  public static CharSequence c(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(79465);
    if (!aa.dsD())
    {
      localObject1 = aa.apg(aa.dsG());
      localObject2 = new GregorianCalendar();
      if (paramLong < 3600000L)
      {
        AppMethodBeat.o(79465);
        return "";
      }
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
      long l = paramLong - localGregorianCalendar.getTimeInMillis();
      if ((l > 0L) && (l <= 86400000L))
      {
        paramContext = java.text.DateFormat.getTimeInstance(3, (Locale)localObject1);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        AppMethodBeat.o(79465);
        return paramContext;
      }
      l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
      if ((l > 0L) && (l <= 86400000L))
      {
        if (paramBoolean)
        {
          paramContext = paramContext.getString(2131300084);
          AppMethodBeat.o(79465);
          return paramContext;
        }
        paramContext = paramContext.getString(2131300084) + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(79465);
        return paramContext;
      }
      paramContext = new GregorianCalendar();
      paramContext.setTimeInMillis(paramLong);
      if ((((GregorianCalendar)localObject2).get(1) == paramContext.get(1)) && (((GregorianCalendar)localObject2).get(3) == paramContext.get(3)))
      {
        paramContext = new SimpleDateFormat("E", (Locale)localObject1);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        if (paramBoolean)
        {
          AppMethodBeat.o(79465);
          return paramContext;
        }
        paramContext = paramContext + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(79465);
        return paramContext;
      }
      if (((GregorianCalendar)localObject2).get(1) == paramContext.get(1))
      {
        if (paramBoolean)
        {
          paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
          AppMethodBeat.o(79465);
          return paramContext;
        }
        paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(79465);
        return paramContext;
      }
      if (paramBoolean)
      {
        paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(79465);
        return paramContext;
      }
      paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
      AppMethodBeat.o(79465);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(79465);
      return "";
    }
    Object localObject2 = new Time();
    Object localObject1 = new Time();
    ((Time)localObject2).set(paramLong);
    ((Time)localObject1).setToNow();
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).yearDay == ((Time)localObject1).yearDay))
    {
      if (dlR())
      {
        paramContext = g.a(paramContext.getString(2131300062), (Time)localObject2);
        AppMethodBeat.o(79465);
        return paramContext;
      }
      paramContext = aj(paramContext, ((Time)localObject2).hour) + g.a(paramContext.getString(2131300061), (Time)localObject2);
      AppMethodBeat.o(79465);
      return paramContext;
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject1).yearDay - ((Time)localObject2).yearDay == 1))
    {
      boolean bool = dlR();
      if (paramBoolean)
      {
        paramContext = paramContext.getString(2131300084);
        AppMethodBeat.o(79465);
        return paramContext;
      }
      localObject1 = new StringBuilder().append(paramContext.getString(2131300084)).append(" ");
      if (bool) {}
      for (paramContext = g.a(paramContext.getString(2131300062), (Time)localObject2);; paramContext = aj(paramContext, ((Time)localObject2).hour) + g.a(paramContext.getString(2131300061), (Time)localObject2))
      {
        paramContext = paramContext;
        AppMethodBeat.o(79465);
        return paramContext;
      }
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).getWeekNumber() == ((Time)localObject1).getWeekNumber()))
    {
      localObject1 = g.a("E ", (Time)localObject2);
      if (paramBoolean)
      {
        AppMethodBeat.o(79465);
        return localObject1;
      }
      paramContext = (String)localObject1 + g.a(paramContext.getString(2131300063), (Time)localObject2);
      AppMethodBeat.o(79465);
      return paramContext;
    }
    if (((Time)localObject2).year == ((Time)localObject1).year)
    {
      if (paramBoolean)
      {
        paramContext = g.a(paramContext.getString(2131300031), (Time)localObject2);
        AppMethodBeat.o(79465);
        return paramContext;
      }
      paramContext = g.a(paramContext.getString(2131300033, new Object[] { r(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
      AppMethodBeat.o(79465);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = g.a(paramContext.getString(2131300050), (Time)localObject2);
      AppMethodBeat.o(79465);
      return paramContext;
    }
    paramContext = g.a(paramContext.getString(2131300052, new Object[] { r(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
    AppMethodBeat.o(79465);
    return paramContext;
  }
  
  public static boolean dlR()
  {
    AppMethodBeat.i(79464);
    if (System.currentTimeMillis() - vMH > 30000L) {
      vMI = android.text.format.DateFormat.is24HourFormat(ah.getContext());
    }
    boolean bool = vMI;
    AppMethodBeat.o(79464);
    return bool;
  }
  
  public static String formatTime(String paramString, long paramLong)
  {
    AppMethodBeat.i(79456);
    paramString = new SimpleDateFormat(paramString).format(new Date(1000L * paramLong));
    AppMethodBeat.o(79456);
    return paramString;
  }
  
  public static CharSequence p(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(79460);
    paramContext = paramContext.getString(2131300109) + android.text.format.DateFormat.format(paramContext.getString(2131300108), paramLong);
    AppMethodBeat.o(79460);
    return paramContext;
  }
  
  public static CharSequence q(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(79461);
    paramContext = paramContext.getString(2131300110) + android.text.format.DateFormat.format(paramContext.getString(2131300108), paramLong);
    AppMethodBeat.o(79461);
    return paramContext;
  }
  
  public static CharSequence r(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(79463);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(79463);
      return "";
    }
    if (paramLong < 21600000L)
    {
      paramContext = paramContext.getString(2131300035);
      AppMethodBeat.o(79463);
      return paramContext;
    }
    if (paramLong < 43200000L)
    {
      paramContext = paramContext.getString(2131300054);
      AppMethodBeat.o(79463);
      return paramContext;
    }
    if (paramLong < 46800000L)
    {
      paramContext = paramContext.getString(2131300060);
      AppMethodBeat.o(79463);
      return paramContext;
    }
    if (paramLong < 64800000L)
    {
      paramContext = paramContext.getString(2131300021);
      AppMethodBeat.o(79463);
      return paramContext;
    }
    paramContext = paramContext.getString(2131300042);
    AppMethodBeat.o(79463);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.h
 * JD-Core Version:    0.7.0.1
 */