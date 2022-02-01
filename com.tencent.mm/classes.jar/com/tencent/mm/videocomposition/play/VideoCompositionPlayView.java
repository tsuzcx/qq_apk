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

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getPosition", "", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"})
public class VideoCompositionPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VideoCompositionPlayView.a LJM;
  public static final String TAG = "VideoCompositionPlayView";
  public h BXI;
  private m<? super Integer, ? super Integer, z> Cln;
  public a LJJ;
  private a.a.a LJK;
  private a.a.c LJL;
  protected boolean aLU;
  private boolean hnW;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private SurfaceTexture wiw;
  
  static
  {
    AppMethodBeat.i(195015);
    LJM = new VideoCompositionPlayView.a((byte)0);
    TAG = "VideoCompositionPlayView";
    AppMethodBeat.o(195015);
  }
  
  public VideoCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195014);
    this.loop = true;
    this.hnW = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(195014);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195013);
    this.loop = true;
    this.hnW = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(195013);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195012);
    this.loop = true;
    this.hnW = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(195012);
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(195000);
    p.h(paramh, "composition");
    b.m(TAG, hashCode() + " start, surface:" + this.wiw + ", player:" + this.LJJ + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramh.hashCode(), new Object[0]);
    a locala;
    if ((this.LJJ != null) && (this.wiw != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((p.i(paramh, this.BXI) ^ true)))
    {
      b.i(TAG, "startWithUpdateComposition", new Object[0]);
      locala = this.LJJ;
      if (locala != null) {
        a.a(locala, paramh);
      }
      this.BXI = paramh;
      AppMethodBeat.o(195000);
      return;
    }
    if (p.i(paramh, this.BXI))
    {
      if (this.wiw != null)
      {
        b.i(TAG, "same composition directly start", new Object[0]);
        this.aLU = true;
        locala = this.LJJ;
        if (locala != null)
        {
          a.a(locala, paramh);
          AppMethodBeat.o(195000);
          return;
        }
        AppMethodBeat.o(195000);
        return;
      }
      b.i(TAG, "same composition but surface is null", new Object[0]);
      this.aLU = true;
      AppMethodBeat.o(195000);
      return;
    }
    this.BXI = paramh;
    if ((this.wiw != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      cOZ();
    }
    this.aLU = true;
    paramh = this.LJJ;
    if (paramh != null)
    {
      paramh.start();
      AppMethodBeat.o(195000);
      return;
    }
    AppMethodBeat.o(195000);
  }
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194995);
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.aq(paramLong1, paramLong2);
      AppMethodBeat.o(194995);
      return;
    }
    AppMethodBeat.o(194995);
  }
  
  public final void bpy()
  {
    AppMethodBeat.i(195010);
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.fUe();
      AppMethodBeat.o(195010);
      return;
    }
    AppMethodBeat.o(195010);
  }
  
  protected void cOZ()
  {
    AppMethodBeat.i(195001);
    if ((this.BXI != null) && (this.wiw != null))
    {
      b.i(TAG, "do createPlayer, composition:" + this.BXI, new Object[0]);
      Object localObject = this.BXI;
      if (localObject == null) {
        p.gkB();
      }
      this.LJJ = new a((h)localObject);
      localObject = this.LJJ;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.wiw;
        if (localSurfaceTexture == null) {
          p.gkB();
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
        ((a)localObject).LJP = true;
        b.i("VideoCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j, new Object[0]);
      }
      localObject = this.LJJ;
      if (localObject != null) {
        ((a)localObject).setLoop(this.loop);
      }
      if (this.LJK != null)
      {
        localObject = this.LJJ;
        if (localObject != null) {
          ((a)localObject).setPlayerCallback(this.LJK);
        }
      }
      localObject = this.LJJ;
      if (localObject != null)
      {
        ((a)localObject).LJL = this.LJL;
        AppMethodBeat.o(195001);
        return;
      }
    }
    AppMethodBeat.o(195001);
  }
  
  protected final h getComposition()
  {
    return this.BXI;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.hnW;
  }
  
  protected final a getPlayer()
  {
    return this.LJJ;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(195011);
    a locala = this.LJJ;
    if (locala != null)
    {
      long l = locala.fUf();
      AppMethodBeat.o(195011);
      return l;
    }
    AppMethodBeat.o(195011);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(195009);
    Object localObject = this.LJJ;
    if (localObject != null)
    {
      localObject = ((a)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(195009);
        return bool;
      }
      AppMethodBeat.o(195009);
      return false;
    }
    AppMethodBeat.o(195009);
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194999);
    b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.wiw = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.BXI != null)
    {
      cOZ();
      if (this.aLU)
      {
        paramSurfaceTexture = this.LJJ;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(194999);
          return;
        }
      }
    }
    AppMethodBeat.o(194999);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(194998);
    b.i(TAG, "surfaceDestroy", new Object[0]);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.LJJ;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.wiw = null;
    AppMethodBeat.o(194998);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194996);
    b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.LJJ;
    if (paramSurfaceTexture != null)
    {
      b.i("VideoCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.Cln;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(194996);
      return;
    }
    AppMethodBeat.o(194996);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(194997);
    if ((this.hnW) && (this.aLU))
    {
      b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
      paramSurfaceTexture = this.LJK;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.cOH();
      }
      this.hnW = false;
    }
    a.a.a locala = this.LJK;
    paramSurfaceTexture = locala;
    if (!(locala instanceof a.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (a.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.cOJ();
      AppMethodBeat.o(194997);
      return;
    }
    AppMethodBeat.o(194997);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(195003);
    b.i(TAG, "pause", new Object[0]);
    this.aLU = false;
    a locala = this.LJJ;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "pause", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.pause();
      }
      locala.aLU = false;
    }
    AppMethodBeat.o(195003);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(195006);
    b.i(TAG, "release", new Object[0]);
    this.aLU = false;
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(195006);
      return;
    }
    AppMethodBeat.o(195006);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(195004);
    b.i(TAG, "resume", new Object[0]);
    this.aLU = true;
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(195004);
      return;
    }
    AppMethodBeat.o(195004);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(195007);
    b.i(TAG, "seekTo:".concat(String.valueOf(paramLong)), new Object[0]);
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.seekTo(paramLong);
      AppMethodBeat.o(195007);
      return;
    }
    AppMethodBeat.o(195007);
  }
  
  protected final void setComposition(h paramh)
  {
    this.BXI = paramh;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.hnW = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(195008);
    b.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.loop = paramBoolean;
    if (this.LJJ != null)
    {
      a locala = this.LJJ;
      if (locala != null)
      {
        locala.setLoop(paramBoolean);
        AppMethodBeat.o(195008);
        return;
      }
      AppMethodBeat.o(195008);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(195008);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, z> paramm)
  {
    this.Cln = paramm;
  }
  
  protected final void setPlayer(a parama)
  {
    this.LJJ = parama;
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(194994);
    if (this.LJJ != null)
    {
      a locala = this.LJJ;
      if (locala != null) {
        locala.setPlayerCallback(parama);
      }
    }
    this.LJK = parama;
    AppMethodBeat.o(194994);
  }
  
  public final void setPlayerProfileCallback(a.a.c paramc)
  {
    this.LJL = paramc;
    a locala = this.LJJ;
    if (locala != null) {
      locala.LJL = paramc;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(195005);
    b.i(TAG, "stop", new Object[0]);
    this.aLU = false;
    this.hnW = true;
    a locala = this.LJJ;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "stop", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.stop();
      }
      locala.aLU = false;
      AppMethodBeat.o(195005);
      return;
    }
    AppMethodBeat.o(195005);
  }
  
  public final void zq(boolean paramBoolean)
  {
    AppMethodBeat.i(195002);
    a locala = this.LJJ;
    if (locala != null)
    {
      locala.zq(paramBoolean);
      AppMethodBeat.o(195002);
      return;
    }
    AppMethodBeat.o(195002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.VideoCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */