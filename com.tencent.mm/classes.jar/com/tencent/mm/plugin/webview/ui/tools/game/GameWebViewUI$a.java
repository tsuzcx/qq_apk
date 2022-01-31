package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class GameWebViewUI$a
  extends com.tencent.mm.plugin.webview.ui.tools.c
{
  public GameWebViewUI$a(GameWebViewUI paramGameWebViewUI, WebViewUI paramWebViewUI)
  {
    super(paramWebViewUI);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8732);
    Object localObject = GameWebViewUI.j(this.vnt).onMiscCallBack(paramString, paramBundle);
    if (localObject != null)
    {
      AppMethodBeat.o(8732);
      return localObject;
    }
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(8732);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */