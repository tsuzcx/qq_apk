package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.webview.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class g$17
  implements f
{
  g$17(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(9061);
    if ((g.E(this.vqm) != null) && (g.E(this.vqm).isShowing()))
    {
      g.E(this.vqm).dismiss();
      g.a(this.vqm, null);
    }
    com.tencent.mm.kernel.g.Rc().b(1177, this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
      this.vqm.a(g.k(this.vqm), "selectSingleContact:fail", null);
      AppMethodBeat.o(9061);
      return;
    }
    ab.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
    paramString = (x)paramm;
    paramm = new HashMap();
    paramm.put("package", paramString.uVJ);
    paramm.put("sign", paramString.sign);
    paramm.put("headImgUrl", paramString.kVW);
    paramm.put("nickName", paramString.kVV);
    paramm.put("friendRelation", Integer.valueOf(paramString.uVK));
    ab.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", new Object[] { paramString.uVJ, paramString.sign, paramString.kVV, Integer.valueOf(paramString.uVK) });
    this.vqm.a(g.k(this.vqm), "selectSingleContact:ok", paramm);
    AppMethodBeat.o(9061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.17
 * JD-Core Version:    0.7.0.1
 */