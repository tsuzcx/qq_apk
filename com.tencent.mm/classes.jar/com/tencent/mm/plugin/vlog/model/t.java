package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "source", "Lcom/tencent/tavkit/composition/TAVSource;", "cacheKey", "", "(Lcom/tencent/tavkit/composition/TAVSource;Ljava/lang/String;)V", "generateCallback", "Lcom/tencent/tav/core/AssetImageGenerator$ImageGeneratorListener;", "generator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Request;", "size", "Lcom/tencent/tav/coremedia/CGSize;", "getSource", "()Lcom/tencent/tavkit/composition/TAVSource;", "destroy", "", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "Companion", "Request", "plugin-vlog_release"})
public final class t
  implements com.tencent.mm.plugin.vlog.ui.thumb.c
{
  private static final com.tencent.mm.memory.a.b<Bitmap> Aoo;
  public static final t.a Aop;
  private TAVSourceImageGenerator Aok;
  private final LinkedList<t.b> Aol;
  private final AssetImageGenerator.ImageGeneratorListener Aom;
  private final TAVSource Aon;
  private final String cacheKey;
  private final CGSize size;
  
  static
  {
    AppMethodBeat.i(207614);
    Aop = new t.a((byte)0);
    Aoo = new com.tencent.mm.memory.a.b(200, t.class);
    AppMethodBeat.o(207614);
  }
  
  private t(TAVSource paramTAVSource, String paramString)
  {
    AppMethodBeat.i(207613);
    this.Aon = paramTAVSource;
    this.cacheKey = paramString;
    this.size = new CGSize(300.0F, 300.0F);
    this.Aol = new LinkedList();
    this.Aom = ((AssetImageGenerator.ImageGeneratorListener)new t.c(this));
    AppMethodBeat.o(207613);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(207611);
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
      ac.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: ".concat(String.valueOf(l)));
      Bitmap localBitmap = (Bitmap)Aoo.get(this.cacheKey + '-' + l);
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
    localObject1 = (Iterable)j.p((Iterable)???);
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new t.b(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      ac.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: no new request");
      AppMethodBeat.o(207611);
      return;
    }
    synchronized (this.Aol)
    {
      localObject1 = ((Iterable)paramm).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (t.b)((Iterator)localObject1).next();
        com.tencent.mm.ac.c.a(this.Aol, (d.g.a.b)new t.d((t.b)localObject2));
      }
    }
    this.Aol.addAll((Collection)paramm);
    paramm = (Iterable)paramm;
    ??? = (Collection)new ArrayList(j.a(paramm, 10));
    paramm = paramm.iterator();
    while (paramm.hasNext()) {
      ???.add(((t.b)paramm.next()).cmTime);
    }
    ??? = (List)???;
    if (this.Aok == null)
    {
      this.Aok = new TAVSourceImageGenerator(this.Aon, this.size);
      ac.i("MicroMsg.VLogCompositionCoverGenerator", "requestFrames: create generator " + this.Aok);
      paramm = this.Aok;
      if (paramm != null)
      {
        paramm = paramm.getAssetImageGenerator();
        if (paramm != null) {
          paramm.setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
        }
      }
    }
    paramm = this.Aok;
    if (paramm != null)
    {
      paramm.generateThumbnailAtTimes(???, this.Aom);
      AppMethodBeat.o(207611);
      return;
    }
    AppMethodBeat.o(207611);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(207612);
    ac.i("MicroMsg.VLogCompositionCoverGenerator", "destroy: " + hashCode() + ", " + this.Aok);
    synchronized (this.Aol)
    {
      this.Aol.clear();
      y localy = y.KTp;
      ??? = this.Aok;
      if (??? != null)
      {
        ??? = ((TAVSourceImageGenerator)???).getAssetImageGenerator();
        if (??? != null)
        {
          ((AssetImageGenerator)???).release();
          AppMethodBeat.o(207612);
          return;
        }
      }
    }
    AppMethodBeat.o(207612);
  }
  
  public final void init()
  {
    AppMethodBeat.i(207610);
    ac.i("MicroMsg.VLogCompositionCoverGenerator", "init: " + hashCode());
    AppMethodBeat.o(207610);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    this.size.width = paramInt1;
    this.size.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t
 * JD-Core Version:    0.7.0.1
 */