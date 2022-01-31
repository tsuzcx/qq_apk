package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

public class dz
{
  private static volatile boolean a = false;
  
  public static void a(ea paramea)
  {
    boolean bool1 = true;
    int m = 0;
    try
    {
      bool2 = a;
      if (bool2) {
        return;
      }
      System.currentTimeMillis();
      SystemClock.elapsedRealtime();
      if (paramea == null) {
        throw new eb("initParam null");
      }
    }
    finally {}
    Object localObject = paramea.a().getPackageName();
    String str = hn.a(paramea.a());
    boolean bool2 = paramea.f();
    int k = paramea.g();
    if (paramea.d()) {}
    for (int i = paramea.e(); i <= 0; i = hn.a(paramea.a(), (String)localObject)) {
      throw new eb("appid illegal:" + i);
    }
    if ((bool2) && (k <= 0)) {
      throw new eb("testAppid illegal:" + k);
    }
    int j = m;
    if (!paramea.d())
    {
      hn.a locala = hn.a(i, paramea.a(), (String)localObject, "com.tencent.halley.common.platform.service.PlatformService");
      if (locala == null) {
        throw new eb("need set PlatformService in manifest for halley");
      }
      if ((locala.d != null) && (locala.a != null))
      {
        if (!locala.d.equals(locala.a)) {
          em.f = bool1;
        }
      }
      else
      {
        if (locala.c) {
          throw new eb("need set PlatformService exported to false");
        }
        if (!locala.b) {
          throw new eb("need set PlatformService enabled to true");
        }
        localObject = hn.a(i, paramea.a(), (String)localObject, "com.tencent.halley.common.platform.service.ActivateService");
        j = m;
        if (localObject == null) {
          break label412;
        }
        if (!((hn.a)localObject).c) {
          throw new eb("need set ActivateService exported to true");
        }
        if (((hn.a)localObject).e == null) {
          throw new eb("need set security_version for ActivateService");
        }
        m = ((hn.a)localObject).e.getInt("security_version");
        j = m;
        if (m > 0) {
          break label412;
        }
        throw new eb("need set valid security_version for ActivateService");
      }
    }
    for (;;)
    {
      label366:
      em.a(bool2, i, paramea, str, j);
      eq.a();
      ey.a.a(paramea.h());
      hj.d().g();
      a = true;
      SystemClock.elapsedRealtime();
      break;
      label412:
      do
      {
        break label366;
        bool1 = false;
        break;
      } while (!bool2);
      i = k;
    }
  }
  
  public static ed b(ea paramea)
  {
    if (!a) {
      a(paramea);
    }
    return eg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dz
 * JD-Core Version:    0.7.0.1
 */