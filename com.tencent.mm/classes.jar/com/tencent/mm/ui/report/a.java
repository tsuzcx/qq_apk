package com.tencent.mm.ui.report;

import android.text.TextUtils;
import com.tencent.c.a.b.a.d;
import com.tencent.c.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.as;
import com.tencent.mm.f.b.a.en;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/report/FindMoreFriendsReporter;", "", "()V", "TAG", "", "discoverNearbyDotExpose", "", "finderLiveSquareEntranceContextId", "nearbyEntranceContextId", "getFinderLiveContextId", "getNearbyEntranceContextId", "report20411", "", "action", "", "showInfoCount", "", "redDotShowInfoType", "reportDiscoverNearbyDotExpose", "reportFinderLiveEntranceClick", "reportFinderLiveEntranceExpose", "reportNearByEntranceV3Click", "reportNearByEntranceV3Expose", "reportNearByLiveFriends", "entranceType", "contextId", "reportNearByLiveFriendsClick", "reportNearByLiveFriendsExpose", "app_release"})
public final class a
{
  private static String XLI;
  private static String XLJ;
  private static boolean XLK;
  public static final a XLL;
  
  static
  {
    AppMethodBeat.i(285620);
    XLL = new a();
    XLI = "";
    XLJ = "";
    AppMethodBeat.o(285620);
  }
  
  public static final void Wl(long paramLong)
  {
    long l2 = 1L;
    AppMethodBeat.i(285615);
    if (paramLong != 0L) {}
    for (long l1 = 2L;; l1 = 1L)
    {
      en localen = new en();
      localen.sy("1");
      localen.sB(Util.nullAsNil(((c)h.ae(c.class)).dbr()));
      localen.sz(hXI());
      localen.lL(1011L);
      localen.st("FinderLocal_" + (float)cm.bfE() * 1.0F / 100000.0F);
      localen.su("NearbyEntrance");
      localen.sv("Discovery");
      localen.lM(l1);
      localen.lN(paramLong);
      localen.sw("");
      localen.sx("");
      localen.lO(1L);
      localen.sA("1011-" + cm.bfE());
      localen.lP(1L);
      localen.lQ(1L);
      localen.lR(1L);
      localen.akc();
      localen.lS(cm.bfE() / 1000L);
      localen.sC("");
      localen.lT(1L);
      aj localaj = aj.AGc;
      if (aj.edY()) {}
      for (paramLong = l2;; paramLong = 2L)
      {
        localen.lU(paramLong);
        localen.bpa();
        XLK = true;
        AppMethodBeat.o(285615);
        return;
      }
    }
  }
  
  private static void c(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(285614);
    as localas = new as();
    localas.cF(cm.bfE());
    localas.cG(paramLong1);
    localas.js(paramString);
    localas.jr(Util.nullAsNil(((c)h.ae(c.class)).dbr()));
    localas.cH(paramLong2);
    localas.bpa();
    Log.i("FindMoreFriendsReporter", "report " + localas.agI());
    AppMethodBeat.o(285614);
  }
  
  public static final void hXC()
  {
    AppMethodBeat.i(285608);
    XLI = "";
    XLJ = "";
    c(1L, 0L, hXI());
    AppMethodBeat.o(285608);
  }
  
  public static final void hXD()
  {
    AppMethodBeat.i(285609);
    c(2L, 0L, hXI());
    AppMethodBeat.o(285609);
  }
  
  public static final void hXE()
  {
    AppMethodBeat.i(285610);
    XLI = "";
    XLJ = "";
    c(1L, 2L, hXI());
    AppMethodBeat.o(285610);
  }
  
  public static final void hXF()
  {
    AppMethodBeat.i(285611);
    c(2L, 2L, hXI());
    AppMethodBeat.o(285611);
  }
  
  public static final void hXG()
  {
    AppMethodBeat.i(285612);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.cFx()) {}
    for (long l = 3L;; l = 1L)
    {
      c(1L, l, hXJ());
      AppMethodBeat.o(285612);
      return;
    }
  }
  
  public static final void hXH()
  {
    AppMethodBeat.i(285613);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.cFx()) {}
    for (long l = 3L;; l = 1L)
    {
      c(2L, l, hXJ());
      AppMethodBeat.o(285613);
      return;
    }
  }
  
  public static final String hXI()
  {
    AppMethodBeat.i(285616);
    if (TextUtils.isEmpty((CharSequence)XLI))
    {
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
      int i = ((e)h.ag(e.class)).get3TabTargetTabCommentScene();
      localObject = ((ak)h.ag(ak.class)).genContextId(12, 2, i);
      p.j(localObject, "MMKernel.plugin(IPluginF…            commentScene)");
      XLI = (String)localObject;
    }
    Object localObject = XLI;
    AppMethodBeat.o(285616);
    return localObject;
  }
  
  public static final String hXJ()
  {
    AppMethodBeat.i(285617);
    if (TextUtils.isEmpty((CharSequence)XLJ))
    {
      int i = ((d)h.ag(d.class)).getTargetCommentScene(94);
      str = ((ak)h.ag(ak.class)).genContextId(23, 2, i);
      p.j(str, "MMKernel.plugin(IPluginF…            commentScene)");
      XLJ = str;
    }
    String str = XLJ;
    AppMethodBeat.o(285617);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.report.a
 * JD-Core Version:    0.7.0.1
 */