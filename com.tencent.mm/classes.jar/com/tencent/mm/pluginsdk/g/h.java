package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class h
{
  private static long BRI;
  private static boolean BRJ = false;
  
  public static String ah(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151900);
    long l1 = 1000L * paramInt;
    Object localObject1 = new GregorianCalendar();
    if (l1 < 3600000L)
    {
      AppMethodBeat.o(151900);
      return "";
    }
    Object localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
    long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = t(paramContext, l2) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759551) + " " + t(paramContext, l2) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759534) + " " + t(paramContext, l2) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759543) + " " + t(paramContext, l2) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131759533) + " " + t(paramContext, l2) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    localObject2 = new GregorianCalendar();
    ((GregorianCalendar)localObject2).setTimeInMillis(l1);
    paramInt = ((GregorianCalendar)localObject2).get(11);
    int i;
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      paramContext = ai(paramContext, i) + " " + aj(paramContext, paramInt) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
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
        paramContext = (String)localObject1 + " " + aj(paramContext, paramInt) + ";" + bI(paramContext.getString(2131759528), l1);
        AppMethodBeat.o(151900);
        return paramContext;
        localObject1 = paramContext.getString(2131759538);
        continue;
        localObject1 = paramContext.getString(2131759536);
        continue;
        localObject1 = paramContext.getString(2131759540);
        continue;
        localObject1 = paramContext.getString(2131759541);
        continue;
        localObject1 = paramContext.getString(2131759539);
        continue;
        localObject1 = paramContext.getString(2131759535);
        continue;
        localObject1 = paramContext.getString(2131759537);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1))
    {
      paramContext = android.text.format.DateFormat.format(paramContext.getString(2131759498), l1) + " " + aj(paramContext, paramInt) + ";" + bI(paramContext.getString(2131759528), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    paramContext = android.text.format.DateFormat.format(paramContext.getString(2131759517), l1) + " " + aj(paramContext, paramInt) + ";" + bI(paramContext.getString(2131759528), l1);
    AppMethodBeat.o(151900);
    return paramContext;
  }
  
  public static String ai(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151902);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(151902);
      return "";
    case 1: 
      paramContext = paramContext.getString(2131759547);
      AppMethodBeat.o(151902);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131759545);
      AppMethodBeat.o(151902);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131759549);
      AppMethodBeat.o(151902);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131759550);
      AppMethodBeat.o(151902);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131759548);
      AppMethodBeat.o(151902);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131759544);
      AppMethodBeat.o(151902);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759546);
    AppMethodBeat.o(151902);
    return paramContext;
  }
  
  private static CharSequence aj(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151905);
    if (paramInt < 0)
    {
      AppMethodBeat.o(151905);
      return "";
    }
    if (paramInt < 6L)
    {
      paramContext = paramContext.getString(2131759502);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 12L)
    {
      paramContext = paramContext.getString(2131759521);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 13L)
    {
      paramContext = paramContext.getString(2131759527);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 18L)
    {
      paramContext = paramContext.getString(2131759488);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759509);
    AppMethodBeat.o(151905);
    return paramContext;
  }
  
  public static String bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(151901);
    paramString = android.text.format.DateFormat.format(paramString, paramLong).toString();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151901);
      return "";
    }
    String str = paramString.trim();
    paramString = str;
    if (str.startsWith("0")) {
      paramString = str.substring(1);
    }
    AppMethodBeat.o(151901);
    return paramString;
  }
  
  public static CharSequence c(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(151908);
    if (!ac.eFr())
    {
      localObject1 = ac.aFt(ac.eFu());
      localObject2 = new GregorianCalendar();
      if (paramLong < 3600000L)
      {
        AppMethodBeat.o(151908);
        return "";
      }
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
      long l = paramLong - localGregorianCalendar.getTimeInMillis();
      if ((l > 0L) && (l <= 86400000L))
      {
        paramContext = java.text.DateFormat.getTimeInstance(3, (Locale)localObject1);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        AppMethodBeat.o(151908);
        return paramContext;
      }
      l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
      if ((l > 0L) && (l <= 86400000L))
      {
        if (paramBoolean)
        {
          paramContext = paramContext.getString(2131759551);
          AppMethodBeat.o(151908);
          return paramContext;
        }
        paramContext = paramContext.getString(2131759551) + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(151908);
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
          AppMethodBeat.o(151908);
          return paramContext;
        }
        paramContext = paramContext + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(151908);
        return paramContext;
      }
      if (((GregorianCalendar)localObject2).get(1) == paramContext.get(1))
      {
        if (paramBoolean)
        {
          paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
          AppMethodBeat.o(151908);
          return paramContext;
        }
        paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(151908);
        return paramContext;
      }
      if (paramBoolean)
      {
        paramContext = java.text.DateFormat.getDateInstance(3, (Locale)localObject1).format(Long.valueOf(paramLong));
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject1).format(Long.valueOf(paramLong));
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(151908);
      return "";
    }
    Object localObject2 = new Time();
    Object localObject1 = new Time();
    ((Time)localObject2).set(paramLong);
    ((Time)localObject1).setToNow();
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).yearDay == ((Time)localObject1).yearDay))
    {
      if (ewd())
      {
        paramContext = g.a(paramContext.getString(2131759529), (Time)localObject2);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = aj(paramContext, ((Time)localObject2).hour) + g.a(paramContext.getString(2131759528), (Time)localObject2);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject1).yearDay - ((Time)localObject2).yearDay == 1))
    {
      boolean bool = ewd();
      if (paramBoolean)
      {
        paramContext = paramContext.getString(2131759551);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      localObject1 = new StringBuilder().append(paramContext.getString(2131759551)).append(" ");
      if (bool) {}
      for (paramContext = g.a(paramContext.getString(2131759529), (Time)localObject2);; paramContext = aj(paramContext, ((Time)localObject2).hour) + g.a(paramContext.getString(2131759528), (Time)localObject2))
      {
        paramContext = paramContext;
        AppMethodBeat.o(151908);
        return paramContext;
      }
    }
    if ((((Time)localObject2).year == ((Time)localObject1).year) && (((Time)localObject2).getWeekNumber() == ((Time)localObject1).getWeekNumber()))
    {
      localObject1 = g.a("E ", (Time)localObject2);
      if (paramBoolean)
      {
        AppMethodBeat.o(151908);
        return localObject1;
      }
      paramContext = (String)localObject1 + g.a(paramContext.getString(2131759530), (Time)localObject2);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (((Time)localObject2).year == ((Time)localObject1).year)
    {
      if (paramBoolean)
      {
        paramContext = g.a(paramContext.getString(2131759498), (Time)localObject2);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = g.a(paramContext.getString(2131759500, new Object[] { t(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = g.a(paramContext.getString(2131759517), (Time)localObject2);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    paramContext = g.a(paramContext.getString(2131759519, new Object[] { t(paramContext, ((Time)localObject2).hour * 3600000L) }).toString(), (Time)localObject2);
    AppMethodBeat.o(151908);
    return paramContext;
  }
  
  public static boolean ewd()
  {
    AppMethodBeat.i(151907);
    if (System.currentTimeMillis() - BRI > 30000L) {}
    try
    {
      BRJ = android.text.format.DateFormat.is24HourFormat(aj.getContext());
      boolean bool = BRJ;
      AppMethodBeat.o(151907);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.TimeUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static String formatTime(String paramString, long paramLong)
  {
    AppMethodBeat.i(151899);
    paramString = new SimpleDateFormat(paramString).format(new Date(1000L * paramLong));
    AppMethodBeat.o(151899);
    return paramString;
  }
  
  public static CharSequence r(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151903);
    paramContext = paramContext.getString(2131759576) + android.text.format.DateFormat.format(paramContext.getString(2131759575), paramLong);
    AppMethodBeat.o(151903);
    return paramContext;
  }
  
  public static CharSequence s(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151904);
    paramContext = paramContext.getString(2131759577) + android.text.format.DateFormat.format(paramContext.getString(2131759575), paramLong);
    AppMethodBeat.o(151904);
    return paramContext;
  }
  
  public static CharSequence t(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151906);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(151906);
      return "";
    }
    if (paramLong < 21600000L)
    {
      paramContext = paramContext.getString(2131759502);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 43200000L)
    {
      paramContext = paramContext.getString(2131759521);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 46800000L)
    {
      paramContext = paramContext.getString(2131759527);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 64800000L)
    {
      paramContext = paramContext.getString(2131759488);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759509);
    AppMethodBeat.o(151906);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.h
 * JD-Core Version:    0.7.0.1
 */