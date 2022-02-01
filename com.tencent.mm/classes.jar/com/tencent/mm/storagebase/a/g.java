package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d IPF;
  
  public g(d paramd, int paramInt)
  {
    this.IPF = paramd;
    this.IPF.wS(true);
    this.IPF.a(new f.a()
    {
      public final ArrayList<a> aV(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.aV(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a ftV()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.ftX();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.IPF.abk(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> aV(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.IPF.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.IPF.close();
    this.IPF = null;
  }
  
  public final boolean dX(Object paramObject)
  {
    return this.IPF.dX(paramObject);
  }
  
  public final SparseArray<K>[] ftH()
  {
    return this.IPF.ftH();
  }
  
  public final boolean ftJ()
  {
    return this.IPF.ftJ();
  }
  
  public abstract T ftX();
  
  public final int getCount()
  {
    return this.IPF.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.IPF.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */