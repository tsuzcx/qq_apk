package com.tencent.mm.videocomposition.play;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.h;
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
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"})
public final class a
{
  public static final a.a Lnh;
  private h BGk;
  a.a.c Lna;
  private TAVSource Lnc;
  private a.a Lnd;
  boolean Lne;
  private boolean Lnf;
  private long Lng;
  boolean aLU;
  private boolean isd;
  Player player;
  private PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  SurfaceTexture surfaceTexture;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(220900);
    Lnh = new a.a((byte)0);
    AppMethodBeat.o(220900);
  }
  
  public a(h paramh)
  {
    AppMethodBeat.i(220899);
    this.BGk = paramh;
    this.Lnc = this.BGk.buildSource();
    this.playerItem = new PlayerItem(this.Lnc.getAsset());
    this.playerItem.setVideoComposition(this.Lnc.getVideoComposition());
    this.playerItem.setAudioMix(this.Lnc.getAudioMix());
    a(this.playerItem);
    b.i("VideoCompositionPlayer", "create player, composition:" + this.BGk, new Object[0]);
    AppMethodBeat.o(220899);
  }
  
  private final void a(final CMTime paramCMTime1, boolean paramBoolean, CMTime paramCMTime2)
  {
    AppMethodBeat.i(220889);
    final long l1 = SystemClock.elapsedRealtime();
    this.Lnf = true;
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
      paramCMTime1.setPlayRange(this.BGk.esb());
      AppMethodBeat.o(220889);
      return;
    }
    AppMethodBeat.o(220889);
  }
  
  private final void a(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(220886);
    this.player = new Player(paramPlayerItem);
    paramPlayerItem = this.player;
    if (paramPlayerItem != null) {
      paramPlayerItem.setPlayRange(this.BGk.esb());
    }
    if (this.BGk.LmS)
    {
      paramPlayerItem = this.player;
      if (paramPlayerItem != null) {
        paramPlayerItem.setRate(-1.0F);
      }
    }
    this.aLU = false;
    this.Lnf = false;
    fPH();
    AppMethodBeat.o(220886);
  }
  
  private final void fPH()
  {
    AppMethodBeat.i(220885);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayerListener((IPlayer.PlayerListener)new b(this));
      AppMethodBeat.o(220885);
      return;
    }
    AppMethodBeat.o(220885);
  }
  
  public final void a(h paramh, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(220887);
    p.h(paramh, "composition");
    b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong + ", isStarted:" + this.aLU, new Object[0]);
    this.Lnc = paramh.buildSource();
    this.playerItem = new PlayerItem(this.Lnc.getAsset());
    this.playerItem.setVideoComposition(this.Lnc.getVideoComposition());
    this.playerItem.setAudioMix(this.Lnc.getAudioMix());
    this.BGk = paramh;
    paramh = this.player;
    Object localObject;
    if (paramh != null)
    {
      paramh = paramh.position();
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:".concat(String.valueOf(paramh)), new Object[0]);
      if (paramLong == -1L) {
        break label263;
      }
      localObject = CMTime.fromMs(paramLong);
    }
    for (;;)
    {
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:" + paramh + ", newPosition:" + localObject, new Object[0]);
      a((CMTime)localObject, paramBoolean1, paramh);
      AppMethodBeat.o(220887);
      return;
      paramh = null;
      break;
      label263:
      if (paramBoolean2) {
        localObject = paramh;
      } else {
        localObject = CMTime.CMTimeZero;
      }
    }
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220890);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayRange(CMTimeRange.fromMs(paramLong1, paramLong2 - paramLong1));
      AppMethodBeat.o(220890);
      return;
    }
    AppMethodBeat.o(220890);
  }
  
  public final void fPI()
  {
    AppMethodBeat.i(220897);
    b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.aLU, new Object[0]);
    if (!this.aLU)
    {
      this.Lng = SystemClock.elapsedRealtime();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.refreshSurface(null);
        AppMethodBeat.o(220897);
        return;
      }
    }
    AppMethodBeat.o(220897);
  }
  
  public final long fPJ()
  {
    AppMethodBeat.i(220898);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(220898);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(220894);
    b.i("VideoCompositionPlayer", "release", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    this.aLU = false;
    AppMethodBeat.o(220894);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(220895);
    b.i("VideoCompositionPlayer", "seekTo:" + paramLong + ", isUpdatingComposition:" + this.Lnf, new Object[0]);
    if (!this.Lnf)
    {
      long l = System.currentTimeMillis();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.seekToTime(CMTime.fromMs(paramLong), (Callback)new d(l, paramLong));
        AppMethodBeat.o(220895);
        return;
      }
    }
    AppMethodBeat.o(220895);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(220896);
    b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.isd = paramBoolean;
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(220896);
      return;
    }
    AppMethodBeat.o(220896);
  }
  
  public final void setPlayerCallback(a.a parama)
  {
    AppMethodBeat.i(220892);
    this.Lnd = parama;
    fPH();
    AppMethodBeat.o(220892);
  }
  
  public final void start()
  {
    AppMethodBeat.i(220893);
    b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.Lnf, new Object[0]);
    if (!this.Lnf)
    {
      Player localPlayer = this.player;
      if (localPlayer != null) {
        localPlayer.play();
      }
    }
    this.aLU = true;
    AppMethodBeat.o(220893);
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(220891);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(220891);
        return;
      }
    }
    AppMethodBeat.o(220891);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"})
  public static abstract interface a$a
  {
    public abstract void cLW();
    
    public abstract void cLX();
    
    public abstract void cLY();
    
    public abstract void cLZ();
    
    public abstract void cMa();
    
    public abstract void xp(long paramLong);
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(220882);
      a.a.a locala = a.a(this.Lni);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.xp(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != a.b(this.Lni).esb().getStartUs()) {
          break label100;
        }
        paramCMTime = a.a(this.Lni);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.cLW();
        AppMethodBeat.o(220882);
        return;
      }
      AppMethodBeat.o(220882);
      return;
      label100:
      AppMethodBeat.o(220882);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(220881);
      b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)), new Object[0]);
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = a.a(this.Lni);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cLW();
          AppMethodBeat.o(220881);
          return;
        }
        AppMethodBeat.o(220881);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = a.a(this.Lni);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cLX();
          AppMethodBeat.o(220881);
          return;
        }
        AppMethodBeat.o(220881);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = a.a(this.Lni);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cLY();
          AppMethodBeat.o(220881);
          return;
        }
        AppMethodBeat.o(220881);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = a.a(this.Lni);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cMa();
          AppMethodBeat.o(220881);
          return;
        }
      }
      AppMethodBeat.o(220881);
    }
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class c
    implements OnCompositionUpdateListener
  {
    c(a parama, long paramLong1, CMTime paramCMTime1, long paramLong2, CMTime paramCMTime2, boolean paramBoolean) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(220883);
      System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      p.g(localCMTime, "player.position()");
      localStringBuilder = localStringBuilder.append(localCMTime.getTimeUs() / 1000L).append(", originPosition:").append(l1).append(", isStarted:").append(a.c(this.Lni)).append(", cost:");
      long l = paramCMTime1;
      b.i("VideoCompositionPlayer", SystemClock.elapsedRealtime() - l, new Object[0]);
      if (paramPlayer != null) {
        paramPlayer.seekToTime(this.Lnl);
      }
      if (((this.Lnm) || (a.c(this.Lni))) && (paramPlayer != null)) {
        paramPlayer.play();
      }
      a.d(this.Lni);
      AppMethodBeat.o(220883);
    }
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "call"})
  static final class d
    implements Callback
  {
    d(long paramLong1, long paramLong2) {}
    
    public final void call()
    {
      AppMethodBeat.i(220884);
      System.currentTimeMillis();
      b.i("VideoCompositionPlayer", "seekTo:" + this.BPk + " completed", new Object[0]);
      AppMethodBeat.o(220884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a
 * JD-Core Version:    0.7.0.1
 */