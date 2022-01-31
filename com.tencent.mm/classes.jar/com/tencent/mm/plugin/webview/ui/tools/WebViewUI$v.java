package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$v
  implements b
{
  private final String vgY = "weixin://openapi/openwebview/result?";
  
  private WebViewUI$v(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7972);
    Object localObject = new OpenWebview.Resp();
    paramString = Uri.parse(paramString);
    ((OpenWebview.Resp)localObject).result = paramString.getQuery();
    ((OpenWebview.Resp)localObject).errCode = bo.getInt(paramString.getQueryParameter("errCode"), 0);
    ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
    ((OpenWebview.Resp)localObject).transaction = this.vgz.getIntent().getStringExtra("transaction_for_openapi_openwebview");
    paramString = paramString.getQueryParameter("appid");
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
      AppMethodBeat.o(7972);
      return true;
    }
    Bundle localBundle = new Bundle();
    ((OpenWebview.Resp)localObject).toBundle(localBundle);
    p.aC(localBundle);
    localObject = new MMessageActV2.Args();
    try
    {
      ((MMessageActV2.Args)localObject).targetPkgName = this.vgz.igU.ahQ(paramString);
      ((MMessageActV2.Args)localObject).bundle = localBundle;
      ab.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
      MMessageActV2.send(this.vgz, (MMessageActV2.Args)localObject);
      this.vgz.finish();
      AppMethodBeat.o(7972);
      return true;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.WebViewUI", paramString, "", new Object[0]);
      AppMethodBeat.o(7972);
    }
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7971);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7971);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://openapi/openwebview/result?");
    AppMethodBeat.o(7971);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.v
 * JD-Core Version:    0.7.0.1
 */