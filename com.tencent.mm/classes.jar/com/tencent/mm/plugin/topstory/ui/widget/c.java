package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.ui.c.d;

public final class c
{
  public f NdD;
  a NdE;
  private int NdF;
  private View Ndu;
  private View Ndv;
  public View contentView;
  public String vid;
  
  public c(View paramView, a parama, f paramf, String paramString)
  {
    AppMethodBeat.i(126639);
    this.NdF = 16;
    this.contentView = paramView;
    this.NdD = paramf;
    this.Ndu = paramView.findViewById(c.d.down_iv);
    this.Ndv = paramView.findViewById(c.d.up_iv);
    this.NdE = parama;
    this.vid = paramString;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126638);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.this.NdE.a(c.this.NdD);
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
    if ((this.Ndv != null) && (this.Ndu != null))
    {
      paramInt = e.hg(paramView) - e.dip2px(paramView.getContext(), this.NdF);
      if (!paramBoolean) {
        break label150;
      }
      this.Ndv.setVisibility(0);
      this.Ndu.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.Ndv.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.Ndv.setLayoutParams(paramView);
    }
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)this.contentView.getLayoutParams();
      paramView.topMargin = arrayOfInt[1];
      this.contentView.setLayoutParams(paramView);
      AppMethodBeat.o(126640);
      return;
      label150:
      this.Ndv.setVisibility(8);
      this.Ndu.setVisibility(0);
      paramView = (RelativeLayout.LayoutParams)this.Ndu.getLayoutParams();
      paramView.leftMargin = paramInt;
      this.Ndu.setLayoutParams(paramView);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */