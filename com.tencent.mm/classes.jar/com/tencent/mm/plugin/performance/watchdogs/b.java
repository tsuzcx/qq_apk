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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt2, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong10)
  {
    AppMethodBeat.i(201135);
    f localf = f.Iyx;
    String str = MMApplicationContext.getProcessName();
    if (BuildInfo.IS_ARM64) {}
    for (int i = 1;; i = 2)
    {
      localf.a(20731, new Object[] { Integer.valueOf(paramInt1), str, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(i), Long.valueOf(paramLong8), Long.valueOf(paramLong9), paramString2, paramString3, paramString4, paramString5, Long.valueOf(paramLong10) });
      AppMethodBeat.o(201135);
      return;
    }
  }
  
  private static void a(c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(201099);
    if (MMApplicationContext.isMainProcess()) {
      i = 1161;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(201099);
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
    label223:
    long l4;
    label279:
    long l5;
    label337:
    int i7;
    if (BuildInfo.IS_ARM64)
    {
      j = 254;
      ((IDKey)localObject2).SetKey(j);
      ((ArrayList)localObject1).add(localObject2);
      l3 = paramb.GRc - paramb.GRd;
      d(paramb);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l3 >= 104857600L) {
        break label845;
      }
      ((IDKey)localObject2).SetKey(1);
      ((ArrayList)localObject1).add(localObject2);
      l4 = paramb.GRa;
      e(paramb);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l4 >= 104857600L) {
        break label1022;
      }
      ((IDKey)localObject2).SetKey(33);
      ((ArrayList)localObject1).add(localObject2);
      l5 = paramb.GQV;
      f(paramb);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l5 >= 1572864.0D) {
        break label1203;
      }
      ((IDKey)localObject2).SetKey(65);
      ((ArrayList)localObject1).add(localObject2);
      i7 = paramb.GRk;
      g(paramb);
      b(paramb, true);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (i7 >= 102400) {
        break label1554;
      }
      if (!BuildInfo.IS_ARM64) {
        break label1548;
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
    label1548:
    for (int i = 154;; i = 122)
    {
      ((IDKey)localObject2).SetKey(i);
      ((ArrayList)localObject1).add(localObject2);
      if (MMApplicationContext.isMainProcess()) {
        ((ArrayList)localObject1).addAll(c(paramb));
      }
      f.Iyx.b((ArrayList)localObject1, false);
      l1 = -1L;
      l2 = -1L;
      if (paramb.GQT != null)
      {
        l1 = Util.getLong((String)paramb.GQT.get("summary.system"), -1L);
        l2 = Util.getLong((String)paramb.GQT.get("summary.graphics"), -1L);
      }
      Log.i("MicroMsg.MemoryWatchDog.Reporter", "systemPss = %d, graphics = %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      n = 0;
      localObject2 = new StringBuilder();
      i = 0;
      k = 0;
      localObject3 = a.values();
      int i8 = localObject3.length;
      m = 0;
      if (m >= i8) {
        break label2216;
      }
      str = localObject3[m];
      if (str.GQr >= 3) {
        str.type |= 0x1;
      }
      if (str.GQs >= 3) {
        str.type |= 0x2;
      }
      if (str.GQt >= 3) {
        str.type |= 0x4;
      }
      if (str.GQu >= 3) {
        str.type |= 0x8;
      }
      if (str.GQv >= 3) {
        str.type |= 0x10;
      }
      if (str.GQw > 3) {
        str.type |= 0x200;
      }
      i9 = str.type;
      i2 = k;
      i1 = n;
      j = i;
      if (!a.abc(i9)) {
        break label2153;
      }
      i2 = k;
      i1 = n;
      j = i;
      if (str.GQx) {
        break label2153;
      }
      if (((i9 & 0x10) != 16) || (i != 0)) {
        break label2423;
      }
      ((StringBuilder)localObject2).append("allProcess:");
      localObject1 = paramb.GRn;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject4 = localObject1[i];
        ((StringBuilder)localObject2).append(((c.b)localObject4).pid).append("-").append(((c.b)localObject4).processName).append("-pss:").append(((c.b)localObject4).GRk).append(";");
        i += 1;
      }
      j = 255;
      break;
      label845:
      if (l3 < 209715200L)
      {
        ((IDKey)localObject2).SetKey(2);
        break label223;
      }
      if (l3 < 314572800L)
      {
        ((IDKey)localObject2).SetKey(3);
        break label223;
      }
      if (l3 < 419430400L)
      {
        ((IDKey)localObject2).SetKey(4);
        break label223;
      }
      if (l3 < 524288000L)
      {
        ((IDKey)localObject2).SetKey(5);
        break label223;
      }
      if (l3 < 629145600L)
      {
        ((IDKey)localObject2).SetKey(6);
        break label223;
      }
      if (l3 < 734003200L)
      {
        ((IDKey)localObject2).SetKey(7);
        break label223;
      }
      if (l3 < 838860800L)
      {
        ((IDKey)localObject2).SetKey(8);
        break label223;
      }
      if (l3 < 943718400L)
      {
        ((IDKey)localObject2).SetKey(9);
        break label223;
      }
      if (l3 < 1048576000L)
      {
        ((IDKey)localObject2).SetKey(10);
        break label223;
      }
      ((IDKey)localObject2).SetKey(11);
      break label223;
      label1022:
      if (l4 < 209715200L)
      {
        ((IDKey)localObject2).SetKey(34);
        break label279;
      }
      if (l4 < 314572800L)
      {
        ((IDKey)localObject2).SetKey(35);
        break label279;
      }
      if (l4 < 419430400L)
      {
        ((IDKey)localObject2).SetKey(36);
        break label279;
      }
      if (l4 < 524288000L)
      {
        ((IDKey)localObject2).SetKey(37);
        break label279;
      }
      if (l4 < 629145600L)
      {
        ((IDKey)localObject2).SetKey(38);
        break label279;
      }
      if (l4 < 734003200L)
      {
        ((IDKey)localObject2).SetKey(39);
        break label279;
      }
      if (l4 < 838860800L)
      {
        ((IDKey)localObject2).SetKey(40);
        break label279;
      }
      if (l4 < 943718400L)
      {
        ((IDKey)localObject2).SetKey(41);
        break label279;
      }
      if (l4 < 1048576000L)
      {
        ((IDKey)localObject2).SetKey(42);
        break label279;
      }
      ((IDKey)localObject2).SetKey(43);
      break label279;
      label1203:
      if (l5 < 2097152L)
      {
        ((IDKey)localObject2).SetKey(66);
        break label337;
      }
      if (l5 < 2621440.0D)
      {
        ((IDKey)localObject2).SetKey(67);
        break label337;
      }
      if (l5 < 3145728L)
      {
        ((IDKey)localObject2).SetKey(68);
        break label337;
      }
      if (l5 < 3670016.0D)
      {
        ((IDKey)localObject2).SetKey(69);
        break label337;
      }
      if (l5 < 4194304L)
      {
        ((IDKey)localObject2).SetKey(70);
        break label337;
      }
      if (l5 < 4718592.0D)
      {
        ((IDKey)localObject2).SetKey(71);
        break label337;
      }
      if (l5 < 5242880L)
      {
        ((IDKey)localObject2).SetKey(72);
        break label337;
      }
      if (l5 < 5767168.0D)
      {
        ((IDKey)localObject2).SetKey(73);
        break label337;
      }
      if (l5 < 6291456.0D)
      {
        ((IDKey)localObject2).SetKey(74);
        break label337;
      }
      if (l5 < 6815744.0D)
      {
        ((IDKey)localObject2).SetKey(75);
        break label337;
      }
      if (l5 < 7340032.0D)
      {
        ((IDKey)localObject2).SetKey(76);
        break label337;
      }
      if (l5 < 7864320.0D)
      {
        ((IDKey)localObject2).SetKey(77);
        break label337;
      }
      if (l5 < 8388608.0D)
      {
        ((IDKey)localObject2).SetKey(78);
        break label337;
      }
      if (l5 < 8912896.0D)
      {
        ((IDKey)localObject2).SetKey(79);
        break label337;
      }
      if (l5 < 9437184.0D)
      {
        ((IDKey)localObject2).SetKey(80);
        break label337;
      }
      if (l5 < 9961472.0D)
      {
        ((IDKey)localObject2).SetKey(81);
        break label337;
      }
      if (l5 < 10485760L)
      {
        ((IDKey)localObject2).SetKey(82);
        break label337;
      }
      ((IDKey)localObject2).SetKey(83);
      break label337;
    }
    label1554:
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
    label2056:
    label2066:
    label2077:
    label2088:
    label2101:
    label2153:
    label2414:
    label2423:
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
          localObject4 = paramb.GRo.iterator();
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
      label2046:
      int i3;
      int i4;
      int i5;
      if (d(paramb))
      {
        k = 1;
        if (!e(paramb)) {
          break label2178;
        }
        i1 = 2;
        if (!f(paramb)) {
          break label2184;
        }
        i2 = 4;
        if (!g(paramb)) {
          break label2190;
        }
        i3 = 8;
        if (!h(paramb)) {
          break label2196;
        }
        i4 = 16;
        if (!b(paramb, false)) {
          break label2202;
        }
        i5 = 512;
        if (!paramb.GQW.isEmpty()) {
          break label2208;
        }
      }
      for (int i6 = 0;; i6 = 256)
      {
        i1 = n | i6 | i9 | k | i1 | i2 | i3 | i4 | i5;
        str.GQx = true;
        i2 = i;
        m += 1;
        k = i2;
        n = i1;
        i = j;
        break;
        k = 0;
        break label2046;
        i1 = 0;
        break label2056;
        i2 = 0;
        break label2066;
        i3 = 0;
        break label2077;
        i4 = 0;
        break label2088;
        i5 = 0;
        break label2101;
      }
      if (!TextUtils.isEmpty(paramb.extra)) {
        ((StringBuilder)localObject2).append(paramb.extra);
      }
      long l6;
      long l7;
      long l8;
      long l9;
      if ((a.abc(n)) || (paramBoolean))
      {
        l6 = i7;
        l7 = paramb.GRm;
        localObject4 = ((StringBuilder)localObject2).toString();
        l8 = paramb.GRi;
        l9 = paramb.GRj.totalMem;
        if (!TextUtils.isEmpty(paramb.GRp)) {
          break label2387;
        }
        localObject1 = "";
        if (!TextUtils.isEmpty(paramb.GRq)) {
          break label2396;
        }
        localObject2 = "";
        if (!TextUtils.isEmpty(paramb.GRr)) {
          break label2405;
        }
        localObject3 = "";
        if (!TextUtils.isEmpty(paramb.GRs)) {
          break label2414;
        }
      }
      for (str = "";; str = paramb.GRs)
      {
        a(n, l3, l4, l5, l6, l7, (String)localObject4, -1, l1, l2, l8, l9, (String)localObject1, (String)localObject2, (String)localObject3, str, paramb.GRl);
        AppMethodBeat.o(201099);
        return;
        localObject1 = paramb.GRp;
        break;
        localObject2 = paramb.GRq;
        break label2312;
        localObject3 = paramb.GRr;
        break label2327;
      }
    }
  }
  
  public static void a(c.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201025);
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
    if (paramb.GRc - paramb.GRd < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (paramb.GRa >= 104857600L) {
        break label995;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (paramb.GQV >= 2097152) {
        break label1160;
      }
      localIDKey1.SetKey(142);
      if (paramb.GQV >= 3858759.8F)
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
      f.Iyx.b(localArrayList, false);
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
      localIDKey1.SetValue((paramb.GRc - paramb.GRd) / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 1);
      localIDKey1.SetValue(paramb.GRa / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 2);
      localIDKey1.SetValue(1L);
      localArrayList.add(localIDKey1);
      f.Iyx.b(localArrayList, false);
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
          l = paramb.GRc - paramb.GRd;
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
          l = paramb.GRa;
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
            l = paramb.GQV;
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
          i = paramb.GRk;
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
      f.Iyx.b(localArrayList, false);
      AppMethodBeat.o(201025);
      return;
      if (paramb.GRc - paramb.GRd < 209715200L)
      {
        localIDKey1.SetKey(121);
        break;
      }
      if (paramb.GRc - paramb.GRd < 314572800L)
      {
        localIDKey1.SetKey(122);
        break;
      }
      if (paramb.GRc - paramb.GRd < 419430400L)
      {
        localIDKey1.SetKey(123);
        break;
      }
      if (paramb.GRc - paramb.GRd < 524288000L)
      {
        localIDKey1.SetKey(124);
        break;
      }
      if (paramb.GRc - paramb.GRd < 629145600L)
      {
        localIDKey1.SetKey(125);
        break;
      }
      if (paramb.GRc - paramb.GRd < 734003200L)
      {
        localIDKey1.SetKey(126);
        break;
      }
      if (paramb.GRc - paramb.GRd < 838860800L)
      {
        localIDKey1.SetKey(127);
        break;
      }
      localIDKey1.SetKey(128);
      break;
      label995:
      if (paramb.GRa < 209715200L)
      {
        localIDKey1.SetKey(132);
        break label111;
      }
      if (paramb.GRa < 314572800L)
      {
        localIDKey1.SetKey(133);
        break label111;
      }
      if (paramb.GRa < 419430400L)
      {
        localIDKey1.SetKey(134);
        break label111;
      }
      if (paramb.GRa < 524288000L)
      {
        localIDKey1.SetKey(135);
        break label111;
      }
      if (paramb.GRa < 629145600L)
      {
        localIDKey1.SetKey(136);
        break label111;
      }
      if (paramb.GRa < 734003200L)
      {
        localIDKey1.SetKey(137);
        break label111;
      }
      if (paramb.GRa < 838860800L)
      {
        localIDKey1.SetKey(138);
        break label111;
      }
      localIDKey1.SetKey(139);
      break label111;
      if (paramb.GQV < 2516582.5F)
      {
        localIDKey1.SetKey(143);
        break label160;
      }
      if (paramb.GQV < 2936012.8F)
      {
        localIDKey1.SetKey(144);
        break label160;
      }
      if (paramb.GQV < 3145728.0F)
      {
        localIDKey1.SetKey(145);
        break label160;
      }
      if (paramb.GQV < 3565158.5F)
      {
        localIDKey1.SetKey(146);
        break label160;
      }
      if (paramb.GQV < 3984588.8F)
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
  
  private static int abb(int paramInt)
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
  
  private static boolean b(c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(201122);
    if (paramb.GRl > 1024000)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(201122);
        return true;
      }
      a locala = a.GQg;
      locala.GQw += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label107;
        }
        locala = a.GQh;
      }
      for (locala.GQw += 1;; locala.GQw += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQw += 1;
        }
        AppMethodBeat.o(201122);
        return true;
        if (paramb.cQt) {
          break;
        }
        label107:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201122);
    return false;
  }
  
  private static ArrayList<IDKey> c(c.b paramb)
  {
    AppMethodBeat.i(201048);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new IDKey();
    ((IDKey)localObject1).SetID(1308);
    ((IDKey)localObject1).SetValue(1L);
    int i;
    Object localObject2;
    label542:
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
      ((IDKey)localObject1).SetKey(abb(paramb.GRm));
      localArrayList.add(localObject1);
      h(paramb);
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
      localObject2 = paramb.GRn;
      int m = localObject2.length;
      i = 0;
      if (i >= m) {
        break label692;
      }
      localObject3 = localObject2[i];
      localObject4 = (Integer)((Map)localObject1).remove(localObject3.processName);
      if (localObject4 == null) {
        break label1284;
      }
    }
    label1284:
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
        ((IDKey)localObject4).SetKey(abb(localObject3.GRk));
        localArrayList.add(localObject4);
        i += 1;
        break label542;
        i = 0;
        break;
      }
      label692:
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "stub : id = %s, process = %s", new Object[] { ((Map.Entry)localObject2).getValue(), ((Map.Entry)localObject2).getKey() });
        j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        if (BuildInfo.IS_ARM64)
        {
          i = 1;
          label782:
          localArrayList.add(new IDKey(j, i, 1));
          j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
          if (!BuildInfo.IS_ARM64) {
            break label845;
          }
        }
        label845:
        for (i = 57;; i = 17)
        {
          localArrayList.add(new IDKey(j, i, 1));
          break;
          i = 0;
          break label782;
        }
      }
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(1308);
      ((IDKey)localObject1).SetValue(1L);
      long l = paramb.GRj.availMem;
      if (l < 104857600L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 113;; i = 82)
        {
          ((IDKey)localObject1).SetKey(i);
          localArrayList.add(localObject1);
          AppMethodBeat.o(201048);
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
  
  private static boolean d(c.b paramb)
  {
    AppMethodBeat.i(201106);
    if (paramb.GRc - paramb.GRd > 262144000L)
    {
      a locala = a.GQg;
      locala.GQr += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label101;
        }
        locala = a.GQh;
      }
      for (locala.GQr += 1;; locala.GQr += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQr += 1;
        }
        AppMethodBeat.o(201106);
        return true;
        if (paramb.cQt) {
          break;
        }
        label101:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201106);
    return false;
  }
  
  private static boolean e(c.b paramb)
  {
    AppMethodBeat.i(201110);
    if (paramb.GRa > 524288000L)
    {
      a locala = a.GQg;
      locala.GQs += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label96;
        }
        locala = a.GQh;
      }
      for (locala.GQs += 1;; locala.GQs += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQs += 1;
        }
        AppMethodBeat.o(201110);
        return true;
        if (paramb.cQt) {
          break;
        }
        label96:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201110);
    return false;
  }
  
  private static boolean f(c.b paramb)
  {
    AppMethodBeat.i(201114);
    if ((!BuildInfo.IS_ARM64) && (paramb.GQV > 3879731.2000000002D))
    {
      a locala = a.GQg;
      locala.GQt += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label103;
        }
        locala = a.GQh;
      }
      for (locala.GQt += 1;; locala.GQt += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQt += 1;
        }
        AppMethodBeat.o(201114);
        return true;
        if (paramb.cQt) {
          break;
        }
        label103:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201114);
    return false;
  }
  
  private static boolean g(c.b paramb)
  {
    AppMethodBeat.i(201117);
    if (paramb.GRk > 1024000)
    {
      a locala = a.GQg;
      locala.GQu += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label95;
        }
        locala = a.GQh;
      }
      for (locala.GQu += 1;; locala.GQu += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQu += 1;
        }
        AppMethodBeat.o(201117);
        return true;
        if (paramb.cQt) {
          break;
        }
        label95:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201117);
    return false;
  }
  
  private static boolean h(c.b paramb)
  {
    AppMethodBeat.i(201128);
    if (paramb.GRm > 2097152)
    {
      a locala = a.GQg;
      locala.GQv += 1;
      if (paramb.GQX)
      {
        if (!paramb.GQG) {
          break label95;
        }
        locala = a.GQh;
      }
      for (locala.GQv += 1;; locala.GQv += 1)
      {
        paramb = a.aUw(paramb.fca);
        if (paramb != null) {
          paramb.GQv += 1;
        }
        AppMethodBeat.o(201128);
        return true;
        if (paramb.cQt) {
          break;
        }
        label95:
        locala = a.GQi;
      }
    }
    AppMethodBeat.o(201128);
    return false;
  }
  
  static enum a
  {
    static final int GQp;
    List<String> GQq;
    int GQr;
    int GQs;
    int GQt;
    int GQu;
    int GQv;
    int GQw;
    boolean GQx;
    int type;
    
    static
    {
      AppMethodBeat.i(200761);
      GQg = new a("GLOBAL", 0, new String[0]);
      GQh = new a("FOREGROUND", 1, new String[0]);
      GQi = new a("BACKGROUND", 2, new String[0]);
      GQj = new a("VOIP", 3, new String[] { "VideoActivity", "VoipCSMainUI", "MultiTalkMainUI", "VoipScoreDialog" });
      GQk = new a("SNS", 4, new String[] { "Sns.*UI", "SnsOnlineVideoActivity" });
      GQl = new a("FINDER", 5, new String[] { "Finder.*UI" });
      GQm = new a("ALBUM_GALLERY", 6, new String[] { "AlbumPreviewUI", "ImagePreviewUI", "ImageGalleryUI" });
      GQn = new a("STORY", 7, new String[] { "Story.*UI" });
      GQo = new a("RECORD", 8, new String[] { "MMRecordUI" });
      GQy = new a[] { GQg, GQh, GQi, GQj, GQk, GQl, GQm, GQn, GQo };
      GQp = -2147483648 >> values().length;
      AppMethodBeat.o(200761);
    }
    
    private a(String... paramVarArgs)
    {
      AppMethodBeat.i(200757);
      this.GQr = 0;
      this.GQs = 0;
      this.GQt = 0;
      this.GQu = 0;
      this.GQv = 0;
      this.GQw = 0;
      this.GQx = false;
      int i = a.GQz;
      a.GQz = i + 1;
      this.type = (-2147483648 >>> i);
      this.GQq = Arrays.asList(paramVarArgs);
      AppMethodBeat.o(200757);
    }
    
    static a aUw(String paramString)
    {
      AppMethodBeat.i(200759);
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        Iterator localIterator = locala.GQq.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!locala.GQx) && (paramString.matches(str)))
          {
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "%s matches %s(%s)", new Object[] { paramString, str, locala.name() });
            AppMethodBeat.o(200759);
            return locala;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(200759);
      return null;
    }
    
    static boolean abc(int paramInt)
    {
      return ((GQp ^ 0xFFFFFFFF) & paramInt) != 0;
    }
    
    static final class a
    {
      static int GQz = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.b
 * JD-Core Version:    0.7.0.1
 */