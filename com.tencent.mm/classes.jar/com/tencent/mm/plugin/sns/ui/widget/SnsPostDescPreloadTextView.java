package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean xYq = true;
  private int xYr = 0;
  
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
    if (this.xYr > 0)
    {
      i = this.xYr;
      AppMethodBeat.o(100551);
      return i;
    }
    int i = f.dEn().getViewWidth();
    AppMethodBeat.o(100551);
    return i;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a agF()
  {
    AppMethodBeat.i(100547);
    this.xYq = true;
    com.tencent.mm.kiss.widget.textview.a.a locala = f.dEn().getTextViewConfig();
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
      if (!this.xYq) {
        break label147;
      }
      setConfig(f.dEn().dEo());
      this.xYq = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.ggt.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).agD();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(100548);
      return;
      if (!this.xYq)
      {
        setConfig(f.dEn().getTextViewConfig());
        this.xYq = true;
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
    this.xYr = paramInt;
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100550);
    Context localContext;
    float f;
    if (paramCharSequence != null)
    {
      localContext = getContext();
      paramCharSequence = paramCharSequence.toString();
      f = getConfig().textSize;
      if (!(getTag() instanceof com.tencent.mm.pluginsdk.ui.c.a)) {
        break label83;
      }
    }
    label83:
    for (boolean bool = com.tencent.mm.plugin.sns.g.a.anZ(((com.tencent.mm.pluginsdk.ui.c.a)getTag()).getUserName());; bool = false)
    {
      setText(g.a(localContext, paramCharSequence, f, bool), true);
      missCount += 1;
      AppMethodBeat.o(100550);
      return;
    }
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