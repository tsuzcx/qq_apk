package com.tencent.mm.plugin.wallet_core.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class BankcardScene
  extends gi
  implements Parcelable
{
  public static int Bua;
  public static int Bub;
  public static int Buc;
  public static int Bud;
  public static int Bue;
  public static int Buf;
  public static int Bug;
  public static int Buh;
  public static int Bui;
  public static final Parcelable.Creator<BankcardScene> CREATOR;
  public static c.a info;
  public String AZE;
  public String AZF;
  public int BtC;
  public String BtE;
  public long BuA;
  public long BuB;
  public long BuC;
  public String BuD;
  public int BuE;
  public int BuF;
  public String BuG;
  public String BuH;
  public int BuI;
  public String BuJ;
  public long BuK;
  public String BuL;
  public String BuM;
  public String BuN;
  public String Buj;
  public String Buk;
  public String Bul;
  public String Bum;
  public String Bun;
  public double Buo;
  public String Bup;
  public double Buq;
  public String Bur;
  public String Bus;
  public String But;
  public String Buu;
  public String Buv;
  public b Buw;
  public String Bux;
  public boolean Buy;
  public e Buz;
  
  static
  {
    AppMethodBeat.i(70236);
    Bua = 1;
    Bub = 2;
    Buc = 4;
    Bud = 8;
    Bue = 16;
    Buf = 32;
    Bug = 64;
    Buh = 128;
    Bui = 256;
    c.a locala = new c.a();
    locala.GvF = new Field[45];
    locala.columns = new String[46];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "fakePk";
    locala.GvH.put("fakePk", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" fakePk INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "fakePk";
    locala.columns[1] = "bindSerial";
    locala.GvH.put("bindSerial", "TEXT");
    localStringBuilder.append(" bindSerial TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "cardType";
    locala.GvH.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "bankcardState";
    locala.GvH.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "forbidWord";
    locala.GvH.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankName";
    locala.GvH.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardType";
    locala.GvH.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTypeName";
    locala.GvH.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTag";
    locala.GvH.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "bankcardTail";
    locala.GvH.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "supportTag";
    locala.GvH.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "mobile";
    locala.GvH.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "trueName";
    locala.GvH.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "desc";
    locala.GvH.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bankPhone";
    locala.GvH.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizUsername";
    locala.GvH.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaKind";
    locala.GvH.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "onceQuotaVirtual";
    locala.GvH.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaKind";
    locala.GvH.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "dayQuotaVirtual";
    locala.GvH.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTime";
    locala.GvH.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[21] = "fetchArriveTimeWording";
    locala.GvH.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "repay_url";
    locala.GvH.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "wxcreditState";
    locala.GvH.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "bankcardClientType";
    locala.GvH.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[25] = "ext_msg";
    locala.GvH.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "support_micropay";
    locala.GvH.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[27] = "arrive_type";
    locala.GvH.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "avail_save_wording";
    locala.GvH.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "fetch_charge_rate";
    locala.GvH.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "full_fetch_charge_fee";
    locala.GvH.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[31] = "fetch_charge_info";
    locala.GvH.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "tips";
    locala.GvH.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_title";
    locala.GvH.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "forbid_url";
    locala.GvH.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "no_micro_word";
    locala.GvH.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "card_bottom_wording";
    locala.GvH.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_in";
    locala.GvH.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "support_lqt_turn_out";
    locala.GvH.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "is_hightlight_pre_arrive_time_wording";
    locala.GvH.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[40] = "card_state_name";
    locala.GvH.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "prompt_info_prompt_text";
    locala.GvH.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "prompt_info_jump_text";
    locala.GvH.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[43] = "prompt_info_jump_url";
    locala.GvH.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[44] = "scene";
    locala.GvH.put("scene", "INTEGER default '0' ");
    localStringBuilder.append(" scene INTEGER default '0' ");
    locala.columns[45] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70236);
  }
  
  public BankcardScene()
  {
    this.Bun = null;
    this.Bux = null;
    this.Buy = false;
  }
  
  public BankcardScene(Parcel paramParcel)
  {
    AppMethodBeat.i(70232);
    this.Bun = null;
    this.Bux = null;
    this.Buy = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.Buy = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.Bun = paramParcel.readString();
      this.BtC = paramParcel.readInt();
      this.Bux = paramParcel.readString();
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
      this.BuD = paramParcel.readString();
      this.BuA = paramParcel.readLong();
      this.BuC = paramParcel.readLong();
      this.BuB = paramParcel.readLong();
      this.BuE = paramParcel.readInt();
      this.BuI = paramParcel.readInt();
      this.BuF = paramParcel.readInt();
      this.BuG = paramParcel.readString();
      this.BuH = paramParcel.readString();
      this.BuJ = paramParcel.readString();
      this.BuK = paramParcel.readLong();
      this.BuL = paramParcel.readString();
      this.BuM = paramParcel.readString();
      this.BuN = paramParcel.readString();
      this.AZE = paramParcel.readString();
      this.AZF = paramParcel.readString();
      AppMethodBeat.o(70232);
      return;
      bool1 = false;
      break;
    }
  }
  
  public BankcardScene(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.Bun = null;
    this.Bux = null;
    this.Buy = false;
    this.Buj = paramString1;
    this.Buk = paramString2;
    this.BtE = paramString3;
    this.Bul = paramString4;
    this.Bum = paramString5;
    this.Bun = paramString6;
    this.Buo = paramDouble1;
    this.Bup = paramString7;
    this.Buq = paramDouble2;
    this.Bur = paramString8;
    this.Bus = paramString9;
    this.But = paramString10;
    this.Buu = paramString11;
    this.Buv = paramString12;
    this.Buw = paramb;
    this.BtC = paramInt1;
    this.Bux = paramString13;
    this.Buy = paramBoolean;
    this.Buz = parame;
    this.BuA = paramLong1;
    this.BuB = paramLong2;
    this.BuC = paramLong3;
    this.BuD = paramString14;
    this.BuE = paramInt2;
    this.BuF = paramInt3;
    this.BuG = paramString15;
    this.BuH = paramString16;
    this.BuI = paramInt4;
    this.BuJ = paramString17;
    this.BuK = paramLong4;
    this.BuL = paramString18;
    this.BuM = paramString19;
    this.BuN = paramString20;
    this.AZE = paramString21;
    this.AZF = paramString22;
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
    if (this.Buy)
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
      paramParcel.writeString(this.Bun);
      paramParcel.writeInt(this.BtC);
      paramParcel.writeString(this.Bux);
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
      paramParcel.writeString(this.BuD);
      paramParcel.writeLong(this.BuA);
      paramParcel.writeLong(this.BuC);
      paramParcel.writeLong(this.BuB);
      paramParcel.writeInt(this.BuE);
      paramParcel.writeInt(this.BuI);
      paramParcel.writeInt(this.BuF);
      paramParcel.writeString(this.BuG);
      paramParcel.writeString(this.BuH);
      paramParcel.writeString(this.BuJ);
      paramParcel.writeLong(this.BuK);
      paramParcel.writeString(this.BuL);
      paramParcel.writeString(this.BuM);
      paramParcel.writeString(this.BuN);
      paramParcel.writeString(this.AZE);
      paramParcel.writeString(this.AZF);
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