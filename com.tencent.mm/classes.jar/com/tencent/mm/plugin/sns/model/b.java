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
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.i;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  implements com.tencent.mm.al.g, c.a
{
  static int wDn = 0;
  private static final int wDo;
  Set<b> csT;
  LinkedList<com.tencent.mm.plugin.sns.data.n> fyl;
  private ap handler;
  public final byte[] mLock;
  ConcurrentHashMap<String, String> wDA;
  public ConcurrentHashMap<String, c> wDB;
  public CopyOnWriteArrayList<String> wDC;
  private long wDp;
  private int wDq;
  private int wDr;
  private LinkedList<com.tencent.mm.plugin.sns.data.o> wDs;
  public HashMap<String, Long> wDt;
  private HashMap<String, String> wDu;
  public boolean wDv;
  public Set<a> wDw;
  private Map<String, Long> wDx;
  Map<String, com.tencent.mm.plugin.sns.data.d> wDy;
  ConcurrentHashMap<String, AtomicInteger> wDz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      wDo = i;
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.wDp = 0L;
    this.wDq = 0;
    this.wDr = 2;
    this.wDs = new LinkedList();
    this.wDt = new HashMap();
    this.mLock = new byte[0];
    this.wDu = new HashMap();
    this.wDv = true;
    this.csT = new HashSet();
    this.wDw = new HashSet();
    this.fyl = new LinkedList();
    this.wDx = new ConcurrentHashMap();
    this.wDy = new HashMap();
    this.wDz = new ConcurrentHashMap();
    this.wDA = new ConcurrentHashMap();
    this.wDB = new ConcurrentHashMap();
    this.wDC = new CopyOnWriteArrayList();
    this.handler = af.czA();
    dsE();
    AppMethodBeat.o(95422);
  }
  
  private boolean TG()
  {
    AppMethodBeat.i(95437);
    if (bt.lZ(this.wDp) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private boolean a(bpi parambpi, int paramInt, m paramm, bc parambc, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!com.tencent.mm.plugin.sns.data.q.anO(af.getAccPath()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { af.getAccPath(), com.tencent.mm.loader.j.b.aib() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((parambpi.Id.startsWith("Locall_path")) || (parambpi.Id.startsWith("pre_temp_sns_pic")))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.q.bP(paramInt, parambpi.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.wDy.containsKey(str))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "add list %s", new Object[] { parambpi.Id });
          this.wDy.put(str, new com.tencent.mm.plugin.sns.data.d(paramm, paramInt));
          paramm = new com.tencent.mm.plugin.sns.data.n(parambpi, paramInt, str, parambc, paramString1, paramString2);
          this.fyl.add(paramm);
          if (!bt.isNullOrNil(paramString3))
          {
            parambc = com.tencent.mm.plugin.sns.data.q.anH(paramString3);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, parambpi.Id, parambc });
            if (this.wDz.containsKey(parambc))
            {
              paramm = (AtomicInteger)this.wDz.get(parambc);
              parambpi = paramm;
              if (paramm == null) {
                parambpi = new AtomicInteger(0);
              }
              paramInt = parambpi.incrementAndGet();
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label300:
              this.wDA.put(str, parambc);
            }
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(af.dtt().dsY()), Integer.valueOf(this.wDx.size()) });
            com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.wDy.size()), Integer.valueOf(this.wDs.size()) });
            if (Looper.myLooper() == null) {
              break label566;
            }
            Looper.myQueue().addIdleHandler(new d());
            dsG();
            dsH();
            if (this.fyl.size() > 0) {
              ayc();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          parambpi = new AtomicInteger(0);
          paramInt = parambpi.incrementAndGet();
          this.wDz.put(parambc, parambpi);
        }
      }
      paramm = this.fyl.iterator();
      if (paramm.hasNext())
      {
        parambc = (com.tencent.mm.plugin.sns.data.n)paramm.next();
        if ((parambc.dyS == null) || (!parambc.dyS.Id.equals(parambpi.Id)) || (parambc.requestType != paramInt)) {
          break label300;
        }
        if (this.fyl.remove(parambc)) {
          this.fyl.addLast(parambc);
        }
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label566:
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean aoh(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!bt.isNullOrNil(paramString)) && (this.wDA.containsKey(paramString)))
    {
      paramString = (String)this.wDA.remove(paramString);
      if (!bt.isNullOrNil(paramString))
      {
        if (this.wDz.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.wDz.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.wDz.remove(paramString);
            }
            AppMethodBeat.o(95428);
            return true;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", new Object[] { paramString });
        }
        AppMethodBeat.o(95428);
        return false;
      }
    }
    AppMethodBeat.o(95428);
    return false;
  }
  
  private static boolean aom(String paramString)
  {
    AppMethodBeat.i(95442);
    if ((paramString == null) || (paramString.equals("")))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95442);
      return false;
    }
    AppMethodBeat.o(95442);
    return true;
  }
  
  private void dsE()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.fyl.clear();
      this.wDy.clear();
      this.wDx.clear();
      this.wDs.clear();
      this.wDt.clear();
      this.wDz.clear();
      this.wDA.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean dsF()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.wDs != null) && (this.wDs.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.o localo = (com.tencent.mm.plugin.sns.data.o)this.wDs.remove();
        new av().v(new com.tencent.mm.plugin.sns.data.o[] { localo });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void dsG()
  {
    AppMethodBeat.i(95435);
    if (TG()) {
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
  
  private void dsH()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.wDx.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.wDx.containsKey(localObject2)) && (bt.lZ(((Long)this.wDx.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "too long to download");
        this.wDx.remove(localObject2);
        this.wDy.remove(localObject2);
        aoh((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(int paramInt1, bpi parambpi, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (parambpi == null) {}
    for (??? = Integer.valueOf(-1);; ??? = parambpi.Id)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!af.dtd())
      {
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afz().aeI()) {
          break;
        }
      }
      dsE();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.wDq += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.wDq > 512000) && (this.fyl.size() == 0))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.wDq) });
          ar.a.gMX.cZ(this.wDq, 0);
          this.wDq = 0;
          break label809;
          if (paramBoolean2) {
            this.wDt.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (parambpi != null))
          {
            ??? = af.dtr();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LazyerImageLoader2", "updateCache " + parambpi.Id);
            Object localObject2 = com.tencent.mm.plugin.sns.data.q.bO(1, parambpi.Id);
            localObject2 = (com.tencent.mm.memory.n)((f)???).wDJ.get((String)localObject2);
            if (com.tencent.mm.plugin.sns.data.q.b((com.tencent.mm.memory.n)localObject2))
            {
              ((com.tencent.mm.memory.n)localObject2).apd();
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LazyerImageLoader2", "force update");
              af.dth().execute(new f.2((f)???, parambpi));
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
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              if (paramBoolean2) {
                this.wDx.remove(paramString);
              }
              ayc();
              p(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (parambpi != null) {}
              try
              {
                ??? = aoo(parambpi.Id);
                if ((??? != null) && (((c)???).goa) && (((c)???).goa))
                {
                  long l = bt.vM(((c)???).startTime);
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).dpC, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.h.vKh.m(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.h.vKh.dB(1040, 1);
                }
                paramString = this.csT.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label802;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (parambpi == null)) {
                      break label742;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).dsp();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.wDt.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            parambpi = finally;
            AppMethodBeat.o(95444);
            throw parambpi;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).aob(parambpi.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).by(parambpi.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).bz(parambpi.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (parambpi != null)) {
              ((b)???).by(parambpi.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (parambpi != null)) {
              ((b)???).bz(parambpi.Id, false);
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
        localb.csT.add(localb1);
        int i = b.wDn + 1;
        b.wDn = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(208, localb);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<bpi> arg2, SparseArray<m> paramSparseArray1, bc parambc, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      ay.aoP(((bpi)???.valueAt(i)).Id);
      i += 1;
    }
    if (!com.tencent.mm.plugin.sns.data.q.anO(af.getAccPath()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { af.getAccPath(), com.tencent.mm.loader.j.b.aib() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (bpi)???.get(k);
      if ((!((bpi)localObject).Id.startsWith("Locall_path")) && (!((bpi)localObject).Id.startsWith("pre_temp_sns_pic"))) {
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(95431);
      return;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.q.anH(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.wDz.containsKey(localObject)) {
          break label521;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.wDz.get(localObject);
        if (localAtomicInteger == null) {
          break label521;
        }
        i = localAtomicInteger.get();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label521;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.wDy.containsKey(localObject)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { paramString });
          this.wDy.put(localObject, new com.tencent.mm.plugin.sns.data.d(paramSparseArray1));
          this.fyl.add(new com.tencent.mm.plugin.sns.data.n(paramString, localSparseArray, (String)localObject, parambc, paramInt));
          continue;
          if (Looper.myLooper() == null) {
            break label510;
          }
          Looper.myQueue().addIdleHandler(new d());
          dsG();
          dsH();
          if (this.fyl.size() > 0)
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            ayc();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.fyl.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.n)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.fyl.remove(paramSparseArray1)) {
          this.fyl.addLast(paramSparseArray1);
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label510:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
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
      c localc = (c)this.wDB.get(paramString);
      if ((localc == null) || (!localc.dpC.equals(paramc.dpC))) {
        this.wDB.put(paramString, paramc);
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
    localh.foc = 1;
    localh.field_fileType = 100;
    localh.fnX = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.foj = parama;
    com.tencent.mm.modelvideo.o.aCJ().a(localh, false);
    synchronized (this.wDu)
    {
      this.wDu.put(paramString1, paramString3);
      AppMethodBeat.o(95433);
      return;
    }
  }
  
  public final boolean a(bpi parambpi, int paramInt, m paramm, bc parambc)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(parambpi, paramInt, paramm, parambc, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(bpi parambpi, int paramInt, m paramm, bc parambc, String paramString)
  {
    AppMethodBeat.i(95430);
    if (parambpi == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "unknow case media is null " + bt.eGN().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      ay.aoP(parambpi.Id);
      a(parambpi, paramInt, paramm, parambc, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(bpi parambpi, int paramInt, m paramm, bc parambc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187324);
    if (parambpi == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "unknow case media is null " + bt.eGN().toString());
      AppMethodBeat.o(187324);
      return false;
    }
    synchronized (this.mLock)
    {
      ay.aoP(parambpi.Id);
      a(parambpi, paramInt, paramm, parambc, paramString1, paramString2, null);
      AppMethodBeat.o(187324);
      return true;
    }
  }
  
  public final void ao(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.wDr = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (com.tencent.mm.sdk.platformtools.ay.isWifi(aj.getContext()))
        {
          str = com.tencent.mm.m.g.Zd().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bt.isNullOrNil(str)) || (!com.tencent.mm.sdk.a.b.eEQ())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bt.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bt.aGh(localObject[0]);
          paramInt = bt.aGh(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.q.awP() - 8) * 60;
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
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.m.g.Zd().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bt.aGh(arrayOfString2[0]);
        j = bt.aGh(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bt.aGh(arrayOfString2[0]);
        k = bt.aGh(arrayOfString2[1]) + k * 60;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bt.aGh((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.wDr = j;
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bt.m(localException) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.wDr) });
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
  
  public final void aoi(String paramString)
  {
    AppMethodBeat.i(95434);
    com.tencent.mm.modelvideo.o.aCJ().k(paramString, null);
    synchronized (this.wDu)
    {
      this.wDu.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean aoj(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.wDx.containsKey(com.tencent.mm.plugin.sns.data.q.bP(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.wDx.containsKey(com.tencent.mm.plugin.sns.data.q.bP(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean aok(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.wDx.containsKey(com.tencent.mm.plugin.sns.data.q.bP(2, paramString))) || (this.wDx.containsKey(com.tencent.mm.plugin.sns.data.q.bP(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean aol(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.wDu)
    {
      if (this.wDu.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void aon(final String paramString)
  {
    AppMethodBeat.i(95445);
    af.czA().post(new Runnable()
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
  
  public final c aoo(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!bt.isNullOrNil(paramString))
    {
      paramString = (c)this.wDB.remove(paramString);
      if (paramString != null) {
        paramString.dsI();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void aop(String paramString)
  {
    AppMethodBeat.i(95449);
    this.wDC.add(paramString);
    AppMethodBeat.o(95449);
  }
  
  public final void ayc()
  {
    AppMethodBeat.i(95443);
    if (!this.wDv)
    {
      AppMethodBeat.o(95443);
      return;
    }
    if (af.dtd())
    {
      dsE();
      AppMethodBeat.o(95443);
      return;
    }
    if (!com.tencent.mm.plugin.sns.data.q.anO(af.getAccPath()))
    {
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.wDr;
    if (com.tencent.mm.platformtools.ab.hVh > 0) {
      i = com.tencent.mm.platformtools.ab.hVh;
    }
    com.tencent.mm.plugin.sns.data.n localn;
    bpi localbpi;
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
        if ((this.fyl.size() > 0) && (af.dtt().dsY() + this.wDx.size() <= i))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(af.dtt().dsY()), Integer.valueOf(this.wDx.size()), Integer.valueOf(this.fyl.size()), Integer.valueOf(this.wDr) });
          localn = (com.tencent.mm.plugin.sns.data.n)this.fyl.removeLast();
          if (localn == null)
          {
            AppMethodBeat.o(95443);
            return;
          }
          localbpi = localn.dyS;
          i = localn.requestType;
          str2 = localn.key;
          str3 = localn.wBe;
          str4 = localn.wBf;
          str1 = localn.dpC;
          localSparseArray1 = localn.wBh;
          if ((!this.wDy.containsKey(str2)) || (this.wDy.get(str2) == null))
          {
            this.wDy.remove(str2);
            aoh(str2);
            AppMethodBeat.o(95443);
            return;
          }
          localm = ((com.tencent.mm.plugin.sns.data.d)this.wDy.get(str2)).wAv;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.d)this.wDy.get(str2)).wAw;
          j = i;
          if (i != 1) {
            break label1526;
          }
          j = i;
          if (!localbpi.isAd) {
            break label1526;
          }
          j = 8;
          break label1526;
          boolean bool2 = true;
          localObject1 = localbpi.DMQ;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!bt.isNullOrNil(localbpi.DNa)) {
              localObject4 = localbpi.DNa;
            }
          }
          int k = localbpi.DMR;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (bt.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localbpi.mBH == 2)
            {
              localObject1 = localbpi.Url;
              i = localbpi.Dzl;
              bool1 = bool2;
            }
          }
          if (!aom((String)localObject1))
          {
            this.wDy.remove(str2);
            aoh(str2);
            AppMethodBeat.o(95443);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localbpi.DMX;
              i = localbpi.Dzl;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (bpi)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((bpi)localObject4).DMQ;
              i = ((bpi)localObject4).DMR;
              if ((!bt.isNullOrNil((String)localObject1)) || (((bpi)localObject4).mBH != 2)) {
                break label1523;
              }
              localObject1 = ((bpi)localObject4).Url;
              i = ((bpi)localObject4).Dzl;
              break label1545;
            }
            bool1 = false;
            localObject1 = localbpi.Url;
            i = localbpi.Dzl;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!af.dtt().isDownloading(str2))
          {
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "to downLoad scene " + localbpi.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new o(localbpi, localbpi.Id, (String)localObject1, localbpi.mBH, bool1, j, str2), 0);
            af.dtt().aoD(str2);
          }
        }
        label714:
        AppMethodBeat.o(95443);
        return;
        if ((i != 1) && (i != 0)) {
          break label1501;
        }
        if (i == 0) {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.wDx.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localbpi == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.wDt.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.wDt.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.wDy.remove(str2);
          aoh(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localbpi == null)
          {
            localObject1 = str1;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "to downLoad cdn " + localbpi.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localbpi.Id;
    }
    this.wDx.put(str2, Long.valueOf(bt.aGK()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.afC();
      i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(68391, null), 0);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localn.size);
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wLv = localn.wBg;
      if (j != 4) {
        break label1301;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wLt = true;
      label1164:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wLs = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wLu = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wFc = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).iL(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1310;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1245:
      break label1460;
    }
    for (;;)
    {
      label1246:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).duz();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).v(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localbpi.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wFd = localbpi;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wAv = localm;
      break label1143;
      label1301:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).wLt = false;
      break label1164;
      label1310:
      if (j != 4) {
        break label1554;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.aty().qu("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (bt.getInt((String)((com.tencent.mm.storage.c)localObject3).eJy().get("CDNDownload"), 0) == 0) {
          break label1548;
        }
        bool1 = true;
      }
      label1371:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localbpi.isAd), Boolean.valueOf(bool1) });
      if ((!localbpi.isAd) || (bool1)) {
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
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localbpi.DMX;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).md5 = localbpi.DMZ;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1501:
      this.wDy.remove(str2);
      aoh(str2);
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
        localb.csT.remove(localb1);
        int i = b.wDn - 1;
        b.wDn = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.b(208, localb);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(95446);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (paramn.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (o)paramn;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.wFa == 2) || (paramString.wFa == 8))
      {
        paramn = this.csT.iterator();
        while (paramn.hasNext())
        {
          localb = (b)paramn.next();
          if (localb != null) {
            localb.by(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramn.getType() == 208)
    {
      paramn = this.csT.iterator();
      while (paramn.hasNext())
      {
        localb = (b)paramn.next();
        if (localb != null) {
          if (paramString.wFa == 3) {
            localb.dsp();
          } else if ((paramString.wFa == 1) || (paramString.wFa == 5) || (paramString.wFa == 7)) {
            localb.aob(paramString.mediaId);
          } else if ((paramString.wFa == 2) || (paramString.wFa == 8)) {
            localb.by(paramString.mediaId, true);
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.d)this.wDy.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.d)localObject).requestType) {
          break label140;
        }
        localObject = (m)((com.tencent.mm.plugin.sns.data.d)localObject).wAw.get(paramInt);
        if (localObject != null) {
          af.dtr().a((m)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.wDy.remove(paramString);
          aoh(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.d)localObject).wAv;
      } while (localObject == null);
      af.dtr().a((m)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void iB(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void aob(String paramString);
    
    public abstract void by(String paramString, boolean paramBoolean);
    
    public abstract void bz(String paramString, boolean paramBoolean);
    
    public abstract void dsp();
  }
  
  public static final class c
  {
    final String dpC;
    private int gKT;
    boolean goa;
    private final byte[] lock;
    long startTime;
    public boolean wDG;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.dpC = paramString;
      this.gKT = paramInt;
      this.startTime = -1L;
      this.wDG = false;
      this.goa = false;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void dsI()
    {
      synchronized (this.lock)
      {
        if (this.gKT > 0) {
          this.gKT -= 1;
        }
        if (this.gKT == 0) {
          this.goa = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.wDG) {
        synchronized (this.lock)
        {
          if (!this.wDG)
          {
            this.wDG = true;
            this.startTime = paramLong;
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.dpC, Long.valueOf(this.startTime), this });
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.DownloadManager", "I run idleHandler ");
      b.a(b.this, bt.aGK());
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