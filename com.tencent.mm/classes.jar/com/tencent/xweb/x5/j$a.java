package com.tencent.xweb.x5;

import android.content.Context;

final class j$a
  extends com.tencent.smtt.sdk.WebView
{
  public j$a(j paramj, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xkO.xjP != null) {
      this.xkO.xjP.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.j.a
 * JD-Core Version:    0.7.0.1
 */