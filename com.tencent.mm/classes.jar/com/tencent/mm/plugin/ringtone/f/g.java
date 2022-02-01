package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.ae;
import com.tencent.mm.protocal.protobuf.a.af;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/SetRingBackCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/SetRingBackResponse;", "request", "Lcom/tencent/mm/protocal/protobuf/ringtone/SetRingBackRequest;", "(Lcom/tencent/mm/protocal/protobuf/ringtone/SetRingBackRequest;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/ringtone/SetRingBackRequest;", "setRequest", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b<af>
{
  private ae OCW;
  
  public g(ae paramae)
  {
    AppMethodBeat.i(272779);
    this.OCW = paramae;
    paramae = this.OCW;
    c.a locala = new c.a();
    locala.otE = ((a)paramae);
    locala.otF = ((a)new af());
    locala.otG = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/setringback";
    locala.funcId = 5279;
    c(locala.bEF());
    AppMethodBeat.o(272779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.g
 * JD-Core Version:    0.7.0.1
 */