package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c
{
  private View AgR;
  private View AgS;
  public f Aha;
  a Ahb;
  private int Ahc;
  public View contentView;
  public String hhd;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.Ahc = 16;
    this.contentView = paramView;
    this.Aha = paramf;
    this.AgR = paramView.findViewById(2131299190);
    this.AgS = paramView.findViewById(2131306200);
    this.Ahb = parama;
    this.hhd = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        c.this.Ahb.a(c.this.Aha);
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
    if ((this.AgS != null) && (this.AgR != null))
    {
      paramInt = e.ft(paramView) - e.dip2px(paramView.getContext(), this.Ahc);
      if (!paramBoolean) {
        break label150;
      }
      this.AgS.setVisibility(0);
      this.AgR.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.AgS.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.AgS.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.AgS.setVisibility(8);
      this.AgR.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.AgR.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.AgR.setLayoutParams(paramView);
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