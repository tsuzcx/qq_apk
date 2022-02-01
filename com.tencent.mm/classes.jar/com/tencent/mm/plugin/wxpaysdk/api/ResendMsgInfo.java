package com.tencent.mm.plugin.wxpaysdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResendMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ResendMsgInfo> CREATOR;
  public String EHI;
  public String description;
  public String kzK;
  public String kzL;
  public String title;
  
  static
  {
    AppMethodBeat.i(117566);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117566);
  }
  
  public ResendMsgInfo() {}
  
  protected ResendMsgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(117565);
    this.title = paramParcel.readString();
    this.EHI = paramParcel.readString();
    this.description = paramParcel.readString();
    this.kzK = paramParcel.readString();
    this.kzL = paramParcel.readString();
    AppMethodBeat.o(117565);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117563);
    String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.EHI + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.kzK + '\'' + ", right_button_wording='" + this.kzL + '\'' + '}';
    AppMethodBeat.o(117563);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117564);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.EHI);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.kzK);
    paramParcel.writeString(this.kzL);
    AppMethodBeat.o(117564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo
 * JD-Core Version:    0.7.0.1
 */