package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.storagebase.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class g<K, T extends a>
  extends BaseAdapter
{
  private int EkZ = 0;
  public String TAG = "MicroMsg.CursorDataAdapter";
  private boolean VSZ = true;
  private g<K, T>.c VTa;
  protected a VTb;
  public int VTc = 1000;
  public int VTd = 3000;
  public boolean VTe = true;
  int VTf = 0;
  private boolean VTg;
  private boolean VTh;
  private g<K, T>.e VTi;
  public K VTj = null;
  public Context context;
  private HashMap<K, g.b<K, T>> events;
  private int pageSize;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    Log.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private g(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.VTg = true;
  }
  
  private g(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.VTg = true;
    this.VTh = false;
    this.VTc = 800;
    this.VTd = 2000;
  }
  
  public g(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    Fk(true);
    if ((this.VTa == null) || (this.VTa.VKd != paramd))
    {
      if ((this.VTa != null) && (!this.VTa.isClosed()))
      {
        this.VTa.close();
        this.VTa = null;
      }
      this.VTa = b(paramd);
      this.VTa.getCount();
      hFD();
      notifyDataSetChanged();
    }
  }
  
  private void a(g<K, T>.c paramg)
  {
    Fk(false);
    this.VTa = paramg;
    this.VTa.getCount();
    hFD();
  }
  
  private void a(final g<K, T>.c paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.VTi != null) && (this.VTi.hFT())) {
        this.VTi.hFR();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if ((paramBoolean2) && (paramg != null) && (!paramg.VKe))
    {
      a(new d()
      {
        public final void hFO()
        {
          AppMethodBeat.i(32997);
          g.a(g.this, paramg);
          AppMethodBeat.o(32997);
        }
      });
      return;
    }
    if ((paramg != null) && (paramg.VKe) && (paramBoolean2))
    {
      h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(277526);
          int i = paramg.getCount();
          Log.i(g.this.TAG, "select db count: %d", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(291188);
              g.a(g.this, new g.d()
              {
                public final void hFO()
                {
                  AppMethodBeat.i(282585);
                  g.a(g.this, g.3.this.VTl);
                  AppMethodBeat.o(282585);
                }
              });
              AppMethodBeat.o(291188);
            }
          });
          AppMethodBeat.o(277526);
        }
      });
      return;
    }
    a(paramg);
  }
  
  private void a(d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.VTb != null) {
      this.VTb.hFP();
    }
    if (paramd != null) {
      paramd.hFO();
    }
    notifyDataSetChanged();
    if (this.VTb != null) {
      this.VTb.bxN();
    }
    if (this.VTi != null) {
      this.VTi.hFU();
    }
    Log.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void dw(String paramString, boolean paramBoolean)
  {
    if ((!hFL()) && ((this.VTe | paramBoolean)))
    {
      if (!paramBoolean) {
        Log.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.VTe), paramString, Util.getStack() });
      }
      os(false);
    }
  }
  
  private int getChangeType()
  {
    if ((this.events == null) || (this.events.size() == 0)) {
      return 0;
    }
    if (this.events.containsKey(this.VTj)) {
      return 2;
    }
    return 1;
  }
  
  private void hFD()
  {
    if (this.VTg) {
      if (!this.VTa.hBP()) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 2)
    {
      if ((i != this.VTf) && (this.VTf != 0))
      {
        if ((this.VTi != null) && (this.VTi.hFT())) {
          a(b(hFF()), true, false);
        }
        Log.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.VTf = i;
      return;
    }
  }
  
  private void hFI()
  {
    this.events.clear();
    this.events.put(this.VTj, null);
  }
  
  private void hFJ()
  {
    if (!hFK()) {
      return;
    }
    int i = getChangeType();
    if (this.VTi != null)
    {
      int j = this.VTi.hFV();
      Log.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.VTi.hFR();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.EkZ = 0;
      if (i == 2)
      {
        a(b(hFF()), true, true);
        return;
      }
      hFN();
      return;
    }
  }
  
  private boolean hFK()
  {
    return ((this.VTi != null) && (this.VTi.hFT())) || (getChangeType() != 0);
  }
  
  private boolean hFL()
  {
    return this.EkZ == 0;
  }
  
  private void hFN()
  {
    if ((this.VTa != null) && (!this.VTa.isClosed()) && (this.events.size() == 0))
    {
      Log.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void hFO()
      {
        AppMethodBeat.i(32996);
        Object localObject1;
        Object localObject2;
        if (g.a(g.this, g.b(g.this)))
        {
          localObject1 = new HashSet(g.b(g.this).size());
          localObject2 = g.b(g.this).values().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((HashSet)localObject1).add(((g.b)((Iterator)localObject2).next()).object);
          }
          Log.i(g.this.TAG, "newcursor all event is delete, event:%s", new Object[] { Integer.valueOf(g.b(g.this).size()) });
          g.c(g.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          g.b(g.this).clear();
          AppMethodBeat.o(32996);
          return;
          long l;
          if (!g.b(g.this).containsKey(g.this.VTj))
          {
            l = System.currentTimeMillis();
            localObject2 = g.this.hFG();
            localObject1 = g.this.a(new HashSet(g.b(g.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                Log.i(g.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            Log.i(g.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = g.b(g.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              g.b localb = (g.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.VTp != null) {
                  Log.i(g.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                g.c(g.this).c(localb.object, (a)localb.VTp);
              }
              else
              {
                Log.e(g.this.TAG, "newcursor event is null ! ");
              }
            }
            g.this.a((SparseArray[])localObject1);
            Log.i(g.this.TAG, "newcursor after resort new pos size:%d, event:%s", new Object[] { Integer.valueOf(g.c(g.this).hBN()[0].size()), Integer.valueOf(g.b(g.this).size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            g.a(g.this, g.this.b(g.this.hFF()), true, false);
            Log.i(g.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
      }
    });
  }
  
  private void os(boolean paramBoolean)
  {
    if ((this.VTh) || (paramBoolean)) {
      hFJ();
    }
    for (;;)
    {
      this.EkZ = 0;
      return;
      int i = getChangeType();
      if (i == 0)
      {
        Log.i(this.TAG, "newcursor need not change ");
        return;
      }
      if (i == 2)
      {
        Log.i(this.TAG, "newcursor enqueueMessage resetcursor ");
        this.events.clear();
      }
      if (this.VTi == null) {
        this.VTi = new e();
      }
      this.VTi.atG(i);
    }
  }
  
  public final void Fk(boolean paramBoolean)
  {
    if (this.VTa != null)
    {
      this.VTa.close();
      this.VTa = null;
    }
    if ((paramBoolean) && (this.VTi != null))
    {
      this.VTi.quit();
      this.VTi = null;
      if (this.events != null)
      {
        this.events.clear();
        Log.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.EkZ = 0;
    this.VTf = 0;
  }
  
  public final void a(a parama)
  {
    this.VTb = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.VTa.hBN();
    int i = 0;
    while (i < arrayOfSparseArray.length)
    {
      arrayOfSparseArray[i].clear();
      int j = 0;
      while (j < paramArrayOfSparseArray[i].size())
      {
        arrayOfSparseArray[i].put(j, paramArrayOfSparseArray[i].get(j));
        j += 1;
      }
      i += 1;
    }
  }
  
  public abstract SparseArray<K>[] a(HashSet<g.b<K, T>> paramHashSet, SparseArray<K>[] paramArrayOfSparseArray);
  
  public final T asW(int paramInt)
  {
    if (this.VTa == null) {
      a(hFF());
    }
    dw("getItem", false);
    this.VTa.VKd.moveToPosition(paramInt);
    a locala = this.VTa.VKd.asW(paramInt);
    if (locala != null)
    {
      locala.hvB();
      return locala;
    }
    Log.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public g<K, T>.c b(d<K> paramd)
  {
    return new c(paramd, (byte)0);
  }
  
  public abstract ArrayList<T> bD(ArrayList<K> paramArrayList);
  
  public final T ei(K paramK)
  {
    if (this.VTa == null) {
      return null;
    }
    return this.VTa.VKd.ei(paramK);
  }
  
  public int getCount()
  {
    if (this.VTa == null)
    {
      long l = System.currentTimeMillis();
      a(hFF());
      Log.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    dw("getcount", false);
    if (this.VTa == null)
    {
      Log.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.VTa.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  protected boolean hBP()
  {
    if (this.VTa == null) {
      return false;
    }
    return this.VTa.hBP();
  }
  
  public abstract T hCa();
  
  public final void hFC()
  {
    this.VTb = null;
  }
  
  public final int hFE()
  {
    if (this.VTa == null) {
      return 0;
    }
    d locald = this.VTa.VKd;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).VJT[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> hFF();
  
  public final SparseArray<K>[] hFG()
  {
    if (this.VTa == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.VTa.hBN();
    SparseArray[] arrayOfSparseArray2 = new SparseArray[arrayOfSparseArray1.length];
    int i = 0;
    while (i < arrayOfSparseArray2.length)
    {
      arrayOfSparseArray2[i] = new SparseArray();
      int j = 0;
      while (j < arrayOfSparseArray1[i].size())
      {
        arrayOfSparseArray2[i].put(j, arrayOfSparseArray1[i].get(j));
        j += 1;
      }
      i += 1;
    }
    return arrayOfSparseArray2;
  }
  
  public final HashMap<Object, T> hFH()
  {
    if (this.VTa == null) {
      return null;
    }
    return this.VTa.VKd.hBO();
  }
  
  public final void hFM()
  {
    Log.i(this.TAG, "newcursor resume syncNow ");
    this.VSZ = true;
    os(true);
  }
  
  public void pause()
  {
    this.VSZ = false;
    Log.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    Log.i(this.TAG, "newcursor resume ");
    this.VSZ = true;
    dw("resume", true);
  }
  
  public void u(K paramK, int paramInt)
  {
    boolean bool;
    if (this.VTa != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.VTj);
      if ((paramInt != 5) && (this.VTg) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      hFI();
    }
    label87:
    do
    {
      break label170;
      Log.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.EkZ = getChangeType();
      paramK = this.TAG;
      int j = this.EkZ;
      if (this.VTf == 1) {}
      for (bool = true;; bool = false)
      {
        Log.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        Log.i(this.TAG, "newcursor event is refresh sync ");
        os(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new g.b(paramK, paramInt));
        break;
        if (bool)
        {
          Log.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.VTf == 1)
        {
          if ((this.VTa.eh(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            g.b localb1 = new g.b(paramK, paramInt);
            if ((localb1.VTo == 2) && (this.VTa.eh(localb1.object))) {
              localb1.VTo = 3;
            }
            g.b localb2 = (g.b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.VTo)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.VTo)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.VTo = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.VTa;
              i = localHashMap.size();
              if (!paramK.VKd.asV(i))
              {
                Log.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.VTj, null);
              }
              Log.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.VTo)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.VTo = 5;
                break;
              case 5: 
                Log.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.VTo = 5;
                break;
                switch (localb2.VTo)
                {
                case 3: 
                case 4: 
                default: 
                  Log.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.VTo = 2;
                  break;
                case 5: 
                  localb1.VTo = 3;
                  break;
                case 2: 
                  Log.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.VTo = 2;
                  break;
                  Log.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.VTo = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          Log.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        hFI();
        i = 0;
        break label87;
      }
    } while ((!this.VSZ) || (!this.VTe));
    label170:
    label171:
    label197:
    label711:
    os(false);
    label302:
  }
  
  public static abstract interface a
  {
    public abstract void bxN();
    
    public abstract void hFP();
  }
  
  public final class c
    extends com.tencent.mm.storagebase.a.g<K, T>
  {
    public c()
    {
      super(g.a(g.this), true);
      AppMethodBeat.i(33000);
      AppMethodBeat.o(33000);
    }
    
    public c(byte paramByte)
    {
      super(g.a(g.this), false);
      AppMethodBeat.i(281292);
      AppMethodBeat.o(281292);
    }
    
    public final ArrayList<T> bD(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = g.this.bD(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T hCc()
    {
      AppMethodBeat.i(33001);
      a locala = g.this.hCa();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void hFO();
  }
  
  final class e
  {
    g<K, T>.e.b VTq;
    private g<K, T>.e.c VTr;
    LinkedList<Integer> VTs;
    int VTt;
    
    public e()
    {
      AppMethodBeat.i(33006);
      hFQ();
      AppMethodBeat.o(33006);
    }
    
    private void hFQ()
    {
      AppMethodBeat.i(33007);
      this.VTq = new b(Looper.getMainLooper());
      this.VTr = new c(bh.aHJ().getLooper());
      AppMethodBeat.o(33007);
    }
    
    private void hfG()
    {
      AppMethodBeat.i(33008);
      c.a(this.VTr);
      b localb = this.VTq;
      localb.VTw = true;
      localb.removeMessages(1);
      localb.removeMessages(2);
      this.VTs.clear();
      this.VTt = 0;
      AppMethodBeat.o(33008);
    }
    
    final void atG(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.VTs.contains(Integer.valueOf(paramInt))) {
          this.VTs.add(Integer.valueOf(paramInt));
        }
        this.VTt = hFS();
        c.c(this.VTr);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void hFR()
    {
      try
      {
        AppMethodBeat.i(33009);
        Log.i(g.this.TAG, "newcursor resetQueue ");
        hfG();
        hFQ();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int hFS()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.VTs.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.VTs.size() == 1) {
          i = ((Integer)this.VTs.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean hFT()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 174	com/tencent/mm/ui/g$e:VTt	I
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq +9 -> 17
      //   11: iconst_1
      //   12: istore_2
      //   13: aload_0
      //   14: monitorexit
      //   15: iload_2
      //   16: ireturn
      //   17: iconst_0
      //   18: istore_2
      //   19: goto -6 -> 13
      //   22: astore_3
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_3
      //   26: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	27	0	this	e
      //   6	2	1	i	int
      //   12	7	2	bool	boolean
      //   22	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	22	finally
    }
    
    final void hFU()
    {
      try
      {
        AppMethodBeat.i(33012);
        c.b(this.VTr);
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int hFV()
    {
      try
      {
        int i = this.VTt;
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void quit()
    {
      try
      {
        AppMethodBeat.i(33010);
        Log.i(g.this.TAG, "newcursor quit ");
        hfG();
        AppMethodBeat.o(33010);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final class a
    {
      int VTu;
      
      public a(int paramInt)
      {
        this.VTu = paramInt;
      }
    }
    
    final class b
      extends MMHandler
    {
      boolean VTw;
      public final int VTx = 1;
      public final int VTy = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.VTw)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (g.e.this)
        {
          g.e.this.VTt = g.e.this.hFS();
          Log.i(g.this.TAG, "newcursor updateWorkerRefresh status:%d, what:%s", new Object[] { Integer.valueOf(g.e.this.VTt), Integer.valueOf(paramMessage.what) });
          if (paramMessage.what == 1)
          {
            g.d(g.this);
            AppMethodBeat.o(33003);
            return;
          }
        }
        if (paramMessage.what == 2) {
          g.a(g.this, (g.c)paramMessage.obj, false, true);
        }
        AppMethodBeat.o(33003);
      }
    }
    
    final class c
      extends MMHandler
    {
      private final int VTA;
      private final int VTB;
      long VTz;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.VTA = (hashCode() | 0x776);
        this.VTB = (hashCode() | 0x77A);
        g.e.this.VTs = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.VTB)
        {
          removeMessages(this.VTA);
          long l = System.currentTimeMillis();
          if ((l - this.VTz > g.this.VTc) || (l - this.VTz < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > g.this.VTd)) || (l - this.lastUpdateTime < 0L)) {
            g.e.a(g.e.this);
          }
          for (;;)
          {
            this.VTz = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.VTA, g.this.VTc);
          }
        }
        if (paramMessage.what == this.VTA) {
          g.e.a(g.e.this);
        }
        AppMethodBeat.o(33005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */