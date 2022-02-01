package com.tencent.qbar.b;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/qbar/util/ScanCostManager;", "", "()V", "decodeCostMap", "Ljava/util/HashMap;", "", "Lcom/tencent/qbar/util/ScanCostManager$FrameDecodeCostInfo;", "Lkotlin/collections/HashMap;", "decodeCostTotal", "decodeFrameCount", "", "destroyed", "", "lastStartScanCodeTimestamp", "scanCodeFrameCostTotal", "scanCodeFrameCount", "startTimestamp", "addFrameDecodeCodeCost", "", "frameId", "cost", "finishFrameDecodeCode", "init", "recordScanCodeFrame", "current", "releaseAndDumpCost", "reset", "runTask", "task", "Ljava/lang/Runnable;", "start", "stop", "Companion", "FrameDecodeCostInfo", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ahrN;
  private static MultiProcessMMKV eMf;
  private long ahrO;
  private long ahrP;
  public long ahrQ;
  private long ahrR;
  private HashMap<Long, a.b> ahrS;
  private int nCz;
  private long tpS;
  private boolean vXm;
  
  static
  {
    AppMethodBeat.i(226803);
    ahrN = new a((byte)0);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.baz();
      if ((bool) && (eMf == null)) {
        eMf = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "_scan_cost_mmkv"));
      }
      Log.i("MicroMsg.ScanCostManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool), eMf });
      AppMethodBeat.o(226803);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanCostManager", (Throwable)localException, "checkInitMMKV exception", new Object[0]);
      AppMethodBeat.o(226803);
    }
  }
  
  public a()
  {
    AppMethodBeat.i(226787);
    this.ahrQ = -1L;
    this.ahrS = new HashMap();
    AppMethodBeat.o(226787);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(226800);
    s.u(parama, "this$0");
    float f;
    Object localObject;
    if (parama.nCz > 0)
    {
      f = (float)parama.ahrR * 1.0F / parama.nCz;
      Log.i("MicroMsg.ScanCostManager", "dumpScanCost decodeCostTotal: " + parama.ahrR + ", decodeFrameCount: " + parama.nCz + ", decodeCostAvg: " + f);
      localObject = eMf;
      if (localObject != null)
      {
        localObject = ((MultiProcessMMKV)localObject).putInt("scan_code_decode_cost", (int)f);
        if (localObject != null) {
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
    if (parama.ahrP > 0L)
    {
      f = (float)parama.ahrO * 1.0F / (float)parama.ahrP;
      localObject = eMf;
      if (localObject != null) {
        break label298;
      }
    }
    label298:
    for (int i = 0;; i = ((MultiProcessMMKV)localObject).getInt("scan_code_last_frame_cost", 0))
    {
      int j = kotlin.h.a.eH(f);
      localObject = eMf;
      if (localObject != null)
      {
        localObject = ((MultiProcessMMKV)localObject).putInt("scan_code_last_frame_cost", i);
        if (localObject != null)
        {
          localObject = ((SharedPreferences.Editor)localObject).putInt("scan_code_last_frame_cost", j);
          if (localObject != null) {
            ((SharedPreferences.Editor)localObject).apply();
          }
        }
      }
      Log.i("MicroMsg.ScanCostManager", "dumpScanCost scanCodeFrameCostTotal: " + parama.ahrO + ", scanCodeFrameCount: " + parama.ahrP + ", scanCodeFrameCostAvg: " + f + ", lastCost: " + i);
      parama.vXm = true;
      parama.ahrR = 0L;
      parama.nCz = 0;
      parama.ahrO = 0L;
      parama.ahrP = 0L;
      parama.ahrQ = -1L;
      parama.ahrS.clear();
      AppMethodBeat.o(226800);
      return;
    }
  }
  
  private static final void a(a parama, long paramLong)
  {
    AppMethodBeat.i(226792);
    s.u(parama, "this$0");
    if (parama.vXm)
    {
      AppMethodBeat.o(226792);
      return;
    }
    if (parama.ahrQ > 0L)
    {
      long l = paramLong - parama.ahrQ;
      if (l > 1000L)
      {
        Log.w("MicroMsg.ScanCostManager", "recordScanCodeFrame invalid cost: " + l + " and ignore");
        parama.ahrQ = paramLong;
        AppMethodBeat.o(226792);
        return;
      }
      parama.ahrO += l;
      parama.ahrP += 1L;
      Log.v("MicroMsg.ScanCostManager", "recordScanCodeFrame cost: " + l + ", costTotal: " + parama.ahrO + ", count: " + parama.ahrP);
    }
    parama.ahrQ = paramLong;
    AppMethodBeat.o(226792);
  }
  
  private static final void a(a parama, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226794);
    s.u(parama, "this$0");
    if (parama.vXm)
    {
      AppMethodBeat.o(226794);
      return;
    }
    a.b localb2 = (a.b)parama.ahrS.get(Long.valueOf(paramLong1));
    a.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new a.b((byte)0);
      ((Map)parama.ahrS).put(Long.valueOf(paramLong1), localb1);
    }
    localb1.cost += paramLong2;
    Log.v("MicroMsg.ScanCostManager", "addFrameDecodeCodeCost frameId: %d, cost: %d, total: %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(localb1.cost) });
    AppMethodBeat.o(226794);
  }
  
  private static final void b(a parama, long paramLong)
  {
    AppMethodBeat.i(226796);
    s.u(parama, "this$0");
    if (parama.vXm)
    {
      AppMethodBeat.o(226796);
      return;
    }
    a.b localb = (a.b)parama.ahrS.remove(Long.valueOf(paramLong));
    if (localb != null)
    {
      parama.ahrR += localb.cost;
      parama.nCz += 1;
      Log.v("MicroMsg.ScanCostManager", "finishFrameDecodeCode cost: " + localb.cost + ", costTotal: " + parama.ahrR + ", count: " + parama.nCz);
    }
    AppMethodBeat.o(226796);
  }
  
  private static void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(226789);
    com.tencent.threadpool.h.ahAA.g(paramRunnable, "ScanCostManager");
    AppMethodBeat.o(226789);
  }
  
  public final void AY(long paramLong)
  {
    AppMethodBeat.i(226812);
    y(new a..ExternalSyntheticLambda1(this, paramLong));
    AppMethodBeat.o(226812);
  }
  
  public final void AZ(long paramLong)
  {
    AppMethodBeat.i(226814);
    y(new a..ExternalSyntheticLambda2(this, paramLong));
    AppMethodBeat.o(226814);
  }
  
  public final void bM(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226813);
    y(new a..ExternalSyntheticLambda3(this, paramLong1, paramLong2));
    AppMethodBeat.o(226813);
  }
  
  public final void init()
  {
    AppMethodBeat.i(226811);
    Log.i("MicroMsg.ScanCostManager", "init");
    this.vXm = false;
    this.tpS = System.currentTimeMillis();
    AppMethodBeat.o(226811);
  }
  
  public final void jWY()
  {
    AppMethodBeat.i(226815);
    if ((System.currentTimeMillis() - this.tpS < 1000L) || (this.nCz < 5))
    {
      Log.w("MicroMsg.ScanCostManager", "releaseAndDumpCost start not over 1s and ignore");
      AppMethodBeat.o(226815);
      return;
    }
    y(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(226815);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/qbar/util/ScanCostManager$Companion;", "", "()V", "MMKV_KEY_SUFFIX", "", "SCAN_CODE_CURRENT_FRAME_COST", "SCAN_CODE_DECODE_COST", "SCAN_CODE_LAST_FRAME_COST", "TAG", "THREAD_LOOP_TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getScanCodeDecodeCost", "", "getScanCodeFrameCost", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int jWZ()
    {
      AppMethodBeat.i(226781);
      MultiProcessMMKV localMultiProcessMMKV = a.iTS();
      if (localMultiProcessMMKV == null)
      {
        AppMethodBeat.o(226781);
        return 0;
      }
      int i = localMultiProcessMMKV.getInt("scan_code_last_frame_cost", 0);
      AppMethodBeat.o(226781);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qbar.b.a
 * JD-Core Version:    0.7.0.1
 */