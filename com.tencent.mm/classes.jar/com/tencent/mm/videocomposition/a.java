package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.AssetImageGenerator.AssetImageGeneratorResult;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.e;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"})
public final class a
  implements c
{
  private static final LruCache<String, Bitmap> LIZ;
  public static final a LJa;
  private TAVSourceImageGenerator LIV;
  private final LinkedList<b> LIW;
  private final AssetImageGenerator.ImageGeneratorListener LIX;
  private final d.g.a.a<TAVSource> LIY;
  private final String cacheKey;
  private boolean isRunning;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(194947);
    LJa = new a((byte)0);
    LIZ = new LruCache(200);
    AppMethodBeat.o(194947);
  }
  
  private a(TAVSource paramTAVSource, String paramString)
  {
    this((d.g.a.a)new q(paramTAVSource) {}, paramString);
    AppMethodBeat.i(194946);
    AppMethodBeat.o(194946);
  }
  
  private a(d.g.a.a<? extends TAVSource> parama, String paramString)
  {
    AppMethodBeat.i(194945);
    this.LIY = parama;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.LIW = new LinkedList();
    this.LIX = ((AssetImageGenerator.ImageGeneratorListener)new d(this));
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
    AppMethodBeat.o(194945);
  }
  
  private final void fTR()
  {
    AppMethodBeat.i(194942);
    synchronized (this.LIW)
    {
      boolean bool = this.isRunning;
      if (bool)
      {
        AppMethodBeat.o(194942);
        return;
      }
      if (!((Collection)this.LIW).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.LIW.get(0);
        p.g(localObject1, "requests[0]");
        localObject1 = (b)localObject1;
        fTS();
        this.isRunning = true;
        TAVSourceImageGenerator localTAVSourceImageGenerator = this.LIV;
        if (localTAVSourceImageGenerator != null)
        {
          localTAVSourceImageGenerator.generateThumbnailAtTime(((b)localObject1).LJd, this.LIX);
          localObject1 = z.Nhr;
        }
        AppMethodBeat.o(194942);
        return;
      }
      fTT();
      Object localObject1 = z.Nhr;
    }
  }
  
  private final void fTS()
  {
    AppMethodBeat.i(194943);
    if (this.LIV == null)
    {
      this.LIV = new TAVSourceImageGenerator((TAVSource)this.LIY.invoke(), this.size);
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.LIV, new Object[0]);
      Object localObject = this.LIV;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null)
        {
          ((AssetImageGenerator)localObject).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
          AppMethodBeat.o(194943);
          return;
        }
      }
    }
    AppMethodBeat.o(194943);
  }
  
  private final void fTT()
  {
    AppMethodBeat.i(194944);
    if (this.LIV != null)
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.LIV, new Object[0]);
      Object localObject = this.LIV;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null) {
          ((AssetImageGenerator)localObject).release();
        }
      }
      this.LIV = null;
    }
    AppMethodBeat.o(194944);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(194939);
    p.h(???, "times");
    p.h(paramm, "callback");
    Object localObject1 = (Iterable)???;
    ??? = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label173:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      long l = ((Number)localObject2).longValue();
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(l)), new Object[0]);
      Bitmap localBitmap = (Bitmap)LIZ.get(this.cacheKey + '-' + l);
      if (localBitmap != null) {
        paramm.p(Long.valueOf(l), localBitmap);
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label173;
        }
        ???.add(localObject2);
        break;
      }
    }
    localObject1 = (Iterable)j.p((Iterable)???);
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new b(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request", new Object[0]);
      AppMethodBeat.o(194939);
      return;
    }
    synchronized (this.LIW)
    {
      this.LIW.addAll((Collection)paramm);
      fTR();
      AppMethodBeat.o(194939);
      return;
    }
  }
  
  public final void c(final m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(194940);
    p.h(paramm, "callback");
    synchronized (this.LIW)
    {
      j.c((List)this.LIW, (d.g.a.b)new c(this, paramm));
      AppMethodBeat.o(194940);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(194941);
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
    synchronized (this.LIW)
    {
      this.LIW.clear();
      z localz = z.Nhr;
      fTT();
      AppMethodBeat.o(194941);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"})
  public static final class a
  {
    public static a a(b paramb)
    {
      AppMethodBeat.i(194929);
      p.h(paramb, "track");
      paramb = new a(paramb.fTW(), paramb.path, (byte)0);
      AppMethodBeat.o(194929);
      return paramb;
    }
    
    public static a b(h paramh)
    {
      AppMethodBeat.i(194930);
      p.h(paramh, "composition");
      paramh = new a((d.g.a.a)new a(paramh), String.valueOf(paramh.hashCode()), (byte)0);
      AppMethodBeat.o(194930);
      return paramh;
    }
    
    @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<TAVSource>
    {
      a(h paramh)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"})
  public static final class b
  {
    final long Cly;
    final CMTime LJd;
    final m<Long, Bitmap, z> glx;
    
    private b(long paramLong, m<? super Long, ? super Bitmap, z> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(194931);
      this.Cly = paramLong;
      this.glx = paramm;
      this.LJd = paramCMTime;
      AppMethodBeat.o(194931);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(194935);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label80;
        }
        paramObject = (b)paramObject;
        if (this.Cly != paramObject.Cly) {
          break label75;
        }
      }
      label75:
      for (int i = 1; (i != 0) && (p.i(this.glx, paramObject.glx)) && (p.i(this.LJd, paramObject.LJd)); i = 0)
      {
        AppMethodBeat.o(194935);
        return true;
      }
      label80:
      AppMethodBeat.o(194935);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(194934);
      long l = this.Cly;
      int k = (int)(l ^ l >>> 32);
      Object localObject = this.glx;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.LJd;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(194934);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194933);
      String str = "Request(timeMs=" + this.Cly + ", callback=" + this.glx + ", cmTime=" + this.LJd + ")";
      AppMethodBeat.o(194933);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$cancel$2$1"})
  static final class c
    extends q
    implements d.g.a.b<a.b, Boolean>
  {
    c(a parama, m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
  static final class d
    implements AssetImageGenerator.ImageGeneratorListener
  {
    d(a parama) {}
    
    public final void onCompletion(final CMTime paramCMTime1, final Bitmap paramBitmap, final CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult arg4)
    {
      AppMethodBeat.i(194938);
      p.h(paramCMTime1, "requestedTime");
      p.h(???, "result");
      if (??? != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
        paramBitmap = null;
      }
      paramCMTime2 = new y.e();
      paramCMTime2.NiX = -1L;
      synchronized (a.a(this.LJe))
      {
        j.c((List)a.a(this.LJe), (d.g.a.b)new a(this, paramCMTime1, paramCMTime2, paramBitmap));
        com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.LJe.hashCode() + ": " + paramCMTime2.NiX + 65292 + paramCMTime1.getTimeUs() / 1000L, new Object[0]);
        a.b(this.LJe);
        a.c(this.LJe);
        if ((paramCMTime2.NiX >= 0L) && (paramBitmap != null))
        {
          paramCMTime1 = a.LJa;
          a.fTU().put(a.d(this.LJe) + '-' + paramCMTime2.NiX, paramBitmap);
        }
        AppMethodBeat.o(194938);
        return;
      }
    }
    
    @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$generateCallback$1$1$1"})
    static final class a
      extends q
      implements d.g.a.b<a.b, Boolean>
    {
      a(a.d paramd, CMTime paramCMTime, y.e parame, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a
 * JD-Core Version:    0.7.0.1
 */