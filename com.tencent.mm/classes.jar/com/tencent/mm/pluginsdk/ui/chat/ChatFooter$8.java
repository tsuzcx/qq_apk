package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

final class ChatFooter$8
  implements View.OnTouchListener
{
  ChatFooter$8(ChatFooter paramChatFooter) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != ChatFooter.s(this.sgd)) {}
    do
    {
      do
      {
        do
        {
          return false;
          y.v("RcdBtnEvent", "event.getAction():" + paramMotionEvent.getAction());
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            y.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.cnK()) });
            if ((ChatFooter.t(this.sgd) instanceof Activity)) {
              ((Activity)ChatFooter.t(this.sgd)).getWindow().addFlags(128);
            }
            break;
          }
        } while ((ChatFooter.u(this.sgd)) || (ChatFooter.v(this.sgd)));
        ChatFooter.c(this.sgd, true);
        ChatFooter.s(this.sgd).setBackgroundDrawable(a.g(this.sgd.getContext(), R.g.record_shape_press));
        ChatFooter.s(this.sgd).setText(R.l.chatfooter_releasetofinish);
        if (ChatFooter.j(this.sgd) != null) {
          ChatFooter.j(this.sgd).bhi();
        }
        ChatFooter.s(this.sgd).setContentDescription(this.sgd.getContext().getString(R.l.chat_footer_switch_press_btn));
        return false;
        if ((ChatFooter.w(this.sgd) == null) || (ChatFooter.x(this.sgd) == null)) {
          y.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.w(this.sgd), ChatFooter.x(this.sgd) });
        }
        if ((paramMotionEvent.getX() <= 0.0F) || (paramMotionEvent.getY() <= -ChatFooter.y(this.sgd) / 2) || (paramMotionEvent.getX() >= ChatFooter.s(this.sgd).getWidth())) {
          break;
        }
        if (ChatFooter.w(this.sgd) != null) {
          ChatFooter.w(this.sgd).setVisibility(0);
        }
      } while (ChatFooter.x(this.sgd) == null);
      ChatFooter.s(this.sgd).setText(R.l.chatfooter_releasetofinish);
      ChatFooter.x(this.sgd).setVisibility(8);
      return false;
      y.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(ChatFooter.y(this.sgd)), Integer.valueOf(ChatFooter.s(this.sgd).getWidth()), Integer.valueOf(ChatFooter.s(this.sgd).getHeight()) });
      if (ChatFooter.w(this.sgd) != null) {
        ChatFooter.w(this.sgd).setVisibility(8);
      }
    } while (ChatFooter.x(this.sgd) == null);
    ChatFooter.s(this.sgd).setText(R.l.chatfooter_cancel_tips);
    ChatFooter.x(this.sgd).setVisibility(0);
    return false;
    if ((ChatFooter.t(this.sgd) instanceof Activity)) {
      ((Activity)ChatFooter.t(this.sgd)).getWindow().clearFlags(128);
    }
    y.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.cnK()) });
    ChatFooter.z(this.sgd);
    y.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.cnL()) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.8
 * JD-Core Version:    0.7.0.1
 */