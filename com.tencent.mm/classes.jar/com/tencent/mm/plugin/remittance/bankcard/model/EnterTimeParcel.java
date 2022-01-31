package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.vv;

public class EnterTimeParcel
  implements Parcelable
{
  public static final Parcelable.Creator<EnterTimeParcel> CREATOR = new EnterTimeParcel.1();
  public String color;
  public int nvl;
  public String nvm;
  public String nvn;
  public int nvo;
  
  public EnterTimeParcel() {}
  
  public EnterTimeParcel(Parcel paramParcel)
  {
    this.nvl = paramParcel.readInt();
    this.nvm = paramParcel.readString();
    this.nvn = paramParcel.readString();
    this.nvo = paramParcel.readInt();
    this.color = paramParcel.readString();
  }
  
  public EnterTimeParcel(vv paramvv)
  {
    this.nvl = paramvv.nvl;
    this.nvm = paramvv.nvm;
    this.nvn = paramvv.nvn;
    this.nvo = paramvv.nvo;
    this.color = paramvv.color;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.nvl);
    paramParcel.writeString(this.nvm);
    paramParcel.writeString(this.nvn);
    paramParcel.writeInt(this.nvo);
    paramParcel.writeString(this.color);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel
 * JD-Core Version:    0.7.0.1
 */