package com.tencent.mm.plugin.story.model.audio;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.bwc;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-story_release"})
public final class e
  extends com.tencent.mm.ai.a<ape>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151063);
    apd localapd = new apd();
    ape localape = new ape();
    localape.setBaseResponse(new BaseResponse());
    localape.getBaseResponse().ErrMsg = new bwc();
    localapd.xfj = paramLinkedList;
    localapd.xfi = paramInt2;
    localapd.cyV = paramFloat1;
    localapd.cAH = paramFloat2;
    localapd.swu = paramLong1;
    localapd.xfl = paramLong2;
    localapd.xfk = paramInt1;
    paramLinkedList = new b.a();
    paramLinkedList.a((com.tencent.mm.bv.a)localapd);
    paramLinkedList.b((com.tencent.mm.bv.a)localape);
    paramLinkedList.rl("/cgi-bin/micromsg-bin/getrecommendedmusiclist");
    paramLinkedList.kT(341);
    a(paramLinkedList.ado());
    AppMethodBeat.o(151063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.e
 * JD-Core Version:    0.7.0.1
 */