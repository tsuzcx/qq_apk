package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.a.qy;
import com.tencent.tencentmap.mapsdk.a.rk;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class c
{
  private int a = 1;
  private TencentMapOptions b;
  
  public IMapView a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.b = paramTencentMapOptions;
    this.a = new a(paramContext).a(this.a);
    if (this.a == 0) {
      return new qy(paramContext, this.b);
    }
    return new rk(paramContext, this.b);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.c
 * JD-Core Version:    0.7.0.1
 */