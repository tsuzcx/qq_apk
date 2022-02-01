package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView
  extends PLTextView
{
  private static a Ffe = null;
  private static int Fff = 0;
  private boolean Ffg = false;
  
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
    if (Ffe == null) {
      Ffe = d.fli().getTextViewConfig();
    }
    a locala = Ffe;
    AppMethodBeat.o(100524);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100527);
    if (Fff == 0) {
      Fff = d.fli().getViewWidth();
    }
    int i = Fff;
    AppMethodBeat.o(100527);
    return i;
  }
  
  public final void A(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100526);
    super.A(paramCharSequence);
    AppMethodBeat.o(100526);
  }
  
  public final void B(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100525);
    super.B(paramCharSequence);
    AppMethodBeat.o(100525);
  }
  
  public final a aBn()
  {
    AppMethodBeat.i(100523);
    if (Ffe == null) {
      Ffe = d.fli().getTextViewConfig();
    }
    a locala = Ffe;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView
 * JD-Core Version:    0.7.0.1
 */