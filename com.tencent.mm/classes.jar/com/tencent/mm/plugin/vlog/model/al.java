package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class al
{
  private static long NnF = 0L;
  public static final List<ld> NnG;
  public static ah NnH;
  public static final al NnI;
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uin;
  private static long yjR;
  private static long zXq;
  
  static
  {
    AppMethodBeat.i(110954);
    NnI = new al();
    TAG = "MicroMsg.VlogReporter";
    NnG = (List)new ArrayList();
    zXq = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (zXq != -1L)
    {
      ah localah = NnH;
      if (localah != null)
      {
        ld localld = new ld();
        localld.RQc = localah.Nnv;
        localld.RQd = 1L;
        localld.RQe = (l - zXq);
        localld.RQf = System.currentTimeMillis();
        localld.fHa = localah.gtH();
        localld.KlE = localah.gtG();
        localld.RQg = localah.gtI();
        NnG.add(localld);
        Log.i(TAG, "record watch: vlogscriptModel = " + localah + ", watch time = " + localld.RQe + "ms");
      }
    }
    zXq = l;
    NnH = paramah;
    AppMethodBeat.o(110952);
  }
  
  public static void aM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    yjR = paramLong1;
    uin = paramLong2;
    NnF = 1L;
    Log.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void fwx()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)NnG).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(TAG, "do send result: behavior size = " + NnG.size());
        com.tencent.mm.kernel.c localc = h.aHF();
        p.j(localc, "network()");
        localc.aGY().b((q)new com.tencent.mm.plugin.vlog.model.cgi.c(yjR, uin, NnF, NnG));
        NnG.clear();
      }
      yjR = 0L;
      uin = 0L;
      NnF = 0L;
      zXq = -1L;
      NnH = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.al
 * JD-Core Version:    0.7.0.1
 */