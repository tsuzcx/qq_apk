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
  private static y aaaG = null;
  public Context aaaH;
  WebView.c aaaI = WebView.c.aabl;
  public boolean aaaJ = false;
  public boolean aaaK = false;
  public boolean aaaL = false;
  public boolean aaaM = false;
  boolean aaaN = false;
  public boolean aaaO = false;
  public boolean aaaP = false;
  public JsRuntime.JsRuntimeType aaaQ = JsRuntime.JsRuntimeType.aaam;
  public boolean aaaR = false;
  public boolean aaaS = false;
  
  public static y iwp()
  {
    return aaaG;
  }
  
  public static void mA(Context paramContext)
  {
    AppMethodBeat.i(156781);
    if (aaaG != null)
    {
      AppMethodBeat.o(156781);
      return;
    }
    Object localObject = new y();
    aaaG = (y)localObject;
    ((y)localObject).aaaH = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    aaaG.aaaK = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    aaaG.aaaL = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    aaaG.aaaM = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      aaaG.aaaQ = JsRuntime.JsRuntimeType.valueOf((String)localObject);
      label131:
      aaaG.aaaJ = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      y localy = aaaG;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localy.aaaR = bool;
        aaaG.aaaO = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (aaaG.aaaO)
        {
          localObject = aaaG.aaaH.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        aaaG.aaaP = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        aaaG.aaaS = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
        AppMethodBeat.o(156781);
        return;
      }
    }
    catch (Exception localException)
    {
      break label131;
    }
  }
  
  public final void IK(boolean paramBoolean)
  {
    AppMethodBeat.i(156787);
    if (paramBoolean == this.aaaM)
    {
      AppMethodBeat.o(156787);
      return;
    }
    this.aaaM = paramBoolean;
    this.aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.aaaM).commit();
    AppMethodBeat.o(156787);
  }
  
  public final void IL(boolean paramBoolean)
  {
    AppMethodBeat.i(156793);
    if (paramBoolean == this.aaaR)
    {
      AppMethodBeat.o(156793);
      return;
    }
    this.aaaR = paramBoolean;
    if (this.aaaR)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.aaaH, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        l.h(WebView.c.aabm).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(156793);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.aaaH, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.aaaH, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    l.h(WebView.c.aabm).excute("STR_CMD_CLEAR_SCHEDULER", null);
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
    Object localObject = this.aaaH.getSharedPreferences("wcwebview", 4);
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
      String[] arrayOfString = f.ZZI;
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
    AppMethodBeat.i(196845);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(196845);
      return "";
    }
    Object localObject = this.aaaH.getSharedPreferences("wcwebview", 4);
    if (localObject == null)
    {
      AppMethodBeat.o(196845);
      return "";
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null)
    {
      AppMethodBeat.o(196845);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str1 = paramArrayOfString[i];
      String[] arrayOfString = f.ZZI;
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
      AppMethodBeat.o(196845);
      return paramArrayOfString;
    }
    AppMethodBeat.o(196845);
    return "";
  }
  
  public final void a(JsRuntime.JsRuntimeType paramJsRuntimeType)
  {
    AppMethodBeat.i(156792);
    if (this.aaaQ == paramJsRuntimeType)
    {
      AppMethodBeat.o(156792);
      return;
    }
    this.aaaQ = paramJsRuntimeType;
    this.aaaH.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
    AppMethodBeat.o(156792);
  }
  
  public final void a(String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(156783);
    if ((this.aaaH == null) || (paramString == null) || (paramString.isEmpty()))
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
    if ((this.aaaH == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156784);
      return;
    }
    XWalkEnvironment.getMMKVSharedPreferences("xweb_debug").edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramc.toString()).commit();
    AppMethodBeat.o(156784);
  }
  
  public final WebView.c bFj(String paramString)
  {
    AppMethodBeat.i(156782);
    if ((paramString == null) || (paramString.isEmpty()) || (this.aaaH == null))
    {
      paramString = WebView.c.aabl;
      AppMethodBeat.o(156782);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.aabl;
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
      if (!str2.equals(WebView.c.aabl.toString())) {}
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
      this.aaaI = WebView.c.aabl;
    }
    for (;;)
    {
      paramString = this.aaaI;
      AppMethodBeat.o(156782);
      return paramString;
      try
      {
        this.aaaI = WebView.c.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.aaaI = WebView.c.aabl;
      }
    }
  }
  
  public final f.a bFk(String paramString)
  {
    AppMethodBeat.i(156788);
    SharedPreferences localSharedPreferences = this.aaaH.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      paramString = f.a.ZZK;
      AppMethodBeat.o(156788);
      return paramString;
    }
    paramString = b.bET(localSharedPreferences.getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(156788);
    return paramString;
  }
  
  public final f.c bFl(String paramString)
  {
    AppMethodBeat.i(196844);
    try
    {
      SharedPreferences localSharedPreferences = this.aaaH.getSharedPreferences("wcwebview", 4);
      if (localSharedPreferences == null)
      {
        paramString = f.c.ZZP;
        AppMethodBeat.o(196844);
        return paramString;
      }
      paramString = b.bER(localSharedPreferences.getString("force_use_office_reader_" + paramString.toLowerCase(), ""));
      AppMethodBeat.o(196844);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("WebDebugCfg", "getForceUseOfficeReader error ", paramString);
      paramString = f.c.ZZP;
      AppMethodBeat.o(196844);
    }
    return paramString;
  }
  
  public final WebView.c dU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175638);
    if ((paramString == null) || (paramString.isEmpty()) || (this.aaaH == null))
    {
      paramString = WebView.c.aabl;
      AppMethodBeat.o(175638);
      return paramString;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
    if (localSharedPreferences == null)
    {
      paramString = WebView.c.aabl;
      AppMethodBeat.o(175638);
      return paramString;
    }
    if (paramBoolean)
    {
      paramString = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label135;
      }
      this.aaaI = WebView.c.aabl;
    }
    for (;;)
    {
      paramString = this.aaaI;
      AppMethodBeat.o(175638);
      return paramString;
      paramString = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      break;
      try
      {
        label135:
        this.aaaI = WebView.c.valueOf(paramString);
      }
      catch (Exception paramString)
      {
        this.aaaI = WebView.c.aabl;
      }
    }
  }
  
  public final boolean iwq()
  {
    AppMethodBeat.i(156790);
    SharedPreferences localSharedPreferences = this.aaaH.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156790);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(156790);
    return bool;
  }
  
  public final boolean iwr()
  {
    AppMethodBeat.i(156791);
    SharedPreferences localSharedPreferences = this.aaaH.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(156791);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(156791);
    return bool;
  }
  
  public final void iws()
  {
    AppMethodBeat.i(156794);
    this.aaaH.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    XWalkEnvironment.initTurnOnKVLog();
    AppMethodBeat.o(156794);
  }
  
  public final boolean iwt()
  {
    AppMethodBeat.i(156795);
    boolean bool = this.aaaH.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
    AppMethodBeat.o(156795);
    return bool;
  }
  
  public final void setDebugEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(156785);
    if (paramBoolean == this.aaaJ)
    {
      AppMethodBeat.o(156785);
      return;
    }
    this.aaaJ = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(156785);
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(156786);
    if (paramBoolean == this.aaaS)
    {
      AppMethodBeat.o(156786);
      return;
    }
    this.aaaS = paramBoolean;
    this.aaaH.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(156786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.y
 * JD-Core Version:    0.7.0.1
 */