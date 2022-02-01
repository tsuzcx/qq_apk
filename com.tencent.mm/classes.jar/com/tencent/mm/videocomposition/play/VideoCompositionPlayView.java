package com.tencent.mm.videocomposition.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getLaggingTime", "", "getPosition", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"})
public class VideoCompositionPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final String TAG = "VideoCompositionPlayView";
  public static final a YJp;
  private SurfaceTexture FhU;
  private m<? super Integer, ? super Integer, x> NBV;
  private j NmT;
  private a YJm;
  private a.a.a YJn;
  private a.a.c YJo;
  private boolean isStarted;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private boolean vcc;
  
  static
  {
    AppMethodBeat.i(248440);
    YJp = new a((byte)0);
    TAG = "VideoCompositionPlayView";
    AppMethodBeat.o(248440);
  }
  
  public VideoCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248438);
    this.loop = true;
    this.vcc = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(248438);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248435);
    this.loop = true;
    this.vcc = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(248435);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248433);
    this.loop = true;
    this.vcc = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(248433);
  }
  
  public final void Ib(boolean paramBoolean)
  {
    AppMethodBeat.i(248410);
    a locala = this.YJm;
    if (locala != null)
    {
      locala.Ib(paramBoolean);
      AppMethodBeat.o(248410);
      return;
    }
    AppMethodBeat.o(248410);
  }
  
  public void a(j paramj)
  {
    AppMethodBeat.i(248402);
    p.k(paramj, "composition");
    b.printInfoStack(TAG, hashCode() + " start, surface:" + this.FhU + ", player:" + this.YJm + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramj.hashCode(), new Object[0]);
    a locala;
    if ((this.YJm != null) && (this.FhU != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((p.h(paramj, this.NmT) ^ true)))
    {
      b.i(TAG, "startWithUpdateComposition", new Object[0]);
      locala = this.YJm;
      if (locala != null) {
        a.a(locala, paramj);
      }
      this.NmT = paramj;
      AppMethodBeat.o(248402);
      return;
    }
    if (p.h(paramj, this.NmT))
    {
      if (this.FhU != null)
      {
        b.i(TAG, "same composition directly start", new Object[0]);
        this.isStarted = true;
        locala = this.YJm;
        if (locala != null)
        {
          a.a(locala, paramj);
          AppMethodBeat.o(248402);
          return;
        }
        AppMethodBeat.o(248402);
        return;
      }
      b.i(TAG, "same composition but surface is null", new Object[0]);
      this.isStarted = true;
      AppMethodBeat.o(248402);
      return;
    }
    this.NmT = paramj;
    if ((this.FhU != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      ehi();
    }
    this.isStarted = true;
    paramj = this.YJm;
    if (paramj != null)
    {
      paramj.start();
      AppMethodBeat.o(248402);
      return;
    }
    AppMethodBeat.o(248402);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(248404);
    p.k(paramj, "composition");
    b.i(TAG, "updateComposition, playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong, new Object[0]);
    a locala = this.YJm;
    if (locala != null) {
      locala.a(paramj, paramBoolean1, paramBoolean2, paramLong);
    }
    this.NmT = paramj;
    AppMethodBeat.o(248404);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248395);
    a locala = this.YJm;
    if (locala != null)
    {
      locala.aG(paramLong1, paramLong2);
      AppMethodBeat.o(248395);
      return;
    }
    AppMethodBeat.o(248395);
  }
  
  public final void bXe()
  {
    AppMethodBeat.i(248428);
    a locala = this.YJm;
    if (locala != null)
    {
      locala.igP();
      AppMethodBeat.o(248428);
      return;
    }
    AppMethodBeat.o(248428);
  }
  
  protected void ehi()
  {
    AppMethodBeat.i(248408);
    if ((this.NmT != null) && (this.FhU != null))
    {
      b.i(TAG, "do createPlayer, composition:" + this.NmT, new Object[0]);
      Object localObject = this.NmT;
      if (localObject == null) {
        p.iCn();
      }
      this.YJm = new a((j)localObject);
      localObject = this.YJm;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.FhU;
        if (localSurfaceTexture == null) {
          p.iCn();
        }
        int i = this.surfaceWidth;
        int j = this.surfaceHeight;
        p.k(localSurfaceTexture, "surfaceTexture");
        ((a)localObject).surfaceWidth = i;
        ((a)localObject).surfaceHeight = j;
        ((a)localObject).surfaceTexture = localSurfaceTexture;
        b.i("VideoCompositionPlayer", "createPlayerLayerBySurfaceTexture: " + localSurfaceTexture + ", size:[" + i + ", " + j + ']', new Object[0]);
        ((a)localObject).playerLayer = new PlayerLayer(localSurfaceTexture, i, j);
        PlayerLayer localPlayerLayer = ((a)localObject).playerLayer;
        if (localPlayerLayer != null) {
          localPlayerLayer.setPlayer(((a)localObject).player);
        }
        ((a)localObject).YJs = true;
        b.i("VideoCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j, new Object[0]);
      }
      localObject = this.YJm;
      if (localObject != null) {
        ((a)localObject).setLoop(this.loop);
      }
      if (this.YJn != null)
      {
        localObject = this.YJm;
        if (localObject != null) {
          ((a)localObject).setPlayerCallback(this.YJn);
        }
      }
      localObject = this.YJm;
      if (localObject != null)
      {
        ((a)localObject).YJo = this.YJo;
        AppMethodBeat.o(248408);
        return;
      }
    }
    AppMethodBeat.o(248408);
  }
  
  protected final j getComposition()
  {
    return this.NmT;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.vcc;
  }
  
  public final long getLaggingTime()
  {
    AppMethodBeat.i(248431);
    a locala = this.YJm;
    if (locala != null)
    {
      long l = locala.playerItem.getLaggingTime();
      AppMethodBeat.o(248431);
      return l;
    }
    AppMethodBeat.o(248431);
    return 0L;
  }
  
  protected final a getPlayer()
  {
    return this.YJm;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(248430);
    a locala = this.YJm;
    if (locala != null)
    {
      long l = locala.igQ();
      AppMethodBeat.o(248430);
      return l;
    }
    AppMethodBeat.o(248430);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(248427);
    Object localObject = this.YJm;
    if (localObject != null)
    {
      localObject = ((a)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(248427);
        return bool;
      }
      AppMethodBeat.o(248427);
      return false;
    }
    AppMethodBeat.o(248427);
    return false;
  }
  
  public final boolean isStarted()
  {
    return this.isStarted;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248400);
    b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.FhU = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.NmT != null)
    {
      ehi();
      if (this.isStarted)
      {
        paramSurfaceTexture = this.YJm;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(248400);
          return;
        }
      }
    }
    AppMethodBeat.o(248400);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248399);
    b.i(TAG, "surfaceDestroy", new Object[0]);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.YJm;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.FhU = null;
    AppMethodBeat.o(248399);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248396);
    b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.YJm;
    if (paramSurfaceTexture != null)
    {
      b.i("VideoCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.NBV;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(248396);
      return;
    }
    AppMethodBeat.o(248396);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248397);
    if ((this.vcc) && (this.isStarted))
    {
      b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
      paramSurfaceTexture = this.YJn;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.egD();
      }
      this.vcc = false;
    }
    a.a.a locala = this.YJn;
    paramSurfaceTexture = locala;
    if (!(locala instanceof a.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (a.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.egF();
      AppMethodBeat.o(248397);
      return;
    }
    AppMethodBeat.o(248397);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(248411);
    b.i(TAG, "pause", new Object[0]);
    this.isStarted = false;
    a locala = this.YJm;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "pause", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.pause();
      }
      locala.isStarted = false;
    }
    AppMethodBeat.o(248411);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(248419);
    b.i(TAG, "release", new Object[0]);
    this.isStarted = false;
    a locala = this.YJm;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(248419);
      return;
    }
    AppMethodBeat.o(248419);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(248414);
    b.i(TAG, "resume", new Object[0]);
    this.isStarted = true;
    a locala = this.YJm;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(248414);
      return;
    }
    AppMethodBeat.o(248414);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(248422);
    b.i(TAG, "seekTo:".concat(String.valueOf(paramLong)), new Object[0]);
    a locala = this.YJm;
    if (locala != null)
    {
      locala.seekTo(paramLong);
      AppMethodBeat.o(248422);
      return;
    }
    AppMethodBeat.o(248422);
  }
  
  protected final void setComposition(j paramj)
  {
    this.NmT = paramj;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.vcc = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(248424);
    b.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.loop = paramBoolean;
    if (this.YJm != null)
    {
      a locala = this.YJm;
      if (locala != null)
      {
        locala.setLoop(paramBoolean);
        AppMethodBeat.o(248424);
        return;
      }
      AppMethodBeat.o(248424);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(248424);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> paramm)
  {
    this.NBV = paramm;
  }
  
  protected final void setPlayer(a parama)
  {
    this.YJm = parama;
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(248394);
    if (this.YJm != null)
    {
      a locala = this.YJm;
      if (locala != null) {
        locala.setPlayerCallback(parama);
      }
    }
    this.YJn = parama;
    AppMethodBeat.o(248394);
  }
  
  public final void setPlayerProfileCallback(a.a.c paramc)
  {
    this.YJo = paramc;
    a locala = this.YJm;
    if (locala != null) {
      locala.YJo = paramc;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(248417);
    b.i(TAG, "stop", new Object[0]);
    this.isStarted = false;
    this.vcc = true;
    a locala = this.YJm;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "stop", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.stop();
      }
      locala.isStarted = false;
      AppMethodBeat.o(248417);
      return;
    }
    AppMethodBeat.o(248417);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.VideoCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */