package com.tencent.mm.videocomposition.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.SystemClock;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.f;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "()V", "TAG", "", "blendBitmapRender", "Lcom/tencent/mm/videocomposition/render/BlendBitmapRender;", "checkPerformance", "", "getCheckPerformance", "()Z", "setCheckPerformance", "(Z)V", "effectMgrChanged", "needRelease", "outputCrop", "Landroid/graphics/Rect;", "outputHeight", "", "outputSizeChanged", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "outputWidth", "performance", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "checkCreateOutputTexture", "", "checkInitVLogDirector", "enableRelease", "enable", "release", "renderTracks", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "trackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "setBlendBitmapProvider", "blendBitmapProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "setOutputCrop", "rect", "setVLogEffectMgr", "effectMgr", "updateAssetSize", "width", "height", "video_composition_release"})
public final class e
  extends a
{
  private VLogEffectMgr BYQ;
  public boolean LJD;
  private final Rect LJz;
  private VLogDirector LKh;
  private b LKi;
  private volatile boolean LKj;
  private volatile boolean LKk;
  private TextureInfo LKl;
  private d LKm;
  private final String TAG;
  private boolean needRelease;
  private int outputHeight;
  private int outputWidth;
  
  public e()
  {
    AppMethodBeat.i(195048);
    this.TAG = "VLogDirectorMultiVideoCompositionEffect";
    this.LKi = new b();
    this.LJz = new Rect();
    this.LKm = new d("renderTracks");
    this.LJD = true;
    this.needRelease = true;
    AppMethodBeat.o(195048);
  }
  
  public final void F(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(195046);
    p.h(paramb, "blendBitmapProvider");
    this.LKi.F(paramb);
    AppMethodBeat.o(195046);
  }
  
  public final TextureInfo a(CIContext paramCIContext, long paramLong, List<f> paramList)
  {
    AppMethodBeat.i(195042);
    p.h(paramCIContext, "context");
    p.h(paramList, "trackList");
    if ((this.outputWidth == 0) || (this.outputHeight == 0))
    {
      this.outputWidth = paramCIContext.getRenderContext().width();
      this.outputHeight = paramCIContext.getRenderContext().height();
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "renderTracks renderSize " + this.outputWidth + ", " + this.outputHeight + ", assetSize: " + this.LKa + ", crop: " + this.LJz, new Object[0]);
    }
    long l;
    if (this.LKh == null)
    {
      l = SystemClock.elapsedRealtime();
      this.LKh = new VLogDirector();
      paramCIContext = this.LKh;
      if (paramCIContext != null) {
        paramCIContext.init();
      }
      paramCIContext = this.LKh;
      if (paramCIContext != null) {
        paramCIContext.setSize(this.LKa.getWidth(), this.LKa.getHeight());
      }
      if (!this.LJz.isEmpty())
      {
        paramCIContext = this.LKh;
        if (paramCIContext != null) {
          paramCIContext.W(this.LJz.left, this.LJz.top, this.LJz.right, this.LJz.bottom);
        }
      }
      paramCIContext = this.LKh;
      if (paramCIContext != null) {
        paramCIContext.setOutputSize(this.outputWidth, this.outputHeight);
      }
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "init vLogDirector:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    if (this.LKj)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = this.LKh;
      if (paramCIContext != null) {
        paramCIContext.b(this.BYQ);
      }
      this.LKj = false;
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "setVLogEffectMgr:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
    }
    Object localObject1;
    Object localObject2;
    if (this.LKl == null)
    {
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.LKl = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("checkCreateOutputTexture texture.id:");
      paramCIContext = this.LKl;
      if (paramCIContext != null)
      {
        paramCIContext = Integer.valueOf(paramCIContext.textureID);
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.LKk = false;
        label498:
        localObject1 = new LinkedList();
        paramCIContext = ((Iterable)paramList).iterator();
        label518:
        if (!paramCIContext.hasNext()) {
          break label1065;
        }
        localObject2 = (f)paramCIContext.next();
        paramList = new com.tencent.mm.xeffect.a(((f)localObject2).texture.textureID, ((f)localObject2).texture.width, ((f)localObject2).texture.height, ((f)localObject2).BXV.dHi, ((f)localObject2).BXV.id);
        if (!((f)localObject2).BXV.LJj.isEmpty()) {
          paramList.LYh.set(((f)localObject2).BXV.LJj);
        }
        if (((f)localObject2).BXV.LJk)
        {
          if (((f)localObject2).BXV.hpa.isEmpty()) {
            break label827;
          }
          paramList.LYj.set(((f)localObject2).BXV.hpa);
        }
      }
    }
    label827:
    Object localObject3;
    int i;
    for (;;)
    {
      ((LinkedList)localObject1).add(paramList);
      break label518;
      paramCIContext = null;
      break;
      if (!this.LKk) {
        break label498;
      }
      l = SystemClock.elapsedRealtime();
      paramCIContext = CIContext.newTextureInfo(this.outputWidth, this.outputHeight);
      GLES30.glBindTexture(3553, paramCIContext.textureID);
      GLES30.glTexImage2D(3553, 0, 6408, paramCIContext.width, paramCIContext.height, 0, 6408, 5121, null);
      GLES30.glBindTexture(3553, 0);
      this.LKl = paramCIContext;
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("ReCreateOutputTexture texture.id:");
      paramCIContext = this.LKl;
      if (paramCIContext != null) {}
      for (paramCIContext = Integer.valueOf(paramCIContext.textureID);; paramCIContext = null)
      {
        com.tencent.mm.videocomposition.c.b.i((String)localObject1, paramCIContext + ", cost:" + (SystemClock.elapsedRealtime() - l), new Object[0]);
        this.LKk = false;
        break;
      }
      paramList.LYj.set(0, 0, ((f)localObject2).BXV.BXQ, ((f)localObject2).BXV.BXR);
      localObject2 = paramList.LYj;
      p.g(localObject2, "inputTexture.contentCrop");
      localObject3 = new Rect(0, 0, this.LKa.getWidth(), this.LKa.getHeight());
      p.h(localObject2, "$this$centerCrop");
      p.h(localObject3, "target");
      float f1 = ((Rect)localObject3).width() * 1.0F / ((Rect)localObject2).width();
      float f2 = ((Rect)localObject3).height() * 1.0F / ((Rect)localObject2).height();
      if (f1 > f2)
      {
        i = (int)((f1 * ((Rect)localObject2).height() - ((Rect)localObject3).height()) / 2.0F);
        ((Rect)localObject2).set((Rect)localObject3);
        ((Rect)localObject2).top -= i;
        ((Rect)localObject2).bottom += i;
      }
      else
      {
        i = (int)((((Rect)localObject2).width() * f2 - ((Rect)localObject3).width()) / 2.0F);
        ((Rect)localObject2).set((Rect)localObject3);
        ((Rect)localObject2).left -= i;
        ((Rect)localObject2).right += i;
      }
    }
    label1065:
    if (this.LJD) {
      this.LKm.LKg = SystemClock.elapsedRealtime();
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      paramCIContext = this.LKl;
      label1172:
      if (paramCIContext != null)
      {
        if (paramCIContext.textureID <= 0) {
          break label1429;
        }
        i = 1;
        if (i == 0) {
          break label1435;
        }
        label1114:
        if (paramCIContext != null)
        {
          paramList = this.LKh;
          if (paramList != null)
          {
            localObject1 = (List)localObject1;
            i = paramCIContext.textureID;
            localObject2 = this.LKi;
            paramCIContext = ((b)localObject2).hnM;
            if (paramCIContext == null) {
              break label1440;
            }
            paramCIContext = (Bitmap)paramCIContext.invoke(Long.valueOf(paramLong));
            if (paramCIContext == null) {
              break label1445;
            }
            ((b)localObject2).width = paramCIContext.getWidth();
            ((b)localObject2).height = paramCIContext.getHeight();
            if (((b)localObject2).BZy == 0)
            {
              localObject3 = new int[1];
              GLES20.glGenTextures(1, (int[])localObject3, 0);
              GLES20.glBindTexture(3553, localObject3[0]);
              GLES20.glBindTexture(3553, 0);
              ((b)localObject2).BZy = localObject3[0];
            }
            GLES20.glBindTexture(3553, ((b)localObject2).BZy);
            GLUtils.texImage2D(3553, 0, paramCIContext, 0);
            GLES20.glTexParameterf(3553, 10241, 9729.0F);
            GLES20.glTexParameterf(3553, 10240, 9729.0F);
            GLES20.glTexParameterf(3553, 10242, 10497.0F);
            GLES20.glTexParameterf(3553, 10243, 10497.0F);
            GLES20.glBindTexture(3553, 0);
          }
        }
      }
    }
    label1429:
    label1435:
    label1440:
    label1445:
    for (paramCIContext = new com.tencent.mm.xeffect.a(((b)localObject2).BZy, ((b)localObject2).width, ((b)localObject2).height);; paramCIContext = null)
    {
      paramList.a((List)localObject1, i, paramLong, paramCIContext);
      GLES20.glDisable(3042);
      if (this.LJD)
      {
        GLES30.glFinish();
        paramCIContext = this.LKm;
        if (paramCIContext.LKg > 0L)
        {
          paramLong = paramCIContext.ddi;
          l = paramCIContext.LKg;
          paramCIContext.ddi = (paramLong + (SystemClock.elapsedRealtime() - l));
          paramCIContext.sbT += 1L;
        }
        paramCIContext.LKg = 0L;
      }
      paramCIContext = this.LKl;
      AppMethodBeat.o(195042);
      return paramCIContext;
      i = 0;
      break;
      paramCIContext = null;
      break label1114;
      paramCIContext = null;
      break label1172;
    }
  }
  
  public final void b(VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(195045);
    if ((p.i(paramVLogEffectMgr, this.BYQ) ^ true))
    {
      this.BYQ = paramVLogEffectMgr;
      this.LKj = true;
    }
    AppMethodBeat.o(195045);
  }
  
  public final void kA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195044);
    super.kA(paramInt1, paramInt2);
    if ((this.outputWidth != paramInt1) || (this.outputHeight != paramInt2))
    {
      this.outputWidth = paramInt1;
      this.outputHeight = paramInt2;
      VLogDirector localVLogDirector = this.LKh;
      if (localVLogDirector != null) {
        localVLogDirector.setSize(this.outputWidth, this.outputHeight);
      }
      localVLogDirector = this.LKh;
      if (localVLogDirector != null) {
        localVLogDirector.setOutputSize(this.outputWidth, this.outputHeight);
      }
      this.LKk = true;
    }
    AppMethodBeat.o(195044);
  }
  
  public final void p(Rect paramRect)
  {
    AppMethodBeat.i(195043);
    p.h(paramRect, "rect");
    this.LJz.set(paramRect);
    if (!this.LJz.isEmpty())
    {
      this.outputWidth = this.LJz.width();
      this.outputHeight = this.LJz.height();
    }
    AppMethodBeat.o(195043);
  }
  
  public final void release()
  {
    AppMethodBeat.i(195047);
    super.release();
    if (!this.needRelease)
    {
      AppMethodBeat.o(195047);
      return;
    }
    Object localObject = this.LKh;
    if (localObject != null) {
      ((VLogDirector)localObject).destroy();
    }
    localObject = this.LKl;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    this.LKl = null;
    localObject = this.LKi;
    if (((b)localObject).BZy != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { ((b)localObject).BZy }, 0);
      ((b)localObject).BZy = 0;
    }
    String str;
    if (this.LJD)
    {
      str = this.TAG;
      localObject = this.LKm;
      if ((((d)localObject).sbT <= 0L) || (((d)localObject).ddi <= 0L)) {
        break label174;
      }
    }
    label174:
    for (localObject = ((d)localObject).tag + " average cost:" + ((d)localObject).ddi / ((d)localObject).sbT;; localObject = "")
    {
      com.tencent.mm.videocomposition.c.b.i(str, (String)localObject, new Object[0]);
      AppMethodBeat.o(195047);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.e
 * JD-Core Version:    0.7.0.1
 */