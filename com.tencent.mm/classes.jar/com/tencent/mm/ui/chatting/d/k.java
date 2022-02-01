package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class k
  implements j, l
{
  private HashSet<l> KcA;
  
  public k()
  {
    AppMethodBeat.i(35179);
    this.KcA = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(35180);
    if (!this.KcA.contains(paraml)) {
      this.KcA.add(paraml);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(35181);
    this.KcA.remove(paraml);
    AppMethodBeat.o(35181);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAs();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAt();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAu();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAv();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAw();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAx();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.KcA).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fAy();
      long l3 = System.currentTimeMillis();
      if (ae.getLogLevel() == 0) {
        ae.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ae.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k
 * JD-Core Version:    0.7.0.1
 */