package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.xweb.x5.a.a.a.a.b;

final class a$b
  extends b
{
  private a$b(a parama) {}
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    Object localObject = this.rwe.rwa.onMiscCallBack(paramString, paramBundle);
    if (localObject != null) {
      return localObject;
    }
    return super.onMiscCallBack(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.b
 * JD-Core Version:    0.7.0.1
 */