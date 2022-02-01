package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class i
  implements h, l
{
  private HashSet<l> HTj;
  
  public i()
  {
    AppMethodBeat.i(35179);
    this.HTj = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(35180);
    if (!this.HTj.contains(paraml)) {
      this.HTj.add(paraml);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(35181);
    this.HTj.remove(paraml);
    AppMethodBeat.o(35181);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgg();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgh();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgi();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgj();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgk();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgl();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.HTj).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fgm();
      long l3 = System.currentTimeMillis();
      if (ac.getLogLevel() == 0) {
        ac.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ac.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.i
 * JD-Core Version:    0.7.0.1
 */