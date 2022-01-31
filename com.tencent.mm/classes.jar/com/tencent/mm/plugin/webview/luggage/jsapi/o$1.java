package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class o$1
  implements d.b
{
  o$1(o paramo, String paramString, bh.a parama) {}
  
  public final void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(153119);
    ab.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    if ((!bo.isNullOrNil(paramString2)) && (paramString2.equals(this.uTw)))
    {
      g.dcD().a(this);
      if (o.a(this.uTx) != null)
      {
        o.a(this.uTx).dismiss();
        o.b(this.uTx);
      }
      if (!paramBoolean)
      {
        this.lax.c("fail", null);
        AppMethodBeat.o(153119);
        return;
      }
      paramString2 = g.dcE().ahh(paramString1);
      if (((paramString2 instanceof WebViewJSSDKImageItem)) && (bo.isNullOrNil(paramString2.hII))) {
        ((WebViewJSSDKImageItem)paramString2).dzl();
      }
      paramString2 = new JSONObject();
    }
    try
    {
      paramString2.put("localId", paramString1);
      label161:
      this.lax.c(null, paramString2);
      AppMethodBeat.o(153119);
      return;
    }
    catch (JSONException paramString1)
    {
      break label161;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.o.1
 * JD-Core Version:    0.7.0.1
 */