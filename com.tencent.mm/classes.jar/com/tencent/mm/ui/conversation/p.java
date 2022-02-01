package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class p
  extends AbstractCursor
{
  private a[] afqT;
  private int afqU;
  private int afqV;
  int afqW;
  LinkedList<c> afqX;
  private final b afqY;
  private Cursor gw;
  private DataSetObserver mObserver;
  private int yAJ;
  
  public p(p.e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(256880);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(256980);
        p.a(p.this);
        p.this.jAP();
        AppMethodBeat.o(256980);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(256983);
        p.b(p.this);
        p.this.jAP();
        AppMethodBeat.o(256983);
      }
    };
    this.yAJ = -1;
    this.afqU = p.e.afrm.op;
    this.afqV = 100;
    this.afqW = -1;
    this.afqX = new LinkedList();
    this.afqY = new b();
    this.afqU = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.afqT = paramVarArgs;; this.afqT = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.gw = this.afqT[0].jAN();
      while (i < this.afqT.length)
      {
        if (aDK(i) != null) {
          aDK(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(256880);
  }
  
  private p(a... paramVarArgs)
  {
    this(p.e.afrm, paramVarArgs);
  }
  
  private boolean aDH(int paramInt)
  {
    AppMethodBeat.i(256886);
    try
    {
      b.a(this.afqY);
      this.gw = this.afqT[0].jAN();
      boolean bool = this.gw.moveToPosition(paramInt);
      AppMethodBeat.o(256886);
      return bool;
    }
    finally
    {
      Log.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localObject.getMessage());
      AppMethodBeat.o(256886);
    }
    return false;
  }
  
  private boolean aDI(int paramInt)
  {
    AppMethodBeat.i(256901);
    int i = this.afqW;
    int j = this.afqW;
    int k = this.afqX.size();
    if ((i <= paramInt) && (paramInt < j + k)) {
      b.a(this.afqY);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = aDJ(paramInt);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(256901);
      return false;
      localObject1 = this.afqY;
      ((b)localObject1).afre += 1L;
      a locala1 = this.afqT[0];
      a locala2 = this.afqT[1];
      d locald;
      LinkedList localLinkedList;
      int m;
      if (paramInt <= 0)
      {
        i = this.afqV;
        j = Math.min(i * 2, getCount());
        k = i;
        if (j < i * 2) {
          k = j;
        }
        j = 0;
        i = 0;
        locald = locala1.aDL(0);
        localObject1 = locala2.aDL(0);
        localLinkedList = new LinkedList();
        m = 0;
        label163:
        if ((m >= k) || ((d.afrj == locald) && (d.afrj == localObject1))) {
          break label405;
        }
        if (d.afrj != locald) {
          break label254;
        }
        localLinkedList.add(new c(1, i, (d)localObject1));
        i += 1;
        localObject1 = locala2.aDL(i);
      }
      label373:
      for (;;)
      {
        m += 1;
        break label163;
        i = (this.afqV - 1 + paramInt) / this.afqV * this.afqV;
        break;
        label254:
        if (d.afrj == localObject1)
        {
          localLinkedList.add(new c(0, j, locald));
          j += 1;
          locald = locala1.aDL(j);
        }
        else
        {
          b localb = this.afqY;
          localb.afrf += 1L;
          if (this.afqU * locald.a((d)localObject1) <= 0) {}
          for (int n = 1;; n = 0)
          {
            if (n == 0) {
              break label373;
            }
            localLinkedList.add(new c(0, j, locald));
            j += 1;
            locald = locala1.aDL(j);
            break;
          }
          localLinkedList.add(new c(1, i, (d)localObject1));
          i += 1;
          localObject1 = locala2.aDL(i);
        }
      }
      label405:
      if (localLinkedList.size() != k) {
        Log.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), iterator=[%d, %d]", new Object[] { Integer.valueOf(0), Integer.valueOf(localLinkedList.size()), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.afqW = 0;
      this.afqX = localLinkedList;
    }
    try
    {
      this.gw = this.afqT[localObject1.afrg].jAN();
      boolean bool = this.gw.moveToPosition(((c)localObject1).afrh);
      AppMethodBeat.o(256901);
      return bool;
    }
    finally
    {
      Log.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localObject2.getMessage());
      AppMethodBeat.o(256901);
    }
    return false;
  }
  
  private c aDJ(int paramInt)
  {
    AppMethodBeat.i(256904);
    try
    {
      int i = this.afqW;
      c localc = (c)this.afqX.get(paramInt - i);
      AppMethodBeat.o(256904);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      Log.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(256904);
    }
    return null;
  }
  
  private Cursor aDK(int paramInt)
  {
    AppMethodBeat.i(256910);
    Cursor localCursor = this.afqT[paramInt].jAN();
    AppMethodBeat.o(256910);
    return localCursor;
  }
  
  public static p jAO()
  {
    AppMethodBeat.i(256869);
    p localp = new p(new a[] { new a()
    {
      protected final p.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(257044);
        paramAnonymousCursor = new p.d(paramAnonymousInt);
        AppMethodBeat.o(257044);
        return paramAnonymousCursor;
      }
      
      public final Cursor jAN()
      {
        return null;
      }
    } });
    AppMethodBeat.o(256869);
    return localp;
  }
  
  public final void close()
  {
    AppMethodBeat.i(256993);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(256993);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(256990);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(256990);
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(256981);
    byte[] arrayOfByte = jAQ().getBlob(paramInt);
    AppMethodBeat.o(256981);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(256984);
    if (this.gw != null)
    {
      String[] arrayOfString = jAQ().getColumnNames();
      AppMethodBeat.o(256984);
      return arrayOfString;
    }
    AppMethodBeat.o(256984);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(256925);
    int m = this.afqT.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (aDK(i) != null) {
        k = j + aDK(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(256925);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(256968);
    double d = jAQ().getDouble(paramInt);
    AppMethodBeat.o(256968);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(256962);
    float f = jAQ().getFloat(paramInt);
    AppMethodBeat.o(256962);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(256952);
    paramInt = jAQ().getInt(paramInt);
    AppMethodBeat.o(256952);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(256957);
    long l = jAQ().getLong(paramInt);
    AppMethodBeat.o(256957);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(256944);
    short s = jAQ().getShort(paramInt);
    AppMethodBeat.o(256944);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(256941);
    String str = jAQ().getString(paramInt);
    AppMethodBeat.o(256941);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(256973);
    paramInt = jAQ().getType(paramInt);
    AppMethodBeat.o(256973);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(256976);
    boolean bool = jAQ().isNull(paramInt);
    AppMethodBeat.o(256976);
    return bool;
  }
  
  public final void jAP()
  {
    AppMethodBeat.i(256933);
    if (this.afqW != -1) {
      b.b(this.afqY);
    }
    this.afqW = -1;
    this.afqX = new LinkedList();
    AppMethodBeat.o(256933);
  }
  
  final Cursor jAQ()
  {
    AppMethodBeat.i(257014);
    if ((this.gw == null) || (this.gw.isClosed())) {
      onMove(-1, this.yAJ);
    }
    Cursor localCursor = this.gw;
    AppMethodBeat.o(257014);
    return localCursor;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256930);
    b localb = this.afqY;
    localb.afrb += 1L;
    this.yAJ = paramInt2;
    if (this.afqT.length < 2)
    {
      bool = aDH(paramInt2);
      AppMethodBeat.o(256930);
      return bool;
    }
    boolean bool = aDI(paramInt2);
    AppMethodBeat.o(256930);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(257000);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(257000);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(257007);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(257007);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(257013);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if ((aDK(i) != null) && (!aDK(i).requery()))
      {
        AppMethodBeat.o(257013);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(257013);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(257004);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(257004);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(257009);
    int j = this.afqT.length;
    int i = 0;
    while (i < j)
    {
      if (aDK(i) != null) {
        aDK(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(257009);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> afra = new LinkedHashMap();
    
    public final p.d aDL(int paramInt)
    {
      Object localObject1 = jAN();
      if (localObject1 == null) {
        return new p.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return p.d.afrj;
      }
      finally {}
      ((Cursor)localObject1).moveToPosition(paramInt);
      localObject1 = d((Cursor)localObject1, paramInt);
      return localObject1;
      return p.d.afrj;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.afra.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.afra.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.afra.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract p.d d(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor jAN();
  }
  
  public static final class b
  {
    long afrb = 0L;
    private long afrc = 0L;
    private long afrd = 0L;
    long afre = 0L;
    long afrf = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(256768);
      try
      {
        String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.afrb), Long.valueOf(this.afrc), Float.valueOf((float)this.afrc * 100.0F / (float)this.afrb), Long.valueOf(this.afrd), Long.valueOf(this.afre), Float.valueOf((float)this.afrd * 100.0F / (float)this.afre), Long.valueOf(this.afrf), Float.valueOf((float)this.afrf * 100.0F / (float)this.afrb) });
        AppMethodBeat.o(256768);
        return str;
      }
      finally
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("total=").append(this.afrb).append("hit=").append(this.afrc).append("clearWindow=").append(this.afrd).append("fillWindow=").append(this.afre).append("compare=").append(this.afrf);
        localObject2 = ((StringBuilder)localObject2).toString();
        AppMethodBeat.o(256768);
        return localObject2;
      }
    }
  }
  
  public static final class c
  {
    public final int afrg;
    public final int afrh;
    public final p.d afri;
    
    public c(int paramInt1, int paramInt2, p.d paramd)
    {
      this.afrg = paramInt1;
      this.afrh = paramInt2;
      this.afri = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d afrj;
    public long afrk = 0L;
    public int afrl = 0;
    
    static
    {
      AppMethodBeat.i(256767);
      afrj = new d(0L);
      AppMethodBeat.o(256767);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.afrk = paramLong;
      this.afrl = 0;
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
          if ((paramd == null) || (afrj == paramd)) {
            return 1;
          }
        } while ((this.afrl == paramd.afrl) && (this.afrk == paramd.afrk));
        if (this.afrl != paramd.afrl) {
          return this.afrl - paramd.afrl;
        }
        l = this.afrk - paramd.afrk;
        if (l < 0L) {
          return -1;
        }
      } while (l == 0L);
      return 1;
    }
    
    public final int hashCode()
    {
      return this.afrl << 31 | (int)this.afrk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p
 * JD-Core Version:    0.7.0.1
 */