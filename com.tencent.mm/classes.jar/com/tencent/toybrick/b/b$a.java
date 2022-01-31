package com.tencent.toybrick.b;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.mm.ui.ao;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.e.c;
import com.tencent.toybrick.e.c.d;

final class b$a
  extends RecyclerView.c
{
  private b$a(b paramb) {}
  
  public final void al(int paramInt1, int paramInt2)
  {
    super.al(paramInt1, paramInt2);
    ao.s("[onItemRangeChanged] positionStart:%d, itemCount:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    g localg = this.xas.Kq(paramInt1);
    if ((localg != null) && (localg.xbb != null)) {
      c.execute(new c.d(c.xbF, localg, localg.xbb, new b.a.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.b.b.a
 * JD-Core Version:    0.7.0.1
 */