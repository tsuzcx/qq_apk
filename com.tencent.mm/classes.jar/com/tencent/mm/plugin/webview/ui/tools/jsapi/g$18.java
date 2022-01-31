package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class g$18
  implements f
{
  g$18(g paramg) {}
  
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
      g.a(this.rzi, g.j(this.rzi), "selectSingleContact:fail", null);
      return;
    }
    y.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
    paramString = (u)paramm;
    paramm = new HashMap();
    paramm.put("package", paramString.rfx);
    paramm.put("sign", paramString.sign);
    paramm.put("headImgUrl", paramString.iQT);
    paramm.put("nickName", paramString.iQS);
    paramm.put("friendRelation", Integer.valueOf(paramString.rfy));
    y.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", new Object[] { paramString.rfx, paramString.sign, paramString.iQS, Integer.valueOf(paramString.rfy) });
    g.a(this.rzi, g.j(this.rzi), "selectSingleContact:ok", paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.18
 * JD-Core Version:    0.7.0.1
 */