package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d FDm;
  
  public g(d paramd, int paramInt)
  {
    this.FDm = paramd;
    this.FDm.ve(true);
    this.FDm.a(new f.a()
    {
      public final ArrayList<a> aM(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.aM(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a eOj()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.eOl();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.FDm.WR(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> aM(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.FDm.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.FDm.close();
    this.FDm = null;
  }
  
  public final boolean dT(Object paramObject)
  {
    return this.FDm.dT(paramObject);
  }
  
  public final SparseArray<K>[] eNV()
  {
    return this.FDm.eNV();
  }
  
  public final boolean eNX()
  {
    return this.FDm.eNX();
  }
  
  public abstract T eOl();
  
  public final int getCount()
  {
    return this.FDm.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.FDm.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */