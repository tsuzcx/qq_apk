package com.tencent.mm.plugin.story.e;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import java.io.Serializable;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "Ljava/io/Serializable;", "()V", "audioInfo", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "getAudioInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "setAudioInfo", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "audioMixType", "", "getAudioMixType", "()I", "setAudioMixType", "(I)V", "fakeVideoImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFakeVideoImageList", "()Ljava/util/ArrayList;", "setFakeVideoImageList", "(Ljava/util/ArrayList;)V", "isCaptureVideo", "", "()Z", "setCaptureVideo", "(Z)V", "isPhotoToVideo", "setPhotoToVideo", "recordThumb", "getRecordThumb", "()Ljava/lang/String;", "setRecordThumb", "(Ljava/lang/String;)V", "recordVideo", "getRecordVideo", "setRecordVideo", "remuxEnd", "", "getRemuxEnd", "()J", "setRemuxEnd", "(J)V", "remuxStart", "getRemuxStart", "setRemuxStart", "videoRotate", "getVideoRotate", "setVideoRotate", "reset", "", "toString", "plugin-story_release"})
public final class a
  implements Serializable
{
  public int eWL;
  public boolean fbp;
  public String ssl;
  public String ssm;
  public long ssn;
  public long sso;
  public boolean ssp;
  public int ssq;
  public AudioCacheInfo ssr;
  public ArrayList<String> sss;
  
  public a()
  {
    AppMethodBeat.i(150991);
    this.ssl = "";
    this.ssm = "";
    this.sss = new ArrayList();
    AppMethodBeat.o(150991);
  }
  
  public final void acH(String paramString)
  {
    AppMethodBeat.i(108986);
    j.q(paramString, "<set-?>");
    this.ssl = paramString;
    AppMethodBeat.o(108986);
  }
  
  public final void acI(String paramString)
  {
    AppMethodBeat.i(108987);
    j.q(paramString, "<set-?>");
    this.ssm = paramString;
    AppMethodBeat.o(108987);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(150989);
    this.ssq = 0;
    this.ssr = null;
    this.ssl = "";
    this.ssm = "";
    this.ssn = 0L;
    this.sso = 0L;
    this.eWL = 0;
    this.fbp = false;
    this.ssp = false;
    this.sss.clear();
    AppMethodBeat.o(150989);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150990);
    String str = "StoryCaptureInfo(sourceVideoPath='" + this.ssl + "', sourceThumb='" + this.ssm + "', remuxStart=" + this.ssn + ", remuxEnd=" + this.sso + ", isCaptureVideo=" + this.fbp + ", audioMixType=" + this.ssq + ", audioInfo=" + this.ssr + ", videoRotate=" + this.eWL + ')';
    AppMethodBeat.o(150990);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.e.a
 * JD-Core Version:    0.7.0.1
 */