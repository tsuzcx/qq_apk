package com.tencent.mm.plugin.vlog.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setComposition", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "firstFrame", "", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer;)V", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getPosition", "", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "play", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayerCallback", "start", "startWithUpdateComposition", "stop", "Companion", "plugin-vlog_release"})
public class VLogCompositionPlayView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static final a LrL;
  private static final String TAG = "MicroMsg.VLogCompositionPlayView";
  private v Lqf;
  public g LrJ;
  private g.a.a LrK;
  private boolean aJn;
  private boolean gsz;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private SurfaceTexture tKD;
  private m<? super Integer, ? super Integer, y> zcQ;
  
  static
  {
    AppMethodBeat.i(200981);
    LrL = new a((byte)0);
    TAG = "MicroMsg.VLogCompositionPlayView";
    AppMethodBeat.o(200981);
  }
  
  public VLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200980);
    this.loop = true;
    this.gsz = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ad.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(200980);
  }
  
  public VLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200979);
    this.loop = true;
    this.gsz = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ad.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(200979);
  }
  
  public VLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200978);
    this.loop = true;
    this.gsz = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    ad.i(TAG, "create VLogCompositionPlayView");
    AppMethodBeat.o(200978);
  }
  
  public void a(v paramv)
  {
    AppMethodBeat.i(200966);
    k.h(paramv, "composition");
    ad.m(TAG, hashCode() + " start, surface:" + this.tKD + ", player:" + this.LrJ + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramv.hashCode(), new Object[0]);
    if ((this.LrJ != null) && (this.tKD != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((k.g(paramv, this.Lqf) ^ true)))
    {
      ad.i(TAG, "startWithUpdateComposition");
      g localg = this.LrJ;
      if (localg != null)
      {
        k.h(paramv, "composition");
        ad.i("MicroMsg.VLogCompositionPlayer", "updateComposition, surfaceWidth:" + localg.surfaceWidth + ", surfaceHeight:" + localg.surfaceHeight);
        paramv.lg(localg.surfaceWidth, localg.surfaceHeight);
        localg.Lrf = paramv.buildSource();
        localg.playerItem = new PlayerItem(localg.Lrf.getAsset());
        localg.playerItem.setVideoComposition(localg.Lrf.getVideoComposition());
        localg.playerItem.setAudioMix(localg.Lrf.getAudioMix());
        Player localPlayer = localg.player;
        if (localPlayer != null) {
          localPlayer.update(localg.playerItem, CMTime.CMTimeZero, (OnCompositionUpdateListener)new g.d(paramv));
        }
        localPlayer = localg.player;
        if (localPlayer != null) {
          localPlayer.setPlayRange(paramv.fYI());
        }
        localg.Lqf = paramv;
      }
      this.Lqf = paramv;
      AppMethodBeat.o(200966);
      return;
    }
    if (k.g(paramv, this.Lqf))
    {
      if (this.tKD != null)
      {
        ad.i(TAG, "same composition directly start");
        this.aJn = true;
        paramv = this.LrJ;
        if (paramv != null)
        {
          paramv.start();
          AppMethodBeat.o(200966);
          return;
        }
        AppMethodBeat.o(200966);
        return;
      }
      ad.i(TAG, "same composition but surface is null");
      this.aJn = true;
      AppMethodBeat.o(200966);
      return;
    }
    this.Lqf = paramv;
    if ((this.tKD != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      fWo();
    }
    this.aJn = true;
    paramv = this.LrJ;
    if (paramv != null)
    {
      paramv.start();
      AppMethodBeat.o(200966);
      return;
    }
    AppMethodBeat.o(200966);
  }
  
  protected void fWo()
  {
    AppMethodBeat.i(200967);
    if ((this.Lqf != null) && (this.tKD != null))
    {
      ad.i(TAG, "do createPlayer, composition:" + this.Lqf);
      Object localObject = this.Lqf;
      if (localObject == null) {
        k.fvU();
      }
      this.LrJ = new g((v)localObject);
      localObject = this.LrJ;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.tKD;
        if (localSurfaceTexture == null) {
          k.fvU();
        }
        int i = this.surfaceWidth;
        int j = this.surfaceHeight;
        k.h(localSurfaceTexture, "surfaceTexture");
        ((g)localObject).Lqf.lg(i, j);
        ((g)localObject).playerLayer = new PlayerLayer(localSurfaceTexture, i, j);
        PlayerLayer localPlayerLayer = ((g)localObject).playerLayer;
        if (localPlayerLayer != null) {
          localPlayerLayer.setPlayer(((g)localObject).player);
        }
        ((g)localObject).surfaceWidth = i;
        ((g)localObject).surfaceHeight = j;
        ad.i("MicroMsg.VLogCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j);
      }
      localObject = this.LrJ;
      if (localObject != null) {
        ((g)localObject).setLoop(this.loop);
      }
      if (this.LrK != null)
      {
        localObject = this.LrJ;
        if (localObject != null)
        {
          ((g)localObject).LrM = this.LrK;
          AppMethodBeat.o(200967);
          return;
        }
      }
    }
    AppMethodBeat.o(200967);
  }
  
  protected final v getComposition()
  {
    return this.Lqf;
  }
  
  protected final g getPlayer()
  {
    return this.LrJ;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(200977);
    g localg = this.LrJ;
    if (localg != null)
    {
      long l = localg.fYU();
      AppMethodBeat.o(200977);
      return l;
    }
    AppMethodBeat.o(200977);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(200976);
    Object localObject = this.LrJ;
    if (localObject != null)
    {
      localObject = ((g)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(200976);
        return bool;
      }
      AppMethodBeat.o(200976);
      return false;
    }
    AppMethodBeat.o(200976);
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200965);
    ad.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.tKD = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.Lqf != null)
    {
      fWo();
      if (this.aJn)
      {
        paramSurfaceTexture = this.LrJ;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(200965);
          return;
        }
      }
    }
    AppMethodBeat.o(200965);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(200964);
    ad.i(TAG, "surfaceDestroy");
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.LrJ;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.tKD = null;
    AppMethodBeat.o(200964);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200962);
    ad.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.LrJ;
    if (paramSurfaceTexture != null)
    {
      ad.i("MicroMsg.VLogCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']');
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.zcQ;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(200962);
      return;
    }
    AppMethodBeat.o(200962);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(200963);
    if ((this.gsz) && (this.aJn))
    {
      ad.i(TAG, "onSurfaceTextureUpdated");
      paramSurfaceTexture = this.LrK;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.fWl();
      }
      this.gsz = false;
    }
    g.a.a locala = this.LrK;
    paramSurfaceTexture = locala;
    if (!(locala instanceof g.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (g.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.fWn();
      AppMethodBeat.o(200963);
      return;
    }
    AppMethodBeat.o(200963);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(200970);
    ad.i(TAG, "pause");
    this.aJn = false;
    Object localObject = this.LrJ;
    if (localObject != null)
    {
      ad.i("MicroMsg.VLogCompositionPlayer", "pause");
      localObject = ((g)localObject).player;
      if (localObject != null) {
        ((Player)localObject).pause();
      }
    }
    AppMethodBeat.o(200970);
    return true;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(200969);
    ad.i(TAG, "play, isStarted=" + this.aJn);
    if (!this.aJn)
    {
      g localg = this.LrJ;
      if (localg != null) {
        localg.start();
      }
    }
    AppMethodBeat.o(200969);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(200973);
    ad.i(TAG, "release");
    this.aJn = false;
    g localg = this.LrJ;
    if (localg != null)
    {
      localg.release();
      AppMethodBeat.o(200973);
      return;
    }
    AppMethodBeat.o(200973);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(200971);
    ad.i(TAG, "resume");
    this.aJn = true;
    g localg = this.LrJ;
    if (localg != null)
    {
      localg.start();
      AppMethodBeat.o(200971);
      return;
    }
    AppMethodBeat.o(200971);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(200974);
    ad.i(TAG, "seekTo:".concat(String.valueOf(paramLong)));
    g localg = this.LrJ;
    if (localg != null)
    {
      localg.seekTo(paramLong);
      AppMethodBeat.o(200974);
      return;
    }
    AppMethodBeat.o(200974);
  }
  
  protected final void setComposition(v paramv)
  {
    this.Lqf = paramv;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(200975);
    ad.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)));
    this.loop = paramBoolean;
    if (this.LrJ != null)
    {
      g localg = this.LrJ;
      if (localg != null)
      {
        localg.setLoop(paramBoolean);
        AppMethodBeat.o(200975);
        return;
      }
      AppMethodBeat.o(200975);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(200975);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, y> paramm)
  {
    this.zcQ = paramm;
  }
  
  protected final void setPlayer(g paramg)
  {
    this.LrJ = paramg;
  }
  
  public final void setPlayerCallback(g.a.a parama)
  {
    if (this.LrJ != null)
    {
      g localg = this.LrJ;
      if (localg != null) {
        localg.LrM = parama;
      }
    }
    this.LrK = parama;
  }
  
  public void stop()
  {
    AppMethodBeat.i(200972);
    ad.i(TAG, "stop");
    this.aJn = false;
    this.gsz = true;
    Object localObject = this.LrJ;
    if (localObject != null)
    {
      ad.i("MicroMsg.VLogCompositionPlayer", "stop");
      localObject = ((g)localObject).player;
      if (localObject != null)
      {
        ((Player)localObject).stop();
        AppMethodBeat.o(200972);
        return;
      }
      AppMethodBeat.o(200972);
      return;
    }
    AppMethodBeat.o(200972);
  }
  
  public final void ze(boolean paramBoolean)
  {
    AppMethodBeat.i(200968);
    g localg = this.LrJ;
    if (localg != null)
    {
      localg.ze(paramBoolean);
      AppMethodBeat.o(200968);
      return;
    }
    AppMethodBeat.o(200968);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */