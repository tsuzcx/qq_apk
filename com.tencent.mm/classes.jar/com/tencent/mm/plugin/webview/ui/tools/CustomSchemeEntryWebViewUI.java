package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class CustomSchemeEntryWebViewUI
  extends WebViewUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(296077);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.CustomSchemeEntryWebViewUI", "CustomSchemeEntryWebViewUI onCreate");
    AppMethodBeat.o(296077);
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