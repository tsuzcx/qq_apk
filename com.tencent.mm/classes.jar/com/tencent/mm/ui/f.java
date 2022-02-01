package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  protected boolean OzL = true;
  protected f<K, T>.c OzM;
  protected a OzN;
  public int OzO = 1000;
  public int OzP = 3000;
  public boolean OzQ = true;
  int OzR = 0;
  private boolean OzS;
  private boolean OzT;
  private f<K, T>.e OzU;
  public K OzV = null;
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, b<K, T>> events;
  private int pageSize;
  private int yHf = 0;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    Log.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.OzS = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.OzS = true;
    this.OzT = false;
    this.OzO = 800;
    this.OzP = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    AV(true);
    if ((this.OzM == null) || (this.OzM.Ouf != paramd))
    {
      if ((this.OzM != null) && (!this.OzM.isClosed()))
      {
        this.OzM.close();
        this.OzM = null;
      }
      this.OzM = b(paramd);
      this.OzM.getCount();
      gGW();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    AV(false);
    this.OzM = paramf;
    this.OzM.getCount();
    gGW();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.OzU != null) && (this.OzU.gHk())) {
        this.OzU.gHi();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if ((paramBoolean2) && (paramf != null) && (!paramf.Oug))
    {
      a(new d()
      {
        public final void gHf()
        {
          AppMethodBeat.i(32997);
          f.a(f.this, paramf);
          AppMethodBeat.o(32997);
        }
      });
      return;
    }
    if ((paramf != null) && (paramf.Oug) && (paramBoolean2))
    {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232461);
          int i = paramf.getCount();
          Log.i(f.this.TAG, "select db count: %d", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232460);
              f.a(f.this, new f.d()
              {
                public final void gHf()
                {
                  AppMethodBeat.i(232459);
                  f.a(f.this, f.3.this.OzX);
                  AppMethodBeat.o(232459);
                }
              });
              AppMethodBeat.o(232460);
            }
          });
          AppMethodBeat.o(232461);
        }
      });
      return;
    }
    a(paramf);
  }
  
  private void a(d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.OzN != null) {
      this.OzN.gHg();
    }
    if (paramd != null) {
      paramd.gHf();
    }
    notifyDataSetChanged();
    if (this.OzN != null) {
      this.OzN.bnE();
    }
    if (this.OzU != null) {
      this.OzU.gHl();
    }
    Log.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void dl(String paramString, boolean paramBoolean)
  {
    if ((!gHd()) && ((this.OzQ | paramBoolean)))
    {
      if (!paramBoolean) {
        Log.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.OzQ), paramString, Util.getStack() });
      }
      mY(false);
    }
  }
  
  private void gGW()
  {
    if (this.OzS) {
      if (!this.OzM.gFx()) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 2)
    {
      if ((i != this.OzR) && (this.OzR != 0))
      {
        if ((this.OzU != null) && (this.OzU.gHk())) {
          a(b(gGY()), true, false);
        }
        Log.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.OzR = i;
      return;
    }
  }
  
  private void gHa()
  {
    this.events.clear();
    this.events.put(this.OzV, null);
  }
  
  private void gHb()
  {
    if (!gHc()) {
      return;
    }
    int i = getChangeType();
    if (this.OzU != null)
    {
      int j = this.OzU.gHm();
      Log.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.OzU.gHi();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.yHf = 0;
      if (i == 2)
      {
        a(b(gGY()), true, true);
        return;
      }
      gHe();
      return;
    }
  }
  
  private boolean gHc()
  {
    return ((this.OzU != null) && (this.OzU.gHk())) || (getChangeType() != 0);
  }
  
  private boolean gHd()
  {
    return this.yHf == 0;
  }
  
  private void gHe()
  {
    if ((this.OzM != null) && (!this.OzM.isClosed()) && (this.events.size() == 0))
    {
      Log.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new d()
    {
      public final void gHf()
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
          Log.i(f.this.TAG, "newcursor all event is delete");
          f.c(f.this).c(((HashSet)localObject1).toArray(), null);
        }
        for (;;)
        {
          f.b(f.this).clear();
          AppMethodBeat.o(32996);
          return;
          long l;
          if (!f.b(f.this).containsKey(f.this.OzV))
          {
            l = System.currentTimeMillis();
            localObject2 = f.this.gGZ();
            localObject1 = f.this.a(new HashSet(f.b(f.this).values()), (SparseArray[])localObject2);
            int j = localObject2.length;
            if (j > 1)
            {
              int i = 0;
              while (i < j)
              {
                Log.i(f.this.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[i].size()), Integer.valueOf(localObject1[i].size()) });
                i += 1;
              }
            }
            Log.i(f.this.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localObject2[0].size()), Integer.valueOf(localObject1[0].size()) });
            localObject2 = f.b(f.this).values().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              f.b localb = (f.b)((Iterator)localObject2).next();
              if (localb != null)
              {
                if (localb.OAb != null) {
                  Log.i(f.this.TAG, "newcursor notify cache update : key : %s ", new Object[] { localb.object });
                }
                f.c(f.this).c(localb.object, (a)localb.OAb);
              }
              else
              {
                Log.e(f.this.TAG, "newcursor event is null ! ");
              }
            }
            f.this.a((SparseArray[])localObject1);
            Log.i(f.this.TAG, "newcursor after resort new pos size :%d  ", new Object[] { Integer.valueOf(f.c(f.this).gFv()[0].size()) });
          }
          else
          {
            l = System.currentTimeMillis();
            f.a(f.this, f.this.b(f.this.gGY()), true, false);
            Log.i(f.this.TAG, "cache unuseful,reset cursor,last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    if (this.events.containsKey(this.OzV)) {
      return 2;
    }
    return 1;
  }
  
  public final void AV(boolean paramBoolean)
  {
    if (this.OzM != null)
    {
      this.OzM.close();
      this.OzM = null;
    }
    if ((paramBoolean) && (this.OzU != null))
    {
      this.OzU.quit();
      this.OzU = null;
      if (this.events != null)
      {
        this.events.clear();
        Log.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.yHf = 0;
    this.OzR = 0;
  }
  
  public final void a(a parama)
  {
    this.OzN = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.OzM.gFv();
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
  
  public final T akz(int paramInt)
  {
    if (this.OzM == null) {
      a(gGY());
    }
    dl("getItem", false);
    this.OzM.Ouf.moveToPosition(paramInt);
    a locala = this.OzM.Ouf.akz(paramInt);
    if (locala != null)
    {
      locala.gzB();
      return locala;
    }
    Log.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public f<K, T>.c b(d<K> paramd)
  {
    return new c(paramd, (byte)0);
  }
  
  public abstract ArrayList<T> bo(ArrayList<K> paramArrayList);
  
  public abstract T gFJ();
  
  protected boolean gFx()
  {
    if (this.OzM == null) {
      return false;
    }
    return this.OzM.gFx();
  }
  
  public final void gGV()
  {
    this.OzN = null;
  }
  
  public final int gGX()
  {
    if (this.OzM == null) {
      return 0;
    }
    d locald = this.OzM.Ouf;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).OtV[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> gGY();
  
  public final SparseArray<K>[] gGZ()
  {
    if (this.OzM == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.OzM.gFv();
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
    if (this.OzM == null)
    {
      long l = System.currentTimeMillis();
      a(gGY());
      Log.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    dl("getcount", false);
    if (this.OzM == null)
    {
      Log.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.OzM.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void mY(boolean paramBoolean)
  {
    if ((this.OzT) || (paramBoolean)) {
      gHb();
    }
    for (;;)
    {
      this.yHf = 0;
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
      if (this.OzU == null) {
        this.OzU = new e();
      }
      this.OzU.akM(i);
    }
  }
  
  public void o(K paramK, int paramInt)
  {
    boolean bool;
    if (this.OzM != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.OzV);
      if ((paramInt != 5) && (this.OzS) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      gHa();
    }
    label87:
    do
    {
      break label170;
      Log.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.yHf = getChangeType();
      paramK = this.TAG;
      int j = this.yHf;
      if (this.OzR == 1) {}
      for (bool = true;; bool = false)
      {
        Log.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        Log.i(this.TAG, "newcursor event is refresh sync ");
        mY(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new b(paramK, paramInt));
        break;
        if (bool)
        {
          Log.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.OzR == 1)
        {
          if ((this.OzM.ed(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            b localb1 = new b(paramK, paramInt);
            if ((localb1.OAa == 2) && (this.OzM.ed(localb1.object))) {
              localb1.OAa = 3;
            }
            b localb2 = (b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.OAa)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.OAa)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.OAa = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.OzM;
              i = localHashMap.size();
              if (!paramK.Ouf.aky(i))
              {
                Log.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.OzV, null);
              }
              Log.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.OAa)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.OAa = 5;
                break;
              case 5: 
                Log.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.OAa = 5;
                break;
                switch (localb2.OAa)
                {
                case 3: 
                case 4: 
                default: 
                  Log.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.OAa = 2;
                  break;
                case 5: 
                  localb1.OAa = 3;
                  break;
                case 2: 
                  Log.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.OAa = 2;
                  break;
                  Log.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.OAa = 2;
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
        gHa();
        i = 0;
        break label87;
      }
    } while ((!this.OzL) || (!this.OzQ));
    label170:
    label171:
    label197:
    label711:
    mY(false);
    label302:
  }
  
  public void pause()
  {
    this.OzL = false;
    Log.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    Log.i(this.TAG, "newcursor resume ");
    this.OzL = true;
    dl("resume", true);
  }
  
  public static abstract interface a
  {
    public abstract void bnE();
    
    public abstract void gHg();
  }
  
  public static final class b<K, T>
  {
    public int OAa;
    public T OAb;
    public K object;
    
    public b(K paramK, int paramInt)
    {
      this.object = paramK;
      this.OAa = paramInt;
      this.OAb = null;
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
      if (this.OAa != paramObject.OAa)
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
      int j = this.OAa;
      if (this.object == null) {}
      for (int i = 0;; i = this.object.hashCode())
      {
        AppMethodBeat.o(32998);
        return i + (j + 31) * 31;
      }
    }
  }
  
  public final class c
    extends g<K, T>
  {
    public c(boolean paramBoolean)
    {
      super(f.a(f.this), true);
      AppMethodBeat.i(33000);
      AppMethodBeat.o(33000);
    }
    
    public c(byte paramByte1, byte paramByte2)
    {
      super(f.a(f.this), false);
      AppMethodBeat.i(232462);
      AppMethodBeat.o(232462);
    }
    
    public final ArrayList<T> bo(ArrayList paramArrayList)
    {
      AppMethodBeat.i(33002);
      paramArrayList = f.this.bo(paramArrayList);
      AppMethodBeat.o(33002);
      return paramArrayList;
    }
    
    public final T gFL()
    {
      AppMethodBeat.i(33001);
      a locala = f.this.gFJ();
      AppMethodBeat.o(33001);
      return locala;
    }
  }
  
  static abstract interface d
  {
    public abstract void gHf();
  }
  
  final class e
  {
    f<K, T>.e.b OAc;
    private f<K, T>.e.c OAd;
    LinkedList<Integer> OAe;
    int OAf;
    
    public e()
    {
      AppMethodBeat.i(33006);
      gHh();
      AppMethodBeat.o(33006);
    }
    
    private void gHh()
    {
      AppMethodBeat.i(33007);
      this.OAc = new b(Looper.getMainLooper());
      this.OAd = new c(bg.aAk().getLooper());
      AppMethodBeat.o(33007);
    }
    
    private void glP()
    {
      AppMethodBeat.i(33008);
      c.a(this.OAd);
      b localb = this.OAc;
      localb.OAi = true;
      localb.removeMessages(1);
      localb.removeMessages(2);
      this.OAe.clear();
      this.OAf = 0;
      AppMethodBeat.o(33008);
    }
    
    final void akM(int paramInt)
    {
      try
      {
        AppMethodBeat.i(33013);
        if (!this.OAe.contains(Integer.valueOf(paramInt))) {
          this.OAe.add(Integer.valueOf(paramInt));
        }
        this.OAf = gHj();
        c.c(this.OAd);
        AppMethodBeat.o(33013);
        return;
      }
      finally {}
    }
    
    public final void gHi()
    {
      try
      {
        AppMethodBeat.i(33009);
        Log.i(f.this.TAG, "newcursor resetQueue ");
        glP();
        gHh();
        AppMethodBeat.o(33009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int gHj()
    {
      int i = 0;
      AppMethodBeat.i(33011);
      if (this.OAe.size() > 1) {
        i = 2;
      }
      for (;;)
      {
        AppMethodBeat.o(33011);
        return i;
        if (this.OAe.size() == 1) {
          i = ((Integer)this.OAe.get(0)).intValue();
        }
      }
    }
    
    /* Error */
    public final boolean gHk()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 174	com/tencent/mm/ui/f$e:OAf	I
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
    
    final void gHl()
    {
      try
      {
        AppMethodBeat.i(33012);
        c.b(this.OAd);
        AppMethodBeat.o(33012);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final int gHm()
    {
      try
      {
        int i = this.OAf;
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
        Log.i(f.this.TAG, "newcursor quit ");
        glP();
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
      int OAg;
      
      public a(int paramInt)
      {
        this.OAg = paramInt;
      }
    }
    
    final class b
      extends MMHandler
    {
      boolean OAi;
      public final int OAj = 1;
      public final int OAk = 2;
      
      public b(Looper paramLooper)
      {
        super();
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33003);
        super.handleMessage(paramMessage);
        if (this.OAi)
        {
          AppMethodBeat.o(33003);
          return;
        }
        synchronized (f.e.this)
        {
          f.e.this.OAf = f.e.this.gHj();
          Log.i(f.this.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(f.e.this.OAf) });
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
      extends MMHandler
    {
      long OAl;
      private final int OAm;
      private final int OAn;
      long lastUpdateTime;
      
      public c(Looper paramLooper)
      {
        super();
        AppMethodBeat.i(33004);
        this.OAm = (hashCode() | 0x776);
        this.OAn = (hashCode() | 0x77A);
        f.e.this.OAe = new LinkedList();
        AppMethodBeat.o(33004);
      }
      
      public final void handleMessage(Message paramMessage)
      {
        AppMethodBeat.i(33005);
        super.handleMessage(paramMessage);
        if (paramMessage.what == this.OAn)
        {
          removeMessages(this.OAm);
          long l = System.currentTimeMillis();
          if ((l - this.OAl > f.this.OzO) || (l - this.OAl < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.OzP)) || (l - this.lastUpdateTime < 0L)) {
            f.e.a(f.e.this);
          }
          for (;;)
          {
            this.OAl = l;
            AppMethodBeat.o(33005);
            return;
            sendEmptyMessageDelayed(this.OAm, f.this.OzO);
          }
        }
        if (paramMessage.what == this.OAm) {
          f.e.a(f.e.this);
        }
        AppMethodBeat.o(33005);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */