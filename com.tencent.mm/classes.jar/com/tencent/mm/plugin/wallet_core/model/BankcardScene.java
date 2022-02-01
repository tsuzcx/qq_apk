package com.tencent.mm.plugin.wallet_core.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hl;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class BankcardScene
  extends hl
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardScene> CREATOR;
  public static int ONp;
  public static int ONq;
  public static int ONr;
  public static int ONs;
  public static int ONt;
  public static int ONu;
  public static int ONv;
  public static int ONw;
  public static int ONx;
  public static IAutoDBItem.MAutoDBInfo info;
  public int OMR;
  public String OMT;
  public String ONA;
  public String ONB;
  public String ONC;
  public double OND;
  public String ONE;
  public double ONF;
  public String ONG;
  public String ONH;
  public String ONI;
  public String ONJ;
  public String ONK;
  public b ONL;
  public String ONM;
  public e ONN;
  public long ONO;
  public long ONP;
  public long ONQ;
  public String ONR;
  public int ONS;
  public int ONT;
  public String ONU;
  public String ONV;
  public int ONW;
  public String ONX;
  public long ONY;
  public String ONZ;
  public String ONy;
  public String ONz;
  public String OOa;
  public String OOb;
  public String Ooe;
  public String Oof;
  public boolean fDD;
  
  static
  {
    AppMethodBeat.i(70236);
    ONp = 1;
    ONq = 2;
    ONr = 4;
    ONs = 8;
    ONt = 16;
    ONu = 32;
    ONv = 64;
    ONw = 128;
    ONx = 256;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "fakePk";
    localMAutoDBInfo.colsMap.put("fakePk", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" fakePk INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "fakePk";
    localMAutoDBInfo.columns[1] = "bindSerial";
    localMAutoDBInfo.colsMap.put("bindSerial", "TEXT");
    localStringBuilder.append(" bindSerial TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "defaultCardState";
    localMAutoDBInfo.colsMap.put("defaultCardState", "INTEGER");
    localStringBuilder.append(" defaultCardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "cardType";
    localMAutoDBInfo.colsMap.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "bankcardState";
    localMAutoDBInfo.colsMap.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "forbidWord";
    localMAutoDBInfo.colsMap.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "bankName";
    localMAutoDBInfo.colsMap.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bankcardType";
    localMAutoDBInfo.colsMap.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bankcardTypeName";
    localMAutoDBInfo.colsMap.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "bankcardTag";
    localMAutoDBInfo.colsMap.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "bankcardTail";
    localMAutoDBInfo.colsMap.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "supportTag";
    localMAutoDBInfo.colsMap.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "mobile";
    localMAutoDBInfo.colsMap.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "trueName";
    localMAutoDBInfo.colsMap.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bankPhone";
    localMAutoDBInfo.colsMap.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bizUsername";
    localMAutoDBInfo.colsMap.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "onceQuotaKind";
    localMAutoDBInfo.colsMap.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "onceQuotaVirtual";
    localMAutoDBInfo.colsMap.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "dayQuotaKind";
    localMAutoDBInfo.colsMap.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "dayQuotaVirtual";
    localMAutoDBInfo.colsMap.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "fetchArriveTime";
    localMAutoDBInfo.colsMap.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "fetchArriveTimeWording";
    localMAutoDBInfo.colsMap.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "repay_url";
    localMAutoDBInfo.colsMap.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "wxcreditState";
    localMAutoDBInfo.colsMap.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "bankcardClientType";
    localMAutoDBInfo.colsMap.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "ext_msg";
    localMAutoDBInfo.colsMap.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "support_micropay";
    localMAutoDBInfo.colsMap.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "arrive_type";
    localMAutoDBInfo.colsMap.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "avail_save_wording";
    localMAutoDBInfo.colsMap.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "fetch_charge_rate";
    localMAutoDBInfo.colsMap.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "full_fetch_charge_fee";
    localMAutoDBInfo.colsMap.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "fetch_charge_info";
    localMAutoDBInfo.colsMap.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "tips";
    localMAutoDBInfo.colsMap.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "forbid_title";
    localMAutoDBInfo.colsMap.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "forbid_url";
    localMAutoDBInfo.colsMap.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "no_micro_word";
    localMAutoDBInfo.colsMap.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "card_bottom_wording";
    localMAutoDBInfo.colsMap.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "support_lqt_turn_in";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "support_lqt_turn_out";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "is_hightlight_pre_arrive_time_wording";
    localMAutoDBInfo.colsMap.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "card_state_name";
    localMAutoDBInfo.colsMap.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "prompt_info_prompt_text";
    localMAutoDBInfo.colsMap.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "prompt_info_jump_text";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "prompt_info_jump_url";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70236);
  }
  
  public BankcardScene()
  {
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
  }
  
  public BankcardScene(Parcel paramParcel)
  {
    AppMethodBeat.i(70232);
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.fDD = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.ONC = paramParcel.readString();
      this.OMR = paramParcel.readInt();
      this.ONM = paramParcel.readString();
      this.field_bankcardClientType = paramParcel.readInt();
      this.field_ext_msg = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label389;
      }
    }
    label389:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.field_support_micropay = bool1;
      this.field_arrive_type = paramParcel.readString();
      this.field_fetch_charge_rate = paramParcel.readDouble();
      this.field_full_fetch_charge_fee = paramParcel.readDouble();
      this.field_no_micro_word = paramParcel.readString();
      this.field_card_bottom_wording = paramParcel.readString();
      this.ONR = paramParcel.readString();
      this.ONO = paramParcel.readLong();
      this.ONQ = paramParcel.readLong();
      this.ONP = paramParcel.readLong();
      this.ONS = paramParcel.readInt();
      this.ONW = paramParcel.readInt();
      this.ONT = paramParcel.readInt();
      this.ONU = paramParcel.readString();
      this.ONV = paramParcel.readString();
      this.ONX = paramParcel.readString();
      this.ONY = paramParcel.readLong();
      this.ONZ = paramParcel.readString();
      this.OOa = paramParcel.readString();
      this.OOb = paramParcel.readString();
      this.Ooe = paramParcel.readString();
      this.Oof = paramParcel.readString();
      AppMethodBeat.o(70232);
      return;
      bool1 = false;
      break;
    }
  }
  
  public BankcardScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
    this.ONy = paramString1;
    this.ONz = paramString2;
    this.OMT = paramString3;
    this.ONA = paramString4;
    this.ONB = paramString5;
    this.ONC = paramString6;
    this.OND = paramDouble1;
    this.ONE = paramString7;
    this.ONF = paramDouble2;
    this.ONG = paramString8;
    this.ONH = paramString9;
    this.ONI = paramString10;
    this.ONJ = paramString11;
    this.ONK = paramString12;
    this.ONL = paramb;
    this.OMR = paramInt1;
    this.ONM = paramString13;
    this.fDD = paramBoolean;
    this.ONN = parame;
    this.ONO = paramLong1;
    this.ONP = paramLong2;
    this.ONQ = paramLong3;
    this.ONR = paramString14;
    this.ONS = paramInt2;
    this.ONT = paramInt3;
    this.ONU = paramString15;
    this.ONV = paramString16;
    this.ONW = paramInt4;
    this.ONX = paramString17;
    this.ONY = paramLong4;
    this.ONZ = paramString18;
    this.OOa = paramString19;
    this.OOb = paramString20;
    this.Ooe = paramString21;
    this.Oof = paramString22;
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
    if (this.fDD)
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
      paramParcel.writeString(this.ONC);
      paramParcel.writeInt(this.OMR);
      paramParcel.writeString(this.ONM);
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
      paramParcel.writeString(this.ONR);
      paramParcel.writeLong(this.ONO);
      paramParcel.writeLong(this.ONQ);
      paramParcel.writeLong(this.ONP);
      paramParcel.writeInt(this.ONS);
      paramParcel.writeInt(this.ONW);
      paramParcel.writeInt(this.ONT);
      paramParcel.writeString(this.ONU);
      paramParcel.writeString(this.ONV);
      paramParcel.writeString(this.ONX);
      paramParcel.writeLong(this.ONY);
      paramParcel.writeString(this.ONZ);
      paramParcel.writeString(this.OOa);
      paramParcel.writeString(this.OOb);
      paramParcel.writeString(this.Ooe);
      paramParcel.writeString(this.Oof);
      AppMethodBeat.o(70233);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BankcardScene
 * JD-Core Version:    0.7.0.1
 */