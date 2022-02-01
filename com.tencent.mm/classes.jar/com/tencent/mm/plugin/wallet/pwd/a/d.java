package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class d
  extends a<dsl>
{
  public d(LinkedList<drm> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    dsk localdsk = new dsk();
    localdsk.FJS = paramLinkedList;
    paramLinkedList = new b.a();
    paramLinkedList.hQF = localdsk;
    paramLinkedList.hQG = new dsl();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.hQH = 0;
    paramLinkedList.respCmdId = 0;
    c(paramLinkedList.aDS());
    ae.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */