package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.protocal.protobuf.crm;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f
  extends c<bsl>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    bsk localbsk = new bsk();
    bsl localbsl = new bsl();
    localbsl.setBaseResponse(new BaseResponse());
    localbsl.getBaseResponse().ErrMsg = new crm();
    localbsk.Fhq = paramLong1;
    localbsk.query = paramString;
    localbsk.offset = paramInt;
    localbsk.Eke = 10;
    localbsk.Fhr = paramLong2;
    paramString = new b.a();
    paramString.c((a)localbsk);
    paramString.d((a)localbsl);
    paramString.Am("/cgi-bin/spr-bin/mmsprbgmsearch");
    paramString.op(3554);
    c(paramString.aAz());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */