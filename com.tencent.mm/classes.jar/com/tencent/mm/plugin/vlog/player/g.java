package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.sdk.platformtools.ad;
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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "flushSurfaceTick", "", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surfaceHeight", "", "surfaceWidth", "currentPositionTimeMs", "initPlayerCallback", "", "isPlaying", "", "muteOrigin", "mute", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayerCallback", "callback", "setSurface", "surface", "Landroid/view/Surface;", "width", "height", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "start", "stop", "updateComposition", "updateDisplaySize", "videoDurationMs", "Companion", "plugin-vlog_release"})
public final class g
{
  public static final a LrO;
  v Lqf;
  g.a.a LrM;
  public long LrN;
  TAVSource Lrf;
  public Player player;
  PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(200993);
    LrO = new a((byte)0);
    AppMethodBeat.o(200993);
  }
  
  public g(v paramv)
  {
    AppMethodBeat.i(200992);
    this.Lqf = paramv;
    this.Lrf = this.Lqf.buildSource();
    this.playerItem = new PlayerItem(this.Lrf.getAsset());
    this.playerItem.setVideoComposition(this.Lrf.getVideoComposition());
    this.playerItem.setAudioMix(this.Lrf.getAudioMix());
    this.player = new Player(this.playerItem);
    paramv = this.player;
    if (paramv != null) {
      paramv.setPlayRange(this.Lqf.fYI());
    }
    paramv = this.player;
    if (paramv != null) {
      paramv.setPlayerListener((IPlayer.PlayerListener)new b(this));
    }
    ad.i("MicroMsg.VLogCompositionPlayer", "create player, composition:" + this.Lqf);
    AppMethodBeat.o(200992);
  }
  
  public final long fYU()
  {
    AppMethodBeat.i(200991);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(200991);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(200988);
    ad.i("MicroMsg.VLogCompositionPlayer", "release");
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    AppMethodBeat.o(200988);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(200989);
    ad.i("MicroMsg.VLogCompositionPlayer", "seekTo:".concat(String.valueOf(paramLong)));
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.seekToTime(CMTime.fromMs(paramLong), (Callback)new c(paramLong));
      AppMethodBeat.o(200989);
      return;
    }
    AppMethodBeat.o(200989);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(200990);
    ad.i("MicroMsg.VLogCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)));
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(200990);
      return;
    }
    AppMethodBeat.o(200990);
  }
  
  public final void start()
  {
    AppMethodBeat.i(200987);
    ad.i("MicroMsg.VLogCompositionPlayer", "start");
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.play();
      AppMethodBeat.o(200987);
      return;
    }
    AppMethodBeat.o(200987);
  }
  
  public final void ze(boolean paramBoolean)
  {
    AppMethodBeat.i(200986);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(200986);
        return;
      }
    }
    AppMethodBeat.o(200986);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion;", "", "()V", "TAG", "", "PlayerCallback", "PlayerFrameCallback", "plugin-vlog_release"})
  public static final class a
  {
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
    public static abstract interface a
    {
      public abstract void Ca(long paramLong);
      
      public abstract void fWi();
      
      public abstract void fWj();
      
      public abstract void fWk();
      
      public abstract void fWl();
      
      public abstract void fWm();
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "plugin-vlog_release"})
    public static abstract interface b
      extends g.a.a
    {
      public abstract void fWn();
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "plugin-vlog_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(200983);
      g.a.a locala = g.a(this.LrP);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.Ca(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != g.b(this.LrP).fYI().getStartUs()) {
          break label100;
        }
        paramCMTime = g.a(this.LrP);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.fWi();
        AppMethodBeat.o(200983);
        return;
      }
      AppMethodBeat.o(200983);
      return;
      label100:
      AppMethodBeat.o(200983);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(200982);
      ad.i("MicroMsg.VLogCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)));
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = g.a(this.LrP);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fWi();
          AppMethodBeat.o(200982);
          return;
        }
        AppMethodBeat.o(200982);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = g.a(this.LrP);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fWj();
          AppMethodBeat.o(200982);
          return;
        }
        AppMethodBeat.o(200982);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = g.a(this.LrP);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fWk();
          AppMethodBeat.o(200982);
          return;
        }
        AppMethodBeat.o(200982);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = g.a(this.LrP);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.fWm();
          AppMethodBeat.o(200982);
          return;
        }
      }
      AppMethodBeat.o(200982);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "call"})
  static final class c
    implements Callback
  {
    c(long paramLong) {}
    
    public final void call()
    {
      AppMethodBeat.i(200984);
      ad.i("MicroMsg.VLogCompositionPlayer", "seekTo:" + this.LrQ + " completed");
      AppMethodBeat.o(200984);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class d
    implements OnCompositionUpdateListener
  {
    d(v paramv) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(200985);
      StringBuilder localStringBuilder = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      k.g(localCMTime, "player.position()");
      ad.i("MicroMsg.VLogCompositionPlayer", localCMTime.getTimeUs() / 1000L);
      if (paramPlayer != null) {
        paramPlayer.play();
      }
      if (paramPlayer != null)
      {
        paramPlayer.seekToTime(this.Llq.fYI().getStart());
        AppMethodBeat.o(200985);
        return;
      }
      AppMethodBeat.o(200985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.g
 * JD-Core Version:    0.7.0.1
 */