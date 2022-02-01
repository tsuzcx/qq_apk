package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"})
public final class d
{
  private static final int AJo = 86400000;
  private static long AJp = 0L;
  public static final d AJq;
  private static final String TAG = "MicroMsg.OneDayPostChecker";
  
  static
  {
    AppMethodBeat.i(118647);
    AJq = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    AJo = 86400000;
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IFm, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    AJp = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void Sd(int paramInt)
  {
    AppMethodBeat.i(118646);
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IFl, Integer.valueOf(Math.min(paramInt, ((Number)f.AIP.ate()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    ad.d(TAG, "lastTimestamp: " + AJp);
    long l = cf.aCL();
    if (l - AJp > AJo)
    {
      localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajl().set(al.a.IFl, Integer.valueOf(0));
      AJp = l;
      localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      ((e)localObject).ajl().set(al.a.IFm, Long.valueOf(AJp));
      ad.d(TAG, "count reset to 0, lastTimestamp update to now: " + AJp);
    }
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IFl, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)f.AIP.ate()).intValue())
    {
      ad.d(TAG, "pass, count=".concat(String.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    ad.d(TAG, "goodbye, count=".concat(String.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void ehB()
  {
    AppMethodBeat.i(118644);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IFl, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajl().set(al.a.IFl, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void ehC()
  {
    AppMethodBeat.i(118645);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajl().get(al.a.IFl, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((e)localObject).ajl().set(al.a.IFl, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d
 * JD-Core Version:    0.7.0.1
 */