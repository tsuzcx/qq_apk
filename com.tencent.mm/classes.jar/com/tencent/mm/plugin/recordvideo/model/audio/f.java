package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.cxn;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f
  extends com.tencent.mm.ak.a<bxs>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    bxr localbxr = new bxr();
    bxs localbxs = new bxs();
    localbxs.setBaseResponse(new BaseResponse());
    localbxs.getBaseResponse().ErrMsg = new cxn();
    localbxr.Hkt = paramLong1;
    localbxr.query = paramString;
    localbxr.offset = paramInt;
    localbxr.GjM = 10;
    localbxr.Hku = paramLong2;
    paramString = new b.a();
    paramString.c((com.tencent.mm.bw.a)localbxr);
    paramString.d((com.tencent.mm.bw.a)localbxs);
    paramString.DN("/cgi-bin/spr-bin/mmsprbgmsearch");
    paramString.oS(3554);
    c(paramString.aDS());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */