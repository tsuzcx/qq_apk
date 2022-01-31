package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference.b;

public final class a$7
  implements Preference.b
{
  public a$7(String paramString1, ad paramad, String paramString2) {}
  
  public final boolean cbH()
  {
    AppMethodBeat.i(23256);
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    localIntent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    localIntent.putExtra("rawUrl", this.val$url);
    localIntent.putExtra("geta8key_scene", 58);
    ah.getContext().startActivity(localIntent);
    h.qsU.e(15319, new Object[] { this.ejm.field_openImAppid, Integer.valueOf(6), this.pxI });
    AppMethodBeat.o(23256);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.7
 * JD-Core Version:    0.7.0.1
 */