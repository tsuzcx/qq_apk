package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.cf.a.a;
import com.tencent.mm.cf.a.d;
import com.tencent.mm.cf.a.e;
import com.tencent.mm.cf.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class f<K, T extends a>
  extends BaseAdapter
{
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private int lEu = 0;
  private int pageSize;
  public boolean uIf = true;
  public f<K, T>.c uIg;
  private HashMap<K, f.b<K, T>> uIh;
  protected f.a uIi;
  public int uIj = 1000;
  public int uIk = 3000;
  public boolean uIl = true;
  int uIm = 0;
  private boolean uIn;
  private boolean uIo;
  private f<K, T>.e uIp;
  public K uIq = null;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    y.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.uIn = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.uIn = true;
    this.uIo = false;
    this.uIj = 800;
    this.uIk = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    mK(true);
    if ((this.uIg == null) || (this.uIg.uEU != paramd))
    {
      if ((this.uIg != null) && (!this.uIg.isClosed()))
      {
        this.uIg.close();
        this.uIg = null;
      }
      this.uIg = new f.c(this, paramd);
      this.uIg.getCount();
      cya();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    mK(false);
    this.uIg = paramf;
    this.uIg.getCount();
    cya();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.uIp != null) && (this.uIp.cym())) {
        this.uIp.cyk();
      }
      if (this.uIh != null) {
        this.uIh.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new d()
      {
        public final void cyg()
        {
          f.a(f.this, paramf);
        }
      });
      return;
    }
    a(paramf);
  }
  
  private void a(d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.uIi != null) {
      this.uIi.cyh();
    }
    paramd.cyg();
    notifyDataSetChanged();
    if (this.uIi != null) {
      this.uIi.Wp();
    }
    if (this.uIp != null) {
      this.uIp.cyn();
    }
    y.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void bG(String paramString, boolean paramBoolean)
  {
    if (this.lEu == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && ((this.uIl | paramBoolean)))
      {
        if (!paramBoolean) {
          y.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.uIl), paramString, bk.csb() });
        }
        mJ(false);
      }
      return;
    }
  }
  
  private void cya()
  {
    if (this.uIn) {
      if (!this.uIg.cxa()) {
        break label95;
      }
    }
    label95:
    for (int i = 1;; i = 2)
    {
      if ((i != this.uIm) && (this.uIm != 0))
      {
        if ((this.uIp != null) && (this.uIp.cym())) {
          a(new f.c(this, cyc()), true, false);
        }
        y.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.uIm = i;
      return;
    }
  }
  
  private void cye()
  {
    this.uIh.clear();
    this.uIh.put(this.uIq, null);
  }
  
  private void cyf()
  {
    if ((this.uIg != null) && (!this.uIg.isClosed()) && (this.uIh.size() == 0))
    {
      y.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new f.1(this));
  }
  
  private int getChangeType()
  {
    if ((this.uIh == null) || (this.uIh.size() == 0)) {
      return 0;
    }
    if (this.uIh.containsKey(this.uIq)) {
      return 2;
    }
    return 1;
  }
  
  public final T FC(int paramInt)
  {
    if (this.uIg == null) {
      a(cyc());
    }
    bG("getItem", false);
    this.uIg.uEU.moveToPosition(paramInt);
    a locala = this.uIg.uEU.FC(paramInt);
    if (locala != null)
    {
      locala.ctt();
      return locala;
    }
    y.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public final void a(f.a parama)
  {
    this.uIi = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.uIg.cwY();
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
  
  public abstract SparseArray<K>[] a(HashSet<f.b<K, T>> paramHashSet, SparseArray<K>[] paramArrayOfSparseArray);
  
  public abstract ArrayList<T> ag(ArrayList<K> paramArrayList);
  
  public final T bZ(K paramK)
  {
    if (this.uIg == null) {
      return null;
    }
    return this.uIg.uEU.bZ(paramK);
  }
  
  public final void cxZ()
  {
    this.uIi = null;
  }
  
  public boolean cxa()
  {
    if (this.uIg == null) {
      return false;
    }
    return this.uIg.cxa();
  }
  
  public abstract T cxi();
  
  public final int cyb()
  {
    if (this.uIg == null) {
      return 0;
    }
    d locald = this.uIg.uEU;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).uEL[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> cyc();
  
  public final SparseArray<K>[] cyd()
  {
    if (this.uIg == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.uIg.cwY();
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
  
  public void f(K paramK, int paramInt)
  {
    boolean bool;
    if (this.uIg != null)
    {
      if (this.uIh == null) {
        this.uIh = new HashMap();
      }
      bool = this.uIh.containsKey(this.uIq);
      if ((paramInt != 5) && (this.uIn) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      cye();
    }
    label87:
    do
    {
      break label170;
      y.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.lEu = getChangeType();
      paramK = this.TAG;
      int j = this.lEu;
      if (this.uIm == 1) {}
      for (bool = true;; bool = false)
      {
        y.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        y.i(this.TAG, "newcursor event is refresh sync ");
        mJ(true);
        return;
        if (bool) {
          break;
        }
        this.uIh.put(paramK, new f.b(paramK, paramInt));
        break;
        if (bool)
        {
          y.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.uIm == 1)
        {
          if ((this.uIg.bY(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.uIh;
            f.b localb1 = new f.b(paramK, paramInt);
            if ((localb1.uIt == 2) && (this.uIg.bY(localb1.object))) {
              localb1.uIt = 3;
            }
            f.b localb2 = (f.b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.uIt)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.uIt)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.uIt = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.uIg;
              i = localHashMap.size();
              if (!paramK.uEU.FB(i))
              {
                y.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.uIq, null);
              }
              y.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.uIh.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.uIt)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.uIt = 5;
                break;
              case 5: 
                y.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.uIt = 5;
                break;
                switch (localb2.uIt)
                {
                case 3: 
                case 4: 
                default: 
                  y.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.uIt = 2;
                  break;
                case 5: 
                  localb1.uIt = 3;
                  break;
                case 2: 
                  y.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.uIt = 2;
                  break;
                  y.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.uIt = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          y.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        cye();
        i = 0;
        break label87;
      }
    } while ((!this.uIf) || (!this.uIl));
    label170:
    label171:
    label197:
    label711:
    mJ(false);
    label302:
  }
  
  public int getCount()
  {
    if (this.uIg == null)
    {
      long l = System.currentTimeMillis();
      a(cyc());
      y.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    bG("getcount", false);
    return this.uIg.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void mJ(boolean paramBoolean)
  {
    int i;
    if ((this.uIo) || (paramBoolean)) {
      if (((this.uIp != null) && (this.uIp.cym())) || (getChangeType() != 0))
      {
        i = 1;
        if (i != 0)
        {
          i = getChangeType();
          if (this.uIp == null) {
            break label239;
          }
          int j = this.uIp.cyo();
          y.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
          if (j != 0) {
            this.uIp.cyk();
          }
          if (i == 2) {
            break label239;
          }
          i = j;
        }
      }
    }
    label239:
    for (;;)
    {
      y.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.lEu = 0;
      if (i == 2) {
        a(new f.c(this, cyc()), true, true);
      }
      for (;;)
      {
        this.lEu = 0;
        return;
        i = 0;
        break;
        cyf();
        continue;
        i = getChangeType();
        if (i == 0)
        {
          y.i(this.TAG, "newcursor need not change ");
          return;
        }
        if (i == 2)
        {
          y.i(this.TAG, "newcursor enqueueMessage resetcursor ");
          this.uIh.clear();
        }
        if (this.uIp == null) {
          this.uIp = new f.e(this);
        }
        this.uIp.FL(i);
      }
    }
  }
  
  public final void mK(boolean paramBoolean)
  {
    if (this.uIg != null)
    {
      this.uIg.close();
      this.uIg = null;
    }
    if ((paramBoolean) && (this.uIp != null))
    {
      this.uIp.quit();
      this.uIp = null;
      if (this.uIh != null)
      {
        this.uIh.clear();
        y.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.lEu = 0;
    this.uIm = 0;
  }
  
  public void pause()
  {
    this.uIf = false;
    y.i(this.TAG, "new cursor pasue");
  }
  
  public final void resume()
  {
    y.i(this.TAG, "newcursor resume ");
    this.uIf = true;
    bG("resume", true);
  }
  
  private static abstract interface d
  {
    public abstract void cyg();
  }
  
  final class e$c
    extends ah
  {
    long lastUpdateTime;
    long uIE;
    final int uIF = hashCode() | 0x776;
    final int uIG = hashCode() | 0x77A;
    
    public e$c(Looper paramLooper)
    {
      super();
      f.this.uIx = new LinkedList();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (paramMessage.what == this.uIG)
      {
        removeMessages(this.uIF);
        l = System.currentTimeMillis();
        if ((l - this.uIE > f.this.uIr.uIj) || (l - this.uIE < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.uIr.uIk)) || (l - this.lastUpdateTime < 0L))
        {
          f.e.a(f.this);
          this.uIE = l;
        }
      }
      while (paramMessage.what != this.uIF) {
        for (;;)
        {
          long l;
          return;
          sendEmptyMessageDelayed(this.uIF, f.this.uIr.uIj);
        }
      }
      f.e.a(f.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */