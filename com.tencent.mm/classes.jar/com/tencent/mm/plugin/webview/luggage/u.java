package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class u
{
  private boolean AUJ;
  private String AUK;
  private String AUL;
  private String AUM;
  private String AUN;
  private String AUO;
  private String AUP;
  private String lang;
  
  public u(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.AUJ = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.AUK = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.AUL = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.AUM = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.AUN = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.AUO = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.AUP = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = ac.ir(aj.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean elw()
  {
    AppMethodBeat.i(78479);
    if ((this.AUJ) && (!bt.isNullOrNil(elx())) && (!bt.isNullOrNil(ely())) && (!bt.isNullOrNil(elz())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String elx()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.AUK;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.AUL;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String ely()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.AUM;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.AUN;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String elz()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.AUO;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.AUP;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */