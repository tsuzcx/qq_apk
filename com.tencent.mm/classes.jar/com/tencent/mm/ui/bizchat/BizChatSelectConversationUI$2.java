package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class BizChatSelectConversationUI$2
  implements q.a
{
  BizChatSelectConversationUI$2(BizChatSelectConversationUI paramBizChatSelectConversationUI, String paramString, long paramLong) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("enterprise_biz_name", this.egy);
      paramString.putExtra("key_biz_chat_id", this.dUI);
      paramString.putExtra("key_is_biz_chat", true);
      this.vfP.setResult(-1, paramString);
      this.vfP.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.2
 * JD-Core Version:    0.7.0.1
 */