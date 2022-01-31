package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;

final class y$9
  implements View.OnTouchListener
{
  boolean vme = false;
  
  y$9(y paramy) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    y.g(this.vmb);
    if (paramMotionEvent.getAction() == 0)
    {
      this.vme = true;
      if ((this.vme) && (this.vmb.vlV)) {
        break label55;
      }
    }
    label55:
    do
    {
      return false;
      if (paramMotionEvent.getAction() != 1) {
        break;
      }
      this.vme = false;
      break;
      paramView = (n)this.vmb.byx.ac(n.class);
    } while ((paramView == null) || (paramView.cEq() == null));
    paramView.cEq().r(0, -1, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.9
 * JD-Core Version:    0.7.0.1
 */