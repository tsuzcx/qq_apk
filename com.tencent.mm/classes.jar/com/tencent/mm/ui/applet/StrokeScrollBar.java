package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar
  extends VerticalScrollBar
{
  public StrokeScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void aNw()
  {
    AppMethodBeat.i(33837);
    this.JMk = new String[18];
    int i = 0;
    while (i < this.JMk.length)
    {
      this.JMk[i] = (Integer.toString(i + 3) + "劃");
      i += 1;
    }
    this.JMi = 2.0F;
    this.JMj = 79;
    AppMethodBeat.o(33837);
  }
  
  public int getToastLayoutId()
  {
    return R.i.gom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.StrokeScrollBar
 * JD-Core Version:    0.7.0.1
 */