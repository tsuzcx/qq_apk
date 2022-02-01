package com.tencent.mm.pluginsdk.platformtools;

import android.content.Context;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
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
  private static long XUR;
  private static boolean XUS = false;
  
  public static CharSequence A(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151906);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(151906);
      return "";
    }
    if (paramLong < 21600000L)
    {
      paramContext = paramContext.getString(c.h.fmt_dawn);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 43200000L)
    {
      paramContext = paramContext.getString(c.h.fmt_morning);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 46800000L)
    {
      paramContext = paramContext.getString(c.h.fmt_noon);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    if (paramLong < 64800000L)
    {
      paramContext = paramContext.getString(c.h.fmt_afternoon);
      AppMethodBeat.o(151906);
      return paramContext;
    }
    paramContext = paramContext.getString(c.h.fmt_evening);
    AppMethodBeat.o(151906);
    return paramContext;
  }
  
  public static String B(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(244667);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
      paramContext = C(paramContext, paramLong);
      AppMethodBeat.o(244667);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(244667);
      return "";
    }
    Time localTime1 = new Time();
    Time localTime2 = new Time();
    localTime1.set(paramLong);
    localTime2.setToNow();
    if ((localTime1.year == localTime2.year) && (localTime1.yearDay == localTime2.yearDay))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_nowday);
      AppMethodBeat.o(244667);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay == 1))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_yesterday);
      AppMethodBeat.o(244667);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay <= 7))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_7days_ago);
      AppMethodBeat.o(244667);
      return paramContext;
    }
    if ((localTime1.year == localTime2.year) && (localTime2.yearDay - localTime1.yearDay <= 30))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_30days_ago);
      AppMethodBeat.o(244667);
      return paramContext;
    }
    if (localTime1.year == localTime2.year)
    {
      paramContext = localTime1.month + 1 + "月";
      AppMethodBeat.o(244667);
      return paramContext;
    }
    paramContext = localTime1.year + "年";
    AppMethodBeat.o(244667);
    return paramContext;
  }
  
  private static String C(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(244673);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(244673);
      return "";
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_nowday);
      AppMethodBeat.o(244673);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_yesterday);
      AppMethodBeat.o(244673);
      return paramContext;
    }
    paramContext = new GregorianCalendar();
    paramContext.setTimeInMillis(paramLong);
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 604800000L;
    if ((l > 0L) && (l <= 604800000L))
    {
      AppMethodBeat.o(244673);
      return "7 days ago";
    }
    paramLong = paramLong - localGregorianCalendar2.getTimeInMillis() + 2592000000L;
    if ((paramLong > 0L) && (paramLong <= 2592000000L))
    {
      AppMethodBeat.o(244673);
      return "30 days ago";
    }
    if (localGregorianCalendar1.get(1) == paramContext.get(1))
    {
      paramContext = avR(localGregorianCalendar1.get(2));
      AppMethodBeat.o(244673);
      return paramContext;
    }
    paramContext = String.format("%d", new Object[] { Integer.valueOf(localGregorianCalendar1.get(1)) });
    AppMethodBeat.o(244673);
    return paramContext;
  }
  
  public static CharSequence D(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(244678);
    if (!LocaleUtil.isSimplifiedChineseAppLang())
    {
      localObject = new GregorianCalendar();
      if (paramLong < 3600000L)
      {
        AppMethodBeat.o(244678);
        return "";
      }
      long l = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
      if ((l > 0L) && (l <= 86400000L))
      {
        paramContext = paramContext.getString(c.h.fmt_pre_nowday);
        AppMethodBeat.o(244678);
        return paramContext;
      }
      LocaleUtil.transLanguageToLocale(LocaleUtil.getApplicationLanguage());
      paramContext = C(paramContext, paramLong);
      AppMethodBeat.o(244678);
      return paramContext;
    }
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(244678);
      return "";
    }
    Object localObject = new Time();
    Time localTime = new Time();
    ((Time)localObject).set(paramLong);
    localTime.setToNow();
    if ((((Time)localObject).year == localTime.year) && (((Time)localObject).yearDay == localTime.yearDay))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_nowday);
      AppMethodBeat.o(244678);
      return paramContext;
    }
    paramContext = d(paramContext, paramLong, true);
    AppMethodBeat.o(244678);
    return paramContext;
  }
  
  private static CharSequence a(Context paramContext, long paramLong, boolean paramBoolean, Locale paramLocale)
  {
    AppMethodBeat.i(244693);
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(244693);
      return "";
    }
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localGregorianCalendar1.get(1), localGregorianCalendar1.get(2), localGregorianCalendar1.get(5));
    long l = paramLong - localGregorianCalendar2.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L))
    {
      paramContext = java.text.DateFormat.getTimeInstance(3, paramLocale);
      paramContext = paramContext.format(Long.valueOf(paramLong));
      AppMethodBeat.o(244693);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar2.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L))
    {
      if (paramBoolean)
      {
        paramContext = paramContext.getString(c.h.fmt_pre_yesterday);
        AppMethodBeat.o(244693);
        return paramContext;
      }
      paramContext = paramContext.getString(c.h.fmt_pre_yesterday) + " " + java.text.DateFormat.getTimeInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(244693);
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
        AppMethodBeat.o(244693);
        return paramContext;
      }
      paramContext = paramContext + " " + java.text.DateFormat.getTimeInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(244693);
      return paramContext;
    }
    if (localGregorianCalendar1.get(1) == paramContext.get(1))
    {
      if (paramBoolean)
      {
        paramContext = java.text.DateFormat.getDateInstance(3, paramLocale).format(Long.valueOf(paramLong));
        AppMethodBeat.o(244693);
        return paramContext;
      }
      paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(244693);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = java.text.DateFormat.getDateInstance(3, paramLocale).format(Long.valueOf(paramLong));
      AppMethodBeat.o(244693);
      return paramContext;
    }
    paramContext = java.text.DateFormat.getDateTimeInstance(3, 3, paramLocale).format(Long.valueOf(paramLong));
    AppMethodBeat.o(244693);
    return paramContext;
  }
  
  private static String avR(int paramInt)
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
  
  public static String bk(Context paramContext, int paramInt)
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
      paramContext = A(paramContext, l2) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_yesterday) + " " + A(paramContext, l2) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_daybeforyesterday) + " " + A(paramContext, l2) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_tomorrow) + " " + A(paramContext, l2) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L))
    {
      paramContext = paramContext.getString(c.h.fmt_pre_dayaftertomorrow) + " " + A(paramContext, l2) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
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
      paramContext = bl(paramContext, i) + " " + bm(paramContext, paramInt) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
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
        paramContext = (String)localObject1 + " " + bm(paramContext, paramInt) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
        AppMethodBeat.o(151900);
        return paramContext;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_sunday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_monday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_tuesday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_wednesday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_thursday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_friday);
        continue;
        localObject1 = paramContext.getString(c.h.fmt_pre_next_week_saturday);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1))
    {
      paramContext = android.text.format.DateFormat.format(paramContext.getString(c.h.fmt_date), l1) + " " + bm(paramContext, paramInt) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
      AppMethodBeat.o(151900);
      return paramContext;
    }
    paramContext = android.text.format.DateFormat.format(paramContext.getString(c.h.fmt_longdate), l1) + " " + bm(paramContext, paramInt) + ";" + cj(paramContext.getString(c.h.fmt_normal_time), l1);
    AppMethodBeat.o(151900);
    return paramContext;
  }
  
  public static String bl(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151902);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(151902);
      return "";
    case 1: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_sunday);
      AppMethodBeat.o(151902);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_monday);
      AppMethodBeat.o(151902);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_tuesday);
      AppMethodBeat.o(151902);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_wednesday);
      AppMethodBeat.o(151902);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_thursday);
      AppMethodBeat.o(151902);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(c.h.fmt_pre_week_friday);
      AppMethodBeat.o(151902);
      return paramContext;
    }
    paramContext = paramContext.getString(c.h.fmt_pre_week_saturday);
    AppMethodBeat.o(151902);
    return paramContext;
  }
  
  private static CharSequence bm(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(151905);
    if (paramInt < 0)
    {
      AppMethodBeat.o(151905);
      return "";
    }
    if (paramInt < 6L)
    {
      paramContext = paramContext.getString(c.h.fmt_dawn);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 12L)
    {
      paramContext = paramContext.getString(c.h.fmt_morning);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 13L)
    {
      paramContext = paramContext.getString(c.h.fmt_noon);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    if (paramInt < 18L)
    {
      paramContext = paramContext.getString(c.h.fmt_afternoon);
      AppMethodBeat.o(151905);
      return paramContext;
    }
    paramContext = paramContext.getString(c.h.fmt_evening);
    AppMethodBeat.o(151905);
    return paramContext;
  }
  
  public static String cj(String paramString, long paramLong)
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
  
  public static CharSequence d(Context paramContext, long paramLong, boolean paramBoolean)
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
      if (iIY())
      {
        paramContext = e.a(paramContext.getString(c.h.fmt_normal_time_24), localTime);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = bm(paramContext, localTime.hour) + e.a(paramContext.getString(c.h.fmt_normal_time), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if ((localTime.year == ((Time)localObject).year) && (((Time)localObject).yearDay - localTime.yearDay == 1))
    {
      boolean bool = iIY();
      if (paramBoolean)
      {
        paramContext = paramContext.getString(c.h.fmt_pre_yesterday);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      localObject = new StringBuilder().append(paramContext.getString(c.h.fmt_pre_yesterday)).append(" ");
      if (bool) {}
      for (paramContext = e.a(paramContext.getString(c.h.fmt_normal_time_24), localTime);; paramContext = bm(paramContext, localTime.hour) + e.a(paramContext.getString(c.h.fmt_normal_time), localTime))
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
      paramContext = (String)localObject + e.a(paramContext.getString(c.h.fmt_patime), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (localTime.year == ((Time)localObject).year)
    {
      if (paramBoolean)
      {
        paramContext = e.a(paramContext.getString(c.h.fmt_date), localTime);
        AppMethodBeat.o(151908);
        return paramContext;
      }
      paramContext = e.a(paramContext.getString(c.h.fmt_datetime, new Object[] { A(paramContext, localTime.hour * 3600000L) }).toString(), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    if (paramBoolean)
    {
      paramContext = e.a(paramContext.getString(c.h.fmt_longdate), localTime);
      AppMethodBeat.o(151908);
      return paramContext;
    }
    paramContext = e.a(paramContext.getString(c.h.fmt_longtime, new Object[] { A(paramContext, localTime.hour * 3600000L) }).toString(), localTime);
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
  
  public static boolean iIY()
  {
    AppMethodBeat.i(151907);
    if (System.currentTimeMillis() - XUR > 30000L) {}
    try
    {
      XUS = android.text.format.DateFormat.is24HourFormat(MMApplicationContext.getContext());
      boolean bool = XUS;
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
  
  public static CharSequence y(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151903);
    paramContext = paramContext.getString(c.h.fmt_voip_longtime_prefix) + android.text.format.DateFormat.format(paramContext.getString(c.h.fmt_voip_longtime), paramLong);
    AppMethodBeat.o(151903);
    return paramContext;
  }
  
  public static CharSequence z(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(151904);
    paramContext = paramContext.getString(c.h.fmt_voip_voice_longtime_prefix) + android.text.format.DateFormat.format(paramContext.getString(c.h.fmt_voip_longtime), paramLong);
    AppMethodBeat.o(151904);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.platformtools.f
 * JD-Core Version:    0.7.0.1
 */