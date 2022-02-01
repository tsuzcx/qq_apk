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
  public List<String> BwA;
  public String Bwv;
  public int Bww;
  public String Bwx;
  public String Bwy;
  public String Bwz;
  
  static
  {
    AppMethodBeat.i(70280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70280);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(70276);
    this.BwA = new LinkedList();
    AppMethodBeat.o(70276);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70277);
    this.BwA = new LinkedList();
    this.Bwv = paramParcel.readString();
    this.Bww = paramParcel.readInt();
    this.Bwx = paramParcel.readString();
    this.Bwy = paramParcel.readString();
    this.Bwz = paramParcel.readString();
    this.BwA = paramParcel.createStringArrayList();
    AppMethodBeat.o(70277);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70279);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.Bwv, Integer.valueOf(this.Bww), this.Bwx, this.Bwy, this.Bwz }));
    if (this.BwA != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.BwA.iterator();
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
    paramParcel.writeString(this.Bwv);
    paramParcel.writeInt(this.Bww);
    paramParcel.writeString(this.Bwx);
    paramParcel.writeString(this.Bwy);
    paramParcel.writeString(this.Bwz);
    paramParcel.writeStringList(this.BwA);
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */