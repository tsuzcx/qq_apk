package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class ad
{
  private static long ASt = 0L;
  private static long BYs = 0L;
  public static final List<kw> BYt;
  public static aa BYu;
  public static final ad BYv;
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uin;
  private static long xsF;
  
  static
  {
    AppMethodBeat.i(110954);
    BYv = new ad();
    TAG = "MicroMsg.VlogReporter";
    BYt = (List)new ArrayList();
    ASt = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(aa paramaa)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (ASt != -1L)
    {
      aa localaa = BYu;
      if (localaa != null)
      {
        kw localkw = new kw();
        localkw.FVt = localaa.BYk;
        localkw.FVu = 1L;
        localkw.FVv = (l - ASt);
        localkw.FVw = System.currentTimeMillis();
        localkw.dwi = localaa.evX();
        localkw.zQm = localaa.evW();
        localkw.FVx = localaa.evY();
        BYt.add(localkw);
        ae.i(TAG, "record watch: vlogscriptModel = " + localaa + ", watch time = " + localkw.FVv + "ms");
      }
    }
    ASt = l;
    BYu = paramaa;
    AppMethodBeat.o(110952);
  }
  
  public static void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    xsF = paramLong1;
    uin = paramLong2;
    BYs = 1L;
    ae.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void dJv()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)BYt).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ae.i(TAG, "do send result: behavior size = " + BYt.size());
        b localb = g.ajQ();
        p.g(localb, "network()");
        localb.ajj().b((n)new c(xsF, uin, BYs, BYt));
        BYt.clear();
      }
      xsF = 0L;
      uin = 0L;
      BYs = 0L;
      ASt = -1L;
      BYu = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ad
 * JD-Core Version:    0.7.0.1
 */