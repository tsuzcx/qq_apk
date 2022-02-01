package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MaskTextView
  extends SnsTextView
{
  public MaskTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97976);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(97976);
      return;
    }
    catch (Throwable paramCanvas)
    {
      Log.printErrStackTrace("MicroMsg.MaskTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(97976);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97974);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(97974);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97975);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(97975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskTextView
 * JD-Core Version:    0.7.0.1
 */