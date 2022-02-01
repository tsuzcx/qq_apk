package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class j
{
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uMU;
  private static long uin;
  private static long xWc;
  private static long yZA;
  public static final List<kh> yZB;
  public static h yZC;
  public static final j yZD;
  
  static
  {
    AppMethodBeat.i(110954);
    yZD = new j();
    TAG = "MicroMsg.VlogReporter";
    yZB = (List)new ArrayList();
    xWc = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(h paramh)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (xWc != -1L)
    {
      h localh = yZC;
      if (localh != null)
      {
        kh localkh = new kh();
        localkh.CFc = localh.yZr;
        localkh.CFd = 1L;
        localkh.CFe = (l - xWc);
        localkh.CFf = System.currentTimeMillis();
        localkh.dlI = localh.dQV();
        localkh.wVR = localh.dQU();
        localkh.CFg = localh.dQW();
        yZB.add(localkh);
        ad.i(TAG, "record watch: vlogscriptModel = " + localh + ", watch time = " + localkh.CFe + "ms");
      }
    }
    xWc = l;
    yZC = paramh;
    AppMethodBeat.o(110952);
  }
  
  public static void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    uMU = paramLong1;
    uin = paramLong2;
    yZA = 1L;
    ad.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void dhV()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)yZB).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i(TAG, "do send result: behavior size = " + yZB.size());
        b localb = g.afA();
        k.g(localb, "network()");
        localb.aeS().b((n)new c(uMU, uin, yZA, yZB));
        yZB.clear();
      }
      uMU = 0L;
      uin = 0L;
      yZA = 0L;
      xWc = -1L;
      yZC = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.j
 * JD-Core Version:    0.7.0.1
 */