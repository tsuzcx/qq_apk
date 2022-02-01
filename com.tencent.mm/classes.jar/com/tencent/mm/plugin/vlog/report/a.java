package com.tencent.mm.plugin.vlog.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ff;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/report/FinderReport21874;", "", "()V", "FinderBackStep", "", "FinderDefaultStep", "FinderNextStep", "FinderPageIn", "FinderPageOut", "TAG", "", "report", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "eventCode", "stayTime", "", "udf_kv", "scene", "nextStep", "udfContent", "Lorg/json/JSONObject;", "jumpId", "FinderActionCode", "FinderEventCode", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a UeF;
  
  static
  {
    AppMethodBeat.i(281305);
    UeF = new a();
    AppMethodBeat.o(281305);
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(281293);
    ff localff = new ff();
    localff.pF(((d)h.ax(d.class)).dHN());
    localff.pH(String.valueOf(paramInt1));
    localff.iGK = paramInt2;
    localff.pI(String.valueOf(System.currentTimeMillis()));
    localff.pJ(z.bAW());
    localff.iGM = paramLong;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localff.pN(paramString);
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      if ((paramInt3 != -1) && (paramInt2 == 1)) {
        paramString.put("nextstep", paramInt3);
      }
      paramJSONObject = paramString.toString();
      s.s(paramJSONObject, "udfJson.toString()");
      localff.pK(n.bV(paramJSONObject, ",", ";"));
      localff.bMH();
      Log.i("MicroMsg.FinderReport21874", "FinderReport21874 report scene:" + paramInt1 + " eventCode:" + paramInt2);
      AppMethodBeat.o(281293);
      return;
      String str = n.m(paramString, ",", ";", false);
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.report.a
 * JD-Core Version:    0.7.0.1
 */