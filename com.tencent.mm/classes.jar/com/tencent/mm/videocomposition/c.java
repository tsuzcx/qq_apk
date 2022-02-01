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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.e;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"})
public final class c
  implements g
{
  private static final LruCache<String, Bitmap> Asq;
  public static final a RgU;
  private final LinkedList<b> Asm;
  private TAVSourceImageGenerator RgR;
  private final AssetImageGenerator.ImageGeneratorListener RgS;
  private final a<TAVSource> RgT;
  private final String cacheKey;
  private boolean isRunning;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(216738);
    RgU = new a((byte)0);
    Asq = new LruCache(200);
    AppMethodBeat.o(216738);
  }
  
  private c(TAVSource paramTAVSource, String paramString)
  {
    this((a)new q(paramTAVSource) {}, paramString);
    AppMethodBeat.i(216737);
    AppMethodBeat.o(216737);
  }
  
  private c(a<? extends TAVSource> parama, String paramString)
  {
    AppMethodBeat.i(216736);
    this.RgT = parama;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.Asm = new LinkedList();
    this.RgS = ((AssetImageGenerator.ImageGeneratorListener)new d(this));
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
    AppMethodBeat.o(216736);
  }
  
  private final void evJ()
  {
    AppMethodBeat.i(216733);
    synchronized (this.Asm)
    {
      boolean bool = this.isRunning;
      if (bool)
      {
        AppMethodBeat.o(216733);
        return;
      }
      if (!((Collection)this.Asm).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.Asm.get(0);
        p.g(localObject1, "requests[0]");
        localObject1 = (b)localObject1;
        hfh();
        this.isRunning = true;
        TAVSourceImageGenerator localTAVSourceImageGenerator = this.RgR;
        if (localTAVSourceImageGenerator != null)
        {
          localTAVSourceImageGenerator.generateThumbnailAtTime(((b)localObject1).Asw, this.RgS);
          localObject1 = x.SXb;
        }
        AppMethodBeat.o(216733);
        return;
      }
      hfi();
      Object localObject1 = x.SXb;
    }
  }
  
  private final void hfh()
  {
    AppMethodBeat.i(216734);
    if (this.RgR == null)
    {
      this.RgR = new TAVSourceImageGenerator((TAVSource)this.RgT.invoke(), this.size);
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.RgR, new Object[0]);
      Object localObject = this.RgR;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null)
        {
          ((AssetImageGenerator)localObject).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
          AppMethodBeat.o(216734);
          return;
        }
      }
    }
    AppMethodBeat.o(216734);
  }
  
  private final void hfi()
  {
    AppMethodBeat.i(216735);
    if (this.RgR != null)
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.RgR, new Object[0]);
      Object localObject = this.RgR;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null) {
          ((AssetImageGenerator)localObject).release();
        }
      }
      this.RgR = null;
    }
    AppMethodBeat.o(216735);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(216730);
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
      Bitmap localBitmap = (Bitmap)Asq.get(this.cacheKey + '-' + l);
      if (localBitmap != null) {
        paramm.invoke(Long.valueOf(l), localBitmap);
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
    localObject1 = (Iterable)j.t((Iterable)???);
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new b(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request", new Object[0]);
      AppMethodBeat.o(216730);
      return;
    }
    synchronized (this.Asm)
    {
      this.Asm.addAll((Collection)paramm);
      evJ();
      AppMethodBeat.o(216730);
      return;
    }
  }
  
  public final void cancel(final long paramLong)
  {
    AppMethodBeat.i(216731);
    synchronized (this.Asm)
    {
      j.c((List)this.Asm, (kotlin.g.a.b)new c(this, paramLong));
      AppMethodBeat.o(216731);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216732);
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
    synchronized (this.Asm)
    {
      this.Asm.clear();
      x localx = x.SXb;
      hfi();
      AppMethodBeat.o(216732);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"})
  public static final class a
  {
    public static c b(d paramd)
    {
      AppMethodBeat.i(216720);
      p.h(paramd, "track");
      paramd = new c(paramd.hfj(), paramd.path, (byte)0);
      AppMethodBeat.o(216720);
      return paramd;
    }
    
    public static c b(n paramn)
    {
      AppMethodBeat.i(216721);
      p.h(paramn, "composition");
      paramn = new c((a)new a(paramn), String.valueOf(paramn.hashCode()), (byte)0);
      AppMethodBeat.o(216721);
      return paramn;
    }
    
    @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"})
    static final class a
      extends q
      implements a<TAVSource>
    {
      a(n paramn)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"})
  public static final class b
  {
    final long Asv;
    final CMTime Asw;
    final m<Long, Bitmap, x> gWp;
    
    private b(long paramLong, m<? super Long, ? super Bitmap, x> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(216722);
      this.Asv = paramLong;
      this.gWp = paramm;
      this.Asw = paramCMTime;
      AppMethodBeat.o(216722);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(216726);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label80;
        }
        paramObject = (b)paramObject;
        if (this.Asv != paramObject.Asv) {
          break label75;
        }
      }
      label75:
      for (int i = 1; (i != 0) && (p.j(this.gWp, paramObject.gWp)) && (p.j(this.Asw, paramObject.Asw)); i = 0)
      {
        AppMethodBeat.o(216726);
        return true;
      }
      label80:
      AppMethodBeat.o(216726);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(216725);
      long l = this.Asv;
      int k = (int)(l ^ l >>> 32);
      Object localObject = this.gWp;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.Asw;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(216725);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(216724);
      String str = "Request(timeMs=" + this.Asv + ", callback=" + this.gWp + ", cmTime=" + this.Asw + ")";
      AppMethodBeat.o(216724);
      return str;
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$cancel$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<c.b, Boolean>
  {
    c(c paramc, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
  static final class d
    implements AssetImageGenerator.ImageGeneratorListener
  {
    d(c paramc) {}
    
    public final void onCompletion(final CMTime paramCMTime1, final Bitmap paramBitmap, final CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult arg4)
    {
      AppMethodBeat.i(216729);
      p.h(paramCMTime1, "requestedTime");
      p.h(???, "result");
      if (??? != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
        paramBitmap = null;
      }
      paramCMTime2 = new z.e();
      paramCMTime2.SYF = -1L;
      synchronized (c.a(this.RgW))
      {
        j.c((List)c.a(this.RgW), (kotlin.g.a.b)new a(this, paramCMTime1, paramCMTime2, paramBitmap));
        com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.RgW.hashCode() + ": " + paramCMTime2.SYF + 65292 + paramCMTime1.getTimeUs() / 1000L, new Object[0]);
        c.b(this.RgW);
        c.c(this.RgW);
        if ((paramCMTime2.SYF >= 0L) && (paramBitmap != null))
        {
          paramCMTime1 = c.RgU;
          c.evK().put(c.d(this.RgW) + '-' + paramCMTime2.SYF, paramBitmap);
        }
        AppMethodBeat.o(216729);
        return;
      }
    }
    
    @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$generateCallback$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<c.b, Boolean>
    {
      a(c.d paramd, CMTime paramCMTime, z.e parame, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c
 * JD-Core Version:    0.7.0.1
 */