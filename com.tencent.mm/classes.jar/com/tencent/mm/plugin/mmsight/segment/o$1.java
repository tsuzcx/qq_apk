package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.drawable.Drawable;

final class o$1
  implements Runnable
{
  o$1(o paramo, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    if (this.mmR <= o.a(this.mmU) * 2) {
      throw new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
    }
    o.b(this.mmU);
    o.a(this.mmU, this.mmS);
    o.b(this.mmU, Math.min(this.mmR, this.mmU.getWidth() - this.mmS * 2));
    o.c(this.mmU, Math.max(this.mmT, o.a(this.mmU) * 2));
    o.c(this.mmU).setBounds(this.mmS, 0, this.mmS + o.a(this.mmU), this.mmU.getHeight());
    o.e(this.mmU).setBounds(this.mmS + o.d(this.mmU) - o.a(this.mmU), 0, o.d(this.mmU) + this.mmS, this.mmU.getHeight());
    if ((o.f(this.mmU) == null) && (o.g(this.mmU) == null))
    {
      o.a(this.mmU, o.c(this.mmU).getBounds());
      o.b(this.mmU, o.e(this.mmU).getBounds());
    }
    this.mmU.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.o.1
 * JD-Core Version:    0.7.0.1
 */