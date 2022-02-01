package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebviewMpUI
  extends WebViewUI
{
  public final boolean bQO()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208144);
    super.onCreate(paramBundle);
    AppMethodBeat.o(208144);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI
 * JD-Core Version:    0.7.0.1
 */