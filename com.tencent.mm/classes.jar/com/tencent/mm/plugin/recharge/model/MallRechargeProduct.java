package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct
  implements Parcelable
{
  public static final Parcelable.Creator<MallRechargeProduct> CREATOR;
  public int BCM;
  public String NwI;
  public float NwJ;
  public float NwK;
  public int NwL;
  public final boolean NwM;
  public boolean NwN;
  public boolean UN;
  public String appId;
  public boolean oBZ;
  public int omE;
  public String productId;
  public String qBb;
  public String xVh;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.NwJ = 0.0F;
    this.NwK = 0.0F;
    this.NwN = true;
    this.qBb = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.xVh = paramParcel.readString();
    this.NwI = paramParcel.readString();
    this.NwJ = paramParcel.readFloat();
    this.NwK = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.UN = bool1;
      this.NwL = paramParcel.readInt();
      this.BCM = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label162;
      }
      bool1 = true;
      label123:
      this.oBZ = bool1;
      if (paramParcel.readInt() != 1) {
        break label167;
      }
    }
    label162:
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.NwM = bool1;
      this.omE = paramParcel.readInt();
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
    this.NwJ = 0.0F;
    this.NwK = 0.0F;
    this.NwN = true;
    this.NwM = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.qBb = paramMallRechargeProduct1.qBb;
    paramMallRechargeProduct2.productId = paramMallRechargeProduct1.productId;
    paramMallRechargeProduct2.xVh = paramMallRechargeProduct1.xVh;
    paramMallRechargeProduct2.NwI = paramMallRechargeProduct1.NwI;
    paramMallRechargeProduct2.NwJ = paramMallRechargeProduct1.NwJ;
    paramMallRechargeProduct2.NwK = paramMallRechargeProduct1.NwK;
    paramMallRechargeProduct2.UN = paramMallRechargeProduct1.UN;
    paramMallRechargeProduct2.NwL = paramMallRechargeProduct1.NwL;
    paramMallRechargeProduct2.BCM = paramMallRechargeProduct1.BCM;
    paramMallRechargeProduct2.oBZ = paramMallRechargeProduct1.oBZ;
    paramMallRechargeProduct2.NwN = paramMallRechargeProduct1.NwN;
    paramMallRechargeProduct2.omE = paramMallRechargeProduct1.omE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.UN) || (this.NwL > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.qBb);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.xVh);
    paramParcel.writeString(this.NwI);
    paramParcel.writeFloat(this.NwJ);
    paramParcel.writeFloat(this.NwK);
    if (this.UN)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.NwL);
      paramParcel.writeInt(this.BCM);
      if (!this.oBZ) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.NwM) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.omE);
      AppMethodBeat.o(67099);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */