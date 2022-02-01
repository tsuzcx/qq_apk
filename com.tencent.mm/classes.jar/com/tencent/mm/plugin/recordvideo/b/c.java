package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public int gTI;
  public boolean hbH;
  public String woZ;
  public String wpa;
  public long wpb;
  public long wpc;
  public boolean wpd;
  public int wpe;
  public AudioCacheInfo wpf;
  public ArrayList<String> wpg;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.woZ = "";
    this.wpa = "";
    this.wpg = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void aqH(String paramString)
  {
    AppMethodBeat.i(75364);
    k.h(paramString, "<set-?>");
    this.woZ = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void aqI(String paramString)
  {
    AppMethodBeat.i(75365);
    k.h(paramString, "<set-?>");
    this.wpa = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final void as(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    k.h(paramArrayList, "<set-?>");
    this.wpg = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.woZ + "', sourceThumb='" + this.wpa + "', remuxStart=" + this.wpb + ", remuxEnd=" + this.wpc + ", isCaptureVideo=" + this.hbH + ", audioMixType=" + this.wpe + ", audioInfo=" + this.wpf + ", videoRotate=" + this.gTI + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */