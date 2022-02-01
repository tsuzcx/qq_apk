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
  private static y Kzv = null;
  public boolean KzA = false;
  public boolean KzB = false;
  boolean KzC = false;
  public boolean KzD = false;
  public boolean KzE = false;
  public JsRuntime.JsRuntimeType KzF = JsRuntime.JsRuntimeType.Kzb;
  public boolean KzG = false;
  public boolean KzH = false;
  public Context Kzw;
  WebView.c Kzx = WebView.c.KzY;
  public boolean Kzy = false;
  public boolean Kzz = false;
  
  public static y fJs()
  {
    return Kzv;
  }
  
  public static void lk(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (Kzv != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new y();
    Kzv = (y)localObject;
    ((y)localObject).Kzw = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    Kzv.Kzz = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    Kzv.KzA = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    Kzv.KzB = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      Kzv.KzF = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      Kzv.Kzy = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      y localy = Kzv;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localy.KzG = bool;
        Kzv.KzD = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (Kzv.KzD)
        {
          localObject = Kzv.Kzw.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        Kzv.KzE = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        Kzv.KzH = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
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
    Object localObject = this.Kzw.getSharedPreferences("wcwebview", 4);
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
      String[] arrayOfString = f.KyK;
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
    if (this.KzF == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.KzF = paramJsRuntimeType;
    this.Kzw.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.Kzw == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156783);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("HardCodeWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156783);
  }
  
  public final WebView.c aUV(String paramString)
  {
    AppMethodBeat.i(156782);
    if ((paramString == null) || (paramString.isEmpty()) || (this.Kzw == null))
    {
      paramString = WebView.c.KzY;
      AppMethodBeat.o(156782);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.KzY;
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
      if (!str2.equals(WebView.c.KzY.toString())) {}
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
      this.Kzx = WebView.c.KzY;
    }
    for (;;)
    {
      paramString = this.Kzx;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.Kzx = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.Kzx = WebView.c.KzY;
      }
    }
  }
  
  public final f.a aUW(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.Kzw.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.KyM;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.aUH(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final void b(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156784);
    if ((this.Kzw == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c df(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.Kzw == null))
    {
      paramString = WebView.c.KzY;
      AppMethodBeat.o(175638);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.KzY;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label132;
      }
      this.Kzx = WebView.c.KzY;
    }
    for (;;)
    {
      paramString = this.Kzx;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label132:
        this.Kzx = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.Kzx = WebView.c.KzY;
      }
    }
  }
  
  public final boolean fJt()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.Kzw.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean fJu()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.Kzw.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void fJv()
  {
    AppMethodBeat.i(156794);
    XWalkEnvironment.initTurnOnKVLog();
    this.Kzw.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    AppMethodBeat.o(156794);
  }
  
  public final boolean fJw()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.Kzw.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.KzH)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.KzH = paramBoolean;
    this.Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
  
  public final void yR(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.Kzy)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.Kzy = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void yS(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.KzB)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.KzB = paramBoolean;
    this.Kzw.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.KzB).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void yT(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.KzG)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.KzG = paramBoolean;
    if (this.KzG)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.Kzw, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        j.g(WebView.c.KzZ).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.Kzw, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.Kzw, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    j.g(WebView.c.KzZ).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(156793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */