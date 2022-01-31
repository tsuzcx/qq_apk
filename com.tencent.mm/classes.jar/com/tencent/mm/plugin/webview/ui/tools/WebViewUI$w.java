package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$w
  implements b
{
  private final String rqT = "weixin://openapi/openwebview/result?";
  
  private WebViewUI$w(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    Object localObject = new OpenWebview.Resp();
    paramString = Uri.parse(paramString);
    ((OpenWebview.Resp)localObject).result = paramString.getQuery();
    ((OpenWebview.Resp)localObject).errCode = bk.getInt(paramString.getQueryParameter("errCode"), 0);
    ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
    ((OpenWebview.Resp)localObject).transaction = this.rpH.getIntent().getStringExtra("transaction_for_openapi_openwebview");
    paramString = paramString.getQueryParameter("appid");
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
      return true;
    }
    Bundle localBundle = new Bundle();
    ((OpenWebview.Resp)localObject).toBundle(localBundle);
    p.ak(localBundle);
    localObject = new MMessageActV2.Args();
    try
    {
      ((MMessageActV2.Args)localObject).targetPkgName = this.rpH.gGn.SO(paramString);
      ((MMessageActV2.Args)localObject).bundle = localBundle;
      y.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
      MMessageActV2.send(this.rpH, (MMessageActV2.Args)localObject);
      this.rpH.finish();
      return true;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.WebViewUI", paramString, "", new Object[0]);
    }
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://openapi/openwebview/result?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w
 * JD-Core Version:    0.7.0.1
 */