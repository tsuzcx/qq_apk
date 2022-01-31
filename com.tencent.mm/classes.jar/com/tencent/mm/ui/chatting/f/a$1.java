package com.tencent.mm.ui.chatting.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.l.e;
import java.util.List;

final class a$1
  implements d.b
{
  a$1(a parama, e parame, d.d paramd, d.a parama1, d.b paramb) {}
  
  public final void next()
  {
    AppMethodBeat.i(32476);
    this.zOp.fs(this.zOq.zOF);
    this.zOp.close();
    this.zOq.eke = this.zOp.dwi();
    this.zOq.zOG = this.zOq.zOF.size();
    ab.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + this.zOr + " addCount:" + this.zOq.zOG + " totalCount:" + this.zOq.eke);
    this.zOs.next();
    AppMethodBeat.o(32476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.a.1
 * JD-Core Version:    0.7.0.1
 */