package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameSettingParams> CREATOR;
  public String EiI;
  public String EiJ;
  public String EiK;
  
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
    this.EiI = paramParcel.readString();
    this.EiJ = paramParcel.readString();
    this.EiK = paramParcel.readString();
    AppMethodBeat.o(80863);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(80862);
    paramParcel.writeString(this.EiI);
    paramParcel.writeString(this.EiJ);
    paramParcel.writeString(this.EiK);
    AppMethodBeat.o(80862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams
 * JD-Core Version:    0.7.0.1
 */