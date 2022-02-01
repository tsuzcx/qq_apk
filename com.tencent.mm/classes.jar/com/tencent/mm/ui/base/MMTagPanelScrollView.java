package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;

public class MMTagPanelScrollView
  extends ScrollView
{
  private Runnable JIN;
  private a JIO;
  private int JIP;
  private int targetHeight;
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142218);
    this.JIN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142215);
        MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
        AppMethodBeat.o(142215);
      }
    };
    this.JIO = new a((byte)0);
    this.targetHeight = 0;
    this.JIP = 2;
    AppMethodBeat.o(142218);
  }
  
  public MMTagPanelScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142217);
    this.JIN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142215);
        MMTagPanelScrollView.this.scrollTo(0, MMTagPanelScrollView.this.getBottom());
        AppMethodBeat.o(142215);
      }
    };
    this.JIO = new a((byte)0);
    this.targetHeight = 0;
    this.JIP = 2;
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
    if ((getChildAt(0) instanceof MMTagPanel))
    {
      MMTagPanel localMMTagPanel = (MMTagPanel)getChildAt(0);
      if (localMMTagPanel.JIy == null) {}
      int i;
      int j;
      for (boolean bool = false;; bool = localMMTagPanel.JIy.isFocused())
      {
        if (localMMTagPanel.getLineCount() == this.JIP) {
          this.targetHeight = (localMMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(2131165573));
        }
        if (localMMTagPanel.getLineCount() < this.JIP) {
          break label277;
        }
        i = View.MeasureSpec.getSize(paramInt1);
        paramInt1 = this.JIP;
        j = Math.max(0, Math.min(localMMTagPanel.JDt.size(), paramInt1));
        paramInt2 = localMMTagPanel.getPaddingTop();
        paramInt1 = 0;
        while (paramInt1 < j - 1)
        {
          paramInt2 += ((Integer)localMMTagPanel.JDt.get(paramInt1)).intValue() + localMMTagPanel.JDs;
          paramInt1 += 1;
        }
      }
      paramInt1 = Math.max(((Integer)localMMTagPanel.JDt.get(j - 1)).intValue() + paramInt2 + localMMTagPanel.getPaddingBottom(), this.targetHeight);
      ae.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[] { Integer.valueOf(paramInt1) });
      setMeasuredDimension(i, paramInt1);
      if (bool)
      {
        this.JIO.JIR = localMMTagPanel;
        removeCallbacks(this.JIO);
        post(this.JIO);
      }
    }
    label277:
    AppMethodBeat.o(142219);
  }
  
  public void setMaxLine(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.JIP = i;
  }
  
  static final class a
    implements Runnable
  {
    public MMTagPanel JIR;
    
    public final void run()
    {
      AppMethodBeat.i(142216);
      if (this.JIR != null) {
        this.JIR.fDc();
      }
      this.JIR = null;
      AppMethodBeat.o(142216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView
 * JD-Core Version:    0.7.0.1
 */