package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class j
  extends i
{
  private ImageView rNq;
  private TextView rNr;
  
  public j(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rNa.setVisibility(8);
    this.bNu.setVisibility(8);
    this.fmL.setVisibility(8);
    this.rNa.setOnClickListener(null);
    this.rNq = ((ImageView)paramView.findViewById(R.h.note_reminder_iv));
    this.rNr = ((TextView)paramView.findViewById(R.h.note_reminder_tv));
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -4) {
      return;
    }
    this.rNh.setVisibility(0);
  }
  
  public final int cjv()
  {
    return -4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.j
 * JD-Core Version:    0.7.0.1
 */