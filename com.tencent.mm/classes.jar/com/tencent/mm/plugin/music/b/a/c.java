package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c
  implements d
{
  private static volatile int oXB;
  private static volatile int oXC;
  private static volatile int oXD;
  private static volatile int oXE;
  private static volatile int oXF;
  private static volatile int oXG;
  private static volatile int oXH;
  private static volatile HashMap<String, Integer> oXI;
  private static volatile HashMap<String, Integer> oXJ;
  private static volatile HashMap<String, a> oXK;
  private static volatile HashMap<String, List<Long>> oXL;
  private static volatile HashMap<String, List<Long>> oXM;
  private static volatile HashMap<String, List<Long>> oXN;
  
  static
  {
    AppMethodBeat.i(104835);
    oXB = 0;
    oXC = 0;
    oXD = 0;
    oXE = 0;
    oXF = 0;
    oXG = 0;
    oXH = 0;
    oXI = new HashMap();
    oXJ = new HashMap();
    oXK = new HashMap();
    oXL = new HashMap();
    oXM = new HashMap();
    oXN = new HashMap();
    AppMethodBeat.o(104835);
  }
  
  public static void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4, long paramLong5, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(104831);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(971);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localIDKey1 = new IDKey();
    localIDKey1.SetID(971);
    localIDKey1.SetValue(1L);
    localArrayList.add(localIDKey1);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(971);
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey2);
    IDKey localIDKey3 = new IDKey();
    localIDKey3.SetID(971);
    localIDKey3.SetValue(1L);
    localArrayList.add(localIDKey3);
    IDKey localIDKey4 = new IDKey();
    localIDKey4.SetID(971);
    localIDKey4.SetValue(1L);
    localArrayList.add(localIDKey4);
    IDKey localIDKey5 = new IDKey();
    localIDKey5.SetID(971);
    localIDKey5.SetValue(1L);
    localArrayList.add(localIDKey5);
    IDKey localIDKey6 = new IDKey();
    localIDKey6.SetID(971);
    localIDKey6.SetValue(1L);
    localArrayList.add(localIDKey6);
    IDKey localIDKey7 = new IDKey();
    localIDKey7.SetID(971);
    localIDKey7.SetValue(1L);
    localArrayList.add(localIDKey7);
    IDKey localIDKey8 = new IDKey();
    IDKey localIDKey9 = new IDKey();
    if (paramInt2 > 0)
    {
      localIDKey8.SetID(971);
      localIDKey8.SetValue(1L);
      localArrayList.add(localIDKey8);
      localIDKey9.SetID(971);
      localIDKey9.SetValue(1L);
      localArrayList.add(localIDKey9);
    }
    IDKey localIDKey10 = new IDKey();
    IDKey localIDKey11 = new IDKey();
    if (paramInt3 > 0)
    {
      localIDKey10.SetID(971);
      localIDKey10.SetValue(1L);
      localArrayList.add(localIDKey10);
      localIDKey11.SetID(971);
      localIDKey11.SetValue(1L);
      localArrayList.add(localIDKey11);
    }
    if (paramInt1 == 0)
    {
      localIDKey1.SetKey(1);
      localIDKey2.SetKey(2);
      if ((0L <= paramLong1) && (paramLong1 <= 3L))
      {
        paramInt1 = 3;
        localIDKey3.SetKey(paramInt1);
        localIDKey4.SetKey(11);
        if ((0L > paramLong2) || (paramLong2 > 6L)) {
          break label858;
        }
        paramInt1 = 12;
        label464:
        localIDKey5.SetKey(paramInt1);
        localIDKey6.SetKey(22);
        if ((0L > paramLong3) || (paramLong3 > 20L)) {
          break label996;
        }
        paramInt1 = 23;
        label496:
        localIDKey7.SetKey(paramInt1);
        if (paramInt2 > 0)
        {
          localIDKey8.SetKey(41);
          if (paramInt2 != 0) {
            break label1338;
          }
          paramInt1 = 42;
          label522:
          localIDKey9.SetKey(paramInt1);
        }
        if (paramInt3 > 0)
        {
          localIDKey10.SetKey(124);
          if (paramInt3 != 0) {
            break label1500;
          }
          paramInt1 = 125;
          label548:
          localIDKey11.SetKey(paramInt1);
        }
        label554:
        if (paramInt4 > 0)
        {
          localIDKey1 = new IDKey();
          localIDKey1.SetID(971);
          localIDKey1.SetValue(1L);
          localIDKey1.SetKey(181);
          localArrayList.add(localIDKey1);
          localIDKey1 = new IDKey();
          localIDKey1.SetID(971);
          localIDKey1.SetValue(1L);
          if ((paramInt4 <= 0) || (paramInt4 > 3)) {
            break label3327;
          }
          paramInt1 = 182;
          label636:
          localIDKey1.SetKey(paramInt1);
          localArrayList.add(localIDKey1);
        }
        if (paramInt5 > 0)
        {
          localIDKey1 = new IDKey();
          localIDKey2 = new IDKey();
          localIDKey1.SetID(971);
          localIDKey1.SetValue(1L);
          localIDKey1.SetKey(193);
          localArrayList.add(localIDKey1);
          localIDKey2.SetID(971);
          localIDKey2.SetValue(1L);
          if ((paramInt5 <= 0) || (paramInt5 > 3)) {
            break label3480;
          }
          paramInt1 = 194;
        }
      }
    }
    for (;;)
    {
      localIDKey2.SetKey(paramInt1);
      localArrayList.add(localIDKey2);
      h.qsU.b(localArrayList, true);
      a.r(localArrayList);
      AppMethodBeat.o(104831);
      return;
      if ((3L < paramLong1) && (paramLong1 <= 6L))
      {
        paramInt1 = 4;
        break;
      }
      if ((6L < paramLong1) && (paramLong1 <= 10L))
      {
        paramInt1 = 5;
        break;
      }
      if ((10L < paramLong1) && (paramLong1 <= 15L))
      {
        paramInt1 = 6;
        break;
      }
      if ((15L < paramLong1) && (paramLong1 <= 20L))
      {
        paramInt1 = 7;
        break;
      }
      paramInt1 = 8;
      break;
      label858:
      if ((6L < paramLong2) && (paramLong2 <= 10L))
      {
        paramInt1 = 13;
        break label464;
      }
      if ((10L < paramLong2) && (paramLong2 <= 15L))
      {
        paramInt1 = 14;
        break label464;
      }
      if ((15L < paramLong2) && (paramLong2 <= 20L))
      {
        paramInt1 = 15;
        break label464;
      }
      if ((20L < paramLong2) && (paramLong2 <= 30L))
      {
        paramInt1 = 16;
        break label464;
      }
      if ((30L < paramLong2) && (paramLong2 <= 40L))
      {
        paramInt1 = 17;
        break label464;
      }
      if ((40L < paramLong2) && (paramLong2 <= 50L))
      {
        paramInt1 = 18;
        break label464;
      }
      paramInt1 = 19;
      break label464;
      label996:
      if ((20L < paramLong3) && (paramLong3 <= 30L))
      {
        paramInt1 = 24;
        break label496;
      }
      if ((30L < paramLong3) && (paramLong3 <= 40L))
      {
        paramInt1 = 25;
        break label496;
      }
      if ((40L < paramLong3) && (paramLong3 <= 50L))
      {
        paramInt1 = 26;
        break label496;
      }
      if ((50L < paramLong3) && (paramLong3 <= 60L))
      {
        paramInt1 = 27;
        break label496;
      }
      if ((60L < paramLong3) && (paramLong3 <= 70L))
      {
        paramInt1 = 28;
        break label496;
      }
      if ((70L < paramLong3) && (paramLong3 <= 80L))
      {
        paramInt1 = 29;
        break label496;
      }
      if ((80L < paramLong3) && (paramLong3 <= 90L))
      {
        paramInt1 = 30;
        break label496;
      }
      if ((90L < paramLong3) && (paramLong3 <= 100L))
      {
        paramInt1 = 31;
        break label496;
      }
      if ((100L < paramLong3) && (paramLong3 <= 110L))
      {
        paramInt1 = 32;
        break label496;
      }
      if ((110L < paramLong3) && (paramLong3 <= 120L))
      {
        paramInt1 = 33;
        break label496;
      }
      if ((120L < paramLong3) && (paramLong3 <= 130L))
      {
        paramInt1 = 34;
        break label496;
      }
      if ((130L < paramLong3) && (paramLong3 <= 140L))
      {
        paramInt1 = 35;
        break label496;
      }
      if ((140L < paramLong3) && (paramLong3 <= 150L))
      {
        paramInt1 = 36;
        break label496;
      }
      if ((150L < paramLong3) && (paramLong3 <= 200L))
      {
        paramInt1 = 37;
        break label496;
      }
      paramInt1 = 38;
      break label496;
      label1338:
      if ((paramInt2 > 0) && (paramInt2 <= 3))
      {
        paramInt1 = 43;
        break label522;
      }
      if ((4 <= paramInt2) && (paramInt2 <= 6))
      {
        paramInt1 = 44;
        break label522;
      }
      if ((7 <= paramInt2) && (paramInt2 <= 10))
      {
        paramInt1 = 45;
        break label522;
      }
      if ((11 <= paramInt2) && (paramInt2 <= 15))
      {
        paramInt1 = 46;
        break label522;
      }
      if ((15 < paramInt2) && (paramInt2 <= 20))
      {
        paramInt1 = 47;
        break label522;
      }
      if ((20 < paramInt2) && (paramInt2 <= 40))
      {
        paramInt1 = 48;
        break label522;
      }
      if ((40 < paramInt2) && (paramInt2 <= 60))
      {
        paramInt1 = 49;
        break label522;
      }
      if ((60 < paramInt2) && (paramInt2 <= 100))
      {
        paramInt1 = 50;
        break label522;
      }
      paramInt1 = 51;
      break label522;
      label1500:
      if ((paramInt3 >= 0) && (paramInt3 <= 10))
      {
        paramInt1 = 126;
        break label548;
      }
      if ((10 <= paramInt3) && (paramInt3 <= 20))
      {
        paramInt1 = 127;
        break label548;
      }
      if ((20 <= paramInt3) && (paramInt3 <= 40))
      {
        paramInt1 = 128;
        break label548;
      }
      if ((40 <= paramInt3) && (paramInt3 <= 60))
      {
        paramInt1 = 129;
        break label548;
      }
      if ((60 < paramInt3) && (paramInt3 <= 100))
      {
        paramInt1 = 130;
        break label548;
      }
      if ((100 < paramInt3) && (paramInt3 <= 150))
      {
        paramInt1 = 131;
        break label548;
      }
      if ((150 < paramInt3) && (paramInt3 <= 200))
      {
        paramInt1 = 132;
        break label548;
      }
      if ((200 < paramInt3) && (paramInt3 <= 500))
      {
        paramInt1 = 133;
        break label548;
      }
      paramInt1 = 134;
      break label548;
      localIDKey1.SetKey(59);
      localIDKey2.SetKey(60);
      if ((0L < paramLong1) && (paramLong1 <= 3L))
      {
        paramInt1 = 61;
        label1707:
        localIDKey3.SetKey(paramInt1);
        localIDKey4.SetKey(69);
        if ((0L > paramLong2) || (paramLong2 > 6L)) {
          break label2093;
        }
        paramInt1 = 70;
        label1737:
        localIDKey5.SetKey(paramInt1);
        localIDKey6.SetKey(80);
        if ((0L > paramLong3) || (paramLong3 > 20L)) {
          break label2231;
        }
        paramInt1 = 81;
        label1769:
        localIDKey7.SetKey(paramInt1);
        if (paramInt2 > 0)
        {
          localIDKey8.SetKey(98);
          if (paramInt2 != 0) {
            break label2573;
          }
          paramInt1 = 99;
          label1795:
          localIDKey9.SetKey(paramInt1);
        }
        if (paramInt3 > 0)
        {
          localIDKey10.SetKey(139);
          if (paramInt3 != 0) {
            break label2735;
          }
          paramInt1 = 140;
          label1823:
          localIDKey11.SetKey(paramInt1);
        }
        if ((paramLong4 <= 0L) || (paramLong5 <= 0L)) {
          break label554;
        }
        localIDKey1 = new IDKey();
        localIDKey1.SetID(971);
        localIDKey1.SetValue(1L);
        localIDKey1.SetKey(153);
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(971);
        localIDKey1.SetValue(1L);
        if ((0L > paramLong4) || (paramLong4 > 10485760L)) {
          break label2913;
        }
        paramInt1 = 154;
        label1925:
        localIDKey1.SetKey(paramInt1);
        localArrayList.add(localIDKey1);
        localIDKey1 = new IDKey();
        localIDKey1.SetID(971);
        localIDKey1.SetValue(1L);
        if ((0L > paramLong5) || (paramLong5 > 10485760L)) {
          break label3120;
        }
        paramInt1 = 169;
      }
      for (;;)
      {
        localIDKey1.SetKey(paramInt1);
        localArrayList.add(localIDKey1);
        break;
        if ((3L < paramLong1) && (paramLong1 <= 6L))
        {
          paramInt1 = 62;
          break label1707;
        }
        if ((6L < paramLong1) && (paramLong1 <= 10L))
        {
          paramInt1 = 63;
          break label1707;
        }
        if ((10L < paramLong1) && (paramLong1 <= 15L))
        {
          paramInt1 = 64;
          break label1707;
        }
        if ((15L < paramLong1) && (paramLong1 <= 20L))
        {
          paramInt1 = 65;
          break label1707;
        }
        paramInt1 = 66;
        break label1707;
        label2093:
        if ((6L < paramLong2) && (paramLong2 <= 10L))
        {
          paramInt1 = 71;
          break label1737;
        }
        if ((10L < paramLong2) && (paramLong2 <= 15L))
        {
          paramInt1 = 72;
          break label1737;
        }
        if ((15L < paramLong2) && (paramLong2 <= 20L))
        {
          paramInt1 = 73;
          break label1737;
        }
        if ((20L < paramLong2) && (paramLong2 <= 30L))
        {
          paramInt1 = 74;
          break label1737;
        }
        if ((30L < paramLong2) && (paramLong2 <= 40L))
        {
          paramInt1 = 75;
          break label1737;
        }
        if ((40L < paramLong2) && (paramLong2 <= 50L))
        {
          paramInt1 = 76;
          break label1737;
        }
        paramInt1 = 77;
        break label1737;
        label2231:
        if ((20L < paramLong3) && (paramLong3 <= 30L))
        {
          paramInt1 = 82;
          break label1769;
        }
        if ((30L < paramLong3) && (paramLong3 <= 40L))
        {
          paramInt1 = 83;
          break label1769;
        }
        if ((40L < paramLong3) && (paramLong3 <= 50L))
        {
          paramInt1 = 84;
          break label1769;
        }
        if ((50L < paramLong3) && (paramLong3 <= 60L))
        {
          paramInt1 = 85;
          break label1769;
        }
        if ((60L < paramLong3) && (paramLong3 <= 70L))
        {
          paramInt1 = 86;
          break label1769;
        }
        if ((70L < paramLong3) && (paramLong3 <= 80L))
        {
          paramInt1 = 87;
          break label1769;
        }
        if ((80L < paramLong3) && (paramLong3 <= 90L))
        {
          paramInt1 = 88;
          break label1769;
        }
        if ((90L < paramLong3) && (paramLong3 <= 100L))
        {
          paramInt1 = 89;
          break label1769;
        }
        if ((100L < paramLong3) && (paramLong3 <= 110L))
        {
          paramInt1 = 90;
          break label1769;
        }
        if ((110L < paramLong3) && (paramLong3 <= 120L))
        {
          paramInt1 = 91;
          break label1769;
        }
        if ((120L < paramLong3) && (paramLong3 <= 130L))
        {
          paramInt1 = 92;
          break label1769;
        }
        if ((130L < paramLong3) && (paramLong3 <= 140L))
        {
          paramInt1 = 93;
          break label1769;
        }
        if ((140L < paramLong3) && (paramLong3 <= 150L))
        {
          paramInt1 = 94;
          break label1769;
        }
        if ((150L < paramLong3) && (paramLong3 <= 200L))
        {
          paramInt1 = 95;
          break label1769;
        }
        paramInt1 = 96;
        break label1769;
        label2573:
        if ((paramInt2 > 0) && (paramInt2 <= 3))
        {
          paramInt1 = 100;
          break label1795;
        }
        if ((4 <= paramInt2) && (paramInt2 <= 6))
        {
          paramInt1 = 101;
          break label1795;
        }
        if ((7 <= paramInt2) && (paramInt2 <= 10))
        {
          paramInt1 = 102;
          break label1795;
        }
        if ((11 <= paramInt2) && (paramInt2 <= 15))
        {
          paramInt1 = 103;
          break label1795;
        }
        if ((15 < paramInt2) && (paramInt2 <= 20))
        {
          paramInt1 = 104;
          break label1795;
        }
        if ((20 < paramInt2) && (paramInt2 <= 40))
        {
          paramInt1 = 105;
          break label1795;
        }
        if ((40 < paramInt2) && (paramInt2 <= 60))
        {
          paramInt1 = 106;
          break label1795;
        }
        if ((60 < paramInt2) && (paramInt2 <= 100))
        {
          paramInt1 = 107;
          break label1795;
        }
        paramInt1 = 108;
        break label1795;
        label2735:
        if ((paramInt3 >= 0) && (paramInt3 <= 10))
        {
          paramInt1 = 141;
          break label1823;
        }
        if ((10 <= paramInt3) && (paramInt3 <= 20))
        {
          paramInt1 = 142;
          break label1823;
        }
        if ((20 <= paramInt3) && (paramInt3 <= 40))
        {
          paramInt1 = 143;
          break label1823;
        }
        if ((40 <= paramInt3) && (paramInt3 <= 60))
        {
          paramInt1 = 144;
          break label1823;
        }
        if ((60 < paramInt3) && (paramInt3 <= 100))
        {
          paramInt1 = 145;
          break label1823;
        }
        if ((100 < paramInt3) && (paramInt3 <= 150))
        {
          paramInt1 = 146;
          break label1823;
        }
        if ((150 < paramInt3) && (paramInt3 <= 200))
        {
          paramInt1 = 147;
          break label1823;
        }
        if ((200 < paramInt3) && (paramInt3 <= 500))
        {
          paramInt1 = 148;
          break label1823;
        }
        paramInt1 = 149;
        break label1823;
        label2913:
        if ((10485760L < paramLong4) && (paramLong4 <= 20971520L))
        {
          paramInt1 = 155;
          break label1925;
        }
        if ((20971520L < paramLong4) && (paramLong4 <= 31457280L))
        {
          paramInt1 = 156;
          break label1925;
        }
        if ((31457280L < paramLong4) && (paramLong4 <= 41943040L))
        {
          paramInt1 = 157;
          break label1925;
        }
        if ((41943040L < paramLong4) && (paramLong4 <= 52428800L))
        {
          paramInt1 = 158;
          break label1925;
        }
        if ((52428800L < paramLong4) && (paramLong4 <= 62914560L))
        {
          paramInt1 = 159;
          break label1925;
        }
        if ((62914560L < paramLong4) && (paramLong4 <= 73400320L))
        {
          paramInt1 = 160;
          break label1925;
        }
        if ((73400320L < paramLong4) && (paramLong4 <= 94371840L))
        {
          paramInt1 = 161;
          break label1925;
        }
        if ((94371840L < paramLong4) && (paramLong4 <= 115343360L))
        {
          paramInt1 = 162;
          break label1925;
        }
        paramInt1 = 163;
        break label1925;
        label3120:
        if ((10485760L < paramLong5) && (paramLong5 <= 20971520L)) {
          paramInt1 = 170;
        } else if ((20971520L < paramLong5) && (paramLong5 <= 31457280L)) {
          paramInt1 = 171;
        } else if ((31457280L < paramLong5) && (paramLong5 <= 41943040L)) {
          paramInt1 = 172;
        } else if ((41943040L < paramLong5) && (paramLong5 <= 52428800L)) {
          paramInt1 = 173;
        } else if ((52428800L < paramLong5) && (paramLong5 <= 62914560L)) {
          paramInt1 = 174;
        } else if ((62914560L < paramLong5) && (paramLong5 <= 73400320L)) {
          paramInt1 = 175;
        } else if ((73400320L < paramLong5) && (paramLong5 <= 94371840L)) {
          paramInt1 = 176;
        } else if ((94371840L < paramLong5) && (paramLong5 <= 115343360L)) {
          paramInt1 = 177;
        } else {
          paramInt1 = 178;
        }
      }
      label3327:
      if ((4 <= paramInt4) && (paramInt4 <= 6))
      {
        paramInt1 = 183;
        break label636;
      }
      if ((7 <= paramInt4) && (paramInt4 <= 10))
      {
        paramInt1 = 184;
        break label636;
      }
      if ((11 <= paramInt4) && (paramInt4 <= 15))
      {
        paramInt1 = 185;
        break label636;
      }
      if ((15 < paramInt4) && (paramInt4 <= 20))
      {
        paramInt1 = 186;
        break label636;
      }
      if ((20 < paramInt4) && (paramInt4 <= 40))
      {
        paramInt1 = 187;
        break label636;
      }
      if ((40 < paramInt4) && (paramInt4 <= 60))
      {
        paramInt1 = 188;
        break label636;
      }
      if ((60 < paramInt4) && (paramInt4 <= 100))
      {
        paramInt1 = 189;
        break label636;
      }
      paramInt1 = 190;
      break label636;
      label3480:
      if ((4 <= paramInt5) && (paramInt5 <= 6)) {
        paramInt1 = 195;
      } else if ((7 <= paramInt5) && (paramInt5 <= 10)) {
        paramInt1 = 196;
      } else if ((11 <= paramInt5) && (paramInt5 <= 15)) {
        paramInt1 = 197;
      } else if ((15 < paramInt5) && (paramInt5 <= 20)) {
        paramInt1 = 198;
      } else if ((20 < paramInt5) && (paramInt5 <= 40)) {
        paramInt1 = 199;
      } else if ((40 < paramInt5) && (paramInt5 <= 60)) {
        paramInt1 = 200;
      } else if ((60 < paramInt5) && (paramInt5 <= 100)) {
        paramInt1 = 201;
      } else {
        paramInt1 = 202;
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(104828);
    a(paramString1, paramString2, paramLong1, paramLong2, paramLong3, true, "", 0L, 0L, 0L);
    AppMethodBeat.o(104828);
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, String paramString3, long paramLong4, long paramLong5, long paramLong6)
  {
    AppMethodBeat.i(104829);
    com.tencent.mm.ch.a.post(new c.3(this, paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramBoolean, paramString3, paramLong6, paramLong5, paramLong4));
    AppMethodBeat.o(104829);
  }
  
  public final void b(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(104830);
    com.tencent.mm.ch.a.post(new c.4(this, paramString, paramLong1, paramLong2, paramLong3));
    AppMethodBeat.o(104830);
  }
  
  public final void bUL()
  {
    synchronized (oXJ)
    {
      oXD += 1;
      return;
    }
  }
  
  public final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104821);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(1);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrSceneIdKey, scene:".concat(String.valueOf(paramInt1)));
    switch (paramInt1)
    {
    }
    localIDKey2.SetKey(9);
    localIDKey2.SetValue(1L);
    IDKey localIDKey3 = new IDKey();
    localIDKey3.SetID(688);
    ab.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(paramInt2)));
    switch (paramInt2)
    {
    default: 
      paramInt1 = 30;
    }
    for (;;)
    {
      localIDKey3.SetKey(paramInt1);
      localIDKey3.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      localArrayList.add(localIDKey3);
      h.qsU.b(localArrayList, true);
      AppMethodBeat.o(104821);
      return;
      paramInt1 = 17;
      continue;
      paramInt1 = 18;
      continue;
      paramInt1 = 19;
      continue;
      paramInt1 = 20;
      continue;
      paramInt1 = 21;
      continue;
      paramInt1 = 22;
      continue;
      paramInt1 = 23;
      continue;
      paramInt1 = 24;
      continue;
      paramInt1 = 25;
      continue;
      paramInt1 = 36;
      continue;
      paramInt1 = 26;
      continue;
      paramInt1 = 27;
      continue;
      paramInt1 = 28;
      continue;
      paramInt1 = 29;
      continue;
      paramInt1 = 31;
      continue;
      paramInt1 = 32;
      continue;
      paramInt1 = 33;
      continue;
      paramInt1 = 34;
      continue;
      paramInt1 = 35;
    }
  }
  
  public final void fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104826);
    com.tencent.mm.ch.a.post(new c.1(this, paramString1, paramString2));
    AppMethodBeat.o(104826);
  }
  
  public final void r(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(104827);
    com.tencent.mm.ch.a.post(new c.2(this, paramString1, paramString2, paramBoolean));
    AppMethodBeat.o(104827);
  }
  
  public final void zO(int paramInt)
  {
    AppMethodBeat.i(104820);
    ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportQQAudioPlayerSum scene:%d", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(0);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerSumIdKeyByScene, scene:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    localIDKey2.SetKey(2);
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.qsU.b(localArrayList, true);
    AppMethodBeat.o(104820);
  }
  
  public final void zP(int paramInt)
  {
    AppMethodBeat.i(104822);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(688);
    if (paramInt == 2) {
      paramInt = 42;
    }
    for (;;)
    {
      localIDKey.SetKey(paramInt);
      localIDKey.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey);
      h.qsU.b(localArrayList, true);
      AppMethodBeat.o(104822);
      return;
      if (paramInt == 3) {
        paramInt = 43;
      } else if (paramInt == 4) {
        paramInt = 44;
      } else if (paramInt == 5) {
        paramInt = 45;
      } else if (paramInt == 6) {
        paramInt = 46;
      } else if (paramInt == 7) {
        paramInt = 47;
      } else if (paramInt == 8) {
        paramInt = 48;
      } else if (paramInt == 9) {
        paramInt = 49;
      } else {
        paramInt = 50;
      }
    }
  }
  
  public final void zQ(int paramInt)
  {
    AppMethodBeat.i(104823);
    ab.d("MicroMsg.Audio.AudioPlayIdKeyReport", "idKeyReportAudioMixPlayerSum scene:%d", new Object[] { Integer.valueOf(paramInt) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(688);
    localIDKey.SetKey(90);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    h.qsU.b(localArrayList, true);
    AppMethodBeat.o(104823);
  }
  
  public final void zR(int paramInt)
  {
    AppMethodBeat.i(104824);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(91);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    localIDKey2.SetKey(b.zN(paramInt));
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.qsU.b(localArrayList, true);
    b.r(localArrayList);
    AppMethodBeat.o(104824);
  }
  
  public final void zS(int paramInt)
  {
    AppMethodBeat.i(104825);
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(688);
    localIDKey1.SetKey(118);
    localIDKey1.SetValue(1L);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(688);
    localIDKey2.SetKey(b.zN(paramInt));
    localIDKey2.SetValue(1L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.qsU.b(localArrayList, true);
    b.r(localArrayList);
    AppMethodBeat.o(104825);
  }
  
  final class a
  {
    long duration = 0L;
    long fileSize = 0L;
    long oXY = 0L;
    int playCount = 0;
    
    a() {}
  }
  
  final class b
  {
    long bCz = 0L;
    int oXZ = 0;
    long oYa = 0L;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.a.c
 * JD-Core Version:    0.7.0.1
 */