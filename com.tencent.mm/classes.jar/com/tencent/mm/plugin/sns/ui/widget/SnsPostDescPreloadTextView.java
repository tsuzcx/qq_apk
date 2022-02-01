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
import com.tencent.mm.plugin.sns.ui.bd;
import java.util.Map;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean AUT;
  private int AUU;
  private b AUV;
  private int AUW;
  private Map<String, Integer> AUX;
  private a AUY;
  private boolean isAd;
  private boolean naw;
  private boolean ndG;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220158);
    this.AUT = true;
    this.AUU = 0;
    this.ndG = false;
    this.naw = false;
    this.isAd = false;
    this.AUV = null;
    this.AUW = ViewConfiguration.getLongPressTimeout();
    this.AUY = new a();
    AppMethodBeat.o(220158);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220159);
    this.AUT = true;
    this.AUU = 0;
    this.ndG = false;
    this.naw = false;
    this.isAd = false;
    this.AUV = null;
    this.AUW = ViewConfiguration.getLongPressTimeout();
    this.AUY = new a();
    AppMethodBeat.o(220159);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.AUU > 0)
    {
      i = this.AUU;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.eiL().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final a akW()
  {
    AppMethodBeat.i(100547);
    this.AUT = true;
    a locala = f.eiL().getTextViewConfig();
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
    AppMethodBeat.i(220160);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(220160);
      return bool;
      this.naw = true;
      postDelayed(this.AUY, this.AUW);
      continue;
      bd localbd;
      if ((!this.ndG) && (this.naw) && (!this.isAd) && ((getTag() instanceof bd)))
      {
        localbd = (bd)getTag();
        if ((localbd != null) && (this.AUX != null) && ((!this.AUX.containsKey(localbd.dsN)) || (!((Integer)this.AUX.get(localbd.dsN)).equals(Integer.valueOf(0))))) {
          break label189;
        }
      }
      for (;;)
      {
        this.ndG = false;
        this.naw = false;
        removeCallbacks(this.AUY);
        break;
        label189:
        if ((this.AUX.containsKey(localbd.dsN)) && (((Integer)this.AUX.get(localbd.dsN)).equals(Integer.valueOf(1))))
        {
          this.AUX.put(localbd.dsN, Integer.valueOf(2));
          if (this.AUV != null) {
            this.AUV.egv();
          }
        }
        else
        {
          this.AUX.put(localbd.dsN, Integer.valueOf(1));
          if (this.AUV != null) {
            this.AUV.egv();
          }
        }
      }
      this.ndG = false;
      this.naw = false;
      removeCallbacks(this.AUY);
    }
  }
  
  public void setCollapseibleMap(Map<String, Integer> paramMap)
  {
    this.AUX = paramMap;
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
      if (!this.AUT) {
        break label147;
      }
      setConfig(f.eiL().eiM());
      this.AUT = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.gHq.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).akU();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.AUT)
      {
        setConfig(f.eiL().getTextViewConfig());
        this.AUT = true;
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
    this.AUV = paramb;
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.AUU = paramInt;
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100550);
    if (paramCharSequence != null) {
      setText(paramCharSequence, true);
    }
    missCount += 1;
    AppMethodBeat.o(100550);
  }
  
  public final void y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100549);
    super.y(paramCharSequence);
    hitCount += 1;
    AppMethodBeat.o(100549);
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(220157);
      SnsPostDescPreloadTextView.a(SnsPostDescPreloadTextView.this);
      AppMethodBeat.o(220157);
    }
  }
  
  public static abstract interface b
  {
    public abstract void egv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */