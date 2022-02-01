package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaLocation
  extends WWMediaMessage.WWMediaObject
{
  public double Mov;
  public String hWY;
  public double latitude;
  public double longitude;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(106544);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(106544);
      return false;
    }
    if ((this.hWY != null) && (this.hWY.length() != 0) && (this.hWY.length() <= 10240))
    {
      AppMethodBeat.o(106544);
      return true;
    }
    AppMethodBeat.o(106544);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(190359);
    this.hWY = paramBundle.getString("_wwlocobject_address");
    this.longitude = paramBundle.getDouble("_wwlocobject_longitude");
    this.latitude = paramBundle.getDouble("_wwlocobject_latitude");
    this.Mov = paramBundle.getDouble("_wwlocobject_zoom");
    super.fromBundle(paramBundle);
    AppMethodBeat.o(190359);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106545);
    paramBundle.putString("_wwlocobject_address", this.hWY);
    paramBundle.putDouble("_wwlocobject_longitude", this.longitude);
    paramBundle.putDouble("_wwlocobject_latitude", this.latitude);
    paramBundle.putDouble("_wwlocobject_zoom", this.Mov);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLocation
 * JD-Core Version:    0.7.0.1
 */