package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class g$15
  implements f
{
  g$15(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(154932);
    if ((g.E(this.vqm) != null) && (g.E(this.vqm).isShowing()))
    {
      g.E(this.vqm).dismiss();
      g.a(this.vqm, null);
    }
    com.tencent.mm.kernel.g.Rc().b(1566, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
      this.vqm.a(g.k(this.vqm), "selectSingleContact:fail", null);
      AppMethodBeat.o(154932);
      return;
    }
    ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
    paramString = (r)paramm;
    if (paramString.rr == null) {}
    for (paramString = null; paramString == null; paramString = (axi)paramString.rr.fsW.fta)
    {
      this.vqm.a(g.k(this.vqm), "selectSingleContact:fail", null);
      AppMethodBeat.o(154932);
      return;
    }
    paramm = g.k(this.vqm).pJb.get("result_sign_type");
    if (paramm != null) {}
    for (paramInt1 = bo.getInt((String)paramm, 0);; paramInt1 = 0)
    {
      paramm = new HashMap();
      paramm.put("package", paramString.wKW);
      paramm.put("sign", paramString.wKX);
      if (paramInt1 == 1) {
        paramm.put("signType", paramString.wKY);
      }
      paramm.put("timestamp", paramString.wvC);
      paramm.put("noncestr", paramString.wKV);
      ab.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[] { paramString.wKW, paramString.wKX });
      this.vqm.a(g.k(this.vqm), "selectSingleContact:ok", paramm);
      AppMethodBeat.o(154932);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.15
 * JD-Core Version:    0.7.0.1
 */