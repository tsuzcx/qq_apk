package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager.MemoryInfo;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.z.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt2, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong10, String paramString6)
  {
    AppMethodBeat.i(301117);
    Log.d("MicroMsg.MemoryWatchDog.Reporter", "report type:%s, java:%s, native:%s, vmSize:%s, totalPss:%s, sumPss:%s, extra:%s, soCount:%s, systemPss:%s, graphic:%s, backgroundDuration:%s, systemTotalMem:%s, amsTotalPss:%s, activity: %s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Long.valueOf(paramLong8), Long.valueOf(paramLong9), Long.valueOf(paramLong10), paramString6 });
    f localf = f.Ozc;
    String str = MMApplicationContext.getProcessName();
    if (BuildInfo.IS_ARM64) {}
    for (int i = 1;; i = 2)
    {
      localf.b(20731, new Object[] { Integer.valueOf(paramInt1), str, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(i), Long.valueOf(paramLong8), Long.valueOf(paramLong9), paramString2, paramString3, paramString4, paramString5, Long.valueOf(paramLong10), paramString6 });
      AppMethodBeat.o(301117);
      return;
    }
  }
  
  private static void a(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301098);
    if (MMApplicationContext.isMainProcess()) {
      i = 1161;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(301098);
      return;
      if (MMApplicationContext.isAppBrandProcess()) {
        i = 1162;
      } else if (MMApplicationContext.isToolsProcess()) {
        i = 1163;
      } else if (MMApplicationContext.isPushProcess()) {
        i = 1164;
      } else if (MMApplicationContext.isToolsMpProcess()) {
        i = 1165;
      } else {
        i = -1;
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(i);
    ((IDKey)localObject2).SetValue(1L);
    ((IDKey)localObject2).SetKey(0);
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = new IDKey();
    ((IDKey)localObject2).SetID(i);
    ((IDKey)localObject2).SetValue(1L);
    long l3;
    label224:
    long l4;
    label281:
    long l5;
    label340:
    int i7;
    if (BuildInfo.IS_ARM64)
    {
      j = 254;
      ((IDKey)localObject2).SetKey(j);
      ((ArrayList)localObject1).add(localObject2);
      l3 = paramb.MOA - paramb.MOB;
      b(paramb, true);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l3 >= 104857600L) {
        break label856;
      }
      ((IDKey)localObject2).SetKey(1);
      ((ArrayList)localObject1).add(localObject2);
      l4 = paramb.MOy;
      c(paramb, true);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l4 >= 104857600L) {
        break label1033;
      }
      ((IDKey)localObject2).SetKey(33);
      ((ArrayList)localObject1).add(localObject2);
      l5 = paramb.MOt;
      d(paramb, true);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l5 >= 1572864.0D) {
        break label1214;
      }
      ((IDKey)localObject2).SetKey(65);
      ((ArrayList)localObject1).add(localObject2);
      i7 = paramb.FrK;
      e(paramb, true);
      f(paramb, true);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (i7 >= 102400) {
        break label1565;
      }
      if (!BuildInfo.IS_ARM64) {
        break label1559;
      }
    }
    long l1;
    long l2;
    int n;
    int k;
    Object localObject3;
    int m;
    String str;
    int i9;
    int i2;
    int i1;
    Object localObject4;
    label1033:
    label1559:
    for (int i = 154;; i = 122)
    {
      ((IDKey)localObject2).SetKey(i);
      ((ArrayList)localObject1).add(localObject2);
      if (MMApplicationContext.isMainProcess()) {
        ((ArrayList)localObject1).addAll(c(paramb));
      }
      f.Ozc.b((ArrayList)localObject1, false);
      l1 = -1L;
      l2 = -1L;
      if (paramb.MOr != null)
      {
        l1 = Util.getLong((String)paramb.MOr.get("summary.system"), -1L);
        l2 = Util.getLong((String)paramb.MOr.get("summary.graphics"), -1L);
      }
      Log.i("MicroMsg.MemoryWatchDog.Reporter", "systemPss = %d, graphics = %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      n = 0;
      localObject2 = new StringBuilder();
      i = 0;
      k = 0;
      Log.d("MicroMsg.MemoryWatchDog.Reporter", "mergeType = 0");
      localObject3 = a.values();
      int i8 = localObject3.length;
      m = 0;
      if (m >= i8) {
        break label2252;
      }
      str = localObject3[m];
      if (str.MNJ >= 3) {
        str.type |= 0x1;
      }
      if (str.MNK >= 3) {
        str.type |= 0x2;
      }
      if (str.MNL >= 3) {
        str.type |= 0x4;
      }
      if (str.MNM >= 3) {
        str.type |= 0x8;
      }
      if (str.MNN >= 3) {
        str.type |= 0x10;
      }
      if (str.MNO > 3) {
        str.type |= 0x200;
      }
      i9 = str.type;
      i2 = k;
      i1 = n;
      j = i;
      if (!a.afv(i9)) {
        break label2189;
      }
      i2 = k;
      i1 = n;
      j = i;
      if (str.MNP) {
        break label2189;
      }
      if (((i9 & 0x10) != 16) || (i != 0)) {
        break label2569;
      }
      ((StringBuilder)localObject2).append("allProcess:");
      localObject1 = paramb.MOL;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject4 = localObject1[i];
        ((StringBuilder)localObject2).append(((d.b)localObject4).pid).append("-").append(((d.b)localObject4).processName).append("-pss:").append(((d.b)localObject4).FrK).append(";");
        i += 1;
      }
      j = 255;
      break;
      label856:
      if (l3 < 209715200L)
      {
        ((IDKey)localObject2).SetKey(2);
        break label224;
      }
      if (l3 < 314572800L)
      {
        ((IDKey)localObject2).SetKey(3);
        break label224;
      }
      if (l3 < 419430400L)
      {
        ((IDKey)localObject2).SetKey(4);
        break label224;
      }
      if (l3 < 524288000L)
      {
        ((IDKey)localObject2).SetKey(5);
        break label224;
      }
      if (l3 < 629145600L)
      {
        ((IDKey)localObject2).SetKey(6);
        break label224;
      }
      if (l3 < 734003200L)
      {
        ((IDKey)localObject2).SetKey(7);
        break label224;
      }
      if (l3 < 838860800L)
      {
        ((IDKey)localObject2).SetKey(8);
        break label224;
      }
      if (l3 < 943718400L)
      {
        ((IDKey)localObject2).SetKey(9);
        break label224;
      }
      if (l3 < 1048576000L)
      {
        ((IDKey)localObject2).SetKey(10);
        break label224;
      }
      ((IDKey)localObject2).SetKey(11);
      break label224;
      if (l4 < 209715200L)
      {
        ((IDKey)localObject2).SetKey(34);
        break label281;
      }
      if (l4 < 314572800L)
      {
        ((IDKey)localObject2).SetKey(35);
        break label281;
      }
      if (l4 < 419430400L)
      {
        ((IDKey)localObject2).SetKey(36);
        break label281;
      }
      if (l4 < 524288000L)
      {
        ((IDKey)localObject2).SetKey(37);
        break label281;
      }
      if (l4 < 629145600L)
      {
        ((IDKey)localObject2).SetKey(38);
        break label281;
      }
      if (l4 < 734003200L)
      {
        ((IDKey)localObject2).SetKey(39);
        break label281;
      }
      if (l4 < 838860800L)
      {
        ((IDKey)localObject2).SetKey(40);
        break label281;
      }
      if (l4 < 943718400L)
      {
        ((IDKey)localObject2).SetKey(41);
        break label281;
      }
      if (l4 < 1048576000L)
      {
        ((IDKey)localObject2).SetKey(42);
        break label281;
      }
      ((IDKey)localObject2).SetKey(43);
      break label281;
      label1214:
      if (l5 < 2097152L)
      {
        ((IDKey)localObject2).SetKey(66);
        break label340;
      }
      if (l5 < 2621440.0D)
      {
        ((IDKey)localObject2).SetKey(67);
        break label340;
      }
      if (l5 < 3145728L)
      {
        ((IDKey)localObject2).SetKey(68);
        break label340;
      }
      if (l5 < 3670016.0D)
      {
        ((IDKey)localObject2).SetKey(69);
        break label340;
      }
      if (l5 < 4194304L)
      {
        ((IDKey)localObject2).SetKey(70);
        break label340;
      }
      if (l5 < 4718592.0D)
      {
        ((IDKey)localObject2).SetKey(71);
        break label340;
      }
      if (l5 < 5242880L)
      {
        ((IDKey)localObject2).SetKey(72);
        break label340;
      }
      if (l5 < 5767168.0D)
      {
        ((IDKey)localObject2).SetKey(73);
        break label340;
      }
      if (l5 < 6291456.0D)
      {
        ((IDKey)localObject2).SetKey(74);
        break label340;
      }
      if (l5 < 6815744.0D)
      {
        ((IDKey)localObject2).SetKey(75);
        break label340;
      }
      if (l5 < 7340032.0D)
      {
        ((IDKey)localObject2).SetKey(76);
        break label340;
      }
      if (l5 < 7864320.0D)
      {
        ((IDKey)localObject2).SetKey(77);
        break label340;
      }
      if (l5 < 8388608.0D)
      {
        ((IDKey)localObject2).SetKey(78);
        break label340;
      }
      if (l5 < 8912896.0D)
      {
        ((IDKey)localObject2).SetKey(79);
        break label340;
      }
      if (l5 < 9437184.0D)
      {
        ((IDKey)localObject2).SetKey(80);
        break label340;
      }
      if (l5 < 9961472.0D)
      {
        ((IDKey)localObject2).SetKey(81);
        break label340;
      }
      if (l5 < 10485760L)
      {
        ((IDKey)localObject2).SetKey(82);
        break label340;
      }
      ((IDKey)localObject2).SetKey(83);
      break label340;
    }
    label1565:
    if (i7 < 204800)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 155;; i = 123)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 307200)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 156;; i = 124)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 409600)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 157;; i = 125)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 512000)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 158;; i = 126)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 614400)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 159;; i = 127)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 716800)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 160;; i = 128)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 819200)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 161;; i = 129)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 921600)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 162;; i = 130)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i7 < 1024000)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 163;; i = 131)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (BuildInfo.IS_ARM64) {}
    for (i = 164;; i = 132)
    {
      ((IDKey)localObject2).SetKey(i);
      break;
    }
    label2433:
    label2569:
    for (int j = 1;; j = i)
    {
      i = k;
      if ((i9 & 0x4) == 4)
      {
        i = k;
        if (k == 0)
        {
          if (j != 0) {
            ((StringBuilder)localObject2).append("--------;");
          }
          localObject4 = paramb.MOM.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
            localObject1 = (String)localEntry.getKey();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {}
            for (localObject1 = "<no-name>";; localObject1 = "'" + (String)localObject1 + "'")
            {
              ((StringBuilder)localObject2).append((String)localObject1).append(':').append(localEntry.getValue()).append(" bytes;");
              break;
            }
          }
          i = 1;
        }
      }
      label2058:
      label2069:
      label2080:
      int i3;
      label2092:
      int i4;
      label2104:
      int i5;
      if (b(paramb, false))
      {
        k = 1;
        if (!c(paramb, false)) {
          break label2214;
        }
        i1 = 2;
        if (!d(paramb, false)) {
          break label2220;
        }
        i2 = 4;
        if (!e(paramb, false)) {
          break label2226;
        }
        i3 = 8;
        if (!g(paramb, false)) {
          break label2232;
        }
        i4 = 16;
        if (!f(paramb, false)) {
          break label2238;
        }
        i5 = 512;
        label2117:
        if (!paramb.MOu.isEmpty()) {
          break label2244;
        }
      }
      label2189:
      label2214:
      label2220:
      label2226:
      label2232:
      label2238:
      label2244:
      for (int i6 = 0;; i6 = 256)
      {
        i1 = n | i6 | i9 | k | i1 | i2 | i3 | i4 | i5;
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "mergeType |= sceneType ==> %s", new Object[] { Integer.valueOf(i1) });
        str.MNP = true;
        i2 = i;
        m += 1;
        k = i2;
        n = i1;
        i = j;
        break;
        k = 0;
        break label2058;
        i1 = 0;
        break label2069;
        i2 = 0;
        break label2080;
        i3 = 0;
        break label2092;
        i4 = 0;
        break label2104;
        i5 = 0;
        break label2117;
      }
      label2252:
      if (!TextUtils.isEmpty(paramb.extra)) {
        ((StringBuilder)localObject2).append(paramb.extra);
      }
      Log.d("MicroMsg.MemoryWatchDog.Reporter", "final mergeType = %s, checkRunningOutBits = %s", new Object[] { Integer.valueOf(n), Boolean.valueOf(a.afv(n)) });
      long l6;
      long l7;
      long l8;
      long l9;
      if ((a.afv(n)) || (paramBoolean))
      {
        if (MMApplicationContext.isMainProcess())
        {
          if (!TextUtils.isEmpty(paramb.MON)) {
            break label2497;
          }
          paramb.MON = ("graphic:" + a.hU);
        }
        l6 = i7;
        l7 = paramb.MOK;
        localObject4 = ((StringBuilder)localObject2).toString();
        l8 = paramb.MOH;
        l9 = paramb.MOI.totalMem;
        if (!TextUtils.isEmpty(paramb.MON)) {
          break label2533;
        }
        localObject1 = "";
        label2403:
        if (!TextUtils.isEmpty(paramb.MOO)) {
          break label2542;
        }
        localObject2 = "";
        label2418:
        if (!TextUtils.isEmpty(paramb.MOP)) {
          break label2551;
        }
        localObject3 = "";
        if (!TextUtils.isEmpty(paramb.MOQ)) {
          break label2560;
        }
      }
      for (str = "";; str = paramb.MOQ)
      {
        a(n, l3, l4, l5, l6, l7, (String)localObject4, -1, l1, l2, l8, l9, (String)localObject1, (String)localObject2, (String)localObject3, str, paramb.MOJ, paramb.hfG);
        AppMethodBeat.o(301098);
        return;
        label2497:
        paramb.MON = (paramb.MON + "|graphic:" + a.hU);
        break;
        label2533:
        localObject1 = paramb.MON;
        break label2403;
        label2542:
        localObject2 = paramb.MOO;
        break label2418;
        label2551:
        localObject3 = paramb.MOP;
        break label2433;
      }
    }
  }
  
  public static void a(d.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(301064);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(959);
    localIDKey1.SetValue(1L);
    label111:
    int j;
    label160:
    label292:
    label490:
    long l;
    if (paramb.MOA - paramb.MOB < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (paramb.MOy >= 104857600L) {
        break label995;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (paramb.MOt >= 2097152) {
        break label1160;
      }
      localIDKey1.SetKey(142);
      if (paramb.MOt >= 3858759.8F)
      {
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(959);
        localIDKey2.SetValue(1L);
        localIDKey2.SetKey(149);
        localArrayList.add(localIDKey2);
      }
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      localIDKey1.SetKey(151);
      localArrayList.add(localIDKey1);
      f.Ozc.b(localArrayList, false);
      a(paramb, paramBoolean2);
      localArrayList = new ArrayList();
      i = 0;
      if (!MMApplicationContext.isMainProcess()) {
        break label1286;
      }
      i = 10;
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i);
      localIDKey1.SetValue((paramb.MOA - paramb.MOB) / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 1);
      localIDKey1.SetValue(paramb.MOy / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 2);
      localIDKey1.SetValue(1L);
      localArrayList.add(localIDKey1);
      f.Ozc.b(localArrayList, false);
      if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "reportPreloadProcessMemory: hasActivity = %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!MMApplicationContext.isAppBrandProcess()) {
          break label1316;
        }
        i = 1462;
        if (i > 0)
        {
          localArrayList = new ArrayList();
          localArrayList.add(new IDKey(i, 0, 1));
          if (!paramBoolean1) {
            break label1347;
          }
          j = 1;
          label526:
          localArrayList.add(new IDKey(i, j, 1));
          l = paramb.MOA - paramb.MOB;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 52428800L) {
            break label1360;
          }
          if (!paramBoolean1) {
            break label1353;
          }
          j = 3;
          label591:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          l = paramb.MOy;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 104857600L) {
            break label1730;
          }
          if (!paramBoolean1) {
            break label1723;
          }
          j = 55;
          label650:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          if (!BuildInfo.IS_ARM64)
          {
            localIDKey1 = new IDKey();
            localIDKey1.SetID(i);
            localIDKey1.SetValue(1L);
            l = paramb.MOt;
            if (l >= 1572864.0D) {
              break label2068;
            }
            if (!paramBoolean1) {
              break label2061;
            }
            j = 111;
            label717:
            localIDKey1.SetKey(j);
            localArrayList.add(localIDKey1);
          }
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          i = paramb.FrK;
          if (i >= 102400) {
            break label2238;
          }
          if (!paramBoolean1) {
            break label2231;
          }
        }
      }
    }
    label1160:
    label1316:
    label2231:
    for (int i = 139;; i = 153)
    {
      localIDKey1.SetKey(i);
      localArrayList.add(localIDKey1);
      f.Ozc.b(localArrayList, false);
      AppMethodBeat.o(301064);
      return;
      if (paramb.MOA - paramb.MOB < 209715200L)
      {
        localIDKey1.SetKey(121);
        break;
      }
      if (paramb.MOA - paramb.MOB < 314572800L)
      {
        localIDKey1.SetKey(122);
        break;
      }
      if (paramb.MOA - paramb.MOB < 419430400L)
      {
        localIDKey1.SetKey(123);
        break;
      }
      if (paramb.MOA - paramb.MOB < 524288000L)
      {
        localIDKey1.SetKey(124);
        break;
      }
      if (paramb.MOA - paramb.MOB < 629145600L)
      {
        localIDKey1.SetKey(125);
        break;
      }
      if (paramb.MOA - paramb.MOB < 734003200L)
      {
        localIDKey1.SetKey(126);
        break;
      }
      if (paramb.MOA - paramb.MOB < 838860800L)
      {
        localIDKey1.SetKey(127);
        break;
      }
      localIDKey1.SetKey(128);
      break;
      label995:
      if (paramb.MOy < 209715200L)
      {
        localIDKey1.SetKey(132);
        break label111;
      }
      if (paramb.MOy < 314572800L)
      {
        localIDKey1.SetKey(133);
        break label111;
      }
      if (paramb.MOy < 419430400L)
      {
        localIDKey1.SetKey(134);
        break label111;
      }
      if (paramb.MOy < 524288000L)
      {
        localIDKey1.SetKey(135);
        break label111;
      }
      if (paramb.MOy < 629145600L)
      {
        localIDKey1.SetKey(136);
        break label111;
      }
      if (paramb.MOy < 734003200L)
      {
        localIDKey1.SetKey(137);
        break label111;
      }
      if (paramb.MOy < 838860800L)
      {
        localIDKey1.SetKey(138);
        break label111;
      }
      localIDKey1.SetKey(139);
      break label111;
      if (paramb.MOt < 2516582.5F)
      {
        localIDKey1.SetKey(143);
        break label160;
      }
      if (paramb.MOt < 2936012.8F)
      {
        localIDKey1.SetKey(144);
        break label160;
      }
      if (paramb.MOt < 3145728.0F)
      {
        localIDKey1.SetKey(145);
        break label160;
      }
      if (paramb.MOt < 3565158.5F)
      {
        localIDKey1.SetKey(146);
        break label160;
      }
      if (paramb.MOt < 3984588.8F)
      {
        localIDKey1.SetKey(147);
        break label160;
      }
      localIDKey1.SetKey(148);
      break label160;
      if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        i = 20;
        break label292;
      }
      if (!MMApplicationContext.isAppBrandProcess()) {
        break label292;
      }
      i = 30;
      break label292;
      if (MMApplicationContext.isToolsProcess())
      {
        i = 1463;
        break label490;
      }
      if (MMApplicationContext.isToolsMpProcess())
      {
        i = 1464;
        break label490;
      }
      i = -1;
      break label490;
      label1347:
      j = 2;
      break label526;
      label1353:
      j = 16;
      break label591;
      label1360:
      if (l < 104857600L)
      {
        if (paramBoolean1) {}
        for (j = 4;; j = 17)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 209715200L)
      {
        if (paramBoolean1) {}
        for (j = 5;; j = 18)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 314572800L)
      {
        if (paramBoolean1) {}
        for (j = 6;; j = 19)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 419430400L)
      {
        if (paramBoolean1) {}
        for (j = 7;; j = 20)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 524288000L)
      {
        if (paramBoolean1) {}
        for (j = 8;; j = 21)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 629145600L)
      {
        if (paramBoolean1) {}
        for (j = 9;; j = 22)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 734003200L)
      {
        if (paramBoolean1) {}
        for (j = 10;; j = 23)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 838860800L)
      {
        if (paramBoolean1) {}
        for (j = 11;; j = 24)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 943718400L)
      {
        if (paramBoolean1) {}
        for (j = 12;; j = 25)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 1048576000L)
      {
        if (paramBoolean1) {}
        for (j = 13;; j = 26)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (paramBoolean1) {}
      for (j = 14;; j = 27)
      {
        localIDKey1.SetKey(j);
        break;
      }
      label1723:
      j = 69;
      break label650;
      label1730:
      if (l < 209715200L)
      {
        if (paramBoolean1) {}
        for (j = 56;; j = 70)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 314572800L)
      {
        if (paramBoolean1) {}
        for (j = 57;; j = 71)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 419430400L)
      {
        if (paramBoolean1) {}
        for (j = 58;; j = 72)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 524288000L)
      {
        if (paramBoolean1) {}
        for (j = 59;; j = 73)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 629145600L)
      {
        if (paramBoolean1) {}
        for (j = 60;; j = 74)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 734003200L)
      {
        if (paramBoolean1) {}
        for (j = 61;; j = 75)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 838860800L)
      {
        if (paramBoolean1) {}
        for (j = 62;; j = 76)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 943718400L)
      {
        if (paramBoolean1) {}
        for (j = 63;; j = 77)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 1048576000L)
      {
        if (paramBoolean1) {}
        for (j = 64;; j = 78)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (paramBoolean1) {}
      for (j = 65;; j = 79)
      {
        localIDKey1.SetKey(j);
        break;
      }
      j = 118;
      break label717;
      if (l < 2097152L)
      {
        if (paramBoolean1) {}
        for (j = 112;; j = 119)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 2621440.0D)
      {
        if (paramBoolean1) {}
        for (j = 113;; j = 120)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 3145728L)
      {
        if (paramBoolean1) {}
        for (j = 114;; j = 121)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (l < 3670016.0D)
      {
        if (paramBoolean1) {}
        for (j = 115;; j = 122)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      if (paramBoolean1) {}
      for (j = 116;; j = 123)
      {
        localIDKey1.SetKey(j);
        break;
      }
    }
    label1286:
    label2061:
    label2068:
    label2238:
    if (i < 204800)
    {
      if (paramBoolean1) {}
      for (i = 140;; i = 154)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 307200)
    {
      if (paramBoolean1) {}
      for (i = 141;; i = 155)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 409600)
    {
      if (paramBoolean1) {}
      for (i = 142;; i = 156)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 512000)
    {
      if (paramBoolean1) {}
      for (i = 143;; i = 157)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 614400)
    {
      if (paramBoolean1) {}
      for (i = 144;; i = 158)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 716800)
    {
      if (paramBoolean1) {}
      for (i = 145;; i = 159)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 819200)
    {
      if (paramBoolean1) {}
      for (i = 146;; i = 160)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 921600)
    {
      if (paramBoolean1) {}
      for (i = 147;; i = 161)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (i < 1024000)
    {
      if (paramBoolean1) {}
      for (i = 148;; i = 162)
      {
        localIDKey1.SetKey(i);
        break;
      }
    }
    if (paramBoolean1) {}
    for (i = 149;; i = 163)
    {
      localIDKey1.SetKey(i);
      break;
    }
  }
  
  private static int afu(int paramInt)
  {
    if (paramInt < 102400)
    {
      if (BuildInfo.IS_ARM64) {
        return 42;
      }
      return 2;
    }
    if (paramInt < 204800)
    {
      if (BuildInfo.IS_ARM64) {
        return 43;
      }
      return 3;
    }
    if (paramInt < 307200)
    {
      if (BuildInfo.IS_ARM64) {
        return 44;
      }
      return 4;
    }
    if (paramInt < 409600)
    {
      if (BuildInfo.IS_ARM64) {
        return 45;
      }
      return 5;
    }
    if (paramInt < 512000)
    {
      if (BuildInfo.IS_ARM64) {
        return 46;
      }
      return 6;
    }
    if (paramInt < 614400)
    {
      if (BuildInfo.IS_ARM64) {
        return 47;
      }
      return 7;
    }
    if (paramInt < 716800)
    {
      if (BuildInfo.IS_ARM64) {
        return 48;
      }
      return 8;
    }
    if (paramInt < 819200)
    {
      if (BuildInfo.IS_ARM64) {
        return 49;
      }
      return 9;
    }
    if (paramInt < 921600)
    {
      if (BuildInfo.IS_ARM64) {
        return 50;
      }
      return 10;
    }
    if (paramInt < 1024000)
    {
      if (BuildInfo.IS_ARM64) {
        return 51;
      }
      return 11;
    }
    if (paramInt < 1126400)
    {
      if (BuildInfo.IS_ARM64) {
        return 52;
      }
      return 12;
    }
    if (paramInt < 1228800)
    {
      if (BuildInfo.IS_ARM64) {
        return 53;
      }
      return 13;
    }
    if (paramInt < 1331200)
    {
      if (BuildInfo.IS_ARM64) {
        return 54;
      }
      return 14;
    }
    if (paramInt < 1433600)
    {
      if (BuildInfo.IS_ARM64) {
        return 55;
      }
      return 15;
    }
    if (BuildInfo.IS_ARM64) {
      return 56;
    }
    return 16;
  }
  
  private static boolean b(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301101);
    if (paramb.MOA - paramb.MOB > 262144000L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301101);
        return true;
      }
      a locala = a.MNw;
      locala.MNJ += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label128;
        }
        locala = a.MNx;
      }
      for (locala.MNJ += 1;; locala.MNJ += 1)
      {
        label128:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNJ += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNJ += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301101);
      return true;
    }
    AppMethodBeat.o(301101);
    return false;
  }
  
  private static ArrayList<IDKey> c(d.b paramb)
  {
    AppMethodBeat.i(301085);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new IDKey();
    ((IDKey)localObject1).SetID(1308);
    ((IDKey)localObject1).SetValue(1L);
    int i;
    Object localObject2;
    label543:
    Object localObject3;
    Object localObject4;
    if (BuildInfo.IS_ARM64)
    {
      i = 1;
      ((IDKey)localObject1).SetKey(i);
      localArrayList.add(localObject1);
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(1308);
      ((IDKey)localObject1).SetValue(1L);
      ((IDKey)localObject1).SetKey(afu(paramb.MOK));
      localArrayList.add(localObject1);
      g(paramb, true);
      localObject2 = WeChatBrands.AppInfo.current().getPackageName();
      localObject1 = new HashMap();
      ((Map)localObject1).put(String.valueOf(localObject2), Integer.valueOf(1595));
      ((Map)localObject1).put((String)localObject2 + ":appbrand0", Integer.valueOf(1596));
      ((Map)localObject1).put((String)localObject2 + ":appbrand1", Integer.valueOf(1596));
      ((Map)localObject1).put((String)localObject2 + ":appbrand2", Integer.valueOf(1596));
      ((Map)localObject1).put((String)localObject2 + ":appbrand3", Integer.valueOf(1596));
      ((Map)localObject1).put((String)localObject2 + ":appbrand4", Integer.valueOf(1596));
      ((Map)localObject1).put((String)localObject2 + ":tools", Integer.valueOf(1607));
      ((Map)localObject1).put((String)localObject2 + ":toolsmp", Integer.valueOf(1598));
      ((Map)localObject1).put((String)localObject2 + ":push", Integer.valueOf(1599));
      ((Map)localObject1).put((String)localObject2 + ":hotpot..", Integer.valueOf(1600));
      ((Map)localObject1).put((String)localObject2 + ":sandbox", Integer.valueOf(1601));
      ((Map)localObject1).put((String)localObject2 + ":exdevice", Integer.valueOf(1610));
      localObject2 = paramb.MOL;
      int m = localObject2.length;
      i = 0;
      if (i >= m) {
        break label693;
      }
      localObject3 = localObject2[i];
      localObject4 = (Integer)((Map)localObject1).remove(localObject3.processName);
      if (localObject4 == null) {
        break label1285;
      }
    }
    label1285:
    for (int j = ((Integer)localObject4).intValue();; j = 1602)
    {
      Log.d("MicroMsg.MemoryWatchDog.Reporter", "id = %s, process = %s", new Object[] { Integer.valueOf(j), localObject3.processName });
      if (BuildInfo.IS_ARM64) {}
      for (int k = 1;; k = 0)
      {
        localArrayList.add(new IDKey(j, k, 1));
        localObject4 = new IDKey();
        ((IDKey)localObject4).SetID(j);
        ((IDKey)localObject4).SetValue(1L);
        ((IDKey)localObject4).SetKey(afu(localObject3.FrK));
        localArrayList.add(localObject4);
        i += 1;
        break label543;
        i = 0;
        break;
      }
      label693:
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "stub : id = %s, process = %s", new Object[] { ((Map.Entry)localObject2).getValue(), ((Map.Entry)localObject2).getKey() });
        j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        if (BuildInfo.IS_ARM64)
        {
          i = 1;
          label783:
          localArrayList.add(new IDKey(j, i, 1));
          j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
          if (!BuildInfo.IS_ARM64) {
            break label846;
          }
        }
        label846:
        for (i = 57;; i = 17)
        {
          localArrayList.add(new IDKey(j, i, 1));
          break;
          i = 0;
          break label783;
        }
      }
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(1308);
      ((IDKey)localObject1).SetValue(1L);
      long l = paramb.MOI.availMem;
      if (l < 104857600L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 113;; i = 82)
        {
          ((IDKey)localObject1).SetKey(i);
          localArrayList.add(localObject1);
          AppMethodBeat.o(301085);
          return localArrayList;
        }
      }
      if (l < 209715200L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 114;; i = 83)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 314572800L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 115;; i = 84)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 419430400L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 116;; i = 85)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 524288000L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 117;; i = 86)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 629145600L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 118;; i = 87)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 734003200L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 119;; i = 88)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 838860800L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 120;; i = 89)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 943718400L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 121;; i = 90)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 1048576000L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 122;; i = 91)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (l < 1572864000L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 123;; i = 92)
        {
          ((IDKey)localObject1).SetKey(i);
          break;
        }
      }
      if (BuildInfo.IS_ARM64) {}
      for (i = 124;; i = 93)
      {
        ((IDKey)localObject1).SetKey(i);
        break;
      }
    }
  }
  
  private static boolean c(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301104);
    if (paramb.MOy > 524288000L)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301104);
        return true;
      }
      a locala = a.MNw;
      locala.MNK += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label123;
        }
        locala = a.MNx;
      }
      for (locala.MNK += 1;; locala.MNK += 1)
      {
        label123:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNK += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNK += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301104);
      return true;
    }
    AppMethodBeat.o(301104);
    return false;
  }
  
  private static boolean d(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301108);
    if ((!BuildInfo.IS_ARM64) && (paramb.MOt > 3879731.2000000002D))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301108);
        return true;
      }
      a locala = a.MNw;
      locala.MNL += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label130;
        }
        locala = a.MNx;
      }
      for (locala.MNL += 1;; locala.MNL += 1)
      {
        label130:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNL += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNL += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301108);
      return true;
    }
    AppMethodBeat.o(301108);
    return false;
  }
  
  private static boolean e(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301111);
    if (paramb.FrK > 1024000)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301111);
        return true;
      }
      a locala = a.MNw;
      locala.MNM += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label122;
        }
        locala = a.MNx;
      }
      for (locala.MNM += 1;; locala.MNM += 1)
      {
        label122:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNM += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNM += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301111);
      return true;
    }
    AppMethodBeat.o(301111);
    return false;
  }
  
  private static boolean f(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301113);
    if (paramb.MOJ > 1024000)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301113);
        return true;
      }
      a locala = a.MNw;
      locala.MNO += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label122;
        }
        locala = a.MNx;
      }
      for (locala.MNO += 1;; locala.MNO += 1)
      {
        label122:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNO += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNO += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301113);
      return true;
    }
    AppMethodBeat.o(301113);
    return false;
  }
  
  private static boolean g(d.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(301115);
    if (paramb.MOK > 2097152)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(301115);
        return true;
      }
      a locala = a.MNw;
      locala.MNN += 1;
      if (paramb.MOv)
      {
        if (!paramb.MNY) {
          break label122;
        }
        locala = a.MNx;
      }
      for (locala.MNN += 1;; locala.MNN += 1)
      {
        label122:
        do
        {
          paramb = a.aRE(paramb.hfG).iterator();
          while (paramb.hasNext())
          {
            locala = (a)paramb.next();
            locala.MNN += 1;
          }
          if (paramb.eLx) {
            break;
          }
          locala = a.MNy;
          locala.MNN += 1;
        } while ((paramb.hfG == null) || ((!paramb.hfG.contains("default")) && (!paramb.hfG.contains("LauncherUI"))));
        locala = a.MNG;
      }
      AppMethodBeat.o(301115);
      return true;
    }
    AppMethodBeat.o(301115);
    return false;
  }
  
  static enum a
  {
    static final int MNH;
    List<String> MNI;
    int MNJ;
    int MNK;
    int MNL;
    int MNM;
    int MNN;
    int MNO;
    boolean MNP;
    int type;
    
    static
    {
      AppMethodBeat.i(301011);
      MNw = new a("GLOBAL", 0, new String[0]);
      MNx = new a("FOREGROUND", 1, new String[0]);
      MNy = new a("BACKGROUND", 2, new String[0]);
      MNz = new a("VOIP", 3, new String[] { "VideoActivity", "VoipCSMainUI", "MultiTalkMainUI", "VoipScoreDialog" });
      MNA = new a("SNS", 4, new String[] { "Sns.*UI", "SnsOnlineVideoActivity" });
      MNB = new a("FINDER", 5, new String[] { "Finder.*UI" });
      MNC = new a("ALBUM_GALLERY", 6, new String[] { "AlbumPreviewUI", "ImagePreviewUI", "ImageGalleryUI" });
      MND = new a("STORY", 7, new String[] { "Story.*UI" });
      MNE = new a("RECORD", 8, new String[] { "MMRecordUI" });
      MNF = new a("FINDER_LIVE", 9, new String[] { ".*Live.*UI", "NearbyUI" });
      MNG = new a("LAUNCHER_BACKGROUND", 10, new String[0]);
      MNQ = new a[] { MNw, MNx, MNy, MNz, MNA, MNB, MNC, MND, MNE, MNF, MNG };
      MNH = -2147483648 >> values().length;
      AppMethodBeat.o(301011);
    }
    
    private a(String... paramVarArgs)
    {
      AppMethodBeat.i(300991);
      this.MNJ = 0;
      this.MNK = 0;
      this.MNL = 0;
      this.MNM = 0;
      this.MNN = 0;
      this.MNO = 0;
      this.MNP = false;
      int i = a.MNR;
      a.MNR = i + 1;
      this.type = (-2147483648 >>> i);
      this.MNI = Arrays.asList(paramVarArgs);
      AppMethodBeat.o(300991);
    }
    
    static List<a> aRE(String paramString)
    {
      AppMethodBeat.i(300995);
      ArrayList localArrayList = new ArrayList();
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        Iterator localIterator = locala.MNI.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!locala.MNP) && (paramString.matches(str)))
          {
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "%s matches %s(%s)", new Object[] { paramString, str, locala.name() });
            localArrayList.add(locala);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(300995);
      return localArrayList;
    }
    
    static boolean afv(int paramInt)
    {
      return ((MNH ^ 0xFFFFFFFF) & paramInt) != 0;
    }
    
    static final class a
    {
      static int MNR = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.c
 * JD-Core Version:    0.7.0.1
 */