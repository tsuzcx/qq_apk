package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class u
{
  private boolean CmW;
  private String CmX;
  private String CmY;
  private String CmZ;
  private String Cna;
  private String Cnb;
  private String Cnc;
  private String lang;
  
  public u(Bundle paramBundle)
  {
    AppMethodBeat.i(78478);
    this.CmW = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.CmX = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.CmY = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.CmZ = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.Cna = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.Cnb = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.Cnc = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = ab.iC(ai.getContext());
    AppMethodBeat.o(78478);
  }
  
  public final boolean eAS()
  {
    AppMethodBeat.i(78479);
    if ((this.CmW) && (!bs.isNullOrNil(eAT())) && (!bs.isNullOrNil(eAU())) && (!bs.isNullOrNil(eAV())))
    {
      AppMethodBeat.o(78479);
      return true;
    }
    AppMethodBeat.o(78479);
    return false;
  }
  
  public final String eAT()
  {
    AppMethodBeat.i(78480);
    if ("zh_CN".equals(this.lang))
    {
      str = this.CmX;
      AppMethodBeat.o(78480);
      return str;
    }
    String str = this.CmY;
    AppMethodBeat.o(78480);
    return str;
  }
  
  public final String eAU()
  {
    AppMethodBeat.i(78481);
    if ("zh_CN".equals(this.lang))
    {
      str = this.CmZ;
      AppMethodBeat.o(78481);
      return str;
    }
    String str = this.Cna;
    AppMethodBeat.o(78481);
    return str;
  }
  
  public final String eAV()
  {
    AppMethodBeat.i(78482);
    if ("zh_CN".equals(this.lang))
    {
      str = this.Cnb;
      AppMethodBeat.o(78482);
      return str;
    }
    String str = this.Cnc;
    AppMethodBeat.o(78482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */