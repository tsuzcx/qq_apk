package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.hk;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends hk
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR;
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
    AppMethodBeat.i(70225);
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
    localMAutoDBInfo.fields = new Field[44];
    localMAutoDBInfo.columns = new String[45];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bindSerial";
    localMAutoDBInfo.colsMap.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bindSerial";
    localMAutoDBInfo.columns[1] = "defaultCardState";
    localMAutoDBInfo.colsMap.put("defaultCardState", "INTEGER");
    localStringBuilder.append(" defaultCardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "cardType";
    localMAutoDBInfo.colsMap.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "bankcardState";
    localMAutoDBInfo.colsMap.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "forbidWord";
    localMAutoDBInfo.colsMap.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "bankName";
    localMAutoDBInfo.colsMap.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "bankcardType";
    localMAutoDBInfo.colsMap.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bankcardTypeName";
    localMAutoDBInfo.colsMap.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bankcardTag";
    localMAutoDBInfo.colsMap.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "bankcardTail";
    localMAutoDBInfo.colsMap.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "supportTag";
    localMAutoDBInfo.colsMap.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "mobile";
    localMAutoDBInfo.colsMap.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "trueName";
    localMAutoDBInfo.colsMap.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "bankPhone";
    localMAutoDBInfo.colsMap.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bizUsername";
    localMAutoDBInfo.colsMap.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "onceQuotaKind";
    localMAutoDBInfo.colsMap.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "onceQuotaVirtual";
    localMAutoDBInfo.colsMap.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "dayQuotaKind";
    localMAutoDBInfo.colsMap.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "dayQuotaVirtual";
    localMAutoDBInfo.colsMap.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fetchArriveTime";
    localMAutoDBInfo.colsMap.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "fetchArriveTimeWording";
    localMAutoDBInfo.colsMap.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "repay_url";
    localMAutoDBInfo.colsMap.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "wxcreditState";
    localMAutoDBInfo.colsMap.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "bankcardClientType";
    localMAutoDBInfo.colsMap.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "ext_msg";
    localMAutoDBInfo.colsMap.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "support_micropay";
    localMAutoDBInfo.colsMap.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "arrive_type";
    localMAutoDBInfo.colsMap.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "avail_save_wording";
    localMAutoDBInfo.colsMap.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "fetch_charge_rate";
    localMAutoDBInfo.colsMap.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "full_fetch_charge_fee";
    localMAutoDBInfo.colsMap.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "fetch_charge_info";
    localMAutoDBInfo.colsMap.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "tips";
    localMAutoDBInfo.colsMap.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "forbid_title";
    localMAutoDBInfo.colsMap.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "forbid_url";
    localMAutoDBInfo.colsMap.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "no_micro_word";
    localMAutoDBInfo.colsMap.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "card_bottom_wording";
    localMAutoDBInfo.colsMap.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "support_lqt_turn_in";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "support_lqt_turn_out";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "is_hightlight_pre_arrive_time_wording";
    localMAutoDBInfo.colsMap.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "card_state_name";
    localMAutoDBInfo.colsMap.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "prompt_info_prompt_text";
    localMAutoDBInfo.colsMap.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "prompt_info_jump_text";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "prompt_info_jump_url";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localMAutoDBInfo.columns[44] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70225);
  }
  
  public Bankcard()
  {
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(70222);
    this.ONC = null;
    this.ONM = null;
    this.fDD = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_defaultCardState = paramParcel.readInt();
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
        break label397;
      }
    }
    label397:
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
      AppMethodBeat.o(70222);
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bankcard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
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
  
  public static String aM(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70216);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_not_exist_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_expired_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_insufficient_balance_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_maintenance_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_domestic_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_international_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(a.i.wallet_pay_bankcard_quota_tips);
      AppMethodBeat.o(70216);
      return paramContext;
    }
    paramContext = paramContext.getString(a.i.wallet_pay_bankcard_not_support_bankcard_tips);
    AppMethodBeat.o(70216);
    return paramContext;
  }
  
  public static boolean amv(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  private boolean isSupport(int paramInt)
  {
    return (this.field_bankcardTag & paramInt) > 0;
  }
  
  public static boolean lj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70214);
    Log.d("MicroMsg.Bankcard", "supportBankcardTag : " + paramInt1 + ", bankcardTag : " + paramInt2);
    if ((paramInt1 & paramInt2) > 0)
    {
      AppMethodBeat.o(70214);
      return true;
    }
    AppMethodBeat.o(70214);
    return false;
  }
  
  public final int a(int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70215);
    if (this.field_bankcardState != 0)
    {
      Log.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
      paramInt = this.field_bankcardState;
      AppMethodBeat.o(70215);
      return paramInt;
    }
    if ((paramOrders != null) && (paramOrders.fwv.equals(this.ONC)))
    {
      AppMethodBeat.o(70215);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (gIK())
      {
        AppMethodBeat.o(70215);
        return 5;
      }
      AppMethodBeat.o(70215);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.OQZ.isEmpty()) && (!paramOrders.OQZ.contains(this.field_bankcardType)))
    {
      AppMethodBeat.o(70215);
      return 7;
    }
    AppMethodBeat.o(70215);
    return 0;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(70224);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(70224);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean gIG()
  {
    AppMethodBeat.i(70217);
    if ((this.field_cardType & ONr) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70217);
      return bool;
    }
  }
  
  public final boolean gIH()
  {
    AppMethodBeat.i(70218);
    if ((this.field_cardType & ONs) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70218);
      return bool;
    }
  }
  
  public final boolean gII()
  {
    AppMethodBeat.i(70219);
    if ((this.field_cardType & ONv) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70219);
      return bool;
    }
  }
  
  public final boolean gIJ()
  {
    AppMethodBeat.i(70220);
    if ((this.field_cardType & ONq) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70220);
      return bool;
    }
  }
  
  public final boolean gIK()
  {
    AppMethodBeat.i(70221);
    if ((this.field_cardType & ONp) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70221);
      return bool;
    }
  }
  
  public final boolean gIL()
  {
    return (this.field_cardType & ONw) > 0;
  }
  
  public final boolean gIM()
  {
    return (this.field_cardType & ONx) > 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(70223);
    paramParcel.writeString(this.field_bankName);
    paramParcel.writeString(this.field_desc);
    paramParcel.writeString(this.field_bankcardType);
    paramParcel.writeString(this.field_bindSerial);
    paramParcel.writeInt(this.field_defaultCardState);
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
        break label376;
      }
    }
    label376:
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
      AppMethodBeat.o(70223);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Bankcard
 * JD-Core Version:    0.7.0.1
 */