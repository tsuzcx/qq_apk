package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c
{
  public View contentView;
  public String gGC;
  private View yTc;
  private View yTd;
  public f yTl;
  a yTm;
  private int yTn;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.yTn = 16;
    this.contentView = paramView;
    this.yTl = paramf;
    this.yTc = paramView.findViewById(2131299190);
    this.yTd = paramView.findViewById(2131306200);
    this.yTm = parama;
    this.gGC = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        c.this.yTm.a(c.this.yTl);
        AppMethodBeat.o(126638);
      }
    });
    AppMethodBeat.o(126639);
  }
  
  public final void a(View paramView, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(126640);
    int[] arrayOfInt = e.b(paramView.getContext(), paramView, this.contentView, paramBoolean);
    arrayOfInt[0] += 0;
    arrayOfInt[1] += paramInt;
    if ((this.yTd != null) && (this.yTc != null))
    {
      paramInt = e.fg(paramView) - e.dip2px(paramView.getContext(), this.yTn);
      if (!paramBoolean) {
        break label150;
      }
      this.yTd.setVisibility(0);
      this.yTc.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.yTd.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.yTd.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.yTd.setVisibility(8);
      this.yTc.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.yTc.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.yTc.setLayoutParams(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */