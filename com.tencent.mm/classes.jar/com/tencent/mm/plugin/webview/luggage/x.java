package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  private boolean PRC;
  private String PRD;
  private String PRE;
  private String PRF;
  private String PRG;
  private String PRH;
  private String PRI;
  private String lang;
  
  public x(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.PRC = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.PRD = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.PRE = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.PRF = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.PRG = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.PRH = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.PRI = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean gVc()
  {
    AppMethodBeat.i(78479);
    if ((this.PRC) && (!Util.isNullOrNil(gVd())) && (!Util.isNullOrNil(gVe())) && (!Util.isNullOrNil(gVf())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String gVd()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.PRD;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.PRE;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String gVe()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.PRF;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.PRG;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String gVf()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.PRH;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.PRI;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.x
 * JD-Core Version:    0.7.0.1
 */