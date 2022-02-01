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
  public String HXI;
  public int HXJ;
  public String HXK;
  public String HXL;
  public String HXM;
  public List<String> HXN;
  
  static
  {
    AppMethodBeat.i(70280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70280);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(70276);
    this.HXN = new LinkedList();
    AppMethodBeat.o(70276);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70277);
    this.HXN = new LinkedList();
    this.HXI = paramParcel.readString();
    this.HXJ = paramParcel.readInt();
    this.HXK = paramParcel.readString();
    this.HXL = paramParcel.readString();
    this.HXM = paramParcel.readString();
    this.HXN = paramParcel.createStringArrayList();
    AppMethodBeat.o(70277);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70279);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.HXI, Integer.valueOf(this.HXJ), this.HXK, this.HXL, this.HXM }));
    if (this.HXN != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.HXN.iterator();
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
    paramParcel.writeString(this.HXI);
    paramParcel.writeInt(this.HXJ);
    paramParcel.writeString(this.HXK);
    paramParcel.writeString(this.HXL);
    paramParcel.writeString(this.HXM);
    paramParcel.writeStringList(this.HXN);
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */