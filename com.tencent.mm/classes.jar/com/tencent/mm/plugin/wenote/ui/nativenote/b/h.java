package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class h
  extends i
{
  public h(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rNa.setVisibility(0);
    this.bNu.setVisibility(8);
    this.fmL.setVisibility(8);
    this.rNa.setTag(this);
    this.rNa.setOnClickListener(this.laS);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    this.rNd.setImageResource(R.k.app_attach_file_icon_location);
    this.rNb.setText(((g)paramc).lFn);
    this.rNc.setText(((g)paramc).ekZ);
    super.a(paramc, paramInt1, paramInt2);
  }
  
  public final int cjv()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.h
 * JD-Core Version:    0.7.0.1
 */