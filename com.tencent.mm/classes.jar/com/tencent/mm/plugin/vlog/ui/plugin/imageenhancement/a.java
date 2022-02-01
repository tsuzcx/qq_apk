package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.k.g;
import kotlin.k.i;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "", "()V", "isCancel", "", "cancel", "", "getImageLabel", "Landroid/util/Pair;", "", "", "path", "", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getTrackLabel", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getVideoLabel", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "isAllImage", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a GLn;
  private volatile boolean ifz;
  
  static
  {
    AppMethodBeat.i(191750);
    GLn = new a((byte)0);
    AppMethodBeat.o(191750);
  }
  
  private static Pair<Integer, Long> a(final ad paramad, com.tencent.mm.plugin.xlabeffect.b paramb)
  {
    AppMethodBeat.i(191749);
    long l3 = Util.currentTicks();
    final Object localObject1 = new Object();
    Object localObject2 = com.tencent.mm.videocomposition.c.RgU;
    Object localObject3 = com.tencent.mm.videocomposition.c.a.b(paramad.GzA);
    ((com.tencent.mm.videocomposition.c)localObject3).setSize(100, 100);
    final ArrayList localArrayList = new ArrayList();
    paramad = j.a((g)new i(0L, paramad.getDurationMs()), 1000L);
    long l2 = paramad.first;
    long l4 = paramad.SZc;
    long l5 = paramad.BMh;
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
    paramad = new int[13];
    ((com.tencent.mm.videocomposition.c)localObject3).b((List)localArrayList, (m)new b(paramb, (z.d)localObject2, paramad, localArrayList, localObject1));
    for (;;)
    {
      try
      {
        localObject1.wait();
        localObject3 = x.SXb;
        if (((z.d)localObject2).SYE < 10)
        {
          i = paramb.glg();
          if (i >= 0) {
            paramad[i] += 1;
          }
        }
        paramb = e.aa(paramad);
        if (paramb != null)
        {
          i = paramb.intValue();
          i = e.n(paramad, i);
          l1 = Util.ticksToNow(l3);
          paramb = com.tencent.mm.plugin.vlog.model.report.a.GBa;
          com.tencent.mm.plugin.vlog.model.report.a.KS(l1);
          paramb = new StringBuilder("getTrackLabel finish, cost:").append(l1).append(", trackFrameCount:").append(((z.d)localObject2).SYE).append(", videoLabelScore:");
          paramad = Arrays.toString(paramad);
          p.g(paramad, "java.util.Arrays.toString(this)");
          Log.i("MicroMsg.CompositionLabelRetriever", paramad + ", videoLabel:" + i);
          paramad = new Pair(Integer.valueOf(i), Long.valueOf(l1));
          AppMethodBeat.o(191749);
          return paramad;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.CompositionLabelRetriever", (Throwable)localException, "", new Object[0]);
        continue;
      }
      finally
      {
        AppMethodBeat.o(191749);
      }
      int i = -1;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(191748);
    this.ifz = true;
    Log.i("MicroMsg.CompositionLabelRetriever", "cancel get label");
    AppMethodBeat.o(191748);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class b
    extends q
    implements m<Long, Bitmap, x>
  {
    b(com.tencent.mm.plugin.xlabeffect.b paramb, z.d paramd, int[] paramArrayOfInt, ArrayList paramArrayList, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(a parama, boolean paramBoolean, v paramv, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(191747);
      Object localObject1 = com.tencent.mm.media.k.c.ilt;
      localObject1 = com.tencent.mm.media.k.c.a.aNa();
      if (p.j(((c.b)localObject1).ilv, EGL14.EGL_NO_CONTEXT))
      {
        Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
        AppMethodBeat.o(191747);
        return;
      }
      if (a.a(this.GLt))
      {
        Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        AppMethodBeat.o(191747);
        return;
      }
      Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      com.tencent.mm.plugin.vlog.model.local.a.fBX();
      com.tencent.mm.plugin.xlabeffect.b localb = new com.tencent.mm.plugin.xlabeffect.b();
      localObject2 = new HashMap();
      Object localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
      com.tencent.mm.plugin.vlog.model.report.a.fCh();
      Object localObject4;
      Pair localPair;
      if (!this.GJS)
      {
        localObject3 = ((Iterable)this.GLu.GxA.Gzn).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ad)((Iterator)localObject3).next();
          if (a.a(this.GLt))
          {
            Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
          }
          else
          {
            localPair = a.b((ad)localObject4, localb);
            ((Map)localObject2).put(((ad)localObject4).path, localPair);
          }
        }
      }
      localObject3 = ((Iterable)this.GLu.Gyv).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (a.a(this.GLt))
        {
          Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
        }
        else
        {
          localPair = a.a((String)localObject4, localb);
          ((Map)localObject2).put(localObject4, localPair);
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
            label356:
            if (i == 0) {
              break label494;
            }
            i = 1;
            label362:
            if (i == 0) {
              break label501;
            }
            localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
            com.tencent.mm.plugin.vlog.model.report.a.fCj();
          }
        }
      }
      for (;;)
      {
        localb.destroy();
        if ((p.j(((c.b)localObject1).eglSurface, EGL14.EGL_NO_SURFACE) ^ true)) {
          EGL14.eglDestroySurface(((c.b)localObject1).ilu, ((c.b)localObject1).eglSurface);
        }
        EGL14.eglDestroyContext(((c.b)localObject1).ilu, ((c.b)localObject1).ilv);
        Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + localObject2 + ", isCancel:" + a.a(this.GLt));
        if (a.a(this.GLt)) {
          ((HashMap)localObject2).clear();
        }
        localObject1 = this.gWe;
        if (localObject1 == null) {
          break label512;
        }
        ((kotlin.g.a.b)localObject1).invoke(localObject2);
        AppMethodBeat.o(191747);
        return;
        i = 0;
        break label356;
        label494:
        break;
        i = 0;
        break label362;
        label501:
        localObject3 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
        com.tencent.mm.plugin.vlog.model.report.a.fCi();
      }
      label512:
      AppMethodBeat.o(191747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a
 * JD-Core Version:    0.7.0.1
 */