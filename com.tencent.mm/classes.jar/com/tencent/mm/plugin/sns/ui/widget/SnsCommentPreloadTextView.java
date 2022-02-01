package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView
  extends PLTextView
{
  private static a LtJ = null;
  private static int LtK = 0;
  private boolean LtL = false;
  
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
    AppMethodBeat.i(100524);
    if (LtJ == null) {
      LtJ = d.fZD().getTextViewConfig();
    }
    a locala = LtJ;
    AppMethodBeat.o(100524);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100527);
    if (LtK == 0) {
      LtK = d.fZD().getViewWidth();
    }
    int i = LtK;
    AppMethodBeat.o(100527);
    return i;
  }
  
  public final void G(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100526);
    super.G(paramCharSequence);
    AppMethodBeat.o(100526);
  }
  
  public final void H(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100525);
    super.H(paramCharSequence);
    AppMethodBeat.o(100525);
  }
  
  public final a aIQ()
  {
    AppMethodBeat.i(100523);
    if (LtJ == null) {
      LtJ = d.fZD().getTextViewConfig();
    }
    a locala = LtJ;
    AppMethodBeat.o(100523);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100528);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView
 * JD-Core Version:    0.7.0.1
 */