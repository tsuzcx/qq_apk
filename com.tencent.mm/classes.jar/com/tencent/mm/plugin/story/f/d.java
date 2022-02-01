package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  private static final int zru = 86400000;
  private static long zrv;
  public static final d zrw;
  
  static
  {
    AppMethodBeat.i(118647);
    zrw = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    zru = 86400000;
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GSH, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    zrv = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void Qu(int paramInt)
  {
    AppMethodBeat.i(118646);
    e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    locale.agA().set(ah.a.GSG, Integer.valueOf(Math.min(paramInt, ((Number)f.zqV.aqp()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    ac.d(TAG, "lastTimestamp: " + zrv);
    long l = ce.azI();
    if (l - zrv > zru)
    {
      localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).agA().set(ah.a.GSG, Integer.valueOf(0));
      zrv = l;
      localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).agA().set(ah.a.GSH, Long.valueOf(zrv));
      ac.d(TAG, "count reset to 0, lastTimestamp update to now: " + zrv);
    }
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GSG, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)f.zqV.aqp()).intValue())
    {
      ac.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    ac.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void dVm()
  {
    AppMethodBeat.i(118644);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GSG, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GSG, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void dVn()
  {
    AppMethodBeat.i(118645);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).agA().get(ah.a.GSG, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GSG, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */