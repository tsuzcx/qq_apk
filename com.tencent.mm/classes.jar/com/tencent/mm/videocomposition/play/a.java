package com.tencent.mm.videocomposition.play;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.j;
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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "getLaggingTime", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"})
public final class a
{
  public static final a YJv;
  private j NmT;
  a.a.c YJo;
  private TAVSource YJq;
  private a.a.a YJr;
  boolean YJs;
  private boolean YJt;
  private long YJu;
  boolean isStarted;
  private boolean mfK;
  Player player;
  PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  SurfaceTexture surfaceTexture;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(248509);
    YJv = new a((byte)0);
    AppMethodBeat.o(248509);
  }
  
  public a(j paramj)
  {
    AppMethodBeat.i(248507);
    this.NmT = paramj;
    this.YJq = this.NmT.buildSource();
    this.playerItem = new PlayerItem(this.YJq.getAsset());
    this.playerItem.setVideoComposition(this.YJq.getVideoComposition());
    this.playerItem.setAudioMix(this.YJq.getAudioMix());
    this.player = new Player(this.playerItem);
    paramj = this.player;
    if (paramj != null) {
      paramj.setPlayRange(this.NmT.igH());
    }
    if (this.NmT.YIn)
    {
      paramj = this.player;
      if (paramj != null) {
        paramj.setRate(-1.0F);
      }
    }
    this.isStarted = false;
    this.YJt = false;
    igO();
    b.i("VideoCompositionPlayer", "create player, composition:" + this.NmT, new Object[0]);
    AppMethodBeat.o(248507);
  }
  
  private final void a(final CMTime paramCMTime1, boolean paramBoolean, CMTime paramCMTime2)
  {
    AppMethodBeat.i(248488);
    final long l1 = SystemClock.elapsedRealtime();
    this.YJt = true;
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
      paramCMTime1.setPlayRange(this.NmT.igH());
      AppMethodBeat.o(248488);
      return;
    }
    AppMethodBeat.o(248488);
  }
  
  private final void igO()
  {
    AppMethodBeat.i(248482);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayerListener((IPlayer.PlayerListener)new b(this));
      AppMethodBeat.o(248482);
      return;
    }
    AppMethodBeat.o(248482);
  }
  
  public final void Ib(boolean paramBoolean)
  {
    AppMethodBeat.i(248490);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(248490);
        return;
      }
    }
    AppMethodBeat.o(248490);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(248486);
    p.k(paramj, "composition");
    b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong + ", isStarted:" + this.isStarted, new Object[0]);
    this.YJq = paramj.buildSource();
    this.playerItem = new PlayerItem(this.YJq.getAsset());
    this.playerItem.setVideoComposition(this.YJq.getVideoComposition());
    this.playerItem.setAudioMix(this.YJq.getAudioMix());
    this.NmT = paramj;
    paramj = this.player;
    Object localObject;
    if (paramj != null)
    {
      paramj = paramj.position();
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:".concat(String.valueOf(paramj)), new Object[0]);
      if (paramLong == -1L) {
        break label270;
      }
      localObject = new CMTime(paramLong, 1000);
    }
    for (;;)
    {
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:" + paramj + ", newPosition:" + localObject, new Object[0]);
      a((CMTime)localObject, paramBoolean1, paramj);
      AppMethodBeat.o(248486);
      return;
      paramj = null;
      break;
      label270:
      if (paramBoolean2) {
        localObject = paramj;
      } else {
        localObject = CMTime.CMTimeZero;
      }
    }
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248489);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayRange(new CMTimeRange(new CMTime(paramLong1, 1000), new CMTime(paramLong2 - paramLong1, 1000)));
      AppMethodBeat.o(248489);
      return;
    }
    AppMethodBeat.o(248489);
  }
  
  public final void igP()
  {
    AppMethodBeat.i(248502);
    b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.isStarted, new Object[0]);
    if (!this.isStarted)
    {
      this.YJu = SystemClock.elapsedRealtime();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.refreshSurface(null);
        AppMethodBeat.o(248502);
        return;
      }
    }
    AppMethodBeat.o(248502);
  }
  
  public final long igQ()
  {
    AppMethodBeat.i(248504);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(248504);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(248496);
    b.i("VideoCompositionPlayer", "release", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    this.isStarted = false;
    AppMethodBeat.o(248496);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(248499);
    b.i("VideoCompositionPlayer", "seekTo:" + paramLong + ", isUpdatingComposition:" + this.YJt, new Object[0]);
    if (!this.YJt)
    {
      final long l = System.currentTimeMillis();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.seekToTime(new CMTime(paramLong, 1000), (Callback)new d(this, l, paramLong));
        AppMethodBeat.o(248499);
        return;
      }
    }
    AppMethodBeat.o(248499);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(248500);
    b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.mfK = paramBoolean;
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(248500);
      return;
    }
    AppMethodBeat.o(248500);
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(248492);
    this.YJr = parama;
    igO();
    AppMethodBeat.o(248492);
  }
  
  public final void start()
  {
    AppMethodBeat.i(248494);
    b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.YJt, new Object[0]);
    if (!this.YJt)
    {
      Player localPlayer = this.player;
      if (localPlayer != null) {
        localPlayer.play();
      }
    }
    this.isStarted = true;
    AppMethodBeat.o(248494);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion;", "", "()V", "TAG", "", "PlayerCallback", "PlayerFrameCallback", "PlayerProfileCallback", "video_composition_release"})
  public static final class a
  {
    @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"})
    public static abstract interface a
    {
      public abstract void Np(long paramLong);
      
      public abstract void egA();
      
      public abstract void egB();
      
      public abstract void egC();
      
      public abstract void egD();
      
      public abstract void egE();
    }
    
    @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "video_composition_release"})
    public static abstract interface b
      extends a.a.a
    {
      public abstract void egF();
    }
    
    @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "", "onSeek", "", "cost", "", "onUpdateComposition", "video_composition_release"})
    public static abstract interface c
    {
      public abstract void OM(long paramLong);
      
      public abstract void Sz(long paramLong);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(248466);
      a.a.a locala = a.a(this.YJw);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.Np(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != a.b(this.YJw).igH().getStartUs()) {
          break label100;
        }
        paramCMTime = a.a(this.YJw);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.egA();
        AppMethodBeat.o(248466);
        return;
      }
      AppMethodBeat.o(248466);
      return;
      label100:
      AppMethodBeat.o(248466);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(248465);
      b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)), new Object[0]);
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = a.a(this.YJw);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.egA();
          AppMethodBeat.o(248465);
          return;
        }
        AppMethodBeat.o(248465);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = a.a(this.YJw);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.egB();
          AppMethodBeat.o(248465);
          return;
        }
        AppMethodBeat.o(248465);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = a.a(this.YJw);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.egC();
          AppMethodBeat.o(248465);
          return;
        }
        AppMethodBeat.o(248465);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = a.a(this.YJw);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.egE();
          AppMethodBeat.o(248465);
          return;
        }
      }
      AppMethodBeat.o(248465);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class c
    implements OnCompositionUpdateListener
  {
    c(a parama, long paramLong1, CMTime paramCMTime1, long paramLong2, CMTime paramCMTime2, boolean paramBoolean) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(248471);
      long l1 = System.currentTimeMillis();
      long l2 = l2;
      Object localObject = a.c(this.YJw);
      if (localObject != null) {
        ((a.a.c)localObject).Sz(l1 - l2);
      }
      localObject = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      p.j(localCMTime, "player.position()");
      localObject = ((StringBuilder)localObject).append(localCMTime.getTimeUs() / 1000L).append(", originPosition:").append(l1).append(", isStarted:").append(a.d(this.YJw)).append(", cost:");
      l1 = paramCMTime1;
      b.i("VideoCompositionPlayer", SystemClock.elapsedRealtime() - l1, new Object[0]);
      if (paramPlayer != null) {
        paramPlayer.seekToTime(this.YJy);
      }
      if (((this.YJz) || (a.d(this.YJw))) && (paramPlayer != null)) {
        paramPlayer.play();
      }
      a.e(this.YJw);
      AppMethodBeat.o(248471);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "call"})
  static final class d
    implements Callback
  {
    d(a parama, long paramLong1, long paramLong2) {}
    
    public final void call()
    {
      AppMethodBeat.i(248477);
      long l1 = System.currentTimeMillis();
      long l2 = l;
      b.i("VideoCompositionPlayer", "seekTo:" + this.AOw + " completed", new Object[0]);
      a.a.c localc = a.c(this.YJw);
      if (localc != null)
      {
        localc.OM(l1 - l2);
        AppMethodBeat.o(248477);
        return;
      }
      AppMethodBeat.o(248477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a
 * JD-Core Version:    0.7.0.1
 */