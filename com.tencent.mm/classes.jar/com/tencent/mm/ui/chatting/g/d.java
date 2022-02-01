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
      GEU = new a("ACTION_TOP", 0);
      GEV = new a("ACTION_BOTTOM", 1);
      GEW = new a("ACTION_UPDATE", 2);
      GEX = new a("ACTION_ENTER", 3);
      GEY = new a("ACTION_POSITION", 4);
      GEZ = new a("ACTION_UN_KNOW", 5);
      GFa = new a[] { GEU, GEV, GEW, GEX, GEY, GEZ };
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
    public Bundle GFb;
    public d.a GFc;
    public List<T> GFd;
    public int GFe;
    public SparseArray<T> GFf;
    public int fwP;
    public AtomicBoolean gUH;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.gUH = paramAtomicBoolean;
      this.GFc = parama;
      this.GFd = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.GFb + ", mode=" + this.GFc + ", selection=" + this.selection + ", count=" + this.GFe + ", totalCount=" + this.fwP + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.d
 * JD-Core Version:    0.7.0.1
 */