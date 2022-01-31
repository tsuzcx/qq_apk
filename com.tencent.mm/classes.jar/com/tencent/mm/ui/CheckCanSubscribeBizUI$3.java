package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CheckCanSubscribeBizUI$3
  implements Runnable
{
  CheckCanSubscribeBizUI$3(CheckCanSubscribeBizUI paramCheckCanSubscribeBizUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(29143);
    ab.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.d(this.yUP) + ", userName = " + this.fwC);
    if (CheckCanSubscribeBizUI.d(this.yUP).equals(this.fwC))
    {
      CheckCanSubscribeBizUI.e(this.yUP);
      if (!CheckCanSubscribeBizUI.f(this.yUP)) {
        CheckCanSubscribeBizUI.b(this.yUP);
      }
    }
    AppMethodBeat.o(29143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI.3
 * JD-Core Version:    0.7.0.1
 */