package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;

final class g$21
  implements f
{
  g$21(g paramg, Intent paramIntent, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((g.k(this.rzi) != null) && (g.k(this.rzi).isShowing()))
    {
      g.k(this.rzi).dismiss();
      g.a(this.rzi, null);
    }
    au.Dk().b(1177, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
      g.a(this.rzi, g.j(this.rzi), "sendSingleAppMessage:fail", null);
      return;
    }
    y.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
    paramString = (u)paramm;
    paramm = new HashMap();
    paramm.put("openid", paramString.rfx);
    paramm.put("headImgUrl", paramString.iQT);
    paramm.put("nickName", paramString.iQS);
    y.d("MicroMsg.MsgHandler", "opnid:%s, nick_name:%s", new Object[] { paramString.rfx, paramString.iQS });
    String str1 = (String)g.j(this.rzi).ndL.get("img_url");
    String str2 = (String)g.j(this.rzi).ndL.get("src_username");
    String str3 = (String)g.j(this.rzi).ndL.get("src_displayname");
    if (this.hSF == null) {}
    for (paramString = null;; paramString = this.hSF.getStringExtra("custom_send_text"))
    {
      g.a(this.rzi, null, "", this.bxX, str1, str2, str3, paramString, null);
      if (g.i(this.rzi) != null) {
        h.bC(g.i(this.rzi), g.i(this.rzi).getResources().getString(R.l.app_shared));
      }
      g.a(this.rzi, g.j(this.rzi), "sendSingleAppMessage:ok", paramm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.21
 * JD-Core Version:    0.7.0.1
 */