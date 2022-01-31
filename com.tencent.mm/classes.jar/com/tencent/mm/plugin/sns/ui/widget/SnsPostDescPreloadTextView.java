package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView
  extends PLTextView
{
  private static int hitCount = 0;
  private static int missCount = 0;
  private boolean prn = false;
  private int pro = 0;
  
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
    if (this.pro > 0) {
      return this.pro;
    }
    return d.bKB().getViewWidth();
  }
  
  protected final a EH()
  {
    this.prn = true;
    return d.bKB().getTextViewConfig();
  }
  
  protected final void o(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      setText(e.a(getContext(), paramCharSequence.toString(), getConfig().dOB), true);
    }
    missCount += 1;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected final void p(CharSequence paramCharSequence)
  {
    super.p(paramCharSequence);
    hitCount += 1;
  }
  
  public void setMaxLines(int paramInt)
  {
    int i = 1;
    if (getText() == null) {
      super.setMaxLines(paramInt);
    }
    if (paramInt < 7)
    {
      if (!this.prn) {
        break label137;
      }
      setConfig(d.bKB().bKC());
      this.prn = false;
      paramInt = i;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        f localf2 = c.dNE.a(getConfig(), getText());
        f localf1 = localf2;
        if (localf2 == null)
        {
          paramInt = getPostDescWidth();
          localf1 = localf2;
          if (paramInt > 0) {
            localf1 = com.tencent.mm.kiss.widget.textview.d.a(getText(), paramInt, getConfig()).EF();
          }
        }
        if (localf1 != null) {
          setTextLayout(localf1);
        }
      }
      return;
      if (!this.prn)
      {
        setConfig(d.bKB().getTextViewConfig());
        this.prn = true;
        paramInt = i;
      }
      else
      {
        label137:
        paramInt = 0;
      }
    }
  }
  
  public void setSpecialWidth(int paramInt)
  {
    this.pro = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView
 * JD-Core Version:    0.7.0.1
 */