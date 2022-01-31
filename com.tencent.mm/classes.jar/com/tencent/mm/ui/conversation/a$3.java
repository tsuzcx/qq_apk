package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class a$3
  extends n.a
{
  private final ap AgQ;
  
  a$3(a parama)
  {
    AppMethodBeat.i(34030);
    this.AgQ = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(34029);
        a.3.this.AgP.dMn();
        AppMethodBeat.o(34029);
        return false;
      }
    }, false);
    AppMethodBeat.o(34030);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(34031);
    if (this.AgQ != null) {
      this.AgQ.ag(10L, 10L);
    }
    AppMethodBeat.o(34031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.3
 * JD-Core Version:    0.7.0.1
 */