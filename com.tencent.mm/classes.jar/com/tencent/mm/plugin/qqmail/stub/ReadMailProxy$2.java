package com.tencent.mm.plugin.qqmail.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.j.a;

final class ReadMailProxy$2
  implements j.a
{
  ReadMailProxy$2(ReadMailProxy paramReadMailProxy) {}
  
  public final void cdV()
  {
    AppMethodBeat.i(68085);
    this.pKO.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
    AppMethodBeat.o(68085);
  }
  
  public final void onSuccess(int paramInt)
  {
    AppMethodBeat.i(68084);
    this.pKO.CLIENT_CALL("onGetQQMailUnreadSuccess", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(68084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.stub.ReadMailProxy.2
 * JD-Core Version:    0.7.0.1
 */