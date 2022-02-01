package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.it;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String dlT;
  public String uVs;
  public String yhW;
  public int yhX;
  public int yhY;
  public String yhZ;
  public String yia;
  public String yib;
  public ArrayList<EnterTimeParcel> yic;
  public String yid;
  public long yie;
  
  static
  {
    AppMethodBeat.i(67404);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67404);
  }
  
  public BankcardElemParcel() {}
  
  public BankcardElemParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(67402);
    this.dlT = paramParcel.readString();
    this.uVs = paramParcel.readString();
    this.yhW = paramParcel.readString();
    this.yhX = paramParcel.readInt();
    this.yhY = paramParcel.readInt();
    this.yic = new ArrayList();
    paramParcel.readTypedList(this.yic, EnterTimeParcel.CREATOR);
    this.yhZ = paramParcel.readString();
    this.yia = paramParcel.readString();
    this.yib = paramParcel.readString();
    this.yid = paramParcel.readString();
    this.yie = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(it paramit)
  {
    AppMethodBeat.i(67401);
    this.dlT = paramit.dlT;
    this.uVs = paramit.uVs;
    this.yhW = paramit.yhW;
    this.yhX = paramit.yhX;
    this.yhY = paramit.yhY;
    this.yhZ = paramit.yhZ;
    this.yia = paramit.yia;
    this.yib = paramit.yib;
    this.yic = new ArrayList();
    Iterator localIterator = paramit.FUf.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((ahf)localIterator.next());
      this.yic.add(localEnterTimeParcel);
    }
    this.yid = paramit.FUh;
    this.yie = paramit.yie;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.dlT);
    paramParcel.writeString(this.uVs);
    paramParcel.writeString(this.yhW);
    paramParcel.writeInt(this.yhX);
    paramParcel.writeInt(this.yhY);
    paramParcel.writeTypedList(this.yic);
    paramParcel.writeString(this.yhZ);
    paramParcel.writeString(this.yia);
    paramParcel.writeString(this.yib);
    paramParcel.writeString(this.yid);
    paramParcel.writeLong(this.yie);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */