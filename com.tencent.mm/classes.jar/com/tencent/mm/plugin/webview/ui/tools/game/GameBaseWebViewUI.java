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
  protected a EAn;
  private c ugv;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.ugv = new c()
    {
      protected final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.lzT != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.lzT.k(96, paramAnonymousBundle);
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
  
  public final void aO(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.ugv.EAK.ba(paramBundle);
    AppMethodBeat.o(80809);
  }
  
  public final boolean bAk()
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
    c.a(this.ugv.EAK.EAL);
    if (this.EAn != null) {
      this.EAn.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.ugv.EAK.onPause();
    if (this.EAn != null)
    {
      a locala = this.EAn;
      locala.ugv.EAK.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.ugi;
      localGameWebPerformanceInfo.gvf += System.currentTimeMillis() - locala.ugw;
      locala.ugw = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.ugv.EAK.onResume();
    if (this.EAn != null)
    {
      a locala = this.EAn;
      locala.ugv.EAK.onResume();
      locala.ugw = System.currentTimeMillis();
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
    
    public void aHE(String paramString)
    {
      AppMethodBeat.i(198397);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).EAK.eYa();
      AppMethodBeat.o(198397);
    }
    
    public void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(198398);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).EAK.CD();
      AppMethodBeat.o(198398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */