package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class BizChatSelectConversationUI$3
  implements q.a
{
  BizChatSelectConversationUI$3(BizChatSelectConversationUI paramBizChatSelectConversationUI, String paramString, long paramLong) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(30176);
    if (paramBoolean)
    {
      paramString = new Intent();
      paramString.putExtra("enterprise_biz_name", this.fwC);
      paramString.putExtra("key_biz_chat_id", this.fkR);
      paramString.putExtra("key_is_biz_chat", true);
      this.zuo.setResult(-1, paramString);
      this.zuo.finish();
    }
    AppMethodBeat.o(30176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.3
 * JD-Core Version:    0.7.0.1
 */