package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.protocal.protobuf.emi;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends c<emj>
{
  public d(LinkedList<eli> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    emi localemi = new emi();
    localemi.KDk = paramLinkedList;
    paramLinkedList = new d.a();
    paramLinkedList.iLN = localemi;
    paramLinkedList.iLO = new emj();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.iLP = 0;
    paramLinkedList.respCmdId = 0;
    c(paramLinkedList.aXF());
    Log.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */