package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String nLq;
  public String poq;
  public String qfY;
  public String qgu;
  public String qgv;
  public String qgw;
  public String qgx;
  
  static
  {
    AppMethodBeat.i(44512);
    CREATOR = new TransferRecordParcel.1();
    AppMethodBeat.o(44512);
  }
  
  public TransferRecordParcel() {}
  
  protected TransferRecordParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(44509);
    this.qgu = paramParcel.readString();
    this.qgv = paramParcel.readString();
    this.qfY = paramParcel.readString();
    this.nLq = paramParcel.readString();
    this.poq = paramParcel.readString();
    this.qgw = paramParcel.readString();
    this.qgx = paramParcel.readString();
    AppMethodBeat.o(44509);
  }
  
  private TransferRecordParcel(clp paramclp)
  {
    this.qgu = paramclp.qgu;
    this.qgv = paramclp.qgv;
    this.qfY = paramclp.qfY;
    this.nLq = paramclp.nLq;
    this.poq = paramclp.poq;
    this.qgw = paramclp.qgw;
    this.qgx = paramclp.qgx;
  }
  
  public static ArrayList<TransferRecordParcel> cL(List<clp> paramList)
  {
    AppMethodBeat.i(44511);
    if (paramList == null)
    {
      AppMethodBeat.o(44511);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new TransferRecordParcel((clp)paramList.next()));
    }
    AppMethodBeat.o(44511);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44510);
    paramParcel.writeString(this.qgu);
    paramParcel.writeString(this.qgv);
    paramParcel.writeString(this.qfY);
    paramParcel.writeString(this.nLq);
    paramParcel.writeString(this.poq);
    paramParcel.writeString(this.qgw);
    paramParcel.writeString(this.qgx);
    AppMethodBeat.o(44510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */