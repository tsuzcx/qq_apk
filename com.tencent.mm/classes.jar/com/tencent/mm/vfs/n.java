package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static a HTc;
  private static int HTd;
  private static int HTe;
  private static int HTf;
  private static int HTg;
  private static int HTh;
  private static int HTi;
  private static int HTj;
  private static int HTk;
  private static int HTl;
  private static int HTm;
  private static int HTn;
  private static ArrayList<IDKey> HTo;
  private static int HTp;
  private static int HTq;
  private static int HTr;
  private static int HTs;
  private static HashMap<String, Long> HTt;
  private static HashMap<String, Long> HTu;
  private static long HTv;
  private static long HTw;
  private static long HTx;
  private static long HTy;
  private static long HTz;
  private static LinkedList<String> jhB;
  
  static
  {
    AppMethodBeat.i(192926);
    HTd = 1401;
    HTe = 0;
    HTf = 1;
    HTg = 2;
    HTh = 3;
    HTi = 4;
    HTj = 5;
    HTk = 6;
    HTl = 7;
    HTm = 8;
    HTn = 9;
    HTo = new ArrayList();
    HTp = 20047;
    HTq = 1;
    HTr = 2;
    HTs = 3;
    HTt = new HashMap();
    HTu = new HashMap();
    jhB = new LinkedList();
    HTt.put("sns", Long.valueOf(0L));
    HTt.put("sns_ad_landingpages", Long.valueOf(0L));
    HTt.put("finder", Long.valueOf(0L));
    HTt.put("brandicon", Long.valueOf(0L));
    HTt.put("bizcache", Long.valueOf(0L));
    HTt.put("openapi_cache", Long.valueOf(0L));
    HTt.put("CDNTemp", Long.valueOf(0L));
    HTt.put("vproxy", Long.valueOf(0L));
    HTt.put("backupRecover", Long.valueOf(0L));
    HTt.put("msgsynchronize", Long.valueOf(0L));
    HTu.put("oneday", Long.valueOf(0L));
    HTu.put("bizimg", Long.valueOf(0L));
    HTu.put("openim", Long.valueOf(0L));
    HTu.put("avatar", Long.valueOf(0L));
    HTu.put("wallet_images", Long.valueOf(0L));
    HTu.put("emoji", Long.valueOf(0L));
    HTv = -1L;
    HTw = 0L;
    HTx = 0L;
    HTy = -1L;
    HTz = -1L;
    AppMethodBeat.o(192926);
  }
  
  public static a fhX()
  {
    AppMethodBeat.i(192924);
    if (HTc == null)
    {
      HTc = new a((byte)0);
      localObject = a.gap();
      a locala = HTc;
      a.d locald = ((a)localObject).LDv;
      ((a)localObject).LDv = locala;
    }
    Object localObject = HTc;
    AppMethodBeat.o(192924);
    return localObject;
  }
  
  public static void resetParams()
  {
    AppMethodBeat.i(192925);
    HTo.clear();
    HTt.clear();
    HTu.clear();
    jhB.clear();
    HTv = -1L;
    HTw = 0L;
    HTx = 0L;
    HTy = -1L;
    HTz = -1L;
    AppMethodBeat.o(192925);
  }
  
  static final class a
    implements a.d, d
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(192921);
      ad.d("MicroMsg.VFSStatistics", "VFS statistics name:%s, fs:%s, phase:%s, params:%s", new Object[] { paramString, paramFileSystem.toString(), Integer.valueOf(paramInt), paramMap });
      if ((paramFileSystem instanceof ExpireFileSystem))
      {
        if (paramInt == 3)
        {
          l = ((Long)paramMap.get("deleteSize")).longValue();
          if (n.biV().containsKey(paramString)) {
            n.biV().put(paramString, Long.valueOf(((Long)n.biV().get(paramString)).longValue() + l));
          }
          for (;;)
          {
            n.wZ(n.HTw + l);
            AppMethodBeat.o(192921);
            return;
            n.biV().put(paramString, Long.valueOf(l));
          }
        }
      }
      else if (!(paramFileSystem instanceof QuotaFileSystem)) {}
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(192921);
        return;
      case 2: 
        n.nv(((Long)paramMap.get("totalSize")).longValue());
        AppMethodBeat.o(192921);
        return;
      }
      if (n.Hf() < 0L)
      {
        ad.e("MicroMsg.VFSStatistics", "quotaBeginSize is not initialize");
        n.fhY().add(paramString);
        AppMethodBeat.o(192921);
        return;
      }
      long l = n.Hf() - ((Long)paramMap.get("totalSize")).longValue();
      if (l <= 0L)
      {
        ad.e("MicroMsg.VFSStatistics", "deleteSize <= 0!, deleteSize:%d, quotaBeginSize:%d", new Object[] { Long.valueOf(l), Long.valueOf(n.Hf()) });
        n.fhY().add(paramString);
      }
      for (;;)
      {
        n.wT(n.HTx + l);
        n.nv(-1L);
        break;
        if (n.cUp().containsKey(paramString)) {
          n.cUp().put(paramString, Long.valueOf(((Long)n.cUp().get(paramString)).longValue() + l));
        } else {
          n.cUp().put(paramString, Long.valueOf(l));
        }
      }
    }
    
    public final void aM(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(192923);
      ad.i("MicroMsg.VFSStatistics", "onMaintenanceEnd");
      n.fhZ().add(new IDKey(n.bxP(), n.aSD(), 1));
      long l2 = n.HTw + n.HTx;
      long l1;
      int i;
      if (l2 / 1024L == 0L)
      {
        l1 = 1L;
        n.fhZ().add(new IDKey(n.bxP(), n.dSK(), l1));
        if (!paramBoolean1) {
          break label301;
        }
        i = n.fia();
        n.fhZ().add(new IDKey(n.bxP(), n.cUu(), 1));
        n.fhZ().add(new IDKey(n.bxP(), n.bwt(), l1));
      }
      StringBuilder localStringBuilder;
      for (;;)
      {
        if (n.bla() > 0L)
        {
          n.xb(System.currentTimeMillis() - n.bla());
          n.fhZ().add(new IDKey(n.bxP(), n.fie(), n.fif()));
        }
        e.vIY.b(n.fhZ(), true);
        localStringBuilder = new StringBuilder();
        localObject1 = n.biV().keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ad.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.biV().get(localObject2) });
          localStringBuilder.append((String)localObject2).append(":").append(n.biV().get(localObject2)).append(";");
        }
        l1 = l2 / 1024L;
        break;
        label301:
        if (paramBoolean2)
        {
          i = n.HTs;
          n.fhZ().add(new IDKey(n.bxP(), n.fib(), 1));
          n.fhZ().add(new IDKey(n.bxP(), n.bwu(), l1));
        }
        else
        {
          i = n.fic();
          n.fhZ().add(new IDKey(n.bxP(), n.bPz(), 1));
          n.fhZ().add(new IDKey(n.bxP(), n.fid(), l1));
        }
      }
      Object localObject1 = n.cUp().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        ad.d("MicroMsg.VFSStatistics", "name:%s, size:%d", new Object[] { localObject2, n.cUp().get(localObject2) });
        localStringBuilder.append((String)localObject2).append(":").append(n.cUp().get(localObject2)).append(";");
      }
      localObject1 = new StringBuilder();
      Object localObject2 = n.fhY().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(";");
      }
      e.vIY.f(n.bPB(), new Object[] { Integer.valueOf(i), Long.valueOf(n.fif()), Long.valueOf(l2), Long.valueOf(n.HTw), Long.valueOf(n.HTx), localStringBuilder.toString(), ((StringBuilder)localObject1).toString() });
      ad.i("MicroMsg.VFSStatistics", "onMaintenanceEnd report finish code:%d, costTime:%d, deleteSize:%d, result:%s, errList:%s", new Object[] { Integer.valueOf(i), Long.valueOf(n.fif()), Long.valueOf(l2), localStringBuilder.toString(), ((StringBuilder)localObject1).toString() });
      AppMethodBeat.o(192923);
    }
    
    public final void fhM()
    {
      AppMethodBeat.i(192922);
      ad.i("MicroMsg.VFSStatistics", "onMaintenanceBegin");
      n.resetParams();
      n.xa(System.currentTimeMillis());
      n.fhZ().add(new IDKey(n.bxP(), n.aDt(), 1));
      AppMethodBeat.o(192922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */