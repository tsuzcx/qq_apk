package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.kw;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class ad
{
  private static long AAY = 0L;
  private static long BGT = 0L;
  public static final List<kw> BGU;
  public static aa BGV;
  public static final ad BGW;
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uin;
  private static long xcO;
  
  static
  {
    AppMethodBeat.i(110954);
    BGW = new ad();
    TAG = "MicroMsg.VlogReporter";
    BGU = (List)new ArrayList();
    AAY = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(aa paramaa)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (AAY != -1L)
    {
      aa localaa = BGV;
      if (localaa != null)
      {
        kw localkw = new kw();
        localkw.FCY = localaa.BGL;
        localkw.FCZ = 1L;
        localkw.FDa = (l - AAY);
        localkw.FDb = System.currentTimeMillis();
        localkw.dvd = localaa.esq();
        localkw.zyN = localaa.esp();
        localkw.FDc = localaa.esr();
        BGU.add(localkw);
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "record watch: vlogscriptModel = " + localaa + ", watch time = " + localkw.FDa + "ms");
      }
    }
    AAY = l;
    BGV = paramaa;
    AppMethodBeat.o(110952);
  }
  
  public static void as(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    xcO = paramLong1;
    uin = paramLong2;
    BGT = 1L;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void dGe()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)BGU).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i(TAG, "do send result: behavior size = " + BGU.size());
        b localb = g.ajB();
        p.g(localb, "network()");
        localb.aiU().b((n)new c(xcO, uin, BGT, BGU));
        BGU.clear();
      }
      xcO = 0L;
      uin = 0L;
      BGT = 0L;
      AAY = -1L;
      BGV = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ad
 * JD-Core Version:    0.7.0.1
 */