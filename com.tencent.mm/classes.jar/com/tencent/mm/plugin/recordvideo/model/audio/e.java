package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.cxn;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.ak.a<bxu>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    bxt localbxt = new bxt();
    bxu localbxu = new bxu();
    localbxu.setBaseResponse(new BaseResponse());
    localbxu.getBaseResponse().ErrMsg = new cxn();
    localbxt.Hkx = paramLinkedList;
    localbxt.Hkw = 10;
    localbxt.dzE = paramFloat1;
    localbxt.dBu = paramFloat2;
    localbxt.xPa = paramLong1;
    localbxt.Hkz = paramLong2;
    localbxt.Hky = paramInt;
    paramLinkedList = new b.a();
    paramLinkedList.c((com.tencent.mm.bw.a)localbxt);
    paramLinkedList.d((com.tencent.mm.bw.a)localbxu);
    paramLinkedList.DN("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.oS(3859);
    c(paramLinkedList.aDS());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */