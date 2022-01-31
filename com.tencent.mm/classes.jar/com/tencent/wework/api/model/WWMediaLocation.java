package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWMediaLocation
  extends WWMediaMessage.WWMediaObject
{
  public double BCL;
  public String fBq;
  public double latitude;
  public double longitude;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(80503);
    if (!super.checkArgs())
    {
      AppMethodBeat.o(80503);
      return false;
    }
    if ((this.fBq != null) && (this.fBq.length() != 0) && (this.fBq.length() <= 10240))
    {
      AppMethodBeat.o(80503);
      return true;
    }
    AppMethodBeat.o(80503);
    return false;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(80504);
    paramBundle.putString("_wwlocobject_address", this.fBq);
    paramBundle.putDouble("_wwlocobject_longitude", this.longitude);
    paramBundle.putDouble("_wwlocobject_latitude", this.latitude);
    paramBundle.putDouble("_wwlocobject_zoom", this.BCL);
    super.toBundle(paramBundle);
    AppMethodBeat.o(80504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLocation
 * JD-Core Version:    0.7.0.1
 */