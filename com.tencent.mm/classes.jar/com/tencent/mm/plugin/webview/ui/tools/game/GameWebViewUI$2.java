package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.e;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.62;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Map;

final class GameWebViewUI$2
  implements b.c
{
  GameWebViewUI$2(GameWebViewUI paramGameWebViewUI) {}
  
  public final void f(MenuItem paramMenuItem)
  {
    paramMenuItem = (awk)GameWebViewUI.d(this.rwB).get(Integer.valueOf(paramMenuItem.getItemId()));
    if (paramMenuItem == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (GameWebViewUI.8.rwD[com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.CU(paramMenuItem.sYX).ordinal()])
          {
          default: 
            return;
          case 1: 
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramMenuItem.sYY);
            com.tencent.mm.br.d.b(this.rwB.mController.uMN, "webview", ".ui.tools.game.GameWebViewUI", (Intent)localObject);
            return;
          case 2: 
            paramMenuItem = GameWebViewUI.f(this.rwB).ccm();
            paramMenuItem.rgD = new Object[] { this.rwB.caS, Integer.valueOf(32), Integer.valueOf(1) };
            paramMenuItem.c(GameWebViewUI.e(this.rwB));
          }
        } while (GameWebViewUI.g(this.rwB));
        this.rwB.finish();
        return;
        paramMenuItem = this.rwB.getIntent().getStringExtra("KPublisherId");
        localObject = this.rwB.getIntent().getStringExtra("KAppId");
        String str = this.rwB.getIntent().getStringExtra("srcUsername");
        an.e locale = GameWebViewUI.i(this.rwB).ccm();
        locale.rgD = new Object[] { this.rwB.caS, Integer.valueOf(1), Integer.valueOf(1), paramMenuItem, localObject, str };
        locale.c(GameWebViewUI.h(this.rwB));
        GameWebViewUI.a(this.rwB, GameWebViewUI.j(this.rwB).cdJ().coX());
        GameWebViewUI.k(this.rwB);
        return;
        paramMenuItem = GameWebViewUI.m(this.rwB).ccm();
        paramMenuItem.rgD = new Object[] { this.rwB.caS, Integer.valueOf(3), Integer.valueOf(1) };
        paramMenuItem.c(GameWebViewUI.l(this.rwB));
        h.nFQ.a(157L, 6L, 1L, false);
        GameWebViewUI.b(this.rwB, GameWebViewUI.n(this.rwB).cdJ().coX());
        GameWebViewUI.o(this.rwB);
        return;
        paramMenuItem = GameWebViewUI.q(this.rwB).ccm();
        paramMenuItem.rgD = new Object[] { this.rwB.caS, Integer.valueOf(10), Integer.valueOf(1) };
        paramMenuItem.c(GameWebViewUI.p(this.rwB));
      } while (GameWebViewUI.r(this.rwB) == null);
      GameWebViewUI.s(this.rwB).reload();
      return;
      paramMenuItem = GameWebViewUI.u(this.rwB).ccm();
      paramMenuItem.rgD = new Object[] { this.rwB.caS, Integer.valueOf(31), Integer.valueOf(1) };
      paramMenuItem.c(GameWebViewUI.t(this.rwB));
      GameWebViewUI.v(this.rwB);
      return;
      paramMenuItem = GameWebViewUI.x(this.rwB).ccm();
      paramMenuItem.rgD = new Object[] { this.rwB.caS, Integer.valueOf(11), Integer.valueOf(1) };
      paramMenuItem.c(GameWebViewUI.w(this.rwB));
      GameWebViewUI.y(this.rwB);
      return;
    } while (GameWebViewUI.z(this.rwB) == null);
    Object localObject = GameWebViewUI.A(this.rwB);
    int i = paramMenuItem.tsZ;
    y.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
    paramMenuItem = new HashMap();
    paramMenuItem.put("itemId", Integer.valueOf(i));
    ai.d(new d.62((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject, i.a.a("onCustomGameMenuClicked", paramMenuItem, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).rxI, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject).rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */