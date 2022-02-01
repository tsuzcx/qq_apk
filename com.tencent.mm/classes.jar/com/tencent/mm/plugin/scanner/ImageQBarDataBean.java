package com.tencent.mm.plugin.scanner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ImageQBarDataBean
  implements Parcelable
{
  public static final Parcelable.Creator<ImageQBarDataBean> CREATOR;
  public String OGQ;
  public float OGR;
  public float OGS;
  public String filePath;
  public int hDb;
  public int hDc;
  public int hXo;
  public int hXp;
  public int priorityLevel;
  public String typeName;
  
  static
  {
    AppMethodBeat.i(313405);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(313405);
  }
  
  public ImageQBarDataBean() {}
  
  public ImageQBarDataBean(Parcel paramParcel)
  {
    AppMethodBeat.i(313402);
    this.OGQ = paramParcel.readString();
    this.hDb = paramParcel.readInt();
    this.hDc = paramParcel.readInt();
    this.typeName = paramParcel.readString();
    this.OGR = paramParcel.readFloat();
    this.OGS = paramParcel.readFloat();
    this.hXo = paramParcel.readInt();
    this.hXp = paramParcel.readInt();
    this.filePath = paramParcel.readString();
    this.priorityLevel = paramParcel.readInt();
    AppMethodBeat.o(313402);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(313410);
    paramParcel.writeString(this.OGQ);
    paramParcel.writeInt(this.hDb);
    paramParcel.writeInt(this.hDc);
    paramParcel.writeString(this.typeName);
    paramParcel.writeFloat(this.OGR);
    paramParcel.writeFloat(this.OGS);
    paramParcel.writeInt(this.hXo);
    paramParcel.writeInt(this.hXp);
    paramParcel.writeString(this.filePath);
    paramParcel.writeInt(this.priorityLevel);
    AppMethodBeat.o(313410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ImageQBarDataBean
 * JD-Core Version:    0.7.0.1
 */