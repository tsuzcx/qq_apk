package com.tencent.mm.ui;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  protected boolean JpK = true;
  protected f<K, T>.c JpL;
  protected a JpM;
  public int JpN = 1000;
  public int JpO = 3000;
  public boolean JpP = true;
  int JpQ = 0;
  private boolean JpR;
  private boolean JpS;
  private f<K, T>.e JpT;
  public K JpU = null;
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, b<K, T>> events;
  private int pageSize;
  private int vno = 0;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    ae.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.JpR = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.JpR = true;
    this.JpS = false;
    this.JpN = 800;
    this.JpO = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    xh(true);
    if ((this.JpL == null) || (this.JpL.Jkn != paramd))
    {
      if ((this.JpL != null) && (!this.JpL.isClosed()))
      {
        this.JpL.close();
        this.JpL = null;
      }
      this.JpL = new c(paramd);
      this.JpL.getCount();
      fzi();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    xh(false);
    this.JpL = paramf;
    this.JpL.getCount();
    fzi();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.JpT != null) && (this.JpT.fzw())) {
        this.JpT.fzu();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void fzr()
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
    if (this.JpM != null) {
      this.JpM.fzs();
    }
    paramd.fzr();
    notifyDataSetChanged();
    if (this.JpM != null) {
      this.JpM.aSR();
    }
    if (this.JpT != null) {
      this.JpT.fzx();
    }
    ae.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void cQ(String paramString, boolean paramBoolean)
  {
    if ((!fzp()) && ((this.JpP | paramBoolean)))
    {
      if (!paramBoolean) {
        ae.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.JpP), paramString, bu.fpN() });
      }
      lR(false);
    }
  }
  
  private void fzi()
  {
    if (this.JpR) {
      if (!this.JpL.fxK()) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      if ((i != this.JpQ) && (this.JpQ != 0))
      {
        if ((this.JpT != null) && (this.JpT.fzw())) {
          a(new c(fzk()), true, false);
        }
        ae.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.JpQ = i;
      return;
    }
  }
  
  private void fzm()
  {
    this.events.clear();
    this.events.put(this.JpU, null);
  }
  
  private void fzn()
  {
    if (!fzo()) {
      return;
    }
    int i = getChangeType();
    if (this.JpT != null)
    {
      int j = this.JpT.fzy();
      ae.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.JpT.fzu();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      ae.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.vno = 0;
      if (i == 2)
      {
        a(new c(fzk()), true, true);
        return;
      }
      fzq();
      return;
    }
  }
  
  private boolean fzo()
  {
    return ((this.JpT != null) && (this.JpT.fzw())) || (getChangeType() != 0);
  }
  
  private boolean fzp()
  {
    return this.vno == 0;
  }
  
  private void fzq()
  {
    if ((this.JpL != null) && (!this.JpL.isClosed()) && (this.events.size() == 0))
    {
      ae.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void fzr()
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
          ae.i(f.this.TAG, "newcursor all event is delete");
          f.c(f.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          f.b(f.this).clear();
          AppMethodBeat.o(32996);
          return;
          long l;
          if (!f.b(f.this).containsKey(f.this.JpU))
          {
            l = System.currentTimeMillis();
            localObject2 = f.this.fzl();
            localObject1 = f.this.a(new HashSet(f.b(f.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                ae.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            ae.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = f.b(f.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              f.b localb = (f.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.JpY != null) {
                  ae.i(f.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                f.c(f.this).c(localb.object, (a)localb.JpY);
              }
              else
              {
                ae.e(f.this.TAG, "newcursor event is null ! ");
              }
            }
            f.this.a((SparseArray[])localObject1);
            ae.i(f.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(f.this).fxI()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            f.a(f.this, new f.c(f.this, f.this.fzk()), true, false);
            ae.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    if (this.events.containsKey(this.JpU)) {
      return 2;
    }
    return 1;
  }
  
  public final void a(a parama)
  {
    this.JpM = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.JpL.fxI();
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
  
  public abstract ArrayList<T> aW(ArrayList<K> paramArrayList);
  
  public final T abR(int paramInt)
  {
    if (this.JpL == null) {
      a(fzk());
    }
    cQ("getItem", false);
    this.JpL.Jkn.moveToPosition(paramInt);
    a locala = this.JpL.Jkn.abR(paramInt);
    if (locala != null)
    {
      locala.fsA();
      return locala;
    }
    ae.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  protected boolean fxK()
  {
    if (this.JpL == null) {
      return false;
    }
    return this.JpL.fxK();
  }
  
  public abstract T fxW();
  
  public final void fzh()
  {
    this.JpM = null;
  }
  
  public final int fzj()
  {
    if (this.JpL == null) {
      return 0;
    }
    d locald = this.JpL.Jkn;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).Jkd[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> fzk();
  
  public final SparseArray<K>[] fzl()
  {
    if (this.JpL == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.JpL.fxI();
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
    if (this.JpL == null)
    {
      long l = System.currentTimeMillis();
      a(fzk());
      ae.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    cQ("getcount", false);
    if (this.JpL == null)
    {
      ae.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.JpL.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void lR(boolean paramBoolean)
  {
    if ((this.JpS) || (paramBoolean)) {
      fzn();
    }
    for (;;)
    {
      this.vno = 0;
      return;
      int i = getChangeType();
      if (i == 0)
      {
        ae.i(this.TAG, "newcursor need not change ");
        return;
      }
      if (i == 2)
      {
        ae.i(this.TAG, "newcursor enqueueMessage resetcursor ");
        this.events.clear();
      }
      if (this.JpT == null) {
        this.JpT = new e();
      }
      this.JpT.acf(i);
    }
  }
  
  public void n(K paramK, int paramInt)
  {
    boolean bool;
    if (this.JpL != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.JpU);
      if ((paramInt != 5) && (this.JpR) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      fzm();
    }
    label87:
    do
    {
      break label170;
      ae.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.vno = getChangeType();
      paramK = this.TAG;
      int j = this.vno;
      if (this.JpQ == 1) {}
      for (bool = true;; bool = false)
      {
        ae.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        ae.i(this.TAG, "newcursor event is refresh sync ");
        lR(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new b(paramK, paramInt));
        break;
        if (bool)
        {
          ae.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.JpQ == 1)
        {
          if ((this.JpL.dY(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            b localb1 = new b(paramK, paramInt);
            if ((localb1.JpX == 2) && (this.JpL.dY(localb1.object))) {
              localb1.JpX = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.JpX)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.JpX)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.JpX = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.JpL;
              i = localHashMap.size();
              if (!paramK.Jkn.abQ(i))
              {
                ae.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.JpU, null);
              }
              ae.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.JpX)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.JpX = 5;
                break;
              case 5: 
                ae.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.JpX = 5;
                break;
                switch (localb2.JpX)
                {
                case 3: 
                case 4: 
                default: 
                  ae.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.JpX = 2;
                  break;
                case 5: 
                  localb1.JpX = 3;
                  break;
                case 2: 
                  ae.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.JpX = 2;
                  break;
                  ae.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.JpX = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          ae.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        fzm();
        i = 0;
        break label87;
      }
    } while ((!this.JpK) || (!this.JpP));
    label170:
    label171:
    label197:
    label711:
    lR(false);
    label302:
  }
  
  public void pause()
  {
    this.JpK = false;
    ae.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    ae.i(this.TAG, "newcursor resume ");
    this.JpK = true;
    cQ("resume", true);
  }
  
  public final void xh(boolean paramBoolean)
  {
    if (this.JpL != null)
    {
      this.JpL.close();
      this.JpL = null;
    }
    if ((paramBoolean) && (this.JpT != null))
    {
      this.JpT.quit();
      this.JpT = null;
      if (this.events != null)
      {
        this.events.clear();
        ae.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.vno = 0;
    this.JpQ = 0;
  }
  
  public static abstract interface a
  {
    public abstract void aSR();
    
    public abstract void fzs();
  }
  
  public static final class b<K, T>
  {
    public int JpX;
    public T JpY;
    public K object;
    
    public b(K paramK, int paramInt)
    {
      this.object = paramK;
      this.JpX = paramInt;
      this.JpY = null;
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
      if (this.JpX != paramObject.JpX)
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
      int j = this.JpX;
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
    
    public final ArrayList<T> aW(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = f.this.aW(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T fxY()
    {
      AppMethodBeat.i(33001);
      a locala = f.this.fxW();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void fzr();
  }
  
  final class e
  {
    f<K, T>.e.b JpZ;
    private f<K, T>.e.c Jqa;
    LinkedList<Integer> Jqb;
    int Jqc;
    
    public e()
    {
      AppMethodBeat.i(33006);
      fzt();
      AppMethodBeat.o(33006);
    }
    
    private void fcD()
    {
      AppMethodBeat.i(33008);
      Object localObject = this.Jqa;
      ((c)localObject).removeMessages(((c)localObject).Jqj);
      ((c)localObject).removeMessages(((c)localObject).Jqk);
      localObject = this.JpZ;
      ((b)localObject).Jqf = true;
      ((b)localObject).removeMessages(1);
      ((b)localObject).removeMessages(2);
      this.Jqb.clear();
      this.Jqc = 0;
      AppMethodBeat.o(33008);
    }
    
    private void fzt()
    {
      AppMethodBeat.i(33007);
      this.JpZ = new b(Looper.getMainLooper());
      this.Jqa = new c(bc.ajU().IxZ.getLooper());
      AppMethodBeat.o(33007);
    }
    
    final void acf(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.Jqb.contains(Integer.valueOf(paramInt))) {
          this.Jqb.add(Integer.valueOf(paramInt));
        }
        this.Jqc = fzv();
        c localc = this.Jqa;
        localc.sendEmptyMessage(localc.Jqk);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void fzu()
    {
      try
      {
        AppMethodBeat.i(33009);
        ae.i(f.this.TAG, "newcursor resetQueue ");
        fcD();
        fzt();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int fzv()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.Jqb.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.Jqb.size() == 1) {
          i = ((Integer)this.Jqb.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean fzw()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 156	com/tencent/mm/ui/f$e:Jqc	I
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
    
    final void fzx()
    {
      try
      {
        AppMethodBeat.i(33012);
        this.Jqa.lastUpdateTime = System.currentTimeMillis();
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int fzy()
    {
      try
      {
        int i = this.Jqc;
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
        ae.i(f.this.TAG, "newcursor quit ");
        fcD();
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
      int Jqd;
      
      public a(int paramInt)
      {
        this.Jqd = paramInt;
      }
    }
    
    final class b
      extends aq
    {
      boolean Jqf;
      public final int Jqg = 1;
      public final int Jqh = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.Jqf)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (f.e.this)
        {
          f.e.this.Jqc = f.e.this.fzv();
          ae.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.Jqc) });
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
      extends aq
    {
      long Jqi;
      final int Jqj;
      final int Jqk;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.Jqj = (hashCode() | 0x776);
        this.Jqk = (hashCode() | 0x77A);
        f.e.this.Jqb = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.Jqk)
        {
          removeMessages(this.Jqj);
          long l = System.currentTimeMillis();
          if ((l - this.Jqi > f.this.JpN) || (l - this.Jqi < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.JpO)) || (l - this.lastUpdateTime < 0L)) {
            f.e.a(f.e.this);
          }
          for (;;)
          {
            this.Jqi = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.Jqj, f.this.JpN);
          }
        }
        if (paramMessage.what == this.Jqj) {
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