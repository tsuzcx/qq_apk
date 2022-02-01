package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
{
  private boolean WHZ;
  private String WIa;
  private String WIb;
  private String WIc;
  private String WId;
  private String WIe;
  private String WIf;
  private String lang;
  
  public y(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.WHZ = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.WIa = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.WIb = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.WIc = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.WId = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.WIe = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.WIf = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean iuN()
  {
    AppMethodBeat.i(78479);
    if ((this.WHZ) && (!Util.isNullOrNil(iuO())) && (!Util.isNullOrNil(iuP())) && (!Util.isNullOrNil(iuQ())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String iuO()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.WIa;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.WIb;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String iuP()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.WIc;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.WId;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String iuQ()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.WIe;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.WIf;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.y
 * JD-Core Version:    0.7.0.1
 */