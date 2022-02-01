package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.i;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  implements com.tencent.mm.ak.g, c.a
{
  static int xPI = 0;
  private static final int xPJ;
  Set<b> cqb;
  LinkedList<com.tencent.mm.plugin.sns.data.n> fBS;
  private ao handler;
  public final byte[] mLock;
  private long xPK;
  private int xPL;
  private int xPM;
  private LinkedList<com.tencent.mm.plugin.sns.data.o> xPN;
  public HashMap<String, Long> xPO;
  private HashMap<String, String> xPP;
  public boolean xPQ;
  public Set<a> xPR;
  private Map<String, Long> xPS;
  Map<String, com.tencent.mm.plugin.sns.data.d> xPT;
  ConcurrentHashMap<String, AtomicInteger> xPU;
  ConcurrentHashMap<String, String> xPV;
  public ConcurrentHashMap<String, c> xPW;
  public CopyOnWriteArrayList<String> xPX;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      xPJ = i;
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.xPK = 0L;
    this.xPL = 0;
    this.xPM = 2;
    this.xPN = new LinkedList();
    this.xPO = new HashMap();
    this.mLock = new byte[0];
    this.xPP = new HashMap();
    this.xPQ = true;
    this.cqb = new HashSet();
    this.xPR = new HashSet();
    this.fBS = new LinkedList();
    this.xPS = new ConcurrentHashMap();
    this.xPT = new HashMap();
    this.xPU = new ConcurrentHashMap();
    this.xPV = new ConcurrentHashMap();
    this.xPW = new ConcurrentHashMap();
    this.xPX = new CopyOnWriteArrayList();
    this.handler = af.cMM();
    dHc();
    AppMethodBeat.o(95422);
  }
  
  private boolean UA()
  {
    AppMethodBeat.i(95437);
    if (bs.pN(this.xPK) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private boolean a(btz parambtz, int paramInt, m paramm, bf parambf, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!com.tencent.mm.plugin.sns.data.q.ata(af.getAccPath()))
    {
      ac.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { af.getAccPath(), com.tencent.mm.loader.j.b.apb() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((parambtz.Id.startsWith("Locall_path")) || (parambtz.Id.startsWith("pre_temp_sns_pic")))
    {
      ac.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.q.bT(paramInt, parambtz.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.xPT.containsKey(str))
        {
          ac.i("MicroMsg.DownloadManager", "add list %s", new Object[] { parambtz.Id });
          this.xPT.put(str, new com.tencent.mm.plugin.sns.data.d(paramm, paramInt));
          paramm = new com.tencent.mm.plugin.sns.data.n(parambtz, paramInt, str, parambf, paramString1, paramString2);
          this.fBS.add(paramm);
          if (!bs.isNullOrNil(paramString3))
          {
            parambf = com.tencent.mm.plugin.sns.data.q.asT(paramString3);
            ac.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, parambtz.Id, parambf });
            if (this.xPU.containsKey(parambf))
            {
              paramm = (AtomicInteger)this.xPU.get(parambf);
              parambtz = paramm;
              if (paramm == null) {
                parambtz = new AtomicInteger(0);
              }
              paramInt = parambtz.incrementAndGet();
              ac.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label300:
              this.xPV.put(str, parambf);
            }
          }
          else
          {
            ac.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(af.dHQ().dHv()), Integer.valueOf(this.xPS.size()) });
            ac.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.xPT.size()), Integer.valueOf(this.xPN.size()) });
            if (Looper.myLooper() == null) {
              break label566;
            }
            Looper.myQueue().addIdleHandler(new d());
            dHe();
            dHf();
            if (this.fBS.size() > 0) {
              aEU();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          parambtz = new AtomicInteger(0);
          paramInt = parambtz.incrementAndGet();
          this.xPU.put(parambf, parambtz);
        }
      }
      paramm = this.fBS.iterator();
      if (paramm.hasNext())
      {
        parambf = (com.tencent.mm.plugin.sns.data.n)paramm.next();
        if ((parambf.dwE == null) || (!parambf.dwE.Id.equals(parambtz.Id)) || (parambf.requestType != paramInt)) {
          break label300;
        }
        if (this.fBS.remove(parambf)) {
          this.fBS.addLast(parambf);
        }
        ac.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label566:
        ac.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean att(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!bs.isNullOrNil(paramString)) && (this.xPV.containsKey(paramString)))
    {
      paramString = (String)this.xPV.remove(paramString);
      if (!bs.isNullOrNil(paramString))
      {
        if (this.xPU.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.xPU.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            ac.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.xPU.remove(paramString);
            }
            AppMethodBeat.o(95428);
            return true;
          }
          ac.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", new Object[] { paramString });
        }
        AppMethodBeat.o(95428);
        return false;
      }
    }
    AppMethodBeat.o(95428);
    return false;
  }
  
  private static boolean aty(String paramString)
  {
    AppMethodBeat.i(95442);
    if ((paramString == null) || (paramString.equals("")))
    {
      ac.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95442);
      return false;
    }
    AppMethodBeat.o(95442);
    return true;
  }
  
  private void dHc()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.fBS.clear();
      this.xPT.clear();
      this.xPS.clear();
      this.xPN.clear();
      this.xPO.clear();
      this.xPU.clear();
      this.xPV.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean dHd()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.xPN != null) && (this.xPN.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.o localo = (com.tencent.mm.plugin.sns.data.o)this.xPN.remove();
        new aw().x(new com.tencent.mm.plugin.sns.data.o[] { localo });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void dHe()
  {
    AppMethodBeat.i(95435);
    if (UA()) {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95416);
          b.a(b.this);
          AppMethodBeat.o(95416);
        }
      }, 500L);
    }
    AppMethodBeat.o(95435);
  }
  
  private void dHf()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.xPS.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.xPS.containsKey(localObject2)) && (bs.pN(((Long)this.xPS.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        ac.d("MicroMsg.DownloadManager", "too long to download");
        this.xPS.remove(localObject2);
        this.xPT.remove(localObject2);
        att((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(int paramInt1, btz parambtz, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (parambtz == null) {}
    for (??? = Integer.valueOf(-1);; ??? = parambtz.Id)
    {
      ac.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!af.dHA())
      {
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agP().afY()) {
          break;
        }
      }
      dHc();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.xPL += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.xPL > 512000) && (this.fBS.size() == 0))
        {
          ac.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.xPL) });
          ar.a.hnx.cZ(this.xPL, 0);
          this.xPL = 0;
          break label809;
          if (paramBoolean2) {
            this.xPO.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (parambtz != null))
          {
            ??? = af.dHO();
            ac.d("MicroMsg.LazyerImageLoader2", "updateCache " + parambtz.Id);
            Object localObject2 = com.tencent.mm.plugin.sns.data.q.bS(1, parambtz.Id);
            localObject2 = (com.tencent.mm.memory.n)((f)???).xQe.get((String)localObject2);
            if (com.tencent.mm.plugin.sns.data.q.b((com.tencent.mm.memory.n)localObject2))
            {
              ((com.tencent.mm.memory.n)localObject2).avU();
              ac.d("MicroMsg.LazyerImageLoader2", "force update");
              af.dHE().execute(new f.2((f)???, parambtz));
            }
          }
        }
      }
      label742:
      while (9 != paramInt2)
      {
        for (;;)
        {
          synchronized (this.mLock)
          {
            for (;;)
            {
              ac.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              if (paramBoolean2) {
                this.xPS.remove(paramString);
              }
              aEU();
              p(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (parambtz != null) {}
              try
              {
                ??? = atA(parambtz.Id);
                if ((??? != null) && (((c)???).gnd) && (((c)???).gnd))
                {
                  long l = bs.Ap(((c)???).startTime);
                  ac.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).dnn, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.h.wUl.n(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.h.wUl.dB(1040, 1);
                }
                paramString = this.cqb.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label802;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (parambtz == null)) {
                      break label742;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).dGO();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.xPO.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            parambtz = finally;
            AppMethodBeat.o(95444);
            throw parambtz;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).atn(parambtz.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).bF(parambtz.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).bG(parambtz.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (parambtz != null)) {
              ((b)???).bF(parambtz.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (parambtz != null)) {
              ((b)???).bG(parambtz.Id, false);
            }
          }
        }
        AppMethodBeat.o(95444);
        return;
      }
      label802:
      label809:
      if (paramInt1 != 1) {
        if (paramInt1 != 3) {}
      }
    }
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(95425);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95413);
        b localb = b.this;
        b.b localb1 = paramb;
        localb.cqb.add(localb1);
        int i = b.xPI + 1;
        b.xPI = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(208, localb);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<btz> arg2, SparseArray<m> paramSparseArray1, bf parambf, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      az.aub(((btz)???.valueAt(i)).Id);
      i += 1;
    }
    if (!com.tencent.mm.plugin.sns.data.q.ata(af.getAccPath()))
    {
      ac.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { af.getAccPath(), com.tencent.mm.loader.j.b.apb() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (btz)???.get(k);
      if ((!((btz)localObject).Id.startsWith("Locall_path")) && (!((btz)localObject).Id.startsWith("pre_temp_sns_pic"))) {
        localSparseArray.put(k, localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        paramSparseArray1.remove(k);
      }
    }
    if (localSparseArray.size() <= 0)
    {
      ac.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(95431);
      return;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.q.asT(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.xPU.containsKey(localObject)) {
          break label521;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.xPU.get(localObject);
        if (localAtomicInteger == null) {
          break label521;
        }
        i = localAtomicInteger.get();
        ac.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label521;
        }
        ac.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.xPT.containsKey(localObject)))
        {
          ac.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { paramString });
          this.xPT.put(localObject, new com.tencent.mm.plugin.sns.data.d(paramSparseArray1));
          this.fBS.add(new com.tencent.mm.plugin.sns.data.n(paramString, localSparseArray, (String)localObject, parambf, paramInt));
          continue;
          if (Looper.myLooper() == null) {
            break label510;
          }
          Looper.myQueue().addIdleHandler(new d());
          dHe();
          dHf();
          if (this.fBS.size() > 0)
          {
            ac.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            aEU();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.fBS.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.n)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.fBS.remove(paramSparseArray1)) {
          this.fBS.addLast(paramSparseArray1);
        }
        ac.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label510:
      ac.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label521:
      i = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!bs.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.xPW.get(paramString);
      if ((localc == null) || (!localc.dnn.equals(paramc.dnn))) {
        this.xPW.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95433);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.frw = 1;
    localh.field_fileType = 100;
    localh.frr = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.frE = parama;
    com.tencent.mm.modelvideo.o.aJz().a(localh, false);
    synchronized (this.xPP)
    {
      this.xPP.put(paramString1, paramString3);
      AppMethodBeat.o(95433);
      return;
    }
  }
  
  public final boolean a(btz parambtz, int paramInt, m paramm, bf parambf)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(parambtz, paramInt, paramm, parambf, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(btz parambtz, int paramInt, m paramm, bf parambf, String paramString)
  {
    AppMethodBeat.i(95430);
    if (parambtz == null)
    {
      ac.e("MicroMsg.DownloadManager", "unknow case media is null " + bs.eWi().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      az.aub(parambtz.Id);
      a(parambtz, paramInt, paramm, parambf, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(btz parambtz, int paramInt, m paramm, bf parambf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(200110);
    if (parambtz == null)
    {
      ac.e("MicroMsg.DownloadManager", "unknow case media is null " + bs.eWi().toString());
      AppMethodBeat.o(200110);
      return false;
    }
    synchronized (this.mLock)
    {
      az.aub(parambtz.Id);
      a(parambtz, paramInt, paramm, parambf, paramString1, paramString2, null);
      AppMethodBeat.o(200110);
      return true;
    }
  }
  
  public final void aEU()
  {
    AppMethodBeat.i(95443);
    if (!this.xPQ)
    {
      AppMethodBeat.o(95443);
      return;
    }
    if (af.dHA())
    {
      dHc();
      AppMethodBeat.o(95443);
      return;
    }
    if (!com.tencent.mm.plugin.sns.data.q.ata(af.getAccPath()))
    {
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.xPM;
    if (ab.ivl > 0) {
      i = ab.ivl;
    }
    com.tencent.mm.plugin.sns.data.n localn;
    btz localbtz;
    String str2;
    String str3;
    String str4;
    String str1;
    SparseArray localSparseArray1;
    m localm;
    SparseArray localSparseArray2;
    int j;
    Object localObject4;
    boolean bool1;
    label464:
    label501:
    Object localObject3;
    for (;;)
    {
      synchronized (this.mLock)
      {
        Object localObject1;
        if ((this.fBS.size() > 0) && (af.dHQ().dHv() + this.xPS.size() <= i))
        {
          ac.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(af.dHQ().dHv()), Integer.valueOf(this.xPS.size()), Integer.valueOf(this.fBS.size()), Integer.valueOf(this.xPM) });
          localn = (com.tencent.mm.plugin.sns.data.n)this.fBS.removeLast();
          if (localn == null)
          {
            AppMethodBeat.o(95443);
            return;
          }
          localbtz = localn.dwE;
          i = localn.requestType;
          str2 = localn.key;
          str3 = localn.xNz;
          str4 = localn.xNA;
          str1 = localn.dnn;
          localSparseArray1 = localn.xNC;
          if ((!this.xPT.containsKey(str2)) || (this.xPT.get(str2) == null))
          {
            this.xPT.remove(str2);
            att(str2);
            AppMethodBeat.o(95443);
            return;
          }
          localm = ((com.tencent.mm.plugin.sns.data.d)this.xPT.get(str2)).xMO;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.d)this.xPT.get(str2)).xMP;
          j = i;
          if (i != 1) {
            break label1526;
          }
          j = i;
          if (!localbtz.isAd) {
            break label1526;
          }
          j = 8;
          break label1526;
          boolean bool2 = true;
          localObject1 = localbtz.Fjh;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!bs.isNullOrNil(localbtz.Fjr)) {
              localObject4 = localbtz.Fjr;
            }
          }
          int k = localbtz.Fji;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (bs.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localbtz.ndI == 2)
            {
              localObject1 = localbtz.Url;
              i = localbtz.EUH;
              bool1 = bool2;
            }
          }
          if (!aty((String)localObject1))
          {
            this.xPT.remove(str2);
            att(str2);
            AppMethodBeat.o(95443);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localbtz.Fjo;
              i = localbtz.EUH;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (btz)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((btz)localObject4).Fjh;
              i = ((btz)localObject4).Fji;
              if ((!bs.isNullOrNil((String)localObject1)) || (((btz)localObject4).ndI != 2)) {
                break label1523;
              }
              localObject1 = ((btz)localObject4).Url;
              i = ((btz)localObject4).EUH;
              break label1545;
            }
            bool1 = false;
            localObject1 = localbtz.Url;
            i = localbtz.EUH;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!af.dHQ().isDownloading(str2))
          {
            ac.d("MicroMsg.DownloadManager", "to downLoad scene " + localbtz.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new o(localbtz, localbtz.Id, (String)localObject1, localbtz.ndI, bool1, j, str2), 0);
            af.dHQ().atP(str2);
          }
        }
        label714:
        AppMethodBeat.o(95443);
        return;
        if ((i != 1) && (i != 0)) {
          break label1501;
        }
        if (i == 0) {
          ac.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.xPS.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          ac.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localbtz == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.xPO.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.xPO.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.xPT.remove(str2);
          att(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localbtz == null)
          {
            localObject1 = str1;
            ac.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          ac.i("MicroMsg.DownloadManager", "to downLoad cdn " + localbtz.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localbtz.Id;
    }
    this.xPS.put(str2, Long.valueOf(bs.aNx()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.agS();
      i = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(68391, null), 0);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localn.size);
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xYb = localn.xNB;
      if (j != 4) {
        break label1301;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xXZ = true;
      label1164:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xXY = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xYa = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xRx = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).ji(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1310;
      }
      ac.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1245:
      break label1460;
    }
    for (;;)
    {
      label1246:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).dIZ();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).x(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localbtz.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xRy = localbtz;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xMO = localm;
      break label1143;
      label1301:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).xXZ = false;
      break label1164;
      label1310:
      if (j != 4) {
        break label1554;
      }
      ac.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.aAp().tJ("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (bs.getInt((String)((com.tencent.mm.storage.c)localObject3).eYV().get("CDNDownload"), 0) == 0) {
          break label1548;
        }
        bool1 = true;
      }
      label1371:
      ac.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localbtz.isAd), Boolean.valueOf(bool1) });
      if ((!localbtz.isAd) || (bool1)) {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.g(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      } else {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.h(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      }
    }
    for (;;)
    {
      localObject3 = new com.tencent.mm.plugin.sns.model.a.e(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1460:
      if (j != 6) {
        break label1246;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localbtz.Fjo;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).md5 = localbtz.Fjq;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1501:
      this.xPT.remove(str2);
      att(str2);
      break label714;
      label1523:
      break label1545;
      label1526:
      if ((j == 1) || (j == 5)) {
        break;
      }
      if (j != 7) {
        break label501;
      }
      break;
      label1545:
      break label464;
      label1548:
      bool1 = false;
      break label1371;
      label1554:
      if ((j != 2) && (j != 8)) {
        if (j != 3) {
          break label1245;
        }
      }
    }
  }
  
  public final void ar(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.xPM = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (ax.isWifi(ai.getContext()))
        {
          str = com.tencent.mm.m.g.ZY().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bs.isNullOrNil(str)) || (!com.tencent.mm.sdk.a.b.eUk())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bs.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bs.aLy(localObject[0]);
          paramInt = bs.aLy(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.q.aDH() - 8) * 60;
          if (paramInt >= 0) {
            break label467;
          }
          paramInt += 1440;
          String[] arrayOfString1 = str.split(";");
          i = 0;
          label140:
          if (i >= arrayOfString1.length) {
            continue;
          }
          if (bs.isNullOrNil(arrayOfString1[i])) {
            break label460;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            ac.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.m.g.ZY().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bs.aLy(arrayOfString2[0]);
        j = bs.aLy(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bs.aLy(arrayOfString2[0]);
        k = bs.aLy(arrayOfString2[1]) + k * 60;
        ac.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bs.aLy((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.xPM = j;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bs.m(localException) });
        ac.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.xPM) });
        AppMethodBeat.o(95421);
        return;
      }
      Object localObject = localObject[3];
      continue;
      label457:
      label460:
      label467:
      do
      {
        break label128;
        break;
        i += 1;
        break label140;
      } while (paramInt < 1440);
      paramInt -= 1440;
    }
  }
  
  public final c atA(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!bs.isNullOrNil(paramString))
    {
      paramString = (c)this.xPW.remove(paramString);
      if (paramString != null) {
        paramString.dHg();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void atB(String paramString)
  {
    AppMethodBeat.i(95449);
    this.xPX.add(paramString);
    AppMethodBeat.o(95449);
  }
  
  public final void atu(String paramString)
  {
    AppMethodBeat.i(95434);
    com.tencent.mm.modelvideo.o.aJz().k(paramString, null);
    synchronized (this.xPP)
    {
      this.xPP.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean atv(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.xPS.containsKey(com.tencent.mm.plugin.sns.data.q.bT(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.xPS.containsKey(com.tencent.mm.plugin.sns.data.q.bT(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.xPS.containsKey(com.tencent.mm.plugin.sns.data.q.bT(2, paramString))) || (this.xPS.containsKey(com.tencent.mm.plugin.sns.data.q.bT(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean atx(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.xPP)
    {
      if (this.xPP.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void atz(final String paramString)
  {
    AppMethodBeat.i(95445);
    af.cMM().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95417);
        b.a(b.this, paramString);
        b.this.p(paramString, -1, true);
        AppMethodBeat.o(95417);
      }
    });
    AppMethodBeat.o(95445);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(95426);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95414);
        b localb = b.this;
        b.b localb1 = paramb;
        localb.cqb.remove(localb1);
        int i = b.xPI - 1;
        b.xPI = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(208, localb);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(95446);
    ac.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (paramn.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (o)paramn;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.xRv == 2) || (paramString.xRv == 8))
      {
        paramn = this.cqb.iterator();
        while (paramn.hasNext())
        {
          localb = (b)paramn.next();
          if (localb != null) {
            localb.bF(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramn.getType() == 208)
    {
      paramn = this.cqb.iterator();
      while (paramn.hasNext())
      {
        localb = (b)paramn.next();
        if (localb != null) {
          if (paramString.xRv == 3) {
            localb.dGO();
          } else if ((paramString.xRv == 1) || (paramString.xRv == 5) || (paramString.xRv == 7)) {
            localb.atn(paramString.mediaId);
          } else if ((paramString.xRv == 2) || (paramString.xRv == 8)) {
            localb.bF(paramString.mediaId, true);
          }
        }
      }
    }
    AppMethodBeat.o(95446);
  }
  
  public final void p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95441);
    synchronized (this.mLock)
    {
      ac.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.d)this.xPT.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.d)localObject).requestType) {
          break label140;
        }
        localObject = (m)((com.tencent.mm.plugin.sns.data.d)localObject).xMP.get(paramInt);
        if (localObject != null) {
          af.dHO().a((m)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.xPT.remove(paramString);
          att(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.d)localObject).xMO;
      } while (localObject == null);
      af.dHO().a((m)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void iY(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void atn(String paramString);
    
    public abstract void bF(String paramString, boolean paramBoolean);
    
    public abstract void bG(String paramString, boolean paramBoolean);
    
    public abstract void dGO();
  }
  
  public static final class c
  {
    final String dnn;
    boolean gnd;
    private int hlt;
    private final byte[] lock;
    long startTime;
    public boolean xQb;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.dnn = paramString;
      this.hlt = paramInt;
      this.startTime = -1L;
      this.xQb = false;
      this.gnd = false;
      ac.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void dHg()
    {
      synchronized (this.lock)
      {
        if (this.hlt > 0) {
          this.hlt -= 1;
        }
        if (this.hlt == 0) {
          this.gnd = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.xQb) {
        synchronized (this.lock)
        {
          if (!this.xQb)
          {
            this.xQb = true;
            this.startTime = paramLong;
            ac.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.dnn, Long.valueOf(this.startTime), this });
          }
          AppMethodBeat.o(95419);
          return;
        }
      }
      AppMethodBeat.o(95419);
    }
  }
  
  final class d
    implements MessageQueue.IdleHandler
  {
    d() {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(95420);
      ac.d("MicroMsg.DownloadManager", "I run idleHandler ");
      b.a(b.this, bs.aNx());
      boolean bool = b.a(b.this);
      AppMethodBeat.o(95420);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b
 * JD-Core Version:    0.7.0.1
 */