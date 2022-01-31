package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.R.g;

public class QRCodeIntroductionWebViewUI
  extends WebViewUI
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addIconOptionMenu(0, R.g.mm_title_btn_menu, new QRCodeIntroductionWebViewUI.1(this));
    setBackBtn(new QRCodeIntroductionWebViewUI.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI
 * JD-Core Version:    0.7.0.1
 */