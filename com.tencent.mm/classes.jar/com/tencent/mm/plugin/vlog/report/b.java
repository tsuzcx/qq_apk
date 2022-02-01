package com.tencent.mm.plugin.vlog.report;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kk;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/report/VideoCompositionPerformanceReport;", "", "()V", "TAG", "", "reportMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "Lkotlin/collections/HashMap;", "doReport", "", "key", "getReportStruct", "initBasicInfo", "struct", "initOutputVideoInfo", "videoPath", "getReportKey", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "plugin-vlog_release"})
public final class b
{
  public static final b GDm;
  private static final HashMap<String, kk> ral;
  
  static
  {
    AppMethodBeat.i(190894);
    GDm = new b();
    ral = new HashMap();
    AppMethodBeat.o(190894);
  }
  
  public static void a(kk paramkk, String paramString)
  {
    AppMethodBeat.i(190892);
    p.h(paramkk, "struct");
    if (s.YS(paramString))
    {
      paramString = e.aNx(paramString);
      if (paramString != null)
      {
        paramkk.xH(paramString.toString());
        paramkk.tq(paramString.frameRate);
        paramkk.tt(paramString.videoDuration);
        paramkk.xG(paramString.width / 100 + 'x' + paramString.height / 100);
        AppMethodBeat.o(190892);
        return;
      }
    }
    AppMethodBeat.o(190892);
  }
  
  public static kk aUh(String paramString)
  {
    AppMethodBeat.i(190891);
    p.h(paramString, "key");
    if (!ral.containsKey(paramString))
    {
      ((Map)ral).put(paramString, new kk());
      Object localObject = ral.get(paramString);
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "reportMap[key]!!");
      ((kk)localObject).xI(paramString);
      localObject = ral.get(paramString);
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "reportMap[key]!!");
      localObject = (kk)localObject;
      List localList = n.a((CharSequence)"2.2-267", new char[] { '-' });
      h.hkS();
      if (localList.size() == 2)
      {
        long l = (Float.parseFloat((String)localList.get(0)) * 1000000.0F);
        ((kk)localObject).tl(Long.parseLong((String)localList.get(1)) + l);
      }
    }
    paramString = ral.get(paramString);
    if (paramString == null) {
      p.hyc();
    }
    paramString = (kk)paramString;
    AppMethodBeat.o(190891);
    return paramString;
  }
  
  public static void aUi(String paramString)
  {
    AppMethodBeat.i(190893);
    p.h(paramString, "key");
    kk localkk = (kk)ral.get(paramString);
    if (localkk != null) {
      localkk.bfK();
    }
    ral.remove(paramString);
    "do report key:".concat(String.valueOf(paramString));
    h.hkS();
    AppMethodBeat.o(190893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.report.b
 * JD-Core Version:    0.7.0.1
 */