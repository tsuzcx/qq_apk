package com.tencent.mm.plugin.sns.ad.widget.recyclerview;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;

public class a
  extends CardLayoutManager.d
{
  private final int JNo;
  private final int JNp;
  private CardLayoutManager.f JNq;
  
  public a(int paramInt1, int paramInt2)
  {
    this.JNo = paramInt1;
    this.JNp = paramInt2;
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
    AppMethodBeat.i(261186);
    CardLayoutManager localCardLayoutManager = this.JNk;
    if ((localCardLayoutManager == null) || (this.JNj <= 0) || (this.JNi <= 0))
    {
      AppMethodBeat.o(261186);
      return;
    }
    if (paramInt2 == 0)
    {
      paramInt1 = afw(paramInt1);
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, 0, paramInt1 + this.JNi, this.JNj + 0);
      AppMethodBeat.o(261186);
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
      localCardLayoutManager.layoutDecorated(paramView, paramInt1, paramInt2, paramInt1 + this.JNi, paramInt2 + this.JNj);
    }
    AppMethodBeat.o(261186);
  }
  
  public final boolean afu(int paramInt)
  {
    AppMethodBeat.i(261178);
    CardLayoutManager localCardLayoutManager = this.JNk;
    if (localCardLayoutManager == null)
    {
      AppMethodBeat.o(261178);
      return false;
    }
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (this.JNq == null) {
      this.JNq = new CardLayoutManager.f();
    }
    this.JNq.width = (paramInt - this.JNo * 2);
    this.JNq.height = ((int)(this.JNq.width * 0.75F + 0.5F));
    localCardLayoutManager.setMeasuredDimension(paramInt, this.JNq.height);
    AppMethodBeat.o(261178);
    return true;
  }
  
  final int afw(int paramInt)
  {
    if ((this.JNi == 0) || (this.JNj == 0)) {}
    do
    {
      return 0;
      if (paramInt >= 0) {
        return -paramInt % this.JNi;
      }
    } while (paramInt % this.JNi == 0);
    return -paramInt % this.JNi - this.JNi;
  }
  
  final int b(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(261193);
    paramInt1 = Math.round(this.JNo * d(paramInt1, paramFloat, paramInt2));
    AppMethodBeat.o(261193);
    return paramInt1;
  }
  
  final int c(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(261195);
    paramInt1 = Math.round(this.JNp * d(paramInt1, paramFloat, paramInt2));
    AppMethodBeat.o(261195);
    return paramInt1;
  }
  
  public final void gl(View paramView)
  {
    AppMethodBeat.i(261181);
    Object localObject = this.JNk;
    CardLayoutManager.f localf = this.JNq;
    if ((localObject == null) || (paramView == null) || (paramView.getTag(i.f.sns_ad_finder_topic_card_item_layout_ready) != null))
    {
      AppMethodBeat.o(261181);
      return;
    }
    localObject = paramView.getLayoutParams();
    if ((localObject == null) || (localf == null))
    {
      AppMethodBeat.o(261181);
      return;
    }
    ((ViewGroup.LayoutParams)localObject).width = localf.width;
    ((ViewGroup.LayoutParams)localObject).height = localf.height;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setTag(i.f.sns_ad_finder_topic_card_item_layout_ready, Boolean.TRUE);
    AppMethodBeat.o(261181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.recyclerview.a
 * JD-Core Version:    0.7.0.1
 */