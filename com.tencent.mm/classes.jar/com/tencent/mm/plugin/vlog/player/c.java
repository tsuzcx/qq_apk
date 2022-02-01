package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.sdk.platformtools.ac;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "flushSurfaceTick", "", "player", "Lcom/tencent/tav/player/Player;", "playerCallback", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "playerItem", "Lcom/tencent/tav/player/PlayerItem;", "playerLayer", "Lcom/tencent/tav/player/PlayerLayer;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "surfaceHeight", "", "surfaceWidth", "currentPositionTimeMs", "initPlayerCallback", "", "isPlaying", "", "muteOrigin", "mute", "pause", "refreshSurface", "release", "seekTo", "timeMs", "setLoop", "loop", "setPlayRange", "start", "end", "setPlayerCallback", "callback", "setSurface", "surface", "Landroid/view/Surface;", "width", "height", "setSurfaceTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "stop", "updateComposition", "updateDisplaySize", "videoDurationMs", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final c.a ApA;
  r AmR;
  TAVSource Aon;
  a.a Apy;
  public long Apz;
  public Player player;
  PlayerItem playerItem;
  PlayerLayer playerLayer;
  int surfaceHeight;
  int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(207679);
    ApA = new c.a((byte)0);
    AppMethodBeat.o(207679);
  }
  
  public c(r paramr)
  {
    AppMethodBeat.i(207678);
    this.AmR = paramr;
    this.Aon = this.AmR.buildSource();
    this.playerItem = new PlayerItem(this.Aon.getAsset());
    this.playerItem.setVideoComposition(this.Aon.getVideoComposition());
    this.playerItem.setAudioMix(this.Aon.getAudioMix());
    this.player = new Player(this.playerItem);
    paramr = this.player;
    if (paramr != null) {
      paramr.setPlayRange(this.AmR.efA());
    }
    paramr = this.player;
    if (paramr != null) {
      paramr.setPlayerListener((IPlayer.PlayerListener)new b(this));
    }
    ac.i("MicroMsg.VLogCompositionPlayer", "create player, composition:" + this.AmR);
    AppMethodBeat.o(207678);
  }
  
  public final long efR()
  {
    AppMethodBeat.i(207677);
    Object localObject = this.player;
    if (localObject != null)
    {
      localObject = ((Player)localObject).currentTime();
      if (localObject == null) {}
    }
    for (long l = ((CMTime)localObject).getTimeUs();; l = 0L)
    {
      l /= 1000L;
      AppMethodBeat.o(207677);
      return l;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(207674);
    ac.i("MicroMsg.VLogCompositionPlayer", "release");
    Player localPlayer = this.player;
    if (localPlayer != null) {
      localPlayer.release();
    }
    this.playerLayer = null;
    this.player = null;
    AppMethodBeat.o(207674);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(207675);
    ac.i("MicroMsg.VLogCompositionPlayer", "seekTo:".concat(String.valueOf(paramLong)));
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.seekToTime(CMTime.fromMs(paramLong), (Callback)new c.c(paramLong));
      AppMethodBeat.o(207675);
      return;
    }
    AppMethodBeat.o(207675);
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(207676);
    ac.i("MicroMsg.VLogCompositionPlayer", "setLoop:".concat(String.valueOf(paramBoolean)));
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.setLoop(paramBoolean);
      AppMethodBeat.o(207676);
      return;
    }
    AppMethodBeat.o(207676);
  }
  
  public final void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(207672);
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      if (paramBoolean) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        localPlayer.setVolume(f);
        AppMethodBeat.o(207672);
        return;
      }
    }
    AppMethodBeat.o(207672);
  }
  
  public final void start()
  {
    AppMethodBeat.i(207673);
    ac.i("MicroMsg.VLogCompositionPlayer", "start");
    Player localPlayer = this.player;
    if (localPlayer != null)
    {
      localPlayer.play();
      AppMethodBeat.o(207673);
      return;
    }
    AppMethodBeat.o(207673);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static abstract interface a$a
  {
    public abstract void cDC();
    
    public abstract void cDD();
    
    public abstract void cDE();
    
    public abstract void cDF();
    
    public abstract void cDG();
    
    public abstract void vm(long paramLong);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerFrameCallback;", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "onFrame", "", "plugin-vlog_release"})
  public static abstract interface a$b
    extends c.a.a
  {
    public abstract void cDH();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$initPlayerCallback$1", "Lcom/tencent/tav/player/IPlayer$PlayerListener;", "onPositionChanged", "", "position", "Lcom/tencent/tav/coremedia/CMTime;", "onStatusChanged", "status", "Lcom/tencent/tav/player/IPlayer$PlayerStatus;", "plugin-vlog_release"})
  public static final class b
    implements IPlayer.PlayerListener
  {
    public final void onPositionChanged(CMTime paramCMTime)
    {
      AppMethodBeat.i(207669);
      c.a.a locala = c.a(this.ApB);
      if (locala != null) {
        if (paramCMTime == null) {
          break label89;
        }
      }
      label89:
      for (long l = paramCMTime.getTimeUs();; l = 0L)
      {
        locala.vm(l / 1000L);
        if (paramCMTime == null) {
          break;
        }
        if (paramCMTime.getTimeUs() != c.b(this.ApB).efA().getStartUs()) {
          break label100;
        }
        paramCMTime = c.a(this.ApB);
        if (paramCMTime == null) {
          break label100;
        }
        paramCMTime.cDC();
        AppMethodBeat.o(207669);
        return;
      }
      AppMethodBeat.o(207669);
      return;
      label100:
      AppMethodBeat.o(207669);
    }
    
    public final void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
    {
      AppMethodBeat.i(207668);
      ac.i("MicroMsg.VLogCompositionPlayer", "onStatusChanged:".concat(String.valueOf(paramPlayerStatus)));
      if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
      {
        paramPlayerStatus = c.a(this.ApB);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cDC();
          AppMethodBeat.o(207668);
          return;
        }
        AppMethodBeat.o(207668);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.STOPPED)
      {
        paramPlayerStatus = c.a(this.ApB);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cDD();
          AppMethodBeat.o(207668);
          return;
        }
        AppMethodBeat.o(207668);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.FINISHED)
      {
        paramPlayerStatus = c.a(this.ApB);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cDE();
          AppMethodBeat.o(207668);
          return;
        }
        AppMethodBeat.o(207668);
        return;
      }
      if (paramPlayerStatus == IPlayer.PlayerStatus.ERROR)
      {
        paramPlayerStatus = c.a(this.ApB);
        if (paramPlayerStatus != null)
        {
          paramPlayerStatus.cDG();
          AppMethodBeat.o(207668);
          return;
        }
      }
      AppMethodBeat.o(207668);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/tav/player/Player;", "kotlin.jvm.PlatformType", "success", "", "onUpdated"})
  static final class d
    implements OnCompositionUpdateListener
  {
    d(r paramr) {}
    
    public final void onUpdated(Player paramPlayer, boolean paramBoolean)
    {
      AppMethodBeat.i(207671);
      StringBuilder localStringBuilder = new StringBuilder("on composition update, success:").append(paramBoolean).append(", position:");
      CMTime localCMTime = paramPlayer.position();
      k.g(localCMTime, "player.position()");
      ac.i("MicroMsg.VLogCompositionPlayer", localCMTime.getTimeUs() / 1000L);
      if (paramPlayer != null) {
        paramPlayer.play();
      }
      if (paramPlayer != null)
      {
        paramPlayer.seekToTime(this.shn.efA().getStart());
        AppMethodBeat.o(207671);
        return;
      }
      AppMethodBeat.o(207671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */