package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends c<cuj>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    cui localcui = new cui();
    cuj localcuj = new cuj();
    localcuj.setBaseResponse(new jh());
    localcuj.getBaseResponse().Tef = new eaf();
    localcui.TBZ = paramLinkedList;
    localcui.TBY = 10;
    localcui.latitude = paramFloat1;
    localcui.longitude = paramFloat2;
    localcui.HLI = paramLong1;
    localcui.TCb = paramLong2;
    localcui.TCa = paramInt;
    paramLinkedList = new d.a();
    paramLinkedList.c((a)localcui);
    paramLinkedList.d((a)localcuj);
    paramLinkedList.TW("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.vD(3859);
    c(paramLinkedList.bgN());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */