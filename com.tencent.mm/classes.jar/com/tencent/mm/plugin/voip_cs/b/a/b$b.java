package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

final class b$b
  implements Runnable
{
  b$b(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135328);
    this.tLv.tLu = b.aeN(this.tLv.tLt);
    Message localMessage = new Message();
    localMessage.what = 12;
    b.t(this.tLv).sendMessage(localMessage);
    d.ysm.remove(this.tLv.tLs);
    AppMethodBeat.o(135328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */