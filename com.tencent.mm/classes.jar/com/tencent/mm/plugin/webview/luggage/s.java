package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

public final class s
{
  private String lang;
  boolean rcU;
  private String rcV;
  private String rcW;
  private String rcX;
  private String rcY;
  private String rcZ;
  private String rda;
  
  public s(Bundle paramBundle)
  {
    this.rcU = paramBundle.getBoolean("close_window_confirm_dialog_switch");
    this.rcV = paramBundle.getString("close_window_confirm_dialog_title_cn");
    this.rcW = paramBundle.getString("close_window_confirm_dialog_title_eng");
    this.rcX = paramBundle.getString("close_window_confirm_dialog_ok_cn");
    this.rcY = paramBundle.getString("close_window_confirm_dialog_ok_eng");
    this.rcZ = paramBundle.getString("close_window_confirm_dialog_cancel_cn");
    this.rda = paramBundle.getString("close_window_confirm_dialog_cancel_eng");
    this.lang = x.fB(ae.getContext());
  }
  
  public final String cbs()
  {
    if ("zh_CN".equals(this.lang)) {
      return this.rcV;
    }
    return this.rcW;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.s
 * JD-Core Version:    0.7.0.1
 */