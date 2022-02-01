package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class x
{
  private boolean IVm;
  private String IVn;
  private String IVo;
  private String IVp;
  private String IVq;
  private String IVr;
  private String IVs;
  private String lang;
  
  public x(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.IVm = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.IVn = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.IVo = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.IVp = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.IVq = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.IVr = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.IVs = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean gci()
  {
    AppMethodBeat.i(78479);
    if ((this.IVm) && (!Util.isNullOrNil(gcj())) && (!Util.isNullOrNil(gck())) && (!Util.isNullOrNil(gcl())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String gcj()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.IVn;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.IVo;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String gck()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.IVp;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.IVq;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String gcl()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.IVr;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.IVs;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.x
 * JD-Core Version:    0.7.0.1
 */