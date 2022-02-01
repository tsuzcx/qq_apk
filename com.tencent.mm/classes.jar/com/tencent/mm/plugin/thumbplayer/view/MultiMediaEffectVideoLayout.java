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
import com.tencent.mm.plugin.thumbplayer.d.c.c;
import com.tencent.mm.plugin.thumbplayer.d.f;
import com.tencent.mm.plugin.thumbplayer.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.effect.g;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "effector", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController;", "value", "Lkotlin/Function0;", "", "firstFrameRenderCallback", "getFirstFrameRenderCallback", "()Lkotlin/jvm/functions/Function0;", "setFirstFrameRenderCallback", "(Lkotlin/jvm/functions/Function0;)V", "lastPauseMusicPosition", "", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "mediaChangeListener", "getMediaChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;", "setMediaChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerChangeMediaListener;)V", "mvMusicProxy", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getMvMusicProxy", "()Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "setMvMusicProxy", "(Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;)V", "onPlayFinishListener", "getOnPlayFinishListener", "setOnPlayFinishListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "timeMs", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "mediaInfo", "onProgressCallback", "getOnProgressCallback", "()Lkotlin/jvm/functions/Function2;", "setOnProgressCallback", "(Lkotlin/jvm/functions/Function2;)V", "", "pauseOnVideoPlay", "getPauseOnVideoPlay", "()Z", "setPauseOnVideoPlay", "(Z)V", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "playStatusChangeListener", "getPlayStatusChangeListener", "()Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "setPlayStatusChangeListener", "(Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;)V", "reportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "getReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "textureView", "Landroid/view/TextureView;", "<set-?>", "totalDuration", "getTotalDuration", "()J", "clearPlayRange", "getCurrentPositionMs", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMediaList", "", "getThumbFetcherExtraData", "", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "pause", "refreshFrame", "release", "requestSnapshot", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "resume", "seekTo", "seekToIndex", "index", "seekToIndexTime", "seekToMusic", "setLoop", "loop", "setMediaList", "mediaList", "setMute", "mute", "setPlayLoopForMedia", "media", "setPlayRange", "startTimeMs", "endTimeMs", "setTransition", "prevTransitionMedia", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "transitionPath", "start", "startIgnoreMusicPosition", "stop", "plugin-thumbplayer_release"})
public final class MultiMediaEffectVideoLayout
  extends FrameLayout
  implements TextureView.SurfaceTextureListener
{
  private d Gjl;
  private c.c MQh;
  private boolean MQj;
  private a<x> MQk;
  private m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.e.d, x> MQl;
  private a<x> MQm;
  private b MTV;
  public final com.tencent.mm.plugin.thumbplayer.d.c MUy;
  public long MUz;
  public final String TAG;
  private final TextureView aND;
  
  public MultiMediaEffectVideoLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(189841);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.aND = new TextureView(getContext());
    this.MUy = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.MUz = -1L;
    this.aND.setAlpha(1.0F);
    this.aND.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.aND, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(189841);
  }
  
  public MultiMediaEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(189843);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.aND = new TextureView(getContext());
    this.MUy = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.MUz = -1L;
    this.aND.setAlpha(1.0F);
    this.aND.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.aND, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(189843);
  }
  
  public MultiMediaEffectVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189849);
    this.TAG = "MicroMsg.MultiMediaEffectVideoLayout";
    this.aND = new TextureView(getContext());
    this.MUy = new com.tencent.mm.plugin.thumbplayer.d.c();
    this.MUz = -1L;
    this.aND.setAlpha(1.0F);
    this.aND.setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView((View)this.aND, (ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(189849);
  }
  
  public final void a(e parame, String paramString)
  {
    AppMethodBeat.i(189813);
    p.k(parame, "prevTransitionMedia");
    this.MUy.a(parame, paramString);
    AppMethodBeat.o(189813);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189815);
    this.MUy.aG(paramLong1, paramLong2);
    AppMethodBeat.o(189815);
  }
  
  public final long getCurrentPositionMs()
  {
    return this.MUy.MQt;
  }
  
  public final EffectManager getEffectManager()
  {
    return this.MUy.MQn.ANo;
  }
  
  public final a<x> getFirstFrameRenderCallback()
  {
    return this.MQk;
  }
  
  public final d getMediaChangeListener()
  {
    return this.Gjl;
  }
  
  public final List<com.tencent.mm.plugin.thumbplayer.e.d> getMediaList()
  {
    return (List)this.MUy.xoX;
  }
  
  public final b getMvMusicProxy()
  {
    return this.MTV;
  }
  
  public final a<x> getOnPlayFinishListener()
  {
    return this.MQm;
  }
  
  public final m<Long, com.tencent.mm.plugin.thumbplayer.e.d, x> getOnProgressCallback()
  {
    return this.MQl;
  }
  
  public final boolean getPauseOnVideoPlay()
  {
    return this.MQj;
  }
  
  public final c.c getPlayStatusChangeListener()
  {
    return this.MQh;
  }
  
  public final com.tencent.mm.plugin.thumbplayer.e.c getReportInfo()
  {
    return this.MUy.MQB;
  }
  
  public final long getTotalDuration()
  {
    AppMethodBeat.i(189782);
    f localf = this.MUy.MQr;
    if (localf != null)
    {
      long l = localf.getDuration();
      AppMethodBeat.o(189782);
      return l;
    }
    AppMethodBeat.o(189782);
    return 0L;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189832);
    Log.i(this.TAG, "onSurfaceTextureAvailable, size:[" + paramInt1 + ',' + paramInt2 + "], surface:" + paramSurfaceTexture);
    this.MUy.setSize(paramInt1, paramInt2);
    if (paramSurfaceTexture != null)
    {
      com.tencent.mm.plugin.thumbplayer.d.c localc = this.MUy;
      p.k(paramSurfaceTexture, "surface");
      Log.i(localc.TAG, "attachSurface:".concat(String.valueOf(paramSurfaceTexture)));
      localc.MQn.setSurface(new Surface(paramSurfaceTexture));
      localc.FhU = paramSurfaceTexture;
    }
    AppMethodBeat.o(189832);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189825);
    Log.i(this.TAG, "onSurfaceTextureDestroyed:".concat(String.valueOf(paramSurfaceTexture)));
    paramSurfaceTexture = this.MUy;
    Log.i(paramSurfaceTexture.TAG, "detachSurface");
    paramSurfaceTexture.MQn.setSurface(null);
    paramSurfaceTexture.FhU = null;
    AppMethodBeat.o(189825);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189820);
    Log.i(this.TAG, "onSurfaceTextureSizeChanged, size:[" + paramInt1 + ',' + paramInt2 + "], surface:" + paramSurfaceTexture);
    this.MUy.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(189820);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void pause()
  {
    AppMethodBeat.i(189800);
    this.MUy.pause();
    b localb = this.MTV;
    if (localb != null) {}
    for (long l = localb.getCurrentPosition();; l = -1L)
    {
      this.MUz = l;
      AppMethodBeat.o(189800);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(189804);
    this.MUy.seekTo(paramLong);
    AppMethodBeat.o(189804);
  }
  
  public final void setFirstFrameRenderCallback(a<x> parama)
  {
    this.MUy.MQk = parama;
    this.MQk = parama;
  }
  
  public final void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(189807);
    this.MUy.setLoop(paramBoolean);
    AppMethodBeat.o(189807);
  }
  
  public final void setMediaChangeListener(d paramd)
  {
    this.MUy.MQi = paramd;
    this.Gjl = paramd;
  }
  
  public final void setMediaList(List<? extends com.tencent.mm.plugin.thumbplayer.e.d> paramList)
  {
    AppMethodBeat.i(189785);
    p.k(paramList, "mediaList");
    com.tencent.mm.plugin.thumbplayer.d.c.a(this.MUy, paramList);
    AppMethodBeat.o(189785);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(189789);
    com.tencent.mm.plugin.thumbplayer.d.c localc = this.MUy;
    Log.i(localc.TAG, "setMute:".concat(String.valueOf(paramBoolean)));
    localc.lhf = paramBoolean;
    AppMethodBeat.o(189789);
  }
  
  public final void setMvMusicProxy(b paramb)
  {
    this.MTV = paramb;
  }
  
  public final void setOnPlayFinishListener(a<x> parama)
  {
    this.MUy.MQm = parama;
    this.MQm = parama;
  }
  
  public final void setOnProgressCallback(m<? super Long, ? super com.tencent.mm.plugin.thumbplayer.e.d, x> paramm)
  {
    this.MUy.MQl = paramm;
    this.MQl = paramm;
  }
  
  public final void setPauseOnVideoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(189773);
    Log.i(this.TAG, "set pauseOnVideoPlay:".concat(String.valueOf(paramBoolean)));
    this.MUy.MQj = paramBoolean;
    this.MQj = paramBoolean;
    AppMethodBeat.o(189773);
  }
  
  public final void setPlayLoopForMedia(com.tencent.mm.plugin.thumbplayer.e.d paramd)
  {
    AppMethodBeat.i(189795);
    p.k(paramd, "media");
    Object localObject = this.MUy;
    p.k(paramd, "media");
    Log.i(((com.tencent.mm.plugin.thumbplayer.d.c)localObject).TAG, "setPlayLoopForMedia, mediaId:" + paramd.mediaId);
    ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).setLoop(true);
    ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).iv(j.listOf(paramd));
    localObject = this.MTV;
    if (localObject != null)
    {
      ((b)localObject).ZN((int)paramd.MSE);
      AppMethodBeat.o(189795);
      return;
    }
    AppMethodBeat.o(189795);
  }
  
  public final void setPlayStatusChangeListener(c.c paramc)
  {
    this.MUy.MQh = paramc;
    this.MQh = paramc;
  }
  
  public final void start()
  {
    AppMethodBeat.i(189797);
    b localb = this.MTV;
    if (localb != null) {}
    for (long l = localb.getCurrentPosition();; l = -1L)
    {
      if ((l >= 0L) && (this.MUz != l)) {
        this.MUy.seekTo(l);
      }
      this.MUy.start();
      this.MUz = -1L;
      AppMethodBeat.o(189797);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout
 * JD-Core Version:    0.7.0.1
 */