package com.tencent.mm.ui;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.a.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class f<K, T extends a>
  extends BaseAdapter
{
  protected boolean IVc = true;
  protected f<K, T>.c IVd;
  protected a IVe;
  public int IVf = 1000;
  public int IVg = 3000;
  public boolean IVh = true;
  int IVi = 0;
  private boolean IVj;
  private boolean IVk;
  private f<K, T>.e IVl;
  public K IVm = null;
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, b<K, T>> events;
  private int pageSize;
  private int vbd = 0;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    ad.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.IVj = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.IVj = true;
    this.IVk = false;
    this.IVf = 800;
    this.IVg = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    wZ(true);
    if ((this.IVd == null) || (this.IVd.IPF != paramd))
    {
      if ((this.IVd != null) && (!this.IVd.isClosed()))
      {
        this.IVd.close();
        this.IVd = null;
      }
      this.IVd = new c(paramd);
      this.IVd.getCount();
      fvh();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    wZ(false);
    this.IVd = paramf;
    this.IVd.getCount();
    fvh();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.IVl != null) && (this.IVl.fvw())) {
        this.IVl.fvu();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void fvr()
        {
          AppMethodBeat.i(32997);
          f.a(f.this, paramf);
          AppMethodBeat.o(32997);
        }
      });
      return;
    }
    a(paramf);
  }
  
  private void a(d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.IVe != null) {
      this.IVe.fvs();
    }
    paramd.fvr();
    notifyDataSetChanged();
    if (this.IVe != null) {
      this.IVe.aSs();
    }
    if (this.IVl != null) {
      this.IVl.fvx();
    }
    ad.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void cM(String paramString, boolean paramBoolean)
  {
    if ((!fvp()) && ((this.IVh | paramBoolean)))
    {
      if (!paramBoolean) {
        ad.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.IVh), paramString, bt.flS() });
      }
      lR(false);
    }
  }
  
  private void fvh()
  {
    if (this.IVj) {
      if (!this.IVd.ftJ()) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      if ((i != this.IVi) && (this.IVi != 0))
      {
        if ((this.IVl != null) && (this.IVl.fvw())) {
          a(new c(fvj()), true, false);
        }
        ad.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.IVi = i;
      return;
    }
  }
  
  private void fvm()
  {
    this.events.clear();
    this.events.put(this.IVm, null);
  }
  
  private void fvn()
  {
    if (!fvo()) {
      return;
    }
    int i = getChangeType();
    if (this.IVl != null)
    {
      int j = this.IVl.fvy();
      ad.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.IVl.fvu();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.vbd = 0;
      if (i == 2)
      {
        a(new c(fvj()), true, true);
        return;
      }
      fvq();
      return;
    }
  }
  
  private boolean fvo()
  {
    return ((this.IVl != null) && (this.IVl.fvw())) || (getChangeType() != 0);
  }
  
  private boolean fvp()
  {
    return this.vbd == 0;
  }
  
  private void fvq()
  {
    if ((this.IVd != null) && (!this.IVd.isClosed()) && (this.events.size() == 0))
    {
      ad.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void fvr()
      {
        AppMethodBeat.i(32996);
        Object localObject1;
        Object localObject2;
        if (f.a(f.this, f.b(f.this)))
        {
          localObject1 = new HashSet(f.b(f.this).size());
          localObject2 = f.b(f.this).values().iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((HashSet)localObject1).add(((f.b)((Iterator)localObject2).next()).object);
          }
          ad.i(f.this.TAG, "newcursor all event is delete");
          f.c(f.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          f.b(f.this).clear();
          AppMethodBeat.o(32996);
          return;
          long l;
          if (!f.b(f.this).containsKey(f.this.IVm))
          {
            l = System.currentTimeMillis();
            localObject2 = f.this.fvk();
            localObject1 = f.this.a(new HashSet(f.b(f.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                ad.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            ad.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = f.b(f.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              f.b localb = (f.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.IVq != null) {
                  ad.i(f.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                f.c(f.this).c(localb.object, (a)localb.IVq);
              }
              else
              {
                ad.e(f.this.TAG, "newcursor event is null ! ");
              }
            }
            f.this.a((SparseArray[])localObject1);
            ad.i(f.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(f.this).ftH()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            f.a(f.this, new f.c(f.this, f.this.fvj()), true, false);
            ad.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
      }
    });
  }
  
  private int getChangeType()
  {
    if ((this.events == null) || (this.events.size() == 0)) {
      return 0;
    }
    if (this.events.containsKey(this.IVm)) {
      return 2;
    }
    return 1;
  }
  
  public final void a(a parama)
  {
    this.IVe = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.IVd.ftH();
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
  
  public abstract SparseArray<K>[] a(HashSet<b<K, T>> paramHashSet, SparseArray<K>[] paramArrayOfSparseArray);
  
  public abstract ArrayList<T> aV(ArrayList<K> paramArrayList);
  
  public final T abj(int paramInt)
  {
    if (this.IVd == null) {
      a(fvj());
    }
    cM("getItem", false);
    this.IVd.IPF.moveToPosition(paramInt);
    a locala = this.IVd.IPF.abj(paramInt);
    if (locala != null)
    {
      locala.foH();
      return locala;
    }
    ad.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  protected boolean ftJ()
  {
    if (this.IVd == null) {
      return false;
    }
    return this.IVd.ftJ();
  }
  
  public abstract T ftV();
  
  public final void fvg()
  {
    this.IVe = null;
  }
  
  public final int fvi()
  {
    if (this.IVd == null) {
      return 0;
    }
    d locald = this.IVd.IPF;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).IPv[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> fvj();
  
  public final SparseArray<K>[] fvk()
  {
    if (this.IVd == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.IVd.ftH();
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
  
  public int getCount()
  {
    if (this.IVd == null)
    {
      long l = System.currentTimeMillis();
      a(fvj());
      ad.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    cM("getcount", false);
    if (this.IVd == null)
    {
      ad.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.IVd.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void lR(boolean paramBoolean)
  {
    if ((this.IVk) || (paramBoolean)) {
      fvn();
    }
    for (;;)
    {
      this.vbd = 0;
      return;
      int i = getChangeType();
      if (i == 0)
      {
        ad.i(this.TAG, "newcursor need not change ");
        return;
      }
      if (i == 2)
      {
        ad.i(this.TAG, "newcursor enqueueMessage resetcursor ");
        this.events.clear();
      }
      if (this.IVl == null) {
        this.IVl = new e();
      }
      this.IVl.abx(i);
    }
  }
  
  public void n(K paramK, int paramInt)
  {
    boolean bool;
    if (this.IVd != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.IVm);
      if ((paramInt != 5) && (this.IVj) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      fvm();
    }
    label87:
    do
    {
      break label170;
      ad.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.vbd = getChangeType();
      paramK = this.TAG;
      int j = this.vbd;
      if (this.IVi == 1) {}
      for (bool = true;; bool = false)
      {
        ad.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        ad.i(this.TAG, "newcursor event is refresh sync ");
        lR(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new b(paramK, paramInt));
        break;
        if (bool)
        {
          ad.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.IVi == 1)
        {
          if ((this.IVd.dX(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            b localb1 = new b(paramK, paramInt);
            if ((localb1.IVp == 2) && (this.IVd.dX(localb1.object))) {
              localb1.IVp = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.IVp)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.IVp)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.IVp = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.IVd;
              i = localHashMap.size();
              if (!paramK.IPF.abi(i))
              {
                ad.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.IVm, null);
              }
              ad.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.IVp)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.IVp = 5;
                break;
              case 5: 
                ad.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.IVp = 5;
                break;
                switch (localb2.IVp)
                {
                case 3: 
                case 4: 
                default: 
                  ad.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.IVp = 2;
                  break;
                case 5: 
                  localb1.IVp = 3;
                  break;
                case 2: 
                  ad.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.IVp = 2;
                  break;
                  ad.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.IVp = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          ad.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        fvm();
        i = 0;
        break label87;
      }
    } while ((!this.IVc) || (!this.IVh));
    label170:
    label171:
    label197:
    label711:
    lR(false);
    label302:
  }
  
  public void pause()
  {
    this.IVc = false;
    ad.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    ad.i(this.TAG, "newcursor resume ");
    this.IVc = true;
    cM("resume", true);
  }
  
  public final void wZ(boolean paramBoolean)
  {
    if (this.IVd != null)
    {
      this.IVd.close();
      this.IVd = null;
    }
    if ((paramBoolean) && (this.IVl != null))
    {
      this.IVl.quit();
      this.IVl = null;
      if (this.events != null)
      {
        this.events.clear();
        ad.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.vbd = 0;
    this.IVi = 0;
  }
  
  public static abstract interface a
  {
    public abstract void aSs();
    
    public abstract void fvs();
  }
  
  public static final class b<K, T>
  {
    public int IVp;
    public T IVq;
    public K object;
    
    public b(K paramK, int paramInt)
    {
      this.object = paramK;
      this.IVp = paramInt;
      this.IVq = null;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(32999);
      if (this == paramObject)
      {
        AppMethodBeat.o(32999);
        return true;
      }
      if (paramObject == null)
      {
        AppMethodBeat.o(32999);
        return false;
      }
      if (getClass() != paramObject.getClass())
      {
        AppMethodBeat.o(32999);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.IVp != paramObject.IVp)
      {
        AppMethodBeat.o(32999);
        return false;
      }
      if (this.object == null)
      {
        if (paramObject.object != null)
        {
          AppMethodBeat.o(32999);
          return false;
        }
      }
      else if (!this.object.equals(paramObject.object))
      {
        AppMethodBeat.o(32999);
        return false;
      }
      AppMethodBeat.o(32999);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(32998);
      int j = this.IVp;
      if (this.object == null) {}
      for (int i = 0;; i = this.object.hashCode())
      {
        AppMethodBeat.o(32998);
        return i + (j + 31) * 31;
      }
    }
  }
  
  final class c
    extends g<K, T>
  {
    public c()
    {
      super(f.a(f.this));
      AppMethodBeat.i(33000);
      AppMethodBeat.o(33000);
    }
    
    public final ArrayList<T> aV(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = f.this.aV(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T ftX()
    {
      AppMethodBeat.i(33001);
      a locala = f.this.ftV();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void fvr();
  }
  
  final class e
  {
    f<K, T>.e.b IVr;
    private f<K, T>.e.c IVs;
    LinkedList<Integer> IVt;
    int IVu;
    
    public e()
    {
      AppMethodBeat.i(33006);
      fvt();
      AppMethodBeat.o(33006);
    }
    
    private void eYP()
    {
      AppMethodBeat.i(33008);
      Object localObject = this.IVs;
      ((c)localObject).removeMessages(((c)localObject).IVB);
      ((c)localObject).removeMessages(((c)localObject).IVC);
      localObject = this.IVr;
      ((b)localObject).IVx = true;
      ((b)localObject).removeMessages(1);
      ((b)localObject).removeMessages(2);
      this.IVt.clear();
      this.IVu = 0;
      AppMethodBeat.o(33008);
    }
    
    private void fvt()
    {
      AppMethodBeat.i(33007);
      this.IVr = new b(Looper.getMainLooper());
      this.IVs = new c(ba.ajF().IdO.getLooper());
      AppMethodBeat.o(33007);
    }
    
    final void abx(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.IVt.contains(Integer.valueOf(paramInt))) {
          this.IVt.add(Integer.valueOf(paramInt));
        }
        this.IVu = fvv();
        c localc = this.IVs;
        localc.sendEmptyMessage(localc.IVC);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void fvu()
    {
      try
      {
        AppMethodBeat.i(33009);
        ad.i(f.this.TAG, "newcursor resetQueue ");
        eYP();
        fvt();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int fvv()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.IVt.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.IVt.size() == 1) {
          i = ((Integer)this.IVt.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean fvw()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 156	com/tencent/mm/ui/f$e:IVu	I
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
    
    final void fvx()
    {
      try
      {
        AppMethodBeat.i(33012);
        this.IVs.lastUpdateTime = System.currentTimeMillis();
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int fvy()
    {
      try
      {
        int i = this.IVu;
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
        ad.i(f.this.TAG, "newcursor quit ");
        eYP();
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
      int IVv;
      
      public a(int paramInt)
      {
        this.IVv = paramInt;
      }
    }
    
    final class b
      extends ap
    {
      boolean IVx;
      public final int IVy = 1;
      public final int IVz = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.IVx)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (f.e.this)
        {
          f.e.this.IVu = f.e.this.fvv();
          ad.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.IVu) });
          if (paramMessage.what == 1)
          {
            f.d(f.this);
            AppMethodBeat.o(33003);
            return;
          }
        }
        if (paramMessage.what == 2) {
          f.a(f.this, (f.c)paramMessage.obj, false, true);
        }
        AppMethodBeat.o(33003);
      }
    }
    
    final class c
      extends ap
    {
      long IVA;
      final int IVB;
      final int IVC;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.IVB = (hashCode() | 0x776);
        this.IVC = (hashCode() | 0x77A);
        f.e.this.IVt = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.IVC)
        {
          removeMessages(this.IVB);
          long l = System.currentTimeMillis();
          if ((l - this.IVA > f.this.IVf) || (l - this.IVA < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.IVg)) || (l - this.lastUpdateTime < 0L)) {
            f.e.a(f.e.this);
          }
          for (;;)
          {
            this.IVA = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.IVB, f.this.IVf);
          }
        }
        if (paramMessage.what == this.IVB) {
          f.e.a(f.e.this);
        }
        AppMethodBeat.o(33005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */