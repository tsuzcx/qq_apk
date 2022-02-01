package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.a.a;
import com.tencent.mm.sdk.platformtools.ad;
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
import d.g.b.k;
import d.g.b.v.d;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSource", "()Lcom/tencent/tavkit/composition/TAVSource;", "destroy", "", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "Companion", "Request", "plugin-vlog_release"})
public final class x
  implements com.tencent.mm.plugin.vlog.ui.thumb.c
{
  private static final com.tencent.mm.memory.a.b<Bitmap> Lrg;
  public static final a Lrh;
  private TAVSourceImageGenerator Lrc;
  private final LinkedList<b> Lrd;
  private final AssetImageGenerator.ImageGeneratorListener Lre;
  private final TAVSource Lrf;
  private final String cacheKey;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(200928);
    Lrh = new a((byte)0);
    Lrg = new com.tencent.mm.memory.a.b(200, x.class);
    AppMethodBeat.o(200928);
  }
  
  private x(TAVSource paramTAVSource, String paramString)
  {
    AppMethodBeat.i(200927);
    this.Lrf = paramTAVSource;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.Lrd = new LinkedList();
    this.Lre = ((AssetImageGenerator.ImageGeneratorListener)new c(this));
    AppMethodBeat.o(200927);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(200925);
    k.h(???, "times");
    k.h(paramm, "callback");
    Object localObject1 = (Iterable)???;
    ??? = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label165:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      long l = ((Number)localObject2).longValue();
      ad.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(l)));
      Bitmap localBitmap = (Bitmap)Lrg.get(this.cacheKey + '-' + l);
      if (localBitmap != null) {
        paramm.n(Long.valueOf(l), localBitmap);
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label165;
        }
        ???.add(localObject2);
        break;
      }
    }
    localObject1 = (Iterable)j.q((Iterable)???);
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new b(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      ad.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request");
      AppMethodBeat.o(200925);
      return;
    }
    synchronized (this.Lrd)
    {
      localObject1 = ((Iterable)paramm).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        com.tencent.mm.ad.c.a(this.Lrd, (d.g.a.b)new d((b)localObject2));
      }
    }
    this.Lrd.addAll((Collection)paramm);
    paramm = (Iterable)paramm;
    ??? = (Collection)new ArrayList(j.a(paramm, 10));
    paramm = paramm.iterator();
    while (paramm.hasNext()) {
      ???.add(((b)paramm.next()).cmTime);
    }
    ??? = (List)???;
    if (this.Lrc == null)
    {
      this.Lrc = new TAVSourceImageGenerator(this.Lrf, this.size);
      ad.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: create generator " + this.Lrc);
      paramm = this.Lrc;
      if (paramm != null)
      {
        paramm = paramm.getAssetImageGenerator();
        if (paramm != null) {
          paramm.setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
        }
      }
    }
    paramm = this.Lrc;
    if (paramm != null)
    {
      paramm.generateThumbnailAtTimes(???, this.Lre);
      AppMethodBeat.o(200925);
      return;
    }
    AppMethodBeat.o(200925);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(200926);
    ad.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode() + ", " + this.Lrc);
    synchronized (this.Lrd)
    {
      this.Lrd.clear();
      y localy = y.JfV;
      ??? = this.Lrc;
      if (??? != null)
      {
        ??? = ((TAVSourceImageGenerator)???).getAssetImageGenerator();
        if (??? != null)
        {
          ((AssetImageGenerator)???).release();
          AppMethodBeat.o(200926);
          return;
        }
      }
    }
    AppMethodBeat.o(200926);
  }
  
  public final void init()
  {
    AppMethodBeat.i(200924);
    ad.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode());
    AppMethodBeat.o(200924);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clearCache", "", "fromVLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "fromVLogCompositionTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "plugin-vlog_release"})
  public static final class a
  {
    public static x f(v paramv)
    {
      AppMethodBeat.i(200918);
      k.h(paramv, "composition");
      paramv = new x(paramv.buildSource(), String.valueOf(paramv.hashCode()), (byte)0);
      AppMethodBeat.o(200918);
      return paramv;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "plugin-vlog_release"})
  public static final class b
  {
    final long Lri;
    final CMTime cmTime;
    final m<Long, Bitmap, y> fLT;
    
    private b(long paramLong, m<? super Long, ? super Bitmap, y> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(200919);
      this.Lri = paramLong;
      this.fLT = paramm;
      this.cmTime = paramCMTime;
      AppMethodBeat.o(200919);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "requestedTime", "Lcom/tencent/tav/coremedia/CMTime;", "bitmap", "Landroid/graphics/Bitmap;", "actualTime", "result", "Lcom/tencent/tav/core/AssetImageGenerator$AssetImageGeneratorResult;", "onCompletion"})
  static final class c
    implements AssetImageGenerator.ImageGeneratorListener
  {
    c(x paramx) {}
    
    public final void onCompletion(final CMTime paramCMTime1, final Bitmap paramBitmap, CMTime arg3, final AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult)
    {
      AppMethodBeat.i(200922);
      k.h(paramCMTime1, "requestedTime");
      k.h(paramAssetImageGeneratorResult, "result");
      if (paramAssetImageGeneratorResult != AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded)
      {
        paramCMTime1 = a.LrI;
        a.fYT();
        AppMethodBeat.o(200922);
        return;
      }
      if (paramBitmap == null)
      {
        paramCMTime1 = a.LrI;
        a.fYS();
        AppMethodBeat.o(200922);
        return;
      }
      paramAssetImageGeneratorResult = new v.d();
      paramAssetImageGeneratorResult.Jhv = -1L;
      synchronized (x.a(this.Lrj))
      {
        j.a((List)x.a(this.Lrj), (d.g.a.b)new a(this, paramCMTime1, paramAssetImageGeneratorResult, paramBitmap));
        ad.i("MicroMsg.VLogCompositionCoverGenerator", "get " + this.Lrj.hashCode() + ": " + paramAssetImageGeneratorResult.Jhv + 65292 + paramCMTime1.getTimeUs() / 1000L);
        if (paramAssetImageGeneratorResult.Jhv >= 0L) {
          x.fYL().put(x.b(this.Lrj) + '-' + paramAssetImageGeneratorResult.Jhv, paramBitmap);
        }
        AppMethodBeat.o(200922);
        return;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "invoke", "com/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$generateCallback$1$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<x.b, Boolean>
    {
      a(x.c paramc, CMTime paramCMTime, v.d paramd, Bitmap paramBitmap)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<x.b, Boolean>
  {
    d(x.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.x
 * JD-Core Version:    0.7.0.1
 */