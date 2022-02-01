package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends hd
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR;
  public static int HVo;
  public static int HVp;
  public static int HVq;
  public static int HVr;
  public static int HVs;
  public static int HVt;
  public static int HVu;
  public static int HVv;
  public static int HVw;
  public static IAutoDBItem.MAutoDBInfo info;
  public int HUQ;
  public String HUS;
  public String HVA;
  public String HVB;
  public double HVC;
  public String HVD;
  public double HVE;
  public String HVF;
  public String HVG;
  public String HVH;
  public String HVI;
  public String HVJ;
  public b HVK;
  public String HVL;
  public e HVM;
  public long HVN;
  public long HVO;
  public long HVP;
  public String HVQ;
  public int HVR;
  public int HVS;
  public String HVT;
  public String HVU;
  public int HVV;
  public String HVW;
  public long HVX;
  public String HVY;
  public String HVZ;
  public String HVx;
  public String HVy;
  public String HVz;
  public String HWa;
  public String Hwr;
  public String Hws;
  public boolean dKO;
  
  static
  {
    AppMethodBeat.i(70225);
    HVo = 1;
    HVp = 2;
    HVq = 4;
    HVr = 8;
    HVs = 16;
    HVt = 32;
    HVu = 64;
    HVv = 128;
    HVw = 256;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[43];
    localMAutoDBInfo.columns = new String[44];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bindSerial";
    localMAutoDBInfo.colsMap.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bindSerial";
    localMAutoDBInfo.columns[1] = "cardType";
    localMAutoDBInfo.colsMap.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "bankcardState";
    localMAutoDBInfo.colsMap.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "forbidWord";
    localMAutoDBInfo.colsMap.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "bankName";
    localMAutoDBInfo.colsMap.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "bankcardType";
    localMAutoDBInfo.colsMap.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "bankcardTypeName";
    localMAutoDBInfo.colsMap.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "bankcardTag";
    localMAutoDBInfo.colsMap.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bankcardTail";
    localMAutoDBInfo.colsMap.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "supportTag";
    localMAutoDBInfo.colsMap.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "mobile";
    localMAutoDBInfo.colsMap.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "trueName";
    localMAutoDBInfo.colsMap.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "bankPhone";
    localMAutoDBInfo.colsMap.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "bizUsername";
    localMAutoDBInfo.colsMap.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "onceQuotaKind";
    localMAutoDBInfo.colsMap.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "onceQuotaVirtual";
    localMAutoDBInfo.colsMap.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "dayQuotaKind";
    localMAutoDBInfo.colsMap.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "dayQuotaVirtual";
    localMAutoDBInfo.colsMap.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "fetchArriveTime";
    localMAutoDBInfo.colsMap.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fetchArriveTimeWording";
    localMAutoDBInfo.colsMap.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "repay_url";
    localMAutoDBInfo.colsMap.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "wxcreditState";
    localMAutoDBInfo.colsMap.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "bankcardClientType";
    localMAutoDBInfo.colsMap.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "ext_msg";
    localMAutoDBInfo.colsMap.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "support_micropay";
    localMAutoDBInfo.colsMap.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "arrive_type";
    localMAutoDBInfo.colsMap.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "avail_save_wording";
    localMAutoDBInfo.colsMap.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "fetch_charge_rate";
    localMAutoDBInfo.colsMap.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "full_fetch_charge_fee";
    localMAutoDBInfo.colsMap.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "fetch_charge_info";
    localMAutoDBInfo.colsMap.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "tips";
    localMAutoDBInfo.colsMap.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "forbid_title";
    localMAutoDBInfo.colsMap.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "forbid_url";
    localMAutoDBInfo.colsMap.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "no_micro_word";
    localMAutoDBInfo.colsMap.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "card_bottom_wording";
    localMAutoDBInfo.colsMap.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "support_lqt_turn_in";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "support_lqt_turn_out";
    localMAutoDBInfo.colsMap.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "is_hightlight_pre_arrive_time_wording";
    localMAutoDBInfo.colsMap.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "card_state_name";
    localMAutoDBInfo.colsMap.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "prompt_info_prompt_text";
    localMAutoDBInfo.colsMap.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "prompt_info_jump_text";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "prompt_info_jump_url";
    localMAutoDBInfo.colsMap.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    localMAutoDBInfo.columns[43] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Bankcard.1();
    AppMethodBeat.o(70225);
  }
  
  public Bankcard()
  {
    this.HVB = null;
    this.HVL = null;
    this.dKO = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.HVB = null;
    this.HVL = null;
    this.dKO = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(70222);
    this.HVB = null;
    this.HVL = null;
    this.dKO = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.dKO = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.HVB = paramParcel.readString();
      this.HUQ = paramParcel.readInt();
      this.HVL = paramParcel.readString();
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
      this.HVQ = paramParcel.readString();
      this.HVN = paramParcel.readLong();
      this.HVP = paramParcel.readLong();
      this.HVO = paramParcel.readLong();
      this.HVR = paramParcel.readInt();
      this.HVV = paramParcel.readInt();
      this.HVS = paramParcel.readInt();
      this.HVT = paramParcel.readString();
      this.HVU = paramParcel.readString();
      this.HVW = paramParcel.readString();
      this.HVX = paramParcel.readLong();
      this.HVY = paramParcel.readString();
      this.HVZ = paramParcel.readString();
      this.HWa = paramParcel.readString();
      this.Hwr = paramParcel.readString();
      this.Hws = paramParcel.readString();
      AppMethodBeat.o(70222);
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bankcard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.HVB = null;
    this.HVL = null;
    this.dKO = false;
    this.HVx = paramString1;
    this.HVy = paramString2;
    this.HUS = paramString3;
    this.HVz = paramString4;
    this.HVA = paramString5;
    this.HVB = paramString6;
    this.HVC = paramDouble1;
    this.HVD = paramString7;
    this.HVE = paramDouble2;
    this.HVF = paramString8;
    this.HVG = paramString9;
    this.HVH = paramString10;
    this.HVI = paramString11;
    this.HVJ = paramString12;
    this.HVK = paramb;
    this.HUQ = paramInt1;
    this.HVL = paramString13;
    this.dKO = paramBoolean;
    this.HVM = parame;
    this.HVN = paramLong1;
    this.HVO = paramLong2;
    this.HVP = paramLong3;
    this.HVQ = paramString14;
    this.HVR = paramInt2;
    this.HVS = paramInt3;
    this.HVT = paramString15;
    this.HVU = paramString16;
    this.HVV = paramInt4;
    this.HVW = paramString17;
    this.HVX = paramLong4;
    this.HVY = paramString18;
    this.HVZ = paramString19;
    this.HWa = paramString20;
    this.Hwr = paramString21;
    this.Hws = paramString22;
  }
  
  public static boolean aeI(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static String au(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70216);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(2131768127);
      AppMethodBeat.o(70216);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131768120);
      AppMethodBeat.o(70216);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131768122);
      AppMethodBeat.o(70216);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131768126);
      AppMethodBeat.o(70216);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131768118);
      AppMethodBeat.o(70216);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131768124);
      AppMethodBeat.o(70216);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131768131);
      AppMethodBeat.o(70216);
      return paramContext;
    }
    paramContext = paramContext.getString(2131768129);
    AppMethodBeat.o(70216);
    return paramContext;
  }
  
  private boolean isSupport(int paramInt)
  {
    return (this.field_bankcardTag & paramInt) > 0;
  }
  
  public static boolean jT(int paramInt1, int paramInt2)
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
    if ((paramOrders != null) && (paramOrders.dDL.equals(this.HVB)))
    {
      AppMethodBeat.o(70215);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (fQe())
      {
        AppMethodBeat.o(70215);
        return 5;
      }
      AppMethodBeat.o(70215);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.HYZ.isEmpty()) && (!paramOrders.HYZ.contains(this.field_bankcardType)))
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
  
  public final boolean fQa()
  {
    AppMethodBeat.i(70217);
    if ((this.field_cardType & HVq) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70217);
      return bool;
    }
  }
  
  public final boolean fQb()
  {
    AppMethodBeat.i(70218);
    if ((this.field_cardType & HVr) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70218);
      return bool;
    }
  }
  
  public final boolean fQc()
  {
    AppMethodBeat.i(70219);
    if ((this.field_cardType & HVu) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70219);
      return bool;
    }
  }
  
  public final boolean fQd()
  {
    AppMethodBeat.i(70220);
    if ((this.field_cardType & HVp) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70220);
      return bool;
    }
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(70221);
    if ((this.field_cardType & HVo) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70221);
      return bool;
    }
  }
  
  public final boolean fQf()
  {
    return (this.field_cardType & HVv) > 0;
  }
  
  public final boolean fQg()
  {
    return (this.field_cardType & HVw) > 0;
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
    paramParcel.writeInt(this.field_cardType);
    if (this.dKO)
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
      paramParcel.writeString(this.HVB);
      paramParcel.writeInt(this.HUQ);
      paramParcel.writeString(this.HVL);
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
      paramParcel.writeString(this.HVQ);
      paramParcel.writeLong(this.HVN);
      paramParcel.writeLong(this.HVP);
      paramParcel.writeLong(this.HVO);
      paramParcel.writeInt(this.HVR);
      paramParcel.writeInt(this.HVV);
      paramParcel.writeInt(this.HVS);
      paramParcel.writeString(this.HVT);
      paramParcel.writeString(this.HVU);
      paramParcel.writeString(this.HVW);
      paramParcel.writeLong(this.HVX);
      paramParcel.writeString(this.HVY);
      paramParcel.writeString(this.HVZ);
      paramParcel.writeString(this.HWa);
      paramParcel.writeString(this.Hwr);
      paramParcel.writeString(this.Hws);
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