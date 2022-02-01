package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;

public final class b
{
  public static void ax(Activity paramActivity)
  {
    AppMethodBeat.i(66371);
    Log.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
    h.a(paramActivity, paramActivity.getString(2131768404), null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66368);
        if ((this.val$activity instanceof WalletOfflineCoinPurseUI)) {
          ((WalletOfflineCoinPurseUI)this.val$activity).AMq = false;
        }
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(66368);
      }
    });
    AppMethodBeat.o(66371);
  }
  
  public static void d(Activity paramActivity, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(66370);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = paramActivity.getString(2131768354);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        Log.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        h.a(paramActivity, paramString1, null, paramActivity.getResources().getString(2131767692), paramActivity.getResources().getString(2131755921), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66366);
            f.bn(this.val$activity, paramString2);
            f.aqm(3);
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
      i(paramActivity, paramString1);
      AppMethodBeat.o(66370);
      return;
    }
  }
  
  public static void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66369);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramActivity.getString(2131768354);
    }
    h.a(paramActivity, str, null, false, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b
 * JD-Core Version:    0.7.0.1
 */