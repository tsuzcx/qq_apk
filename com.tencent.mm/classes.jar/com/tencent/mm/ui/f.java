package com.tencent.mm.ui;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
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
  protected boolean FID = true;
  protected f<K, T>.c FIE;
  protected a FIF;
  public int FIG = 1000;
  public int FIH = 3000;
  public boolean FII = true;
  int FIJ = 0;
  private boolean FIK;
  private boolean FIL;
  private f<K, T>.e FIM;
  public K FIN = null;
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, b<K, T>> events;
  private int pageSize;
  private int sQh = 0;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    ad.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.FIK = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.FIK = true;
    this.FIL = false;
    this.FIG = 800;
    this.FIH = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    vl(true);
    if ((this.FIE == null) || (this.FIE.FDm != paramd))
    {
      if ((this.FIE != null) && (!this.FIE.isClosed()))
      {
        this.FIE.close();
        this.FIE = null;
      }
      this.FIE = new c(paramd);
      this.FIE.getCount();
      ePv();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    vl(false);
    this.FIE = paramf;
    this.FIE.getCount();
    ePv();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.FIM != null) && (this.FIM.ePJ())) {
        this.FIM.ePH();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void ePE()
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
    if (this.FIF != null) {
      this.FIF.ePF();
    }
    paramd.ePE();
    notifyDataSetChanged();
    if (this.FIF != null) {
      this.FIF.aIp();
    }
    if (this.FIM != null) {
      this.FIM.ePK();
    }
    ad.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void cB(String paramString, boolean paramBoolean)
  {
    if ((!ePC()) && ((this.FII | paramBoolean)))
    {
      if (!paramBoolean) {
        ad.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.FII), paramString, bt.eGN() });
      }
      kT(false);
    }
  }
  
  private void ePA()
  {
    if (!ePB()) {
      return;
    }
    int i = getChangeType();
    if (this.FIM != null)
    {
      int j = this.FIM.ePL();
      ad.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.FIM.ePH();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      ad.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.sQh = 0;
      if (i == 2)
      {
        a(new c(ePx()), true, true);
        return;
      }
      ePD();
      return;
    }
  }
  
  private boolean ePB()
  {
    return ((this.FIM != null) && (this.FIM.ePJ())) || (getChangeType() != 0);
  }
  
  private boolean ePC()
  {
    return this.sQh == 0;
  }
  
  private void ePD()
  {
    if ((this.FIE != null) && (!this.FIE.isClosed()) && (this.events.size() == 0))
    {
      ad.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void ePE()
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
          if (!f.b(f.this).containsKey(f.this.FIN))
          {
            l = System.currentTimeMillis();
            localObject2 = f.this.ePy();
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
                if (localb.FIR != null) {
                  ad.i(f.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                f.c(f.this).c(localb.object, (a)localb.FIR);
              }
              else
              {
                ad.e(f.this.TAG, "newcursor event is null ! ");
              }
            }
            f.this.a((SparseArray[])localObject1);
            ad.i(f.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(f.this).eNV()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            f.a(f.this, new f.c(f.this, f.this.ePx()), true, false);
            ad.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
      }
    });
  }
  
  private void ePv()
  {
    if (this.FIK) {
      if (!this.FIE.eNX()) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      if ((i != this.FIJ) && (this.FIJ != 0))
      {
        if ((this.FIM != null) && (this.FIM.ePJ())) {
          a(new c(ePx()), true, false);
        }
        ad.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.FIJ = i;
      return;
    }
  }
  
  private void ePz()
  {
    this.events.clear();
    this.events.put(this.FIN, null);
  }
  
  private int getChangeType()
  {
    if ((this.events == null) || (this.events.size() == 0)) {
      return 0;
    }
    if (this.events.containsKey(this.FIN)) {
      return 2;
    }
    return 1;
  }
  
  public final T WQ(int paramInt)
  {
    if (this.FIE == null) {
      a(ePx());
    }
    cB("getItem", false);
    this.FIE.FDm.moveToPosition(paramInt);
    a locala = this.FIE.FDm.WQ(paramInt);
    if (locala != null)
    {
      locala.eJA();
      return locala;
    }
    ad.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public final void a(a parama)
  {
    this.FIF = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.FIE.eNV();
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
  
  public abstract ArrayList<T> aM(ArrayList<K> paramArrayList);
  
  public final T dU(K paramK)
  {
    if (this.FIE == null) {
      return null;
    }
    return this.FIE.FDm.dU(paramK);
  }
  
  protected boolean eNX()
  {
    if (this.FIE == null) {
      return false;
    }
    return this.FIE.eNX();
  }
  
  public abstract T eOj();
  
  public final void ePu()
  {
    this.FIF = null;
  }
  
  public final int ePw()
  {
    if (this.FIE == null) {
      return 0;
    }
    d locald = this.FIE.FDm;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).FDc[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> ePx();
  
  public final SparseArray<K>[] ePy()
  {
    if (this.FIE == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.FIE.eNV();
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
    if (this.FIE == null)
    {
      long l = System.currentTimeMillis();
      a(ePx());
      ad.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    cB("getcount", false);
    if (this.FIE == null)
    {
      ad.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.FIE.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public void j(K paramK, int paramInt)
  {
    boolean bool;
    if (this.FIE != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.FIN);
      if ((paramInt != 5) && (this.FIK) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      ePz();
    }
    label87:
    do
    {
      break label170;
      ad.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.sQh = getChangeType();
      paramK = this.TAG;
      int j = this.sQh;
      if (this.FIJ == 1) {}
      for (bool = true;; bool = false)
      {
        ad.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        ad.i(this.TAG, "newcursor event is refresh sync ");
        kT(true);
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
        if (this.FIJ == 1)
        {
          if ((this.FIE.dT(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            b localb1 = new b(paramK, paramInt);
            if ((localb1.FIQ == 2) && (this.FIE.dT(localb1.object))) {
              localb1.FIQ = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.FIQ)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.FIQ)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.FIQ = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.FIE;
              i = localHashMap.size();
              if (!paramK.FDm.WP(i))
              {
                ad.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.FIN, null);
              }
              ad.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.FIQ)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.FIQ = 5;
                break;
              case 5: 
                ad.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.FIQ = 5;
                break;
                switch (localb2.FIQ)
                {
                case 3: 
                case 4: 
                default: 
                  ad.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.FIQ = 2;
                  break;
                case 5: 
                  localb1.FIQ = 3;
                  break;
                case 2: 
                  ad.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.FIQ = 2;
                  break;
                  ad.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.FIQ = 2;
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
        ePz();
        i = 0;
        break label87;
      }
    } while ((!this.FID) || (!this.FII));
    label170:
    label171:
    label197:
    label711:
    kT(false);
    label302:
  }
  
  public final void kT(boolean paramBoolean)
  {
    if ((this.FIL) || (paramBoolean)) {
      ePA();
    }
    for (;;)
    {
      this.sQh = 0;
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
      if (this.FIM == null) {
        this.FIM = new e();
      }
      this.FIM.Xe(i);
    }
  }
  
  public void pause()
  {
    this.FID = false;
    ad.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    ad.i(this.TAG, "newcursor resume ");
    this.FID = true;
    cB("resume", true);
  }
  
  public final void vl(boolean paramBoolean)
  {
    if (this.FIE != null)
    {
      this.FIE.close();
      this.FIE = null;
    }
    if ((paramBoolean) && (this.FIM != null))
    {
      this.FIM.quit();
      this.FIM = null;
      if (this.events != null)
      {
        this.events.clear();
        ad.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.sQh = 0;
    this.FIJ = 0;
  }
  
  public static abstract interface a
  {
    public abstract void aIp();
    
    public abstract void ePF();
  }
  
  public static final class b<K, T>
  {
    public int FIQ;
    public T FIR;
    public K object;
    
    public b(K paramK, int paramInt)
    {
      this.object = paramK;
      this.FIQ = paramInt;
      this.FIR = null;
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
      if (this.FIQ != paramObject.FIQ)
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
      int j = this.FIQ;
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
    
    public final ArrayList<T> aM(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = f.this.aM(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T eOl()
    {
      AppMethodBeat.i(33001);
      a locala = f.this.eOj();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void ePE();
  }
  
  final class e
  {
    f<K, T>.e.b FIS;
    private f<K, T>.e.c FIT;
    LinkedList<Integer> FIU;
    int FIV;
    
    public e()
    {
      AppMethodBeat.i(33006);
      ePG();
      AppMethodBeat.o(33006);
    }
    
    private void ePG()
    {
      AppMethodBeat.i(33007);
      this.FIS = new b(Looper.getMainLooper());
      this.FIT = new c(az.afE().EUN.getLooper());
      AppMethodBeat.o(33007);
    }
    
    private void euI()
    {
      AppMethodBeat.i(33008);
      Object localObject = this.FIT;
      ((c)localObject).removeMessages(((c)localObject).FJc);
      ((c)localObject).removeMessages(((c)localObject).FJd);
      localObject = this.FIS;
      ((b)localObject).FIY = true;
      ((b)localObject).removeMessages(1);
      ((b)localObject).removeMessages(2);
      this.FIU.clear();
      this.FIV = 0;
      AppMethodBeat.o(33008);
    }
    
    final void Xe(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.FIU.contains(Integer.valueOf(paramInt))) {
          this.FIU.add(Integer.valueOf(paramInt));
        }
        this.FIV = ePI();
        c localc = this.FIT;
        localc.sendEmptyMessage(localc.FJd);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void ePH()
    {
      try
      {
        AppMethodBeat.i(33009);
        ad.i(f.this.TAG, "newcursor resetQueue ");
        euI();
        ePG();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int ePI()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.FIU.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.FIU.size() == 1) {
          i = ((Integer)this.FIU.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean ePJ()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 184	com/tencent/mm/ui/f$e:FIV	I
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
    
    final void ePK()
    {
      try
      {
        AppMethodBeat.i(33012);
        this.FIT.lastUpdateTime = System.currentTimeMillis();
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int ePL()
    {
      try
      {
        int i = this.FIV;
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
        euI();
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
      int FIW;
      
      public a(int paramInt)
      {
        this.FIW = paramInt;
      }
    }
    
    final class b
      extends ap
    {
      boolean FIY;
      public final int FIZ = 1;
      public final int FJa = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.FIY)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (f.e.this)
        {
          f.e.this.FIV = f.e.this.ePI();
          ad.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.FIV) });
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
      long FJb;
      final int FJc;
      final int FJd;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.FJc = (hashCode() | 0x776);
        this.FJd = (hashCode() | 0x77A);
        f.e.this.FIU = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.FJd)
        {
          removeMessages(this.FJc);
          long l = System.currentTimeMillis();
          if ((l - this.FJb > f.this.FIG) || (l - this.FJb < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.FIH)) || (l - this.lastUpdateTime < 0L)) {
            f.e.a(f.e.this);
          }
          for (;;)
          {
            this.FJb = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.FJc, f.this.FIG);
          }
        }
        if (paramMessage.what == this.FJc) {
          f.e.a(f.e.this);
        }
        AppMethodBeat.o(33005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */