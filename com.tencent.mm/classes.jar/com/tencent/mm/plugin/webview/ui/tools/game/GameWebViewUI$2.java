package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.as.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.70;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

final class GameWebViewUI$2
  implements b.c
{
  GameWebViewUI$2(GameWebViewUI paramGameWebViewUI) {}
  
  public final void c(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(8725);
    paramMenuItem = (bcz)GameWebViewUI.l(this.vnt).get(Integer.valueOf(paramMenuItem.getItemId()));
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(8725);
      return;
    }
    switch (GameWebViewUI.8.vnw[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.KP(paramMenuItem.wzE).ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8725);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramMenuItem.wXs);
      com.tencent.mm.bq.d.b(this.vnt.getContext(), "webview", ".ui.tools.game.GameWebViewUI", (Intent)localObject);
      AppMethodBeat.o(8725);
      return;
      paramMenuItem = GameWebViewUI.m(this.vnt).dcp();
      paramMenuItem.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(32), Integer.valueOf(1) };
      paramMenuItem.b(this.vnt.igU);
      if (!GameWebViewUI.n(this.vnt))
      {
        this.vnt.finish();
        AppMethodBeat.o(8725);
        return;
        paramMenuItem = this.vnt.getIntent().getStringExtra("KPublisherId");
        localObject = this.vnt.getIntent().getStringExtra("KAppId");
        String str = this.vnt.getIntent().getStringExtra("srcUsername");
        as.e locale = GameWebViewUI.o(this.vnt).dcp();
        locale.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(1), Integer.valueOf(1), paramMenuItem, localObject, str };
        locale.b(this.vnt.igU);
        GameWebViewUI.b(this.vnt, GameWebViewUI.p(this.vnt).ddW().dqx());
        GameWebViewUI.q(this.vnt);
        AppMethodBeat.o(8725);
        return;
        paramMenuItem = GameWebViewUI.r(this.vnt).dcp();
        paramMenuItem.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(3), Integer.valueOf(1) };
        paramMenuItem.b(this.vnt.igU);
        h.qsU.idkeyStat(157L, 6L, 1L, false);
        GameWebViewUI.c(this.vnt, GameWebViewUI.s(this.vnt).ddW().dqx());
        GameWebViewUI.t(this.vnt);
        AppMethodBeat.o(8725);
        return;
        paramMenuItem = GameWebViewUI.u(this.vnt).dcp();
        paramMenuItem.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(10), Integer.valueOf(1) };
        paramMenuItem.b(this.vnt.igU);
        if (GameWebViewUI.v(this.vnt) != null)
        {
          GameWebViewUI.w(this.vnt).reload();
          AppMethodBeat.o(8725);
          return;
          paramMenuItem = GameWebViewUI.x(this.vnt).dcp();
          paramMenuItem.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(31), Integer.valueOf(1) };
          paramMenuItem.b(this.vnt.igU);
          GameWebViewUI.y(this.vnt);
          AppMethodBeat.o(8725);
          return;
          paramMenuItem = GameWebViewUI.z(this.vnt).dcp();
          paramMenuItem.uWQ = new Object[] { this.vnt.cJr, Integer.valueOf(11), Integer.valueOf(1) };
          paramMenuItem.b(this.vnt.igU);
          GameWebViewUI.A(this.vnt);
          AppMethodBeat.o(8725);
          return;
          if (this.vnt.uQS != null)
          {
            localObject = this.vnt.uQS;
            int i = paramMenuItem.xsZ;
            ab.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
            paramMenuItem = new HashMap();
            paramMenuItem.put("itemId", Integer.valueOf(i));
            al.d(new d.70((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject, i.a.b("onCustomGameMenuClicked", paramMenuItem, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).voB, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).voC)));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */