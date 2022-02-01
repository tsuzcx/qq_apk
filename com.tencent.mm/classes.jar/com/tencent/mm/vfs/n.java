package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static int JtA;
  private static int JtB;
  private static int JtC;
  private static int JtD;
  private static int JtE;
  private static int JtF;
  private static int JtG;
  private static int JtH;
  private static int JtI;
  private static ArrayList<IDKey> JtJ;
  private static int JtK;
  private static int JtL;
  private static int JtM;
  private static int JtN;
  private static HashMap<String, Long> JtO;
  private static HashMap<String, Long> JtP;
  private static int JtQ;
  private static float JtR;
  private static float JtS;
  private static long JtT;
  private static long JtU;
  private static long JtV;
  private static long JtW;
  private static int JtX;
  private static int JtY;
  private static long JtZ;
  private static a Jtx;
  private static int Jty;
  private static int Jtz;
  private static long Jua;
  private static long Jub;
  private static long Juc;
  private static long Jud;
  private static long Jue;
  private static long Juf;
  private static long Jug;
  private static LinkedList<String> jHQ;
  private static long oqI;
  
  static
  {
    AppMethodBeat.i(206982);
    Jty = 1401;
    Jtz = 0;
    JtA = 1;
    JtB = 2;
    JtC = 3;
    JtD = 4;
    JtE = 5;
    JtF = 6;
    JtG = 7;
    JtH = 8;
    JtI = 9;
    JtJ = new ArrayList();
    JtK = 20047;
    JtL = 1;
    JtM = 2;
    JtN = 3;
    JtO = new HashMap();
    JtP = new HashMap();
    jHQ = new LinkedList();
    JtQ = 0;
    JtR = -1.0F;
    JtS = -1.0F;
    JtT = 0L;
    JtU = 0L;
    oqI = 0L;
    JtV = -1L;
    JtW = -1L;
    JtX = -1;
    JtY = -1;
    JtZ = -1L;
    Jua = -1L;
    Jub = 0L;
    JtO.put("sns", Long.valueOf(0L));
    JtO.put("sns_ad_landingpages", Long.valueOf(0L));
    JtO.put("finder", Long.valueOf(0L));
    JtO.put("brandicon", Long.valueOf(0L));
    JtO.put("bizcache", Long.valueOf(0L));
    JtO.put("openapi_cache", Long.valueOf(0L));
    JtO.put("CDNTemp", Long.valueOf(0L));
    JtO.put("vproxy", Long.valueOf(0L));
    JtO.put("backupRecover", Long.valueOf(0L));
    JtO.put("msgsynchronize", Long.valueOf(0L));
    JtP.put("oneday", Long.valueOf(0L));
    JtP.put("bizimg", Long.valueOf(0L));
    JtP.put("openim", Long.valueOf(0L));
    JtP.put("avatar", Long.valueOf(0L));
    JtP.put("wallet_images", Long.valueOf(0L));
    JtP.put("emoji", Long.valueOf(0L));
    Juc = -1L;
    Jud = 0L;
    Jue = 0L;
    Juf = -1L;
    Jug = -1L;
    AppMethodBeat.o(206982);
  }
  
  public static a fxY()
  {
    AppMethodBeat.i(206980);
    if (Jtx == null)
    {
      Jtx = new a((byte)0);
      localObject = a.ghk();
      a locala = Jtx;
      a.d locald = ((a)localObject).Kjb;
      ((a)localObject).Kjb = locala;
    }
    Object localObject = Jtx;
    AppMethodBeat.o(206980);
    return localObject;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(206981);
    JtJ.clear();
    JtO.clear();
    JtP.clear();
    jHQ.clear();
    Juc = -1L;
    Jud = 0L;
    Jue = 0L;
    Juf = -1L;
    Jug = -1L;
    JtQ = 0;
    JtR = -1.0F;
    JtS = -1.0F;
    JtT = 0L;
    JtU = 0L;
    oqI = 0L;
    JtV = -1L;
    JtW = -1L;
    JtX = -1;
    JtY = -1;
    JtZ = -1L;
    Jua = -1L;
    Jub = 0L;
    AppMethodBeat.o(206981);
  }
  
  static final class a
    implements a.d, d
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(206977);
      ac.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (n.JtO.containsKey(paramString)) {
            n.JtO.put(paramString, Long.valueOf(((Long)n.JtO.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            n.BD(n.Jud + l);
            AppMethodBeat.o(206977);
            return;
            n.JtO.put(paramString, Long.valueOf(l));
          }
        }
      }
      else
      {
        if (((paramFileSystem instanceof QuotaFileSystem)) || ((paramFileSystem instanceof CleanQuotaFileSystem)))
        {
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(206977);
            return;
          case 2: 
            n.rh(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(206977);
            return;
          }
          if (n.GQ() < 0L)
          {
            ac.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            n.fxZ().add(paramString);
            AppMethodBeat.o(206977);
            return;
          }
          l = n.GQ() - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            ac.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(n.GQ()) });
            n.fxZ().add(paramString);
          }
          for (;;)
          {
            n.Bw(n.Jue + l);
            n.rh(-1L);
            break;
            if (n.dhV().containsKey(paramString)) {
              n.dhV().put(paramString, Long.valueOf(((Long)n.dhV().get(paramString)).longValue() + l));
            } else {
              n.dhV().put(paramString, Long.valueOf(l));
            }
          }
        }
        if (((paramFileSystem instanceof CleanExpireFileSystem)) && (paramString.equals("sns"))) {
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(206977);
        return;
        n.BE(System.currentTimeMillis());
        n.BF(-1L);
        n.BG(0L);
        AppMethodBeat.o(206977);
        return;
        if (n.brP() > 0L)
        {
          n.BF(System.currentTimeMillis() - n.brP());
          n.BE(-1L);
        }
        n.adq(((Integer)paramMap.get("cleanStorageCount")).intValue());
        n.bZ(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        n.ca(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        n.Bv(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        n.BH(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        n.BI(((Long)paramMap.get("deleteSize")).longValue());
        n.BJ(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        n.BK(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        n.adr(((Integer)paramMap.get("cleanTrend")).intValue());
        n.ads(((Integer)paramMap.get("changeSwitch")).intValue());
        n.BG(n.Jub + n.fya());
        n.BD(n.Jud + n.fya());
      }
    }
    
    public final void aQ(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(206979);
      ac.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      n.fyc().add(new IDKey(n.fyb(), n.bWR(), 1));
      long l2 = n.Jud + n.Jue;
      long l1;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        n.fyc().add(new IDKey(n.fyb(), n.bWS(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = n.fyd();
        n.fyc().add(new IDKey(n.fyb(), n.fye(), 1));
        n.fyc().add(new IDKey(n.fyb(), n.fyf(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (n.cPm() > 0L)
        {
          n.BM(System.currentTimeMillis() - n.cPm());
          n.fyc().add(new IDKey(n.fyb(), n.fyk(), n.fyl()));
        }
        e.wTc.b(n.fyc(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = n.JtO.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ac.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.JtO.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(n.JtO.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = n.dmL();
          n.fyc().add(new IDKey(n.fyb(), n.fyg(), 1));
          n.fyc().add(new IDKey(n.fyb(), n.fyh(), l1));
        }
        else
        {
          i = n.fyi();
          n.fyc().add(new IDKey(n.fyb(), n.deC(), 1));
          n.fyc().add(new IDKey(n.fyb(), n.fyj(), l1));
        }
      }
      Object localObject1 = n.dhV().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ac.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.dhV().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(n.dhV().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = n.fxZ().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      e.wTc.f(n.fym(), new Object[] { Integer.valueOf(i), Long.valueOf(n.fyl()), Long.valueOf(l2), Long.valueOf(n.Jud), Long.valueOf(n.Jue), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(n.aZz()), Integer.valueOf((int)n.fyn()), Integer.valueOf((int)n.dth()), Long.valueOf(n.frR()), Long.valueOf(n.fyo()), Long.valueOf(n.Jub), Long.valueOf(n.fyp()), Long.valueOf(n.fyq()), Long.valueOf(n.fyr()), Integer.valueOf(n.bDq()), Integer.valueOf(n.fys()) });
      ac.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d", new Object[] { Integer.valueOf(i), Long.valueOf(n.fyl()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(n.aZz()), Float.valueOf(n.fyn()), Float.valueOf(n.dth()), Long.valueOf(n.frR()), Long.valueOf(n.fyo()), Long.valueOf(n.Jub), Long.valueOf(n.fyp()), Long.valueOf(n.fyq()), Long.valueOf(n.fyr()), Integer.valueOf(n.bDq()), Integer.valueOf(n.fys()) });
      AppMethodBeat.o(206979);
    }
    
    public final void fxN()
    {
      AppMethodBeat.i(206978);
      ac.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      n.resetParams();
      n.BL(System.currentTimeMillis());
      n.fyc().add(new IDKey(n.fyb(), n.bWQ(), 1));
      AppMethodBeat.o(206978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */