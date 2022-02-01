package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
{
  public static boolean a(Context paramContext, String paramString, PayResp paramPayResp, PayReq.Options paramOptions)
  {
    AppMethodBeat.i(117561);
    ae.d("MicroMsg.PayCallbackHelper", "callback, packageName = ".concat(String.valueOf(paramString)));
    String str;
    if ((paramOptions == null) || (bu.isNullOrNil(paramOptions.callbackClassName)))
    {
      str = paramString + ".wxapi.WXPayEntryActivity";
      if ((paramOptions != null) && (paramOptions.callbackFlags != -1)) {
        break label193;
      }
    }
    label193:
    for (int i = 268435456;; i = paramOptions.callbackFlags)
    {
      ae.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + paramString + ", cbCls = " + str + ", cbFlags(hex) = " + Integer.toHexString(i));
      paramOptions = new Bundle();
      paramOptions.putString("wx_token_key", "com.tencent.mm.openapi.token");
      if (paramPayResp != null) {
        paramPayResp.toBundle(paramOptions);
      }
      paramPayResp = new MMessageActV2.Args();
      paramPayResp.targetPkgName = paramString;
      paramPayResp.targetClassName = str;
      paramPayResp.bundle = paramOptions;
      paramPayResp.flags = i;
      boolean bool = MMessageActV2.send(paramContext, paramPayResp);
      AppMethodBeat.o(117561);
      return bool;
      str = paramOptions.callbackClassName;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.e
 * JD-Core Version:    0.7.0.1
 */