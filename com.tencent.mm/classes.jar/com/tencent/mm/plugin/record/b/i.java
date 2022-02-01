package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;
import java.util.List;

public abstract class i<T extends c>
  implements b
{
  private boolean BGI = false;
  final int BGJ = 3;
  private final int BGK = 300000;
  private SparseArray<i<T>.a> BGL = new SparseArray();
  private LinkedList<T> BGM = new LinkedList();
  private long BGN = 0L;
  
  protected abstract List<T> eIp();
  
  protected final void eIq()
  {
    this.BGI = false;
    run();
  }
  
  public final void finish()
  {
    this.BGM.clear();
    this.BGL.clear();
    this.BGI = false;
  }
  
  public final void run()
  {
    g.aAi();
    g.aAk().postToWorker(new Runnable()
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
    long BGP;
    int jNv;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.BGP = SystemClock.elapsedRealtime();
      this.jNv = i.this.BGJ;
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */