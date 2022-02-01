package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView
  extends PLTextView
{
  private static a ACX = null;
  private static int ACY = 0;
  private boolean ACZ = false;
  
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
    if (ACX == null) {
      ACX = c.efa().getTextViewConfig();
    }
    a locala = ACX;
    AppMethodBeat.o(100498);
    return locala;
  }
  
  public static int getViewWidth()
  {
    AppMethodBeat.i(100501);
    if (ACY == 0) {
      ACY = c.efa().getViewWidth();
    }
    int i = ACY;
    AppMethodBeat.o(100501);
    return i;
  }
  
  public final a akH()
  {
    AppMethodBeat.i(100497);
    if (ACX == null) {
      ACX = c.efa().getTextViewConfig();
    }
    a locala = ACX;
    AppMethodBeat.o(100497);
    return locala;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100502);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(100502);
  }
  
  public final void x(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100500);
    super.x(paramCharSequence);
    AppMethodBeat.o(100500);
  }
  
  public final void y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(100499);
    super.y(paramCharSequence);
    AppMethodBeat.o(100499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView
 * JD-Core Version:    0.7.0.1
 */