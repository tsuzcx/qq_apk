package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d adoh;
  public boolean adoi;
  
  public g(d paramd, int paramInt, boolean paramBoolean)
  {
    this.adoh = paramd;
    this.adoi = paramBoolean;
    this.adoh.KF(true);
    this.adoh.a(new f.a()
    {
      public final ArrayList<a> ce(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.ce(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a jeg()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.jei();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.adoh.fi(paramInt);
    }
    if (!paramBoolean) {
      getCount();
    }
  }
  
  public final void c(Object paramObject, T paramT)
  {
    this.adoh.a(paramObject, paramT);
  }
  
  public abstract ArrayList<T> ce(ArrayList<Object> paramArrayList);
  
  public final void close()
  {
    this.adoh.close();
    this.adoh = null;
  }
  
  public final boolean gF(Object paramObject)
  {
    return this.adoh.gF(paramObject);
  }
  
  public final int getCount()
  {
    return this.adoh.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.adoh.isClosed();
  }
  
  public final SparseArray<K>[] jdT()
  {
    return this.adoh.jdT();
  }
  
  public final boolean jdV()
  {
    return this.adoh.jdV();
  }
  
  public abstract T jei();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */