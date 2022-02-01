package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class r
  implements com.tencent.tencentmap.mapsdk.map.UiSettings
{
  private com.tencent.tencentmap.mapsdk.maps.UiSettings a;
  
  public r(com.tencent.tencentmap.mapsdk.maps.UiSettings paramUiSettings)
  {
    this.a = paramUiSettings;
  }
  
  public boolean isAnimationEnabled()
  {
    return false;
  }
  
  public boolean isCompassEnabled()
  {
    AppMethodBeat.i(186353);
    if (this.a == null)
    {
      AppMethodBeat.o(186353);
      return false;
    }
    boolean bool = this.a.isCompassEnabled();
    AppMethodBeat.o(186353);
    return bool;
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    AppMethodBeat.i(186351);
    if (this.a == null)
    {
      AppMethodBeat.o(186351);
      return false;
    }
    boolean bool = this.a.isIndoorLevelPickerEnabled();
    AppMethodBeat.o(186351);
    return bool;
  }
  
  public boolean isRotateGesturesEnabled()
  {
    AppMethodBeat.i(186348);
    if (this.a == null)
    {
      AppMethodBeat.o(186348);
      return false;
    }
    boolean bool = this.a.isRotateGesturesEnabled();
    AppMethodBeat.o(186348);
    return bool;
  }
  
  public boolean isScaleControlsEnabled()
  {
    AppMethodBeat.i(186343);
    if (this.a != null)
    {
      boolean bool = this.a.isScaleViewEnabled();
      AppMethodBeat.o(186343);
      return bool;
    }
    AppMethodBeat.o(186343);
    return false;
  }
  
  public boolean isTiltGesturesEnabled()
  {
    AppMethodBeat.i(186346);
    if (this.a == null)
    {
      AppMethodBeat.o(186346);
      return false;
    }
    boolean bool = this.a.isTiltGesturesEnabled();
    AppMethodBeat.o(186346);
    return bool;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186340);
    if (this.a != null) {
      this.a.setAllGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(186340);
  }
  
  public void setAnimationEnabled(boolean paramBoolean) {}
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186352);
    if (this.a == null)
    {
      AppMethodBeat.o(186352);
      return;
    }
    this.a.setCompassEnabled(paramBoolean);
    AppMethodBeat.o(186352);
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186350);
    if (this.a != null) {
      this.a.setIndoorLevelPickerEnabled(paramBoolean);
    }
    AppMethodBeat.o(186350);
  }
  
  public void setLogoPosition(int paramInt)
  {
    AppMethodBeat.i(186341);
    if (this.a != null) {
      this.a.setLogoPosition(paramInt);
    }
    AppMethodBeat.o(186341);
  }
  
  public void setLogoPosition(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(186349);
    if (this.a != null) {
      this.a.setLogoPosition(paramInt, paramArrayOfInt);
    }
    AppMethodBeat.o(186349);
  }
  
  public void setLogoScale(float paramFloat)
  {
    AppMethodBeat.i(186347);
    if (this.a == null)
    {
      AppMethodBeat.o(186347);
      return;
    }
    this.a.setLogoScale(paramFloat);
    AppMethodBeat.o(186347);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186345);
    if (this.a == null)
    {
      AppMethodBeat.o(186345);
      return;
    }
    this.a.setRotateGesturesEnabled(paramBoolean);
    AppMethodBeat.o(186345);
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186337);
    if (this.a != null) {
      this.a.setScaleViewEnabled(paramBoolean);
    }
    AppMethodBeat.o(186337);
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    AppMethodBeat.i(186342);
    if (this.a != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.a.setScaleViewPosition(paramInt);
      AppMethodBeat.o(186342);
      return;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186338);
    if (this.a != null) {
      this.a.setScrollGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(186338);
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186344);
    if (this.a == null)
    {
      AppMethodBeat.o(186344);
      return;
    }
    this.a.setTiltGesturesEnabled(paramBoolean);
    AppMethodBeat.o(186344);
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(186339);
    if (this.a != null) {
      this.a.setZoomGesturesEnabled(paramBoolean);
    }
    AppMethodBeat.o(186339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.r
 * JD-Core Version:    0.7.0.1
 */