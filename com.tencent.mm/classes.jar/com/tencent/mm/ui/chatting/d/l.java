package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.n;
import java.util.HashSet;
import java.util.Iterator;

public final class l
  implements j, n
{
  private HashSet<n> WIl;
  
  public l()
  {
    AppMethodBeat.i(35179);
    this.WIl = new HashSet();
    AppMethodBeat.o(35179);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(35180);
    if (!this.WIl.contains(paramn)) {
      this.WIl.add(paramn);
    }
    AppMethodBeat.o(35180);
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(35181);
    this.WIl.remove(paramn);
    AppMethodBeat.o(35181);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35182);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGU();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35182);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35183);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGV();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35183);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35184);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGW();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35184);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35185);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGX();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35185);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35186);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGY();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35186);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35187);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hGZ();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35187);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(35188);
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.WIl).iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      long l2 = System.currentTimeMillis();
      localn.hHa();
      long l3 = System.currentTimeMillis();
      if (Log.getLogLevel() == 0) {
        Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { localn.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
      }
    }
    Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(35188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.l
 * JD-Core Version:    0.7.0.1
 */