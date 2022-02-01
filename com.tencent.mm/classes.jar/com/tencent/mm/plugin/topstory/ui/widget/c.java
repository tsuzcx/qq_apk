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
  private View ByD;
  private View ByE;
  public f ByM;
  a ByN;
  private int ByO;
  public View contentView;
  public String hzm;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.ByO = 16;
    this.contentView = paramView;
    this.ByM = paramf;
    this.ByD = paramView.findViewById(2131299190);
    this.ByE = paramView.findViewById(2131306200);
    this.ByN = parama;
    this.hzm = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        c.this.ByN.a(c.this.ByM);
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
    if ((this.ByE != null) && (this.ByD != null))
    {
      paramInt = e.fG(paramView) - e.dip2px(paramView.getContext(), this.ByO);
      if (!paramBoolean) {
        break label150;
      }
      this.ByE.setVisibility(0);
      this.ByD.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.ByE.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.ByE.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.ByE.setVisibility(8);
      this.ByD.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.ByD.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.ByD.setLayoutParams(paramView);
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