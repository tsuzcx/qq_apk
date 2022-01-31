package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GlobalConfigChangeNotify
  implements Parcelable
{
  public static final Parcelable.Creator<GlobalConfigChangeNotify> CREATOR = new GlobalConfigChangeNotify.1();
  
  public GlobalConfigChangeNotify() {}
  
  private GlobalConfigChangeNotify(byte paramByte) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.GlobalConfigChangeNotify
 * JD-Core Version:    0.7.0.1
 */