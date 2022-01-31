package com.tencent.xweb.sys;

import android.content.Context;
import android.view.KeyEvent;
import com.tencent.xweb.o;

final class e$a
  extends android.webkit.WebView
{
  public o gGh;
  
  public e$a(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4) && (this.xjZ.hasEnteredFullscreen()))
    {
      this.xjZ.leaveFullscreen();
      return true;
    }
    return false;
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xjZ.xjP != null) {
      this.xjZ.xjP.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.gGh != null) {
      this.gGh.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.e.a
 * JD-Core Version:    0.7.0.1
 */