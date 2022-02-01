package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.preference.Preference.b;

final class k$10
  implements Preference.b
{
  k$10(k paramk, String paramString1, String paramString2) {}
  
  public final boolean dDy()
  {
    AppMethodBeat.i(27189);
    Object localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setClassName(ak.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    ((Intent)localObject).putExtra("rawUrl", this.val$url);
    ((Intent)localObject).putExtra("geta8key_scene", 58);
    Context localContext = ak.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    g.yxI.f(15319, new Object[] { this.xhZ.contact.field_openImAppid, Integer.valueOf(6), this.xfg });
    AppMethodBeat.o(27189);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.10
 * JD-Core Version:    0.7.0.1
 */