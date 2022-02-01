package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class n
  extends AbstractCursor
{
  private a[] XDq;
  private int XDr;
  private int XDs;
  int XDt;
  LinkedList<c> XDu;
  private final n.b XDv;
  private Cursor fB;
  private DataSetObserver mObserver;
  private int von;
  
  public n(e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(283471);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(239754);
        n.a(n.this);
        n.this.hWB();
        AppMethodBeat.o(239754);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(239757);
        n.b(n.this);
        n.this.hWB();
        AppMethodBeat.o(239757);
      }
    };
    this.von = -1;
    this.XDr = e.XDJ.op;
    this.XDs = 100;
    this.XDt = -1;
    this.XDu = new LinkedList();
    this.XDv = new n.b();
    this.XDr = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.XDq = paramVarArgs;; this.XDq = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.fB = this.XDq[0].hWz();
      while (i < this.XDq.length)
      {
        if (axc(i) != null) {
          axc(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(283471);
  }
  
  private n(a... paramVarArgs)
  {
    this(e.XDJ, paramVarArgs);
  }
  
  private boolean awZ(int paramInt)
  {
    AppMethodBeat.i(283476);
    try
    {
      n.b.a(this.XDv);
      this.fB = this.XDq[0].hWz();
      boolean bool = this.fB.moveToPosition(paramInt);
      AppMethodBeat.o(283476);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(283476);
    }
    return false;
  }
  
  private boolean axa(int paramInt)
  {
    AppMethodBeat.i(283477);
    int i = this.XDt;
    int j = this.XDt;
    int k = this.XDu.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      n.b.a(this.XDv);
    }
    Object localObject;
    for (;;)
    {
      localObject = axb(paramInt);
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(283477);
      return false;
      localObject = this.XDv;
      ((n.b)localObject).XDB += 1L;
      a locala1 = this.XDq[0];
      a locala2 = this.XDq[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.XDs;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.axd(0);
        localObject = locala2.axd(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.XDG == locald) && (d.XDG == localObject))) {
          break label405;
        }
        if (d.XDG != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject));
        i += 1;
        localObject = locala2.axd(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.XDs - 1 + paramInt) / this.XDs * this.XDs;
        break;
        label254:
        if (d.XDG == localObject)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.axd(j);
        }
        else
        {
          n.b localb = this.XDv;
          localb.XDC += 1L;
          if (this.XDr * locald.a((d)localObject) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.axd(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject));
          i += 1;
          localObject = locala2.axd(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        Log.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.XDt = 0;
      this.XDu = localLinkedList;
    }
    try
    {
      this.fB = this.XDq[localObject.XDD].hWz();
      boolean bool = this.fB.moveToPosition(((c)localObject).XDE);
      AppMethodBeat.o(283477);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
      AppMethodBeat.o(283477);
    }
    return false;
  }
  
  private c axb(int paramInt)
  {
    AppMethodBeat.i(283479);
    try
    {
      int i = this.XDt;
      c localc = (c)this.XDu.get(paramInt - i);
      AppMethodBeat.o(283479);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(283479);
    }
    return null;
  }
  
  private Cursor axc(int paramInt)
  {
    AppMethodBeat.i(283497);
    Cursor localCursor = this.XDq[paramInt].hWz();
    AppMethodBeat.o(283497);
    return localCursor;
  }
  
  public static n hWA()
  {
    AppMethodBeat.i(283470);
    n localn = new n(new a[] { new a()
    {
      protected final n.d c(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(204264);
        paramAnonymousCursor = new n.d(paramAnonymousInt);
        AppMethodBeat.o(204264);
        return paramAnonymousCursor;
      }
      
      public final Cursor hWz()
      {
        return null;
      }
    } });
    AppMethodBeat.o(283470);
    return localn;
  }
  
  public final void close()
  {
    AppMethodBeat.i(283491);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(283491);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(283490);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(283490);
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(283488);
    byte[] arrayOfByte = hWC().getBlob(paramInt);
    AppMethodBeat.o(283488);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(283489);
    if (this.fB != null)
    {
      String[] arrayOfString = hWC().getColumnNames();
      AppMethodBeat.o(283489);
      return arrayOfString;
    }
    AppMethodBeat.o(283489);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(283474);
    int m = this.XDq.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (axc(i) != null) {
        k = j + axc(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(283474);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(283485);
    double d = hWC().getDouble(paramInt);
    AppMethodBeat.o(283485);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(283484);
    float f = hWC().getFloat(paramInt);
    AppMethodBeat.o(283484);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(283482);
    paramInt = hWC().getInt(paramInt);
    AppMethodBeat.o(283482);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(283483);
    long l = hWC().getLong(paramInt);
    AppMethodBeat.o(283483);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(283481);
    short s = hWC().getShort(paramInt);
    AppMethodBeat.o(283481);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(283480);
    String str = hWC().getString(paramInt);
    AppMethodBeat.o(283480);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(283486);
    paramInt = hWC().getType(paramInt);
    AppMethodBeat.o(283486);
    return paramInt;
  }
  
  public final void hWB()
  {
    AppMethodBeat.i(283478);
    if (this.XDt != -1) {
      n.b.b(this.XDv);
    }
    this.XDt = -1;
    this.XDu = new LinkedList();
    AppMethodBeat.o(283478);
  }
  
  final Cursor hWC()
  {
    AppMethodBeat.i(283498);
    if ((this.fB == null) || (this.fB.isClosed())) {
      onMove(-1, this.von);
    }
    Cursor localCursor = this.fB;
    AppMethodBeat.o(283498);
    return localCursor;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(283487);
    boolean bool = hWC().isNull(paramInt);
    AppMethodBeat.o(283487);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283475);
    n.b localb = this.XDv;
    localb.XDy += 1L;
    this.von = paramInt2;
    if (this.XDq.length < 2)
    {
      bool = awZ(paramInt2);
      AppMethodBeat.o(283475);
      return bool;
    }
    boolean bool = axa(paramInt2);
    AppMethodBeat.o(283475);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(283492);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(283492);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(283494);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(283494);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(283496);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if ((axc(i) != null) && (!axc(i).requery()))
      {
        AppMethodBeat.o(283496);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(283496);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(283493);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(283493);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(283495);
    int j = this.XDq.length;
    int i = 0;
    while (i < j)
    {
      if (axc(i) != null) {
        axc(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(283495);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> XDx = new LinkedHashMap();
    
    public final n.d axd(int paramInt)
    {
      Object localObject = hWz();
      if (localObject == null) {
        return new n.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return n.d.XDG;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = c((Cursor)localObject, paramInt);
      return localObject;
      return n.d.XDG;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.XDx.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.XDx.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.XDx.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract n.d c(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor hWz();
  }
  
  public static final class c
  {
    public final int XDD;
    public final int XDE;
    public final n.d XDF;
    
    public c(int paramInt1, int paramInt2, n.d paramd)
    {
      this.XDD = paramInt1;
      this.XDE = paramInt2;
      this.XDF = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d XDG;
    public long XDH = 0L;
    public int XDI = 0;
    
    static
    {
      AppMethodBeat.i(248990);
      XDG = new d(0L);
      AppMethodBeat.o(248990);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.XDH = paramLong;
      this.XDI = 0;
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
          if ((paramd == null) || (XDG == paramd)) {
            return 1;
          }
        } while ((this.XDI == paramd.XDI) && (this.XDH == paramd.XDH));
        if (this.XDI != paramd.XDI) {
          return this.XDI - paramd.XDI;
        }
        l = this.XDH - paramd.XDH;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.XDI << 31 | (int)this.XDH;
    }
  }
  
  public static enum e
  {
    final int op;
    
    static
    {
      AppMethodBeat.i(283745);
      XDJ = new e("ASC", 0, 1);
      XDK = new e("DESC", 1, -1);
      XDL = new e[] { XDJ, XDK };
      AppMethodBeat.o(283745);
    }
    
    private e(int paramInt)
    {
      this.op = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n
 * JD-Core Version:    0.7.0.1
 */