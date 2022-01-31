package com.tencent.toybrick.c;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.g;
import com.tencent.toybrick.f.a;

public final class e
  extends g<e, a>
{
  public static final int xau = a.g.space_toybrick;
  private int xaX;
  
  public final void a(a parama)
  {
    if (this.xaX == 0) {
      this.xaX = ((int)this.xaY.getResources().getDimension(a.d.Edge_2A));
    }
    parama.aie.setLayoutParams(new RecyclerView.LayoutParams(-1, this.xaX));
  }
  
  public final g.b cQZ()
  {
    return g.b.xbm;
  }
  
  public final a er(View paramView)
  {
    return new a(paramView);
  }
  
  public final int getLayoutResource()
  {
    return xau;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.c.e
 * JD-Core Version:    0.7.0.1
 */