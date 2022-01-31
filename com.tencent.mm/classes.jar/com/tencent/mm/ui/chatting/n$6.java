package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.mm.br.d.a;
import com.tencent.mm.ui.chatting.c.a;

final class n$6
  implements d.a
{
  n$6(a parama) {}
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 225)
    {
      String str = paramIntent.getStringExtra("enterprise_biz_name");
      long l = paramIntent.getLongExtra("key_biz_chat_id", -1L);
      n.a(this.vjy, str, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.n.6
 * JD-Core Version:    0.7.0.1
 */