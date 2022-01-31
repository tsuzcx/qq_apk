package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.a.a;
import com.tencent.mm.cg.a.d;
import com.tencent.mm.cg.a.e;
import com.tencent.mm.cg.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class f<K, T extends a>
  extends BaseAdapter
{
  public String TAG = "MicroMsg.CursorDataAdapter";
  public Context context;
  private HashMap<K, f.b<K, T>> events;
  private int obH = 0;
  private int pageSize;
  protected f<K, T>.c yVA;
  protected f.a yVB;
  public int yVC = 1000;
  public int yVD = 3000;
  public boolean yVE = true;
  int yVF = 0;
  private boolean yVG;
  private boolean yVH;
  private f<K, T>.e yVI;
  public K yVJ = null;
  protected boolean yVz = true;
  
  public f(Context paramContext)
  {
    this(paramContext, (byte)0);
    this.pageSize = 5000;
    ab.i(this.TAG, "newCursor setPageSize %d", new Object[] { Integer.valueOf(5000) });
  }
  
  private f(Context paramContext, byte paramByte)
  {
    this.context = paramContext;
    this.yVG = true;
  }
  
  private f(Context paramContext, char paramChar)
  {
    this.context = paramContext;
    this.yVG = true;
    this.yVH = false;
    this.yVC = 800;
    this.yVD = 2000;
  }
  
  public f(Context paramContext, short paramShort)
  {
    this(paramContext, '\000');
  }
  
  private void a(d<K> paramd)
  {
    qd(true);
    if ((this.yVA == null) || (this.yVA.yRC != paramd))
    {
      if ((this.yVA != null) && (!this.yVA.isClosed()))
      {
        this.yVA.close();
        this.yVA = null;
      }
      this.yVA = new f.c(this, paramd);
      this.yVA.getCount();
      dAX();
      notifyDataSetChanged();
    }
  }
  
  private void a(f<K, T>.c paramf)
  {
    qd(false);
    this.yVA = paramf;
    this.yVA.getCount();
    dAX();
  }
  
  private void a(final f<K, T>.c paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.yVI != null) && (this.yVI.dBm())) {
        this.yVI.dBk();
      }
      if (this.events != null) {
        this.events.clear();
      }
    }
    if (paramBoolean2)
    {
      a(new f.d()
      {
        public final void dBg()
        {
          AppMethodBeat.i(29172);
          f.a(f.this, paramf);
          AppMethodBeat.o(29172);
        }
      });
      return;
    }
    a(paramf);
  }
  
  private void a(f.d paramd)
  {
    long l = System.currentTimeMillis();
    if (this.yVB != null) {
      this.yVB.dBh();
    }
    paramd.dBg();
    notifyDataSetChanged();
    if (this.yVB != null) {
      this.yVB.apT();
    }
    if (this.yVI != null) {
      this.yVI.dBn();
    }
    ab.i(this.TAG, "newcursor update callback last :%d ", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private void ci(String paramString, boolean paramBoolean)
  {
    if ((!dBe()) && ((this.yVE | paramBoolean)))
    {
      if (!paramBoolean) {
        ab.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[] { Boolean.valueOf(this.yVE), paramString, bo.dtY() });
      }
      qc(false);
    }
  }
  
  private void dAX()
  {
    if (this.yVG) {
      if (!this.yVA.dzM()) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 2)
    {
      if ((i != this.yVF) && (this.yVF != 0))
      {
        if ((this.yVI != null) && (this.yVI.dBm())) {
          a(new f.c(this, dAZ()), true, false);
        }
        ab.i(this.TAG, "newcursor change update stats  %d ", new Object[] { Integer.valueOf(i) });
      }
      this.yVF = i;
      return;
    }
  }
  
  private void dBb()
  {
    this.events.clear();
    this.events.put(this.yVJ, null);
  }
  
  private void dBc()
  {
    if (!dBd()) {
      return;
    }
    int i = getChangeType();
    if (this.yVI != null)
    {
      int j = this.yVI.dBo();
      ab.i(this.TAG, "newcursor mWorkerHandler.isHandingMsg,type is %d ", new Object[] { Integer.valueOf(j) });
      if (j != 0) {
        this.yVI.dBk();
      }
      if (i != 2) {
        i = j;
      }
    }
    for (;;)
    {
      ab.i(this.TAG, "newcursor ensureNewState  refreshstatus is %d ", new Object[] { Integer.valueOf(i) });
      this.obH = 0;
      if (i == 2)
      {
        a(new f.c(this, dAZ()), true, true);
        return;
      }
      dBf();
      return;
    }
  }
  
  private boolean dBd()
  {
    return ((this.yVI != null) && (this.yVI.dBm())) || (getChangeType() != 0);
  }
  
  private boolean dBe()
  {
    return this.obH == 0;
  }
  
  private void dBf()
  {
    if ((this.yVA != null) && (!this.yVA.isClosed()) && (this.events.size() == 0))
    {
      ab.i(this.TAG, "events size is 0  ");
      return;
    }
    a(new f.1(this));
  }
  
  private int getChangeType()
  {
    if ((this.events == null) || (this.events.size() == 0)) {
      return 0;
    }
    if (this.events.containsKey(this.yVJ)) {
      return 2;
    }
    return 1;
  }
  
  public final T NM(int paramInt)
  {
    if (this.yVA == null) {
      a(dAZ());
    }
    ci("getItem", false);
    this.yVA.yRC.moveToPosition(paramInt);
    a locala = this.yVA.yRC.NM(paramInt);
    if (locala != null)
    {
      locala.dvP();
      return locala;
    }
    ab.e(this.TAG, "newcursor getItem error %d", new Object[] { Integer.valueOf(paramInt) });
    return locala;
  }
  
  public final void a(f.a parama)
  {
    this.yVB = parama;
  }
  
  public final void a(SparseArray<K>[] paramArrayOfSparseArray)
  {
    SparseArray[] arrayOfSparseArray = this.yVA.dzK();
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
  
  public abstract ArrayList<T> ap(ArrayList<K> paramArrayList);
  
  public final T cE(K paramK)
  {
    if (this.yVA == null) {
      return null;
    }
    return this.yVA.yRC.cE(paramK);
  }
  
  public final void dAW()
  {
    this.yVB = null;
  }
  
  public final int dAY()
  {
    if (this.yVA == null) {
      return 0;
    }
    d locald = this.yVA.yRC;
    if (locald == null) {
      return 0;
    }
    if ((locald instanceof e)) {
      return ((e)locald).yRt[0].getCount();
    }
    throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
  }
  
  public abstract d<K> dAZ();
  
  public final SparseArray<K>[] dBa()
  {
    if (this.yVA == null) {
      return null;
    }
    SparseArray[] arrayOfSparseArray1 = this.yVA.dzK();
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
  
  protected boolean dzM()
  {
    if (this.yVA == null) {
      return false;
    }
    return this.yVA.dzM();
  }
  
  public abstract T dzX();
  
  public int getCount()
  {
    if (this.yVA == null)
    {
      long l = System.currentTimeMillis();
      a(dAZ());
      ab.i(this.TAG, "newcursor createCursor last : %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    ci("getcount", false);
    if (this.yVA == null)
    {
      ab.w(this.TAG, "[getCount] is zero!");
      return 0;
    }
    return this.yVA.getCount();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public void i(K paramK, int paramInt)
  {
    boolean bool;
    if (this.yVA != null)
    {
      if (this.events == null) {
        this.events = new HashMap();
      }
      bool = this.events.containsKey(this.yVJ);
      if ((paramInt != 5) && (this.yVG) && (paramInt != 1)) {
        break label197;
      }
      if (paramInt == 5) {
        break label171;
      }
      dBb();
    }
    label87:
    do
    {
      break label170;
      ab.i(this.TAG, "newcursor syncHandle is true ,changeType is %d  ", new Object[] { Integer.valueOf(paramInt) });
      int i = 1;
      this.obH = getChangeType();
      paramK = this.TAG;
      int j = this.obH;
      if (this.yVF == 1) {}
      for (bool = true;; bool = false)
      {
        ab.i(paramK, "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        if (i == 0) {
          break label711;
        }
        ab.i(this.TAG, "newcursor event is refresh sync ");
        qc(true);
        return;
        if (bool) {
          break;
        }
        this.events.put(paramK, new f.b(paramK, paramInt));
        break;
        if (bool)
        {
          ab.i(this.TAG, "newcursor need reset ,return ");
          return;
        }
        if (this.yVF == 1)
        {
          if ((this.yVA.cD(paramK)) || (paramInt == 2))
          {
            HashMap localHashMap = this.events;
            f.b localb1 = new f.b(paramK, paramInt);
            if ((localb1.yVM == 2) && (this.yVA.cD(localb1.object))) {
              localb1.yVM = 3;
            }
            f.b localb2 = (f.b)localHashMap.get(paramK);
            if (localb2 != null)
            {
              i = 1;
              if (i == 0) {
                break label669;
              }
              localHashMap.remove(localb2);
              switch (localb1.yVM)
              {
              case 3: 
              case 4: 
              default: 
                switch (localb2.yVM)
                {
                case 3: 
                case 4: 
                default: 
                  localb1.yVM = 3;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
            for (;;)
            {
              paramK = this.yVA;
              i = localHashMap.size();
              if (!paramK.yRC.NL(i))
              {
                ab.i(this.TAG, "newcursor events size exceed limit :size is :  %d", new Object[] { Integer.valueOf(localHashMap.size()) });
                localHashMap.clear();
                localHashMap.put(this.yVJ, null);
              }
              ab.i(this.TAG, "newcursor add event events size %d", new Object[] { Integer.valueOf(this.events.size()) });
              i = 0;
              break;
              i = 0;
              break label302;
              switch (localb2.yVM)
              {
              case 2: 
              case 3: 
              case 4: 
              default: 
                localb1.yVM = 5;
                break;
              case 5: 
                ab.i(this.TAG, "newcursor processEvent last delete, now delete, impossible");
                localb1.yVM = 5;
                break;
                switch (localb2.yVM)
                {
                case 3: 
                case 4: 
                default: 
                  ab.i(this.TAG, "newcursor processEvent last update, now insert, impossible");
                  localb1.yVM = 2;
                  break;
                case 5: 
                  localb1.yVM = 3;
                  break;
                case 2: 
                  ab.i(this.TAG, "newcursor processEvent last insert, now insert, impossible");
                  localb1.yVM = 2;
                  break;
                  ab.i(this.TAG, "newcursor processEvent last delete, now update, impossible");
                  break label384;
                  localb1.yVM = 2;
                  break;
                  localHashMap.put(paramK, localb1);
                }
                break;
              }
            }
          }
          ab.i(this.TAG, "newcursor event pass ");
          i = 0;
          break label87;
        }
        dBb();
        i = 0;
        break label87;
      }
    } while ((!this.yVz) || (!this.yVE));
    label170:
    label171:
    label197:
    label711:
    qc(false);
    label302:
  }
  
  public void pause()
  {
    this.yVz = false;
    ab.i(this.TAG, "new cursor pasue");
  }
  
  public final void qc(boolean paramBoolean)
  {
    if ((this.yVH) || (paramBoolean)) {
      dBc();
    }
    for (;;)
    {
      this.obH = 0;
      return;
      int i = getChangeType();
      if (i == 0)
      {
        ab.i(this.TAG, "newcursor need not change ");
        return;
      }
      if (i == 2)
      {
        ab.i(this.TAG, "newcursor enqueueMessage resetcursor ");
        this.events.clear();
      }
      if (this.yVI == null) {
        this.yVI = new f.e(this);
      }
      this.yVI.NZ(i);
    }
  }
  
  public final void qd(boolean paramBoolean)
  {
    if (this.yVA != null)
    {
      this.yVA.close();
      this.yVA = null;
    }
    if ((paramBoolean) && (this.yVI != null))
    {
      this.yVI.quit();
      this.yVI = null;
      if (this.events != null)
      {
        this.events.clear();
        ab.i(this.TAG, "newcursor closeCursor,clear events");
      }
    }
    this.obH = 0;
    this.yVF = 0;
  }
  
  public final void resume()
  {
    ab.i(this.TAG, "newcursor resume ");
    this.yVz = true;
    ci("resume", true);
  }
  
  final class e$c
    extends ak
  {
    long lastUpdateTime;
    long yVX;
    final int yVY;
    final int yVZ;
    
    public e$c(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(29179);
      this.yVY = (hashCode() | 0x776);
      this.yVZ = (hashCode() | 0x77A);
      f.this.yVQ = new LinkedList();
      AppMethodBeat.o(29179);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(29180);
      super.handleMessage(paramMessage);
      if (paramMessage.what == this.yVZ)
      {
        removeMessages(this.yVY);
        long l = System.currentTimeMillis();
        if ((l - this.yVX > f.this.yVK.yVC) || (l - this.yVX < 0L) || ((this.lastUpdateTime != 0L) && (l - this.lastUpdateTime > f.this.yVK.yVD)) || (l - this.lastUpdateTime < 0L)) {
          f.e.a(f.this);
        }
        for (;;)
        {
          this.yVX = l;
          AppMethodBeat.o(29180);
          return;
          sendEmptyMessageDelayed(this.yVY, f.this.yVK.yVC);
        }
      }
      if (paramMessage.what == this.yVY) {
        f.e.a(f.this);
      }
      AppMethodBeat.o(29180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */