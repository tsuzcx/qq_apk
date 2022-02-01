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
  protected a Bms;
  private c rQv;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.rQv = new c()
    {
      protected final void aa(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.kxf != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.kxf.j(96, paramAnonymousBundle);
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
  
  public final void aD(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.rQv.BmP.aQ(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean bon()
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
    c.a(this.rQv.BmP.BmQ);
    if (this.Bms != null) {
      this.Bms.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.rQv.BmP.onPause();
    if (this.Bms != null)
    {
      a locala = this.Bms;
      locala.rQv.BmP.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.rQk;
      localGameWebPerformanceInfo.fVn += System.currentTimeMillis() - locala.rQw;
      locala.rQw = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.rQv.BmP.onResume();
    if (this.Bms != null)
    {
      a locala = this.Bms;
      locala.rQv.BmP.onResume();
      locala.rQw = System.currentTimeMillis();
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
      AppMethodBeat.i(188103);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).BmP.Bx();
      AppMethodBeat.o(188103);
    }
    
    public void m(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188102);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).BmP.epX();
      AppMethodBeat.o(188102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */