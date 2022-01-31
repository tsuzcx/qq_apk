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
  private boolean snl = false;
  private int snm = 0;
  
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
    AppMethodBeat.i(40516);
    if (this.snm > 0)
    {
      i = this.snm;
      AppMethodBeat.o(40516);
      return i;
    }
    int i = e.cxN().getViewWidth();
    AppMethodBeat.o(40516);
    return i;
  }
  
  public final com.tencent.mm.kiss.widget.textview.a.a SM()
  {
    AppMethodBeat.i(40512);
    this.snl = true;
    com.tencent.mm.kiss.widget.textview.a.a locala = e.cxN().getTextViewConfig();
    AppMethodBeat.o(40512);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40517);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40517);
  }
  
  public void setMaxLines(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(40513);
    if (getText() == null) {
      super.setMaxLines(paramInt);
    }
    if (paramInt < 7)
    {
      if (!this.snl) {
        break label147;
      }
      setConfig(e.cxN().cxO());
      this.snl = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        com.tencent.mm.kiss.widget.textview.f localf2 = c.eLm.a(getConfig(), getText());
        com.tencent.mm.kiss.widget.textview.f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = d.a(getText(), paramInt, getConfig()).SK();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      AppMethodBeat.o(40513);
      return;
      if (!this.snl)
      {
        setConfig(e.cxN().getTextViewConfig());
        this.snl = true;
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
    this.snm = paramInt;
  }
  
  public final void t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40515);
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
    for (boolean bool = com.tencent.mm.plugin.sns.e.a.ZS(((com.tencent.mm.pluginsdk.ui.c.a)getTag()).getUserName());; bool = false)
    {
      setText(f.a(localContext, paramCharSequence, f, bool), true);
      missCount += 1;
      AppMethodBeat.o(40515);
      return;
    }
  }
  
  public final void u(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40514);
    super.u(paramCharSequence);
    hitCount += 1;
    AppMethodBeat.o(40514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */