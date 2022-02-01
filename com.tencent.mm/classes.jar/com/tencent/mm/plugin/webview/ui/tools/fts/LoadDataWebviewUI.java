package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadDataWebviewUI
  extends PreLoadWebViewUI
{
  public LoadDataWebviewUI()
  {
    AppMethodBeat.i(80724);
    AppMethodBeat.o(80724);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80725);
    super.onCreate(paramBundle);
    AppMethodBeat.o(80725);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI
 * JD-Core Version:    0.7.0.1
 */