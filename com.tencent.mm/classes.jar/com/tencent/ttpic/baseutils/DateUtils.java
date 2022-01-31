package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils
{
  public static final SimpleDateFormat DEFAULT_DATE_FORMAT;
  public static final SimpleDateFormat DEFAULT_FORMAT;
  public static final SimpleDateFormat EXIF_DATE_FORMAT;
  public static final SimpleDateFormat SERVER_DATE_FORMAT;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(49668);
    TAG = DateUtils.class.getSimpleName();
    DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SERVER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    AppMethodBeat.o(49668);
  }
  
  public static String buildClockFormatString(long paramLong)
  {
    AppMethodBeat.i(49663);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(49663);
      return "0.0s";
    }
    double d = (float)paramLong / 1000.0F;
    String str = String.format(Locale.US, "%.1fs", new Object[] { Double.valueOf(d) });
    AppMethodBeat.o(49663);
    return str;
  }
  
  public static long calcTimeCost(long paramLong)
  {
    AppMethodBeat.i(49653);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(49653);
    return l - paramLong;
  }
  
  public static int daysBetween(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49665);
    try
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd");
      paramString1 = ((SimpleDateFormat)localObject).parse(paramString1);
      paramString2 = ((SimpleDateFormat)localObject).parse(paramString2);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString1);
      long l = ((Calendar)localObject).getTimeInMillis();
      ((Calendar)localObject).setTime(paramString2);
      l = (((Calendar)localObject).getTimeInMillis() - l) / 86400000L;
      int i = (int)l;
      AppMethodBeat.o(49665);
      return i;
    }
    catch (Exception paramString1)
    {
      LogUtils.e(TAG, paramString1.getMessage());
      AppMethodBeat.o(49665);
    }
    return 0;
  }
  
  public static String format(Date paramDate)
  {
    AppMethodBeat.i(49654);
    paramDate = DEFAULT_FORMAT.format(paramDate);
    AppMethodBeat.o(49654);
    return paramDate;
  }
  
  public static String getCurrentFormatDate()
  {
    AppMethodBeat.i(49656);
    Object localObject = new Date();
    localObject = DEFAULT_DATE_FORMAT.format((Date)localObject);
    AppMethodBeat.o(49656);
    return localObject;
  }
  
  public static int getCurrentYear()
  {
    AppMethodBeat.i(49662);
    int i = Calendar.getInstance().get(1);
    AppMethodBeat.o(49662);
    return i;
  }
  
  public static Date getDefaultDate(String paramString)
  {
    try
    {
      AppMethodBeat.i(49658);
      paramString = parse(paramString, DEFAULT_FORMAT);
      AppMethodBeat.o(49658);
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
      AppMethodBeat.i(49655);
      Object localObject1 = new Date();
      localObject1 = SERVER_DATE_FORMAT.format((Date)localObject1);
      AppMethodBeat.o(49655);
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
      AppMethodBeat.i(49657);
      paramString = parse(paramString, SERVER_DATE_FORMAT);
      AppMethodBeat.o(49657);
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
    AppMethodBeat.i(49664);
    paramString1 = getDefaultDate(paramString1);
    paramString2 = getDefaultDate(paramString2);
    Date localDate = new Date();
    if ((paramString1 != null) && (paramString2 != null) && (localDate.after(paramString1)) && (localDate.before(paramString2)))
    {
      AppMethodBeat.o(49664);
      return false;
    }
    AppMethodBeat.o(49664);
    return true;
  }
  
  public static boolean isDuringNewYear()
  {
    boolean bool = true;
    AppMethodBeat.i(49667);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    LogUtils.d(TAG, "[isDuringNewYear] year = ".concat(String.valueOf(i)));
    LogUtils.d(TAG, "[isDuringNewYear] month = ".concat(String.valueOf(j)));
    LogUtils.d(TAG, "[isDuringNewYear] date = ".concat(String.valueOf(k)));
    if (i == 2018) {
      if ((j != 0) || (k <= 0) || (k > 5)) {}
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isDuringNewYear] newYear = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(49667);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static boolean isDuringXChristmas()
  {
    boolean bool = true;
    AppMethodBeat.i(49666);
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    LogUtils.d(TAG, "[isDuringXChristmas] year = ".concat(String.valueOf(i)));
    LogUtils.d(TAG, "[isDuringXChristmas] month = ".concat(String.valueOf(j)));
    LogUtils.d(TAG, "[isDuringXChristmas] date = ".concat(String.valueOf(k)));
    if (i == 2017) {
      if ((11 != j) || (k < 22) || (k > 26)) {}
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isDuringXChristmas] christmas = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(49666);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static Date parse(String paramString)
  {
    AppMethodBeat.i(49661);
    try
    {
      paramString = DEFAULT_FORMAT.parse(paramString);
      AppMethodBeat.o(49661);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
      AppMethodBeat.o(49661);
    }
    return null;
  }
  
  public static Date parse(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49660);
    try
    {
      paramString1 = new SimpleDateFormat(paramString2).parse(paramString1);
      AppMethodBeat.o(49660);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      LogUtils.e(paramString1);
      AppMethodBeat.o(49660);
    }
    return null;
  }
  
  public static Date parse(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    AppMethodBeat.i(49659);
    try
    {
      paramString = paramSimpleDateFormat.parse(paramString);
      AppMethodBeat.o(49659);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
      AppMethodBeat.o(49659);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.DateUtils
 * JD-Core Version:    0.7.0.1
 */