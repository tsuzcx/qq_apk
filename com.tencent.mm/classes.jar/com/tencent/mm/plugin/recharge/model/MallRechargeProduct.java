package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct
  implements Parcelable
{
  public static final Parcelable.Creator<MallRechargeProduct> CREATOR = new MallRechargeProduct.1();
  public String appId;
  public String bJd;
  public int dWX;
  public boolean isDefault;
  public String jfG;
  public float npA = 0.0F;
  public float npB = 0.0F;
  public boolean npC;
  public int npD;
  public int npE;
  public final boolean npF;
  public boolean npG = true;
  public String npy;
  public String npz;
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    this.npy = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.bJd = paramParcel.readString();
    this.jfG = paramParcel.readString();
    this.npz = paramParcel.readString();
    this.npA = paramParcel.readFloat();
    this.npB = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.npC = bool1;
      this.npD = paramParcel.readInt();
      this.npE = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label118:
      this.isDefault = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.npF = bool1;
      this.dWX = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label118;
    }
  }
  
  public MallRechargeProduct(boolean paramBoolean)
  {
    this.npF = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.npy = paramMallRechargeProduct1.npy;
    paramMallRechargeProduct2.bJd = paramMallRechargeProduct1.bJd;
    paramMallRechargeProduct2.jfG = paramMallRechargeProduct1.jfG;
    paramMallRechargeProduct2.npz = paramMallRechargeProduct1.npz;
    paramMallRechargeProduct2.npA = paramMallRechargeProduct1.npA;
    paramMallRechargeProduct2.npB = paramMallRechargeProduct1.npB;
    paramMallRechargeProduct2.npC = paramMallRechargeProduct1.npC;
    paramMallRechargeProduct2.npD = paramMallRechargeProduct1.npD;
    paramMallRechargeProduct2.npE = paramMallRechargeProduct1.npE;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.npG = paramMallRechargeProduct1.npG;
    paramMallRechargeProduct2.dWX = paramMallRechargeProduct1.dWX;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.npC) || (this.npD > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.npy);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.bJd);
    paramParcel.writeString(this.jfG);
    paramParcel.writeString(this.npz);
    paramParcel.writeFloat(this.npA);
    paramParcel.writeFloat(this.npB);
    if (this.npC)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.npD);
      paramParcel.writeInt(this.npE);
      if (!this.isDefault) {
        break label130;
      }
      paramInt = 1;
      label97:
      paramParcel.writeInt(paramInt);
      if (!this.npF) {
        break label135;
      }
    }
    label130:
    label135:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.dWX);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */