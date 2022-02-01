package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.i;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.al.f, c.a
{
  static int zfC = 0;
  private static final int zfD;
  Set<b> cAT;
  LinkedList<com.tencent.mm.plugin.sns.data.n> fVg;
  private ap handler;
  public final byte[] mLock;
  private long zfE;
  private int zfF;
  private int zfG;
  private LinkedList<com.tencent.mm.plugin.sns.data.o> zfH;
  public HashMap<String, Long> zfI;
  private HashMap<String, String> zfJ;
  public boolean zfK;
  public Set<a> zfL;
  private Map<String, Long> zfM;
  Map<String, com.tencent.mm.plugin.sns.data.d> zfN;
  ConcurrentHashMap<String, AtomicInteger> zfO;
  ConcurrentHashMap<String, String> zfP;
  public ConcurrentHashMap<String, c> zfQ;
  public CopyOnWriteArrayList<String> zfR;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      zfD = i;
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.zfE = 0L;
    this.zfF = 0;
    this.zfG = 2;
    this.zfH = new LinkedList();
    this.zfI = new HashMap();
    this.mLock = new byte[0];
    this.zfJ = new HashMap();
    this.zfK = true;
    this.cAT = new HashSet();
    this.zfL = new HashSet();
    this.fVg = new LinkedList();
    this.zfM = new ConcurrentHashMap();
    this.zfN = new HashMap();
    this.zfO = new ConcurrentHashMap();
    this.zfP = new ConcurrentHashMap();
    this.zfQ = new ConcurrentHashMap();
    this.zfR = new CopyOnWriteArrayList();
    this.handler = ag.cVf();
    dTp();
    AppMethodBeat.o(95422);
  }
  
  private boolean WR()
  {
    AppMethodBeat.i(95437);
    if (bt.rM(this.zfE) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private boolean a(byn parambyn, int paramInt, m paramm, bj parambj, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!com.tencent.mm.plugin.sns.data.q.ayf(ag.getAccPath()))
    {
      ad.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { ag.getAccPath(), com.tencent.mm.loader.j.b.arO() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((parambyn.Id.startsWith("Locall_path")) || (parambyn.Id.startsWith("pre_temp_sns_pic")))
    {
      ad.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.q.ca(paramInt, parambyn.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.zfN.containsKey(str))
        {
          ad.i("MicroMsg.DownloadManager", "add list %s", new Object[] { parambyn.Id });
          this.zfN.put(str, new com.tencent.mm.plugin.sns.data.d(paramm, paramInt));
          paramm = new com.tencent.mm.plugin.sns.data.n(parambyn, paramInt, str, parambj, paramString1, paramString2);
          this.fVg.add(paramm);
          if (!bt.isNullOrNil(paramString3))
          {
            parambj = com.tencent.mm.plugin.sns.data.q.axY(paramString3);
            ad.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, parambyn.Id, parambj });
            if (this.zfO.containsKey(parambj))
            {
              paramm = (AtomicInteger)this.zfO.get(parambj);
              parambyn = paramm;
              if (paramm == null) {
                parambyn = new AtomicInteger(0);
              }
              paramInt = parambyn.incrementAndGet();
              ad.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label300:
              this.zfP.put(str, parambj);
            }
          }
          else
          {
            ad.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(ag.dUd().dTH()), Integer.valueOf(this.zfM.size()) });
            ad.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.zfN.size()), Integer.valueOf(this.zfH.size()) });
            if (Looper.myLooper() == null) {
              break label566;
            }
            Looper.myQueue().addIdleHandler(new d());
            dTr();
            dTs();
            if (this.fVg.size() > 0) {
              aHZ();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          parambyn = new AtomicInteger(0);
          paramInt = parambyn.incrementAndGet();
          this.zfO.put(parambj, parambyn);
        }
      }
      paramm = this.fVg.iterator();
      if (paramm.hasNext())
      {
        parambj = (com.tencent.mm.plugin.sns.data.n)paramm.next();
        if ((parambj.dIQ == null) || (!parambj.dIQ.Id.equals(parambyn.Id)) || (parambj.requestType != paramInt)) {
          break label300;
        }
        if (this.fVg.remove(parambj)) {
          this.fVg.addLast(parambj);
        }
        ad.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label566:
        ad.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private static boolean ayD(String paramString)
  {
    AppMethodBeat.i(95442);
    if ((paramString == null) || (paramString.equals("")))
    {
      ad.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95442);
      return false;
    }
    AppMethodBeat.o(95442);
    return true;
  }
  
  private boolean ayy(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!bt.isNullOrNil(paramString)) && (this.zfP.containsKey(paramString)))
    {
      paramString = (String)this.zfP.remove(paramString);
      if (!bt.isNullOrNil(paramString))
      {
        if (this.zfO.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.zfO.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            ad.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.zfO.remove(paramString);
            }
            AppMethodBeat.o(95428);
            return true;
          }
          ad.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", new Object[] { paramString });
        }
        AppMethodBeat.o(95428);
        return false;
      }
    }
    AppMethodBeat.o(95428);
    return false;
  }
  
  private void dTp()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.fVg.clear();
      this.zfN.clear();
      this.zfM.clear();
      this.zfH.clear();
      this.zfI.clear();
      this.zfO.clear();
      this.zfP.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean dTq()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.zfH != null) && (this.zfH.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.o localo = (com.tencent.mm.plugin.sns.data.o)this.zfH.remove();
        new ax().x(new com.tencent.mm.plugin.sns.data.o[] { localo });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void dTr()
  {
    AppMethodBeat.i(95435);
    if (WR()) {
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
  
  private void dTs()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.zfM.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.zfM.containsKey(localObject2)) && (bt.rM(((Long)this.zfM.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        ad.d("MicroMsg.DownloadManager", "too long to download");
        this.zfM.remove(localObject2);
        this.zfN.remove(localObject2);
        ayy((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(int paramInt1, byn parambyn, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (parambyn == null) {}
    for (??? = Integer.valueOf(-1);; ??? = parambyn.Id)
    {
      ad.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!ag.dTN())
      {
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajA().aiK()) {
          break;
        }
      }
      dTp();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.zfF += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.zfF > 512000) && (this.fVg.size() == 0))
        {
          ad.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.zfF) });
          as.a.hFP.db(this.zfF, 0);
          this.zfF = 0;
          break label809;
          if (paramBoolean2) {
            this.zfI.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (parambyn != null))
          {
            ??? = ag.dUb();
            ad.d("MicroMsg.LazyerImageLoader2", "updateCache " + parambyn.Id);
            Object localObject2 = com.tencent.mm.plugin.sns.data.q.bZ(1, parambyn.Id);
            localObject2 = (com.tencent.mm.memory.n)((f)???).zfY.get((String)localObject2);
            if (com.tencent.mm.plugin.sns.data.q.b((com.tencent.mm.memory.n)localObject2))
            {
              ((com.tencent.mm.memory.n)localObject2).ayH();
              ad.d("MicroMsg.LazyerImageLoader2", "force update");
              ag.dTR().execute(new f.2((f)???, parambyn));
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
              ad.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              if (paramBoolean2) {
                this.zfM.remove(paramString);
              }
              aHZ();
              p(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (parambyn != null) {}
              try
              {
                ??? = ayF(parambyn.Id);
                if ((??? != null) && (((c)???).gGM) && (((c)???).gGM))
                {
                  long l = bt.Df(((c)???).startTime);
                  ad.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).dzb, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.g.yhR.n(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.g.yhR.dD(1040, 1);
                }
                paramString = this.cAT.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label802;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (parambyn == null)) {
                      break label742;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).dTb();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.zfI.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            parambyn = finally;
            AppMethodBeat.o(95444);
            throw parambyn;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).ays(parambyn.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).bM(parambyn.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).bN(parambyn.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (parambyn != null)) {
              ((b)???).bM(parambyn.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (parambyn != null)) {
              ((b)???).bN(parambyn.Id, false);
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
        localb.cAT.add(localb1);
        int i = b.zfC + 1;
        b.zfC = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(208, localb);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<byn> arg2, SparseArray<m> paramSparseArray1, bj parambj, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      ba.azg(((byn)???.valueAt(i)).Id);
      i += 1;
    }
    if (!com.tencent.mm.plugin.sns.data.q.ayf(ag.getAccPath()))
    {
      ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { ag.getAccPath(), com.tencent.mm.loader.j.b.arO() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (byn)???.get(k);
      if ((!((byn)localObject).Id.startsWith("Locall_path")) && (!((byn)localObject).Id.startsWith("pre_temp_sns_pic"))) {
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
      ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(95431);
      return;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.q.axY(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.zfO.containsKey(localObject)) {
          break label521;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.zfO.get(localObject);
        if (localAtomicInteger == null) {
          break label521;
        }
        i = localAtomicInteger.get();
        ad.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label521;
        }
        ad.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.zfN.containsKey(localObject)))
        {
          ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { paramString });
          this.zfN.put(localObject, new com.tencent.mm.plugin.sns.data.d(paramSparseArray1));
          this.fVg.add(new com.tencent.mm.plugin.sns.data.n(paramString, localSparseArray, (String)localObject, parambj, paramInt));
          continue;
          if (Looper.myLooper() == null) {
            break label510;
          }
          Looper.myQueue().addIdleHandler(new d());
          dTr();
          dTs();
          if (this.fVg.size() > 0)
          {
            ad.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            aHZ();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.fVg.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.n)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.fVg.remove(paramSparseArray1)) {
          this.fVg.addLast(paramSparseArray1);
        }
        ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label510:
      ad.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label521:
      i = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!bt.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.zfQ.get(paramString);
      if ((localc == null) || (!localc.dzb.equals(paramc.dzb))) {
        this.zfQ.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95433);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.fJi = "task_DownloadManager";
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.fJF = 1;
    localh.field_fileType = 100;
    localh.fJA = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.fJN = parama;
    com.tencent.mm.modelvideo.o.aMK().a(localh, false);
    synchronized (this.zfJ)
    {
      this.zfJ.put(paramString1, paramString3);
      AppMethodBeat.o(95433);
      return;
    }
  }
  
  public final boolean a(byn parambyn, int paramInt, m paramm, bj parambj)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(parambyn, paramInt, paramm, parambj, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(byn parambyn, int paramInt, m paramm, bj parambj, String paramString)
  {
    AppMethodBeat.i(95430);
    if (parambyn == null)
    {
      ad.e("MicroMsg.DownloadManager", "unknow case media is null " + bt.flS().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      ba.azg(parambyn.Id);
      a(parambyn, paramInt, paramm, parambj, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(byn parambyn, int paramInt, m paramm, bj parambj, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197841);
    if (parambyn == null)
    {
      ad.e("MicroMsg.DownloadManager", "unknow case media is null " + bt.flS().toString());
      AppMethodBeat.o(197841);
      return false;
    }
    synchronized (this.mLock)
    {
      ba.azg(parambyn.Id);
      a(parambyn, paramInt, paramm, parambj, paramString1, paramString2, null);
      AppMethodBeat.o(197841);
      return true;
    }
  }
  
  public final void aHZ()
  {
    AppMethodBeat.i(95443);
    if (!this.zfK)
    {
      AppMethodBeat.o(95443);
      return;
    }
    if (ag.dTN())
    {
      dTp();
      AppMethodBeat.o(95443);
      return;
    }
    if (!com.tencent.mm.plugin.sns.data.q.ayf(ag.getAccPath()))
    {
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.zfG;
    if (ac.iOs > 0) {
      i = ac.iOs;
    }
    com.tencent.mm.plugin.sns.data.n localn;
    byn localbyn;
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
        if ((this.fVg.size() > 0) && (ag.dUd().dTH() + this.zfM.size() <= i))
        {
          ad.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(ag.dUd().dTH()), Integer.valueOf(this.zfM.size()), Integer.valueOf(this.fVg.size()), Integer.valueOf(this.zfG) });
          localn = (com.tencent.mm.plugin.sns.data.n)this.fVg.removeLast();
          if (localn == null)
          {
            AppMethodBeat.o(95443);
            return;
          }
          localbyn = localn.dIQ;
          i = localn.requestType;
          str2 = localn.key;
          str3 = localn.zdt;
          str4 = localn.zdu;
          str1 = localn.dzb;
          localSparseArray1 = localn.zdw;
          if ((!this.zfN.containsKey(str2)) || (this.zfN.get(str2) == null))
          {
            this.zfN.remove(str2);
            ayy(str2);
            AppMethodBeat.o(95443);
            return;
          }
          localm = ((com.tencent.mm.plugin.sns.data.d)this.zfN.get(str2)).zcG;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.d)this.zfN.get(str2)).zcH;
          j = i;
          if (i != 1) {
            break label1526;
          }
          j = i;
          if (!localbyn.isAd) {
            break label1526;
          }
          j = 8;
          break label1526;
          boolean bool2 = true;
          localObject1 = localbyn.GSI;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!bt.isNullOrNil(localbyn.GSS)) {
              localObject4 = localbyn.GSS;
            }
          }
          int k = localbyn.GSJ;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (bt.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localbyn.nEf == 2)
            {
              localObject1 = localbyn.Url;
              i = localbyn.GEe;
              bool1 = bool2;
            }
          }
          if (!ayD((String)localObject1))
          {
            this.zfN.remove(str2);
            ayy(str2);
            AppMethodBeat.o(95443);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localbyn.GSP;
              i = localbyn.GEe;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (byn)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((byn)localObject4).GSI;
              i = ((byn)localObject4).GSJ;
              if ((!bt.isNullOrNil((String)localObject1)) || (((byn)localObject4).nEf != 2)) {
                break label1523;
              }
              localObject1 = ((byn)localObject4).Url;
              i = ((byn)localObject4).GEe;
              break label1545;
            }
            bool1 = false;
            localObject1 = localbyn.Url;
            i = localbyn.GEe;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!ag.dUd().isDownloading(str2))
          {
            ad.d("MicroMsg.DownloadManager", "to downLoad scene " + localbyn.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new o(localbyn, localbyn.Id, (String)localObject1, localbyn.nEf, bool1, j, str2), 0);
            ag.dUd().ayU(str2);
          }
        }
        label714:
        AppMethodBeat.o(95443);
        return;
        if ((i != 1) && (i != 0)) {
          break label1501;
        }
        if (i == 0) {
          ad.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.zfM.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          ad.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localbyn == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.zfI.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.zfI.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.zfN.remove(str2);
          ayy(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localbyn == null)
          {
            localObject1 = str1;
            ad.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          ad.i("MicroMsg.DownloadManager", "to downLoad cdn " + localbyn.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localbyn.Id;
    }
    this.zfM.put(str2, Long.valueOf(bt.aQJ()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.ajD();
      i = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(68391, null), 0);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localn.size);
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zoa = localn.zdv;
      if (j != 4) {
        break label1301;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).znY = true;
      label1164:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).znX = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).znZ = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zhr = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).ju(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1310;
      }
      ad.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1245:
      break label1460;
    }
    for (;;)
    {
      label1246:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).dVm();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).x(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localbyn.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zhs = localbyn;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zcG = localm;
      break label1143;
      label1301:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).znY = false;
      break label1164;
      label1310:
      if (j != 4) {
        break label1554;
      }
      ad.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.aDs().wz("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (bt.getInt((String)((com.tencent.mm.storage.c)localObject3).foF().get("CDNDownload"), 0) == 0) {
          break label1548;
        }
        bool1 = true;
      }
      label1371:
      ad.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localbyn.isAd), Boolean.valueOf(bool1) });
      if ((!localbyn.isAd) || (bool1)) {
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
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localbyn.GSP;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).md5 = localbyn.GSR;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1501:
      this.zfN.remove(str2);
      ayy(str2);
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
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.zfG = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (ay.isWifi(aj.getContext()))
        {
          str = com.tencent.mm.n.g.acA().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bt.isNullOrNil(str)) || (!com.tencent.mm.sdk.a.b.fjN())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bt.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bt.aRe(localObject[0]);
          paramInt = bt.aRe(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.q.aGM() - 8) * 60;
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
          if (bt.isNullOrNil(arrayOfString1[i])) {
            break label460;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            ad.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.n.g.acA().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bt.aRe(arrayOfString2[0]);
        j = bt.aRe(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bt.aRe(arrayOfString2[0]);
        k = bt.aRe(arrayOfString2[1]) + k * 60;
        ad.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bt.aRe((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.zfG = j;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bt.n(localException) });
        ad.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.zfG) });
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
  
  public final boolean ayA(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.zfM.containsKey(com.tencent.mm.plugin.sns.data.q.ca(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.zfM.containsKey(com.tencent.mm.plugin.sns.data.q.ca(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean ayB(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.zfM.containsKey(com.tencent.mm.plugin.sns.data.q.ca(2, paramString))) || (this.zfM.containsKey(com.tencent.mm.plugin.sns.data.q.ca(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean ayC(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.zfJ)
    {
      if (this.zfJ.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void ayE(final String paramString)
  {
    AppMethodBeat.i(95445);
    ag.cVf().post(new Runnable()
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
  
  public final c ayF(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = (c)this.zfQ.remove(paramString);
      if (paramString != null) {
        paramString.dTt();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void ayG(String paramString)
  {
    AppMethodBeat.i(95449);
    this.zfR.add(paramString);
    AppMethodBeat.o(95449);
  }
  
  public final void ayz(String paramString)
  {
    AppMethodBeat.i(95434);
    com.tencent.mm.modelvideo.o.aMK().m(paramString, null);
    synchronized (this.zfJ)
    {
      this.zfJ.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
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
        localb.cAT.remove(localb1);
        int i = b.zfC - 1;
        b.zfC = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.b(208, localb);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(95446);
    ad.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (paramn.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (o)paramn;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.zhp == 2) || (paramString.zhp == 8))
      {
        paramn = this.cAT.iterator();
        while (paramn.hasNext())
        {
          localb = (b)paramn.next();
          if (localb != null) {
            localb.bM(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramn.getType() == 208)
    {
      paramn = this.cAT.iterator();
      while (paramn.hasNext())
      {
        localb = (b)paramn.next();
        if (localb != null) {
          if (paramString.zhp == 3) {
            localb.dTb();
          } else if ((paramString.zhp == 1) || (paramString.zhp == 5) || (paramString.zhp == 7)) {
            localb.ays(paramString.mediaId);
          } else if ((paramString.zhp == 2) || (paramString.zhp == 8)) {
            localb.bM(paramString.mediaId, true);
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
      ad.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.d)this.zfN.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.d)localObject).requestType) {
          break label140;
        }
        localObject = (m)((com.tencent.mm.plugin.sns.data.d)localObject).zcH.get(paramInt);
        if (localObject != null) {
          ag.dUb().a((m)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.zfN.remove(paramString);
          ayy(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.d)localObject).zcG;
      } while (localObject == null);
      ag.dUb().a((m)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void jk(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void ays(String paramString);
    
    public abstract void bM(String paramString, boolean paramBoolean);
    
    public abstract void bN(String paramString, boolean paramBoolean);
    
    public abstract void dTb();
  }
  
  public static final class c
  {
    final String dzb;
    boolean gGM;
    private int hDC;
    private final byte[] lock;
    long startTime;
    public boolean zfV;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.dzb = paramString;
      this.hDC = paramInt;
      this.startTime = -1L;
      this.zfV = false;
      this.gGM = false;
      ad.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void dTt()
    {
      synchronized (this.lock)
      {
        if (this.hDC > 0) {
          this.hDC -= 1;
        }
        if (this.hDC == 0) {
          this.gGM = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.zfV) {
        synchronized (this.lock)
        {
          if (!this.zfV)
          {
            this.zfV = true;
            this.startTime = paramLong;
            ad.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.dzb, Long.valueOf(this.startTime), this });
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
      ad.d("MicroMsg.DownloadManager", "I run idleHandler ");
      b.a(b.this, bt.aQJ());
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