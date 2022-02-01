package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.vlog.model.cgi.c;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"})
public final class ab
{
  private static long Apd = 0L;
  public static final List<kn> Ape;
  public static y Apf;
  public static final ab Apg;
  public static final String TAG = "MicroMsg.VlogReporter";
  private static long uin;
  private static long vVK;
  private static long ziY;
  
  static
  {
    AppMethodBeat.i(110954);
    Apg = new ab();
    TAG = "MicroMsg.VlogReporter";
    Ape = (List)new ArrayList();
    ziY = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(y paramy)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (ziY != -1L)
    {
      y localy = Apf;
      if (localy != null)
      {
        kn localkn = new kn();
        localkn.DXC = localy.AoU;
        localkn.DXD = 1L;
        localkn.DXE = (l - ziY);
        localkn.DXF = System.currentTimeMillis();
        localkn.djq = localy.efN();
        localkn.yiF = localy.efM();
        localkn.DXG = localy.efO();
        Ape.add(localkn);
        ac.i(TAG, "record watch: vlogscriptModel = " + localy + ", watch time = " + localkn.DXE + "ms");
      }
    }
    ziY = l;
    Apf = paramy;
    AppMethodBeat.o(110952);
  }
  
  public static void ao(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    vVK = paramLong1;
    uin = paramLong2;
    Apd = 1L;
    ac.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void dvG()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)Ape).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i(TAG, "do send result: behavior size = " + Ape.size());
        b localb = g.agQ();
        k.g(localb, "network()");
        localb.agi().b((n)new c(vVK, uin, Apd, Ape));
        Ape.clear();
      }
      vVK = 0L;
      uin = 0L;
      Apd = 0L;
      ziY = -1L;
      Apf = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */