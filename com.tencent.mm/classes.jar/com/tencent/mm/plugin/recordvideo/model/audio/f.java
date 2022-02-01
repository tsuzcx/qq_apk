package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.dln;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<dln>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    dlm localdlm = new dlm();
    dln localdln = new dln();
    localdln.setBaseResponse(new kd());
    localdln.getBaseResponse().akjO = new etl();
    localdlm.aaRC = paramLong1;
    localdlm.query = paramString;
    localdlm.offset = paramInt;
    localdlm.Zdz = 10;
    localdlm.aaRD = paramLong2;
    paramString = new c.a();
    paramString.otE = ((a)localdlm);
    paramString.otF = ((a)localdln);
    paramString.uri = "/cgi-bin/spr-bin/mmsprbgmsearch";
    paramString.funcId = 3554;
    c(paramString.bEF());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */