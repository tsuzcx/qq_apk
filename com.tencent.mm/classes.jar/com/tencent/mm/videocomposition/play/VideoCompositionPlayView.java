package com.tencent.mm.videocomposition.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.d.b;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getLaggingTime", "", "getPosition", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"}, k=1, mv={1, 1, 15})
public class VideoCompositionPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final String TAG = "VideoCompositionPlayView";
  public static final VideoCompositionPlayView.a agFh;
  private SurfaceTexture Ldt;
  private j Uaw;
  private m<? super Integer, ? super Integer, ah> UoD;
  private a agFe;
  private a.a.a agFf;
  private a.a.c agFg;
  private boolean isStarted;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private boolean ynV;
  
  static
  {
    AppMethodBeat.i(233584);
    agFh = new VideoCompositionPlayView.a((byte)0);
    TAG = "VideoCompositionPlayView";
    AppMethodBeat.o(233584);
  }
  
  public VideoCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(233577);
    this.loop = true;
    this.ynV = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(233577);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(233571);
    this.loop = true;
    this.ynV = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(233571);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(233566);
    this.loop = true;
    this.ynV = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(233566);
  }
  
  public final void NX(boolean paramBoolean)
  {
    AppMethodBeat.i(233708);
    a locala = this.agFe;
    if (locala != null)
    {
      locala.NX(paramBoolean);
      AppMethodBeat.o(233708);
      return;
    }
    AppMethodBeat.o(233708);
  }
  
  public void a(j paramj)
  {
    AppMethodBeat.i(233673);
    s.t(paramj, "composition");
    b.printInfoStack(TAG, hashCode() + " start, surface:" + this.Ldt + ", player:" + this.agFe + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramj.hashCode(), new Object[0]);
    a locala;
    if ((this.agFe != null) && (this.Ldt != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((s.p(paramj, this.Uaw) ^ true)))
    {
      b.i(TAG, "startWithUpdateComposition", new Object[0]);
      locala = this.agFe;
      if (locala != null) {
        a.a(locala, paramj);
      }
      this.Uaw = paramj;
      AppMethodBeat.o(233673);
      return;
    }
    if (s.p(paramj, this.Uaw))
    {
      if (this.Ldt != null)
      {
        b.i(TAG, "same composition directly start", new Object[0]);
        this.isStarted = true;
        locala = this.agFe;
        if (locala != null)
        {
          a.a(locala, paramj);
          AppMethodBeat.o(233673);
          return;
        }
        AppMethodBeat.o(233673);
        return;
      }
      b.i(TAG, "same composition but surface is null", new Object[0]);
      this.isStarted = true;
      AppMethodBeat.o(233673);
      return;
    }
    this.Uaw = paramj;
    if ((this.Ldt != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      fjm();
    }
    this.isStarted = true;
    paramj = this.agFe;
    if (paramj != null)
    {
      paramj.start();
      AppMethodBeat.o(233673);
      return;
    }
    AppMethodBeat.o(233673);
  }
  
  public final void a(j paramj, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(233682);
    s.t(paramj, "composition");
    b.i(TAG, "updateComposition, playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong, new Object[0]);
    a locala = this.agFe;
    if (locala != null) {
      locala.a(paramj, paramBoolean1, paramBoolean2, paramLong);
    }
    this.Uaw = paramj;
    AppMethodBeat.o(233682);
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(233633);
    a locala = this.agFe;
    if (locala != null)
    {
      locala.bs(paramLong1, paramLong2);
      AppMethodBeat.o(233633);
      return;
    }
    AppMethodBeat.o(233633);
  }
  
  public final void cxp()
  {
    AppMethodBeat.i(233732);
    a locala = this.agFe;
    if (locala != null)
    {
      locala.jMe();
      AppMethodBeat.o(233732);
      return;
    }
    AppMethodBeat.o(233732);
  }
  
  protected void fjm()
  {
    AppMethodBeat.i(233700);
    if ((this.Uaw != null) && (this.Ldt != null))
    {
      b.i(TAG, "do createPlayer, composition:" + this.Uaw, new Object[0]);
      Object localObject = this.Uaw;
      if (localObject == null) {
        s.klw();
      }
      this.agFe = new a((j)localObject);
      localObject = this.agFe;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.Ldt;
        if (localSurfaceTexture == null) {
          s.klw();
        }
        int i = this.surfaceWidth;
        int j = this.surfaceHeight;
        s.t(localSurfaceTexture, "surfaceTexture");
        ((a)localObject).surfaceWidth = i;
        ((a)localObject).surfaceHeight = j;
        ((a)localObject).surfaceTexture = localSurfaceTexture;
        b.i("VideoCompositionPlayer", "createPlayerLayerBySurfaceTexture: " + localSurfaceTexture + ", size:[" + i + ", " + j + ']', new Object[0]);
        ((a)localObject).playerLayer = new PlayerLayer(localSurfaceTexture, i, j);
        PlayerLayer localPlayerLayer = ((a)localObject).playerLayer;
        if (localPlayerLayer != null) {
          localPlayerLayer.setPlayer(((a)localObject).player);
        }
        ((a)localObject).agFk = true;
        b.i("VideoCompositionPlayer", "setSurfaceTexture: " + localSurfaceTexture + ", width:" + i + ", height:" + j, new Object[0]);
      }
      localObject = this.agFe;
      if (localObject != null) {
        ((a)localObject).setLoop(this.loop);
      }
      if (this.agFf != null)
      {
        localObject = this.agFe;
        if (localObject != null) {
          ((a)localObject).setPlayerCallback(this.agFf);
        }
      }
      localObject = this.agFe;
      if (localObject != null)
      {
        ((a)localObject).agFg = this.agFg;
        AppMethodBeat.o(233700);
        return;
      }
    }
    AppMethodBeat.o(233700);
  }
  
  protected final j getComposition()
  {
    return this.Uaw;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.ynV;
  }
  
  public final long getLaggingTime()
  {
    AppMethodBeat.i(233740);
    a locala = this.agFe;
    if (locala != null)
    {
      long l = locala.playerItem.getLaggingTime();
      AppMethodBeat.o(233740);
      return l;
    }
    AppMethodBeat.o(233740);
    return 0L;
  }
  
  protected final a getPlayer()
  {
    return this.agFe;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(233736);
    a locala = this.agFe;
    if (locala != null)
    {
      long l = locala.jMf();
      AppMethodBeat.o(233736);
      return l;
    }
    AppMethodBeat.o(233736);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(233728);
    Object localObject = this.agFe;
    if (localObject != null)
    {
      localObject = ((a)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(233728);
        return bool;
      }
      AppMethodBeat.o(233728);
      return false;
    }
    AppMethodBeat.o(233728);
    return false;
  }
  
  public final boolean isStarted()
  {
    return this.isStarted;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233665);
    s.t(paramSurfaceTexture, "surface");
    b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.Ldt = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.Uaw != null)
    {
      fjm();
      if (this.isStarted)
      {
        paramSurfaceTexture = this.agFe;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(233665);
          return;
        }
      }
    }
    AppMethodBeat.o(233665);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(233658);
    s.t(paramSurfaceTexture, "surface");
    b.i(TAG, "surfaceDestroy", new Object[0]);
    paramSurfaceTexture.release();
    paramSurfaceTexture = this.agFe;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.Ldt = null;
    AppMethodBeat.o(233658);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233643);
    s.t(paramSurfaceTexture, "surface");
    b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.agFe;
    if (paramSurfaceTexture != null)
    {
      b.i("VideoCompositionPlayer", "updateDisplaySize:[" + paramInt1 + ", " + paramInt2 + ']', new Object[0]);
      paramSurfaceTexture = paramSurfaceTexture.player;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.updateViewport(paramInt1, paramInt2);
      }
    }
    paramSurfaceTexture = this.UoD;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(233643);
      return;
    }
    AppMethodBeat.o(233643);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(233652);
    s.t(paramSurfaceTexture, "surface");
    if ((this.ynV) && (this.isStarted))
    {
      b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
      paramSurfaceTexture = this.agFf;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.fiA();
      }
      this.ynV = false;
    }
    a.a.a locala = this.agFf;
    paramSurfaceTexture = locala;
    if (!(locala instanceof a.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (a.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.fiC();
      AppMethodBeat.o(233652);
      return;
    }
    AppMethodBeat.o(233652);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(233712);
    b.i(TAG, "pause", new Object[0]);
    this.isStarted = false;
    a locala = this.agFe;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "pause", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.pause();
      }
      locala.isStarted = false;
    }
    AppMethodBeat.o(233712);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(233719);
    b.i(TAG, "release", new Object[0]);
    this.isStarted = false;
    a locala = this.agFe;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(233719);
      return;
    }
    AppMethodBeat.o(233719);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(233713);
    b.i(TAG, "resume", new Object[0]);
    this.isStarted = true;
    a locala = this.agFe;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(233713);
      return;
    }
    AppMethodBeat.o(233713);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(233723);
    b.i(TAG, "seekTo:".concat(String.valueOf(paramLong)), new Object[0]);
    a locala = this.agFe;
    if (locala != null)
    {
      locala.seekTo(paramLong);
      AppMethodBeat.o(233723);
      return;
    }
    AppMethodBeat.o(233723);
  }
  
  protected final void setComposition(j paramj)
  {
    this.Uaw = paramj;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.ynV = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(233726);
    b.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.loop = paramBoolean;
    if (this.agFe != null)
    {
      a locala = this.agFe;
      if (locala != null)
      {
        locala.setLoop(paramBoolean);
        AppMethodBeat.o(233726);
        return;
      }
      AppMethodBeat.o(233726);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(233726);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, ah> paramm)
  {
    this.UoD = paramm;
  }
  
  protected final void setPlayer(a parama)
  {
    this.agFe = parama;
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(233624);
    if (this.agFe != null)
    {
      a locala = this.agFe;
      if (locala != null) {
        locala.setPlayerCallback(parama);
      }
    }
    this.agFf = parama;
    AppMethodBeat.o(233624);
  }
  
  public final void setPlayerProfileCallback(a.a.c paramc)
  {
    this.agFg = paramc;
    a locala = this.agFe;
    if (locala != null) {
      locala.agFg = paramc;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(233717);
    b.i(TAG, "stop", new Object[0]);
    this.isStarted = false;
    this.ynV = true;
    a locala = this.agFe;
    if (locala != null)
    {
      b.i("VideoCompositionPlayer", "stop", new Object[0]);
      Player localPlayer = locala.player;
      if (localPlayer != null) {
        localPlayer.stop();
      }
      locala.isStarted = false;
      AppMethodBeat.o(233717);
      return;
    }
    AppMethodBeat.o(233717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.VideoCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */