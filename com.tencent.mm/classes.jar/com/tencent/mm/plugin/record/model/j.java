package com.tencent.mm.plugin.record.model;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;
import java.util.List;

public abstract class j<T extends c>
  implements b
{
  private boolean NAq = false;
  private final int NAr = 3;
  private final int NAs = 300000;
  private SparseArray<j<T>.a> NAt = new SparseArray();
  private LinkedList<T> NAu = new LinkedList();
  private long NAv = 0L;
  
  public void b(c paramc)
  {
    if (paramc != null)
    {
      this.NAu.remove(paramc);
      this.NAt.remove(paramc.getKey());
      gGk();
    }
  }
  
  public final void finish()
  {
    this.NAu.clear();
    this.NAt.clear();
    this.NAq = false;
  }
  
  protected abstract List<T> gGj();
  
  protected final void gGk()
  {
    this.NAq = false;
    run();
  }
  
  public final void run()
  {
    h.baF();
    h.baH().postToWorker(new j.1(this));
  }
  
  final class a
  {
    long NAx;
    int pBg;
    
    private a()
    {
      AppMethodBeat.i(9490);
      this.NAx = SystemClock.elapsedRealtime();
      this.pBg = j.a(j.this);
      AppMethodBeat.o(9490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.j
 * JD-Core Version:    0.7.0.1
 */