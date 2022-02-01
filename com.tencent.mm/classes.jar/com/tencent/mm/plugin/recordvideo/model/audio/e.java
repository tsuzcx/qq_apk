package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.dqi;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends c<clm>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    cll localcll = new cll();
    clm localclm = new clm();
    localclm.setBaseResponse(new BaseResponse());
    localclm.getBaseResponse().ErrMsg = new dqi();
    localcll.MqL = paramLinkedList;
    localcll.MqK = 10;
    localcll.latitude = paramFloat1;
    localcll.dTj = paramFloat2;
    localcll.BPd = paramLong1;
    localcll.MqN = paramLong2;
    localcll.MqM = paramInt;
    paramLinkedList = new d.a();
    paramLinkedList.c((a)localcll);
    paramLinkedList.d((a)localclm);
    paramLinkedList.MB("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.sG(3859);
    c(paramLinkedList.aXF());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */