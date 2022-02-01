package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager.MemoryInfo;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
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
  private static int Uq(int paramInt)
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
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2, long paramLong6, long paramLong7, long paramLong8, long paramLong9)
  {
    AppMethodBeat.i(201143);
    e locale = e.Cxv;
    String str = MMApplicationContext.getProcessName();
    if (BuildInfo.IS_ARM64) {}
    for (int i = 1;; i = 2)
    {
      locale.a(20731, new Object[] { Integer.valueOf(paramInt1), str, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(i), Long.valueOf(paramLong8), Long.valueOf(paramLong9) });
      AppMethodBeat.o(201143);
      return;
    }
  }
  
  public static void a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(201135);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(959);
    localIDKey1.SetValue(1L);
    label110:
    int i;
    if (parama.AXx - parama.AXy < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.AXv >= 104857600L) {
        break label979;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.AXq >= 2097152) {
        break label1144;
      }
      localIDKey1.SetKey(142);
      label158:
      if (parama.AXq >= 3858759.8F)
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
      e.Cxv.b(localArrayList, false);
      c(parama);
      localArrayList = new ArrayList();
      if (!MMApplicationContext.isMainProcess()) {
        break label1265;
      }
      i = 10;
    }
    for (;;)
    {
      label286:
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i);
      localIDKey1.SetValue((parama.AXx - parama.AXy) / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 1);
      localIDKey1.SetValue(parama.AXv / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 2);
      localIDKey1.SetValue(1L);
      localArrayList.add(localIDKey1);
      e.Cxv.b(localArrayList, false);
      label483:
      int j;
      label518:
      long l;
      if ((MMApplicationContext.isAppBrandProcess()) || (MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
      {
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "reportPreloadProcessMemory: hasActivity = %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!MMApplicationContext.isAppBrandProcess()) {
          break label1295;
        }
        i = 1462;
        if (i > 0)
        {
          localArrayList = new ArrayList();
          localArrayList.add(new IDKey(i, 0, 1));
          if (!paramBoolean) {
            break label1326;
          }
          j = 1;
          localArrayList.add(new IDKey(i, j, 1));
          l = parama.AXx - parama.AXy;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 52428800L) {
            break label1337;
          }
          if (!paramBoolean) {
            break label1331;
          }
          j = 3;
          label581:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          l = parama.AXv;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 104857600L) {
            break label1673;
          }
          if (!paramBoolean) {
            break label1667;
          }
          j = 55;
          label638:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          if (!BuildInfo.IS_ARM64)
          {
            localIDKey1 = new IDKey();
            localIDKey1.SetID(i);
            localIDKey1.SetValue(1L);
            l = parama.AXq;
            if (l >= 1572864.0D) {
              break label1980;
            }
            if (!paramBoolean) {
              break label1974;
            }
            j = 111;
            label703:
            localIDKey1.SetKey(j);
            localArrayList.add(localIDKey1);
          }
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          i = parama.AXF;
          if (i >= 102400) {
            break label2135;
          }
          if (!paramBoolean) {
            break label2128;
          }
        }
      }
      label1295:
      label1326:
      label1331:
      label1337:
      label1980:
      label2128:
      for (i = 139;; i = 153)
      {
        localIDKey1.SetKey(i);
        localArrayList.add(localIDKey1);
        e.Cxv.b(localArrayList, false);
        AppMethodBeat.o(201135);
        return;
        if (parama.AXx - parama.AXy < 209715200L)
        {
          localIDKey1.SetKey(121);
          break;
        }
        if (parama.AXx - parama.AXy < 314572800L)
        {
          localIDKey1.SetKey(122);
          break;
        }
        if (parama.AXx - parama.AXy < 419430400L)
        {
          localIDKey1.SetKey(123);
          break;
        }
        if (parama.AXx - parama.AXy < 524288000L)
        {
          localIDKey1.SetKey(124);
          break;
        }
        if (parama.AXx - parama.AXy < 629145600L)
        {
          localIDKey1.SetKey(125);
          break;
        }
        if (parama.AXx - parama.AXy < 734003200L)
        {
          localIDKey1.SetKey(126);
          break;
        }
        if (parama.AXx - parama.AXy < 838860800L)
        {
          localIDKey1.SetKey(127);
          break;
        }
        localIDKey1.SetKey(128);
        break;
        label979:
        if (parama.AXv < 209715200L)
        {
          localIDKey1.SetKey(132);
          break label110;
        }
        if (parama.AXv < 314572800L)
        {
          localIDKey1.SetKey(133);
          break label110;
        }
        if (parama.AXv < 419430400L)
        {
          localIDKey1.SetKey(134);
          break label110;
        }
        if (parama.AXv < 524288000L)
        {
          localIDKey1.SetKey(135);
          break label110;
        }
        if (parama.AXv < 629145600L)
        {
          localIDKey1.SetKey(136);
          break label110;
        }
        if (parama.AXv < 734003200L)
        {
          localIDKey1.SetKey(137);
          break label110;
        }
        if (parama.AXv < 838860800L)
        {
          localIDKey1.SetKey(138);
          break label110;
        }
        localIDKey1.SetKey(139);
        break label110;
        label1144:
        if (parama.AXq < 2516582.5F)
        {
          localIDKey1.SetKey(143);
          break label158;
        }
        if (parama.AXq < 2936012.8F)
        {
          localIDKey1.SetKey(144);
          break label158;
        }
        if (parama.AXq < 3145728.0F)
        {
          localIDKey1.SetKey(145);
          break label158;
        }
        if (parama.AXq < 3565158.5F)
        {
          localIDKey1.SetKey(146);
          break label158;
        }
        if (parama.AXq < 3984588.8F)
        {
          localIDKey1.SetKey(147);
          break label158;
        }
        localIDKey1.SetKey(148);
        break label158;
        label1265:
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
        {
          i = 20;
          break label286;
        }
        if (!MMApplicationContext.isAppBrandProcess()) {
          break label2429;
        }
        i = 30;
        break label286;
        if (MMApplicationContext.isToolsProcess())
        {
          i = 1463;
          break label483;
        }
        if (MMApplicationContext.isToolsMpProcess())
        {
          i = 1464;
          break label483;
        }
        i = -1;
        break label483;
        j = 2;
        break label518;
        j = 16;
        break label581;
        if (l < 104857600L)
        {
          if (paramBoolean) {}
          for (j = 4;; j = 17)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 209715200L)
        {
          if (paramBoolean) {}
          for (j = 5;; j = 18)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 314572800L)
        {
          if (paramBoolean) {}
          for (j = 6;; j = 19)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 419430400L)
        {
          if (paramBoolean) {}
          for (j = 7;; j = 20)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 524288000L)
        {
          if (paramBoolean) {}
          for (j = 8;; j = 21)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 629145600L)
        {
          if (paramBoolean) {}
          for (j = 9;; j = 22)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 734003200L)
        {
          if (paramBoolean) {}
          for (j = 10;; j = 23)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 838860800L)
        {
          if (paramBoolean) {}
          for (j = 11;; j = 24)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 943718400L)
        {
          if (paramBoolean) {}
          for (j = 12;; j = 25)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 1048576000L)
        {
          if (paramBoolean) {}
          for (j = 13;; j = 26)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (paramBoolean) {}
        for (j = 14;; j = 27)
        {
          localIDKey1.SetKey(j);
          break;
        }
        j = 69;
        break label638;
        if (l < 209715200L)
        {
          if (paramBoolean) {}
          for (j = 56;; j = 70)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 314572800L)
        {
          if (paramBoolean) {}
          for (j = 57;; j = 71)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 419430400L)
        {
          if (paramBoolean) {}
          for (j = 58;; j = 72)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 524288000L)
        {
          if (paramBoolean) {}
          for (j = 59;; j = 73)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 629145600L)
        {
          if (paramBoolean) {}
          for (j = 60;; j = 74)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 734003200L)
        {
          if (paramBoolean) {}
          for (j = 61;; j = 75)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 838860800L)
        {
          if (paramBoolean) {}
          for (j = 62;; j = 76)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 943718400L)
        {
          if (paramBoolean) {}
          for (j = 63;; j = 77)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 1048576000L)
        {
          if (paramBoolean) {}
          for (j = 64;; j = 78)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (paramBoolean) {}
        for (j = 65;; j = 79)
        {
          localIDKey1.SetKey(j);
          break;
        }
        j = 118;
        break label703;
        if (l < 2097152L)
        {
          if (paramBoolean) {}
          for (j = 112;; j = 119)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 2621440.0D)
        {
          if (paramBoolean) {}
          for (j = 113;; j = 120)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 3145728L)
        {
          if (paramBoolean) {}
          for (j = 114;; j = 121)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (l < 3670016.0D)
        {
          if (paramBoolean) {}
          for (j = 115;; j = 122)
          {
            localIDKey1.SetKey(j);
            break;
          }
        }
        if (paramBoolean) {}
        for (j = 116;; j = 123)
        {
          localIDKey1.SetKey(j);
          break;
        }
      }
      label1667:
      label1673:
      label1974:
      label2135:
      if (i < 204800)
      {
        if (paramBoolean) {}
        for (i = 140;; i = 154)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 307200)
      {
        if (paramBoolean) {}
        for (i = 141;; i = 155)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 409600)
      {
        if (paramBoolean) {}
        for (i = 142;; i = 156)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 512000)
      {
        if (paramBoolean) {}
        for (i = 143;; i = 157)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 614400)
      {
        if (paramBoolean) {}
        for (i = 144;; i = 158)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 716800)
      {
        if (paramBoolean) {}
        for (i = 145;; i = 159)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 819200)
      {
        if (paramBoolean) {}
        for (i = 146;; i = 160)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 921600)
      {
        if (paramBoolean) {}
        for (i = 147;; i = 161)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (i < 1024000)
      {
        if (paramBoolean) {}
        for (i = 148;; i = 162)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      if (paramBoolean) {}
      for (i = 149;; i = 163)
      {
        localIDKey1.SetKey(i);
        break;
      }
      label2429:
      i = 0;
    }
  }
  
  private static ArrayList<IDKey> b(c.a parama)
  {
    AppMethodBeat.i(201136);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new IDKey();
    ((IDKey)localObject1).SetID(1308);
    ((IDKey)localObject1).SetValue(1L);
    int i;
    Object localObject2;
    label533:
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
      ((IDKey)localObject1).SetKey(Uq(parama.AXG));
      localArrayList.add(localObject1);
      h(parama);
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
      localObject2 = parama.AXH;
      int m = localObject2.length;
      i = 0;
      if (i >= m) {
        break label683;
      }
      localObject3 = localObject2[i];
      localObject4 = (Integer)((Map)localObject1).remove(localObject3.processName);
      if (localObject4 == null) {
        break label1274;
      }
    }
    label683:
    label836:
    label1274:
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
        ((IDKey)localObject4).SetKey(Uq(localObject3.AXF));
        localArrayList.add(localObject4);
        i += 1;
        break label533;
        i = 0;
        break;
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Log.d("MicroMsg.MemoryWatchDog.Reporter", "stub : id = %s, process = %s", new Object[] { ((Map.Entry)localObject2).getValue(), ((Map.Entry)localObject2).getKey() });
        j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        if (BuildInfo.IS_ARM64)
        {
          i = 1;
          localArrayList.add(new IDKey(j, i, 1));
          j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
          if (!BuildInfo.IS_ARM64) {
            break label836;
          }
        }
        for (i = 57;; i = 17)
        {
          localArrayList.add(new IDKey(j, i, 1));
          break;
          i = 0;
          break label773;
        }
      }
      localObject1 = new IDKey();
      ((IDKey)localObject1).SetID(1308);
      ((IDKey)localObject1).SetValue(1L);
      long l = parama.AXE.availMem;
      if (l < 104857600L)
      {
        if (BuildInfo.IS_ARM64) {}
        for (i = 113;; i = 82)
        {
          ((IDKey)localObject1).SetKey(i);
          localArrayList.add(localObject1);
          AppMethodBeat.o(201136);
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
  
  private static void c(c.a parama)
  {
    AppMethodBeat.i(201137);
    if (MMApplicationContext.isMainProcess()) {
      i = 1161;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(201137);
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
    int j;
    long l3;
    label225:
    long l4;
    label281:
    long l5;
    label339:
    int i5;
    if (BuildInfo.IS_ARM64)
    {
      j = 254;
      ((IDKey)localObject2).SetKey(j);
      ((ArrayList)localObject1).add(localObject2);
      l3 = parama.AXx - parama.AXy;
      d(parama);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l3 >= 104857600L) {
        break label815;
      }
      ((IDKey)localObject2).SetKey(1);
      ((ArrayList)localObject1).add(localObject2);
      l4 = parama.AXv;
      e(parama);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l4 >= 104857600L) {
        break label992;
      }
      ((IDKey)localObject2).SetKey(33);
      ((ArrayList)localObject1).add(localObject2);
      l5 = parama.AXq;
      f(parama);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l5 >= 1572864.0D) {
        break label1173;
      }
      ((IDKey)localObject2).SetKey(65);
      ((ArrayList)localObject1).add(localObject2);
      i5 = parama.AXF;
      g(parama);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (i5 >= 102400) {
        break label1524;
      }
      if (!BuildInfo.IS_ARM64) {
        break label1518;
      }
    }
    long l1;
    long l2;
    int m;
    int k;
    Object localObject3;
    int i7;
    int n;
    label815:
    label992:
    label1518:
    for (int i = 154;; i = 122)
    {
      ((IDKey)localObject2).SetKey(i);
      ((ArrayList)localObject1).add(localObject2);
      if (MMApplicationContext.isMainProcess()) {
        ((ArrayList)localObject1).addAll(b(parama));
      }
      e.Cxv.b((ArrayList)localObject1, false);
      l1 = -1L;
      l2 = -1L;
      if (parama.map != null)
      {
        l1 = Util.getLong((String)parama.map.get("summary.system"), -1L);
        l2 = Util.getLong((String)parama.map.get("summary.graphics"), -1L);
      }
      Log.i("MicroMsg.MemoryWatchDog.Reporter", "systemPss = %d, graphics = %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      m = 0;
      localObject1 = new StringBuilder();
      j = 0;
      localObject2 = a.values();
      int i6 = localObject2.length;
      k = 0;
      if (k >= i6) {
        break label1990;
      }
      localObject3 = localObject2[k];
      if (localObject3.AWS >= 3) {
        localObject3.type |= 0x1;
      }
      if (localObject3.AWT >= 3) {
        localObject3.type |= 0x2;
      }
      if (localObject3.AWU >= 3) {
        localObject3.type |= 0x4;
      }
      if (localObject3.AWV >= 3) {
        localObject3.type |= 0x8;
      }
      if (localObject3.AWW >= 3) {
        localObject3.type |= 0x10;
      }
      i7 = localObject3.type;
      i = j;
      n = m;
      if (!a.Ur(i7)) {
        break label1940;
      }
      i = j;
      n = m;
      if (localObject3.AWX) {
        break label1940;
      }
      i = j;
      if ((i7 & 0x10) != 16) {
        break label1844;
      }
      i = j;
      if (j != 0) {
        break label1844;
      }
      ((StringBuilder)localObject1).append("allProcess:");
      c.a[] arrayOfa = parama.AXH;
      j = arrayOfa.length;
      i = 0;
      while (i < j)
      {
        c.a locala = arrayOfa[i];
        ((StringBuilder)localObject1).append(locala.pid).append("-").append(locala.processName).append("-pss:").append(locala.AXF).append(";");
        i += 1;
      }
      j = 255;
      break;
      if (l3 < 209715200L)
      {
        ((IDKey)localObject2).SetKey(2);
        break label225;
      }
      if (l3 < 314572800L)
      {
        ((IDKey)localObject2).SetKey(3);
        break label225;
      }
      if (l3 < 419430400L)
      {
        ((IDKey)localObject2).SetKey(4);
        break label225;
      }
      if (l3 < 524288000L)
      {
        ((IDKey)localObject2).SetKey(5);
        break label225;
      }
      if (l3 < 629145600L)
      {
        ((IDKey)localObject2).SetKey(6);
        break label225;
      }
      if (l3 < 734003200L)
      {
        ((IDKey)localObject2).SetKey(7);
        break label225;
      }
      if (l3 < 838860800L)
      {
        ((IDKey)localObject2).SetKey(8);
        break label225;
      }
      if (l3 < 943718400L)
      {
        ((IDKey)localObject2).SetKey(9);
        break label225;
      }
      if (l3 < 1048576000L)
      {
        ((IDKey)localObject2).SetKey(10);
        break label225;
      }
      ((IDKey)localObject2).SetKey(11);
      break label225;
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
      if (l5 < 2097152L)
      {
        ((IDKey)localObject2).SetKey(66);
        break label339;
      }
      if (l5 < 2621440.0D)
      {
        ((IDKey)localObject2).SetKey(67);
        break label339;
      }
      if (l5 < 3145728L)
      {
        ((IDKey)localObject2).SetKey(68);
        break label339;
      }
      if (l5 < 3670016.0D)
      {
        ((IDKey)localObject2).SetKey(69);
        break label339;
      }
      if (l5 < 4194304L)
      {
        ((IDKey)localObject2).SetKey(70);
        break label339;
      }
      if (l5 < 4718592.0D)
      {
        ((IDKey)localObject2).SetKey(71);
        break label339;
      }
      if (l5 < 5242880L)
      {
        ((IDKey)localObject2).SetKey(72);
        break label339;
      }
      if (l5 < 5767168.0D)
      {
        ((IDKey)localObject2).SetKey(73);
        break label339;
      }
      if (l5 < 6291456.0D)
      {
        ((IDKey)localObject2).SetKey(74);
        break label339;
      }
      if (l5 < 6815744.0D)
      {
        ((IDKey)localObject2).SetKey(75);
        break label339;
      }
      if (l5 < 7340032.0D)
      {
        ((IDKey)localObject2).SetKey(76);
        break label339;
      }
      if (l5 < 7864320.0D)
      {
        ((IDKey)localObject2).SetKey(77);
        break label339;
      }
      if (l5 < 8388608.0D)
      {
        ((IDKey)localObject2).SetKey(78);
        break label339;
      }
      if (l5 < 8912896.0D)
      {
        ((IDKey)localObject2).SetKey(79);
        break label339;
      }
      if (l5 < 9437184.0D)
      {
        ((IDKey)localObject2).SetKey(80);
        break label339;
      }
      if (l5 < 9961472.0D)
      {
        ((IDKey)localObject2).SetKey(81);
        break label339;
      }
      if (l5 < 10485760L)
      {
        ((IDKey)localObject2).SetKey(82);
        break label339;
      }
      ((IDKey)localObject2).SetKey(83);
      break label339;
    }
    label1173:
    label1524:
    if (i5 < 204800)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 155;; i = 123)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 307200)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 156;; i = 124)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 409600)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 157;; i = 125)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 512000)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 158;; i = 126)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 614400)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 159;; i = 127)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 716800)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 160;; i = 128)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 819200)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 161;; i = 129)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 921600)
    {
      if (BuildInfo.IS_ARM64) {}
      for (i = 162;; i = 130)
      {
        ((IDKey)localObject2).SetKey(i);
        break;
      }
    }
    if (i5 < 1024000)
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
    i = 1;
    label1844:
    label1853:
    label1863:
    int i1;
    label1873:
    int i2;
    label1884:
    int i3;
    if (d(parama))
    {
      j = 1;
      if (!e(parama)) {
        break label1958;
      }
      n = 2;
      if (!f(parama)) {
        break label1964;
      }
      i1 = 4;
      if (!g(parama)) {
        break label1970;
      }
      i2 = 8;
      if (!h(parama)) {
        break label1976;
      }
      i3 = 16;
      label1895:
      if (!parama.AXr.isEmpty()) {
        break label1982;
      }
    }
    label1940:
    label1958:
    label1964:
    label1970:
    label1976:
    label1982:
    for (int i4 = 0;; i4 = 256)
    {
      n = m | i4 | i7 | j | n | i1 | i2 | i3;
      localObject3.AWX = true;
      k += 1;
      j = i;
      m = n;
      break;
      j = 0;
      break label1853;
      n = 0;
      break label1863;
      i1 = 0;
      break label1873;
      i2 = 0;
      break label1884;
      i3 = 0;
      break label1895;
    }
    label1990:
    if (a.Ur(m)) {
      a(m, l3, l4, l5, i5, parama.AXG, ((StringBuilder)localObject1).toString(), -1, l1, l2, parama.AXD, parama.AXE.totalMem);
    }
    AppMethodBeat.o(201137);
  }
  
  private static boolean d(c.a parama)
  {
    AppMethodBeat.i(201138);
    if (parama.AXx - parama.AXy > 262144000L)
    {
      a locala = a.AWH;
      locala.AWS += 1;
      if (parama.AXs)
      {
        if (!parama.AXg) {
          break label101;
        }
        locala = a.AWI;
      }
      for (locala.AWS += 1;; locala.AWS += 1)
      {
        parama = a.aKa(parama.activity);
        if (parama != null) {
          parama.AWS += 1;
        }
        AppMethodBeat.o(201138);
        return true;
        if (parama.cPB) {
          break;
        }
        label101:
        locala = a.AWJ;
      }
    }
    AppMethodBeat.o(201138);
    return false;
  }
  
  private static boolean e(c.a parama)
  {
    AppMethodBeat.i(201139);
    if (parama.AXv > 524288000L)
    {
      a locala = a.AWH;
      locala.AWT += 1;
      if (parama.AXs)
      {
        if (!parama.AXg) {
          break label96;
        }
        locala = a.AWI;
      }
      for (locala.AWT += 1;; locala.AWT += 1)
      {
        parama = a.aKa(parama.activity);
        if (parama != null) {
          parama.AWT += 1;
        }
        AppMethodBeat.o(201139);
        return true;
        if (parama.cPB) {
          break;
        }
        label96:
        locala = a.AWJ;
      }
    }
    AppMethodBeat.o(201139);
    return false;
  }
  
  private static boolean f(c.a parama)
  {
    AppMethodBeat.i(201140);
    if ((!BuildInfo.IS_ARM64) && (parama.AXq > 3879731.2000000002D))
    {
      a locala = a.AWH;
      locala.AWU += 1;
      if (parama.AXs)
      {
        if (!parama.AXg) {
          break label103;
        }
        locala = a.AWI;
      }
      for (locala.AWU += 1;; locala.AWU += 1)
      {
        parama = a.aKa(parama.activity);
        if (parama != null) {
          parama.AWU += 1;
        }
        AppMethodBeat.o(201140);
        return true;
        if (parama.cPB) {
          break;
        }
        label103:
        locala = a.AWJ;
      }
    }
    AppMethodBeat.o(201140);
    return false;
  }
  
  private static boolean g(c.a parama)
  {
    AppMethodBeat.i(201141);
    if (parama.AXF > 1024000)
    {
      a locala = a.AWH;
      locala.AWV += 1;
      if (parama.AXs)
      {
        if (!parama.AXg) {
          break label94;
        }
        locala = a.AWI;
      }
      for (locala.AWV += 1;; locala.AWV += 1)
      {
        parama = a.aKa(parama.activity);
        if (parama != null) {
          parama.AWV += 1;
        }
        AppMethodBeat.o(201141);
        return true;
        if (parama.cPB) {
          break;
        }
        label94:
        locala = a.AWJ;
      }
    }
    AppMethodBeat.o(201141);
    return false;
  }
  
  private static boolean h(c.a parama)
  {
    AppMethodBeat.i(201142);
    if (parama.AXG > 2097152)
    {
      a locala = a.AWH;
      locala.AWW += 1;
      if (parama.AXs)
      {
        if (!parama.AXg) {
          break label94;
        }
        locala = a.AWI;
      }
      for (locala.AWW += 1;; locala.AWW += 1)
      {
        parama = a.aKa(parama.activity);
        if (parama != null) {
          parama.AWW += 1;
        }
        AppMethodBeat.o(201142);
        return true;
        if (parama.cPB) {
          break;
        }
        label94:
        locala = a.AWJ;
      }
    }
    AppMethodBeat.o(201142);
    return false;
  }
  
  static enum a
  {
    static final int AWQ;
    List<String> AWR;
    int AWS;
    int AWT;
    int AWU;
    int AWV;
    int AWW;
    boolean AWX;
    int type;
    
    static
    {
      AppMethodBeat.i(201134);
      AWH = new a("GLOBAL", 0, new String[0]);
      AWI = new a("FOREGROUND", 1, new String[0]);
      AWJ = new a("BACKGROUND", 2, new String[0]);
      AWK = new a("VOIP", 3, new String[] { "VideoActivity", "VoipCSMainUI", "MultiTalkMainUI", "VoipScoreDialog" });
      AWL = new a("SNS", 4, new String[] { "Sns.*UI", "SnsOnlineVideoActivity" });
      AWM = new a("FINDER", 5, new String[] { "Finder.*UI" });
      AWN = new a("ALBUM_GALLERY", 6, new String[] { "AlbumPreviewUI", "ImagePreviewUI", "ImageGalleryUI" });
      AWO = new a("STORY", 7, new String[] { "Story.*UI" });
      AWP = new a("RECORD", 8, new String[] { "MMRecordUI" });
      AWY = new a[] { AWH, AWI, AWJ, AWK, AWL, AWM, AWN, AWO, AWP };
      AWQ = -2147483648 >> values().length;
      AppMethodBeat.o(201134);
    }
    
    private a(String... paramVarArgs)
    {
      AppMethodBeat.i(201132);
      this.AWS = 0;
      this.AWT = 0;
      this.AWU = 0;
      this.AWV = 0;
      this.AWW = 0;
      this.AWX = false;
      int i = a.AWZ;
      a.AWZ = i + 1;
      this.type = (-2147483648 >>> i);
      this.AWR = Arrays.asList(paramVarArgs);
      AppMethodBeat.o(201132);
    }
    
    static boolean Ur(int paramInt)
    {
      return ((AWQ ^ 0xFFFFFFFF) & paramInt) != 0;
    }
    
    static a aKa(String paramString)
    {
      AppMethodBeat.i(201133);
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        Iterator localIterator = locala.AWR.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!locala.AWX) && (paramString.matches(str)))
          {
            Log.d("MicroMsg.MemoryWatchDog.Reporter", "%s matches %s(%s)", new Object[] { paramString, str, locala.name() });
            AppMethodBeat.o(201133);
            return locala;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(201133);
      return null;
    }
    
    static final class a
    {
      static int AWZ = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.b
 * JD-Core Version:    0.7.0.1
 */