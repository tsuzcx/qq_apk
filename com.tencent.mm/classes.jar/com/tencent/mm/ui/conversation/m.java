package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m
  extends AbstractCursor
{
  private a[] KwK;
  private int KwL;
  private int KwM;
  int KwN;
  LinkedList<c> KwO;
  private final b KwP;
  private Cursor Tc;
  private DataSetObserver mObserver;
  private int qkF;
  
  public m(m.e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(194731);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(194721);
        m.a(m.this);
        m.this.fJq();
        AppMethodBeat.o(194721);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(194722);
        m.b(m.this);
        m.this.fJq();
        AppMethodBeat.o(194722);
      }
    };
    this.qkF = -1;
    this.KwL = m.e.Kxd.op;
    this.KwM = 100;
    this.KwN = -1;
    this.KwO = new LinkedList();
    this.KwP = new b();
    this.KwL = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.KwK = paramVarArgs;; this.KwK = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.Tc = this.KwK[0].fJo();
      while (i < this.KwK.length)
      {
        if (aeE(i) != null) {
          aeE(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(194731);
  }
  
  private m(a... paramVarArgs)
  {
    this(m.e.Kxd, paramVarArgs);
  }
  
  private boolean aeB(int paramInt)
  {
    AppMethodBeat.i(194734);
    try
    {
      b.a(this.KwP);
      this.Tc = this.KwK[0].fJo();
      boolean bool = this.Tc.moveToPosition(paramInt);
      AppMethodBeat.o(194734);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ad.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(194734);
    }
    return false;
  }
  
  private boolean aeC(int paramInt)
  {
    AppMethodBeat.i(194735);
    int i = this.KwN;
    int j = this.KwN;
    int k = this.KwO.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      b.a(this.KwP);
    }
    Object localObject;
    for (;;)
    {
      localObject = aeD(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(194735);
      return false;
      localObject = this.KwP;
      ((b)localObject).KwV += 1L;
      a locala1 = this.KwK[0];
      a locala2 = this.KwK[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.KwM;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.aeF(0);
        localObject = locala2.aeF(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.Kxa == locald) && (d.Kxa == localObject))) {
          break label405;
        }
        if (d.Kxa != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject));
        i += 1;
        localObject = locala2.aeF(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.KwM - 1 + paramInt) / this.KwM * this.KwM;
        break;
        label254:
        if (d.Kxa == localObject)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.aeF(j);
        }
        else
        {
          b localb = this.KwP;
          localb.KwW += 1L;
          if (this.KwL * locald.a((d)localObject) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.aeF(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject));
          i += 1;
          localObject = locala2.aeF(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        ad.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.KwN = 0;
      this.KwO = localLinkedList;
    }
    try
    {
      this.Tc = this.KwK[localObject.KwX].fJo();
      boolean bool = this.Tc.moveToPosition(((c)localObject).KwY);
      AppMethodBeat.o(194735);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ad.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
      AppMethodBeat.o(194735);
    }
    return false;
  }
  
  private c aeD(int paramInt)
  {
    AppMethodBeat.i(194737);
    try
    {
      int i = this.KwN;
      c localc = (c)this.KwO.get(paramInt - i);
      AppMethodBeat.o(194737);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ad.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(194737);
    }
    return null;
  }
  
  private Cursor aeE(int paramInt)
  {
    AppMethodBeat.i(194755);
    Cursor localCursor = this.KwK[paramInt].fJo();
    AppMethodBeat.o(194755);
    return localCursor;
  }
  
  public static m fJp()
  {
    AppMethodBeat.i(194730);
    m localm = new m(new a[] { new a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(194723);
        paramAnonymousCursor = new m.d(paramAnonymousInt);
        AppMethodBeat.o(194723);
        return paramAnonymousCursor;
      }
      
      public final Cursor fJo()
      {
        return null;
      }
    } });
    AppMethodBeat.o(194730);
    return localm;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194749);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(194749);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(194748);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(194748);
  }
  
  public final void fJq()
  {
    AppMethodBeat.i(194736);
    if (this.KwN != -1) {
      b.b(this.KwP);
    }
    this.KwN = -1;
    this.KwO = new LinkedList();
    AppMethodBeat.o(194736);
  }
  
  final Cursor fJr()
  {
    AppMethodBeat.i(194756);
    if ((this.Tc == null) || (this.Tc.isClosed())) {
      onMove(-1, this.qkF);
    }
    Cursor localCursor = this.Tc;
    AppMethodBeat.o(194756);
    return localCursor;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(194746);
    byte[] arrayOfByte = fJr().getBlob(paramInt);
    AppMethodBeat.o(194746);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(194747);
    if (this.Tc != null)
    {
      String[] arrayOfString = fJr().getColumnNames();
      AppMethodBeat.o(194747);
      return arrayOfString;
    }
    AppMethodBeat.o(194747);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(194732);
    int m = this.KwK.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (aeE(i) != null) {
        k = j + aeE(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(194732);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(194743);
    double d = fJr().getDouble(paramInt);
    AppMethodBeat.o(194743);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(194742);
    float f = fJr().getFloat(paramInt);
    AppMethodBeat.o(194742);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(194740);
    paramInt = fJr().getInt(paramInt);
    AppMethodBeat.o(194740);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(194741);
    long l = fJr().getLong(paramInt);
    AppMethodBeat.o(194741);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(194739);
    short s = fJr().getShort(paramInt);
    AppMethodBeat.o(194739);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(194738);
    String str = fJr().getString(paramInt);
    AppMethodBeat.o(194738);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(194744);
    paramInt = fJr().getType(paramInt);
    AppMethodBeat.o(194744);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(194745);
    boolean bool = fJr().isNull(paramInt);
    AppMethodBeat.o(194745);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194733);
    b localb = this.KwP;
    localb.KwS += 1L;
    this.qkF = paramInt2;
    if (this.KwK.length < 2)
    {
      bool = aeB(paramInt2);
      AppMethodBeat.o(194733);
      return bool;
    }
    boolean bool = aeC(paramInt2);
    AppMethodBeat.o(194733);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(194750);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(194750);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(194752);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(194752);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(194754);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if ((aeE(i) != null) && (!aeE(i).requery()))
      {
        AppMethodBeat.o(194754);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(194754);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(194751);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(194751);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(194753);
    int j = this.KwK.length;
    int i = 0;
    while (i < j)
    {
      if (aeE(i) != null) {
        aeE(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(194753);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> KwR = new LinkedHashMap();
    
    public final m.d aeF(int paramInt)
    {
      Object localObject = fJo();
      if (localObject == null) {
        return new m.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return m.d.Kxa;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = c((Cursor)localObject, paramInt);
      return localObject;
      return m.d.Kxa;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.KwR.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.KwR.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.KwR.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract m.d c(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor fJo();
  }
  
  public static final class b
  {
    long KwS = 0L;
    private long KwT = 0L;
    private long KwU = 0L;
    long KwV = 0L;
    long KwW = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(194724);
      try
      {
        String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.KwS), Long.valueOf(this.KwT), Float.valueOf((float)this.KwT * 100.0F / (float)this.KwS), Long.valueOf(this.KwU), Long.valueOf(this.KwV), Float.valueOf((float)this.KwU * 100.0F / (float)this.KwV), Long.valueOf(this.KwW), Float.valueOf((float)this.KwW * 100.0F / (float)this.KwS) });
        AppMethodBeat.o(194724);
        return str;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("total=").append(this.KwS).append("hit=").append(this.KwT).append("clearWindow=").append(this.KwU).append("fillWindow=").append(this.KwV).append("compare=").append(this.KwW);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(194724);
        return localObject;
      }
    }
  }
  
  public static final class c
  {
    public final int KwX;
    public final int KwY;
    public final m.d KwZ;
    
    public c(int paramInt1, int paramInt2, m.d paramd)
    {
      this.KwX = paramInt1;
      this.KwY = paramInt2;
      this.KwZ = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d Kxa;
    public long Kxb = 0L;
    public int Kxc = 0;
    
    static
    {
      AppMethodBeat.i(194726);
      Kxa = new d(0L);
      AppMethodBeat.o(194726);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.Kxb = paramLong;
      this.Kxc = 0;
    }
    
    public final int a(d paramd)
    {
      if (this == paramd) {}
      long l;
      do
      {
        do
        {
          return 0;
          if ((paramd == null) || (Kxa == paramd)) {
            return 1;
          }
        } while ((this.Kxc == paramd.Kxc) && (this.Kxb == paramd.Kxb));
        if (this.Kxc != paramd.Kxc) {
          return this.Kxc - paramd.Kxc;
        }
        l = this.Kxb - paramd.Kxb;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.Kxc << 31 | (int)this.Kxb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */