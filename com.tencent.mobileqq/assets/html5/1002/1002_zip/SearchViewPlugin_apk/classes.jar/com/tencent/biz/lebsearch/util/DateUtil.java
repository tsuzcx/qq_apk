package com.tencent.biz.lebsearch.util;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
  public static final String DAYS_AGO = "天前";
  public static final String HOURS_AGO = "小时前";
  public static final String JUST_MINS = "刚刚";
  public static final String MINS_AGO = "分钟前";
  
  public static String getDateString(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return "刚刚";
    }
    if ((l >= 60L) && (l < 3600L)) {
      return l / 60L + "分钟前";
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return l / 3600L + "小时前";
    }
    if ((l >= 86400L) && (l < 432000L)) {
      return l / 86400L + "天前";
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(1000L * paramLong));
  }
  
  public static String getDateString(String paramString)
  {
    try
    {
      paramString = getDateString(Long.valueOf(paramString).longValue());
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("DateUtil", paramString + "");
    }
    return "未知";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\html5\1002\1002_zip\SearchViewPlugin_apk\classes.jar
 * Qualified Name:     com.tencent.biz.lebsearch.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */