package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView
  extends PLTextView
{
  private static a smU = null;
  private static int smV = 0;
  private boolean smW = false;
  
  public SnsComment2LinePreloadTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsComment2LinePreloadTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static a getTextViewConfig()
  {
    AppMethodBeat.i(40471);
    if (smU == null) {
      smU = b.cxJ().getTextViewConfig();
    }
    a locala = smU;
    AppMethodBeat.o(40471);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(40474);
    if (smV == 0) {
      smV = b.cxJ().getViewWidth();
    }
    int i = smV;
    AppMethodBeat.o(40474);
    return i;
  }
  
  public final a SM()
  {
    AppMethodBeat.i(40470);
    if (smU == null) {
      smU = b.cxJ().getTextViewConfig();
    }
    a locala = smU;
    AppMethodBeat.o(40470);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40475);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(40475);
  }
  
  public final void t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40473);
    super.t(paramCharSequence);
    AppMethodBeat.o(40473);
  }
  
  public final void u(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(40472);
    super.u(paramCharSequence);
    AppMethodBeat.o(40472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView
 * JD-Core Version:    0.7.0.1
 */