package com.tencent.mm.videocomposition.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.h;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerLayer;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getPosition", "", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"})
public class VideoCompositionPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VideoCompositionPlayView.a Lnb;
  public static final String TAG = "VideoCompositionPlayView";
  public h BGk;
  private m<? super Integer, ? super Integer, z> BTM;
  public a LmY;
  private a.a.a LmZ;
  private a.a.c Lna;
  protected boolean aLU;
  private boolean hlh;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private SurfaceTexture vWs;
  
  static
  {
    AppMethodBeat.i(220880);
    Lnb = new VideoCompositionPlayView.a((byte)0);
    TAG = "VideoCompositionPlayView";
    AppMethodBeat.o(220880);
  }
  
  public VideoCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(220879);
    this.loop = true;
    this.hlh = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(220879);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220878);
    this.loop = true;
    this.hlh = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(220878);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220877);
    this.loop = true;
    this.hlh = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(220877);
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(220864);
    p.h(paramh, "composition");
    b.m(TAG, hashCode() + " start, surface:" + this.vWs + ", player:" + this.LmY + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramh.hashCode(), new Object[0]);
    a locala;
    if ((this.LmY != null) && (this.vWs != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((p.i(paramh, this.BGk) ^ true)))
    {
      b.i(TAG, "startWithUpdateComposition", new Object[0]);
      locala = this.LmY;
      if (locala != null) {
        a.a(locala, paramh);
      }
      this.BGk = paramh;
      AppMethodBeat.o(220864);
      return;
    }
    if (p.i(paramh, this.BGk))
    {
      if (this.vWs != null)
      {
        b.i(TAG, "same composition directly start", new Object[0]);
        this.aLU = true;
        locala = this.LmY;
        if (locala != null)
        {
          a.a(locala, paramh);
          AppMethodBeat.o(220864);
          return;
        }
        AppMethodBeat.o(220864);
        return;
      }
      b.i(TAG, "same composition but surface is null", new Object[0]);
      this.aLU = true;
      AppMethodBeat.o(220864);
      return;
    }
    this.BGk = paramh;
    if ((this.vWs != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      cMq();
    }
    this.aLU = true;
    paramh = this.LmY;
    if (paramh != null)
    {
      paramh.start();
      AppMethodBeat.o(220864);
      return;
    }
    AppMethodBeat.o(220864);
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220859);
    a locala = this.LmY;
    if (locala != null)
    {
      locala.ar(paramLong1, paramLong2);
      AppMethodBeat.o(220859);
      return;
    }
    AppMethodBeat.o(220859);
  }
  
  public final void boO()
  {
    AppMethodBeat.i(220875);
    a locala = this.LmY;
    if (locala != null)
    {
      locala.fPI();
      AppMethodBeat.o(220875);
      return;
    }
    AppMethodBeat.o(220875);
  }
  
  protected void cMq()
  {
    AppMethodBeat.i(220866);
    if ((this.BGk != null) && (this.vWs != null))
    {
      b.i(TAG, "do createPlayer, composition:" + this.BGk, new Object[0]);
      Object localObject = this.BGk;
      if (localObject == null) {
        p.gfZ();
      }
      this.LmY = new a((h)localObject);
      localObject = this.LmY;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.vWs;
        if (localSurfaceTexture == null) {
          p.gfZ();
        }
        int i = this.surfaceWidth;
        int j = this.surfaceHeight;
        p.h(localSurfaceTexture, "surfaceTexture");
        ((a)localObject).surfaceWidth = i;
        ((a)localObject).surfaceHeight = j;
        ((a)localObject).surfaceTexture = localSurfaceTexture;
        b.i("VideoCompositionPlayer", "createPlayerLayerBySurfaceTexture: " + localSurfaceTexture + ", size:[" + i + ", " + j + ']', new Object[0]);
        ((a)localObject).playerLayer = new PlayerLayer(localSurfaceTexture, i, j);
        PlayerLayer localPlayerLayer = ((a)localObject).playerLayer;
        if (localPlayerLayer != null) {
          localPlayerLayer.setPlayer(((a)localObject).player);
        }
        ((a)localObject).Lne = true;
        b.i("VideoCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j, new Object[0]);
      }
      localObject = this.LmY;
      if (localObject != null) {
        ((a)localObject).setLoop(this.loop);
      }
      if (this.LmZ != null)
      {
        localObject = this.LmY;
        if (localObject != null) {
          ((a)localObject).setPlayerCallback(this.LmZ);
        }
      }
      localObject = this.LmY;
      if (localObject != null)
      {
        ((a)localObject).Lna = this.Lna;
        AppMethodBeat.o(220866);
        return;
      }
    }
    AppMethodBeat.o(220866);
  }
  
  protected final h getComposition()
  {
    return this.BGk;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.hlh;
  }
  
  protected final a getPlayer()
  {
    return this.LmY;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(220876);
    a locala = this.LmY;
    if (locala != null)
    {
      long l = locala.fPJ();
      AppMethodBeat.o(220876);
      return l;
    }
    AppMethodBeat.o(220876);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(220874);
    Object localObject = this.LmY;
    if (localObject != null)
    {
      localObject = ((a)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(220874);
        return bool;
      }
      AppMethodBeat.o(220874);
      return false;
    }
    AppMethodBeat.o(220874);
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220863);
    b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.vWs = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.BGk != null)
    {
      cMq();
      if (this.aLU)
      {
        paramSurfaceTexture = this.LmY;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(220863);
          return;
        }
      }
    }
    AppMethodBeat.o(220863);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(220862);
    b.i(TAG, "surfaceDestroy", new Object[0]);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.LmY;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.vWs = null;
    AppMethodBeat.o(220862);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220860);
    b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.LmY;
    if (paramSurfaceTexture != null)
    {
      b.i("VideoCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.BTM;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(220860);
      return;
    }
    AppMethodBeat.o(220860);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(220861);
    if ((this.hlh) && (this.aLU))
    {
      b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
      paramSurfaceTexture = this.LmZ;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.cLZ();
      }
      this.hlh = false;
    }
    a.a.a locala = this.LmZ;
    paramSurfaceTexture = locala;
    if (!(locala instanceof a.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (a.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.cMb();
      AppMethodBeat.o(220861);
      return;
    }
    AppMethodBeat.o(220861);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(220868);
    b.i(TAG, "pause", new Object[0]);
    this.aLU = false;
    a locala = this.LmY;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "pause", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.pause();
      }
      locala.aLU = false;
    }
    AppMethodBeat.o(220868);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(220871);
    b.i(TAG, "release", new Object[0]);
    this.aLU = false;
    a locala = this.LmY;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(220871);
      return;
    }
    AppMethodBeat.o(220871);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(220869);
    b.i(TAG, "resume", new Object[0]);
    this.aLU = true;
    a locala = this.LmY;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(220869);
      return;
    }
    AppMethodBeat.o(220869);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(220872);
    b.i(TAG, "seekTo:".concat(String.valueOf(paramLong)), new Object[0]);
    a locala = this.LmY;
    if (locala != null)
    {
      locala.seekTo(paramLong);
      AppMethodBeat.o(220872);
      return;
    }
    AppMethodBeat.o(220872);
  }
  
  protected final void setComposition(h paramh)
  {
    this.BGk = paramh;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.hlh = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(220873);
    b.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.loop = paramBoolean;
    if (this.LmY != null)
    {
      a locala = this.LmY;
      if (locala != null)
      {
        locala.setLoop(paramBoolean);
        AppMethodBeat.o(220873);
        return;
      }
      AppMethodBeat.o(220873);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(220873);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.BTM = paramm;
  }
  
  protected final void setPlayer(a parama)
  {
    this.LmY = parama;
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(220858);
    if (this.LmY != null)
    {
      a locala = this.LmY;
      if (locala != null) {
        locala.setPlayerCallback(parama);
      }
    }
    this.LmZ = parama;
    AppMethodBeat.o(220858);
  }
  
  public final void setPlayerProfileCallback(a.a.c paramc)
  {
    this.Lna = paramc;
    a locala = this.LmY;
    if (locala != null) {
      locala.Lna = paramc;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(220870);
    b.i(TAG, "stop", new Object[0]);
    this.aLU = false;
    this.hlh = true;
    a locala = this.LmY;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "stop", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.stop();
      }
      locala.aLU = false;
      AppMethodBeat.o(220870);
      return;
    }
    AppMethodBeat.o(220870);
  }
  
  public final void zc(boolean paramBoolean)
  {
    AppMethodBeat.i(220867);
    a locala = this.LmY;
    if (locala != null)
    {
      locala.zc(paramBoolean);
      AppMethodBeat.o(220867);
      return;
    }
    AppMethodBeat.o(220867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.VideoCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */