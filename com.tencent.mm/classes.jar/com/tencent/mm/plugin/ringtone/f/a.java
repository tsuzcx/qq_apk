package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.a.f;
import com.tencent.mm.protocal.protobuf.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetAllFriendRingBackCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetAllFriendRingBackResponse;", "seq", "", "(J)V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b<g>
{
  public a(long paramLong)
  {
    AppMethodBeat.i(272767);
    f localf = new f();
    localf.aciZ = paramLong;
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)localf);
    locala.otF = ((com.tencent.mm.bx.a)new g());
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/getallfriendringback";
    locala.funcId = 497;
    c(locala.bEF());
    AppMethodBeat.o(272767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.a
 * JD-Core Version:    0.7.0.1
 */