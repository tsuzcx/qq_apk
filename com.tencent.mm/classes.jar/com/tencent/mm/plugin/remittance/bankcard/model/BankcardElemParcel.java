package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String CiX;
  public int CiY;
  public int CiZ;
  public String Cja;
  public String Cjb;
  public String Cjc;
  public ArrayList<EnterTimeParcel> Cjd;
  public String Cje;
  public long Cjf;
  public String dDj;
  public String ynT;
  
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
    this.dDj = paramParcel.readString();
    this.ynT = paramParcel.readString();
    this.CiX = paramParcel.readString();
    this.CiY = paramParcel.readInt();
    this.CiZ = paramParcel.readInt();
    this.Cjd = new ArrayList();
    paramParcel.readTypedList(this.Cjd, EnterTimeParcel.CREATOR);
    this.Cja = paramParcel.readString();
    this.Cjb = paramParcel.readString();
    this.Cjc = paramParcel.readString();
    this.Cje = paramParcel.readString();
    this.Cjf = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(jg paramjg)
  {
    AppMethodBeat.i(67401);
    this.dDj = paramjg.dDj;
    this.ynT = paramjg.ynT;
    this.CiX = paramjg.CiX;
    this.CiY = paramjg.CiY;
    this.CiZ = paramjg.CiZ;
    this.Cja = paramjg.Cja;
    this.Cjb = paramjg.Cjb;
    this.Cjc = paramjg.Cjc;
    this.Cjd = new ArrayList();
    Iterator localIterator = paramjg.KNO.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((ajr)localIterator.next());
      this.Cjd.add(localEnterTimeParcel);
    }
    this.Cje = paramjg.KNQ;
    this.Cjf = paramjg.Cjf;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.dDj);
    paramParcel.writeString(this.ynT);
    paramParcel.writeString(this.CiX);
    paramParcel.writeInt(this.CiY);
    paramParcel.writeInt(this.CiZ);
    paramParcel.writeTypedList(this.Cjd);
    paramParcel.writeString(this.Cja);
    paramParcel.writeString(this.Cjb);
    paramParcel.writeString(this.Cjc);
    paramParcel.writeString(this.Cje);
    paramParcel.writeLong(this.Cjf);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */