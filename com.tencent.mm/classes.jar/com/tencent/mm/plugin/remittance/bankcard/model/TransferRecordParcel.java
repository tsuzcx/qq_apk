package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String DNV;
  public String IfQ;
  public String Igm;
  public String Ign;
  public String Igo;
  public String Igp;
  public String fvP;
  
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
    this.Igm = paramParcel.readString();
    this.Ign = paramParcel.readString();
    this.IfQ = paramParcel.readString();
    this.DNV = paramParcel.readString();
    this.fvP = paramParcel.readString();
    this.Igo = paramParcel.readString();
    this.Igp = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(eup parameup)
  {
    this.Igm = parameup.Igm;
    this.Ign = parameup.Ign;
    this.IfQ = parameup.IfQ;
    this.DNV = parameup.DNV;
    this.fvP = parameup.fvP;
    this.Igo = parameup.Igo;
    this.Igp = parameup.Igp;
  }
  
  public static ArrayList<TransferRecordParcel> gU(List<eup> paramList)
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
      localArrayList.add(new TransferRecordParcel((eup)paramList.next()));
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
    paramParcel.writeString(this.Igm);
    paramParcel.writeString(this.Ign);
    paramParcel.writeString(this.IfQ);
    paramParcel.writeString(this.DNV);
    paramParcel.writeString(this.fvP);
    paramParcel.writeString(this.Igo);
    paramParcel.writeString(this.Igp);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */