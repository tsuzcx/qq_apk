package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FavorPayInfo> CREATOR;
  public String uhU;
  public int uhV;
  public String uhW;
  public String uhX;
  public String uhY;
  public List<String> uhZ;
  
  static
  {
    AppMethodBeat.i(46763);
    CREATOR = new FavorPayInfo.1();
    AppMethodBeat.o(46763);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(46759);
    this.uhZ = new LinkedList();
    AppMethodBeat.o(46759);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46760);
    this.uhZ = new LinkedList();
    this.uhU = paramParcel.readString();
    this.uhV = paramParcel.readInt();
    this.uhW = paramParcel.readString();
    this.uhX = paramParcel.readString();
    this.uhY = paramParcel.readString();
    this.uhZ = paramParcel.createStringArrayList();
    AppMethodBeat.o(46760);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(46762);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.uhU, Integer.valueOf(this.uhV), this.uhW, this.uhX, this.uhY }));
    if (this.uhZ != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.uhZ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuffer)localObject).append(str + ",");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(46762);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46761);
    paramParcel.writeString(this.uhU);
    paramParcel.writeInt(this.uhV);
    paramParcel.writeString(this.uhW);
    paramParcel.writeString(this.uhX);
    paramParcel.writeString(this.uhY);
    paramParcel.writeStringList(this.uhZ);
    AppMethodBeat.o(46761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */