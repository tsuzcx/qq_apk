package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;

public class FTSWebViewUI
  extends FTSBaseWebViewUI
{
  private void dfQ()
  {
    AppMethodBeat.i(8546);
    if (this.scene == 21) {
      an.Jw(19);
    }
    AppMethodBeat.o(8546);
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(8540);
    super.aMf();
    an.Ju(this.scene);
    if (this.scene == 21) {
      an.Jw(17);
    }
    AppMethodBeat.o(8540);
  }
  
  public final void deE()
  {
    AppMethodBeat.i(8547);
    dfQ();
    super.deE();
    AppMethodBeat.o(8547);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(8539);
    String str = getString(2131297065);
    AppMethodBeat.o(8539);
    return str;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(8544);
    super.onBackPressed();
    dfQ();
    AppMethodBeat.o(8544);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(8545);
    super.onClickCancelBtn(paramView);
    finish();
    AppMethodBeat.o(8545);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8543);
    super.onDestroy();
    an.cZJ();
    an.cZK();
    if (this.scene == 21) {
      an.Jw(18);
    }
    AppMethodBeat.o(8543);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8542);
    super.onPause();
    an.cZI();
    AppMethodBeat.o(8542);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8541);
    super.onResume();
    an.cZH();
    AppMethodBeat.o(8541);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSWebViewUI
 * JD-Core Version:    0.7.0.1
 */