package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.util.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper;", "", "()V", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCreateActionStruct;", "finderPostFinishListener", "com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1;", "materialFrom", "", "materialPosition", "postCache", "", "", "cacheMaterialFrom", "", "cacheMaterialPosition", "enterCreateMv", "context", "Landroid/content/Context;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "initReporter", "onCancelMaterial", "position", "data", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "isScrollEdit", "", "onConfirmMaterial", "onCreateMvFinish", "onDestroy", "onMaterialExposure", "onPreparePostSuccess", "localId", "onPreviewMvFinish", "onSaveDraft", "isSave", "isFinderNew", "partList", "", "onSearch", "keyWord", "expId", "onSelect", "onStartPost", "reporter", "updateRequestId", "requestId", "plugin-mv_release"})
public final class l
{
  public static of Uqu;
  public static int Uqv;
  public static int Uqw;
  public static final Map<Long, of> Uqx;
  private static final a Uqy;
  public static final l Uqz;
  
  static
  {
    AppMethodBeat.i(258842);
    Uqz = new l();
    Uqu = new of();
    Uqx = (Map)new LinkedHashMap();
    Uqy = new a();
    EventCenter.instance.addListener((IListener)Uqy);
    AppMethodBeat.o(258842);
  }
  
  public static void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(258840);
    p.h(paramd, "data");
    of localof = gFd();
    localof.bvG(paramd.adk());
    localof.bvH(paramd.gFb());
    if (Uqv == 3) {
      localof.PI(Uqw);
    }
    localof.PK(paramInt);
    localof.PL(Uqv);
    localof.PN(paramd.gFc());
    localof.PF(2L);
    localof.bfK();
    paramd = b.QYu;
    b.a((a)localof);
    AppMethodBeat.o(258840);
  }
  
  public static void awt(int paramInt)
  {
    Uqw = paramInt;
  }
  
  public static void awu(int paramInt)
  {
    Uqv = paramInt;
  }
  
  public static void bxc(String paramString)
  {
    AppMethodBeat.i(258839);
    Uqu.bvK(paramString);
    AppMethodBeat.o(258839);
  }
  
  public static void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(258841);
    p.h(paramString1, "keyWord");
    p.h(paramString2, "expId");
    of localof = gFd();
    localof.bvI(paramString1);
    localof.bvJ(paramString2);
    localof.PF(3L);
    localof.bfK();
    paramString1 = b.QYu;
    b.a((a)localof);
    AppMethodBeat.o(258841);
  }
  
  public static of gFd()
  {
    AppMethodBeat.i(258838);
    of localof = new of(Uqu.abV());
    AppMethodBeat.o(258838);
    return localof;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/model/MvCreateReportHelper$finderPostFinishListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderPostStatusEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class a
    extends IListener<ia>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.l
 * JD-Core Version:    0.7.0.1
 */