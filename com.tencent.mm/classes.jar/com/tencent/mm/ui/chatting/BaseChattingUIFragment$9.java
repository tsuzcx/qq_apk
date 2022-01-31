package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.d.a;

final class BaseChattingUIFragment$9
  implements Runnable
{
  BaseChattingUIFragment$9(BaseChattingUIFragment paramBaseChattingUIFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(30448);
    ab.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO) });
    if ((this.zwS.Pi(16)) && (!this.zwS.Pi(8)))
    {
      RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { this.zwS.zwL, Boolean.valueOf(this.zwS.zwO), Boolean.valueOf(this.zwS.caz.bSe), Boolean.valueOf(this.zwS.isFinishing()), Boolean.valueOf(this.zwS.Pi(2)) }));
      AppMethodBeat.o(30448);
      throw localRuntimeException;
    }
    this.zwS.caz.bSe = false;
    BaseChattingUIFragment.b(this.zwS);
    AppMethodBeat.o(30448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment.9
 * JD-Core Version:    0.7.0.1
 */