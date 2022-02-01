package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fqc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String JFk;
  public String OcL;
  public String OcM;
  public String OcN;
  public String OcO;
  public String Ocp;
  public String hAk;
  
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
    this.OcL = paramParcel.readString();
    this.OcM = paramParcel.readString();
    this.Ocp = paramParcel.readString();
    this.JFk = paramParcel.readString();
    this.hAk = paramParcel.readString();
    this.OcN = paramParcel.readString();
    this.OcO = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(fqc paramfqc)
  {
    this.OcL = paramfqc.OcL;
    this.OcM = paramfqc.OcM;
    this.Ocp = paramfqc.Ocp;
    this.JFk = paramfqc.JFk;
    this.hAk = paramfqc.hAk;
    this.OcN = paramfqc.OcN;
    this.OcO = paramfqc.OcO;
  }
  
  public static ArrayList<TransferRecordParcel> jU(List<fqc> paramList)
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
      localArrayList.add(new TransferRecordParcel((fqc)paramList.next()));
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
    paramParcel.writeString(this.OcL);
    paramParcel.writeString(this.OcM);
    paramParcel.writeString(this.Ocp);
    paramParcel.writeString(this.JFk);
    paramParcel.writeString(this.hAk);
    paramParcel.writeString(this.OcN);
    paramParcel.writeString(this.OcO);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */