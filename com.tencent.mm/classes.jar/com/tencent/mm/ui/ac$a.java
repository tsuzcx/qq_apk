package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.ag;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class ac$a
{
  public static boolean a(final Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(33447);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33447);
      return false;
      if (((paramInt3 & 0x2) != 0) && (bh.aGY().bii()))
      {
        bh.aGY().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(33447);
        return true;
        if ((((paramInt3 & 0x1) == 0) || (!ag.dj(paramContext)) || (!n.jF(paramContext))) && (((paramInt3 & 0x4) == 0) || (!NetStatusUtil.isWap(paramContext)) || (!MMAppMgr.kP(paramContext)))) {
          Toast.makeText(paramContext, paramContext.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(paramContext, paramContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 1).show();
      AppMethodBeat.o(33447);
      return true;
      AppMethodBeat.o(33447);
      return true;
      if (com.tencent.mm.plugin.account.ui.a.eh(paramInt1, paramInt2))
      {
        AppMethodBeat.o(33447);
        return true;
      }
      com.tencent.mm.h.a locala = com.tencent.mm.h.a.Kb(paramString);
      if (locala != null)
      {
        Log.i("MicroMsg.MMErrorProcessor", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(locala.fwp), locala.url, locala.desc });
        if (!Util.isNullOrNil(locala.url)) {}
        for (paramString = new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(33446);
                paramAnonymousDialogInterface = new Intent();
                StringBuilder localStringBuilder = new StringBuilder(this.mEP.url);
                localStringBuilder.append("&wechat_real_lang=" + LocaleUtil.getApplicationLanguage());
                paramAnonymousDialogInterface.putExtra("rawUrl", localStringBuilder.toString());
                paramAnonymousDialogInterface.putExtra("showShare", false);
                paramAnonymousDialogInterface.putExtra("show_bottom", false);
                paramAnonymousDialogInterface.putExtra("needRedirect", false);
                paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
                paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
                c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                AppMethodBeat.o(33446);
              }
            }; locala.a(paramContext, paramString, null); paramString = null)
        {
          AppMethodBeat.o(33447);
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ac.a
 * JD-Core Version:    0.7.0.1
 */