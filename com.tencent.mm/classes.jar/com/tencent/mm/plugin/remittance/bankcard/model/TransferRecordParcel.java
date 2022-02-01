package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String dkR;
  public String uJF;
  public String xSA;
  public String xSB;
  public String xSC;
  public String xSd;
  public String xSz;
  
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
    this.xSz = paramParcel.readString();
    this.xSA = paramParcel.readString();
    this.xSd = paramParcel.readString();
    this.uJF = paramParcel.readString();
    this.dkR = paramParcel.readString();
    this.xSB = paramParcel.readString();
    this.xSC = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(dps paramdps)
  {
    this.xSz = paramdps.xSz;
    this.xSA = paramdps.xSA;
    this.xSd = paramdps.xSd;
    this.uJF = paramdps.uJF;
    this.dkR = paramdps.dkR;
    this.xSB = paramdps.xSB;
    this.xSC = paramdps.xSC;
  }
  
  public static ArrayList<TransferRecordParcel> fl(List<dps> paramList)
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
      localArrayList.add(new TransferRecordParcel((dps)paramList.next()));
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
    paramParcel.writeString(this.xSz);
    paramParcel.writeString(this.xSA);
    paramParcel.writeString(this.xSd);
    paramParcel.writeString(this.uJF);
    paramParcel.writeString(this.dkR);
    paramParcel.writeString(this.xSB);
    paramParcel.writeString(this.xSC);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */