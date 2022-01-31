package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public abstract class BasePanelKeybordLayout
  extends KeyboardLinearLayout
{
  private int kET = -1;
  private BasePanelKeybordLayout.a uHr = null;
  
  public BasePanelKeybordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BasePanelKeybordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract List<View> getPanelView();
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    y.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
    if (m >= 0)
    {
      if (this.kET >= 0) {
        break label62;
      }
      this.kET = m;
    }
    label62:
    int n;
    label102:
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        do
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
          n = this.kET - m;
          this.kET = m;
        } while (n == 0);
        localObject = getPanelView();
      } while (localObject == null);
      Object localObject = ((List)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localView = (View)((Iterator)localObject).next();
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    } while (localLayoutParams == null);
    if (localLayoutParams.height < 0) {}
    for (i = 0;; i = localLayoutParams.height - n)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      int i1 = j.u(ae.getContext(), true);
      i = j.fy(getContext());
      int k = j;
      if (j.zM() > 0)
      {
        k = j;
        if (m >= j.zM()) {
          k = i;
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k < i1)
        {
          j = k;
          if (localView.getVisibility() != 0) {
            j = 0;
          }
        }
      }
      k = j;
      if (j > i) {
        k = i;
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k < i) {
          j = i;
        }
      }
      y.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", new Object[] { Integer.valueOf(localLayoutParams.height), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i) });
      localLayoutParams.height = j;
      localView.setLayoutParams(localLayoutParams);
      break label102;
      break;
    }
  }
  
  public void setOnMeasureListener(BasePanelKeybordLayout.a parama)
  {
    this.uHr = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.BasePanelKeybordLayout
 * JD-Core Version:    0.7.0.1
 */