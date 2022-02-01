package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Orders$ShowInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShowInfo> CREATOR;
  public String Iaq;
  public int Iar;
  public String Ias;
  public String Iat;
  public String Iau;
  public int Iav;
  public String name;
  public String value;
  public String xEk;
  
  static
  {
    AppMethodBeat.i(70347);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70347);
  }
  
  public Orders$ShowInfo() {}
  
  protected Orders$ShowInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70344);
    this.name = paramParcel.readString();
    this.value = paramParcel.readString();
    this.xEk = paramParcel.readString();
    this.Iaq = paramParcel.readString();
    this.Iar = paramParcel.readInt();
    this.Ias = paramParcel.readString();
    this.Iat = paramParcel.readString();
    this.Iau = paramParcel.readString();
    this.Iav = paramParcel.readInt();
    AppMethodBeat.o(70344);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70345);
    String str = String.format("ShowInfo name:%s, value:%s, nameColor:%s, valueColor:%s, linkType:%s, linkWeApp:%s, linkAddr:%s, linkUrl:%s, textAttr:%s", new Object[] { this.name, this.value, this.xEk, this.Iaq, Integer.valueOf(this.Iar), this.Ias, this.Iat, this.Iau, Integer.valueOf(this.Iav) });
    AppMethodBeat.o(70345);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70346);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.value);
    paramParcel.writeString(this.xEk);
    paramParcel.writeString(this.Iaq);
    paramParcel.writeInt(this.Iar);
    paramParcel.writeString(this.Ias);
    paramParcel.writeString(this.Iat);
    paramParcel.writeString(this.Iau);
    paramParcel.writeInt(this.Iav);
    AppMethodBeat.o(70346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.ShowInfo
 * JD-Core Version:    0.7.0.1
 */