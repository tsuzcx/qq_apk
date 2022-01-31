package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.h;

final class SelectConversationUI$3
  implements q.a
{
  SelectConversationUI$3(SelectConversationUI paramSelectConversationUI, e parame) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.whw.XM();
    e locale = this.whx;
    locale.wib = true;
    locale.wid = paramBoolean;
    locale.text = paramString;
    locale.oYc = paramInt;
    if (locale.jC()) {
      locale.cJI();
    }
    while (!paramBoolean) {
      return;
    }
    locale.tipDialog = h.b(locale.context, locale.context.getString(R.l.sending_message), true, null);
    ai.l(locale.gmy, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.3
 * JD-Core Version:    0.7.0.1
 */