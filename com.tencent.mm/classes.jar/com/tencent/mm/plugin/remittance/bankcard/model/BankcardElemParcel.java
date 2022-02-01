package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.im;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String cZz;
  public String tGS;
  public String wEA;
  public String wEB;
  public ArrayList<EnterTimeParcel> wEC;
  public String wED;
  public long wEE;
  public String wEw;
  public int wEx;
  public int wEy;
  public String wEz;
  
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
    this.cZz = paramParcel.readString();
    this.tGS = paramParcel.readString();
    this.wEw = paramParcel.readString();
    this.wEx = paramParcel.readInt();
    this.wEy = paramParcel.readInt();
    this.wEC = new ArrayList();
    paramParcel.readTypedList(this.wEC, EnterTimeParcel.CREATOR);
    this.wEz = paramParcel.readString();
    this.wEA = paramParcel.readString();
    this.wEB = paramParcel.readString();
    this.wED = paramParcel.readString();
    this.wEE = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(im paramim)
  {
    AppMethodBeat.i(67401);
    this.cZz = paramim.cZz;
    this.tGS = paramim.tGS;
    this.wEw = paramim.wEw;
    this.wEx = paramim.wEx;
    this.wEy = paramim.wEy;
    this.wEz = paramim.wEz;
    this.wEA = paramim.wEA;
    this.wEB = paramim.wEB;
    this.wEC = new ArrayList();
    Iterator localIterator = paramim.DWo.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((aem)localIterator.next());
      this.wEC.add(localEnterTimeParcel);
    }
    this.wED = paramim.DWq;
    this.wEE = paramim.wEE;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.cZz);
    paramParcel.writeString(this.tGS);
    paramParcel.writeString(this.wEw);
    paramParcel.writeInt(this.wEx);
    paramParcel.writeInt(this.wEy);
    paramParcel.writeTypedList(this.wEC);
    paramParcel.writeString(this.wEz);
    paramParcel.writeString(this.wEA);
    paramParcel.writeString(this.wEB);
    paramParcel.writeString(this.wED);
    paramParcel.writeLong(this.wEE);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */