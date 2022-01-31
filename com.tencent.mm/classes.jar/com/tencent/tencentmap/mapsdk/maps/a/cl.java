package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class cl
  implements ct, Runnable
{
  private static int a;
  private static cl b;
  private bz c;
  private boolean d;
  private Handler e;
  private Map<String, ch> f;
  private Runnable g;
  private Runnable h;
  private Runnable i;
  private Map<String, cl.a> j;
  
  static
  {
    AppMethodBeat.i(147364);
    a = -1;
    b = new cl();
    AppMethodBeat.o(147364);
  }
  
  private cl()
  {
    AppMethodBeat.i(147351);
    this.d = false;
    this.f = new ConcurrentHashMap();
    this.g = new cp(this);
    this.h = new cr(this);
    this.i = new cs(this);
    this.j = new HashMap();
    AppMethodBeat.o(147351);
  }
  
  private cl.a a(String paramString)
  {
    AppMethodBeat.i(147358);
    Object localObject3;
    if (this.j.isEmpty()) {
      try
      {
        Object localObject1 = da.b("apnrecords", "", true);
        if (!((String)localObject1).isEmpty())
        {
          localObject1 = new JSONObject((String)localObject1);
          localObject3 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!TextUtils.isEmpty(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject(str);
              if (localJSONObject != null)
              {
                cl.a locala = new cl.a(this, (byte)0);
                locala.b = localJSONObject.optInt("lastCode");
                locala.a = localJSONObject.optLong("lastReqTime");
                this.j.put(str, locala);
              }
            }
          }
        }
        localObject3 = (cl.a)this.j.get(paramString);
      }
      catch (Exception localException) {}
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new cl.a(this, (byte)0);
      this.j.put(paramString, localObject2);
    }
    AppMethodBeat.o(147358);
    return localObject2;
  }
  
  private static int c(int paramInt)
  {
    AppMethodBeat.i(147359);
    String str;
    if (paramInt == 0)
    {
      str = "http_platform_update_interval_succ";
      if (paramInt != 0) {
        break label60;
      }
      paramInt = 1800000;
    }
    for (;;)
    {
      paramInt = an.a.a(str, 60000, 3600000, paramInt);
      AppMethodBeat.o(147359);
      return paramInt;
      if ((paramInt == -4) || (paramInt == -3))
      {
        str = "http_platform_update_interval_nonet";
        break;
      }
      str = "http_platform_update_interval_fail";
      break;
      label60:
      if ((paramInt == -4) || (paramInt == -3)) {
        paramInt = 60000;
      } else {
        paramInt = 300000;
      }
    }
  }
  
  public static cl c()
  {
    return b;
  }
  
  public final void a()
  {
    AppMethodBeat.i(147354);
    ((ch)this.f.get("accessscheduler")).a();
    AppMethodBeat.o(147354);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(147356);
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.e.removeCallbacks(this.h);
      this.e.post(this.h);
      AppMethodBeat.o(147356);
      return;
    }
    if ((paramInt == 3) || (paramInt == 4))
    {
      paramInt = an.a.a("detect_platform_update_random_interval", 0, 1440, 10);
      paramInt = new Random().nextInt(paramInt);
      int k = c(0);
      av.a().a(this.g, paramInt * 60 * 1000 + k);
    }
    AppMethodBeat.o(147356);
  }
  
  public final void a(bz parambz)
  {
    AppMethodBeat.i(147352);
    this.c = parambz;
    parambz = new cq();
    this.f.put(parambz.c(), parambz);
    parambz = new cj();
    this.f.put(parambz.c(), parambz);
    parambz = new cm();
    this.f.put(parambz.c(), parambz);
    AppMethodBeat.o(147352);
  }
  
  public final void b()
  {
    AppMethodBeat.i(147355);
    ((ch)this.f.get("settings")).b();
    AppMethodBeat.o(147355);
  }
  
  public final bz d()
  {
    return this.c;
  }
  
  public final void e()
  {
    AppMethodBeat.i(147353);
    this.e = an.a.a("HttpPlatformConnection", 10);
    this.e.post(this);
    this.c.c();
    AppMethodBeat.o(147353);
  }
  
  public final void run()
  {
    AppMethodBeat.i(147357);
    if (an.a.a("http_platform_start_update_on", 0, 1, 0) == 1)
    {
      a = 1;
      this.e.post(this.i);
    }
    AppMethodBeat.o(147357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cl
 * JD-Core Version:    0.7.0.1
 */