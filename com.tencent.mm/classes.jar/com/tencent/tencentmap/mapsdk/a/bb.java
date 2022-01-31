package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.atomic.AtomicInteger;

public class bb
{
  private AtomicInteger a;
  private AtomicInteger b;
  
  public bg a(az paramaz, am paramam)
  {
    Object localObject;
    if (paramam.a(2)) {
      localObject = c(paramaz, paramam);
    }
    bg localbg;
    do
    {
      return localObject;
      localbg = b(paramaz, paramam);
      localObject = localbg;
    } while (localbg != null);
    return a(paramaz, paramam);
  }
  
  public bg a(nr paramnr, am paramam)
  {
    if (paramnr.a(0))
    {
      paramnr = paramnr.a(0, this.a.incrementAndGet());
      if (paramnr != null) {
        return paramnr;
      }
    }
    return null;
  }
  
  public bg b(az paramaz, am paramam)
  {
    if (paramam.a(1))
    {
      paramam = paramaz.a(0, paramam.b());
      if (paramam != null) {
        return paramam;
      }
      bc.a(paramaz.j + " do not have active service in getHashSelect hash invoke");
    }
    return null;
  }
  
  public bg c(az paramaz, am paramam)
  {
    if (paramam.a(2))
    {
      if (!paramaz.a(paramam.c())) {
        break label153;
      }
      if (paramam.b() != -1) {
        break label102;
      }
      paramaz = paramaz.a(paramam.c(), this.b.incrementAndGet());
      if (paramaz != null)
      {
        paramam = paramaz;
        return paramam;
      }
      bc.a(paramam.a() + " get gridActiveServices " + paramam.c() + " is null");
    }
    label102:
    while (!paramaz.d()) {
      for (;;)
      {
        return null;
        bg localbg = paramaz.a(paramam.c(), paramam.b());
        paramam = localbg;
        if (localbg == null) {
          bc.a(paramaz.j + " do not have active service in getGridSelect hash invoke");
        }
      }
    }
    label153:
    throw new bq("gridValue is " + paramam.c() + ", but no gridService can use");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bb
 * JD-Core Version:    0.7.0.1
 */