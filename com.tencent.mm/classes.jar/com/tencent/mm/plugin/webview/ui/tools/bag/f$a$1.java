package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.a;
import com.tencent.mm.compatible.d.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class f$a$1
  implements Runnable
{
  public f$a$1(int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(80463);
    switch (this.cWS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80463);
      return;
      Object localObject = this.cWK.getString("key_url");
      String str = this.cWK.getString("key_bag_icon");
      i = this.cWK.getInt("key_scene", 0);
      boolean bool = this.cWK.getBoolean("key_from_bag", false);
      Bundle localBundle = this.cWK.getBundle("key_extras");
      d locald = d.Efz;
      if (!b.ca(aj.getContext()))
      {
        ad.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        Context localContext = aj.getContext();
        RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131766076), new d.1(locald, (String)localObject, i, str, localBundle, bool), a.abB());
        AppMethodBeat.o(80463);
        return;
      }
      locald.a((String)localObject, i, str, localBundle, bool);
      locald.eTC();
      AppMethodBeat.o(80463);
      return;
      d.Efz.eTD();
      AppMethodBeat.o(80463);
      return;
      localObject = d.Efz;
      ad.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(((d)localObject).EfC) });
      if ((!bt.isNullOrNil(((d)localObject).EfD.url)) && (!((d)localObject).EfC))
      {
        if (System.currentTimeMillis() - ((d)localObject).yVn > 500L) {
          i = 1;
        }
        if (i == 0) {
          ad.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
        }
        if (i != 0)
        {
          if ((((d)localObject).EfA != null) && (((d)localObject).EfA.getVisibility() == 0))
          {
            ad.i("MicroMsg.WebViewBagMgr", "already show");
            ((d)localObject).EfA.setTouchEnable(true);
            AppMethodBeat.o(80463);
            return;
          }
          ((d)localObject).eTC();
          ad.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
          AppMethodBeat.o(80463);
          return;
        }
      }
      ((d)localObject).eTD();
      ad.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
      AppMethodBeat.o(80463);
      return;
      d.Efz.eTB();
      AppMethodBeat.o(80463);
      return;
      float f = this.cWK.getFloat("key_alpha", 1.0F);
      d.Efz.bM(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.f.a.1
 * JD-Core Version:    0.7.0.1
 */