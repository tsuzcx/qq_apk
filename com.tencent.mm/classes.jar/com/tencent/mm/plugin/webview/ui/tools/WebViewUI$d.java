package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;

final class WebViewUI$d
{
  private String lang;
  private String rcV;
  private String rcW;
  private String rcX;
  private String rcY;
  private String rcZ;
  private String rda;
  String rqF;
  
  private WebViewUI$d(Bundle paramBundle)
  {
    this.rqF = paramBundle.getString("close_window_confirm_dialog_switch");
    this.rcV = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.rcW = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.rcX = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.rcY = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.rcZ = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.rda = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = paramBundle.getString("application_language");
  }
  
  public static d V(Bundle paramBundle)
  {
    return new d(paramBundle);
  }
  
  public final String cbt()
  {
    if ("zh_CN".equals(this.lang)) {
      return this.rcX;
    }
    return this.rcY;
  }
  
  public final String cbu()
  {
    if ("zh_CN".equals(this.lang)) {
      return this.rcZ;
    }
    return this.rda;
  }
  
  public final String ceK()
  {
    if ("zh_CN".equals(this.lang)) {
      return this.rcV;
    }
    return this.rcW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.d
 * JD-Core Version:    0.7.0.1
 */