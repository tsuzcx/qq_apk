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
  public String Doq;
  public int Dor;
  public String Dos;
  public String Dot;
  public String Dou;
  public List<String> Dov;
  
  static
  {
    AppMethodBeat.i(70280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70280);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(70276);
    this.Dov = new LinkedList();
    AppMethodBeat.o(70276);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70277);
    this.Dov = new LinkedList();
    this.Doq = paramParcel.readString();
    this.Dor = paramParcel.readInt();
    this.Dos = paramParcel.readString();
    this.Dot = paramParcel.readString();
    this.Dou = paramParcel.readString();
    this.Dov = paramParcel.createStringArrayList();
    AppMethodBeat.o(70277);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70279);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.Doq, Integer.valueOf(this.Dor), this.Dos, this.Dot, this.Dou }));
    if (this.Dov != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.Dov.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((StringBuffer)localObject).append(str + ",");
      }
    }
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(70279);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70278);
    paramParcel.writeString(this.Doq);
    paramParcel.writeInt(this.Dor);
    paramParcel.writeString(this.Dos);
    paramParcel.writeString(this.Dot);
    paramParcel.writeString(this.Dou);
    paramParcel.writeStringList(this.Dov);
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */