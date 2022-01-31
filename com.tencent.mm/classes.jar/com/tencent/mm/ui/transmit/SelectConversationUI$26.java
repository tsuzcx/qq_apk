package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class SelectConversationUI$26
  implements q.a
{
  SelectConversationUI$26(SelectConversationUI paramSelectConversationUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(35148);
    this.AAp.hideVKB();
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent();
      if (!t.lA(this.AAu)) {
        break label83;
      }
      SelectConversationUI.c(localIntent, SelectConversationUI.g(this.AAp), this.AAu);
    }
    for (;;)
    {
      localIntent.putExtra("custom_send_text", paramString);
      SelectConversationUI.a(this.AAp, -1, localIntent);
      this.AAp.finish();
      AppMethodBeat.o(35148);
      return;
      label83:
      SelectConversationUI.d(localIntent, SelectConversationUI.g(this.AAp), this.AAu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.26
 * JD-Core Version:    0.7.0.1
 */