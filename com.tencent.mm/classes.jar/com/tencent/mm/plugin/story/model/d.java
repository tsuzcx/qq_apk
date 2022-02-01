package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/OneDayPostChecker;", "", "()V", "TAG", "", "TIME_ONE_DAY", "", "mYesterdayTime", "", "canPostStory", "", "nextCount", "", "preCount", "updateCount", "count", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static long SjA;
  public static final d Sjy;
  private static final int Sjz;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118647);
    Sjy = new d();
    TAG = "MicroMsg.OneDayPostChecker";
    Sjz = 86400000;
    Object localObject = h.baE().ban().get(at.a.acYt, Long.valueOf(0L));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
      AppMethodBeat.o(118647);
      throw ((Throwable)localObject);
    }
    SjA = ((Long)localObject).longValue();
    AppMethodBeat.o(118647);
  }
  
  public static void anb(int paramInt)
  {
    AppMethodBeat.i(118646);
    h.baE().ban().set(at.a.acYs, Integer.valueOf(Math.min(paramInt, ((Number)com.tencent.mm.plugin.story.c.a.f.Sjd.boF()).intValue())));
    AppMethodBeat.o(118646);
  }
  
  public static boolean canPostStory()
  {
    AppMethodBeat.i(118643);
    Log.d(TAG, s.X("lastTimestamp: ", Long.valueOf(SjA)));
    long l = cn.bDv();
    if (l - SjA > Sjz)
    {
      h.baE().ban().set(at.a.acYs, Integer.valueOf(0));
      SjA = l;
      h.baE().ban().set(at.a.acYt, Long.valueOf(SjA));
      Log.d(TAG, s.X("count reset to 0, lastTimestamp update to now: ", Long.valueOf(SjA)));
    }
    Object localObject = h.baE().ban().get(at.a.acYs, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118643);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    if (i < ((Number)com.tencent.mm.plugin.story.c.a.f.Sjd.boF()).intValue())
    {
      Log.d(TAG, s.X("pass, count=", Integer.valueOf(i)));
      AppMethodBeat.o(118643);
      return true;
    }
    Log.d(TAG, s.X("goodbye, count=", Integer.valueOf(i)));
    AppMethodBeat.o(118643);
    return false;
  }
  
  public static void hvq()
  {
    AppMethodBeat.i(118644);
    Object localObject = h.baE().ban().get(at.a.acYs, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118644);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    h.baE().ban().set(at.a.acYs, Integer.valueOf(i + 1));
    AppMethodBeat.o(118644);
  }
  
  public static void hvr()
  {
    AppMethodBeat.i(118645);
    Object localObject = h.baE().ban().get(at.a.acYs, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(118645);
      throw ((Throwable)localObject);
    }
    int i = ((Integer)localObject).intValue();
    h.baE().ban().set(at.a.acYs, Integer.valueOf(Math.max(0, i - 1)));
    AppMethodBeat.o(118645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d
 * JD-Core Version:    0.7.0.1
 */