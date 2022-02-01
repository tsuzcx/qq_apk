package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.thumbplayer.f.a;
import com.tencent.mm.plugin.thumbplayer.f.b.b;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "prepareAudio", "release", "resetAudio", "resumeAudio", "seekTo", "timeMs", "", "plugin-recordvideo_release"})
public final class b
{
  private com.tencent.mm.plugin.thumbplayer.f.b Ght;
  private final String TAG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.TAG = ("MicroMsg.EditMusicController" + hashCode());
    AppMethodBeat.o(75759);
  }
  
  public final void d(final AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(224899);
    pauseAudio();
    if (paramAudioCacheInfo == null)
    {
      AppMethodBeat.o(224899);
      return;
    }
    Object localObject2 = paramAudioCacheInfo.musicUrl;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i = paramAudioCacheInfo.HLC;
    String str = paramAudioCacheInfo.cachePath;
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d(String.valueOf(i), (String)localObject2, (String)localObject1, 0, 0);
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = paramAudioCacheInfo.aGs;
    ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).decodeKey = paramAudioCacheInfo.decodeKey;
    if (paramAudioCacheInfo.HLJ) {
      ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).videoFlag = "A0";
    }
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).stop();
    }
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).recycle();
    }
    localObject2 = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    this.Ght = d.a.iA((Context)localObject2);
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).ALj = true;
    }
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).setLoop(true);
    }
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).setMute(false);
    }
    localObject2 = this.Ght;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject1);
    }
    localObject1 = this.Ght;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MSQ;
      if (localObject1 != null)
      {
        ((b.b)localObject1).MTi = ((m)new a(this, paramAudioCacheInfo));
        AppMethodBeat.o(224899);
        return;
      }
    }
    AppMethodBeat.o(224899);
  }
  
  public final void e(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(224902);
    Log.i(this.TAG, "play music");
    try
    {
      d(paramAudioCacheInfo);
      com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
      if (localb != null)
      {
        localb.gos();
        AppMethodBeat.o(224902);
        return;
      }
      AppMethodBeat.o(224902);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "play music " + paramAudioCacheInfo + " fail:" + localException.getLocalizedMessage());
      AppMethodBeat.o(224902);
    }
  }
  
  public final void fxk()
  {
    AppMethodBeat.i(224917);
    Log.i(this.TAG, "reset music");
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null) {
      localb.stop();
    }
    localb = this.Ght;
    if (localb != null) {
      localb.recycle();
    }
    this.Ght = null;
    AppMethodBeat.o(224917);
  }
  
  public final void fxl()
  {
    AppMethodBeat.i(224924);
    Log.i(this.TAG, "resume music");
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null)
    {
      localb.gos();
      AppMethodBeat.o(224924);
      return;
    }
    AppMethodBeat.o(224924);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    Log.i(this.TAG, "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxq().Ce("");
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxq().vF(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxq().vG(0L);
    localObject = com.tencent.mm.plugin.recordvideo.d.c.HUw;
    com.tencent.mm.plugin.recordvideo.d.c.fxr().anj();
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.HMp;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.fwy();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).fwt();
    }
    localObject = this.Ght;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
      AppMethodBeat.o(75758);
      return;
    }
    AppMethodBeat.o(75758);
  }
  
  public final void release()
  {
    AppMethodBeat.i(224928);
    Log.i(this.TAG, "release");
    com.tencent.mm.plugin.thumbplayer.f.b localb = this.Ght;
    if (localb != null) {
      localb.stop();
    }
    localb = this.Ght;
    if (localb != null) {
      localb.recycle();
    }
    this.Ght = null;
    AppMethodBeat.o(224928);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(224911);
    Object localObject = this.Ght;
    long l2;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).AMn;
      if (localObject != null)
      {
        l1 = ((a)localObject).getDurationMs();
        l2 = Math.max(0L, l1);
        if ((paramLong == 0L) || (l2 == 0L) || (paramLong < l2)) {
          break label154;
        }
      }
    }
    label154:
    for (long l1 = paramLong % l2;; l1 = paramLong)
    {
      Log.i(this.TAG, "seek music to " + paramLong + ", durationMs " + l2 + ", seek to " + l1);
      localObject = this.Ght;
      if (localObject != null)
      {
        com.tencent.mm.plugin.thumbplayer.f.b.a((com.tencent.mm.plugin.thumbplayer.f.b)localObject, (int)l1, false, 6);
        AppMethodBeat.o(224911);
        return;
        l1 = 0L;
        break;
      }
      AppMethodBeat.o(224911);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "ret", "", "invoke"})
  static final class a
    extends q
    implements m<String, Integer, x>
  {
    a(b paramb, AudioCacheInfo paramAudioCacheInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */