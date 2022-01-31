package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.protocal.c.vv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BankcardElemParcel
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardElemParcel> CREATOR = new BankcardElemParcel.1();
  public String lnT;
  public String mOb;
  public String nve;
  public int nvf;
  public int nvg;
  public String nvh;
  public String nvi;
  public String nvj;
  public ArrayList<EnterTimeParcel> nvk;
  
  public BankcardElemParcel() {}
  
  public BankcardElemParcel(Parcel paramParcel)
  {
    this.mOb = paramParcel.readString();
    this.lnT = paramParcel.readString();
    this.nve = paramParcel.readString();
    this.nvf = paramParcel.readInt();
    this.nvg = paramParcel.readInt();
    this.nvk = new ArrayList();
    paramParcel.readTypedList(this.nvk, EnterTimeParcel.CREATOR);
    this.nvh = paramParcel.readString();
    this.nvi = paramParcel.readString();
    this.nvj = paramParcel.readString();
  }
  
  public BankcardElemParcel(fx paramfx)
  {
    this.mOb = paramfx.mOb;
    this.lnT = paramfx.lnT;
    this.nve = paramfx.nve;
    this.nvf = paramfx.nvf;
    this.nvg = paramfx.nvg;
    this.nvh = paramfx.nvh;
    this.nvi = paramfx.nvi;
    this.nvj = paramfx.nvj;
    this.nvk = new ArrayList();
    paramfx = paramfx.szX.iterator();
    while (paramfx.hasNext())
    {
      EnterTimeParcel localEnterTimeParcel = new EnterTimeParcel((vv)paramfx.next());
      this.nvk.add(localEnterTimeParcel);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mOb);
    paramParcel.writeString(this.lnT);
    paramParcel.writeString(this.nve);
    paramParcel.writeInt(this.nvf);
    paramParcel.writeInt(this.nvg);
    paramParcel.writeTypedList(this.nvk);
    paramParcel.writeString(this.nvh);
    paramParcel.writeString(this.nvi);
    paramParcel.writeString(this.nvj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel
 * JD-Core Version:    0.7.0.1
 */