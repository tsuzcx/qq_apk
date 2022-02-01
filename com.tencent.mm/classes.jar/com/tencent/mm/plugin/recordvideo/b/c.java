package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public boolean gBl;
  public int gta;
  public String vgn;
  public String vgo;
  public long vgp;
  public long vgq;
  public boolean vgr;
  public int vgs;
  public AudioCacheInfo vgt;
  public ArrayList<String> vgu;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.vgn = "";
    this.vgo = "";
    this.vgu = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void ah(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    k.h(paramArrayList, "<set-?>");
    this.vgu = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final void alI(String paramString)
  {
    AppMethodBeat.i(75364);
    k.h(paramString, "<set-?>");
    this.vgn = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void alJ(String paramString)
  {
    AppMethodBeat.i(75365);
    k.h(paramString, "<set-?>");
    this.vgo = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.vgn + "', sourceThumb='" + this.vgo + "', remuxStart=" + this.vgp + ", remuxEnd=" + this.vgq + ", isCaptureVideo=" + this.gBl + ", audioMixType=" + this.vgs + ", audioInfo=" + this.vgt + ", videoRotate=" + this.gta + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */