package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.it;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String dkR;
  public String uJF;
  public String xSd;
  public int xSe;
  public int xSf;
  public String xSg;
  public String xSh;
  public String xSi;
  public ArrayList<EnterTimeParcel> xSj;
  public String xSk;
  public long xSl;
  
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
    this.dkR = paramParcel.readString();
    this.uJF = paramParcel.readString();
    this.xSd = paramParcel.readString();
    this.xSe = paramParcel.readInt();
    this.xSf = paramParcel.readInt();
    this.xSj = new ArrayList();
    paramParcel.readTypedList(this.xSj, EnterTimeParcel.CREATOR);
    this.xSg = paramParcel.readString();
    this.xSh = paramParcel.readString();
    this.xSi = paramParcel.readString();
    this.xSk = paramParcel.readString();
    this.xSl = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(it paramit)
  {
    AppMethodBeat.i(67401);
    this.dkR = paramit.dkR;
    this.uJF = paramit.uJF;
    this.xSd = paramit.xSd;
    this.xSe = paramit.xSe;
    this.xSf = paramit.xSf;
    this.xSg = paramit.xSg;
    this.xSh = paramit.xSh;
    this.xSi = paramit.xSi;
    this.xSj = new ArrayList();
    Iterator localIterator = paramit.FBK.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((agv)localIterator.next());
      this.xSj.add(localEnterTimeParcel);
    }
    this.xSk = paramit.FBM;
    this.xSl = paramit.xSl;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.dkR);
    paramParcel.writeString(this.uJF);
    paramParcel.writeString(this.xSd);
    paramParcel.writeInt(this.xSe);
    paramParcel.writeInt(this.xSf);
    paramParcel.writeTypedList(this.xSj);
    paramParcel.writeString(this.xSg);
    paramParcel.writeString(this.xSh);
    paramParcel.writeString(this.xSi);
    paramParcel.writeString(this.xSk);
    paramParcel.writeLong(this.xSl);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */