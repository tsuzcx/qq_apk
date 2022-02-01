package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean zln = true;
  private int zlo = 0;
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsPostDescPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getPostDescWidth()
  {
    AppMethodBeat.i(100551);
    if (this.zlo > 0)
    {
      i = this.zlo;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.dSL().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final a ahW()
  {
    AppMethodBeat.i(100547);
    this.zln = true;
    a locala = f.dSL().getTextViewConfig();
    AppMethodBeat.o(100547);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100552);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100552);
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
      if (!this.zln) {
        break label147;
      }
      setConfig(f.dSL().dSM());
      this.zln = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.gkZ.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).ahU();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.zln)
      {
        setConfig(f.dSL().getTextViewConfig());
        this.zln = true;
        paramInt = i;
      }
      else
      {
        label147:
        paramInt = 0;
      }
    }
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.zlo = paramInt;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */