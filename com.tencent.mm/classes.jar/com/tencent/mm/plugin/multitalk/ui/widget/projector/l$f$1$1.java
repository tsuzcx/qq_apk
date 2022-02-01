package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.ag;
import com.tencent.mm.plugin.multitalk.model.q;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class l$f$1$1
  implements Runnable
{
  l$f$1$1(l.f.1 param1, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(201453);
    this.FDg.position(0);
    byte[] arrayOfByte = new byte[this.FDg.capacity()];
    this.FDg.get(arrayOfByte);
    q localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    localq.eXn().uT(false);
    localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    localq.eXn().a(arrayOfByte, arrayOfByte.length, this.cLp, this.cLq, 4);
    AppMethodBeat.o(201453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l.f.1.1
 * JD-Core Version:    0.7.0.1
 */