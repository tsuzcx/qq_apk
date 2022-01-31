package com.tencent.ttpic.baseutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils
{
  public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
  public static final SimpleDateFormat DEFAULT_FORMAT;
  public static final SimpleDateFormat EXIF_DATE_FORMAT;
  public static final SimpleDateFormat SERVER_DATE_FORMAT;
  private static final String TAG = DateUtils.class.getSimpleName();
  
  static
  {
    DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SERVER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }
  
  public static String buildClockFormatString(long paramLong)
  {
    if (paramLong < 0L) {
      return "0.0s";
    }
    double d = (float)paramLong / 1000.0F;
    return String.format(Locale.US, "%.1fs", new Object[] { Double.valueOf(d) });
  }
  
  public static long calcTimeCost(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static String format(Date paramDate)
  {
    return DEFAULT_FORMAT.format(paramDate);
  }
  
  public static String getCurrentFormatDate()
  {
    Date localDate = new Date();
    return DEFAULT_DATE_FORMAT.format(localDate);
  }
  
  public static int getCurrentYear()
  {
    return Calendar.getInstance().get(1);
  }
  
  public static Date getDefaultDate(String paramString)
  {
    try
    {
      paramString = parse(paramString, DEFAULT_FORMAT);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String getNow2ServerFormat()
  {
    try
    {
      Object localObject1 = new Date();
      localObject1 = SERVER_DATE_FORMAT.format((Date)localObject1);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static Date getServerDate(String paramString)
  {
    try
    {
      paramString = parse(paramString, SERVER_DATE_FORMAT);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean isDateExpired(String paramString1, String paramString2)
  {
    paramString1 = getDefaultDate(paramString1);
    paramString2 = getDefaultDate(paramString2);
    Date localDate = new Date();
    return (paramString1 == null) || (paramString2 == null) || (!localDate.after(paramString1)) || (!localDate.before(paramString2));
  }
  
  public static boolean isDuringHallow()
  {
    boolean bool2 = true;
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    LogUtils.d(TAG, "[isDuringHallow] year = " + i);
    LogUtils.d(TAG, "[isDuringHallow] month = " + j);
    LogUtils.d(TAG, "[isDuringHallow] date = " + k);
    boolean bool1;
    if (i == 2017) {
      if (9 == j)
      {
        bool1 = bool2;
        if (k >= 26) {}
      }
      else
      {
        if ((10 != j) || (k > 1)) {
          break label155;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[isDuringHallow] hallow = " + bool1);
      return bool1;
      label155:
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public static Date parse(String paramString)
  {
    try
    {
      paramString = DEFAULT_FORMAT.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  public static Date parse(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new SimpleDateFormat(paramString2).parse(paramString1);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      LogUtils.e(paramString1);
    }
    return null;
  }
  
  public static Date parse(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      paramString = paramSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.DateUtils
 * JD-Core Version:    0.7.0.1
 */