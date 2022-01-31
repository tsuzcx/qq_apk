package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import java.util.Calendar;

public final class a
{
  public c<rb> ptc = new a.1(this);
  public f ptd;
  private long pte;
  long ptf;
  public com.tencent.mm.plugin.sport.a.a ptg;
  private ServiceConnection pth = new a.2(this);
  
  public a()
  {
    this.ptc.cqo();
  }
  
  public final long bLg()
  {
    if (this.pte == 0L) {
      this.pte = i.Q(4, 0L);
    }
    return this.pte;
  }
  
  public final long bLh()
  {
    long l3 = System.currentTimeMillis();
    String str = "";
    if (this.ptg != null) {}
    for (;;)
    {
      try
      {
        l1 = this.ptg.bLd();
        str = "exdevice";
      }
      catch (RemoteException localRemoteException)
      {
        long l2;
        long l4;
        l1 = -1L;
        continue;
      }
      l2 = l1;
      if (l1 == -1L)
      {
        l1 = bk.crX() / 10000L;
        l4 = i.zl(202);
        l2 = i.zl(201);
        if (l4 == l1) {
          str = "mm";
        }
      }
      else
      {
        y.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", new Object[] { str, Long.valueOf(l2), Long.valueOf(System.currentTimeMillis() - l3) });
        return l2;
      }
      str = "unknow";
      l2 = 0L;
      continue;
      long l1 = -1L;
    }
  }
  
  public final void bLi()
  {
    if (n.ej(ae.getContext()))
    {
      if (this.ptg != null)
      {
        y.i("MicroMsg.Sport.DeviceStepManager", "Not need bind");
        return;
      }
      y.i("MicroMsg.Sport.DeviceStepManager", "start to bind sport aidl");
      try
      {
        Intent localIntent1 = new Intent(ae.getContext(), SportService.class);
        localIntent1.setFlags(268435456);
        ae.getContext().bindService(localIntent1, this.pth, 1);
        return;
      }
      catch (Exception localException1)
      {
        return;
      }
    }
    try
    {
      if (this.ptg != null) {
        ae.getContext().unbindService(this.pth);
      }
      Intent localIntent2 = new Intent(ae.getContext(), SportService.class);
      ae.getContext().stopService(localIntent2);
    }
    catch (Exception localException2)
    {
      label105:
      break label105;
    }
    this.ptg = null;
  }
  
  public final boolean gE(long paramLong)
  {
    if (this.ptd != null) {
      g.Dk().c(this.ptd);
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    y.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[] { n.ce(l2), Long.valueOf(paramLong) });
    this.ptd = new f("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), (int)paramLong, bs.cwc(), 1);
    g.Dk().a(this.ptd, 0);
    l1 = System.currentTimeMillis();
    this.ptf = l1;
    i.R(3, l1);
    this.pte = paramLong;
    i.R(4, this.pte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.a
 * JD-Core Version:    0.7.0.1
 */