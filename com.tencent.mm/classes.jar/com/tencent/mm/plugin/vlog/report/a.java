package com.tencent.mm.plugin.vlog.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/report/FinderReport21874;", "", "()V", "FinderBackStep", "", "FinderDefaultStep", "FinderNextStep", "FinderPageIn", "FinderPageOut", "TAG", "", "report", "", "scene", "eventCode", "stayTime", "", "nextStep", "FinderActionCode", "FinderEventCode", "plugin-vlog_release"})
public final class a
{
  public static final a NqV;
  
  static
  {
    AppMethodBeat.i(249605);
    NqV = new a();
    AppMethodBeat.o(249605);
  }
  
  public static void c(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(249599);
    dv localdv = new dv();
    localdv.qT(((c)h.ae(c.class)).dbr());
    localdv.qU(String.valueOf(paramInt1));
    localdv.lM(paramInt2);
    localdv.qV(String.valueOf(System.currentTimeMillis()));
    localdv.qW(z.bdh());
    localdv.jV(paramLong);
    if ((paramInt3 != -1) && (paramInt2 == 1))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nextstep", paramInt3);
      localdv.qX(localJSONObject.toString());
    }
    localdv.bpa();
    Log.i("MicroMsg.FinderReport21874", "FinderReport21874 report scene:" + paramInt1 + " eventCode:" + paramInt2);
    AppMethodBeat.o(249599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.report.a
 * JD-Core Version:    0.7.0.1
 */