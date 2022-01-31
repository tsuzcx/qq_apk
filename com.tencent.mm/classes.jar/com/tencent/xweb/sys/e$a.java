package com.tencent.xweb.sys;

import android.content.Context;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.v;

final class e$a
  extends android.webkit.WebView
{
  public v igO;
  
  public e$a(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(84698);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (this.BHD.hasEnteredFullscreen()))
    {
      this.BHD.leaveFullscreen();
      AppMethodBeat.o(84698);
      return true;
    }
    AppMethodBeat.o(84698);
    return false;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(84697);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.BHD.BHt != null) {
      this.BHD.BHt.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.igO != null) {
      this.igO.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
    AppMethodBeat.o(84697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.e.a
 * JD-Core Version:    0.7.0.1
 */