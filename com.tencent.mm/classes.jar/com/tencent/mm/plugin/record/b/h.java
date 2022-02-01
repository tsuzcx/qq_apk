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

public abstract class h<T extends c>
  implements b
{
  private boolean van = false;
  final int vao = 3;
  private final int vap = 300000;
  private SparseArray<h<T>.a> vaq = new SparseArray();
  private LinkedList<T> var = new LinkedList();
  private long vas = 0L;
  
  protected abstract List<T> dgh();
  
  protected final void dgi()
  {
    this.van = false;
    run();
  }
  
  public final void finish()
  {
    this.var.clear();
    this.vaq.clear();
    this.van = false;
  }
  
  public final void run()
  {
    g.afC();
    g.afE().ax(new Runnable()
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
    int hUz;
    long vau;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.vau = SystemClock.elapsedRealtime();
      this.hUz = h.this.vao;
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.h
 * JD-Core Version:    0.7.0.1
 */