package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.k.g;
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
      aeHQ = new a("ACTION_TOP", 0);
      aeHR = new a("ACTION_BOTTOM", 1);
      aeHS = new a("ACTION_UPDATE", 2);
      aeHT = new a("ACTION_ENTER", 3);
      aeHU = new a("ACTION_POSITION", 4);
      aeHV = new a("ACTION_UN_KNOW", 5);
      aeHW = new a[] { aeHQ, aeHR, aeHS, aeHT, aeHU, aeHV };
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
    public Bundle aeHX;
    public d.a aeHY;
    public List<T> aeHZ;
    public int aeIa;
    public SparseArray<T> aeIb;
    public int lNX;
    public AtomicBoolean otq;
    public int selection;
    
    d(d.a parama, AtomicBoolean paramAtomicBoolean)
    {
      AppMethodBeat.i(179939);
      this.selection = -1;
      this.otq = paramAtomicBoolean;
      this.aeHY = parama;
      this.aeHZ = new LinkedList();
      AppMethodBeat.o(179939);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(36425);
      String str = "LoadedResult{sourceArgs=" + this.aeHX + ", mode=" + this.aeHY + ", selection=" + this.selection + ", count=" + this.aeIa + ", totalCount=" + this.lNX + '}';
      AppMethodBeat.o(36425);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.d
 * JD-Core Version:    0.7.0.1
 */