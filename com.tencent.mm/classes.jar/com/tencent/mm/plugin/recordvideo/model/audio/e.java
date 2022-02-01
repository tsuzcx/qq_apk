package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.cwt;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.al.a<bxa>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    bwz localbwz = new bwz();
    bxa localbxa = new bxa();
    localbxa.setBaseResponse(new BaseResponse());
    localbxa.getBaseResponse().ErrMsg = new cwt();
    localbwz.GQW = paramLinkedList;
    localbwz.GQV = 10;
    localbwz.dyz = paramFloat1;
    localbwz.dAp = paramFloat2;
    localbwz.xze = paramLong1;
    localbwz.GQY = paramLong2;
    localbwz.GQX = paramInt;
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bx.a)localbwz);
    paramLinkedList.d((com.tencent.mm.bx.a)localbxa);
    paramLinkedList.Dl("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.oP(3859);
    c(paramLinkedList.aDC());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */