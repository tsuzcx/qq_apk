package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends m
  implements i
{
  public b cHz;
  private int cLI;
  public String cnJ;
  public String cwk;
  public String cyr;
  public String kMN;
  public String kPg;
  public int okH;
  public int opG;
  public v.a qjA;
  public String qjB;
  public String qjC;
  public double qjD;
  public double qjE;
  public String qjF;
  public boolean qjG;
  public double qjH;
  public double qjI;
  public double qjJ;
  public String qjK;
  public String qjL;
  public String qjM;
  public double qjN;
  public String qjO;
  public String qjP;
  public String qjQ;
  public int qjR;
  public String qjS;
  public String qjT;
  public int qjU;
  public String qjV;
  public String qjW;
  public String qjX;
  public String qjY;
  public int qjZ;
  public String qjj;
  public fx qjk;
  public int qjz;
  public sn qka;
  public String username;
  
  public v(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt4, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, fx paramfx, String paramString15, String paramString16, String paramString17, String paramString18, int paramInt5, String paramString19, int paramInt6)
  {
    AppMethodBeat.i(44772);
    this.cwk = null;
    this.qjz = 0;
    this.qjN = 0.0D;
    this.qjO = "";
    this.qjP = "";
    this.qjj = "";
    this.qjk = null;
    this.qjZ = 0;
    this.username = "";
    ab.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), paramString11, paramString12, paramString13, paramString14, paramString18, String.valueOf(paramInt5), paramString19, Integer.valueOf(paramInt6) });
    this.qjN = paramDouble;
    this.cLI = paramInt1;
    this.username = paramString2;
    this.qjj = paramString11;
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
    if ((paramfx != null) && (paramfx.cul.cuo == 1))
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
      this.qjk = paramfx;
    }
    for (;;)
    {
      try
      {
        if ((this.cLI != 33) && (this.cLI != 32)) {
          continue;
        }
        ab.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString8 });
        if (!bo.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", q.encode(paramString4, "UTF-8"));
        }
        if (!bo.isNullOrNil(paramString8)) {
          localHashMap.put("desc", q.encode(paramString8, "UTF-8"));
        }
        if (!bo.isNullOrNil(paramString11)) {
          localHashMap.put("dynamic_code_url", q.encode(paramString11, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        ab.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
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
        g.RM();
        l = ((Long)g.RL().Ru().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        ab.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.cLI == 32) || (this.cLI == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt4));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(44772);
      return;
      paramString1 = "0";
      break;
      if (!bo.isNullOrNil(paramString4)) {
        localHashMap.put("desc", q.encode(paramString4, "UTF-8"));
      }
      if (bo.hl(paramInt3, 0))
      {
        if (!bo.isNullOrNil(paramString5)) {
          localHashMap.put("address_name", q.encode(paramString5, "UTF-8"));
        }
        if (!bo.isNullOrNil(paramString6)) {
          localHashMap.put("phone_num", q.encode(paramString6, "UTF-8"));
        }
        if (!bo.isNullOrNil(paramString7)) {
          localHashMap.put("address", q.encode(paramString7, "UTF-8"));
        }
      }
    }
  }
  
  public final int getFuncId()
  {
    if ((this.cLI == 32) || (this.cLI == 33)) {
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
    if ((this.cLI == 32) || (this.cLI == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44773);
    ab.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2))
    {
      AppMethodBeat.o(44773);
      return;
    }
    boolean bool;
    if (paramJSONObject.has("used_fee"))
    {
      this.qjJ = paramJSONObject.optDouble("used_fee");
      this.cwk = paramJSONObject.optString("req_key");
      this.qjz = paramJSONObject.optInt("tansfering_num", 0);
      this.qjB = paramJSONObject.optString("transfer_interrupt_desc");
      this.qjC = paramJSONObject.optString("appmsgcontent");
      this.qjF = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label893;
      }
      bool = true;
      label145:
      this.qjG = bool;
      this.qjK = paramJSONObject.optString("receiver_true_name");
      this.qjL = paramJSONObject.optString("f2f_id", "");
      this.kMN = paramJSONObject.optString("trans_id", "");
      this.kPg = paramJSONObject.optString("extend_str", "");
      this.qjM = paramJSONObject.optString("receiver_open_id", "");
      this.okH = paramJSONObject.optInt("amount", 0);
      this.cyr = paramJSONObject.optString("transfer_id", "");
      this.cnJ = paramJSONObject.optString("transaction_id", "");
      this.qjQ = paramJSONObject.optString("receiver_openid", "");
      if (bo.isNullOrNil(this.qjK)) {
        ab.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label899;
      }
      this.qjH = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label910;
      }
      this.qjI = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label921;
      }
      this.qjD = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label932;
      }
      this.qjE = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        ab.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new b();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((b)localObject).opC = localJSONObject.optString("left_button_wording");
        ((b)localObject).opD = localJSONObject.optString("right_button_wording");
        ((b)localObject).kNB = localJSONObject.optString("right_button_url");
        this.cHz = ((b)localObject);
        this.cHz.cyA = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.qjO = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        ab.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.qjP = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        ab.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new v.a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.cyA = ((JSONObject)localObject).optString("wording");
        paramString.qkb = ((JSONObject)localObject).optString("open_button");
        paramString.qkc = ((JSONObject)localObject).optString("bill_url");
        ab.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { bo.nullAsNil(paramString.cyA), bo.nullAsNil(paramString.qkb), bo.nullAsNil(paramString.qkc) });
        this.qjA = paramString;
      }
      this.qjR = paramJSONObject.optInt("scan_scene", 0);
      this.qjS = paramJSONObject.optString("placeorder_suc_sign");
      this.qjT = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.qjC)) {
        ab.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.qjU = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.qjV = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.qjW = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.qjX = paramJSONObject.optString("show_paying_wording", "");
      this.qjY = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.qjZ = paramJSONObject.optInt("need_checkname", 0);
      this.opG = paramJSONObject.optInt("return_to_session", 0);
      ab.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.opG) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.qka = new sn();
        this.qka.title = paramString.optString("title");
        this.qka.qlQ = paramString.optString("checkname_sign");
        this.qka.ppA = paramString.optString("display_name");
        this.qka.cyA = paramString.optString("wording");
        this.qka.wKU = paramString.optInt("message_type", 0);
      }
      AppMethodBeat.o(44773);
      return;
      ab.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label893:
      bool = false;
      break label145;
      label899:
      ab.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label910:
      ab.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label921:
      ab.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label932:
      ab.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */