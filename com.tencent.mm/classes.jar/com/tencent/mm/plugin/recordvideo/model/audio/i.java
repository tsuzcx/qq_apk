package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.p;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.source.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vending.e.a;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cacheAudioWithLifcycle", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cancelCache", "Companion", "plugin-recordvideo_release"})
public final class i
{
  private static final i vji;
  public static final a vjj;
  private final String TAG;
  private final Map<Integer, b> vjh;
  
  static
  {
    AppMethodBeat.i(75446);
    vjj = new a((byte)0);
    vji = new i();
    AppMethodBeat.o(75446);
  }
  
  public i()
  {
    AppMethodBeat.i(75445);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.vjh = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(75445);
  }
  
  private void a(com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo, final m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(75443);
    k.h(paramAudioCacheInfo, "info");
    ad.i(this.TAG, "cache audio " + paramAudioCacheInfo.viz);
    b localb = (b)this.vjh.get(Integer.valueOf(paramAudioCacheInfo.viz));
    if (localb == null)
    {
      if (!com.tencent.mm.vfs.i.eK(paramAudioCacheInfo.cachePath))
      {
        paramb = new b(paramb, paramAudioCacheInfo);
        paramb.d((m)new b(this, paramAudioCacheInfo, paramm));
        paramb.start();
        paramm = this.vjh;
        k.g(paramm, "audioTaskMap");
        paramm.put(Integer.valueOf(paramAudioCacheInfo.viz), paramb);
        AppMethodBeat.o(75443);
        return;
      }
      if (paramm != null)
      {
        paramm.n(Boolean.TRUE, paramAudioCacheInfo.cachePath);
        AppMethodBeat.o(75443);
        return;
      }
      AppMethodBeat.o(75443);
      return;
    }
    localb.d(paramm);
    AppMethodBeat.o(75443);
  }
  
  public final void a(Context paramContext, AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(75441);
    k.h(paramContext, "context");
    k.h(paramAudioCacheInfo, "info");
    ad.i(this.TAG, "cacheAudio: ".concat(String.valueOf(paramContext)));
    if ((paramContext instanceof MMFragmentActivity))
    {
      a((com.tencent.mm.vending.e.b)paramContext, paramAudioCacheInfo, paramm);
      AppMethodBeat.o(75441);
      return;
    }
    ad.w(this.TAG, "context is not LifeCycle: ".concat(String.valueOf(paramContext)));
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75441);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75444);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.vjh.remove(Integer.valueOf(paramAudioCacheInfo.viz));
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.cancel();
        AppMethodBeat.o(75444);
        return;
      }
    }
    AppMethodBeat.o(75444);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, y> paramm)
  {
    AppMethodBeat.i(75440);
    k.h(paramAudioCacheInfo, "info");
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75440);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager$Companion;", "", "()V", "instance", "Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "getInstance", "()Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "createSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "userAgent", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public static j a(AudioCacheInfo paramAudioCacheInfo, String paramString)
    {
      AppMethodBeat.i(75438);
      k.h(paramAudioCacheInfo, "cacheInfo");
      k.h(paramString, "userAgent");
      if (paramAudioCacheInfo.aMb)
      {
        paramAudioCacheInfo = (j)new com.google.android.exoplayer2.source.h(Uri.parse(paramAudioCacheInfo.cachePath), (g.a)new r(), (com.google.android.exoplayer2.c.h)new c(), null, null);
        AppMethodBeat.o(75438);
        return paramAudioCacheInfo;
      }
      paramAudioCacheInfo = (j)new com.google.android.exoplayer2.source.h(Uri.parse(paramAudioCacheInfo.musicUrl), (g.a)new p(paramString), (com.google.android.exoplayer2.c.h)new c(), null, null);
      AppMethodBeat.o(75438);
      return paramAudioCacheInfo;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements m<Boolean, String, y>
  {
    b(i parami, AudioCacheInfo paramAudioCacheInfo, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.i
 * JD-Core Version:    0.7.0.1
 */