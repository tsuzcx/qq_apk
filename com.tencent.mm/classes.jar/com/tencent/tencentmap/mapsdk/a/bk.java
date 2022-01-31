package com.tencent.tencentmap.mapsdk.a;

import com.qq.navi.Session;
import com.qq.sim.Millis100TimeProvider;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class bk
{
  volatile Session a = new Session();
  private Semaphore b;
  private bg c;
  private String d;
  private bj e;
  private cd<Integer, at> f;
  private AtomicBoolean g;
  
  public bk(bj parambj, bg parambg, cd<Integer, at> paramcd)
  {
    this.e = parambj;
    this.c = parambg;
    this.d = this.c.a();
    if (parambj.g.d() > 0) {
      this.b = new Semaphore(parambj.g.d());
    }
    this.g = new AtomicBoolean(false);
    this.f = paramcd;
  }
  
  protected Session a(ar paramar)
  {
    Session localSession = b();
    if ((localSession == null) || (!localSession.isOpen())) {
      throw new bp(this.c, paramar, localSession);
    }
    return localSession;
  }
  
  protected void a()
  {
    b();
    if (this.a.isOpen())
    {
      this.e.b(this);
      return;
    }
    this.e.a(this);
  }
  
  public void a(lu paramlu, int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      ap.a().b(this.e.e).a(paramlu, paramLong, paramInt);
    }
    bl.a(this.e, this.c, paramInt);
  }
  
  protected Session b()
  {
    if (this.a.isOpen()) {
      return this.a;
    }
    if (this.g.compareAndSet(false, true))
    {
      this.e.c.a(this.c, this);
      bc.a(this + " getNextEndPoint wait 500");
      synchronized (this.g)
      {
        try
        {
          this.g.wait(500L);
          return this.a;
        }
        catch (InterruptedException localInterruptedException1)
        {
          for (;;)
          {
            bc.b(this + " getNextEndPoint wait was Interrupted in " + this);
          }
        }
      }
    }
    if (this.a.isOpen()) {
      return this.a;
    }
    bc.a(this + " getNextEndPoint wait 500 for others is connecting");
    synchronized (this.g)
    {
      try
      {
        this.g.wait(500L);
        return this.a;
      }
      catch (InterruptedException localInterruptedException2)
      {
        for (;;)
        {
          bc.b(this + " getNextEndPoint wait was Interrupted in " + this);
        }
      }
    }
  }
  
  protected void b(ar paramar)
  {
    paramar.e().c(this.c.b);
    paramar.e().a(this.c.b());
    paramar.e().d(d().a());
    lu locallu = cb.a(this.e.b, paramar.d().e, paramar.d().f, "", this.c.b, this.c.b(), 0, this.e.g.h(), this.e.g.g(), this.e.g.h(), this.c.h());
    ap.a().a(this.e.e);
    ap.a().a(this.e.e, this.c.b, this.e.b, paramar);
    try
    {
      Session localSession = a(paramar);
      Object localObject = new nl(0);
      paramar.d().writeTo((nl)localObject);
      localObject = nn.a(((nl)localObject).a());
      localObject = be.a(true, paramar.e().h(), (byte[])localObject);
      if (paramar.f()) {
        bh.a(paramar.e().h(), paramar.e(), this.f);
      }
      paramar.e().a(localSession.getID());
      localSession.write(localObject);
      if (!paramar.f()) {
        a(locallu, 0, Millis100TimeProvider.INSTANCE.currentTimeMillis() - paramar.e().i(), "sendMsg", true);
      }
      return;
    }
    catch (bp localbp)
    {
      a(locallu, 3, Millis100TimeProvider.INSTANCE.currentTimeMillis() - paramar.e().i(), "sendMsg", true);
      throw localbp;
    }
  }
  
  public void c()
  {
    try
    {
      bc.a(this + " call close all, try to close conn ");
      if (this.a.isOpen()) {
        this.a.close(true);
      }
      return;
    }
    catch (Exception localException)
    {
      bc.b(this + " closeAll session error", localException);
    }
  }
  
  public bg d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "EndPoint(ID=" + this.a.getID() + " " + this.c + ") ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bk
 * JD-Core Version:    0.7.0.1
 */