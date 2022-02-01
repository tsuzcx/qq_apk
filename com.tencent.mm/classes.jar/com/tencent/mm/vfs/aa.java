package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class aa
{
  private static a YEE;
  private static int YEF;
  private static int YEG;
  private static int YEH;
  private static int YEI;
  private static int YEJ;
  private static int YEK;
  private static int YEL;
  private static int YEM;
  private static int YEN;
  private static int YEO;
  private static int YEP;
  private static ArrayList<IDKey> YEQ;
  private static int YER;
  private static int YES;
  private static int YET;
  private static int YEU;
  private static HashMap<String, Long> YEV;
  private static HashMap<String, Long> YEW;
  private static int YEX;
  private static float YEY;
  private static int YEZ;
  private static float YFa;
  private static long YFb;
  private static long YFc;
  private static long YFd;
  private static long YFe;
  private static long YFf;
  private static int YFg;
  private static int YFh;
  private static long YFi;
  private static long YFj;
  private static long YFk;
  private static long YFl;
  private static long YFm;
  private static long YFn;
  private static long YFo;
  private static long YFp;
  private static LinkedList<String> odL;
  private static long tOn;
  
  static
  {
    AppMethodBeat.i(194331);
    YEF = 1401;
    YEG = 0;
    YEH = 1;
    YEI = 2;
    YEJ = 3;
    YEK = 4;
    YEL = 5;
    YEM = 6;
    YEN = 7;
    YEO = 8;
    YEP = 9;
    YEQ = new ArrayList();
    YER = 20047;
    YES = 1;
    YET = 2;
    YEU = 3;
    YEV = new HashMap();
    YEW = new HashMap();
    odL = new LinkedList();
    YEX = 0;
    YEY = -1.0F;
    YEZ = 0;
    YFa = -1.0F;
    YFb = 0L;
    YFc = 0L;
    tOn = 0L;
    YFd = -1L;
    YFe = -1L;
    YFf = -1L;
    YFg = -1;
    YFh = -1;
    YFi = -1L;
    YFj = -1L;
    YFk = 0L;
    YEV.put("sns", Long.valueOf(0L));
    YEV.put("sns_ad_landingpages", Long.valueOf(0L));
    YEV.put("finder", Long.valueOf(0L));
    YEV.put("brandicon", Long.valueOf(0L));
    YEV.put("bizcache", Long.valueOf(0L));
    YEV.put("openapi_cache", Long.valueOf(0L));
    YEV.put("CDNTemp", Long.valueOf(0L));
    YEV.put("vproxy", Long.valueOf(0L));
    YEV.put("backupRecover", Long.valueOf(0L));
    YEV.put("msgsynchronize", Long.valueOf(0L));
    YEW.put("oneday", Long.valueOf(0L));
    YEW.put("bizimg", Long.valueOf(0L));
    YEW.put("openim", Long.valueOf(0L));
    YEW.put("avatar", Long.valueOf(0L));
    YEW.put("wallet_images", Long.valueOf(0L));
    YEW.put("emoji", Long.valueOf(0L));
    YFl = -1L;
    YFm = 0L;
    YFn = 0L;
    YFo = -1L;
    YFp = -1L;
    AppMethodBeat.o(194331);
  }
  
  public static a ifO()
  {
    AppMethodBeat.i(194282);
    if (YEE == null)
    {
      YEE = new a((byte)0);
      i.YCR.b(YEE);
    }
    a locala = YEE;
    AppMethodBeat.o(194282);
    return locala;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(194284);
    YEQ.clear();
    YEV.clear();
    YEW.clear();
    odL.clear();
    YFl = -1L;
    YFm = 0L;
    YFn = 0L;
    YFo = -1L;
    YFp = -1L;
    YEX = 0;
    YEY = -1.0F;
    YEZ = 0;
    YFa = -1.0F;
    YFb = 0L;
    YFc = 0L;
    tOn = 0L;
    YFd = -1L;
    YFd = -1L;
    YFe = -1L;
    YFf = -1L;
    YFg = -1;
    YFh = -1;
    YFi = -1L;
    YFj = -1L;
    YFk = 0L;
    AppMethodBeat.o(194284);
  }
  
  static final class a
    implements h.d, o.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(193831);
      Log.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (aa.YEV.containsKey(paramString)) {
            aa.YEV.put(paramString, Long.valueOf(((Long)aa.YEV.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            aa.Wq(aa.YFm + l);
            AppMethodBeat.o(193831);
            return;
            aa.YEV.put(paramString, Long.valueOf(l));
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
            AppMethodBeat.o(193831);
            return;
          case 2: 
            aa.access$302(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(193831);
            return;
          }
          if (aa.YFl < 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            aa.ifP().add(paramString);
            AppMethodBeat.o(193831);
            return;
          }
          l = aa.YFl - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(aa.YFl) });
            aa.ifP().add(paramString);
          }
          for (;;)
          {
            aa.Wi(aa.YFn + l);
            aa.access$302(-1L);
            break;
            if (aa.fdD().containsKey(paramString)) {
              aa.fdD().put(paramString, Long.valueOf(((Long)aa.fdD().get(paramString)).longValue() + l));
            } else {
              aa.fdD().put(paramString, Long.valueOf(l));
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
        AppMethodBeat.o(193831);
        return;
        aa.Ws(System.currentTimeMillis());
        aa.Wt(-1L);
        aa.Wu(0L);
        AppMethodBeat.o(193831);
        return;
        if (aa.cfW() > 0L)
        {
          aa.Wt(System.currentTimeMillis() - aa.cfW());
          aa.Ws(-1L);
        }
        aa.azb(((Integer)paramMap.get("cleanStorageCount")).intValue());
        aa.da(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        aa.azc(((Integer)paramMap.get("cleanRepetitionRatioCount")).intValue());
        aa.db(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        aa.Wv(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        aa.Ww(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        aa.Wx(((Long)paramMap.get("deleteSize")).longValue());
        aa.Wy(((Long)paramMap.get("cleanOriginExpireTime")).longValue());
        aa.Wz(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        aa.WA(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        aa.azd(((Integer)paramMap.get("cleanTrend")).intValue());
        aa.aze(((Integer)paramMap.get("changeSwitch")).intValue());
        aa.Wu(aa.YFk + aa.ifQ());
        aa.Wq(aa.YFm + aa.ifQ());
      }
    }
    
    public final void br(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(193835);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      aa.ifT().add(new IDKey(aa.ifR(), aa.ifU(), 1));
      long l2 = aa.YFm + aa.YFn;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        aa.ifT().add(new IDKey(aa.ifR(), aa.ifV(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = aa.ifW();
        aa.ifT().add(new IDKey(aa.ifR(), aa.ifX(), 1));
        aa.ifT().add(new IDKey(aa.ifR(), aa.ifY(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (aa.igd() > 0L)
        {
          aa.WC(System.currentTimeMillis() - aa.igd());
          aa.ifT().add(new IDKey(aa.ifR(), aa.flI(), aa.ige()));
        }
        f.Iyx.b(aa.ifT(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = aa.YEV.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, aa.YEV.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(aa.YEV.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = aa.ifZ();
          aa.ifT().add(new IDKey(aa.ifR(), aa.epy(), 1));
          aa.ifT().add(new IDKey(aa.ifR(), aa.eUB(), l1));
        }
        else
        {
          i = aa.iga();
          aa.ifT().add(new IDKey(aa.ifR(), aa.igb(), 1));
          aa.ifT().add(new IDKey(aa.ifR(), aa.igc(), l1));
        }
      }
      Object localObject1 = aa.fdD().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, aa.fdD().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(aa.fdD().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = aa.ifP().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      localObject2 = g.avF().getPath();
      paramBoolean1 = b.aSG().equals(localObject2);
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
        f.Iyx.a(aa.igf(), new Object[] { Integer.valueOf(i), Long.valueOf(aa.ige()), Long.valueOf(l2), Long.valueOf(aa.YFm), Long.valueOf(aa.YFn), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(aa.bKi()), Integer.valueOf((int)aa.igg()), Integer.valueOf((int)aa.igh()), Long.valueOf(aa.dlI()), Long.valueOf(aa.igi()), Long.valueOf(aa.YFk), Long.valueOf(aa.igj()), Long.valueOf(aa.igk()), Long.valueOf(aa.igl()), Integer.valueOf(aa.csA()), Integer.valueOf(aa.igm()), Long.valueOf(aa.ign()), Integer.valueOf(aa.gyr()), Integer.valueOf(1), Long.valueOf(l1) });
        Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", new Object[] { Integer.valueOf(i), Long.valueOf(aa.ige()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(aa.bKi()), Float.valueOf(aa.igg()), Float.valueOf(aa.igh()), Long.valueOf(aa.dlI()), Long.valueOf(aa.igi()), Long.valueOf(aa.YFk), Long.valueOf(aa.igj()), Long.valueOf(aa.igk()), Long.valueOf(aa.igl()), Integer.valueOf(aa.csA()), Integer.valueOf(aa.igm()), Long.valueOf(aa.ign()), Integer.valueOf(aa.gyr()), Integer.valueOf(1), Long.valueOf(l1) });
        AppMethodBeat.o(193835);
        return;
        localObject2 = new StatFs(b.aSG());
        j = ((StatFs)localObject2).getBlockSize();
        k = ((StatFs)localObject2).getAvailableBlocks();
        l1 = k * j;
      }
    }
    
    public final void ife()
    {
      AppMethodBeat.i(193832);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      aa.resetParams();
      aa.WB(System.currentTimeMillis());
      aa.ifT().add(new IDKey(aa.ifR(), aa.ifS(), 1));
      AppMethodBeat.o(193832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.vfs.aa
 * JD-Core Version:    0.7.0.1
 */