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
  private static y MMU = null;
  public Context MMV;
  WebView.c MMW = WebView.c.MNx;
  public boolean MMX = false;
  public boolean MMY = false;
  public boolean MMZ = false;
  public boolean MNa = false;
  boolean MNb = false;
  public boolean MNc = false;
  public boolean MNd = false;
  public JsRuntime.JsRuntimeType MNe = JsRuntime.JsRuntimeType.MMA;
  public boolean MNf = false;
  public boolean MNg = false;
  
  public static y gfo()
  {
    return MMU;
  }
  
  public static void lD(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (MMU != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new y();
    MMU = (y)localObject;
    ((y)localObject).MMV = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    MMU.MMY = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    MMU.MMZ = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    MMU.MNa = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      MMU.MNe = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      MMU.MMX = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      y localy = MMU;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localy.MNf = bool;
        MMU.MNc = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (MMU.MNc)
        {
          localObject = MMU.MMV.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        MMU.MNd = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        MMU.MNg = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
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
    Object localObject = this.MMV.getSharedPreferences("wcwebview", 4);
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
      String[] arrayOfString = f.MMc;
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
    if (this.MNe == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.MNe = paramJsRuntimeType;
    this.MMV.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.MMV == null) || (paramString == null) || (paramString.isEmpty()))
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
    if ((this.MMV == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c bcB(String paramString)
  {
    AppMethodBeat.i(156782);
    if ((paramString == null) || (paramString.isEmpty()) || (this.MMV == null))
    {
      paramString = WebView.c.MNx;
      AppMethodBeat.o(156782);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.MNx;
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
      if (!str2.equals(WebView.c.MNx.toString())) {}
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
      this.MMW = WebView.c.MNx;
    }
    for (;;)
    {
      paramString = this.MMW;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.MMW = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.MMW = WebView.c.MNx;
      }
    }
  }
  
  public final f.a bcC(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.MMV.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.MMe;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.bcn(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final WebView.c dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.MMV == null))
    {
      paramString = WebView.c.MNx;
      AppMethodBeat.o(175638);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.MNx;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label132;
      }
      this.MMW = WebView.c.MNx;
    }
    for (;;)
    {
      paramString = this.MMW;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label132:
        this.MMW = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.MMW = WebView.c.MNx;
      }
    }
  }
  
  public final boolean gfp()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.MMV.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean gfq()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.MMV.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void gfr()
  {
    AppMethodBeat.i(156794);
    XWalkEnvironment.initTurnOnKVLog();
    this.MMV.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    AppMethodBeat.o(156794);
  }
  
  public final boolean gfs()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.MMV.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.MNg)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.MNg = paramBoolean;
    this.MMV.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
  
  public final void zR(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.MMX)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.MMX = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void zS(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.MNa)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.MNa = paramBoolean;
    this.MMV.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.MNa).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void zT(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.MNf)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.MNf = paramBoolean;
    if (this.MNf)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.MMV, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        j.g(WebView.c.MNy).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.MMV, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.MMV, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    j.g(WebView.c.MNy).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(156793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */