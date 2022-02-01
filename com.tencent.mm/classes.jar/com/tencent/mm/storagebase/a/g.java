package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d VKd;
  public boolean VKe;
  
  public g(d paramd, int paramInt, boolean paramBoolean)
  {
    this.VKd = paramd;
    this.VKe = paramBoolean;
    this.VKd.EV(true);
    this.VKd.a(new f.a()
    {
      public final ArrayList<a> bD(ArrayList<Object> paramAnonymousArrayList)
      {
        AppMethodBeat.i(133504);
        paramAnonymousArrayList = g.this.bD(paramAnonymousArrayList);
        AppMethodBeat.o(133504);
        return paramAnonymousArrayList;
      }
      
      public final a hCa()
      {
        AppMethodBeat.i(133503);
        a locala = g.this.hCc();
        AppMethodBeat.o(133503);
        return locala;
      }
    });
    if (paramInt != 0) {
      this.VKd.asX(paramInt);
    }
    if (!paramBoolean) {
      getCount();
    }
  }
  
  public abstract ArrayList<T> bD(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.VKd.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.VKd.close();
    this.VKd = null;
  }
  
  public final boolean eh(Object paramObject)
  {
    return this.VKd.eh(paramObject);
  }
  
  public final int getCount()
  {
    return this.VKd.getCount();
  }
  
  public final SparseArray<K>[] hBN()
  {
    return this.VKd.hBN();
  }
  
  public final boolean hBP()
  {
    return this.VKd.hBP();
  }
  
  public abstract T hCc();
  
  public final boolean isClosed()
  {
    return this.VKd.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.g
 * JD-Core Version:    0.7.0.1
 */