package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k
  extends i
{
  private View rNs;
  
  public k(View paramView, com.tencent.mm.plugin.wenote.model.nativenote.manager.k paramk)
  {
    super(paramView, paramk);
    this.rNa.setVisibility(8);
    this.bNu.setVisibility(8);
    this.fmL.setVisibility(8);
    this.rNa.setOnClickListener(null);
    this.rNf.setOnClickListener(new k.1(this));
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -1) {
      return;
    }
    paramc = (RelativeLayout.LayoutParams)this.rNg.getLayoutParams();
    paramc.bottomMargin = 0;
    paramc.topMargin = 0;
    this.rNg.setLayoutParams(paramc);
    this.rNf.setVisibility(0);
    this.rNs = this.aie.findViewById(R.h.note_split_line);
  }
  
  public final int cjv()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.k
 * JD-Core Version:    0.7.0.1
 */