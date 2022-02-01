package com.tencent.mm.plugin.performance.c;

import android.app.ActivityManager.MemoryInfo;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import java.util.ArrayList;
import java.util.Map;

public final class b
{
  private static int wZD = 0;
  private static int wZE = 0;
  private static int wZF = 0;
  private static int wZG = 0;
  private static int wZH = 0;
  private static boolean wZI = false;
  
  private static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2, long paramLong6, long paramLong7)
  {
    AppMethodBeat.i(215448);
    e.ywz.f(20731, new Object[] { Integer.valueOf(paramInt1), ak.getProcessName(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong6), Long.valueOf(paramLong7) });
    AppMethodBeat.o(215448);
  }
  
  private static void a(c.a parama)
  {
    AppMethodBeat.i(215446);
    int i;
    if (ak.coh()) {
      i = 1161;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(215446);
      return;
      if (ak.isAppBrandProcess()) {
        i = 1162;
      } else if (ak.foC()) {
        i = 1163;
      } else if (ak.foA()) {
        i = 1164;
      } else if (ak.foD()) {
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
    long l1;
    label224:
    long l2;
    label281:
    long l3;
    label340:
    int i2;
    label399:
    int k;
    label452:
    long l4;
    if (j.hjx)
    {
      j = 254;
      ((IDKey)localObject2).SetKey(j);
      ((ArrayList)localObject1).add(localObject2);
      l1 = parama.wZU - parama.wZV;
      yO(l1);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l1 >= 104857600L) {
        break label782;
      }
      ((IDKey)localObject2).SetKey(1);
      ((ArrayList)localObject1).add(localObject2);
      l2 = parama.wZS;
      yP(l2);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l2 >= 104857600L) {
        break label959;
      }
      ((IDKey)localObject2).SetKey(33);
      ((ArrayList)localObject1).add(localObject2);
      l3 = parama.wZQ;
      yQ(l3);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l3 >= 1572864.0D) {
        break label1140;
      }
      ((IDKey)localObject2).SetKey(65);
      ((ArrayList)localObject1).add(localObject2);
      i2 = parama.xab;
      yR(i2);
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (i2 >= 102400) {
        break label1491;
      }
      if (!j.hjx) {
        break label1485;
      }
      i = 154;
      ((IDKey)localObject2).SetKey(i);
      ((ArrayList)localObject1).add(localObject2);
      k = 0;
      if (ak.coh())
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        if (!j.hjx) {
          break label1810;
        }
        i = 1;
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        k = parama.xac;
        yS(k);
        if (k >= 102400) {
          break label1820;
        }
        if (!j.hjx) {
          break label1815;
        }
        i = 42;
        label515:
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        l4 = parama.xaa.availMem;
        if (l4 >= 104857600L) {
          break label2242;
        }
        if (!j.hjx) {
          break label2236;
        }
        i = 113;
        label579:
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
      }
      e.ywz.b((ArrayList)localObject1, false);
      j = 0;
      if (wZD >= 3) {
        j = 1;
      }
      i = j;
      if (wZE >= 3) {
        i = j | 0x2;
      }
      j = i;
      if (wZF >= 3) {
        j = i | 0x4;
      }
      i = j;
      if (wZG >= 3) {
        i = j | 0x8;
      }
      if (wZH < 3) {
        break label2806;
      }
      i |= 0x10;
    }
    label782:
    label959:
    label1140:
    label2806:
    for (;;)
    {
      int m;
      int n;
      int i1;
      if ((i != 0) && (!wZI))
      {
        localObject1 = new StringBuilder();
        if ((i & 0x10) == 16)
        {
          ((StringBuilder)localObject1).append("allProcess:");
          localObject2 = parama.xad;
          m = localObject2.length;
          j = 0;
          for (;;)
          {
            if (j < m)
            {
              Object localObject3 = localObject2[j];
              ((StringBuilder)localObject1).append(localObject3.pid).append("-").append(localObject3.processName).append("-pss:").append(localObject3.xab).append(";");
              j += 1;
              continue;
              j = 255;
              break;
              if (l1 < 209715200L)
              {
                ((IDKey)localObject2).SetKey(2);
                break label224;
              }
              if (l1 < 314572800L)
              {
                ((IDKey)localObject2).SetKey(3);
                break label224;
              }
              if (l1 < 419430400L)
              {
                ((IDKey)localObject2).SetKey(4);
                break label224;
              }
              if (l1 < 524288000L)
              {
                ((IDKey)localObject2).SetKey(5);
                break label224;
              }
              if (l1 < 629145600L)
              {
                ((IDKey)localObject2).SetKey(6);
                break label224;
              }
              if (l1 < 734003200L)
              {
                ((IDKey)localObject2).SetKey(7);
                break label224;
              }
              if (l1 < 838860800L)
              {
                ((IDKey)localObject2).SetKey(8);
                break label224;
              }
              if (l1 < 943718400L)
              {
                ((IDKey)localObject2).SetKey(9);
                break label224;
              }
              if (l1 < 1048576000L)
              {
                ((IDKey)localObject2).SetKey(10);
                break label224;
              }
              ((IDKey)localObject2).SetKey(11);
              break label224;
              if (l2 < 209715200L)
              {
                ((IDKey)localObject2).SetKey(34);
                break label281;
              }
              if (l2 < 314572800L)
              {
                ((IDKey)localObject2).SetKey(35);
                break label281;
              }
              if (l2 < 419430400L)
              {
                ((IDKey)localObject2).SetKey(36);
                break label281;
              }
              if (l2 < 524288000L)
              {
                ((IDKey)localObject2).SetKey(37);
                break label281;
              }
              if (l2 < 629145600L)
              {
                ((IDKey)localObject2).SetKey(38);
                break label281;
              }
              if (l2 < 734003200L)
              {
                ((IDKey)localObject2).SetKey(39);
                break label281;
              }
              if (l2 < 838860800L)
              {
                ((IDKey)localObject2).SetKey(40);
                break label281;
              }
              if (l2 < 943718400L)
              {
                ((IDKey)localObject2).SetKey(41);
                break label281;
              }
              if (l2 < 1048576000L)
              {
                ((IDKey)localObject2).SetKey(42);
                break label281;
              }
              ((IDKey)localObject2).SetKey(43);
              break label281;
              if (l3 < 2097152L)
              {
                ((IDKey)localObject2).SetKey(66);
                break label340;
              }
              if (l3 < 2621440.0D)
              {
                ((IDKey)localObject2).SetKey(67);
                break label340;
              }
              if (l3 < 3145728L)
              {
                ((IDKey)localObject2).SetKey(68);
                break label340;
              }
              if (l3 < 3670016.0D)
              {
                ((IDKey)localObject2).SetKey(69);
                break label340;
              }
              if (l3 < 4194304L)
              {
                ((IDKey)localObject2).SetKey(70);
                break label340;
              }
              if (l3 < 4718592.0D)
              {
                ((IDKey)localObject2).SetKey(71);
                break label340;
              }
              if (l3 < 5242880L)
              {
                ((IDKey)localObject2).SetKey(72);
                break label340;
              }
              if (l3 < 5767168.0D)
              {
                ((IDKey)localObject2).SetKey(73);
                break label340;
              }
              if (l3 < 6291456.0D)
              {
                ((IDKey)localObject2).SetKey(74);
                break label340;
              }
              if (l3 < 6815744.0D)
              {
                ((IDKey)localObject2).SetKey(75);
                break label340;
              }
              if (l3 < 7340032.0D)
              {
                ((IDKey)localObject2).SetKey(76);
                break label340;
              }
              if (l3 < 7864320.0D)
              {
                ((IDKey)localObject2).SetKey(77);
                break label340;
              }
              if (l3 < 8388608.0D)
              {
                ((IDKey)localObject2).SetKey(78);
                break label340;
              }
              if (l3 < 8912896.0D)
              {
                ((IDKey)localObject2).SetKey(79);
                break label340;
              }
              if (l3 < 9437184.0D)
              {
                ((IDKey)localObject2).SetKey(80);
                break label340;
              }
              if (l3 < 9961472.0D)
              {
                ((IDKey)localObject2).SetKey(81);
                break label340;
              }
              if (l3 < 10485760L)
              {
                ((IDKey)localObject2).SetKey(82);
                break label340;
              }
              ((IDKey)localObject2).SetKey(83);
              break label340;
              i = 122;
              break label399;
              if (i2 < 204800)
              {
                if (j.hjx) {}
                for (i = 155;; i = 123)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 307200)
              {
                if (j.hjx) {}
                for (i = 156;; i = 124)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 409600)
              {
                if (j.hjx) {}
                for (i = 157;; i = 125)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 512000)
              {
                if (j.hjx) {}
                for (i = 158;; i = 126)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 614400)
              {
                if (j.hjx) {}
                for (i = 159;; i = 127)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 716800)
              {
                if (j.hjx) {}
                for (i = 160;; i = 128)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 819200)
              {
                if (j.hjx) {}
                for (i = 161;; i = 129)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 921600)
              {
                if (j.hjx) {}
                for (i = 162;; i = 130)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i2 < 1024000)
              {
                if (j.hjx) {}
                for (i = 163;; i = 131)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (j.hjx) {}
              for (i = 164;; i = 132)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
              i = 0;
              break label452;
              i = 2;
              break label515;
              if (k < 204800)
              {
                if (j.hjx) {}
                for (i = 43;; i = 3)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 307200)
              {
                if (j.hjx) {}
                for (i = 44;; i = 4)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 409600)
              {
                if (j.hjx) {}
                for (i = 45;; i = 5)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 512000)
              {
                if (j.hjx) {}
                for (i = 46;; i = 6)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 614400)
              {
                if (j.hjx) {}
                for (i = 47;; i = 7)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 716800)
              {
                if (j.hjx) {}
                for (i = 48;; i = 8)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 819200)
              {
                if (j.hjx) {}
                for (i = 49;; i = 9)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 921600)
              {
                if (j.hjx) {}
                for (i = 50;; i = 10)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1024000)
              {
                if (j.hjx) {}
                for (i = 51;; i = 11)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1126400)
              {
                if (j.hjx) {}
                for (i = 52;; i = 12)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1228800)
              {
                if (j.hjx) {}
                for (i = 53;; i = 13)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1331200)
              {
                if (j.hjx) {}
                for (i = 54;; i = 14)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1433600)
              {
                if (j.hjx) {}
                for (i = 55;; i = 15)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (j.hjx) {}
              for (i = 56;; i = 16)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
              i = 82;
              break label579;
              if (l4 < 209715200L)
              {
                if (j.hjx) {}
                for (i = 114;; i = 83)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 314572800L)
              {
                if (j.hjx) {}
                for (i = 115;; i = 84)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 419430400L)
              {
                if (j.hjx) {}
                for (i = 116;; i = 85)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 524288000L)
              {
                if (j.hjx) {}
                for (i = 117;; i = 86)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 629145600L)
              {
                if (j.hjx) {}
                for (i = 118;; i = 87)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 734003200L)
              {
                if (j.hjx) {}
                for (i = 119;; i = 88)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 838860800L)
              {
                if (j.hjx) {}
                for (i = 120;; i = 89)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 943718400L)
              {
                if (j.hjx) {}
                for (i = 121;; i = 90)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 1048576000L)
              {
                if (j.hjx) {}
                for (i = 122;; i = 91)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 1572864000L)
              {
                if (j.hjx) {}
                for (i = 123;; i = 92)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (j.hjx) {}
              for (i = 124;; i = 93)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
            }
          }
        }
        if (!yO(l1)) {
          break label2778;
        }
        j = 1;
        if (!yP(l2)) {
          break label2783;
        }
        m = 2;
        if (!yQ(l3)) {
          break label2789;
        }
        n = 4;
        if (!yR(i2)) {
          break label2795;
        }
        i1 = 8;
        if (!yS(k)) {
          break label2801;
        }
      }
      for (k = 16;; k = 0)
      {
        l4 = bu.getLong((String)parama.map.get("summary.system"), -1L);
        long l5 = bu.getLong((String)parama.map.get("summary.graphics"), -1L);
        ae.d("MicroMsg.MemoryWatchDog.Reporter", "systemPss = %d, graphics = %d", new Object[] { Long.valueOf(l4), Long.valueOf(l5) });
        a(i1 | i | j | m | n | k, l1, l2, l3, i2, parama.xac, ((StringBuilder)localObject1).toString(), -1, l4, l5);
        wZI = true;
        AppMethodBeat.o(215446);
        return;
        j = 0;
        break;
        m = 0;
        break label2617;
        n = 0;
        break label2628;
        i1 = 0;
        break label2641;
      }
    }
  }
  
  public static void a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(215445);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(959);
    localIDKey1.SetValue(1L);
    label111:
    int i;
    if (parama.wZU - parama.wZV < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.wZS >= 104857600L) {
        break label985;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.wZQ >= 2097152) {
        break label1150;
      }
      localIDKey1.SetKey(142);
      label160:
      if (parama.wZQ >= 3858759.8F)
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
      e.ywz.b(localArrayList, false);
      a(parama);
      localArrayList = new ArrayList();
      if (!ak.coh()) {
        break label1276;
      }
      i = 10;
    }
    for (;;)
    {
      label289:
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i);
      localIDKey1.SetValue((parama.wZU - parama.wZV) / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 1);
      localIDKey1.SetValue(parama.wZS / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 2);
      localIDKey1.SetValue(1L);
      localArrayList.add(localIDKey1);
      e.ywz.b(localArrayList, false);
      label488:
      int j;
      label523:
      long l;
      if ((ak.isAppBrandProcess()) || (ak.foC()) || (ak.foD()))
      {
        ae.d("MicroMsg.MemoryWatchDog.Reporter", "reportPreloadProcessMemory: hasActivity = %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!ak.isAppBrandProcess()) {
          break label1306;
        }
        i = 1462;
        if (i > 0)
        {
          localArrayList = new ArrayList();
          localArrayList.add(new IDKey(i, 0, 1));
          if (!paramBoolean) {
            break label1337;
          }
          j = 1;
          localArrayList.add(new IDKey(i, j, 1));
          l = parama.wZU - parama.wZV;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 52428800L) {
            break label1348;
          }
          if (!paramBoolean) {
            break label1342;
          }
          j = 3;
          label586:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          l = parama.wZS;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 104857600L) {
            break label1684;
          }
          if (!paramBoolean) {
            break label1678;
          }
          j = 55;
          label643:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          if (!j.hjx)
          {
            localIDKey1 = new IDKey();
            localIDKey1.SetID(i);
            localIDKey1.SetValue(1L);
            l = parama.wZQ;
            if (l >= 1572864.0D) {
              break label1991;
            }
            if (!paramBoolean) {
              break label1985;
            }
            j = 111;
            label708:
            localIDKey1.SetKey(j);
            localArrayList.add(localIDKey1);
          }
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          i = parama.xab;
          if (i >= 102400) {
            break label2146;
          }
          if (!paramBoolean) {
            break label2139;
          }
        }
      }
      label985:
      label2139:
      for (i = 139;; i = 153)
      {
        localIDKey1.SetKey(i);
        localArrayList.add(localIDKey1);
        e.ywz.b(localArrayList, false);
        AppMethodBeat.o(215445);
        return;
        if (parama.wZU - parama.wZV < 209715200L)
        {
          localIDKey1.SetKey(121);
          break;
        }
        if (parama.wZU - parama.wZV < 314572800L)
        {
          localIDKey1.SetKey(122);
          break;
        }
        if (parama.wZU - parama.wZV < 419430400L)
        {
          localIDKey1.SetKey(123);
          break;
        }
        if (parama.wZU - parama.wZV < 524288000L)
        {
          localIDKey1.SetKey(124);
          break;
        }
        if (parama.wZU - parama.wZV < 629145600L)
        {
          localIDKey1.SetKey(125);
          break;
        }
        if (parama.wZU - parama.wZV < 734003200L)
        {
          localIDKey1.SetKey(126);
          break;
        }
        if (parama.wZU - parama.wZV < 838860800L)
        {
          localIDKey1.SetKey(127);
          break;
        }
        localIDKey1.SetKey(128);
        break;
        if (parama.wZS < 209715200L)
        {
          localIDKey1.SetKey(132);
          break label111;
        }
        if (parama.wZS < 314572800L)
        {
          localIDKey1.SetKey(133);
          break label111;
        }
        if (parama.wZS < 419430400L)
        {
          localIDKey1.SetKey(134);
          break label111;
        }
        if (parama.wZS < 524288000L)
        {
          localIDKey1.SetKey(135);
          break label111;
        }
        if (parama.wZS < 629145600L)
        {
          localIDKey1.SetKey(136);
          break label111;
        }
        if (parama.wZS < 734003200L)
        {
          localIDKey1.SetKey(137);
          break label111;
        }
        if (parama.wZS < 838860800L)
        {
          localIDKey1.SetKey(138);
          break label111;
        }
        localIDKey1.SetKey(139);
        break label111;
        label1150:
        if (parama.wZQ < 2516582.5F)
        {
          localIDKey1.SetKey(143);
          break label160;
        }
        if (parama.wZQ < 2936012.8F)
        {
          localIDKey1.SetKey(144);
          break label160;
        }
        if (parama.wZQ < 3145728.0F)
        {
          localIDKey1.SetKey(145);
          break label160;
        }
        if (parama.wZQ < 3565158.5F)
        {
          localIDKey1.SetKey(146);
          break label160;
        }
        if (parama.wZQ < 3984588.8F)
        {
          localIDKey1.SetKey(147);
          break label160;
        }
        localIDKey1.SetKey(148);
        break label160;
        label1276:
        if ((ak.foC()) || (ak.foD()))
        {
          i = 20;
          break label289;
        }
        if (!ak.isAppBrandProcess()) {
          break label2441;
        }
        i = 30;
        break label289;
        if (ak.foC())
        {
          i = 1463;
          break label488;
        }
        if (ak.foD())
        {
          i = 1464;
          break label488;
        }
        i = -1;
        break label488;
        j = 2;
        break label523;
        j = 16;
        break label586;
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
        break label643;
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
        break label708;
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
      label1306:
      label1337:
      label1342:
      label1348:
      label1991:
      label2146:
      if (i < 204800)
      {
        if (paramBoolean) {}
        for (i = 140;; i = 154)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      label1678:
      label1684:
      label1985:
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
      label2441:
      i = 0;
    }
  }
  
  public static void a(c.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(215447);
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if ((parama.xad != null) && (parama.xad.length > 0))
    {
      localStringBuilder.append("allProcess:");
      c.a[] arrayOfa = parama.xad;
      j = arrayOfa.length;
      i = 0;
      while (i < j)
      {
        c.a locala = arrayOfa[i];
        localStringBuilder.append(locala.pid).append("-").append(locala.processName).append("-pss:").append(locala.xab).append(";");
        i += 1;
      }
    }
    int j = -1;
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      j = k;
      if (k > 0)
      {
        localStringBuilder.append("loaded so:");
        int m = paramVarArgs.length;
        i = 0;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localStringBuilder.append(paramVarArgs[i]).append(";");
          i += 1;
        }
      }
    }
    a(32, parama.wZU - parama.wZV, parama.wZS, parama.wZQ, parama.xab, parama.xac, localStringBuilder.toString(), j, -2L, -2L);
    AppMethodBeat.o(215447);
  }
  
  private static boolean yO(long paramLong)
  {
    if (paramLong > 262144000L)
    {
      wZD += 1;
      return true;
    }
    return false;
  }
  
  private static boolean yP(long paramLong)
  {
    if (paramLong > 524288000L)
    {
      wZE += 1;
      return true;
    }
    return false;
  }
  
  private static boolean yQ(long paramLong)
  {
    if ((!j.hjx) && (paramLong > 3879731.2000000002D))
    {
      wZF += 1;
      return true;
    }
    return false;
  }
  
  private static boolean yR(long paramLong)
  {
    if (paramLong > 1024000L)
    {
      wZG += 1;
      return true;
    }
    return false;
  }
  
  private static boolean yS(long paramLong)
  {
    if (paramLong > 2097152L)
    {
      wZH += 1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.b
 * JD-Core Version:    0.7.0.1
 */