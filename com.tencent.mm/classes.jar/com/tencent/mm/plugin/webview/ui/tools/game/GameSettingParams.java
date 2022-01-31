package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameSettingParams> CREATOR;
  public String vmD;
  public String vmE;
  
  static
  {
    AppMethodBeat.i(8693);
    CREATOR = new GameSettingParams.1();
    AppMethodBeat.o(8693);
  }
  
  public GameSettingParams() {}
  
  private GameSettingParams(Parcel paramParcel)
  {
    AppMethodBeat.i(8692);
    this.vmD = paramParcel.readString();
    this.vmE = paramParcel.readString();
    AppMethodBeat.o(8692);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8691);
    paramParcel.writeString(this.vmD);
    paramParcel.writeString(this.vmE);
    AppMethodBeat.o(8691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams
 * JD-Core Version:    0.7.0.1
 */