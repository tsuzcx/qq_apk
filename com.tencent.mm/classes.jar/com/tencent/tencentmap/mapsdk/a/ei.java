package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class ei
  implements UiSettings
{
  private ak a;
  
  public ei(ak paramak)
  {
    this.a = paramak;
  }
  
  public boolean isAnimationEnabled()
  {
    return false;
  }
  
  public boolean isCompassEnabled()
  {
    AppMethodBeat.i(150348);
    if (this.a == null)
    {
      AppMethodBeat.o(150348);
      return false;
    }
    boolean bool = this.a.a();
    AppMethodBeat.o(150348);
    return bool;
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(150346);
    if (this.a == null)
    {
      AppMethodBeat.o(150346);
      return false;
    }
    boolean bool = this.a.d();
    AppMethodBeat.o(150346);
    return bool;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(150343);
    if (this.a == null)
    {
      AppMethodBeat.o(150343);
      return false;
    }
    boolean bool = this.a.c();
    AppMethodBeat.o(150343);
    return bool;
  }
  
  public boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(150338);
    if (this.a != null)
    {
      boolean bool = this.a.e();
      AppMethodBeat.o(150338);
      return bool;
    }
    AppMethodBeat.o(150338);
    return false;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(150341);
    if (this.a == null)
    {
      AppMethodBeat.o(150341);
      return false;
    }
    boolean bool = this.a.b();
    AppMethodBeat.o(150341);
    return bool;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150335);
    if (this.a != null) {
      this.a.g(paramBoolean);
    }
    AppMethodBeat.o(150335);
  }
  
  public void setAnimationEnabled(boolean paramBoolean) {}
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150347);
    if (this.a == null)
    {
      AppMethodBeat.o(150347);
      return;
    }
    this.a.b(paramBoolean);
    AppMethodBeat.o(150347);
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150345);
    if (this.a != null) {
      this.a.j(paramBoolean);
    }
    AppMethodBeat.o(150345);
  }
  
  public void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(150336);
    if (this.a != null) {
      this.a.b(paramInt);
    }
    AppMethodBeat.o(150336);
  }
  
  public void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(150344);
    if (this.a != null) {
      this.a.a(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(150344);
  }
  
  public void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(150342);
    if (this.a == null)
    {
      AppMethodBeat.o(150342);
      return;
    }
    this.a.a(paramFloat);
    AppMethodBeat.o(150342);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150340);
    if (this.a == null)
    {
      AppMethodBeat.o(150340);
      return;
    }
    this.a.f(paramBoolean);
    AppMethodBeat.o(150340);
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150332);
    if (this.a != null) {
      this.a.h(paramBoolean);
    }
    AppMethodBeat.o(150332);
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(150337);
    if (this.a != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.a.a(paramInt);
      AppMethodBeat.o(150337);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150333);
    if (this.a != null) {
      this.a.c(paramBoolean);
    }
    AppMethodBeat.o(150333);
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150339);
    if (this.a == null)
    {
      AppMethodBeat.o(150339);
      return;
    }
    this.a.e(paramBoolean);
    AppMethodBeat.o(150339);
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(150334);
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
    AppMethodBeat.o(150334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ei
 * JD-Core Version:    0.7.0.1
 */