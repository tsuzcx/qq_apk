package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class aq
{
  private static aq qVi = new aq();
  private SharedPreferences mPref = ap.l(ae.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
  private volatile boolean qVf = this.mPref.getBoolean("isUseSysWebview", false);
  private long qVg;
  private boolean qVh = false;
  private long qVj;
  
  public aq()
  {
    bZV();
  }
  
  private void bZV()
  {
    if (System.currentTimeMillis() - this.qVj < 7200000L) {
      return;
    }
    this.qVj = System.currentTimeMillis();
    e.post(new aq.1(this), "WebSearchXWeb-getSwitch");
  }
  
  public static aq bZW()
  {
    return qVi;
  }
  
  public final boolean bZX()
  {
    bZV();
    String str = Build.BRAND;
    if (TextUtils.isEmpty(str))
    {
      y.i("WebSearchXWeb", "brand is empty");
      return false;
    }
    if ((str.contains("huawei")) || (str.contains("honor")))
    {
      y.i("WebSearchXWeb", "huawei not support sys webview");
      return false;
    }
    if (!this.qVh)
    {
      y.i("WebSearchXWeb", "check use sys webview switch close");
      return false;
    }
    if (this.qVg == 0L) {
      this.qVg = this.mPref.getLong("lastCheckTimestamp", 0L);
    }
    if (System.currentTimeMillis() - this.qVg > 86400000L)
    {
      e.post(new aq.2(this, MMWebView.a.hj(ae.getContext()), MMWebView.a.cO(ae.getContext())), "WebSearchXWeb.check");
      this.qVg = System.currentTimeMillis();
      this.mPref.edit().putLong("lastCheckTimestamp", this.qVg).commit();
    }
    return this.qVf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aq
 * JD-Core Version:    0.7.0.1
 */