package com.tencent.wework.api.model;

import android.os.Bundle;

public class WWMediaLocation
  extends WWMediaMessage.WWMediaObject
{
  public String ekZ;
  public double latitude;
  public double longitude;
  public double xge;
  
  public final boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    while ((this.ekZ == null) || (this.ekZ.length() == 0) || (this.ekZ.length() > 10240)) {
      return false;
    }
    return true;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("_wwlocobject_address", this.ekZ);
    paramBundle.putDouble("_wwlocobject_longitude", this.longitude);
    paramBundle.putDouble("_wwlocobject_latitude", this.latitude);
    paramBundle.putDouble("_wwlocobject_zoom", this.xge);
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaLocation
 * JD-Core Version:    0.7.0.1
 */