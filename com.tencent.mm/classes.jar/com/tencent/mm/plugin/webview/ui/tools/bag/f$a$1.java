package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class f$a$1
  implements Runnable
{
  public f$a$1(int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(80463);
    switch (this.cXP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80463);
      return;
      Object localObject = this.cXH.getString("key_url");
      String str = this.cXH.getString("key_bag_icon");
      i = this.cXH.getInt("key_scene", 0);
      boolean bool = this.cXH.getBoolean("key_from_bag", false);
      Bundle localBundle = this.cXH.getBundle("key_extras");
      d locald = d.ExC;
      if (!b.cc(ak.getContext()))
      {
        ae.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        Context localContext = ak.getContext();
        RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131766076), new d.1(locald, (String)localObject, i, str, localBundle, bool), a.abK());
        AppMethodBeat.o(80463);
        return;
      }
      locald.a((String)localObject, i, str, localBundle, bool);
      locald.eXp();
      AppMethodBeat.o(80463);
      return;
      d.ExC.eXq();
      AppMethodBeat.o(80463);
      return;
      localObject = d.ExC;
      ae.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(((d)localObject).ExF) });
      if ((!bu.isNullOrNil(((d)localObject).ExG.url)) && (!((d)localObject).ExF))
      {
        if (System.currentTimeMillis() - ((d)localObject).zlx > 500L) {
          i = 1;
        }
        if (i == 0) {
          ae.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
        }
        if (i != 0)
        {
          if ((((d)localObject).ExD != null) && (((d)localObject).ExD.getVisibility() == 0))
          {
            ae.i("MicroMsg.WebViewBagMgr", "already show");
            ((d)localObject).ExD.setTouchEnable(true);
            AppMethodBeat.o(80463);
            return;
          }
          ((d)localObject).eXp();
          ae.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
          AppMethodBeat.o(80463);
          return;
        }
      }
      ((d)localObject).eXq();
      ae.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
      AppMethodBeat.o(80463);
      return;
      d.ExC.eXo();
      AppMethodBeat.o(80463);
      return;
      float f = this.cXH.getFloat("key_alpha", 1.0F);
      d.ExC.bK(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.f.a.1
 * JD-Core Version:    0.7.0.1
 */