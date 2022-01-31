package com.tencent.xweb.xwalk;

import android.widget.AbsoluteLayout;
import com.tencent.xweb.o;
import org.xwalk.core.XWalkView.ScrollChangedListener;

final class h$3
  implements XWalkView.ScrollChangedListener
{
  h$3(h paramh) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.xmk.xmb.scrollTo(paramInt1, paramInt2);
    if (this.xmk.gGh != null) {
      this.xmk.gGh.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this.xmk.xlW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.3
 * JD-Core Version:    0.7.0.1
 */