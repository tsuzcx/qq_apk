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
import kotlin.g.a.m;
import kotlin.g.b.aa.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"})
public final class a
  implements c
{
  private static final LruCache<String, Bitmap> Ghx;
  public static final a.a YHM;
  private final LinkedList<b> Ghs;
  private TAVSourceImageGenerator YHJ;
  private final AssetImageGenerator.ImageGeneratorListener YHK;
  private final kotlin.g.a.a<TAVSource> YHL;
  private final String cacheKey;
  private boolean isRunning;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(247898);
    YHM = new a.a((byte)0);
    Ghx = new LruCache(200);
    AppMethodBeat.o(247898);
  }
  
  private a(TAVSource paramTAVSource, String paramString)
  {
    this((kotlin.g.a.a)new q(paramTAVSource) {}, paramString);
    AppMethodBeat.i(247897);
    AppMethodBeat.o(247897);
  }
  
  private a(kotlin.g.a.a<? extends TAVSource> parama, String paramString)
  {
    AppMethodBeat.i(247896);
    this.YHL = parama;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.Ghs = new LinkedList();
    this.YHK = ((AssetImageGenerator.ImageGeneratorListener)new d(this));
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
    AppMethodBeat.o(247896);
  }
  
  private final void aDw()
  {
    AppMethodBeat.i(247893);
    synchronized (this.Ghs)
    {
      boolean bool = this.isRunning;
      if (bool)
      {
        AppMethodBeat.o(247893);
        return;
      }
      if (!((Collection)this.Ghs).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.Ghs.get(0);
        p.j(localObject1, "requests[0]");
        localObject1 = (b)localObject1;
        igz();
        this.isRunning = true;
        TAVSourceImageGenerator localTAVSourceImageGenerator = this.YHJ;
        if (localTAVSourceImageGenerator != null)
        {
          localTAVSourceImageGenerator.generateThumbnailAtTime(((b)localObject1).GhB, this.YHK);
          localObject1 = x.aazN;
        }
        AppMethodBeat.o(247893);
        return;
      }
      igA();
      Object localObject1 = x.aazN;
    }
  }
  
  private final void igA()
  {
    AppMethodBeat.i(247895);
    if (this.YHJ != null)
    {
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.YHJ, new Object[0]);
      Object localObject = this.YHJ;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null) {
          ((AssetImageGenerator)localObject).release();
        }
      }
      this.YHJ = null;
    }
    AppMethodBeat.o(247895);
  }
  
  private final void igz()
  {
    AppMethodBeat.i(247894);
    if (this.YHJ == null)
    {
      this.YHJ = new TAVSourceImageGenerator((TAVSource)this.YHL.invoke(), this.size);
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.YHJ, new Object[0]);
      Object localObject = this.YHJ;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null)
        {
          ((AssetImageGenerator)localObject).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
          AppMethodBeat.o(247894);
          return;
        }
      }
    }
    AppMethodBeat.o(247894);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(247890);
    p.k(???, "times");
    p.k(paramm, "callback");
    Object localObject1 = (Iterable)???;
    ??? = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label173:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      long l = ((Number)localObject2).longValue();
      com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(l)), new Object[0]);
      Bitmap localBitmap = (Bitmap)Ghx.get(this.cacheKey + '-' + l);
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
      AppMethodBeat.o(247890);
      return;
    }
    synchronized (this.Ghs)
    {
      this.Ghs.addAll((Collection)paramm);
      aDw();
      AppMethodBeat.o(247890);
      return;
    }
  }
  
  public final void cancel(final long paramLong)
  {
    AppMethodBeat.i(247891);
    synchronized (this.Ghs)
    {
      j.c((List)this.Ghs, (kotlin.g.a.b)new c(this, paramLong));
      AppMethodBeat.o(247891);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(247892);
    com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
    synchronized (this.Ghs)
    {
      this.Ghs.clear();
      x localx = x.aazN;
      igA();
      AppMethodBeat.o(247892);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"})
  public static final class b
  {
    final long GhA;
    final CMTime GhB;
    final m<Long, Bitmap, x> jHk;
    
    private b(long paramLong, m<? super Long, ? super Bitmap, x> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(247862);
      this.GhA = paramLong;
      this.jHk = paramm;
      this.GhB = paramCMTime;
      AppMethodBeat.o(247862);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(247871);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label80;
        }
        paramObject = (b)paramObject;
        if (this.GhA != paramObject.GhA) {
          break label75;
        }
      }
      label75:
      for (int i = 1; (i != 0) && (p.h(this.jHk, paramObject.jHk)) && (p.h(this.GhB, paramObject.GhB)); i = 0)
      {
        AppMethodBeat.o(247871);
        return true;
      }
      label80:
      AppMethodBeat.o(247871);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(247868);
      long l = this.GhA;
      int k = (int)(l ^ l >>> 32);
      Object localObject = this.jHk;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.GhB;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(247868);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(247865);
      String str = "Request(timeMs=" + this.GhA + ", callback=" + this.jHk + ", cmTime=" + this.GhB + ")";
      AppMethodBeat.o(247865);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$cancel$1$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<a.b, Boolean>
  {
    c(a parama, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
  static final class d
    implements AssetImageGenerator.ImageGeneratorListener
  {
    d(a parama) {}
    
    public final void onCompletion(final CMTime paramCMTime1, final Bitmap paramBitmap, final CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult arg4)
    {
      AppMethodBeat.i(247885);
      p.k(paramCMTime1, "requestedTime");
      p.k(???, "result");
      if (??? != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
        paramBitmap = null;
      }
      paramCMTime2 = new aa.e();
      paramCMTime2.aaBB = -1L;
      synchronized (a.a(this.YHO))
      {
        j.c((List)a.a(this.YHO), (kotlin.g.a.b)new a(this, paramCMTime1, paramCMTime2, paramBitmap));
        com.tencent.mm.videocomposition.c.b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.YHO.hashCode() + ": " + paramCMTime2.aaBB + 65292 + paramCMTime1.getTimeUs() / 1000L, new Object[0]);
        a.b(this.YHO);
        a.c(this.YHO);
        if ((paramCMTime2.aaBB >= 0L) && (paramBitmap != null))
        {
          paramCMTime1 = a.YHM;
          a.fgL().put(a.d(this.YHO) + '-' + paramCMTime2.aaBB, paramBitmap);
        }
        AppMethodBeat.o(247885);
        return;
      }
    }
    
    @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/videocomposition/CompositionThumbGenerator$generateCallback$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.b<a.b, Boolean>
    {
      a(a.d paramd, CMTime paramCMTime, aa.e parame, Bitmap paramBitmap)
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