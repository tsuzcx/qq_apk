package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.byw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<TransferRecordParcel> CREATOR = new TransferRecordParcel.1();
  public String lnT;
  public String mOb;
  public String nvA;
  public String nvB;
  public String nve;
  public String nvy;
  public String nvz;
  
  public TransferRecordParcel() {}
  
  protected TransferRecordParcel(Parcel paramParcel)
  {
    this.nvy = paramParcel.readString();
    this.nvz = paramParcel.readString();
    this.nve = paramParcel.readString();
    this.lnT = paramParcel.readString();
    this.mOb = paramParcel.readString();
    this.nvA = paramParcel.readString();
    this.nvB = paramParcel.readString();
  }
  
  private TransferRecordParcel(byw parambyw)
  {
    this.nvy = parambyw.nvy;
    this.nvz = parambyw.nvz;
    this.nve = parambyw.nve;
    this.lnT = parambyw.lnT;
    this.mOb = parambyw.mOb;
    this.nvA = parambyw.nvA;
    this.nvB = parambyw.nvB;
  }
  
  public static ArrayList<TransferRecordParcel> ci(List<byw> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new TransferRecordParcel((byw)paramList.next()));
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.nvy);
    paramParcel.writeString(this.nvz);
    paramParcel.writeString(this.nve);
    paramParcel.writeString(this.lnT);
    paramParcel.writeString(this.mOb);
    paramParcel.writeString(this.nvA);
    paramParcel.writeString(this.nvB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel
 * JD-Core Version:    0.7.0.1
 */