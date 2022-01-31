package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkView;

final class h$a
  extends XWalkView
{
  public h$a(h paramh, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChangedDelegate(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xmk.xjP != null) {
      this.xmk.xjP.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.a
 * JD-Core Version:    0.7.0.1
 */