package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI
  extends WebViewUI
{
  protected a CEz;
  private c sYm;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.sYm = new c()
    {
      protected final void ad(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.kYt != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.kYt.k(96, paramAnonymousBundle);
          }
          AppMethodBeat.o(80805);
          return;
        }
        catch (RemoteException paramAnonymousBundle)
        {
          AppMethodBeat.o(80805);
        }
      }
    };
    AppMethodBeat.o(80808);
  }
  
  public final void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.sYm.CEW.aU(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean bvj()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80810);
    super.onCreate(paramBundle);
    AppMethodBeat.o(80810);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80813);
    c.a(this.sYm.CEW.CEX);
    if (this.CEz != null) {
      this.CEz.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.sYm.CEW.onPause();
    if (this.CEz != null)
    {
      a locala = this.CEz;
      locala.sYm.CEW.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.sYb;
      localGameWebPerformanceInfo.fZi += System.currentTimeMillis() - locala.sYn;
      locala.sYn = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.sYm.CEW.onResume();
    if (this.CEz != null)
    {
      a locala = this.CEz;
      locala.sYm.CEW.onResume();
      locala.sYn = System.currentTimeMillis();
    }
    super.onResume();
    AppMethodBeat.o(80811);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected class a
    extends com.tencent.mm.plugin.webview.core.e
  {
    protected a() {}
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188547);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).CEW.Bb();
      AppMethodBeat.o(188547);
    }
    
    public void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188546);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).CEW.eFr();
      AppMethodBeat.o(188546);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */