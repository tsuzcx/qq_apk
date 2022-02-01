package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.o.g;
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
      WYq = new a("ACTION_TOP", 0);
      WYr = new a("ACTION_BOTTOM", 1);
      WYs = new a("ACTION_UPDATE", 2);
      WYt = new a("ACTION_ENTER", 3);
      WYu = new a("ACTION_POSITION", 4);
      WYv = new a("ACTION_UN_KNOW", 5);
      WYw = new a[] { WYq, WYr, WYs, WYt, WYu, WYv };
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
    public abstract g b(d.d<T> paramd);
    
    public abstract void c(d.d<T> paramd);
  }
  
  public static final class d<T>
  {
    public int WYA;
    public SparseArray<T> WYB;
    public Bundle WYx;
    public d.a WYy;
    public List<T> WYz;
    public int jlf;
    public AtomicBoolean lBG;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.lBG = paramAtomicBoolean;
      this.WYy = parama;
      this.WYz = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.WYx + ", mode=" + this.WYy + ", selection=" + this.selection + ", count=" + this.WYA + ", totalCount=" + this.jlf + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d
 * JD-Core Version:    0.7.0.1
 */