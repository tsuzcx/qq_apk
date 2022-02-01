package com.tencent.mm.videocomposition.c;

import android.graphics.Rect;
import android.opengl.GLES30;
import android.os.Process;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "()V", "TAG", "", "checkPerformance", "", "getCheckPerformance", "()Z", "setCheckPerformance", "(Z)V", "effectMgrChanged", "glBlendStateCache", "Lcom/tencent/mm/videocomposition/render/GLBlendStateCache;", "needRelease", "outputCrop", "Landroid/graphics/Rect;", "outputHeight", "", "outputSizeChanged", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "outputWidth", "<set-?>", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "performance", "getPerformance", "()Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "processCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "checkCreateOutputTexture", "", "checkInitVLogDirector", "enableRelease", "enable", "release", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "setEffectManager", "effectMgr", "setOutputCrop", "rect", "setProcessCallback", "callback", "updateAssetSize", "width", "height", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class g
  extends a
{
  private VLogDirector GvX;
  private volatile boolean GvY;
  private final String TAG;
  public EffectManager UbK;
  public final Rect agDQ;
  public boolean agDV;
  private TextureInfo agEt;
  public volatile e agFB;
  public volatile boolean agFC;
  public d agFD;
  private c agFE;
  private boolean needRelease;
  public int outputHeight;
  public int outputWidth;
  
  public g()
  {
    AppMethodBeat.i(233522);
    this.TAG = "VLogDirectorMultiVideoCompositionEffect";
    this.agDQ = new Rect();
    this.agFD = new d("renderTracks");
    this.agDV = true;
    this.needRelease = true;
    AppMethodBeat.o(233522);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<f> paramList)
  {
    AppMethodBeat.i(233541);
    s.t(paramCIContext, "context");
    s.t(paramList, "trackList");
    com.tencent.mm.videocomposition.d.b.d(this.TAG, "[hash:%d][thread:%d]renderTracks ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Process.myTid()) });
    if ((this.outputWidth == 0) || (this.outputHeight == 0))
    {
      this.outputWidth = paramCIContext.getRenderContext().width();
      this.outputHeight = paramCIContext.getRenderContext().height();
      com.tencent.mm.videocomposition.d.b.i(this.TAG, "renderTracks renderSize " + this.outputWidth + ", " + this.outputHeight + ", assetSize: " + jLW() + ", crop: " + this.agDQ, new Object[0]);
    }
    long l;
    if (this.GvX == null)
    {
      l = SystemClock.elapsedRealtime();
      this.GvX = new VLogDirector();
      paramCIContext = this.GvX;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      paramCIContext = this.GvX;
      if (paramCIContext != null) {
        paramCIContext.setSize(jLW().getWidth(), jLW().getHeight());
      }
      if (!this.agDQ.isEmpty())
      {
        paramCIContext = this.GvX;
        if (paramCIContext != null) {
          paramCIContext.ak(this.agDQ.left, this.agDQ.top, this.agDQ.right, this.agDQ.bottom);
        }
      }
      paramCIContext = this.GvX;
      if (paramCIContext != null) {
        paramCIContext.setOutputSize(this.outputWidth, this.outputHeight);
      }
      com.tencent.mm.videocomposition.d.b.i(this.TAG, "init vLogDirector:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    if (this.agFC)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = this.GvX;
      if (paramCIContext != null) {
        paramCIContext.c(this.UbK);
      }
      this.agFC = false;
      com.tencent.mm.videocomposition.d.b.i(this.TAG, "setVLogEffectMgr:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    if (this.agEt == null)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.agEt = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("checkCreateOutputTexture texture.id:");
      paramCIContext = this.agEt;
      if (paramCIContext != null)
      {
        paramCIContext = Integer.valueOf(paramCIContext.textureID);
        com.tencent.mm.videocomposition.d.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.GvY = false;
        label531:
        localObject1 = new LinkedList();
        paramCIContext = ((Iterable)paramList).iterator();
        label551:
        if (!paramCIContext.hasNext()) {
          break label913;
        }
        paramList = (f)paramCIContext.next();
        localObject2 = new com.tencent.mm.xeffect.c(paramList.texture.textureID, paramList.texture.width, paramList.texture.height, false, paramList.UaI.hYK);
        if (!paramList.UaI.agDz.isEmpty()) {
          ((com.tencent.mm.xeffect.c)localObject2).agXt.set(paramList.UaI.agDz);
        }
        if (paramList.UaI.agDA)
        {
          if (paramList.UaI.Gl.isEmpty()) {
            break label853;
          }
          ((com.tencent.mm.xeffect.c)localObject2).agXu.set(paramList.UaI.Gl);
        }
      }
    }
    for (;;)
    {
      ((LinkedList)localObject1).add(localObject2);
      break label551;
      paramCIContext = null;
      break;
      if (!this.GvY) {
        break label531;
      }
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.agEt = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("ReCreateOutputTexture texture.id:");
      paramCIContext = this.agEt;
      if (paramCIContext != null) {}
      for (paramCIContext = Integer.valueOf(paramCIContext.textureID);; paramCIContext = null)
      {
        com.tencent.mm.videocomposition.d.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.GvY = false;
        break;
      }
      label853:
      ((com.tencent.mm.xeffect.c)localObject2).agXu.set(0, 0, paramList.UaI.UaC, paramList.UaI.UaD);
      h.g(((com.tencent.mm.xeffect.c)localObject2).agXu, new Rect(0, 0, jLW().getWidth(), jLW().getHeight()));
    }
    label913:
    this.agFD.agFz = SystemClock.elapsedRealtime();
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      paramCIContext = this.agEt;
      if (paramCIContext != null)
      {
        if (paramCIContext.textureID <= 0) {
          break label1125;
        }
        i = 1;
        if (i == 0) {
          break label1131;
        }
      }
    }
    for (;;)
    {
      if (paramCIContext != null)
      {
        if (this.agFE == null) {
          this.agFE = new c();
        }
        paramList = this.agFE;
        if (paramList != null) {
          paramList.cache();
        }
        paramList = this.agFB;
        if (paramList != null) {
          paramList.wx(paramLong);
        }
        paramList = this.GvX;
        if (paramList != null) {
          paramList.b((List)localObject1, paramCIContext.textureID, paramLong);
        }
        paramCIContext = this.agFE;
        if (paramCIContext != null) {
          paramCIContext.restore();
        }
      }
      if (this.agDV) {
        GLES30.glFinish();
      }
      paramCIContext = this.agFD;
      if (paramCIContext.agFz > 0L)
      {
        paramLong = paramCIContext.hqS;
        l = paramCIContext.agFz;
        paramCIContext.hqS = (paramLong + (SystemClock.elapsedRealtime() - l));
        paramCIContext.Bbb += 1L;
      }
      paramCIContext.agFz = 0L;
      paramCIContext = this.agEt;
      AppMethodBeat.o(233541);
      return paramCIContext;
      label1125:
      i = 0;
      break;
      label1131:
      paramCIContext = null;
    }
  }
  
  public final void pm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233548);
    super.pm(paramInt1, paramInt2);
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      VLogDirector localVLogDirector = this.GvX;
      if (localVLogDirector != null) {
        localVLogDirector.setSize(this.outputWidth, this.outputHeight);
      }
      localVLogDirector = this.GvX;
      if (localVLogDirector != null) {
        localVLogDirector.setOutputSize(this.outputWidth, this.outputHeight);
      }
      this.GvY = true;
    }
    AppMethodBeat.o(233548);
  }
  
  public final void release()
  {
    AppMethodBeat.i(233557);
    super.release();
    if (!this.needRelease)
    {
      AppMethodBeat.o(233557);
      return;
    }
    Object localObject = this.GvX;
    if (localObject != null) {
      ((VLogDirector)localObject).destroy();
    }
    localObject = this.agEt;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    this.agEt = null;
    localObject = this.agFB;
    if (localObject != null) {
      ((e)localObject).onRelease();
    }
    String str;
    if (this.agDV)
    {
      str = this.TAG;
      localObject = this.agFD;
      if ((((d)localObject).Bbb <= 0L) || (((d)localObject).hqS <= 0L)) {
        break label185;
      }
    }
    label185:
    for (localObject = ((d)localObject).tag + " totalFrame:" + ((d)localObject).Bbb + ", totalTime:" + ((d)localObject).hqS + ", average cost:" + ((d)localObject).hqS / ((d)localObject).Bbb;; localObject = "")
    {
      com.tencent.mm.videocomposition.d.b.i(str, (String)localObject, new Object[0]);
      AppMethodBeat.o(233557);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.g
 * JD-Core Version:    0.7.0.1
 */