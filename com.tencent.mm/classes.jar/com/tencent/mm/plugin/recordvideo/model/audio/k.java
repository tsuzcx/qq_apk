package com.tencent.mm.plugin.recordvideo.model.audio;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/audio/StoryAudioManager;", "", "()V", "TAG", "", "audioTaskMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioDownloadTask;", "", "cacheAudio", "", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "filePath", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "cacheAudioAsync", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheAudioWithLifcycle", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "cancelCache", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a NJr;
  private static final k NJt;
  private final Map<Integer, b> NJs;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(75446);
    NJr = new k.a((byte)0);
    NJt = new k();
    AppMethodBeat.o(75446);
  }
  
  public k()
  {
    AppMethodBeat.i(75445);
    this.TAG = "MicroMsg.StoryAudioManager";
    this.NJs = Collections.synchronizedMap((Map)new HashMap());
    AppMethodBeat.o(75445);
  }
  
  private void a(com.tencent.mm.vending.e.b<a> paramb, final AudioCacheInfo paramAudioCacheInfo, final m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(75443);
    s.u(paramAudioCacheInfo, "info");
    Log.i(this.TAG, s.X("cache audio ", Integer.valueOf(paramAudioCacheInfo.NID)));
    int i;
    if (((CharSequence)paramAudioCacheInfo.decodeKey).length() == 0) {
      i = 1;
    }
    Object localObject;
    while (i != 0)
    {
      localObject = (b)this.NJs.get(Integer.valueOf(paramAudioCacheInfo.NID));
      if (localObject == null)
      {
        if (!y.ZC(paramAudioCacheInfo.cachePath))
        {
          paramb = new b(paramb, paramAudioCacheInfo);
          paramb.r((m)new d(this, paramm, paramAudioCacheInfo));
          paramb.start();
          paramm = this.NJs;
          s.s(paramm, "audioTaskMap");
          paramm.put(Integer.valueOf(paramAudioCacheInfo.NID), paramb);
          AppMethodBeat.o(75443);
          return;
          i = 0;
        }
        else
        {
          Log.i(this.TAG, s.X("cacheAudio is exist ", paramAudioCacheInfo.cachePath));
          if (paramm == null) {
            break label352;
          }
          paramm.invoke(Boolean.TRUE, paramAudioCacheInfo.cachePath);
          AppMethodBeat.o(75443);
        }
      }
      else
      {
        ((b)localObject).r(paramm);
        AppMethodBeat.o(75443);
        return;
      }
    }
    if ((y.ZC(paramAudioCacheInfo.cachePath)) && (y.bEl(paramAudioCacheInfo.cachePath) > 0L) && (paramAudioCacheInfo.cached))
    {
      Log.i(this.TAG, "info is cached, directly invoke callback success");
      if (paramm != null)
      {
        paramm.invoke(Boolean.TRUE, paramAudioCacheInfo.cachePath);
        AppMethodBeat.o(75443);
      }
    }
    else
    {
      Log.i(this.TAG, "info is not cached, start download");
      paramb = paramAudioCacheInfo.musicUrl;
      s.checkNotNull(paramb);
      i = paramAudioCacheInfo.NID;
      localObject = paramAudioCacheInfo.cachePath;
      s.checkNotNull(localObject);
      paramb = new com.tencent.mm.plugin.thumbplayer.a.b(String.valueOf(i), (String)localObject, paramb, 0, 0);
      paramb.decodeKey = paramAudioCacheInfo.decodeKey;
      if (paramAudioCacheInfo.NIJ) {
        paramb.videoFlag = "A0";
      }
      a(paramb, paramm);
    }
    label352:
    AppMethodBeat.o(75443);
  }
  
  public final void a(Context paramContext, AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(75441);
    s.u(paramContext, "context");
    s.u(paramAudioCacheInfo, "info");
    Log.i(this.TAG, "cacheAudio: " + paramContext + ", false");
    if ((paramContext instanceof MMFragmentActivity))
    {
      a((com.tencent.mm.vending.e.b)paramContext, paramAudioCacheInfo, paramm);
      AppMethodBeat.o(75441);
      return;
    }
    Log.w(this.TAG, s.X("context is not LifeCycle: ", paramContext));
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75441);
  }
  
  public final void a(AudioCacheInfo paramAudioCacheInfo, m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(75440);
    s.u(paramAudioCacheInfo, "info");
    a(null, paramAudioCacheInfo, paramm);
    AppMethodBeat.o(75440);
  }
  
  public final void a(final com.tencent.mm.plugin.thumbplayer.a.b paramb, final m<? super Boolean, ? super String, ah> paramm)
  {
    AppMethodBeat.i(279651);
    s.u(paramb, "mediaInfo");
    Object localObject = d.TFK;
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    localObject = d.a.ks((Context)localObject);
    ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMute(true);
    ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flr = true;
    ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMediaInfo(paramb);
    b.b localb = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).TFd;
    if (localb != null) {
      localb.TFy = ((m)new b(this, (com.tencent.mm.plugin.thumbplayer.e.b)localObject, paramm, paramb));
    }
    ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).hLh();
    AppMethodBeat.o(279651);
  }
  
  public final void c(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(75444);
    if (paramAudioCacheInfo != null)
    {
      paramAudioCacheInfo = (b)this.NJs.remove(Integer.valueOf(paramAudioCacheInfo.NID));
      if (paramAudioCacheInfo != null) {
        paramAudioCacheInfo.cancel();
      }
    }
    AppMethodBeat.o(75444);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "ret", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<String, Integer, ah>
  {
    b(k paramk, com.tencent.mm.plugin.thumbplayer.e.b paramb, m<? super Boolean, ? super String, ah> paramm, com.tencent.mm.plugin.thumbplayer.a.b paramb1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "filePath", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, String, ah>
  {
    d(k paramk, m<? super Boolean, ? super String, ah> paramm, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.k
 * JD-Core Version:    0.7.0.1
 */