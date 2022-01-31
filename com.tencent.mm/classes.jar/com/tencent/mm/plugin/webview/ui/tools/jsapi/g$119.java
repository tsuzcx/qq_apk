package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.protocal.c.byr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

final class g$119
  implements f
{
  g$119(g paramg, i parami, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((g.k(this.rzi) != null) && (g.k(this.rzi).isShowing()))
    {
      g.k(this.rzi).dismiss();
      g.a(this.rzi, null);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (z)paramm;
      if (paramString.dmK == null)
      {
        paramString = null;
        if (paramString == null) {
          break label281;
        }
        paramString = paramString.username;
        if (bk.bl(paramString)) {
          break label271;
        }
        if ((g.i(this.rzi) instanceof MMActivity))
        {
          paramm = (String)this.rzk.ndL.get("img_url");
          String str1 = (String)this.rzk.ndL.get("desc");
          String str2 = (String)this.rzk.ndL.get("src_username");
          String str3 = (String)this.rzk.ndL.get("src_displayname");
          String str4 = (String)this.rzk.ndL.get("title");
          if (g.a(this.rzi, this.val$appId, str4, paramm, paramString, str1, str2, str3, "sendAppMessageToSpecifiedContact:ok", "sendAppMessageToSpecifiedContact:fail") != null) {
            break label253;
          }
          y.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
          g.a(this.rzi, this.rzk, "sendAppMessageToSpecifiedContact:fail", null);
        }
      }
    }
    for (;;)
    {
      g.a(this.rzi, this.rzk, "sendAppMessageToSpecifiedContact:fail", null);
      label253:
      return;
      paramString = (byr)paramString.dmK.ecF.ecN;
      break;
      label271:
      y.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
      continue;
      label281:
      y.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
      continue;
      y.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.119
 * JD-Core Version:    0.7.0.1
 */