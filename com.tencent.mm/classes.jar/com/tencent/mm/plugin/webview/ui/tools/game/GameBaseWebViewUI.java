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
  protected a JpK;
  private c xyK;
  
  public GameBaseWebViewUI()
  {
    AppMethodBeat.i(80808);
    this.xyK = new c()
    {
      protected final void an(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80805);
        try
        {
          if ((GameBaseWebViewUI.this.mHh != null) && (paramAnonymousBundle != null)) {
            GameBaseWebViewUI.this.mHh.j(96, paramAnonymousBundle);
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
  
  public final boolean bXi()
  {
    return true;
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(80809);
    this.xyK.Jqh.bm(paramBundle);
    AppMethodBeat.o(80809);
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
    c.a(this.xyK.Jqh.Jqi);
    if (this.JpK != null) {
      this.JpK.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(80813);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80812);
    super.onPause();
    this.xyK.Jqh.onPause();
    if (this.JpK != null)
    {
      a locala = this.JpK;
      locala.xyK.Jqh.onPause();
      GameWebPerformanceInfo localGameWebPerformanceInfo = locala.xyv;
      localGameWebPerformanceInfo.hhU += System.currentTimeMillis() - locala.xyL;
      locala.xyL = System.currentTimeMillis();
    }
    AppMethodBeat.o(80812);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80811);
    this.xyK.Jqh.onResume();
    if (this.JpK != null)
    {
      a locala = this.JpK;
      locala.xyK.Jqh.onResume();
      locala.xyL = System.currentTimeMillis();
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
      AppMethodBeat.i(211306);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).Jqh.LZ();
      AppMethodBeat.o(211306);
    }
    
    public void i(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(211305);
      GameBaseWebViewUI.a(GameBaseWebViewUI.this).Jqh.ghf();
      AppMethodBeat.o(211305);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI
 * JD-Core Version:    0.7.0.1
 */