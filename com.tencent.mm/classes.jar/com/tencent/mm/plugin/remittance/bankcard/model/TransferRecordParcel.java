package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.deo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String dca;
  public String szi;
  public String vuN;
  public String vuO;
  public String vuP;
  public String vuQ;
  public String vur;
  
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
    this.vuN = paramParcel.readString();
    this.vuO = paramParcel.readString();
    this.vur = paramParcel.readString();
    this.szi = paramParcel.readString();
    this.dca = paramParcel.readString();
    this.vuP = paramParcel.readString();
    this.vuQ = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(deo paramdeo)
  {
    this.vuN = paramdeo.vuN;
    this.vuO = paramdeo.vuO;
    this.vur = paramdeo.vur;
    this.szi = paramdeo.szi;
    this.dca = paramdeo.dca;
    this.vuP = paramdeo.vuP;
    this.vuQ = paramdeo.vuQ;
  }
  
  public static ArrayList<TransferRecordParcel> eS(List<deo> paramList)
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
      localArrayList.add(new TransferRecordParcel((deo)paramList.next()));
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
    paramParcel.writeString(this.vuN);
    paramParcel.writeString(this.vuO);
    paramParcel.writeString(this.vur);
    paramParcel.writeString(this.szi);
    paramParcel.writeString(this.dca);
    paramParcel.writeString(this.vuP);
    paramParcel.writeString(this.vuQ);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */