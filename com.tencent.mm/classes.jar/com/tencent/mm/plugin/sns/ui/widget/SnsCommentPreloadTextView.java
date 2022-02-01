package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView
  extends PLTextView
{
  private static a zkT = null;
  private static int zkU = 0;
  private boolean zkV = false;
  
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
    if (zkT == null) {
      zkT = d.dSI().getTextViewConfig();
    }
    a locala = zkT;
    AppMethodBeat.o(100524);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100527);
    if (zkU == 0) {
      zkU = d.dSI().getViewWidth();
    }
    int i = zkU;
    AppMethodBeat.o(100527);
    return i;
  }
  
  public final a ahW()
  {
    AppMethodBeat.i(100523);
    if (zkT == null) {
      zkT = d.dSI().getTextViewConfig();
    }
    a locala = zkT;
    AppMethodBeat.o(100523);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100528);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100528);
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100526);
    super.x(paramCharSequence);
    AppMethodBeat.o(100526);
  }
  
  public final void y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100525);
    super.y(paramCharSequence);
    AppMethodBeat.o(100525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView
 * JD-Core Version:    0.7.0.1
 */