package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public int hoy;
  public boolean hwD;
  public String xMM;
  public String xMN;
  public long xMO;
  public long xMP;
  public boolean xMQ;
  public int xMR;
  public AudioCacheInfo xMS;
  public ArrayList<String> xMT;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.xMM = "";
    this.xMN = "";
    this.xMT = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void ar(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    p.h(paramArrayList, "<set-?>");
    this.xMT = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final void awW(String paramString)
  {
    AppMethodBeat.i(75364);
    p.h(paramString, "<set-?>");
    this.xMM = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void awX(String paramString)
  {
    AppMethodBeat.i(75365);
    p.h(paramString, "<set-?>");
    this.xMN = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.xMM + "', sourceThumb='" + this.xMN + "', remuxStart=" + this.xMO + ", remuxEnd=" + this.xMP + ", isCaptureVideo=" + this.hwD + ", audioMixType=" + this.xMR + ", audioInfo=" + this.xMS + ", videoRotate=" + this.hoy + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */