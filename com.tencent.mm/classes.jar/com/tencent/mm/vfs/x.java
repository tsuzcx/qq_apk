package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class x
{
  private static a RdM;
  private static int RdN;
  private static int RdO;
  private static int RdP;
  private static int RdQ;
  private static int RdR;
  private static int RdS;
  private static int RdT;
  private static int RdU;
  private static int RdV;
  private static int RdW;
  private static int RdX;
  private static int RdY;
  private static int RdZ;
  private static int Rea;
  private static int Reb;
  private static HashMap<String, Long> Rec;
  private static HashMap<String, Long> Red;
  private static int Ree;
  private static float Ref;
  private static int Reg;
  private static float Reh;
  private static long Rei;
  private static long Rej;
  private static long Rek;
  private static long Rel;
  private static long Rem;
  private static int Ren;
  private static int Reo;
  private static long Rep;
  private static long Req;
  private static long Rer;
  private static long Res;
  private static long Reu;
  private static long Rev;
  private static long Rew;
  private static long Rex;
  private static ArrayList<IDKey> dmd;
  private static LinkedList<String> ljc;
  private static long qpE;
  
  static
  {
    AppMethodBeat.i(197244);
    RdN = 1401;
    RdO = 0;
    RdP = 1;
    RdQ = 2;
    RdR = 3;
    RdS = 4;
    RdT = 5;
    RdU = 6;
    RdV = 7;
    RdW = 8;
    RdX = 9;
    dmd = new ArrayList();
    RdY = 20047;
    RdZ = 1;
    Rea = 2;
    Reb = 3;
    Rec = new HashMap();
    Red = new HashMap();
    ljc = new LinkedList();
    Ree = 0;
    Ref = -1.0F;
    Reg = 0;
    Reh = -1.0F;
    Rei = 0L;
    Rej = 0L;
    qpE = 0L;
    Rek = -1L;
    Rel = -1L;
    Rem = -1L;
    Ren = -1;
    Reo = -1;
    Rep = -1L;
    Req = -1L;
    Rer = 0L;
    Rec.put("sns", Long.valueOf(0L));
    Rec.put("sns_ad_landingpages", Long.valueOf(0L));
    Rec.put("finder", Long.valueOf(0L));
    Rec.put("brandicon", Long.valueOf(0L));
    Rec.put("bizcache", Long.valueOf(0L));
    Rec.put("openapi_cache", Long.valueOf(0L));
    Rec.put("CDNTemp", Long.valueOf(0L));
    Rec.put("vproxy", Long.valueOf(0L));
    Rec.put("backupRecover", Long.valueOf(0L));
    Rec.put("msgsynchronize", Long.valueOf(0L));
    Red.put("oneday", Long.valueOf(0L));
    Red.put("bizimg", Long.valueOf(0L));
    Red.put("openim", Long.valueOf(0L));
    Red.put("avatar", Long.valueOf(0L));
    Red.put("wallet_images", Long.valueOf(0L));
    Red.put("emoji", Long.valueOf(0L));
    Res = -1L;
    Reu = 0L;
    Rev = 0L;
    Rew = -1L;
    Rex = -1L;
    AppMethodBeat.o(197244);
  }
  
  public static a heu()
  {
    AppMethodBeat.i(197242);
    if (RdM == null)
    {
      RdM = new a((byte)0);
      h.Rco.a(RdM);
    }
    a locala = RdM;
    AppMethodBeat.o(197242);
    return locala;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(197243);
    dmd.clear();
    Rec.clear();
    Red.clear();
    ljc.clear();
    Res = -1L;
    Reu = 0L;
    Rev = 0L;
    Rew = -1L;
    Rex = -1L;
    Ree = 0;
    Ref = -1.0F;
    Reg = 0;
    Reh = -1.0F;
    Rei = 0L;
    Rej = 0L;
    qpE = 0L;
    Rek = -1L;
    Rek = -1L;
    Rel = -1L;
    Rem = -1L;
    Ren = -1;
    Reo = -1;
    Rep = -1L;
    Req = -1L;
    Rer = 0L;
    AppMethodBeat.o(197243);
  }
  
  static final class a
    implements g.d, n.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(197239);
      Log.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (x.Rec.containsKey(paramString)) {
            x.Rec.put(paramString, Long.valueOf(((Long)x.Rec.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            x.Oe(x.Reu + l);
            AppMethodBeat.o(197239);
            return;
            x.Rec.put(paramString, Long.valueOf(l));
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
            AppMethodBeat.o(197239);
            return;
          case 2: 
            x.Of(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(197239);
            return;
          }
          if (x.cfR() < 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            x.hev().add(paramString);
            AppMethodBeat.o(197239);
            return;
          }
          l = x.cfR() - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            Log.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(x.cfR()) });
            x.hev().add(paramString);
          }
          for (;;)
          {
            x.NV(x.Rev + l);
            x.Of(-1L);
            break;
            if (x.ets().containsKey(paramString)) {
              x.ets().put(paramString, Long.valueOf(((Long)x.ets().get(paramString)).longValue() + l));
            } else {
              x.ets().put(paramString, Long.valueOf(l));
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
        AppMethodBeat.o(197239);
        return;
        x.Og(System.currentTimeMillis());
        x.Oh(-1L);
        x.Oi(0L);
        AppMethodBeat.o(197239);
        return;
        if (x.bST() > 0L)
        {
          x.Oh(System.currentTimeMillis() - x.bST());
          x.Og(-1L);
        }
        x.apC(((Integer)paramMap.get("cleanStorageCount")).intValue());
        x.cF(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        x.apD(((Integer)paramMap.get("cleanRepetitionRatioCount")).intValue());
        x.cG(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        x.Oj(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        x.Ok(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        x.Ol(((Long)paramMap.get("deleteSize")).longValue());
        x.Om(((Long)paramMap.get("cleanOriginExpireTime")).longValue());
        x.On(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        x.Oo(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        x.apE(((Integer)paramMap.get("cleanTrend")).intValue());
        x.apF(((Integer)paramMap.get("changeSwitch")).intValue());
        x.Oi(x.Rer + x.hew());
        x.Oe(x.Reu + x.hew());
      }
    }
    
    public final void bh(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(197241);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      x.hey().add(new IDKey(x.dKP(), x.hez(), 1));
      long l2 = x.Reu + x.Rev;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        x.hey().add(new IDKey(x.dKP(), x.heA(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = x.heB();
        x.hey().add(new IDKey(x.dKP(), x.heC(), 1));
        x.hey().add(new IDKey(x.dKP(), x.heD(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (x.heJ() > 0L)
        {
          x.Oq(System.currentTimeMillis() - x.heJ());
          x.hey().add(new IDKey(x.dKP(), x.heK(), x.heL()));
        }
        e.Cxv.b(x.hey(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = x.Rec.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, x.Rec.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(x.Rec.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = x.heE();
          x.hey().add(new IDKey(x.dKP(), x.heF(), 1));
          x.hey().add(new IDKey(x.dKP(), x.ekS(), l1));
        }
        else
        {
          i = x.heG();
          x.hey().add(new IDKey(x.dKP(), x.heH(), 1));
          x.hey().add(new IDKey(x.dKP(), x.heI(), l1));
        }
      }
      Object localObject1 = x.ets().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        Log.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, x.ets().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(x.ets().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = x.hev().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      localObject2 = g.getExternalStorageDirectory().getPath();
      paramBoolean1 = b.aKE().equals(localObject2);
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
        e.Cxv.a(x.heM(), new Object[] { Integer.valueOf(i), Long.valueOf(x.heL()), Long.valueOf(l2), Long.valueOf(x.Reu), Long.valueOf(x.Rev), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(x.byT()), Integer.valueOf((int)x.heN()), Integer.valueOf((int)x.heO()), Long.valueOf(x.heP()), Long.valueOf(x.heQ()), Long.valueOf(x.Rer), Long.valueOf(x.heR()), Long.valueOf(x.heS()), Long.valueOf(x.heT()), Integer.valueOf(x.cAB()), Integer.valueOf(x.heU()), Long.valueOf(x.heV()), Integer.valueOf(x.fGe()), Integer.valueOf(1), Long.valueOf(l1) });
        Log.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", new Object[] { Integer.valueOf(i), Long.valueOf(x.heL()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(x.byT()), Float.valueOf(x.heN()), Float.valueOf(x.heO()), Long.valueOf(x.heP()), Long.valueOf(x.heQ()), Long.valueOf(x.Rer), Long.valueOf(x.heR()), Long.valueOf(x.heS()), Long.valueOf(x.heT()), Integer.valueOf(x.cAB()), Integer.valueOf(x.heU()), Long.valueOf(x.heV()), Integer.valueOf(x.fGe()), Integer.valueOf(1), Long.valueOf(l1) });
        AppMethodBeat.o(197241);
        return;
        localObject2 = new StatFs(b.aKE());
        j = ((StatFs)localObject2).getBlockSize();
        k = ((StatFs)localObject2).getAvailableBlocks();
        l1 = k * j;
      }
    }
    
    public final void hdV()
    {
      AppMethodBeat.i(197240);
      Log.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      x.resetParams();
      x.Op(System.currentTimeMillis());
      x.hey().add(new IDKey(x.dKP(), x.hex(), 1));
      AppMethodBeat.o(197240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.x
 * JD-Core Version:    0.7.0.1
 */