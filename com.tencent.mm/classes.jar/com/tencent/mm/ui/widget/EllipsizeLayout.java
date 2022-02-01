package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.q.e;

public class EllipsizeLayout
  extends LinearLayout
{
  private final boolean afSf;
  
  public EllipsizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251717);
    this.afSf = paramContext.obtainStyledAttributes(paramAttributeSet, q.e.EllipsizeLayout).getBoolean(q.e.EllipsizeLayout_center_ellipsize_textview, false);
    AppMethodBeat.o(251717);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251722);
    int j;
    int i;
    Object localObject1;
    int n;
    int i1;
    int i2;
    int k;
    View localView;
    Object localObject2;
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = 0;
      i = 0;
      localObject1 = null;
      n = getChildCount();
      i1 = View.MeasureSpec.getSize(paramInt1) - (getPaddingLeft() + getPaddingRight());
      i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
      k = 0;
      if ((k < n) && (i == 0))
      {
        localView = getChildAt(k);
        if ((localView == null) || (localView.getVisibility() == 8)) {
          break label409;
        }
        if (!(localView instanceof TextView)) {
          break label406;
        }
        localObject2 = (TextView)localView;
        if (((TextView)localObject2).getEllipsize() == null) {
          break label406;
        }
        if (localObject1 == null)
        {
          ((TextView)localObject2).setMaxWidth(2147483647);
          if (!this.afSf) {
            break label412;
          }
          ((LinearLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).leftMargin = 0;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label156:
      measureChildWithMargins(localView, i2, 0, paramInt2, 0);
      localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
      int m;
      if (localObject2 != null) {
        if (((LinearLayout.LayoutParams)localObject2).weight > 0.0F)
        {
          m = 1;
          label195:
          i |= m;
          m = localView.getMeasuredWidth();
          int i3 = ((LinearLayout.LayoutParams)localObject2).leftMargin;
          j = ((LinearLayout.LayoutParams)localObject2).rightMargin + (m + i3) + j;
        }
      }
      label386:
      label392:
      label406:
      label409:
      for (;;)
      {
        k += 1;
        break;
        i = 1;
        break label156;
        m = 0;
        break label195;
        i = 1;
        continue;
        if (localObject1 != null)
        {
          if (j != 0) {
            break label386;
          }
          n = 1;
          m = localObject1.getMeasuredWidth() - (j - i1);
          k = m;
          if ((i | n) == 0)
          {
            k = m;
            if (j > i1)
            {
              i = m;
              if (m < 0) {
                i = 0;
              }
              localObject1.setMaxWidth(i);
              k = i;
            }
          }
          if ((this.afSf) && (localObject1.getMeasuredWidth() > 0)) {
            if (j <= i1) {
              break label392;
            }
          }
        }
        for (i = j - localObject1.getMeasuredWidth();; i = (i1 - localObject1.getMeasuredWidth()) / 2)
        {
          ((LinearLayout.LayoutParams)localObject1.getLayoutParams()).leftMargin = i;
          localObject1.setMaxWidth(k - i);
          super.onMeasure(paramInt1, paramInt2);
          AppMethodBeat.o(251722);
          return;
          n = 0;
          break;
        }
        break label156;
      }
      label412:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.EllipsizeLayout
 * JD-Core Version:    0.7.0.1
 */