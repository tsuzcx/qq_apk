package com.tencent.mm.plugin.scanner.util;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.etw;
import com.tencent.mm.protocal.protobuf.etx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanCrashManager;", "", "()V", "CRASH_TIME_LIMIT_ONE_DAY", "", "CRASH_TIME_LIMIT_ONE_HOUR", "KEY_CLIENT_VERSION", "", "KEY_CRASH_INFO", "KEY_CRASH_TIME_LIMIT", "KEY_HAS_REPORT_CRASH_LIMIT", "KEY_LAST_ENTER_TIMESTAMP", "KEY_LAST_ENTER_WILL_CRASH", "KEY_WILL_CRASH", "MMKV_KEY_SUFFIX", "TAG", "crashLimit", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "maxCrashTimeDuration", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "willCrash", "", "checkInitMMKV", "", "checkWillCrash", "crashInfo", "Lcom/tencent/mm/protocal/protobuf/ScanCrashInfo;", "clearCrashInfo", "enterScanUI", "enableScanCodeProductMerge", "exitScanUI", "initWillCrash", "reportWillCrashWhenEnter", "saveWillCrash", "timeLimit", "updateCrashInfo", "lastEnterTimestamp", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Piv;
  private static HashMap<Long, Integer> Piw;
  private static boolean Pix;
  private static long Piy;
  private static MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(314226);
    Piv = new d();
    Piw = ak.g(new r[] { v.Y(Long.valueOf(216000000L), Integer.valueOf(3)), v.Y(Long.valueOf(5184000000L), Integer.valueOf(10)) });
    Piy = 5184000000L;
    boolean bool;
    int i;
    label269:
    Object localObject1;
    try
    {
      bool = com.tencent.mm.kernel.h.baz();
      if ((bool) && (eMf == null)) {
        eMf = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "_scan_crash_mmkv"));
      }
      Log.i("MicroMsg.ScanCrashManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool), eMf });
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        MultiProcessMMKV localMultiProcessMMKV;
        Log.printErrStackTrace("MicroMsg.ScanCrashManager", (Throwable)localException1, "checkInitMMKV exception", new Object[0]);
        continue;
        i = localException1.getInt("key_client_version", 0);
      }
      localObject1 = eMf;
      if (localObject1 != null) {
        break label657;
      }
    }
    localMultiProcessMMKV = eMf;
    int j;
    if (localMultiProcessMMKV == null)
    {
      i = 0;
      j = com.tencent.mm.protocal.d.Yxh;
      if (i == j) {
        break label269;
      }
      Log.w("MicroMsg.ScanCrashManager", "initWillCrash client not the same, and clear crash info. last: %X, current: %d, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), BuildInfo.CLIENT_VERSION });
      localMultiProcessMMKV = eMf;
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.clearAll();
      }
      localMultiProcessMMKV = eMf;
      if (localMultiProcessMMKV != null) {
        localMultiProcessMMKV.putInt("key_client_version", j);
      }
      p(false, 0L);
      Pix = false;
    }
    label282:
    long l1;
    label295:
    do
    {
      Log.i("MicroMsg.ScanCrashManager", s.X("initWillCrash willCrash: ", Boolean.valueOf(Pix)));
      AppMethodBeat.o(314226);
      return;
      bool = false;
      localObject1 = eMf;
      if (localObject1 != null) {
        break;
      }
      l1 = 0L;
    } while (!bool);
    label657:
    label978:
    label981:
    label984:
    label989:
    label994:
    label1000:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.ScanCrashManager", s.X("updateCrash lastEnterTimestamp: ", Long.valueOf(l1)));
        localObject1 = eMf;
        Object localObject4;
        long l2;
        int m;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label981;
          }
          localObject1 = new etw();
          localObject3 = ((etw)localObject1).abxa;
          if (localObject3 != null)
          {
            localObject4 = new etx();
            if (l1 != 0L) {
              break label1000;
            }
            l1 = System.currentTimeMillis();
            ((etx)localObject4).abxb = l1;
            localObject5 = ah.aiuX;
            ((LinkedList)localObject3).add(localObject4);
          }
          localObject3 = eMf;
          if (localObject3 != null) {
            ((MultiProcessMMKV)localObject3).encode("key_crash_info", ((etw)localObject1).toByteArray());
          }
          bool = false;
          l1 = 0L;
          localObject3 = ((Map)Piw).entrySet().iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label902;
          }
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          l2 = ((Number)((Map.Entry)localObject4).getKey()).longValue();
          m = ((Number)((Map.Entry)localObject4).getValue()).intValue();
          j = 0;
          localObject4 = new ArrayList();
          Object localObject5 = ((etw)localObject1).abxa;
          s.s(localObject5, "crashInfo.crashList");
          localObject5 = (Iterable)localObject5;
          i = 0;
          localObject5 = ((Iterable)localObject5).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            continue;
          }
          Object localObject6 = ((Iterator)localObject5).next();
          if (i < 0) {
            p.kkW();
          }
          localObject6 = (etx)localObject6;
          long l3 = System.currentTimeMillis() - ((etx)localObject6).abxb;
          int k = j;
          if (l3 <= l2)
          {
            Log.w("MicroMsg.ScanCrashManager", s.X("updateCrashInfo find crash diff: ", Long.valueOf(l3)));
            k = j + 1;
          }
          if (l3 < Piy) {
            ((ArrayList)localObject4).add(localObject6);
          }
          if (k < m) {
            break label978;
          }
          Log.w("MicroMsg.ScanCrashManager", "updateCrashInfo crash count >= limit count");
          bool = true;
          l1 = l2;
          i += 1;
          j = k;
          continue;
          bool = ((MultiProcessMMKV)localObject1).getBoolean("key_last_enter_will_crash", false);
          break label282;
          l1 = ((MultiProcessMMKV)localObject1).getLong("key_last_enter", 0L);
          break label295;
        }
        if (!((MultiProcessMMKV)localObject1).containsKey("key_crash_info")) {
          break label994;
        }
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("key_crash_info");
        if (localObject1 == null) {
          break label994;
        }
        i = localObject1.length;
        if (i != 0) {
          break label984;
        }
        i = 1;
        if (i != 0) {
          break label989;
        }
        i = 1;
        if (i == 0) {
          break label994;
        }
        try
        {
          localObject3 = etw.class.newInstance();
          ((a)localObject3).parseFrom((byte[])localObject1);
          localObject1 = (a)localObject3;
          localObject1 = (etw)localObject1;
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          break label994;
        }
        Log.i("MicroMsg.ScanCrashManager", "checkWillCrash time: " + l2 + ", crashLimit: " + m + ", currentCrashCount: " + j + ", newCrashList: " + ((ArrayList)localObject4).size() + ", willCrash: " + bool);
        localException2.abxa.clear();
        localException2.abxa.addAll((Collection)localObject4);
        continue;
      }
      catch (Exception localException3)
      {
        Log.printErrStackTrace("MicroMsg.ScanCrashManager", (Throwable)localException3, "updateCrashInfo exception", new Object[0]);
      }
      if (bool)
      {
        p(true, l1);
        localObject2 = eMf;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((MultiProcessMMKV)localObject2).remove("key_crash_info");
        if (localObject2 == null) {
          break;
        }
        ((SharedPreferences.Editor)localObject2).apply();
        break;
      }
      p(false, 0L);
      Object localObject3 = eMf;
      if (localObject3 == null) {
        break;
      }
      ((MultiProcessMMKV)localObject3).encode("key_crash_info", ((etw)localObject2).toByteArray());
      break;
      continue;
      continue;
      i = 0;
      continue;
      i = 0;
      continue;
      Object localObject2 = null;
    }
  }
  
  public static final void Cy(boolean paramBoolean)
  {
    long l = 0L;
    boolean bool = false;
    AppMethodBeat.i(314205);
    Log.i("MicroMsg.ScanCrashManager", "enterScanUI %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (Pix)
    {
      localObject = eMf;
      if (localObject != null) {
        break label146;
      }
      localObject = eMf;
      if (localObject != null) {
        break label159;
      }
      label55:
      if (!bool)
      {
        if (l != 216000000L) {
          break label172;
        }
        localObject = eMf;
        if (localObject != null)
        {
          localObject = ((MultiProcessMMKV)localObject).putBoolean("key_has_report_crash_limit", true);
          if (localObject != null) {
            ((SharedPreferences.Editor)localObject).apply();
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1259, 230);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanCrashManager", s.X("reportWillCrashWhenEnter crashTimeLimit: ", Long.valueOf(l)));
      if (paramBoolean) {
        break label228;
      }
      Log.w("MicroMsg.ScanCrashManager", "enterScanUI not enableScanCodeProductMerge and ignore");
      AppMethodBeat.o(314205);
      return;
      label146:
      l = ((MultiProcessMMKV)localObject).getLong("key_will_crash_time_limit", 0L);
      break;
      label159:
      bool = ((MultiProcessMMKV)localObject).getBoolean("key_has_report_crash_limit", false);
      break label55;
      label172:
      if (l == 5184000000L)
      {
        localObject = eMf;
        if (localObject != null)
        {
          localObject = ((MultiProcessMMKV)localObject).putBoolean("key_has_report_crash_limit", true);
          if (localObject != null) {
            ((SharedPreferences.Editor)localObject).apply();
          }
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1259, 231);
      }
    }
    label228:
    Object localObject = eMf;
    if (localObject != null) {
      ((MultiProcessMMKV)localObject).putBoolean("key_last_enter_will_crash", true);
    }
    localObject = eMf;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).putLong("key_last_enter", System.currentTimeMillis());
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    AppMethodBeat.o(314205);
  }
  
  public static final boolean aTr()
  {
    return Pix;
  }
  
  public static final void gTQ()
  {
    AppMethodBeat.i(314208);
    Log.i("MicroMsg.ScanCrashManager", "exitScanUI");
    Object localObject = eMf;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).putBoolean("key_last_enter_will_crash", false);
      if (localObject != null)
      {
        localObject = ((SharedPreferences.Editor)localObject).remove("key_last_enter");
        if (localObject != null) {
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
    AppMethodBeat.o(314208);
  }
  
  private static void p(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(314210);
    Log.i("MicroMsg.ScanCrashManager", "saveWillCrash willCrash: " + paramBoolean + ", timeLimit: " + paramLong);
    Pix = paramBoolean;
    Object localObject = eMf;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).putBoolean("key_will_crash", paramBoolean);
      if (localObject != null)
      {
        localObject = ((SharedPreferences.Editor)localObject).putLong("key_will_crash_time_limit", paramLong);
        if (localObject != null) {
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
    AppMethodBeat.o(314210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d
 * JD-Core Version:    0.7.0.1
 */