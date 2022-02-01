package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static long LlA;
  private static long LlB;
  private static long LlC;
  private static long LlD;
  private static long LlE;
  private static int LlF;
  private static int LlG;
  private static long LlH;
  private static long LlI;
  private static long LlJ;
  private static long LlK;
  private static long LlL;
  private static long LlM;
  private static long LlN;
  private static long LlO;
  private static a Lld;
  private static int Lle;
  private static int Llf;
  private static int Llg;
  private static int Llh;
  private static int Lli;
  private static int Llj;
  private static int Llk;
  private static int Lll;
  private static int Llm;
  private static int Lln;
  private static int Llo;
  private static ArrayList<IDKey> Llp;
  private static int Llq;
  private static int Llr;
  private static int Lls;
  private static int Llt;
  private static HashMap<String, Long> Llu;
  private static HashMap<String, Long> Llv;
  private static int Llw;
  private static float Llx;
  private static int Lly;
  private static float Llz;
  private static LinkedList<String> kcc;
  private static long oUd;
  
  static
  {
    AppMethodBeat.i(189950);
    Lle = 1401;
    Llf = 0;
    Llg = 1;
    Llh = 2;
    Lli = 3;
    Llj = 4;
    Llk = 5;
    Lll = 6;
    Llm = 7;
    Lln = 8;
    Llo = 9;
    Llp = new ArrayList();
    Llq = 20047;
    Llr = 1;
    Lls = 2;
    Llt = 3;
    Llu = new HashMap();
    Llv = new HashMap();
    kcc = new LinkedList();
    Llw = 0;
    Llx = -1.0F;
    Lly = 0;
    Llz = -1.0F;
    LlA = 0L;
    LlB = 0L;
    oUd = 0L;
    LlC = -1L;
    LlD = -1L;
    LlE = -1L;
    LlF = -1;
    LlG = -1;
    LlH = -1L;
    LlI = -1L;
    LlJ = 0L;
    Llu.put("sns", Long.valueOf(0L));
    Llu.put("sns_ad_landingpages", Long.valueOf(0L));
    Llu.put("finder", Long.valueOf(0L));
    Llu.put("brandicon", Long.valueOf(0L));
    Llu.put("bizcache", Long.valueOf(0L));
    Llu.put("openapi_cache", Long.valueOf(0L));
    Llu.put("CDNTemp", Long.valueOf(0L));
    Llu.put("vproxy", Long.valueOf(0L));
    Llu.put("backupRecover", Long.valueOf(0L));
    Llu.put("msgsynchronize", Long.valueOf(0L));
    Llv.put("oneday", Long.valueOf(0L));
    Llv.put("bizimg", Long.valueOf(0L));
    Llv.put("openim", Long.valueOf(0L));
    Llv.put("avatar", Long.valueOf(0L));
    Llv.put("wallet_images", Long.valueOf(0L));
    Llv.put("emoji", Long.valueOf(0L));
    LlK = -1L;
    LlL = 0L;
    LlM = 0L;
    LlN = -1L;
    LlO = -1L;
    AppMethodBeat.o(189950);
  }
  
  public static a fON()
  {
    AppMethodBeat.i(189948);
    if (Lld == null)
    {
      Lld = new a((byte)0);
      localObject = a.gzU();
      a locala = Lld;
      a.d locald = ((a)localObject).OfG;
      ((a)localObject).OfG = locala;
    }
    Object localObject = Lld;
    AppMethodBeat.o(189948);
    return localObject;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(189949);
    Llp.clear();
    Llu.clear();
    Llv.clear();
    kcc.clear();
    LlK = -1L;
    LlL = 0L;
    LlM = 0L;
    LlN = -1L;
    LlO = -1L;
    Llw = 0;
    Llx = -1.0F;
    Lly = 0;
    Llz = -1.0F;
    LlA = 0L;
    LlB = 0L;
    oUd = 0L;
    LlC = -1L;
    LlC = -1L;
    LlD = -1L;
    LlE = -1L;
    LlF = -1;
    LlG = -1;
    LlH = -1L;
    LlI = -1L;
    LlJ = 0L;
    AppMethodBeat.o(189949);
  }
  
  static final class a
    implements a.d, d
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(189945);
      ad.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (n.Llu.containsKey(paramString)) {
            n.Llu.put(paramString, Long.valueOf(((Long)n.Llu.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            n.Ev(n.LlL + l);
            AppMethodBeat.o(189945);
            return;
            n.Llu.put(paramString, Long.valueOf(l));
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
            AppMethodBeat.o(189945);
            return;
          case 2: 
            n.Ew(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(189945);
            return;
          }
          if (n.Il() < 0L)
          {
            ad.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            n.fOO().add(paramString);
            AppMethodBeat.o(189945);
            return;
          }
          l = n.Il() - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            ad.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(n.Il()) });
            n.fOO().add(paramString);
          }
          for (;;)
          {
            n.Eo(n.LlM + l);
            n.Ew(-1L);
            break;
            if (n.dsi().containsKey(paramString)) {
              n.dsi().put(paramString, Long.valueOf(((Long)n.dsi().get(paramString)).longValue() + l));
            } else {
              n.dsi().put(paramString, Long.valueOf(l));
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
        AppMethodBeat.o(189945);
        return;
        n.Ex(System.currentTimeMillis());
        n.Ey(-1L);
        n.Ez(0L);
        AppMethodBeat.o(189945);
        return;
        if (n.bvT() > 0L)
        {
          n.Ey(System.currentTimeMillis() - n.bvT());
          n.Ex(-1L);
        }
        n.afQ(((Integer)paramMap.get("cleanStorageCount")).intValue());
        n.ce(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        n.afR(((Integer)paramMap.get("cleanRepetitionRatioCount")).intValue());
        n.cf(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        n.EA(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        n.EB(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        n.EC(((Long)paramMap.get("deleteSize")).longValue());
        n.ED(((Long)paramMap.get("cleanOriginExpireTime")).longValue());
        n.EE(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        n.EF(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        n.afS(((Integer)paramMap.get("cleanTrend")).intValue());
        n.afT(((Integer)paramMap.get("changeSwitch")).intValue());
        n.Ez(n.LlJ + n.fOP());
        n.Ev(n.LlL + n.fOP());
      }
    }
    
    public final void aY(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(189947);
      ad.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      n.fOR().add(new IDKey(n.fOQ(), n.fOS(), 1));
      long l2 = n.LlL + n.LlM;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        n.fOR().add(new IDKey(n.fOQ(), n.fOT(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = n.fOU();
        n.fOR().add(new IDKey(n.fOQ(), n.dxd(), 1));
        n.fOR().add(new IDKey(n.fOQ(), n.fOV(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (n.fPb() > 0L)
        {
          n.EH(System.currentTimeMillis() - n.fPb());
          n.fOR().add(new IDKey(n.fOQ(), n.fPc(), n.fPd()));
        }
        e.ygI.b(n.fOR(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = n.Llu.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ad.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.Llu.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(n.Llu.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = n.fOW();
          n.fOR().add(new IDKey(n.fOQ(), n.fOX(), 1));
          n.fOR().add(new IDKey(n.fOQ(), n.doa(), l1));
        }
        else
        {
          i = n.fOY();
          n.fOR().add(new IDKey(n.fOQ(), n.fOZ(), 1));
          n.fOR().add(new IDKey(n.fOQ(), n.fPa(), l1));
        }
      }
      Object localObject1 = n.dsi().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ad.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.dsi().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(n.dsi().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = n.fOO().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      localObject2 = g.getExternalStorageDirectory().getPath();
      if (b.arP().equals(localObject2)) {
        localObject2 = new StatFs((String)localObject2);
      }
      int j;
      for (long l1 = ((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks();; l1 = ((StatFs)localObject2).getAvailableBlocks() * j)
      {
        p.fPs();
        e.ygI.f(n.fPe(), new Object[] { Integer.valueOf(i), Long.valueOf(n.fPd()), Long.valueOf(l2), Long.valueOf(n.LlL), Long.valueOf(n.LlM), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(n.bcX()), Integer.valueOf((int)n.fPf()), Integer.valueOf((int)n.fPg()), Long.valueOf(n.fPh()), Long.valueOf(n.fPi()), Long.valueOf(n.LlJ), Long.valueOf(n.fPj()), Long.valueOf(n.fPk()), Long.valueOf(n.fPl()), Integer.valueOf(n.cbs()), Integer.valueOf(n.fPm()), Long.valueOf(n.fPn()), Integer.valueOf(n.evH()), Integer.valueOf(1), Long.valueOf(l1) });
        ad.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", new Object[] { Integer.valueOf(i), Long.valueOf(n.fPd()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(n.bcX()), Float.valueOf(n.fPf()), Float.valueOf(n.fPg()), Long.valueOf(n.fPh()), Long.valueOf(n.fPi()), Long.valueOf(n.LlJ), Long.valueOf(n.fPj()), Long.valueOf(n.fPk()), Long.valueOf(n.fPl()), Integer.valueOf(n.cbs()), Integer.valueOf(n.fPm()), Long.valueOf(n.fPn()), Integer.valueOf(n.evH()), Integer.valueOf(1), Long.valueOf(l1) });
        AppMethodBeat.o(189947);
        return;
        localObject2 = new StatFs(b.arP());
        j = ((StatFs)localObject2).getBlockSize();
      }
    }
    
    public final void fOA()
    {
      AppMethodBeat.i(189946);
      ad.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      n.resetParams();
      n.EG(System.currentTimeMillis());
      n.fOR().add(new IDKey(n.fOQ(), n.cbu(), 1));
      AppMethodBeat.o(189946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */