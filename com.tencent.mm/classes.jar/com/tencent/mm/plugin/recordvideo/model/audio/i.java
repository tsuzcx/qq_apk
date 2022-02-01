package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cacheAudioWithLifcycle", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cancelCache", "Companion", "plugin-recordvideo_release"})
public final class i
{
  private static final i BPK;
  public static final i.a BPL;
  private final Map<Integer, b> BPJ;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(75446);
    BPL = new i.a((byte)0);
    BPK = new i();
    AppMethodBeat.o(75446);
  }
  
  public i()
  {
    AppMethodBeat.i(75445);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.BPJ = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(75445);
  }
  
  private void a(com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo, final m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75443);
    p.h(paramAudioCacheInfo, "info");
    Log.i(this.TAG, "cache audio " + paramAudioCacheInfo.BOX);
    b localb = (b)this.BPJ.get(Integer.valueOf(paramAudioCacheInfo.BOX));
    if (localb == null)
    {
      if (!s.YS(paramAudioCacheInfo.cachePath))
      {
        paramb = new b(paramb, paramAudioCacheInfo);
        paramb.h((m)new b(this, paramm, paramAudioCacheInfo));
        paramb.start();
        paramm = this.BPJ;
        p.g(paramm, "audioTaskMap");
        paramm.put(Integer.valueOf(paramAudioCacheInfo.BOX), paramb);
        AppMethodBeat.o(75443);
        return;
      }
      Log.i(this.TAG, "cacheAudio is exist " + paramAudioCacheInfo.cachePath);
      if (paramm != null)
      {
        paramm.invoke(Boolean.TRUE, paramAudioCacheInfo.cachePath);
        AppMethodBeat.o(75443);
        return;
      }
      AppMethodBeat.o(75443);
      return;
    }
    localb.h(paramm);
    AppMethodBeat.o(75443);
  }
  
  public final void a(Context paramContext, AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, x> paramm)
  {
    AppMethodBeat.i(75441);
    p.h(paramContext, "context");
    p.h(paramAudioCacheInfo, "info");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("cacheAudio: ").append(paramContext).append(", ");
    if (paramm == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      if (!(paramContext instanceof MMFragmentActivity)) {
        break;
      }
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
    p.h(paramAudioCacheInfo, "info");
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75440);
  }
  
  public final void c(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75444);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.BPJ.remove(Integer.valueOf(paramAudioCacheInfo.BOX));
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.cancel();
        AppMethodBeat.o(75444);
        return;
      }
    }
    AppMethodBeat.o(75444);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, String, x>
  {
    b(i parami, m paramm, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.i
 * JD-Core Version:    0.7.0.1
 */