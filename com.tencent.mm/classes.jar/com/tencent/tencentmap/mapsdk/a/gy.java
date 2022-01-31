package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class gy
  implements hg, Runnable
{
  private static int a = -1;
  private static gy b = new gy();
  private gl c;
  private boolean d = false;
  private Handler e;
  private Map<String, gu> f = new ConcurrentHashMap();
  private Runnable g = new hc(this);
  private Runnable h = new he(this);
  private Runnable i = new hf(this);
  private Map<String, gy.a> j = new HashMap();
  
  private gy.a a(String paramString)
  {
    Object localObject3;
    if (this.j.isEmpty()) {
      try
      {
        Object localObject1 = hn.b("apnrecords", "", true);
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
                gy.a locala = new gy.a(this, (byte)0);
                locala.b = localJSONObject.optInt("lastCode");
                locala.a = localJSONObject.optLong("lastReqTime");
                this.j.put(str, locala);
              }
            }
          }
        }
        localObject3 = (gy.a)this.j.get(paramString);
      }
      catch (Exception localException) {}
    }
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new gy.a(this, (byte)0);
      this.j.put(paramString, localObject2);
    }
    return localObject2;
  }
  
  private static int c(int paramInt)
  {
    String str;
    if (paramInt == 0)
    {
      str = "http_platform_update_interval_succ";
      if (paramInt != 0) {
        break label48;
      }
      paramInt = 1800000;
    }
    for (;;)
    {
      return ey.a.a(str, 60000, 3600000, paramInt);
      if ((paramInt == -4) || (paramInt == -3))
      {
        str = "http_platform_update_interval_nonet";
        break;
      }
      str = "http_platform_update_interval_fail";
      break;
      label48:
      if ((paramInt == -4) || (paramInt == -3)) {
        paramInt = 60000;
      } else {
        paramInt = 300000;
      }
    }
  }
  
  public static gy c()
  {
    return b;
  }
  
  public final void a()
  {
    ((gu)this.f.get("accessscheduler")).a();
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.e.removeCallbacks(this.h);
      this.e.post(this.h);
    }
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    paramInt = ey.a.a("detect_platform_update_random_interval", 0, 1440, 10);
    paramInt = new Random().nextInt(paramInt);
    int k = c(0);
    fg.a().a(this.g, paramInt * 60 * 1000 + k);
  }
  
  public final void a(gl paramgl)
  {
    this.c = paramgl;
    paramgl = new hd();
    this.f.put(paramgl.c(), paramgl);
    paramgl = new gw();
    this.f.put(paramgl.c(), paramgl);
    paramgl = new gz();
    this.f.put(paramgl.c(), paramgl);
  }
  
  public final void b()
  {
    ((gu)this.f.get("settings")).b();
  }
  
  public final gl d()
  {
    return this.c;
  }
  
  public final void e()
  {
    this.e = ey.a.a("HttpPlatformConnection", 10);
    this.e.post(this);
    this.c.c();
  }
  
  public final void run()
  {
    if (ey.a.a("http_platform_start_update_on", 0, 1, 0) == 1)
    {
      a = 1;
      this.e.post(this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gy
 * JD-Core Version:    0.7.0.1
 */