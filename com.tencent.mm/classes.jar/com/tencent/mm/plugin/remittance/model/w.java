package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.gl.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
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
  public String CoC;
  public gl CoD;
  public int CoV;
  public a CoW;
  public String CoX;
  public String CoY;
  public double CoZ;
  public double Cpa;
  public String Cpb;
  public boolean Cpc;
  public double Cpd;
  public double Cpe;
  public double Cpf;
  public String Cpg;
  public String Cph;
  public String Cpi;
  public double Cpj;
  public String Cpk;
  public String Cpl;
  public String Cpm;
  public int Cpn;
  public String Cpo;
  public String Cpp;
  public int Cpq;
  public String Cpr;
  public String Cps;
  public String Cpt;
  public String Cpu;
  public int Cpv;
  public zd Cpw;
  public String dDM;
  public String dNQ;
  public String dQp;
  public a ebb;
  private int efQ;
  public String qvD;
  public String qya;
  public String username;
  public int yRL;
  public int yXM;
  
  public w(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt4, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, gl paramgl, String paramString15, String paramString16, String paramString17, String paramString18, int paramInt5, String paramString19, int paramInt6)
  {
    AppMethodBeat.i(67885);
    this.dNQ = null;
    this.CoV = 0;
    this.Cpj = 0.0D;
    this.Cpk = "";
    this.Cpl = "";
    this.CoC = "";
    this.CoD = null;
    this.Cpv = 0;
    this.username = "";
    Log.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), paramString11, paramString12, paramString13, paramString14, paramString18, String.valueOf(paramInt5), paramString19, Integer.valueOf(paramInt6) });
    this.Cpj = paramDouble;
    this.efQ = paramInt1;
    this.username = paramString2;
    this.CoC = paramString11;
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
    if ((paramgl != null) && (paramgl.dKn.dKp == 1))
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
      this.CoD = paramgl;
    }
    for (;;)
    {
      try
      {
        if ((this.efQ != 33) && (this.efQ != 32)) {
          continue;
        }
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString8 });
        if (!Util.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", q.encode(paramString4, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString8)) {
          localHashMap.put("desc", q.encode(paramString8, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString11)) {
          localHashMap.put("dynamic_code_url", q.encode(paramString11, "UTF-8"));
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
      localHashMap.put("transfer_qrcode_id", paramString9);
      if ((paramInt2 == 0) || (paramInt2 == 2))
      {
        g.aAi();
        l = ((Long)g.aAh().azQ().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.efQ == 32) || (this.efQ == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt4));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(67885);
      return;
      paramString1 = "0";
      break;
      if (!Util.isNullOrNil(paramString4)) {
        localHashMap.put("desc", q.encode(paramString4, "UTF-8"));
      }
      if (Util.isEqual(paramInt3, 0))
      {
        if (!Util.isNullOrNil(paramString5)) {
          localHashMap.put("address_name", q.encode(paramString5, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString6)) {
          localHashMap.put("phone_num", q.encode(paramString6, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString7)) {
          localHashMap.put("address", q.encode(paramString7, "UTF-8"));
        }
      }
    }
  }
  
  public final int getFuncId()
  {
    if ((this.efQ == 32) || (this.efQ == 33)) {
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
    if ((this.efQ == 32) || (this.efQ == 33)) {
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
      this.Cpf = paramJSONObject.optDouble("used_fee");
      this.dNQ = paramJSONObject.optString("req_key");
      this.CoV = paramJSONObject.optInt("tansfering_num", 0);
      this.CoX = paramJSONObject.optString("transfer_interrupt_desc");
      this.CoY = paramJSONObject.optString("appmsgcontent");
      this.Cpb = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label893;
      }
      bool = true;
      label145:
      this.Cpc = bool;
      this.Cpg = paramJSONObject.optString("receiver_true_name");
      this.Cph = paramJSONObject.optString("f2f_id", "");
      this.qvD = paramJSONObject.optString("trans_id", "");
      this.qya = paramJSONObject.optString("extend_str", "");
      this.Cpi = paramJSONObject.optString("receiver_open_id", "");
      this.yRL = paramJSONObject.optInt("amount", 0);
      this.dQp = paramJSONObject.optString("transfer_id", "");
      this.dDM = paramJSONObject.optString("transaction_id", "");
      this.Cpm = paramJSONObject.optString("receiver_openid", "");
      if (Util.isNullOrNil(this.Cpg)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label899;
      }
      this.Cpd = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label910;
      }
      this.Cpe = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label921;
      }
      this.CoZ = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label932;
      }
      this.Cpa = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).lHA = localJSONObject.optString("left_button_wording");
        ((a)localObject).lHB = localJSONObject.optString("right_button_wording");
        ((a)localObject).qwt = localJSONObject.optString("right_button_url");
        this.ebb = ((a)localObject);
        this.ebb.dQx = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.Cpk = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.Cpl = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.dQx = ((JSONObject)localObject).optString("wording");
        paramString.Cpx = ((JSONObject)localObject).optString("open_button");
        paramString.Cpy = ((JSONObject)localObject).optString("bill_url");
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { Util.nullAsNil(paramString.dQx), Util.nullAsNil(paramString.Cpx), Util.nullAsNil(paramString.Cpy) });
        this.CoW = paramString;
      }
      this.Cpn = paramJSONObject.optInt("scan_scene", 0);
      this.Cpo = paramJSONObject.optString("placeorder_suc_sign");
      this.Cpp = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.CoY)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.Cpq = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.Cpr = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.Cps = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.Cpt = paramJSONObject.optString("show_paying_wording", "");
      this.Cpu = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.Cpv = paramJSONObject.optInt("need_checkname", 0);
      this.yXM = paramJSONObject.optInt("return_to_session", 0);
      Log.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.yXM) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.Cpw = new zd();
        this.Cpw.title = paramString.optString("title");
        this.Cpw.Crt = paramString.optString("checkname_sign");
        this.Cpw.AOv = paramString.optString("display_name");
        this.Cpw.dQx = paramString.optString("wording");
        this.Cpw.Lko = paramString.optInt("message_type", 0);
      }
      AppMethodBeat.o(67886);
      return;
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label893:
      bool = false;
      break label145;
      label899:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label910:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label921:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label932:
      Log.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
  
  public static final class a
  {
    public String Cpx;
    public String Cpy;
    public String dQx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */