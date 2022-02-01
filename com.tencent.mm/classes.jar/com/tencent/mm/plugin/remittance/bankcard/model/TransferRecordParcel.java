package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String dlT;
  public String uVs;
  public String yhW;
  public String yis;
  public String yit;
  public String yiu;
  public String yiv;
  
  static
  {
    AppMethodBeat.i(67421);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67421);
  }
  
  public TransferRecordParcel() {}
  
  protected TransferRecordParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(67418);
    this.yis = paramParcel.readString();
    this.yit = paramParcel.readString();
    this.yhW = paramParcel.readString();
    this.uVs = paramParcel.readString();
    this.dlT = paramParcel.readString();
    this.yiu = paramParcel.readString();
    this.yiv = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(dqp paramdqp)
  {
    this.yis = paramdqp.yis;
    this.yit = paramdqp.yit;
    this.yhW = paramdqp.yhW;
    this.uVs = paramdqp.uVs;
    this.dlT = paramdqp.dlT;
    this.yiu = paramdqp.yiu;
    this.yiv = paramdqp.yiv;
  }
  
  public static ArrayList<TransferRecordParcel> ft(List<dqp> paramList)
  {
    AppMethodBeat.i(67420);
    if (paramList == null)
    {
      AppMethodBeat.o(67420);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new TransferRecordParcel((dqp)paramList.next()));
    }
    AppMethodBeat.o(67420);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67419);
    paramParcel.writeString(this.yis);
    paramParcel.writeString(this.yit);
    paramParcel.writeString(this.yhW);
    paramParcel.writeString(this.uVs);
    paramParcel.writeString(this.dlT);
    paramParcel.writeString(this.yiu);
    paramParcel.writeString(this.yiv);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */