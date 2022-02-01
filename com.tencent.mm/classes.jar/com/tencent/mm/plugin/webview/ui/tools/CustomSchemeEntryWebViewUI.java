package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class CustomSchemeEntryWebViewUI
  extends WebViewUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198177);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.CustomSchemeEntryWebViewUI", "CustomSchemeEntryWebViewUI onCreate");
    AppMethodBeat.o(198177);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CustomSchemeEntryWebViewUI
 * JD-Core Version:    0.7.0.1
 */