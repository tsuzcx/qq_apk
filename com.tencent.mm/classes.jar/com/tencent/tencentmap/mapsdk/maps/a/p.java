package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
{
  private static volatile boolean a = false;
  
  public static void a(q paramq)
  {
    boolean bool1 = true;
    int m = 0;
    try
    {
      AppMethodBeat.i(149612);
      if (a)
      {
        AppMethodBeat.o(149612);
        return;
      }
      System.currentTimeMillis();
      SystemClock.elapsedRealtime();
      if (paramq == null)
      {
        paramq = new r("initParam null");
        AppMethodBeat.o(149612);
        throw paramq;
      }
    }
    finally {}
    Object localObject = paramq.a().getPackageName();
    String str = da.a(paramq.a());
    boolean bool2 = paramq.f();
    int k = paramq.g();
    if (paramq.d()) {}
    for (int i = paramq.e(); i <= 0; i = da.a(paramq.a(), (String)localObject))
    {
      paramq = new r("appid illegal:".concat(String.valueOf(i)));
      AppMethodBeat.o(149612);
      throw paramq;
    }
    if ((bool2) && (k <= 0))
    {
      paramq = new r("testAppid illegal:".concat(String.valueOf(k)));
      AppMethodBeat.o(149612);
      throw paramq;
    }
    int j = m;
    if (!paramq.d())
    {
      da.a locala = da.a(i, paramq.a(), (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
      if (locala == null)
      {
        paramq = new r("need set PlatformService in manifest for halley");
        AppMethodBeat.o(149612);
        throw paramq;
      }
      if ((locala.d != null) && (locala.a != null))
      {
        if (!locala.d.equals(locala.a)) {
          ac.f = bool1;
        }
      }
      else
      {
        if (locala.c)
        {
          paramq = new r("need set PlatformService exported to false");
          AppMethodBeat.o(149612);
          throw paramq;
        }
        if (!locala.b)
        {
          paramq = new r("need set PlatformService enabled to true");
          AppMethodBeat.o(149612);
          throw paramq;
        }
        localObject = da.a(i, paramq.a(), (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
        j = m;
        if (localObject == null) {
          break label472;
        }
        if (!((da.a)localObject).c)
        {
          paramq = new r("need set ActivateService exported to true");
          AppMethodBeat.o(149612);
          throw paramq;
        }
        if (((da.a)localObject).e == null)
        {
          paramq = new r("need set security_version for ActivateService");
          AppMethodBeat.o(149612);
          throw paramq;
        }
        m = ((da.a)localObject).e.getInt("security_version");
        j = m;
        if (m > 0) {
          break label472;
        }
        paramq = new r("need set valid security_version for ActivateService");
        AppMethodBeat.o(149612);
        throw paramq;
      }
    }
    for (;;)
    {
      label421:
      ac.a(bool2, i, paramq, str, j);
      af.a();
      an.a.a(paramq.h());
      cw.d().g();
      a = true;
      SystemClock.elapsedRealtime();
      AppMethodBeat.o(149612);
      break;
      label472:
      do
      {
        break label421;
        bool1 = false;
        break;
      } while (!bool2);
      i = k;
    }
  }
  
  public static t b(q paramq)
  {
    AppMethodBeat.i(149613);
    if (!a) {
      a(paramq);
    }
    paramq = w.a();
    AppMethodBeat.o(149613);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.p
 * JD-Core Version:    0.7.0.1
 */