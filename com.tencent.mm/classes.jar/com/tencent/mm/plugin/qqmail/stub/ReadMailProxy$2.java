package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.m.a;

final class ReadMailProxy$2
  implements m.a
{
  ReadMailProxy$2(ReadMailProxy paramReadMailProxy) {}
  
  public final void dej()
  {
    AppMethodBeat.i(122811);
    this.uNc.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
    AppMethodBeat.o(122811);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(122810);
    this.uNc.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(122810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.2
 * JD-Core Version:    0.7.0.1
 */