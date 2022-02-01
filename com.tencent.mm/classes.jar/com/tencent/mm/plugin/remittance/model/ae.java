package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.a.gs;
import com.tencent.mm.f.a.gs.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ae
  extends m
  implements j
{
  public int EBQ;
  public String IlE;
  public gs IlF;
  public long Ilo;
  public String ImA;
  public String ImB;
  public int ImC;
  public String ImD;
  public String ImE;
  public int ImF;
  public String ImG;
  public String ImH;
  public String ImI;
  public String ImJ;
  public int ImK;
  public zh ImL;
  public String Imh;
  public int Imk;
  public a Iml;
  public String Imm;
  public String Imn;
  public double Imo;
  public double Imp;
  public String Imq;
  public boolean Imr;
  public double Ims;
  public double Imt;
  public double Imu;
  public String Imv;
  public String Imw;
  public String Imx;
  public double Imy;
  public String Imz;
  public int amount;
  public String fHb;
  public String fJG;
  public a fUY;
  public String fww;
  private int gag;
  public String tUC;
  public String tXa;
  public String username;
  
  public ae(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt3, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, gs paramgs, String paramString13, String paramString14, String paramString15, String paramString16, int paramInt4, String paramString17, int paramInt5, String paramString18)
  {
    AppMethodBeat.i(224809);
    this.fHb = null;
    this.Imk = 0;
    this.Imy = 0.0D;
    this.Imz = "";
    this.ImA = "";
    this.IlE = "";
    this.IlF = null;
    this.ImK = 0;
    this.username = "";
    Log.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString9, paramString10, paramString11, paramString12, paramString16, String.valueOf(paramInt4), paramString17, Integer.valueOf(paramInt5) });
    this.Imy = paramDouble;
    this.gag = paramInt1;
    this.username = paramString2;
    this.IlE = paramString9;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("transfer_scene", String.valueOf(paramInt2));
    localHashMap.put("fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("receiver_openid", paramString8);
    localHashMap.put("mask_truename", paramString3);
    localHashMap.put("mch_name", paramString10);
    localHashMap.put("nickname", paramString11);
    localHashMap.put("receiver_true_name", paramString12);
    if ((paramgs != null) && (paramgs.fDc.fDe == 1))
    {
      paramString1 = "1";
      localHashMap.put("dynamic_code_source", paramString1);
      localHashMap.put("input_name", paramString13);
      localHashMap.put("checkname_sign", paramString14);
      localHashMap.put("truename_extend", paramString15);
      localHashMap.put("placeorder_reserves", paramString16);
      localHashMap.put("cancel_outtradeno", paramString17);
      localHashMap.put("unpay_type", String.valueOf(paramInt4));
      localHashMap.put("cancel_reason", String.valueOf(paramInt5));
      localHashMap.put("group_username", paramString18);
      this.IlF = paramgs;
    }
    for (;;)
    {
      try
      {
        if ((this.gag != 33) && (this.gag != 32)) {
          continue;
        }
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString6 });
        if (!Util.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", q.an(paramString4, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString6)) {
          localHashMap.put("desc", q.an(paramString6, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString9)) {
          localHashMap.put("dynamic_code_url", q.an(paramString9, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
        continue;
        if ((l & 0x20) == 0L) {
          continue;
        }
        paramInt1 = 1;
        continue;
      }
      localHashMap.put("transfer_qrcode_id", paramString7);
      if ((paramInt2 == 0) || (paramInt2 == 2))
      {
        h.aHH();
        l = ((Long)h.aHG().aHp().b(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.gag == 32) || (this.gag == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt3));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(224809);
      return;
      paramString1 = "0";
      break;
      if (!Util.isNullOrNil(paramString4)) {
        localHashMap.put("desc", q.an(paramString4, "UTF-8"));
      }
      localHashMap.put("desc_has_address", String.valueOf(ka(paramString4, paramString5)));
    }
  }
  
  private static int ka(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224811);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(224811);
      return 0;
    }
    int i = 0;
    while (i < paramString1.length())
    {
      int j = 0;
      while (j < paramString2.length())
      {
        if (paramString1.charAt(i) == paramString2.charAt(j))
        {
          Log.i("Micromsg.NetSceneTenpayRemittanceGen", "find equal char: %s, %s, %s", new Object[] { Character.valueOf(paramString1.charAt(i)), Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(224811);
          return 1;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(224811);
    return 0;
  }
  
  public final int getFuncId()
  {
    if ((this.gag == 32) || (this.gag == 33)) {
      return 1582;
    }
    return 1544;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    if ((this.gag == 32) || (this.gag == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67886);
    Log.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2))
    {
      AppMethodBeat.o(67886);
      return;
    }
    boolean bool;
    if (paramJSONObject.has("used_fee"))
    {
      this.Imu = paramJSONObject.optDouble("used_fee");
      this.fHb = paramJSONObject.optString("req_key");
      this.Imk = paramJSONObject.optInt("tansfering_num", 0);
      this.Imm = paramJSONObject.optString("transfer_interrupt_desc");
      this.Imn = paramJSONObject.optString("appmsgcontent");
      this.Imq = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label930;
      }
      bool = true;
      label145:
      this.Imr = bool;
      this.Imv = paramJSONObject.optString("receiver_true_name");
      this.Imw = paramJSONObject.optString("f2f_id", "");
      this.tUC = paramJSONObject.optString("trans_id", "");
      this.tXa = paramJSONObject.optString("extend_str", "");
      this.Imx = paramJSONObject.optString("receiver_open_id", "");
      this.amount = paramJSONObject.optInt("amount", 0);
      this.fJG = paramJSONObject.optString("transfer_id", "");
      this.fww = paramJSONObject.optString("transaction_id", "");
      this.ImB = paramJSONObject.optString("receiver_openid", "");
      if (Util.isNullOrNil(this.Imv)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label936;
      }
      this.Ims = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label947;
      }
      this.Imt = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label958;
      }
      this.Imo = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label969;
      }
      this.Imp = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).oDJ = localJSONObject.optString("left_button_wording");
        ((a)localObject).oDK = localJSONObject.optString("right_button_wording");
        ((a)localObject).tVu = localJSONObject.optString("right_button_url");
        this.fUY = ((a)localObject);
        this.fUY.wording = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.Imz = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.ImA = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.wording = ((JSONObject)localObject).optString("wording");
        paramString.ImM = ((JSONObject)localObject).optString("open_button");
        paramString.ImN = ((JSONObject)localObject).optString("bill_url");
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { Util.nullAsNil(paramString.wording), Util.nullAsNil(paramString.ImM), Util.nullAsNil(paramString.ImN) });
        this.Iml = paramString;
      }
      this.ImC = paramJSONObject.optInt("scan_scene", 0);
      this.ImD = paramJSONObject.optString("placeorder_suc_sign");
      this.ImE = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.Imn)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.ImF = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.ImG = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.ImH = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.ImI = paramJSONObject.optString("show_paying_wording", "");
      this.ImJ = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.ImK = paramJSONObject.optInt("need_checkname", 0);
      this.EBQ = paramJSONObject.optInt("return_to_session", 0);
      Log.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.EBQ) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.ImL = new zh();
        this.ImL.title = paramString.optString("title");
        this.ImL.IoR = paramString.optString("checkname_sign");
        this.ImL.GHJ = paramString.optString("display_name");
        this.ImL.wording = paramString.optString("wording");
        this.ImL.Slx = paramString.optInt("message_type", 0);
      }
      paramString = paramJSONObject.optJSONObject("msg_check_info");
      if (paramString != null)
      {
        this.Ilo = paramString.optLong("msg_check_sec", 0L);
        this.Imh = paramString.optString("msg_check_str", "");
      }
      AppMethodBeat.o(67886);
      return;
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label930:
      bool = false;
      break label145;
      label936:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label947:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label958:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label969:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
  
  public static final class a
  {
    public String ImM;
    public String ImN;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ae
 * JD-Core Version:    0.7.0.1
 */