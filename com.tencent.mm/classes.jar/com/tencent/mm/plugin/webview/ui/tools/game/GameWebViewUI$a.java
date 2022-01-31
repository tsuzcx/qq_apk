package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g;
import com.tencent.mm.plugin.wepkg.c;

final class GameWebViewUI$a
  extends WebViewUI.g
{
  private GameWebViewUI$a(GameWebViewUI paramGameWebViewUI)
  {
    super(paramGameWebViewUI);
  }
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    Object localObject = GameWebViewUI.F(this.rwB).onMiscCallBack(paramString, paramBundle);
    if (localObject != null) {
      return localObject;
    }
    return super.onMiscCallBack(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.a
 * JD-Core Version:    0.7.0.1
 */