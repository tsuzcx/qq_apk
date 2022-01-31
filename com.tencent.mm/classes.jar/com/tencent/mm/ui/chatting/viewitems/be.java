package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.mm.ui.base.a.a;

abstract class be
  extends ClickableSpan
  implements a
{
  private boolean vIo;
  private int vIp;
  private int vIq;
  
  public be(int paramInt1, int paramInt2)
  {
    this.vIp = paramInt1;
    this.vIq = paramInt2;
  }
  
  public final void mf(boolean paramBoolean)
  {
    this.vIo = paramBoolean;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    if (this.vIo) {}
    for (int i = this.vIq;; i = this.vIp)
    {
      paramTextPaint.setColor(i);
      paramTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be
 * JD-Core Version:    0.7.0.1
 */