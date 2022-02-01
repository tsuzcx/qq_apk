package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView
  extends PLTextView
{
  private static a Ffe = null;
  private static int Fff = 0;
  private boolean Ffg = false;
  
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
    if (Ffe == null) {
      Ffe = c.flh().getTextViewConfig();
    }
    a locala = Ffe;
    AppMethodBeat.o(100498);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100501);
    if (Fff == 0) {
      Fff = c.flh().getViewWidth();
    }
    int i = Fff;
    AppMethodBeat.o(100501);
    return i;
  }
  
  public final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100500);
    super.A(paramCharSequence);
    AppMethodBeat.o(100500);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100499);
    super.B(paramCharSequence);
    AppMethodBeat.o(100499);
  }
  
  public final a aBn()
  {
    AppMethodBeat.i(100497);
    if (Ffe == null) {
      Ffe = c.flh().getTextViewConfig();
    }
    a locala = Ffe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView
 * JD-Core Version:    0.7.0.1
 */