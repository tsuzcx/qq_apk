package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final int LFN = 86400000;
  private static long LFO = 0L;
  public static final d LFP;
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  
  static
  {
    AppMethodBeat.i(118647);
    LFP = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    LFN = 86400000;
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VwI, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    LFO = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void aib(int paramInt)
  {
    AppMethodBeat.i(118646);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VwH, Integer.valueOf(Math.min(paramInt, ((Number)com.tencent.mm.plugin.story.c.a.f.LFs.aUb()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    Log.d(TAG, "lastTimestamp: " + LFO);
    long l = cm.bfD();
    if (l - LFO > LFN)
    {
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VwH, Integer.valueOf(0));
      LFO = l;
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VwI, Long.valueOf(LFO));
      Log.d(TAG, "count reset to 0, lastTimestamp update to now: " + LFO);
    }
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VwH, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)com.tencent.mm.plugin.story.c.a.f.LFs.aUb()).intValue())
    {
      Log.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    Log.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void gce()
  {
    AppMethodBeat.i(118644);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VwH, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VwH, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void gcf()
  {
    AppMethodBeat.i(118645);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VwH, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VwH, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */