package com.tencent.mm.ui.chatting.h;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.n.f;
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
      PDD = new a("ACTION_TOP", 0);
      PDE = new a("ACTION_BOTTOM", 1);
      PDF = new a("ACTION_UPDATE", 2);
      PDG = new a("ACTION_ENTER", 3);
      PDH = new a("ACTION_POSITION", 4);
      PDI = new a("ACTION_UN_KNOW", 5);
      PDJ = new a[] { PDD, PDE, PDF, PDG, PDH, PDI };
      AppMethodBeat.o(36423);
    }
    
    private a() {}
  }
  
  public static abstract interface c<T>
  {
    public abstract f b(d.d<T> paramd);
    
    public abstract void c(d.d<T> paramd);
  }
  
  public static final class d<T>
  {
    public Bundle PDK;
    public d.a PDL;
    public List<T> PDM;
    public int PDN;
    public SparseArray<T> PDO;
    public int gAZ;
    public AtomicBoolean iLz;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.iLz = paramAtomicBoolean;
      this.PDL = parama;
      this.PDM = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.PDK + ", mode=" + this.PDL + ", selection=" + this.selection + ", count=" + this.PDN + ", totalCount=" + this.gAZ + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d
 * JD-Core Version:    0.7.0.1
 */