package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;

public class MMTagPanelScrollView
  extends ScrollView
{
  private Runnable adUh;
  private a adUi;
  private int maxLine;
  private int nxP;
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142218);
    this.adUh = new MMTagPanelScrollView.1(this);
    this.adUi = new a((byte)0);
    this.nxP = 0;
    this.maxLine = 2;
    AppMethodBeat.o(142218);
  }
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142217);
    this.adUh = new MMTagPanelScrollView.1(this);
    this.adUi = new a((byte)0);
    this.nxP = 0;
    this.maxLine = 2;
    AppMethodBeat.o(142217);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142220);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    scrollBy(0, paramInt4);
    AppMethodBeat.o(142220);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142219);
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() <= 0)
    {
      AppMethodBeat.o(142219);
      return;
    }
    MMTagPanel localMMTagPanel;
    if ((getChildAt(0) instanceof MMTagPanel))
    {
      localMMTagPanel = (MMTagPanel)getChildAt(0);
      if (localMMTagPanel.adTR != null) {
        break label182;
      }
    }
    label182:
    for (boolean bool = false;; bool = localMMTagPanel.adTR.isFocused())
    {
      if (localMMTagPanel.getLineCount() == this.maxLine) {
        this.nxP = (localMMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(a.e.SmallerPadding));
      }
      if (localMMTagPanel.getLineCount() >= this.maxLine)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        paramInt2 = Math.max(localMMTagPanel.aAJ(this.maxLine), this.nxP);
        Log.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[] { Integer.valueOf(paramInt2) });
        setMeasuredDimension(paramInt1, paramInt2);
        if (bool)
        {
          this.adUi.adUk = localMMTagPanel;
          removeCallbacks(this.adUi);
          post(this.adUi);
        }
      }
      AppMethodBeat.o(142219);
      return;
    }
  }
  
  public void setMaxLine(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.maxLine = i;
  }
  
  static final class a
    implements Runnable
  {
    public MMTagPanel adUk;
    
    public final void run()
    {
      AppMethodBeat.i(142216);
      if (this.adUk != null) {
        this.adUk.iCG();
      }
      this.adUk = null;
      AppMethodBeat.o(142216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView
 * JD-Core Version:    0.7.0.1
 */