package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adn;
import com.tencent.mm.protocal.protobuf.ig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR;
  public String dca;
  public String szi;
  public String vur;
  public int vus;
  public int vut;
  public String vuu;
  public String vuv;
  public String vuw;
  public ArrayList<EnterTimeParcel> vux;
  public String vuy;
  public long vuz;
  
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
    this.dca = paramParcel.readString();
    this.szi = paramParcel.readString();
    this.vur = paramParcel.readString();
    this.vus = paramParcel.readInt();
    this.vut = paramParcel.readInt();
    this.vux = new ArrayList();
    paramParcel.readTypedList(this.vux, EnterTimeParcel.CREATOR);
    this.vuu = paramParcel.readString();
    this.vuv = paramParcel.readString();
    this.vuw = paramParcel.readString();
    this.vuy = paramParcel.readString();
    this.vuz = paramParcel.readLong();
    AppMethodBeat.o(67402);
  }
  
  public BankcardElemParcel(ig paramig)
  {
    AppMethodBeat.i(67401);
    this.dca = paramig.dca;
    this.szi = paramig.szi;
    this.vur = paramig.vur;
    this.vus = paramig.vus;
    this.vut = paramig.vut;
    this.vuu = paramig.vuu;
    this.vuv = paramig.vuv;
    this.vuw = paramig.vuw;
    this.vux = new ArrayList();
    Iterator localIterator = paramig.CDO.iterator();
    while (localIterator.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((adn)localIterator.next());
      this.vux.add(localEnterTimeParcel);
    }
    this.vuy = paramig.CDQ;
    this.vuz = paramig.vuz;
    AppMethodBeat.o(67401);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(67403);
    paramParcel.writeString(this.dca);
    paramParcel.writeString(this.szi);
    paramParcel.writeString(this.vur);
    paramParcel.writeInt(this.vus);
    paramParcel.writeInt(this.vut);
    paramParcel.writeTypedList(this.vux);
    paramParcel.writeString(this.vuu);
    paramParcel.writeString(this.vuv);
    paramParcel.writeString(this.vuw);
    paramParcel.writeString(this.vuy);
    paramParcel.writeLong(this.vuz);
    AppMethodBeat.o(67403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */