package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;

class ef$6
  implements ah.f
{
  ef$6(ef paramef, TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener) {}
  
  public boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(150162);
    if (this.a == null)
    {
      AppMethodBeat.o(150162);
      return false;
    }
    boolean bool = this.a.onIndoorBuildingDeactivated();
    AppMethodBeat.o(150162);
    return bool;
  }
  
  public boolean onIndoorBuildingFocused()
  {
    AppMethodBeat.i(150160);
    if (this.a == null)
    {
      AppMethodBeat.o(150160);
      return false;
    }
    boolean bool = this.a.onIndoorBuildingFocused();
    AppMethodBeat.o(150160);
    return bool;
  }
  
  public boolean onIndoorLevelActivated(cu paramcu)
  {
    AppMethodBeat.i(150161);
    if (this.a == null)
    {
      AppMethodBeat.o(150161);
      return false;
    }
    boolean bool = this.a.onIndoorLevelActivated(eh.a(paramcu));
    AppMethodBeat.o(150161);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.6
 * JD-Core Version:    0.7.0.1
 */