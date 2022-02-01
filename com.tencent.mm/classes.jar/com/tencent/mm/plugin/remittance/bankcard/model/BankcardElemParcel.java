package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String JFk;
  public String Ocp;
  public int Ocq;
  public int Ocr;
  public String Ocs;
  public String Oct;
  public String Ocu;
  public ArrayList<EnterTimeParcel> Ocv;
  public String Ocw;
  public long Ocx;
  public String hAk;
  
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
    this.hAk = paramParcel.readString();
    this.JFk = paramParcel.readString();
    this.Ocp = paramParcel.readString();
    this.Ocq = paramParcel.readInt();
    this.Ocr = paramParcel.readInt();
    this.Ocv = new ArrayList();
    paramParcel.readTypedList(this.Ocv, EnterTimeParcel.CREATOR);
    this.Ocs = paramParcel.readString();
    this.Oct = paramParcel.readString();
    this.Ocu = paramParcel.readString();
    this.Ocw = paramParcel.readString();
    this.Ocx = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(jr paramjr)
  {
    AppMethodBeat.i(67401);
    this.hAk = paramjr.hAk;
    this.JFk = paramjr.JFk;
    this.Ocp = paramjr.Ocp;
    this.Ocq = paramjr.Ocq;
    this.Ocr = paramjr.Ocr;
    this.Ocs = paramjr.Ocs;
    this.Oct = paramjr.Oct;
    this.Ocu = paramjr.Ocu;
    this.Ocv = new ArrayList();
    Iterator localIterator = paramjr.YLW.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((aoc)localIterator.next());
      this.Ocv.add(localEnterTimeParcel);
    }
    this.Ocw = paramjr.YLY;
    this.Ocx = paramjr.Ocx;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.hAk);
    paramParcel.writeString(this.JFk);
    paramParcel.writeString(this.Ocp);
    paramParcel.writeInt(this.Ocq);
    paramParcel.writeInt(this.Ocr);
    paramParcel.writeTypedList(this.Ocv);
    paramParcel.writeString(this.Ocs);
    paramParcel.writeString(this.Oct);
    paramParcel.writeString(this.Ocu);
    paramParcel.writeString(this.Ocw);
    paramParcel.writeLong(this.Ocx);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */