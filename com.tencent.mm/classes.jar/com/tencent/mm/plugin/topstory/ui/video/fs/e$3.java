package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.protocal.c.byg;

final class e$3
  implements f.a
{
  e$3(e parame) {}
  
  public final void bOw()
  {
    e.H(this.pGX).setVisibility(8);
  }
  
  public final void bOx()
  {
    if ((this.pGX.getFSVideoUIComponent().bNx().pGx) && ((this.pGX.getFSVideoUIComponent().bNx().bOu()) || (this.pGX.getFSVideoUIComponent().bNx().pGy)))
    {
      e.I(this.pGX).setVisibility(0);
      return;
    }
    e.J(this.pGX).setVisibility(8);
  }
  
  public final void update(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {}
    for (int i = e.A(this.pGX).getWidth() * paramInt1 / paramInt2;; i = 0)
    {
      Object localObject = this.pGX.getFSVideoUIComponent().bNt().pGq;
      if ((localObject != null) && (((a)localObject).pDh < this.pGX.getFSVideoUIComponent().bNx().getCurrPosMs())) {
        ((a)localObject).pDh = this.pGX.getFSVideoUIComponent().bNx().getCurrPosMs();
      }
      localObject = (FrameLayout.LayoutParams)e.B(this.pGX).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      e.C(this.pGX).setLayoutParams((ViewGroup.LayoutParams)localObject);
      e.D(this.pGX).requestLayout();
      if ((e.E(this.pGX).tOK <= 0) && (e.F(this.pGX).ej(paramInt1, paramInt2))) {
        e.G(this.pGX).tOK = 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.3
 * JD-Core Version:    0.7.0.1
 */