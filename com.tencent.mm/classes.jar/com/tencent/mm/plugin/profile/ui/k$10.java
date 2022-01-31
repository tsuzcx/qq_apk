package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.Preference.b;

final class k$10
  implements Preference.b
{
  k$10(k paramk, String paramString1, String paramString2) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23574);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("geta8key_scene", 58);
    ah.getContext().startActivity(localIntent);
    h.qsU.e(15319, new Object[] { this.pAx.contact.field_openImAppid, Integer.valueOf(6), this.pxI });
    AppMethodBeat.o(23574);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.10
 * JD-Core Version:    0.7.0.1
 */