package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.gd.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends m
  implements j
{
  private int dCG;
  public String dcF;
  public String dlJ;
  public String dnZ;
  public a dyo;
  public String nSY;
  public String nVt;
  public int tav;
  public int tfL;
  public String username;
  public int vAB;
  public a vAC;
  public String vAD;
  public String vAE;
  public double vAF;
  public double vAG;
  public String vAH;
  public boolean vAI;
  public double vAJ;
  public double vAK;
  public double vAL;
  public String vAM;
  public String vAN;
  public String vAO;
  public double vAP;
  public String vAQ;
  public String vAR;
  public String vAS;
  public int vAT;
  public String vAU;
  public String vAV;
  public int vAW;
  public String vAX;
  public String vAY;
  public String vAZ;
  public String vAi;
  public gd vAj;
  public String vBa;
  public int vBb;
  public vf vBc;
  
  public w(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt4, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, gd paramgd, String paramString15, String paramString16, String paramString17, String paramString18, int paramInt5, String paramString19, int paramInt6)
  {
    AppMethodBeat.i(67885);
    this.dlJ = null;
    this.vAB = 0;
    this.vAP = 0.0D;
    this.vAQ = "";
    this.vAR = "";
    this.vAi = "";
    this.vAj = null;
    this.vBb = 0;
    this.username = "";
    ad.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), paramString11, paramString12, paramString13, paramString14, paramString18, String.valueOf(paramInt5), paramString19, Integer.valueOf(paramInt6) });
    this.vAP = paramDouble;
    this.dCG = paramInt1;
    this.username = paramString2;
    this.vAi = paramString11;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("transfer_scene", String.valueOf(paramInt2));
    localHashMap.put("fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("receiver_openid", paramString10);
    localHashMap.put("mask_truename", paramString3);
    localHashMap.put("mch_name", paramString12);
    localHashMap.put("nickname", paramString13);
    localHashMap.put("receiver_true_name", paramString14);
    if ((paramgd != null) && (paramgd.djg.dji == 1))
    {
      paramString1 = "1";
      localHashMap.put("dynamic_code_source", paramString1);
      localHashMap.put("input_name", paramString15);
      localHashMap.put("checkname_sign", paramString16);
      localHashMap.put("truename_extend", paramString17);
      localHashMap.put("placeorder_reserves", paramString18);
      localHashMap.put("cancel_outtradeno", paramString19);
      localHashMap.put("unpay_type", String.valueOf(paramInt5));
      localHashMap.put("cancel_reason", String.valueOf(paramInt6));
      this.vAj = paramgd;
    }
    for (;;)
    {
      try
      {
        if ((this.dCG != 33) && (this.dCG != 32)) {
          continue;
        }
        ad.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString8 });
        if (!bt.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", p.encode(paramString4, "UTF-8"));
        }
        if (!bt.isNullOrNil(paramString8)) {
          localHashMap.put("desc", p.encode(paramString8, "UTF-8"));
        }
        if (!bt.isNullOrNil(paramString11)) {
          localHashMap.put("dynamic_code_url", p.encode(paramString11, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        ad.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
        continue;
        if ((l & 0x20) == 0L) {
          continue;
        }
        paramInt1 = 1;
        continue;
      }
      localHashMap.put("transfer_qrcode_id", paramString9);
      if ((paramInt2 == 0) || (paramInt2 == 2))
      {
        g.afC();
        l = ((Long)g.afB().afk().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        ad.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.dCG == 32) || (this.dCG == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt4));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(67885);
      return;
      paramString1 = "0";
      break;
      if (!bt.isNullOrNil(paramString4)) {
        localHashMap.put("desc", p.encode(paramString4, "UTF-8"));
      }
      if (bt.iY(paramInt3, 0))
      {
        if (!bt.isNullOrNil(paramString5)) {
          localHashMap.put("address_name", p.encode(paramString5, "UTF-8"));
        }
        if (!bt.isNullOrNil(paramString6)) {
          localHashMap.put("phone_num", p.encode(paramString6, "UTF-8"));
        }
        if (!bt.isNullOrNil(paramString7)) {
          localHashMap.put("address", p.encode(paramString7, "UTF-8"));
        }
      }
    }
  }
  
  public final int getFuncId()
  {
    if ((this.dCG == 32) || (this.dCG == 33)) {
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
    if ((this.dCG == 32) || (this.dCG == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67886);
    ad.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2))
    {
      AppMethodBeat.o(67886);
      return;
    }
    boolean bool;
    if (paramJSONObject.has("used_fee"))
    {
      this.vAL = paramJSONObject.optDouble("used_fee");
      this.dlJ = paramJSONObject.optString("req_key");
      this.vAB = paramJSONObject.optInt("tansfering_num", 0);
      this.vAD = paramJSONObject.optString("transfer_interrupt_desc");
      this.vAE = paramJSONObject.optString("appmsgcontent");
      this.vAH = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label893;
      }
      bool = true;
      label145:
      this.vAI = bool;
      this.vAM = paramJSONObject.optString("receiver_true_name");
      this.vAN = paramJSONObject.optString("f2f_id", "");
      this.nSY = paramJSONObject.optString("trans_id", "");
      this.nVt = paramJSONObject.optString("extend_str", "");
      this.vAO = paramJSONObject.optString("receiver_open_id", "");
      this.tav = paramJSONObject.optInt("amount", 0);
      this.dnZ = paramJSONObject.optString("transfer_id", "");
      this.dcF = paramJSONObject.optString("transaction_id", "");
      this.vAS = paramJSONObject.optString("receiver_openid", "");
      if (bt.isNullOrNil(this.vAM)) {
        ad.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label899;
      }
      this.vAJ = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label910;
      }
      this.vAK = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label921;
      }
      this.vAF = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label932;
      }
      this.vAG = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        ad.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).tfH = localJSONObject.optString("left_button_wording");
        ((a)localObject).tfI = localJSONObject.optString("right_button_wording");
        ((a)localObject).nTQ = localJSONObject.optString("right_button_url");
        this.dyo = ((a)localObject);
        this.dyo.doh = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.vAQ = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        ad.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.vAR = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        ad.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.doh = ((JSONObject)localObject).optString("wording");
        paramString.vBd = ((JSONObject)localObject).optString("open_button");
        paramString.vBe = ((JSONObject)localObject).optString("bill_url");
        ad.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { bt.nullAsNil(paramString.doh), bt.nullAsNil(paramString.vBd), bt.nullAsNil(paramString.vBe) });
        this.vAC = paramString;
      }
      this.vAT = paramJSONObject.optInt("scan_scene", 0);
      this.vAU = paramJSONObject.optString("placeorder_suc_sign");
      this.vAV = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.vAE)) {
        ad.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.vAW = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.vAX = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.vAY = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.vAZ = paramJSONObject.optString("show_paying_wording", "");
      this.vBa = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.vBb = paramJSONObject.optInt("need_checkname", 0);
      this.tfL = paramJSONObject.optInt("return_to_session", 0);
      ad.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.tfL) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.vBc = new vf();
        this.vBc.title = paramString.optString("title");
        this.vBc.vCY = paramString.optString("checkname_sign");
        this.vBc.uoA = paramString.optString("display_name");
        this.vBc.doh = paramString.optString("wording");
        this.vBc.CXj = paramString.optInt("message_type", 0);
      }
      AppMethodBeat.o(67886);
      return;
      ad.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label893:
      bool = false;
      break label145;
      label899:
      ad.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label910:
      ad.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label921:
      ad.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label932:
      ad.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
  
  public static final class a
  {
    public String doh;
    public String vBd;
    public String vBe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */