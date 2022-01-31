package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import java.io.Closeable;
import java.io.InputStream;

public class ly
  extends jv
{
  public a a;
  jt b;
  kt c;
  b d;
  private int e;
  private String f;
  private oj g;
  private float h;
  private ai i;
  
  public ly(Context paramContext, ai paramai) {}
  
  private Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((this.i != null) && (!StringUtil.isEmpty(this.i.f()))) {}
    for (Object localObject1 = this.i.f();; localObject1 = null)
    {
      Object localObject2 = v.b(r.a(getContext()).g((String)localObject1) + paramString);
      if (localObject2 == null) {}
      for (localObject1 = v.b(r.a(getContext()).h((String)localObject1) + paramString);; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = v.b(r.a(getContext()).i() + paramString);
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (t.a() == null) {
            break label227;
          }
          localObject1 = t.b(getContext(), t.a() + paramString);
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = t.a(getContext(), paramString);
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = t.b(getContext(), paramString);
          }
          if (localObject1 == null) {
            break;
          }
          paramString = BitmapFactory.decodeStream((InputStream)localObject1);
          v.a((Closeable)localObject1);
          return paramString;
          label227:
          localObject1 = localObject2;
          if (t.b() != null) {
            localObject1 = v.b(t.b() + paramString);
          }
        }
      }
    }
  }
  
  private String getRouteBlockUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://closedroadvector.map.qq.com/closed_road_v2?");
    localStringBuilder.append("iszip=true");
    localStringBuilder.append("&imei=" + lq.a());
    localStringBuilder.append("&pf=android");
    localStringBuilder.append("&sdkversion=4.1.1");
    localStringBuilder.append("&p=sdk");
    localStringBuilder.append("&nettype=" + lq.b());
    return localStringBuilder.toString();
  }
  
  public void k()
  {
    Context localContext = getContext().getApplicationContext();
    this.h = (SystemUtil.getDensity(localContext) / 2.0F);
    qs.a().a(localContext);
    r localr = r.a(localContext);
    v.a(localr.f());
    v.a(localr.g());
    String str;
    if ((this.i != null) && (!StringUtil.isEmpty(this.i.f())))
    {
      str = this.i.f();
      v.a(localr.g(str));
      v.a(localr.h(str));
    }
    for (;;)
    {
      v.a(localr.g(null));
      v.a(localr.h(null));
      v.a(localr.h());
      if (this.i != null)
      {
        if (this.i.a() == null) {
          break label211;
        }
        t.a(this.i.a());
      }
      for (;;)
      {
        mf.a(localContext, str);
        this.b = new ly.d(getContext(), str);
        this.a = new ly.b(this);
        a(this.a, lw.a());
        getMap().b(lh.a());
        getMap().c(getRouteBlockUrl());
        return;
        label211:
        if (this.i.b() != null) {
          t.b(this.i.b());
        }
      }
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ly
 * JD-Core Version:    0.7.0.1
 */