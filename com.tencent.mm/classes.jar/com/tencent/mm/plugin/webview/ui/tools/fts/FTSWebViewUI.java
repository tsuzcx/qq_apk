package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.webview.c.i;

public class FTSWebViewUI
  extends FTSBaseWebViewUI
{
  private void iAC()
  {
    AppMethodBeat.i(80714);
    if (getScene() == 21) {
      as.atf(19);
    }
    AppMethodBeat.o(80714);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(80708);
    super.cKX();
    as.dD(getScene(), this.sessionId);
    if (getScene() == 21) {
      as.atf(17);
    }
    AppMethodBeat.o(80708);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80707);
    String str = getString(c.i.app_search);
    AppMethodBeat.o(80707);
    return str;
  }
  
  public final void izc()
  {
    AppMethodBeat.i(80715);
    iAC();
    super.izc();
    AppMethodBeat.o(80715);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80712);
    super.onBackPressed();
    iAC();
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
    as.iql();
    as.iqm();
    if (getScene() == 21) {
      as.atf(18);
    }
    AppMethodBeat.o(80711);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80710);
    super.onPause();
    as.iqk();
    AppMethodBeat.o(80710);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80709);
    super.onResume();
    as.iqj();
    AppMethodBeat.o(80709);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSWebViewUI
 * JD-Core Version:    0.7.0.1
 */