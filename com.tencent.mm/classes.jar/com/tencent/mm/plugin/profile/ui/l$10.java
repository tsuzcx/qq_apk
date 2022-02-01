package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;

final class l$10
  implements Preference.b
{
  l$10(l paraml, String paramString1, String paramString2) {}
  
  public final boolean a(Preference paramPreference)
  {
    AppMethodBeat.i(231881);
    Object localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    ((Intent)localObject).putExtra("rawUrl", this.val$url);
    ((Intent)localObject).putExtra("geta8key_scene", 58);
    paramPreference = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramPreference, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$8", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.CyF.a(15319, new Object[] { this.BfT.contact.field_openImAppid, Integer.valueOf(6), this.BcK });
    AppMethodBeat.o(231881);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l.10
 * JD-Core Version:    0.7.0.1
 */