package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public class o
  extends bi<e>
{
  private ProgressDialog eeN = null;
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(153121);
    Object localObject = b.BJ(paramString);
    if (localObject == null)
    {
      ab.i("MicroMsg.JsApiDownLoadImage", "data is null");
      parama.c("invalid_data", null);
      AppMethodBeat.o(153121);
      return;
    }
    paramString = ((JSONObject)localObject).optString("preVerifyAppId");
    String str = ((JSONObject)localObject).optString("serverId");
    if (bo.getInt(((JSONObject)localObject).optString("isShowProgressTips", "0"), 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, appid is : %s, media id is : %s", new Object[] { paramString, str });
      if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(str))) {
        break;
      }
      parama.c("missing arguments", null);
      AppMethodBeat.o(153121);
      return;
    }
    localObject = new o.1(this, str, parama);
    g.dcD().a(paramString, str, (d.b)localObject);
    ab.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, add cdn download task result : %b", new Object[] { Boolean.TRUE });
    if (i != 0)
    {
      paramContext.getString(2131297087);
      this.eeN = h.b(paramContext, paramContext.getString(2131306015), true, new o.2(this, (d.b)localObject, str, parama));
    }
    AppMethodBeat.o(153121);
  }
  
  public final void b(a<e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "downloadImage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.o
 * JD-Core Version:    0.7.0.1
 */