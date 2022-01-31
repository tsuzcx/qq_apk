package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static boolean a;
  private static boolean b;
  private static TbsLogClient c;
  public static int sLogMaxCount;
  public static List<String> sTbsLogList;
  
  static
  {
    AppMethodBeat.i(65337);
    a = false;
    b = true;
    c = null;
    sTbsLogList = new LinkedList();
    sLogMaxCount = 10;
    AppMethodBeat.o(65337);
  }
  
  public static void addLog(int paramInt, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(65336);
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
        AppMethodBeat.o(65336);
        return;
        paramString = finally;
        AppMethodBeat.o(65336);
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
    AppMethodBeat.i(65322);
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
          AppMethodBeat.o(65322);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      w(paramString, "app_extra exception:" + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(65322);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139525);
    if (c == null)
    {
      AppMethodBeat.o(139525);
      return;
    }
    c.d(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(139525);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65329);
    d(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(65329);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65325);
    if (c == null)
    {
      AppMethodBeat.o(65325);
      return;
    }
    c.e(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(E)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(65325);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65326);
    e(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(65326);
  }
  
  public static String getTbsLogFilePath()
  {
    AppMethodBeat.i(65333);
    if (TbsLogClient.c != null)
    {
      String str = TbsLogClient.c.getAbsolutePath();
      AppMethodBeat.o(65333);
      return str;
    }
    AppMethodBeat.o(65333);
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65323);
    if (c == null)
    {
      AppMethodBeat.o(65323);
      return;
    }
    c.i(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(I)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(65323);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65324);
    i(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(65324);
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(65334);
      if (c == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      AppMethodBeat.o(65334);
      return;
    }
    finally {}
  }
  
  public static void setLogView(TextView paramTextView)
  {
    AppMethodBeat.i(65331);
    if ((paramTextView == null) || (c == null))
    {
      AppMethodBeat.o(65331);
      return;
    }
    c.setLogView(paramTextView);
    AppMethodBeat.o(65331);
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    AppMethodBeat.i(65332);
    if (paramTbsLogClient == null)
    {
      AppMethodBeat.o(65332);
      return false;
    }
    c = paramTbsLogClient;
    TbsLogClient.setWriteLogJIT(b);
    AppMethodBeat.o(65332);
    return true;
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    AppMethodBeat.i(65321);
    b = paramBoolean;
    if (c == null)
    {
      AppMethodBeat.o(65321);
      return;
    }
    TbsLogClient.setWriteLogJIT(paramBoolean);
    AppMethodBeat.o(65321);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139526);
    if (c == null)
    {
      AppMethodBeat.o(139526);
      return;
    }
    c.v(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(139526);
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65330);
    v(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(65330);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65327);
    if (c == null)
    {
      AppMethodBeat.o(65327);
      return;
    }
    c.w(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(W)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(65327);
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(65328);
    w(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(65328);
  }
  
  public static void writeLogToDisk()
  {
    try
    {
      AppMethodBeat.i(65335);
      if (c != null) {
        c.writeLogToDisk();
      }
      AppMethodBeat.o(65335);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLog
 * JD-Core Version:    0.7.0.1
 */