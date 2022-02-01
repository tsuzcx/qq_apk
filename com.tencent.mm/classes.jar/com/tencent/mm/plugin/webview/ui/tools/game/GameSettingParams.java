package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameSettingParams
  implements Parcelable
{
  public static final Parcelable.Creator<GameSettingParams> CREATOR;
  public String QnG;
  public String QnH;
  public String QnI;
  
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
    this.QnG = paramParcel.readString();
    this.QnH = paramParcel.readString();
    this.QnI = paramParcel.readString();
    AppMethodBeat.o(80863);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(80862);
    paramParcel.writeString(this.QnG);
    paramParcel.writeString(this.QnH);
    paramParcel.writeString(this.QnI);
    AppMethodBeat.o(80862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams
 * JD-Core Version:    0.7.0.1
 */