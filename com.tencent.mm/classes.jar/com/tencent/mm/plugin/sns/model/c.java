package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.g.h.a;
import com.tencent.mm.memory.m;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.a.a;
import com.tencent.mm.plugin.sns.model.a.d;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.br;
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
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.sns.model.a.c.a
{
  static int QqC = 0;
  private static final int QqD;
  private long QqE;
  private int QqF;
  private int QqG;
  private LinkedList<r> QqH;
  public HashMap<String, Long> QqI;
  private HashMap<String, String> QqJ;
  public boolean QqK;
  public Set<a> QqL;
  private HashMap<String, Long> QqM;
  private Map<String, Long> QqN;
  private Map<String, com.tencent.mm.plugin.sns.data.h> QqO;
  private ConcurrentHashMap<String, AtomicInteger> QqP;
  private ConcurrentHashMap<String, String> QqQ;
  public ConcurrentHashMap<String, c> QqR;
  public CopyOnWriteArrayList<String> QqS;
  private MMHandler handler;
  private LinkedList<com.tencent.mm.plugin.sns.data.q> lPK;
  Set<b> listeners;
  public final byte[] mLock;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (int i = 100;; i = 25)
    {
      QqD = i;
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(95422);
    this.handler = null;
    this.QqE = 0L;
    this.QqF = 0;
    this.QqG = 2;
    this.QqH = new LinkedList();
    this.QqI = new HashMap();
    this.mLock = new byte[0];
    this.QqJ = new HashMap();
    this.QqK = true;
    this.listeners = new HashSet();
    this.QqL = new HashSet();
    this.lPK = new LinkedList();
    this.QqM = new HashMap();
    this.QqN = new ConcurrentHashMap();
    this.QqO = new HashMap();
    this.QqP = new ConcurrentHashMap();
    this.QqQ = new ConcurrentHashMap();
    this.QqR = new ConcurrentHashMap();
    this.QqS = new CopyOnWriteArrayList();
    this.handler = al.fAG();
    hfB();
    AppMethodBeat.o(95422);
  }
  
  private boolean a(dmz paramdmz, int paramInt1, com.tencent.mm.plugin.sns.data.p paramp, br parambr, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(309598);
    if (paramdmz == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(309598);
      return false;
    }
    synchronized (this.mLock)
    {
      be.aYJ(paramdmz.Id);
      int i = paramInt2;
      if (parambr.equals(br.adjV))
      {
        i = paramInt2;
        if (paramInt2 == 0) {
          i = 2;
        }
      }
      be.hb(paramdmz.Id, i);
      a(paramdmz, paramInt1, paramp, parambr, null, null, paramString1, paramString2, paramString3);
      AppMethodBeat.o(309598);
      return true;
    }
  }
  
  private boolean a(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(309590);
    if (!t.aXA(al.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[] { al.getAccPath(), com.tencent.mm.loader.i.b.bmt() });
      AppMethodBeat.o(309590);
      return false;
    }
    if ((paramdmz.Id.startsWith("Locall_path")) || (paramdmz.Id.startsWith("pre_temp_sns_pic")))
    {
      Log.d("MicroMsg.DownloadManager", "is a local img not need download");
      AppMethodBeat.o(309590);
      return false;
    }
    String str = t.dc(paramInt, paramdmz.Id);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.QqO.containsKey(str))
        {
          Log.i("MicroMsg.DownloadManager", "add list %s, lists:%s", new Object[] { paramdmz.Id, hfF() });
          this.QqM.put(paramdmz.Id, Long.valueOf(Util.currentTicks()));
          this.QqO.put(str, new com.tencent.mm.plugin.sns.data.h(paramp, paramInt));
          paramp = new com.tencent.mm.plugin.sns.data.q(paramdmz, paramInt, str, parambr, paramString1, paramString2, paramString4, paramString5);
          this.lPK.add(paramp);
          if (!Util.isNullOrNil(paramString3))
          {
            parambr = t.aXt(paramString3);
            Log.i("MicroMsg.DownloadManager", "snsId: %s, mediaId: %s, batchKey: %s.", new Object[] { paramString3, paramdmz.Id, parambr });
            if (this.QqP.containsKey(parambr))
            {
              paramp = (AtomicInteger)this.QqP.get(parambr);
              paramdmz = paramp;
              if (paramp == null) {
                paramdmz = new AtomicInteger(0);
              }
              paramInt = paramdmz.incrementAndGet();
              Log.i("MicroMsg.DownloadManager", "res: %s.", new Object[] { Integer.valueOf(paramInt) });
              label334:
              this.QqQ.put(str, parambr);
            }
          }
          else
          {
            Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s, list:%s", new Object[] { Integer.valueOf(al.hgA().hfW()), Integer.valueOf(this.QqN.size()), hfF() });
            Log.v("MicroMsg.DownloadManager", "lockwaitdownload %s memeryFiles.size() %s", new Object[] { Integer.valueOf(this.QqO.size()), Integer.valueOf(this.QqH.size()) });
            if (Looper.myLooper() == null) {
              break label607;
            }
            Looper.myQueue().addIdleHandler(new d());
            hfD();
            hfE();
            if (this.lPK.size() > 0) {
              bJu();
            }
            AppMethodBeat.o(309590);
            return true;
          }
          paramdmz = new AtomicInteger(0);
          paramInt = paramdmz.incrementAndGet();
          this.QqP.put(parambr, paramdmz);
        }
      }
      paramp = this.lPK.iterator();
      if (paramp.hasNext())
      {
        parambr = (com.tencent.mm.plugin.sns.data.q)paramp.next();
        if ((parambr.ibT == null) || (!parambr.ibT.Id.equals(paramdmz.Id)) || (parambr.requestType != paramInt)) {
          break label334;
        }
        if (this.lPK.remove(parambr)) {
          this.lPK.addLast(parambr);
        }
        Log.v("MicroMsg.DownloadManager", "update the download list.");
        continue;
        label607:
        Log.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
      }
    }
  }
  
  private boolean aKG()
  {
    AppMethodBeat.i(95437);
    if (Util.secondsToNow(this.QqE) * 1000L > 300000L)
    {
      AppMethodBeat.o(95437);
      return true;
    }
    AppMethodBeat.o(95437);
    return false;
  }
  
  private boolean aXT(String paramString)
  {
    AppMethodBeat.i(95428);
    if ((!Util.isNullOrNil(paramString)) && (this.QqQ.containsKey(paramString)))
    {
      paramString = (String)this.QqQ.remove(paramString);
      if (!Util.isNullOrNil(paramString))
      {
        if (this.QqP.containsKey(paramString))
        {
          AtomicInteger localAtomicInteger = (AtomicInteger)this.QqP.get(paramString);
          if (localAtomicInteger != null)
          {
            int i = localAtomicInteger.decrementAndGet();
            Log.i("MicroMsg.DownloadManager", "unLockDownLoad, key: %s, v: %s.", new Object[] { paramString, Integer.valueOf(i) });
            if (i == 0) {
              this.QqP.remove(paramString);
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
  
  private static boolean aXY(String paramString)
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
  
  private void cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(309622);
    String[] arrayOfString = paramString.split("-");
    long l;
    if ((arrayOfString != null) && (arrayOfString.length == 2) && (!paramString.contains("sns_table_")))
    {
      paramString = arrayOfString[1].trim();
      if (this.QqM.containsKey(paramString))
      {
        l = Util.ticksToNow(((Long)this.QqM.get(paramString)).longValue());
        if (l <= 2000L) {
          break label134;
        }
        Log.i("MicroMsg.DownloadManager", "mediaId:%s download cost:%sms too long!", new Object[] { paramString, Long.valueOf(l) });
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        this.QqM.remove(paramString);
      }
      AppMethodBeat.o(309622);
      return;
      paramString = paramString.substring(2);
      break;
      label134:
      Log.i("MicroMsg.DownloadManager", "mediaId:%s download cost:%sms", new Object[] { paramString, Long.valueOf(l) });
    }
  }
  
  private boolean hfC()
  {
    AppMethodBeat.i(95424);
    synchronized (this.mLock)
    {
      if ((this.QqH != null) && (this.QqH.size() > 0))
      {
        r localr = (r)this.QqH.remove();
        new bb().A(new r[] { localr });
        AppMethodBeat.o(95424);
        return true;
      }
      AppMethodBeat.o(95424);
      return false;
    }
  }
  
  private void hfD()
  {
    AppMethodBeat.i(95435);
    if (aKG()) {
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
  
  private void hfE()
  {
    AppMethodBeat.i(95436);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    synchronized (this.mLock)
    {
      localObject2 = this.QqN.entrySet().iterator();
      if (((Iterator)localObject2).hasNext()) {
        localLinkedList.add((String)((Map.Entry)((Iterator)localObject2).next()).getKey());
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if ((this.QqN.containsKey(localObject2)) && (Util.secondsToNow(((Long)this.QqN.get(localObject2)).longValue()) * 1000L > 300000L))
      {
        Log.d("MicroMsg.DownloadManager", "too long to download");
        this.QqN.remove(localObject2);
        this.QqO.remove(localObject2);
        aXT((String)localObject2);
      }
    }
    AppMethodBeat.o(95436);
  }
  
  private String hfF()
  {
    AppMethodBeat.i(309636);
    if (this.lPK.size() > 0)
    {
      Object localObject = new StringBuilder("");
      Iterator localIterator = this.lPK.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.sns.data.q localq = (com.tencent.mm.plugin.sns.data.q)localIterator.next();
        if (localq != null)
        {
          if ((localq.Qoc != null) && (localq.Qoc.size() > 0)) {
            ((StringBuilder)localObject).append(localq.hQX);
          }
          for (;;)
          {
            ((StringBuilder)localObject).append(",");
            break;
            if (localq.ibT != null) {
              ((StringBuilder)localObject).append(localq.ibT.Id);
            }
          }
        }
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(309636);
      return localObject;
    }
    AppMethodBeat.o(309636);
    return "";
  }
  
  private String hfG()
  {
    AppMethodBeat.i(309643);
    if (this.QqN.size() > 0)
    {
      Object localObject = new StringBuilder("");
      Iterator localIterator = this.QqN.keySet().iterator();
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
      AppMethodBeat.o(309643);
      return localObject;
    }
    AppMethodBeat.o(309643);
    return "";
  }
  
  public final void a(int paramInt1, dmz paramdmz, int paramInt2, boolean paramBoolean1, String paramString, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    AppMethodBeat.i(95444);
    if (paramdmz == null) {}
    for (??? = Integer.valueOf(-1);; ??? = paramdmz.Id)
    {
      Log.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b,requestKey:%s, totalSize:%d", new Object[] { Integer.valueOf(paramInt1), ???, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), paramString, Integer.valueOf(paramInt3) });
      if (!al.isInValid())
      {
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baC().aZN()) {
          break;
        }
      }
      hfB();
      AppMethodBeat.o(95444);
      return;
    }
    if (paramInt1 != 2) {
      this.QqF += paramInt3;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.QqF > 512000) && (this.lPK.size() == 0))
        {
          Log.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[] { Integer.valueOf(this.QqF) });
          az.a.okQ.eB(this.QqF, 0);
          this.QqF = 0;
          break label927;
          if (paramBoolean2) {
            this.QqI.put(paramString, Long.valueOf(System.currentTimeMillis()));
          }
          if ((paramInt1 != 3) && (paramInt1 == 1) && (paramInt2 != 3) && (paramdmz != null))
          {
            ??? = al.hgy();
            Log.d("MicroMsg.LazyerImageLoader2", "updateCache " + paramdmz.Id);
            Object localObject2 = t.db(1, paramdmz.Id);
            localObject2 = (m)((g)???).QqY.get((String)localObject2);
            if (t.b((m)localObject2))
            {
              ((m)localObject2).bvT();
              Log.d("MicroMsg.LazyerImageLoader2", "force update");
              al.hgo().execute(new g.2((g)???, paramdmz));
            }
          }
        }
      }
      label803:
      while (9 != paramInt2)
      {
        for (;;)
        {
          synchronized (this.mLock)
          {
            for (;;)
            {
              Log.i("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s, taskDone %s.", new Object[] { paramString, Boolean.valueOf(paramBoolean2) });
              cX(paramString, paramBoolean2);
              if (paramBoolean2) {
                this.QqN.remove(paramString);
              }
              bJu();
              y(paramString, paramInt4, paramBoolean2);
              paramString = this.mLock;
              if (paramdmz != null) {}
              try
              {
                ??? = aYa(paramdmz.Id);
                if ((??? != null) && (((c)???).isFinished) && (((c)???).isFinished))
                {
                  long l = Util.milliSecondsToNow(((c)???).startTime);
                  Log.d("MicroMsg.DownloadManager", "single download, feed id: %s, startTime: %d, cost: %d, this: %s.", new Object[] { ((c)???).hQX, Long.valueOf(((c)???).startTime), Long.valueOf(l), ??? });
                  com.tencent.mm.plugin.report.service.h.OAn.p(1040L, 0L, l);
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1040, 1);
                }
                paramString = this.listeners.iterator();
                for (;;)
                {
                  if (!paramString.hasNext()) {
                    break label920;
                  }
                  ??? = (b)paramString.next();
                  if (??? != null)
                  {
                    if ((paramInt1 == 2) || (paramdmz == null)) {
                      break label803;
                    }
                    if (paramInt2 != 3) {
                      break;
                    }
                    ((b)???).aXr();
                  }
                }
                if ((paramInt1 != 1) && (paramInt1 != 3)) {
                  break;
                }
                this.QqI.put(paramString, Long.valueOf(System.currentTimeMillis()));
                break;
              }
              finally
              {
                AppMethodBeat.o(95444);
              }
            }
            paramdmz = finally;
            AppMethodBeat.o(95444);
            throw paramdmz;
          }
          if ((paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 5) || (paramInt2 == 7)) {
            ((b)???).EE(paramdmz.Id);
          } else if ((paramInt2 == 2) || (paramInt2 == 8)) {
            ((b)???).w(paramdmz.Id, true);
          } else if ((paramInt2 == 4) || (paramInt2 == 6)) {
            ((b)???).x(paramdmz.Id, true);
          } else if (paramInt2 == 10) {
            if (paramdmz.vhJ == 6)
            {
              ((b)???).x(paramdmz.Id, true);
            }
            else if (paramdmz.vhJ == 2)
            {
              ((b)???).w(paramdmz.Id, true);
              continue;
              if (((paramInt2 == 2) || (paramInt2 == 8)) && (paramdmz != null)) {
                ((b)???).w(paramdmz.Id, false);
              } else if (((paramInt2 == 4) || (paramInt2 == 6)) && (paramdmz != null)) {
                ((b)???).x(paramdmz.Id, false);
              } else if ((paramInt2 == 10) && (paramdmz != null)) {
                if (paramdmz.vhJ == 6) {
                  ((b)???).x(paramdmz.Id, false);
                } else if (paramdmz.vhJ == 2) {
                  ((b)???).w(paramdmz.Id, false);
                }
              }
            }
          }
        }
        AppMethodBeat.o(95444);
        return;
      }
      label920:
      label927:
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
        int i = c.QqC + 1;
        c.QqC = i;
        if (i <= 1)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(208, localc);
        }
        AppMethodBeat.o(95413);
      }
    });
    AppMethodBeat.o(95425);
  }
  
  public final void a(String paramString, SparseArray<dmz> arg2, SparseArray<com.tencent.mm.plugin.sns.data.p> paramSparseArray1, br parambr, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309791);
    int j = ???.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (dmz)???.valueAt(i);
      be.aYJ(((dmz)localObject1).Id);
      be.hb(((dmz)localObject1).Id, paramInt2);
      i += 1;
    }
    if (!t.aXA(al.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns isHasSdcard is false accPath %s sdcard: %s.", new Object[] { al.getAccPath(), com.tencent.mm.loader.i.b.bmt() });
      AppMethodBeat.o(309791);
      return;
    }
    Object localObject1 = new SparseArray();
    paramInt2 = 0;
    if (paramInt2 < j)
    {
      i = ???.keyAt(paramInt2);
      localObject2 = (dmz)???.get(i);
      if ((!((dmz)localObject2).Id.startsWith("Locall_path")) && (!((dmz)localObject2).Id.startsWith("pre_temp_sns_pic"))) {
        ((SparseArray)localObject1).put(i, localObject2);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        paramSparseArray1.remove(i);
      }
    }
    if (((SparseArray)localObject1).size() <= 0)
    {
      Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns do not need download.");
      AppMethodBeat.o(309791);
      return;
    }
    Object localObject2 = t.aXt(paramString);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.QqP.containsKey(localObject2)) {
          break label559;
        }
        AtomicInteger localAtomicInteger = (AtomicInteger)this.QqP.get(localObject2);
        if (localAtomicInteger == null) {
          break label559;
        }
        paramInt2 = localAtomicInteger.get();
        Log.i("MicroMsg.DownloadManager", "v: %s.", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 <= 0) {
          break label559;
        }
        Log.i("MicroMsg.DownloadManager", "skip this batch task.");
        paramInt2 = 0;
        if ((paramInt2 != 0) && (!this.QqO.containsKey(localObject2)))
        {
          Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns put lock & add list %s. lists:%s", new Object[] { paramString, hfF() });
          this.QqO.put(localObject2, new com.tencent.mm.plugin.sns.data.h(paramSparseArray1));
          this.lPK.add(new com.tencent.mm.plugin.sns.data.q(paramString, (SparseArray)localObject1, (String)localObject2, parambr, paramInt1));
          this.QqM.put(paramString, Long.valueOf(Util.currentTicks()));
          continue;
          if (Looper.myLooper() == null) {
            break label548;
          }
          Looper.myQueue().addIdleHandler(new d());
          hfD();
          hfE();
          if (this.lPK.size() > 0)
          {
            Log.d("MicroMsg.DownloadManager", "addBatchDownloadSns add success, tryStartNetscene.");
            bJu();
          }
          AppMethodBeat.o(309791);
        }
        else
        {
          if (paramInt2 == 0) {
            continue;
          }
          paramString = this.lPK.iterator();
        }
        if (!paramString.hasNext()) {
          continue;
        }
        paramSparseArray1 = (com.tencent.mm.plugin.sns.data.q)paramString.next();
        if (!paramSparseArray1.key.equals(localObject2)) {
          continue;
        }
        if (this.lPK.remove(paramSparseArray1)) {
          this.lPK.addLast(paramSparseArray1);
        }
        Log.i("MicroMsg.DownloadManager", "addBatchDownloadSns update the download list.");
      }
      label548:
      Log.w("MicroMsg.DownloadManager", "addBatchDownloadSns Looper.myLooper() == null.");
      continue;
      label559:
      paramInt2 = 1;
    }
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(95447);
    if ((!Util.isNullOrNil(paramString)) && (paramc != null))
    {
      c localc = (c)this.QqR.get(paramString);
      if ((localc == null) || (!localc.hQX.equals(paramc.hQX))) {
        this.QqR.put(paramString, paramc);
      }
    }
    AppMethodBeat.o(95447);
  }
  
  public final void a(String paramString1, String arg2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, h.a parama)
  {
    AppMethodBeat.i(309809);
    com.tencent.mm.g.h localh = new com.tencent.mm.g.h();
    localh.taskName = "task_DownloadManager";
    localh.field_mediaId = paramString1;
    localh.url = ???;
    localh.lxi = 1;
    localh.field_fileType = 100;
    localh.lxc = 5;
    localh.lxe = paramInt1;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString3;
    localh.lxs = parama;
    if ((localh.aLN()) && (localh.aLR()))
    {
      localh.concurrentCount = 10;
      com.tencent.mm.plugin.sns.ad.d.e.h(localh);
      if (paramBoolean)
      {
        localh.lxi = 2;
        localh.field_preloadRatio = paramInt2;
      }
    }
    v.bOi().a(localh, false);
    synchronized (this.QqJ)
    {
      this.QqJ.put(paramString1, paramString3);
      AppMethodBeat.o(309809);
      return;
    }
  }
  
  public final boolean a(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr)
  {
    AppMethodBeat.i(95429);
    boolean bool = a(paramdmz, paramInt, paramp, parambr, null);
    AppMethodBeat.o(95429);
    return bool;
  }
  
  public final boolean a(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr, String paramString)
  {
    AppMethodBeat.i(95430);
    boolean bool = a(paramdmz, paramInt, paramp, parambr, paramString, "", "");
    AppMethodBeat.o(95430);
    return bool;
  }
  
  public final boolean a(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr, String paramString1, String paramString2)
  {
    AppMethodBeat.i(309801);
    if (paramdmz == null)
    {
      Log.e("MicroMsg.DownloadManager", "unknow case media is null " + Util.getStack().toString());
      AppMethodBeat.o(309801);
      return false;
    }
    synchronized (this.mLock)
    {
      be.aYJ(paramdmz.Id);
      a(paramdmz, paramInt, paramp, parambr, paramString1, paramString2, null, "", "");
      AppMethodBeat.o(309801);
      return true;
    }
  }
  
  public final boolean a(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(309768);
    boolean bool = a(paramdmz, paramInt, paramp, parambr, paramString1, paramString2, paramString3, 0);
    AppMethodBeat.o(309768);
    return bool;
  }
  
  public final void aXU(String paramString)
  {
    AppMethodBeat.i(95434);
    v.bOi().l(paramString, null);
    synchronized (this.QqJ)
    {
      this.QqJ.remove(paramString);
      AppMethodBeat.o(95434);
      return;
    }
  }
  
  public final boolean aXV(String paramString)
  {
    AppMethodBeat.i(95438);
    synchronized (this.mLock)
    {
      if (this.QqN.containsKey(t.dc(1, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      if (this.QqN.containsKey(t.dc(5, paramString)))
      {
        AppMethodBeat.o(95438);
        return true;
      }
      AppMethodBeat.o(95438);
      return false;
    }
  }
  
  public final boolean aXW(String paramString)
  {
    AppMethodBeat.i(95439);
    synchronized (this.mLock)
    {
      if ((this.QqN.containsKey(t.dc(2, paramString))) || (this.QqN.containsKey(t.dc(8, paramString))))
      {
        AppMethodBeat.o(95439);
        return true;
      }
      AppMethodBeat.o(95439);
      return false;
    }
  }
  
  public final boolean aXX(String paramString)
  {
    AppMethodBeat.i(95440);
    synchronized (this.QqJ)
    {
      if (this.QqJ.containsKey(paramString))
      {
        AppMethodBeat.o(95440);
        return true;
      }
      AppMethodBeat.o(95440);
      return false;
    }
  }
  
  public final void aXZ(final String paramString)
  {
    AppMethodBeat.i(95445);
    al.fAG().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(95417);
        c.a(c.this, paramString);
        c.this.y(paramString, -1, true);
        AppMethodBeat.o(95417);
      }
    });
    AppMethodBeat.o(95445);
  }
  
  public final c aYa(String paramString)
  {
    AppMethodBeat.i(95448);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = (c)this.QqR.remove(paramString);
      if (paramString != null) {
        paramString.hfH();
      }
      AppMethodBeat.o(95448);
      return paramString;
    }
    AppMethodBeat.o(95448);
    return null;
  }
  
  public final void aYb(String paramString)
  {
    AppMethodBeat.i(95449);
    this.QqS.add(paramString);
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
        int i = c.QqC - 1;
        c.QqC = i;
        if (i <= 0)
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.b(208, localc);
        }
        AppMethodBeat.o(95414);
      }
    });
    AppMethodBeat.o(95426);
  }
  
  public final boolean b(dmz paramdmz, int paramInt, com.tencent.mm.plugin.sns.data.p paramp, br parambr)
  {
    AppMethodBeat.i(309741);
    boolean bool = a(paramdmz, paramInt, paramp, parambr, null, "", "", 1);
    AppMethodBeat.o(309741);
    return bool;
  }
  
  public final void bE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95421);
    this.QqG = paramInt;
    for (;;)
    {
      label128:
      int i;
      try
      {
        String str;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          str = com.tencent.mm.k.i.aRC().getValue("SnsImgDownloadConcurrentCountForWifi");
          if ((!Util.isNullOrNil(str)) || (!CrashReportFactory.hasDebuger())) {
            break label457;
          }
          str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
          if (Util.isNullOrNil(str)) {
            continue;
          }
          localObject = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
          paramInt = Util.safeParseInt(localObject[0]);
          paramInt = Util.safeParseInt(localObject[1]) + paramInt * 60 - ((int)t.bIb() - 8) * 60;
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
          str = com.tencent.mm.k.i.aRC().getValue("SnsImgDownloadConcurrentCountForNotWifi");
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
          this.QqG = j;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[] { Util.stackTraceToString(localException) });
        Log.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[] { Integer.valueOf(this.QqG) });
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
  
  public final void bJu()
  {
    AppMethodBeat.i(95443);
    Log.i("MicroMsg.DownloadManager", "do tryStartNetscene");
    if (!this.QqK)
    {
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene isnot runing now");
      AppMethodBeat.o(95443);
      return;
    }
    if (al.isInValid())
    {
      hfB();
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene SnsCore not valid");
      AppMethodBeat.o(95443);
      return;
    }
    if (!t.aXA(al.getAccPath()))
    {
      Log.i("MicroMsg.DownloadManager", "tryStartNetscene not has sdcard");
      AppMethodBeat.o(95443);
      return;
    }
    int i = this.QqG;
    if (z.pBQ > 0) {
      i = z.pBQ;
    }
    Log.i("MicroMsg.DownloadManager", "tryStartNetscene max downloadSize:%s", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.plugin.sns.data.q localq;
    dmz localdmz;
    String str2;
    String str3;
    String str4;
    String str1;
    SparseArray localSparseArray1;
    com.tencent.mm.plugin.sns.data.p localp;
    SparseArray localSparseArray2;
    int j;
    Object localObject4;
    boolean bool1;
    for (;;)
    {
      synchronized (this.mLock)
      {
        if ((this.lPK.size() <= 0) || (al.hgA().hfW() + this.QqN.size() > i)) {
          break label1640;
        }
        Log.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s, downLoadingT:%s, lists:%s", new Object[] { Integer.valueOf(al.hgA().hfW()), Integer.valueOf(this.QqN.size()), Integer.valueOf(this.lPK.size()), Integer.valueOf(this.QqG), hfG(), hfF() });
        localq = (com.tencent.mm.plugin.sns.data.q)this.lPK.removeLast();
        if (localq == null)
        {
          AppMethodBeat.o(95443);
          return;
        }
        localdmz = localq.ibT;
        i = localq.requestType;
        str2 = localq.key;
        str3 = localq.QnZ;
        str4 = localq.Qoa;
        str1 = localq.hQX;
        localSparseArray1 = localq.Qoc;
        if ((!this.QqO.containsKey(str2)) || (this.QqO.get(str2) == null))
        {
          this.QqO.remove(str2);
          aXT(str2);
          Log.e("MicroMsg.DownloadManager", "tryStartNetscene not contain requestKey:%s return", new Object[] { str2 });
          AppMethodBeat.o(95443);
          return;
        }
        Log.i("MicroMsg.DownloadManager", "try start download requestType:%s, requestKey:%s", new Object[] { Integer.valueOf(i), str2 });
        localp = ((com.tencent.mm.plugin.sns.data.h)this.QqO.get(str2)).QmT;
        localSparseArray2 = ((com.tencent.mm.plugin.sns.data.h)this.QqO.get(str2)).QmU;
        j = i;
        if (i != 1) {
          break label1706;
        }
        j = i;
        if (!localdmz.isAd) {
          break label1706;
        }
        j = 8;
        break label1706;
        boolean bool2 = true;
        Object localObject1 = localdmz.aaTl;
        localObject4 = localObject1;
        if (j == 7)
        {
          localObject4 = localObject1;
          if (!Util.isNullOrNil(localdmz.aaTu)) {
            localObject4 = localdmz.aaTu;
          }
        }
        int k = localdmz.aaTm;
        i = k;
        localObject1 = localObject4;
        bool1 = bool2;
        if (Util.isNullOrNil((String)localObject4))
        {
          i = k;
          localObject1 = localObject4;
          bool1 = bool2;
          if (localdmz.vhJ == 2)
          {
            localObject1 = localdmz.Url;
            i = localdmz.aazR;
            bool1 = bool2;
          }
        }
        label571:
        if (!aXY((String)localObject1))
        {
          this.QqO.remove(str2);
          aXT(str2);
          AppMethodBeat.o(95443);
          return;
          label608:
          if (j == 6)
          {
            bool1 = false;
            localObject1 = localdmz.aaTr;
            i = localdmz.aazR;
            continue;
          }
          if (j == 9)
          {
            localObject4 = (dmz)localSparseArray1.valueAt(0);
            bool1 = true;
            localObject1 = ((dmz)localObject4).aaTl;
            i = ((dmz)localObject4).aaTm;
            if ((!Util.isNullOrNil((String)localObject1)) || (((dmz)localObject4).vhJ != 2)) {
              break label1703;
            }
            localObject1 = ((dmz)localObject4).Url;
            i = ((dmz)localObject4).aazR;
            break label1725;
          }
          bool1 = false;
          localObject1 = localdmz.Url;
          i = localdmz.aazR;
          continue;
        }
        if (i == 2)
        {
          if (!al.hgA().isDownloading(str2))
          {
            Log.d("MicroMsg.DownloadManager", "to downLoad scene " + localdmz.Id + "  " + (String)localObject1);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(new q(localdmz, localdmz.Id, (String)localObject1, localdmz.vhJ, bool1, j, str2), 0);
            al.hgA().aYs(str2);
          }
          label821:
          AppMethodBeat.o(95443);
          return;
        }
        if ((i != 1) && (i != 0)) {
          break label1618;
        }
        if (i == 0) {
          Log.e("MicroMsg.DownloadManager", "others http: urlType" + i + " -- url : " + (String)localObject1 + " isThumb :" + bool1);
        }
        if (this.QqN.containsKey(str2)) {
          continue;
        }
        if (j == 9)
        {
          Log.i("MicroMsg.DownloadManager", "batch download, snsId: %s.", new Object[] { str1 });
          if (((localdmz == null) && ((localSparseArray1 == null) || (localSparseArray1.size() <= 0))) || (j == 6) || (j == 8) || (!this.QqI.containsKey(str2))) {
            break;
          }
          long l = ((Long)this.QqI.get(str2)).longValue();
          if (System.currentTimeMillis() - l >= 300000L) {
            break;
          }
          this.QqO.remove(str2);
          aXT(str2);
          localObject4 = new StringBuilder("no need download. lastTime: ").append(l).append(" url: ").append((String)localObject1).append(" id: ");
          if (localdmz == null)
          {
            localObject1 = str1;
            Log.i("MicroMsg.DownloadManager", (String)localObject1);
            AppMethodBeat.o(95443);
          }
        }
        else
        {
          Log.i("MicroMsg.DownloadManager", "to downLoad cdn " + localdmz.Id + "  " + (String)localObject1);
        }
      }
      localObject3 = localdmz.Id;
    }
    this.QqN.put(str2, Long.valueOf(Util.nowSecond()));
    if ((j == 2) || (j == 8))
    {
      com.tencent.mm.kernel.h.baF();
      i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(68391, null), 0);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(68391, Integer.valueOf(i + 1));
    }
    if (j == 9)
    {
      localObject4 = new a(str1, localSparseArray1, localSparseArray2, localq.size);
      label1250:
      ((a)localObject4).QzO = localq.Qob;
      ((a)localObject4).aesKey = localq.aesKey;
      ((a)localObject4).authKey = localq.authKey;
      if (j != 4) {
        break label1428;
      }
      ((a)localObject4).QzM = true;
      label1291:
      ((a)localObject4).QzL = bool1;
      ((a)localObject4).QzN = j;
      ((a)localObject4).Qsq = str2;
      ((a)localObject4).url = ((String)localObject3);
      ((a)localObject4).mp(str3, str4);
      localObject3 = null;
      if ((j != 1) && (j != 5) && (j != 7) && (j != 9)) {
        break label1437;
      }
      Log.d("MicroMsg.DownloadManager", "SnsDownloadThumb task create.");
    }
    for (Object localObject3 = new com.tencent.mm.plugin.sns.model.a.j(this, (a)localObject4);; localObject3 = new com.tencent.mm.plugin.sns.model.a.i(this, (a)localObject4))
    {
      label1373:
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).hhM();
      ((com.tencent.mm.plugin.sns.model.a.c)localObject3).A(new String[] { "" });
      break;
      localObject4 = new a(localdmz.Id);
      ((a)localObject4).Qsr = localdmz;
      ((a)localObject4).QmT = localp;
      break label1250;
      label1428:
      ((a)localObject4).QzM = false;
      break label1291;
      label1437:
      if (j != 4) {
        break label1734;
      }
      Log.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
      if ((localdmz.Id == null) || (!localdmz.Id.startsWith("adId_sight"))) {
        break label1728;
      }
      bool1 = true;
      label1475:
      Log.i("MicroMsg.DownloadManager", "isAd=" + localdmz.isAd + ", downloadByCDN=true, isAdLandingPageSight=" + bool1 + ", mediaId=" + localdmz.Id);
    }
    label1541:
    label1703:
    label1706:
    label1725:
    label1728:
    label1734:
    for (;;)
    {
      localObject3 = new com.tencent.mm.plugin.sns.model.a.g(this, (a)localObject4);
      break label1373;
      label1618:
      label1640:
      do
      {
        if (j == 6)
        {
          ((a)localObject4).url = localdmz.aaTr;
          ((a)localObject4).md5 = localdmz.aaTt;
          localObject3 = new d(this, (a)localObject4);
          break label1373;
        }
        if (j != 10) {
          break label1373;
        }
        localObject3 = new com.tencent.mm.plugin.sns.model.a.e(this, (a)localObject4);
        break label1373;
        this.QqO.remove(str2);
        aXT(str2);
        break label821;
        Log.i("MicroMsg.DownloadManager", "tryStartNetscene list is empty or reach max download size limit, max:%s, downloading.size:%d, downLoadingT.size:%s, downLoadingT:%s, list:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(al.hgA().hfW()), Integer.valueOf(this.QqN.size()), hfG(), hfF() });
        break label821;
        break label1725;
        if ((j == 1) || (j == 5)) {
          break;
        }
        if (j != 7) {
          break label608;
        }
        break;
        break label571;
        bool1 = false;
        break label1475;
        if ((j == 2) || (j == 8)) {
          break label1541;
        }
      } while (j != 3);
    }
  }
  
  public final void hfA()
  {
    AppMethodBeat.i(309682);
    Object localObject2;
    synchronized (this.mLock)
    {
      LinkedList localLinkedList = new LinkedList();
      localObject2 = this.lPK.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.sns.data.q localq = (com.tencent.mm.plugin.sns.data.q)((Iterator)localObject2).next();
        if (localq.requestType != 6)
        {
          this.QqO.remove(localq.key);
          localLinkedList.add(localq);
        }
      }
    }
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.sns.data.q)localIterator.next();
      this.lPK.remove(localObject2);
    }
    this.QqP.clear();
    this.QqQ.clear();
    AppMethodBeat.o(309682);
  }
  
  public final void hfB()
  {
    AppMethodBeat.i(95423);
    synchronized (this.mLock)
    {
      this.lPK.clear();
      this.QqO.clear();
      this.QqN.clear();
      this.QqH.clear();
      this.QqI.clear();
      this.QqP.clear();
      this.QqQ.clear();
      AppMethodBeat.o(95423);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(95446);
    Log.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType() + " @" + hashCode());
    if (paramp.getType() != 208)
    {
      AppMethodBeat.o(95446);
      return;
    }
    paramString = (q)paramp;
    b localb;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramString.Qso == 2) || (paramString.Qso == 8))
      {
        paramp = this.listeners.iterator();
        while (paramp.hasNext())
        {
          localb = (b)paramp.next();
          if (localb != null) {
            localb.w(paramString.mediaId, false);
          }
        }
      }
      AppMethodBeat.o(95446);
      return;
    }
    if (paramp.getType() == 208)
    {
      paramp = this.listeners.iterator();
      while (paramp.hasNext())
      {
        localb = (b)paramp.next();
        if (localb != null) {
          if (paramString.Qso == 3) {
            localb.aXr();
          } else if ((paramString.Qso == 1) || (paramString.Qso == 5) || (paramString.Qso == 7)) {
            localb.EE(paramString.mediaId);
          } else if ((paramString.Qso == 2) || (paramString.Qso == 8)) {
            localb.w(paramString.mediaId, true);
          }
        }
      }
    }
    AppMethodBeat.o(95446);
  }
  
  public final void y(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95441);
    synchronized (this.mLock)
    {
      Log.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s %s.", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramString, Boolean.valueOf(paramBoolean) });
      Object localObject = (com.tencent.mm.plugin.sns.data.h)this.QqO.get(paramString);
      if (localObject != null)
      {
        if (9 != ((com.tencent.mm.plugin.sns.data.h)localObject).requestType) {
          break label140;
        }
        localObject = (com.tencent.mm.plugin.sns.data.p)((com.tencent.mm.plugin.sns.data.h)localObject).QmU.get(paramInt);
        if (localObject != null) {
          al.hgy().a((com.tencent.mm.plugin.sns.data.p)localObject, paramString);
        }
      }
      label140:
      do
      {
        if (paramBoolean)
        {
          this.QqO.remove(paramString);
          aXT(paramString);
        }
        AppMethodBeat.o(95441);
        return;
        localObject = ((com.tencent.mm.plugin.sns.data.h)localObject).QmT;
      } while (localObject == null);
      al.hgy().a((com.tencent.mm.plugin.sns.data.p)localObject, paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void mc(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void EE(String paramString);
    
    public abstract void aXr();
    
    public abstract void w(String paramString, boolean paramBoolean);
    
    public abstract void x(String paramString, boolean paramBoolean);
  }
  
  public static final class c
  {
    public boolean QqV;
    final String hQX;
    boolean isFinished;
    private final byte[] lock;
    private int nVc;
    long startTime;
    
    public c(String paramString, int paramInt)
    {
      AppMethodBeat.i(95418);
      this.lock = new byte[0];
      this.hQX = paramString;
      this.nVc = paramInt;
      this.startTime = -1L;
      this.QqV = false;
      this.isFinished = false;
      Log.d("MicroMsg.DownloadManager", "new reporter, snsId id: %s, picNum: %d, this: %s.", new Object[] { paramString, Integer.valueOf(paramInt), this });
      AppMethodBeat.o(95418);
    }
    
    public final void hfH()
    {
      synchronized (this.lock)
      {
        if (this.nVc > 0) {
          this.nVc -= 1;
        }
        if (this.nVc == 0) {
          this.isFinished = true;
        }
        return;
      }
    }
    
    public final void setStartTime(long paramLong)
    {
      AppMethodBeat.i(95419);
      if (!this.QqV) {
        synchronized (this.lock)
        {
          if (!this.QqV)
          {
            this.QqV = true;
            this.startTime = paramLong;
            Log.d("MicroMsg.DownloadManager", "set start time, snsId id: %s, time: %d, this: %s.", new Object[] { this.hQX, Long.valueOf(this.startTime), this });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */