package com.tencent.xweb.xwalk;

import android.webkit.WebView.FindListener;
import org.xwalk.core.XWalkFindListener;

public final class e$f
  extends XWalkFindListener
{
  WebView.FindListener xkj;
  
  public e$f(WebView.FindListener paramFindListener)
  {
    this.xkj = paramFindListener;
  }
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.xkj != null) {
      this.xkj.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e.f
 * JD-Core Version:    0.7.0.1
 */