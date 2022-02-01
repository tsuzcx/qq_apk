package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class y
{
  private static y SzP = null;
  public boolean SAa = false;
  public boolean SAb = false;
  public Context SzQ;
  WebView.c SzR = WebView.c.SAs;
  public boolean SzS = false;
  public boolean SzT = false;
  public boolean SzU = false;
  public boolean SzV = false;
  boolean SzW = false;
  public boolean SzX = false;
  public boolean SzY = false;
  public JsRuntime.JsRuntimeType SzZ = JsRuntime.JsRuntimeType.Szv;
  
  public static y hsF()
  {
    return SzP;
  }
  
  public static void lC(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (SzP != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new y();
    SzP = (y)localObject;
    ((y)localObject).SzQ = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    SzP.SzT = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    SzP.SzU = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    SzP.SzV = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      SzP.SzZ = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      SzP.SzS = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      y localy = SzP;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localy.SAa = bool;
        SzP.SzX = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (SzP.SzX)
        {
          localObject = SzP.SzQ.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        SzP.SzY = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        SzP.SAb = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
        AppMethodBeat.o(156781);
        return;
      }
    }
    catch (Exception localException)
    {
      break label131;
    }
  }
  
  public final void Ei(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.SzV)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.SzV = paramBoolean;
    this.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.SzV).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void Ej(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.SAa)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.SAa = paramBoolean;
    if (this.SAa)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        l.g(WebView.c.SAt).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.SzQ, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    l.g(WebView.c.SAt).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(156793);
  }
  
  public final String a(String[] paramArrayOfString, f.a parama)
  {
    AppMethodBeat.i(156789);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(156789);
      return "";
    }
    Object localObject = this.SzQ.getSharedPreferences("wcwebview", 4);
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
      String[] arrayOfString = f.SyR;
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
  
  public final String a(String[] paramArrayOfString, f.c paramc)
  {
    AppMethodBeat.i(219047);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(219047);
      return "";
    }
    Object localObject = this.SzQ.getSharedPreferences("wcwebview", 4);
    if (localObject == null)
    {
      AppMethodBeat.o(219047);
      return "";
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(219047);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str1 = paramArrayOfString[i];
      String[] arrayOfString = f.SyR;
      int m = arrayOfString.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString[j];
        if (str2.equalsIgnoreCase(str1))
        {
          ((SharedPreferences.Editor)localObject).putString("force_use_office_reader_" + str1.toLowerCase(), paramc.toString());
          localStringBuilder.append(str2).append(",");
        }
        j += 1;
      }
      i += 1;
    }
    if (((SharedPreferences.Editor)localObject).commit())
    {
      paramArrayOfString = localStringBuilder.toString();
      AppMethodBeat.o(219047);
      return paramArrayOfString;
    }
    AppMethodBeat.o(219047);
    return "";
  }
  
  public final void a(JsRuntime.JsRuntimeType paramJsRuntimeType)
  {
    AppMethodBeat.i(156792);
    if (this.SzZ == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.SzZ = paramJsRuntimeType;
    this.SzQ.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.SzQ == null) || (paramString == null) || (paramString.isEmpty()))
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
    if ((this.SzQ == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c bsk(String paramString)
  {
    AppMethodBeat.i(156782);
    if ((paramString == null) || (paramString.isEmpty()) || (this.SzQ == null))
    {
      paramString = WebView.c.SAs;
      AppMethodBeat.o(156782);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.SAs;
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
      if (!str2.equals(WebView.c.SAs.toString())) {}
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
      this.SzR = WebView.c.SAs;
    }
    for (;;)
    {
      paramString = this.SzR;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.SzR = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.SzR = WebView.c.SAs;
      }
    }
  }
  
  public final f.a bsl(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.SyT;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.brU(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final f.c bsm(String paramString)
  {
    AppMethodBeat.i(219046);
    try
    {
      SharedPreferences localSharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
      if (localSharedPreferences == null)
      {
        paramString = f.c.SyY;
        AppMethodBeat.o(219046);
        return paramString;
      }
      paramString = b.brS(localSharedPreferences.getString("force_use_office_reader_" + paramString.toLowerCase(), ""));
      AppMethodBeat.o(219046);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("WebDebugCfg", "getForceUseOfficeReader error ", paramString);
      paramString = f.c.SyY;
      AppMethodBeat.o(219046);
    }
    return paramString;
  }
  
  public final WebView.c dI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.SzQ == null))
    {
      paramString = WebView.c.SAs;
      AppMethodBeat.o(175638);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.SAs;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label135;
      }
      this.SzR = WebView.c.SAs;
    }
    for (;;)
    {
      paramString = this.SzR;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label135:
        this.SzR = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.SzR = WebView.c.SAs;
      }
    }
  }
  
  public final boolean hsG()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean hsH()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.SzQ.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void hsI()
  {
    AppMethodBeat.i(156794);
    XWalkEnvironment.initTurnOnKVLog();
    this.SzQ.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    AppMethodBeat.o(156794);
  }
  
  public final boolean hsJ()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.SzQ.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.SzS)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.SzS = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.SAb)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.SAb = paramBoolean;
    this.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */