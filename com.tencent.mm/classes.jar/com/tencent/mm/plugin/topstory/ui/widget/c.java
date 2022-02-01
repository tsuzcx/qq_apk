package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c
{
  private View BQb;
  private View BQc;
  public f BQk;
  a BQl;
  private int BQm;
  public View contentView;
  public String hCa;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.BQm = 16;
    this.contentView = paramView;
    this.BQk = paramf;
    this.BQb = paramView.findViewById(2131299190);
    this.BQc = paramView.findViewById(2131306200);
    this.BQl = parama;
    this.hCa = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        c.this.BQl.a(c.this.BQk);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    if ((this.BQc != null) && (this.BQb != null))
    {
      paramInt = e.fF(paramView) - e.dip2px(paramView.getContext(), this.BQm);
      if (!paramBoolean) {
        break label150;
      }
      this.BQc.setVisibility(0);
      this.BQb.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.BQc.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.BQc.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.BQc.setVisibility(8);
      this.BQb.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.BQb.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.BQb.setLayoutParams(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */