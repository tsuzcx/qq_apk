package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
  extends a<cni>
{
  public d(LinkedList<cmj> paramLinkedList)
  {
    AppMethodBeat.i(46169);
    cnh localcnh = new cnh();
    localcnh.wlK = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.fsX = localcnh;
    paramLinkedList.fsY = new cni();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.reqCmdId = 0;
    paramLinkedList.respCmdId = 0;
    this.rr = paramLinkedList.ado();
    ab.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(46169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */