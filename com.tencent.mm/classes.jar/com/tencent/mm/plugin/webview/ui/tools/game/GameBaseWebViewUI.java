package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI
  extends WebViewUI
{
  private d CCS;
  protected b Qnf;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.CCS = new d()
    {
      protected final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.pGC != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.pGC.l(96, paramAnonymousBundle);
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
  
  public final void aW(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.CCS.QnE.bk(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean cjM()
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
    d.a(this.CCS.QnE.QnF);
    if (this.Qnf != null) {
      this.Qnf.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.CCS.QnE.onPause();
    if (this.Qnf != null)
    {
      b localb = this.Qnf;
      localb.CCS.QnE.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = localb.CCD;
      localGameWebPerformanceInfo.jTS += System.currentTimeMillis() - localb.CCT;
      localb.CCT = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.CCS.QnE.onResume();
    if (this.Qnf != null)
    {
      b localb = this.Qnf;
      localb.CCS.QnE.onResume();
      localb.CCT = System.currentTimeMillis();
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
    extends f
  {
    protected a() {}
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(264859);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).QnE.OR();
      AppMethodBeat.o(264859);
    }
    
    public void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(264858);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).QnE.hay();
      AppMethodBeat.o(264858);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */