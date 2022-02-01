package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.am.b<dlp>
{
  private e(LinkedList<com.tencent.mm.bx.b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    dlo localdlo = new dlo();
    dlp localdlp = new dlp();
    localdlp.setBaseResponse(new kd());
    localdlp.getBaseResponse().akjO = new etl();
    localdlo.aaRF = paramLinkedList;
    localdlo.aaRE = 10;
    localdlo.latitude = paramFloat1;
    localdlo.longitude = paramFloat2;
    localdlo.NII = paramLong1;
    localdlo.aaRH = paramLong2;
    localdlo.aaRG = paramInt;
    paramLinkedList = new c.a();
    paramLinkedList.otE = ((a)localdlo);
    paramLinkedList.otF = ((a)localdlp);
    paramLinkedList.uri = "/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist";
    paramLinkedList.funcId = 3859;
    c(paramLinkedList.bEF());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */