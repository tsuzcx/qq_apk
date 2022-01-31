package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

public class GameBaseWebViewUI
  extends WebViewUI
{
  private c nkG;
  protected a vmg;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(8637);
    this.nkG = new GameBaseWebViewUI.1(this);
    AppMethodBeat.o(8637);
  }
  
  public final boolean aMh()
  {
    return true;
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(8638);
    this.nkG.vmB.ax(paramBundle);
    AppMethodBeat.o(8638);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(8639);
    super.onCreate(paramBundle);
    AppMethodBeat.o(8639);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(8642);
    c.a(this.nkG.vmB.vmC);
    if (this.vmg != null) {
      this.vmg.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(8642);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(8641);
    super.onPause();
    this.nkG.vmB.onPause();
    if (this.vmg != null)
    {
      a locala = this.vmg;
      locala.nkG.vmB.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.nkv;
      localGameWebPerformanceInfo.eAp += System.currentTimeMillis() - locala.nkH;
      locala.nkH = System.currentTimeMillis();
    }
    AppMethodBeat.o(8641);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(8640);
    this.nkG.vmB.onResume();
    if (this.vmg != null)
    {
      a locala = this.vmg;
      locala.nkG.vmB.onResume();
      locala.nkH = System.currentTimeMillis();
    }
    super.onResume();
    AppMethodBeat.o(8640);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */