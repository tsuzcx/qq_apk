package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.c;

public class Orders$Promotions
  implements Parcelable
{
  public static final Parcelable.Creator<Promotions> CREATOR;
  public String name;
  public String ppq;
  public String pvi;
  public String title;
  public int type;
  public String uWi;
  public long ubC;
  public int uiL;
  public int uiM;
  public long uiN;
  public String uiO;
  public int uki;
  public int ukk;
  public int ukl;
  public String ukm;
  public String ukn;
  public String uko;
  public int ukp;
  public String ukq;
  public c ukr;
  public String url;
  
  static
  {
    AppMethodBeat.i(46815);
    CREATOR = new Orders.Promotions.1();
    AppMethodBeat.o(46815);
  }
  
  public Orders$Promotions() {}
  
  public Orders$Promotions(Parcel paramParcel)
  {
    AppMethodBeat.i(46813);
    this.type = paramParcel.readInt();
    this.pvi = paramParcel.readString();
    this.name = paramParcel.readString();
    this.uiO = paramParcel.readString();
    this.url = paramParcel.readString();
    this.ppq = paramParcel.readString();
    this.title = paramParcel.readString();
    this.uki = paramParcel.readInt();
    this.ubC = paramParcel.readLong();
    this.ukk = paramParcel.readInt();
    this.ukl = paramParcel.readInt();
    this.uiL = paramParcel.readInt();
    this.uiM = paramParcel.readInt();
    this.ukm = paramParcel.readString();
    this.ukn = paramParcel.readString();
    this.uko = paramParcel.readString();
    this.uiN = paramParcel.readLong();
    this.ukp = paramParcel.readInt();
    AppMethodBeat.o(46813);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46814);
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.pvi);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.uiO);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.ppq);
    paramParcel.writeString(this.title);
    paramParcel.writeInt(this.uki);
    paramParcel.writeLong(this.ubC);
    paramParcel.writeInt(this.ukk);
    paramParcel.writeInt(this.ukl);
    paramParcel.writeInt(this.uiL);
    paramParcel.writeInt(this.uiM);
    paramParcel.writeString(this.ukm);
    paramParcel.writeString(this.ukn);
    paramParcel.writeString(this.uko);
    paramParcel.writeLong(this.uiN);
    paramParcel.writeInt(this.ukp);
    AppMethodBeat.o(46814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Orders.Promotions
 * JD-Core Version:    0.7.0.1
 */