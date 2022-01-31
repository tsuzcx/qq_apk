package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.Preference.b;

final class k$11
  implements Preference.b
{
  k$11(k paramk, String paramString1, String paramString2) {}
  
  public final boolean bsE()
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("geta8key_scene", 58);
    ae.getContext().startActivity(localIntent);
    h.nFQ.f(15319, new Object[] { this.mXC.dnp.field_openImAppid, Integer.valueOf(6), this.mXJ });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.11
 * JD-Core Version:    0.7.0.1
 */