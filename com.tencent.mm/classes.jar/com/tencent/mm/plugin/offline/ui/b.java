package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.i;

public final class b
{
  public static void bf(Activity paramActivity)
  {
    AppMethodBeat.i(66371);
    Log.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
    k.a(paramActivity, paramActivity.getString(a.i.wallet_wx_offline_check_network_connect_tips), null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66368);
        if ((b.this instanceof WalletOfflineCoinPurseUI)) {
          ((WalletOfflineCoinPurseUI)b.this).MCf = false;
        }
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(66368);
      }
    });
    AppMethodBeat.o(66371);
  }
  
  public static void e(Activity paramActivity, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(66370);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramActivity.getString(a.i.wallet_unknown_err);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        Log.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        k.a(paramActivity, paramString1, null, paramActivity.getResources().getString(a.i.wallet_err_alert_btn_err_detail_text), paramActivity.getResources().getString(a.i.app_ok), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66366);
            i.bC(b.this, paramString2);
            i.aGA(3);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(66366);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66367);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(66367);
          }
        });
        AppMethodBeat.o(66370);
        return;
      }
      l(paramActivity, paramString1);
      AppMethodBeat.o(66370);
      return;
    }
  }
  
  public static void l(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66369);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramActivity.getString(a.i.wallet_unknown_err);
    }
    k.a(paramActivity, str, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66365);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(66365);
      }
    });
    AppMethodBeat.o(66369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b
 * JD-Core Version:    0.7.0.1
 */