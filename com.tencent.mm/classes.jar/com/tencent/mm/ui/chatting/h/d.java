package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.n.e;
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
      JVd = new a("ACTION_TOP", 0);
      JVe = new a("ACTION_BOTTOM", 1);
      JVf = new a("ACTION_UPDATE", 2);
      JVg = new a("ACTION_ENTER", 3);
      JVh = new a("ACTION_POSITION", 4);
      JVi = new a("ACTION_UN_KNOW", 5);
      JVj = new a[] { JVd, JVe, JVf, JVg, JVh, JVi };
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
    public Bundle JVk;
    public d.a JVl;
    public List<T> JVm;
    public int JVn;
    public SparseArray<T> JVo;
    public int fTM;
    public AtomicBoolean hNy;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.hNy = paramAtomicBoolean;
      this.JVl = parama;
      this.JVm = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.JVk + ", mode=" + this.JVl + ", selection=" + this.selection + ", count=" + this.JVn + ", totalCount=" + this.fTM + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d
 * JD-Core Version:    0.7.0.1
 */