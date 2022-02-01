package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView
  extends PLTextView
{
  private static a RXc = null;
  private static int RXd = 0;
  private boolean RXe = false;
  
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
    AppMethodBeat.i(100498);
    if (RXc == null) {
      RXc = e.hsR().getTextViewConfig();
    }
    a locala = RXc;
    AppMethodBeat.o(100498);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100501);
    if (RXd == 0) {
      RXd = e.hsR().getViewWidth();
    }
    int i = RXd;
    AppMethodBeat.o(100501);
    return i;
  }
  
  public final void K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100500);
    super.K(paramCharSequence);
    AppMethodBeat.o(100500);
  }
  
  public final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100499);
    super.L(paramCharSequence);
    AppMethodBeat.o(100499);
  }
  
  public final a bbM()
  {
    AppMethodBeat.i(100497);
    if (RXc == null) {
      RXc = e.hsR().getTextViewConfig();
    }
    a locala = RXc;
    AppMethodBeat.o(100497);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100502);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView
 * JD-Core Version:    0.7.0.1
 */