package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

public class SQLiteLintUtil
{
  private static final int DEFAULT_MAX_STACK_LAYER = 6;
  private static final String TAG = "SQLiteLint.SQLiteLintUtil";
  public static final String YYYY_MM_DD_HH_mm = "yyyy-MM-dd HH:mm";
  
  public static String extractDbName(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(52966);
    if (isNullOrNil(paramString))
    {
      AppMethodBeat.o(52966);
      return null;
    }
    String[] arrayOfString = paramString.split("/");
    paramString = localObject;
    if (arrayOfString != null)
    {
      paramString = localObject;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[(arrayOfString.length - 1)];
      }
    }
    AppMethodBeat.o(52966);
    return paramString;
  }
  
  public static String formatTime(String paramString, long paramLong)
  {
    AppMethodBeat.i(52968);
    paramString = new SimpleDateFormat(paramString).format(new Date(paramLong));
    AppMethodBeat.o(52968);
    return paramString;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(52967);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(52967);
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(52967);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(52967);
    }
    return paramInt;
  }
  
  public static String getThrowableStack()
  {
    AppMethodBeat.i(52972);
    try
    {
      String str = getThrowableStack(new Throwable());
      AppMethodBeat.o(52972);
      return str;
    }
    finally
    {
      SLog.e("SQLiteLint.SQLiteLintUtil", "getThrowableStack ex %s", new Object[] { localObject.getMessage() });
      AppMethodBeat.o(52972);
    }
    return "";
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    AppMethodBeat.i(52971);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(52971);
      return "";
    }
    paramThrowable = stackTraceToString(paramThrowable.getStackTrace());
    AppMethodBeat.o(52971);
    return paramThrowable;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(52965);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(52965);
      return true;
    }
    AppMethodBeat.o(52965);
    return false;
  }
  
  public static void mkdirs(String paramString)
  {
    AppMethodBeat.i(52969);
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      paramString = paramString.getParentFile();
      if (paramString != null) {
        paramString.mkdirs();
      }
    }
    AppMethodBeat.o(52969);
  }
  
  public static String nullAsNil(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(52970);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(52970);
      return "";
    }
    Object localObject = new ArrayList(paramArrayOfStackTraceElement.length);
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      if (!paramArrayOfStackTraceElement[i].getClassName().contains("com.tencent.sqlitelint")) {
        ((ArrayList)localObject).add(paramArrayOfStackTraceElement[i]);
      }
      i += 1;
    }
    if ((((ArrayList)localObject).size() > 6) && (SQLiteLint.sPackageName != null))
    {
      paramArrayOfStackTraceElement = ((ArrayList)localObject).listIterator(((ArrayList)localObject).size());
      do
      {
        if (!paramArrayOfStackTraceElement.hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)paramArrayOfStackTraceElement.previous()).getClassName().contains(SQLiteLint.sPackageName)) {
          paramArrayOfStackTraceElement.remove();
        }
      } while (((ArrayList)localObject).size() > 6);
    }
    paramArrayOfStackTraceElement = new StringBuffer(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfStackTraceElement.append((StackTraceElement)((Iterator)localObject).next()).append('\n');
    }
    paramArrayOfStackTraceElement = paramArrayOfStackTraceElement.toString();
    AppMethodBeat.o(52970);
    return paramArrayOfStackTraceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SQLiteLintUtil
 * JD-Core Version:    0.7.0.1
 */