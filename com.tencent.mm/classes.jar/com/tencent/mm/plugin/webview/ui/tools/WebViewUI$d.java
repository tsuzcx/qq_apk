package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class WebViewUI$d
{
  private String lang;
  private String uST;
  private String uSU;
  private String uSV;
  private String uSW;
  private String uSX;
  private String uSY;
  private String vgJ;
  
  private WebViewUI$d(Bundle paramBundle)
  {
    AppMethodBeat.i(7891);
    this.vgJ = paramBundle.getString("close_window_confirm_dialog_switch");
    this.uST = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.uSU = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.uSV = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.uSW = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.uSX = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.uSY = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = paramBundle.getString("application_language");
    AppMethodBeat.o(7891);
  }
  
  public static d am(Bundle paramBundle)
  {
    AppMethodBeat.i(7892);
    paramBundle = new d(paramBundle);
    AppMethodBeat.o(7892);
    return paramBundle;
  }
  
  public final boolean dbw()
  {
    AppMethodBeat.i(7893);
    if (bo.isNullOrNil(this.vgJ))
    {
      AppMethodBeat.o(7893);
      return false;
    }
    boolean bool = this.vgJ.equals("true");
    AppMethodBeat.o(7893);
    return bool;
  }
  
  public final String dby()
  {
    AppMethodBeat.i(7895);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uSV;
      AppMethodBeat.o(7895);
      return str;
    }
    String str = this.uSW;
    AppMethodBeat.o(7895);
    return str;
  }
  
  public final String dbz()
  {
    AppMethodBeat.i(7896);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uSX;
      AppMethodBeat.o(7896);
      return str;
    }
    String str = this.uSY;
    AppMethodBeat.o(7896);
    return str;
  }
  
  public final String deP()
  {
    AppMethodBeat.i(7894);
    if ("zh_CN".equals(this.lang))
    {
      str = this.uST;
      AppMethodBeat.o(7894);
      return str;
    }
    String str = this.uSU;
    AppMethodBeat.o(7894);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.d
 * JD-Core Version:    0.7.0.1
 */