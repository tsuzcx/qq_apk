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
      Krv = new a("ACTION_TOP", 0);
      Krw = new a("ACTION_BOTTOM", 1);
      Krx = new a("ACTION_UPDATE", 2);
      Kry = new a("ACTION_ENTER", 3);
      Krz = new a("ACTION_POSITION", 4);
      KrA = new a("ACTION_UN_KNOW", 5);
      KrB = new a[] { Krv, Krw, Krx, Kry, Krz, KrA };
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
    public Bundle KrC;
    public d.a KrD;
    public List<T> KrE;
    public int KrF;
    public SparseArray<T> KrG;
    public int fVS;
    public AtomicBoolean hQr;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.hQr = paramAtomicBoolean;
      this.KrD = parama;
      this.KrE = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.KrC + ", mode=" + this.KrD + ", selection=" + this.selection + ", count=" + this.KrF + ", totalCount=" + this.fVS + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d
 * JD-Core Version:    0.7.0.1
 */