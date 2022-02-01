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
  public String Aeb;
  public int Aec;
  public String Aed;
  public String Aee;
  public String Aef;
  public List<String> Aeg;
  
  static
  {
    AppMethodBeat.i(70280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70280);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(70276);
    this.Aeg = new LinkedList();
    AppMethodBeat.o(70276);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70277);
    this.Aeg = new LinkedList();
    this.Aeb = paramParcel.readString();
    this.Aec = paramParcel.readInt();
    this.Aed = paramParcel.readString();
    this.Aee = paramParcel.readString();
    this.Aef = paramParcel.readString();
    this.Aeg = paramParcel.createStringArrayList();
    AppMethodBeat.o(70277);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70279);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.Aeb, Integer.valueOf(this.Aec), this.Aed, this.Aee, this.Aef }));
    if (this.Aeg != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.Aeg.iterator();
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
    paramParcel.writeString(this.Aeb);
    paramParcel.writeInt(this.Aec);
    paramParcel.writeString(this.Aed);
    paramParcel.writeString(this.Aee);
    paramParcel.writeString(this.Aef);
    paramParcel.writeStringList(this.Aeg);
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */