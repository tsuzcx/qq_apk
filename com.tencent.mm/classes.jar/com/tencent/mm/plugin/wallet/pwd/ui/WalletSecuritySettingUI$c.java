package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletSecuritySettingUI$c
{
  String desc;
  String pek;
  int status;
  String title;
  String uaD;
  String uaG;
  String uaH;
  String uaI;
  
  WalletSecuritySettingUI$c(WalletSecuritySettingUI paramWalletSecuritySettingUI, Context paramContext)
  {
    AppMethodBeat.i(46400);
    if (p.u(paramContext, "com.tencent.qqpimsecure"))
    {
      if (bo.bG(paramContext, "com.tencent.server.back.BackEngine"))
      {
        this.status = 2;
        AppMethodBeat.o(46400);
        return;
      }
      this.status = 1;
      AppMethodBeat.o(46400);
      return;
    }
    this.status = 0;
    AppMethodBeat.o(46400);
  }
  
  private String ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46402);
    paramString1 = Uri.parse(this.uaD).buildUpon().appendQueryParameter(paramString1, paramString2).build().toString();
    AppMethodBeat.o(46402);
    return paramString1;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(46401);
    if (this.status == 0)
    {
      str = ha("qqpimsecurestatus", "not_installed");
      AppMethodBeat.o(46401);
      return str;
    }
    if (this.status == 1)
    {
      str = ha("qqpimsecurestatus", "not_run");
      AppMethodBeat.o(46401);
      return str;
    }
    String str = ha("qqpimsecurestatus", "runing");
    AppMethodBeat.o(46401);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.c
 * JD-Core Version:    0.7.0.1
 */