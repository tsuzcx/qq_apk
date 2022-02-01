package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class al
{
  public static final List<ln> GAa;
  public static ah GAb;
  public static final al GAc;
  private static long GzZ = 0L;
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uin;
  private static long ulj;
  private static long vgi;
  
  static
  {
    AppMethodBeat.i(110954);
    GAc = new al();
    TAG = "MicroMsg.VlogReporter";
    GAa = (List)new ArrayList();
    vgi = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (vgi != -1L)
    {
      ah localah = GAb;
      if (localah != null)
      {
        ln localln = new ln();
        localln.KPe = localah.GzP;
        localln.KPf = 1L;
        localln.KPg = (l - vgi);
        localln.KPh = System.currentTimeMillis();
        localln.dNP = localah.fBK();
        localln.DYl = localah.fBJ();
        localln.KPi = localah.fBL();
        GAa.add(localln);
        Log.i(TAG, "record watch: vlogscriptModel = " + localah + ", watch time = " + localln.KPg + "ms");
      }
    }
    vgi = l;
    GAb = paramah;
    AppMethodBeat.o(110952);
  }
  
  public static void ax(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    ulj = paramLong1;
    uin = paramLong2;
    GzZ = 1L;
    Log.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void eKh()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)GAa).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(TAG, "do send result: behavior size = " + GAa.size());
        b localb = g.aAg();
        p.g(localb, "network()");
        localb.azz().b((q)new c(ulj, uin, GzZ, GAa));
        GAa.clear();
      }
      ulj = 0L;
      uin = 0L;
      GzZ = 0L;
      vgi = -1L;
      GAb = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.al
 * JD-Core Version:    0.7.0.1
 */