package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final int FlL = 86400000;
  private static long FlM = 0L;
  public static final d FlN;
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  
  static
  {
    AppMethodBeat.i(118647);
    FlN = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    FlL = 86400000;
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Ois, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    FlM = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void aaG(int paramInt)
  {
    AppMethodBeat.i(118646);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Oir, Integer.valueOf(Math.min(paramInt, ((Number)f.Flq.aLT()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    Log.d(TAG, "lastTimestamp: " + FlM);
    long l = cl.aWz();
    if (l - FlM > FlL)
    {
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(ar.a.Oir, Integer.valueOf(0));
      FlM = l;
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).azQ().set(ar.a.Ois, Long.valueOf(FlM));
      Log.d(TAG, "count reset to 0, lastTimestamp update to now: " + FlM);
    }
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Oir, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)f.Flq.aLT()).intValue())
    {
      Log.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    Log.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void fnK()
  {
    AppMethodBeat.i(118644);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Oir, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).azQ().set(ar.a.Oir, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void fnL()
  {
    AppMethodBeat.i(118645);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.Oir, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).azQ().set(ar.a.Oir, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */