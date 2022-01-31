package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SelectConversationUI$18
  implements q.a
{
  SelectConversationUI$18(SelectConversationUI paramSelectConversationUI, Intent paramIntent) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whw.XM();
    if (paramBoolean)
    {
      this.val$intent.putExtra("custom_send_text", paramString);
      SelectConversationUI.a(this.whw, this.val$intent);
      this.whw.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.18
 * JD-Core Version:    0.7.0.1
 */