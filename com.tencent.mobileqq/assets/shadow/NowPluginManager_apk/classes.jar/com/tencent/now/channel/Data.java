package com.tencent.now.channel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Data
  implements Parcelable
{
  public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator()
  {
    public Data createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Data(paramAnonymousParcel);
    }
    
    public Data[] newArray(int paramAnonymousInt)
    {
      return new Data[paramAnonymousInt];
    }
  };
  public Bundle bundle;
  public int cmd;
  public long seq;
  public int subCmd;
  public String target;
  
  public Data() {}
  
  protected Data(Parcel paramParcel)
  {
    this.cmd = paramParcel.readInt();
    this.subCmd = paramParcel.readInt();
    this.seq = paramParcel.readLong();
    this.target = paramParcel.readString();
    this.bundle = paramParcel.readBundle();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.cmd);
    paramParcel.writeInt(this.subCmd);
    paramParcel.writeLong(this.seq);
    paramParcel.writeString(this.target);
    paramParcel.writeBundle(this.bundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.now.channel.Data
 * JD-Core Version:    0.7.0.1
 */