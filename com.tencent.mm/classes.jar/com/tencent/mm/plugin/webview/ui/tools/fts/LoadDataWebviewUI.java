package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI
  extends PreLoadWebViewUI
{
  private CountDownLatch vlk;
  
  public LoadDataWebviewUI()
  {
    AppMethodBeat.i(8556);
    this.vlk = new CountDownLatch(1);
    AppMethodBeat.o(8556);
  }
  
  public void aMf()
  {
    AppMethodBeat.i(8558);
    super.aMf();
    this.vlk.countDown();
    AppMethodBeat.o(8558);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8557);
    super.onCreate(paramBundle);
    AppMethodBeat.o(8557);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI
 * JD-Core Version:    0.7.0.1
 */