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
  
  public final void ann()
  {
    AppMethodBeat.i(33837);
    this.yuX = new String[18];
    int i = 0;
    while (i < this.yuX.length)
    {
      this.yuX[i] = (Integer.toString(i + 3) + "劃");
      i += 1;
    }
    this.yuV = 2.0F;
    this.yuW = 79;
    AppMethodBeat.o(33837);
  }
  
  public int getToastLayoutId()
  {
    return 2131496312;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.applet.StrokeScrollBar
 * JD-Core Version:    0.7.0.1
 */