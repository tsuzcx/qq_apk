package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.c.eq;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class Bankcard
  extends eq
  implements Parcelable
{
  public static final Parcelable.Creator<Bankcard> CREATOR = new Bankcard.1();
  public static c.a buS;
  public static int qtl = 1;
  public static int qtm = 2;
  public static int qtn = 4;
  public static int qto = 8;
  public static int qtp = 16;
  public static int qtq = 32;
  public static int qtr = 64;
  public static int qts = 128;
  public boolean bre = false;
  public int qsL;
  public String qsN;
  public double qtA;
  public String qtB;
  public String qtC;
  public String qtD;
  public String qtE;
  public String qtF;
  public String qtG = null;
  public e qtH;
  public long qtI;
  public long qtJ;
  public long qtK;
  public String qtL;
  public int qtM;
  public int qtN;
  public String qtO;
  public String qtP;
  public int qtQ;
  public String qtt;
  public String qtu;
  public String qtv;
  public String qtw;
  public String qtx = null;
  public double qty;
  public String qtz;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[40];
    locala.columns = new String[41];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bindSerial";
    locala.ujN.put("bindSerial", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "bindSerial";
    locala.columns[1] = "cardType";
    locala.ujN.put("cardType", "INTEGER");
    localStringBuilder.append(" cardType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "bankcardState";
    locala.ujN.put("bankcardState", "INTEGER");
    localStringBuilder.append(" bankcardState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "forbidWord";
    locala.ujN.put("forbidWord", "TEXT");
    localStringBuilder.append(" forbidWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "bankName";
    locala.ujN.put("bankName", "TEXT");
    localStringBuilder.append(" bankName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "bankcardType";
    locala.ujN.put("bankcardType", "TEXT");
    localStringBuilder.append(" bankcardType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "bankcardTypeName";
    locala.ujN.put("bankcardTypeName", "TEXT");
    localStringBuilder.append(" bankcardTypeName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "bankcardTag";
    locala.ujN.put("bankcardTag", "INTEGER");
    localStringBuilder.append(" bankcardTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "bankcardTail";
    locala.ujN.put("bankcardTail", "TEXT");
    localStringBuilder.append(" bankcardTail TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "supportTag";
    locala.ujN.put("supportTag", "INTEGER");
    localStringBuilder.append(" supportTag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "mobile";
    locala.ujN.put("mobile", "TEXT");
    localStringBuilder.append(" mobile TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "trueName";
    locala.ujN.put("trueName", "TEXT");
    localStringBuilder.append(" trueName TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "desc";
    locala.ujN.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "bankPhone";
    locala.ujN.put("bankPhone", "TEXT");
    localStringBuilder.append(" bankPhone TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "bizUsername";
    locala.ujN.put("bizUsername", "TEXT");
    localStringBuilder.append(" bizUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "onceQuotaKind";
    locala.ujN.put("onceQuotaKind", "DOUBLE");
    localStringBuilder.append(" onceQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[16] = "onceQuotaVirtual";
    locala.ujN.put("onceQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" onceQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[17] = "dayQuotaKind";
    locala.ujN.put("dayQuotaKind", "DOUBLE");
    localStringBuilder.append(" dayQuotaKind DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[18] = "dayQuotaVirtual";
    locala.ujN.put("dayQuotaVirtual", "DOUBLE");
    localStringBuilder.append(" dayQuotaVirtual DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[19] = "fetchArriveTime";
    locala.ujN.put("fetchArriveTime", "LONG");
    localStringBuilder.append(" fetchArriveTime LONG");
    localStringBuilder.append(", ");
    locala.columns[20] = "fetchArriveTimeWording";
    locala.ujN.put("fetchArriveTimeWording", "TEXT");
    localStringBuilder.append(" fetchArriveTimeWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "repay_url";
    locala.ujN.put("repay_url", "TEXT");
    localStringBuilder.append(" repay_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "wxcreditState";
    locala.ujN.put("wxcreditState", "INTEGER");
    localStringBuilder.append(" wxcreditState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[23] = "bankcardClientType";
    locala.ujN.put("bankcardClientType", "INTEGER");
    localStringBuilder.append(" bankcardClientType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[24] = "ext_msg";
    locala.ujN.put("ext_msg", "TEXT");
    localStringBuilder.append(" ext_msg TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "support_micropay";
    locala.ujN.put("support_micropay", "INTEGER");
    localStringBuilder.append(" support_micropay INTEGER");
    localStringBuilder.append(", ");
    locala.columns[26] = "arrive_type";
    locala.ujN.put("arrive_type", "TEXT");
    localStringBuilder.append(" arrive_type TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "avail_save_wording";
    locala.ujN.put("avail_save_wording", "TEXT");
    localStringBuilder.append(" avail_save_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[28] = "fetch_charge_rate";
    locala.ujN.put("fetch_charge_rate", "DOUBLE");
    localStringBuilder.append(" fetch_charge_rate DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[29] = "full_fetch_charge_fee";
    locala.ujN.put("full_fetch_charge_fee", "DOUBLE");
    localStringBuilder.append(" full_fetch_charge_fee DOUBLE");
    localStringBuilder.append(", ");
    locala.columns[30] = "fetch_charge_info";
    locala.ujN.put("fetch_charge_info", "TEXT");
    localStringBuilder.append(" fetch_charge_info TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tips";
    locala.ujN.put("tips", "TEXT");
    localStringBuilder.append(" tips TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "forbid_title";
    locala.ujN.put("forbid_title", "TEXT");
    localStringBuilder.append(" forbid_title TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "forbid_url";
    locala.ujN.put("forbid_url", "TEXT");
    localStringBuilder.append(" forbid_url TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "no_micro_word";
    locala.ujN.put("no_micro_word", "TEXT");
    localStringBuilder.append(" no_micro_word TEXT");
    localStringBuilder.append(", ");
    locala.columns[35] = "card_bottom_wording";
    locala.ujN.put("card_bottom_wording", "TEXT");
    localStringBuilder.append(" card_bottom_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[36] = "support_lqt_turn_in";
    locala.ujN.put("support_lqt_turn_in", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_in INTEGER");
    localStringBuilder.append(", ");
    locala.columns[37] = "support_lqt_turn_out";
    locala.ujN.put("support_lqt_turn_out", "INTEGER");
    localStringBuilder.append(" support_lqt_turn_out INTEGER");
    localStringBuilder.append(", ");
    locala.columns[38] = "is_hightlight_pre_arrive_time_wording";
    locala.ujN.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
    localStringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
    localStringBuilder.append(", ");
    locala.columns[39] = "card_state_name";
    locala.ujN.put("card_state_name", "TEXT");
    localStringBuilder.append(" card_state_name TEXT");
    locala.columns[40] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public Bankcard() {}
  
  public Bankcard(byte paramByte)
  {
    this.field_bankcardTag = 1;
  }
  
  public Bankcard(Parcel paramParcel)
  {
    this.field_bankName = paramParcel.readString();
    this.field_desc = paramParcel.readString();
    this.field_bankcardType = paramParcel.readString();
    this.field_bindSerial = paramParcel.readString();
    this.field_cardType = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.bre = bool1;
      this.field_mobile = paramParcel.readString();
      this.field_onceQuotaKind = paramParcel.readDouble();
      this.field_onceQuotaVirtual = paramParcel.readDouble();
      this.field_dayQuotaKind = paramParcel.readDouble();
      this.field_dayQuotaVirtual = paramParcel.readDouble();
      this.field_bankcardTail = paramParcel.readString();
      this.field_bankPhone = paramParcel.readString();
      this.field_bankcardTag = paramParcel.readInt();
      this.field_bankcardState = paramParcel.readInt();
      this.qtx = paramParcel.readString();
      this.qsL = paramParcel.readInt();
      this.qtG = paramParcel.readString();
      this.field_bankcardClientType = paramParcel.readInt();
      this.field_ext_msg = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label321;
      }
    }
    label321:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.field_support_micropay = bool1;
      this.field_arrive_type = paramParcel.readString();
      this.field_fetch_charge_rate = paramParcel.readDouble();
      this.field_full_fetch_charge_fee = paramParcel.readDouble();
      this.field_no_micro_word = paramParcel.readString();
      this.field_card_bottom_wording = paramParcel.readString();
      this.qtL = paramParcel.readString();
      this.qtI = paramParcel.readLong();
      this.qtK = paramParcel.readLong();
      this.qtJ = paramParcel.readLong();
      this.qtM = paramParcel.readInt();
      this.qtQ = paramParcel.readInt();
      this.qtN = paramParcel.readInt();
      this.qtO = paramParcel.readString();
      this.qtP = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public static boolean AM(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public static String N(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramContext.getString(a.i.wallet_pay_bankcard_not_exist_tips);
    case 1: 
      return paramContext.getString(a.i.wallet_pay_bankcard_expired_tips);
    case 4: 
      return paramContext.getString(a.i.wallet_pay_bankcard_insufficient_balance_tips);
    case 2: 
      return paramContext.getString(a.i.wallet_pay_bankcard_maintenance_tips);
    case 5: 
      return paramContext.getString(a.i.wallet_pay_bankcard_domestic_tips);
    case 6: 
      return paramContext.getString(a.i.wallet_pay_bankcard_international_tips);
    case 3: 
      return paramContext.getString(a.i.wallet_pay_bankcard_quota_tips);
    }
    return paramContext.getString(a.i.wallet_pay_bankcard_not_support_bankcard_tips);
  }
  
  public static boolean eu(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.Bankcard", "supportBankcardTag : " + paramInt1 + ", bankcardTag : " + paramInt2);
    return (paramInt1 & paramInt2) > 0;
  }
  
  public final int a(int paramInt, Orders paramOrders)
  {
    int i = 0;
    if (this.field_bankcardState != 0)
    {
      y.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
      paramInt = this.field_bankcardState;
    }
    do
    {
      do
      {
        do
        {
          return paramInt;
          if ((paramOrders != null) && (paramOrders.bMX.equals(this.qtx))) {
            return 4;
          }
          if ((this.field_bankcardTag & paramInt) > 0) {
            paramInt = 1;
          }
          while (paramInt == 0) {
            if (bUT())
            {
              return 5;
              paramInt = 0;
            }
            else
            {
              return 6;
            }
          }
          paramInt = i;
        } while (paramOrders == null);
        paramInt = i;
      } while (paramOrders.qwK.isEmpty());
      paramInt = i;
    } while (paramOrders.qwK.contains(this.field_bankcardType));
    return 7;
  }
  
  public final boolean bUP()
  {
    if ((this.field_cardType & qtn) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.Bankcard", "isWXCredit, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean bUQ()
  {
    if ((this.field_cardType & qto) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.Bankcard", "isWXCredit, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean bUR()
  {
    if ((this.field_cardType & qtr) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.Bankcard", "isLqtCard, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean bUS()
  {
    if ((this.field_cardType & qtm) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.Bankcard", "isCredit, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean bUT()
  {
    if ((this.field_cardType & qtl) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.Bankcard", "isDomestic, ret = " + bool);
      return bool;
    }
  }
  
  public final boolean bUU()
  {
    return (this.field_cardType & qts) > 0;
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.field_bankName);
    paramParcel.writeString(this.field_desc);
    paramParcel.writeString(this.field_bankcardType);
    paramParcel.writeString(this.field_bindSerial);
    paramParcel.writeInt(this.field_cardType);
    if (this.bre)
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
      paramParcel.writeString(this.qtx);
      paramParcel.writeInt(this.qsL);
      paramParcel.writeString(this.qtG);
      paramParcel.writeInt(this.field_bankcardClientType);
      paramParcel.writeString(this.field_ext_msg);
      if (!this.field_support_micropay) {
        break label300;
      }
    }
    label300:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.field_arrive_type);
      paramParcel.writeDouble(this.field_fetch_charge_rate);
      paramParcel.writeDouble(this.field_full_fetch_charge_fee);
      paramParcel.writeString(this.field_no_micro_word);
      paramParcel.writeString(this.field_card_bottom_wording);
      paramParcel.writeString(this.qtL);
      paramParcel.writeLong(this.qtI);
      paramParcel.writeLong(this.qtK);
      paramParcel.writeLong(this.qtJ);
      paramParcel.writeInt(this.qtM);
      paramParcel.writeInt(this.qtQ);
      paramParcel.writeInt(this.qtN);
      paramParcel.writeString(this.qtO);
      paramParcel.writeString(this.qtP);
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