package com.tencent.mm.plugin.wallet_core.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ih;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class BankcardScene
  extends ih
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardScene> CREATOR;
  public static int VDa;
  public static int VDb;
  public static int VDc;
  public static int VDd;
  public static int VDe;
  public static int VDf;
  public static int VDg;
  public static int VDh;
  public static int VDi;
  public static IAutoDBItem.MAutoDBInfo info;
  public int VCC;
  public String VCE;
  public long VDA;
  public long VDB;
  public String VDC;
  public int VDD;
  public int VDE;
  public String VDF;
  public String VDG;
  public int VDH;
  public String VDI;
  public long VDJ;
  public String VDK;
  public String VDL;
  public String VDM;
  public String VDj;
  public String VDk;
  public String VDl;
  public String VDm;
  public String VDn;
  public double VDo;
  public String VDp;
  public double VDq;
  public String VDr;
  public String VDs;
  public String VDt;
  public String VDu;
  public String VDv;
  public b VDw;
  public String VDx;
  public e VDy;
  public long VDz;
  public String VcU;
  public String VcV;
  public boolean hIt;
  
  static
  {
    AppMethodBeat.i(70236);
    VDa = 1;
    VDb = 2;
    VDc = 4;
    VDd = 8;
    VDe = 16;
    VDf = 32;
    VDg = 64;
    VDh = 128;
    VDi = 256;
    info = ih.aJm();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70236);
  }
  
  public BankcardScene()
  {
    this.VDn = null;
    this.VDx = null;
    this.hIt = false;
  }
  
  public BankcardScene(Parcel paramParcel)
  {
    AppMethodBeat.i(70232);
    this.VDn = null;
    this.VDx = null;
    this.hIt = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.hIt = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.VDn = paramParcel.readString();
      this.VCC = paramParcel.readInt();
      this.VDx = paramParcel.readString();
      this.field_bankcardClientType = paramParcel.readInt();
      this.field_ext_msg = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label387;
      }
    }
    label387:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.field_support_micropay = bool1;
      this.field_arrive_type = paramParcel.readString();
      this.field_fetch_charge_rate = paramParcel.readDouble();
      this.field_full_fetch_charge_fee = paramParcel.readDouble();
      this.field_no_micro_word = paramParcel.readString();
      this.field_card_bottom_wording = paramParcel.readString();
      this.VDC = paramParcel.readString();
      this.VDz = paramParcel.readLong();
      this.VDB = paramParcel.readLong();
      this.VDA = paramParcel.readLong();
      this.VDD = paramParcel.readInt();
      this.VDH = paramParcel.readInt();
      this.VDE = paramParcel.readInt();
      this.VDF = paramParcel.readString();
      this.VDG = paramParcel.readString();
      this.VDI = paramParcel.readString();
      this.VDJ = paramParcel.readLong();
      this.VDK = paramParcel.readString();
      this.VDL = paramParcel.readString();
      this.VDM = paramParcel.readString();
      this.VcU = paramParcel.readString();
      this.VcV = paramParcel.readString();
      AppMethodBeat.o(70232);
      return;
      bool1 = false;
      break;
    }
  }
  
  public BankcardScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.VDn = null;
    this.VDx = null;
    this.hIt = false;
    this.VDj = paramString1;
    this.VDk = paramString2;
    this.VCE = paramString3;
    this.VDl = paramString4;
    this.VDm = paramString5;
    this.VDn = paramString6;
    this.VDo = paramDouble1;
    this.VDp = paramString7;
    this.VDq = paramDouble2;
    this.VDr = paramString8;
    this.VDs = paramString9;
    this.VDt = paramString10;
    this.VDu = paramString11;
    this.VDv = paramString12;
    this.VDw = paramb;
    this.VCC = paramInt1;
    this.VDx = paramString13;
    this.hIt = paramBoolean;
    this.VDy = parame;
    this.VDz = paramLong1;
    this.VDA = paramLong2;
    this.VDB = paramLong3;
    this.VDC = paramString14;
    this.VDD = paramInt2;
    this.VDE = paramInt3;
    this.VDF = paramString15;
    this.VDG = paramString16;
    this.VDH = paramInt4;
    this.VDI = paramString17;
    this.VDJ = paramLong4;
    this.VDK = paramString18;
    this.VDL = paramString19;
    this.VDM = paramString20;
    this.VcU = paramString21;
    this.VcV = paramString22;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70234);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(70234);
  }
  
  public ContentValues convertTo()
  {
    AppMethodBeat.i(70235);
    ContentValues localContentValues = super.convertTo();
    localContentValues.remove("fakePk");
    AppMethodBeat.o(70235);
    return localContentValues;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70233);
    paramParcel.writeString(this.field_bankName);
    paramParcel.writeString(this.field_desc);
    paramParcel.writeString(this.field_bankcardType);
    paramParcel.writeString(this.field_bindSerial);
    paramParcel.writeInt(this.field_cardType);
    if (this.hIt)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.field_mobile);
      paramParcel.writeDouble(this.field_onceQuotaKind);
      paramParcel.writeDouble(this.field_onceQuotaVirtual);
      paramParcel.writeDouble(this.field_dayQuotaKind);
      paramParcel.writeDouble(this.field_dayQuotaVirtual);
      paramParcel.writeString(this.field_bankcardTail);
      paramParcel.writeString(this.field_bankPhone);
      paramParcel.writeInt(this.field_bankcardTag);
      paramParcel.writeInt(this.field_bankcardState);
      paramParcel.writeString(this.VDn);
      paramParcel.writeInt(this.VCC);
      paramParcel.writeString(this.VDx);
      paramParcel.writeInt(this.field_bankcardClientType);
      paramParcel.writeString(this.field_ext_msg);
      if (!this.field_support_micropay) {
        break label368;
      }
    }
    label368:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.field_arrive_type);
      paramParcel.writeDouble(this.field_fetch_charge_rate);
      paramParcel.writeDouble(this.field_full_fetch_charge_fee);
      paramParcel.writeString(this.field_no_micro_word);
      paramParcel.writeString(this.field_card_bottom_wording);
      paramParcel.writeString(this.VDC);
      paramParcel.writeLong(this.VDz);
      paramParcel.writeLong(this.VDB);
      paramParcel.writeLong(this.VDA);
      paramParcel.writeInt(this.VDD);
      paramParcel.writeInt(this.VDH);
      paramParcel.writeInt(this.VDE);
      paramParcel.writeString(this.VDF);
      paramParcel.writeString(this.VDG);
      paramParcel.writeString(this.VDI);
      paramParcel.writeLong(this.VDJ);
      paramParcel.writeString(this.VDK);
      paramParcel.writeString(this.VDL);
      paramParcel.writeString(this.VDM);
      paramParcel.writeString(this.VcU);
      paramParcel.writeString(this.VcV);
      AppMethodBeat.o(70233);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BankcardScene
 * JD-Core Version:    0.7.0.1
 */