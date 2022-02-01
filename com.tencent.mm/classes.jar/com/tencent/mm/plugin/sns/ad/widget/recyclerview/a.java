package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends CardLayoutManager.d
{
  private final int DBD;
  private final int DBE;
  private CardLayoutManager.f DBF;
  
  public a(int paramInt1, int paramInt2)
  {
    this.DBD = paramInt1;
    this.DBE = paramInt2;
  }
  
  private static float a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramInt1 - paramFloat;
    }
    return paramInt1 - 2.0F * paramFloat + 1.0F;
  }
  
  public final boolean Yf(int paramInt)
  {
    AppMethodBeat.i(202487);
    CardLayoutManager localCardLayoutManager = this.DBz;
    if (localCardLayoutManager == null)
    {
      AppMethodBeat.o(202487);
      return false;
    }
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (this.DBF == null) {
      this.DBF = new CardLayoutManager.f();
    }
    this.DBF.width = (paramInt - this.DBD * 2);
    this.DBF.height = ((int)(this.DBF.width * 0.75F + 0.5F));
    localCardLayoutManager.setMeasuredDimension(paramInt, this.DBF.height);
    AppMethodBeat.o(202487);
    return true;
  }
  
  public final void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(202489);
    CardLayoutManager localCardLayoutManager = this.DBz;
    if ((localCardLayoutManager == null) || (this.DBy <= 0) || (this.DBx <= 0))
    {
      AppMethodBeat.o(202489);
      return;
    }
    if (paramInt2 == 0)
    {
      if ((this.DBx == 0) || (this.DBy == 0)) {
        paramInt1 = 0;
      }
      for (;;)
      {
        localCardLayoutManager.layoutDecorated(paramView, paramInt1, 0, paramInt1 + this.DBx, this.DBy + 0);
        AppMethodBeat.o(202489);
        return;
        if (paramInt1 >= 0) {
          paramInt1 = -paramInt1 % this.DBx;
        } else if (paramInt1 % this.DBx == 0) {
          paramInt1 = 0;
        } else {
          paramInt1 = -paramInt1 % this.DBx - this.DBx;
        }
      }
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
      paramInt1 = Math.round(this.DBD * a(paramInt2, paramFloat, paramInt3));
      paramInt2 = Math.round(this.DBE * a(paramInt2, paramFloat, paramInt3));
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, paramInt2, paramInt1 + this.DBx, paramInt2 + this.DBy);
    }
    AppMethodBeat.o(202489);
  }
  
  public final void fe(View paramView)
  {
    AppMethodBeat.i(202488);
    Object localObject = this.DBz;
    CardLayoutManager.f localf = this.DBF;
    if ((localObject == null) || (paramView == null) || (paramView.getTag(2131308007) != null))
    {
      AppMethodBeat.o(202488);
      return;
    }
    localObject = paramView.getLayoutParams();
    if ((localObject == null) || (localf == null))
    {
      AppMethodBeat.o(202488);
      return;
    }
    ((ViewGroup.LayoutParams)localObject).width = localf.width;
    ((ViewGroup.LayoutParams)localObject).height = localf.height;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setTag(2131308007, Boolean.TRUE);
    AppMethodBeat.o(202488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */