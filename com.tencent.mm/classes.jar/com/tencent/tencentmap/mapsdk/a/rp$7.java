package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;

class rp$7
  implements qn
{
  rp$7(rp paramrp, TencentMap.TencentMapGestureListener paramTencentMapGestureListener) {}
  
  public void a()
  {
    if (this.a == null) {
      return;
    }
    this.a.onMapStable();
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onDoubleTap(paramFloat1, paramFloat2);
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onSingleTap(paramFloat1, paramFloat2);
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onFling(paramFloat1, paramFloat2);
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onScroll(paramFloat1, paramFloat2);
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onLongPress(paramFloat1, paramFloat2);
  }
  
  public boolean f(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onDown(paramFloat1, paramFloat2);
  }
  
  public boolean g(float paramFloat1, float paramFloat2)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onUp(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp.7
 * JD-Core Version:    0.7.0.1
 */