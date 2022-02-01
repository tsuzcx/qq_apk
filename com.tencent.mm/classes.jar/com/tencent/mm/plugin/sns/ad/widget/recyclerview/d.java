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
    int i = 0;
    AppMethodBeat.i(207410);
    CardLayoutManager localCardLayoutManager = this.JNk;
    if ((localCardLayoutManager == null) || (this.JNj <= 0) || (this.JNi <= 0))
    {
      AppMethodBeat.o(207410);
      return;
    }
    if (paramInt2 == 0)
    {
      paramInt1 = afw(paramInt1);
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, 0, paramInt1 + this.JNi, this.JNj + 0);
      AppMethodBeat.o(207410);
      return;
    }
    if (paramInt3 != 0)
    {
      paramInt1 = i;
      if (paramFloat < 0.5F) {}
    }
    else
    {
      paramInt1 = 1;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = b(paramInt2, paramFloat, paramInt3);
      paramInt2 = c(paramInt2, paramFloat, paramInt3);
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, paramInt2, paramInt1 + this.JNi, paramInt2 + (this.JNj - paramInt2 * 2));
    }
    AppMethodBeat.o(207410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.d
 * JD-Core Version:    0.7.0.1
 */