package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.protocal.protobuf.zz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String nLq;
  public String poq;
  public String qfY;
  public int qfZ;
  public int qga;
  public String qgb;
  public String qgc;
  public String qgd;
  public ArrayList<EnterTimeParcel> qge;
  public String qgf;
  public long qgg;
  
  static
  {
    AppMethodBeat.i(44495);
    CREATOR = new BankcardElemParcel.1();
    AppMethodBeat.o(44495);
  }
  
  public BankcardElemParcel() {}
  
  public BankcardElemParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(44493);
    this.poq = paramParcel.readString();
    this.nLq = paramParcel.readString();
    this.qfY = paramParcel.readString();
    this.qfZ = paramParcel.readInt();
    this.qga = paramParcel.readInt();
    this.qge = new ArrayList();
    paramParcel.readTypedList(this.qge, EnterTimeParcel.CREATOR);
    this.qgb = paramParcel.readString();
    this.qgc = paramParcel.readString();
    this.qgd = paramParcel.readString();
    this.qgf = paramParcel.readString();
    this.qgg = paramParcel.readLong();
    AppMethodBeat.o(44493);
  }
  
  public BankcardElemParcel(hi paramhi)
  {
    AppMethodBeat.i(44492);
    this.poq = paramhi.poq;
    this.nLq = paramhi.nLq;
    this.qfY = paramhi.qfY;
    this.qfZ = paramhi.qfZ;
    this.qga = paramhi.qga;
    this.qgb = paramhi.qgb;
    this.qgc = paramhi.qgc;
    this.qgd = paramhi.qgd;
    this.qge = new ArrayList();
    Iterator localIterator = paramhi.wua.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((zz)localIterator.next());
      this.qge.add(localEnterTimeParcel);
    }
    this.qgf = paramhi.wuc;
    this.qgg = paramhi.qgg;
    AppMethodBeat.o(44492);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44494);
    paramParcel.writeString(this.poq);
    paramParcel.writeString(this.nLq);
    paramParcel.writeString(this.qfY);
    paramParcel.writeInt(this.qfZ);
    paramParcel.writeInt(this.qga);
    paramParcel.writeTypedList(this.qge);
    paramParcel.writeString(this.qgb);
    paramParcel.writeString(this.qgc);
    paramParcel.writeString(this.qgd);
    paramParcel.writeString(this.qgf);
    paramParcel.writeLong(this.qgg);
    AppMethodBeat.o(44494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */