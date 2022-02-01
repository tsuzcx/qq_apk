package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class v
{
  private boolean Eir;
  private String Eis;
  private String Eit;
  private String Eiu;
  private String Eiv;
  private String Eiw;
  private String Eix;
  private String lang;
  
  public v(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.Eir = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.Eis = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.Eit = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.Eiu = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.Eiv = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.Eiw = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.Eix = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = ad.iR(ak.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean eTw()
  {
    AppMethodBeat.i(78479);
    if ((this.Eir) && (!bu.isNullOrNil(eTx())) && (!bu.isNullOrNil(eTy())) && (!bu.isNullOrNil(eTz())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String eTx()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.Eis;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.Eit;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String eTy()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.Eiu;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.Eiv;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String eTz()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.Eiw;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.Eix;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.v
 * JD-Core Version:    0.7.0.1
 */