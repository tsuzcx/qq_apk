package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.xweb.x5.a.a.a.a.b;

final class a$c
  extends b
{
  private a$c(a parama) {}
  
  public final Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8672);
    Object localObject = this.vmw.vmq.onMiscCallBack(paramString, paramBundle);
    if (localObject != null)
    {
      AppMethodBeat.o(8672);
      return localObject;
    }
    paramString = super.onMiscCallBack(paramString, paramBundle);
    AppMethodBeat.o(8672);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.c
 * JD-Core Version:    0.7.0.1
 */