package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  private static final int sur = 86400000;
  private static long sus;
  public static final d sut;
  
  static
  {
    AppMethodBeat.i(109017);
    sut = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    sur = 86400000;
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().get(ac.a.yLs, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(109017);
      throw ((Throwable)localObject);
    }
    sus = ((Long)localObject).longValue();
    AppMethodBeat.o(109017);
  }
  
  public static void FG(int paramInt)
  {
    AppMethodBeat.i(109016);
    com.tencent.mm.kernel.e locale = g.RL();
    j.p(locale, "MMKernel.storage()");
    locale.Ru().set(ac.a.yLr, Integer.valueOf(Math.min(paramInt, ((Number)com.tencent.mm.plugin.story.c.a.e.ssf.Uw()).intValue())));
    AppMethodBeat.o(109016);
  }
  
  public static void cAg()
  {
    AppMethodBeat.i(109014);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().get(ac.a.yLr, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(109014);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).Ru().set(ac.a.yLr, Integer.valueOf(i + 1));
    AppMethodBeat.o(109014);
  }
  
  public static void cAh()
  {
    AppMethodBeat.i(109015);
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().get(ac.a.yLr, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(109015);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).Ru().set(ac.a.yLr, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(109015);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(109013);
    ab.d(TAG, "lastTimestamp: " + sus);
    long l = cb.abq();
    if (l - sus > sur)
    {
      localObject = g.RL();
      j.p(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).Ru().set(ac.a.yLr, Integer.valueOf(0));
      sus = l;
      localObject = g.RL();
      j.p(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).Ru().set(ac.a.yLs, Long.valueOf(sus));
      ab.d(TAG, "count reset to 0, lastTimestamp update to now: " + sus);
    }
    Object localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().get(ac.a.yLr, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(109013);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)com.tencent.mm.plugin.story.c.a.e.ssf.Uw()).intValue())
    {
      ab.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(109013);
      return true;
    }
    ab.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(109013);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d
 * JD-Core Version:    0.7.0.1
 */