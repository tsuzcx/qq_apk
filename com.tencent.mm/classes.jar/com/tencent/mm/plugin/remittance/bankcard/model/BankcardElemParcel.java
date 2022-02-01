package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String DNV;
  public String IfQ;
  public int IfR;
  public int IfS;
  public String IfT;
  public String IfU;
  public String IfV;
  public ArrayList<EnterTimeParcel> IfW;
  public String IfX;
  public long IfY;
  public String fvP;
  
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
    this.fvP = paramParcel.readString();
    this.DNV = paramParcel.readString();
    this.IfQ = paramParcel.readString();
    this.IfR = paramParcel.readInt();
    this.IfS = paramParcel.readInt();
    this.IfW = new ArrayList();
    paramParcel.readTypedList(this.IfW, EnterTimeParcel.CREATOR);
    this.IfT = paramParcel.readString();
    this.IfU = paramParcel.readString();
    this.IfV = paramParcel.readString();
    this.IfX = paramParcel.readString();
    this.IfY = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(iv paramiv)
  {
    AppMethodBeat.i(67401);
    this.fvP = paramiv.fvP;
    this.DNV = paramiv.DNV;
    this.IfQ = paramiv.IfQ;
    this.IfR = paramiv.IfR;
    this.IfS = paramiv.IfS;
    this.IfT = paramiv.IfT;
    this.IfU = paramiv.IfU;
    this.IfV = paramiv.IfV;
    this.IfW = new ArrayList();
    Iterator localIterator = paramiv.ROI.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((aks)localIterator.next());
      this.IfW.add(localEnterTimeParcel);
    }
    this.IfX = paramiv.ROK;
    this.IfY = paramiv.IfY;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.fvP);
    paramParcel.writeString(this.DNV);
    paramParcel.writeString(this.IfQ);
    paramParcel.writeInt(this.IfR);
    paramParcel.writeInt(this.IfS);
    paramParcel.writeTypedList(this.IfW);
    paramParcel.writeString(this.IfT);
    paramParcel.writeString(this.IfU);
    paramParcel.writeString(this.IfV);
    paramParcel.writeString(this.IfX);
    paramParcel.writeLong(this.IfY);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */