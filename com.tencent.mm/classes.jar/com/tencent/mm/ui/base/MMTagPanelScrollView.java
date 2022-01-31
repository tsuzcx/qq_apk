package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

public class MMTagPanelScrollView
  extends ScrollView
{
  private int eRv;
  private Runnable zmQ;
  private a zmR;
  private int zmS;
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106859);
    this.zmQ = new MMTagPanelScrollView.1(this);
    this.zmR = new a((byte)0);
    this.eRv = 0;
    this.zmS = 2;
    AppMethodBeat.o(106859);
  }
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106858);
    this.zmQ = new MMTagPanelScrollView.1(this);
    this.zmR = new a((byte)0);
    this.eRv = 0;
    this.zmS = 2;
    AppMethodBeat.o(106858);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106861);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollBy(0, paramInt4);
    AppMethodBeat.o(106861);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106860);
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(106860);
      return;
    }
    if ((getChildAt(0) instanceof MMTagPanel))
    {
      MMTagPanel localMMTagPanel = (MMTagPanel)getChildAt(0);
      if (localMMTagPanel.zmB == null) {}
      int i;
      int j;
      for (boolean bool = false;; bool = localMMTagPanel.zmB.isFocused())
      {
        if (localMMTagPanel.getLineCount() == this.zmS) {
          this.eRv = (localMMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(2131427859));
        }
        if (localMMTagPanel.getLineCount() < this.zmS) {
          break label277;
        }
        i = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = this.zmS;
        j = Math.max(0, Math.min(localMMTagPanel.zhx.size(), paramInt1));
        paramInt2 = localMMTagPanel.getPaddingTop();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          paramInt2 += ((Integer)localMMTagPanel.zhx.get(paramInt1)).intValue() + localMMTagPanel.zhw;
          paramInt1 += 1;
        }
      }
      paramInt1 = Math.max(((Integer)localMMTagPanel.zhx.get(j - 1)).intValue() + paramInt2 + localMMTagPanel.getPaddingBottom(), this.eRv);
      ab.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[] { Integer.valueOf(paramInt1) });
      setMeasuredDimension(i, paramInt1);
      if (bool)
      {
        this.zmR.zmU = localMMTagPanel;
        removeCallbacks(this.zmR);
        post(this.zmR);
      }
    }
    label277:
    AppMethodBeat.o(106860);
  }
  
  public void setMaxLine(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.zmS = i;
  }
  
  static final class a
    implements Runnable
  {
    public MMTagPanel zmU;
    
    public final void run()
    {
      AppMethodBeat.i(106857);
      if (this.zmU != null) {
        this.zmU.dEn();
      }
      this.zmU = null;
      AppMethodBeat.o(106857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView
 * JD-Core Version:    0.7.0.1
 */