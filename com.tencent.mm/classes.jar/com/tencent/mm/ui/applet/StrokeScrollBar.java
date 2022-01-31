package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar
  extends VerticalScrollBar
{
  public StrokeScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void Kr()
  {
    AppMethodBeat.i(29979);
    this.nSx = new String[18];
    int i = 0;
    while (i < this.nSx.length)
    {
      this.nSx[i] = (Integer.toString(i + 3) + "劃");
      i += 1;
    }
    this.nSv = 2.0F;
    this.nSw = 79;
    AppMethodBeat.o(29979);
  }
  
  public int getToastLayoutId()
  {
    return 2130970735;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.StrokeScrollBar
 * JD-Core Version:    0.7.0.1
 */