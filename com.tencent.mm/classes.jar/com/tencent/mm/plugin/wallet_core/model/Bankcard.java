package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gr;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends gr
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR;
  public static int CUp;
  public static int CUq;
  public static int CUr;
  public static int CUs;
  public static int CUt;
  public static int CUu;
  public static int CUv;
  public static int CUw;
  public static int CUx;
  public static c.a info;
  public int CTR;
  public String CTT;
  public String CUA;
  public String CUB;
  public String CUC;
  public double CUD;
  public String CUE;
  public double CUF;
  public String CUG;
  public String CUH;
  public String CUI;
  public String CUJ;
  public String CUK;
  public b CUL;
  public String CUM;
  public boolean CUN;
  public e CUO;
  public long CUP;
  public long CUQ;
  public long CUR;
  public String CUS;
  public int CUT;
  public int CUU;
  public String CUV;
  public String CUW;
  public int CUX;
  public String CUY;
  public long CUZ;
  public String CUy;
  public String CUz;
  public String CVa;
  public String CVb;
  public String CVc;
  public String CzQ;
  public String CzR;
  
  static
  {
    AppMethodBeat.i(70225);
    CUp = 1;
    CUq = 2;
    CUr = 4;
    CUs = 8;
    CUt = 16;
    CUu = 32;
    CUv = 64;
    CUw = 128;
    CUx = 256;
    c.a locala = new c.a();
    locala.IhA = new Field[43];
    locala.columns = new String[44];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bindSerial";
    locala.IhC.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "bindSerial";
    locala.columns[1] = "cardType";
    locala.IhC.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "bankcardState";
    locala.IhC.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "forbidWord";
    locala.IhC.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bankName";
    locala.IhC.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankcardType";
    locala.IhC.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardTypeName";
    locala.IhC.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTag";
    locala.IhC.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTail";
    locala.IhC.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "supportTag";
    locala.IhC.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "mobile";
    locala.IhC.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "trueName";
    locala.IhC.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "desc";
    locala.IhC.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bankPhone";
    locala.IhC.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bizUsername";
    locala.IhC.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "onceQuotaKind";
    locala.IhC.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaVirtual";
    locala.IhC.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "dayQuotaKind";
    locala.IhC.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaVirtual";
    locala.IhC.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "fetchArriveTime";
    locala.IhC.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTimeWording";
    locala.IhC.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "repay_url";
    locala.IhC.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "wxcreditState";
    locala.IhC.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "bankcardClientType";
    locala.IhC.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "ext_msg";
    locala.IhC.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "support_micropay";
    locala.IhC.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "arrive_type";
    locala.IhC.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "avail_save_wording";
    locala.IhC.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "fetch_charge_rate";
    locala.IhC.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[29] = "full_fetch_charge_fee";
    locala.IhC.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "fetch_charge_info";
    locala.IhC.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tips";
    locala.IhC.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "forbid_title";
    locala.IhC.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_url";
    locala.IhC.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "no_micro_word";
    locala.IhC.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "card_bottom_wording";
    locala.IhC.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "support_lqt_turn_in";
    locala.IhC.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_out";
    locala.IhC.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "is_hightlight_pre_arrive_time_wording";
    locala.IhC.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "card_state_name";
    locala.IhC.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[40] = "prompt_info_prompt_text";
    locala.IhC.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "prompt_info_jump_text";
    locala.IhC.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "prompt_info_jump_url";
    locala.IhC.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    locala.columns[43] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70225);
  }
  
  public Bankcard()
  {
    this.CUC = null;
    this.CUM = null;
    this.CUN = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.CUC = null;
    this.CUM = null;
    this.CUN = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(70222);
    this.CUC = null;
    this.CUM = null;
    this.CUN = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.CUN = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.CUC = paramParcel.readString();
      this.CTR = paramParcel.readInt();
      this.CUM = paramParcel.readString();
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
      this.CUS = paramParcel.readString();
      this.CUP = paramParcel.readLong();
      this.CUR = paramParcel.readLong();
      this.CUQ = paramParcel.readLong();
      this.CUT = paramParcel.readInt();
      this.CUX = paramParcel.readInt();
      this.CUU = paramParcel.readInt();
      this.CUV = paramParcel.readString();
      this.CUW = paramParcel.readString();
      this.CUY = paramParcel.readString();
      this.CUZ = paramParcel.readLong();
      this.CVa = paramParcel.readString();
      this.CVb = paramParcel.readString();
      this.CVc = paramParcel.readString();
      this.CzQ = paramParcel.readString();
      this.CzR = paramParcel.readString();
      AppMethodBeat.o(70222);
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bankcard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.CUC = null;
    this.CUM = null;
    this.CUN = false;
    this.CUy = paramString1;
    this.CUz = paramString2;
    this.CTT = paramString3;
    this.CUA = paramString4;
    this.CUB = paramString5;
    this.CUC = paramString6;
    this.CUD = paramDouble1;
    this.CUE = paramString7;
    this.CUF = paramDouble2;
    this.CUG = paramString8;
    this.CUH = paramString9;
    this.CUI = paramString10;
    this.CUJ = paramString11;
    this.CUK = paramString12;
    this.CUL = paramb;
    this.CTR = paramInt1;
    this.CUM = paramString13;
    this.CUN = paramBoolean;
    this.CUO = parame;
    this.CUP = paramLong1;
    this.CUQ = paramLong2;
    this.CUR = paramLong3;
    this.CUS = paramString14;
    this.CUT = paramInt2;
    this.CUU = paramInt3;
    this.CUV = paramString15;
    this.CUW = paramString16;
    this.CUX = paramInt4;
    this.CUY = paramString17;
    this.CUZ = paramLong4;
    this.CVa = paramString18;
    this.CVb = paramString19;
    this.CVc = paramString20;
    this.CzQ = paramString21;
    this.CzR = paramString22;
  }
  
  public static boolean Vx(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static String al(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(70216);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(2131765674);
      AppMethodBeat.o(70216);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131765667);
      AppMethodBeat.o(70216);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131765669);
      AppMethodBeat.o(70216);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131765673);
      AppMethodBeat.o(70216);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131765665);
      AppMethodBeat.o(70216);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131765671);
      AppMethodBeat.o(70216);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131765678);
      AppMethodBeat.o(70216);
      return paramContext;
    }
    paramContext = paramContext.getString(2131765676);
    AppMethodBeat.o(70216);
    return paramContext;
  }
  
  public static boolean iJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70214);
    ad.d("MicroMsg.Bankcard", "supportBankcardTag : " + paramInt1 + ", bankcardTag : " + paramInt2);
    if ((paramInt1 & paramInt2) > 0)
    {
      AppMethodBeat.o(70214);
      return true;
    }
    AppMethodBeat.o(70214);
    return false;
  }
  
  private boolean isSupport(int paramInt)
  {
    return (this.field_bankcardTag & paramInt) > 0;
  }
  
  public final int a(int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(70215);
    if (this.field_bankcardState != 0)
    {
      ad.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
      paramInt = this.field_bankcardState;
      AppMethodBeat.o(70215);
      return paramInt;
    }
    if ((paramOrders != null) && (paramOrders.dlu.equals(this.CUC)))
    {
      AppMethodBeat.o(70215);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (eEU())
      {
        AppMethodBeat.o(70215);
        return 5;
      }
      AppMethodBeat.o(70215);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.CYg.isEmpty()) && (!paramOrders.CYg.contains(this.field_bankcardType)))
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
  
  public final boolean eEQ()
  {
    AppMethodBeat.i(70217);
    if ((this.field_cardType & CUr) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70217);
      return bool;
    }
  }
  
  public final boolean eER()
  {
    AppMethodBeat.i(70218);
    if ((this.field_cardType & CUs) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70218);
      return bool;
    }
  }
  
  public final boolean eES()
  {
    AppMethodBeat.i(70219);
    if ((this.field_cardType & CUv) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70219);
      return bool;
    }
  }
  
  public final boolean eET()
  {
    AppMethodBeat.i(70220);
    if ((this.field_cardType & CUq) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70220);
      return bool;
    }
  }
  
  public final boolean eEU()
  {
    AppMethodBeat.i(70221);
    if ((this.field_cardType & CUp) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70221);
      return bool;
    }
  }
  
  public final boolean eEV()
  {
    return (this.field_cardType & CUw) > 0;
  }
  
  public final boolean eEW()
  {
    return (this.field_cardType & CUx) > 0;
  }
  
  public c.a getDBInfo()
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
    if (this.CUN)
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
      paramParcel.writeString(this.CUC);
      paramParcel.writeInt(this.CTR);
      paramParcel.writeString(this.CUM);
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
      paramParcel.writeString(this.CUS);
      paramParcel.writeLong(this.CUP);
      paramParcel.writeLong(this.CUR);
      paramParcel.writeLong(this.CUQ);
      paramParcel.writeInt(this.CUT);
      paramParcel.writeInt(this.CUX);
      paramParcel.writeInt(this.CUU);
      paramParcel.writeString(this.CUV);
      paramParcel.writeString(this.CUW);
      paramParcel.writeString(this.CUY);
      paramParcel.writeLong(this.CUZ);
      paramParcel.writeString(this.CVa);
      paramParcel.writeString(this.CVb);
      paramParcel.writeString(this.CVc);
      paramParcel.writeString(this.CzQ);
      paramParcel.writeString(this.CzR);
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