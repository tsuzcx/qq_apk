package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator() {};
  public int accuracy;
  public int bTe;
  public String bTg;
  public float elk;
  public float ell;
  public String mac;
  
  public Location() {}
  
  public Location(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.elk = paramFloat1;
    this.ell = paramFloat2;
    this.accuracy = paramInt1;
    this.bTe = paramInt2;
    this.mac = paramString1;
    this.bTg = paramString2;
  }
  
  public final boolean clg()
  {
    if ((this.elk == -85.0F) || (this.ell == -1000.0F))
    {
      y.d("MicroMsg.Radar.Location", "mac and cellId is null");
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.elk);
    paramParcel.writeFloat(this.ell);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.bTe);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.bTg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */