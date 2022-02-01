package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;

public abstract class BasePanelKeybordLayout
  extends KeyboardLinearLayout
{
  private int FvU = -1;
  private a Joy = null;
  
  public BasePanelKeybordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BasePanelKeybordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected abstract List<View> getPanelView();
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    ae.d("MicroMsg.BasePanelKeybordLayout", "onMeasure, width: %d, height: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
    if (m >= 0)
    {
      if (this.FvU >= 0) {
        break label62;
      }
      this.FvU = m;
    }
    label62:
    int n;
    label102:
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      do
      {
        do
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
          n = this.FvU - m;
          this.FvU = m;
        } while (n == 0);
        localObject = getPanelView();
      } while (localObject == null);
      Object localObject = ((List)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localView = (View)((Iterator)localObject).next();
      localLayoutParams = localView.getLayoutParams();
    } while (localLayoutParams == null);
    if (localLayoutParams.height < 0) {}
    for (i = 0;; i = localLayoutParams.height - n)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      int i1 = i.iL(ak.getContext());
      i = i.iN(getContext());
      int k = j;
      if (i.abw() > 0)
      {
        k = j;
        if (m >= i.abw()) {
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
      ae.d("MicroMsg.BasePanelKeybordLayout", "oldHeight: %d, offset: %d newHeight: %d, validPanelHeight: %d", new Object[] { Integer.valueOf(localLayoutParams.height), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i) });
      localLayoutParams.height = j;
      localView.setLayoutParams(localLayoutParams);
      break label102;
      break;
    }
  }
  
  public void setOnMeasureListener(a parama)
  {
    this.Joy = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.BasePanelKeybordLayout
 * JD-Core Version:    0.7.0.1
 */