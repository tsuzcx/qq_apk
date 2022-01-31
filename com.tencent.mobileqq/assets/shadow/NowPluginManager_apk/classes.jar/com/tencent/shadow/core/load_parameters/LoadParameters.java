package com.tencent.shadow.core.load_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LoadParameters
  implements Parcelable
{
  public static final Parcelable.Creator<LoadParameters> CREATOR = new Parcelable.Creator()
  {
    public LoadParameters createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LoadParameters(paramAnonymousParcel);
    }
    
    public LoadParameters[] newArray(int paramAnonymousInt)
    {
      return new LoadParameters[paramAnonymousInt];
    }
  };
  public final String businessName;
  public final String[] dependsOn;
  public final String[] hostWhiteList;
  public final String partKey;
  
  public LoadParameters(Parcel paramParcel)
  {
    this.businessName = paramParcel.readString();
    this.partKey = paramParcel.readString();
    this.dependsOn = paramParcel.createStringArray();
    this.hostWhiteList = paramParcel.createStringArray();
  }
  
  public LoadParameters(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.businessName = paramString1;
    this.partKey = paramString2;
    this.dependsOn = paramArrayOfString1;
    this.hostWhiteList = paramArrayOfString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.businessName);
    paramParcel.writeString(this.partKey);
    paramParcel.writeStringArray(this.dependsOn);
    paramParcel.writeStringArray(this.hostWhiteList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.load_parameters.LoadParameters
 * JD-Core Version:    0.7.0.1
 */