package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.cwt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f
  extends com.tencent.mm.al.a<bwy>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    bwx localbwx = new bwx();
    bwy localbwy = new bwy();
    localbwy.setBaseResponse(new BaseResponse());
    localbwy.getBaseResponse().ErrMsg = new cwt();
    localbwx.GQS = paramLong1;
    localbwx.query = paramString;
    localbwx.offset = paramInt;
    localbwx.FRn = 10;
    localbwx.GQT = paramLong2;
    paramString = new b.a();
    paramString.c((com.tencent.mm.bx.a)localbwx);
    paramString.d((com.tencent.mm.bx.a)localbwy);
    paramString.Dl("/cgi-bin/spr-bin/mmsprbgmsearch");
    paramString.oP(3554);
    c(paramString.aDC());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */