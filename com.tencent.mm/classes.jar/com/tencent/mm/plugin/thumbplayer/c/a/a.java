package com.tencent.mm.plugin.thumbplayer.c.a;

import com.tencent.mm.plugin.thumbplayer.c.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "", "()V", "hasTexture", "", "getHasTexture", "()Z", "setHasTexture", "(Z)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "onPlayFinished", "Lkotlin/Function1;", "", "getOnPlayFinished", "()Lkotlin/jvm/functions/Function1;", "setOnPlayFinished", "(Lkotlin/jvm/functions/Function1;)V", "onPlayProgressUpdate", "Lkotlin/Function2;", "", "getOnPlayProgressUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnPlayProgressUpdate", "(Lkotlin/jvm/functions/Function2;)V", "onPlayStarted", "getOnPlayStarted", "setOnPlayStarted", "targetEndTimeMs", "getTargetEndTimeMs", "()J", "setTargetEndTimeMs", "(J)V", "targetHeight", "", "getTargetHeight", "()I", "setTargetHeight", "(I)V", "targetStartTimeMs", "getTargetStartTimeMs", "setTargetStartTimeMs", "targetWidth", "getTargetWidth", "setTargetWidth", "track", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "getTrack", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "setTrack", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;)V", "getCurrentPlayTimeMs", "getMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "isPlaying", "isPrepared", "isStarted", "mediaType", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "pause", "preloadMedia", "release", "resume", "seek", "timeMs", "onSeekFinished", "Lkotlin/Function0;", "setInputSurface", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setLoop", "loop", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setTargetPlayRange", "start", "end", "setTargetSize", "width", "height", "stop", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  private long TEb;
  private long TEc;
  public kotlin.g.a.b<? super a, ah> TEd;
  public kotlin.g.a.b<? super a, ah> TEe;
  public m<? super Long, ? super a, ah> TEf;
  public c TEg;
  public boolean TEh;
  public String key = "";
  private int nxO;
  private int nxP;
  
  public abstract void bs(long paramLong1, long paramLong2);
  
  public final void bt(long paramLong1, long paramLong2)
  {
    this.TEb = paramLong1;
    this.TEc = paramLong2;
  }
  
  public abstract boolean cxs();
  
  public abstract void d(long paramLong, kotlin.g.a.a<ah> parama);
  
  public abstract b hKR();
  
  public abstract void hKS();
  
  public final int hKT()
  {
    return this.nxO;
  }
  
  public final int hKU()
  {
    return this.nxP;
  }
  
  public final long hKV()
  {
    return this.TEb;
  }
  
  public final long hKW()
  {
    return this.TEc;
  }
  
  public abstract boolean isPlaying();
  
  public abstract boolean isStarted();
  
  public void mi(int paramInt1, int paramInt2)
  {
    this.nxO = paramInt1;
    this.nxP = paramInt2;
  }
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public final void setKey(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public abstract void setLoop(boolean paramBoolean);
  
  public void setMute(boolean paramBoolean) {}
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.a
 * JD-Core Version:    0.7.0.1
 */