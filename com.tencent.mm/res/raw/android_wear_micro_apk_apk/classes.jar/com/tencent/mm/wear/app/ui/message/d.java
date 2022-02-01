package com.tencent.mm.wear.app.ui.message;

import android.os.Message;
import com.tencent.mm.wear.a.b.a;
import com.tencent.mm.wear.app.ui.widget.RecordView;

final class d
  extends a
{
  private d(ReplyTextUI paramReplyTextUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 4098) && ((ReplyTextUI.a(this.ajX).getStatus() == 2) || (ReplyTextUI.a(this.ajX).getStatus() == 3)))
    {
      if (ReplyTextUI.b(this.ajX) <= 0) {
        ReplyTextUI.a(this.ajX).setStatus(4);
      }
    }
    else {
      return;
    }
    if (ReplyTextUI.b(this.ajX) <= 10)
    {
      if (ReplyTextUI.a(this.ajX).getStatus() != 2) {
        break label145;
      }
      ReplyTextUI.a(this.ajX, this.ajX.getString(2131165235, new Object[] { Integer.valueOf(ReplyTextUI.b(this.ajX)) }));
    }
    for (;;)
    {
      ReplyTextUI.c(this.ajX);
      ReplyTextUI.d(this.ajX).sendEmptyMessageDelayed(4098, 1000L);
      return;
      label145:
      ReplyTextUI.a(this.ajX, this.ajX.getString(2131165238, new Object[] { Integer.valueOf(ReplyTextUI.b(this.ajX)) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.d
 * JD-Core Version:    0.7.0.1
 */