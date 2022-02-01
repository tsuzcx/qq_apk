package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.crm;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends c<bsn>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    bsm localbsm = new bsm();
    bsn localbsn = new bsn();
    localbsn.setBaseResponse(new BaseResponse());
    localbsn.getBaseResponse().ErrMsg = new crm();
    localbsm.Fhu = paramLinkedList;
    localbsm.Fht = 10;
    localbsm.dmL = paramFloat1;
    localbsm.doB = paramFloat2;
    localbsm.wrn = paramLong1;
    localbsm.Fhw = paramLong2;
    localbsm.Fhv = paramInt;
    paramLinkedList = new b.a();
    paramLinkedList.c((a)localbsm);
    paramLinkedList.d((a)localbsn);
    paramLinkedList.Am("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.op(3859);
    c(paramLinkedList.aAz());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */