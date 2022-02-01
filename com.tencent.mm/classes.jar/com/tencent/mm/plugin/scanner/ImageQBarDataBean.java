package com.tencent.mm.plugin.scanner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ImageQBarDataBean
  implements Parcelable
{
  public static final Parcelable.Creator<ImageQBarDataBean> CREATOR;
  public String IAH;
  public float IAI;
  public float IAJ;
  public int fRr;
  public int fRs;
  public String filePath;
  public int fys;
  public int fyt;
  public int priorityLevel;
  public String typeName;
  
  static
  {
    AppMethodBeat.i(202583);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(202583);
  }
  
  public ImageQBarDataBean() {}
  
  public ImageQBarDataBean(Parcel paramParcel)
  {
    AppMethodBeat.i(202576);
    this.IAH = paramParcel.readString();
    this.fys = paramParcel.readInt();
    this.fyt = paramParcel.readInt();
    this.typeName = paramParcel.readString();
    this.IAI = paramParcel.readFloat();
    this.IAJ = paramParcel.readFloat();
    this.fRr = paramParcel.readInt();
    this.fRs = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    this.priorityLevel = paramParcel.readInt();
    AppMethodBeat.o(202576);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(202582);
    paramParcel.writeString(this.IAH);
    paramParcel.writeInt(this.fys);
    paramParcel.writeInt(this.fyt);
    paramParcel.writeString(this.typeName);
    paramParcel.writeFloat(this.IAI);
    paramParcel.writeFloat(this.IAJ);
    paramParcel.writeInt(this.fRr);
    paramParcel.writeInt(this.fRs);
    paramParcel.writeString(this.filePath);
    paramParcel.writeInt(this.priorityLevel);
    AppMethodBeat.o(202582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ImageQBarDataBean
 * JD-Core Version:    0.7.0.1
 */