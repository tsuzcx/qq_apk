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
  public String dpp;
  public int hKr;
  public boolean isDefault;
  public String jFZ;
  public String pSt;
  public String xDa;
  public float xDb;
  public float xDc;
  public boolean xDd;
  public int xDe;
  public int xDf;
  public final boolean xDg;
  public boolean xDh;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.xDb = 0.0F;
    this.xDc = 0.0F;
    this.xDh = true;
    this.jFZ = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dpp = paramParcel.readString();
    this.pSt = paramParcel.readString();
    this.xDa = paramParcel.readString();
    this.xDb = paramParcel.readFloat();
    this.xDc = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.xDd = bool1;
      this.xDe = paramParcel.readInt();
      this.xDf = paramParcel.readInt();
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
      this.xDg = bool1;
      this.hKr = paramParcel.readInt();
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
    this.xDb = 0.0F;
    this.xDc = 0.0F;
    this.xDh = true;
    this.xDg = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.jFZ = paramMallRechargeProduct1.jFZ;
    paramMallRechargeProduct2.dpp = paramMallRechargeProduct1.dpp;
    paramMallRechargeProduct2.pSt = paramMallRechargeProduct1.pSt;
    paramMallRechargeProduct2.xDa = paramMallRechargeProduct1.xDa;
    paramMallRechargeProduct2.xDb = paramMallRechargeProduct1.xDb;
    paramMallRechargeProduct2.xDc = paramMallRechargeProduct1.xDc;
    paramMallRechargeProduct2.xDd = paramMallRechargeProduct1.xDd;
    paramMallRechargeProduct2.xDe = paramMallRechargeProduct1.xDe;
    paramMallRechargeProduct2.xDf = paramMallRechargeProduct1.xDf;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.xDh = paramMallRechargeProduct1.xDh;
    paramMallRechargeProduct2.hKr = paramMallRechargeProduct1.hKr;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.xDd) || (this.xDe > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.jFZ);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dpp);
    paramParcel.writeString(this.pSt);
    paramParcel.writeString(this.xDa);
    paramParcel.writeFloat(this.xDb);
    paramParcel.writeFloat(this.xDc);
    if (this.xDd)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.xDe);
      paramParcel.writeInt(this.xDf);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.xDg) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hKr);
      AppMethodBeat.o(67099);
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