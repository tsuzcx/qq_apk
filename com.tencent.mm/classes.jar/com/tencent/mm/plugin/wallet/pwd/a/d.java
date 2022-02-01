package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends c<dgi>
{
  public d(LinkedList<dfj> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    dgh localdgh = new dgh();
    localdgh.CtY = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.gUU = localdgh;
    paramLinkedList.gUV = new dgi();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.reqCmdId = 0;
    paramLinkedList.respCmdId = 0;
    this.rr = paramLinkedList.atI();
    ad.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */