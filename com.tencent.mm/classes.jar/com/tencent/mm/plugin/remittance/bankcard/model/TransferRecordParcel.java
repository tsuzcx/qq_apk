package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ekl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR;
  public String CiX;
  public String Cjt;
  public String Cju;
  public String Cjv;
  public String Cjw;
  public String dDj;
  public String ynT;
  
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
    this.Cjt = paramParcel.readString();
    this.Cju = paramParcel.readString();
    this.CiX = paramParcel.readString();
    this.ynT = paramParcel.readString();
    this.dDj = paramParcel.readString();
    this.Cjv = paramParcel.readString();
    this.Cjw = paramParcel.readString();
    AppMethodBeat.o(67418);
  }
  
  private TransferRecordParcel(ekl paramekl)
  {
    this.Cjt = paramekl.Cjt;
    this.Cju = paramekl.Cju;
    this.CiX = paramekl.CiX;
    this.ynT = paramekl.ynT;
    this.dDj = paramekl.dDj;
    this.Cjv = paramekl.Cjv;
    this.Cjw = paramekl.Cjw;
  }
  
  public static ArrayList<TransferRecordParcel> go(List<ekl> paramList)
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
      localArrayList.add(new TransferRecordParcel((ekl)paramList.next()));
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
    paramParcel.writeString(this.Cjt);
    paramParcel.writeString(this.Cju);
    paramParcel.writeString(this.CiX);
    paramParcel.writeString(this.ynT);
    paramParcel.writeString(this.dDj);
    paramParcel.writeString(this.Cjv);
    paramParcel.writeString(this.Cjw);
    AppMethodBeat.o(67419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */