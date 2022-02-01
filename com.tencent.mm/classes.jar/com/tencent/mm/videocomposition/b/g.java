package com.tencent.mm.videocomposition.b;

import android.graphics.Rect;
import android.opengl.GLES30;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.f;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "()V", "TAG", "", "checkPerformance", "", "getCheckPerformance", "()Z", "setCheckPerformance", "(Z)V", "effectMgrChanged", "glBlendStateCache", "Lcom/tencent/mm/videocomposition/render/GLBlendStateCache;", "needRelease", "outputCrop", "Landroid/graphics/Rect;", "outputHeight", "", "outputSizeChanged", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "outputWidth", "<set-?>", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "performance", "getPerformance", "()Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "processCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "checkCreateOutputTexture", "", "checkInitVLogDirector", "enableRelease", "enable", "release", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "setEffectManager", "effectMgr", "setOutputCrop", "rect", "setProcessCallback", "callback", "updateAssetSize", "width", "height", "video_composition_release"})
public final class g
  extends a
{
  private VLogDirector GhL;
  private volatile boolean GhM;
  private EffectManager Noe;
  private final String TAG;
  private TextureInfo YIL;
  private final Rect YIj;
  public boolean YIo;
  public volatile e YJJ;
  private volatile boolean YJK;
  public d YJL;
  private c YJM;
  private boolean needRelease;
  private int outputHeight;
  private int outputWidth;
  
  public g()
  {
    AppMethodBeat.i(248570);
    this.TAG = "VLogDirectorMultiVideoCompositionEffect";
    this.YIj = new Rect();
    this.YJL = new d("renderTracks");
    this.YIo = true;
    this.needRelease = true;
    AppMethodBeat.o(248570);
  }
  
  public final void D(Rect paramRect)
  {
    AppMethodBeat.i(248566);
    p.k(paramRect, "rect");
    this.YIj.set(paramRect);
    if (!this.YIj.isEmpty())
    {
      this.outputWidth = this.YIj.width();
      this.outputHeight = this.YIj.height();
    }
    AppMethodBeat.o(248566);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<f> paramList)
  {
    AppMethodBeat.i(248565);
    p.k(paramCIContext, "context");
    p.k(paramList, "trackList");
    if ((this.outputWidth == 0) || (this.outputHeight == 0))
    {
      this.outputWidth = paramCIContext.getRenderContext().width();
      this.outputHeight = paramCIContext.getRenderContext().height();
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "renderTracks renderSize " + this.outputWidth + ", " + this.outputHeight + ", assetSize: " + igI() + ", crop: " + this.YIj, new Object[0]);
    }
    long l;
    if (this.GhL == null)
    {
      l = SystemClock.elapsedRealtime();
      this.GhL = new VLogDirector();
      paramCIContext = this.GhL;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      paramCIContext = this.GhL;
      if (paramCIContext != null) {
        paramCIContext.setSize(igI().getWidth(), igI().getHeight());
      }
      if (!this.YIj.isEmpty())
      {
        paramCIContext = this.GhL;
        if (paramCIContext != null) {
          paramCIContext.aa(this.YIj.left, this.YIj.top, this.YIj.right, this.YIj.bottom);
        }
      }
      paramCIContext = this.GhL;
      if (paramCIContext != null) {
        paramCIContext.setOutputSize(this.outputWidth, this.outputHeight);
      }
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "init vLogDirector:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    if (this.YJK)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = this.GhL;
      if (paramCIContext != null) {
        paramCIContext.c(this.Noe);
      }
      this.YJK = false;
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "setVLogEffectMgr:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    if (this.YIL == null)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.YIL = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("checkCreateOutputTexture texture.id:");
      paramCIContext = this.YIL;
      if (paramCIContext != null)
      {
        paramCIContext = Integer.valueOf(paramCIContext.textureID);
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.GhM = false;
        label498:
        localObject1 = new LinkedList();
        paramCIContext = ((Iterable)paramList).iterator();
        label518:
        if (!paramCIContext.hasNext()) {
          break label880;
        }
        paramList = (f)paramCIContext.next();
        localObject2 = new com.tencent.mm.xeffect.c(paramList.texture.textureID, paramList.texture.width, paramList.texture.height, false, paramList.Nng.fSM);
        if (!paramList.Nng.YHS.isEmpty()) {
          ((com.tencent.mm.xeffect.c)localObject2).YZi.set(paramList.Nng.YHS);
        }
        if (paramList.Nng.YHT)
        {
          if (paramList.Nng.kXj.isEmpty()) {
            break label820;
          }
          ((com.tencent.mm.xeffect.c)localObject2).YZj.set(paramList.Nng.kXj);
        }
      }
    }
    for (;;)
    {
      ((LinkedList)localObject1).add(localObject2);
      break label518;
      paramCIContext = null;
      break;
      if (!this.GhM) {
        break label498;
      }
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.YIL = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("ReCreateOutputTexture texture.id:");
      paramCIContext = this.YIL;
      if (paramCIContext != null) {}
      for (paramCIContext = Integer.valueOf(paramCIContext.textureID);; paramCIContext = null)
      {
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.GhM = false;
        break;
      }
      label820:
      ((com.tencent.mm.xeffect.c)localObject2).YZj.set(0, 0, paramList.Nng.Nna, paramList.Nng.Nnb);
      h.c(((com.tencent.mm.xeffect.c)localObject2).YZj, new Rect(0, 0, igI().getWidth(), igI().getHeight()));
    }
    label880:
    this.YJL.YJH = SystemClock.elapsedRealtime();
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      paramCIContext = this.YIL;
      if (paramCIContext != null)
      {
        if (paramCIContext.textureID <= 0) {
          break label1092;
        }
        i = 1;
        if (i == 0) {
          break label1098;
        }
      }
    }
    for (;;)
    {
      if (paramCIContext != null)
      {
        if (this.YJM == null) {
          this.YJM = new c();
        }
        paramList = this.YJM;
        if (paramList != null) {
          paramList.cache();
        }
        paramList = this.YJJ;
        if (paramList != null) {
          paramList.Sj(paramLong);
        }
        paramList = this.GhL;
        if (paramList != null) {
          paramList.a((List)localObject1, paramCIContext.textureID, paramLong);
        }
        paramCIContext = this.YJM;
        if (paramCIContext != null) {
          paramCIContext.restore();
        }
      }
      if (this.YIo) {
        GLES30.glFinish();
      }
      paramCIContext = this.YJL;
      if (paramCIContext.YJH > 0L)
      {
        paramLong = paramCIContext.fmH;
        l = paramCIContext.YJH;
        paramCIContext.fmH = (paramLong + (SystemClock.elapsedRealtime() - l));
        paramCIContext.xEc += 1L;
      }
      paramCIContext.YJH = 0L;
      paramCIContext = this.YIL;
      AppMethodBeat.o(248565);
      return paramCIContext;
      label1092:
      i = 0;
      break;
      label1098:
      paramCIContext = null;
    }
  }
  
  public final void c(EffectManager paramEffectManager)
  {
    AppMethodBeat.i(248568);
    if ((p.h(paramEffectManager, this.Noe) ^ true))
    {
      this.Noe = paramEffectManager;
      this.YJK = true;
    }
    AppMethodBeat.o(248568);
  }
  
  public final void np(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248567);
    super.np(paramInt1, paramInt2);
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      VLogDirector localVLogDirector = this.GhL;
      if (localVLogDirector != null) {
        localVLogDirector.setSize(this.outputWidth, this.outputHeight);
      }
      localVLogDirector = this.GhL;
      if (localVLogDirector != null) {
        localVLogDirector.setOutputSize(this.outputWidth, this.outputHeight);
      }
      this.GhM = true;
    }
    AppMethodBeat.o(248567);
  }
  
  public final void release()
  {
    AppMethodBeat.i(248569);
    super.release();
    if (!this.needRelease)
    {
      AppMethodBeat.o(248569);
      return;
    }
    Object localObject = this.GhL;
    if (localObject != null) {
      ((VLogDirector)localObject).destroy();
    }
    localObject = this.YIL;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    this.YIL = null;
    localObject = this.YJJ;
    if (localObject != null) {
      ((e)localObject).onRelease();
    }
    String str;
    if (this.YIo)
    {
      str = this.TAG;
      localObject = this.YJL;
      if ((((d)localObject).xEc <= 0L) || (((d)localObject).fmH <= 0L)) {
        break label185;
      }
    }
    label185:
    for (localObject = ((d)localObject).tag + " totalFrame:" + ((d)localObject).xEc + ", totalTime:" + ((d)localObject).fmH + ", average cost:" + ((d)localObject).fmH / ((d)localObject).xEc;; localObject = "")
    {
      com.tencent.mm.videocomposition.c.b.i(str, (String)localObject, new Object[0]);
      AppMethodBeat.o(248569);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.g
 * JD-Core Version:    0.7.0.1
 */