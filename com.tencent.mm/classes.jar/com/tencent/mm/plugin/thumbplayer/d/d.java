package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "", "()V", "TAG", "", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getEffectReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setEffectReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "errorCount", "", "getErrorCount", "()I", "firstFrame", "", "getFirstFrame", "()J", "setFirstFrame", "(J)V", "mediaReportInfo", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "Lkotlin/collections/HashMap;", "getMediaReportInfo", "()Ljava/util/HashMap;", "playTime", "getPlayTime", "setPlayTime", "startTick", "getStartTick", "setStartTick", "appendPlayerInfo", "", "index", "info", "getPlayInfoJson", "reset", "start", "stop", "toString", "plugin-thumbplayer_release"})
public final class d
{
  private final String TAG;
  public c Utk;
  public long Utl;
  public final HashMap<Integer, b> Utm;
  public long gXF;
  public long vgo;
  
  public d()
  {
    AppMethodBeat.i(258718);
    this.TAG = "MicroMsg.MV.MvReportInfo";
    this.Utm = new HashMap();
    AppMethodBeat.o(258718);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(258715);
    p.h(paramb, "info");
    if ((this.Utm.isEmpty()) || (this.Utl <= 0L)) {
      this.Utl = paramb.UsY;
    }
    c localc = this.Utk;
    if (localc != null)
    {
      paramb.Utc = ((int)((float)localc.Utg * 1.0F / localc.Utf));
      paramb.Utd = localc.Uth;
      paramb.Ute = localc.Uti;
      localc.reset();
    }
    this.Utm.put(Integer.valueOf(paramInt), paramb);
    Log.i(this.TAG, paramInt + ", " + paramb);
    AppMethodBeat.o(258715);
  }
  
  public final String gWO()
  {
    AppMethodBeat.i(258716);
    try
    {
      i locali1 = new i();
      Iterator localIterator = ((Map)this.Utm).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        i locali2 = new i();
        locali2.v("firstFrame", ((b)localEntry.getValue()).UsY).v("playTime", ((b)localEntry.getValue()).vgo).U("waitCount", ((b)localEntry.getValue()).UsZ).U("renderTime", ((b)localEntry.getValue()).Utc);
        if (((b)localEntry.getValue()).gWN()) {
          locali2.U("errType", ((b)localEntry.getValue()).errType).U("errCode", ((b)localEntry.getValue()).errCode);
        }
        if (((b)localEntry.getValue()).Utd > 0) {
          locali2.U("ptsNegative", ((b)localEntry.getValue()).Utd);
        }
        if (((b)localEntry.getValue()).Ute > 0) {
          locali2.U("ptsOutOfBound", ((b)localEntry.getValue()).Ute);
        }
        locali1.h(String.valueOf(((Number)localEntry.getKey()).intValue()), locali2);
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "getJson", new Object[0]);
      AppMethodBeat.o(258716);
      return "";
    }
    p.g(str, "obj.toString()");
    String str = n.j(str, ",", ";", false);
    AppMethodBeat.o(258716);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258717);
    Object localObject = this.Utm.entrySet();
    p.g(localObject, "mediaReportInfo.entries");
    localObject = j.a((Iterable)localObject, null, null, null, 0, null, (kotlin.g.a.b)a.Utn, 31);
    AppMethodBeat.o(258717);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Map.Entry<Integer, b>, String>
  {
    public static final a Utn;
    
    static
    {
      AppMethodBeat.i(258714);
      Utn = new a();
      AppMethodBeat.o(258714);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.d
 * JD-Core Version:    0.7.0.1
 */