package com.tencent.mm.videocomposition.b;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.util.ArrayMap;
import android.util.Size;
import com.tencent.mm.videocomposition.f;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "()V", "assetSize", "Landroid/util/Size;", "getAssetSize", "()Landroid/util/Size;", "setAssetSize", "(Landroid/util/Size;)V", "cacheTextureInfo", "Landroid/util/ArrayMap;", "Lkotlin/Pair;", "", "Ljava/util/LinkedList;", "Lcom/tencent/tav/coremedia/TextureInfo;", "renderContext", "Landroid/opengl/EGLContext;", "getRenderContext", "()Landroid/opengl/EGLContext;", "setRenderContext", "(Landroid/opengl/EGLContext;)V", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "createInputTrackList", "", "Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "pts", "", "release", "", "renderTracks", "trackList", "updateAssetSize", "width", "height", "Companion", "video_composition_release"})
public abstract class a
  implements TAVVideoMixEffect.Filter
{
  public static final a.a YJD = new a.a((byte)0);
  private ArrayMap<o<Integer, Integer>, LinkedList<TextureInfo>> YJA = new ArrayMap();
  private EGLContext YJB;
  private Size YJC;
  
  public a()
  {
    EGLContext localEGLContext = EGL14.EGL_NO_CONTEXT;
    p.j(localEGLContext, "EGL14.EGL_NO_CONTEXT");
    this.YJB = localEGLContext;
    this.YJC = new Size(0, 0);
    com.tencent.mm.videocomposition.c.b.i("BaseMultiVideoCompositionEffect", "init: ".concat(String.valueOf(this)), new Object[0]);
  }
  
  public abstract TextureInfo a(CIContext paramCIContext, long paramLong, List<f> paramList);
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    Object localObject1;
    if (paramRenderInfo != null)
    {
      localObject1 = paramRenderInfo.getCiContext();
      if (localObject1 != null) {}
    }
    else
    {
      return null;
    }
    p.j(localObject1, "renderInfo?.ciContext ?: return null");
    if ((this.YJC.getWidth() == 0) || (this.YJC.getHeight() == 0))
    {
      np(paramRenderInfo.getRenderWidth(), paramRenderInfo.getRenderHeight());
      com.tencent.mm.videocomposition.c.b.e("BaseMultiVideoCompositionEffect", "assetsSize error %s, update as renderSize", new Object[] { this.YJC });
    }
    paramTAVVideoMixEffect = ((CIContext)localObject1).getRenderContext().eglContext();
    p.j(paramTAVVideoMixEffect, "context.renderContext.eglContext()");
    this.YJB = paramTAVVideoMixEffect;
    paramTAVVideoMixEffect = paramRenderInfo.getTime();
    p.j(paramTAVVideoMixEffect, "renderInfo.time");
    long l1 = paramTAVVideoMixEffect.getTimeUs() / 1000L;
    Object localObject2;
    if (paramImageCollection != null)
    {
      localObject2 = new LinkedList();
      Object localObject3 = paramImageCollection.getVideoChannelImages().iterator();
      Object localObject4;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ImageCollection.TrackImagePair)((Iterator)localObject3).next();
        p.j(localObject4, "it");
        paramTAVVideoMixEffect = ((ImageCollection.TrackImagePair)localObject4).getTrack();
        if (paramTAVVideoMixEffect == null) {
          throw new t("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
        }
        paramTAVVideoMixEffect = (TAVClip)paramTAVVideoMixEffect;
        if (!(paramTAVVideoMixEffect.getResource() instanceof TAVEmptyResource))
        {
          paramImageCollection = paramTAVVideoMixEffect.getStartTime();
          p.j(paramImageCollection, "clip.startTime");
          long l2 = paramImageCollection.getTimeUs() / 1000L;
          paramImageCollection = paramTAVVideoMixEffect.getDuration();
          p.j(paramImageCollection, "clip.duration");
          long l3 = paramImageCollection.getTimeUs() / 1000L;
          if ((l2 <= l1) && (l3 + l2 + 1L > l1))
          {
            paramImageCollection = paramTAVVideoMixEffect.getExtraTrackInfo("key_extra_track");
            paramTAVVideoMixEffect = paramImageCollection;
            if (!(paramImageCollection instanceof com.tencent.mm.videocomposition.b)) {
              paramTAVVideoMixEffect = null;
            }
            paramTAVVideoMixEffect = (com.tencent.mm.videocomposition.b)paramTAVVideoMixEffect;
            if (paramTAVVideoMixEffect != null) {
              ((LinkedList)localObject2).add(new o(paramTAVVideoMixEffect, ((ImageCollection.TrackImagePair)localObject4).getImage()));
            }
          }
        }
      }
      paramImageCollection = new LinkedList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (o)((Iterator)localObject2).next();
        paramTAVVideoMixEffect = (CIImage)((o)localObject3).My;
        int i = (int)paramTAVVideoMixEffect.getSize().width;
        int j = (int)paramTAVVideoMixEffect.getSize().height;
        if ((i > 0) && (j > 0))
        {
          paramTAVVideoMixEffect = new o(Integer.valueOf(i), Integer.valueOf(j));
          localObject4 = (LinkedList)this.YJA.get(paramTAVVideoMixEffect);
          Collection localCollection = (Collection)localObject4;
          if ((localCollection == null) || (localCollection.isEmpty()))
          {
            i = 1;
            label452:
            if (i != 0) {
              break label546;
            }
          }
          label546:
          for (paramTAVVideoMixEffect = (TextureInfo)((LinkedList)localObject4).removeFirst();; paramTAVVideoMixEffect = CIContext.newTextureInfo(((Number)paramTAVVideoMixEffect.Mx).intValue(), ((Number)paramTAVVideoMixEffect.My).intValue()))
          {
            ((CIImage)((o)localObject3).My).applyFlip(false, true);
            ((CIContext)localObject1).convertImageToTexture((CIImage)((o)localObject3).My, paramTAVVideoMixEffect);
            ((CIImage)((o)localObject3).My).reset();
            localObject3 = (com.tencent.mm.videocomposition.b)((o)localObject3).Mx;
            p.j(paramTAVVideoMixEffect, "sourceTextureInfo");
            paramImageCollection.add(new f((com.tencent.mm.videocomposition.b)localObject3, paramTAVVideoMixEffect));
            break;
            i = 0;
            break label452;
          }
        }
      }
      paramTAVVideoMixEffect = (List)paramImageCollection;
      paramImageCollection = a((CIContext)localObject1, l1, paramTAVVideoMixEffect);
      localObject1 = ((Iterable)paramTAVVideoMixEffect).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        localObject3 = new o(Integer.valueOf(((f)localObject2).texture.width), Integer.valueOf(((f)localObject2).texture.height));
        localObject4 = (Map)this.YJA;
        paramTAVVideoMixEffect = ((Map)localObject4).get(localObject3);
        if (paramTAVVideoMixEffect != null) {
          break label755;
        }
        paramTAVVideoMixEffect = new LinkedList();
        ((Map)localObject4).put(localObject3, paramTAVVideoMixEffect);
      }
    }
    label755:
    for (;;)
    {
      ((LinkedList)paramTAVVideoMixEffect).add(((f)localObject2).texture);
      break;
      paramTAVVideoMixEffect = new CIImage(paramImageCollection);
      paramTAVVideoMixEffect.applyFlip(false, true);
      paramTAVVideoMixEffect.applyFillInFrame(new CGRect(0.0F, 0.0F, paramRenderInfo.getRenderWidth(), paramRenderInfo.getRenderHeight()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
      return paramTAVVideoMixEffect;
      return null;
    }
  }
  
  protected final Size igI()
  {
    return this.YJC;
  }
  
  public void np(int paramInt1, int paramInt2)
  {
    com.tencent.mm.videocomposition.c.b.i("BaseMultiVideoCompositionEffect", "updateRenderSize width:" + paramInt1 + ", height:" + paramInt2, new Object[0]);
    this.YJC = new Size(paramInt1, paramInt2);
  }
  
  public void release()
  {
    com.tencent.mm.videocomposition.c.b.i("BaseMultiVideoCompositionEffect", "release: ".concat(String.valueOf(this)), new Object[0]);
    Object localObject2 = (Map)this.YJA;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)((Map.Entry)((Iterator)localObject2).next()).getValue());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((TextureInfo)((Iterator)localObject1).next()).release();
    }
    this.YJA.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.a
 * JD-Core Version:    0.7.0.1
 */