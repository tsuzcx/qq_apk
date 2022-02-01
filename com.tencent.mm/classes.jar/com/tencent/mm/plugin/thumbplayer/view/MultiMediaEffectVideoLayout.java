package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.c.b.c;
import com.tencent.mm.plugin.thumbplayer.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.effect.h;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "value", "Lkotlin/Function0;", "", "firstFrameRenderCallback", "getFirstFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFirstFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastPauseMusicPosition", "", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mediaChangeListener", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "mvMusicProxy", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getMvMusicProxy", "()Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "setMvMusicProxy", "(Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;)V", "onPlayFinishListener", "getOnPlayFinishListener", "setOnPlayFinishListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "timeMs", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "mediaInfo", "onProgressCallback", "getOnProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setOnProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "", "pauseOnVideoPlay", "getPauseOnVideoPlay", "()Z", "setPauseOnVideoPlay", "(Z)V", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "playStatusChangeListener", "getPlayStatusChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "setPlayStatusChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;)V", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "textureView", "Landroid/view/TextureView;", "<set-?>", "totalDuration", "getTotalDuration", "()J", "clearPlayRange", "getCurrentPositionMs", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMediaList", "", "getThumbFetcherExtraData", "", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "refreshFrame", "release", "requestSnapshot", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "resume", "seekTo", "seekToIndex", "index", "seekToIndexTime", "seekToMusic", "setLoop", "loop", "setMediaList", "mediaList", "setMute", "mute", "setPlayLoopForMedia", "media", "setPlayRange", "startTimeMs", "endTimeMs", "setTransition", "prevTransitionMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "transitionPath", "start", "startIgnoreMusicPosition", "stop", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiMediaEffectVideoLayout
  extends FrameLayout
  implements TextureView.SurfaceTextureListener
{
  private d Meq;
  public final String TAG;
  private b.c TCK;
  private boolean TCM;
  private a<ah> TCN;
  private m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.a.b, ah> TCO;
  private a<ah> TCQ;
  private b TGB;
  public final com.tencent.mm.plugin.thumbplayer.c.b TGY;
  public long TGZ;
  private final TextureView cHz;
  
  public MultiMediaEffectVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272401);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.cHz = new TextureView(getContext());
    this.TGY = new com.tencent.mm.plugin.thumbplayer.c.b();
    this.TGZ = -1L;
    this.cHz.setAlpha(1.0F);
    this.cHz.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.cHz, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(272401);
  }
  
  public MultiMediaEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272408);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.cHz = new TextureView(getContext());
    this.TGY = new com.tencent.mm.plugin.thumbplayer.c.b();
    this.TGZ = -1L;
    this.cHz.setAlpha(1.0F);
    this.cHz.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.cHz, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(272408);
  }
  
  public MultiMediaEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272416);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.cHz = new TextureView(getContext());
    this.TGY = new com.tencent.mm.plugin.thumbplayer.c.b();
    this.TGZ = -1L;
    this.cHz.setAlpha(1.0F);
    this.cHz.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.cHz, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(272416);
  }
  
  public final void a(com.tencent.mm.plugin.thumbplayer.d.d paramd, String paramString)
  {
    AppMethodBeat.i(272572);
    s.u(paramd, "prevTransitionMedia");
    this.TGY.a(paramd, paramString);
    AppMethodBeat.o(272572);
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(272574);
    this.TGY.bs(paramLong1, paramLong2);
    AppMethodBeat.o(272574);
  }
  
  public final long getCurrentPositionMs()
  {
    return this.TGY.TCX;
  }
  
  public final EffectManager getEffectManager()
  {
    return this.TGY.TCR.GpO;
  }
  
  public final a<ah> getFirstFrameRenderCallback()
  {
    return this.TCN;
  }
  
  public final d getMediaChangeListener()
  {
    return this.Meq;
  }
  
  public final List<com.tencent.mm.plugin.thumbplayer.a.b> getMediaList()
  {
    return (List)this.TGY.ofu;
  }
  
  public final b getMvMusicProxy()
  {
    return this.TGB;
  }
  
  public final a<ah> getOnPlayFinishListener()
  {
    return this.TCQ;
  }
  
  public final m<Long, com.tencent.mm.plugin.thumbplayer.a.b, ah> getOnProgressCallback()
  {
    return this.TCO;
  }
  
  public final boolean getPauseOnVideoPlay()
  {
    return this.TCM;
  }
  
  public final b.c getPlayStatusChangeListener()
  {
    return this.TCK;
  }
  
  public final c getReportInfo()
  {
    return this.TGY.TDf;
  }
  
  public final long getTotalDuration()
  {
    AppMethodBeat.i(272493);
    com.tencent.mm.plugin.thumbplayer.c.d locald = this.TGY.TCV;
    if (locald == null)
    {
      AppMethodBeat.o(272493);
      return 0L;
    }
    long l = locald.getDuration();
    AppMethodBeat.o(272493);
    return l;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272595);
    s.u(paramSurfaceTexture, "surface");
    Log.i(this.TAG, "onSurfaceTextureAvailable, size:[" + paramInt1 + ',' + paramInt2 + "], surface:" + paramSurfaceTexture);
    this.TGY.setSize(paramInt1, paramInt2);
    com.tencent.mm.plugin.thumbplayer.c.b localb = this.TGY;
    s.u(paramSurfaceTexture, "surface");
    Log.i(localb.TAG, s.X("attachSurface:", paramSurfaceTexture));
    localb.TCR.setSurface(new Surface(paramSurfaceTexture));
    localb.Ldt = paramSurfaceTexture;
    AppMethodBeat.o(272595);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272590);
    s.u(paramSurfaceTexture, "surface");
    Log.i(this.TAG, s.X("onSurfaceTextureDestroyed:", paramSurfaceTexture));
    paramSurfaceTexture = this.TGY;
    Log.i(paramSurfaceTexture.TAG, "detachSurface");
    paramSurfaceTexture.TCR.setSurface(null);
    paramSurfaceTexture.Ldt = null;
    AppMethodBeat.o(272590);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272584);
    s.u(paramSurfaceTexture, "surface");
    Log.i(this.TAG, "onSurfaceTextureSizeChanged, size:[" + paramInt1 + ',' + paramInt2 + "], surface:" + paramSurfaceTexture);
    this.TGY.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(272584);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272586);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(272586);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(272541);
    this.TGY.pause();
    b localb = this.TGB;
    if (localb == null) {}
    for (long l = -1L;; l = localb.getCurrentPosition())
    {
      this.TGZ = l;
      AppMethodBeat.o(272541);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(272548);
    this.TGY.seekTo(paramLong);
    AppMethodBeat.o(272548);
  }
  
  public final void setFirstFrameRenderCallback(a<ah> parama)
  {
    this.TGY.TCN = parama;
    this.TCN = parama;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(272555);
    this.TGY.setLoop(paramBoolean);
    AppMethodBeat.o(272555);
  }
  
  public final void setMediaChangeListener(d paramd)
  {
    this.TGY.TCL = paramd;
    this.Meq = paramd;
  }
  
  public final void setMediaList(List<? extends com.tencent.mm.plugin.thumbplayer.a.b> paramList)
  {
    AppMethodBeat.i(272505);
    s.u(paramList, "mediaList");
    com.tencent.mm.plugin.thumbplayer.c.b.a(this.TGY, paramList);
    AppMethodBeat.o(272505);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(272515);
    com.tencent.mm.plugin.thumbplayer.c.b localb = this.TGY;
    Log.i(localb.TAG, s.X("setMute:", Boolean.valueOf(paramBoolean)));
    localb.nLP = paramBoolean;
    AppMethodBeat.o(272515);
  }
  
  public final void setMvMusicProxy(b paramb)
  {
    this.TGB = paramb;
  }
  
  public final void setOnPlayFinishListener(a<ah> parama)
  {
    this.TGY.TCQ = parama;
    this.TCQ = parama;
  }
  
  public final void setOnProgressCallback(m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.a.b, ah> paramm)
  {
    this.TGY.TCO = paramm;
    this.TCO = paramm;
  }
  
  public final void setPauseOnVideoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(272451);
    Log.i(this.TAG, s.X("set pauseOnVideoPlay:", Boolean.valueOf(paramBoolean)));
    this.TGY.TCM = paramBoolean;
    this.TCM = paramBoolean;
    AppMethodBeat.o(272451);
  }
  
  public final void setPlayLoopForMedia(com.tencent.mm.plugin.thumbplayer.a.b paramb)
  {
    AppMethodBeat.i(272524);
    s.u(paramb, "media");
    Object localObject = this.TGY;
    s.u(paramb, "media");
    Log.i(((com.tencent.mm.plugin.thumbplayer.c.b)localObject).TAG, s.X("setPlayLoopForMedia, mediaId:", paramb.mediaId));
    ((com.tencent.mm.plugin.thumbplayer.c.b)localObject).setLoop(true);
    ((com.tencent.mm.plugin.thumbplayer.c.b)localObject).lB(p.listOf(paramb));
    localObject = this.TGB;
    if (localObject != null) {
      ((b)localObject).aea((int)paramb.TBM);
    }
    AppMethodBeat.o(272524);
  }
  
  public final void setPlayStatusChangeListener(b.c paramc)
  {
    this.TGY.TCK = paramc;
    this.TCK = paramc;
  }
  
  public final void start()
  {
    AppMethodBeat.i(272531);
    b localb = this.TGB;
    if (localb == null) {}
    for (long l = -1L;; l = localb.getCurrentPosition())
    {
      if ((l >= 0L) && (this.TGZ != l)) {
        this.TGY.seekTo(l);
      }
      this.TGY.start();
      this.TGZ = -1L;
      AppMethodBeat.o(272531);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout
 * JD-Core Version:    0.7.0.1
 */