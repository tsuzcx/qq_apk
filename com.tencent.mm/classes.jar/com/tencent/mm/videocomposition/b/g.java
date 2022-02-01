package com.tencent.mm.videocomposition.b;

import android.graphics.Rect;
import android.opengl.GLES30;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "()V", "TAG", "", "checkPerformance", "", "getCheckPerformance", "()Z", "setCheckPerformance", "(Z)V", "effectMgrChanged", "glBlendStateCache", "Lcom/tencent/mm/videocomposition/render/GLBlendStateCache;", "needRelease", "outputCrop", "Landroid/graphics/Rect;", "outputHeight", "", "outputSizeChanged", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "outputWidth", "<set-?>", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "performance", "getPerformance", "()Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "processCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "checkCreateOutputTexture", "", "checkInitVLogDirector", "enableRelease", "enable", "release", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "setEffectManager", "effectMgr", "setOutputCrop", "rect", "setProcessCallback", "callback", "updateAssetSize", "width", "height", "video_composition_release"})
public final class g
  extends a
{
  private VLogDirector AsI;
  private volatile boolean AsJ;
  private EffectManager GAw;
  private final Rect Rhq;
  public boolean Rhu;
  public volatile e Rib;
  private volatile boolean Ric;
  private TextureInfo Rid;
  public d Rie;
  private c Rif;
  private final String TAG;
  private boolean needRelease;
  private int outputHeight;
  private int outputWidth;
  
  public g()
  {
    AppMethodBeat.i(216857);
    this.TAG = "VLogDirectorMultiVideoCompositionEffect";
    this.Rhq = new Rect();
    this.Rie = new d("renderTracks");
    this.Rhu = true;
    this.needRelease = true;
    AppMethodBeat.o(216857);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<j> paramList)
  {
    AppMethodBeat.i(216852);
    p.h(paramCIContext, "context");
    p.h(paramList, "trackList");
    if ((this.outputWidth == 0) || (this.outputHeight == 0))
    {
      this.outputWidth = paramCIContext.getRenderContext().width();
      this.outputHeight = paramCIContext.getRenderContext().height();
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "renderTracks renderSize " + this.outputWidth + ", " + this.outputHeight + ", assetSize: " + this.RhT + ", crop: " + this.Rhq, new Object[0]);
    }
    long l;
    if (this.AsI == null)
    {
      l = SystemClock.elapsedRealtime();
      this.AsI = new VLogDirector();
      paramCIContext = this.AsI;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      paramCIContext = this.AsI;
      if (paramCIContext != null) {
        paramCIContext.setSize(this.RhT.getWidth(), this.RhT.getHeight());
      }
      if (!this.Rhq.isEmpty())
      {
        paramCIContext = this.AsI;
        if (paramCIContext != null) {
          paramCIContext.V(this.Rhq.left, this.Rhq.top, this.Rhq.right, this.Rhq.bottom);
        }
      }
      paramCIContext = this.AsI;
      if (paramCIContext != null) {
        paramCIContext.setOutputSize(this.outputWidth, this.outputHeight);
      }
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "init vLogDirector:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    if (this.Ric)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = this.AsI;
      if (paramCIContext != null) {
        paramCIContext.b(this.GAw);
      }
      this.Ric = false;
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "setVLogEffectMgr:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    if (this.Rid == null)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.Rid = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("checkCreateOutputTexture texture.id:");
      paramCIContext = this.Rid;
      if (paramCIContext != null)
      {
        paramCIContext = Integer.valueOf(paramCIContext.textureID);
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.AsJ = false;
        label498:
        localObject1 = new LinkedList();
        paramCIContext = ((Iterable)paramList).iterator();
        label518:
        if (!paramCIContext.hasNext()) {
          break label892;
        }
        localObject2 = (j)paramCIContext.next();
        paramList = new com.tencent.mm.xeffect.b(((j)localObject2).texture.textureID, ((j)localObject2).texture.width, ((j)localObject2).texture.height, false, ((j)localObject2).GzA.dYT);
        if (!((j)localObject2).GzA.Rha.isEmpty()) {
          paramList.RxI.set(((j)localObject2).GzA.Rha);
        }
        if (((j)localObject2).GzA.Rhb)
        {
          if (((j)localObject2).GzA.iiw.isEmpty()) {
            break label820;
          }
          paramList.RxJ.set(((j)localObject2).GzA.iiw);
        }
      }
    }
    for (;;)
    {
      ((LinkedList)localObject1).add(paramList);
      break label518;
      paramCIContext = null;
      break;
      if (!this.AsJ) {
        break label498;
      }
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.Rid = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("ReCreateOutputTexture texture.id:");
      paramCIContext = this.Rid;
      if (paramCIContext != null) {}
      for (paramCIContext = Integer.valueOf(paramCIContext.textureID);; paramCIContext = null)
      {
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.AsJ = false;
        break;
      }
      label820:
      paramList.RxJ.set(0, 0, ((j)localObject2).GzA.Gzu, ((j)localObject2).GzA.Gzv);
      localObject2 = paramList.RxJ;
      p.g(localObject2, "inputTexture.contentCrop");
      com.tencent.mm.videocomposition.l.c((Rect)localObject2, new Rect(0, 0, this.RhT.getWidth(), this.RhT.getHeight()));
    }
    label892:
    this.Rie.RhZ = SystemClock.elapsedRealtime();
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      paramCIContext = this.Rid;
      if (paramCIContext != null)
      {
        if (paramCIContext.textureID <= 0) {
          break label1104;
        }
        i = 1;
        if (i == 0) {
          break label1110;
        }
      }
    }
    for (;;)
    {
      if (paramCIContext != null)
      {
        if (this.Rif == null) {
          this.Rif = new c();
        }
        paramList = this.Rif;
        if (paramList != null) {
          paramList.cache();
        }
        paramList = this.Rib;
        if (paramList != null) {
          paramList.KM(paramLong);
        }
        paramList = this.AsI;
        if (paramList != null) {
          paramList.a((List)localObject1, paramCIContext.textureID, paramLong);
        }
        paramCIContext = this.Rif;
        if (paramCIContext != null) {
          paramCIContext.restore();
        }
      }
      paramCIContext = this.Rie;
      if (paramCIContext.RhZ > 0L)
      {
        paramLong = paramCIContext.dtZ;
        l = paramCIContext.RhZ;
        paramCIContext.dtZ = (paramLong + (SystemClock.elapsedRealtime() - l));
        paramCIContext.tTn += 1L;
      }
      paramCIContext.RhZ = 0L;
      if (this.Rhu) {
        GLES30.glFinish();
      }
      paramCIContext = this.Rid;
      AppMethodBeat.o(216852);
      return paramCIContext;
      label1104:
      i = 0;
      break;
      label1110:
      paramCIContext = null;
    }
  }
  
  public final void b(EffectManager paramEffectManager)
  {
    AppMethodBeat.i(216855);
    if ((p.j(paramEffectManager, this.GAw) ^ true))
    {
      this.GAw = paramEffectManager;
      this.Ric = true;
    }
    AppMethodBeat.o(216855);
  }
  
  public final void lY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216854);
    super.lY(paramInt1, paramInt2);
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      VLogDirector localVLogDirector = this.AsI;
      if (localVLogDirector != null) {
        localVLogDirector.setSize(this.outputWidth, this.outputHeight);
      }
      localVLogDirector = this.AsI;
      if (localVLogDirector != null) {
        localVLogDirector.setOutputSize(this.outputWidth, this.outputHeight);
      }
      this.AsJ = true;
    }
    AppMethodBeat.o(216854);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216856);
    super.release();
    if (!this.needRelease)
    {
      AppMethodBeat.o(216856);
      return;
    }
    Object localObject = this.AsI;
    if (localObject != null) {
      ((VLogDirector)localObject).destroy();
    }
    localObject = this.Rid;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    this.Rid = null;
    localObject = this.Rib;
    if (localObject != null) {
      ((e)localObject).onRelease();
    }
    String str;
    if (this.Rhu)
    {
      str = this.TAG;
      localObject = this.Rie;
      if ((((d)localObject).tTn <= 0L) || (((d)localObject).dtZ <= 0L)) {
        break label157;
      }
    }
    label157:
    for (localObject = ((d)localObject).tag + " average cost:" + ((d)localObject).dtZ / ((d)localObject).tTn;; localObject = "")
    {
      com.tencent.mm.videocomposition.c.b.i(str, (String)localObject, new Object[0]);
      AppMethodBeat.o(216856);
      return;
    }
  }
  
  public final void t(Rect paramRect)
  {
    AppMethodBeat.i(216853);
    p.h(paramRect, "rect");
    this.Rhq.set(paramRect);
    if (!this.Rhq.isEmpty())
    {
      this.outputWidth = this.Rhq.width();
      this.outputHeight = this.Rhq.height();
    }
    AppMethodBeat.o(216853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.g
 * JD-Core Version:    0.7.0.1
 */