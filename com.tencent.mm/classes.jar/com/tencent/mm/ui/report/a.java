package com.tencent.mm.ui.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/report/FindMoreFriendsReporter;", "", "()V", "TAG", "", "contextId", "discoverNearbyDotExpose", "", "getContextId", "report20411", "", "action", "", "showInfoCount", "", "redDotShowInfoType", "reportDiscoverNearbyDotClick", "reportDiscoverNearbyDotExpose", "reportDiscoverNearbyNewDotClick", "reportDiscoverNearbyNewDotExpose", "reportNearByLiveFriends", "reportNearByLiveFriendsClick", "reportNearByLiveFriendsExpose", "app_release"})
public final class a
{
  private static boolean QnJ;
  public static final a QnK;
  private static String sGQ;
  
  static
  {
    AppMethodBeat.i(231380);
    QnK = new a();
    sGQ = "";
    AppMethodBeat.o(231380);
  }
  
  private static void NY(long paramLong)
  {
    AppMethodBeat.i(231375);
    ak localak = new ak();
    localak.cb(cl.aWA());
    localak.cc(paramLong);
    localak.ir(acj());
    localak.iq(Util.nullAsNil(((c)g.af(c.class)).cMD()));
    localak.bfK();
    Log.d("FindMoreFriendsReporter", "report " + localak.abW());
    AppMethodBeat.o(231375);
  }
  
  public static final void NZ(long paramLong)
  {
    AppMethodBeat.i(231376);
    sGQ = "";
    long l = 1L;
    if (paramLong != 0L) {
      l = 2L;
    }
    s(1, paramLong, l);
    QnJ = true;
    AppMethodBeat.o(231376);
  }
  
  public static final String acj()
  {
    AppMethodBeat.i(231379);
    if (TextUtils.isEmpty((CharSequence)sGQ))
    {
      localObject = g.ah(aj.class);
      p.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      int i = ((aj)localObject).getFinderUtilApi().dli();
      localObject = ((aj)g.ah(aj.class)).fillContextIdToIntent(12, 1, i, new Intent());
      p.g(localObject, "MMKernel.plugin(IPluginF…, commentScene, Intent())");
      sGQ = (String)localObject;
    }
    Object localObject = sGQ;
    AppMethodBeat.o(231379);
    return localObject;
  }
  
  public static final void gWZ()
  {
    AppMethodBeat.i(231373);
    sGQ = "";
    NY(1L);
    AppMethodBeat.o(231373);
  }
  
  public static final void gXa()
  {
    AppMethodBeat.i(231374);
    NY(2L);
    AppMethodBeat.o(231374);
  }
  
  public static final void gXb()
  {
    sGQ = "";
    QnJ = true;
  }
  
  public static final void gXc()
  {
    AppMethodBeat.i(231377);
    if (QnJ) {
      s(2, 0L, 6L);
    }
    QnJ = false;
    AppMethodBeat.o(231377);
  }
  
  private static void s(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(231378);
    dt localdt = new dt();
    localdt.pN("1");
    localdt.pQ(Util.nullAsNil(((c)g.af(c.class)).cMD()));
    localdt.pO(acj());
    localdt.kA(1011L);
    localdt.pI("FinderLocal_" + (float)cl.aWA() * 1.0F / 100000.0F);
    localdt.pJ("NearbyEntrance");
    localdt.pK("Discovery");
    localdt.kB(paramLong2);
    localdt.kC(paramLong1);
    localdt.pL("");
    localdt.pM("");
    localdt.kD(paramInt);
    localdt.pP("1011-" + cl.aWA());
    localdt.kE(1L);
    localdt.kF(1L);
    localdt.kG(1L);
    localdt.afg();
    localdt.kH(cl.aWA() / 1000L);
    localdt.pR("");
    localdt.kI(1L);
    y localy = y.vXH;
    if (y.dCB()) {}
    for (paramLong1 = 1L;; paramLong1 = 2L)
    {
      localdt.kJ(paramLong1);
      localdt.bfK();
      Log.d("FindMoreFriendsReporter", "report " + localdt.abW());
      AppMethodBeat.o(231378);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.report.a
 * JD-Core Version:    0.7.0.1
 */