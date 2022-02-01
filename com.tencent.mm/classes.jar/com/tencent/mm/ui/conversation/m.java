package com.tencent.mm.ui.conversation;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class m
  extends AbstractCursor
{
  private a[] Hfl;
  private int Hfm;
  private int Hfn;
  int Hfo;
  LinkedList<c> Hfp;
  private final b Hfq;
  private Cursor Qs;
  private DataSetObserver mObserver;
  private int pdP;
  
  public m(e parame, a... paramVarArgs)
  {
    AppMethodBeat.i(191767);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(191756);
        m.a(m.this);
        m.this.fcH();
        AppMethodBeat.o(191756);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(191757);
        m.b(m.this);
        m.this.fcH();
        AppMethodBeat.o(191757);
      }
    };
    this.pdP = -1;
    this.Hfm = e.HfE.op;
    this.Hfn = 40;
    this.Hfo = -1;
    this.Hfp = new LinkedList();
    this.Hfq = new b();
    this.Hfm = parame.op;
    if (paramVarArgs.length < 2) {}
    for (this.Hfl = paramVarArgs;; this.Hfl = new a[] { paramVarArgs[0], paramVarArgs[1] })
    {
      this.Qs = this.Hfl[0].fcF();
      while (i < this.Hfl.length)
      {
        if (ZT(i) != null) {
          ZT(i).registerDataSetObserver(this.mObserver);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(191767);
  }
  
  private m(a... paramVarArgs)
  {
    this(e.HfE, paramVarArgs);
  }
  
  private boolean ZQ(int paramInt)
  {
    AppMethodBeat.i(191770);
    try
    {
      b.a(this.Hfq);
      this.Qs = this.Hfl[0].fcF();
      boolean bool = this.Qs.moveToPosition(paramInt);
      AppMethodBeat.o(191770);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      ad.w("MergeSortCursorWrapper", "onMoveOneCursorOnly fail:" + localThrowable.getMessage());
      AppMethodBeat.o(191770);
    }
    return false;
  }
  
  private boolean ZR(int paramInt)
  {
    AppMethodBeat.i(191771);
    int i = this.Hfo;
    int j = this.Hfo;
    int k = this.Hfp.size();
    Object localObject1;
    int i3;
    int i4;
    label132:
    Object localObject2;
    d locald1;
    d locald2;
    label258:
    int m;
    if ((i <= paramInt) && (paramInt < j + k))
    {
      b.a(this.Hfq);
      localObject1 = ZS(paramInt);
      if (localObject1 == null)
      {
        AppMethodBeat.o(191771);
        return false;
      }
    }
    else
    {
      localObject1 = this.Hfq;
      ((b)localObject1).Hfw += 1L;
      i = this.Hfn / 2;
      i3 = Math.max(paramInt / i * i - i, 0);
      i4 = Math.min(this.Hfn + i3, getCount());
      int i2 = i4 - 1;
      if (i2 < 0) {
        localObject1 = null;
      }
      while (localObject1 != null)
      {
        localObject2 = new LinkedList();
        a locala1 = this.Hfl[0];
        a locala2 = this.Hfl[1];
        j = ((Integer)((Pair)localObject1).first).intValue();
        i = ((Integer)((Pair)localObject1).second).intValue();
        k = i2;
        for (;;)
        {
          if (k < i3) {
            break label745;
          }
          locald1 = locala1.ZU(j);
          locald2 = locala2.ZU(i);
          if ((d.HfB == locald1) && (d.HfB == locald2)) {
            break label745;
          }
          if (d.HfB != locald1) {
            break;
          }
          ((LinkedList)localObject2).add(0, new c(1, i, locald2));
          i -= 1;
          k -= 1;
        }
        localObject1 = this.Hfl[0];
        localObject2 = this.Hfl[1];
        if ((localObject1 == null) || (localObject2 == null))
        {
          localObject1 = null;
        }
        else
        {
          j = ((a)localObject1).getCount();
          int i5 = ((a)localObject2).getCount();
          if (j + i5 < i2 + 1)
          {
            localObject1 = null;
          }
          else if (j <= 0)
          {
            localObject1 = new Pair(Integer.valueOf(-1), Integer.valueOf(i2));
          }
          else if (i5 <= 0)
          {
            localObject1 = new Pair(Integer.valueOf(i2), Integer.valueOf(-1));
          }
          else
          {
            i = 0;
            m = Math.min(j - 1, i2);
            k = 0;
            j = -1;
            while (i <= m)
            {
              n = (i + m) / 2;
              int i1 = i2 - n - 1;
              if ((i1 < 0) || (i1 >= i5))
              {
                i = n + 1;
                j = i1;
                k = n;
              }
              else
              {
                int i6 = a(((a)localObject1).ZU(n), ((a)localObject2).ZU(i1));
                if (i6 < 0)
                {
                  i = n + 1;
                  j = i1;
                  k = n;
                }
                else
                {
                  j = i1;
                  k = n;
                  if (i6 <= 0) {
                    break;
                  }
                  m = n - 1;
                  j = i1;
                  k = n;
                }
              }
            }
            int n = j + 1;
            for (;;)
            {
              i = j;
              m = k;
              if (n >= i5) {
                break;
              }
              i = j;
              m = k;
              if (a(((a)localObject1).ZU(k), ((a)localObject2).ZU(n)) <= 0) {
                break;
              }
              k -= 1;
              j += 1;
              i = j;
              m = k;
              if (k < 0) {
                break;
              }
              n += 1;
            }
            if (m >= 0) {
              break label915;
            }
          }
        }
      }
    }
    label915:
    for (j = -1;; j = m)
    {
      k = i;
      if (i < 0) {
        k = -1;
      }
      localObject1 = new Pair(Integer.valueOf(j), Integer.valueOf(k));
      break label132;
      break;
      if (d.HfB == locald2)
      {
        ((LinkedList)localObject2).add(0, new c(0, j, locald1));
        j -= 1;
        break label258;
      }
      b.c(this.Hfq);
      if (this.Hfm * locald1.a(locald2) <= 0) {}
      for (m = 1;; m = 0)
      {
        if (m == 0) {
          break label721;
        }
        ((LinkedList)localObject2).add(0, new c(1, i, locald2));
        i -= 1;
        break;
      }
      label721:
      ((LinkedList)localObject2).add(0, new c(0, j, locald1));
      j -= 1;
      break label258;
      label745:
      if (((LinkedList)localObject2).size() != i4) {
        ad.w("MergeSortCursorWrapper", "fillWindow K=%d, N=%d (%d), heads=[%d, %d], iterator=[%d, %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(((LinkedList)localObject2).size()), Integer.valueOf(i4), ((Pair)localObject1).first, ((Pair)localObject1).second, Integer.valueOf(j), Integer.valueOf(i) });
      }
      this.Hfo = i3;
      this.Hfp = ((LinkedList)localObject2);
      break;
      try
      {
        this.Qs = this.Hfl[localObject1.Hfy].fcF();
        boolean bool = this.Qs.moveToPosition(((c)localObject1).Hfz);
        AppMethodBeat.o(191771);
        return bool;
      }
      catch (Throwable localThrowable)
      {
        ad.w("MergeSortCursorWrapper", "onMoveTwoCursorMixed fail:" + localThrowable.getMessage());
        AppMethodBeat.o(191771);
        return false;
      }
    }
  }
  
  private c ZS(int paramInt)
  {
    AppMethodBeat.i(191774);
    try
    {
      int i = this.Hfo;
      c localc = (c)this.Hfp.get(paramInt - i);
      AppMethodBeat.o(191774);
      return localc;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      ad.w("MergeSortCursorWrapper", "locateElement fail:" + localIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(191774);
    }
    return null;
  }
  
  private Cursor ZT(int paramInt)
  {
    AppMethodBeat.i(191792);
    Cursor localCursor = this.Hfl[paramInt].fcF();
    AppMethodBeat.o(191792);
    return localCursor;
  }
  
  private int a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(191773);
    b.c(this.Hfq);
    int i = this.Hfm;
    int j = paramd1.a(paramd2);
    AppMethodBeat.o(191773);
    return i * j;
  }
  
  public static m fcG()
  {
    AppMethodBeat.i(191766);
    m localm = new m(new a[] { new a()
    {
      protected final m.d d(Cursor paramAnonymousCursor, int paramAnonymousInt)
      {
        AppMethodBeat.i(191758);
        paramAnonymousCursor = new m.d(paramAnonymousInt);
        AppMethodBeat.o(191758);
        return paramAnonymousCursor;
      }
      
      public final Cursor fcF()
      {
        return null;
      }
    } });
    AppMethodBeat.o(191766);
    return localm;
  }
  
  public final void close()
  {
    AppMethodBeat.i(191786);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(191786);
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(191785);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(191785);
  }
  
  public final void fcH()
  {
    AppMethodBeat.i(191772);
    if (this.Hfo != -1) {
      b.b(this.Hfq);
    }
    this.Hfo = -1;
    this.Hfp = new LinkedList();
    AppMethodBeat.o(191772);
  }
  
  final Cursor fcI()
  {
    AppMethodBeat.i(191793);
    if ((this.Qs == null) || (this.Qs.isClosed())) {
      onMove(-1, this.pdP);
    }
    Cursor localCursor = this.Qs;
    AppMethodBeat.o(191793);
    return localCursor;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(191783);
    byte[] arrayOfByte = fcI().getBlob(paramInt);
    AppMethodBeat.o(191783);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(191784);
    if (this.Qs != null)
    {
      String[] arrayOfString = fcI().getColumnNames();
      AppMethodBeat.o(191784);
      return arrayOfString;
    }
    AppMethodBeat.o(191784);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(191768);
    int m = this.Hfl.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (ZT(i) != null) {
        k = j + ZT(i).getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(191768);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(191780);
    double d = fcI().getDouble(paramInt);
    AppMethodBeat.o(191780);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(191779);
    float f = fcI().getFloat(paramInt);
    AppMethodBeat.o(191779);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(191777);
    paramInt = fcI().getInt(paramInt);
    AppMethodBeat.o(191777);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(191778);
    long l = fcI().getLong(paramInt);
    AppMethodBeat.o(191778);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(191776);
    short s = fcI().getShort(paramInt);
    AppMethodBeat.o(191776);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(191775);
    String str = fcI().getString(paramInt);
    AppMethodBeat.o(191775);
    return str;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(191781);
    paramInt = fcI().getType(paramInt);
    AppMethodBeat.o(191781);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(191782);
    boolean bool = fcI().isNull(paramInt);
    AppMethodBeat.o(191782);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191769);
    b localb = this.Hfq;
    localb.Hft += 1L;
    this.pdP = paramInt2;
    if (this.Hfl.length < 2)
    {
      bool = ZQ(paramInt2);
      AppMethodBeat.o(191769);
      return bool;
    }
    boolean bool = ZR(paramInt2);
    AppMethodBeat.o(191769);
    return bool;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(191787);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(191787);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(191789);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(191789);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(191791);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if ((ZT(i) != null) && (!ZT(i).requery()))
      {
        AppMethodBeat.o(191791);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(191791);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(191788);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(191788);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(191790);
    int j = this.Hfl.length;
    int i = 0;
    while (i < j)
    {
      if (ZT(i) != null) {
        ZT(i).unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(191790);
  }
  
  public static abstract class a
  {
    private final LinkedHashMap<String, Integer> Hfs = new LinkedHashMap();
    
    public final m.d ZU(int paramInt)
    {
      Object localObject = fcF();
      if (localObject == null) {
        return new m.d(paramInt);
      }
      if (paramInt < 0) {}
      try
      {
        return m.d.HfB;
      }
      catch (Throwable localThrowable) {}
      ((Cursor)localObject).moveToPosition(paramInt);
      localObject = d((Cursor)localObject, paramInt);
      return localObject;
      return m.d.HfB;
    }
    
    protected final int b(Cursor paramCursor, String paramString)
    {
      Integer localInteger = (Integer)this.Hfs.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      paramCursor = paramCursor.getColumnNames();
      int i = 0;
      while (i < paramCursor.length)
      {
        if (paramString.equals(paramCursor[i]))
        {
          this.Hfs.put(paramString, Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      this.Hfs.put(paramString, Integer.valueOf(-1));
      return -1;
    }
    
    protected abstract m.d d(Cursor paramCursor, int paramInt);
    
    protected abstract Cursor fcF();
    
    public final int getCount()
    {
      Cursor localCursor = fcF();
      if (localCursor == null) {
        return 0;
      }
      return localCursor.getCount();
    }
  }
  
  public static final class b
  {
    long Hft = 0L;
    private long Hfu = 0L;
    private long Hfv = 0L;
    long Hfw = 0L;
    private long Hfx = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(191759);
      try
      {
        String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.Hft), Long.valueOf(this.Hfu), Float.valueOf((float)this.Hfu * 100.0F / (float)this.Hft), Long.valueOf(this.Hfv), Long.valueOf(this.Hfw), Float.valueOf((float)this.Hfv * 100.0F / (float)this.Hfw), Long.valueOf(this.Hfx), Float.valueOf((float)this.Hfx * 100.0F / (float)this.Hft) });
        AppMethodBeat.o(191759);
        return str;
      }
      catch (Throwable localThrowable)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("total=").append(this.Hft).append("hit=").append(this.Hfu).append("clearWindow=").append(this.Hfv).append("fillWindow=").append(this.Hfw).append("compare=").append(this.Hfx);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(191759);
        return localObject;
      }
    }
  }
  
  public static final class c
  {
    public final m.d HfA;
    public final int Hfy;
    public final int Hfz;
    
    public c(int paramInt1, int paramInt2, m.d paramd)
    {
      this.Hfy = paramInt1;
      this.Hfz = paramInt2;
      this.HfA = paramd;
    }
  }
  
  public static final class d
    implements Comparable<d>
  {
    public static final d HfB;
    public long HfC = 0L;
    public int HfD = 0;
    
    static
    {
      AppMethodBeat.i(191762);
      HfB = new d(0L);
      AppMethodBeat.o(191762);
    }
    
    public d() {}
    
    public d(long paramLong)
    {
      this.HfC = paramLong;
      this.HfD = 0;
    }
    
    public final int a(d paramd)
    {
      if (this == paramd) {}
      do
      {
        return 0;
        if ((paramd == null) || (HfB == paramd)) {
          return 1;
        }
      } while ((this.HfD == paramd.HfD) && (this.HfC == paramd.HfC));
      if (this.HfD != paramd.HfD) {
        return this.HfD - paramd.HfD;
      }
      return (int)(this.HfC - paramd.HfC);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(191760);
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(191760);
      return bool;
    }
    
    public final int hashCode()
    {
      return this.HfD << 31 | (int)this.HfC;
    }
  }
  
  public static enum e
  {
    final int op;
    
    static
    {
      AppMethodBeat.i(191765);
      HfE = new e("ASC", 0, 1);
      HfF = new e("DESC", 1, -1);
      HfG = new e[] { HfE, HfF };
      AppMethodBeat.o(191765);
    }
    
    private e(int paramInt)
    {
      this.op = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */