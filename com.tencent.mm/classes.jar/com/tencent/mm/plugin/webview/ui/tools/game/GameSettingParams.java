package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameSettingParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameSettingParams> CREATOR = new GameSettingParams.1();
  public String rwl;
  public String rwm;
  
  public GameSettingParams() {}
  
  private GameSettingParams(Parcel paramParcel)
  {
    this.rwl = paramParcel.readString();
    this.rwm = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.rwl);
    paramParcel.writeString(this.rwm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams
 * JD-Core Version:    0.7.0.1
 */