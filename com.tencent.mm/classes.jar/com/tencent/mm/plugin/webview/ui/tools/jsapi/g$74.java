package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class g$74
  implements d.b
{
  g$74(g paramg, String paramString, i parami) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(154994);
    ab.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    if ((!bo.isNullOrNil(paramString2)) && (paramString2.equals(this.uTw)))
    {
      com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this);
      if (g.E(this.vqm) != null)
      {
        g.E(this.vqm).dismiss();
        g.a(this.vqm, null);
      }
      if (!paramBoolean)
      {
        this.vqm.a(this.uZa, "downloadImage:fail", null);
        AppMethodBeat.o(154994);
        return;
      }
      paramString2 = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh(paramString1);
      if (((paramString2 instanceof WebViewJSSDKImageItem)) && (bo.isNullOrNil(paramString2.hII))) {
        ((WebViewJSSDKImageItem)paramString2).dzl();
      }
      paramString2 = new HashMap();
      paramString2.put("localId", paramString1);
      this.vqm.a(this.uZa, "downloadImage:ok", paramString2);
    }
    AppMethodBeat.o(154994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.74
 * JD-Core Version:    0.7.0.1
 */