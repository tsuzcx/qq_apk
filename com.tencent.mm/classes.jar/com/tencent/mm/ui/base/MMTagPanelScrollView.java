package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

public class MMTagPanelScrollView
  extends ScrollView
{
  private int eIC = 0;
  private Runnable uYA = new MMTagPanelScrollView.1(this);
  private MMTagPanelScrollView.a uYB = new MMTagPanelScrollView.a((byte)0);
  private int uYC = 2;
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollBy(0, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() <= 0) {}
    MMTagPanel localMMTagPanel;
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!(getChildAt(0) instanceof MMTagPanel));
      localMMTagPanel = (MMTagPanel)getChildAt(0);
      if (localMMTagPanel.uYk == null) {}
      int i;
      int j;
      for (bool = false;; bool = localMMTagPanel.uYk.isFocused())
      {
        if (localMMTagPanel.getLineCount() == this.uYC) {
          this.eIC = (localMMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(a.e.SmallerPadding));
        }
        if (localMMTagPanel.getLineCount() < this.uYC) {
          break;
        }
        i = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = this.uYC;
        j = Math.max(0, Math.min(localMMTagPanel.uSX.size(), paramInt1));
        paramInt2 = localMMTagPanel.getPaddingTop();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          paramInt2 += ((Integer)localMMTagPanel.uSX.get(paramInt1)).intValue() + localMMTagPanel.uSW;
          paramInt1 += 1;
        }
      }
      paramInt1 = Math.max(((Integer)localMMTagPanel.uSX.get(j - 1)).intValue() + paramInt2 + localMMTagPanel.getPaddingBottom(), this.eIC);
      y.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[] { Integer.valueOf(paramInt1) });
      setMeasuredDimension(i, paramInt1);
    } while (!bool);
    this.uYB.uYE = localMMTagPanel;
    removeCallbacks(this.uYB);
    post(this.uYB);
  }
  
  public void setMaxLine(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.uYC = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView
 * JD-Core Version:    0.7.0.1
 */