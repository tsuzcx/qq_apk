package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d Jkn;
  
  public g(d paramd, int paramInt)
  {
    this.Jkn = paramd;
    this.Jkn.xa(true);
    this.Jkn.a(new f.a()
    {
      public final ArrayList<a> aW(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.aW(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a fxW()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.fxY();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.Jkn.abS(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> aW(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.Jkn.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.Jkn.close();
    this.Jkn = null;
  }
  
  public final boolean dY(Object paramObject)
  {
    return this.Jkn.dY(paramObject);
  }
  
  public final SparseArray<K>[] fxI()
  {
    return this.Jkn.fxI();
  }
  
  public final boolean fxK()
  {
    return this.Jkn.fxK();
  }
  
  public abstract T fxY();
  
  public final int getCount()
  {
    return this.Jkn.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.Jkn.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */