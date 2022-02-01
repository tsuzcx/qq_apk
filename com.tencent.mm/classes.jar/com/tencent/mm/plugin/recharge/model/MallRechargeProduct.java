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
  public String dcO;
  public int hph;
  public boolean isDefault;
  public String pio;
  public int wfA;
  public final boolean wfB;
  public boolean wfC;
  public String wfu;
  public String wfv;
  public float wfw;
  public float wfx;
  public boolean wfy;
  public int wfz;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.wfw = 0.0F;
    this.wfx = 0.0F;
    this.wfC = true;
    this.wfu = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dcO = paramParcel.readString();
    this.pio = paramParcel.readString();
    this.wfv = paramParcel.readString();
    this.wfw = paramParcel.readFloat();
    this.wfx = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.wfy = bool1;
      this.wfz = paramParcel.readInt();
      this.wfA = paramParcel.readInt();
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
      this.wfB = bool1;
      this.hph = paramParcel.readInt();
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
    this.wfw = 0.0F;
    this.wfx = 0.0F;
    this.wfC = true;
    this.wfB = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.wfu = paramMallRechargeProduct1.wfu;
    paramMallRechargeProduct2.dcO = paramMallRechargeProduct1.dcO;
    paramMallRechargeProduct2.pio = paramMallRechargeProduct1.pio;
    paramMallRechargeProduct2.wfv = paramMallRechargeProduct1.wfv;
    paramMallRechargeProduct2.wfw = paramMallRechargeProduct1.wfw;
    paramMallRechargeProduct2.wfx = paramMallRechargeProduct1.wfx;
    paramMallRechargeProduct2.wfy = paramMallRechargeProduct1.wfy;
    paramMallRechargeProduct2.wfz = paramMallRechargeProduct1.wfz;
    paramMallRechargeProduct2.wfA = paramMallRechargeProduct1.wfA;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.wfC = paramMallRechargeProduct1.wfC;
    paramMallRechargeProduct2.hph = paramMallRechargeProduct1.hph;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.wfy) || (this.wfz > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.wfu);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dcO);
    paramParcel.writeString(this.pio);
    paramParcel.writeString(this.wfv);
    paramParcel.writeFloat(this.wfw);
    paramParcel.writeFloat(this.wfx);
    if (this.wfy)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.wfz);
      paramParcel.writeInt(this.wfA);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.wfB) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hph);
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