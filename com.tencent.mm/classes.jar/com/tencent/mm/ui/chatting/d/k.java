package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.m;
import java.util.HashSet;
import java.util.Iterator;

public final class k
  implements j, m
{
  private HashSet<m> PnY;
  
  public k()
  {
    AppMethodBeat.i(35179);
    this.PnY = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(35180);
    if (!this.PnY.contains(paramm)) {
      this.PnY.add(paramm);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(35181);
    this.PnY.remove(paramm);
    AppMethodBeat.o(35181);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cFx();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cFy();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.gIk();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.gIl();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.gIm();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.gIn();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.PnY).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.gIo();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k
 * JD-Core Version:    0.7.0.1
 */