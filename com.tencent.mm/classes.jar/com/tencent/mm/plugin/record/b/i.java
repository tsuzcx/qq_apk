package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.LinkedList;
import java.util.List;

public abstract class i<T extends c>
  implements b
{
  private boolean xGJ = false;
  final int xGK = 3;
  private final int xGL = 300000;
  private SparseArray<i<T>.a> xGM = new SparseArray();
  private LinkedList<T> xGN = new LinkedList();
  private long xGO = 0L;
  
  protected abstract List<T> dHC();
  
  protected final void dHD()
  {
    this.xGJ = false;
    run();
  }
  
  public final void finish()
  {
    this.xGN.clear();
    this.xGM.clear();
    this.xGJ = false;
  }
  
  public final void run()
  {
    g.ajS();
    g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9488);
        i.a(i.this);
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
    int iQA;
    long xGQ;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.xGQ = SystemClock.elapsedRealtime();
      this.iQA = i.this.xGK;
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */