package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR;
  public String name;
  public String nmk;
  public String ukA;
  public int ukB;
  public String ukC;
  public String ukD;
  public String ukE;
  public int ukF;
  public String value;
  
  static
  {
    AppMethodBeat.i(46828);
    CREATOR = new Orders.ShowInfo.1();
    AppMethodBeat.o(46828);
  }
  
  public Orders$ShowInfo() {}
  
  protected Orders$ShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46825);
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.nmk = paramParcel.readString();
    this.ukA = paramParcel.readString();
    this.ukB = paramParcel.readInt();
    this.ukC = paramParcel.readString();
    this.ukD = paramParcel.readString();
    this.ukE = paramParcel.readString();
    this.ukF = paramParcel.readInt();
    AppMethodBeat.o(46825);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(46826);
    String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.nmk, this.ukA, Integer.valueOf(this.ukB), this.ukC, this.ukD, this.ukE, Integer.valueOf(this.ukF) });
    AppMethodBeat.o(46826);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46827);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeString(this.nmk);
    paramParcel.writeString(this.ukA);
    paramParcel.writeInt(this.ukB);
    paramParcel.writeString(this.ukC);
    paramParcel.writeString(this.ukD);
    paramParcel.writeString(this.ukE);
    paramParcel.writeInt(this.ukF);
    AppMethodBeat.o(46827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo
 * JD-Core Version:    0.7.0.1
 */