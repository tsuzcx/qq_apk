package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends a<dro>
{
  public d(LinkedList<dqp> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    drn localdrn = new drn();
    localdrn.Fru = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.hNM = localdrn;
    paramLinkedList.hNN = new dro();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.hNO = 0;
    paramLinkedList.respCmdId = 0;
    c(paramLinkedList.aDC());
    ad.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */