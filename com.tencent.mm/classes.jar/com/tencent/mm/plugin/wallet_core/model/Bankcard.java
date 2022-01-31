package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends fg
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR;
  public static c.a info;
  public static int ufA;
  public static int ufB;
  public static int ufC;
  public static int ufD;
  public static int ufE;
  public static int ufF;
  public static int ufG;
  public static int ufy;
  public static int ufz;
  public String uaL;
  public int ueY;
  public String ufH;
  public String ufI;
  public String ufJ;
  public String ufK;
  public String ufL;
  public double ufM;
  public String ufN;
  public double ufO;
  public String ufP;
  public String ufQ;
  public String ufR;
  public String ufS;
  public String ufT;
  public String ufU;
  public boolean ufV;
  public g ufW;
  public long ufX;
  public long ufY;
  public long ufZ;
  public String ufa;
  public String uga;
  public int ugb;
  public int ugc;
  public String ugd;
  public String uge;
  public int ugf;
  public String ugg;
  public long ugh;
  public String ugi;
  public String ugj;
  public String ugk;
  public String ugl;
  
  static
  {
    AppMethodBeat.i(46714);
    ufy = 1;
    ufz = 2;
    ufA = 4;
    ufB = 8;
    ufC = 16;
    ufD = 32;
    ufE = 64;
    ufF = 128;
    ufG = 256;
    c.a locala = new c.a();
    locala.yrK = new Field[40];
    locala.columns = new String[41];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bindSerial";
    locala.yrM.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "bindSerial";
    locala.columns[1] = "cardType";
    locala.yrM.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "bankcardState";
    locala.yrM.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "forbidWord";
    locala.yrM.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bankName";
    locala.yrM.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankcardType";
    locala.yrM.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardTypeName";
    locala.yrM.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTag";
    locala.yrM.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTail";
    locala.yrM.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "supportTag";
    locala.yrM.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "mobile";
    locala.yrM.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "trueName";
    locala.yrM.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "desc";
    locala.yrM.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bankPhone";
    locala.yrM.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bizUsername";
    locala.yrM.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "onceQuotaKind";
    locala.yrM.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaVirtual";
    locala.yrM.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "dayQuotaKind";
    locala.yrM.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaVirtual";
    locala.yrM.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "fetchArriveTime";
    locala.yrM.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTimeWording";
    locala.yrM.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "repay_url";
    locala.yrM.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "wxcreditState";
    locala.yrM.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "bankcardClientType";
    locala.yrM.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "ext_msg";
    locala.yrM.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "support_micropay";
    locala.yrM.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "arrive_type";
    locala.yrM.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "avail_save_wording";
    locala.yrM.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "fetch_charge_rate";
    locala.yrM.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[29] = "full_fetch_charge_fee";
    locala.yrM.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "fetch_charge_info";
    locala.yrM.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tips";
    locala.yrM.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "forbid_title";
    locala.yrM.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_url";
    locala.yrM.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "no_micro_word";
    locala.yrM.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "card_bottom_wording";
    locala.yrM.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "support_lqt_turn_in";
    locala.yrM.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_out";
    locala.yrM.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "is_hightlight_pre_arrive_time_wording";
    locala.yrM.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "card_state_name";
    locala.yrM.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    locala.columns[40] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Bankcard.1();
    AppMethodBeat.o(46714);
  }
  
  public Bankcard()
  {
    this.ufL = null;
    this.ufU = null;
    this.ufV = false;
  }
  
  public Bankcard(byte paramByte)
  {
    this.ufL = null;
    this.ufU = null;
    this.ufV = false;
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    AppMethodBeat.i(46711);
    this.ufL = null;
    this.ufU = null;
    this.ufV = false;
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.ufV = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.ufL = paramParcel.readString();
      this.ueY = paramParcel.readInt();
      this.ufU = paramParcel.readString();
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
      this.uga = paramParcel.readString();
      this.ufX = paramParcel.readLong();
      this.ufZ = paramParcel.readLong();
      this.ufY = paramParcel.readLong();
      this.ugb = paramParcel.readInt();
      this.ugf = paramParcel.readInt();
      this.ugc = paramParcel.readInt();
      this.ugd = paramParcel.readString();
      this.uge = paramParcel.readString();
      this.ugg = paramParcel.readString();
      this.ugh = paramParcel.readLong();
      this.ugi = paramParcel.readString();
      this.ugj = paramParcel.readString();
      this.ugk = paramParcel.readString();
      this.ugl = paramParcel.readString();
      this.uaL = paramParcel.readString();
      AppMethodBeat.o(46711);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean Ix(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static String aa(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(46705);
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(2131305460);
      AppMethodBeat.o(46705);
      return paramContext;
    case 1: 
      paramContext = paramContext.getString(2131305453);
      AppMethodBeat.o(46705);
      return paramContext;
    case 4: 
      paramContext = paramContext.getString(2131305455);
      AppMethodBeat.o(46705);
      return paramContext;
    case 2: 
      paramContext = paramContext.getString(2131305459);
      AppMethodBeat.o(46705);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131305451);
      AppMethodBeat.o(46705);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(2131305457);
      AppMethodBeat.o(46705);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131305464);
      AppMethodBeat.o(46705);
      return paramContext;
    }
    paramContext = paramContext.getString(2131305462);
    AppMethodBeat.o(46705);
    return paramContext;
  }
  
  public static boolean gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46703);
    ab.d("MicroMsg.Bankcard", "supportBankcardTag : " + paramInt1 + ", bankcardTag : " + paramInt2);
    if ((paramInt1 & paramInt2) > 0)
    {
      AppMethodBeat.o(46703);
      return true;
    }
    AppMethodBeat.o(46703);
    return false;
  }
  
  private boolean isSupport(int paramInt)
  {
    return (this.field_bankcardTag & paramInt) > 0;
  }
  
  public final int a(int paramInt, Orders paramOrders)
  {
    AppMethodBeat.i(46704);
    if (this.field_bankcardState != 0)
    {
      ab.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
      paramInt = this.field_bankcardState;
      AppMethodBeat.o(46704);
      return paramInt;
    }
    if ((paramOrders != null) && (paramOrders.cnI.equals(this.ufL)))
    {
      AppMethodBeat.o(46704);
      return 4;
    }
    if (!isSupport(paramInt))
    {
      if (cTi())
      {
        AppMethodBeat.o(46704);
        return 5;
      }
      AppMethodBeat.o(46704);
      return 6;
    }
    if ((paramOrders != null) && (!paramOrders.uji.isEmpty()) && (!paramOrders.uji.contains(this.field_bankcardType)))
    {
      AppMethodBeat.o(46704);
      return 7;
    }
    AppMethodBeat.o(46704);
    return 0;
  }
  
  public final boolean cTe()
  {
    AppMethodBeat.i(46706);
    if ((this.field_cardType & ufA) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46706);
      return bool;
    }
  }
  
  public final boolean cTf()
  {
    AppMethodBeat.i(46707);
    if ((this.field_cardType & ufB) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46707);
      return bool;
    }
  }
  
  public final boolean cTg()
  {
    AppMethodBeat.i(46708);
    if ((this.field_cardType & ufE) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46708);
      return bool;
    }
  }
  
  public final boolean cTh()
  {
    AppMethodBeat.i(46709);
    if ((this.field_cardType & ufz) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46709);
      return bool;
    }
  }
  
  public final boolean cTi()
  {
    AppMethodBeat.i(46710);
    if ((this.field_cardType & ufy) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(46710);
      return bool;
    }
  }
  
  public final boolean cTj()
  {
    return (this.field_cardType & ufF) > 0;
  }
  
  public final boolean cTk()
  {
    return (this.field_cardType & ufG) > 0;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(46713);
    super.convertFrom(paramCursor);
    AppMethodBeat.o(46713);
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
    AppMethodBeat.i(46712);
    paramParcel.writeString(this.field_bankName);
    paramParcel.writeString(this.field_desc);
    paramParcel.writeString(this.field_bankcardType);
    paramParcel.writeString(this.field_bindSerial);
    paramParcel.writeInt(this.field_cardType);
    if (this.ufV)
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
      paramParcel.writeString(this.ufL);
      paramParcel.writeInt(this.ueY);
      paramParcel.writeString(this.ufU);
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
      paramParcel.writeString(this.uga);
      paramParcel.writeLong(this.ufX);
      paramParcel.writeLong(this.ufZ);
      paramParcel.writeLong(this.ufY);
      paramParcel.writeInt(this.ugb);
      paramParcel.writeInt(this.ugf);
      paramParcel.writeInt(this.ugc);
      paramParcel.writeString(this.ugd);
      paramParcel.writeString(this.uge);
      paramParcel.writeString(this.ugg);
      paramParcel.writeLong(this.ugh);
      paramParcel.writeString(this.ugi);
      paramParcel.writeString(this.ugj);
      paramParcel.writeString(this.ugk);
      paramParcel.writeString(this.ugl);
      paramParcel.writeString(this.uaL);
      AppMethodBeat.o(46712);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.Bankcard
 * JD-Core Version:    0.7.0.1
 */