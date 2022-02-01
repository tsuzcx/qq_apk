package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class y
{
  private static y MpQ = null;
  public Context MpR;
  WebView.c MpS = WebView.c.Mqt;
  public boolean MpT = false;
  public boolean MpU = false;
  public boolean MpV = false;
  public boolean MpW = false;
  boolean MpX = false;
  public boolean MpY = false;
  public boolean MpZ = false;
  public JsRuntime.JsRuntimeType Mqa = JsRuntime.JsRuntimeType.Mpw;
  public boolean Mqb = false;
  public boolean Mqc = false;
  
  public static y gaM()
  {
    return MpQ;
  }
  
  public static void lx(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (MpQ != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new y();
    MpQ = (y)localObject;
    ((y)localObject).MpR = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    MpQ.MpU = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    MpQ.MpV = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    MpQ.MpW = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      MpQ.Mqa = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      MpQ.MpT = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      y localy = MpQ;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localy.Mqb = bool;
        MpQ.MpY = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (MpQ.MpY)
        {
          localObject = MpQ.MpR.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        MpQ.MpZ = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        MpQ.Mqc = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
        AppMethodBeat.o(156781);
        return;
      }
    }
    catch (Exception localException)
    {
      break label131;
    }
  }
  
  public final String a(String[] paramArrayOfString, f.a parama)
  {
    AppMethodBeat.i(156789);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(156789);
      return "";
    }
    Object localObject = this.MpR.getSharedPreferences("wcwebview", 4);
    if (localObject == null)
    {
      AppMethodBeat.o(156789);
      return "";
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(156789);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str1 = paramArrayOfString[i];
      String[] arrayOfString = f.Mpg;
      int m = arrayOfString.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString[j];
        if (str2.equalsIgnoreCase(str1))
        {
          ((SharedPreferences.Editor)localObject).putString("force_fr_" + str1.toLowerCase(), parama.toString());
          localStringBuilder.append(str2).append(",");
        }
        j += 1;
      }
      i += 1;
    }
    if (((SharedPreferences.Editor)localObject).commit())
    {
      paramArrayOfString = localStringBuilder.toString();
      AppMethodBeat.o(156789);
      return paramArrayOfString;
    }
    AppMethodBeat.o(156789);
    return "";
  }
  
  public final void a(JsRuntime.JsRuntimeType paramJsRuntimeType)
  {
    AppMethodBeat.i(156792);
    if (this.Mqa == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.Mqa = paramJsRuntimeType;
    this.MpR.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.MpR == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156783);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("HardCodeWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156783);
  }
  
  public final void b(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156784);
    if ((this.MpR == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c baY(String paramString)
  {
    AppMethodBeat.i(156782);
    if ((paramString == null) || (paramString.isEmpty()) || (this.MpR == null))
    {
      paramString = WebView.c.Mqt;
      AppMethodBeat.o(156782);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.Mqt;
      AppMethodBeat.o(156782);
      return paramString;
    }
    String str2 = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
    if ((str2 != null) && (!str2.isEmpty())) {
      XWalkEnvironment.addXWalkInitializeLog("has hardcode type = ".concat(String.valueOf(str2)));
    }
    String str1;
    if ((str2 != null) && (!str2.isEmpty()))
    {
      str1 = str2;
      if (!str2.equals(WebView.c.Mqt.toString())) {}
    }
    else
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      str1 = paramString;
      if (paramString != null)
      {
        str1 = paramString;
        if (!paramString.isEmpty())
        {
          XWalkEnvironment.addXWalkInitializeLog("has abtest type = ".concat(String.valueOf(paramString)));
          str1 = paramString;
        }
      }
    }
    if ((str1 == null) || (str1.isEmpty())) {
      this.MpS = WebView.c.Mqt;
    }
    for (;;)
    {
      paramString = this.MpS;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.MpS = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.MpS = WebView.c.Mqt;
      }
    }
  }
  
  public final f.a baZ(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.MpR.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.Mpi;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.baK(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final WebView.c dk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.MpR == null))
    {
      paramString = WebView.c.Mqt;
      AppMethodBeat.o(175638);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.Mqt;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label132;
      }
      this.MpS = WebView.c.Mqt;
    }
    for (;;)
    {
      paramString = this.MpS;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label132:
        this.MpS = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.MpS = WebView.c.Mqt;
      }
    }
  }
  
  public final boolean gaN()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.MpR.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean gaO()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.MpR.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void gaP()
  {
    AppMethodBeat.i(156794);
    XWalkEnvironment.initTurnOnKVLog();
    this.MpR.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    AppMethodBeat.o(156794);
  }
  
  public final boolean gaQ()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.MpR.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.Mqc)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.Mqc = paramBoolean;
    this.MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
  
  public final void zE(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.MpT)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.MpT = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void zF(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.MpW)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.MpW = paramBoolean;
    this.MpR.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.MpW).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void zG(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.Mqb)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.Mqb = paramBoolean;
    if (this.Mqb)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.MpR, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        j.g(WebView.c.Mqu).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.MpR, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.MpR, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    j.g(WebView.c.Mqu).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(156793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */