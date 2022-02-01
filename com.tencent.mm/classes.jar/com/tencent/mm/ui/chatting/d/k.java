package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class k
  implements j, l
{
  private HashSet<l> JHG;
  
  public k()
  {
    AppMethodBeat.i(35179);
    this.JHG = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(35180);
    if (!this.JHG.contains(paraml)) {
      this.JHG.add(paraml);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(35181);
    this.JHG.remove(paraml);
    AppMethodBeat.o(35181);
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fws();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fwt();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fwu();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fwv();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fww();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fwx();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.JHG).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      long l2 = System.currentTimeMillis();
      locall.fwy();
      long l3 = System.currentTimeMillis();
      if (ad.getLogLevel() == 0) {
        ad.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { locall.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    ad.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k
 * JD-Core Version:    0.7.0.1
 */