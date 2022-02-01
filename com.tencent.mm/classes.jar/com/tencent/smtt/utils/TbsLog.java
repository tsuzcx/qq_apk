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
    AppMethodBeat.i(54000);
    a = true;
    b = true;
    c = null;
    sTbsLogList = new LinkedList();
    sLogMaxCount = 10;
    AppMethodBeat.o(54000);
  }
  
  public static void addLog(int paramInt, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(53999);
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
        AppMethodBeat.o(53999);
        return;
        paramString = finally;
        AppMethodBeat.o(53999);
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
    AppMethodBeat.i(53983);
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
          AppMethodBeat.o(53983);
          return;
        }
        i += 1;
      }
      return;
    }
    finally
    {
      w(paramString, "app_extra exception:" + Log.getStackTraceString(paramContext));
      AppMethodBeat.o(53983);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53990);
    if (c == null)
    {
      AppMethodBeat.o(53990);
      return;
    }
    c.d(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(53990);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53991);
    d(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(53991);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53986);
    if (c == null)
    {
      AppMethodBeat.o(53986);
      return;
    }
    c.e(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(E)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(53986);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53987);
    e(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(53987);
  }
  
  public static String getTbsLogFilePath()
  {
    AppMethodBeat.i(53996);
    if (TbsLogClient.c != null)
    {
      String str = TbsLogClient.c.getAbsolutePath();
      AppMethodBeat.o(53996);
      return str;
    }
    AppMethodBeat.o(53996);
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53984);
    if (c == null)
    {
      AppMethodBeat.o(53984);
      return;
    }
    c.i(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(I)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(53984);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53985);
    i(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(53985);
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(53997);
      if (c == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      AppMethodBeat.o(53997);
      return;
    }
    finally {}
  }
  
  public static void setLogView(TextView paramTextView)
  {
    AppMethodBeat.i(53994);
    if ((paramTextView == null) || (c == null))
    {
      AppMethodBeat.o(53994);
      return;
    }
    c.setLogView(paramTextView);
    AppMethodBeat.o(53994);
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    AppMethodBeat.i(53995);
    if (paramTbsLogClient == null)
    {
      AppMethodBeat.o(53995);
      return false;
    }
    c = paramTbsLogClient;
    TbsLogClient.setWriteLogJIT(b);
    AppMethodBeat.o(53995);
    return true;
  }
  
  public static void setWriteLogJIT(boolean paramBoolean)
  {
    AppMethodBeat.i(53982);
    b = paramBoolean;
    if (c == null)
    {
      AppMethodBeat.o(53982);
      return;
    }
    TbsLogClient.setWriteLogJIT(paramBoolean);
    AppMethodBeat.o(53982);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53992);
    if (c == null)
    {
      AppMethodBeat.o(53992);
      return;
    }
    c.v(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(53992);
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53993);
    v(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(53993);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(53988);
    if (c == null)
    {
      AppMethodBeat.o(53988);
      return;
    }
    c.w(paramString1, "TBS:".concat(String.valueOf(paramString2)));
    c.writeLog("(W)-" + paramString1 + "-TBS:" + paramString2);
    AppMethodBeat.o(53988);
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(53989);
    w(paramString1, paramString2);
    if ((c != null) && (a) && (paramBoolean)) {
      c.showLog(paramString1 + ": " + paramString2);
    }
    AppMethodBeat.o(53989);
  }
  
  public static void writeLogToDisk()
  {
    try
    {
      AppMethodBeat.i(53998);
      if (c != null) {
        c.writeLogToDisk();
      }
      AppMethodBeat.o(53998);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLog
 * JD-Core Version:    0.7.0.1
 */