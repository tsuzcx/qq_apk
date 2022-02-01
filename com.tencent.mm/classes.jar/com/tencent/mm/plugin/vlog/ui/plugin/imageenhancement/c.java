package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.plugin.aj;
import com.tencent.mm.plugin.vlog.ui.plugin.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.k.g;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/WXCompositionLabelRetriever;", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "()V", "isCancel", "", "getTrackLabel", "Landroid/util/Pair;", "", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getVideoLabel", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isEnable", "Companion", "plugin-vlog_release"})
public final class c
  implements com.tencent.mm.videocomposition.e
{
  public static final a GLG;
  private volatile boolean ifz;
  
  static
  {
    AppMethodBeat.i(191776);
    GLG = new a((byte)0);
    AppMethodBeat.o(191776);
  }
  
  private static Pair<Integer, Long> a(final d paramd, com.tencent.mm.plugin.xlabeffect.b paramb)
  {
    AppMethodBeat.i(191773);
    long l3 = Util.currentTicks();
    final Object localObject1 = new Object();
    Object localObject2 = com.tencent.mm.videocomposition.c.RgU;
    Object localObject3 = com.tencent.mm.videocomposition.c.a.b(paramd);
    ((com.tencent.mm.videocomposition.c)localObject3).setSize(100, 100);
    final ArrayList localArrayList = new ArrayList();
    paramd = j.a((g)new kotlin.k.i(0L, paramd.getDurationMs()), 1000L);
    long l2 = paramd.first;
    long l4 = paramd.SZc;
    long l5 = paramd.BMh;
    long l1;
    if (l5 >= 0L)
    {
      if (l2 <= l4) {
        l1 = l2;
      }
    }
    else {
      do
      {
        for (;;)
        {
          localArrayList.add(Long.valueOf(l1));
          if ((localArrayList.size() >= 10) || (l1 == l4)) {
            break;
          }
          l1 += l5;
        }
        l1 = l2;
      } while (l2 >= l4);
    }
    localObject2 = new z.d();
    ((z.d)localObject2).SYE = 0;
    paramd = new int[13];
    ((com.tencent.mm.videocomposition.c)localObject3).b((List)localArrayList, (m)new b(paramb, (z.d)localObject2, paramd, localObject1, localArrayList));
    for (;;)
    {
      try
      {
        if (((z.d)localObject2).SYE < localArrayList.size()) {
          localObject1.wait();
        }
        localObject3 = x.SXb;
        if (((z.d)localObject2).SYE < 10)
        {
          i = paramb.glg();
          if (i >= 0) {
            paramd[i] += 1;
          }
        }
        paramb = kotlin.a.e.aa(paramd);
        if (paramb != null)
        {
          i = paramb.intValue();
          i = kotlin.a.e.n(paramd, i);
          l1 = Util.ticksToNow(l3);
          paramb = com.tencent.mm.plugin.vlog.model.report.a.GBa;
          com.tencent.mm.plugin.vlog.model.report.a.KS(l1);
          paramb = new StringBuilder("getTrackLabel finish, cost:").append(l1).append(", trackFrameCount:").append(((z.d)localObject2).SYE).append(", videoLabelScore:");
          paramd = Arrays.toString(paramd);
          p.g(paramd, "java.util.Arrays.toString(this)");
          Log.i("MicroMsg.WXCompositionLabelRetriever", paramd + ", videoLabel:" + i);
          paramd = new Pair(Integer.valueOf(i), Long.valueOf(l1));
          AppMethodBeat.o(191773);
          return paramd;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WXCompositionLabelRetriever", (Throwable)localException, "", new Object[0]);
        continue;
      }
      finally
      {
        AppMethodBeat.o(191773);
      }
      int i = -1;
    }
  }
  
  public final void a(final n paramn, final kotlin.g.a.b<? super HashMap<String, Pair<Integer, Long>>, x> paramb)
  {
    AppMethodBeat.i(191774);
    p.h(paramn, "composition");
    h.RTc.aX((Runnable)new c(this, paramn, paramb));
    AppMethodBeat.o(191774);
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(191775);
    aj.a locala = aj.GJP;
    boolean bool = aj.a.isEnable();
    AppMethodBeat.o(191775);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/WXCompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements m<Long, Bitmap, x>
  {
    b(com.tencent.mm.plugin.xlabeffect.b paramb, z.d paramd, int[] paramArrayOfInt, Object paramObject, ArrayList paramArrayList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc, n paramn, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(191772);
      Object localObject1 = com.tencent.mm.media.k.c.ilt;
      localObject1 = com.tencent.mm.media.k.c.a.aNa();
      if (p.j(((com.tencent.mm.media.k.c.b)localObject1).ilv, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.WXCompositionLabelRetriever", "create EGLContext failed");
        AppMethodBeat.o(191772);
        return;
      }
      if (c.a(this.GLH))
      {
        Log.i("MicroMsg.WXCompositionLabelRetriever", "getVideoLabel cancel!");
        AppMethodBeat.o(191772);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      com.tencent.mm.plugin.vlog.model.local.a.fBX();
      com.tencent.mm.plugin.xlabeffect.b localb = new com.tencent.mm.plugin.xlabeffect.b();
      localObject2 = new HashMap();
      Object localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
      com.tencent.mm.plugin.vlog.model.report.a.fCh();
      localObject3 = ((Iterable)paramn.Gzn).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        d locald = (d)((Iterator)localObject3).next();
        if (c.a(this.GLH))
        {
          Log.i("MicroMsg.WXCompositionLabelRetriever", "getVideoLabel cancel!");
        }
        else
        {
          Pair localPair = c.b(locald, localb);
          ((Map)localObject2).put(locald.path, localPair);
        }
      }
      localObject3 = (Map)localObject2;
      int i;
      if (!((Map)localObject3).isEmpty())
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        if (((Iterator)localObject3).hasNext()) {
          if (p.compare(((Number)((Pair)((Map.Entry)((Iterator)localObject3).next()).getValue()).first).intValue(), 0) < 0)
          {
            i = 1;
            label261:
            if (i == 0) {
              break label399;
            }
            i = 1;
            label267:
            if (i == 0) {
              break label406;
            }
            localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
            com.tencent.mm.plugin.vlog.model.report.a.fCj();
          }
        }
      }
      for (;;)
      {
        localb.destroy();
        if ((p.j(((com.tencent.mm.media.k.c.b)localObject1).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
          EGL14.eglDestroySurface(((com.tencent.mm.media.k.c.b)localObject1).ilu, ((com.tencent.mm.media.k.c.b)localObject1).eglSurface);
        }
        EGL14.eglDestroyContext(((com.tencent.mm.media.k.c.b)localObject1).ilu, ((com.tencent.mm.media.k.c.b)localObject1).ilv);
        Log.i("MicroMsg.WXCompositionLabelRetriever", "all track list label:" + localObject2 + ", isCancel:" + c.a(this.GLH));
        if (c.a(this.GLH)) {
          ((HashMap)localObject2).clear();
        }
        localObject1 = paramb;
        if (localObject1 == null) {
          break label417;
        }
        ((kotlin.g.a.b)localObject1).invoke(localObject2);
        AppMethodBeat.o(191772);
        return;
        i = 0;
        break label261;
        label399:
        break;
        i = 0;
        break label267;
        label406:
        localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.fCi();
      }
      label417:
      AppMethodBeat.o(191772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.c
 * JD-Core Version:    0.7.0.1
 */