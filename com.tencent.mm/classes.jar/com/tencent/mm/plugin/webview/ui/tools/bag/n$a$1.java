package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class n$a$1
  implements Runnable
{
  n$a$1(int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(8252);
    switch (this.caF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8252);
      return;
      String str1 = this.cax.getString("key_url");
      String str2 = this.cax.getString("key_bag_icon");
      int i = this.cax.getInt("key_scene", 0);
      boolean bool = this.cax.getBoolean("key_from_bag", false);
      Bundle localBundle = this.cax.getBundle("key_extras");
      l locall = l.vix;
      if (!b.bK(ah.getContext()))
      {
        ab.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        Context localContext = ah.getContext();
        RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131305842), new l.1(locall, str1, i, str2, localBundle, bool));
        AppMethodBeat.o(8252);
        return;
      }
      locall.a(str1, i, str2, localBundle, bool);
      locall.oz(false);
      AppMethodBeat.o(8252);
      return;
      l.vix.dcS();
      AppMethodBeat.o(8252);
      return;
      l.vix.ox(false);
      AppMethodBeat.o(8252);
      return;
      l.vix.dfj();
      AppMethodBeat.o(8252);
      return;
      float f = this.cax.getFloat("key_alpha", 1.0F);
      l.vix.bn(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.a.1
 * JD-Core Version:    0.7.0.1
 */