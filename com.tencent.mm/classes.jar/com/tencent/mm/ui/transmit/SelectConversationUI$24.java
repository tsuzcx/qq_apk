package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SelectConversationUI$24
  implements q.a
{
  SelectConversationUI$24(SelectConversationUI paramSelectConversationUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whw.XM();
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent();
      if (!s.fn(this.whA)) {
        break label72;
      }
      SelectConversationUI.c(localIntent, SelectConversationUI.g(this.whw), this.whA);
    }
    for (;;)
    {
      localIntent.putExtra("custom_send_text", paramString);
      SelectConversationUI.a(this.whw, localIntent);
      this.whw.finish();
      return;
      label72:
      SelectConversationUI.d(localIntent, SelectConversationUI.g(this.whw), this.whA);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.24
 * JD-Core Version:    0.7.0.1
 */