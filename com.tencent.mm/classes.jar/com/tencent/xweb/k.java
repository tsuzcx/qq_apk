package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.j.a;
import org.xwalk.core.XWalkEnvironment;

public final class k
{
  private static k xgJ = null;
  public Context xgK;
  WebView.d xgL = WebView.d.xhn;
  public boolean xgM = false;
  public boolean xgN = false;
  public boolean xgO = false;
  boolean xgP = false;
  public boolean xgQ = false;
  public boolean xgR = false;
  public g.a xgS = g.a.xgw;
  public boolean xgT = false;
  String xgU = "";
  
  public static k cSk()
  {
    return xgJ;
  }
  
  public static void im(Context paramContext)
  {
    if (xgJ != null) {
      return;
    }
    Object localObject = new k();
    xgJ = (k)localObject;
    ((k)localObject).xgK = paramContext;
    XWalkEnvironment.init(paramContext);
    xgJ.xgN = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    xgJ.xgO = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    localObject = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      xgJ.xgS = g.a.valueOf((String)localObject);
      label97:
      xgJ.xgM = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      k localk = xgJ;
      if ((localObject != null) && (!((String)localObject).isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        localk.xgT = bool;
        xgJ.xgQ = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
        if (xgJ.xgQ) {
          Debug.waitForDebugger();
        }
        xgJ.xgR = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
        return;
      }
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  public final void a(g.a parama)
  {
    if (this.xgS == parama) {
      return;
    }
    this.xgS = parama;
    this.xgK.getSharedPreferences("wcwebview", 0).edit().putString("V8type", parama.toString()).commit();
  }
  
  public final void a(String paramString, WebView.d paramd)
  {
    if ((this.xgK == null) || (paramString == null) || (paramString.isEmpty())) {
      return;
    }
    this.xgU = paramString;
    this.xgL = paramd;
    this.xgK.getSharedPreferences("wcwebview", 0).edit().putString("HardCodeWebView" + paramString, paramd.toString()).commit();
  }
  
  public final WebView.d agU(String paramString)
  {
    if (this.xgU.equals(paramString)) {
      return this.xgL;
    }
    if ((paramString == null) || (paramString.isEmpty()) || (this.xgK == null)) {
      return WebView.d.xhn;
    }
    this.xgU = paramString;
    SharedPreferences localSharedPreferences = this.xgK.getSharedPreferences("wcwebview", 0);
    if (localSharedPreferences == null) {
      return WebView.d.xhn;
    }
    String str2 = localSharedPreferences.getString("HardCodeWebView" + paramString, "");
    String str1;
    if ((str2 != null) && (!str2.isEmpty()))
    {
      str1 = str2;
      if (!str2.equals(WebView.d.xhn.toString())) {}
    }
    else
    {
      str1 = localSharedPreferences.getString("ABTestWebView" + paramString, "");
    }
    if ((str1 == null) || (str1.isEmpty())) {
      this.xgL = WebView.d.xhn;
    }
    for (;;)
    {
      return this.xgL;
      try
      {
        this.xgL = WebView.d.valueOf(str1);
      }
      catch (Exception paramString)
      {
        this.xgL = WebView.d.xhn;
      }
    }
  }
  
  public final void oq(boolean paramBoolean)
  {
    if (paramBoolean == this.xgM) {
      return;
    }
    this.xgM = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
  }
  
  public final void or(boolean paramBoolean)
  {
    if (paramBoolean == this.xgO) {
      return;
    }
    this.xgO = paramBoolean;
    this.xgK.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.xgO).commit();
  }
  
  public final void os(boolean paramBoolean)
  {
    if (paramBoolean == this.xgT) {
      return;
    }
    this.xgT = paramBoolean;
    if (this.xgT)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.xgK, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      }
      for (;;)
      {
        localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        localEditor.putLong("nLastFetchConfigTime", 0L);
        localEditor.commit();
        j.c(WebView.d.xho).excute("STR_CMD_CLEAR_SCHEDULER", null);
        return;
        XWalkEnvironment.setTestDownLoadUrl(this.xgK, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
    }
    XWalkEnvironment.setTestDownLoadUrl(this.xgK, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    j.c(WebView.d.xho).excute("STR_CMD_CLEAR_SCHEDULER", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.k
 * JD-Core Version:    0.7.0.1
 */