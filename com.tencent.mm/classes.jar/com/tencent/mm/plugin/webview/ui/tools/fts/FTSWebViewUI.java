package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.am;

public class FTSWebViewUI
  extends FTSBaseWebViewUI
{
  private void eUf()
  {
    AppMethodBeat.i(80714);
    if (this.scene == 21) {
      am.Wm(19);
    }
    AppMethodBeat.o(80714);
  }
  
  public final void bzn()
  {
    AppMethodBeat.i(80708);
    super.bzn();
    am.Wk(this.scene);
    if (this.scene == 21) {
      am.Wm(17);
    }
    AppMethodBeat.o(80708);
  }
  
  public final void eTg()
  {
    AppMethodBeat.i(80715);
    eUf();
    super.eTg();
    AppMethodBeat.o(80715);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80707);
    String str = getString(2131755882);
    AppMethodBeat.o(80707);
    return str;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80712);
    super.onBackPressed();
    eUf();
    AppMethodBeat.o(80712);
  }
  
  public void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(80713);
    super.onClickCancelBtn(paramView);
    finish();
    AppMethodBeat.o(80713);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80711);
    super.onDestroy();
    am.eMs();
    am.eMt();
    if (this.scene == 21) {
      am.Wm(18);
    }
    AppMethodBeat.o(80711);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80710);
    super.onPause();
    am.eMr();
    AppMethodBeat.o(80710);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80709);
    super.onResume();
    am.eMq();
    AppMethodBeat.o(80709);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSWebViewUI
 * JD-Core Version:    0.7.0.1
 */