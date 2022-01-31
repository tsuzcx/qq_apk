package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;

public class TencentMapInitializer
  implements IInitializer
{
  private static volatile TencentMapInitializer b;
  private IInitializer a;
  
  private TencentMapInitializer(Context paramContext)
  {
    this.a = b.a(paramContext);
  }
  
  public static TencentMapInitializer getInstance(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new TencentMapInitializer(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public void downLoadVectorMapResource()
  {
    if (this.a == null) {
      return;
    }
    this.a.downLoadVectorMapResource();
  }
  
  public boolean isVectorMapValid()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.isVectorMapValid();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.dynamic.TencentMapInitializer
 * JD-Core Version:    0.7.0.1
 */