package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI
  extends WebViewUI
{
  private d IwT;
  protected b Xft;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.IwT = new d()
    {
      protected final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.sLC != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.sLC.m(96, paramAnonymousBundle);
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
  
  public final void bA(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.IwT.XfS.bP(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean cKZ()
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
    d.a(this.IwT.XfS.XfT);
    if (this.Xft != null) {
      this.Xft.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.IwT.XfS.onPause();
    if (this.Xft != null)
    {
      b localb = this.Xft;
      localb.IwT.XfS.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = localb.IwE;
      localGameWebPerformanceInfo.muk += System.currentTimeMillis() - localb.IwU;
      localb.IwU = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.IwT.XfS.onResume();
    if (this.Xft != null)
    {
      b localb = this.Xft;
      localb.IwT.XfS.onResume();
      localb.IwU = System.currentTimeMillis();
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
    extends h
  {
    protected a() {}
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(297051);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).XfS.aoZ();
      AppMethodBeat.o(297051);
    }
    
    public void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(297047);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).XfS.iAL();
      AppMethodBeat.o(297047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */