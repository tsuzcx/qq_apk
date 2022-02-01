package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.LinkedList;
import java.util.List;

public abstract class h<T extends c>
  implements b
{
  private boolean wjb = false;
  final int wjc = 3;
  private final int wjd = 300000;
  private SparseArray<h<T>.a> wje = new SparseArray();
  private LinkedList<T> wjf = new LinkedList();
  private long wjg = 0L;
  
  protected abstract List<T> dtO();
  
  protected final void dtP()
  {
    this.wjb = false;
    run();
  }
  
  public final void finish()
  {
    this.wjf.clear();
    this.wje.clear();
    this.wjb = false;
  }
  
  public final void run()
  {
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9488);
        h.a(h.this);
        AppMethodBeat.o(9488);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(9489);
        String str = super.toString() + "|tryDoJob";
        AppMethodBeat.o(9489);
        return str;
      }
    });
  }
  
  final class a
  {
    int iuD;
    long wji;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.wji = SystemClock.elapsedRealtime();
      this.iuD = h.this.wjc;
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */