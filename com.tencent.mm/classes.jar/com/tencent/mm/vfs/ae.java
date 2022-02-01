package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class ae
{
  private static float agAA;
  private static int agAB;
  private static float agAC;
  private static long agAD;
  private static long agAE;
  private static long agAF;
  private static long agAG;
  private static long agAH;
  private static int agAI;
  private static int agAJ;
  private static long agAK;
  private static long agAL;
  private static long agAM;
  private static long agAN;
  private static long agAO;
  private static long agAP;
  private static long agAQ;
  private static long agAR;
  private static a agAh;
  private static int agAi;
  private static int agAj;
  private static int agAk;
  private static int agAl;
  private static int agAm;
  private static int agAn;
  private static int agAo;
  private static int agAp;
  private static int agAq;
  private static int agAr;
  private static int agAs;
  private static ArrayList<IDKey> agAt;
  private static int agAu;
  private static int agAv;
  private static int agAw;
  private static int agAx;
  private static HashMap<String, Long> agAy;
  private static HashMap<String, Long> agAz;
  private static int bPz;
  private static LinkedList<String> reE;
  private static long wRD;
  
  static
  {
    AppMethodBeat.i(238289);
    agAi = 1401;
    agAj = 0;
    agAk = 1;
    agAl = 2;
    agAm = 3;
    agAn = 4;
    agAo = 5;
    agAp = 6;
    agAq = 7;
    agAr = 8;
    agAs = 9;
    agAt = new ArrayList();
    agAu = 20047;
    agAv = 1;
    agAw = 2;
    agAx = 3;
    agAy = new HashMap();
    agAz = new HashMap();
    reE = new LinkedList();
    bPz = 0;
    agAA = -1.0F;
    agAB = 0;
    agAC = -1.0F;
    agAD = 0L;
    agAE = 0L;
    wRD = 0L;
    agAF = -1L;
    agAG = -1L;
    agAH = -1L;
    agAI = -1;
    agAJ = -1;
    agAK = -1L;
    agAL = -1L;
    agAM = 0L;
    agAy.put("sns", Long.valueOf(0L));
    agAy.put("sns_ad_landingpages", Long.valueOf(0L));
    agAy.put("finder", Long.valueOf(0L));
    agAy.put("brandicon", Long.valueOf(0L));
    agAy.put("bizcache", Long.valueOf(0L));
    agAy.put("openapi_cache", Long.valueOf(0L));
    agAy.put("CDNTemp", Long.valueOf(0L));
    agAy.put("vproxy", Long.valueOf(0L));
    agAy.put("backupRecover", Long.valueOf(0L));
    agAy.put("msgsynchronize", Long.valueOf(0L));
    agAz.put("oneday", Long.valueOf(0L));
    agAz.put("bizimg", Long.valueOf(0L));
    agAz.put("openim", Long.valueOf(0L));
    agAz.put("avatar", Long.valueOf(0L));
    agAz.put("wallet_images", Long.valueOf(0L));
    agAz.put("emoji", Long.valueOf(0L));
    agAN = -1L;
    agAO = 0L;
    agAP = 0L;
    agAQ = -1L;
    agAR = -1L;
    AppMethodBeat.o(238289);
  }
  
  public static a jLb()
  {
    AppMethodBeat.i(238092);
    if (agAh == null)
    {
      agAh = new a((byte)0);
      l.agxP.a(agAh);
    }
    a locala = agAh;
    AppMethodBeat.o(238092);
    return locala;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(238100);
    agAt.clear();
    agAy.clear();
    agAz.clear();
    reE.clear();
    agAN = -1L;
    agAO = 0L;
    agAP = 0L;
    agAQ = -1L;
    agAR = -1L;
    bPz = 0;
    agAA = -1.0F;
    agAB = 0;
    agAC = -1.0F;
    agAD = 0L;
    agAE = 0L;
    wRD = 0L;
    agAF = -1L;
    agAF = -1L;
    agAG = -1L;
    agAH = -1L;
    agAI = -1;
    agAJ = -1;
    agAK = -1L;
    agAL = -1L;
    agAM = 0L;
    AppMethodBeat.o(238100);
  }
  
  static final class a
    implements k.d, s.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(238217);
      Log.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (ae.agAy.containsKey(paramString)) {
            ae.agAy.put(paramString, Long.valueOf(((Long)ae.agAy.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            ae.AC(l);
            AppMethodBeat.o(238217);
            return;
            ae.agAy.put(paramString, Long.valueOf(l));
          }
        }
      }
      else
      {
        if ((paramFileSystem instanceof QuotaFileSystem))
        {
          switch (paramInt)
          {
          default: 
            AppMethodBeat.o(238217);
            return;
          case 2: 
            ae.access$302(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(238217);
            return;
          }
          if (ae.agAN < 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            ae.jLc().add(paramString);
            AppMethodBeat.o(238217);
            return;
          }
          l = ae.agAN - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(ae.agAN) });
            ae.jLc().add(paramString);
          }
          for (;;)
          {
            ae.AD(l);
            ae.access$302(-1L);
            break;
            if (ae.gmG().containsKey(paramString)) {
              ae.gmG().put(paramString, Long.valueOf(((Long)ae.gmG().get(paramString)).longValue() + l));
            } else {
              ae.gmG().put(paramString, Long.valueOf(l));
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
        AppMethodBeat.o(238217);
        return;
        ae.AE(System.currentTimeMillis());
        ae.AF(-1L);
        ae.jLd();
        AppMethodBeat.o(238217);
        return;
        if (ae.cGI() > 0L)
        {
          ae.AF(System.currentTimeMillis() - ae.cGI());
          ae.AE(-1L);
        }
        ae.aqA(((Integer)paramMap.get("cleanStorageCount")).intValue());
        ae.ep(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        ae.aFG(((Integer)paramMap.get("cleanRepetitionRatioCount")).intValue());
        ae.eq(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        ae.AG(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        ae.AH(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        ae.At(((Long)paramMap.get("deleteSize")).longValue());
        ae.AI(((Long)paramMap.get("cleanOriginExpireTime")).longValue());
        ae.AJ(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        ae.AK(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        ae.aFH(((Integer)paramMap.get("cleanTrend")).intValue());
        ae.aFI(((Integer)paramMap.get("changeSwitch")).intValue());
        ae.AL(ae.jzU());
        ae.AC(ae.jzU());
      }
    }
    
    public final void bQ(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(238235);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      ae.jLg().add(new IDKey(ae.jLe(), ae.jLh(), 1));
      long l2 = ae.agAO + ae.agAP;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        ae.jLg().add(new IDKey(ae.jLe(), ae.jLi(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = ae.jLj();
        ae.jLg().add(new IDKey(ae.jLe(), ae.jLk(), 1));
        ae.jLg().add(new IDKey(ae.jLe(), ae.jLl(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (ae.jLq() > 0L)
        {
          ae.AN(System.currentTimeMillis() - ae.jLq());
          ae.jLg().add(new IDKey(ae.jLe(), ae.jLr(), ae.jLs()));
        }
        f.Ozc.b(ae.jLg(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = ae.agAy.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, ae.agAy.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(ae.agAy.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = ae.jLm();
          ae.jLg().add(new IDKey(ae.jLe(), ae.fuA(), 1));
          ae.jLg().add(new IDKey(ae.jLe(), ae.gdn(), l1));
        }
        else
        {
          i = ae.jLn();
          ae.jLg().add(new IDKey(ae.jLe(), ae.jLo(), 1));
          ae.jLg().add(new IDKey(ae.jLe(), ae.jLp(), l1));
        }
      }
      Object localObject1 = ae.gmG().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, ae.gmG().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(ae.gmG().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = ae.jLc().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      localObject2 = g.aPZ().getPath();
      paramBoolean1 = b.bmu().equals(localObject2);
      long l1 = 0L;
      if (paramBoolean1) {}
      for (;;)
      {
        try
        {
          localObject2 = new StatFs((String)localObject2);
          j = ((StatFs)localObject2).getBlockSize();
          k = ((StatFs)localObject2).getAvailableBlocks();
          l1 = k * j;
        }
        catch (Exception localException)
        {
          int j;
          int k;
          Log.printErrStackTrace("MicroMsg.VFSStatistics", localException, "Unable to get FS size.", new Object[0]);
          continue;
        }
        f.Ozc.b(ae.jLt(), new Object[] { Integer.valueOf(i), Long.valueOf(ae.jLs()), Long.valueOf(l2), Long.valueOf(ae.agAO), Long.valueOf(ae.agAP), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(ae.alu()), Integer.valueOf((int)ae.jLu()), Integer.valueOf((int)ae.jLv()), Long.valueOf(ae.dSy()), Long.valueOf(ae.jLw()), Long.valueOf(ae.Ss()), Long.valueOf(ae.jLx()), Long.valueOf(ae.jLy()), Long.valueOf(ae.jLz()), Integer.valueOf(ae.cVk()), Integer.valueOf(ae.dsH()), Long.valueOf(ae.jLA()), Integer.valueOf(ae.aDd()), Integer.valueOf(1), Long.valueOf(l1) });
        Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", new Object[] { Integer.valueOf(i), Long.valueOf(ae.jLs()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(ae.alu()), Float.valueOf(ae.jLu()), Float.valueOf(ae.jLv()), Long.valueOf(ae.dSy()), Long.valueOf(ae.jLw()), Long.valueOf(ae.Ss()), Long.valueOf(ae.jLx()), Long.valueOf(ae.jLy()), Long.valueOf(ae.jLz()), Integer.valueOf(ae.cVk()), Integer.valueOf(ae.dsH()), Long.valueOf(ae.jLA()), Integer.valueOf(ae.aDd()), Integer.valueOf(1), Long.valueOf(l1) });
        AppMethodBeat.o(238235);
        return;
        localObject2 = new StatFs(b.bmu());
        j = ((StatFs)localObject2).getBlockSize();
        k = ((StatFs)localObject2).getAvailableBlocks();
        l1 = k * j;
      }
    }
    
    public final void jKq()
    {
      AppMethodBeat.i(238222);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      ae.resetParams();
      ae.AM(System.currentTimeMillis());
      ae.jLg().add(new IDKey(ae.jLe(), ae.jLf(), 1));
      AppMethodBeat.o(238222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.vfs.ae
 * JD-Core Version:    0.7.0.1
 */