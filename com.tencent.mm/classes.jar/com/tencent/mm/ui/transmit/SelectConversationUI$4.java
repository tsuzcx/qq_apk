package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;

final class SelectConversationUI$4
  implements q.a
{
  SelectConversationUI$4(SelectConversationUI paramSelectConversationUI, e parame) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(35127);
    this.AAp.hideVKB();
    e locale = this.AAq;
    locale.iNk = true;
    locale.iNm = paramBoolean;
    locale.text = paramString;
    locale.iNn = paramInt;
    if (locale.lw())
    {
      locale.aMj();
      AppMethodBeat.o(35127);
      return;
    }
    if (paramBoolean)
    {
      locale.tipDialog = h.b(locale.context, locale.context.getString(2131303124), true, null);
      al.p(locale.hGy, 5000L);
    }
    AppMethodBeat.o(35127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.4
 * JD-Core Version:    0.7.0.1
 */