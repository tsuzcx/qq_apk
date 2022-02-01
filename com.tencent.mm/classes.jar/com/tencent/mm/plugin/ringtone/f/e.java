package com.tencent.mm.plugin.ringtone.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.a.ac;
import com.tencent.mm.protocal.protobuf.a.ad;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/model/GetSearchRingBackCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ringtone/SearchRingBackResponse;", "queryContent", "", "offset", "", "sessionId", "(Ljava/lang/String;ILjava/lang/String;)V", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<ad>
{
  public e(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(272771);
    ac localac = new ac();
    localac.acjv = paramString1;
    localac.YYs = paramInt;
    localac.SessionId = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)localac);
    paramString1.otF = ((a)new ad());
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    paramString1.uri = "/cgi-bin/micromsg-bin/searchringback";
    paramString1.funcId = 6442;
    c(paramString1.bEF());
    AppMethodBeat.o(272771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.f.e
 * JD-Core Version:    0.7.0.1
 */