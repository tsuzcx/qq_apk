package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.o;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "cacheAudioWithLifcycle", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cancelCache", "Companion", "plugin-recordvideo_release"})
public final class i
{
  private static final i xPH;
  public static final i.a xPI;
  private final String TAG;
  private final Map<Integer, b> xPG;
  
  static
  {
    AppMethodBeat.i(75446);
    xPI = new i.a((byte)0);
    xPH = new i();
    AppMethodBeat.o(75446);
  }
  
  public i()
  {
    AppMethodBeat.i(75445);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.xPG = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(75445);
  }
  
  private void a(com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo, final m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(75443);
    p.h(paramAudioCacheInfo, "info");
    ae.i(this.TAG, "cache audio " + paramAudioCacheInfo.xOV);
    b localb = (b)this.xPG.get(Integer.valueOf(paramAudioCacheInfo.xOV));
    if (localb == null)
    {
      if (!o.fB(paramAudioCacheInfo.cachePath))
      {
        paramb = new b(paramb, paramAudioCacheInfo);
        paramb.e((m)new b(this, paramAudioCacheInfo, paramm));
        paramb.start();
        paramm = this.xPG;
        p.g(paramm, "audioTaskMap");
        paramm.put(Integer.valueOf(paramAudioCacheInfo.xOV), paramb);
        AppMethodBeat.o(75443);
        return;
      }
      if (paramm != null)
      {
        paramm.p(Boolean.TRUE, paramAudioCacheInfo.cachePath);
        AppMethodBeat.o(75443);
        return;
      }
      AppMethodBeat.o(75443);
      return;
    }
    localb.e(paramm);
    AppMethodBeat.o(75443);
  }
  
  public final void a(Context paramContext, AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(75441);
    p.h(paramContext, "context");
    p.h(paramAudioCacheInfo, "info");
    ae.i(this.TAG, "cacheAudio: ".concat(String.valueOf(paramContext)));
    if ((paramContext instanceof MMFragmentActivity))
    {
      a((com.tencent.mm.vending.e.b)paramContext, paramAudioCacheInfo, paramm);
      AppMethodBeat.o(75441);
      return;
    }
    ae.w(this.TAG, "context is not LifeCycle: ".concat(String.valueOf(paramContext)));
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75441);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75444);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.xPG.remove(Integer.valueOf(paramAudioCacheInfo.xOV));
      if (paramAudioCacheInfo != null)
      {
        paramAudioCacheInfo.cancel();
        AppMethodBeat.o(75444);
        return;
      }
    }
    AppMethodBeat.o(75444);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, z> paramm)
  {
    AppMethodBeat.i(75440);
    p.h(paramAudioCacheInfo, "info");
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75440);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "filePath", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, String, z>
  {
    b(i parami, AudioCacheInfo paramAudioCacheInfo, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.i
 * JD-Core Version:    0.7.0.1
 */