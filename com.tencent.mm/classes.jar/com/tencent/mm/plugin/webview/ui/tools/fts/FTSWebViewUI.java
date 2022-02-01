package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.webview.c.i;

public class FTSWebViewUI
  extends FTSBaseWebViewUI
{
  private void har()
  {
    AppMethodBeat.i(80714);
    if (getScene() == 21) {
      ar.anp(19);
    }
    AppMethodBeat.o(80714);
  }
  
  public final void cjK()
  {
    AppMethodBeat.i(80708);
    super.cjK();
    ar.ann(getScene());
    if (getScene() == 21) {
      ar.anp(17);
    }
    AppMethodBeat.o(80708);
  }
  
  public final void gZc()
  {
    AppMethodBeat.i(80715);
    har();
    super.gZc();
    AppMethodBeat.o(80715);
  }
  
  protected final String getHint()
  {
    AppMethodBeat.i(80707);
    String str = getString(c.i.app_search);
    AppMethodBeat.o(80707);
    return str;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(80712);
    super.onBackPressed();
    har();
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
    ar.gQZ();
    ar.gRa();
    if (getScene() == 21) {
      ar.anp(18);
    }
    AppMethodBeat.o(80711);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80710);
    super.onPause();
    ar.gQY();
    AppMethodBeat.o(80710);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80709);
    super.onResume();
    ar.gQX();
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