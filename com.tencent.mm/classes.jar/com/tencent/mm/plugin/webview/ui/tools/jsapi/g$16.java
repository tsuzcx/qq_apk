package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.protocal.c.ard;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class g$16
  implements f
{
  g$16(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((g.k(this.rzi) != null) && (g.k(this.rzi).isShowing()))
    {
      g.k(this.rzi).dismiss();
      g.a(this.rzi, null);
    }
    au.Dk().b(1566, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
      g.a(this.rzi, g.j(this.rzi), "selectSingleContact:fail", null);
      return;
    }
    y.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
    paramString = (o)paramm;
    if (paramString.dmK == null) {}
    for (paramString = null; paramString == null; paramString = (ard)paramString.dmK.ecF.ecN)
    {
      g.a(this.rzi, g.j(this.rzi), "selectSingleContact:fail", null);
      return;
    }
    paramm = g.j(this.rzi).ndL.get("result_sign_type");
    if (paramm != null) {}
    for (paramInt1 = bk.getInt((String)paramm, 0);; paramInt1 = 0)
    {
      paramm = new HashMap();
      paramm.put("package", paramString.sNg);
      paramm.put("sign", paramString.sNh);
      if (paramInt1 == 1) {
        paramm.put("signType", paramString.sNi);
      }
      paramm.put("timestamp", paramString.sBi);
      paramm.put("noncestr", paramString.sNf);
      y.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[] { paramString.sNg, paramString.sNh });
      g.a(this.rzi, g.j(this.rzi), "selectSingleContact:ok", paramm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.16
 * JD-Core Version:    0.7.0.1
 */