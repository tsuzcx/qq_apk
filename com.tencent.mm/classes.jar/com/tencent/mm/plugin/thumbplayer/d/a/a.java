package com.tencent.mm.plugin.thumbplayer.d.a;

import com.tencent.mm.plugin.thumbplayer.d.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaPlayer;", "", "()V", "hasTexture", "", "getHasTexture", "()Z", "setHasTexture", "(Z)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "onPlayFinished", "Lkotlin/Function1;", "", "getOnPlayFinished", "()Lkotlin/jvm/functions/Function1;", "setOnPlayFinished", "(Lkotlin/jvm/functions/Function1;)V", "onPlayProgressUpdate", "Lkotlin/Function2;", "", "getOnPlayProgressUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnPlayProgressUpdate", "(Lkotlin/jvm/functions/Function2;)V", "onPlayStarted", "getOnPlayStarted", "setOnPlayStarted", "targetEndTimeMs", "getTargetEndTimeMs", "()J", "setTargetEndTimeMs", "(J)V", "targetHeight", "", "getTargetHeight", "()I", "setTargetHeight", "(I)V", "targetStartTimeMs", "getTargetStartTimeMs", "setTargetStartTimeMs", "targetWidth", "getTargetWidth", "setTargetWidth", "track", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "getTrack", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "setTrack", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;)V", "getCurrentPlayTimeMs", "getMediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MultiMediaInfo;", "isPlaying", "isPrepared", "isStarted", "mediaType", "Lcom/tencent/mm/plugin/thumbplayer/effect/player/MediaType;", "pause", "preloadMedia", "release", "resume", "seek", "timeMs", "onSeekFinished", "Lkotlin/Function0;", "setInputSurface", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setLoop", "loop", "setMute", "mute", "setPlayRange", "startMs", "endMs", "setTargetPlayRange", "start", "end", "setTargetSize", "width", "height", "stop", "plugin-thumbplayer_release"})
public abstract class a
{
  private long MRE;
  private long MRF;
  public kotlin.g.a.b<? super a, x> MRG;
  public kotlin.g.a.b<? super a, x> MRH;
  public m<? super Long, ? super a, x> MRI;
  public e MRJ;
  public boolean MRK;
  public String key = "";
  private int targetHeight;
  private int targetWidth;
  
  public abstract void aG(long paramLong1, long paramLong2);
  
  public final void aH(long paramLong1, long paramLong2)
  {
    this.MRE = paramLong1;
    this.MRF = paramLong2;
  }
  
  public abstract boolean ayN();
  
  public abstract void b(long paramLong, kotlin.g.a.a<x> parama);
  
  public abstract b god();
  
  public abstract void goe();
  
  public final int gof()
  {
    return this.targetWidth;
  }
  
  public final int gog()
  {
    return this.targetHeight;
  }
  
  public final long goh()
  {
    return this.MRE;
  }
  
  public final long goi()
  {
    return this.MRF;
  }
  
  public abstract boolean isPlaying();
  
  public abstract boolean isStarted();
  
  public void kv(int paramInt1, int paramInt2)
  {
    this.targetWidth = paramInt1;
    this.targetHeight = paramInt2;
  }
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public final void setKey(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public abstract void setLoop(boolean paramBoolean);
  
  public void setMute(boolean paramBoolean) {}
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.a.a
 * JD-Core Version:    0.7.0.1
 */