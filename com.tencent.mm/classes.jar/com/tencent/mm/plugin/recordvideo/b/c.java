package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public String BMT;
  public String BMU;
  public long BMV;
  public long BMW;
  public boolean BMX;
  public int BMY;
  public ArrayList<String> BMZ;
  public int ihS;
  public boolean iqf;
  public AudioCacheInfo uPh;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.BMT = "";
    this.BMU = "";
    this.BMZ = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void aI(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    p.h(paramArrayList, "<set-?>");
    this.BMZ = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final void aLo(String paramString)
  {
    AppMethodBeat.i(75364);
    p.h(paramString, "<set-?>");
    this.BMT = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void aLp(String paramString)
  {
    AppMethodBeat.i(75365);
    p.h(paramString, "<set-?>");
    this.BMU = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.BMT + "', sourceThumb='" + this.BMU + "', remuxStart=" + this.BMV + ", remuxEnd=" + this.BMW + ", isCaptureVideo=" + this.iqf + ", audioMixType=" + this.BMY + ", audioInfo=" + this.uPh + ", videoRotate=" + this.ihS + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */