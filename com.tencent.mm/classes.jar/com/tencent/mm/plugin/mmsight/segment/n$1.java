package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$1
  implements Runnable
{
  n$1(n paramn, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(55011);
    if (this.oLZ <= n.a(this.oMc) * 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
      AppMethodBeat.o(55011);
      throw localIllegalStateException;
    }
    n.b(this.oMc);
    n.a(this.oMc, this.oMa);
    n.b(this.oMc, Math.min(this.oLZ, this.oMc.getWidth() - this.oMa * 2));
    n.c(this.oMc, Math.max(this.oMb, n.a(this.oMc) * 2));
    n.c(this.oMc).setBounds(this.oMa, 0, this.oMa + n.a(this.oMc), this.oMc.getHeight());
    n.e(this.oMc).setBounds(this.oMa + n.d(this.oMc) - n.a(this.oMc), 0, n.d(this.oMc) + this.oMa, this.oMc.getHeight());
    if ((n.f(this.oMc) == null) && (n.g(this.oMc) == null))
    {
      n.a(this.oMc, new Rect(n.c(this.oMc).getBounds().left, n.c(this.oMc).getBounds().top, n.c(this.oMc).getBounds().right, n.c(this.oMc).getBounds().bottom));
      n.b(this.oMc, new Rect(n.e(this.oMc).getBounds().left, n.e(this.oMc).getBounds().top, n.e(this.oMc).getBounds().right, n.e(this.oMc).getBounds().bottom));
    }
    this.oMc.invalidate();
    AppMethodBeat.o(55011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n.1
 * JD-Core Version:    0.7.0.1
 */