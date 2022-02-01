package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaLocation
  extends WWMediaMessage.WWMediaObject
{
  public double MLr;
  public String hZQ;
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
    if ((this.hZQ != null) && (this.hZQ.length() != 0) && (this.hZQ.length() <= 10240))
    {
      AppMethodBeat.o(106544);
      return true;
    }
    AppMethodBeat.o(106544);
    return false;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(193331);
    this.hZQ = paramBundle.getString("_wwlocobject_address");
    this.longitude = paramBundle.getDouble("_wwlocobject_longitude");
    this.latitude = paramBundle.getDouble("_wwlocobject_latitude");
    this.MLr = paramBundle.getDouble("_wwlocobject_zoom");
    super.fromBundle(paramBundle);
    AppMethodBeat.o(193331);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(106545);
    paramBundle.putString("_wwlocobject_address", this.hZQ);
    paramBundle.putDouble("_wwlocobject_longitude", this.longitude);
    paramBundle.putDouble("_wwlocobject_latitude", this.latitude);
    paramBundle.putDouble("_wwlocobject_zoom", this.MLr);
    super.toBundle(paramBundle);
    AppMethodBeat.o(106545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLocation
 * JD-Core Version:    0.7.0.1
 */