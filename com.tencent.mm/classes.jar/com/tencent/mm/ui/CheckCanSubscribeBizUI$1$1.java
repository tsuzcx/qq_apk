package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class CheckCanSubscribeBizUI$1$1
  implements Runnable
{
  CheckCanSubscribeBizUI$1$1(CheckCanSubscribeBizUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(293374);
    Log.i("MicroMsg.CheckCanSubscribeBizUI", "getContactCallBack fail run");
    CheckCanSubscribeBizUI.a(this.ZuQ.VRI);
    if ((!CheckCanSubscribeBizUI.b(this.ZuQ.VRI)) && (!this.ZuQ.VRI.isDestroyed())) {
      CheckCanSubscribeBizUI.c(this.ZuQ.VRI);
    }
    AppMethodBeat.o(293374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.CheckCanSubscribeBizUI.1.1
 * JD-Core Version:    0.7.0.1
 */