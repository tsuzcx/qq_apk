package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m
  extends AbstractCursor
{
  private a[] Qgl;
  private int Qgm;
  private int Qgn;
  int Qgo;
  LinkedList<c> Qgp;
  private final m.b Qgq;
  private Cursor To;
  private DataSetObserver mObserver;
  private int rIF;
  
  public m(m.e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(234226);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(234216);
        m.a(m.this);
        m.this.gWb();
        AppMethodBeat.o(234216);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(234217);
        m.b(m.this);
        m.this.gWb();
        AppMethodBeat.o(234217);
      }
    };
    this.rIF = -1;
    this.Qgm = m.e.QgE.op;
    this.Qgn = 100;
    this.Qgo = -1;
    this.Qgp = new LinkedList();
    this.Qgq = new m.b();
    this.Qgm = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.Qgl = paramVarArgs;; this.Qgl = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.To = this.Qgl[0].gVZ();
      while (i < this.Qgl.length)
      {
        if (anX(i) != null) {
          anX(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(234226);
  }
  
  private m(a... paramVarArgs)
  {
    this(m.e.QgE, paramVarArgs);
  }
  
  private boolean anU(int paramInt)
  {
    AppMethodBeat.i(234229);
    try
    {
      m.b.a(this.Qgq);
      this.To = this.Qgl[0].gVZ();
      boolean bool = this.To.moveToPosition(paramInt);
      AppMethodBeat.o(234229);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(234229);
    }
    return false;
  }
  
  private boolean anV(int paramInt)
  {
    AppMethodBeat.i(234230);
    int i = this.Qgo;
    int j = this.Qgo;
    int k = this.Qgp.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      m.b.a(this.Qgq);
    }
    Object localObject;
    for (;;)
    {
      localObject = anW(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(234230);
      return false;
      localObject = this.Qgq;
      ((m.b)localObject).Qgw += 1L;
      a locala1 = this.Qgl[0];
      a locala2 = this.Qgl[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.Qgn;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.anY(0);
        localObject = locala2.anY(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.QgB == locald) && (d.QgB == localObject))) {
          break label405;
        }
        if (d.QgB != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject));
        i += 1;
        localObject = locala2.anY(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.Qgn - 1 + paramInt) / this.Qgn * this.Qgn;
        break;
        label254:
        if (d.QgB == localObject)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.anY(j);
        }
        else
        {
          m.b localb = this.Qgq;
          localb.Qgx += 1L;
          if (this.Qgm * locald.a((d)localObject) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.anY(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject));
          i += 1;
          localObject = locala2.anY(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        Log.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.Qgo = 0;
      this.Qgp = localLinkedList;
    }
    try
    {
      this.To = this.Qgl[localObject.Qgy].gVZ();
      boolean bool = this.To.moveToPosition(((c)localObject).Qgz);
      AppMethodBeat.o(234230);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
      AppMethodBeat.o(234230);
    }
    return false;
  }
  
  private c anW(int paramInt)
  {
    AppMethodBeat.i(234232);
    try
    {
      int i = this.Qgo;
      c localc = (c)this.Qgp.get(paramInt - i);
      AppMethodBeat.o(234232);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(234232);
    }
    return null;
  }
  
  private Cursor anX(int paramInt)
  {
    AppMethodBeat.i(234250);
    Cursor localCursor = this.Qgl[paramInt].gVZ();
    AppMethodBeat.o(234250);
    return localCursor;
  }
  
  public static m gWa()
  {
    AppMethodBeat.i(234225);
    m localm = new m(new a[] { new a()
    {
      protected final m.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(234218);
        paramAnonymousCursor = new m.d(paramAnonymousInt);
        AppMethodBeat.o(234218);
        return paramAnonymousCursor;
      }
      
      public final Cursor gVZ()
      {
        return null;
      }
    } });
    AppMethodBeat.o(234225);
    return localm;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234244);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(234244);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(234243);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(234243);
  }
  
  public final void gWb()
  {
    AppMethodBeat.i(234231);
    if (this.Qgo != -1) {
      m.b.b(this.Qgq);
    }
    this.Qgo = -1;
    this.Qgp = new LinkedList();
    AppMethodBeat.o(234231);
  }
  
  final Cursor gWc()
  {
    AppMethodBeat.i(234251);
    if ((this.To == null) || (this.To.isClosed())) {
      onMove(-1, this.rIF);
    }
    Cursor localCursor = this.To;
    AppMethodBeat.o(234251);
    return localCursor;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(234241);
    byte[] arrayOfByte = gWc().getBlob(paramInt);
    AppMethodBeat.o(234241);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(234242);
    if (this.To != null)
    {
      String[] arrayOfString = gWc().getColumnNames();
      AppMethodBeat.o(234242);
      return arrayOfString;
    }
    AppMethodBeat.o(234242);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(234227);
    int m = this.Qgl.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (anX(i) != null) {
        k = j + anX(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(234227);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(234238);
    double d = gWc().getDouble(paramInt);
    AppMethodBeat.o(234238);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(234237);
    float f = gWc().getFloat(paramInt);
    AppMethodBeat.o(234237);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(234235);
    paramInt = gWc().getInt(paramInt);
    AppMethodBeat.o(234235);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(234236);
    long l = gWc().getLong(paramInt);
    AppMethodBeat.o(234236);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(234234);
    short s = gWc().getShort(paramInt);
    AppMethodBeat.o(234234);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(234233);
    String str = gWc().getString(paramInt);
    AppMethodBeat.o(234233);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(234239);
    paramInt = gWc().getType(paramInt);
    AppMethodBeat.o(234239);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(234240);
    boolean bool = gWc().isNull(paramInt);
    AppMethodBeat.o(234240);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234228);
    m.b localb = this.Qgq;
    localb.Qgt += 1L;
    this.rIF = paramInt2;
    if (this.Qgl.length < 2)
    {
      bool = anU(paramInt2);
      AppMethodBeat.o(234228);
      return bool;
    }
    boolean bool = anV(paramInt2);
    AppMethodBeat.o(234228);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(234245);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(234245);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(234247);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(234247);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(234249);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if ((anX(i) != null) && (!anX(i).requery()))
      {
        AppMethodBeat.o(234249);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(234249);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(234246);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(234246);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(234248);
    int j = this.Qgl.length;
    int i = 0;
    while (i < j)
    {
      if (anX(i) != null) {
        anX(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(234248);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> Qgs = new LinkedHashMap();
    
    public final m.d anY(int paramInt)
    {
      Object localObject = gVZ();
      if (localObject == null) {
        return new m.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return m.d.QgB;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = c((Cursor)localObject, paramInt);
      return localObject;
      return m.d.QgB;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.Qgs.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.Qgs.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.Qgs.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract m.d c(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor gVZ();
  }
  
  public static final class c
  {
    public final m.d QgA;
    public final int Qgy;
    public final int Qgz;
    
    public c(int paramInt1, int paramInt2, m.d paramd)
    {
      this.Qgy = paramInt1;
      this.Qgz = paramInt2;
      this.QgA = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d QgB;
    public long QgC = 0L;
    public int QgD = 0;
    
    static
    {
      AppMethodBeat.i(234221);
      QgB = new d(0L);
      AppMethodBeat.o(234221);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.QgC = paramLong;
      this.QgD = 0;
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
          if ((paramd == null) || (QgB == paramd)) {
            return 1;
          }
        } while ((this.QgD == paramd.QgD) && (this.QgC == paramd.QgC));
        if (this.QgD != paramd.QgD) {
          return this.QgD - paramd.QgD;
        }
        l = this.QgC - paramd.QgC;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.QgD << 31 | (int)this.QgC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */