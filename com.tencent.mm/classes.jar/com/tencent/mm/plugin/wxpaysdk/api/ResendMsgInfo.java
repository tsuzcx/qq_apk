package com.tencent.mm.plugin.wxpaysdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResendMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ResendMsgInfo> CREATOR;
  public String DdI;
  public String description;
  public String title;
  public String unW;
  public String unX;
  
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
    this.DdI = paramParcel.readString();
    this.description = paramParcel.readString();
    this.unW = paramParcel.readString();
    this.unX = paramParcel.readString();
    AppMethodBeat.o(117565);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117563);
    String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.DdI + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.unW + '\'' + ", right_button_wording='" + this.unX + '\'' + '}';
    AppMethodBeat.o(117563);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117564);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.DdI);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.unW);
    paramParcel.writeString(this.unX);
    AppMethodBeat.o(117564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo
 * JD-Core Version:    0.7.0.1
 */