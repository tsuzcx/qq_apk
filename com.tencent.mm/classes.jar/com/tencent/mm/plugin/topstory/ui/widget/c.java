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
  private View GqJ;
  private View GqK;
  public f GqS;
  a GqT;
  private int GqU;
  public View contentView;
  public String vid;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.GqU = 16;
    this.contentView = paramView;
    this.GqS = paramf;
    this.GqJ = paramView.findViewById(2131299741);
    this.GqK = paramView.findViewById(2131309598);
    this.GqT = parama;
    this.vid = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        c.this.GqT.a(c.this.GqS);
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
    if ((this.GqK != null) && (this.GqJ != null))
    {
      paramInt = e.fX(paramView) - e.dip2px(paramView.getContext(), this.GqU);
      if (!paramBoolean) {
        break label150;
      }
      this.GqK.setVisibility(0);
      this.GqJ.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.GqK.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.GqK.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.GqK.setVisibility(8);
      this.GqJ.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.GqJ.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.GqJ.setLayoutParams(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */