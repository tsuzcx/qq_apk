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
  private boolean ADs;
  private int ADt;
  private b ADu;
  private int ADv;
  private Map<String, Integer> ADw;
  private a ADx;
  private boolean isAd;
  private boolean mVq;
  private boolean mYz;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198611);
    this.ADs = true;
    this.ADt = 0;
    this.mYz = false;
    this.mVq = false;
    this.isAd = false;
    this.ADu = null;
    this.ADv = ViewConfiguration.getLongPressTimeout();
    this.ADx = new a();
    AppMethodBeat.o(198611);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198612);
    this.ADs = true;
    this.ADt = 0;
    this.mYz = false;
    this.mVq = false;
    this.isAd = false;
    this.ADu = null;
    this.ADv = ViewConfiguration.getLongPressTimeout();
    this.ADx = new a();
    AppMethodBeat.o(198612);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.ADt > 0)
    {
      i = this.ADt;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.efe().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final a akH()
  {
    AppMethodBeat.i(100547);
    this.ADs = true;
    a locala = f.efe().getTextViewConfig();
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
    AppMethodBeat.i(198613);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(198613);
      return bool;
      this.mVq = true;
      postDelayed(this.ADx, this.ADv);
      continue;
      bd localbd;
      if ((!this.mYz) && (this.mVq) && (!this.isAd) && ((getTag() instanceof bd)))
      {
        localbd = (bd)getTag();
        if ((localbd != null) && (this.ADw != null) && ((!this.ADw.containsKey(localbd.drH)) || (!((Integer)this.ADw.get(localbd.drH)).equals(Integer.valueOf(0))))) {
          break label189;
        }
      }
      for (;;)
      {
        this.mYz = false;
        this.mVq = false;
        removeCallbacks(this.ADx);
        break;
        label189:
        if ((this.ADw.containsKey(localbd.drH)) && (((Integer)this.ADw.get(localbd.drH)).equals(Integer.valueOf(1))))
        {
          this.ADw.put(localbd.drH, Integer.valueOf(2));
          if (this.ADu != null) {
            this.ADu.ecO();
          }
        }
        else
        {
          this.ADw.put(localbd.drH, Integer.valueOf(1));
          if (this.ADu != null) {
            this.ADu.ecO();
          }
        }
      }
      this.mYz = false;
      this.mVq = false;
      removeCallbacks(this.ADx);
    }
  }
  
  public void setCollapseibleMap(Map<String, Integer> paramMap)
  {
    this.ADw = paramMap;
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
      if (!this.ADs) {
        break label147;
      }
      setConfig(f.efe().eff());
      this.ADs = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.gEJ.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).akF();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.ADs)
      {
        setConfig(f.efe().getTextViewConfig());
        this.ADs = true;
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
    this.ADu = paramb;
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.ADt = paramInt;
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
      AppMethodBeat.i(198610);
      SnsPostDescPreloadTextView.a(SnsPostDescPreloadTextView.this);
      AppMethodBeat.o(198610);
    }
  }
  
  public static abstract interface b
  {
    public abstract void ecO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */