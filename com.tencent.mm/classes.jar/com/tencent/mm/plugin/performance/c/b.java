package com.tencent.mm.plugin.performance.c;

import android.app.ActivityManager.MemoryInfo;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import java.util.ArrayList;

public final class b
{
  private static int wJS = 0;
  private static int wJT = 0;
  private static int wJU = 0;
  private static int wJV = 0;
  private static int wJW = 0;
  private static boolean wJX = false;
  
  private static void a(c.a parama)
  {
    AppMethodBeat.i(211776);
    int i;
    if (aj.cmR()) {
      i = 1161;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(211776);
      return;
      if (aj.isAppBrandProcess()) {
        i = 1162;
      } else if (aj.fkI()) {
        i = 1163;
      } else if (aj.fkG()) {
        i = 1164;
      } else if (aj.fkJ()) {
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
    label235:
    long l2;
    label303:
    long l3;
    label380:
    int k;
    label444:
    label495:
    long l4;
    if (i.hgJ)
    {
      j = 254;
      ((IDKey)localObject2).SetKey(j);
      ((ArrayList)localObject1).add(localObject2);
      l1 = parama.wKj - parama.wKk;
      if (l1 > 262144000L) {
        wJS += 1;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l1 >= 104857600L) {
        break label833;
      }
      ((IDKey)localObject2).SetKey(1);
      ((ArrayList)localObject1).add(localObject2);
      l2 = parama.wKh;
      if (l2 > 524288000L) {
        wJT += 1;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l2 >= 104857600L) {
        break label1010;
      }
      ((IDKey)localObject2).SetKey(33);
      ((ArrayList)localObject1).add(localObject2);
      l3 = parama.wKf;
      if ((!i.hgJ) && (l3 > 3879731.2000000002D)) {
        wJU += 1;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (l3 >= 1572864.0D) {
        break label1191;
      }
      ((IDKey)localObject2).SetKey(65);
      ((ArrayList)localObject1).add(localObject2);
      k = parama.wKq;
      if (k > 1024000) {
        wJV += 1;
      }
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(i);
      ((IDKey)localObject2).SetValue(1L);
      if (k >= 102400) {
        break label1542;
      }
      if (!i.hgJ) {
        break label1536;
      }
      i = 154;
      ((IDKey)localObject2).SetKey(i);
      ((ArrayList)localObject1).add(localObject2);
      if (aj.cmR())
      {
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        if (!i.hgJ) {
          break label1851;
        }
        i = 1;
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        i = parama.wKr;
        if (i > 2097152) {
          wJW += 1;
        }
        if (i >= 102400) {
          break label1861;
        }
        if (!i.hgJ) {
          break label1856;
        }
        i = 42;
        label566:
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(1308);
        ((IDKey)localObject2).SetValue(1L);
        l4 = parama.wKp.availMem;
        if (l4 >= 104857600L) {
          break label2278;
        }
        if (!i.hgJ) {
          break label2272;
        }
        i = 113;
        label630:
        ((IDKey)localObject2).SetKey(i);
        ((ArrayList)localObject1).add(localObject2);
      }
      e.ygI.b((ArrayList)localObject1, false);
      j = 0;
      if (wJS >= 3) {
        j = 1;
      }
      i = j;
      if (wJT >= 3) {
        i = j | 0x2;
      }
      j = i;
      if (wJU >= 3) {
        j = i | 0x4;
      }
      i = j;
      if (wJV >= 3) {
        i = j | 0x8;
      }
      if (wJW < 3) {
        break label2665;
      }
      i |= 0x10;
    }
    label833:
    label1861:
    label2272:
    label2278:
    label2665:
    for (;;)
    {
      if ((i != 0) && (!wJX))
      {
        localObject1 = new StringBuilder();
        if ((i & 0x10) == 16)
        {
          ((StringBuilder)localObject1).append("allProcess:");
          localObject2 = parama.wKs;
          int m = localObject2.length;
          j = 0;
          for (;;)
          {
            if (j < m)
            {
              Object localObject3 = localObject2[j];
              ((StringBuilder)localObject1).append(localObject3.pid).append("-").append(localObject3.processName).append("-pss:").append(localObject3.wKq).append(";");
              j += 1;
              continue;
              j = 255;
              break;
              if (l1 < 209715200L)
              {
                ((IDKey)localObject2).SetKey(2);
                break label235;
              }
              if (l1 < 314572800L)
              {
                ((IDKey)localObject2).SetKey(3);
                break label235;
              }
              if (l1 < 419430400L)
              {
                ((IDKey)localObject2).SetKey(4);
                break label235;
              }
              if (l1 < 524288000L)
              {
                ((IDKey)localObject2).SetKey(5);
                break label235;
              }
              if (l1 < 629145600L)
              {
                ((IDKey)localObject2).SetKey(6);
                break label235;
              }
              if (l1 < 734003200L)
              {
                ((IDKey)localObject2).SetKey(7);
                break label235;
              }
              if (l1 < 838860800L)
              {
                ((IDKey)localObject2).SetKey(8);
                break label235;
              }
              if (l1 < 943718400L)
              {
                ((IDKey)localObject2).SetKey(9);
                break label235;
              }
              if (l1 < 1048576000L)
              {
                ((IDKey)localObject2).SetKey(10);
                break label235;
              }
              ((IDKey)localObject2).SetKey(11);
              break label235;
              label1010:
              if (l2 < 209715200L)
              {
                ((IDKey)localObject2).SetKey(34);
                break label303;
              }
              if (l2 < 314572800L)
              {
                ((IDKey)localObject2).SetKey(35);
                break label303;
              }
              if (l2 < 419430400L)
              {
                ((IDKey)localObject2).SetKey(36);
                break label303;
              }
              if (l2 < 524288000L)
              {
                ((IDKey)localObject2).SetKey(37);
                break label303;
              }
              if (l2 < 629145600L)
              {
                ((IDKey)localObject2).SetKey(38);
                break label303;
              }
              if (l2 < 734003200L)
              {
                ((IDKey)localObject2).SetKey(39);
                break label303;
              }
              if (l2 < 838860800L)
              {
                ((IDKey)localObject2).SetKey(40);
                break label303;
              }
              if (l2 < 943718400L)
              {
                ((IDKey)localObject2).SetKey(41);
                break label303;
              }
              if (l2 < 1048576000L)
              {
                ((IDKey)localObject2).SetKey(42);
                break label303;
              }
              ((IDKey)localObject2).SetKey(43);
              break label303;
              if (l3 < 2097152L)
              {
                ((IDKey)localObject2).SetKey(66);
                break label380;
              }
              if (l3 < 2621440.0D)
              {
                ((IDKey)localObject2).SetKey(67);
                break label380;
              }
              if (l3 < 3145728L)
              {
                ((IDKey)localObject2).SetKey(68);
                break label380;
              }
              if (l3 < 3670016.0D)
              {
                ((IDKey)localObject2).SetKey(69);
                break label380;
              }
              if (l3 < 4194304L)
              {
                ((IDKey)localObject2).SetKey(70);
                break label380;
              }
              if (l3 < 4718592.0D)
              {
                ((IDKey)localObject2).SetKey(71);
                break label380;
              }
              if (l3 < 5242880L)
              {
                ((IDKey)localObject2).SetKey(72);
                break label380;
              }
              if (l3 < 5767168.0D)
              {
                ((IDKey)localObject2).SetKey(73);
                break label380;
              }
              if (l3 < 6291456.0D)
              {
                ((IDKey)localObject2).SetKey(74);
                break label380;
              }
              if (l3 < 6815744.0D)
              {
                ((IDKey)localObject2).SetKey(75);
                break label380;
              }
              if (l3 < 7340032.0D)
              {
                ((IDKey)localObject2).SetKey(76);
                break label380;
              }
              if (l3 < 7864320.0D)
              {
                ((IDKey)localObject2).SetKey(77);
                break label380;
              }
              if (l3 < 8388608.0D)
              {
                ((IDKey)localObject2).SetKey(78);
                break label380;
              }
              if (l3 < 8912896.0D)
              {
                ((IDKey)localObject2).SetKey(79);
                break label380;
              }
              if (l3 < 9437184.0D)
              {
                ((IDKey)localObject2).SetKey(80);
                break label380;
              }
              if (l3 < 9961472.0D)
              {
                ((IDKey)localObject2).SetKey(81);
                break label380;
              }
              if (l3 < 10485760L)
              {
                ((IDKey)localObject2).SetKey(82);
                break label380;
              }
              ((IDKey)localObject2).SetKey(83);
              break label380;
              i = 122;
              break label444;
              if (k < 204800)
              {
                if (i.hgJ) {}
                for (i = 155;; i = 123)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 307200)
              {
                if (i.hgJ) {}
                for (i = 156;; i = 124)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 409600)
              {
                if (i.hgJ) {}
                for (i = 157;; i = 125)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 512000)
              {
                if (i.hgJ) {}
                for (i = 158;; i = 126)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 614400)
              {
                if (i.hgJ) {}
                for (i = 159;; i = 127)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 716800)
              {
                if (i.hgJ) {}
                for (i = 160;; i = 128)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 819200)
              {
                if (i.hgJ) {}
                for (i = 161;; i = 129)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 921600)
              {
                if (i.hgJ) {}
                for (i = 162;; i = 130)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (k < 1024000)
              {
                if (i.hgJ) {}
                for (i = 163;; i = 131)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i.hgJ) {}
              for (i = 164;; i = 132)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
              i = 0;
              break label495;
              i = 2;
              break label566;
              if (i < 204800)
              {
                if (i.hgJ) {}
                for (i = 43;; i = 3)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 307200)
              {
                if (i.hgJ) {}
                for (i = 44;; i = 4)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 409600)
              {
                if (i.hgJ) {}
                for (i = 45;; i = 5)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 512000)
              {
                if (i.hgJ) {}
                for (i = 46;; i = 6)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 614400)
              {
                if (i.hgJ) {}
                for (i = 47;; i = 7)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 716800)
              {
                if (i.hgJ) {}
                for (i = 48;; i = 8)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 819200)
              {
                if (i.hgJ) {}
                for (i = 49;; i = 9)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 921600)
              {
                if (i.hgJ) {}
                for (i = 50;; i = 10)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 1024000)
              {
                if (i.hgJ) {}
                for (i = 51;; i = 11)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 1126400)
              {
                if (i.hgJ) {}
                for (i = 52;; i = 12)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 1228800)
              {
                if (i.hgJ) {}
                for (i = 53;; i = 13)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 1331200)
              {
                if (i.hgJ) {}
                for (i = 54;; i = 14)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i < 1433600)
              {
                if (i.hgJ) {}
                for (i = 55;; i = 15)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i.hgJ) {}
              for (i = 56;; i = 16)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
              i = 82;
              break label630;
              if (l4 < 209715200L)
              {
                if (i.hgJ) {}
                for (i = 114;; i = 83)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 314572800L)
              {
                if (i.hgJ) {}
                for (i = 115;; i = 84)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 419430400L)
              {
                if (i.hgJ) {}
                for (i = 116;; i = 85)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 524288000L)
              {
                if (i.hgJ) {}
                for (i = 117;; i = 86)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 629145600L)
              {
                if (i.hgJ) {}
                for (i = 118;; i = 87)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 734003200L)
              {
                if (i.hgJ) {}
                for (i = 119;; i = 88)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 838860800L)
              {
                if (i.hgJ) {}
                for (i = 120;; i = 89)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 943718400L)
              {
                if (i.hgJ) {}
                for (i = 121;; i = 90)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 1048576000L)
              {
                if (i.hgJ) {}
                for (i = 122;; i = 91)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (l4 < 1572864000L)
              {
                if (i.hgJ) {}
                for (i = 123;; i = 92)
                {
                  ((IDKey)localObject2).SetKey(i);
                  break;
                }
              }
              if (i.hgJ) {}
              for (i = 124;; i = 93)
              {
                ((IDKey)localObject2).SetKey(i);
                break;
              }
            }
          }
        }
        c(i, l1, l2, l3, k, parama.wKr, ((StringBuilder)localObject1).toString(), -1);
        wJX = true;
      }
      AppMethodBeat.o(211776);
      return;
    }
  }
  
  public static void a(c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(211775);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(959);
    localIDKey1.SetValue(1L);
    label110:
    int i;
    if (parama.wKj - parama.wKk < 104857600L)
    {
      localIDKey1.SetKey(120);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.wKh >= 104857600L) {
        break label979;
      }
      localIDKey1.SetKey(131);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(959);
      localIDKey1.SetValue(1L);
      if (parama.wKf >= 2097152) {
        break label1144;
      }
      localIDKey1.SetKey(142);
      label158:
      if (parama.wKf >= 3858759.8F)
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
      e.ygI.b(localArrayList, false);
      a(parama);
      localArrayList = new ArrayList();
      if (!aj.cmR()) {
        break label1270;
      }
      i = 10;
    }
    for (;;)
    {
      label286:
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i);
      localIDKey1.SetValue((parama.wKj - parama.wKk) / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 1);
      localIDKey1.SetValue(parama.wKh / 1024L / 1024L);
      localArrayList.add(localIDKey1);
      localIDKey1 = new IDKey();
      localIDKey1.SetID(1031);
      localIDKey1.SetKey(i + 2);
      localIDKey1.SetValue(1L);
      localArrayList.add(localIDKey1);
      e.ygI.b(localArrayList, false);
      label483:
      int j;
      label518:
      long l;
      if ((aj.isAppBrandProcess()) || (aj.fkI()) || (aj.fkJ()))
      {
        ad.d("MicroMsg.MemoryWatchDog.Reporter", "reportPreloadProcessMemory: hasActivity = %s", new Object[] { Boolean.valueOf(paramBoolean) });
        if (!aj.isAppBrandProcess()) {
          break label1300;
        }
        i = 1462;
        if (i > 0)
        {
          localArrayList = new ArrayList();
          localArrayList.add(new IDKey(i, 0, 1));
          if (!paramBoolean) {
            break label1331;
          }
          j = 1;
          localArrayList.add(new IDKey(i, j, 1));
          l = parama.wKj - parama.wKk;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 52428800L) {
            break label1342;
          }
          if (!paramBoolean) {
            break label1336;
          }
          j = 3;
          label581:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          l = parama.wKh;
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          if (l >= 104857600L) {
            break label1678;
          }
          if (!paramBoolean) {
            break label1672;
          }
          j = 55;
          label638:
          localIDKey1.SetKey(j);
          localArrayList.add(localIDKey1);
          if (!i.hgJ)
          {
            localIDKey1 = new IDKey();
            localIDKey1.SetID(i);
            localIDKey1.SetValue(1L);
            l = parama.wKf;
            if (l >= 1572864.0D) {
              break label1985;
            }
            if (!paramBoolean) {
              break label1979;
            }
            j = 111;
            label703:
            localIDKey1.SetKey(j);
            localArrayList.add(localIDKey1);
          }
          localIDKey1 = new IDKey();
          localIDKey1.SetID(i);
          localIDKey1.SetValue(1L);
          i = parama.wKq;
          if (i >= 102400) {
            break label2140;
          }
          if (!paramBoolean) {
            break label2133;
          }
        }
      }
      label979:
      label2133:
      for (i = 139;; i = 153)
      {
        localIDKey1.SetKey(i);
        localArrayList.add(localIDKey1);
        e.ygI.b(localArrayList, false);
        AppMethodBeat.o(211775);
        return;
        if (parama.wKj - parama.wKk < 209715200L)
        {
          localIDKey1.SetKey(121);
          break;
        }
        if (parama.wKj - parama.wKk < 314572800L)
        {
          localIDKey1.SetKey(122);
          break;
        }
        if (parama.wKj - parama.wKk < 419430400L)
        {
          localIDKey1.SetKey(123);
          break;
        }
        if (parama.wKj - parama.wKk < 524288000L)
        {
          localIDKey1.SetKey(124);
          break;
        }
        if (parama.wKj - parama.wKk < 629145600L)
        {
          localIDKey1.SetKey(125);
          break;
        }
        if (parama.wKj - parama.wKk < 734003200L)
        {
          localIDKey1.SetKey(126);
          break;
        }
        if (parama.wKj - parama.wKk < 838860800L)
        {
          localIDKey1.SetKey(127);
          break;
        }
        localIDKey1.SetKey(128);
        break;
        if (parama.wKh < 209715200L)
        {
          localIDKey1.SetKey(132);
          break label110;
        }
        if (parama.wKh < 314572800L)
        {
          localIDKey1.SetKey(133);
          break label110;
        }
        if (parama.wKh < 419430400L)
        {
          localIDKey1.SetKey(134);
          break label110;
        }
        if (parama.wKh < 524288000L)
        {
          localIDKey1.SetKey(135);
          break label110;
        }
        if (parama.wKh < 629145600L)
        {
          localIDKey1.SetKey(136);
          break label110;
        }
        if (parama.wKh < 734003200L)
        {
          localIDKey1.SetKey(137);
          break label110;
        }
        if (parama.wKh < 838860800L)
        {
          localIDKey1.SetKey(138);
          break label110;
        }
        localIDKey1.SetKey(139);
        break label110;
        label1144:
        if (parama.wKf < 2516582.5F)
        {
          localIDKey1.SetKey(143);
          break label158;
        }
        if (parama.wKf < 2936012.8F)
        {
          localIDKey1.SetKey(144);
          break label158;
        }
        if (parama.wKf < 3145728.0F)
        {
          localIDKey1.SetKey(145);
          break label158;
        }
        if (parama.wKf < 3565158.5F)
        {
          localIDKey1.SetKey(146);
          break label158;
        }
        if (parama.wKf < 3984588.8F)
        {
          localIDKey1.SetKey(147);
          break label158;
        }
        localIDKey1.SetKey(148);
        break label158;
        label1270:
        if ((aj.fkI()) || (aj.fkJ()))
        {
          i = 20;
          break label286;
        }
        if (!aj.isAppBrandProcess()) {
          break label2434;
        }
        i = 30;
        break label286;
        if (aj.fkI())
        {
          i = 1463;
          break label483;
        }
        if (aj.fkJ())
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
      label1300:
      label1331:
      label1336:
      label1342:
      label1985:
      label2140:
      if (i < 204800)
      {
        if (paramBoolean) {}
        for (i = 140;; i = 154)
        {
          localIDKey1.SetKey(i);
          break;
        }
      }
      label1672:
      label1678:
      label1979:
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
      label2434:
      i = 0;
    }
  }
  
  public static void a(c.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(211777);
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if ((parama.wKs != null) && (parama.wKs.length > 0))
    {
      localStringBuilder.append("allProcess:");
      c.a[] arrayOfa = parama.wKs;
      j = arrayOfa.length;
      i = 0;
      while (i < j)
      {
        c.a locala = arrayOfa[i];
        localStringBuilder.append(locala.pid).append("-").append(locala.processName).append("-pss:").append(locala.wKq).append(";");
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
    c(32, parama.wKj - parama.wKk, parama.wKh, parama.wKf, parama.wKq, parama.wKr, localStringBuilder.toString(), j);
    AppMethodBeat.o(211777);
  }
  
  private static void c(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
  {
    AppMethodBeat.i(211778);
    e.ygI.f(20731, new Object[] { Integer.valueOf(paramInt1), aj.getProcessName(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(211778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.b
 * JD-Core Version:    0.7.0.1
 */