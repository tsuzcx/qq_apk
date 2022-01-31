package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar
  extends VerticalScrollBar
{
  public StrokeScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getToastLayoutId()
  {
    return R.i.show_head_toast_stroke;
  }
  
  protected final void xZ()
  {
    this.lvg = new String[18];
    int i = 0;
    while (i < this.lvg.length)
    {
      this.lvg[i] = (Integer.toString(i + 3) + "劃");
      i += 1;
    }
    this.lve = 2.0F;
    this.lvf = 79;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.StrokeScrollBar
 * JD-Core Version:    0.7.0.1
 */