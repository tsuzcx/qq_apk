package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.a;
import com.tencent.mm.protocal.protobuf.cvt;
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
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.sns.model.a.c.a
{
  private static final int JTA;
  static int JTz = 0;
  private long JTB;
  private int JTC;
  private int JTD;
  private LinkedList<r> JTE;
  public HashMap<String, Long> JTF;
  private HashMap<String, String> JTG;
  public boolean JTH;
  public Set<a> JTI;
  private HashMap<String, Long> JTJ;
  private Map<String, Long> JTK;
  Map<String, com.tencent.mm.plugin.sns.data.h> JTL;
  ConcurrentHashMap<String, AtomicInteger> JTM;
  ConcurrentHashMap<String, String> JTN;
  public ConcurrentHashMap<String, c> JTO;
  public CopyOnWriteArrayList<String> JTP;
  private MMHandler handler;
  LinkedList<com.tencent.mm.plugin.sns.data.q> jmy;
  Set<b> listeners;
  public final byte[] mLock;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      JTA = i;
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.JTB = 0L;
    this.JTC = 0;
    this.JTD = 2;
    this.JTE = new LinkedList();
    this.JTF = new HashMap();
    this.mLock = new byte[0];
    this.JTG = new HashMap();
    this.JTH = true;
    this.listeners = new HashSet();
    this.JTI = new HashSet();
    this.jmy = new LinkedList();
    this.JTJ = new HashMap();
    this.JTK = new ConcurrentHashMap();
    this.JTL = new HashMap();
    this.JTM = new ConcurrentHashMap();
    this.JTN = new ConcurrentHashMap();
    this.JTO = new ConcurrentHashMap();
    this.JTP = new CopyOnWriteArrayList();
    this.handler = aj.etE();
    fNO();
    AppMethodBeat.o(95422);
  }
  
  private boolean a(cvt paramcvt, int paramInt, p paramp, bp parambp, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95427);
    if (!com.tencent.mm.plugin.sns.data.t.aZp(aj.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { aj.getAccPath(), com.tencent.mm.loader.j.b.aSF() });
      AppMethodBeat.o(95427);
      return false;
    }
    if ((paramcvt.Id.startsWith("Locall_path")) || (paramcvt.Id.startsWith("pre_temp_sns_pic")))
    {
      Log.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(95427);
      return false;
    }
    String str = com.tencent.mm.plugin.sns.data.t.cr(paramInt, paramcvt.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.JTL.containsKey(str))
        {
          Log.i("MicroMsg.DownloadManager", "add list %s, lists:%s", new Object[] { paramcvt.Id, fNS() });
          this.JTJ.put(paramcvt.Id, Long.valueOf(Util.currentTicks()));
          this.JTL.put(str, new com.tencent.mm.plugin.sns.data.h(paramp, paramInt));
          paramp = new com.tencent.mm.plugin.sns.data.q(paramcvt, paramInt, str, parambp, paramString1, paramString2);
          this.jmy.add(paramp);
          if (!Util.isNullOrNil(paramString3))
          {
            parambp = com.tencent.mm.plugin.sns.data.t.aZi(paramString3);
            Log.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, paramcvt.Id, parambp });
            if (this.JTM.containsKey(parambp))
            {
              paramp = (AtomicInteger)this.JTM.get(parambp);
              paramcvt = paramp;
              if (paramp == null) {
                paramcvt = new AtomicInteger(0);
              }
              paramInt = paramcvt.incrementAndGet();
              Log.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label325:
              this.JTN.put(str, parambp);
            }
          }
          else
          {
            Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s, list:%s", new Object[] { Integer.valueOf(aj.fOH().fOk()), Integer.valueOf(this.JTK.size()), fNS() });
            Log.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.JTL.size()), Integer.valueOf(this.JTE.size()) });
            if (Looper.myLooper() == null) {
              break label598;
            }
            Looper.myQueue().addIdleHandler(new d());
            fNQ();
            fNR();
            if (this.jmy.size() > 0) {
              blz();
            }
            AppMethodBeat.o(95427);
            return true;
          }
          paramcvt = new AtomicInteger(0);
          paramInt = paramcvt.incrementAndGet();
          this.JTM.put(parambp, paramcvt);
        }
      }
      paramp = this.jmy.iterator();
      if (paramp.hasNext())
      {
        parambp = (com.tencent.mm.plugin.sns.data.q)paramp.next();
        if ((parambp.fVT == null) || (!parambp.fVT.Id.equals(paramcvt.Id)) || (parambp.requestType != paramInt)) {
          break label325;
        }
        if (this.jmy.remove(parambp)) {
          this.jmy.addLast(parambp);
        }
        Log.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label598:
        Log.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean aZG(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!Util.isNullOrNil(paramString)) && (this.JTN.containsKey(paramString)))
    {
      paramString = (String)this.JTN.remove(paramString);
      if (!Util.isNullOrNil(paramString))
      {
        if (this.JTM.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.JTM.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            Log.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.JTM.remove(paramString);
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
  
  private static boolean aZL(String paramString)
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
  
  private boolean aqI()
  {
    AppMethodBeat.i(95437);
    if (Util.secondsToNow(this.JTB) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private void cw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(267967);
    String[] arrayOfString = paramString.split("-");
    long l;
    if ((arrayOfString != null) && (arrayOfString.length == 2) && (!paramString.contains("sns_table_")))
    {
      paramString = arrayOfString[1].trim();
      if (this.JTJ.containsKey(paramString))
      {
        l = Util.ticksToNow(((Long)this.JTJ.get(paramString)).longValue());
        if (l <= 2000L) {
          break label134;
        }
        Log.i("MicroMsg.DownloadManager", "mediaId:%s download cost:%sms too long!", new Object[] { paramString, Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        this.JTJ.remove(paramString);
      }
      AppMethodBeat.o(267967);
      return;
      paramString = paramString.substring(2);
      break;
      label134:
      Log.i("MicroMsg.DownloadManager", "mediaId:%s download cost:%sms", new Object[] { paramString, Long.valueOf(l) });
    }
  }
  
  private void fNO()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.jmy.clear();
      this.JTL.clear();
      this.JTK.clear();
      this.JTE.clear();
      this.JTF.clear();
      this.JTM.clear();
      this.JTN.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  private boolean fNP()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.JTE != null) && (this.JTE.size() > 0))
      {
        r localr = (r)this.JTE.remove();
        new az().y(new r[] { localr });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void fNQ()
  {
    AppMethodBeat.i(95435);
    if (aqI()) {
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
  
  private void fNR()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.JTK.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add(((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.JTK.containsKey(localObject2)) && (Util.secondsToNow(((Long)this.JTK.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        Log.d("MicroMsg.DownloadManager", "too long to download");
        this.JTK.remove(localObject2);
        this.JTL.remove(localObject2);
        aZG((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  private String fNS()
  {
    AppMethodBeat.i(267969);
    if (this.jmy.size() > 0)
    {
      Object localObject = new StringBuilder("");
      Iterator localIterator = this.jmy.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.data.q localq = (com.tencent.mm.plugin.sns.data.q)localIterator.next();
        if (localq != null)
        {
          if ((localq.JRr != null) && (localq.JRr.size() > 0)) {
            ((StringBuilder)localObject).append(localq.fLp);
          }
          for (;;)
          {
            ((StringBuilder)localObject).append(",");
            break;
            if (localq.fVT != null) {
              ((StringBuilder)localObject).append(localq.fVT.Id);
            }
          }
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(267969);
      return localObject;
    }
    AppMethodBeat.o(267969);
    return "";
  }
  
  private String fNT()
  {
    AppMethodBeat.i(267970);
    if (this.JTK.size() > 0)
    {
      Object localObject = new StringBuilder("");
      Iterator localIterator = this.JTK.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!Util.isNullOrNil(str))
        {
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",");
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(267970);
      return localObject;
    }
    AppMethodBeat.o(267970);
    return "";
  }
  
  public final void a(int paramInt1, cvt paramcvt, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (paramcvt == null) {}
    for (??? = Integer.valueOf(-1);; ??? = paramcvt.Id)
    {
      Log.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!aj.isInValid())
      {
        com.tencent.mm.kernel.h.aHH();
        if (com.tencent.mm.kernel.h.aHE().aGM()) {
          break;
        }
      }
      fNO();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.JTC += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.JTC > 512000) && (this.jmy.size() == 0))
        {
          Log.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.JTC) });
          az.a.lts.dH(this.JTC, 0);
          this.JTC = 0;
          break label817;
          if (paramBoolean2) {
            this.JTF.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (paramcvt != null))
          {
            ??? = aj.fOF();
            Log.d("MicroMsg.LazyerImageLoader2", "updateCache " + paramcvt.Id);
            Object localObject2 = com.tencent.mm.plugin.sns.data.t.cq(1, paramcvt.Id);
            localObject2 = (n)((g)???).JTW.get((String)localObject2);
            if (com.tencent.mm.plugin.sns.data.t.b((n)localObject2))
            {
              ((n)localObject2).baY();
              Log.d("MicroMsg.LazyerImageLoader2", "force update");
              aj.fOv().execute(new g.2((g)???, paramcvt));
            }
          }
        }
      }
      label750:
      while (9 != paramInt2)
      {
        for (;;)
        {
          synchronized (this.mLock)
          {
            for (;;)
            {
              Log.i("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              cw(paramString, paramBoolean2);
              if (paramBoolean2) {
                this.JTK.remove(paramString);
              }
              blz();
              w(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (paramcvt != null) {}
              try
              {
                ??? = aZN(paramcvt.Id);
                if ((??? != null) && (((c)???).isFinished) && (((c)???).isFinished))
                {
                  long l = Util.milliSecondsToNow(((c)???).startTime);
                  Log.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).fLp, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.h.IzE.p(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.h.IzE.el(1040, 1);
                }
                paramString = this.listeners.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label810;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (paramcvt == null)) {
                      break label750;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).fLL();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.JTF.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            paramcvt = finally;
            AppMethodBeat.o(95444);
            throw paramcvt;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7))
          {
            ((b)???).aYK(paramcvt.Id);
          }
          else if ((paramInt2 == 2) || (paramInt2 == 8))
          {
            ((b)???).cr(paramcvt.Id, true);
          }
          else if ((paramInt2 == 4) || (paramInt2 == 6))
          {
            ((b)???).cq(paramcvt.Id, true);
            continue;
            if (((paramInt2 == 2) || (paramInt2 == 8)) && (paramcvt != null)) {
              ((b)???).cr(paramcvt.Id, false);
            } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (paramcvt != null)) {
              ((b)???).cq(paramcvt.Id, false);
            }
          }
        }
        AppMethodBeat.o(95444);
        return;
      }
      label810:
      label817:
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
        int i = c.JTz + 1;
        c.JTz = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(208, localc);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<cvt> arg2, SparseArray<p> paramSparseArray1, bp parambp, int paramInt)
  {
    AppMethodBeat.i(95431);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      bc.bap(((cvt)???.valueAt(i)).Id);
      i += 1;
    }
    if (!com.tencent.mm.plugin.sns.data.t.aZp(aj.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { aj.getAccPath(), com.tencent.mm.loader.j.b.aSF() });
      AppMethodBeat.o(95431);
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    i = 0;
    if (i < j)
    {
      int k = ???.keyAt(i);
      localObject = (cvt)???.get(k);
      if ((!((cvt)localObject).Id.startsWith("Locall_path")) && (!((cvt)localObject).Id.startsWith("pre_temp_sns_pic"))) {
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
    Object localObject = com.tencent.mm.plugin.sns.data.t.aZi(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.JTM.containsKey(localObject)) {
          break label543;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.JTM.get(localObject);
        if (localAtomicInteger == null) {
          break label543;
        }
        i = localAtomicInteger.get();
        Log.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(i) });
        if (i <= 0) {
          break label543;
        }
        Log.i("MicroMsg.DownloadManager", "skip this batch task.");
        i = 0;
        if ((i != 0) && (!this.JTL.containsKey(localObject)))
        {
          Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s. lists:%s", new Object[] { paramString, fNS() });
          this.JTL.put(localObject, new com.tencent.mm.plugin.sns.data.h(paramSparseArray1));
          this.jmy.add(new com.tencent.mm.plugin.sns.data.q(paramString, localSparseArray, (String)localObject, parambp, paramInt));
          this.JTJ.put(paramString, Long.valueOf(Util.currentTicks()));
          continue;
          if (Looper.myLooper() == null) {
            break label532;
          }
          Looper.myQueue().addIdleHandler(new d());
          fNQ();
          fNR();
          if (this.jmy.size() > 0)
          {
            Log.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            blz();
          }
          AppMethodBeat.o(95431);
        }
        else
        {
          if (i == 0) {
            continue;
          }
          paramString = this.jmy.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.q)paramString.next();
        if (!paramSparseArray1.key.equals(localObject)) {
          continue;
        }
        if (this.jmy.remove(paramSparseArray1)) {
          this.jmy.addLast(paramSparseArray1);
        }
        Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label532:
      Log.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label543:
      i = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!Util.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.JTO.get(paramString);
      if ((localc == null) || (!localc.fLp.equals(paramc.fLp))) {
        this.JTO.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, h.a parama)
  {
    AppMethodBeat.i(267964);
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_DownloadManager";
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.iVd = 1;
    localh.field_fileType = 100;
    localh.iUX = 5;
    localh.iUZ = paramInt1;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.iVn = parama;
    if ((localh.arR()) && (localh.arV()))
    {
      localh.concurrentCount = 10;
      com.tencent.mm.plugin.sns.ad.d.d.h(localh);
      if (paramBoolean)
      {
        localh.iVd = 2;
        localh.field_preloadRatio = paramInt2;
      }
    }
    s.bqC().a(localh, false);
    synchronized (this.JTG)
    {
      this.JTG.put(paramString1, paramString3);
      AppMethodBeat.o(267964);
      return;
    }
  }
  
  public final boolean a(cvt paramcvt, int paramInt, p paramp, bp parambp)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(paramcvt, paramInt, paramp, parambp, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(cvt paramcvt, int paramInt, p paramp, bp parambp, String paramString)
  {
    AppMethodBeat.i(95430);
    if (paramcvt == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(95430);
      return false;
    }
    synchronized (this.mLock)
    {
      bc.bap(paramcvt.Id);
      a(paramcvt, paramInt, paramp, parambp, null, null, paramString);
      AppMethodBeat.o(95430);
      return true;
    }
  }
  
  public final boolean a(cvt paramcvt, int paramInt, p paramp, bp parambp, String paramString1, String paramString2)
  {
    AppMethodBeat.i(267962);
    if (paramcvt == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(267962);
      return false;
    }
    synchronized (this.mLock)
    {
      bc.bap(paramcvt.Id);
      a(paramcvt, paramInt, paramp, parambp, paramString1, paramString2, null);
      AppMethodBeat.o(267962);
      return true;
    }
  }
  
  public final void aX(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.JTD = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          str = com.tencent.mm.n.h.axc().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!Util.isNullOrNil(str)) || (!CrashReportFactory.hasDebuger())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (Util.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = Util.safeParseInt(localObject[0]);
          paramInt = Util.safeParseInt(localObject[1]) + paramInt * 60 - ((int)com.tencent.mm.plugin.sns.data.t.bkk() - 8) * 60;
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
          str = com.tencent.mm.n.h.axc().getValue("SnsImgDownloadConcurrentCountForNotWifi");
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
          this.JTD = j;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { Util.stackTraceToString(localException) });
        Log.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.JTD) });
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
  
  public final void aZH(String paramString)
  {
    AppMethodBeat.i(95434);
    s.bqC().l(paramString, null);
    synchronized (this.JTG)
    {
      this.JTG.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean aZI(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.JTK.containsKey(com.tencent.mm.plugin.sns.data.t.cr(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.JTK.containsKey(com.tencent.mm.plugin.sns.data.t.cr(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean aZJ(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.JTK.containsKey(com.tencent.mm.plugin.sns.data.t.cr(2, paramString))) || (this.JTK.containsKey(com.tencent.mm.plugin.sns.data.t.cr(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean aZK(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.JTG)
    {
      if (this.JTG.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void aZM(final String paramString)
  {
    AppMethodBeat.i(95445);
    aj.etE().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95417);
        c.a(c.this, paramString);
        c.this.w(paramString, -1, true);
        AppMethodBeat.o(95417);
      }
    });
    AppMethodBeat.o(95445);
  }
  
  public final c aZN(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (c)this.JTO.remove(paramString);
      if (paramString != null) {
        paramString.fNU();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void aZO(String paramString)
  {
    AppMethodBeat.i(95449);
    this.JTP.add(paramString);
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
        int i = c.JTz - 1;
        c.JTz = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(208, localc);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final void blz()
  {
    AppMethodBeat.i(95443);
    Log.i("MicroMsg.DownloadManager", "do tryStartNetscene");
    if (!this.JTH)
    {
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene isnot runing now");
      AppMethodBeat.o(95443);
      return;
    }
    if (aj.isInValid())
    {
      fNO();
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene SnsCore not valid");
      AppMethodBeat.o(95443);
      return;
    }
    if (!com.tencent.mm.plugin.sns.data.t.aZp(aj.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene not has sdcard");
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.JTD;
    if (ac.mFp > 0) {
      i = ac.mFp;
    }
    Log.i("MicroMsg.DownloadManager", "tryStartNetscene max downloadSize:%s", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.plugin.sns.data.q localq;
    cvt localcvt;
    String str2;
    String str3;
    String str4;
    String str1;
    SparseArray localSparseArray1;
    p localp;
    SparseArray localSparseArray2;
    int j;
    boolean bool2;
    Object localObject4;
    boolean bool1;
    label571:
    label608:
    Object localObject3;
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.jmy.size() <= 0) || (aj.fOH().fOk() + this.JTK.size() > i)) {
          break label1691;
        }
        Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s, downLoadingT:%s, lists:%s", new Object[] { Integer.valueOf(aj.fOH().fOk()), Integer.valueOf(this.JTK.size()), Integer.valueOf(this.jmy.size()), Integer.valueOf(this.JTD), fNT(), fNS() });
        localq = (com.tencent.mm.plugin.sns.data.q)this.jmy.removeLast();
        if (localq == null)
        {
          AppMethodBeat.o(95443);
          return;
        }
        localcvt = localq.fVT;
        i = localq.requestType;
        str2 = localq.key;
        str3 = localq.JRo;
        str4 = localq.JRp;
        str1 = localq.fLp;
        localSparseArray1 = localq.JRr;
        if ((!this.JTL.containsKey(str2)) || (this.JTL.get(str2) == null))
        {
          this.JTL.remove(str2);
          aZG(str2);
          Log.e("MicroMsg.DownloadManager", "tryStartNetscene not contain requestKey:%s return", new Object[] { str2 });
          AppMethodBeat.o(95443);
          return;
        }
        Log.i("MicroMsg.DownloadManager", "try start download requestType:%s, requestKey:%s", new Object[] { Integer.valueOf(i), str2 });
        localp = ((com.tencent.mm.plugin.sns.data.h)this.JTL.get(str2)).JQm;
        localSparseArray2 = ((com.tencent.mm.plugin.sns.data.h)this.JTL.get(str2)).JQn;
        j = i;
        if (i != 1) {
          break label1763;
        }
        j = i;
        if (!localcvt.isAd) {
          break label1763;
        }
        j = 8;
        break label1763;
        bool2 = true;
        Object localObject1 = localcvt.TDF;
        localObject4 = localObject1;
        if (j == 7)
        {
          localObject4 = localObject1;
          if (!Util.isNullOrNil(localcvt.TDO)) {
            localObject4 = localcvt.TDO;
          }
        }
        int k = localcvt.TDG;
        i = k;
        localObject1 = localObject4;
        bool1 = bool2;
        if (Util.isNullOrNil((String)localObject4))
        {
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (localcvt.rWu == 2)
          {
            localObject1 = localcvt.Url;
            i = localcvt.TlV;
            bool1 = bool2;
          }
        }
        if (!aZL((String)localObject1))
        {
          this.JTL.remove(str2);
          aZG(str2);
          AppMethodBeat.o(95443);
          return;
          if (j == 6)
          {
            bool1 = false;
            localObject1 = localcvt.TDL;
            i = localcvt.TlV;
            continue;
          }
          if (j == 9)
          {
            localObject4 = (cvt)localSparseArray1.valueAt(0);
            bool1 = true;
            localObject1 = ((cvt)localObject4).TDF;
            i = ((cvt)localObject4).TDG;
            if ((!Util.isNullOrNil((String)localObject1)) || (((cvt)localObject4).rWu != 2)) {
              break label1760;
            }
            localObject1 = ((cvt)localObject4).Url;
            i = ((cvt)localObject4).TlV;
            break label1782;
          }
          bool1 = false;
          localObject1 = localcvt.Url;
          i = localcvt.TlV;
          continue;
        }
        if (i == 2)
        {
          if (!aj.fOH().isDownloading(str2))
          {
            Log.d("MicroMsg.DownloadManager", "to downLoad scene " + localcvt.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(new q(localcvt, localcvt.Id, (String)localObject1, localcvt.rWu, bool1, j, str2), 0);
            aj.fOH().bac(str2);
          }
          label821:
          AppMethodBeat.o(95443);
          return;
        }
        if ((i != 1) && (i != 0)) {
          break label1669;
        }
        if (i == 0) {
          Log.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.JTK.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          Log.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localcvt == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.JTF.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.JTF.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.JTL.remove(str2);
          aZG(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localcvt == null)
          {
            localObject1 = str1;
            Log.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          Log.i("MicroMsg.DownloadManager", "to downLoad cdn " + localcvt.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localcvt.Id;
    }
    this.JTK.put(str2, Long.valueOf(Util.nowSecond()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.h.aHH();
      i = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(68391, null), 0);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new a(str1, localSparseArray1, localSparseArray2, localq.size);
      label1250:
      ((a)localObject4).Kcw = localq.JRq;
      if (j != 4) {
        break label1408;
      }
      ((a)localObject4).Kcu = true;
      label1271:
      ((a)localObject4).Kct = bool1;
      ((a)localObject4).Kcv = j;
      ((a)localObject4).JVp = str2;
      ((a)localObject4).url = ((String)localObject3);
      ((a)localObject4).kJ(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1417;
      }
      Log.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
      localObject3 = new com.tencent.mm.plugin.sns.model.a.i(this, (a)localObject4);
      label1352:
      break label1628;
    }
    for (;;)
    {
      label1353:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).fPU();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).y(new String[] { "" });
      break;
      localObject4 = new a(localcvt.Id);
      ((a)localObject4).JVq = localcvt;
      ((a)localObject4).JQm = localp;
      break label1250;
      label1408:
      ((a)localObject4).Kcu = false;
      break label1271;
      label1417:
      if (j != 4) {
        break label1800;
      }
      Log.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      localObject3 = com.tencent.mm.model.c.d.bgB().Mu("100438");
      if (!((com.tencent.mm.storage.c)localObject3).isValid()) {
        break label1754;
      }
      if (Util.getInt((String)((com.tencent.mm.storage.c)localObject3).hvz().get("CDNDownload"), 0) == 0) {
        break label1788;
      }
      bool1 = true;
      break label1785;
      label1478:
      if ((localcvt.Id == null) || (!localcvt.Id.startsWith("adId_sight"))) {
        break label1794;
      }
      bool2 = true;
      label1503:
      Log.i("MicroMsg.DownloadManager", "isAd=" + localcvt.isAd + ", downloadByCDN=" + bool1 + ", isAdLandingPageSight=" + bool2 + ", mediaId=" + localcvt.Id);
      if ((!localcvt.isAd) || (bool1) || (bool2)) {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.g(this, (a)localObject4);
      } else {
        localObject3 = new com.tencent.mm.plugin.sns.model.a.h(this, (a)localObject4);
      }
    }
    for (;;)
    {
      localObject3 = new com.tencent.mm.plugin.sns.model.a.e(this, (a)localObject4);
      break label1353;
      label1628:
      if (j != 6) {
        break label1353;
      }
      ((a)localObject4).url = localcvt.TDL;
      ((a)localObject4).md5 = localcvt.TDN;
      localObject3 = new com.tencent.mm.plugin.sns.model.a.d(this, (a)localObject4);
      break label1353;
      label1669:
      this.JTL.remove(str2);
      aZG(str2);
      break label821;
      label1691:
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene list is empty or reach max download size limit, max:%s, downloading.size:%d, downLoadingT.size:%s, downLoadingT:%s, list:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(aj.fOH().fOk()), Integer.valueOf(this.JTK.size()), fNT(), fNS() });
      break label821;
      label1754:
      bool1 = false;
      break label1478;
      label1760:
      break label1782;
      label1763:
      if ((j == 1) || (j == 5)) {
        break;
      }
      if (j != 7) {
        break label608;
      }
      break;
      label1782:
      break label571;
      for (;;)
      {
        label1785:
        break;
        label1788:
        bool1 = false;
      }
      label1794:
      bool2 = false;
      break label1503;
      label1800:
      if ((j != 2) && (j != 8)) {
        if (j != 3) {
          break label1352;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      if ((paramString.JVn == 2) || (paramString.JVn == 8))
      {
        paramq = this.listeners.iterator();
        while (paramq.hasNext())
        {
          localb = (b)paramq.next();
          if (localb != null) {
            localb.cr(paramString.mediaId, false);
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
          if (paramString.JVn == 3) {
            localb.fLL();
          } else if ((paramString.JVn == 1) || (paramString.JVn == 5) || (paramString.JVn == 7)) {
            localb.aYK(paramString.mediaId);
          } else if ((paramString.JVn == 2) || (paramString.JVn == 8)) {
            localb.cr(paramString.mediaId, true);
          }
        }
      }
    }
    AppMethodBeat.o(95446);
  }
  
  public final void w(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95441);
    synchronized (this.mLock)
    {
      Log.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.h)this.JTL.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.h)localObject).requestType) {
          break label140;
        }
        localObject = (p)((com.tencent.mm.plugin.sns.data.h)localObject).JQn.get(paramInt);
        if (localObject != null) {
          aj.fOF().a((p)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.JTL.remove(paramString);
          aZG(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.h)localObject).JQm;
      } while (localObject == null);
      aj.fOF().a((p)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void kz(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void aYK(String paramString);
    
    public abstract void cq(String paramString, boolean paramBoolean);
    
    public abstract void cr(String paramString, boolean paramBoolean);
    
    public abstract void fLL();
  }
  
  public static final class c
  {
    public boolean JTT;
    final String fLp;
    boolean isFinished;
    private final byte[] lock;
    private int lqa;
    long startTime;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.fLp = paramString;
      this.lqa = paramInt;
      this.startTime = -1L;
      this.JTT = false;
      this.isFinished = false;
      Log.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void fNU()
    {
      synchronized (this.lock)
      {
        if (this.lqa > 0) {
          this.lqa -= 1;
        }
        if (this.lqa == 0) {
          this.isFinished = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.JTT) {
        synchronized (this.lock)
        {
          if (!this.JTT)
          {
            this.JTT = true;
            this.startTime = paramLong;
            Log.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.fLp, Long.valueOf(this.startTime), this });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */