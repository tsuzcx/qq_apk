package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends gs
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR;
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
    AppMethodBeat.i(70225);
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
    locala.IBL = new Field[43];
    locala.columns = new String[44];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bindSerial";
    locala.IBN.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "bindSerial";
    locala.columns[1] = "cardType";
    locala.IBN.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "bankcardState";
    locala.IBN.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "forbidWord";
    locala.IBN.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bankName";
    locala.IBN.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankcardType";
    locala.IBN.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardTypeName";
    locala.IBN.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTag";
    locala.IBN.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTail";
    locala.IBN.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "supportTag";
    locala.IBN.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "mobile";
    locala.IBN.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "trueName";
    locala.IBN.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "desc";
    locala.IBN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bankPhone";
    locala.IBN.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bizUsername";
    locala.IBN.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "onceQuotaKind";
    locala.IBN.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaVirtual";
    locala.IBN.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "dayQuotaKind";
    locala.IBN.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaVirtual";
    locala.IBN.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "fetchArriveTime";
    locala.IBN.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTimeWording";
    locala.IBN.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "repay_url";
    locala.IBN.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "wxcreditState";
    locala.IBN.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "bankcardClientType";
    locala.IBN.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "ext_msg";
    locala.IBN.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "support_micropay";
    locala.IBN.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "arrive_type";
    locala.IBN.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "avail_save_wording";
    locala.IBN.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "fetch_charge_rate";
    locala.IBN.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[29] = "full_fetch_charge_fee";
    locala.IBN.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "fetch_charge_info";
    locala.IBN.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tips";
    locala.IBN.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "forbid_title";
    locala.IBN.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_url";
    locala.IBN.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "no_micro_word";
    locala.IBN.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "card_bottom_wording";
    locala.IBN.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "support_lqt_turn_in";
    locala.IBN.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_out";
    locala.IBN.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "is_hightlight_pre_arrive_time_wording";
    locala.IBN.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "card_state_name";
    locala.IBN.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    localStringBuilder.append(", ");
    locala.columns[40] = "prompt_info_prompt_text";
    locala.IBN.put("prompt_info_prompt_text", "TEXT");
    localStringBuilder.append(" prompt_info_prompt_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[41] = "prompt_info_jump_text";
    locala.IBN.put("prompt_info_jump_text", "TEXT");
    localStringBuilder.append(" prompt_info_jump_text TEXT");
    localStringBuilder.append(", ");
    locala.columns[42] = "prompt_info_jump_url";
    locala.IBN.put("prompt_info_jump_url", "TEXT");
    localStringBuilder.append(" prompt_info_jump_url TEXT");
    locala.columns[43] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Bankcard.1();
    AppMethodBeat.o(70225);
  }
  
  public Bankcard()
  {
    this.Dmi = null;
    this.Dms = null;
    this.Dmt = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.Dmi = null;
    this.Dms = null;
    this.Dmt = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(70222);
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
      AppMethodBeat.o(70222);
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bankcard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
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
  
  public static boolean We(int paramInt)
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
  
  public static boolean iN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70214);
    ae.d("MicroMsg.Bankcard", "supportBankcardTag : " + paramInt1 + ", bankcardTag : " + paramInt2);
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
      ae.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
      paramInt = this.field_bankcardState;
      AppMethodBeat.o(70215);
      return paramInt;
    }
    if ((paramOrders != null) && (paramOrders.dmw.equals(this.Dmi)))
    {
      AppMethodBeat.o(70215);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (eIB())
      {
        AppMethodBeat.o(70215);
        return 5;
      }
      AppMethodBeat.o(70215);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.DpL.isEmpty()) && (!paramOrders.DpL.contains(this.field_bankcardType)))
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
  
  public final boolean eIA()
  {
    AppMethodBeat.i(70220);
    if ((this.field_cardType & DlW) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70220);
      return bool;
    }
  }
  
  public final boolean eIB()
  {
    AppMethodBeat.i(70221);
    if ((this.field_cardType & DlV) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70221);
      return bool;
    }
  }
  
  public final boolean eIC()
  {
    return (this.field_cardType & Dmc) > 0;
  }
  
  public final boolean eID()
  {
    return (this.field_cardType & Dmd) > 0;
  }
  
  public final boolean eIx()
  {
    AppMethodBeat.i(70217);
    if ((this.field_cardType & DlX) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70217);
      return bool;
    }
  }
  
  public final boolean eIy()
  {
    AppMethodBeat.i(70218);
    if ((this.field_cardType & DlY) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70218);
      return bool;
    }
  }
  
  public final boolean eIz()
  {
    AppMethodBeat.i(70219);
    if ((this.field_cardType & Dmb) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70219);
      return bool;
    }
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
      AppMethodBeat.o(70223);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Bankcard
 * JD-Core Version:    0.7.0.1
 */