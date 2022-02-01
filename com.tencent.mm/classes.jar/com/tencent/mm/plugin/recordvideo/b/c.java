package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public long HJA;
  public long HJB;
  public boolean HJC;
  public int HJD;
  public ArrayList<String> HJE;
  public String HJy;
  public String HJz;
  public int kWG;
  public boolean lfl;
  public AudioCacheInfo zBD;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.HJy = "";
    this.HJz = "";
    this.HJE = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void aQ(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    p.k(paramArrayList, "<set-?>");
    this.HJE = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final void aVQ(String paramString)
  {
    AppMethodBeat.i(75364);
    p.k(paramString, "<set-?>");
    this.HJy = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void aVR(String paramString)
  {
    AppMethodBeat.i(75365);
    p.k(paramString, "<set-?>");
    this.HJz = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.HJy + "', sourceThumb='" + this.HJz + "', remuxStart=" + this.HJA + ", remuxEnd=" + this.HJB + ", isCaptureVideo=" + this.lfl + ", audioMixType=" + this.HJD + ", audioInfo=" + this.zBD + ", videoRotate=" + this.kWG + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */