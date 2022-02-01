package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;
import java.util.List;

public abstract class i<T extends c>
  implements b
{
  private boolean HCO = false;
  private final int HCP = 3;
  private final int HCQ = 300000;
  private SparseArray<i<T>.a> HCR = new SparseArray();
  private LinkedList<T> HCS = new LinkedList();
  private long HCT = 0L;
  
  public void b(c paramc)
  {
    if (paramc != null)
    {
      this.HCS.remove(paramc);
      this.HCR.remove(paramc.getKey());
      fuv();
    }
  }
  
  public final void finish()
  {
    this.HCS.clear();
    this.HCR.clear();
    this.HCO = false;
  }
  
  protected abstract List<T> fuu();
  
  protected final void fuv()
  {
    this.HCO = false;
    run();
  }
  
  public final void run()
  {
    h.aHH();
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9488);
        i.b(i.this);
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
    long HCV;
    int mED;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.HCV = SystemClock.elapsedRealtime();
      this.mED = i.a(i.this);
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.i
 * JD-Core Version:    0.7.0.1
 */