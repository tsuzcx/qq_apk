package com.tencent.mm.plugin.wxpaysdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResendMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ResendMsgInfo> CREATOR;
  public String Fae;
  public String description;
  public String kCZ;
  public String kDa;
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
    this.Fae = paramParcel.readString();
    this.description = paramParcel.readString();
    this.kCZ = paramParcel.readString();
    this.kDa = paramParcel.readString();
    AppMethodBeat.o(117565);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117563);
    String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.Fae + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.kCZ + '\'' + ", right_button_wording='" + this.kDa + '\'' + '}';
    AppMethodBeat.o(117563);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117564);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.Fae);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.kCZ);
    paramParcel.writeString(this.kDa);
    AppMethodBeat.o(117564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo
 * JD-Core Version:    0.7.0.1
 */