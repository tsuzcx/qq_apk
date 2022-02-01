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

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"})
public final class a
  implements c
{
  private static final LruCache<String, Bitmap> Lmp;
  public static final a Lmq;
  private TAVSourceImageGenerator Lml;
  private final LinkedList<b> Lmm;
  private final AssetImageGenerator.ImageGeneratorListener Lmn;
  private final d.g.a.a<TAVSource> Lmo;
  private final String cacheKey;
  private boolean isRunning;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(220811);
    Lmq = new a((byte)0);
    Lmp = new LruCache(200);
    AppMethodBeat.o(220811);
  }
  
  private a(TAVSource paramTAVSource, String paramString)
  {
    this((d.g.a.a)new q(paramTAVSource) {}, paramString);
    AppMethodBeat.i(220810);
    AppMethodBeat.o(220810);
  }
  
  private a(d.g.a.a<? extends TAVSource> parama, String paramString)
  {
    AppMethodBeat.i(220809);
    this.Lmo = parama;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.Lmm = new LinkedList();
    this.Lmn = ((AssetImageGenerator.ImageGeneratorListener)new d(this));
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
    AppMethodBeat.o(220809);
  }
  
  private final void fPv()
  {
    AppMethodBeat.i(220806);
    synchronized (this.Lmm)
    {
      boolean bool = this.isRunning;
      if (bool)
      {
        AppMethodBeat.o(220806);
        return;
      }
      if (!((Collection)this.Lmm).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.Lmm.get(0);
        p.g(localObject1, "requests[0]");
        localObject1 = (b)localObject1;
        fPw();
        this.isRunning = true;
        TAVSourceImageGenerator localTAVSourceImageGenerator = this.Lml;
        if (localTAVSourceImageGenerator != null)
        {
          localTAVSourceImageGenerator.generateThumbnailAtTime(((b)localObject1).Lmt, this.Lmn);
          localObject1 = z.MKo;
        }
        AppMethodBeat.o(220806);
        return;
      }
      fPx();
      Object localObject1 = z.MKo;
    }
  }
  
  private final void fPw()
  {
    AppMethodBeat.i(220807);
    if (this.Lml == null)
    {
      this.Lml = new TAVSourceImageGenerator((TAVSource)this.Lmo.invoke(), this.size);
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.Lml, new Object[0]);
      Object localObject = this.Lml;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null)
        {
          ((AssetImageGenerator)localObject).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
          AppMethodBeat.o(220807);
          return;
        }
      }
    }
    AppMethodBeat.o(220807);
  }
  
  private final void fPx()
  {
    AppMethodBeat.i(220808);
    if (this.Lml != null)
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.Lml, new Object[0]);
      Object localObject = this.Lml;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null) {
          ((AssetImageGenerator)localObject).release();
        }
      }
      this.Lml = null;
    }
    AppMethodBeat.o(220808);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(220803);
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
      Bitmap localBitmap = (Bitmap)Lmp.get(this.cacheKey + '-' + l);
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
      AppMethodBeat.o(220803);
      return;
    }
    synchronized (this.Lmm)
    {
      this.Lmm.addAll((Collection)paramm);
      fPv();
      AppMethodBeat.o(220803);
      return;
    }
  }
  
  public final void c(final m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(220804);
    p.h(paramm, "callback");
    synchronized (this.Lmm)
    {
      j.b((List)this.Lmm, (d.g.a.b)new c(this, paramm));
      AppMethodBeat.o(220804);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(220805);
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
    synchronized (this.Lmm)
    {
      this.Lmm.clear();
      z localz = z.MKo;
      fPx();
      AppMethodBeat.o(220805);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"})
  public static final class a
  {
    public static a a(b paramb)
    {
      AppMethodBeat.i(220793);
      p.h(paramb, "track");
      paramb = new a(paramb.fPA(), paramb.path, (byte)0);
      AppMethodBeat.o(220793);
      return paramb;
    }
    
    public static a b(h paramh)
    {
      AppMethodBeat.i(220794);
      p.h(paramh, "composition");
      paramh = new a((d.g.a.a)new a(paramh), String.valueOf(paramh.hashCode()), (byte)0);
      AppMethodBeat.o(220794);
      return paramh;
    }
    
    @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"})
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
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"})
  public static final class b
  {
    final long BTX;
    final CMTime Lmt;
    final m<Long, Bitmap, z> gjf;
    
    private b(long paramLong, m<? super Long, ? super Bitmap, z> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(220795);
      this.BTX = paramLong;
      this.gjf = paramm;
      this.Lmt = paramCMTime;
      AppMethodBeat.o(220795);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(220799);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label80;
        }
        paramObject = (b)paramObject;
        if (this.BTX != paramObject.BTX) {
          break label75;
        }
      }
      label75:
      for (int i = 1; (i != 0) && (p.i(this.gjf, paramObject.gjf)) && (p.i(this.Lmt, paramObject.Lmt)); i = 0)
      {
        AppMethodBeat.o(220799);
        return true;
      }
      label80:
      AppMethodBeat.o(220799);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(220798);
      long l = this.BTX;
      int k = (int)(l ^ l >>> 32);
      Object localObject = this.gjf;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.Lmt;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(220798);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(220797);
      String str = "Request(timeMs=" + this.BTX + ", callback=" + this.gjf + ", cmTime=" + this.Lmt + ")";
      AppMethodBeat.o(220797);
      return str;
    }
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$cancel$2$1"})
  static final class c
    extends q
    implements d.g.a.b<a.b, Boolean>
  {
    c(a parama, m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
  static final class d
    implements AssetImageGenerator.ImageGeneratorListener
  {
    d(a parama) {}
    
    public final void onCompletion(final CMTime paramCMTime1, final Bitmap paramBitmap, final CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult arg4)
    {
      AppMethodBeat.i(220802);
      p.h(paramCMTime1, "requestedTime");
      p.h(???, "result");
      if (??? != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
        paramBitmap = null;
      }
      paramCMTime2 = new y.e();
      paramCMTime2.MLU = -1L;
      synchronized (a.a(this.Lmu))
      {
        j.b((List)a.a(this.Lmu), (d.g.a.b)new a(this, paramCMTime1, paramCMTime2, paramBitmap));
        com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.Lmu.hashCode() + ": " + paramCMTime2.MLU + 65292 + paramCMTime1.getTimeUs() / 1000L, new Object[0]);
        a.b(this.Lmu);
        a.c(this.Lmu);
        if ((paramCMTime2.MLU >= 0L) && (paramBitmap != null))
        {
          paramCMTime1 = a.Lmq;
          a.fPy().put(a.d(this.Lmu) + '-' + paramCMTime2.MLU, paramBitmap);
        }
        AppMethodBeat.o(220802);
        return;
      }
    }
    
    @l(gfx={1, 1, 15}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$generateCallback$1$1$1"})
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