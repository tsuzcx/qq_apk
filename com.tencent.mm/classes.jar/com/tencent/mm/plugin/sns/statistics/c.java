package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/statistics/FinderReportSns21874;", "", "()V", "FinderBackStep", "", "FinderDefaultStep", "FinderNextStep", "FinderPageIn", "FinderPageOut", "MMFinder_GetComment_Scene_Video_Sns_Album", "TAG", "", "report", "", "scene", "eventCode", "stayTime", "", "nextStep", "finderContextId", "FinderActionCode", "FinderEventCode", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c QDu;
  
  static
  {
    AppMethodBeat.i(306506);
    QDu = new c();
    AppMethodBeat.o(306506);
  }
  
  public static void c(int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    AppMethodBeat.i(306497);
    s.u(paramString, "finderContextId");
    hd localhd = new hd();
    localhd.inx = localhd.F("sessionid", ((d)h.ax(d.class)).dHN(), true);
    localhd.ixs = localhd.F("commentscene", "107", true);
    localhd.iGK = paramInt1;
    localhd.iGL = localhd.F("event_time", String.valueOf(System.currentTimeMillis()), true);
    localhd.ixp = localhd.F("finderusername", z.bAW(), true);
    localhd.iGM = paramLong;
    localhd.iGJ = localhd.F("findercontextid", paramString, true);
    if ((paramInt2 != -1) && (paramInt1 == 1))
    {
      paramString = new JSONObject();
      paramString.put("nextstep", paramInt2);
      localhd.iAN = localhd.F("udf_kv", paramString.toString(), true);
    }
    localhd.bMH();
    Log.i("MicroMsg.FinderReportSns21874", "FinderReportSns21874 report scene:107 eventCode:" + paramInt1);
    AppMethodBeat.o(306497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.c
 * JD-Core Version:    0.7.0.1
 */