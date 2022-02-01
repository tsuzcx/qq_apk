package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VlogReporter;", "", "()V", "TAG", "", "behaviorList", "", "Lcom/tencent/mm/protocal/protobuf/BehaviorReportItem;", "businessId", "", "lastPlayTime", "lastVlogScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "requestId", "uin", "configure", "", "recordCancel", "recordSelect", "vLogScriptModel", "recordSend", "recordWatch", "sendResult", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
{
  private static long Bjl;
  private static long FsW;
  public static final String TAG;
  public static final am Ubi;
  private static long Ubj;
  public static final List<me> Ubk;
  public static ah Ubl;
  private static long uin;
  
  static
  {
    AppMethodBeat.i(110954);
    Ubi = new am();
    TAG = "MicroMsg.VlogReporter";
    Ubk = (List)new ArrayList();
    FsW = -1L;
    AppMethodBeat.o(110954);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(110952);
    long l = System.currentTimeMillis();
    if (FsW != -1L)
    {
      ah localah = Ubl;
      if (localah != null)
      {
        me localme = new me();
        localme.YNt = localah.UaX;
        localme.YNu = 1L;
        localme.YNv = (l - FsW);
        localme.YNw = System.currentTimeMillis();
        localme.hMx = localah.hRk();
        localme.oeO = localah.hRj();
        localme.YNx = localah.hRl();
        Ubk.add(localme);
        Log.i(TAG, "record watch: vlogscriptModel = " + localah + ", watch time = " + localme.YNv + "ms");
      }
    }
    FsW = l;
    Ubl = paramah;
    AppMethodBeat.o(110952);
  }
  
  public static void by(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(110951);
    Bjl = paramLong1;
    uin = paramLong2;
    Ubj = 1L;
    Log.i(TAG, "configure vlogreporter: requestId = " + paramLong1 + ", uin = " + paramLong2 + ", businessId = 1");
    AppMethodBeat.o(110951);
  }
  
  public static void gIg()
  {
    AppMethodBeat.i(110953);
    if (!((Collection)Ubk).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(TAG, kotlin.g.b.s.X("do send result: behavior size = ", Integer.valueOf(Ubk.size())));
        h.baD().mCm.a((p)new com.tencent.mm.plugin.vlog.model.cgi.c(Bjl, uin, Ubj, Ubk), 0);
        Ubk.clear();
      }
      Bjl = 0L;
      uin = 0L;
      Ubj = 0L;
      FsW = -1L;
      Ubl = null;
      AppMethodBeat.o(110953);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.am
 * JD-Core Version:    0.7.0.1
 */