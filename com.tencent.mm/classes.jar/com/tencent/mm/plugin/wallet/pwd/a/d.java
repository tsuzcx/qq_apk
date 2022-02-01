package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dlw;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class d
  extends c<dlx>
{
  public d(LinkedList<dky> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    dlw localdlw = new dlw();
    localdlw.DMp = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.hvt = localdlw;
    paramLinkedList.hvu = new dlx();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.reqCmdId = 0;
    paramLinkedList.respCmdId = 0;
    this.rr = paramLinkedList.aAz();
    ac.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */