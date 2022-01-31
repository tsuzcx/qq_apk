package com.tencent.mm.sdk.g.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class d$a
  implements a
{
  int cgb;
  String name;
  List<al> ytr;
  AtomicInteger yts;
  
  public d$a(String paramString, int paramInt)
  {
    AppMethodBeat.i(52693);
    this.ytr = new ArrayList();
    this.yts = new AtomicInteger(0);
    this.cgb = paramInt;
    this.name = paramString;
    reset();
    AppMethodBeat.o(52693);
  }
  
  private void duJ()
  {
    AppMethodBeat.i(52699);
    if (this.yts.incrementAndGet() >= this.cgb) {
      this.yts.set(0);
    }
    AppMethodBeat.o(52699);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(52698);
    ((al)this.ytr.get(this.yts.get())).ac(paramRunnable);
    duJ();
    AppMethodBeat.o(52698);
  }
  
  public final int getCorePoolSize()
  {
    return this.cgb;
  }
  
  public final void r(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(52697);
    ((al)this.ytr.get(this.yts.get())).o(paramRunnable, paramLong);
    duJ();
    AppMethodBeat.o(52697);
  }
  
  public final boolean remove(Runnable paramRunnable)
  {
    AppMethodBeat.i(52694);
    Iterator localIterator = this.ytr.iterator();
    while (localIterator.hasNext()) {
      ((al)localIterator.next()).caB().removeCallbacks(paramRunnable);
    }
    AppMethodBeat.o(52694);
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(52696);
    this.ytr.clear();
    int i = 0;
    while (i < this.cgb)
    {
      this.ytr.add(new al(this.name + i));
      i += 1;
    }
    AppMethodBeat.o(52696);
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(52695);
    Iterator localIterator = this.ytr.iterator();
    while (localIterator.hasNext()) {
      ((al)localIterator.next()).oNc.quit();
    }
    AppMethodBeat.o(52695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.g.c.d.a
 * JD-Core Version:    0.7.0.1
 */