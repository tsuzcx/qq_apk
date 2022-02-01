package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.LinkedList;
import java.util.List;

public abstract class i<T extends c>
  implements b
{
  private boolean xqM = false;
  final int xqN = 3;
  private final int xqO = 300000;
  private SparseArray<i<T>.a> xqP = new SparseArray();
  private LinkedList<T> xqQ = new LinkedList();
  private long xqR = 0L;
  
  protected abstract List<T> dEl();
  
  protected final void dEm()
  {
    this.xqM = false;
    run();
  }
  
  public final void finish()
  {
    this.xqQ.clear();
    this.xqP.clear();
    this.xqM = false;
  }
  
  public final void run()
  {
    g.ajD();
    g.ajF().ay(new Runnable()
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
    int iNG;
    long xqT;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.xqT = SystemClock.elapsedRealtime();
      this.iNG = i.this.xqN;
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */