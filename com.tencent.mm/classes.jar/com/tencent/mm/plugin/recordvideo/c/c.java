package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements Serializable
{
  public AudioCacheInfo EEx;
  public long NGA;
  public boolean NGB;
  public int NGC;
  public ArrayList<String> NGD;
  public String NGx;
  public String NGy;
  public long NGz;
  public int nCg;
  public boolean nJW;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.NGx = "";
    this.NGy = "";
    this.NGD = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void aSY(String paramString)
  {
    AppMethodBeat.i(75364);
    s.u(paramString, "<set-?>");
    this.NGx = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void aSZ(String paramString)
  {
    AppMethodBeat.i(75365);
    s.u(paramString, "<set-?>");
    this.NGy = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.NGx + "', sourceThumb='" + this.NGy + "', remuxStart=" + this.NGz + ", remuxEnd=" + this.NGA + ", isCaptureVideo=" + this.nJW + ", audioMixType=" + this.NGC + ", audioInfo=" + this.EEx + ", videoRotate=" + this.nCg + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.c
 * JD-Core Version:    0.7.0.1
 */