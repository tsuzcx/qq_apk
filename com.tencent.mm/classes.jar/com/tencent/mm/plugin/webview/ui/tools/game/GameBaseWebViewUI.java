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
  protected a Eij;
  private c tVy;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.tVy = new c()
    {
      protected final void ag(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.lvv != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.lvv.k(96, paramAnonymousBundle);
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
  
  public final void aN(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.tVy.EiG.aZ(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean bzp()
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
    c.a(this.tVy.EiG.EiH);
    if (this.Eij != null) {
      this.Eij.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.tVy.EiG.onPause();
    if (this.Eij != null)
    {
      a locala = this.Eij;
      locala.tVy.EiG.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.tVm;
      localGameWebPerformanceInfo.gsE += System.currentTimeMillis() - locala.tVz;
      locala.tVz = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.tVy.EiG.onResume();
    if (this.Eij != null)
    {
      a locala = this.Eij;
      locala.tVy.EiG.onResume();
      locala.tVz = System.currentTimeMillis();
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
    
    public void aGk(String paramString)
    {
      AppMethodBeat.i(208216);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).EiG.eUn();
      AppMethodBeat.o(208216);
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(208217);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).EiG.CA();
      AppMethodBeat.o(208217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */