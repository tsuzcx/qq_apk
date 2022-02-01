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
  public String dok;
  public int hHz;
  public boolean isDefault;
  public String jDb;
  public String pLO;
  public String xnd;
  public float xne;
  public float xnf;
  public boolean xng;
  public int xnh;
  public int xni;
  public final boolean xnj;
  public boolean xnk;
  
  static
  {
    AppMethodBeat.i(67100);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(67100);
  }
  
  public MallRechargeProduct(Parcel paramParcel)
  {
    AppMethodBeat.i(67098);
    this.xne = 0.0F;
    this.xnf = 0.0F;
    this.xnk = true;
    this.jDb = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dok = paramParcel.readString();
    this.pLO = paramParcel.readString();
    this.xnd = paramParcel.readString();
    this.xne = paramParcel.readFloat();
    this.xnf = paramParcel.readFloat();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.xng = bool1;
      this.xnh = paramParcel.readInt();
      this.xni = paramParcel.readInt();
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
      this.xnj = bool1;
      this.hHz = paramParcel.readInt();
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
    this.xne = 0.0F;
    this.xnf = 0.0F;
    this.xnk = true;
    this.xnj = paramBoolean;
  }
  
  public static void a(MallRechargeProduct paramMallRechargeProduct1, MallRechargeProduct paramMallRechargeProduct2)
  {
    paramMallRechargeProduct2.appId = paramMallRechargeProduct1.appId;
    paramMallRechargeProduct2.jDb = paramMallRechargeProduct1.jDb;
    paramMallRechargeProduct2.dok = paramMallRechargeProduct1.dok;
    paramMallRechargeProduct2.pLO = paramMallRechargeProduct1.pLO;
    paramMallRechargeProduct2.xnd = paramMallRechargeProduct1.xnd;
    paramMallRechargeProduct2.xne = paramMallRechargeProduct1.xne;
    paramMallRechargeProduct2.xnf = paramMallRechargeProduct1.xnf;
    paramMallRechargeProduct2.xng = paramMallRechargeProduct1.xng;
    paramMallRechargeProduct2.xnh = paramMallRechargeProduct1.xnh;
    paramMallRechargeProduct2.xni = paramMallRechargeProduct1.xni;
    paramMallRechargeProduct2.isDefault = paramMallRechargeProduct1.isDefault;
    paramMallRechargeProduct2.xnk = paramMallRechargeProduct1.xnk;
    paramMallRechargeProduct2.hHz = paramMallRechargeProduct1.hHz;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean isValid()
  {
    return (!this.xng) || (this.xnh > 0);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(67099);
    paramParcel.writeString(this.jDb);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dok);
    paramParcel.writeString(this.pLO);
    paramParcel.writeString(this.xnd);
    paramParcel.writeFloat(this.xne);
    paramParcel.writeFloat(this.xnf);
    if (this.xng)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.xnh);
      paramParcel.writeInt(this.xni);
      if (!this.isDefault) {
        break label140;
      }
      paramInt = 1;
      label102:
      paramParcel.writeInt(paramInt);
      if (!this.xnj) {
        break label145;
      }
    }
    label140:
    label145:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hHz);
      AppMethodBeat.o(67099);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label102;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.MallRechargeProduct
 * JD-Core Version:    0.7.0.1
 */