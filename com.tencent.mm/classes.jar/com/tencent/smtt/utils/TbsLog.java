package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class TbsLog
{
  public static final int TBSLOG_CODE_SDK_BASE = 1000;
  public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
  public static final int TBSLOG_CODE_SDK_INIT = 999;
  public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
  public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
  public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
  public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
  public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
  public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
  public static final String X5LOGTAG = "x5logtag";
  private static boolean a = false;
  private static boolean b = true;
  private static TbsLogClient c = null;
  public static int sLogMaxCount = 10;
  public static List<String> sTbsLogList = new LinkedList();
  
  public static void addLog(int paramInt, String paramString, Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        synchronized (sTbsLogList)
        {
          if (sTbsLogList.size() > sLogMaxCount)
          {
            int i = sTbsLogList.size() - sLogMaxCount;
            if ((i > 0) && (sTbsLogList.size() > 0))
            {
              sTbsLogList.remove(0);
              i -= 1;
              continue;
            }
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (paramString == null) {}
        }
      }
      catch (Exception paramString)
      {
        Object localObject2;
        Object localObject1;
        continue;
      }
      try
      {
        localObject1 = String.format(paramString, paramVarArgs);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        paramString = String.format("[%d][%d][%c][%d]%s", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(1), Character.valueOf('0'), Integer.valueOf(paramInt), paramString });
        sTbsLogList.add(paramString);
        return;
        paramString = finally;
        throw paramString;
      }
      catch (Exception paramString)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static void app_extra(String paramString, Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getApplicationContext();
      for (;;)
      {
        if (i < 6)
        {
          if (paramContext.getPackageName().contains(new String[] { "com.tencent.tbs", "com.tencent.mtt", "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.mtt.sdk.test", "com.qzone" }[i])) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + new String[] { "DEMO", "QB", "WX", "QQ", "TEST", "QZ" }[i] + "!");
          }
        }
        else
        {
          if (i == 6) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
          }
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      w(paramString, "app_extra exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (c == null) {}
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    d(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (c == null) {
      return;
    }
    c.writeLog("(E)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    e(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static String getTbsLogFilePath()
  {
    if (TbsLogClient.c != null) {
      return TbsLogClient.c.getAbsolutePath();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (c == null) {
      return;
    }
    c.writeLog("(I)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    i(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      if (c == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setLogView(TextView paramTextView)
  {
    if ((paramTextView == null) || (c == null)) {
      return;
    }
    c.setLogView(paramTextView);
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    if (paramTbsLogClient == null) {
      return false;
    }
    c = paramTbsLogClient;
    TbsLogClient.setWriteLogJIT(b);
    return true;
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    b = paramBoolean;
    if (c == null) {
      return;
    }
    TbsLogClient.setWriteLogJIT(paramBoolean);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (c == null) {}
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    v(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (c == null) {
      return;
    }
    c.writeLog("(W)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    w(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void writeLogToDisk()
  {
    try
    {
      if (c != null) {
        c.writeLogToDisk();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLog
 * JD-Core Version:    0.7.0.1
 */