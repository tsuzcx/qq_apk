package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.sns.ui.bj;
import java.util.Map;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean RXD;
  private int RXE;
  private boolean RXF;
  private b RXG;
  private int RXH;
  private Map<String, Integer> RXI;
  private a RXJ;
  private boolean isAd;
  private boolean uAR;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(309212);
    this.RXD = true;
    this.RXE = 0;
    this.uAR = false;
    this.RXF = false;
    this.isAd = false;
    this.RXG = null;
    this.RXH = ViewConfiguration.getLongPressTimeout();
    this.RXJ = new a();
    AppMethodBeat.o(309212);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(309218);
    this.RXD = true;
    this.RXE = 0;
    this.uAR = false;
    this.RXF = false;
    this.isAd = false;
    this.RXG = null;
    this.RXH = ViewConfiguration.getLongPressTimeout();
    this.RXJ = new a();
    AppMethodBeat.o(309218);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.RXE > 0)
    {
      i = this.RXE;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = i.hsX().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final void K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100550);
    if (paramCharSequence != null) {
      a(paramCharSequence, true);
    }
    missCount += 1;
    AppMethodBeat.o(100550);
  }
  
  public final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100549);
    super.L(paramCharSequence);
    hitCount += 1;
    AppMethodBeat.o(100549);
  }
  
  public final a bbM()
  {
    AppMethodBeat.i(100547);
    this.RXD = true;
    a locala = i.hsX().getTextViewConfig();
    AppMethodBeat.o(100547);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100552);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100552);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(309293);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(309293);
      return bool;
      this.RXF = true;
      postDelayed(this.RXJ, this.RXH);
      continue;
      bj localbj;
      if ((!this.uAR) && (this.RXF) && (!this.isAd) && ((getTag() instanceof bj)))
      {
        localbj = (bj)getTag();
        if ((localbj != null) && (this.RXI != null) && ((!this.RXI.containsKey(localbj.hHB)) || (!((Integer)this.RXI.get(localbj.hHB)).equals(Integer.valueOf(0))))) {
          break label189;
        }
      }
      for (;;)
      {
        this.uAR = false;
        this.RXF = false;
        removeCallbacks(this.RXJ);
        break;
        label189:
        if ((this.RXI.containsKey(localbj.hHB)) && (((Integer)this.RXI.get(localbj.hHB)).equals(Integer.valueOf(1))))
        {
          this.RXI.put(localbj.hHB, Integer.valueOf(2));
          if (this.RXG != null) {
            this.RXG.hpC();
          }
        }
        else
        {
          this.RXI.put(localbj.hHB, Integer.valueOf(1));
          if (this.RXG != null) {
            this.RXG.hpC();
          }
        }
      }
      this.uAR = false;
      this.RXF = false;
      removeCallbacks(this.RXJ);
    }
  }
  
  public void setCollapseibleMap(Map<String, Integer> paramMap)
  {
    this.RXI = paramMap;
  }
  
  public void setIsAd(boolean paramBoolean)
  {
    this.isAd = paramBoolean;
  }
  
  public void setMaxLines(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(100548);
    if (getText() == null) {
      super.setMaxLines(paramInt);
    }
    if (paramInt < 7)
    {
      if (!this.RXD) {
        break label147;
      }
      setConfig(i.hsX().hsY());
      this.RXD = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        f localf2 = c.mGx.a(getConfig(), getText());
        f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).bbK();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.RXD)
      {
        setConfig(i.hsX().getTextViewConfig());
        this.RXD = true;
        paramInt = i;
      }
      else
      {
        label147:
        paramInt = 0;
      }
    }
  }
  
  public void setShrinkOrSpreadListener(b paramb)
  {
    this.RXG = paramb;
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.RXE = paramInt;
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(309251);
      SnsPostDescPreloadTextView.a(SnsPostDescPreloadTextView.this);
      AppMethodBeat.o(309251);
    }
  }
  
  public static abstract interface b
  {
    public abstract void hpC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */