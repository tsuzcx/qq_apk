package com.tencent.mm.vfs;

import android.os.StatFs;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class t
{
  private static a LHL;
  private static int LHM;
  private static int LHN;
  private static int LHO;
  private static int LHP;
  private static int LHQ;
  private static int LHR;
  private static int LHS;
  private static int LHT;
  private static int LHU;
  private static int LHV;
  private static int LHW;
  private static ArrayList<IDKey> LHX;
  private static int LHY;
  private static int LHZ;
  private static int LIa;
  private static int LIb;
  private static HashMap<String, Long> LIc;
  private static HashMap<String, Long> LId;
  private static int LIe;
  private static float LIf;
  private static int LIg;
  private static float LIh;
  private static long LIi;
  private static long LIj;
  private static long LIk;
  private static long LIl;
  private static long LIm;
  private static int LIn;
  private static int LIo;
  private static long LIp;
  private static long LIq;
  private static long LIr;
  private static long LIs;
  private static long LIt;
  private static long LIu;
  private static long LIv;
  private static long LIw;
  private static LinkedList<String> kft;
  private static long paG;
  
  static
  {
    AppMethodBeat.i(193655);
    LHM = 1401;
    LHN = 0;
    LHO = 1;
    LHP = 2;
    LHQ = 3;
    LHR = 4;
    LHS = 5;
    LHT = 6;
    LHU = 7;
    LHV = 8;
    LHW = 9;
    LHX = new ArrayList();
    LHY = 20047;
    LHZ = 1;
    LIa = 2;
    LIb = 3;
    LIc = new HashMap();
    LId = new HashMap();
    kft = new LinkedList();
    LIe = 0;
    LIf = -1.0F;
    LIg = 0;
    LIh = -1.0F;
    LIi = 0L;
    LIj = 0L;
    paG = 0L;
    LIk = -1L;
    LIl = -1L;
    LIm = -1L;
    LIn = -1;
    LIo = -1;
    LIp = -1L;
    LIq = -1L;
    LIr = 0L;
    LIc.put("sns", Long.valueOf(0L));
    LIc.put("sns_ad_landingpages", Long.valueOf(0L));
    LIc.put("finder", Long.valueOf(0L));
    LIc.put("brandicon", Long.valueOf(0L));
    LIc.put("bizcache", Long.valueOf(0L));
    LIc.put("openapi_cache", Long.valueOf(0L));
    LIc.put("CDNTemp", Long.valueOf(0L));
    LIc.put("vproxy", Long.valueOf(0L));
    LIc.put("backupRecover", Long.valueOf(0L));
    LIc.put("msgsynchronize", Long.valueOf(0L));
    LId.put("oneday", Long.valueOf(0L));
    LId.put("bizimg", Long.valueOf(0L));
    LId.put("openim", Long.valueOf(0L));
    LId.put("avatar", Long.valueOf(0L));
    LId.put("wallet_images", Long.valueOf(0L));
    LId.put("emoji", Long.valueOf(0L));
    LIs = -1L;
    LIt = 0L;
    LIu = 0L;
    LIv = -1L;
    LIw = -1L;
    AppMethodBeat.o(193655);
  }
  
  public static a fTk()
  {
    AppMethodBeat.i(193653);
    if (LHL == null)
    {
      LHL = new a((byte)0);
      localObject = e.fSU();
      a locala = LHL;
      e.d locald = ((e)localObject).OAN;
      ((e)localObject).OAN = locala;
    }
    Object localObject = LHL;
    AppMethodBeat.o(193653);
    return localObject;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(193654);
    LHX.clear();
    LIc.clear();
    LId.clear();
    kft.clear();
    LIs = -1L;
    LIt = 0L;
    LIu = 0L;
    LIv = -1L;
    LIw = -1L;
    LIe = 0;
    LIf = -1.0F;
    LIg = 0;
    LIh = -1.0F;
    LIi = 0L;
    LIj = 0L;
    paG = 0L;
    LIk = -1L;
    LIk = -1L;
    LIl = -1L;
    LIm = -1L;
    LIn = -1;
    LIo = -1;
    LIp = -1L;
    LIq = -1L;
    LIr = 0L;
    AppMethodBeat.o(193654);
  }
  
  static final class a
    implements e.d, j.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(193650);
      ae.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      long l;
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (t.LIc.containsKey(paramString)) {
            t.LIc.put(paramString, Long.valueOf(((Long)t.LIc.get(paramString)).longValue() + l));
          }
          for (;;)
          {
            t.EX(t.LIt + l);
            AppMethodBeat.o(193650);
            return;
            t.LIc.put(paramString, Long.valueOf(l));
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
            AppMethodBeat.o(193650);
            return;
          case 2: 
            t.EY(((Long)paramMap.get("totalSize")).longValue());
            AppMethodBeat.o(193650);
            return;
          }
          if (t.It() < 0L)
          {
            ae.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
            t.fTl().add(paramString);
            AppMethodBeat.o(193650);
            return;
          }
          l = t.It() - ((Long)paramMap.get("totalSize")).longValue();
          if (l <= 0L)
          {
            ae.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(t.It()) });
            t.fTl().add(paramString);
          }
          for (;;)
          {
            t.EQ(t.LIu + l);
            t.EY(-1L);
            break;
            if (t.dvx().containsKey(paramString)) {
              t.dvx().put(paramString, Long.valueOf(((Long)t.dvx().get(paramString)).longValue() + l));
            } else {
              t.dvx().put(paramString, Long.valueOf(l));
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
        AppMethodBeat.o(193650);
        return;
        t.EZ(System.currentTimeMillis());
        t.Fa(-1L);
        t.Fb(0L);
        AppMethodBeat.o(193650);
        return;
        if (t.bwK() > 0L)
        {
          t.Fa(System.currentTimeMillis() - t.bwK());
          t.EZ(-1L);
        }
        t.agz(((Integer)paramMap.get("cleanStorageCount")).intValue());
        t.cc(((Float)paramMap.get("cleanRepetitionRatio")).floatValue());
        t.agA(((Integer)paramMap.get("cleanRepetitionRatioCount")).intValue());
        t.cd(((Float)paramMap.get("cleanStorageRepetitionRatio")).floatValue());
        t.Fc(((Long)paramMap.get("cleanStorageDeleteSize")).longValue());
        t.Fd(((Long)paramMap.get("cleanStorageFreeSize")).longValue());
        t.Fe(((Long)paramMap.get("deleteSize")).longValue());
        t.Ff(((Long)paramMap.get("cleanOriginExpireTime")).longValue());
        t.Fg(((Long)paramMap.get("cleanNewExpireTime")).longValue());
        t.Fh(((Long)paramMap.get("cleanExtraCostTime")).longValue());
        t.agB(((Integer)paramMap.get("cleanTrend")).intValue());
        t.agC(((Integer)paramMap.get("changeSwitch")).intValue());
        t.Fb(t.LIr + t.fTm());
        t.EX(t.LIt + t.fTm());
      }
    }
    
    public final void aX(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(193652);
      ae.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      t.fTo().add(new IDKey(t.fTn(), t.fTp(), 1));
      long l2 = t.LIt + t.LIu;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        t.fTo().add(new IDKey(t.fTn(), t.fTq(), l1));
        if (!paramBoolean1) {
          break label304;
        }
        i = t.fTr();
        t.fTo().add(new IDKey(t.fTn(), t.dAt(), 1));
        t.fTo().add(new IDKey(t.fTn(), t.fTs(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (t.fTy() > 0L)
        {
          t.Fj(System.currentTimeMillis() - t.fTy());
          t.fTo().add(new IDKey(t.fTn(), t.fTz(), t.fTA()));
        }
        com.tencent.mm.plugin.report.e.ywz.b(t.fTo(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = t.LIc.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ae.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, t.LIc.get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(t.LIc.get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label304:
        if (paramBoolean2)
        {
          i = t.fTt();
          t.fTo().add(new IDKey(t.fTn(), t.fTu(), 1));
          t.fTo().add(new IDKey(t.fTn(), t.dqY(), l1));
        }
        else
        {
          i = t.fTv();
          t.fTo().add(new IDKey(t.fTn(), t.fTw(), 1));
          t.fTo().add(new IDKey(t.fTn(), t.fTx(), l1));
        }
      }
      Object localObject1 = t.dvx().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ae.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, t.dvx().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(t.dvx().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = t.fTl().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      localObject2 = g.getExternalStorageDirectory().getPath();
      if (b.ase().equals(localObject2)) {
        localObject2 = new StatFs((String)localObject2);
      }
      int j;
      for (long l1 = ((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks();; l1 = ((StatFs)localObject2).getAvailableBlocks() * j)
      {
        v.fTP();
        com.tencent.mm.plugin.report.e.ywz.f(t.fTB(), new Object[] { Integer.valueOf(i), Long.valueOf(t.fTA()), Long.valueOf(l2), Long.valueOf(t.LIt), Long.valueOf(t.LIu), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(t.bdC()), Integer.valueOf((int)t.fTC()), Integer.valueOf((int)t.fTD()), Long.valueOf(t.fTE()), Long.valueOf(t.fTF()), Long.valueOf(t.LIr), Long.valueOf(t.fTG()), Long.valueOf(t.fTH()), Long.valueOf(t.fTI()), Integer.valueOf(t.ccH()), Integer.valueOf(t.fTJ()), Long.valueOf(t.fTK()), Integer.valueOf(t.ezo()), Integer.valueOf(1), Long.valueOf(l1) });
        ae.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s, storageCount:%d, repetitionRatio:%s, storageRepetitionRatio:%s, storageDeleteSize:%d, storageFreeSize:%d, vfsCleanExpireDeleteSize:%d, newExpireTime:%d, cleanExtraCostTime:%d, vfsCleanExpireCostTime:%d, cleanTrend:%d, changeSwitch:%d, originExpireTime:%d, repetitionRatioCount:%d, isVFSOpened:%d, availableSize:%d", new Object[] { Integer.valueOf(i), Long.valueOf(t.fTA()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), Integer.valueOf(t.bdC()), Float.valueOf(t.fTC()), Float.valueOf(t.fTD()), Long.valueOf(t.fTE()), Long.valueOf(t.fTF()), Long.valueOf(t.LIr), Long.valueOf(t.fTG()), Long.valueOf(t.fTH()), Long.valueOf(t.fTI()), Integer.valueOf(t.ccH()), Integer.valueOf(t.fTJ()), Long.valueOf(t.fTK()), Integer.valueOf(t.ezo()), Integer.valueOf(1), Long.valueOf(l1) });
        AppMethodBeat.o(193652);
        return;
        localObject2 = new StatFs(b.ase());
        j = ((StatFs)localObject2).getBlockSize();
      }
    }
    
    public final void fSW()
    {
      AppMethodBeat.i(193651);
      ae.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      t.resetParams();
      t.Fi(System.currentTimeMillis());
      t.fTo().add(new IDKey(t.fTn(), t.ccJ(), 1));
      AppMethodBeat.o(193651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.t
 * JD-Core Version:    0.7.0.1
 */