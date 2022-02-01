package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d Hcp;
  
  public g(d paramd, int paramInt)
  {
    this.Hcp = paramd;
    this.Hcp.wg(true);
    this.Hcp.a(new f.a()
    {
      public final ArrayList<a> aY(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.aY(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a fdN()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.fdP();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.Hcp.Zb(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> aY(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.Hcp.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.Hcp.close();
    this.Hcp = null;
  }
  
  public final boolean dU(Object paramObject)
  {
    return this.Hcp.dU(paramObject);
  }
  
  public final boolean fdB()
  {
    return this.Hcp.fdB();
  }
  
  public abstract T fdP();
  
  public final SparseArray<K>[] fdz()
  {
    return this.Hcp.fdz();
  }
  
  public final int getCount()
  {
    return this.Hcp.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.Hcp.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */