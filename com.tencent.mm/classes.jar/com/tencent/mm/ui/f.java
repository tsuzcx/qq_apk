package com.tencent.mm.ui;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  protected boolean HhL = true;
  protected f<K, T>.c HhM;
  protected a HhN;
  public int HhO = 1000;
  public int HhP = 3000;
  public boolean HhQ = true;
  int HhR = 0;
  private boolean HhS;
  private boolean HhT;
  private f<K, T>.e HhU;
  public K HhV = null;
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, b<K, T>> events;
  private int pageSize;
  private int tYu = 0;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    ac.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.HhS = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.HhS = true;
    this.HhT = false;
    this.HhO = 800;
    this.HhP = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    wn(true);
    if ((this.HhM == null) || (this.HhM.Hcp != paramd))
    {
      if ((this.HhM != null) && (!this.HhM.isClosed()))
      {
        this.HhM.close();
        this.HhM = null;
      }
      this.HhM = new c(paramd);
      this.HhM.getCount();
      feZ();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    wn(false);
    this.HhM = paramf;
    this.HhM.getCount();
    feZ();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.HhU != null) && (this.HhU.ffo())) {
        this.HhU.ffm();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void ffj()
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
    if (this.HhN != null) {
      this.HhN.ffk();
    }
    paramd.ffj();
    notifyDataSetChanged();
    if (this.HhN != null) {
      this.HhN.aPg();
    }
    if (this.HhU != null) {
      this.HhU.ffp();
    }
    ac.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void cH(String paramString, boolean paramBoolean)
  {
    if ((!ffh()) && ((this.HhQ | paramBoolean)))
    {
      if (!paramBoolean) {
        ac.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.HhQ), paramString, bs.eWi() });
      }
      lw(false);
    }
  }
  
  private void feZ()
  {
    if (this.HhS) {
      if (!this.HhM.fdB()) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      if ((i != this.HhR) && (this.HhR != 0))
      {
        if ((this.HhU != null) && (this.HhU.ffo())) {
          a(new c(ffb()), true, false);
        }
        ac.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.HhR = i;
      return;
    }
  }
  
  private void ffe()
  {
    this.events.clear();
    this.events.put(this.HhV, null);
  }
  
  private void fff()
  {
    if (!ffg()) {
      return;
    }
    int i = getChangeType();
    if (this.HhU != null)
    {
      int j = this.HhU.ffq();
      ac.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.HhU.ffm();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      ac.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.tYu = 0;
      if (i == 2)
      {
        a(new c(ffb()), true, true);
        return;
      }
      ffi();
      return;
    }
  }
  
  private boolean ffg()
  {
    return ((this.HhU != null) && (this.HhU.ffo())) || (getChangeType() != 0);
  }
  
  private boolean ffh()
  {
    return this.tYu == 0;
  }
  
  private void ffi()
  {
    if ((this.HhM != null) && (!this.HhM.isClosed()) && (this.events.size() == 0))
    {
      ac.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void ffj()
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
          ac.i(f.this.TAG, "newcursor all event is delete");
          f.c(f.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          f.b(f.this).clear();
          AppMethodBeat.o(32996);
          return;
          long l;
          if (!f.b(f.this).containsKey(f.this.HhV))
          {
            l = System.currentTimeMillis();
            localObject2 = f.this.ffc();
            localObject1 = f.this.a(new HashSet(f.b(f.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                ac.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            ac.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = f.b(f.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              f.b localb = (f.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.HhZ != null) {
                  ac.i(f.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                f.c(f.this).c(localb.object, (a)localb.HhZ);
              }
              else
              {
                ac.e(f.this.TAG, "newcursor event is null ! ");
              }
            }
            f.this.a((SparseArray[])localObject1);
            ac.i(f.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(f.this).fdz()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            f.a(f.this, new f.c(f.this, f.this.ffb()), true, false);
            ac.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    if (this.events.containsKey(this.HhV)) {
      return 2;
    }
    return 1;
  }
  
  public final T Za(int paramInt)
  {
    if (this.HhM == null) {
      a(ffb());
    }
    cH("getItem", false);
    this.HhM.Hcp.moveToPosition(paramInt);
    a locala = this.HhM.Hcp.Za(paramInt);
    if (locala != null)
    {
      locala.eYX();
      return locala;
    }
    ac.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public final void a(a parama)
  {
    this.HhN = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.HhM.fdz();
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
  
  public abstract ArrayList<T> aY(ArrayList<K> paramArrayList);
  
  protected boolean fdB()
  {
    if (this.HhM == null) {
      return false;
    }
    return this.HhM.fdB();
  }
  
  public abstract T fdN();
  
  public final void feY()
  {
    this.HhN = null;
  }
  
  public final int ffa()
  {
    if (this.HhM == null) {
      return 0;
    }
    d locald = this.HhM.Hcp;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).Hcf[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> ffb();
  
  public final SparseArray<K>[] ffc()
  {
    if (this.HhM == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.HhM.fdz();
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
  
  public final HashMap<Object, T> ffd()
  {
    if (this.HhM == null) {
      return null;
    }
    return this.HhM.Hcp.fdA();
  }
  
  public int getCount()
  {
    if (this.HhM == null)
    {
      long l = System.currentTimeMillis();
      a(ffb());
      ac.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    cH("getcount", false);
    if (this.HhM == null)
    {
      ac.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.HhM.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void lw(boolean paramBoolean)
  {
    if ((this.HhT) || (paramBoolean)) {
      fff();
    }
    for (;;)
    {
      this.tYu = 0;
      return;
      int i = getChangeType();
      if (i == 0)
      {
        ac.i(this.TAG, "newcursor need not change ");
        return;
      }
      if (i == 2)
      {
        ac.i(this.TAG, "newcursor enqueueMessage resetcursor ");
        this.events.clear();
      }
      if (this.HhU == null) {
        this.HhU = new e();
      }
      this.HhU.Zo(i);
    }
  }
  
  public void m(K paramK, int paramInt)
  {
    boolean bool;
    if (this.HhM != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.HhV);
      if ((paramInt != 5) && (this.HhS) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      ffe();
    }
    label87:
    do
    {
      break label170;
      ac.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.tYu = getChangeType();
      paramK = this.TAG;
      int j = this.tYu;
      if (this.HhR == 1) {}
      for (bool = true;; bool = false)
      {
        ac.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        ac.i(this.TAG, "newcursor event is refresh sync ");
        lw(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new b(paramK, paramInt));
        break;
        if (bool)
        {
          ac.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.HhR == 1)
        {
          if ((this.HhM.dU(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            b localb1 = new b(paramK, paramInt);
            if ((localb1.HhY == 2) && (this.HhM.dU(localb1.object))) {
              localb1.HhY = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.HhY)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.HhY)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.HhY = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.HhM;
              i = localHashMap.size();
              if (!paramK.Hcp.YZ(i))
              {
                ac.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.HhV, null);
              }
              ac.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.HhY)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.HhY = 5;
                break;
              case 5: 
                ac.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.HhY = 5;
                break;
                switch (localb2.HhY)
                {
                case 3: 
                case 4: 
                default: 
                  ac.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.HhY = 2;
                  break;
                case 5: 
                  localb1.HhY = 3;
                  break;
                case 2: 
                  ac.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.HhY = 2;
                  break;
                  ac.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.HhY = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          ac.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        ffe();
        i = 0;
        break label87;
      }
    } while ((!this.HhL) || (!this.HhQ));
    label170:
    label171:
    label197:
    label711:
    lw(false);
    label302:
  }
  
  public void pause()
  {
    this.HhL = false;
    ac.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    ac.i(this.TAG, "newcursor resume ");
    this.HhL = true;
    cH("resume", true);
  }
  
  public final void wn(boolean paramBoolean)
  {
    if (this.HhM != null)
    {
      this.HhM.close();
      this.HhM = null;
    }
    if ((paramBoolean) && (this.HhU != null))
    {
      this.HhU.quit();
      this.HhU = null;
      if (this.events != null)
      {
        this.events.clear();
        ac.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.tYu = 0;
    this.HhR = 0;
  }
  
  public static abstract interface a
  {
    public abstract void aPg();
    
    public abstract void ffk();
  }
  
  public static final class b<K, T>
  {
    public int HhY;
    public T HhZ;
    public K object;
    
    public b(K paramK, int paramInt)
    {
      this.object = paramK;
      this.HhY = paramInt;
      this.HhZ = null;
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
      if (this.HhY != paramObject.HhY)
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
      int j = this.HhY;
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
    
    public final ArrayList<T> aY(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = f.this.aY(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T fdP()
    {
      AppMethodBeat.i(33001);
      a locala = f.this.fdN();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void ffj();
  }
  
  final class e
  {
    f<K, T>.e.b Hia;
    private f<K, T>.e.c Hib;
    LinkedList<Integer> Hic;
    int Hid;
    
    public e()
    {
      AppMethodBeat.i(33006);
      ffl();
      AppMethodBeat.o(33006);
    }
    
    private void eKb()
    {
      AppMethodBeat.i(33008);
      Object localObject = this.Hib;
      ((c)localObject).removeMessages(((c)localObject).Hik);
      ((c)localObject).removeMessages(((c)localObject).Hil);
      localObject = this.Hia;
      ((b)localObject).Hig = true;
      ((b)localObject).removeMessages(1);
      ((b)localObject).removeMessages(2);
      this.Hic.clear();
      this.Hid = 0;
      AppMethodBeat.o(33008);
    }
    
    private void ffl()
    {
      AppMethodBeat.i(33007);
      this.Hia = new b(Looper.getMainLooper());
      this.Hib = new c(az.agU().GrZ.getLooper());
      AppMethodBeat.o(33007);
    }
    
    final void Zo(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.Hic.contains(Integer.valueOf(paramInt))) {
          this.Hic.add(Integer.valueOf(paramInt));
        }
        this.Hid = ffn();
        c localc = this.Hib;
        localc.sendEmptyMessage(localc.Hil);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void ffm()
    {
      try
      {
        AppMethodBeat.i(33009);
        ac.i(f.this.TAG, "newcursor resetQueue ");
        eKb();
        ffl();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int ffn()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.Hic.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.Hic.size() == 1) {
          i = ((Integer)this.Hic.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean ffo()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 156	com/tencent/mm/ui/f$e:Hid	I
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
    
    final void ffp()
    {
      try
      {
        AppMethodBeat.i(33012);
        this.Hib.lastUpdateTime = System.currentTimeMillis();
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int ffq()
    {
      try
      {
        int i = this.Hid;
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
        ac.i(f.this.TAG, "newcursor quit ");
        eKb();
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
      int Hie;
      
      public a(int paramInt)
      {
        this.Hie = paramInt;
      }
    }
    
    final class b
      extends ao
    {
      boolean Hig;
      public final int Hih = 1;
      public final int Hii = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.Hig)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (f.e.this)
        {
          f.e.this.Hid = f.e.this.ffn();
          ac.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.Hid) });
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
      extends ao
    {
      long Hij;
      final int Hik;
      final int Hil;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.Hik = (hashCode() | 0x776);
        this.Hil = (hashCode() | 0x77A);
        f.e.this.Hic = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.Hil)
        {
          removeMessages(this.Hik);
          long l = System.currentTimeMillis();
          if ((l - this.Hij > f.this.HhO) || (l - this.Hij < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.HhP)) || (l - this.lastUpdateTime < 0L)) {
            f.e.a(f.e.this);
          }
          for (;;)
          {
            this.Hij = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.Hik, f.this.HhO);
          }
        }
        if (paramMessage.what == this.Hik) {
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