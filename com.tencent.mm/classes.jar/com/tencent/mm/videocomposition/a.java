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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "sourceBuilder", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "isRunning", "", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSourceBuilder", "()Lkotlin/jvm/functions/Function0;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "destroyGenerator", "ensureGenerator", "requestFrames", "times", "", "requestNext", "setSize", "width", "", "height", "Companion", "Request", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a
  implements c
{
  private static final LruCache<String, Bitmap> GvK;
  public static final a agDr;
  private final LinkedList<a.b> GvG;
  private boolean Uz;
  private TAVSourceImageGenerator agDo;
  private final AssetImageGenerator.ImageGeneratorListener agDp;
  private final kotlin.g.a.a<TAVSource> agDq;
  private final String mgR;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(233533);
    agDr = new a((byte)0);
    GvK = new LruCache(200);
    AppMethodBeat.o(233533);
  }
  
  private a(TAVSource paramTAVSource, String paramString)
  {
    this((kotlin.g.a.a)new u(paramTAVSource) {}, paramString);
    AppMethodBeat.i(233530);
    AppMethodBeat.o(233530);
  }
  
  private a(kotlin.g.a.a<? extends TAVSource> parama, String paramString)
  {
    AppMethodBeat.i(233525);
    this.agDq = parama;
    this.mgR = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.GvG = new LinkedList();
    this.agDp = ((AssetImageGenerator.ImageGeneratorListener)new d(this));
    com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode(), new Object[0]);
    AppMethodBeat.o(233525);
  }
  
  private final void aWx()
  {
    AppMethodBeat.i(233503);
    synchronized (this.GvG)
    {
      boolean bool = this.Uz;
      if (bool)
      {
        AppMethodBeat.o(233503);
        return;
      }
      if (!((Collection)this.GvG).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.GvG.get(0);
        s.r(localObject1, "requests[0]");
        localObject1 = (a.b)localObject1;
        jLM();
        this.Uz = true;
        TAVSourceImageGenerator localTAVSourceImageGenerator = this.agDo;
        if (localTAVSourceImageGenerator != null)
        {
          localTAVSourceImageGenerator.generateThumbnailAtTime(((a.b)localObject1).GvN, this.agDp);
          localObject1 = ah.aiuX;
        }
        AppMethodBeat.o(233503);
        return;
      }
      jLN();
      Object localObject1 = ah.aiuX;
    }
  }
  
  private final void jLM()
  {
    AppMethodBeat.i(233512);
    if (this.agDo == null)
    {
      this.agDo = new TAVSourceImageGenerator((TAVSource)this.agDq.invoke(), this.size);
      com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "create generator " + this.agDo, new Object[0]);
      Object localObject = this.agDo;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null)
        {
          ((AssetImageGenerator)localObject).setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
          AppMethodBeat.o(233512);
          return;
        }
      }
    }
    AppMethodBeat.o(233512);
  }
  
  private final void jLN()
  {
    AppMethodBeat.i(233517);
    if (this.agDo != null)
    {
      com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy generator: " + this.agDo, new Object[0]);
      Object localObject = this.agDo;
      if (localObject != null)
      {
        localObject = ((TAVSourceImageGenerator)localObject).getAssetImageGenerator();
        if (localObject != null) {
          ((AssetImageGenerator)localObject).release();
        }
      }
      this.agDo = null;
    }
    AppMethodBeat.o(233517);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, ah> paramm)
  {
    AppMethodBeat.i(233582);
    s.t(???, "times");
    s.t(paramm, "callback");
    Object localObject1 = (Iterable)???;
    ??? = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label173:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      long l = ((Number)localObject2).longValue();
      com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(l)), new Object[0]);
      Bitmap localBitmap = (Bitmap)GvK.get(this.mgR + '-' + l);
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
    localObject1 = (Iterable)p.t((Iterable)???);
    ??? = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new a.b(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request", new Object[0]);
      AppMethodBeat.o(233582);
      return;
    }
    synchronized (this.GvG)
    {
      this.GvG.addAll((Collection)paramm);
      aWx();
      AppMethodBeat.o(233582);
      return;
    }
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(233590);
    synchronized (this.GvG)
    {
      p.e((List)this.GvG, (kotlin.g.a.b)new a.c(this, paramLong));
      AppMethodBeat.o(233590);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(233594);
    com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode(), new Object[0]);
    synchronized (this.GvG)
    {
      this.GvG.clear();
      ah localah = ah.aiuX;
      jLN();
      AppMethodBeat.o(233594);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a
  {
    public static a d(b paramb)
    {
      AppMethodBeat.i(233463);
      s.t(paramb, "track");
      paramb = new a(paramb.jLP(), paramb.path, (byte)0);
      AppMethodBeat.o(233463);
      return paramb;
    }
    
    public static a e(j paramj)
    {
      AppMethodBeat.i(233470);
      s.t(paramj, "composition");
      paramj = new a((kotlin.g.a.a)new a(paramj), String.valueOf(paramj.hashCode()), (byte)0);
      AppMethodBeat.o(233470);
      return paramj;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"}, k=3, mv={1, 1, 15})
    static final class a
      extends u
      implements kotlin.g.a.a<TAVSource>
    {
      a(j paramj)
      {
        super();
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"}, k=3, mv={1, 1, 15})
  static final class d
    implements AssetImageGenerator.ImageGeneratorListener
  {
    d(a parama) {}
    
    public final void onCompletion(CMTime paramCMTime1, Bitmap paramBitmap, CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult arg4)
    {
      AppMethodBeat.i(233466);
      s.t(paramCMTime1, "requestedTime");
      s.t(???, "result");
      if (??? != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded) {
        paramBitmap = null;
      }
      paramCMTime2 = new ah.e();
      paramCMTime2.aixc = -1L;
      synchronized (a.a(this.agDt))
      {
        p.e((List)a.a(this.agDt), (kotlin.g.a.b)new a.d.a(this, paramCMTime1, paramCMTime2, paramBitmap));
        com.tencent.mm.videocomposition.d.b.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.agDt.hashCode() + ": " + paramCMTime2.aixc + 65292 + paramCMTime1.getTimeUs() / 1000L, new Object[0]);
        a.b(this.agDt);
        a.c(this.agDt);
        if ((paramCMTime2.aixc >= 0L) && (paramBitmap != null))
        {
          paramCMTime1 = a.agDr;
          a.fka().put(a.d(this.agDt) + '-' + paramCMTime2.aixc, paramBitmap);
        }
        AppMethodBeat.o(233466);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a
 * JD-Core Version:    0.7.0.1
 */