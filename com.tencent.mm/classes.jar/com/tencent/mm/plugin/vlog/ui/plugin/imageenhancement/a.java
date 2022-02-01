package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.f;
import kotlin.k.h;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "", "()V", "isCancel", "", "cancel", "", "getImageLabel", "Landroid/util/Pair;", "", "", "path", "", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getImageLable", "pathList", "", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getTrackLabel", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getVideoLabel", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a NyN;
  private volatile boolean kUn;
  
  static
  {
    AppMethodBeat.i(237788);
    NyN = new a((byte)0);
    AppMethodBeat.o(237788);
  }
  
  private static Pair<Integer, Long> a(final com.tencent.mm.videocomposition.b paramb, com.tencent.mm.plugin.xlabeffect.e parame)
  {
    AppMethodBeat.i(237784);
    long l3 = Util.currentTicks();
    final Object localObject1 = new Object();
    Object localObject2 = com.tencent.mm.videocomposition.a.YHM;
    Object localObject3 = com.tencent.mm.videocomposition.a.a.d(paramb);
    ((com.tencent.mm.videocomposition.a)localObject3).setSize(100, 100);
    final ArrayList localArrayList = new ArrayList();
    paramb = i.a((f)new h(0L, paramb.getDurationMs()), 1000L);
    long l2 = paramb.first;
    long l4 = paramb.aaBW;
    long l5 = paramb.HIt;
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
    localObject2 = new aa.d();
    ((aa.d)localObject2).aaBA = 0;
    paramb = new int[13];
    ((com.tencent.mm.videocomposition.a)localObject3).b((List)localArrayList, (m)new c(parame, (aa.d)localObject2, paramb, localArrayList, localObject1));
    for (;;)
    {
      try
      {
        localObject1.wait();
        localObject3 = x.aazN;
        if (((aa.d)localObject2).aaBA < 10)
        {
          i = parame.heZ();
          if (i >= 0) {
            paramb[i] += 1;
          }
        }
        parame = kotlin.a.e.Z(paramb);
        if (parame != null)
        {
          i = parame.intValue();
          i = kotlin.a.e.n(paramb, i);
          l1 = Util.ticksToNow(l3);
          parame = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
          com.tencent.mm.plugin.vlog.model.report.a.Sp(l1);
          parame = new StringBuilder("getTrackLabel finish, cost:").append(l1).append(", trackFrameCount:").append(((aa.d)localObject2).aaBA).append(", videoLabelScore:");
          paramb = Arrays.toString(paramb);
          p.j(paramb, "java.util.Arrays.toString(this)");
          Log.i("MicroMsg.CompositionLabelRetriever", paramb + ", videoLabel:" + i);
          paramb = new Pair(Integer.valueOf(i), Long.valueOf(l1));
          AppMethodBeat.o(237784);
          return paramb;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.CompositionLabelRetriever", (Throwable)localException, "", new Object[0]);
        continue;
      }
      finally
      {
        AppMethodBeat.o(237784);
      }
      int i = -1;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(237780);
    this.kUn = true;
    Log.i("MicroMsg.CompositionLabelRetriever", "cancel get label");
    AppMethodBeat.o(237780);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(a parama, List paramList, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(231245);
      Object localObject1 = c.lar;
      localObject1 = c.a.aVD();
      if (p.h(((c.b)localObject1).lau, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
        AppMethodBeat.o(231245);
        return;
      }
      if (a.a(this.NyO))
      {
        Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        AppMethodBeat.o(231245);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      com.tencent.mm.plugin.vlog.model.local.a.gtV();
      com.tencent.mm.plugin.xlabeffect.e locale = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 0, true, false, 23);
      localObject2 = new HashMap();
      Object localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
      com.tencent.mm.plugin.vlog.model.report.a.guf();
      localObject3 = ((Iterable)this.NyP).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (a.a(this.NyO))
        {
          Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        }
        else
        {
          Pair localPair = a.a(str, locale);
          ((Map)localObject2).put(str, localPair);
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
            label265:
            if (i == 0) {
              break label406;
            }
            i = j;
            label271:
            if (i == 0) {
              break label413;
            }
            localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
            com.tencent.mm.plugin.vlog.model.report.a.guh();
          }
        }
      }
      for (;;)
      {
        locale.destroy();
        if ((p.h(((c.b)localObject1).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
          EGL14.eglDestroySurface(((c.b)localObject1).las, ((c.b)localObject1).eglSurface);
        }
        EGL14.eglDestroyContext(((c.b)localObject1).las, ((c.b)localObject1).lau);
        Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + localObject2 + ", isCancel:" + a.a(this.NyO));
        if (a.a(this.NyO)) {
          ((HashMap)localObject2).clear();
        }
        localObject1 = this.jFa;
        if (localObject1 == null) {
          break label424;
        }
        ((kotlin.g.a.b)localObject1).invoke(localObject2);
        AppMethodBeat.o(231245);
        return;
        i = 0;
        break label265;
        label406:
        break;
        i = 0;
        break label271;
        label413:
        localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
        com.tencent.mm.plugin.vlog.model.report.a.gug();
      }
      label424:
      AppMethodBeat.o(231245);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements m<Long, Bitmap, x>
  {
    c(com.tencent.mm.plugin.xlabeffect.e parame, aa.d paramd, int[] paramArrayOfInt, ArrayList paramArrayList, Object paramObject)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(a parama, j paramj, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(229772);
      Object localObject1 = c.lar;
      localObject1 = c.a.aVD();
      if (p.h(((c.b)localObject1).lau, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
        AppMethodBeat.o(229772);
        return;
      }
      if (a.a(this.NyO))
      {
        Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        AppMethodBeat.o(229772);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      com.tencent.mm.plugin.vlog.model.local.a.gtV();
      com.tencent.mm.plugin.xlabeffect.e locale = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 0, true, false, 23);
      localObject2 = new HashMap();
      Object localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
      com.tencent.mm.plugin.vlog.model.report.a.guf();
      localObject3 = ((Iterable)this.Nku.MQY).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.videocomposition.b localb = (com.tencent.mm.videocomposition.b)((Iterator)localObject3).next();
        if (a.a(this.NyO))
        {
          Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        }
        else
        {
          Pair localPair = a.b(localb, locale);
          ((Map)localObject2).put(localb.path, localPair);
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
            label274:
            if (i == 0) {
              break label415;
            }
            i = j;
            label280:
            if (i == 0) {
              break label422;
            }
            localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
            com.tencent.mm.plugin.vlog.model.report.a.guh();
          }
        }
      }
      for (;;)
      {
        locale.destroy();
        if ((p.h(((c.b)localObject1).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
          EGL14.eglDestroySurface(((c.b)localObject1).las, ((c.b)localObject1).eglSurface);
        }
        EGL14.eglDestroyContext(((c.b)localObject1).las, ((c.b)localObject1).lau);
        Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + localObject2 + ", isCancel:" + a.a(this.NyO));
        if (a.a(this.NyO)) {
          ((HashMap)localObject2).clear();
        }
        localObject1 = this.jFa;
        if (localObject1 == null) {
          break label433;
        }
        ((kotlin.g.a.b)localObject1).invoke(localObject2);
        AppMethodBeat.o(229772);
        return;
        i = 0;
        break label274;
        label415:
        break;
        i = 0;
        break label280;
        label422:
        localObject3 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
        com.tencent.mm.plugin.vlog.model.report.a.gug();
      }
      label433:
      AppMethodBeat.o(229772);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a
 * JD-Core Version:    0.7.0.1
 */