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

public final class x
{
  private static x IMX = null;
  public Context IMY;
  WebView.c IMZ = WebView.c.INB;
  public boolean INa = false;
  public boolean INb = false;
  public boolean INc = false;
  public boolean INd = false;
  boolean INe = false;
  public boolean INf = false;
  public boolean INg = false;
  public JsRuntime.JsRuntimeType INh = JsRuntime.JsRuntimeType.IMD;
  public boolean INi = false;
  public boolean INj = false;
  String INk = "";
  
  public static x fqR()
  {
    return IMX;
  }
  
  public static void kW(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (IMX != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new x();
    IMX = (x)localObject;
    ((x)localObject).IMY = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    IMX.INb = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    IMX.INc = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    IMX.INd = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      IMX.INh = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      IMX.INa = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      x localx = IMX;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localx.INi = bool;
        IMX.INf = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (IMX.INf)
        {
          localObject = IMX.IMY.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        IMX.INg = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        IMX.INj = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
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
    Object localObject = this.IMY.getSharedPreferences("wcwebview", 4);
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
      String[] arrayOfString = f.IMr;
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
    if (this.INh == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.INh = paramJsRuntimeType;
    this.IMY.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.IMY == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156783);
      return;
    }
    this.INk = paramString;
    this.IMZ = paramc;
    this.IMY.getSharedPreferences("wcwebview", 4).edit().putString("HardCodeWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156783);
  }
  
  public final WebView.c aPc(String paramString)
  {
    AppMethodBeat.i(156782);
    if (this.INk.equals(paramString))
    {
      paramString = this.IMZ;
      AppMethodBeat.o(156782);
      return paramString;
    }
    if ((paramString == null) || (paramString.isEmpty()) || (this.IMY == null))
    {
      paramString = WebView.c.INB;
      AppMethodBeat.o(156782);
      return paramString;
    }
    this.INk = paramString;
    SharedPreferences localSharedPreferences = this.IMY.getSharedPreferences("wcwebview", 0);
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.INB;
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
      if (!str2.equals(WebView.c.INB.toString())) {}
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
      this.IMZ = WebView.c.INB;
    }
    for (;;)
    {
      paramString = this.IMZ;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.IMZ = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.IMZ = WebView.c.INB;
      }
    }
  }
  
  public final f.a aPd(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.IMY.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.IMt;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.aOU(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final void b(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156784);
    if ((this.IMY == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    this.IMY.getSharedPreferences("wcwebview", 4).edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    Object localObject = this.IMY.getSharedPreferences("wcwebview", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        AppMethodBeat.o(156784);
        return;
      }
    }
    this.INk = paramString;
    this.IMZ = paramc;
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c da(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.IMY == null))
    {
      paramString = WebView.c.INB;
      AppMethodBeat.o(175638);
      return paramString;
    }
    this.INk = paramString;
    SharedPreferences localSharedPreferences = this.IMY.getSharedPreferences("wcwebview", 0);
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.INB;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label142;
      }
      this.IMZ = WebView.c.INB;
    }
    for (;;)
    {
      paramString = this.IMZ;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label142:
        this.IMZ = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.IMZ = WebView.c.INB;
      }
    }
  }
  
  public final boolean fqS()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.IMY.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean fqT()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.IMY.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void fqU()
  {
    AppMethodBeat.i(156794);
    XWalkEnvironment.initTurnOnKVLog();
    this.IMY.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    AppMethodBeat.o(156794);
  }
  
  public final boolean fqV()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.IMY.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.INj)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.INj = paramBoolean;
    this.IMY.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
  
  public final void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.INa)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.INa = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void xC(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.INi)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.INi = paramBoolean;
    if (this.INi)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.IMY, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        j.g(WebView.c.INC).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.IMY, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.IMY, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    j.g(WebView.c.INC).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(156793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x
 * JD-Core Version:    0.7.0.1
 */