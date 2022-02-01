package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.api.l;
import com.tencent.mm.ui.o;
import java.util.HashSet;
import java.util.Iterator;

public final class m
  implements l, o
{
  private HashSet<o> aeqr;
  
  public m()
  {
    AppMethodBeat.i(35179);
    this.aeqr = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(35180);
    if (!this.aeqr.contains(paramo)) {
      this.aeqr.add(paramo);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(35181);
    this.aeqr.remove(paramo);
    AppMethodBeat.o(35181);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjf();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjg();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjh();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jji();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjj();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjk();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.aeqr).iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      long l2 = System.currentTimeMillis();
      localo.jjl();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { localo.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.m
 * JD-Core Version:    0.7.0.1
 */