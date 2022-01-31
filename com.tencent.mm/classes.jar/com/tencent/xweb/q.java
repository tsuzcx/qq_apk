package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.l;
import com.tencent.xweb.c.l.a;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class q
{
  private static q BDG = null;
  public Context BDH;
  WebView.d BDI = WebView.d.BEp;
  public boolean BDJ = false;
  public boolean BDK = false;
  public boolean BDL = false;
  public boolean BDM = false;
  boolean BDN = false;
  public boolean BDO = false;
  public boolean BDP = false;
  public k.a BDQ = k.a.BDo;
  public boolean BDR = false;
  public boolean BDS = false;
  String BDT = "";
  
  public static q dYn()
  {
    return BDG;
  }
  
  public static void jS(Context paramContext)
  {
    AppMethodBeat.i(3825);
    if (BDG != null)
    {
      AppMethodBeat.o(3825);
      return;
    }
    Object localObject = new q();
    BDG = (q)localObject;
    ((q)localObject).BDH = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    BDG.BDK = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    BDG.BDL = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    BDG.BDM = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      BDG.BDQ = k.a.valueOf((String)localObject);
      label133:
      BDG.BDJ = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      q localq = BDG;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localq.BDR = bool;
        BDG.BDO = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (BDG.BDO)
        {
          localObject = BDG.BDH.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
          if ((localObject != null) && (((String)localObject).equals(XWalkEnvironment.getProcessName())))
          {
            Debug.waitForDebugger();
            Log.w("WebDebugCfg", "strDebugProcess is ".concat(String.valueOf(localObject)));
          }
        }
        BDG.BDP = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        BDG.BDS = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
        AppMethodBeat.o(3825);
        return;
      }
    }
    catch (Exception localException)
    {
      break label133;
    }
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(3831);
    if (this.BDQ == parama)
    {
      AppMethodBeat.o(3831);
      return;
    }
    this.BDQ = parama;
    this.BDH.getSharedPreferences("wcwebview", 0).edit().putString("V8type", parama.toString()).commit();
    AppMethodBeat.o(3831);
  }
  
  public final void a(String paramString, WebView.d paramd)
  {
    AppMethodBeat.i(3827);
    if ((this.BDH == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(3827);
      return;
    }
    this.BDT = paramString;
    this.BDI = paramd;
    this.BDH.getSharedPreferences("wcwebview", 4).edit().putString("HardCodeWebView".concat(String.valueOf(paramString)), paramd.toString()).commit();
    AppMethodBeat.o(3827);
  }
  
  public final void a(String[] paramArrayOfString, d.a parama)
  {
    AppMethodBeat.i(3830);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(3830);
      return;
    }
    SharedPreferences.Editor localEditor = this.BDH.getSharedPreferences("wcwebview", 4).edit();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      localEditor.putString("force_fr_" + str.toLowerCase(), parama.toString());
      i += 1;
    }
    localEditor.commit();
    AppMethodBeat.o(3830);
  }
  
  public final WebView.d axW(String paramString)
  {
    AppMethodBeat.i(3826);
    if (this.BDT.equals(paramString))
    {
      paramString = this.BDI;
      AppMethodBeat.o(3826);
      return paramString;
    }
    if ((paramString == null) || (paramString.isEmpty()) || (this.BDH == null))
    {
      paramString = WebView.d.BEp;
      AppMethodBeat.o(3826);
      return paramString;
    }
    this.BDT = paramString;
    SharedPreferences localSharedPreferences = this.BDH.getSharedPreferences("wcwebview", 0);
    if (localSharedPreferences == null)
    {
      paramString = WebView.d.BEp;
      AppMethodBeat.o(3826);
      return paramString;
    }
    String str2 = localSharedPreferences.getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
    String str1;
    if ((str2 != null) && (!str2.isEmpty()))
    {
      str1 = str2;
      if (!str2.equals(WebView.d.BEp.toString())) {}
    }
    else
    {
      str1 = localSharedPreferences.getString("ABTestWebView".concat(String.valueOf(paramString)), "");
    }
    if ((str1 == null) || (str1.isEmpty())) {
      this.BDI = WebView.d.BEp;
    }
    for (;;)
    {
      paramString = this.BDI;
      AppMethodBeat.o(3826);
      return paramString;
      try
      {
        this.BDI = WebView.d.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.BDI = WebView.d.BEp;
      }
    }
  }
  
  public final d.a axX(String paramString)
  {
    AppMethodBeat.i(151424);
    paramString = a.axS(this.BDH.getSharedPreferences("wcwebview", 4).getString("force_fr_" + paramString.toLowerCase(), ""));
    AppMethodBeat.o(151424);
    return paramString;
  }
  
  public final void b(String paramString, WebView.d paramd)
  {
    AppMethodBeat.i(151422);
    if ((this.BDH == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(151422);
      return;
    }
    this.BDH.getSharedPreferences("wcwebview", 4).edit().putString("ABTestWebView".concat(String.valueOf(paramString)), paramd.toString()).commit();
    Object localObject = this.BDH.getSharedPreferences("wcwebview", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getString("HardCodeWebView".concat(String.valueOf(paramString)), "");
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        AppMethodBeat.o(151422);
        return;
      }
    }
    this.BDT = paramString;
    this.BDI = paramd;
    AppMethodBeat.o(151422);
  }
  
  public final boolean dYo()
  {
    AppMethodBeat.i(151425);
    boolean bool = this.BDH.getSharedPreferences("wcwebview", 4).getBoolean("fr_disable_cache", false);
    AppMethodBeat.o(151425);
    return bool;
  }
  
  public final boolean dYp()
  {
    AppMethodBeat.i(151426);
    boolean bool = this.BDH.getSharedPreferences("wcwebview", 4).getBoolean("fr_disable_crash_detect", false);
    AppMethodBeat.o(151426);
    return bool;
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(3828);
    if (paramBoolean == this.BDJ)
    {
      AppMethodBeat.o(3828);
      return;
    }
    this.BDJ = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
    AppMethodBeat.o(3828);
  }
  
  public final void se(boolean paramBoolean)
  {
    AppMethodBeat.i(3829);
    if (paramBoolean == this.BDM)
    {
      AppMethodBeat.o(3829);
      return;
    }
    this.BDM = paramBoolean;
    this.BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.BDM).commit();
    AppMethodBeat.o(3829);
  }
  
  public final void setShowFps(boolean paramBoolean)
  {
    AppMethodBeat.i(151423);
    if (paramBoolean == this.BDS)
    {
      AppMethodBeat.o(151423);
      return;
    }
    this.BDS = paramBoolean;
    this.BDH.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
    AppMethodBeat.o(151423);
  }
  
  public final void sf(boolean paramBoolean)
  {
    AppMethodBeat.i(3832);
    if (paramBoolean == this.BDR)
    {
      AppMethodBeat.o(3832);
      return;
    }
    this.BDR = paramBoolean;
    if (this.BDR)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.BDH, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        l.e(WebView.d.BEq).excute("STR_CMD_CLEAR_SCHEDULER", null);
        AppMethodBeat.o(3832);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.BDH, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.BDH, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    l.e(WebView.d.BEq).excute("STR_CMD_CLEAR_SCHEDULER", null);
    AppMethodBeat.o(3832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.q
 * JD-Core Version:    0.7.0.1
 */