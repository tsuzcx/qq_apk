package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "TAG", "", "callbacks", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "", "kotlin.jvm.PlatformType", "", "getInfo", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "mediaId", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "addCallback", "cb", "cancel", "dead", "notifyCallbacks", "start", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private final AudioCacheInfo NJb;
  private final String TAG;
  private final List<m<Boolean, String, ah>> bPE;
  private final String mediaId;
  private final com.tencent.mm.vending.e.b<a> mjD;
  private final com.tencent.mm.g.g ozc;
  
  public b(com.tencent.mm.vending.e.b<a> paramb, AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75414);
    this.mjD = paramb;
    this.NJb = paramAudioCacheInfo;
    this.TAG = "MicroMsg.AudioDownloadTask";
    this.bPE = Collections.synchronizedList((List)new ArrayList());
    paramb = s.X(this.NJb.cachePath, "_temp");
    paramAudioCacheInfo = this.NJb.cachePath;
    f localf = f.Obq;
    f.aTB(paramb);
    if (paramAudioCacheInfo != null)
    {
      localf = f.Obq;
      f.aTB(paramAudioCacheInfo);
    }
    this.mediaId = s.X("downaudio_", Integer.valueOf(this.NJb.NID));
    this.ozc = new com.tencent.mm.g.g();
    this.ozc.taskName = "task_AudioDownloadTask";
    this.ozc.lwP = 60;
    this.ozc.lwQ = 60;
    this.ozc.field_mediaId = this.mediaId;
    this.ozc.lwO = this.NJb.musicUrl;
    this.ozc.field_fileType = 40001;
    this.ozc.field_fullpath = paramb;
    this.ozc.field_aesKey = this.NJb.decodeKey;
    this.ozc.lwL = ((g.a)new b.1(this, paramAudioCacheInfo, paramb));
    AppMethodBeat.o(75414);
  }
  
  private final void at(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(75413);
    ??? = this.bPE;
    s.s(???, "callbacks");
    synchronized ((Iterable)???)
    {
      Iterator localIterator = ((Iterable)???).iterator();
      if (localIterator.hasNext()) {
        ((m)localIterator.next()).invoke(Boolean.valueOf(paramBoolean), paramString);
      }
    }
    paramString = ah.aiuX;
    this.bPE.clear();
    AppMethodBeat.o(75413);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(75411);
    Log.i(this.TAG, s.X("cancel ", this.mediaId));
    com.tencent.mm.modelcdntran.k.bHW().Nz(this.mediaId);
    this.bPE.clear();
    AppMethodBeat.o(75411);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(75412);
    k.a locala = k.NJr;
    k.gIk().c(this.NJb);
    AppMethodBeat.o(75412);
  }
  
  public final void r(m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(75410);
    if (paramm != null) {
      this.bPE.add(paramm);
    }
    AppMethodBeat.o(75410);
  }
  
  public final void start()
  {
    AppMethodBeat.i(75409);
    if (!com.tencent.mm.modelcdntran.k.bHW().b(this.ozc, -1))
    {
      at(false, null);
      AppMethodBeat.o(75409);
      return;
    }
    com.tencent.mm.vending.e.b localb = this.mjD;
    if (localb != null) {
      localb.keep((a)this);
    }
    AppMethodBeat.o(75409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.b
 * JD-Core Version:    0.7.0.1
 */