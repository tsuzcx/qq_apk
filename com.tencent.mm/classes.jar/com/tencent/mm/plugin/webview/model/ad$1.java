package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ad$1
  implements DialogInterface.OnClickListener
{
  ad$1(ad paramad, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.rfO;
    String str1 = this.edL;
    String str2 = ad.Sf(paramDialogInterface.mAppId);
    if (bk.bl(str2))
    {
      y.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
      return;
    }
    SendAuth.Resp localResp = new SendAuth.Resp();
    localResp.transaction = paramDialogInterface.kWT;
    localResp.errCode = -1;
    localResp.errStr = str1;
    localResp.lang = paramDialogInterface.cbS();
    localResp.country = ad.getCountry();
    paramDialogInterface.a(str2, localResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ad.1
 * JD-Core Version:    0.7.0.1
 */