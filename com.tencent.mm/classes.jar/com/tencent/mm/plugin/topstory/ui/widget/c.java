package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c
{
  public View contentView;
  public String fgl;
  public f tmA;
  c.a tmB;
  private int tmC;
  private View tmr;
  private View tms;
  
  public c(View paramView, c.a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(2233);
    this.tmC = 16;
    this.contentView = paramView;
    this.tmA = paramf;
    this.tmr = paramView.findViewById(2131828567);
    this.tms = paramView.findViewById(2131828571);
    this.tmB = parama;
    this.fgl = paramString;
    paramView.setOnClickListener(new c.1(this));
    AppMethodBeat.o(2233);
  }
  
  public final void a(View paramView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(2234);
    int[] arrayOfInt = d.a(paramView.getContext(), paramView, this.contentView, paramBoolean);
    arrayOfInt[0] += 0;
    arrayOfInt[1] += paramInt;
    if ((this.tms != null) && (this.tmr != null))
    {
      paramInt = d.es(paramView) - d.dip2px(paramView.getContext(), this.tmC);
      if (!paramBoolean) {
        break label152;
      }
      this.tms.setVisibility(0);
      this.tmr.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.tms.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.tms.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(2234);
      return;
      label152:
      this.tms.setVisibility(8);
      this.tmr.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.tmr.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.tmr.setLayoutParams(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */