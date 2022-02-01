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
  public String CWL;
  public int CWM;
  public String CWN;
  public String CWO;
  public String CWP;
  public List<String> CWQ;
  
  static
  {
    AppMethodBeat.i(70280);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70280);
  }
  
  public FavorPayInfo()
  {
    AppMethodBeat.i(70276);
    this.CWQ = new LinkedList();
    AppMethodBeat.o(70276);
  }
  
  public FavorPayInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(70277);
    this.CWQ = new LinkedList();
    this.CWL = paramParcel.readString();
    this.CWM = paramParcel.readInt();
    this.CWN = paramParcel.readString();
    this.CWO = paramParcel.readString();
    this.CWP = paramParcel.readString();
    this.CWQ = paramParcel.createStringArrayList();
    AppMethodBeat.o(70277);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(70279);
    Object localObject = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.CWL, Integer.valueOf(this.CWM), this.CWN, this.CWO, this.CWP }));
    if (this.CWQ != null)
    {
      ((StringBuffer)localObject).append("bind_serial_list :");
      Iterator localIterator = this.CWQ.iterator();
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
    paramParcel.writeString(this.CWL);
    paramParcel.writeInt(this.CWM);
    paramParcel.writeString(this.CWN);
    paramParcel.writeString(this.CWO);
    paramParcel.writeString(this.CWP);
    paramParcel.writeStringList(this.CWQ);
    AppMethodBeat.o(70278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */