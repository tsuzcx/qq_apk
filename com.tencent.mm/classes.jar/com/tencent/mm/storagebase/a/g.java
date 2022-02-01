package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d Ouf;
  public boolean Oug;
  
  public g(d paramd, int paramInt, boolean paramBoolean)
  {
    this.Ouf = paramd;
    this.Oug = paramBoolean;
    this.Ouf.AO(true);
    this.Ouf.a(new f.a()
    {
      public final ArrayList<a> bo(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.bo(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a gFJ()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.gFL();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.Ouf.akA(paramInt);
    }
    if (!paramBoolean) {
      getCount();
    }
  }
  
  public abstract ArrayList<T> bo(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.Ouf.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.Ouf.close();
    this.Ouf = null;
  }
  
  public final boolean ed(Object paramObject)
  {
    return this.Ouf.ed(paramObject);
  }
  
  public abstract T gFL();
  
  public final SparseArray<K>[] gFv()
  {
    return this.Ouf.gFv();
  }
  
  public final boolean gFx()
  {
    return this.Ouf.gFx();
  }
  
  public final int getCount()
  {
    return this.Ouf.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.Ouf.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */