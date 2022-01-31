package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MaskTextView
  extends SnsTextView
{
  public MaskTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38323);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(38323);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.MaskTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(38323);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38321);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(38321);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38322);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(38322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskTextView
 * JD-Core Version:    0.7.0.1
 */