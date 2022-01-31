package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ai$1
  implements DialogInterface.OnClickListener
{
  ai$1(ai paramai, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(6677);
    if (!this.uWc.uWb)
    {
      paramDialogInterface = this.uWc;
      String str1 = this.ftO;
      String str2 = ai.ahb(paramDialogInterface.mAppId);
      if (bo.isNullOrNil(str2))
      {
        ab.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
        AppMethodBeat.o(6677);
        return;
      }
      SendAuth.Resp localResp = new SendAuth.Resp();
      localResp.transaction = paramDialogInterface.nuV;
      localResp.errCode = -1;
      localResp.errStr = str1;
      localResp.lang = paramDialogInterface.dbV();
      localResp.country = ai.getCountry();
      paramDialogInterface.a(str2, localResp);
    }
    AppMethodBeat.o(6677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ai.1
 * JD-Core Version:    0.7.0.1
 */