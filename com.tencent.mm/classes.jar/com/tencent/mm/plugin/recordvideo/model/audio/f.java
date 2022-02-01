package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiSearchMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRBgmSearchResp;", "searchRequestId", "", "query", "", "offset", "", "relatedRecId", "audioCount", "(JLjava/lang/String;IJI)V", "plugin-recordvideo_release"})
public final class f
  extends c<clk>
{
  private f(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(75423);
    clj localclj = new clj();
    clk localclk = new clk();
    localclk.setBaseResponse(new BaseResponse());
    localclk.getBaseResponse().ErrMsg = new dqi();
    localclj.MqH = paramLong1;
    localclj.query = paramString;
    localclj.offset = paramInt;
    localclj.Ler = 10;
    localclj.MqI = paramLong2;
    paramString = new d.a();
    paramString.c((a)localclj);
    paramString.d((a)localclk);
    paramString.MB("/cgi-bin/spr-bin/mmsprbgmsearch");
    paramString.sG(3554);
    c(paramString.aXF());
    AppMethodBeat.o(75423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.f
 * JD-Core Version:    0.7.0.1
 */