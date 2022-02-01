package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;

public final class b
{
  public static void aw(Activity paramActivity)
  {
    AppMethodBeat.i(66371);
    ae.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
    h.a(paramActivity, paramActivity.getString(2131765951), null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66368);
        if ((this.val$activity instanceof WalletOfflineCoinPurseUI)) {
          ((WalletOfflineCoinPurseUI)this.val$activity).wQz = false;
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
      paramString1 = paramActivity.getString(2131765901);
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString2))
      {
        ae.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
        h.a(paramActivity, paramString1, null, paramActivity.getResources().getString(2131765249), paramActivity.getResources().getString(2131755835), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(66366);
            f.aY(this.val$activity, paramString2);
            f.aha(3);
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
      e(paramActivity, paramString1);
      AppMethodBeat.o(66370);
      return;
    }
  }
  
  public static void e(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(66369);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramActivity.getString(2131765901);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.b
 * JD-Core Version:    0.7.0.1
 */