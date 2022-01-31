package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView
  extends PLTextView
{
  private static a prk = null;
  private static int prl = 0;
  
  public SnsCommentPreloadTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SnsCommentPreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsCommentPreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static a getTextViewConfig()
  {
    if (prk == null) {
      prk = b.bKA().getTextViewConfig();
    }
    return prk;
  }
  
  public static int getViewWidth()
  {
    if (prl == 0) {
      prl = b.bKA().getViewWidth();
    }
    return prl;
  }
  
  protected final a EH()
  {
    if (prk == null) {
      prk = b.bKA().getTextViewConfig();
    }
    return prk;
  }
  
  protected final void o(CharSequence paramCharSequence)
  {
    super.o(paramCharSequence);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected final void p(CharSequence paramCharSequence)
  {
    super.p(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView
 * JD-Core Version:    0.7.0.1
 */