package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.map.lib.d;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jy
  extends Thread
{
  private jh a = null;
  private boolean b = false;
  private boolean c = false;
  private int d = 30000;
  private long e = -1L;
  private List<Object> f;
  private kt g = null;
  private boolean h = true;
  
  public jy(jh paramjh, kt paramkt)
  {
    this.a = paramjh;
    this.g = paramkt;
    this.f = new ArrayList();
  }
  
  private a a(double paramDouble1, double paramDouble2)
  {
    paramDouble1 = (180.0D + paramDouble1) / 360.0D;
    paramDouble2 = Math.sin(3.1415926D * paramDouble2 / 180.0D);
    paramDouble2 = (180.0D - Math.log((1.0D + paramDouble2) / (1.0D - paramDouble2)) * 180.0D / 6.2831852D) / 360.0D;
    a locala = new a(null);
    locala.a = ((int)(paramDouble1 * 268435456.0D + 0.5D));
    locala.b = ((int)(0.5D + paramDouble2 * 268435456.0D));
    return locala;
  }
  
  private String a(TrafficRequestItem[] paramArrayOfTrafficRequestItem)
  {
    int i = 0;
    if ((paramArrayOfTrafficRequestItem == null) || (paramArrayOfTrafficRequestItem.length == 0)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tag", "traffic");
      localJSONObject.put("level", paramArrayOfTrafficRequestItem[0].level);
      JSONArray localJSONArray = new JSONArray();
      if (i < paramArrayOfTrafficRequestItem.length)
      {
        TrafficRequestItem localTrafficRequestItem = paramArrayOfTrafficRequestItem[i];
        if (localTrafficRequestItem != null)
        {
          localJSONArray.put(localTrafficRequestItem.minLat);
          localJSONArray.put(localTrafficRequestItem.minLon);
          localJSONArray.put(localTrafficRequestItem.maxLat);
          localJSONArray.put(localTrafficRequestItem.maxLon);
        }
      }
      else
      {
        localJSONObject.put("boundArray", localJSONArray);
        localJSONObject.put("zip", 0);
        return localJSONObject.toString();
      }
    }
    catch (JSONException paramArrayOfTrafficRequestItem)
    {
      for (;;)
      {
        continue;
        i += 1;
      }
    }
  }
  
  private byte[] a(String paramString)
  {
    if (this.g == null) {
      return null;
    }
    return this.g.a(paramString);
  }
  
  private void d()
  {
    if (this.a == null) {
      return;
    }
    String str = i();
    d.a("link_traffic.txt", "\n\n触发刷新路况， 时间是 : " + str + "=============================");
    f();
    long l = SystemClock.elapsedRealtime() - this.e;
    d.a("link_traffic.txt", "当前等待时间：" + l + "   服务器返回刷新间隔: " + this.d);
    if ((this.e < 0L) || (l >= this.d))
    {
      e();
      return;
    }
    d.a("link_traffic.txt", "无需刷新全国路况");
  }
  
  private void e()
  {
    try
    {
      Object localObject = h();
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return;
        }
        String str = i();
        d.a("link_traffic.txt", "发起全国路况请求  请求时间: " + str + "  请求结构: " + (String)localObject);
        localObject = a((String)localObject);
        if ((localObject != null) && (localObject.length > 0))
        {
          str = i();
          d.a("link_traffic.txt", "全国路况返回, 大小是： " + localObject.length + " 返回时间： " + str);
          this.d = this.a.i().a((byte[])localObject, localObject.length, true, true);
          this.d *= 1000;
          this.e = SystemClock.elapsedRealtime();
          localObject = i();
          d.a("link_traffic.txt", "全国路况刷新完成， 时间是:  " + (String)localObject);
          return;
        }
        d.a("link_traffic.txt", "全国路况返回, 但结果为空");
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    Object localObject = g();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      d.a("link_traffic.txt", "无需刷新城市路况");
      return;
    }
    try
    {
      String str = i();
      d.a("link_traffic.txt", "发起城市路况请求  请求时间: " + str + "  请求结构: " + (String)localObject);
      localObject = a((String)localObject);
      if ((localObject != null) && (localObject.length > 0))
      {
        str = i();
        d.a("link_traffic.txt", "城市路况返回, 大小是： " + localObject.length + " 返回时间： " + str);
        this.a.i().a((byte[])localObject, localObject.length, true, false);
        localObject = i();
        d.a("link_traffic.txt", "城市路况刷新完成， 时间是:  " + (String)localObject);
        return;
      }
      d.a("link_traffic.txt", "城市路况返回, 但结果为空");
      return;
    }
    catch (Exception localException) {}
  }
  
  private String g()
  {
    if (this.a == null) {
      return null;
    }
    int i = this.a.a().m();
    Object localObject = this.a.a().y();
    double d1 = ((Rect)localObject).left / 1000000.0F;
    double d2 = ((Rect)localObject).bottom / 1000000.0F;
    double d3 = ((Rect)localObject).right / 1000000.0F;
    double d4 = ((Rect)localObject).top / 1000000.0F;
    localObject = a(d1, d2);
    a locala = a(d3, d4);
    this.a.i().a(i, Math.min(((a)localObject).a, locala.a), Math.min(((a)localObject).b, locala.b), Math.max(locala.a, ((a)localObject).a), Math.max(locala.b, ((a)localObject).b));
    localObject = this.a.i().h();
    if (localObject != null) {
      return a((TrafficRequestItem[])localObject);
    }
    return null;
  }
  
  private String h()
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tag", "traffic");
      localJSONObject.put("level", 4);
      JSONArray localJSONArray = new JSONArray();
      while (i < 4)
      {
        localJSONArray.put(0);
        i += 1;
      }
      localJSONObject.put("boundArray", localJSONArray);
      localJSONObject.put("zip", 0);
    }
    catch (JSONException localJSONException)
    {
      label69:
      break label69;
    }
    return localJSONObject.toString();
  }
  
  private String i()
  {
    return new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss").format(new Date(System.currentTimeMillis()));
  }
  
  public void a()
  {
    this.b = true;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    this.b = false;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    this.c = true;
    try
    {
      notify();
      interrupt();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    super.run();
    if (!this.c)
    {
      if (this.b) {
        break label37;
      }
      if (this.a != null) {}
    }
    else
    {
      return;
    }
    d();
    this.a.x();
    for (;;)
    {
      try
      {
        for (;;)
        {
          try
          {
            label37:
            if (this.h)
            {
              wait(500L);
              this.h = false;
              break;
            }
          }
          finally {}
        }
        wait(30000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
    }
  }
  
  private class a
  {
    public int a;
    public int b;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jy
 * JD-Core Version:    0.7.0.1
 */