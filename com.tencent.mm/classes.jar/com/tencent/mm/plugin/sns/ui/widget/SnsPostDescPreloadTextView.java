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
import com.tencent.mm.plugin.sns.ui.bg;
import java.util.Map;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private b FfA;
  private int FfB;
  private Map<String, Integer> FfC;
  private a FfD;
  private boolean Ffy;
  private int Ffz;
  private boolean isAd;
  private boolean ooU;
  private boolean pJi;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204003);
    this.Ffy = true;
    this.Ffz = 0;
    this.ooU = false;
    this.pJi = false;
    this.isAd = false;
    this.FfA = null;
    this.FfB = ViewConfiguration.getLongPressTimeout();
    this.FfD = new a();
    AppMethodBeat.o(204003);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204004);
    this.Ffy = true;
    this.Ffz = 0;
    this.ooU = false;
    this.pJi = false;
    this.isAd = false;
    this.FfA = null;
    this.FfB = ViewConfiguration.getLongPressTimeout();
    this.FfD = new a();
    AppMethodBeat.o(204004);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.Ffz > 0)
    {
      i = this.Ffz;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.fll().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100550);
    if (paramCharSequence != null) {
      setText(paramCharSequence, true);
    }
    missCount += 1;
    AppMethodBeat.o(100550);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100549);
    super.B(paramCharSequence);
    hitCount += 1;
    AppMethodBeat.o(100549);
  }
  
  public final a aBn()
  {
    AppMethodBeat.i(100547);
    this.Ffy = true;
    a locala = f.fll().getTextViewConfig();
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
    AppMethodBeat.i(204005);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(204005);
      return bool;
      this.pJi = true;
      postDelayed(this.FfD, this.FfB);
      continue;
      bg localbg;
      if ((!this.ooU) && (this.pJi) && (!this.isAd) && ((getTag() instanceof bg)))
      {
        localbg = (bg)getTag();
        if ((localbg != null) && (this.FfC != null) && ((!this.FfC.containsKey(localbg.dJX)) || (!((Integer)this.FfC.get(localbg.dJX)).equals(Integer.valueOf(0))))) {
          break label189;
        }
      }
      for (;;)
      {
        this.ooU = false;
        this.pJi = false;
        removeCallbacks(this.FfD);
        break;
        label189:
        if ((this.FfC.containsKey(localbg.dJX)) && (((Integer)this.FfC.get(localbg.dJX)).equals(Integer.valueOf(1))))
        {
          this.FfC.put(localbg.dJX, Integer.valueOf(2));
          if (this.FfA != null) {
            this.FfA.fiW();
          }
        }
        else
        {
          this.FfC.put(localbg.dJX, Integer.valueOf(1));
          if (this.FfA != null) {
            this.FfA.fiW();
          }
        }
      }
      this.ooU = false;
      this.pJi = false;
      removeCallbacks(this.FfD);
    }
  }
  
  public void setCollapseibleMap(Map<String, Integer> paramMap)
  {
    this.FfC = paramMap;
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
      if (!this.Ffy) {
        break label147;
      }
      setConfig(f.fll().flm());
      this.Ffy = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.hue.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).aBl();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.Ffy)
      {
        setConfig(f.fll().getTextViewConfig());
        this.Ffy = true;
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
    this.FfA = paramb;
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.Ffz = paramInt;
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(204002);
      SnsPostDescPreloadTextView.a(SnsPostDescPreloadTextView.this);
      AppMethodBeat.o(204002);
    }
  }
  
  public static abstract interface b
  {
    public abstract void fiW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */