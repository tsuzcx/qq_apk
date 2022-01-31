package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import navsns.RttRequest;
import navsns.user_login_t;

public class ix
  extends Thread
{
  private ik a;
  private jd b;
  private boolean c;
  private boolean d;
  private boolean e;
  private List<Object> f;
  
  public ix(ik paramik, jd paramjd)
  {
    AppMethodBeat.i(148660);
    this.a = null;
    this.b = null;
    this.c = true;
    this.d = false;
    this.e = false;
    this.a = paramik;
    this.b = paramjd;
    this.f = new ArrayList();
    AppMethodBeat.o(148660);
  }
  
  private ix.a a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148669);
    paramDouble1 = (180.0D + paramDouble1) / 360.0D;
    paramDouble2 = Math.sin(3.1415926D * paramDouble2 / 180.0D);
    paramDouble2 = (180.0D - Math.log((1.0D + paramDouble2) / (1.0D - paramDouble2)) * 180.0D / 6.2831852D) / 360.0D;
    ix.a locala = new ix.a(this, null);
    locala.a = ((int)(paramDouble1 * 268435456.0D + 0.5D));
    locala.b = ((int)(0.5D + paramDouble2 * 268435456.0D));
    AppMethodBeat.o(148669);
    return locala;
  }
  
  private byte[] a(RttRequest paramRttRequest)
  {
    AppMethodBeat.i(148667);
    user_login_t localuser_login_t = new user_login_t();
    localuser_login_t.pf = "android_sdk";
    localuser_login_t.is_login = false;
    localuser_login_t.channel = ka.c;
    localuser_login_t.imei = ka.a();
    e locale = new e();
    locale.c("rttserverex");
    locale.d("getRtt");
    locale.a("info", localuser_login_t);
    locale.a("req", paramRttRequest);
    paramRttRequest = locale.a();
    AppMethodBeat.o(148667);
    return paramRttRequest;
  }
  
  private void d()
  {
    AppMethodBeat.i(148665);
    if (this.a == null)
    {
      AppMethodBeat.o(148665);
      return;
    }
    e();
    byte[] arrayOfByte = f();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      this.a.i().a(arrayOfByte, arrayOfByte.length, true, false);
    }
    AppMethodBeat.o(148665);
  }
  
  private void e()
  {
    AppMethodBeat.i(99896);
    int i = this.a.a().m();
    Object localObject = this.a.a().y();
    double d1 = ((Rect)localObject).left / 1000000.0F;
    double d2 = ((Rect)localObject).bottom / 1000000.0F;
    double d3 = ((Rect)localObject).right / 1000000.0F;
    double d4 = ((Rect)localObject).top / 1000000.0F;
    localObject = a(d1, d2);
    ix.a locala = a(d3, d4);
    this.a.i().a(i, Math.min(((ix.a)localObject).a, locala.a), Math.min(((ix.a)localObject).b, locala.b), Math.max(locala.a, ((ix.a)localObject).a), Math.max(locala.b, ((ix.a)localObject).b));
    AppMethodBeat.o(99896);
  }
  
  private byte[] f()
  {
    AppMethodBeat.i(148666);
    if (this.a == null)
    {
      AppMethodBeat.o(148666);
      return null;
    }
    Object localObject = g();
    if (localObject == null)
    {
      AppMethodBeat.o(148666);
      return null;
    }
    localObject = this.b.a(a((RttRequest)localObject));
    AppMethodBeat.o(148666);
    return localObject;
  }
  
  private RttRequest g()
  {
    AppMethodBeat.i(148668);
    if (this.a == null)
    {
      AppMethodBeat.o(148668);
      return null;
    }
    TrafficRequestItem[] arrayOfTrafficRequestItem = this.a.i().h();
    if ((arrayOfTrafficRequestItem == null) || (arrayOfTrafficRequestItem.length == 0))
    {
      AppMethodBeat.o(148668);
      return null;
    }
    RttRequest localRttRequest = new RttRequest();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfTrafficRequestItem.length;
    int i = 0;
    while (i < j)
    {
      TrafficRequestItem localTrafficRequestItem = arrayOfTrafficRequestItem[i];
      localArrayList.add(Integer.valueOf(localTrafficRequestItem.left));
      localArrayList.add(Integer.valueOf(localTrafficRequestItem.top));
      localArrayList.add(Integer.valueOf(localTrafficRequestItem.right));
      localArrayList.add(Integer.valueOf(localTrafficRequestItem.bottom));
      localArrayList.add(Integer.valueOf(localTrafficRequestItem.timestamp));
      i += 1;
    }
    localRttRequest.bounds = localArrayList;
    localRttRequest.zip = 1;
    localRttRequest.zoom = ((short)arrayOfTrafficRequestItem[0].level);
    AppMethodBeat.o(148668);
    return localRttRequest;
  }
  
  public void a()
  {
    AppMethodBeat.i(148662);
    this.d = true;
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(148662);
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(148663);
    this.d = false;
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(148663);
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(148664);
    this.e = true;
    try
    {
      notify();
      interrupt();
      AppMethodBeat.o(148664);
      return;
    }
    finally
    {
      AppMethodBeat.o(148664);
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(148661);
    super.run();
    if (!this.e) {
      if (!this.d)
      {
        if (this.a == null)
        {
          AppMethodBeat.o(148661);
          return;
        }
        d();
        this.a.w();
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          try
          {
            if (!this.c) {
              break label90;
            }
            wait(500L);
            this.c = false;
            break;
          }
          finally
          {
            AppMethodBeat.o(148661);
          }
        }
        AppMethodBeat.o(148661);
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label90:
      wait(30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ix
 * JD-Core Version:    0.7.0.1
 */