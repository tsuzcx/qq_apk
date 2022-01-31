package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

final class at$2
  implements q.a
{
  at$2(at paramat, WXMediaMessage paramWXMediaMessage, f paramf) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = null;
      if (this.pii.getType() != 8) {
        break label93;
      }
      if (this.pii.thumbData == null) {
        y.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
      }
    }
    else
    {
      return;
    }
    String str = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(at.a(this.vnz).getContext(), this.pii, this.vny.field_appId);
    paramString = str;
    if (str == null)
    {
      y.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
      return;
    }
    label93:
    bt.If().d(27, new Object[] { Integer.valueOf(1) });
    y.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { this.pii.messageAction, this.pii.messageExt });
    l.a(this.pii, this.vny.field_appId, this.vny.field_appName, at.b(this.vnz).getTalkerUserName(), 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.at.2
 * JD-Core Version:    0.7.0.1
 */