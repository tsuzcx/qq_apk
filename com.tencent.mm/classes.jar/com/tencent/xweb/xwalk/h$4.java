package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.OverScrolledListener;

final class h$4
  implements XWalkView.OverScrolledListener
{
  h$4(h paramh) {}
  
  public final void onOverScrolled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      h.a(this.xmk, true);
      return;
    }
    h.a(this.xmk, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.4
 * JD-Core Version:    0.7.0.1
 */