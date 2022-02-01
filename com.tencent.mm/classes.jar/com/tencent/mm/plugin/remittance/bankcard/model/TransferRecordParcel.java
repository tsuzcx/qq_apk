package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String cZz;
  public String tGS;
  public String wES;
  public String wET;
  public String wEU;
  public String wEV;
  public String wEw;
  
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
    this.wES = paramParcel.readString();
    this.wET = paramParcel.readString();
    this.wEw = paramParcel.readString();
    this.tGS = paramParcel.readString();
    this.cZz = paramParcel.readString();
    this.wEU = paramParcel.readString();
    this.wEV = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(dkd paramdkd)
  {
    this.wES = paramdkd.wES;
    this.wET = paramdkd.wET;
    this.wEw = paramdkd.wEw;
    this.tGS = paramdkd.tGS;
    this.cZz = paramdkd.cZz;
    this.wEU = paramdkd.wEU;
    this.wEV = paramdkd.wEV;
  }
  
  public static ArrayList<TransferRecordParcel> eY(List<dkd> paramList)
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
      localArrayList.add(new TransferRecordParcel((dkd)paramList.next()));
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
    paramParcel.writeString(this.wES);
    paramParcel.writeString(this.wET);
    paramParcel.writeString(this.wEw);
    paramParcel.writeString(this.tGS);
    paramParcel.writeString(this.cZz);
    paramParcel.writeString(this.wEU);
    paramParcel.writeString(this.wEV);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */