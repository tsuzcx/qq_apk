package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "", "()V", "TAG", "", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getEffectReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setEffectReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "errorCount", "", "getErrorCount", "()I", "firstFrame", "", "getFirstFrame", "()J", "setFirstFrame", "(J)V", "mediaReportInfo", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "Lkotlin/collections/HashMap;", "getMediaReportInfo", "()Ljava/util/HashMap;", "playTime", "getPlayTime", "setPlayTime", "startTick", "getStartTick", "setStartTick", "appendPlayerInfo", "", "index", "info", "getPlayInfoJson", "reset", "start", "stop", "toString", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public long Ftc;
  private final String TAG;
  public b TEQ;
  public long TER;
  public final HashMap<Integer, a> TES;
  public long moe;
  
  public c()
  {
    AppMethodBeat.i(272066);
    this.TAG = "MicroMsg.MV.MvReportInfo";
    this.TES = new HashMap();
    AppMethodBeat.o(272066);
  }
  
  public final void a(int paramInt, a parama)
  {
    AppMethodBeat.i(272071);
    s.u(parama, "info");
    if ((this.TES.isEmpty()) || (this.TER <= 0L)) {
      this.TER = parama.wNr;
    }
    b localb = this.TEQ;
    if (localb != null)
    {
      parama.TEK = ((int)((float)localb.nDw * 1.0F / localb.nDx));
      parama.TEL = localb.TEN;
      parama.TEM = localb.TEO;
      localb.reset();
    }
    this.TES.put(Integer.valueOf(paramInt), parama);
    Log.i(this.TAG, paramInt + ", " + parama);
    AppMethodBeat.o(272071);
  }
  
  public final String hLb()
  {
    AppMethodBeat.i(272080);
    try
    {
      i locali1 = new i();
      Iterator localIterator = ((Map)this.TES).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        i locali2 = new i();
        locali2.t("firstFrame", ((a)localEntry.getValue()).wNr).t("playTime", ((a)localEntry.getValue()).Ftc).au("waitCount", ((a)localEntry.getValue()).TEH).au("renderTime", ((a)localEntry.getValue()).TEK);
        if (((a)localEntry.getValue()).hLa()) {
          locali2.au("errType", ((a)localEntry.getValue()).errType).au("errCode", ((a)localEntry.getValue()).errCode);
        }
        if (((a)localEntry.getValue()).TEL > 0) {
          locali2.au("ptsNegative", ((a)localEntry.getValue()).TEL);
        }
        if (((a)localEntry.getValue()).TEM > 0) {
          locali2.au("ptsOutOfBound", ((a)localEntry.getValue()).TEM);
        }
        locali1.m(String.valueOf(((Number)localEntry.getKey()).intValue()), locali2);
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "getJson", new Object[0]);
      AppMethodBeat.o(272080);
      return "";
    }
    s.s(str, "obj.toString()");
    String str = n.m(str, ",", ";", false);
    AppMethodBeat.o(272080);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(272087);
    Object localObject = this.TES.entrySet();
    s.s(localObject, "mediaReportInfo.entries");
    localObject = p.a((Iterable)localObject, null, null, null, 0, null, (kotlin.g.a.b)c.a.TET, 31);
    AppMethodBeat.o(272087);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.c
 * JD-Core Version:    0.7.0.1
 */