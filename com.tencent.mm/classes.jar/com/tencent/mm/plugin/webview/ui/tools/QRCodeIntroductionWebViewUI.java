package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QRCodeIntroductionWebViewUI
  extends WebViewUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7474);
    super.onCreate(paramBundle);
    addIconOptionMenu(0, 2130839668, new QRCodeIntroductionWebViewUI.1(this));
    setBackBtn(new QRCodeIntroductionWebViewUI.2(this));
    AppMethodBeat.o(7474);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI
 * JD-Core Version:    0.7.0.1
 */