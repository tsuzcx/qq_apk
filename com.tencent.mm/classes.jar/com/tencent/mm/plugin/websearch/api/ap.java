package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class ap
{
  private static ap uKu;
  private SharedPreferences uKq;
  private volatile boolean uKr;
  private long uKs;
  private boolean uKt;
  private long uKv;
  
  static
  {
    AppMethodBeat.i(124257);
    uKu = new ap();
    AppMethodBeat.o(124257);
  }
  
  public ap()
  {
    AppMethodBeat.i(124252);
    this.uKq = ar.r(ah.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    this.uKr = this.uKq.getBoolean("isUseSysWebview", false);
    this.uKt = false;
    cZQ();
    AppMethodBeat.o(124252);
  }
  
  private void cZQ()
  {
    AppMethodBeat.i(124253);
    if (System.currentTimeMillis() - this.uKv < 7200000L)
    {
      AppMethodBeat.o(124253);
      return;
    }
    this.uKv = System.currentTimeMillis();
    d.post(new ap.1(this), "WebSearchXWeb-getSwitch");
    AppMethodBeat.o(124253);
  }
  
  public static ap cZR()
  {
    return uKu;
  }
  
  private void cZT()
  {
    AppMethodBeat.i(124255);
    d.post(new ap.2(this, MMWebView.a.iH(ah.getContext()), MMWebView.a.iI(ah.getContext())), "WebSearchXWeb.check");
    AppMethodBeat.o(124255);
  }
  
  public final boolean cZS()
  {
    AppMethodBeat.i(124254);
    cZQ();
    String str = Build.BRAND;
    if (TextUtils.isEmpty(str))
    {
      ab.i("WebSearchXWeb", "brand is empty");
      AppMethodBeat.o(124254);
      return false;
    }
    if ((str.contains("huawei")) || (str.contains("honor")))
    {
      ab.i("WebSearchXWeb", "huawei not support sys webview");
      AppMethodBeat.o(124254);
      return false;
    }
    if (!this.uKt)
    {
      ab.i("WebSearchXWeb", "check use sys webview switch close");
      AppMethodBeat.o(124254);
      return false;
    }
    if (this.uKs == 0L) {
      this.uKs = this.uKq.getLong("lastCheckTimestamp", 0L);
    }
    if (System.currentTimeMillis() - this.uKs > 86400000L)
    {
      cZT();
      this.uKs = System.currentTimeMillis();
      this.uKq.edit().putLong("lastCheckTimestamp", this.uKs).commit();
    }
    boolean bool = this.uKr;
    AppMethodBeat.o(124254);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ap
 * JD-Core Version:    0.7.0.1
 */