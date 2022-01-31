package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b
  extends i
{
  public b(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rNa.setVisibility(8);
    this.bNu.setVisibility(8);
    this.fmL.setVisibility(8);
    this.rNa.setOnClickListener(null);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -2) {}
    while (this.rLi.rJg != 3) {
      return;
    }
    this.rNi.setVisibility(0);
  }
  
  public final int cjv()
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.b
 * JD-Core Version:    0.7.0.1
 */