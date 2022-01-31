package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.TencentMapGestureListener;

class ef$7
  implements dl
{
  ef$7(ef paramef, TencentMap.TencentMapGestureListener paramTencentMapGestureListener) {}
  
  public void a()
  {
    AppMethodBeat.i(150200);
    if (this.a == null)
    {
      AppMethodBeat.o(150200);
      return;
    }
    this.a.onMapStable();
    AppMethodBeat.o(150200);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150193);
    if (this.a == null)
    {
      AppMethodBeat.o(150193);
      return false;
    }
    boolean bool = this.a.onDoubleTap(paramFloat1, paramFloat2);
    AppMethodBeat.o(150193);
    return bool;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150194);
    if (this.a == null)
    {
      AppMethodBeat.o(150194);
      return false;
    }
    boolean bool = this.a.onSingleTap(paramFloat1, paramFloat2);
    AppMethodBeat.o(150194);
    return bool;
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150195);
    if (this.a == null)
    {
      AppMethodBeat.o(150195);
      return false;
    }
    boolean bool = this.a.onFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(150195);
    return bool;
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150196);
    if (this.a == null)
    {
      AppMethodBeat.o(150196);
      return false;
    }
    boolean bool = this.a.onScroll(paramFloat1, paramFloat2);
    AppMethodBeat.o(150196);
    return bool;
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150197);
    if (this.a == null)
    {
      AppMethodBeat.o(150197);
      return false;
    }
    boolean bool = this.a.onLongPress(paramFloat1, paramFloat2);
    AppMethodBeat.o(150197);
    return bool;
  }
  
  public boolean f(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150198);
    if (this.a == null)
    {
      AppMethodBeat.o(150198);
      return false;
    }
    boolean bool = this.a.onDown(paramFloat1, paramFloat2);
    AppMethodBeat.o(150198);
    return bool;
  }
  
  public boolean g(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(150199);
    if (this.a == null)
    {
      AppMethodBeat.o(150199);
      return false;
    }
    boolean bool = this.a.onUp(paramFloat1, paramFloat2);
    AppMethodBeat.o(150199);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.7
 * JD-Core Version:    0.7.0.1
 */