package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.frd;
import com.tencent.mm.protocal.protobuf.fsh;
import com.tencent.mm.protocal.protobuf.fsi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends b<fsi>
{
  public d(LinkedList<frd> paramLinkedList)
  {
    AppMethodBeat.i(69525);
    fsh localfsh = new fsh();
    localfsh.YBg = paramLinkedList;
    paramLinkedList = new c.a();
    paramLinkedList.otE = localfsh;
    paramLinkedList.otF = new fsi();
    paramLinkedList.funcId = 2638;
    paramLinkedList.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
    paramLinkedList.otG = 0;
    paramLinkedList.respCmdId = 0;
    c(paramLinkedList.bEF());
    Log.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
    AppMethodBeat.o(69525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.d
 * JD-Core Version:    0.7.0.1
 */