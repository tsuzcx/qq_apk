package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.e.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"})
public final class b
  implements a
{
  final String TAG;
  private final List<m<Boolean, String, y>> callbacks;
  private final com.tencent.mm.vending.e.b<a> fSt;
  private final String mediaId;
  private final g wrB;
  private final AudioCacheInfo wrC;
  
  public b(com.tencent.mm.vending.e.b<a> paramb, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.fSt = paramb;
    this.wrC = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.callbacks = Collections.synchronizedList((List)new ArrayList());
    paramb = this.wrC.cachePath + "_temp";
    paramAudioCacheInfo = this.wrC.cachePath;
    com.tencent.mm.plugin.recordvideo.e.b localb = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    com.tencent.mm.plugin.recordvideo.e.b.arb(paramb);
    if (paramAudioCacheInfo != null)
    {
      localb = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      com.tencent.mm.plugin.recordvideo.e.b.arb(paramAudioCacheInfo);
    }
    this.mediaId = ("downaudio_" + this.wrC.wri);
    this.wrB = new g();
    this.wrB.frf = 60;
    this.wrB.frg = 60;
    this.wrB.field_mediaId = this.mediaId;
    this.wrB.fre = this.wrC.musicUrl;
    this.wrB.field_fileType = 40001;
    this.wrB.field_fullpath = paramb;
    this.wrB.frb = ((g.a)new b.1(this, paramAudioCacheInfo, paramb));
    AppMethodBeat.o(75414);
  }
  
  private final void u(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.callbacks;
    k.g(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).n(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = y.KTp;
    this.callbacks.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    ac.i(this.TAG, "cancel " + this.mediaId);
    f.aDD().BR(this.mediaId);
    this.callbacks.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void d(m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(75410);
    if (paramm != null) {
      this.callbacks.add(paramm);
    }
    AppMethodBeat.o(75410);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    i.a locala = i.wrV;
    i.dvK().a(this.wrC);
    AppMethodBeat.o(75412);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75409);
    if (!f.aDD().e(this.wrB))
    {
      u(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.fSt;
    if (localb != null)
    {
      localb.keep((a)this);
      AppMethodBeat.o(75409);
      return;
    }
    AppMethodBeat.o(75409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b
 * JD-Core Version:    0.7.0.1
 */