package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.o;
import com.tencent.mm.protocal.protobuf.a.p;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetRecommendRingBackCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/GetRecommendRingBackResponse;", "offset", "", "sessionId", "", "(ILjava/lang/String;)V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<p>
{
  public c(int paramInt, String paramString)
  {
    AppMethodBeat.i(272764);
    o localo = new o();
    localo.YYs = paramInt;
    localo.SessionId = paramString;
    paramString = new c.a();
    paramString.otE = ((a)localo);
    paramString.otF = ((a)new p());
    paramString.otG = 0;
    paramString.respCmdId = 0;
    paramString.uri = "/cgi-bin/micromsg-bin/getrecommendringback";
    paramString.funcId = 4215;
    c(paramString.bEF());
    AppMethodBeat.o(272764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.c
 * JD-Core Version:    0.7.0.1
 */