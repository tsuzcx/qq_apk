package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;

public abstract class h<T extends c>
  implements b
{
  private boolean pYu = false;
  final int pYv = 3;
  private final int pYw = 300000;
  private SparseArray<h<T>.a> pYx = new SparseArray();
  private LinkedList<T> pYy = new LinkedList();
  private long pYz = 0L;
  
  protected abstract List<T> cfR();
  
  protected final void cfS()
  {
    this.pYu = false;
    run();
  }
  
  public final void finish()
  {
    this.pYy.clear();
    this.pYx.clear();
    this.pYu = false;
  }
  
  public final void run()
  {
    g.RM();
    g.RO().ac(new h.1(this));
  }
  
  final class a
  {
    int gjM;
    long pYB;
    
    private a()
    {
      AppMethodBeat.i(135668);
      this.pYB = SystemClock.elapsedRealtime();
      this.gjM = h.this.pYv;
      AppMethodBeat.o(135668);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */