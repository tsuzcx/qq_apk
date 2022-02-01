package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cacheAudioWithLifcycle", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cancelCache", "Companion", "plugin-recordvideo_release"})
public final class k
{
  private static final k HMw;
  public static final a HMx;
  private final Map<Integer, b> HMv;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(75446);
    HMx = new a((byte)0);
    HMw = new k();
    AppMethodBeat.o(75446);
  }
  
  public k()
  {
    AppMethodBeat.i(75445);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.HMv = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(75445);
  }
  
  private void a(com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo, final m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75443);
    kotlin.g.b.p.k(paramAudioCacheInfo, "info");
    Log.i(this.TAG, "cache audio " + paramAudioCacheInfo.HLC);
    if (((CharSequence)paramAudioCacheInfo.decodeKey).length() == 0) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = (b)this.HMv.get(Integer.valueOf(paramAudioCacheInfo.HLC));
      if (localObject == null)
      {
        if (!u.agG(paramAudioCacheInfo.cachePath))
        {
          paramb = new b(paramb, paramAudioCacheInfo);
          paramb.h((m)new b(this, paramm, paramAudioCacheInfo));
          paramb.start();
          paramm = this.HMv;
          kotlin.g.b.p.j(paramm, "audioTaskMap");
          paramm.put(Integer.valueOf(paramAudioCacheInfo.HLC), paramb);
          AppMethodBeat.o(75443);
          return;
          i = 0;
        }
        else
        {
          Log.i(this.TAG, "cacheAudio is exist " + paramAudioCacheInfo.cachePath);
          if (paramm != null)
          {
            paramm.invoke(Boolean.TRUE, paramAudioCacheInfo.cachePath);
            AppMethodBeat.o(75443);
            return;
          }
          AppMethodBeat.o(75443);
        }
      }
      else
      {
        ((b)localObject).h(paramm);
        AppMethodBeat.o(75443);
        return;
      }
    }
    if ((u.agG(paramAudioCacheInfo.cachePath)) && (u.bBQ(paramAudioCacheInfo.cachePath) > 0L) && (paramAudioCacheInfo.aGs))
    {
      Log.i(this.TAG, "info is cached, directly invoke callback success");
      if (paramm != null)
      {
        paramm.invoke(Boolean.TRUE, paramAudioCacheInfo.cachePath);
        AppMethodBeat.o(75443);
        return;
      }
      AppMethodBeat.o(75443);
      return;
    }
    Log.i(this.TAG, "info is not cached, start download");
    paramb = paramAudioCacheInfo.musicUrl;
    if (paramb == null) {
      kotlin.g.b.p.iCn();
    }
    int i = paramAudioCacheInfo.HLC;
    Object localObject = paramAudioCacheInfo.cachePath;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    paramb = new com.tencent.mm.plugin.thumbplayer.e.d(String.valueOf(i), (String)localObject, paramb, 0, 0);
    paramb.decodeKey = paramAudioCacheInfo.decodeKey;
    if (paramAudioCacheInfo.HLJ) {
      paramb.videoFlag = "A0";
    }
    localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    localObject = d.a.iA((Context)localObject);
    ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMute(true);
    ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).ALj = true;
    ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMediaInfo(paramb);
    paramb = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).MSQ;
    if (paramb != null) {
      paramb.MTi = ((m)new c(this, (com.tencent.mm.plugin.thumbplayer.f.b)localObject, paramm, paramAudioCacheInfo));
    }
    ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).gos();
    AppMethodBeat.o(75443);
  }
  
  public final void a(Context paramContext, AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75441);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramAudioCacheInfo, "info");
    Log.i(this.TAG, "cacheAudio: " + paramContext + ", false");
    if ((paramContext instanceof MMFragmentActivity))
    {
      a((com.tencent.mm.vending.e.b)paramContext, paramAudioCacheInfo, paramm);
      AppMethodBeat.o(75441);
      return;
    }
    Log.w(this.TAG, "context is not LifeCycle: ".concat(String.valueOf(paramContext)));
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75441);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75440);
    kotlin.g.b.p.k(paramAudioCacheInfo, "info");
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75440);
  }
  
  public final void c(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75444);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.HMv.remove(Integer.valueOf(paramAudioCacheInfo.HLC));
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.cancel();
        AppMethodBeat.o(75444);
        return;
      }
    }
    AppMethodBeat.o(75444);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public static com.google.android.exoplayer2.source.k a(AudioCacheInfo paramAudioCacheInfo, String paramString)
    {
      AppMethodBeat.i(75438);
      kotlin.g.b.p.k(paramAudioCacheInfo, "cacheInfo");
      kotlin.g.b.p.k(paramString, "userAgent");
      if (paramAudioCacheInfo.aGs)
      {
        paramAudioCacheInfo = (com.google.android.exoplayer2.source.k)new com.google.android.exoplayer2.source.h(Uri.parse(u.n(paramAudioCacheInfo.cachePath, false)), (g.a)new r(), (com.google.android.exoplayer2.c.h)new c(), null, null);
        AppMethodBeat.o(75438);
        return paramAudioCacheInfo;
      }
      paramAudioCacheInfo = (com.google.android.exoplayer2.source.k)new com.google.android.exoplayer2.source.h(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new com.google.android.exoplayer2.h.p(paramString), (com.google.android.exoplayer2.c.h)new c(), null, null);
      AppMethodBeat.o(75438);
      return paramAudioCacheInfo;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, String, x>
  {
    b(k paramk, m paramm, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "ret", "", "invoke"})
  static final class c
    extends q
    implements m<String, Integer, x>
  {
    c(k paramk, com.tencent.mm.plugin.thumbplayer.f.b paramb, m paramm, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.k
 * JD-Core Version:    0.7.0.1
 */