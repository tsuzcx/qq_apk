package com.tencent.mm.videocomposition.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.mm.videocomposition.n;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "callback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerCallback;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "setComposition", "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "firstFrame", "", "getFirstFrame", "()Z", "setFirstFrame", "(Z)V", "isStarted", "loop", "onSizeChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "player", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "getPlayer", "()Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;", "setPlayer", "(Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer;)V", "profileCallback", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "surface", "Landroid/graphics/SurfaceTexture;", "surfaceHeight", "surfaceWidth", "createPlayer", "flushSurface", "getLaggingTime", "", "getPosition", "isLoop", "isPlaying", "muteOrigin", "mute", "onSurfaceTextureAvailable", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "release", "resume", "seekTo", "timeMs", "setLoop", "setOnSizeChangedListener", "setPlayRange", "start", "end", "setPlayerCallback", "setPlayerProfileCallback", "startWithUpdateComposition", "stop", "updateComposition", "playAfterUpdate", "seekToOriginPosition", "Companion", "video_composition_release"})
public class VideoCompositionPlayView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  public static final VideoCompositionPlayView.a RhF;
  public static final String TAG = "VideoCompositionPlayView";
  private m<? super Integer, ? super Integer, x> GOp;
  public n Gez;
  public a RhC;
  private a.a.a RhD;
  private a.a.c RhE;
  private boolean ihq;
  protected boolean isStarted;
  public boolean loop;
  private int surfaceHeight;
  private int surfaceWidth;
  private SurfaceTexture zCV;
  
  static
  {
    AppMethodBeat.i(216818);
    RhF = new VideoCompositionPlayView.a((byte)0);
    TAG = "VideoCompositionPlayView";
    AppMethodBeat.o(216818);
  }
  
  public VideoCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216817);
    this.loop = true;
    this.ihq = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(216817);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216816);
    this.loop = true;
    this.ihq = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(216816);
  }
  
  public VideoCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216815);
    this.loop = true;
    this.ihq = true;
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    b.i(TAG, "create VLogCompositionPlayView", new Object[0]);
    AppMethodBeat.o(216815);
  }
  
  public final void DB(boolean paramBoolean)
  {
    AppMethodBeat.i(216804);
    a locala = this.RhC;
    if (locala != null)
    {
      locala.DB(paramBoolean);
      AppMethodBeat.o(216804);
      return;
    }
    AppMethodBeat.o(216804);
  }
  
  public void a(n paramn)
  {
    AppMethodBeat.i(216802);
    p.h(paramn, "composition");
    b.printInfoStack(TAG, hashCode() + " start, surface:" + this.zCV + ", player:" + this.RhC + ", surfaceWidth:" + this.surfaceWidth + ", surfaceHeight:" + this.surfaceHeight + ", composition:" + paramn.hashCode(), new Object[0]);
    a locala;
    if ((this.RhC != null) && (this.zCV != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0) && ((p.j(paramn, this.Gez) ^ true)))
    {
      b.i(TAG, "startWithUpdateComposition", new Object[0]);
      locala = this.RhC;
      if (locala != null) {
        a.a(locala, paramn, true, 0L, 12);
      }
      this.Gez = paramn;
      AppMethodBeat.o(216802);
      return;
    }
    if (p.j(paramn, this.Gez))
    {
      if (this.zCV != null)
      {
        b.i(TAG, "same composition directly start", new Object[0]);
        this.isStarted = true;
        locala = this.RhC;
        if (locala != null)
        {
          a.a(locala, paramn, true, 0L, 12);
          AppMethodBeat.o(216802);
          return;
        }
        AppMethodBeat.o(216802);
        return;
      }
      b.i(TAG, "same composition but surface is null", new Object[0]);
      this.isStarted = true;
      AppMethodBeat.o(216802);
      return;
    }
    this.Gez = paramn;
    if ((this.zCV != null) && (this.surfaceWidth > 0) && (this.surfaceHeight > 0)) {
      dFu();
    }
    this.isStarted = true;
    paramn = this.RhC;
    if (paramn != null)
    {
      paramn.start();
      AppMethodBeat.o(216802);
      return;
    }
    AppMethodBeat.o(216802);
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(216797);
    a locala = this.RhC;
    if (locala != null)
    {
      locala.at(paramLong1, paramLong2);
      AppMethodBeat.o(216797);
      return;
    }
    AppMethodBeat.o(216797);
  }
  
  public final void bLe()
  {
    AppMethodBeat.i(216812);
    a locala = this.RhC;
    if (locala != null)
    {
      locala.hft();
      AppMethodBeat.o(216812);
      return;
    }
    AppMethodBeat.o(216812);
  }
  
  protected void dFu()
  {
    AppMethodBeat.i(216803);
    if ((this.Gez != null) && (this.zCV != null))
    {
      b.i(TAG, "do createPlayer, composition:" + this.Gez, new Object[0]);
      Object localObject = this.Gez;
      if (localObject == null) {
        p.hyc();
      }
      this.RhC = new a((n)localObject);
      localObject = this.RhC;
      if (localObject != null)
      {
        SurfaceTexture localSurfaceTexture = this.zCV;
        if (localSurfaceTexture == null) {
          p.hyc();
        }
        ((a)localObject).c(localSurfaceTexture, this.surfaceWidth, this.surfaceHeight);
      }
      localObject = this.RhC;
      if (localObject != null) {
        ((a)localObject).setLoop(this.loop);
      }
      if (this.RhD != null)
      {
        localObject = this.RhC;
        if (localObject != null) {
          ((a)localObject).setPlayerCallback(this.RhD);
        }
      }
      localObject = this.RhC;
      if (localObject != null)
      {
        ((a)localObject).RhE = this.RhE;
        AppMethodBeat.o(216803);
        return;
      }
    }
    AppMethodBeat.o(216803);
  }
  
  protected final n getComposition()
  {
    return this.Gez;
  }
  
  protected final boolean getFirstFrame()
  {
    return this.ihq;
  }
  
  public final long getLaggingTime()
  {
    AppMethodBeat.i(216814);
    a locala = this.RhC;
    if (locala != null)
    {
      long l = locala.playerItem.getLaggingTime();
      AppMethodBeat.o(216814);
      return l;
    }
    AppMethodBeat.o(216814);
    return 0L;
  }
  
  protected final a getPlayer()
  {
    return this.RhC;
  }
  
  public final long getPosition()
  {
    AppMethodBeat.i(216813);
    a locala = this.RhC;
    if (locala != null)
    {
      long l = locala.hfu();
      AppMethodBeat.o(216813);
      return l;
    }
    AppMethodBeat.o(216813);
    return 0L;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(216811);
    Object localObject = this.RhC;
    if (localObject != null)
    {
      localObject = ((a)localObject).player;
      if (localObject != null)
      {
        boolean bool = ((Player)localObject).isPlaying();
        AppMethodBeat.o(216811);
        return bool;
      }
      AppMethodBeat.o(216811);
      return false;
    }
    AppMethodBeat.o(216811);
    return false;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216801);
    b.i(TAG, "surfaceAvailable, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.zCV = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    if (this.Gez != null)
    {
      dFu();
      if (this.isStarted)
      {
        paramSurfaceTexture = this.RhC;
        if (paramSurfaceTexture != null)
        {
          paramSurfaceTexture.start();
          AppMethodBeat.o(216801);
          return;
        }
      }
    }
    AppMethodBeat.o(216801);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(216800);
    b.i(TAG, "surfaceDestroy", new Object[0]);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    paramSurfaceTexture = this.RhC;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.release();
    }
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.zCV = null;
    AppMethodBeat.o(216800);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216798);
    b.i(TAG, "surfaceSizeChanged, surfaceTexture:" + getSurfaceTexture() + ", width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    paramSurfaceTexture = this.RhC;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.lX(paramInt1, paramInt2);
    }
    paramSurfaceTexture = this.GOp;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(216798);
      return;
    }
    AppMethodBeat.o(216798);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(216799);
    if ((this.ihq) && (this.isStarted))
    {
      b.i(TAG, "onSurfaceTextureUpdated", new Object[0]);
      paramSurfaceTexture = this.RhD;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.dEU();
      }
      this.ihq = false;
    }
    a.a.a locala = this.RhD;
    paramSurfaceTexture = locala;
    if (!(locala instanceof a.a.b)) {
      paramSurfaceTexture = null;
    }
    paramSurfaceTexture = (a.a.b)paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.dEW();
      AppMethodBeat.o(216799);
      return;
    }
    AppMethodBeat.o(216799);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(216805);
    b.i(TAG, "pause", new Object[0]);
    this.isStarted = false;
    a locala = this.RhC;
    if (locala != null) {
      locala.pause();
    }
    AppMethodBeat.o(216805);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(216808);
    b.i(TAG, "release", new Object[0]);
    this.isStarted = false;
    a locala = this.RhC;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(216808);
      return;
    }
    AppMethodBeat.o(216808);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(216806);
    b.i(TAG, "resume", new Object[0]);
    this.isStarted = true;
    a locala = this.RhC;
    if (locala != null)
    {
      locala.start();
      AppMethodBeat.o(216806);
      return;
    }
    AppMethodBeat.o(216806);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(216809);
    b.i(TAG, "seekTo:".concat(String.valueOf(paramLong)), new Object[0]);
    a locala = this.RhC;
    if (locala != null)
    {
      locala.seekTo(paramLong);
      AppMethodBeat.o(216809);
      return;
    }
    AppMethodBeat.o(216809);
  }
  
  protected final void setComposition(n paramn)
  {
    this.Gez = paramn;
  }
  
  protected final void setFirstFrame(boolean paramBoolean)
  {
    this.ihq = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(216810);
    b.i(TAG, "setLoop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    this.loop = paramBoolean;
    if (this.RhC != null)
    {
      a locala = this.RhC;
      if (locala != null)
      {
        locala.setLoop(paramBoolean);
        AppMethodBeat.o(216810);
        return;
      }
      AppMethodBeat.o(216810);
      return;
    }
    this.loop = paramBoolean;
    AppMethodBeat.o(216810);
  }
  
  public final void setOnSizeChangedListener(m<? super Integer, ? super Integer, x> paramm)
  {
    this.GOp = paramm;
  }
  
  protected final void setPlayer(a parama)
  {
    this.RhC = parama;
  }
  
  public final void setPlayerCallback(a.a.a parama)
  {
    AppMethodBeat.i(216796);
    if (this.RhC != null)
    {
      a locala = this.RhC;
      if (locala != null) {
        locala.setPlayerCallback(parama);
      }
    }
    this.RhD = parama;
    AppMethodBeat.o(216796);
  }
  
  public final void setPlayerProfileCallback(a.a.c paramc)
  {
    this.RhE = paramc;
    a locala = this.RhC;
    if (locala != null) {
      locala.RhE = paramc;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(216807);
    b.i(TAG, "stop", new Object[0]);
    this.isStarted = false;
    this.ihq = true;
    a locala = this.RhC;
    if (locala != null)
    {
      locala.stop();
      AppMethodBeat.o(216807);
      return;
    }
    AppMethodBeat.o(216807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.VideoCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */