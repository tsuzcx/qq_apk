package com.tencent.mm.ui.chatting.g;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.m.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface d
{
  public abstract void a(a parama, boolean paramBoolean, c paramc);
  
  public abstract void cancel();
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(36423);
      IeQ = new a("ACTION_TOP", 0);
      IeR = new a("ACTION_BOTTOM", 1);
      IeS = new a("ACTION_UPDATE", 2);
      IeT = new a("ACTION_ENTER", 3);
      IeU = new a("ACTION_POSITION", 4);
      IeV = new a("ACTION_UN_KNOW", 5);
      IeW = new a[] { IeQ, IeR, IeS, IeT, IeU, IeV };
      AppMethodBeat.o(36423);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void next();
  }
  
  public static abstract interface c<T>
  {
    public abstract e b(d.d<T> paramd);
    
    public abstract void c(d.d<T> paramd);
  }
  
  public static final class d<T>
  {
    public Bundle IeX;
    public d.a IeY;
    public List<T> IeZ;
    public int Ifa;
    public SparseArray<T> Ifb;
    public int fAw;
    public AtomicBoolean hvg;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.hvg = paramAtomicBoolean;
      this.IeY = parama;
      this.IeZ = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.IeX + ", mode=" + this.IeY + ", selection=" + this.selection + ", count=" + this.Ifa + ", totalCount=" + this.fAw + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.d
 * JD-Core Version:    0.7.0.1
 */