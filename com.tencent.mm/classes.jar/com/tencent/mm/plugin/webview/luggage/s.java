package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class s
{
  private String lang;
  private boolean uSS;
  private String uST;
  private String uSU;
  private String uSV;
  private String uSW;
  private String uSX;
  private String uSY;
  
  public s(Bundle paramBundle)
  {
    AppMethodBeat.i(6233);
    this.uSS = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.uST = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.uSU = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.uSV = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.uSW = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.uSX = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.uSY = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = aa.gP(ah.getContext());
    AppMethodBeat.o(6233);
  }
  
  public final boolean dbw()
  {
    AppMethodBeat.i(6234);
    if ((this.uSS) && (!bo.isNullOrNil(dbx())) && (!bo.isNullOrNil(dby())) && (!bo.isNullOrNil(dbz())))
    {
      AppMethodBeat.o(6234);
      return true;
    }
    AppMethodBeat.o(6234);
    return false;
  }
  
  public final String dbx()
  {
    AppMethodBeat.i(6235);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uST;
      AppMethodBeat.o(6235);
      return str;
    }
    String str = this.uSU;
    AppMethodBeat.o(6235);
    return str;
  }
  
  public final String dby()
  {
    AppMethodBeat.i(6236);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uSV;
      AppMethodBeat.o(6236);
      return str;
    }
    String str = this.uSW;
    AppMethodBeat.o(6236);
    return str;
  }
  
  public final String dbz()
  {
    AppMethodBeat.i(6237);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uSX;
      AppMethodBeat.o(6237);
      return str;
    }
    String str = this.uSY;
    AppMethodBeat.o(6237);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */