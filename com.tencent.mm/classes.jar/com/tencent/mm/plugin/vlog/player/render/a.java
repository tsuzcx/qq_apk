package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Process;
import android.util.Size;
import com.tencent.mm.plugin.vlog.model.d;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import d.g.b.k;
import d.l;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "()V", "cacheTextureInfo", "Ljava/util/ArrayList;", "Lcom/tencent/tav/coremedia/TextureInfo;", "cacheTextureSize", "", "enableLog", "", "getEnableLog", "()Z", "setEnableLog", "(Z)V", "frameRenderCallback", "Lkotlin/Function0;", "", "renderContext", "Landroid/opengl/EGLContext;", "getRenderContext", "()Landroid/opengl/EGLContext;", "setRenderContext", "(Landroid/opengl/EGLContext;)V", "renderSize", "Landroid/util/Size;", "getRenderSize", "()Landroid/util/Size;", "setRenderSize", "(Landroid/util/Size;)V", "setThreadPriority", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "calcImageTextureSize", "image", "createInputTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "release", "renderTracks", "trackList", "setFrameRenderCallback", "callback", "updateRenderSize", "width", "height", "Companion", "plugin-vlog_release"})
public abstract class a
  implements TAVVideoMixEffect.Filter
{
  public static final a AqP = new a((byte)0);
  private ArrayList<TextureInfo> AqJ = new ArrayList();
  private final int AqK = 3;
  private EGLContext AqL;
  Size AqM;
  private boolean AqN;
  public boolean AqO;
  private volatile d.g.a.a<y> hbi;
  
  public a()
  {
    EGLContext localEGLContext = EGL14.EGL_NO_CONTEXT;
    k.g(localEGLContext, "EGL14.EGL_NO_CONTEXT");
    this.AqL = localEGLContext;
    this.AqM = new Size(0, 0);
    ac.i("MicroMsg.BaseMultiVideoCompositionEffect", "init: ".concat(String.valueOf(this)));
  }
  
  public abstract TextureInfo a(CIContext paramCIContext, long paramLong, List<p> paramList);
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    CIContext localCIContext;
    if (paramRenderInfo != null)
    {
      localCIContext = paramRenderInfo.getCiContext();
      if (localCIContext != null) {}
    }
    else
    {
      return null;
    }
    k.g(localCIContext, "renderInfo?.ciContext ?: return null");
    int i;
    int j;
    if (!this.AqN)
    {
      ac.i("MicroMsg.BaseMultiVideoCompositionEffect", "set render thread priority ".concat(String.valueOf(this)));
      Process.setThreadPriority(-4);
      this.AqN = true;
      i = 0;
      j = this.AqK;
      while (i < j)
      {
        this.AqJ.add(CIContext.newTextureInfo(this.AqM.getWidth(), this.AqM.getHeight()));
        i += 1;
      }
    }
    paramTAVVideoMixEffect = localCIContext.getRenderContext().eglContext();
    k.g(paramTAVVideoMixEffect, "context.renderContext.eglContext()");
    this.AqL = paramTAVVideoMixEffect;
    paramTAVVideoMixEffect = paramRenderInfo.getTime();
    k.g(paramTAVVideoMixEffect, "renderInfo.time");
    long l1 = paramTAVVideoMixEffect.getTimeUs() / 1000L;
    Object localObject1;
    Object localObject2;
    if (paramImageCollection != null)
    {
      paramRenderInfo = new LinkedList();
      localObject1 = paramImageCollection.getVideoChannelImages().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ImageCollection.TrackImagePair)((Iterator)localObject1).next();
        k.g(localObject2, "it");
        paramTAVVideoMixEffect = ((ImageCollection.TrackImagePair)localObject2).getTrack();
        if (paramTAVVideoMixEffect == null) {
          throw new v("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
        }
        paramTAVVideoMixEffect = (TAVClip)paramTAVVideoMixEffect;
        if (!(paramTAVVideoMixEffect.getResource() instanceof TAVEmptyResource))
        {
          paramImageCollection = paramTAVVideoMixEffect.getStartTime();
          k.g(paramImageCollection, "clip.startTime");
          long l2 = paramImageCollection.getTimeUs() / 1000L;
          paramImageCollection = paramTAVVideoMixEffect.getDuration();
          k.g(paramImageCollection, "clip.duration");
          long l3 = paramImageCollection.getTimeUs() / 1000L;
          if ((l1 >= l2) && (l1 < l3 + l2 + 1L))
          {
            paramImageCollection = paramTAVVideoMixEffect.getExtraTrackInfo("key_extra_track");
            paramTAVVideoMixEffect = paramImageCollection;
            if (!(paramImageCollection instanceof u)) {
              paramTAVVideoMixEffect = null;
            }
            paramTAVVideoMixEffect = (u)paramTAVVideoMixEffect;
            if (paramTAVVideoMixEffect != null) {
              paramRenderInfo.add(new o(paramTAVVideoMixEffect, ((ImageCollection.TrackImagePair)localObject2).getImage()));
            }
          }
        }
      }
      paramImageCollection = new LinkedList();
      paramRenderInfo = ((Iterable)paramRenderInfo).iterator();
      while (paramRenderInfo.hasNext())
      {
        localObject1 = (o)paramRenderInfo.next();
        i = this.AqM.getWidth();
        j = this.AqM.getHeight();
        if ((i > 0) && (j > 0))
        {
          paramTAVVideoMixEffect = null;
          if (this.AqJ.size() > 0) {
            paramTAVVideoMixEffect = (TextureInfo)this.AqJ.remove(0);
          }
          if ((paramTAVVideoMixEffect != null) && (paramTAVVideoMixEffect.width == i) && (paramTAVVideoMixEffect.height == j)) {
            break label827;
          }
          if (paramTAVVideoMixEffect != null) {
            this.AqJ.add(paramTAVVideoMixEffect);
          }
          ac.i("MicroMsg.BaseMultiVideoCompositionEffect", "create new sourceTextureInfo size:[" + i + ", " + j + ']');
          paramTAVVideoMixEffect = CIContext.newTextureInfo(i, j);
        }
      }
    }
    label827:
    for (;;)
    {
      localObject2 = (u)((o)localObject1).first;
      CIImage localCIImage = (CIImage)((o)localObject1).second;
      Matrix localMatrix = new Matrix();
      int k = ((u)localObject2).AoD.viewRect.width();
      int m = ((u)localObject2).AoD.viewRect.height();
      RectF localRectF = new RectF(((u)localObject2).AoD.pvE);
      localRectF.offset(-((u)localObject2).AoD.viewRect.left, -((u)localObject2).AoD.viewRect.top);
      j.a(localMatrix, localCIImage.getSize().width, localCIImage.getSize().height, localRectF.left, m - localRectF.bottom, localRectF.right, m - localRectF.top);
      localMatrix.postScale(i * 1.0F / k, j * 1.0F / m);
      localCIImage.imageByApplyingTransform(localMatrix);
      localCIContext.convertImageToTexture((CIImage)((o)localObject1).second, paramTAVVideoMixEffect);
      paramImageCollection.add(new p((u)((o)localObject1).first, paramTAVVideoMixEffect));
      break;
      paramImageCollection = (List)paramImageCollection;
      paramTAVVideoMixEffect = a(localCIContext, l1, paramImageCollection);
      paramImageCollection = ((Iterable)paramImageCollection).iterator();
      while (paramImageCollection.hasNext())
      {
        paramRenderInfo = (p)paramImageCollection.next();
        this.AqJ.add(paramRenderInfo.texture);
      }
      paramImageCollection = this.hbi;
      if (paramImageCollection != null) {
        paramImageCollection.invoke();
      }
      return new CIImage(paramTAVVideoMixEffect);
      return null;
    }
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.BaseMultiVideoCompositionEffect", "updateRenderSize width:" + paramInt1 + ", height:" + paramInt2);
    this.AqM = new Size(paramInt1, paramInt2);
  }
  
  public void release()
  {
    ac.i("MicroMsg.BaseMultiVideoCompositionEffect", "release: ".concat(String.valueOf(this)));
    Iterator localIterator = ((Iterable)this.AqJ).iterator();
    while (localIterator.hasNext()) {
      ((TextureInfo)localIterator.next()).release();
    }
    this.AqJ.clear();
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.a
 * JD-Core Version:    0.7.0.1
 */