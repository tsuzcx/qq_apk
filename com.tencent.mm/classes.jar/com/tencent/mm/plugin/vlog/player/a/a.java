package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Process;
import android.util.Size;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.sdk.platformtools.ad;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "()V", "cacheTextureInfo", "Ljava/util/ArrayList;", "Lcom/tencent/tav/coremedia/TextureInfo;", "cacheTextureSize", "", "frameRenderCallback", "Lkotlin/Function0;", "", "renderContext", "Landroid/opengl/EGLContext;", "getRenderContext", "()Landroid/opengl/EGLContext;", "setRenderContext", "(Landroid/opengl/EGLContext;)V", "renderSize", "Landroid/util/Size;", "getRenderSize", "()Landroid/util/Size;", "setRenderSize", "(Landroid/util/Size;)V", "setThreadPriority", "", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "calcImageTextureSize", "image", "createInputTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/TrackRenderInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "release", "renderTracks", "trackList", "setFrameRenderCallback", "callback", "updateRenderSize", "width", "height", "Companion", "plugin-vlog_release"})
public abstract class a
  implements TAVVideoMixEffect.Filter
{
  public static final a LsI = new a((byte)0);
  private volatile d.g.a.a<d.y> KBP;
  private ArrayList<TextureInfo> LsD = new ArrayList();
  private final int LsE = 3;
  public EGLContext LsF;
  Size LsG;
  private boolean LsH;
  
  public a()
  {
    EGLContext localEGLContext = EGL14.EGL_NO_CONTEXT;
    k.g(localEGLContext, "EGL14.EGL_NO_CONTEXT");
    this.LsF = localEGLContext;
    this.LsG = new Size(0, 0);
    ad.i("MicroMsg.BaseMultiVideoCompositionEffect", "init: ".concat(String.valueOf(this)));
  }
  
  public final void U(d.g.a.a<d.y> parama)
  {
    k.h(parama, "callback");
    ad.d("MicroMsg.BaseMultiVideoCompositionEffect", "setFrameRenderCallback:" + parama.hashCode());
    this.KBP = parama;
  }
  
  public abstract TextureInfo a(CIContext paramCIContext, long paramLong, List<u> paramList);
  
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
    if (!this.LsH)
    {
      ad.i("MicroMsg.BaseMultiVideoCompositionEffect", "set render thread priority ".concat(String.valueOf(this)));
      Process.setThreadPriority(-4);
      this.LsH = true;
      i = 0;
      j = this.LsE;
      while (i < j)
      {
        this.LsD.add(CIContext.newTextureInfo(this.LsG.getWidth(), this.LsG.getHeight()));
        i += 1;
      }
    }
    paramTAVVideoMixEffect = localCIContext.getRenderContext().eglContext();
    k.g(paramTAVVideoMixEffect, "context.renderContext.eglContext()");
    this.LsF = paramTAVVideoMixEffect;
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
            if (!(paramImageCollection instanceof com.tencent.mm.plugin.vlog.model.y)) {
              paramTAVVideoMixEffect = null;
            }
            paramTAVVideoMixEffect = (com.tencent.mm.plugin.vlog.model.y)paramTAVVideoMixEffect;
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
        i = this.LsG.getWidth();
        j = this.LsG.getHeight();
        if ((i > 0) && (j > 0))
        {
          paramTAVVideoMixEffect = null;
          if (this.LsD.size() > 0) {
            paramTAVVideoMixEffect = (TextureInfo)this.LsD.remove(0);
          }
          if ((paramTAVVideoMixEffect != null) && (paramTAVVideoMixEffect.width == i) && (paramTAVVideoMixEffect.height == j)) {
            break label830;
          }
          if (paramTAVVideoMixEffect != null) {
            this.LsD.add(paramTAVVideoMixEffect);
          }
          ad.i("MicroMsg.BaseMultiVideoCompositionEffect", "create new sourceTextureInfo size:[" + i + ", " + j + ']');
          paramTAVVideoMixEffect = CIContext.newTextureInfo(i, j);
        }
      }
    }
    label830:
    for (;;)
    {
      localObject2 = (com.tencent.mm.plugin.vlog.model.y)((o)localObject1).first;
      CIImage localCIImage = (CIImage)((o)localObject1).second;
      Matrix localMatrix = new Matrix();
      int k = ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.viewRect.width();
      int m = ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.viewRect.height();
      RectF localRectF = new RectF(((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.oSt);
      localRectF.offset(-((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.viewRect.left, -((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.viewRect.top);
      p.a(localMatrix, localCIImage.getSize().width, localCIImage.getSize().height, localRectF.left, m - localRectF.bottom, localRectF.right, m - localRectF.top);
      localMatrix.postScale(i * 1.0F / k, j * 1.0F / m);
      localCIImage.imageByApplyingTransform(localMatrix);
      localCIContext.convertImageToTexture((CIImage)((o)localObject1).second, paramTAVVideoMixEffect);
      paramImageCollection.add(new u((com.tencent.mm.plugin.vlog.model.y)((o)localObject1).first, paramTAVVideoMixEffect));
      break;
      paramImageCollection = (List)paramImageCollection;
      paramTAVVideoMixEffect = a(localCIContext, l1, paramImageCollection);
      paramImageCollection = ((Iterable)paramImageCollection).iterator();
      while (paramImageCollection.hasNext())
      {
        paramRenderInfo = (u)paramImageCollection.next();
        this.LsD.add(paramRenderInfo.texture);
      }
      paramImageCollection = this.KBP;
      if (paramImageCollection != null) {
        paramImageCollection.invoke();
      }
      return new CIImage(paramTAVVideoMixEffect);
      return null;
    }
  }
  
  public final void li(int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.BaseMultiVideoCompositionEffect", "updateRenderSize width:" + paramInt1 + ", height:" + paramInt2);
    this.LsG = new Size(paramInt1, paramInt2);
  }
  
  public void release()
  {
    ad.i("MicroMsg.BaseMultiVideoCompositionEffect", "release: ".concat(String.valueOf(this)));
    Iterator localIterator = ((Iterable)this.LsD).iterator();
    while (localIterator.hasNext()) {
      ((TextureInfo)localIterator.next()).release();
    }
    this.LsD.clear();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.a
 * JD-Core Version:    0.7.0.1
 */