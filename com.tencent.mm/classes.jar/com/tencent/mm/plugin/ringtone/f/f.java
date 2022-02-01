package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.l;
import com.tencent.mm.protocal.protobuf.a.m;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetSelfRingtoneCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetMyRingBackResponse;", "()V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<m>
{
  public f()
  {
    AppMethodBeat.i(272773);
    l locall = new l();
    c.a locala = new c.a();
    locala.otE = ((a)locall);
    locala.otF = ((a)new m());
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/getmyringback";
    locala.funcId = 5830;
    c(locala.bEF());
    AppMethodBeat.o(272773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.f
 * JD-Core Version:    0.7.0.1
 */