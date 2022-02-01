package com.tencent.mm.videocomposition.play;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.n;
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

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "flushSurfaceTick", "", "hasPlaySurface", "", "isLoop", "isStarted", "isUpdatingComposition", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surfaceWidth", "createPlayer", "", "createPlayerLayerBySurface", "width", "height", "createPlayerLayerBySurfaceTexture", "currentPositionTimeMs", "getLaggingTime", "initPlayerCallback", "isPlaying", "muteOrigin", "mute", "normalUpdateComposition", "newPosition", "Lcom/tencent/tav/coremedia/CMTime;", "playAfterUpdate", "originPosition", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setProfileCallback", "setSurface", "setSurfaceTexture", "stop", "updateComposition", "seekToOriginPosition", "updateCompositionByRecreatePlayer", "updateDisplaySize", "videoDurationMs", "Companion", "video_composition_release"})
public final class a
{
  public static final a.a RhL;
  private n Gez;
  public a.c RhE;
  private TAVSource RhG;
  private a.a RhH;
  public boolean RhI;
  private boolean RhJ;
  private long RhK;
  private boolean isStarted;
  private boolean jqj;
  Player player;
  PlayerItem playerItem;
  private PlayerLayer playerLayer;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(216842);
    RhL = new a.a((byte)0);
    AppMethodBeat.o(216842);
  }
  
  public a(n paramn)
  {
    AppMethodBeat.i(216841);
    this.Gez = paramn;
    this.RhG = this.Gez.buildSource();
    this.playerItem = new PlayerItem(this.RhG.getAsset());
    this.playerItem.setVideoComposition(this.RhG.getVideoComposition());
    this.playerItem.setAudioMix(this.RhG.getAudioMix());
    this.player = new Player(this.playerItem);
    paramn = this.player;
    if (paramn != null) {
      paramn.setPlayRange(this.Gez.hfo());
    }
    if (this.Gez.QEl)
    {
      paramn = this.player;
      if (paramn != null) {
        paramn.setRate(-1.0F);
      }
    }
    this.isStarted = false;
    this.RhJ = false;
    hfs();
    b.i("VideoCompositionPlayer", "create player, composition:" + this.Gez, new Object[0]);
    AppMethodBeat.o(216841);
  }
  
  private final void a(final CMTime paramCMTime1, boolean paramBoolean, CMTime paramCMTime2)
  {
    AppMethodBeat.i(216826);
    final long l1 = SystemClock.elapsedRealtime();
    this.RhJ = true;
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
      paramCMTime1.setPlayRange(this.Gez.hfo());
      AppMethodBeat.o(216826);
      return;
    }
    AppMethodBeat.o(216826);
  }
  
  private final void d(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216831);
    b.i("VideoCompositionPlayer", "createPlayerLayerBySurfaceTexture: " + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
    this.playerLayer = new PlayerLayer(paramSurfaceTexture, paramInt1, paramInt2);
    paramSurfaceTexture = this.playerLayer;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.setPlayer(this.player);
      AppMethodBeat.o(216831);
      return;
    }
    AppMethodBeat.o(216831);
  }
  
  private final void hfs()
  {
    AppMethodBeat.i(216823);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayerListener((IPlayer.PlayerListener)new b(this));
      AppMethodBeat.o(216823);
      return;
    }
    AppMethodBeat.o(216823);
  }
  
  public final void DB(boolean paramBoolean)
  {
    AppMethodBeat.i(216828);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(216828);
        return;
      }
    }
    AppMethodBeat.o(216828);
  }
  
  public final void a(n paramn, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(216824);
    p.h(paramn, "composition");
    b.i("VideoCompositionPlayer", "updateComposition, surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong + ", isStarted:" + this.isStarted, new Object[0]);
    this.RhG = paramn.buildSource();
    this.playerItem = new PlayerItem(this.RhG.getAsset());
    this.playerItem.setVideoComposition(this.RhG.getVideoComposition());
    this.playerItem.setAudioMix(this.RhG.getAudioMix());
    this.Gez = paramn;
    paramn = this.player;
    Object localObject;
    if (paramn != null)
    {
      paramn = paramn.position();
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:".concat(String.valueOf(paramn)), new Object[0]);
      if (paramLong == -1L) {
        break label270;
      }
      localObject = new CMTime(paramLong, 1000);
    }
    for (;;)
    {
      b.i("VideoCompositionPlayer", "updateComposition, originPosition:" + paramn + ", newPosition:" + localObject, new Object[0]);
      a((CMTime)localObject, paramBoolean1, paramn);
      AppMethodBeat.o(216824);
      return;
      paramn = null;
      break;
      label270:
      if (paramBoolean2) {
        localObject = paramn;
      } else {
        localObject = CMTime.CMTimeZero;
      }
    }
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216827);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setPlayRange(new CMTimeRange(new CMTime(paramLong1, 1000), new CMTime(paramLong2 - paramLong1, 1000)));
      AppMethodBeat.o(216827);
      return;
    }
    AppMethodBeat.o(216827);
  }
  
  public final void c(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216830);
    p.h(paramSurfaceTexture, "surfaceTexture");
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.surfaceTexture = paramSurfaceTexture;
    d(paramSurfaceTexture, paramInt1, paramInt2);
    this.RhI = true;
    b.i("VideoCompositionPlayer", "setSurfaceTexture: " + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    AppMethodBeat.o(216830);
  }
  
  public final void hft()
  {
    AppMethodBeat.i(216839);
    b.i("VideoCompositionPlayer", "refreshSurface isStarted:" + this.isStarted, new Object[0]);
    if (!this.isStarted)
    {
      this.RhK = SystemClock.elapsedRealtime();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.refreshSurface(null);
        AppMethodBeat.o(216839);
        return;
      }
    }
    AppMethodBeat.o(216839);
  }
  
  public final long hfu()
  {
    AppMethodBeat.i(216840);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(216840);
      return l;
    }
  }
  
  public final void lX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216832);
    b.i("VideoCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.updateViewport(paramInt1, paramInt2);
      AppMethodBeat.o(216832);
      return;
    }
    AppMethodBeat.o(216832);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(216834);
    b.i("VideoCompositionPlayer", "pause", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.pause();
    }
    this.isStarted = false;
    AppMethodBeat.o(216834);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216836);
    b.i("VideoCompositionPlayer", "release", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    this.isStarted = false;
    AppMethodBeat.o(216836);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(216837);
    b.i("VideoCompositionPlayer", "seekTo:" + paramLong + ", isUpdatingComposition:" + this.RhJ, new Object[0]);
    if (!this.RhJ)
    {
      final long l = System.currentTimeMillis();
      Player localPlayer = this.player;
      if (localPlayer != null)
      {
        localPlayer.seekToTime(new CMTime(paramLong, 1000), (Callback)new d(this, l, paramLong));
        AppMethodBeat.o(216837);
        return;
      }
    }
    AppMethodBeat.o(216837);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(216838);
    b.i("VideoCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.jqj = paramBoolean;
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(216838);
      return;
    }
    AppMethodBeat.o(216838);
  }
  
  public final void setPlayerCallback(a.a parama)
  {
    AppMethodBeat.i(216829);
    this.RhH = parama;
    hfs();
    AppMethodBeat.o(216829);
  }
  
  public final void start()
  {
    AppMethodBeat.i(216833);
    b.i("VideoCompositionPlayer", "start, isUpdatingComposition:" + this.RhJ, new Object[0]);
    if (!this.RhJ)
    {
      Player localPlayer = this.player;
      if (localPlayer != null) {
        localPlayer.play();
      }
    }
    this.isStarted = true;
    AppMethodBeat.o(216833);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(216835);
    b.i("VideoCompositionPlayer", "stop", new Object[0]);
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.stop();
    }
    this.isStarted = false;
    AppMethodBeat.o(216835);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "video_composition_release"})
  public static abstract interface a$a
  {
    public abstract void Go(long paramLong);
    
    public abstract void dER();
    
    public abstract void dES();
    
    public abstract void dET();
    
    public abstract void dEU();
    
    public abstract void dEV();
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "", "onSeek", "", "cost", "", "onUpdateComposition", "video_composition_release"})
  public static abstract interface a$c
  {
    public abstract void Lc(long paramLong);
    
    public abstract void Ld(long paramLong);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"com/tencent/mm/videocomposition/play/VideoCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "video_composition_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(216820);
      a.a.a locala = a.a(this.RhM);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.Go(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != a.b(this.RhM).hfo().getStartUs()) {
          break label100;
        }
        paramCMTime = a.a(this.RhM);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.dER();
        AppMethodBeat.o(216820);
        return;
      }
      AppMethodBeat.o(216820);
      return;
      label100:
      AppMethodBeat.o(216820);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(216819);
      b.i("VideoCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)), new Object[0]);
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = a.a(this.RhM);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.dER();
          AppMethodBeat.o(216819);
          return;
        }
        AppMethodBeat.o(216819);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = a.a(this.RhM);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.dES();
          AppMethodBeat.o(216819);
          return;
        }
        AppMethodBeat.o(216819);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = a.a(this.RhM);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.dET();
          AppMethodBeat.o(216819);
          return;
        }
        AppMethodBeat.o(216819);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = a.a(this.RhM);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.dEV();
          AppMethodBeat.o(216819);
          return;
        }
      }
      AppMethodBeat.o(216819);
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class c
    implements OnCompositionUpdateListener
  {
    c(a parama, long paramLong1, CMTime paramCMTime1, long paramLong2, CMTime paramCMTime2, boolean paramBoolean) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(216821);
      long l1 = System.currentTimeMillis();
      long l2 = l2;
      Object localObject = a.c(this.RhM);
      if (localObject != null) {
        ((a.a.c)localObject).Lc(l1 - l2);
      }
      localObject = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      p.g(localCMTime, "player.position()");
      localObject = ((StringBuilder)localObject).append(localCMTime.getTimeUs() / 1000L).append(", originPosition:").append(l1).append(", isStarted:").append(a.d(this.RhM)).append(", cost:");
      l1 = paramCMTime1;
      b.i("VideoCompositionPlayer", SystemClock.elapsedRealtime() - l1, new Object[0]);
      if (paramPlayer != null) {
        paramPlayer.seekToTime(this.RhP);
      }
      if (((this.RhQ) || (a.d(this.RhM))) && (paramPlayer != null)) {
        paramPlayer.play();
      }
      a.e(this.RhM);
      AppMethodBeat.o(216821);
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "call"})
  static final class d
    implements Callback
  {
    d(a parama, long paramLong1, long paramLong2) {}
    
    public final void call()
    {
      AppMethodBeat.i(216822);
      long l1 = System.currentTimeMillis();
      long l2 = l;
      b.i("VideoCompositionPlayer", "seekTo:" + this.wfK + " completed", new Object[0]);
      a.a.c localc = a.c(this.RhM);
      if (localc != null)
      {
        localc.Ld(l1 - l2);
        AppMethodBeat.o(216822);
        return;
      }
      AppMethodBeat.o(216822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a
 * JD-Core Version:    0.7.0.1
 */