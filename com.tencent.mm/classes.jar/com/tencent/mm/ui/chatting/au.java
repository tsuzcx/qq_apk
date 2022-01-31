package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.cg.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class au
  implements ad
{
  private static k<ad, Bundle> vnx = new au.1();
  private Context context;
  private final Map<String, ShowMessageFromWX.Req> vnA = new HashMap();
  
  public au(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static void ap(Bundle paramBundle)
  {
    vnx.bV(paramBundle);
    vnx.doNotify();
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3)
  {
    a(paramString1, paramWXMediaMessage, paramString2, paramString3, null);
  }
  
  public final void a(String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3, am paramam)
  {
    y.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[] { paramString1, paramString3 });
    a.post(new au.2(this, paramWXMediaMessage, paramString3, paramString1, paramString2, paramam));
  }
  
  public final void ao(Bundle paramBundle)
  {
    String str = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    y.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + str);
    paramBundle = new ShowMessageFromWX.Resp(paramBundle);
    y.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + paramBundle.errCode + ", type = " + paramBundle.getType());
    if ((ShowMessageFromWX.Req)this.vnA.get(paramBundle.transaction) == null)
    {
      y.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + paramBundle.transaction);
      return;
    }
    this.vnA.remove(paramBundle.transaction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.au
 * JD-Core Version:    0.7.0.1
 */