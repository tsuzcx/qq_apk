package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxQBarResult
  extends a.a
  implements Parcelable
{
  public static final Parcelable.Creator<WxQBarResult> CREATOR;
  public WxQBarPoint LKP;
  public int LKn;
  
  static
  {
    AppMethodBeat.i(176212);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(176212);
  }
  
  public WxQBarResult(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt2)
  {
    this.LKn = 0;
    this.typeID = paramInt1;
    this.typeName = paramString1;
    this.data = paramString2;
    this.rawData = paramArrayOfByte;
    this.charset = paramString3;
    this.priorityLevel = paramInt2;
  }
  
  public WxQBarResult(Parcel paramParcel)
  {
    AppMethodBeat.i(176210);
    this.LKn = 0;
    this.typeID = paramParcel.readInt();
    this.typeName = paramParcel.readString();
    this.data = paramParcel.readString();
    paramParcel.readByteArray(this.rawData);
    this.charset = paramParcel.readString();
    this.LKn = paramParcel.readInt();
    this.LKP = ((WxQBarPoint)paramParcel.readParcelable(WxQBarPoint.class.getClassLoader()));
    this.priorityLevel = paramParcel.readInt();
    AppMethodBeat.o(176210);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(176211);
    paramParcel.writeInt(this.typeID);
    paramParcel.writeString(this.typeName);
    paramParcel.writeString(this.data);
    paramParcel.writeByteArray(this.rawData);
    paramParcel.writeString(this.charset);
    paramParcel.writeInt(this.LKn);
    paramParcel.writeParcelable(this.LKP, paramInt);
    paramParcel.writeInt(this.priorityLevel);
    AppMethodBeat.o(176211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.WxQBarResult
 * JD-Core Version:    0.7.0.1
 */