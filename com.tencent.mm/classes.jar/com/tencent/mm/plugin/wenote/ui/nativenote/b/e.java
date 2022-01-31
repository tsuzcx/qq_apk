package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e
  extends a
{
  private TextView rMQ;
  private View rMR;
  public LinearLayout rMS;
  
  public e(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rMS = ((LinearLayout)paramView.findViewById(R.h.note_header_ll));
    this.rMS.setVisibility(0);
    this.rMQ = ((TextView)paramView.findViewById(R.h.note_header_tips));
    this.rMR = paramView.findViewById(R.h.note_header_split_line);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramc.getType() != -3) {}
    do
    {
      return;
      if (this.rLi.rJg == 3)
      {
        this.rMS.setVisibility(8);
        return;
      }
      this.rMS.setVisibility(0);
      paramc = (com.tencent.mm.plugin.wenote.model.a.e)paramc;
    } while (paramc.rGy <= 0L);
    Object localObject = this.rMQ.getContext();
    long l = paramc.rGy;
    if (l < 3600000L) {}
    for (paramc = "";; paramc = DateFormat.format(((Context)localObject).getString(R.l.favorite_longdate), l))
    {
      localObject = this.rMQ.getContext().getString(R.l.note_edit_time);
      paramc = (String)localObject + " " + paramc;
      this.rMQ.setText(paramc);
      return;
    }
  }
  
  public final int cjv()
  {
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.e
 * JD-Core Version:    0.7.0.1
 */