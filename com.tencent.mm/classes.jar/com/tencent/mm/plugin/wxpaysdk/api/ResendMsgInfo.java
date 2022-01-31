package com.tencent.mm.plugin.wxpaysdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResendMsgInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ResendMsgInfo> CREATOR;
  public String description;
  public String opC;
  public String opD;
  public String title;
  public String vIO;
  
  static
  {
    AppMethodBeat.i(141111);
    CREATOR = new ResendMsgInfo.1();
    AppMethodBeat.o(141111);
  }
  
  public ResendMsgInfo() {}
  
  protected ResendMsgInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(141110);
    this.title = paramParcel.readString();
    this.vIO = paramParcel.readString();
    this.description = paramParcel.readString();
    this.opC = paramParcel.readString();
    this.opD = paramParcel.readString();
    AppMethodBeat.o(141110);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(141108);
    String str = "ResendMsgInfo{title='" + this.title + '\'' + ", pic='" + this.vIO + '\'' + ", description='" + this.description + '\'' + ", left_button_wording='" + this.opC + '\'' + ", right_button_wording='" + this.opD + '\'' + '}';
    AppMethodBeat.o(141108);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(141109);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.vIO);
    paramParcel.writeString(this.description);
    paramParcel.writeString(this.opC);
    paramParcel.writeString(this.opD);
    AppMethodBeat.o(141109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo
 * JD-Core Version:    0.7.0.1
 */