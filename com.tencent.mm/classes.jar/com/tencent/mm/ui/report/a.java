package com.tencent.mm.ui.report;

import android.text.TextUtils;
import com.tencent.d.a.b.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.be;
import com.tencent.mm.autogen.mmdata.rpt.ga;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/report/FindMoreFriendsReporter;", "", "()V", "TAG", "", "discoverNearbyDotExpose", "", "finderLiveSquareEntranceContextId", "nearbyEntranceContextId", "getFinderLiveContextId", "getNearbyEntranceContextId", "report20411", "", "action", "", "showInfoCount", "", "redDotShowInfoType", "reportDiscoverNearbyDotExpose", "reportFinderLiveEntranceExpose", "reportFinderLiveOldEntranceClick", "reportNearByEntranceV3Click", "reportNearByEntranceV3Expose", "reportNearByLiveFriends", "entranceType", "contextId", "reportNearByLiveFriendsClick", "reportNearByLiveFriendsExpose", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a afBO;
  private static String afBP;
  private static String afBQ;
  private static boolean afBR;
  
  static
  {
    AppMethodBeat.i(249567);
    afBO = new a();
    afBP = "";
    afBQ = "";
    AppMethodBeat.o(249567);
  }
  
  public static final void Ax(long paramLong)
  {
    long l2 = 1L;
    AppMethodBeat.i(249558);
    if (paramLong != 0L) {}
    for (long l1 = 2L;; l1 = 1L)
    {
      ga localga = new ga();
      localga.qx("1");
      localga.qA(Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN()));
      localga.qy(jCp());
      localga.iJM = 1011L;
      localga.qs(s.X("FinderLocal_", Float.valueOf((float)com.tencent.mm.model.cn.bDw() * 1.0F / 100000.0F)));
      localga.qt("NearbyEntrance");
      localga.qu("Discovery");
      localga.iJP = l1;
      localga.iJQ = paramLong;
      localga.qv("");
      localga.qw("");
      localga.iJS = 1L;
      localga.qz(s.X("1011-", Long.valueOf(com.tencent.mm.model.cn.bDw())));
      localga.iGr = 1L;
      localga.iJV = 1L;
      localga.iJW = 1L;
      localga.iJX = 1L;
      localga.iJY = (com.tencent.mm.model.cn.bDw() / 1000L);
      localga.qB("");
      localga.iKa = 1L;
      av localav = av.GiL;
      if (av.ffR()) {}
      for (paramLong = l2;; paramLong = 2L)
      {
        localga.iKb = paramLong;
        localga.bMH();
        afBR = true;
        AppMethodBeat.o(249558);
        return;
      }
    }
  }
  
  private static void d(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(249552);
    be localbe = new be();
    localbe.iqN = com.tencent.mm.model.cn.bDw();
    localbe.ila = paramLong1;
    localbe.kY(paramString);
    localbe.kX(Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN()));
    localbe.iqQ = paramLong2;
    localbe.bMH();
    Log.i("FindMoreFriendsReporter", s.X("report ", localbe.aIF()));
    AppMethodBeat.o(249552);
  }
  
  public static final void jCj()
  {
    AppMethodBeat.i(249528);
    afBP = "";
    afBQ = "";
    d(1L, 0L, jCp());
    AppMethodBeat.o(249528);
  }
  
  public static final void jCk()
  {
    AppMethodBeat.i(249532);
    d(2L, 0L, jCp());
    AppMethodBeat.o(249532);
  }
  
  public static final void jCl()
  {
    AppMethodBeat.i(249535);
    afBP = "";
    afBQ = "";
    d(1L, 2L, jCp());
    AppMethodBeat.o(249535);
  }
  
  public static final void jCm()
  {
    AppMethodBeat.i(249539);
    d(2L, 2L, jCp());
    AppMethodBeat.o(249539);
  }
  
  public static final void jCn()
  {
    AppMethodBeat.i(249545);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEl()) {}
    for (long l = 3L;; l = 1L)
    {
      d(1L, l, jCq());
      AppMethodBeat.o(249545);
      return;
    }
  }
  
  public static final void jCo()
  {
    AppMethodBeat.i(249548);
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEl()) {}
    for (long l = 3L;; l = 1L)
    {
      d(2L, l, jCq());
      AppMethodBeat.o(249548);
      return;
    }
  }
  
  public static final String jCp()
  {
    AppMethodBeat.i(249563);
    if (TextUtils.isEmpty((CharSequence)afBP))
    {
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
      int i = ((e)h.az(e.class)).get3TabTargetTabCommentScene();
      localObject = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).genContextId(12, 2, i);
      s.s(localObject, "plugin(IPluginFinder::cl…            commentScene)");
      afBP = (String)localObject;
    }
    Object localObject = afBP;
    AppMethodBeat.o(249563);
    return localObject;
  }
  
  public static final String jCq()
  {
    AppMethodBeat.i(249565);
    if (TextUtils.isEmpty((CharSequence)afBQ))
    {
      int i = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetCommentScene(94);
      str = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).genContextId(23, 2, i);
      s.s(str, "plugin(IPluginFinder::cl…            commentScene)");
      afBQ = str;
    }
    String str = afBQ;
    AppMethodBeat.o(249565);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.report.a
 * JD-Core Version:    0.7.0.1
 */