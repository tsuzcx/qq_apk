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

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"})
public final class a
{
  public static final a.a LJS;
  private h BXI;
  a.a.c LJL;
  private TAVSource LJN;
  private a.a LJO;
  boolean LJP;
  private boolean LJQ;
  private long LJR;
  boolean aLU;
  private boolean iuX;
  Player player;
  private PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  SurfaceTexture surfaceTexture;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(195035);
    LJS = new a.a((byte)0);
    AppMethodBeat.o(195035);
  }
  
  public a(h paramh)
  {
    AppMethodBeat.i(195034);
    this.BXI = paramh;
    this.LJN = this.BXI.buildSource();
    this.playerItem = new PlayerItem(this.LJN.getAsset());
    this.playerItem.setVideoComposition(this.LJN.getVideoComposition());
    this.playerItem.setAudioMix(this.LJN.getAudioMix());
    a(this.playerItem);
    b.i("VideoCompositionPlayer", "create player, composition:" + this.BXI, new Object[0]);
    AppMethodBeat.o(195034);
  }
  
  private final void a(final CMTime paramCMTime1, boolean paramBoolean, CMTime paramCMTime2)
  {
    AppMethodBeat.i(195024);
    final long l1 = SystemClock.elapsedRealtime();
    this.LJQ = true;
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
      paramCMTime1.setPlayRange(this.BXI.evI());
      AppMethodBeat.o(195024);
      return;
    }
    AppMethodBeat.o(195024);
  }
  
  private final void a(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(195021);
    this.player = new Player(paramPlayerItem);
    paramPlayerItem = this.player;
    if (paramPlayerItem != null) {
      paramPlayerItem.setPlayRange(this.BXI.evI());
    }
    if (this.BXI.LJC)
    {
      paramPlayerItem = this.player;
      if (paramPlayerItem != null) {
        paramPlayerItem.setRate(-1.0F);
      }
    }
    this.aLU = false;
    this.LJQ = false;
    fUd();
    AppMethodBeat.o(195021);
  }
  
  private final void fUd()
  {
    AppMethodBeat.i(195020);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayerListener((IPlayer.PlayerListener)new b(this));
      AppMethodBeat.o(195020);
      return;
    }
    AppMethodBeat.o(195020);
  }
  
  public final void a(h paramh, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(195022);
    p.h(paramh, "composition");
    b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong + ", isStarted:" + this.aLU, new Object[0]);
    this.LJN = paramh.buildSource();
    this.playerItem = new PlayerItem(this.LJN.getAsset());
    this.playerItem.setVideoComposition(this.LJN.getVideoComposition());
    this.playerItem.setAudioMix(this.LJN.getAudioMix());
    this.BXI = paramh;
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
      AppMethodBeat.o(195022);
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
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195025);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayRange(CMTimeRange.fromMs(paramLong1, paramLong2 - paramLong1));
      AppMethodBeat.o(195025);
      return;
    }
    AppMethodBeat.o(195025);
  }
  
  public final void fUe()
  {
    AppMethodBeat.i(195032);
    b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.aLU, new Object[0]);
    if (!this.aLU)
    {
      this.LJR = SystemClock.elapsedRealtime();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.refreshSurface(null);
        AppMethodBeat.o(195032);
        return;
      }
    }
    AppMethodBeat.o(195032);
  }
  
  public final long fUf()
  {
    AppMethodBeat.i(195033);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(195033);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(195029);
    b.i("VideoCompositionPlayer", "release", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    this.aLU = false;
    AppMethodBeat.o(195029);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(195030);
    b.i("VideoCompositionPlayer", "seekTo:" + paramLong + ", isUpdatingComposition:" + this.LJQ, new Object[0]);
    if (!this.LJQ)
    {
      long l = System.currentTimeMillis();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.seekToTime(CMTime.fromMs(paramLong), (Callback)new a.d(l, paramLong));
        AppMethodBeat.o(195030);
        return;
      }
    }
    AppMethodBeat.o(195030);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(195031);
    b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.iuX = paramBoolean;
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(195031);
      return;
    }
    AppMethodBeat.o(195031);
  }
  
  public final void setPlayerCallback(a.a parama)
  {
    AppMethodBeat.i(195027);
    this.LJO = parama;
    fUd();
    AppMethodBeat.o(195027);
  }
  
  public final void start()
  {
    AppMethodBeat.i(195028);
    b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.LJQ, new Object[0]);
    if (!this.LJQ)
    {
      Player localPlayer = this.player;
      if (localPlayer != null) {
        localPlayer.play();
      }
    }
    this.aLU = true;
    AppMethodBeat.o(195028);
  }
  
  public final void zq(boolean paramBoolean)
  {
    AppMethodBeat.i(195026);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(195026);
        return;
      }
    }
    AppMethodBeat.o(195026);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"})
  public static abstract interface a$a
  {
    public abstract void cOE();
    
    public abstract void cOF();
    
    public abstract void cOG();
    
    public abstract void cOH();
    
    public abstract void cOI();
    
    public abstract void xH(long paramLong);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "video_composition_release"})
  public static abstract interface a$b
    extends a.a.a
  {
    public abstract void cOJ();
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(195017);
      a.a.a locala = a.a(this.LJT);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.xH(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != a.b(this.LJT).evI().getStartUs()) {
          break label100;
        }
        paramCMTime = a.a(this.LJT);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.cOE();
        AppMethodBeat.o(195017);
        return;
      }
      AppMethodBeat.o(195017);
      return;
      label100:
      AppMethodBeat.o(195017);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(195016);
      b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)), new Object[0]);
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = a.a(this.LJT);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cOE();
          AppMethodBeat.o(195016);
          return;
        }
        AppMethodBeat.o(195016);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = a.a(this.LJT);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cOF();
          AppMethodBeat.o(195016);
          return;
        }
        AppMethodBeat.o(195016);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = a.a(this.LJT);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cOG();
          AppMethodBeat.o(195016);
          return;
        }
        AppMethodBeat.o(195016);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = a.a(this.LJT);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cOI();
          AppMethodBeat.o(195016);
          return;
        }
      }
      AppMethodBeat.o(195016);
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class c
    implements OnCompositionUpdateListener
  {
    c(a parama, long paramLong1, CMTime paramCMTime1, long paramLong2, CMTime paramCMTime2, boolean paramBoolean) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(195018);
      System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      p.g(localCMTime, "player.position()");
      localStringBuilder = localStringBuilder.append(localCMTime.getTimeUs() / 1000L).append(", originPosition:").append(l1).append(", isStarted:").append(a.c(this.LJT)).append(", cost:");
      long l = paramCMTime1;
      b.i("VideoCompositionPlayer", SystemClock.elapsedRealtime() - l, new Object[0]);
      if (paramPlayer != null) {
        paramPlayer.seekToTime(this.LJW);
      }
      if (((this.LJX) || (a.c(this.LJT))) && (paramPlayer != null)) {
        paramPlayer.play();
      }
      a.d(this.LJT);
      AppMethodBeat.o(195018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a
 * JD-Core Version:    0.7.0.1
 */