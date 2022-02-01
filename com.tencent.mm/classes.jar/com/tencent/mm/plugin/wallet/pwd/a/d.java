package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.evo;
import com.tencent.mm.protocal.protobuf.ewo;
import com.tencent.mm.protocal.protobuf.ewp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends c<ewp>
{
  public d(LinkedList<evo> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    ewo localewo = new ewo();
    localewo.REB = paramLinkedList;
    paramLinkedList = new d.a();
    paramLinkedList.lBU = localewo;
    paramLinkedList.lBV = new ewp();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.lBW = 0;
    paramLinkedList.respCmdId = 0;
    c(paramLinkedList.bgN());
    Log.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */