package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  public a dJo;
  private int dNV;
  public String dmx;
  public String dwj;
  public String dyA;
  public String pgs;
  public String piP;
  public String username;
  public int vCJ;
  public int vxx;
  public String ynM;
  public gi ynN;
  public int yoA;
  public String yoB;
  public String yoC;
  public String yoD;
  public String yoE;
  public int yoF;
  public xr yoG;
  public int yof;
  public a yog;
  public String yoh;
  public String yoi;
  public double yoj;
  public double yok;
  public String yol;
  public boolean yom;
  public double yon;
  public double yoo;
  public double yop;
  public String yoq;
  public String yor;
  public String yos;
  public double yot;
  public String you;
  public String yov;
  public String yow;
  public int yox;
  public String yoy;
  public String yoz;
  
  public w(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt4, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, gi paramgi, String paramString15, String paramString16, String paramString17, String paramString18, int paramInt5, String paramString19, int paramInt6)
  {
    AppMethodBeat.i(67885);
    this.dwj = null;
    this.yof = 0;
    this.yot = 0.0D;
    this.you = "";
    this.yov = "";
    this.ynM = "";
    this.ynN = null;
    this.yoF = 0;
    this.username = "";
    ae.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), paramString11, paramString12, paramString13, paramString14, paramString18, String.valueOf(paramInt5), paramString19, Integer.valueOf(paramInt6) });
    this.yot = paramDouble;
    this.dNV = paramInt1;
    this.username = paramString2;
    this.ynM = paramString11;
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
    if ((paramgi != null) && (paramgi.dtd.dtf == 1))
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
      this.ynN = paramgi;
    }
    for (;;)
    {
      try
      {
        if ((this.dNV != 33) && (this.dNV != 32)) {
          continue;
        }
        ae.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString8 });
        if (!bu.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", q.encode(paramString4, "UTF-8"));
        }
        if (!bu.isNullOrNil(paramString8)) {
          localHashMap.put("desc", q.encode(paramString8, "UTF-8"));
        }
        if (!bu.isNullOrNil(paramString11)) {
          localHashMap.put("dynamic_code_url", q.encode(paramString11, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        ae.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
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
        g.ajS();
        l = ((Long)g.ajR().ajA().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        ae.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.dNV == 32) || (this.dNV == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt4));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(67885);
      return;
      paramString1 = "0";
      break;
      if (!bu.isNullOrNil(paramString4)) {
        localHashMap.put("desc", q.encode(paramString4, "UTF-8"));
      }
      if (bu.jB(paramInt3, 0))
      {
        if (!bu.isNullOrNil(paramString5)) {
          localHashMap.put("address_name", q.encode(paramString5, "UTF-8"));
        }
        if (!bu.isNullOrNil(paramString6)) {
          localHashMap.put("phone_num", q.encode(paramString6, "UTF-8"));
        }
        if (!bu.isNullOrNil(paramString7)) {
          localHashMap.put("address", q.encode(paramString7, "UTF-8"));
        }
      }
    }
  }
  
  public final int getFuncId()
  {
    if ((this.dNV == 32) || (this.dNV == 33)) {
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
    if ((this.dNV == 32) || (this.dNV == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67886);
    ae.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2))
    {
      AppMethodBeat.o(67886);
      return;
    }
    boolean bool;
    if (paramJSONObject.has("used_fee"))
    {
      this.yop = paramJSONObject.optDouble("used_fee");
      this.dwj = paramJSONObject.optString("req_key");
      this.yof = paramJSONObject.optInt("tansfering_num", 0);
      this.yoh = paramJSONObject.optString("transfer_interrupt_desc");
      this.yoi = paramJSONObject.optString("appmsgcontent");
      this.yol = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label893;
      }
      bool = true;
      label145:
      this.yom = bool;
      this.yoq = paramJSONObject.optString("receiver_true_name");
      this.yor = paramJSONObject.optString("f2f_id", "");
      this.pgs = paramJSONObject.optString("trans_id", "");
      this.piP = paramJSONObject.optString("extend_str", "");
      this.yos = paramJSONObject.optString("receiver_open_id", "");
      this.vxx = paramJSONObject.optInt("amount", 0);
      this.dyA = paramJSONObject.optString("transfer_id", "");
      this.dmx = paramJSONObject.optString("transaction_id", "");
      this.yow = paramJSONObject.optString("receiver_openid", "");
      if (bu.isNullOrNil(this.yoq)) {
        ae.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label899;
      }
      this.yon = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label910;
      }
      this.yoo = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label921;
      }
      this.yoj = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label932;
      }
      this.yok = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        ae.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).kCZ = localJSONObject.optString("left_button_wording");
        ((a)localObject).kDa = localJSONObject.optString("right_button_wording");
        ((a)localObject).phk = localJSONObject.optString("right_button_url");
        this.dJo = ((a)localObject);
        this.dJo.dyI = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.you = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        ae.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.yov = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        ae.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.dyI = ((JSONObject)localObject).optString("wording");
        paramString.yoH = ((JSONObject)localObject).optString("open_button");
        paramString.yoI = ((JSONObject)localObject).optString("bill_url");
        ae.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { bu.nullAsNil(paramString.dyI), bu.nullAsNil(paramString.yoH), bu.nullAsNil(paramString.yoI) });
        this.yog = paramString;
      }
      this.yox = paramJSONObject.optInt("scan_scene", 0);
      this.yoy = paramJSONObject.optString("placeorder_suc_sign");
      this.yoz = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.yoi)) {
        ae.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.yoA = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.yoB = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.yoC = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.yoD = paramJSONObject.optString("show_paying_wording", "");
      this.yoE = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.yoF = paramJSONObject.optInt("need_checkname", 0);
      this.vCJ = paramJSONObject.optInt("return_to_session", 0);
      ae.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.vCJ) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.yoG = new xr();
        this.yoG.title = paramString.optString("title");
        this.yoG.yqC = paramString.optString("checkname_sign");
        this.yoG.wSB = paramString.optString("display_name");
        this.yoG.dyI = paramString.optString("wording");
        this.yoG.GpC = paramString.optInt("message_type", 0);
      }
      AppMethodBeat.o(67886);
      return;
      ae.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label893:
      bool = false;
      break label145;
      label899:
      ae.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label910:
      ae.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label921:
      ae.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label932:
      ae.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
  
  public static final class a
  {
    public String dyI;
    public String yoH;
    public String yoI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */