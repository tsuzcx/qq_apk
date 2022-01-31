package com.tencent.mm.plugin.story.model.audio;

import a.f.a.m;
import a.f.b.j;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/audio/AudioDownloadTask;", "", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "notifyCallbacks", "start", "plugin-story_release"})
public final class b
{
  final String TAG;
  private final String cBO;
  private final List<m<Boolean, String, y>> callbacks;
  private final g swD;
  private final AudioCacheInfo swE;
  
  public b(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109184);
    this.swE = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramAudioCacheInfo = this.swE.cachePath + "_temp";
    String str = this.swE.cachePath;
    com.tencent.mm.plugin.story.model.l locall = com.tencent.mm.plugin.story.model.l.svv;
    com.tencent.mm.plugin.story.model.l.adc(paramAudioCacheInfo);
    if (str != null)
    {
      locall = com.tencent.mm.plugin.story.model.l.svv;
      com.tencent.mm.plugin.story.model.l.adc(str);
    }
    this.cBO = ("downaudio_" + this.swE.swp);
    this.swD = new g();
    this.swD.edt = 60;
    this.swD.edu = 60;
    this.swD.field_mediaId = this.cBO;
    this.swD.eds = this.swE.musicUrl;
    this.swD.field_fileType = 40001;
    this.swD.field_fullpath = paramAudioCacheInfo;
    this.swD.edp = ((g.a)new b.1(this, str, paramAudioCacheInfo));
    AppMethodBeat.o(109184);
  }
  
  private final void u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(109183);
    ??? = this.callbacks;
    j.p(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).h(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = y.BMg;
    this.callbacks.clear();
    AppMethodBeat.o(109183);
  }
  
  public final void a(m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(109181);
    if (paramm != null) {
      this.callbacks.add(paramm);
    }
    AppMethodBeat.o(109181);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(109182);
    ab.i(this.TAG, "cancel " + this.cBO);
    f.afO().sJ(this.cBO);
    this.callbacks.clear();
    AppMethodBeat.o(109182);
  }
  
  public final void start()
  {
    AppMethodBeat.i(109180);
    if (!f.afO().d(this.swD)) {
      u(false, null);
    }
    AppMethodBeat.o(109180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.audio.b
 * JD-Core Version:    0.7.0.1
 */