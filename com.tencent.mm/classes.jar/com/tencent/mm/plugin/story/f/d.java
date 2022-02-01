package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final int BaR = 86400000;
  private static long BaS = 0L;
  public static final d BaT;
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  
  static
  {
    AppMethodBeat.i(118647);
    BaT = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    BaR = 86400000;
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.IZM, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    BaS = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void SK(int paramInt)
  {
    AppMethodBeat.i(118646);
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.IZL, Integer.valueOf(Math.min(paramInt, ((Number)f.Bas.att()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    ae.d(TAG, "lastTimestamp: " + BaS);
    long l = ch.aDb();
    if (l - BaS > BaR)
    {
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajA().set(am.a.IZL, Integer.valueOf(0));
      BaS = l;
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajA().set(am.a.IZM, Long.valueOf(BaS));
      ae.d(TAG, "count reset to 0, lastTimestamp update to now: " + BaS);
    }
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.IZL, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)f.Bas.att()).intValue())
    {
      ae.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    ae.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void elj()
  {
    AppMethodBeat.i(118644);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.IZL, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajA().set(am.a.IZL, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void elk()
  {
    AppMethodBeat.i(118645);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.IZL, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajA().set(am.a.IZL, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */