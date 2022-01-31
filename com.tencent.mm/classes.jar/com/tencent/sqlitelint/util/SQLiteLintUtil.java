package com.tencent.sqlitelint.util;

import com.tencent.sqlitelint.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class SQLiteLintUtil
{
  public static String agb(String paramString)
  {
    if (bl(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("/");
    } while ((paramString == null) || (paramString.length <= 0));
    return paramString[(paramString.length - 1)];
  }
  
  public static boolean bl(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static String g(String paramString, long paramLong)
  {
    return new SimpleDateFormat(paramString).format(new Date(paramLong));
  }
  
  public static String getThrowableStack()
  {
    try
    {
      String str = getThrowableStack(new Throwable());
      return str;
    }
    catch (Throwable localThrowable)
    {
      SLog.e("SQLiteLint.SQLiteLintUtil", "getThrowableStack ex %s", new Object[] { localThrowable.getMessage() });
    }
    return "";
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject = paramThrowable.getStackTrace();
    if (localObject == null) {
      return "";
    }
    paramThrowable = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      if (!localObject[i].getClassName().contains("com.tencent.sqlitelint")) {
        paramThrowable.add(localObject[i]);
      }
      i += 1;
    }
    if ((paramThrowable.size() > 6) && (e.bnW != null))
    {
      localObject = paramThrowable.listIterator(paramThrowable.size());
      do
      {
        if (!((ListIterator)localObject).hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)((ListIterator)localObject).previous()).getClassName().contains(e.bnW)) {
          ((ListIterator)localObject).remove();
        }
      } while (paramThrowable.size() > 6);
    }
    localObject = new StringBuffer(paramThrowable.size());
    paramThrowable = paramThrowable.iterator();
    while (paramThrowable.hasNext()) {
      ((StringBuffer)localObject).append((StackTraceElement)paramThrowable.next()).append('\n');
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public static String pm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SQLiteLintUtil
 * JD-Core Version:    0.7.0.1
 */