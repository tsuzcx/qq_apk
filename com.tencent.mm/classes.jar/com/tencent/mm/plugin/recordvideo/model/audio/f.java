package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.cmf;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f
  extends c<bnv>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    bnu localbnu = new bnu();
    bnv localbnv = new bnv();
    localbnv.setBaseResponse(new BaseResponse());
    localbnv.getBaseResponse().ErrMsg = new cmf();
    localbnu.DLb = paramLong1;
    localbnu.query = paramString;
    localbnu.offset = paramInt;
    localbnu.CRt = 10;
    localbnu.DLc = paramLong2;
    paramString = new b.a();
    paramString.c((a)localbnu);
    paramString.d((a)localbnv);
    paramString.wg("/cgi-bin/spr-bin/mmsprbgmsearch");
    paramString.nB(3554);
    c(paramString.atI());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */