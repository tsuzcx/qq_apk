package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.storagebase.a.e;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class g<K, T extends a>
  extends BaseAdapter
{
  private int KdI = 0;
  public String TAG = "MicroMsg.CursorDataAdapter";
  private boolean adxh = true;
  private g<K, T>.c adxi;
  private HashMap<K, g.b<K, T>> adxj;
  protected a adxk;
  public int adxl = 1000;
  public int adxm = 3000;
  public boolean adxn = true;
  int adxo = 0;
  private boolean adxp;
  private boolean adxq;
  private g<K, T>.e adxr;
  public K adxs = null;
  public Context context;
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
    this.adxp = true;
  }
  
  private g(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.adxp = true;
    this.adxq = false;
    this.adxl = 800;
    this.adxm = 2000;
  }
  
  public g(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    KV(true);
    if ((this.adxi == null) || (this.adxi.adoh != paramd))
    {
      if ((this.adxi != null) && (!this.adxi.isClosed()))
      {
        this.adxi.close();
        this.adxi = null;
      }
      this.adxi = b(paramd);
      this.adxi.getCount();
      jhP();
      notifyDataSetChanged();
    }
  }
  
  private void a(g<K, T>.c paramg)
  {
    KV(false);
    this.adxi = paramg;
    this.adxi.getCount();
    jhP();
  }
  
  private void a(final g<K, T>.c paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.adxr != null) && (this.adxr.jie())) {
        this.adxr.jic();
      }
      if (this.adxj != null) {
        this.adxj.clear();
      }
    }
    if ((paramBoolean2) && (paramg != null) && (!paramg.adoi))
    {
      a(new d()
      {
        public final void goi()
        {
          AppMethodBeat.i(32997);
          g.a(g.this, paramg);
          AppMethodBeat.o(32997);
        }
      });
      return;
    }
    if ((paramg != null) && (paramg.adoi) && (paramBoolean2))
    {
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250070);
          int i = paramg.getCount();
          Log.i(g.this.TAG, "select db count: %d", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(249249);
              g.a(g.this, new g.d()
              {
                public final void goi()
                {
                  AppMethodBeat.i(249508);
                  g.a(g.this, g.3.this.adxu);
                  AppMethodBeat.o(249508);
                }
              });
              AppMethodBeat.o(249249);
            }
          });
          AppMethodBeat.o(250070);
        }
      });
      return;
    }
    a(paramg);
  }
  
  private void a(d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.adxk != null) {
      this.adxk.jia();
    }
    if (paramd != null) {
      paramd.goi();
    }
    notifyDataSetChanged();
    if (this.adxk != null) {
      this.adxk.bWC();
    }
    if (this.adxr != null) {
      this.adxr.jif();
    }
    Log.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.adxq) || (paramBoolean1)) {
      jhV();
    }
    for (;;)
    {
      this.KdI = 0;
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
        this.adxj.clear();
      }
      if (this.adxr == null) {
        this.adxr = new e();
      }
      this.adxr.cC(i, paramBoolean2);
    }
  }
  
  private void c(K paramK, int paramInt, boolean paramBoolean)
  {
    if (this.adxi == null) {}
    label89:
    do
    {
      return;
      if (this.adxj == null) {
        this.adxj = new HashMap();
      }
      boolean bool = this.adxj.containsKey(this.adxs);
      int i;
      int j;
      if ((paramInt == 5) || (!this.adxp) || (paramInt == 1)) {
        if (paramInt != 5)
        {
          jhU();
          Log.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
          i = 1;
          this.KdI = getChangeType();
          paramK = this.TAG;
          j = this.KdI;
          if (this.adxo != 1) {
            break label719;
          }
        }
      }
      for (bool = true;; bool = false)
      {
        Log.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label725;
        }
        Log.i(this.TAG, "newcursor event is refresh sync ");
        aR(true, paramBoolean);
        return;
        if (bool) {
          break;
        }
        this.adxj.put(paramK, new g.b(paramK, paramInt));
        break;
        if (bool)
        {
          Log.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.adxo == 1)
        {
          if ((this.adxi.gF(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.adxj;
            g.b localb1 = new g.b(paramK, paramInt);
            if ((localb1.adxx == 2) && (this.adxi.gF(localb1.object))) {
              localb1.adxx = 3;
            }
            g.b localb2 = (g.b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label681;
              }
              localHashMap.remove(localb2);
              switch (localb1.adxx)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.adxx)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.adxx = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.adxi;
              i = localHashMap.size();
              if (!paramK.adoh.azm(i))
              {
                Log.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.adxs, null);
              }
              Log.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.adxj.size()) });
              i = 0;
              break;
              i = 0;
              break label307;
              switch (localb2.adxx)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.adxx = 5;
                break;
              case 5: 
                Log.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.adxx = 5;
                break;
                switch (localb2.adxx)
                {
                case 3: 
                case 4: 
                default: 
                  Log.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.adxx = 2;
                  break;
                case 5: 
                  localb1.adxx = 3;
                  break;
                case 2: 
                  Log.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.adxx = 2;
                  break;
                  Log.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label392;
                  localb1.adxx = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          Log.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label89;
        }
        jhU();
        i = 0;
        break label89;
      }
    } while ((!this.adxh) || (!this.adxn));
    label307:
    label719:
    label725:
    aR(false, paramBoolean);
    label392:
    label681:
    return;
  }
  
  private void ee(String paramString, boolean paramBoolean)
  {
    if ((!jhX()) && ((this.adxn | paramBoolean)))
    {
      if (!paramBoolean) {
        Log.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s", new Object[] { Boolean.valueOf(this.adxn), paramString });
      }
      aR(false, true);
    }
  }
  
  private int getChangeType()
  {
    if ((this.adxj == null) || (this.adxj.size() == 0)) {
      return 0;
    }
    if (this.adxj.containsKey(this.adxs)) {
      return 2;
    }
    return 1;
  }
  
  private void jhP()
  {
    if (this.adxp) {
      if (!this.adxi.jdV()) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 2)
    {
      if ((i != this.adxo) && (this.adxo != 0))
      {
        if ((this.adxr != null) && (this.adxr.jie())) {
          a(b(jhR()), true, false);
        }
        Log.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.adxo = i;
      return;
    }
  }
  
  private void jhU()
  {
    this.adxj.clear();
    this.adxj.put(this.adxs, null);
  }
  
  private void jhV()
  {
    if (!jhW()) {
      return;
    }
    int i = getChangeType();
    if (this.adxr != null)
    {
      int j = this.adxr.jig();
      Log.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.adxr.jic();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.KdI = 0;
      if (i == 2)
      {
        a(b(jhR()), true, true);
        return;
      }
      jhZ();
      return;
    }
  }
  
  private boolean jhW()
  {
    return ((this.adxr != null) && (this.adxr.jie())) || (getChangeType() != 0);
  }
  
  private boolean jhX()
  {
    return this.KdI == 0;
  }
  
  private void jhZ()
  {
    if ((this.adxi != null) && (!this.adxi.isClosed()) && (this.adxj.size() == 0))
    {
      Log.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void goi()
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
          if (!g.b(g.this).containsKey(g.this.adxs))
          {
            l = System.currentTimeMillis();
            localObject2 = g.this.jhS();
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
                if (localb.adxy != null) {
                  Log.i(g.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                g.c(g.this).c(localb.object, (a)localb.adxy);
              }
              else
              {
                Log.e(g.this.TAG, "newcursor event is null ! ");
              }
            }
            g.this.a((SparseArray[])localObject1);
            Log.i(g.this.TAG, "newcursor after resort new pos size:%d, event:%s", new Object[] { Integer.valueOf(g.c(g.this).jdT()[0].size()), Integer.valueOf(g.b(g.this).size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            g.a(g.this, g.this.b(g.this.jhR()), true, false);
            Log.i(g.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
      }
    });
  }
  
  public final void KV(boolean paramBoolean)
  {
    if (this.adxi != null)
    {
      this.adxi.close();
      this.adxi = null;
    }
    if ((paramBoolean) && (this.adxr != null))
    {
      this.adxr.quit();
      this.adxr = null;
      if (this.adxj != null)
      {
        this.adxj.clear();
        Log.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.KdI = 0;
    this.adxo = 0;
  }
  
  public final void a(a parama)
  {
    this.adxk = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.adxi.jdT();
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
  
  public final T azn(int paramInt)
  {
    if (this.adxi == null) {
      a(jhR());
    }
    ee("getItem", false);
    this.adxi.adoh.moveToPosition(paramInt);
    a locala = this.adxi.adoh.azn(paramInt);
    if (locala != null)
    {
      locala.iXb();
      return locala;
    }
    Log.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public g<K, T>.c b(d<K> paramd)
  {
    return new c(paramd, (byte)0);
  }
  
  public abstract ArrayList<T> ce(ArrayList<K> paramArrayList);
  
  public final void d(K paramK, int paramInt, boolean paramBoolean)
  {
    c(paramK, paramInt, paramBoolean);
  }
  
  public final T gG(K paramK)
  {
    if (this.adxi == null) {
      return null;
    }
    return this.adxi.adoh.gG(paramK);
  }
  
  public int getCount()
  {
    if (this.adxi == null)
    {
      long l = System.currentTimeMillis();
      a(jhR());
      Log.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    ee("getcount", false);
    if (this.adxi == null)
    {
      Log.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.adxi.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  protected boolean jdV()
  {
    if (this.adxi == null) {
      return false;
    }
    return this.adxi.jdV();
  }
  
  public abstract T jeg();
  
  public final void jhO()
  {
    this.adxk = null;
  }
  
  public final int jhQ()
  {
    if (this.adxi == null) {
      return 0;
    }
    d locald = this.adxi.adoh;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).adnX[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> jhR();
  
  public final SparseArray<K>[] jhS()
  {
    if (this.adxi == null) {}
    SparseArray[] arrayOfSparseArray1;
    do
    {
      return null;
      arrayOfSparseArray1 = this.adxi.jdT();
    } while (arrayOfSparseArray1 == null);
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
  
  public final HashMap<Object, T> jhT()
  {
    if (this.adxi == null) {
      return null;
    }
    return this.adxi.adoh.jdU();
  }
  
  public final void jhY()
  {
    Log.i(this.TAG, "newcursor resume syncNow ");
    this.adxh = true;
    aR(true, true);
  }
  
  public void pause()
  {
    this.adxh = false;
    Log.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    Log.i(this.TAG, "newcursor resume ");
    this.adxh = true;
    ee("resume", true);
  }
  
  public void v(K paramK, int paramInt)
  {
    c(paramK, paramInt, true);
  }
  
  public static abstract interface a
  {
    public abstract void bWC();
    
    public abstract void jia();
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
      AppMethodBeat.i(249733);
      AppMethodBeat.o(249733);
    }
    
    public final ArrayList<T> ce(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = g.this.ce(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T jei()
    {
      AppMethodBeat.i(33001);
      a locala = g.this.jeg();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void goi();
  }
  
  final class e
  {
    private g<K, T>.e.c adxA;
    LinkedList<Integer> adxB;
    int adxC;
    g<K, T>.e.b adxz;
    
    public e()
    {
      AppMethodBeat.i(33006);
      jib();
      AppMethodBeat.o(33006);
    }
    
    private void iGB()
    {
      AppMethodBeat.i(33008);
      c.a(this.adxA);
      b localb = this.adxz;
      localb.adxF = true;
      localb.removeMessages(1);
      localb.removeMessages(2);
      this.adxB.clear();
      this.adxC = 0;
      AppMethodBeat.o(33008);
    }
    
    private void jib()
    {
      AppMethodBeat.i(33007);
      this.adxz = new b(Looper.getMainLooper());
      this.adxA = new c(bh.baH().getLooper());
      AppMethodBeat.o(33007);
    }
    
    final void cC(int paramInt, boolean paramBoolean)
    {
      try
      {
        AppMethodBeat.i(249750);
        if (!this.adxB.contains(Integer.valueOf(paramInt))) {
          this.adxB.add(Integer.valueOf(paramInt));
        }
        this.adxC = jid();
        c.a(this.adxA, paramBoolean);
        AppMethodBeat.o(249750);
        return;
      }
      finally {}
    }
    
    public final void jic()
    {
      try
      {
        AppMethodBeat.i(33009);
        Log.i(g.this.TAG, "newcursor resetQueue ");
        iGB();
        jib();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int jid()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.adxB.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.adxB.size() == 1) {
          i = ((Integer)this.adxB.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean jie()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 152	com/tencent/mm/ui/g$e:adxC	I
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
    
    final void jif()
    {
      try
      {
        AppMethodBeat.i(33012);
        c.b(this.adxA);
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int jig()
    {
      try
      {
        int i = this.adxC;
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
        iGB();
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
      int adxD;
      
      public a(int paramInt)
      {
        this.adxD = paramInt;
      }
    }
    
    final class b
      extends MMHandler
    {
      boolean adxF;
      public final int adxG = 1;
      public final int adxH = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.adxF)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (g.e.this)
        {
          g.e.this.adxC = g.e.this.jid();
          Log.i(g.this.TAG, "newcursor updateWorkerRefresh status:%d, what:%s", new Object[] { Integer.valueOf(g.e.this.adxC), Integer.valueOf(paramMessage.what) });
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
      long adxI;
      boolean adxJ;
      private final int adxK;
      private final int adxL;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.adxK = (hashCode() | 0x776);
        this.adxL = (hashCode() | 0x77A);
        g.e.this.adxB = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.adxL)
        {
          removeMessages(this.adxK);
          long l = System.currentTimeMillis();
          this.adxJ = true;
          if ((paramMessage.obj instanceof Boolean)) {
            this.adxJ = ((Boolean)paramMessage.obj).booleanValue();
          }
          if ((l - this.adxI > g.this.adxl) || (l - this.adxI < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > g.this.adxm)) || (l - this.lastUpdateTime < 0L) || (!this.adxJ)) {
            g.e.a(g.e.this);
          }
          for (;;)
          {
            this.adxI = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.adxK, g.this.adxl);
          }
        }
        if (paramMessage.what == this.adxK) {
          g.e.a(g.e.this);
        }
        AppMethodBeat.o(33005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.g
 * JD-Core Version:    0.7.0.1
 */