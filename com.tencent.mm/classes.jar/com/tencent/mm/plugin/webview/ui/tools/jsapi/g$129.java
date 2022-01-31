package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

final class g$129
  implements f
{
  g$129(g paramg, i parami, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(155042);
    if ((g.E(this.vqm) != null) && (g.E(this.vqm).isShowing()))
    {
      g.E(this.vqm).dismiss();
      g.a(this.vqm, null);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (ae)paramm;
      if (paramString.rr == null)
      {
        paramString = null;
        if (paramString == null) {
          break label297;
        }
        paramString = paramString.username;
        if (bo.isNullOrNil(paramString)) {
          break label287;
        }
        if ((g.j(this.vqm) instanceof MMActivity))
        {
          paramm = (String)this.uZa.pJb.get("img_url");
          String str1 = (String)this.uZa.pJb.get("desc");
          String str2 = (String)this.uZa.pJb.get("src_username");
          String str3 = (String)this.uZa.pJb.get("src_displayname");
          String str4 = (String)this.uZa.pJb.get("title");
          if (g.a(this.vqm, this.val$appId, str4, paramm, paramString, str1, str2, str3, "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") != null) {
            break label281;
          }
          ab.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
          this.vqm.a(this.uZa, "sendAppMessageToSpecifiedContact:fail", null);
        }
      }
    }
    for (;;)
    {
      this.vqm.a(this.uZa, "sendAppMessageToSpecifiedContact:fail", null);
      AppMethodBeat.o(155042);
      return;
      paramString = (clj)paramString.rr.fsW.fta;
      break;
      label281:
      AppMethodBeat.o(155042);
      return;
      label287:
      ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
      continue;
      label297:
      ab.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
      continue;
      ab.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.129
 * JD-Core Version:    0.7.0.1
 */