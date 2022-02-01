package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.sns.model.a.c.a
{
  static int DGB = 0;
  private static final int DGC;
  private long DGD;
  private int DGE;
  private int DGF;
  private LinkedList<p> DGG;
  public HashMap<String, Long> DGH;
  private HashMap<String, String> DGI;
  public boolean DGJ;
  public Set<a> DGK;
  private Map<String, Long> DGL;
  Map<String, com.tencent.mm.plugin.sns.data.f> DGM;
  ConcurrentHashMap<String, AtomicInteger> DGN;
  ConcurrentHashMap<String, String> DGO;
  public ConcurrentHashMap<String, c> DGP;
  public CopyOnWriteArrayList<String> DGQ;
  LinkedList<com.tencent.mm.plugin.sns.data.o> gCs;
  private MMHandler handler;
  Set<b> listeners;
  public final byte[] mLock;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      DGC = i;
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.DGD = 0L;
    this.DGE = 0;
    this.DGF = 2;
    this.DGG = new LinkedList();
    this.DGH = new HashMap();
    this.mLock = new byte[0];
    this.DGI = new HashMap();
    this.DGJ = true;
    this.listeners = new HashSet();
    this.DGK = new HashSet();
    this.gCs = new LinkedList();
    this.DGL = new ConcurrentHashMap();
    this.DGM = new HashMap();
    this.DGN = new ConcurrentHashMap();
    this.DGO = new ConcurrentHashMap();
    this.DGP = new ConcurrentHashMap();
    this.DGQ = new CopyOnWriteArrayList();
    this.handler = aj.dRd();
    eZX();
    AppMethodBeat.o(95422);
  }
  
  private boolean a(cnb paramcnb, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bp parambp, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!r.aOt(aj.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { aj.getAccPath(), com.tencent.mm.loader.j.b.aKD() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((paramcnb.Id.startsWith("Locall_path")) || (paramcnb.Id.startsWith("pre_temp_sns_pic")))
    {
      Log.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = r.cr(paramInt, paramcnb.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.DGM.containsKey(str))
        {
          Log.i("MicroMsg.DownloadManager", "add list %s", new Object[] { paramcnb.Id });
          this.DGM.put(str, new com.tencent.mm.plugin.sns.data.f(paramn, paramInt));
          paramn = new com.tencent.mm.plugin.sns.data.o(paramcnb, paramInt, str, parambp, paramString1, paramString2);
          this.gCs.add(paramn);
          if (!Util.isNullOrNil(paramString3))
          {
            parambp = r.aOm(paramString3);
            Log.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, paramcnb.Id, parambp });
            if (this.DGN.containsKey(parambp))
            {
              paramn = (AtomicInteger)this.DGN.get(parambp);
              paramcnb = paramn;
              if (paramn == null) {
                paramcnb = new AtomicInteger(0);
              }
              paramInt = paramcnb.incrementAndGet();
              Log.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label300:
              this.DGO.put(str, parambp);
            }
          }
          else
          {
            Log.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[] { Integer.valueOf(aj.faN().faq()), Integer.valueOf(this.DGL.size()) });
            Log.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.DGM.size()), Integer.valueOf(this.DGG.size()) });
            if (Looper.myLooper() == null) {
              break label566;
            }
            Looper.myQueue().addIdleHandler(new d());
            eZZ();
            faa();
            if (this.gCs.size() > 0) {
              bck();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          paramcnb = new AtomicInteger(0);
          paramInt = paramcnb.incrementAndGet();
          this.DGN.put(parambp, paramcnb);
        }
      }
      paramn = this.gCs.iterator();
      if (paramn.hasNext())
      {
        parambp = (com.tencent.mm.plugin.sns.data.o)paramn.next();
        if ((parambp.ebR == null) || (!parambp.ebR.Id.equals(paramcnb.Id)) || (parambp.requestType != paramInt)) {
          break label300;
        }
        if (this.gCs.remove(parambp)) {
          this.gCs.addLast(parambp);
        }
        Log.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label566:
        Log.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean aOL(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!Util.isNullOrNil(paramString)) && (this.DGO.containsKey(paramString)))
    {
      paramString = (String)this.DGO.remove(paramString);
      if (!Util.isNullOrNil(paramString))
      {
        if (this.DGN.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.DGN.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            Log.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.DGN.remove(paramString);
            }
            AppMethodBeat.o(95428);
            return true;
          }
          Log.e("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, value is null.", new Object[] { paramString });
        }
        AppMethodBeat.o(95428);
        return false;
      }
    }
    AppMethodBeat.o(95428);
    return false;
  }
  
  private static boolean aOQ(String paramString)
  {
    AppMethodBeat.i(95442);
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.d("MicroMsg.DownloadManager", "url  ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95442);
      return false;
    }
    AppMethodBeat.o(95442);
    return true;
  }
  
  private boolean akM()
  {
    AppMethodBeat.i(95437);
    if (Util.secondsToNow(this.DGD) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private void eZX()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.gCs.clear();
      this.DGM.clear();
      this.DGL.clear();
      this.DGG.clear();
      this.DGH.clear();
      this.DGN.clear();
      this.DGO.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean eZY()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.DGG != null) && (this.DGG.size() > 0))
      {
        p localp = (p)this.DGG.remove();
        new ba().y(new p[] { localp });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void eZZ()
  {
    AppMethodBeat.i(95435);
    if (akM()) {
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
  
  private void faa()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.DGL.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.DGL.containsKey(localObject2)) && (Util.secondsToNow(((Long)this.DGL.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        Log.d("MicroMsg.DownloadManager", "too long to download");
        this.DGL.remove(localObject2);
        this.DGM.remove(localObject2);
        aOL((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  public final void a(int paramInt1, cnb paramcnb, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (paramcnb == null) {}
    for (??? = Integer.valueOf(-1);; ??? = paramcnb.Id)
    {
      Log.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!aj.isInValid())
      {
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAf().azp()) {
          break;
        }
      }
      eZX();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.DGE += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.DGE > 512000) && (this.gCs.size() == 0))
        {
          Log.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.DGE) });
          ay.a.iDr.dl(this.DGE, 0);
          this.DGE = 0;
          break label809;
          if (paramBoolean2) {
            this.DGH.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (paramcnb != null))
          {
            ??? = aj.faL();
            Log.d("MicroMsg.LazyerImageLoader2", "updateCache " + paramcnb.Id);
            Object localObject2 = r.cq(1, paramcnb.Id);
            localObject2 = (com.tencent.mm.memory.n)((g)???).DGX.get((String)localObject2);
            if (r.b((com.tencent.mm.memory.n)localObject2))
            {
              ((com.tencent.mm.memory.n)localObject2).aSc();
              Log.d("MicroMsg.LazyerImageLoader2", "force update");
              aj.faB().execute(new g.2((g)???, paramcnb));
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
              Log.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              if (paramBoolean2) {
                this.DGL.remove(paramString);
              }
              bck();
              s(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (paramcnb != null) {}
              try
              {
                ??? = aOS(paramcnb.Id);
                if ((??? != null) && (((c)???).isFinished) && (((c)???).isFinished))
                {
                  long l = Util.milliSecondsToNow(((c)???).startTime);
                  Log.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).dRS, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.h.CyF.n(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.h.CyF.dN(1040, 1);
                }
                paramString = this.listeners.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label802;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (paramcnb == null)) {
                      break label742;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).eZJ();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.DGH.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            paramcnb = finally;
            AppMethodBeat.o(95444);
            throw paramcnb;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).aOG(paramcnb.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).ci(paramcnb.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).cj(paramcnb.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (paramcnb != null)) {
              ((b)???).ci(paramcnb.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (paramcnb != null)) {
              ((b)???).cj(paramcnb.Id, false);
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
        localc.listeners.add(localb);
        int i = c.DGB + 1;
        c.DGB = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(208, localc);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<cnb> arg2, SparseArray<com.tencent.mm.plugin.sns.data.n> paramSparseArray1, bp parambp, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      bd.aPt(((cnb)???.valueAt(i)).Id);
      i += 1;
    }
    if (!r.aOt(aj.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { aj.getAccPath(), com.tencent.mm.loader.j.b.aKD() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (cnb)???.get(k);
      if ((!((cnb)localObject).Id.startsWith("Locall_path")) && (!((cnb)localObject).Id.startsWith("pre_temp_sns_pic"))) {
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
      Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(95431);
      return;
    }
    Object localObject = r.aOm(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.DGN.containsKey(localObject)) {
          break label521;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.DGN.get(localObject);
        if (localAtomicInteger == null) {
          break label521;
        }
        i = localAtomicInteger.get();
        Log.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label521;
        }
        Log.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.DGM.containsKey(localObject)))
        {
          Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s.", new Object[] { paramString });
          this.DGM.put(localObject, new com.tencent.mm.plugin.sns.data.f(paramSparseArray1));
          this.gCs.add(new com.tencent.mm.plugin.sns.data.o(paramString, localSparseArray, (String)localObject, parambp, paramInt));
          continue;
          if (Looper.myLooper() == null) {
            break label510;
          }
          Looper.myQueue().addIdleHandler(new d());
          eZZ();
          faa();
          if (this.gCs.size() > 0)
          {
            Log.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            bck();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.gCs.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.o)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.gCs.remove(paramSparseArray1)) {
          this.gCs.addLast(paramSparseArray1);
        }
        Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label510:
      Log.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label521:
      i = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!Util.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.DGP.get(paramString);
      if ((localc == null) || (!localc.dRS.equals(paramc.dRS))) {
        this.DGP.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, h.a parama)
  {
    AppMethodBeat.i(95433);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_DownloadManager";
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.gqU = 1;
    localh.field_fileType = 100;
    localh.gqP = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.gre = parama;
    com.tencent.mm.modelvideo.o.bhk().a(localh, false);
    synchronized (this.DGI)
    {
      this.DGI.put(paramString1, paramString3);
      AppMethodBeat.o(95433);
      return;
    }
  }
  
  public final boolean a(cnb paramcnb, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bp parambp)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(paramcnb, paramInt, paramn, parambp, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(cnb paramcnb, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bp parambp, String paramString)
  {
    AppMethodBeat.i(95430);
    if (paramcnb == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      bd.aPt(paramcnb.Id);
      a(paramcnb, paramInt, paramn, parambp, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(cnb paramcnb, int paramInt, com.tencent.mm.plugin.sns.data.n paramn, bp parambp, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202718);
    if (paramcnb == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(202718);
      return false;
    }
    synchronized (this.mLock)
    {
      bd.aPt(paramcnb.Id);
      a(paramcnb, paramInt, paramn, parambp, paramString1, paramString2, null);
      AppMethodBeat.o(202718);
      return true;
    }
  }
  
  public final void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.DGF = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          str = com.tencent.mm.n.h.aqJ().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!Util.isNullOrNil(str)) || (!CrashReportFactory.hasDebuger())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (Util.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = Util.safeParseInt(localObject[0]);
          paramInt = Util.safeParseInt(localObject[1]) + paramInt * 60 - ((int)r.baU() - 8) * 60;
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
          if (Util.isNullOrNil(arrayOfString1[i])) {
            break label460;
          }
          localObject = arrayOfString1[i].split("-");
          if ((localObject == null) || (localObject.length < 4))
          {
            Log.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[] { Integer.valueOf(i), str });
            break label460;
          }
        }
        else
        {
          str = com.tencent.mm.n.h.aqJ().getValue("SnsImgDownloadConcurrentCountForNotWifi");
          continue;
        }
        String[] arrayOfString2 = localObject[0].split(":");
        int j = Util.safeParseInt(arrayOfString2[0]);
        j = Util.safeParseInt(arrayOfString2[1]) + j * 60;
        arrayOfString2 = localObject[1].split(":");
        int k = Util.safeParseInt(arrayOfString2[0]);
        k = Util.safeParseInt(arrayOfString2[1]) + k * 60;
        Log.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt), localObject[2], localObject[3] });
        if ((paramInt > k) || (paramInt <= j)) {
          break label460;
        }
        if (paramBoolean)
        {
          localObject = localObject[2];
          j = Util.safeParseInt((String)localObject);
          if (j <= 0) {
            break label460;
          }
          this.DGF = j;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { Util.stackTraceToString(localException) });
        Log.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.DGF) });
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
  
  public final void aOM(String paramString)
  {
    AppMethodBeat.i(95434);
    com.tencent.mm.modelvideo.o.bhk().m(paramString, null);
    synchronized (this.DGI)
    {
      this.DGI.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean aON(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.DGL.containsKey(r.cr(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.DGL.containsKey(r.cr(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean aOO(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.DGL.containsKey(r.cr(2, paramString))) || (this.DGL.containsKey(r.cr(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean aOP(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.DGI)
    {
      if (this.DGI.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void aOR(final String paramString)
  {
    AppMethodBeat.i(95445);
    aj.dRd().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95417);
        c.a(c.this, paramString);
        c.this.s(paramString, -1, true);
        AppMethodBeat.o(95417);
      }
    });
    AppMethodBeat.o(95445);
  }
  
  public final c aOS(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (c)this.DGP.remove(paramString);
      if (paramString != null) {
        paramString.fab();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void aOT(String paramString)
  {
    AppMethodBeat.i(95449);
    this.DGQ.add(paramString);
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
        localc.listeners.remove(localb);
        int i = c.DGB - 1;
        c.DGB = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.b(208, localc);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void bck()
  {
    AppMethodBeat.i(95443);
    if (!this.DGJ)
    {
      AppMethodBeat.o(95443);
      return;
    }
    if (aj.isInValid())
    {
      eZX();
      AppMethodBeat.o(95443);
      return;
    }
    if (!r.aOt(aj.getAccPath()))
    {
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.DGF;
    if (ac.jOg > 0) {
      i = ac.jOg;
    }
    com.tencent.mm.plugin.sns.data.o localo;
    cnb localcnb;
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
        if ((this.gCs.size() > 0) && (aj.faN().faq() + this.DGL.size() <= i))
        {
          Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[] { Integer.valueOf(aj.faN().faq()), Integer.valueOf(this.DGL.size()), Integer.valueOf(this.gCs.size()), Integer.valueOf(this.DGF) });
          localo = (com.tencent.mm.plugin.sns.data.o)this.gCs.removeLast();
          if (localo == null)
          {
            AppMethodBeat.o(95443);
            return;
          }
          localcnb = localo.ebR;
          i = localo.requestType;
          str2 = localo.key;
          str3 = localo.DEt;
          str4 = localo.DEu;
          str1 = localo.dRS;
          localSparseArray1 = localo.DEw;
          if ((!this.DGM.containsKey(str2)) || (this.DGM.get(str2) == null))
          {
            this.DGM.remove(str2);
            aOL(str2);
            AppMethodBeat.o(95443);
            return;
          }
          localn = ((com.tencent.mm.plugin.sns.data.f)this.DGM.get(str2)).DDH;
          localSparseArray2 = ((com.tencent.mm.plugin.sns.data.f)this.DGM.get(str2)).DDI;
          j = i;
          if (i != 1) {
            break label1526;
          }
          j = i;
          if (!localcnb.isAd) {
            break label1526;
          }
          j = 8;
          break label1526;
          boolean bool2 = true;
          localObject1 = localcnb.Msz;
          localObject4 = localObject1;
          if (j == 7)
          {
            localObject4 = localObject1;
            if (!Util.isNullOrNil(localcnb.MsI)) {
              localObject4 = localcnb.MsI;
            }
          }
          int k = localcnb.MsA;
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (Util.isNullOrNil((String)localObject4))
          {
            i = k;
            localObject1 = localObject4;
            bool1 = bool2;
            if (localcnb.oUv == 2)
            {
              localObject1 = localcnb.Url;
              i = localcnb.Mcw;
              bool1 = bool2;
            }
          }
          if (!aOQ((String)localObject1))
          {
            this.DGM.remove(str2);
            aOL(str2);
            AppMethodBeat.o(95443);
            return;
            if (j == 6)
            {
              bool1 = false;
              localObject1 = localcnb.MsF;
              i = localcnb.Mcw;
              continue;
            }
            if (j == 9)
            {
              localObject4 = (cnb)localSparseArray1.valueAt(0);
              bool1 = true;
              localObject1 = ((cnb)localObject4).Msz;
              i = ((cnb)localObject4).MsA;
              if ((!Util.isNullOrNil((String)localObject1)) || (((cnb)localObject4).oUv != 2)) {
                break label1523;
              }
              localObject1 = ((cnb)localObject4).Url;
              i = ((cnb)localObject4).Mcw;
              break label1545;
            }
            bool1 = false;
            localObject1 = localcnb.Url;
            i = localcnb.Mcw;
            continue;
          }
          if (i != 2) {
            continue;
          }
          if (!aj.faN().isDownloading(str2))
          {
            Log.d("MicroMsg.DownloadManager", "to downLoad scene " + localcnb.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(new q(localcnb, localcnb.Id, (String)localObject1, localcnb.oUv, bool1, j, str2), 0);
            aj.faN().aPh(str2);
          }
        }
        label714:
        AppMethodBeat.o(95443);
        return;
        if ((i != 1) && (i != 0)) {
          break label1501;
        }
        if (i == 0) {
          Log.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.DGL.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          Log.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localcnb == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.DGH.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.DGH.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.DGM.remove(str2);
          aOL(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localcnb == null)
          {
            localObject1 = str1;
            Log.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          Log.i("MicroMsg.DownloadManager", "to downLoad cdn " + localcnb.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localcnb.Id;
    }
    this.DGL.put(str2, Long.valueOf(Util.nowSecond()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.g.aAi();
      i = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(68391, null), 0);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(str1, localSparseArray1, localSparseArray2, localo.size);
      label1143:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DPp = localo.DEv;
      if (j != 4) {
        break label1301;
      }
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DPn = true;
      label1164:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DPm = bool1;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DPo = j;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DIp = str2;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = ((String)localObject3);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).ko(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1310;
      }
      Log.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new com.tencent.mm.plugin.sns.model.a.i(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      label1245:
      break label1460;
    }
    for (;;)
    {
      label1246:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).fcb();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).y(new String[] { "" });
      break;
      localObject4 = new com.tencent.mm.plugin.sns.model.a.a(localcnb.Id);
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DIq = localcnb;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DDH = localn;
      break label1143;
      label1301:
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).DPn = false;
      break label1164;
      label1310:
      if (j != 4) {
        break label1554;
      }
      Log.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.aXu().Fu("100438");
      bool1 = false;
      if (((com.tencent.mm.storage.c)localObject3).isValid())
      {
        if (Util.getInt((String)((com.tencent.mm.storage.c)localObject3).gzz().get("CDNDownload"), 0) == 0) {
          break label1548;
        }
        bool1 = true;
      }
      label1371:
      Log.i("MicroMsg.DownloadManager", "is Ad %s, downloadByCDN %s", new Object[] { Boolean.valueOf(localcnb.isAd), Boolean.valueOf(bool1) });
      if ((!localcnb.isAd) || (bool1)) {
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
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).url = localcnb.MsF;
      ((com.tencent.mm.plugin.sns.model.a.a)localObject4).md5 = localcnb.MsH;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (com.tencent.mm.plugin.sns.model.a.a)localObject4);
      break label1246;
      label1501:
      this.DGM.remove(str2);
      aOL(str2);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(95446);
    Log.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType() + " @" + hashCode());
    if (paramq.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (q)paramq;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.DIn == 2) || (paramString.DIn == 8))
      {
        paramq = this.listeners.iterator();
        while (paramq.hasNext())
        {
          localb = (b)paramq.next();
          if (localb != null) {
            localb.ci(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramq.getType() == 208)
    {
      paramq = this.listeners.iterator();
      while (paramq.hasNext())
      {
        localb = (b)paramq.next();
        if (localb != null) {
          if (paramString.DIn == 3) {
            localb.eZJ();
          } else if ((paramString.DIn == 1) || (paramString.DIn == 5) || (paramString.DIn == 7)) {
            localb.aOG(paramString.mediaId);
          } else if ((paramString.DIn == 2) || (paramString.DIn == 8)) {
            localb.ci(paramString.mediaId, true);
          }
        }
      }
    }
    AppMethodBeat.o(95446);
  }
  
  public final void s(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95441);
    synchronized (this.mLock)
    {
      Log.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.f)this.DGM.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.f)localObject).requestType) {
          break label140;
        }
        localObject = (com.tencent.mm.plugin.sns.data.n)((com.tencent.mm.plugin.sns.data.f)localObject).DDI.get(paramInt);
        if (localObject != null) {
          aj.faL().a((com.tencent.mm.plugin.sns.data.n)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.DGM.remove(paramString);
          aOL(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.f)localObject).DDH;
      } while (localObject == null);
      aj.faL().a((com.tencent.mm.plugin.sns.data.n)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ke(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void aOG(String paramString);
    
    public abstract void ci(String paramString, boolean paramBoolean);
    
    public abstract void cj(String paramString, boolean paramBoolean);
    
    public abstract void eZJ();
  }
  
  public static final class c
  {
    public boolean DGU;
    final String dRS;
    private int iAC;
    boolean isFinished;
    private final byte[] lock;
    long startTime;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.dRS = paramString;
      this.iAC = paramInt;
      this.startTime = -1L;
      this.DGU = false;
      this.isFinished = false;
      Log.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void fab()
    {
      synchronized (this.lock)
      {
        if (this.iAC > 0) {
          this.iAC -= 1;
        }
        if (this.iAC == 0) {
          this.isFinished = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.DGU) {
        synchronized (this.lock)
        {
          if (!this.DGU)
          {
            this.DGU = true;
            this.startTime = paramLong;
            Log.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.dRS, Long.valueOf(this.startTime), this });
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
      Log.d("MicroMsg.DownloadManager", "I run idleHandler ");
      c.a(c.this, Util.nowSecond());
      boolean bool = c.a(c.this);
      AppMethodBeat.o(95420);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */