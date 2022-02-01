package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/config/CaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-recordvideo_release"})
public final class c
  implements Serializable
{
  public int hlJ;
  public boolean htP;
  public String xwP;
  public String xwQ;
  public long xwR;
  public long xwS;
  public boolean xwT;
  public int xwU;
  public AudioCacheInfo xwV;
  public ArrayList<String> xwW;
  
  public c()
  {
    AppMethodBeat.i(75368);
    this.xwP = "";
    this.xwQ = "";
    this.xwW = new ArrayList();
    AppMethodBeat.o(75368);
  }
  
  public final void aq(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(75366);
    p.h(paramArrayList, "<set-?>");
    this.xwW = paramArrayList;
    AppMethodBeat.o(75366);
  }
  
  public final void avH(String paramString)
  {
    AppMethodBeat.i(75364);
    p.h(paramString, "<set-?>");
    this.xwP = paramString;
    AppMethodBeat.o(75364);
  }
  
  public final void avI(String paramString)
  {
    AppMethodBeat.i(75365);
    p.h(paramString, "<set-?>");
    this.xwQ = paramString;
    AppMethodBeat.o(75365);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(75367);
    String str = "CaptureInfo(sourceVideoPath='" + this.xwP + "', sourceThumb='" + this.xwQ + "', remuxStart=" + this.xwR + ", remuxEnd=" + this.xwS + ", isCaptureVideo=" + this.htP + ", audioMixType=" + this.xwU + ", audioInfo=" + this.xwV + ", videoRotate=" + this.hlJ + ')';
    AppMethodBeat.o(75367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */