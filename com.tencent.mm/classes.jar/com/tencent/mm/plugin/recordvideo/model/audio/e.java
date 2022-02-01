package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.cmf;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e
  extends c<bnx>
{
  private e(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(75422);
    bnw localbnw = new bnw();
    bnx localbnx = new bnx();
    localbnx.setBaseResponse(new BaseResponse());
    localbnx.getBaseResponse().ErrMsg = new cmf();
    localbnw.DLf = paramLinkedList;
    localbnw.DLe = 10;
    localbnw.dpb = paramFloat1;
    localbnw.dqQ = paramFloat2;
    localbnw.viE = paramLong1;
    localbnw.DLh = paramLong2;
    localbnw.DLg = paramInt;
    paramLinkedList = new b.a();
    paramLinkedList.c((a)localbnw);
    paramLinkedList.d((a)localbnx);
    paramLinkedList.wg("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
    paramLinkedList.nB(3859);
    c(paramLinkedList.atI());
    AppMethodBeat.o(75422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.e
 * JD-Core Version:    0.7.0.1
 */