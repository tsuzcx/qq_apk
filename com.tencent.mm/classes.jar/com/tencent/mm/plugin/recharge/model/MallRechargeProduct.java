package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct
  implements Parcelable
{
  public static final Parcelable.Creator<MallRechargeProduct> CREATOR;
  public String BCZ;
  public float BDa;
  public float BDb;
  public boolean BDc;
  public int BDd;
  public int BDe;
  public final boolean BDf;
  public boolean BDg;
  public String appId;
  public int iFf;
  public boolean isDefault;
  public String kHR;
  public String productId;
  public String rjt;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.BDa = 0.0F;
    this.BDb = 0.0F;
    this.BDg = true;
    this.kHR = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.rjt = paramParcel.readString();
    this.BCZ = paramParcel.readString();
    this.BDa = paramParcel.readFloat();
    this.BDb = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.BDc = bool1;
      this.BDd = paramParcel.readInt();
      this.BDe = paramParcel.readInt();
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
      this.BDf = bool1;
      this.iFf = paramParcel.readInt();
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
    this.BDa = 0.0F;
    this.BDb = 0.0F;
    this.BDg = true;
    this.BDf = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.kHR = paramMallRechargeProduct1.kHR;
    paramMallRechargeProduct2.productId = paramMallRechargeProduct1.productId;
    paramMallRechargeProduct2.rjt = paramMallRechargeProduct1.rjt;
    paramMallRechargeProduct2.BCZ = paramMallRechargeProduct1.BCZ;
    paramMallRechargeProduct2.BDa = paramMallRechargeProduct1.BDa;
    paramMallRechargeProduct2.BDb = paramMallRechargeProduct1.BDb;
    paramMallRechargeProduct2.BDc = paramMallRechargeProduct1.BDc;
    paramMallRechargeProduct2.BDd = paramMallRechargeProduct1.BDd;
    paramMallRechargeProduct2.BDe = paramMallRechargeProduct1.BDe;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.BDg = paramMallRechargeProduct1.BDg;
    paramMallRechargeProduct2.iFf = paramMallRechargeProduct1.iFf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.BDc) || (this.BDd > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.kHR);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.rjt);
    paramParcel.writeString(this.BCZ);
    paramParcel.writeFloat(this.BDa);
    paramParcel.writeFloat(this.BDb);
    if (this.BDc)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.BDd);
      paramParcel.writeInt(this.BDe);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.BDf) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.iFf);
      AppMethodBeat.o(67099);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */