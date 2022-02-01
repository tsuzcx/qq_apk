package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMAutoHeightViewPager
  extends ViewPager
{
  private static final String TAG = "MicoMsg.MMAutoHeightViewPager";
  
  public MMAutoHeightViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public MMAutoHeightViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMAutoHeightViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141848);
    paramInt2 = 0;
    int j;
    for (int i = 0; paramInt2 < getChildCount(); i = j)
    {
      View localView = getChildAt(paramInt2);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = localView.getMeasuredHeight();
      j = i;
      if (k > i) {
        j = k;
      }
      paramInt2 += 1;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    AppMethodBeat.o(141848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoHeightViewPager
 * JD-Core Version:    0.7.0.1
 */