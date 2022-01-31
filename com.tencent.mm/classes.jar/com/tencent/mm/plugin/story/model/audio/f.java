package com.tencent.mm.plugin.story.model.audio;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.protocal.protobuf.jh;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-story_release"})
public final class f
  extends com.tencent.mm.ai.a<jh>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(109193);
    jg localjg = new jg();
    jh localjh = new jh();
    localjh.setBaseResponse(new BaseResponse());
    localjh.getBaseResponse().ErrMsg = new bwc();
    localjg.wvj = paramLong1;
    localjg.query = paramString;
    localjg.offset = paramInt;
    localjg.wvk = 10;
    localjg.wvl = paramLong2;
    paramString = new b.a();
    paramString.a((com.tencent.mm.bv.a)localjg);
    paramString.b((com.tencent.mm.bv.a)localjh);
    paramString.rl("/cgi-bin/micromsg-bin/sprbgmsearch");
    paramString.kT(3645);
    a(paramString.ado());
    AppMethodBeat.o(109193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.f
 * JD-Core Version:    0.7.0.1
 */