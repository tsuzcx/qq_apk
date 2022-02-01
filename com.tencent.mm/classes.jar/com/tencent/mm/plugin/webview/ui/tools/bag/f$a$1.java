package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f$a$1
  implements Runnable
{
  public f$a$1(int paramInt, Bundle paramBundle) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(80463);
    switch (this.dos)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80463);
      return;
      Object localObject = this.doj.getString("key_url");
      String str = this.doj.getString("key_bag_icon");
      i = this.doj.getInt("key_scene", 0);
      boolean bool = this.doj.getBoolean("key_from_bag", false);
      Bundle localBundle = this.doj.getBundle("key_extras");
      d locald = d.JkV;
      if (!b.cx(MMApplicationContext.getContext()))
      {
        Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
        Context localContext = MMApplicationContext.getContext();
        RequestFloatWindowPermissionDialog.a(localContext, localContext.getString(2131768533), new d.1(locald, (String)localObject, i, str, localBundle, bool), a.apJ());
        AppMethodBeat.o(80463);
        return;
      }
      locald.a((String)localObject, i, str, localBundle, bool);
      locald.ggp();
      AppMethodBeat.o(80463);
      return;
      d.JkV.ggq();
      AppMethodBeat.o(80463);
      return;
      localObject = d.JkV;
      Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(((d)localObject).JkY) });
      if ((!Util.isNullOrNil(((d)localObject).JkZ.url)) && (!((d)localObject).JkY))
      {
        if (System.currentTimeMillis() - ((d)localObject).Dqp > 500L) {
          i = 1;
        }
        if (i == 0) {
          Log.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
        }
        if (i != 0)
        {
          if ((((d)localObject).JkW != null) && (((d)localObject).JkW.getVisibility() == 0))
          {
            Log.i("MicroMsg.WebViewBagMgr", "already show");
            ((d)localObject).JkW.setTouchEnable(true);
            AppMethodBeat.o(80463);
            return;
          }
          ((d)localObject).ggp();
          Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
          AppMethodBeat.o(80463);
          return;
        }
      }
      ((d)localObject).ggq();
      Log.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
      AppMethodBeat.o(80463);
      return;
      d.JkV.ggo();
      AppMethodBeat.o(80463);
      return;
      float f = this.doj.getFloat("key_alpha", 1.0F);
      d.JkV.ci(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.f.a.1
 * JD-Core Version:    0.7.0.1
 */