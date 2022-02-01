package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallRechargeProduct
  implements Parcelable
{
  public static final Parcelable.Creator<MallRechargeProduct> CREATOR;
  public String Hzd;
  public float Hze;
  public float Hzf;
  public boolean Hzg;
  public int Hzh;
  public int Hzi;
  public final boolean Hzj;
  public boolean Hzk;
  public String appId;
  public boolean lJx;
  public int lvh;
  public String nBK;
  public String productId;
  public String uMF;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.Hze = 0.0F;
    this.Hzf = 0.0F;
    this.Hzk = true;
    this.nBK = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.productId = paramParcel.readString();
    this.uMF = paramParcel.readString();
    this.Hzd = paramParcel.readString();
    this.Hze = paramParcel.readFloat();
    this.Hzf = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.Hzg = bool1;
      this.Hzh = paramParcel.readInt();
      this.Hzi = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label162;
      }
      bool1 = true;
      label123:
      this.lJx = bool1;
      if (paramParcel.readInt() != 1) {
        break label167;
      }
    }
    label162:
    label167:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Hzj = bool1;
      this.lvh = paramParcel.readInt();
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
    this.Hze = 0.0F;
    this.Hzf = 0.0F;
    this.Hzk = true;
    this.Hzj = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.nBK = paramMallRechargeProduct1.nBK;
    paramMallRechargeProduct2.productId = paramMallRechargeProduct1.productId;
    paramMallRechargeProduct2.uMF = paramMallRechargeProduct1.uMF;
    paramMallRechargeProduct2.Hzd = paramMallRechargeProduct1.Hzd;
    paramMallRechargeProduct2.Hze = paramMallRechargeProduct1.Hze;
    paramMallRechargeProduct2.Hzf = paramMallRechargeProduct1.Hzf;
    paramMallRechargeProduct2.Hzg = paramMallRechargeProduct1.Hzg;
    paramMallRechargeProduct2.Hzh = paramMallRechargeProduct1.Hzh;
    paramMallRechargeProduct2.Hzi = paramMallRechargeProduct1.Hzi;
    paramMallRechargeProduct2.lJx = paramMallRechargeProduct1.lJx;
    paramMallRechargeProduct2.Hzk = paramMallRechargeProduct1.Hzk;
    paramMallRechargeProduct2.lvh = paramMallRechargeProduct1.lvh;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.Hzg) || (this.Hzh > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.nBK);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.productId);
    paramParcel.writeString(this.uMF);
    paramParcel.writeString(this.Hzd);
    paramParcel.writeFloat(this.Hze);
    paramParcel.writeFloat(this.Hzf);
    if (this.Hzg)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.Hzh);
      paramParcel.writeInt(this.Hzi);
      if (!this.lJx) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.Hzj) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.lvh);
      AppMethodBeat.o(67099);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */