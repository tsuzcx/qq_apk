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
import com.tencent.mm.plugin.sns.ui.bi;
import java.util.Map;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean Luc;
  private int Lud;
  private boolean Lue;
  private b Luf;
  private int Lug;
  private Map<String, Integer> Luh;
  private a Lui;
  private boolean isAd;
  private boolean rqI;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(265665);
    this.Luc = true;
    this.Lud = 0;
    this.rqI = false;
    this.Lue = false;
    this.isAd = false;
    this.Luf = null;
    this.Lug = ViewConfiguration.getLongPressTimeout();
    this.Lui = new a();
    AppMethodBeat.o(265665);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(265666);
    this.Luc = true;
    this.Lud = 0;
    this.rqI = false;
    this.Lue = false;
    this.isAd = false;
    this.Luf = null;
    this.Lug = ViewConfiguration.getLongPressTimeout();
    this.Lui = new a();
    AppMethodBeat.o(265666);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.Lud > 0)
    {
      i = this.Lud;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.fZG().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final void G(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100550);
    if (paramCharSequence != null) {
      a(paramCharSequence, true);
    }
    missCount += 1;
    AppMethodBeat.o(100550);
  }
  
  public final void H(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100549);
    super.H(paramCharSequence);
    hitCount += 1;
    AppMethodBeat.o(100549);
  }
  
  public final a aIQ()
  {
    AppMethodBeat.i(100547);
    this.Luc = true;
    a locala = f.fZG().getTextViewConfig();
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
    AppMethodBeat.i(265668);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(265668);
      return bool;
      this.Lue = true;
      postDelayed(this.Lui, this.Lug);
      continue;
      bi localbi;
      if ((!this.rqI) && (this.Lue) && (!this.isAd) && ((getTag() instanceof bi)))
      {
        localbi = (bi)getTag();
        if ((localbi != null) && (this.Luh != null) && ((!this.Luh.containsKey(localbi.fCM)) || (!((Integer)this.Luh.get(localbi.fCM)).equals(Integer.valueOf(0))))) {
          break label189;
        }
      }
      for (;;)
      {
        this.rqI = false;
        this.Lue = false;
        removeCallbacks(this.Lui);
        break;
        label189:
        if ((this.Luh.containsKey(localbi.fCM)) && (((Integer)this.Luh.get(localbi.fCM)).equals(Integer.valueOf(1))))
        {
          this.Luh.put(localbi.fCM, Integer.valueOf(2));
          if (this.Luf != null) {
            this.Luf.fXj();
          }
        }
        else
        {
          this.Luh.put(localbi.fCM, Integer.valueOf(1));
          if (this.Luf != null) {
            this.Luf.fXj();
          }
        }
      }
      this.rqI = false;
      this.Lue = false;
      removeCallbacks(this.Lui);
    }
  }
  
  public void setCollapseibleMap(Map<String, Integer> paramMap)
  {
    this.Luh = paramMap;
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
      if (!this.Luc) {
        break label147;
      }
      setConfig(f.fZG().fZH());
      this.Luc = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.kfZ.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).aIO();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.Luc)
      {
        setConfig(f.fZG().getTextViewConfig());
        this.Luc = true;
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
    this.Luf = paramb;
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.Lud = paramInt;
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(270398);
      SnsPostDescPreloadTextView.a(SnsPostDescPreloadTextView.this);
      AppMethodBeat.o(270398);
    }
  }
  
  public static abstract interface b
  {
    public abstract void fXj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */