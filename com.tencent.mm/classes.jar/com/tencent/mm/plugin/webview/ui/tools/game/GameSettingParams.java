package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameSettingParams> CREATOR;
  public String XfU;
  public String XfV;
  public String XfW;
  
  static
  {
    AppMethodBeat.i(80864);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(80864);
  }
  
  public GameSettingParams() {}
  
  private GameSettingParams(Parcel paramParcel)
  {
    AppMethodBeat.i(80863);
    this.XfU = paramParcel.readString();
    this.XfV = paramParcel.readString();
    this.XfW = paramParcel.readString();
    AppMethodBeat.o(80863);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(80862);
    paramParcel.writeString(this.XfU);
    paramParcel.writeString(this.XfV);
    paramParcel.writeString(this.XfW);
    AppMethodBeat.o(80862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams
 * JD-Core Version:    0.7.0.1
 */