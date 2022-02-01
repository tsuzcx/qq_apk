package com.tencent.mm.plugin.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "", "()V", "TAG", "", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getEffectReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setEffectReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "errorCount", "", "getErrorCount", "()I", "firstFrame", "", "getFirstFrame", "()J", "setFirstFrame", "(J)V", "mediaReportInfo", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "Lkotlin/collections/HashMap;", "getMediaReportInfo", "()Ljava/util/HashMap;", "playTime", "getPlayTime", "setPlayTime", "startTick", "getStartTick", "setStartTick", "appendPlayerInfo", "", "index", "info", "getPlayInfoJson", "reset", "start", "stop", "toString", "plugin-thumbplayer_release"})
public final class c
{
  public b MSw;
  public long MSx;
  public final HashMap<Integer, a> MSy;
  private final String TAG;
  public long jID;
  public long zXw;
  
  public c()
  {
    AppMethodBeat.i(193338);
    this.TAG = "MicroMsg.MV.MvReportInfo";
    this.MSy = new HashMap();
    AppMethodBeat.o(193338);
  }
  
  public final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(193317);
    p.k(parama, "info");
    if ((this.MSy.isEmpty()) || (this.MSx <= 0L)) {
      this.MSx = parama.tJV;
    }
    b localb = this.MSw;
    if (localb != null)
    {
      parama.MSq = ((int)((float)localb.kYp * 1.0F / localb.kYq));
      parama.MSr = localb.MSt;
      parama.MSs = localb.MSu;
      localb.reset();
    }
    this.MSy.put(Integer.valueOf(paramInt), parama);
    Log.i(this.TAG, paramInt + ", " + parama);
    AppMethodBeat.o(193317);
  }
  
  public final String goo()
  {
    AppMethodBeat.i(193333);
    try
    {
      i locali1 = new i();
      Iterator localIterator = ((Map)this.MSy).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        i locali2 = new i();
        locali2.s("firstFrame", ((a)localEntry.getValue()).tJV).s("playTime", ((a)localEntry.getValue()).zXw).al("waitCount", ((a)localEntry.getValue()).MSn).al("renderTime", ((a)localEntry.getValue()).MSq);
        if (((a)localEntry.getValue()).gon()) {
          locali2.al("errType", ((a)localEntry.getValue()).errType).al("errCode", ((a)localEntry.getValue()).errCode);
        }
        if (((a)localEntry.getValue()).MSr > 0) {
          locali2.al("ptsNegative", ((a)localEntry.getValue()).MSr);
        }
        if (((a)localEntry.getValue()).MSs > 0) {
          locali2.al("ptsOutOfBound", ((a)localEntry.getValue()).MSs);
        }
        locali1.g(String.valueOf(((Number)localEntry.getKey()).intValue()), locali2);
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "getJson", new Object[0]);
      AppMethodBeat.o(193333);
      return "";
    }
    p.j(str, "obj.toString()");
    String str = n.l(str, ",", ";", false);
    AppMethodBeat.o(193333);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193335);
    Object localObject = this.MSy.entrySet();
    p.j(localObject, "mediaReportInfo.entries");
    localObject = j.a((Iterable)localObject, null, null, null, 0, null, (kotlin.g.a.b)c.a.MSz, 31);
    AppMethodBeat.o(193335);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.e.c
 * JD-Core Version:    0.7.0.1
 */