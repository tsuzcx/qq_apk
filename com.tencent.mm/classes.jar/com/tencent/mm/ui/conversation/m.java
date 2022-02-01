package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m
  extends AbstractCursor
{
  private a[] IFE;
  private int IFF;
  private int IFG;
  int IFH;
  LinkedList<c> IFI;
  private final b IFJ;
  private Cursor Rn;
  private DataSetObserver mObserver;
  private int pHa;
  
  public m(m.e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(196882);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(196872);
        m.a(m.this);
        m.this.fsC();
        AppMethodBeat.o(196872);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(196873);
        m.b(m.this);
        m.this.fsC();
        AppMethodBeat.o(196873);
      }
    };
    this.pHa = -1;
    this.IFF = m.e.IFX.op;
    this.IFG = 100;
    this.IFH = -1;
    this.IFI = new LinkedList();
    this.IFJ = new b();
    this.IFF = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.IFE = paramVarArgs;; this.IFE = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.Rn = this.IFE[0].fsA();
      while (i < this.IFE.length)
      {
        if (acg(i) != null) {
          acg(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(196882);
  }
  
  private m(a... paramVarArgs)
  {
    this(m.e.IFX, paramVarArgs);
  }
  
  private boolean acd(int paramInt)
  {
    AppMethodBeat.i(196885);
    try
    {
      b.a(this.IFJ);
      this.Rn = this.IFE[0].fsA();
      boolean bool = this.Rn.moveToPosition(paramInt);
      AppMethodBeat.o(196885);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ac.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(196885);
    }
    return false;
  }
  
  private boolean ace(int paramInt)
  {
    AppMethodBeat.i(196886);
    int i = this.IFH;
    int j = this.IFH;
    int k = this.IFI.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      b.a(this.IFJ);
    }
    Object localObject;
    for (;;)
    {
      localObject = acf(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(196886);
      return false;
      localObject = this.IFJ;
      ((b)localObject).IFP += 1L;
      a locala1 = this.IFE[0];
      a locala2 = this.IFE[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.IFG;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.ach(0);
        localObject = locala2.ach(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.IFU == locald) && (d.IFU == localObject))) {
          break label405;
        }
        if (d.IFU != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject));
        i += 1;
        localObject = locala2.ach(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.IFG - 1 + paramInt) / this.IFG * this.IFG;
        break;
        label254:
        if (d.IFU == localObject)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.ach(j);
        }
        else
        {
          b localb = this.IFJ;
          localb.IFQ += 1L;
          if (this.IFF * locald.a((d)localObject) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.ach(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject));
          i += 1;
          localObject = locala2.ach(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        ac.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.IFH = 0;
      this.IFI = localLinkedList;
    }
    try
    {
      this.Rn = this.IFE[localObject.IFR].fsA();
      boolean bool = this.Rn.moveToPosition(((c)localObject).IFS);
      AppMethodBeat.o(196886);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ac.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
      AppMethodBeat.o(196886);
    }
    return false;
  }
  
  private c acf(int paramInt)
  {
    AppMethodBeat.i(196888);
    try
    {
      int i = this.IFH;
      c localc = (c)this.IFI.get(paramInt - i);
      AppMethodBeat.o(196888);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ac.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(196888);
    }
    return null;
  }
  
  private Cursor acg(int paramInt)
  {
    AppMethodBeat.i(196906);
    Cursor localCursor = this.IFE[paramInt].fsA();
    AppMethodBeat.o(196906);
    return localCursor;
  }
  
  public static m fsB()
  {
    AppMethodBeat.i(196881);
    m localm = new m(new a[] { new a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(196874);
        paramAnonymousCursor = new m.d(paramAnonymousInt);
        AppMethodBeat.o(196874);
        return paramAnonymousCursor;
      }
      
      public final Cursor fsA()
      {
        return null;
      }
    } });
    AppMethodBeat.o(196881);
    return localm;
  }
  
  public final void close()
  {
    AppMethodBeat.i(196900);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(196900);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(196899);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(196899);
  }
  
  public final void fsC()
  {
    AppMethodBeat.i(196887);
    if (this.IFH != -1) {
      b.b(this.IFJ);
    }
    this.IFH = -1;
    this.IFI = new LinkedList();
    AppMethodBeat.o(196887);
  }
  
  final Cursor fsD()
  {
    AppMethodBeat.i(196907);
    if ((this.Rn == null) || (this.Rn.isClosed())) {
      onMove(-1, this.pHa);
    }
    Cursor localCursor = this.Rn;
    AppMethodBeat.o(196907);
    return localCursor;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(196897);
    byte[] arrayOfByte = fsD().getBlob(paramInt);
    AppMethodBeat.o(196897);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(196898);
    if (this.Rn != null)
    {
      String[] arrayOfString = fsD().getColumnNames();
      AppMethodBeat.o(196898);
      return arrayOfString;
    }
    AppMethodBeat.o(196898);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(196883);
    int m = this.IFE.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (acg(i) != null) {
        k = j + acg(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(196883);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(196894);
    double d = fsD().getDouble(paramInt);
    AppMethodBeat.o(196894);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(196893);
    float f = fsD().getFloat(paramInt);
    AppMethodBeat.o(196893);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(196891);
    paramInt = fsD().getInt(paramInt);
    AppMethodBeat.o(196891);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(196892);
    long l = fsD().getLong(paramInt);
    AppMethodBeat.o(196892);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(196890);
    short s = fsD().getShort(paramInt);
    AppMethodBeat.o(196890);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(196889);
    String str = fsD().getString(paramInt);
    AppMethodBeat.o(196889);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(196895);
    paramInt = fsD().getType(paramInt);
    AppMethodBeat.o(196895);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(196896);
    boolean bool = fsD().isNull(paramInt);
    AppMethodBeat.o(196896);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196884);
    b localb = this.IFJ;
    localb.IFM += 1L;
    this.pHa = paramInt2;
    if (this.IFE.length < 2)
    {
      bool = acd(paramInt2);
      AppMethodBeat.o(196884);
      return bool;
    }
    boolean bool = ace(paramInt2);
    AppMethodBeat.o(196884);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(196901);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(196901);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(196903);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(196903);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(196905);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if ((acg(i) != null) && (!acg(i).requery()))
      {
        AppMethodBeat.o(196905);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(196905);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(196902);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(196902);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(196904);
    int j = this.IFE.length;
    int i = 0;
    while (i < j)
    {
      if (acg(i) != null) {
        acg(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(196904);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> IFL = new LinkedHashMap();
    
    public final m.d ach(int paramInt)
    {
      Object localObject = fsA();
      if (localObject == null) {
        return new m.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return m.d.IFU;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = c((Cursor)localObject, paramInt);
      return localObject;
      return m.d.IFU;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.IFL.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.IFL.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.IFL.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract m.d c(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor fsA();
  }
  
  public static final class b
  {
    long IFM = 0L;
    private long IFN = 0L;
    private long IFO = 0L;
    long IFP = 0L;
    long IFQ = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(196875);
      try
      {
        String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.IFM), Long.valueOf(this.IFN), Float.valueOf((float)this.IFN * 100.0F / (float)this.IFM), Long.valueOf(this.IFO), Long.valueOf(this.IFP), Float.valueOf((float)this.IFO * 100.0F / (float)this.IFP), Long.valueOf(this.IFQ), Float.valueOf((float)this.IFQ * 100.0F / (float)this.IFM) });
        AppMethodBeat.o(196875);
        return str;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("total=").append(this.IFM).append("hit=").append(this.IFN).append("clearWindow=").append(this.IFO).append("fillWindow=").append(this.IFP).append("compare=").append(this.IFQ);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(196875);
        return localObject;
      }
    }
  }
  
  public static final class c
  {
    public final int IFR;
    public final int IFS;
    public final m.d IFT;
    
    public c(int paramInt1, int paramInt2, m.d paramd)
    {
      this.IFR = paramInt1;
      this.IFS = paramInt2;
      this.IFT = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d IFU;
    public long IFV = 0L;
    public int IFW = 0;
    
    static
    {
      AppMethodBeat.i(196877);
      IFU = new d(0L);
      AppMethodBeat.o(196877);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.IFV = paramLong;
      this.IFW = 0;
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
          if ((paramd == null) || (IFU == paramd)) {
            return 1;
          }
        } while ((this.IFW == paramd.IFW) && (this.IFV == paramd.IFV));
        if (this.IFW != paramd.IFW) {
          return this.IFW - paramd.IFW;
        }
        l = this.IFV - paramd.IFV;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.IFW << 31 | (int)this.IFV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */