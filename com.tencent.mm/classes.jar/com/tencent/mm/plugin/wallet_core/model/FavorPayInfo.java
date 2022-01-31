package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FavorPayInfo> CREATOR = new FavorPayInfo.1();
  public String qvC;
  public int qvD;
  public String qvE;
  public String qvF;
  public String qvG;
  public List<String> qvH = new LinkedList();
  
  public FavorPayInfo() {}
  
  public FavorPayInfo(Parcel paramParcel)
  {
    this.qvC = paramParcel.readString();
    this.qvD = paramParcel.readInt();
    this.qvE = paramParcel.readString();
    this.qvF = paramParcel.readString();
    this.qvG = paramParcel.readString();
    this.qvH = paramParcel.createStringArrayList();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(String.format("FavorPayInfo %s isNeedBankPay %s needBankType %s defaultFavorCompId %s changeBankcardTips %s", new Object[] { this.qvC, Integer.valueOf(this.qvD), this.qvE, this.qvF, this.qvG }));
    if (this.qvH != null)
    {
      localStringBuffer.append("bind_serial_list :");
      Iterator localIterator = this.qvH.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuffer.append(str + ",");
      }
    }
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.qvC);
    paramParcel.writeInt(this.qvD);
    paramParcel.writeString(this.qvE);
    paramParcel.writeString(this.qvF);
    paramParcel.writeString(this.qvG);
    paramParcel.writeStringList(this.qvH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.FavorPayInfo
 * JD-Core Version:    0.7.0.1
 */