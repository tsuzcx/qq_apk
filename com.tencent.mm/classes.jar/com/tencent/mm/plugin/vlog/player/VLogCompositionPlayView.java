package com.tencent.mm.plugin.vlog.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVSource;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;)V", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getPosition", "", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "play", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "startWithUpdateComposition", "stop", "Companion", "plugin-vlog_release"})
public class VLogCompositionPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VLogCompositionPlayView.a Apx;
  private static final String TAG = "MicroMsg.VLogCompositionPlayView";
  private r AmR;
  public c Apu;
  private m<? super Integer, ? super Integer, y> Apv;
  private c.a.a Apw;
  protected boolean aKd;
  private boolean gTg;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private SurfaceTexture uTi;
  
  static
  {
    AppMethodBeat.i(207667);
    Apx = new VLogCompositionPlayView.a((byte)0);
    TAG = "MicroMsg.VLogCompositionPlayView";
    AppMethodBeat.o(207667);
  }
  
  public VLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207666);
    this.loop = true;
    this.gTg = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ac.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(207666);
  }
  
  public VLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(207665);
    this.loop = true;
    this.gTg = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ac.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(207665);
  }
  
  public VLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207664);
    this.loop = true;
    this.gTg = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ac.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(207664);
  }
  
  public void a(r paramr)
  {
    AppMethodBeat.i(207652);
    k.h(paramr, "composition");
    ac.m(TAG, hashCode() + " start, surface:" + this.uTi + ", player:" + this.Apu + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramr.hashCode(), new Object[0]);
    if ((this.Apu != null) && (this.uTi != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((k.g(paramr, this.AmR) ^ true)))
    {
      ac.i(TAG, "startWithUpdateComposition");
      c localc = this.Apu;
      if (localc != null)
      {
        k.h(paramr, "composition");
        ac.i("MicroMsg.VLogCompositionPlayer", "updateComposition, surfaceWidth:" + localc.surfaceWidth + ", surfaceHeight:" + localc.surfaceHeight);
        paramr.hY(localc.surfaceWidth, localc.surfaceHeight);
        localc.Aon = paramr.buildSource();
        localc.playerItem = new PlayerItem(localc.Aon.getAsset());
        localc.playerItem.setVideoComposition(localc.Aon.getVideoComposition());
        localc.playerItem.setAudioMix(localc.Aon.getAudioMix());
        Player localPlayer = localc.player;
        if (localPlayer != null) {
          localPlayer.update(localc.playerItem, CMTime.CMTimeZero, (OnCompositionUpdateListener)new c.d(paramr));
        }
        localPlayer = localc.player;
        if (localPlayer != null) {
          localPlayer.setPlayRange(paramr.efA());
        }
        localc.AmR = paramr;
      }
      this.AmR = paramr;
      AppMethodBeat.o(207652);
      return;
    }
    if (k.g(paramr, this.AmR))
    {
      if (this.uTi != null)
      {
        ac.i(TAG, "same composition directly start");
        this.aKd = true;
        paramr = this.Apu;
        if (paramr != null)
        {
          paramr.start();
          AppMethodBeat.o(207652);
          return;
        }
        AppMethodBeat.o(207652);
        return;
      }
      ac.i(TAG, "same composition but surface is null");
      this.aKd = true;
      AppMethodBeat.o(207652);
      return;
    }
    this.AmR = paramr;
    if ((this.uTi != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      cDW();
    }
    this.aKd = true;
    paramr = this.Apu;
    if (paramr != null)
    {
      paramr.start();
      AppMethodBeat.o(207652);
      return;
    }
    AppMethodBeat.o(207652);
  }
  
  protected void cDW()
  {
    AppMethodBeat.i(207653);
    if ((this.AmR != null) && (this.uTi != null))
    {
      ac.i(TAG, "do createPlayer, composition:" + this.AmR);
      Object localObject = this.AmR;
      if (localObject == null) {
        k.fOy();
      }
      this.Apu = new c((r)localObject);
      localObject = this.Apu;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.uTi;
        if (localSurfaceTexture == null) {
          k.fOy();
        }
        int i = this.surfaceWidth;
        int j = this.surfaceHeight;
        k.h(localSurfaceTexture, "surfaceTexture");
        ((c)localObject).AmR.hY(i, j);
        ((c)localObject).playerLayer = new PlayerLayer(localSurfaceTexture, i, j);
        PlayerLayer localPlayerLayer = ((c)localObject).playerLayer;
        if (localPlayerLayer != null) {
          localPlayerLayer.setPlayer(((c)localObject).player);
        }
        ((c)localObject).surfaceWidth = i;
        ((c)localObject).surfaceHeight = j;
        ac.i("MicroMsg.VLogCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j);
      }
      localObject = this.Apu;
      if (localObject != null) {
        ((c)localObject).setLoop(this.loop);
      }
      if (this.Apw != null)
      {
        localObject = this.Apu;
        if (localObject != null)
        {
          ((c)localObject).Apy = this.Apw;
          AppMethodBeat.o(207653);
          return;
        }
      }
    }
    AppMethodBeat.o(207653);
  }
  
  protected final r getComposition()
  {
    return this.AmR;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.gTg;
  }
  
  protected final c getPlayer()
  {
    return this.Apu;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(207663);
    c localc = this.Apu;
    if (localc != null)
    {
      long l = localc.efR();
      AppMethodBeat.o(207663);
      return l;
    }
    AppMethodBeat.o(207663);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(207662);
    Object localObject = this.Apu;
    if (localObject != null)
    {
      localObject = ((c)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(207662);
        return bool;
      }
      AppMethodBeat.o(207662);
      return false;
    }
    AppMethodBeat.o(207662);
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207651);
    ac.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.uTi = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.AmR != null)
    {
      cDW();
      if (this.aKd)
      {
        paramSurfaceTexture = this.Apu;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(207651);
          return;
        }
      }
    }
    AppMethodBeat.o(207651);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(207650);
    ac.i(TAG, "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.Apu;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.Apu = null;
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.uTi = null;
    this.AmR = null;
    AppMethodBeat.o(207650);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207648);
    ac.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.Apu;
    if (paramSurfaceTexture != null)
    {
      ac.i("MicroMsg.VLogCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']');
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.Apv;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(207648);
      return;
    }
    AppMethodBeat.o(207648);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(207649);
    if ((this.gTg) && (this.aKd))
    {
      ac.i(TAG, "onSurfaceTextureUpdated");
      paramSurfaceTexture = this.Apw;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.cDF();
      }
      this.gTg = false;
    }
    c.a.a locala = this.Apw;
    paramSurfaceTexture = locala;
    if (!(locala instanceof c.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (c.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.cDH();
      AppMethodBeat.o(207649);
      return;
    }
    AppMethodBeat.o(207649);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(207656);
    ac.i(TAG, "pause");
    this.aKd = false;
    Object localObject = this.Apu;
    if (localObject != null)
    {
      ac.i("MicroMsg.VLogCompositionPlayer", "pause");
      localObject = ((c)localObject).player;
      if (localObject != null) {
        ((Player)localObject).pause();
      }
    }
    AppMethodBeat.o(207656);
    return true;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(207655);
    ac.i(TAG, "play, isStarted=" + this.aKd);
    if (!this.aKd)
    {
      c localc = this.Apu;
      if (localc != null) {
        localc.start();
      }
    }
    AppMethodBeat.o(207655);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(207659);
    ac.i(TAG, "release");
    this.aKd = false;
    c localc = this.Apu;
    if (localc != null)
    {
      localc.release();
      AppMethodBeat.o(207659);
      return;
    }
    AppMethodBeat.o(207659);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(207657);
    ac.i(TAG, "resume");
    this.aKd = true;
    c localc = this.Apu;
    if (localc != null)
    {
      localc.start();
      AppMethodBeat.o(207657);
      return;
    }
    AppMethodBeat.o(207657);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(207660);
    ac.i(TAG, "seekTo:".concat(String.valueOf(paramLong)));
    c localc = this.Apu;
    if (localc != null)
    {
      localc.seekTo(paramLong);
      AppMethodBeat.o(207660);
      return;
    }
    AppMethodBeat.o(207660);
  }
  
  protected final void setComposition(r paramr)
  {
    this.AmR = paramr;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.gTg = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(207661);
    ac.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    if (this.Apu != null)
    {
      c localc = this.Apu;
      if (localc != null)
      {
        localc.setLoop(paramBoolean);
        AppMethodBeat.o(207661);
        return;
      }
      AppMethodBeat.o(207661);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(207661);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, y> paramm)
  {
    this.Apv = paramm;
  }
  
  protected final void setPlayer(c paramc)
  {
    this.Apu = paramc;
  }
  
  public final void setPlayerCallback(c.a.a parama)
  {
    if (this.Apu != null)
    {
      c localc = this.Apu;
      if (localc != null) {
        localc.Apy = parama;
      }
    }
    this.Apw = parama;
  }
  
  public final void sl(boolean paramBoolean)
  {
    AppMethodBeat.i(207654);
    c localc = this.Apu;
    if (localc != null)
    {
      localc.sl(paramBoolean);
      AppMethodBeat.o(207654);
      return;
    }
    AppMethodBeat.o(207654);
  }
  
  public void stop()
  {
    AppMethodBeat.i(207658);
    ac.i(TAG, "stop");
    this.aKd = false;
    this.gTg = true;
    Object localObject = this.Apu;
    if (localObject != null)
    {
      ac.i("MicroMsg.VLogCompositionPlayer", "stop");
      localObject = ((c)localObject).player;
      if (localObject != null)
      {
        ((Player)localObject).stop();
        AppMethodBeat.o(207658);
        return;
      }
      AppMethodBeat.o(207658);
      return;
    }
    AppMethodBeat.o(207658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */