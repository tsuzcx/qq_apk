package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView
  extends PLTextView
{
  private static a smU = null;
  private static int smV = 0;
  private boolean smW = false;
  
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
    AppMethodBeat.i(40495);
    if (smU == null) {
      smU = c.cxK().getTextViewConfig();
    }
    a locala = smU;
    AppMethodBeat.o(40495);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(40498);
    if (smV == 0) {
      smV = c.cxK().getViewWidth();
    }
    int i = smV;
    AppMethodBeat.o(40498);
    return i;
  }
  
  public final a SM()
  {
    AppMethodBeat.i(40494);
    if (smU == null) {
      smU = c.cxK().getTextViewConfig();
    }
    a locala = smU;
    AppMethodBeat.o(40494);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40499);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40499);
  }
  
  public final void t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40497);
    super.t(paramCharSequence);
    AppMethodBeat.o(40497);
  }
  
  public final void u(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40496);
    super.u(paramCharSequence);
    AppMethodBeat.o(40496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView
 * JD-Core Version:    0.7.0.1
 */