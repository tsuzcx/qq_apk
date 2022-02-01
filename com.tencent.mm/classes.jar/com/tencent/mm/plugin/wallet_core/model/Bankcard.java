package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gd;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends gd
  implements Parcelable
{
  public static int AbG;
  public static int AbH;
  public static int AbI;
  public static int AbJ;
  public static int AbK;
  public static int AbL;
  public static int AbM;
  public static int AbN;
  public static int AbO;
  public static final Parcelable.Creator<Bankcard> CREATOR;
  public static c.a info;
  public String AbP;
  public String AbQ;
  public String AbR;
  public String AbS;
  public String AbT;
  public double AbU;
  public String AbV;
  public double AbW;
  public String AbX;
  public String AbY;
  public String AbZ;
  public int Abi;
  public String Abk;
  public String Aca;
  public String Acb;
  public b Acc;
  public String Acd;
  public boolean Ace;
  public e Acf;
  public long Acg;
  public long Ach;
  public long Aci;
  public String Acj;
  public int Ack;
  public int Acl;
  public String Acm;
  public String Acn;
  public int Aco;
  public String Acp;
  public long Acq;
  public String Acr;
  public String Acs;
  public String Act;
  public String zHs;
  public String zHt;
  
  static
  {
    AppMethodBeat.i(70225);
    AbG = 1;
    AbH = 2;
    AbI = 4;
    AbJ = 8;
    AbK = 16;
    AbL = 32;
    AbM = 64;
    AbN = 128;
    AbO = 256;
    c.a locala = new c.a();
    locala.EYt = new Field[40];
    locala.columns = new String[41];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bindSerial";
    locala.EYv.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "bindSerial";
    locala.columns[1] = "cardType";
    locala.EYv.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "bankcardState";
    locala.EYv.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "forbidWord";
    locala.EYv.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bankName";
    locala.EYv.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankcardType";
    locala.EYv.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardTypeName";
    locala.EYv.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTag";
    locala.EYv.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTail";
    locala.EYv.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "supportTag";
    locala.EYv.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "mobile";
    locala.EYv.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "trueName";
    locala.EYv.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "desc";
    locala.EYv.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bankPhone";
    locala.EYv.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bizUsername";
    locala.EYv.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "onceQuotaKind";
    locala.EYv.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaVirtual";
    locala.EYv.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "dayQuotaKind";
    locala.EYv.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaVirtual";
    locala.EYv.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "fetchArriveTime";
    locala.EYv.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTimeWording";
    locala.EYv.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "repay_url";
    locala.EYv.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "wxcreditState";
    locala.EYv.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "bankcardClientType";
    locala.EYv.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "ext_msg";
    locala.EYv.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "support_micropay";
    locala.EYv.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "arrive_type";
    locala.EYv.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "avail_save_wording";
    locala.EYv.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "fetch_charge_rate";
    locala.EYv.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[29] = "full_fetch_charge_fee";
    locala.EYv.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "fetch_charge_info";
    locala.EYv.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tips";
    locala.EYv.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "forbid_title";
    locala.EYv.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_url";
    locala.EYv.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "no_micro_word";
    locala.EYv.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "card_bottom_wording";
    locala.EYv.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "support_lqt_turn_in";
    locala.EYv.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_out";
    locala.EYv.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "is_hightlight_pre_arrive_time_wording";
    locala.EYv.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "card_state_name";
    locala.EYv.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    locala.columns[40] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70225);
  }
  
  public Bankcard()
  {
    this.AbT = null;
    this.Acd = null;
    this.Ace = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.AbT = null;
    this.Acd = null;
    this.Ace = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(70222);
    this.AbT = null;
    this.Acd = null;
    this.Ace = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.Ace = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.AbT = paramParcel.readString();
      this.Abi = paramParcel.readInt();
      this.Acd = paramParcel.readString();
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
      this.Acj = paramParcel.readString();
      this.Acg = paramParcel.readLong();
      this.Aci = paramParcel.readLong();
      this.Ach = paramParcel.readLong();
      this.Ack = paramParcel.readInt();
      this.Aco = paramParcel.readInt();
      this.Acl = paramParcel.readInt();
      this.Acm = paramParcel.readString();
      this.Acn = paramParcel.readString();
      this.Acp = paramParcel.readString();
      this.Acq = paramParcel.readLong();
      this.Acr = paramParcel.readString();
      this.Acs = paramParcel.readString();
      this.Act = paramParcel.readString();
      this.zHs = paramParcel.readString();
      this.zHt = paramParcel.readString();
      AppMethodBeat.o(70222);
      return;
      bool1 = false;
      break;
    }
  }
  
  public Bankcard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, double paramDouble1, String paramString7, double paramDouble2, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, b paramb, int paramInt1, String paramString13, boolean paramBoolean, e parame, long paramLong1, long paramLong2, long paramLong3, String paramString14, int paramInt2, int paramInt3, String paramString15, String paramString16, int paramInt4, String paramString17, long paramLong4, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22)
  {
    this.AbT = null;
    this.Acd = null;
    this.Ace = false;
    this.AbP = paramString1;
    this.AbQ = paramString2;
    this.Abk = paramString3;
    this.AbR = paramString4;
    this.AbS = paramString5;
    this.AbT = paramString6;
    this.AbU = paramDouble1;
    this.AbV = paramString7;
    this.AbW = paramDouble2;
    this.AbX = paramString8;
    this.AbY = paramString9;
    this.AbZ = paramString10;
    this.Aca = paramString11;
    this.Acb = paramString12;
    this.Acc = paramb;
    this.Abi = paramInt1;
    this.Acd = paramString13;
    this.Ace = paramBoolean;
    this.Acf = parame;
    this.Acg = paramLong1;
    this.Ach = paramLong2;
    this.Aci = paramLong3;
    this.Acj = paramString14;
    this.Ack = paramInt2;
    this.Acl = paramInt3;
    this.Acm = paramString15;
    this.Acn = paramString16;
    this.Aco = paramInt4;
    this.Acp = paramString17;
    this.Acq = paramLong4;
    this.Acr = paramString18;
    this.Acs = paramString19;
    this.Act = paramString20;
    this.zHs = paramString21;
    this.zHt = paramString22;
  }
  
  public static boolean Rw(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static String ac(Context paramContext, int paramInt)
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
  
  public static boolean ih(int paramInt1, int paramInt2)
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
    if ((paramOrders != null) && (paramOrders.dcE.equals(this.AbT)))
    {
      AppMethodBeat.o(70215);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (eby())
      {
        AppMethodBeat.o(70215);
        return 5;
      }
      AppMethodBeat.o(70215);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.Aft.isEmpty()) && (!paramOrders.Aft.contains(this.field_bankcardType)))
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
  
  public final boolean ebA()
  {
    return (this.field_cardType & AbO) > 0;
  }
  
  public final boolean ebu()
  {
    AppMethodBeat.i(70217);
    if ((this.field_cardType & AbI) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70217);
      return bool;
    }
  }
  
  public final boolean ebv()
  {
    AppMethodBeat.i(70218);
    if ((this.field_cardType & AbJ) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70218);
      return bool;
    }
  }
  
  public final boolean ebw()
  {
    AppMethodBeat.i(70219);
    if ((this.field_cardType & AbM) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70219);
      return bool;
    }
  }
  
  public final boolean ebx()
  {
    AppMethodBeat.i(70220);
    if ((this.field_cardType & AbH) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70220);
      return bool;
    }
  }
  
  public final boolean eby()
  {
    AppMethodBeat.i(70221);
    if ((this.field_cardType & AbG) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(70221);
      return bool;
    }
  }
  
  public final boolean ebz()
  {
    return (this.field_cardType & AbN) > 0;
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
    if (this.Ace)
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
      paramParcel.writeString(this.AbT);
      paramParcel.writeInt(this.Abi);
      paramParcel.writeString(this.Acd);
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
      paramParcel.writeString(this.Acj);
      paramParcel.writeLong(this.Acg);
      paramParcel.writeLong(this.Aci);
      paramParcel.writeLong(this.Ach);
      paramParcel.writeInt(this.Ack);
      paramParcel.writeInt(this.Aco);
      paramParcel.writeInt(this.Acl);
      paramParcel.writeString(this.Acm);
      paramParcel.writeString(this.Acn);
      paramParcel.writeString(this.Acp);
      paramParcel.writeLong(this.Acq);
      paramParcel.writeString(this.Acr);
      paramParcel.writeString(this.Acs);
      paramParcel.writeString(this.Act);
      paramParcel.writeString(this.zHs);
      paramParcel.writeString(this.zHt);
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