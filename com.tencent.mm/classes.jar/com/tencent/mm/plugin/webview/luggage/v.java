package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class v
{
  private boolean DQr;
  private String DQs;
  private String DQt;
  private String DQu;
  private String DQv;
  private String DQw;
  private String DQx;
  private String lang;
  
  public v(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.DQr = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.DQs = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.DQt = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.DQu = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.DQv = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.DQw = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.DQx = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = ac.iM(aj.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean ePK()
  {
    AppMethodBeat.i(78479);
    if ((this.DQr) && (!bt.isNullOrNil(ePL())) && (!bt.isNullOrNil(ePM())) && (!bt.isNullOrNil(ePN())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String ePL()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.DQs;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.DQt;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String ePM()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.DQu;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.DQv;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String ePN()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.DQw;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.DQx;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.v
 * JD-Core Version:    0.7.0.1
 */