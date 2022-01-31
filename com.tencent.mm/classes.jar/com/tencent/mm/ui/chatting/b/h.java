package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.m;
import java.util.HashSet;
import java.util.Iterator;

public final class h
  implements f, m
{
  private HashSet<m> vpn = new HashSet();
  
  public final void a(m paramm)
  {
    if (!this.vpn.contains(paramm)) {
      this.vpn.add(paramm);
    }
  }
  
  public final void b(m paramm)
  {
    this.vpn.remove(paramm);
  }
  
  public final void cyM()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyM();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyN()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyN();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyO()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyO();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyP()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyP();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyQ()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyQ();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyR()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyR();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void cyS()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = new HashSet(this.vpn).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      long l2 = System.currentTimeMillis();
      localm.cyS();
      long l3 = System.currentTimeMillis();
      y.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", new Object[] { localm.getClass().getSimpleName(), Long.valueOf(l3 - l2) });
    }
    y.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.h
 * JD-Core Version:    0.7.0.1
 */