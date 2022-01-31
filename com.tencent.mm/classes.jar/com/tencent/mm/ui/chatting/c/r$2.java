package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.a;

final class r$2
  implements Runnable
{
  r$2(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(31441);
    Bundle localBundle = new Bundle();
    localBundle.putLong("MSG_ID", r.a(this.zGh).field_msgId);
    this.zGh.caz.zJB.aG(localBundle);
    AppMethodBeat.o(31441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.r.2
 * JD-Core Version:    0.7.0.1
 */