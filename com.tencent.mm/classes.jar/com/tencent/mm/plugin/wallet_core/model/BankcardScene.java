package com.tencent.mm.plugin.wallet_core.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class BankcardScene
  extends gt
  implements Parcelable
{
  public static final Parcelable.Creator<BankcardScene> CREATOR;
  public static int DlV;
  public static int DlW;
  public static int DlX;
  public static int DlY;
  public static int DlZ;
  public static int Dma;
  public static int Dmb;
  public static int Dmc;
  public static int Dmd;
  public static c.a info;
  public String CRv;
  public String CRw;
  public int Dlx;
  public String Dlz;
  public int DmA;
  public String DmB;
  public String DmC;
  public int DmD;
  public String DmE;
  public long DmF;
  public String DmG;
  public String DmH;
  public String DmI;
  public String Dme;
  public String Dmf;
  public String Dmg;
  public String Dmh;
  public String Dmi;
  public double Dmj;
  public String Dmk;
  public double Dml;
  public String Dmm;
  public String Dmn;
  public String Dmo;
  public String Dmp;
  public String Dmq;
  public b Dmr;
  public String Dms;
  public boolean Dmt;
  public e Dmu;
  public long Dmv;
  public long Dmw;
  public long Dmx;
  public String Dmy;
  public int Dmz;
  
  static
  {
    AppMethodBeat.i(70236);
    DlV = 1;
    DlW = 2;
    DlX = 4;
    DlY = 8;
    DlZ = 16;
    Dma = 32;
    Dmb = 64;
    Dmc = 128;
    Dmd = 256;
    c.a locala = new c.a();
    locala.IBL = new Field[45];
    locala.columns = new String[46];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "fakePk";
    locala.IBN.put("fakePk", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" fakePk INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "fakePk";
    locala.columns[1] = "bindSerial";
    locala.IBN.put("bindSerial", "TEXT");
    localStringBuilder.append(" bindSerial TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "cardType";
    locala.IBN.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "bankcardState";
    locala.IBN.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "forbidWord";
    locala.IBN.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankName";
    locala.IBN.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardType";
    locala.IBN.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTypeName";
    locala.IBN.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTag";
    locala.IBN.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "bankcardTail";
    locala.IBN.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "supportTag";
    locala.IBN.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "mobile";
    locala.IBN.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "trueName";
    locala.IBN.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "desc";
    locala.IBN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bankPhone";
    locala.IBN.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizUsername";
    locala.IBN.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaKind";
    locala.IBN.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "onceQuotaVirtual";
    locala.IBN.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaKind";
    locala.IBN.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "dayQuotaVirtual";
    locala.IBN.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTime";
    locala.IBN.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[21] = "fetchArriveTimeWording";
    locala.IBN.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "repay_url";
    locala.IBN.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "wxcreditState";
    locala.IBN.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "bankcardClientType";
    locala.IBN.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "ext_msg";
    locala.IBN.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "support_micropay";
    locala.IBN.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "arrive_type";
    locala.IBN.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "avail_save_wording";
    locala.IBN.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "fetch_charge_rate";
    locala.IBN.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "full_fetch_charge_fee";
    locala.IBN.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[31] = "fetch_charge_info";
    locala.IBN.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "tips";
    locala.IBN.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_title";
    locala.IBN.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "forbid_url";
    locala.IBN.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "no_micro_word";
    locala.IBN.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "card_bottom_wording";
    locala.IBN.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_in";
    locala.IBN.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "support_lqt_turn_out";
    locala.IBN.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "is_hightlight_pre_arrive_time_wording";
    locala.IBN.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "card_state_name";
    locala.IBN.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "prompt_info_prompt_text";
    locala.IBN.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "prompt_info_jump_text";
    locala.IBN.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "prompt_info_jump_url";
    locala.IBN.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "scene";
    locala.IBN.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    locala.columns[45] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70236);
  }
  
  public BankcardScene()
  {
    this.Dmi = null;
    this.Dms = null;
    this.Dmt = false;
  }
  
  public BankcardScene(Parcel paramParcel)
  {
    AppMethodBeat.i(70232);
    this.Dmi = null;
    this.Dms = null;
    this.Dmt = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.Dmt = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.Dmi = paramParcel.readString();
      this.Dlx = paramParcel.readInt();
      this.Dms = paramParcel.readString();
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
      this.Dmy = paramParcel.readString();
      this.Dmv = paramParcel.readLong();
      this.Dmx = paramParcel.readLong();
      this.Dmw = paramParcel.readLong();
      this.Dmz = paramParcel.readInt();
      this.DmD = paramParcel.readInt();
      this.DmA = paramParcel.readInt();
      this.DmB = paramParcel.readString();
      this.DmC = paramParcel.readString();
      this.DmE = paramParcel.readString();
      this.DmF = paramParcel.readLong();
      this.DmG = paramParcel.readString();
      this.DmH = paramParcel.readString();
      this.DmI = paramParcel.readString();
      this.CRv = paramParcel.readString();
      this.CRw = paramParcel.readString();
      AppMethodBeat.o(70232);
      return;
      bool1 = false;
      break;
    }
  }
  
  public BankcardScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.Dmi = null;
    this.Dms = null;
    this.Dmt = false;
    this.Dme = paramString1;
    this.Dmf = paramString2;
    this.Dlz = paramString3;
    this.Dmg = paramString4;
    this.Dmh = paramString5;
    this.Dmi = paramString6;
    this.Dmj = paramDouble1;
    this.Dmk = paramString7;
    this.Dml = paramDouble2;
    this.Dmm = paramString8;
    this.Dmn = paramString9;
    this.Dmo = paramString10;
    this.Dmp = paramString11;
    this.Dmq = paramString12;
    this.Dmr = paramb;
    this.Dlx = paramInt1;
    this.Dms = paramString13;
    this.Dmt = paramBoolean;
    this.Dmu = parame;
    this.Dmv = paramLong1;
    this.Dmw = paramLong2;
    this.Dmx = paramLong3;
    this.Dmy = paramString14;
    this.Dmz = paramInt2;
    this.DmA = paramInt3;
    this.DmB = paramString15;
    this.DmC = paramString16;
    this.DmD = paramInt4;
    this.DmE = paramString17;
    this.DmF = paramLong4;
    this.DmG = paramString18;
    this.DmH = paramString19;
    this.DmI = paramString20;
    this.CRv = paramString21;
    this.CRw = paramString22;
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
  
  public c.a getDBInfo()
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
    if (this.Dmt)
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
      paramParcel.writeString(this.Dmi);
      paramParcel.writeInt(this.Dlx);
      paramParcel.writeString(this.Dms);
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
      paramParcel.writeString(this.Dmy);
      paramParcel.writeLong(this.Dmv);
      paramParcel.writeLong(this.Dmx);
      paramParcel.writeLong(this.Dmw);
      paramParcel.writeInt(this.Dmz);
      paramParcel.writeInt(this.DmD);
      paramParcel.writeInt(this.DmA);
      paramParcel.writeString(this.DmB);
      paramParcel.writeString(this.DmC);
      paramParcel.writeString(this.DmE);
      paramParcel.writeLong(this.DmF);
      paramParcel.writeString(this.DmG);
      paramParcel.writeString(this.DmH);
      paramParcel.writeString(this.DmI);
      paramParcel.writeString(this.CRv);
      paramParcel.writeString(this.CRw);
      AppMethodBeat.o(70233);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.BankcardScene
 * JD-Core Version:    0.7.0.1
 */