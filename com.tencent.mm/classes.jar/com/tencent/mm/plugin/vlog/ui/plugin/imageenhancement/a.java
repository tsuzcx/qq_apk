package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.EGL14;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.j;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever;", "", "()V", "isCancel", "", "cancel", "", "getImageLabel", "Landroid/util/Pair;", "", "", "path", "", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getImageLable", "pathList", "", "callback", "Lkotlin/Function1;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getTrackLabel", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getVideoLabel", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UlL;
  private volatile boolean nzW;
  
  static
  {
    AppMethodBeat.i(283297);
    UlL = new a((byte)0);
    AppMethodBeat.o(283297);
  }
  
  private static Pair<Integer, Long> a(final com.tencent.mm.videocomposition.b paramb, com.tencent.mm.plugin.xlabeffect.k paramk)
  {
    AppMethodBeat.i(283257);
    long l2 = Util.currentTicks();
    final Object localObject1 = new Object();
    Object localObject2 = com.tencent.mm.videocomposition.a.agDr;
    Object localObject3 = com.tencent.mm.videocomposition.a.a.d(paramb);
    ((com.tencent.mm.videocomposition.a)localObject3).setSize(100, 100);
    final ArrayList localArrayList = new ArrayList();
    long l3 = kotlin.e.c.A(0L, paramb.getDurationMs(), 1000L);
    if (0L <= l3) {}
    for (long l1 = 0L;; l1 = 1000L + l1)
    {
      localArrayList.add(Long.valueOf(l1));
      if ((localArrayList.size() >= 10) || (l1 == l3))
      {
        localObject2 = new ah.d();
        paramb = new int[13];
        ((com.tencent.mm.videocomposition.a)localObject3).b((List)localArrayList, (m)new b(paramk, (ah.d)localObject2, paramb, localArrayList, localObject1));
        for (;;)
        {
          try
          {
            localObject1.wait();
            localObject3 = ah.aiuX;
            if (((ah.d)localObject2).aixb < 10)
            {
              i = paramk.iGa();
              if (i >= 0) {
                paramb[i] += 1;
              }
            }
            paramk = kotlin.a.k.ag(paramb);
            if (paramk == null)
            {
              i = -1;
              i = kotlin.a.k.B(paramb, i);
              l1 = Util.ticksToNow(l2);
              paramk = com.tencent.mm.plugin.vlog.model.report.a.Uch;
              com.tencent.mm.plugin.vlog.model.report.a.wD(l1);
              paramk = new StringBuilder("getTrackLabel finish, cost:").append(l1).append(", trackFrameCount:").append(((ah.d)localObject2).aixb).append(", videoLabelScore:");
              paramb = Arrays.toString(paramb);
              s.s(paramb, "java.util.Arrays.toString(this)");
              Log.i("MicroMsg.CompositionLabelRetriever", paramb + ", videoLabel:" + i);
              paramb = new Pair(Integer.valueOf(i), Long.valueOf(l1));
              AppMethodBeat.o(283257);
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
            AppMethodBeat.o(283257);
          }
          int i = paramk.intValue();
        }
      }
    }
  }
  
  private static final void a(a parama, j paramj, kotlin.g.a.b paramb)
  {
    int j = 0;
    AppMethodBeat.i(283286);
    s.u(parama, "this$0");
    s.u(paramj, "$composition");
    c.b localb = c.a.a(com.tencent.mm.media.util.c.nFs);
    if (s.p(localb.eXL, EGL14.EGL_NO_CONTEXT))
    {
      Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
      AppMethodBeat.o(283286);
      return;
    }
    if (parama.nzW)
    {
      Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
      AppMethodBeat.o(283286);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    com.tencent.mm.plugin.vlog.model.local.a.hRD();
    localObject1 = new com.tencent.mm.plugin.xlabeffect.k(0, 0, 0, false, false, 55);
    HashMap localHashMap = new HashMap();
    Object localObject2 = com.tencent.mm.plugin.vlog.model.report.a.Uch;
    com.tencent.mm.plugin.vlog.model.report.a.hRN();
    paramj = ((Iterable)paramj.TDz).iterator();
    while (paramj.hasNext())
    {
      localObject2 = (com.tencent.mm.videocomposition.b)paramj.next();
      if (parama.nzW)
      {
        Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
      }
      else
      {
        Pair localPair = a((com.tencent.mm.videocomposition.b)localObject2, (com.tencent.mm.plugin.xlabeffect.k)localObject1);
        ((Map)localHashMap).put(((com.tencent.mm.videocomposition.b)localObject2).path, localPair);
      }
    }
    paramj = (Map)localHashMap;
    int i = j;
    if (!paramj.isEmpty())
    {
      paramj = paramj.entrySet().iterator();
      i = j;
      if (paramj.hasNext())
      {
        localObject2 = ((Pair)((Map.Entry)paramj.next()).getValue()).first;
        s.s(localObject2, "it.value.first");
        if (((Number)localObject2).intValue() >= 0) {
          break label424;
        }
        i = 1;
        label292:
        if (i == 0) {
          break label427;
        }
        i = 1;
      }
    }
    if (i != 0)
    {
      paramj = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.hRP();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.xlabeffect.k)localObject1).destroy();
      if (!s.p(localb.eglSurface, EGL14.EGL_NO_SURFACE)) {
        EGL14.eglDestroySurface(localb.nFB, localb.eglSurface);
      }
      EGL14.eglDestroyContext(localb.nFB, localb.eXL);
      Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + localHashMap + ", isCancel:" + parama.nzW);
      if (parama.nzW) {
        localHashMap.clear();
      }
      if (paramb != null) {
        paramb.invoke(localHashMap);
      }
      AppMethodBeat.o(283286);
      return;
      label424:
      i = 0;
      break label292;
      label427:
      break;
      paramj = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.hRO();
    }
  }
  
  private static final void a(a parama, List paramList, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(283273);
    s.u(parama, "this$0");
    s.u(paramList, "$pathList");
    c.b localb = c.a.a(com.tencent.mm.media.util.c.nFs);
    if (s.p(localb.eXL, EGL14.EGL_NO_CONTEXT))
    {
      Log.e("MicroMsg.CompositionLabelRetriever", "create EGLContext failed");
      AppMethodBeat.o(283273);
      return;
    }
    if (parama.nzW)
    {
      Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
      AppMethodBeat.o(283273);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    com.tencent.mm.plugin.vlog.model.local.a.hRD();
    localObject1 = new com.tencent.mm.plugin.xlabeffect.k(0, 0, 0, false, false, 55);
    HashMap localHashMap = new HashMap();
    Object localObject2 = com.tencent.mm.plugin.vlog.model.report.a.Uch;
    com.tencent.mm.plugin.vlog.model.report.a.hRN();
    localObject2 = ((Iterable)paramList).iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (parama.nzW)
      {
        Log.i("MicroMsg.CompositionLabelRetriever", "getVideoLabel cancel!");
      }
      else
      {
        long l;
        Object localObject3;
        if (y.ZC(str))
        {
          l = Util.currentTicks();
          localObject3 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
          paramList = y.n(str, false);
          BitmapFactory.decodeFile(paramList, (BitmapFactory.Options)localObject3);
          ((BitmapFactory.Options)localObject3).inSampleSize = BitmapUtil.calculateInSampleSize(((BitmapFactory.Options)localObject3).outWidth, ((BitmapFactory.Options)localObject3).outHeight, 200, 200);
          ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
          localObject3 = BitmapFactory.decodeFile(paramList, (BitmapFactory.Options)localObject3);
          if (localObject3 == null)
          {
            Log.e("MicroMsg.CompositionLabelRetriever", s.X("getImageLabel bitmap is null path:", paramList));
            paramList = new Pair(Integer.valueOf(-1), Long.valueOf(-1L));
          }
        }
        for (;;)
        {
          ((Map)localHashMap).put(str, paramList);
          break;
          Log.d("MicroMsg.CompositionLabelRetriever", "start track image label:" + localObject3 + ", size:[" + ((Bitmap)localObject3).getWidth() + ", " + ((Bitmap)localObject3).getHeight() + "], config:" + ((Bitmap)localObject3).getConfig() + "], path:" + paramList);
          paramList = ByteBuffer.allocateDirect(((Bitmap)localObject3).getByteCount());
          ((Bitmap)localObject3).copyPixelsToBuffer((Buffer)paramList);
          paramList.position(0);
          s.s(paramList, "bitmapBuffer");
          i = ((com.tencent.mm.plugin.xlabeffect.k)localObject1).a((Buffer)paramList, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
          int j = ((com.tencent.mm.plugin.xlabeffect.k)localObject1).iGa();
          Log.d("MicroMsg.CompositionLabelRetriever", "trackImageLabel ret:" + i + ", label:" + j + ", cost:" + Util.ticksToNow(l));
          paramList = new Pair(Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)));
          continue;
          paramList = new Pair(Integer.valueOf(-1), Long.valueOf(-1L));
        }
      }
    }
    paramList = (Map)localHashMap;
    if (!paramList.isEmpty())
    {
      paramList = paramList.entrySet().iterator();
      if (paramList.hasNext())
      {
        localObject2 = ((Pair)((Map.Entry)paramList.next()).getValue()).first;
        s.s(localObject2, "it.value.first");
        if (((Number)localObject2).intValue() < 0)
        {
          i = 1;
          label607:
          if (i == 0) {
            break label742;
          }
          i = 1;
          label613:
          if (i == 0) {
            break label749;
          }
          paramList = com.tencent.mm.plugin.vlog.model.report.a.Uch;
          com.tencent.mm.plugin.vlog.model.report.a.hRP();
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.xlabeffect.k)localObject1).destroy();
      if (!s.p(localb.eglSurface, EGL14.EGL_NO_SURFACE)) {
        EGL14.eglDestroySurface(localb.nFB, localb.eglSurface);
      }
      EGL14.eglDestroyContext(localb.nFB, localb.eXL);
      Log.i("MicroMsg.CompositionLabelRetriever", "all track list label:" + localHashMap + ", isCancel:" + parama.nzW);
      if (parama.nzW) {
        localHashMap.clear();
      }
      if (paramb != null) {
        paramb.invoke(localHashMap);
      }
      AppMethodBeat.o(283273);
      return;
      i = 0;
      break label607;
      label742:
      break;
      i = 0;
      break label613;
      label749:
      paramList = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.hRO();
    }
  }
  
  public final void a(j paramj, kotlin.g.a.b<? super HashMap<String, Pair<Integer, Long>>, ah> paramb)
  {
    AppMethodBeat.i(283331);
    s.u(paramj, "composition");
    h.ahAA.bm(new a..ExternalSyntheticLambda0(this, paramj, paramb));
    AppMethodBeat.o(283331);
  }
  
  public final void c(List<String> paramList, kotlin.g.a.b<? super HashMap<String, Pair<Integer, Long>>, ah> paramb)
  {
    AppMethodBeat.i(283321);
    s.u(paramList, "pathList");
    h.ahAA.bm(new a..ExternalSyntheticLambda1(this, paramList, paramb));
    AppMethodBeat.o(283321);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(283337);
    this.nzW = true;
    Log.i("MicroMsg.CompositionLabelRetriever", "cancel get label");
    AppMethodBeat.o(283337);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/CompositionLabelRetriever$Companion;", "", "()V", "TAG", "", "maxTrackFrameCount", "", "thumbSize", "timeStep", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Long, Bitmap, ah>
  {
    b(com.tencent.mm.plugin.xlabeffect.k paramk, ah.d paramd, int[] paramArrayOfInt, ArrayList<Long> paramArrayList, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.a
 * JD-Core Version:    0.7.0.1
 */