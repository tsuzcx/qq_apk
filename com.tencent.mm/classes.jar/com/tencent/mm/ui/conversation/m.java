package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m
  extends AbstractCursor
{
  private a[] KTe;
  private int KTf;
  private int KTg;
  int KTh;
  LinkedList<c> KTi;
  private final b KTj;
  private Cursor Tc;
  private DataSetObserver mObserver;
  private int qrk;
  
  public m(m.e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(188133);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(188123);
        m.a(m.this);
        m.this.fNH();
        AppMethodBeat.o(188123);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(188124);
        m.b(m.this);
        m.this.fNH();
        AppMethodBeat.o(188124);
      }
    };
    this.qrk = -1;
    this.KTf = m.e.KTx.op;
    this.KTg = 100;
    this.KTh = -1;
    this.KTi = new LinkedList();
    this.KTj = new b();
    this.KTf = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.KTe = paramVarArgs;; this.KTe = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.Tc = this.KTe[0].fNF();
      while (i < this.KTe.length)
      {
        if (afn(i) != null) {
          afn(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(188133);
  }
  
  private m(a... paramVarArgs)
  {
    this(m.e.KTx, paramVarArgs);
  }
  
  private boolean afk(int paramInt)
  {
    AppMethodBeat.i(188136);
    try
    {
      b.a(this.KTj);
      this.Tc = this.KTe[0].fNF();
      boolean bool = this.Tc.moveToPosition(paramInt);
      AppMethodBeat.o(188136);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ae.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(188136);
    }
    return false;
  }
  
  private boolean afl(int paramInt)
  {
    AppMethodBeat.i(188137);
    int i = this.KTh;
    int j = this.KTh;
    int k = this.KTi.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      b.a(this.KTj);
    }
    Object localObject;
    for (;;)
    {
      localObject = afm(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(188137);
      return false;
      localObject = this.KTj;
      ((b)localObject).KTp += 1L;
      a locala1 = this.KTe[0];
      a locala2 = this.KTe[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.KTg;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.afo(0);
        localObject = locala2.afo(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.KTu == locald) && (d.KTu == localObject))) {
          break label405;
        }
        if (d.KTu != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject));
        i += 1;
        localObject = locala2.afo(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.KTg - 1 + paramInt) / this.KTg * this.KTg;
        break;
        label254:
        if (d.KTu == localObject)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.afo(j);
        }
        else
        {
          b localb = this.KTj;
          localb.KTq += 1L;
          if (this.KTf * locald.a((d)localObject) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.afo(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject));
          i += 1;
          localObject = locala2.afo(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        ae.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.KTh = 0;
      this.KTi = localLinkedList;
    }
    try
    {
      this.Tc = this.KTe[localObject.KTr].fNF();
      boolean bool = this.Tc.moveToPosition(((c)localObject).KTs);
      AppMethodBeat.o(188137);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ae.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
      AppMethodBeat.o(188137);
    }
    return false;
  }
  
  private c afm(int paramInt)
  {
    AppMethodBeat.i(188139);
    try
    {
      int i = this.KTh;
      c localc = (c)this.KTi.get(paramInt - i);
      AppMethodBeat.o(188139);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ae.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(188139);
    }
    return null;
  }
  
  private Cursor afn(int paramInt)
  {
    AppMethodBeat.i(188157);
    Cursor localCursor = this.KTe[paramInt].fNF();
    AppMethodBeat.o(188157);
    return localCursor;
  }
  
  public static m fNG()
  {
    AppMethodBeat.i(188132);
    m localm = new m(new a[] { new a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(188125);
        paramAnonymousCursor = new m.d(paramAnonymousInt);
        AppMethodBeat.o(188125);
        return paramAnonymousCursor;
      }
      
      public final Cursor fNF()
      {
        return null;
      }
    } });
    AppMethodBeat.o(188132);
    return localm;
  }
  
  public final void close()
  {
    AppMethodBeat.i(188151);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(188151);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(188150);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(188150);
  }
  
  public final void fNH()
  {
    AppMethodBeat.i(188138);
    if (this.KTh != -1) {
      b.b(this.KTj);
    }
    this.KTh = -1;
    this.KTi = new LinkedList();
    AppMethodBeat.o(188138);
  }
  
  final Cursor fNI()
  {
    AppMethodBeat.i(188158);
    if ((this.Tc == null) || (this.Tc.isClosed())) {
      onMove(-1, this.qrk);
    }
    Cursor localCursor = this.Tc;
    AppMethodBeat.o(188158);
    return localCursor;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(188148);
    byte[] arrayOfByte = fNI().getBlob(paramInt);
    AppMethodBeat.o(188148);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(188149);
    if (this.Tc != null)
    {
      String[] arrayOfString = fNI().getColumnNames();
      AppMethodBeat.o(188149);
      return arrayOfString;
    }
    AppMethodBeat.o(188149);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(188134);
    int m = this.KTe.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (afn(i) != null) {
        k = j + afn(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(188134);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(188145);
    double d = fNI().getDouble(paramInt);
    AppMethodBeat.o(188145);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(188144);
    float f = fNI().getFloat(paramInt);
    AppMethodBeat.o(188144);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(188142);
    paramInt = fNI().getInt(paramInt);
    AppMethodBeat.o(188142);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(188143);
    long l = fNI().getLong(paramInt);
    AppMethodBeat.o(188143);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(188141);
    short s = fNI().getShort(paramInt);
    AppMethodBeat.o(188141);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(188140);
    String str = fNI().getString(paramInt);
    AppMethodBeat.o(188140);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(188146);
    paramInt = fNI().getType(paramInt);
    AppMethodBeat.o(188146);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(188147);
    boolean bool = fNI().isNull(paramInt);
    AppMethodBeat.o(188147);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188135);
    b localb = this.KTj;
    localb.KTm += 1L;
    this.qrk = paramInt2;
    if (this.KTe.length < 2)
    {
      bool = afk(paramInt2);
      AppMethodBeat.o(188135);
      return bool;
    }
    boolean bool = afl(paramInt2);
    AppMethodBeat.o(188135);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(188152);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(188152);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(188154);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(188154);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(188156);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if ((afn(i) != null) && (!afn(i).requery()))
      {
        AppMethodBeat.o(188156);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(188156);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(188153);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(188153);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(188155);
    int j = this.KTe.length;
    int i = 0;
    while (i < j)
    {
      if (afn(i) != null) {
        afn(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(188155);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> KTl = new LinkedHashMap();
    
    public final m.d afo(int paramInt)
    {
      Object localObject = fNF();
      if (localObject == null) {
        return new m.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return m.d.KTu;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = c((Cursor)localObject, paramInt);
      return localObject;
      return m.d.KTu;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.KTl.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.KTl.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.KTl.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract m.d c(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor fNF();
  }
  
  public static final class b
  {
    long KTm = 0L;
    private long KTn = 0L;
    private long KTo = 0L;
    long KTp = 0L;
    long KTq = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(188126);
      try
      {
        String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.KTm), Long.valueOf(this.KTn), Float.valueOf((float)this.KTn * 100.0F / (float)this.KTm), Long.valueOf(this.KTo), Long.valueOf(this.KTp), Float.valueOf((float)this.KTo * 100.0F / (float)this.KTp), Long.valueOf(this.KTq), Float.valueOf((float)this.KTq * 100.0F / (float)this.KTm) });
        AppMethodBeat.o(188126);
        return str;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("total=").append(this.KTm).append("hit=").append(this.KTn).append("clearWindow=").append(this.KTo).append("fillWindow=").append(this.KTp).append("compare=").append(this.KTq);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(188126);
        return localObject;
      }
    }
  }
  
  public static final class c
  {
    public final int KTr;
    public final int KTs;
    public final m.d KTt;
    
    public c(int paramInt1, int paramInt2, m.d paramd)
    {
      this.KTr = paramInt1;
      this.KTs = paramInt2;
      this.KTt = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d KTu;
    public long KTv = 0L;
    public int KTw = 0;
    
    static
    {
      AppMethodBeat.i(188128);
      KTu = new d(0L);
      AppMethodBeat.o(188128);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.KTv = paramLong;
      this.KTw = 0;
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
          if ((paramd == null) || (KTu == paramd)) {
            return 1;
          }
        } while ((this.KTw == paramd.KTw) && (this.KTv == paramd.KTv));
        if (this.KTw != paramd.KTw) {
          return this.KTw - paramd.KTw;
        }
        l = this.KTv - paramd.KTv;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.KTw << 31 | (int)this.KTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */