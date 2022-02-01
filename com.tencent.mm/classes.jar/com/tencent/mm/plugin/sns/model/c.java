package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.i;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bk;
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

public final class c
  implements f, com.tencent.mm.plugin.sns.model.a.c.a
{
  static int zws = 0;
  private static final int zwt;
  Set<b> cBA;
  LinkedList<com.tencent.mm.plugin.sns.data.o> fXm;
  private aq handler;
  public final byte[] mLock;
  public boolean zwA;
  public Set<a> zwB;
  private Map<String, Long> zwC;
  Map<String, com.tencent.mm.plugin.sns.data.e> zwD;
  ConcurrentHashMap<String, AtomicInteger> zwE;
  ConcurrentHashMap<String, String> zwF;
  public ConcurrentHashMap<String, c> zwG;
  public CopyOnWriteArrayList<String> zwH;
  private long zwu;
  private int zwv;
  private int zww;
  private LinkedList<com.tencent.mm.plugin.sns.data.p> zwx;
  public HashMap<String, Long> zwy;
  private HashMap<String, String> zwz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      zwt = i;
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.zwu = 0L;
    this.zwv = 0;
    this.zww = 2;
    this.zwx = new LinkedList();
    this.zwy = new HashMap();
    this.mLock = new byte[0];
    this.zwz = new HashMap();
    this.zwA = true;
    this.cBA = new HashSet();
    this.zwB = new HashSet();
    this.fXm = new LinkedList();
    this.zwC = new ConcurrentHashMap();
    this.zwD = new HashMap();
    this.zwE = new ConcurrentHashMap();
    this.zwF = new ConcurrentHashMap();
    this.zwG = new ConcurrentHashMap();
    this.zwH = new CopyOnWriteArrayList();
    this.handler = ah.cXK();
    dWP();
    AppMethodBeat.o(95422);
  }
  
  private boolean WZ()
  {
    AppMethodBeat.i(95437);
    if (bu.rZ(this.zwu) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private boolean a(bzh parambzh, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bk parambk, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!r.azw(ah.getAccPath()))
    {
      ae.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { ah.getAccPath(), com.tencent.mm.loader.j.b.asd() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((parambzh.Id.startsWith("Locall_path")) || (parambzh.Id.startsWith("pre_temp_sns_pic")))
    {
      ae.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = r.ca(paramInt, parambzh.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.zwD.containsKey(str))
        {
          ae.i("MicroMsg.DownloadManager", "add list %s", new Object[] { parambzh.Id });
          this.zwD.put(str, new com.tencent.mm.plugin.sns.data.e(paramn, paramInt));
          paramn = new com.tencent.mm.plugin.sns.data.o(parambzh, paramInt, str, parambk, paramString1, paramString2);
          this.fXm.add(paramn);
          if (!bu.isNullOrNil(paramString3))
          {
            parambk = r.azp(paramString3);
            ae.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, parambzh.Id, parambk });
            if (this.zwE.containsKey(parambk))
            {
              paramn = (AtomicInteger)this.zwE.get(parambk);
              parambzh = paramn;
              if (paramn == null) {
                parambzh = new AtomicInteger(0);
              }
              paramInt = parambzh.incrementAndGet();
              ae.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label300:
              this.zwF.put(str, parambk);
            }
          }
          else
          {
            ae.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(ah.dXD().dXh()), Integer.valueOf(this.zwC.size()) });
            ae.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.zwD.size()), Integer.valueOf(this.zwx.size()) });
            if (Looper.myLooper() == null) {
              break label566;
            }
            Looper.myQueue().addIdleHandler(new d());
            dWR();
            dWS();
            if (this.fXm.size() > 0) {
              aIq();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          parambzh = new AtomicInteger(0);
          paramInt = parambzh.incrementAndGet();
          this.zwE.put(parambk, parambzh);
        }
      }
      paramn = this.fXm.iterator();
      if (paramn.hasNext())
      {
        parambk = (com.tencent.mm.plugin.sns.data.o)paramn.next();
        if ((parambk.dKe == null) || (!parambk.dKe.Id.equals(parambzh.Id)) || (parambk.requestType != paramInt)) {
          break label300;
        }
        if (this.fXm.remove(parambk)) {
          this.fXm.addLast(parambk);
        }
        ae.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label566:
        ae.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean azP(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!bu.isNullOrNil(paramString)) && (this.zwF.containsKey(paramString)))
    {
      paramString = (String)this.zwF.remove(paramString);
      if (!bu.isNullOrNil(paramString))
      {
        if (this.zwE.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.zwE.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            ae.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.zwE.remove(paramString);
            }
            AppMethodBeat.o(95428);
            return true;
          }
          ae.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", new Object[] { paramString });
        }
        AppMethodBeat.o(95428);
        return false;
      }
    }
    AppMethodBeat.o(95428);
    return false;
  }
  
  private static boolean azU(String paramString)
  {
    AppMethodBeat.i(95442);
    if ((paramString == null) || (paramString.equals("")))
    {
      ae.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95442);
      return false;
    }
    AppMethodBeat.o(95442);
    return true;
  }
  
  private void dWP()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.fXm.clear();
      this.zwD.clear();
      this.zwC.clear();
      this.zwx.clear();
      this.zwy.clear();
      this.zwE.clear();
      this.zwF.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean dWQ()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.zwx != null) && (this.zwx.size() > 0))
      {
        com.tencent.mm.plugin.sns.data.p localp = (com.tencent.mm.plugin.sns.data.p)this.zwx.remove();
        new ay().x(new com.tencent.mm.plugin.sns.data.p[] { localp });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void dWR()
  {
    AppMethodBeat.i(95435);
    if (WZ()) {
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(95416);
          c.a(c.this);
          AppMethodBeat.o(95416);
        }
      }, 500L);
    }
    AppMethodBeat.o(95435);
  }
  
  private void dWS()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.zwC.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.zwC.containsKey(localObject2)) && (bu.rZ(((Long)this.zwC.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        ae.d("MicroMsg.DownloadManager", "too long to download");
        this.zwC.remove(localObject2);
        this.zwD.remove(localObject2);
        azP((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(int paramInt1, bzh parambzh, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (parambzh == null) {}
    for (??? = Integer.valueOf(-1);; ??? = parambzh.Id)
    {
      ae.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!ah.dXn())
      {
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajP().aiZ()) {
          break;
        }
      }
      dWP();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.zwv += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.zwv > 512000) && (this.fXm.size() == 0))
        {
          ae.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.zwv) });
          au.a.hIH.db(this.zwv, 0);
          this.zwv = 0;
          break label809;
          if (paramBoolean2) {
            this.zwy.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (parambzh != null))
          {
            ??? = ah.dXB();
            ae.d("MicroMsg.LazyerImageLoader2", "updateCache " + parambzh.Id);
            Object localObject2 = r.bZ(1, parambzh.Id);
            localObject2 = (com.tencent.mm.memory.n)((g)???).zwO.get((String)localObject2);
            if (r.b((com.tencent.mm.memory.n)localObject2))
            {
              ((com.tencent.mm.memory.n)localObject2).ayW();
              ae.d("MicroMsg.LazyerImageLoader2", "force update");
              ah.dXr().execute(new g.2((g)???, parambzh));
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
              ae.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              if (paramBoolean2) {
                this.zwC.remove(paramString);
              }
              aIq();
              p(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (parambzh != null) {}
              try
              {
                ??? = azW(parambzh.Id);
                if ((??? != null) && (((c)???).gJv) && (((c)???).gJv))
                {
                  long l = bu.DD(((c)???).startTime);
                  ae.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).dAg, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.g.yxI.n(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.g.yxI.dD(1040, 1);
                }
                paramString = this.cBA.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label802;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (parambzh == null)) {
                      break label742;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).dWB();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.zwy.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            parambzh = finally;
            AppMethodBeat.o(95444);
            throw parambzh;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).azJ(parambzh.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).bQ(parambzh.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).bR(parambzh.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (parambzh != null)) {
              ((b)???).bQ(parambzh.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (parambzh != null)) {
              ((b)???).bR(parambzh.Id, false);
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
        c localc = c.this;
        c.b localb = paramb;
        localc.cBA.add(localb);
        int i = c.zws + 1;
        c.zws = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(208, localc);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<bzh> arg2, SparseArray<com.tencent.mm.plugin.sns.data.n> paramSparseArray1, bk parambk, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      bb.aAx(((bzh)???.valueAt(i)).Id);
      i += 1;
    }
    if (!r.azw(ah.getAccPath()))
    {
      ae.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { ah.getAccPath(), com.tencent.mm.loader.j.b.asd() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (bzh)???.get(k);
      if ((!((bzh)localObject).Id.startsWith("Locall_path")) && (!((bzh)localObject).Id.startsWith("pre_temp_sns_pic"))) {
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
      ae.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(95431);
      return;
    }
    Object localObject = r.azp(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.zwE.containsKey(localObject)) {
          break label521;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.zwE.get(localObject);
        if (localAtomicInteger == null) {
          break label521;
        }
        i = localAtomicInteger.get();
        ae.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label521;
        }
        ae.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.zwD.containsKey(localObject)))
        {
          ae.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { paramString });
          this.zwD.put(localObject, new com.tencent.mm.plugin.sns.data.e(paramSparseArray1));
          this.fXm.add(new com.tencent.mm.plugin.sns.data.o(paramString, localSparseArray, (String)localObject, parambk, paramInt));
          continue;
          if (Looper.myLooper() == null) {
            break label510;
          }
          Looper.myQueue().addIdleHandler(new d());
          dWR();
          dWS();
          if (this.fXm.size() > 0)
          {
            ae.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            aIq();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.fXm.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.o)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.fXm.remove(paramSparseArray1)) {
          this.fXm.addLast(paramSparseArray1);
        }
        ae.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label510:
      ae.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label521:
      i = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!bu.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.zwG.get(paramString);
      if ((localc == null) || (!localc.dAg.equals(paramc.dAg))) {
        this.zwG.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95433);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.fLl = "task_DownloadManager";
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.fLI = 1;
    localh.field_fileType = 100;
    localh.fLD = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.fLQ = parama;
    com.tencent.mm.modelvideo.o.aNi().a(localh, false);
    synchronized (this.zwz)
    {
      this.zwz.put(paramString1, paramString3);
      AppMethodBeat.o(95433);
      return;
    }
  }
  
  public final boolean a(bzh parambzh, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bk parambk)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(parambzh, paramInt, paramn, parambk, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(bzh parambzh, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bk parambk, String paramString)
  {
    AppMethodBeat.i(95430);
    if (parambzh == null)
    {
      ae.e("MicroMsg.DownloadManager", "unknow case media is null " + bu.fpN().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      bb.aAx(parambzh.Id);
      a(parambzh, paramInt, paramn, parambk, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(bzh parambzh, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bk parambk, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219334);
    if (parambzh == null)
    {
      ae.e("MicroMsg.DownloadManager", "unknow case media is null " + bu.fpN().toString());
      AppMethodBeat.o(219334);
      return false;
    }
    synchronized (this.mLock)
    {
      bb.aAx(parambzh.Id);
      a(parambzh, paramInt, paramn, parambk, paramString1, paramString2, null);
      AppMethodBeat.o(219334);
      return true;
    }
  }
  
  public final void aIq()
  {
    AppMethodBeat.i(95443);
    if (!this.zwA)
    {
      AppMethodBeat.o(95443);
      return;
    }
    if (ah.dXn())
    {
      dWP();
      AppMethodBeat.o(95443);
      return;
    }
    if (!r.azw(ah.getAccPath()))
    {
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.zww;
    if (ac.iRm > 0) {
      i = ac.iRm;
    }
    com.tencent.mm.plugin.sns.data.o localo;
    bzh localbzh;
    String str2;
    String str3;
    String str4;
    String str1;
    SparseArray localSparseArray1;
    com.tencent.mm.plugin.sns.data.n localn;
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
        if ((this.fXm.size() > 0) && (ah.dXD().dXh() + this.zwC.size() <= i))
        {
          ae.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(ah.dXD().dXh()), Integer.valueOf(this.zwC.size()), Integer.valueOf(this.fXm.size()), Integer.valueOf(this.zww) });
          localo = (com.tencent.mm.plugin.sns.data.o)this.fXm.removeLast();
          if (localo == null)
          {
            AppMethodBeat.o(95443);
            return;
          }
          localbzh = localo.dKe;
          i = localo.requestType;
          str2 = localo.key;
          str3 = localo.zuj;
          str4 = localo.zuk;
          str1 = localo.dAg;
          localSparseArray1 = localo.zum;
          if ((!this.zwD.containsKey(str2)) || (this.zwD.get(str2) == null))
          {
            this.zwD.remove(str2);
            azP(str2);
            AppMethodBeat.o(95443);
            return;
          }
          localn = ((com.tencent.mm.plugin.sns.data.e)this.zwD.get(str2)).ztw;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.e)this.zwD.get(str2)).ztx;
          j = i;
          if (i != 1) {
            break label1526;
          }
          j = i;
          if (!localbzh.isAd) {
            break label1526;
          }
          j = 8;
          break label1526;
          boolean bool2 = true;
          localObject1 = localbzh.Hmj;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!bu.isNullOrNil(localbzh.Hmt)) {
              localObject4 = localbzh.Hmt;
            }
          }
          int k = localbzh.Hmk;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (bu.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localbzh.nJA == 2)
            {
              localObject1 = localbzh.Url;
              i = localbzh.GXH;
              bool1 = bool2;
            }
          }
          if (!azU((String)localObject1))
          {
            this.zwD.remove(str2);
            azP(str2);
            AppMethodBeat.o(95443);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localbzh.Hmq;
              i = localbzh.GXH;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (bzh)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((bzh)localObject4).Hmj;
              i = ((bzh)localObject4).Hmk;
              if ((!bu.isNullOrNil((String)localObject1)) || (((bzh)localObject4).nJA != 2)) {
                break label1523;
              }
              localObject1 = ((bzh)localObject4).Url;
              i = ((bzh)localObject4).GXH;
              break label1545;
            }
            bool1 = false;
            localObject1 = localbzh.Url;
            i = localbzh.GXH;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!ah.dXD().isDownloading(str2))
          {
            ae.d("MicroMsg.DownloadManager", "to downLoad scene " + localbzh.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(new p(localbzh, localbzh.Id, (String)localObject1, localbzh.nJA, bool1, j, str2), 0);
            ah.dXD().aAl(str2);
          }
        }
        label714:
        AppMethodBeat.o(95443);
        return;
        if ((i != 1) && (i != 0)) {
          break label1501;
        }
        if (i == 0) {
          ae.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.zwC.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          ae.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localbzh == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.zwy.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.zwy.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.zwD.remove(str2);
          azP(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localbzh == null)
          {
            localObject1 = str1;
            ae.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          ae.i("MicroMsg.DownloadManager", "to downLoad cdn " + localbzh.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localbzh.Id;
    }
    this.zwC.put(str2, Long.valueOf(bu.aRi()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.ajS();
      i = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(68391, null), 0);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localo.size);
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zFp = localo.zul;
      if (j != 4) {
        break label1301;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zFn = true;
      label1164:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zFm = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zFo = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zyg = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).jB(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1310;
      }
      ae.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1245:
      break label1460;
    }
    for (;;)
    {
      label1246:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).dYN();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).x(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localbzh.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zyh = localbzh;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).ztw = localn;
      break label1143;
      label1301:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).zFn = false;
      break label1164;
      label1310:
      if (j != 4) {
        break label1554;
      }
      ae.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.aDI().xi("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (bu.getInt((String)((com.tencent.mm.storage.c)localObject3).fsy().get("CDNDownload"), 0) == 0) {
          break label1548;
        }
        bool1 = true;
      }
      label1371:
      ae.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localbzh.isAd), Boolean.valueOf(bool1) });
      if ((!localbzh.isAd) || (bool1)) {
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
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localbzh.Hmq;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).md5 = localbzh.Hms;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1501:
      this.zwD.remove(str2);
      azP(str2);
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
  
  public final void az(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.zww = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (az.isWifi(ak.getContext()))
        {
          str = com.tencent.mm.n.g.acL().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!bu.isNullOrNil(str)) || (!com.tencent.mm.sdk.a.b.fnF())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (bu.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = bu.aSB(localObject[0]);
          paramInt = bu.aSB(localObject[1]) + paramInt * 60 - ((int)r.aHd() - 8) * 60;
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
          if (bu.isNullOrNil(arrayOfString1[i])) {
            break label460;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            ae.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.n.g.acL().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = bu.aSB(arrayOfString2[0]);
        j = bu.aSB(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = bu.aSB(arrayOfString2[0]);
        k = bu.aSB(arrayOfString2[1]) + k * 60;
        ae.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = bu.aSB((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.zww = j;
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { bu.o(localException) });
        ae.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.zww) });
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
  
  public final void azQ(String paramString)
  {
    AppMethodBeat.i(95434);
    com.tencent.mm.modelvideo.o.aNi().m(paramString, null);
    synchronized (this.zwz)
    {
      this.zwz.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean azR(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.zwC.containsKey(r.ca(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.zwC.containsKey(r.ca(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean azS(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.zwC.containsKey(r.ca(2, paramString))) || (this.zwC.containsKey(r.ca(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean azT(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.zwz)
    {
      if (this.zwz.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void azV(final String paramString)
  {
    AppMethodBeat.i(95445);
    ah.cXK().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95417);
        c.a(c.this, paramString);
        c.this.p(paramString, -1, true);
        AppMethodBeat.o(95417);
      }
    });
    AppMethodBeat.o(95445);
  }
  
  public final c azW(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!bu.isNullOrNil(paramString))
    {
      paramString = (c)this.zwG.remove(paramString);
      if (paramString != null) {
        paramString.dWT();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void azX(String paramString)
  {
    AppMethodBeat.i(95449);
    this.zwH.add(paramString);
    AppMethodBeat.o(95449);
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(95426);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95414);
        c localc = c.this;
        c.b localb = paramb;
        localc.cBA.remove(localb);
        int i = c.zws - 1;
        c.zws = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.b(208, localc);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(95446);
    ae.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (paramn.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (p)paramn;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.zye == 2) || (paramString.zye == 8))
      {
        paramn = this.cBA.iterator();
        while (paramn.hasNext())
        {
          localb = (b)paramn.next();
          if (localb != null) {
            localb.bQ(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramn.getType() == 208)
    {
      paramn = this.cBA.iterator();
      while (paramn.hasNext())
      {
        localb = (b)paramn.next();
        if (localb != null) {
          if (paramString.zye == 3) {
            localb.dWB();
          } else if ((paramString.zye == 1) || (paramString.zye == 5) || (paramString.zye == 7)) {
            localb.azJ(paramString.mediaId);
          } else if ((paramString.zye == 2) || (paramString.zye == 8)) {
            localb.bQ(paramString.mediaId, true);
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
      ae.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.e)this.zwD.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.e)localObject).requestType) {
          break label140;
        }
        localObject = (com.tencent.mm.plugin.sns.data.n)((com.tencent.mm.plugin.sns.data.e)localObject).ztx.get(paramInt);
        if (localObject != null) {
          ah.dXB().a((com.tencent.mm.plugin.sns.data.n)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.zwD.remove(paramString);
          azP(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.e)localObject).ztw;
      } while (localObject == null);
      ah.dXB().a((com.tencent.mm.plugin.sns.data.n)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void jr(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void azJ(String paramString);
    
    public abstract void bQ(String paramString, boolean paramBoolean);
    
    public abstract void bR(String paramString, boolean paramBoolean);
    
    public abstract void dWB();
  }
  
  public static final class c
  {
    final String dAg;
    boolean gJv;
    private int hGu;
    private final byte[] lock;
    long startTime;
    public boolean zwL;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.dAg = paramString;
      this.hGu = paramInt;
      this.startTime = -1L;
      this.zwL = false;
      this.gJv = false;
      ae.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void dWT()
    {
      synchronized (this.lock)
      {
        if (this.hGu > 0) {
          this.hGu -= 1;
        }
        if (this.hGu == 0) {
          this.gJv = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.zwL) {
        synchronized (this.lock)
        {
          if (!this.zwL)
          {
            this.zwL = true;
            this.startTime = paramLong;
            ae.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.dAg, Long.valueOf(this.startTime), this });
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
      ae.d("MicroMsg.DownloadManager", "I run idleHandler ");
      c.a(c.this, bu.aRi());
      boolean bool = c.a(c.this);
      AppMethodBeat.o(95420);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */