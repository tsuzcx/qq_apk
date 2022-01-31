package com.tencent.mm.ui.chatting;

import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.tools.i.a;

final class u$7
  implements i.a
{
  u$7(u paramu) {}
  
  public final void btK()
  {
    this.vkL.vkB.setText(R.l.chatfooter_mail_without_unread_count);
  }
  
  public final void onSuccess(int paramInt)
  {
    this.vkL.vkE = paramInt;
    this.vkL.cCS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.7
 * JD-Core Version:    0.7.0.1
 */