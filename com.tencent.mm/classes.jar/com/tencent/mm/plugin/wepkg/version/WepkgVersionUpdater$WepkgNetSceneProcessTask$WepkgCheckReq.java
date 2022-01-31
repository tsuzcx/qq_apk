package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class WepkgVersionUpdater$WepkgNetSceneProcessTask$WepkgCheckReq
  implements Parcelable
{
  public static final Parcelable.Creator<WepkgCheckReq> CREATOR = new WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.1();
  private String dCD;
  private int scene;
  private String version;
  
  private WepkgVersionUpdater$WepkgNetSceneProcessTask$WepkgCheckReq() {}
  
  private WepkgVersionUpdater$WepkgNetSceneProcessTask$WepkgCheckReq(Parcel paramParcel)
  {
    this.dCD = paramParcel.readString();
    this.version = paramParcel.readString();
    this.scene = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dCD);
    paramParcel.writeString(this.version);
    paramParcel.writeInt(this.scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq
 * JD-Core Version:    0.7.0.1
 */