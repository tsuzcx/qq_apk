package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;

public class a
  extends CardLayoutManager.d
{
  private final int QhO;
  private final int QhP;
  private CardLayoutManager.f QhQ;
  
  public a(int paramInt1, int paramInt2)
  {
    this.QhO = paramInt1;
    this.QhP = paramInt2;
  }
  
  private static float d(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramInt1 - paramFloat;
    }
    return paramInt1 - 2.0F * paramFloat + 1.0F;
  }
  
  public void a(int paramInt1, float paramFloat, View paramView, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(310252);
    CardLayoutManager localCardLayoutManager = this.QhK;
    if ((localCardLayoutManager == null) || (this.QhJ <= 0) || (this.QhI <= 0))
    {
      AppMethodBeat.o(310252);
      return;
    }
    if (paramInt2 == 0)
    {
      paramInt1 = aki(paramInt1);
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, 0, paramInt1 + this.QhI, this.QhJ + 0);
      AppMethodBeat.o(310252);
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
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, paramInt2, paramInt1 + this.QhI, paramInt2 + this.QhJ);
    }
    AppMethodBeat.o(310252);
  }
  
  public final boolean akg(int paramInt)
  {
    AppMethodBeat.i(310215);
    CardLayoutManager localCardLayoutManager = this.QhK;
    if (localCardLayoutManager == null)
    {
      AppMethodBeat.o(310215);
      return false;
    }
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (this.QhQ == null) {
      this.QhQ = new CardLayoutManager.f();
    }
    this.QhQ.width = (paramInt - this.QhO * 2);
    this.QhQ.height = ((int)(this.QhQ.width * 0.75F + 0.5F));
    localCardLayoutManager.setMeasuredDimension(paramInt, this.QhQ.height);
    AppMethodBeat.o(310215);
    return true;
  }
  
  final int aki(int paramInt)
  {
    if ((this.QhI == 0) || (this.QhJ == 0)) {}
    do
    {
      return 0;
      if (paramInt >= 0) {
        return -paramInt % this.QhI;
      }
    } while (paramInt % this.QhI == 0);
    return -paramInt % this.QhI - this.QhI;
  }
  
  final int b(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(310273);
    paramInt1 = Math.round(this.QhO * d(paramInt1, paramFloat, paramInt2));
    AppMethodBeat.o(310273);
    return paramInt1;
  }
  
  final int c(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(310282);
    paramInt1 = Math.round(this.QhP * d(paramInt1, paramFloat, paramInt2));
    AppMethodBeat.o(310282);
    return paramInt1;
  }
  
  public final float hdr()
  {
    return 0.5F;
  }
  
  public final void jp(View paramView)
  {
    AppMethodBeat.i(310232);
    Object localObject = this.QhK;
    CardLayoutManager.f localf = this.QhQ;
    if ((localObject == null) || (paramView == null) || (paramView.getTag(b.f.sns_ad_finder_topic_card_item_layout_ready) != null))
    {
      AppMethodBeat.o(310232);
      return;
    }
    localObject = paramView.getLayoutParams();
    if ((localObject == null) || (localf == null))
    {
      AppMethodBeat.o(310232);
      return;
    }
    ((ViewGroup.LayoutParams)localObject).width = localf.width;
    ((ViewGroup.LayoutParams)localObject).height = localf.height;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setTag(b.f.sns_ad_finder_topic_card_item_layout_ready, Boolean.TRUE);
    AppMethodBeat.o(310232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */