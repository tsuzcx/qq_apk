package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

@TargetApi(14)
public final class ak$a
  implements View.OnHoverListener
{
  private ak.b vmC;
  
  public ak$a(ak.b paramb)
  {
    this.vmC = paramb;
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.vmC != null) {
      return this.vmC.e(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak.a
 * JD-Core Version:    0.7.0.1
 */