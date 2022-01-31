package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.ui.chatting.d.a;

final class as$2
  implements ChatFooter.d
{
  as$2(as paramas) {}
  
  public final void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(31867);
    if (paramBoolean.booleanValue())
    {
      if (as.a(this.zJk) == null) {
        as.a(this.zJk, ((ViewStub)this.zJk.caz.findViewById(2131822450)).inflate());
      }
      as.a(this.zJk).setVisibility(0);
      AppMethodBeat.o(31867);
      return;
    }
    if ((as.a(this.zJk) != null) && (as.a(this.zJk).getVisibility() == 0)) {
      as.a(this.zJk).setVisibility(8);
    }
    AppMethodBeat.o(31867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.as.2
 * JD-Core Version:    0.7.0.1
 */