package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.m.d.b;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$37
  implements n.d
{
  WebViewUI$37(WebViewUI paramWebViewUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int i = 0;
    Object localObject2;
    if (WebViewUI.g(paramMenuItem))
    {
      localObject1 = (d.b)paramMenuItem.getMenuInfo();
      if (localObject1 != null)
      {
        paramMenuItem = this.rpH.rbk;
        y.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("key", ((d.b)localObject1).key);
        ((HashMap)localObject2).put("title", ((d.b)localObject1).title);
        localObject1 = i.a.a("menu:custom", (Map)localObject2, paramMenuItem.rxI, paramMenuItem.rxJ);
        paramMenuItem.rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject1 + ")", null);
      }
    }
    do
    {
      return;
      switch (paramMenuItem.getItemId())
      {
      case 4: 
      case 13: 
      case 30: 
      case 32: 
      default: 
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(16), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        localObject1 = paramMenuItem.getTitle();
      }
    } while (bk.bl((String)localObject1));
    for (;;)
    {
      try
      {
        paramMenuItem = new Bundle();
        paramMenuItem.putString("data", (String)localObject1);
        paramMenuItem = this.rpH.gGn.f(50, paramMenuItem);
        paramInt = i;
        if (paramMenuItem != null)
        {
          paramInt = paramMenuItem.getInt("key_biz_type");
          if (paramInt != 2) {
            continue;
          }
          paramInt = 1;
        }
      }
      catch (RemoteException paramMenuItem)
      {
        int j;
        an.e locale;
        paramInt = 0;
        y.printErrStackTrace("MicroMsg.WebViewUI", paramMenuItem, "", new Object[0]);
        continue;
        WebViewUI.l(this.rpH, (String)localObject1);
        return;
      }
      try
      {
        j = paramMenuItem.getInt("key_biz_type");
        paramInt = i;
        if (j == 3) {
          paramInt = 1;
        }
        if (paramInt == 0) {
          continue;
        }
        WebViewUI.k(this.rpH, (String)localObject1);
        return;
      }
      catch (RemoteException paramMenuItem)
      {
        continue;
        paramInt = 0;
        continue;
      }
      paramMenuItem = this.rpH.rfg.ccm();
      paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(32), Integer.valueOf(1) };
      paramMenuItem.c(this.rpH.gGn);
      if (this.rpH.caS()) {
        break;
      }
      this.rpH.finish();
      return;
      paramMenuItem = this.rpH.getIntent().getStringExtra("KPublisherId");
      localObject1 = this.rpH.getIntent().getStringExtra("KAppId");
      localObject2 = this.rpH.getIntent().getStringExtra("srcUsername");
      locale = this.rpH.rfg.ccm();
      locale.rgD = new Object[] { this.rpH.caS, Integer.valueOf(1), Integer.valueOf(1), paramMenuItem, localObject1, localObject2 };
      locale.c(this.rpH.gGn);
      this.rpH.rnJ = this.rpH.gGo.cdJ().coX();
      this.rpH.bBI();
      return;
      paramMenuItem = new Intent();
      localObject1 = this.rpH.getIntent().getStringExtra("sns_local_id");
      if (localObject1 != null)
      {
        paramMenuItem.putExtra("sns_send_data_ui_activity", true);
        paramMenuItem.putExtra("sns_local_id", (String)localObject1);
        com.tencent.mm.br.d.e(this.rpH.mController.uMN, ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
        return;
      }
      paramMenuItem.putExtra("Retr_Msg_Id", Long.valueOf(this.rpH.getIntent().getLongExtra("msg_id", -9223372036854775808L)));
      continue;
      paramMenuItem = this.rpH.getIntent().getStringExtra("KPublisherId");
      localObject1 = this.rpH.getIntent().getStringExtra("KAppId");
      localObject2 = this.rpH.getIntent().getStringExtra("srcUsername");
      locale = this.rpH.rfg.ccm();
      locale.rgD = new Object[] { this.rpH.caS, Integer.valueOf(2), Integer.valueOf(1), paramMenuItem, localObject1, localObject2 };
      locale.c(this.rpH.gGn);
      this.rpH.rnJ = this.rpH.gGo.cdJ().coX();
      if (!WebViewUI.S(this.rpH).containsKey(this.rpH.niQ.getUrl())) {
        break label3317;
      }
      paramInt = ((Integer)WebViewUI.S(this.rpH).get(this.rpH.niQ.getUrl())).intValue();
      paramMenuItem = this.rpH;
      paramMenuItem.rbk.bp("shareTimeline", true);
      localObject1 = paramMenuItem.rbk;
      if (!((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).ready)
      {
        y.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
        paramMenuItem.rfg.St("mm_share_sns_count");
        return;
      }
      localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).CV(2);
      if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("WebViewShare_reslut", false)))
      {
        ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).g((Bundle)localObject2, "shareTimeline");
      }
      else
      {
        try
        {
          ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).gGn.I("urlAttribute", String.valueOf(paramInt), ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rjN);
          localObject2 = i.a.a("menu:share:timeline", new HashMap(), ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxI, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxJ);
          ((com.tencent.mm.plugin.webview.ui.tools.jsapi.d)localObject1).rxB.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject2 + ")", null);
        }
        catch (RemoteException localRemoteException)
        {
          y.printErrStackTrace("MicroMsg.JsApiHandler", localRemoteException, "", new Object[0]);
          continue;
        }
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(3), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        com.tencent.mm.plugin.report.service.h.nFQ.a(157L, 6L, 1L, false);
        this.rpH.rnJ = this.rpH.gGo.cdJ().coX();
        this.rpH.ceo();
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(4), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        localObject1 = (String)WebViewUI.h(this.rpH).get(this.rpH.niQ.getUrl());
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 == null) {
          paramMenuItem = this.rpH.getIntent().getStringExtra("srcUsername");
        }
        WebViewUI.h(this.rpH, "Contact_Scene");
        WebViewUI.i(this.rpH, paramMenuItem);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(8), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        if (WebViewUI.J(this.rpH).getVisibility() == 8)
        {
          paramMenuItem = AnimationUtils.loadAnimation(this.rpH, R.a.font_fade_in);
          WebViewUI.J(this.rpH).startAnimation(paramMenuItem);
          WebViewUI.J(this.rpH).setVisibility(0);
          return;
        }
        paramMenuItem = AnimationUtils.loadAnimation(this.rpH, R.a.font_fade_out);
        paramMenuItem.setAnimationListener(new WebViewUI.37.1(this));
        WebViewUI.J(this.rpH).startAnimation(paramMenuItem);
        WebViewUI.J(this.rpH).setVisibility(8);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(10), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        if (this.rpH.niQ == null) {
          break;
        }
        this.rpH.niQ.reload();
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(5), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.T(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(13), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.U(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(15), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.V(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(7), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.W(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(11), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        this.rpH.cen();
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(6), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("key_fav_scene", 2);
        paramMenuItem.putExtra("key_fav_item_id", this.rpH.getIntent().getLongExtra("fav_local_id", -1L));
        b.a(this.rpH.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
        this.rpH.rfg.St("mm_edit_fav_count");
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(9), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        if (!WebViewUI.X(this.rpH))
        {
          WebViewUI.a(this.rpH, this.rpH.niQ.getUrl(), this.rpH.niQ.getSettings().getUserAgentString(), WebViewUI.Y(this.rpH), WebViewUI.Z(this.rpH));
          return;
        }
        WebViewUI.j(this.rpH, WebViewUI.aa(this.rpH));
        return;
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(19), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        WebViewUI.a(this.rpH, paramMenuItem);
        return;
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(21), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        WebViewUI.a(this.rpH, paramMenuItem);
        return;
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(20), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        WebViewUI.a(this.rpH, paramMenuItem);
        return;
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(22), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        WebViewUI.a(this.rpH, paramMenuItem);
        return;
        localObject1 = this.rpH.rfg.ccm();
        ((an.e)localObject1).rgD = new Object[] { this.rpH.caS, Integer.valueOf(23), Integer.valueOf(1) };
        ((an.e)localObject1).c(this.rpH.gGn);
        WebViewUI.a(this.rpH, paramMenuItem);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(26), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ab(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(27), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ac(this.rpH);
        return;
        this.rpH.rnJ = this.rpH.gGo.cdJ().coX();
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(17), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ad(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(18), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ae(this.rpH);
        return;
        this.rpH.rnJ = this.rpH.gGo.cdJ().coX();
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(24), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.af(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(14), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ag(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(16), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        WebViewUI.ah(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(31), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        this.rpH.cei();
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.a(480L, 1L, 1L, false);
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(28), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        if (this.rpH.rnD.isShown()) {
          break;
        }
        this.rpH.rnD.reset();
        this.rpH.rnD.cgS();
        this.rpH.rnD.show();
        return;
        WebViewUI.ai(this.rpH);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(33), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        this.rpH.rbN.lo(false);
        return;
        paramMenuItem = this.rpH.rfg.ccm();
        paramMenuItem.rgD = new Object[] { this.rpH.caS, Integer.valueOf(34), Integer.valueOf(1) };
        paramMenuItem.c(this.rpH.gGn);
        this.rpH.rbN.lo(true);
        return;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.37
 * JD-Core Version:    0.7.0.1
 */