package com.tencent.mm.plugin.recordvideo.plugin.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.thumbplayer.e.a;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import com.tencent.mm.plugin.thumbplayer.e.d;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditMusicController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "player", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "pauseAudio", "", "playAudio", "info", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "prepareAudio", "release", "resetAudio", "resumeAudio", "seekTo", "timeMs", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private com.tencent.mm.plugin.thumbplayer.e.b GvH;
  private final String TAG;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(75759);
    this.TAG = s.X("MicroMsg.EditMusicController", Integer.valueOf(hashCode()));
    AppMethodBeat.o(75759);
  }
  
  public final void d(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(280916);
    pauseAudio();
    if (paramAudioCacheInfo == null)
    {
      AppMethodBeat.o(280916);
      return;
    }
    Object localObject2 = paramAudioCacheInfo.musicUrl;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i = paramAudioCacheInfo.NID;
    String str = paramAudioCacheInfo.cachePath;
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b(String.valueOf(i), (String)localObject2, (String)localObject1, 0, 0);
    ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = paramAudioCacheInfo.cached;
    ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).decodeKey = paramAudioCacheInfo.decodeKey;
    if (paramAudioCacheInfo.NIJ) {
      ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).videoFlag = "A0";
    }
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).stop();
    }
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).recycle();
    }
    localObject2 = d.TFK;
    localObject2 = MMApplicationContext.getContext();
    s.s(localObject2, "getContext()");
    this.GvH = d.a.ks((Context)localObject2);
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Flr = true;
    }
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(true);
    }
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMute(false);
    }
    localObject2 = this.GvH;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
    }
    localObject1 = this.GvH;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFd)
    {
      if (localObject1 != null) {
        ((b.b)localObject1).TFy = ((m)new a(paramAudioCacheInfo, this));
      }
      AppMethodBeat.o(280916);
      return;
    }
  }
  
  public final void e(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(280923);
    Log.i(this.TAG, "play music");
    try
    {
      d(paramAudioCacheInfo);
      com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
      if (localb != null)
      {
        localb.hLh();
        AppMethodBeat.o(280923);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "play music " + paramAudioCacheInfo + " fail:" + localException.getLocalizedMessage());
      AppMethodBeat.o(280923);
    }
  }
  
  public final void gIW()
  {
    AppMethodBeat.i(280934);
    Log.i(this.TAG, "reset music");
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.stop();
    }
    localb = this.GvH;
    if (localb != null) {
      localb.recycle();
    }
    this.GvH = null;
    AppMethodBeat.o(280934);
  }
  
  public final void gIX()
  {
    AppMethodBeat.i(280944);
    Log.i(this.TAG, "resume music");
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.hLh();
    }
    AppMethodBeat.o(280944);
  }
  
  public final void pauseAudio()
  {
    AppMethodBeat.i(75758);
    Log.i(this.TAG, "pause music");
    Object localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJf().wn("");
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJf().jjA = 0L;
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJf().itJ = 0L;
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.gJg().jkX = 0L;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.NJe;
    localObject = com.tencent.mm.plugin.recordvideo.model.audio.c.gIh();
    if (localObject != null) {
      ((com.tencent.mm.plugin.recordvideo.model.audio.c)localObject).gIc();
    }
    localObject = this.GvH;
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    AppMethodBeat.o(75758);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280946);
    Log.i(this.TAG, "release");
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
    if (localb != null) {
      localb.stop();
    }
    localb = this.GvH;
    if (localb != null) {
      localb.recycle();
    }
    this.GvH = null;
    AppMethodBeat.o(280946);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(280930);
    Object localObject = this.GvH;
    long l2;
    if (localObject == null)
    {
      l1 = 0L;
      l2 = Math.max(0L, l1);
      if ((paramLong == 0L) || (l2 == 0L) || (paramLong < l2)) {
        break label152;
      }
    }
    label152:
    for (long l1 = paramLong % l2;; l1 = paramLong)
    {
      Log.i(this.TAG, "seek music to " + paramLong + ", durationMs " + l2 + ", seek to " + l1);
      localObject = this.GvH;
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject, (int)l1, false, 6);
      }
      AppMethodBeat.o(280930);
      return;
      localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).Flb;
      if (localObject == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((a)localObject).getDurationMs();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "ret", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<String, Integer, ah>
  {
    a(AudioCacheInfo paramAudioCacheInfo, b paramb)
    {
      super();
    }
    
    private static final void a(b paramb, AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(280885);
      s.u(paramb, "this$0");
      paramb.e(paramAudioCacheInfo);
      AppMethodBeat.o(280885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */