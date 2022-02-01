package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(310202);
    CardLayoutManager localCardLayoutManager = this.QhK;
    if ((localCardLayoutManager == null) || (this.QhJ <= 0) || (this.QhI <= 0))
    {
      AppMethodBeat.o(310202);
      return;
    }
    if (paramInt2 == 0)
    {
      paramInt1 = aki(paramInt1);
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, 0, paramInt1 + this.QhI, this.QhJ + 0);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      AppMethodBeat.o(310202);
      return;
    }
    if ((paramInt3 == 0) || (paramFloat >= 0.5F)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramInt1 = c(paramInt2, paramFloat, paramInt3);
        float f = (this.QhJ - paramInt1 * 2) / this.QhJ;
        paramView.setScaleX(f);
        paramView.setScaleY(f);
        paramInt1 = b(paramInt2, paramFloat, paramInt3);
        paramInt2 = (int)((1.0F - f) * this.QhI / 2.0F);
        localCardLayoutManager.layoutDecorated(paramView, paramInt1 + paramInt2, 0, this.QhI + (paramInt2 + paramInt1), this.QhJ + 0);
      }
      AppMethodBeat.o(310202);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */