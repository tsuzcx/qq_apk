package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct
  implements Parcelable
{
  public static final Parcelable.Creator<MallRechargeProduct> CREATOR;
  public String appId;
  public String cqx;
  public int fnf;
  public boolean isDefault;
  public String loz;
  public String pUM;
  public String pUN;
  public float pUO;
  public float pUP;
  public boolean pUQ;
  public int pUR;
  public int pUS;
  public final boolean pUT;
  public boolean pUU;
  
  static
  {
    AppMethodBeat.i(44192);
    CREATOR = new MallRechargeProduct.1();
    AppMethodBeat.o(44192);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(44190);
    this.pUO = 0.0F;
    this.pUP = 0.0F;
    this.pUU = true;
    this.pUM = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.cqx = paramParcel.readString();
    this.loz = paramParcel.readString();
    this.pUN = paramParcel.readString();
    this.pUO = paramParcel.readFloat();
    this.pUP = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.pUQ = bool1;
      this.pUR = paramParcel.readInt();
      this.pUS = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label162;
      }
      bool1 = true;
      label123:
      this.isDefault = bool1;
      if (paramParcel.readInt() != 1) {
        break label167;
      }
    }
    label162:
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pUT = bool1;
      this.fnf = paramParcel.readInt();
      AppMethodBeat.o(44190);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label123;
    }
  }
  
  public MallRechargeProduct(boolean paramBoolean)
  {
    this.pUO = 0.0F;
    this.pUP = 0.0F;
    this.pUU = true;
    this.pUT = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.pUM = paramMallRechargeProduct1.pUM;
    paramMallRechargeProduct2.cqx = paramMallRechargeProduct1.cqx;
    paramMallRechargeProduct2.loz = paramMallRechargeProduct1.loz;
    paramMallRechargeProduct2.pUN = paramMallRechargeProduct1.pUN;
    paramMallRechargeProduct2.pUO = paramMallRechargeProduct1.pUO;
    paramMallRechargeProduct2.pUP = paramMallRechargeProduct1.pUP;
    paramMallRechargeProduct2.pUQ = paramMallRechargeProduct1.pUQ;
    paramMallRechargeProduct2.pUR = paramMallRechargeProduct1.pUR;
    paramMallRechargeProduct2.pUS = paramMallRechargeProduct1.pUS;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.pUU = paramMallRechargeProduct1.pUU;
    paramMallRechargeProduct2.fnf = paramMallRechargeProduct1.fnf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.pUQ) || (this.pUR > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(44191);
    paramParcel.writeString(this.pUM);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cqx);
    paramParcel.writeString(this.loz);
    paramParcel.writeString(this.pUN);
    paramParcel.writeFloat(this.pUO);
    paramParcel.writeFloat(this.pUP);
    if (this.pUQ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.pUR);
      paramParcel.writeInt(this.pUS);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.pUT) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.fnf);
      AppMethodBeat.o(44191);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */