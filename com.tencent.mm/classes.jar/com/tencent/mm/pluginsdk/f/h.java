package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.text.format.Time;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class h
{
  private static long rVM;
  private static boolean rVN = false;
  
  public static String T(Context paramContext, int paramInt)
  {
    long l1 = 1000L * paramInt;
    Object localObject1 = new GregorianCalendar();
    if (l1 < 3600000L) {
      return "";
    }
    Object localObject2 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
    long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
    if ((l2 >= 0L) && (l2 < 86400000L)) {
      return p(paramContext, l2) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L)) {
      return paramContext.getString(a.h.fmt_pre_yesterday) + " " + p(paramContext, l2) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() - 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L)) {
      return paramContext.getString(a.h.fmt_pre_daybeforyesterday) + " " + p(paramContext, l2) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L);
    if ((l2 >= 0L) && (l2 < 86400000L)) {
      return paramContext.getString(a.h.fmt_pre_tomorrow) + " " + p(paramContext, l2) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    l2 = l1 - (((GregorianCalendar)localObject2).getTimeInMillis() + 172800000L);
    if ((l2 >= 0L) && (l2 < 86400000L)) {
      return paramContext.getString(a.h.fmt_pre_dayaftertomorrow) + " " + p(paramContext, l2) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    localObject2 = new GregorianCalendar();
    ((GregorianCalendar)localObject2).setTimeInMillis(l1);
    paramInt = ((GregorianCalendar)localObject2).get(11);
    int i;
    if ((((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) && (((GregorianCalendar)localObject1).get(3) == ((GregorianCalendar)localObject2).get(3)))
    {
      i = ((GregorianCalendar)localObject2).get(7);
      return U(paramContext, i) + " " + V(paramContext, paramInt) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
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
        return (String)localObject1 + " " + V(paramContext, paramInt) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_sunday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_monday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_tuesday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_wednesday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_thursday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_friday);
        continue;
        localObject1 = paramContext.getString(a.h.fmt_pre_next_week_saturday);
      }
    }
    if (((GregorianCalendar)localObject1).get(1) == ((GregorianCalendar)localObject2).get(1)) {
      return android.text.format.DateFormat.format(paramContext.getString(a.h.fmt_date), l1) + " " + V(paramContext, paramInt) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
    }
    return android.text.format.DateFormat.format(paramContext.getString(a.h.fmt_longdate), l1) + " " + V(paramContext, paramInt) + ";" + aq(paramContext.getString(a.h.fmt_normal_time), l1);
  }
  
  public static String U(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return paramContext.getString(a.h.fmt_pre_week_sunday);
    case 2: 
      return paramContext.getString(a.h.fmt_pre_week_monday);
    case 3: 
      return paramContext.getString(a.h.fmt_pre_week_tuesday);
    case 4: 
      return paramContext.getString(a.h.fmt_pre_week_wednesday);
    case 5: 
      return paramContext.getString(a.h.fmt_pre_week_thursday);
    case 6: 
      return paramContext.getString(a.h.fmt_pre_week_friday);
    }
    return paramContext.getString(a.h.fmt_pre_week_saturday);
  }
  
  private static CharSequence V(Context paramContext, int paramInt)
  {
    if (paramInt < 0) {
      return "";
    }
    if (paramInt < 6L) {
      return paramContext.getString(a.h.fmt_dawn);
    }
    if (paramInt < 12L) {
      return paramContext.getString(a.h.fmt_morning);
    }
    if (paramInt < 13L) {
      return paramContext.getString(a.h.fmt_noon);
    }
    if (paramInt < 18L) {
      return paramContext.getString(a.h.fmt_afternoon);
    }
    return paramContext.getString(a.h.fmt_evening);
  }
  
  public static String aq(String paramString, long paramLong)
  {
    paramString = android.text.format.DateFormat.format(paramString, paramLong).toString();
    if (bk.bl(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      paramString = str;
    } while (!str.startsWith("0"));
    return str.substring(1);
  }
  
  public static CharSequence c(Context paramContext, long paramLong, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (!x.cqG())
    {
      localObject2 = x.Zi(x.cqJ());
      localObject1 = new GregorianCalendar();
      if (paramLong < 3600000L) {
        localObject1 = "";
      }
    }
    Object localObject3;
    do
    {
      do
      {
        return localObject1;
        localObject3 = new GregorianCalendar(((GregorianCalendar)localObject1).get(1), ((GregorianCalendar)localObject1).get(2), ((GregorianCalendar)localObject1).get(5));
        long l = paramLong - ((GregorianCalendar)localObject3).getTimeInMillis();
        if ((l > 0L) && (l <= 86400000L))
        {
          paramContext = java.text.DateFormat.getTimeInstance(3, (Locale)localObject2);
          return paramContext.format(Long.valueOf(paramLong));
        }
        l = paramLong - ((GregorianCalendar)localObject3).getTimeInMillis() + 86400000L;
        if ((l > 0L) && (l <= 86400000L))
        {
          if (paramBoolean) {
            return paramContext.getString(a.h.fmt_pre_yesterday);
          }
          return paramContext.getString(a.h.fmt_pre_yesterday) + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject2).format(Long.valueOf(paramLong));
        }
        paramContext = new GregorianCalendar();
        paramContext.setTimeInMillis(paramLong);
        if ((((GregorianCalendar)localObject1).get(1) != paramContext.get(1)) || (((GregorianCalendar)localObject1).get(3) != paramContext.get(3))) {
          break;
        }
        paramContext = new SimpleDateFormat("E", (Locale)localObject2);
        paramContext = paramContext.format(Long.valueOf(paramLong));
        localObject1 = paramContext;
      } while (paramBoolean);
      return paramContext + " " + java.text.DateFormat.getTimeInstance(3, (Locale)localObject2).format(Long.valueOf(paramLong));
      if (((GregorianCalendar)localObject1).get(1) == paramContext.get(1))
      {
        if (paramBoolean) {
          return java.text.DateFormat.getDateInstance(3, (Locale)localObject2).format(Long.valueOf(paramLong));
        }
        return java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject2).format(Long.valueOf(paramLong));
      }
      if (paramBoolean) {
        return java.text.DateFormat.getDateInstance(3, (Locale)localObject2).format(Long.valueOf(paramLong));
      }
      return java.text.DateFormat.getDateTimeInstance(3, 3, (Locale)localObject2).format(Long.valueOf(paramLong));
      if (paramLong < 3600000L) {
        return "";
      }
      localObject3 = new Time();
      localObject1 = new Time();
      ((Time)localObject3).set(paramLong);
      ((Time)localObject1).setToNow();
      if ((((Time)localObject3).year == ((Time)localObject1).year) && (((Time)localObject3).yearDay == ((Time)localObject1).yearDay))
      {
        if (clh()) {
          return g.a(paramContext.getString(a.h.fmt_normal_time_24), (Time)localObject3);
        }
        return V(paramContext, ((Time)localObject3).hour) + g.a(paramContext.getString(a.h.fmt_normal_time), (Time)localObject3);
      }
      if ((((Time)localObject3).year == ((Time)localObject1).year) && (((Time)localObject1).yearDay - ((Time)localObject3).yearDay == 1))
      {
        boolean bool = clh();
        if (paramBoolean) {
          return paramContext.getString(a.h.fmt_pre_yesterday);
        }
        localObject1 = new StringBuilder().append(paramContext.getString(a.h.fmt_pre_yesterday)).append(" ");
        if (bool) {}
        for (paramContext = g.a(paramContext.getString(a.h.fmt_normal_time_24), (Time)localObject3);; paramContext = V(paramContext, ((Time)localObject3).hour) + g.a(paramContext.getString(a.h.fmt_normal_time), (Time)localObject3)) {
          return paramContext;
        }
      }
      if ((((Time)localObject3).year != ((Time)localObject1).year) || (((Time)localObject3).getWeekNumber() != ((Time)localObject1).getWeekNumber())) {
        break;
      }
      localObject2 = g.a("E ", (Time)localObject3);
      localObject1 = localObject2;
    } while (paramBoolean);
    return (String)localObject2 + g.a(paramContext.getString(a.h.fmt_patime), (Time)localObject3);
    if (((Time)localObject3).year == ((Time)localObject1).year)
    {
      if (paramBoolean) {
        return g.a(paramContext.getString(a.h.fmt_date), (Time)localObject3);
      }
      return g.a(paramContext.getString(a.h.fmt_datetime, new Object[] { p(paramContext, ((Time)localObject3).hour * 3600000L) }).toString(), (Time)localObject3);
    }
    if (paramBoolean) {
      return g.a(paramContext.getString(a.h.fmt_longdate), (Time)localObject3);
    }
    return g.a(paramContext.getString(a.h.fmt_longtime, new Object[] { p(paramContext, ((Time)localObject3).hour * 3600000L) }).toString(), (Time)localObject3);
  }
  
  public static boolean clh()
  {
    if (System.currentTimeMillis() - rVM > 30000L) {
      rVN = android.text.format.DateFormat.is24HourFormat(ae.getContext());
    }
    return rVN;
  }
  
  public static String g(String paramString, long paramLong)
  {
    return new SimpleDateFormat(paramString).format(new Date(1000L * paramLong));
  }
  
  public static CharSequence n(Context paramContext, long paramLong)
  {
    return paramContext.getString(a.h.fmt_voip_longtime_prefix) + android.text.format.DateFormat.format(paramContext.getString(a.h.fmt_voip_longtime), paramLong);
  }
  
  public static CharSequence o(Context paramContext, long paramLong)
  {
    return paramContext.getString(a.h.fmt_voip_voice_longtime_prefix) + android.text.format.DateFormat.format(paramContext.getString(a.h.fmt_voip_longtime), paramLong);
  }
  
  public static CharSequence p(Context paramContext, long paramLong)
  {
    if (paramLong < 0L) {
      return "";
    }
    if (paramLong < 21600000L) {
      return paramContext.getString(a.h.fmt_dawn);
    }
    if (paramLong < 43200000L) {
      return paramContext.getString(a.h.fmt_morning);
    }
    if (paramLong < 46800000L) {
      return paramContext.getString(a.h.fmt_noon);
    }
    if (paramLong < 64800000L) {
      return paramContext.getString(a.h.fmt_afternoon);
    }
    return paramContext.getString(a.h.fmt_evening);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.h
 * JD-Core Version:    0.7.0.1
 */