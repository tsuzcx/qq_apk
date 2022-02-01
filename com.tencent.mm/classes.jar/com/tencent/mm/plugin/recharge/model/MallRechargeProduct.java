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
  public String dft;
  public int gOH;
  public boolean isDefault;
  public String oEN;
  public String uWF;
  public String uWG;
  public float uWH;
  public float uWI;
  public boolean uWJ;
  public int uWK;
  public int uWL;
  public final boolean uWM;
  public boolean uWN;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.uWH = 0.0F;
    this.uWI = 0.0F;
    this.uWN = true;
    this.uWF = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dft = paramParcel.readString();
    this.oEN = paramParcel.readString();
    this.uWG = paramParcel.readString();
    this.uWH = paramParcel.readFloat();
    this.uWI = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.uWJ = bool1;
      this.uWK = paramParcel.readInt();
      this.uWL = paramParcel.readInt();
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
      this.uWM = bool1;
      this.gOH = paramParcel.readInt();
      AppMethodBeat.o(67098);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label123;
    }
  }
  
  public MallRechargeProduct(boolean paramBoolean)
  {
    this.uWH = 0.0F;
    this.uWI = 0.0F;
    this.uWN = true;
    this.uWM = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.uWF = paramMallRechargeProduct1.uWF;
    paramMallRechargeProduct2.dft = paramMallRechargeProduct1.dft;
    paramMallRechargeProduct2.oEN = paramMallRechargeProduct1.oEN;
    paramMallRechargeProduct2.uWG = paramMallRechargeProduct1.uWG;
    paramMallRechargeProduct2.uWH = paramMallRechargeProduct1.uWH;
    paramMallRechargeProduct2.uWI = paramMallRechargeProduct1.uWI;
    paramMallRechargeProduct2.uWJ = paramMallRechargeProduct1.uWJ;
    paramMallRechargeProduct2.uWK = paramMallRechargeProduct1.uWK;
    paramMallRechargeProduct2.uWL = paramMallRechargeProduct1.uWL;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.uWN = paramMallRechargeProduct1.uWN;
    paramMallRechargeProduct2.gOH = paramMallRechargeProduct1.gOH;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.uWJ) || (this.uWK > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.uWF);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dft);
    paramParcel.writeString(this.oEN);
    paramParcel.writeString(this.uWG);
    paramParcel.writeFloat(this.uWH);
    paramParcel.writeFloat(this.uWI);
    if (this.uWJ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.uWK);
      paramParcel.writeInt(this.uWL);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.uWM) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.gOH);
      AppMethodBeat.o(67099);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */