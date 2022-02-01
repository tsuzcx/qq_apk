package com.tencent.mm.pluginsdk.i;

import android.content.Context;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class f
{
  private static long JYp;
  private static boolean JYq = false;
  
  private static CharSequence a(Context paramContext, long paramLong, boolean paramBoolean, Locale paramLocale)
  {
    AppMethodBeat.i(223821);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(223821);
      return "";
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = java.text.DateFormat.getTimeInstance(3, paramLocale);
      paramContext = paramContext.format(Long.valueOf(paramLong));
      AppMethodBeat.o(223821);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L))
    {
      if (paramBoolean)
      {
        paramContext = paramContext.getString(2131760868);
        AppMethodBeat.o(223821);
        return paramContext;
      }
      paramContext = paramContext.getString(2131760868) + " " + java.text.DateFormat.getTimeInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(223821);
      return paramContext;
    }
    paramContext = new GregorianCalendar();
    paramContext.setTimeInMillis(paramLong);
    if ((localGregorianCalendar1.get(1) == paramContext.get(1)) && (localGregorianCalendar1.get(3) == paramContext.get(3)))
    {
      paramContext = new SimpleDateFormat("E", paramLocale);
      paramContext = paramContext.format(Long.valueOf(paramLong));
      if (paramBoolean)
      {
        AppMethodBeat.o(223821);
        return paramContext;
      }
      paramContext = paramContext + " " + java.text.DateFormat.getTimeInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(223821);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == paramContext.get(1))
    {
      if (paramBoolean)
      {
        paramContext = java.text.DateFormat.getDateInstance(3, paramLocale).format(Long.valueOf(paramLong));
        AppMethodBeat.o(223821);
        return paramContext;
      }
      paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(223821);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = java.text.DateFormat.getDateInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(223821);
      return paramContext;
    }
    paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, paramLocale).format(Long.valueOf(paramLong));
    AppMethodBeat.o(223821);
    return paramContext;
  }
  
  public static String aA(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151902);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(151902);
      return "";
    case 1: 
      paramContext = paramContext.getString(2131760864);
      AppMethodBeat.o(151902);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131760862);
      AppMethodBeat.o(151902);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131760866);
      AppMethodBeat.o(151902);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131760867);
      AppMethodBeat.o(151902);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131760865);
      AppMethodBeat.o(151902);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131760861);
      AppMethodBeat.o(151902);
      return paramContext;
    }
    paramContext = paramContext.getString(2131760863);
    AppMethodBeat.o(151902);
    return paramContext;
  }
  
  private static CharSequence aB(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151905);
    if (paramInt < 0)
    {
      AppMethodBeat.o(151905);
      return "";
    }
    if (paramInt < 6L)
    {
      paramContext = paramContext.getString(2131760817);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 12L)
    {
      paramContext = paramContext.getString(2131760836);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 13L)
    {
      paramContext = paramContext.getString(2131760842);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 18L)
    {
      paramContext = paramContext.getString(2131760803);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    paramContext = paramContext.getString(2131760824);
    AppMethodBeat.o(151905);
    return paramContext;
  }
  
  private static String ahO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNDECIMBER";
    case 0: 
      return "JANUARY";
    case 1: 
      return "FEBRUARY";
    case 2: 
      return "MARCH";
    case 3: 
      return "APRIL";
    case 4: 
      return "MAY";
    case 5: 
      return "JUNE";
    case 6: 
      return "JULY";
    case 7: 
      return "AUGUST";
    case 8: 
      return "SEPTEMBER";
    case 9: 
      return "OCTOBER";
    case 10: 
      return "NOVEMBER";
    }
    return "DECEMBER";
  }
  
  public static String az(Context paramContext, int paramInt)
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
      paramContext = v(paramContext, l2) + ";" + bQ(paramContext.getString(2131760843), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131760868) + " " + v(paramContext, l2) + ";" + bQ(paramContext.getString(2131760843), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131760851) + " " + v(paramContext, l2) + ";" + bQ(paramContext.getString(2131760843), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131760860) + " " + v(paramContext, l2) + ";" + bQ(paramContext.getString(2131760843), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(2131760850) + " " + v(paramContext, l2) + ";" + bQ(paramContext.getString(2131760843), l1);
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
      paramContext = aA(paramContext, i) + " " + aB(paramContext, paramInt) + ";" + bQ(paramContext.getString(2131760843), l1);
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
        paramContext = (String)localObject1 + " " + aB(paramContext, paramInt) + ";" + bQ(paramContext.getString(2131760843), l1);
        AppMethodBeat.o(151900);
        return paramContext;
        localObject1 = paramContext.getString(2131760855);
        continue;
        localObject1 = paramContext.getString(2131760853);
        continue;
        localObject1 = paramContext.getString(2131760857);
        continue;
        localObject1 = paramContext.getString(2131760858);
        continue;
        localObject1 = paramContext.getString(2131760856);
        continue;
        localObject1 = paramContext.getString(2131760852);
        continue;
        localObject1 = paramContext.getString(2131760854);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1))
    {
      paramContext = android.text.format.DateFormat.format(paramContext.getString(2131760813), l1) + " " + aB(paramContext, paramInt) + ";" + bQ(paramContext.getString(2131760843), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    paramContext = android.text.format.DateFormat.format(paramContext.getString(2131760832), l1) + " " + aB(paramContext, paramInt) + ";" + bQ(paramContext.getString(2131760843), l1);
    AppMethodBeat.o(151900);
    return paramContext;
  }
  
  public static String bQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(151901);
    paramString = android.text.format.DateFormat.format(paramString, paramLong).toString();
    if (Util.isNullOrNil(paramString))
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
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      paramContext = a(paramContext, paramLong, paramBoolean, LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage()));
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(151908);
      return "";
    }
    Time localTime = new Time();
    Object localObject = new Time();
    localTime.set(paramLong);
    ((Time)localObject).setToNow();
    if ((localTime.year == ((Time)localObject).year) && (localTime.yearDay == ((Time)localObject).yearDay))
    {
      if (gns())
      {
        paramContext = e.a(paramContext.getString(2131760844), localTime);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = aB(paramContext, localTime.hour) + e.a(paramContext.getString(2131760843), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if ((localTime.year == ((Time)localObject).year) && (((Time)localObject).yearDay - localTime.yearDay == 1))
    {
      boolean bool = gns();
      if (paramBoolean)
      {
        paramContext = paramContext.getString(2131760868);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      localObject = new StringBuilder().append(paramContext.getString(2131760868)).append(" ");
      if (bool) {}
      for (paramContext = e.a(paramContext.getString(2131760844), localTime);; paramContext = aB(paramContext, localTime.hour) + e.a(paramContext.getString(2131760843), localTime))
      {
        paramContext = paramContext;
        AppMethodBeat.o(151908);
        return paramContext;
      }
    }
    if ((localTime.year == ((Time)localObject).year) && (localTime.getWeekNumber() == ((Time)localObject).getWeekNumber()))
    {
      localObject = e.a("E ", localTime);
      if (paramBoolean)
      {
        AppMethodBeat.o(151908);
        return localObject;
      }
      paramContext = (String)localObject + e.a(paramContext.getString(2131760845), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (localTime.year == ((Time)localObject).year)
    {
      if (paramBoolean)
      {
        paramContext = e.a(paramContext.getString(2131760813), localTime);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = e.a(paramContext.getString(2131760815, new Object[] { v(paramContext, localTime.hour * 3600000L) }).toString(), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = e.a(paramContext.getString(2131760832), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    paramContext = e.a(paramContext.getString(2131760834, new Object[] { v(paramContext, localTime.hour * 3600000L) }).toString(), localTime);
    AppMethodBeat.o(151908);
    return paramContext;
  }
  
  public static String formatTime(String paramString, long paramLong)
  {
    AppMethodBeat.i(151899);
    paramString = new SimpleDateFormat(paramString).format(new Date(1000L * paramLong));
    AppMethodBeat.o(151899);
    return paramString;
  }
  
  public static boolean gns()
  {
    AppMethodBeat.i(151907);
    if (System.currentTimeMillis() - JYp > 30000L) {}
    try
    {
      JYq = android.text.format.DateFormat.is24HourFormat(MMApplicationContext.getContext());
      boolean bool = JYq;
      AppMethodBeat.o(151907);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TimeUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static CharSequence t(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151903);
    paramContext = paramContext.getString(2131760893) + android.text.format.DateFormat.format(paramContext.getString(2131760892), paramLong);
    AppMethodBeat.o(151903);
    return paramContext;
  }
  
  public static CharSequence u(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151904);
    paramContext = paramContext.getString(2131760894) + android.text.format.DateFormat.format(paramContext.getString(2131760892), paramLong);
    AppMethodBeat.o(151904);
    return paramContext;
  }
  
  public static CharSequence v(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151906);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(151906);
      return "";
    }
    if (paramLong < 21600000L)
    {
      paramContext = paramContext.getString(2131760817);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 43200000L)
    {
      paramContext = paramContext.getString(2131760836);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 46800000L)
    {
      paramContext = paramContext.getString(2131760842);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 64800000L)
    {
      paramContext = paramContext.getString(2131760803);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    paramContext = paramContext.getString(2131760824);
    AppMethodBeat.o(151906);
    return paramContext;
  }
  
  public static String w(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(223818);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
      paramContext = x(paramContext, paramLong);
      AppMethodBeat.o(223818);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(223818);
      return "";
    }
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
    {
      paramContext = paramContext.getString(2131760859);
      AppMethodBeat.o(223818);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay == 1))
    {
      paramContext = paramContext.getString(2131760868);
      AppMethodBeat.o(223818);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay <= 7))
    {
      paramContext = paramContext.getString(2131760849);
      AppMethodBeat.o(223818);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay <= 30))
    {
      paramContext = paramContext.getString(2131760848);
      AppMethodBeat.o(223818);
      return paramContext;
    }
    if (localTime1.year == localTime2.year)
    {
      paramContext = localTime1.month + 1 + "月";
      AppMethodBeat.o(223818);
      return paramContext;
    }
    paramContext = localTime1.year + "年";
    AppMethodBeat.o(223818);
    return paramContext;
  }
  
  private static String x(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(223819);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(223819);
      return "";
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131760859);
      AppMethodBeat.o(223819);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(2131760868);
      AppMethodBeat.o(223819);
      return paramContext;
    }
    paramContext = new GregorianCalendar();
    paramContext.setTimeInMillis(paramLong);
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 604800000L;
    if ((l > 0L) && (l <= 604800000L))
    {
      AppMethodBeat.o(223819);
      return "7 days ago";
    }
    paramLong = paramLong - localGregorianCalendar2.getTimeInMillis() + 2592000000L;
    if ((paramLong > 0L) && (paramLong <= 2592000000L))
    {
      AppMethodBeat.o(223819);
      return "30 days ago";
    }
    if (localGregorianCalendar1.get(1) == paramContext.get(1))
    {
      paramContext = ahO(localGregorianCalendar1.get(2));
      AppMethodBeat.o(223819);
      return paramContext;
    }
    paramContext = String.format("%d", new Object[] { Integer.valueOf(localGregorianCalendar1.get(1)) });
    AppMethodBeat.o(223819);
    return paramContext;
  }
  
  public static CharSequence y(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(223820);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      localObject = new GregorianCalendar();
      if (paramLong < 3600000L)
      {
        AppMethodBeat.o(223820);
        return "";
      }
      long l = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
      if ((l > 0L) && (l <= 86400000L))
      {
        paramContext = paramContext.getString(2131760859);
        AppMethodBeat.o(223820);
        return paramContext;
      }
      LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
      paramContext = x(paramContext, paramLong);
      AppMethodBeat.o(223820);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(223820);
      return "";
    }
    Object localObject = new Time();
    Time localTime = new Time();
    ((Time)localObject).set(paramLong);
    localTime.setToNow();
    if ((((Time)localObject).year == localTime.year) && (((Time)localObject).yearDay == localTime.yearDay))
    {
      paramContext = paramContext.getString(2131760859);
      AppMethodBeat.o(223820);
      return paramContext;
    }
    paramContext = c(paramContext, paramLong, true);
    AppMethodBeat.o(223820);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.f
 * JD-Core Version:    0.7.0.1
 */