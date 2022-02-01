package com.tencent.mm.videocomposition.play;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.d.b;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.Callback;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVSource;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "getLaggingTime", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a
{
  public static final a.a agFn;
  private j Uaw;
  a.c agFg;
  private TAVSource agFi;
  private a.a agFj;
  boolean agFk;
  private boolean agFl;
  private long agFm;
  boolean isStarted;
  private boolean oYG;
  Player player;
  PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  SurfaceTexture surfaceTexture;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(233603);
    agFn = new a.a((byte)0);
    AppMethodBeat.o(233603);
  }
  
  public a(j paramj)
  {
    AppMethodBeat.i(233597);
    this.Uaw = paramj;
    this.agFi = j.f(this.Uaw);
    this.playerItem = new PlayerItem(this.agFi.getAsset());
    this.playerItem.setVideoComposition(this.agFi.getVideoComposition());
    this.playerItem.setAudioMix(this.agFi.getAudioMix());
    paramj = this.playerItem;
    paramj.setDecoderFactory((IDecoderFactory)this.Uaw.mediaFactory);
    this.player = new Player(paramj);
    paramj = this.player;
    if (paramj != null) {
      paramj.setPlayRange(this.Uaw.jLV());
    }
    if (this.Uaw.agDU)
    {
      paramj = this.player;
      if (paramj != null) {
        paramj.setRate(-1.0F);
      }
    }
    this.isStarted = false;
    this.agFl = false;
    jMd();
    b.i("VideoCompositionPlayer", "create player, composition:" + this.Uaw, new Object[0]);
    AppMethodBeat.o(233597);
  }
  
  private final void a(final CMTime paramCMTime1, boolean paramBoolean, CMTime paramCMTime2)
  {
    AppMethodBeat.i(233591);
    final long l1 = SystemClock.elapsedRealtime();
    this.agFl = true;
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.pause();
    }
    final long l2 = System.currentTimeMillis();
    localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.update(this.playerItem, paramCMTime1, (OnCompositionUpdateListener)new c(this, l2, paramCMTime2, l1, paramCMTime1, paramBoolean));
    }
    paramCMTime1 = this.player;
    if (paramCMTime1 != null)
    {
      paramCMTime1.setPlayRange(this.Uaw.jLV());
      AppMethodBeat.o(233591);
      return;
    }
    AppMethodBeat.o(233591);
  }
  
  private final void jMd()
  {
    AppMethodBeat.i(233575);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayerListener((IPlayer.PlayerListener)new b(this));
      AppMethodBeat.o(233575);
      return;
    }
    AppMethodBeat.o(233575);
  }
  
  public final void NX(boolean paramBoolean)
  {
    AppMethodBeat.i(233650);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(233650);
        return;
      }
    }
    AppMethodBeat.o(233650);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(233638);
    s.t(paramj, "composition");
    b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong + ", isStarted:" + this.isStarted, new Object[0]);
    this.agFi = j.f(paramj);
    this.playerItem = new PlayerItem(this.agFi.getAsset());
    this.playerItem.setVideoComposition(this.agFi.getVideoComposition());
    this.playerItem.setAudioMix(this.agFi.getAudioMix());
    this.playerItem.setDecoderFactory((IDecoderFactory)paramj.mediaFactory);
    this.Uaw = paramj;
    paramj = this.player;
    Object localObject;
    if (paramj != null)
    {
      paramj = paramj.position();
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:".concat(String.valueOf(paramj)), new Object[0]);
      if (paramLong == -1L) {
        break label284;
      }
      localObject = new CMTime(paramLong, 1000);
    }
    for (;;)
    {
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:" + paramj + ", newPosition:" + localObject, new Object[0]);
      a((CMTime)localObject, paramBoolean1, paramj);
      AppMethodBeat.o(233638);
      return;
      paramj = null;
      break;
      label284:
      if (paramBoolean2) {
        localObject = paramj;
      } else {
        localObject = CMTime.CMTimeZero;
      }
    }
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(233644);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayRange(new CMTimeRange(new CMTime(paramLong1, 1000), new CMTime(paramLong2 - paramLong1, 1000)));
      AppMethodBeat.o(233644);
      return;
    }
    AppMethodBeat.o(233644);
  }
  
  public final void jMe()
  {
    AppMethodBeat.i(233690);
    b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.isStarted, new Object[0]);
    if (!this.isStarted)
    {
      this.agFm = SystemClock.elapsedRealtime();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.refreshSurface(null);
        AppMethodBeat.o(233690);
        return;
      }
    }
    AppMethodBeat.o(233690);
  }
  
  public final long jMf()
  {
    AppMethodBeat.i(233696);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(233696);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(233669);
    b.i("VideoCompositionPlayer", "release", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    this.isStarted = false;
    AppMethodBeat.o(233669);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(233676);
    b.i("VideoCompositionPlayer", "seekTo:" + paramLong + ", isUpdatingComposition:" + this.agFl, new Object[0]);
    if (!this.agFl)
    {
      final long l = System.currentTimeMillis();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.seekToTime(new CMTime(paramLong, 1000), (Callback)new d(this, l, paramLong));
        AppMethodBeat.o(233676);
        return;
      }
    }
    AppMethodBeat.o(233676);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(233683);
    b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.oYG = paramBoolean;
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(233683);
      return;
    }
    AppMethodBeat.o(233683);
  }
  
  public final void setPlayerCallback(a.a parama)
  {
    AppMethodBeat.i(233657);
    this.agFj = parama;
    jMd();
    AppMethodBeat.o(233657);
  }
  
  public final void start()
  {
    AppMethodBeat.i(233663);
    b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.agFl, new Object[0]);
    if (!this.agFl)
    {
      Player localPlayer = this.player;
      if (localPlayer != null) {
        localPlayer.play();
      }
    }
    this.isStarted = true;
    AppMethodBeat.o(233663);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static abstract interface a$a
  {
    public abstract void fiA();
    
    public abstract void fiB();
    
    public abstract void fix();
    
    public abstract void fiy();
    
    public abstract void fiz();
    
    public abstract void qT(long paramLong);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static abstract interface a$b
    extends a.a.a
  {
    public abstract void fiC();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "", "onSeek", "", "cost", "", "onUpdateComposition", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static abstract interface a$c
  {
    public abstract void sK(long paramLong);
    
    public abstract void wN(long paramLong);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(233570);
      a.a.a locala = a.a(this.agFo);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.qT(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != a.b(this.agFo).jLV().getStartUs()) {
          break label100;
        }
        paramCMTime = a.a(this.agFo);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.fix();
        AppMethodBeat.o(233570);
        return;
      }
      AppMethodBeat.o(233570);
      return;
      label100:
      AppMethodBeat.o(233570);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(233563);
      b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)), new Object[0]);
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = a.a(this.agFo);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fix();
          AppMethodBeat.o(233563);
          return;
        }
        AppMethodBeat.o(233563);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = a.a(this.agFo);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fiy();
          AppMethodBeat.o(233563);
          return;
        }
        AppMethodBeat.o(233563);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = a.a(this.agFo);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fiz();
          AppMethodBeat.o(233563);
          return;
        }
        AppMethodBeat.o(233563);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = a.a(this.agFo);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fiB();
          AppMethodBeat.o(233563);
          return;
        }
      }
      AppMethodBeat.o(233563);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"}, k=3, mv={1, 1, 15})
  static final class c
    implements OnCompositionUpdateListener
  {
    c(a parama, long paramLong1, CMTime paramCMTime1, long paramLong2, CMTime paramCMTime2, boolean paramBoolean) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(233565);
      long l1 = System.currentTimeMillis();
      long l2 = l2;
      Object localObject = a.c(this.agFo);
      if (localObject != null) {
        ((a.a.c)localObject).wN(l1 - l2);
      }
      localObject = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      s.r(localCMTime, "player.position()");
      localObject = ((StringBuilder)localObject).append(localCMTime.getTimeUs() / 1000L).append(", originPosition:").append(l1).append(", isStarted:").append(a.d(this.agFo)).append(", cost:");
      l1 = paramCMTime1;
      b.i("VideoCompositionPlayer", SystemClock.elapsedRealtime() - l1, new Object[0]);
      if (paramPlayer != null) {
        paramPlayer.seekToTime(this.agFq);
      }
      if (((this.agFr) || (a.d(this.agFo))) && (paramPlayer != null)) {
        paramPlayer.play();
      }
      a.e(this.agFo);
      AppMethodBeat.o(233565);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "call"}, k=3, mv={1, 1, 15})
  static final class d
    implements Callback
  {
    d(a parama, long paramLong1, long paramLong2) {}
    
    public final void call()
    {
      AppMethodBeat.i(233561);
      long l1 = System.currentTimeMillis();
      long l2 = l;
      b.i("VideoCompositionPlayer", "seekTo:" + this.GqS + " completed", new Object[0]);
      a.a.c localc = a.c(this.agFo);
      if (localc != null)
      {
        localc.sK(l1 - l2);
        AppMethodBeat.o(233561);
        return;
      }
      AppMethodBeat.o(233561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a
 * JD-Core Version:    0.7.0.1
 */