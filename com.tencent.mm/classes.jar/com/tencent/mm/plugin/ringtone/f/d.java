package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.r;
import com.tencent.mm.protocal.protobuf.a.s;
import com.tencent.mm.protocal.protobuf.a.t;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetRingBackDetailCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRingBackDetailResponse;", "ringbackLists", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRingBackDetailSubRequest;", "(Ljava/util/LinkedList;)V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<s>
{
  public d(LinkedList<t> paramLinkedList)
  {
    AppMethodBeat.i(272766);
    r localr = new r();
    localr.acjg = paramLinkedList;
    paramLinkedList = new c.a();
    paramLinkedList.otE = ((a)localr);
    paramLinkedList.otF = ((a)new s());
    paramLinkedList.otG = 0;
    paramLinkedList.respCmdId = 0;
    paramLinkedList.uri = "/cgi-bin/micromsg-bin/getringbackdetail";
    paramLinkedList.funcId = 6296;
    c(paramLinkedList.bEF());
    AppMethodBeat.o(272766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.d
 * JD-Core Version:    0.7.0.1
 */