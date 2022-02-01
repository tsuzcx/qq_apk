package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  private static final int yeu = 86400000;
  private static long yev;
  public static final d yew;
  
  static
  {
    AppMethodBeat.i(118647);
    yew = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    yeu = 86400000;
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.FuN, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    yev = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void Oo(int paramInt)
  {
    AppMethodBeat.i(118646);
    e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(ae.a.FuM, Integer.valueOf(Math.min(paramInt, ((Number)f.ydV.ajp()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    ad.d(TAG, "lastTimestamp: " + yev);
    long l = ce.asR();
    if (l - yev > yeu)
    {
      localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).afk().set(ae.a.FuM, Integer.valueOf(0));
      yev = l;
      localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      ((e)localObject).afk().set(ae.a.FuN, Long.valueOf(yev));
      ad.d(TAG, "count reset to 0, lastTimestamp update to now: " + yev);
    }
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.FuM, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)f.ydV.ajp()).intValue())
    {
      ad.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    ad.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void dGL()
  {
    AppMethodBeat.i(118644);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.FuM, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.FuM, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void dGM()
  {
    AppMethodBeat.i(118645);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).afk().get(ae.a.FuM, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.FuM, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */