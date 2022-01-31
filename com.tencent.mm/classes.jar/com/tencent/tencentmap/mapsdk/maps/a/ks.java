package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah.f;
import com.tencent.tencentmap.mapsdk.a.cu;

public class ks
  implements ah.f
{
  private kx a;
  
  public ks(kx paramkx)
  {
    this.a = paramkx;
  }
  
  public boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(148980);
    if (this.a == null)
    {
      AppMethodBeat.o(148980);
      return false;
    }
    this.a.onIndoorBuildingDeactivated();
    if (this.a.r != null) {
      this.a.r.onIndoorBuildingDeactivated();
    }
    AppMethodBeat.o(148980);
    return true;
  }
  
  public boolean onIndoorBuildingFocused()
  {
    AppMethodBeat.i(148978);
    if (this.a == null)
    {
      AppMethodBeat.o(148978);
      return false;
    }
    this.a.onIndoorBuildingFocused();
    if (this.a.r != null) {
      this.a.r.onIndoorBuildingFocused();
    }
    AppMethodBeat.o(148978);
    return true;
  }
  
  public boolean onIndoorLevelActivated(cu paramcu)
  {
    AppMethodBeat.i(148979);
    if (this.a == null)
    {
      AppMethodBeat.o(148979);
      return false;
    }
    this.a.onIndoorLevelActivated(paramcu);
    if (this.a.r != null) {
      this.a.r.onIndoorLevelActivated(paramcu);
    }
    AppMethodBeat.o(148979);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ks
 * JD-Core Version:    0.7.0.1
 */