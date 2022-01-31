package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.h.a.fu.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v
  extends j
  implements com.tencent.mm.wallet_core.c.g
{
  public int amount;
  public String bMY;
  public String bOT = null;
  public String bQR;
  public a bZo;
  private int ccY;
  public String iGK;
  public String iIB;
  public String nyA;
  public String nyB;
  public double nyC;
  public double nyD;
  public String nyE;
  public boolean nyF;
  public double nyG;
  public String nyH;
  public double nyI;
  public double nyJ;
  public String nyK;
  public String nyL;
  public String nyM;
  public double nyN = 0.0D;
  public String nyO = "";
  public String nyP = "";
  public String nyQ;
  public int nyR;
  public String nyS;
  public String nyT;
  public int nyU;
  public String nyV;
  public String nyW;
  public String nyX;
  public String nyY;
  public int nyZ = 0;
  public String nyi = "";
  public fu nyj = null;
  public int nyz = 0;
  public pj nza;
  public String username = "";
  
  public v(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, fu paramfu, String paramString12, String paramString13, String paramString14)
  {
    y.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString8, paramString9, paramString10, paramString11 });
    this.nyN = paramDouble;
    this.ccY = paramInt1;
    this.username = paramString2;
    this.nyi = paramString8;
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("transfer_scene", String.valueOf(paramInt2));
    localHashMap.put("fee", Math.round(100.0D * paramDouble));
    localHashMap.put("fee_type", paramString1);
    localHashMap.put("receiver_name", paramString2);
    localHashMap.put("receiver_openid", paramString7);
    localHashMap.put("mask_truename", paramString3);
    localHashMap.put("mch_name", paramString9);
    localHashMap.put("nickname", paramString10);
    localHashMap.put("receiver_true_name", paramString11);
    if ((paramfu != null) && (paramfu.bMR.bMU == 1))
    {
      paramString1 = "1";
      localHashMap.put("dynamic_code_source", paramString1);
      localHashMap.put("input_name", paramString12);
      localHashMap.put("checkname_sign", paramString13);
      localHashMap.put("truename_extend", paramString14);
      this.nyj = paramfu;
    }
    for (;;)
    {
      try
      {
        if ((this.ccY != 33) && (this.ccY != 32)) {
          continue;
        }
        y.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString5 });
        if (!bk.bl(paramString4)) {
          localHashMap.put("f2f_payer_desc", q.encode(paramString4, "UTF-8"));
        }
        if (!bk.bl(paramString5)) {
          localHashMap.put("desc", q.encode(paramString5, "UTF-8"));
        }
        if (!bk.bl(paramString8)) {
          localHashMap.put("dynamic_code_url", q.encode(paramString8, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        y.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
        continue;
        if ((l & 0x20) == 0L) {
          continue;
        }
        paramInt1 = 1;
        continue;
      }
      localHashMap.put("transfer_qrcode_id", paramString6);
      if ((paramInt2 == 0) || (paramInt2 == 2))
      {
        com.tencent.mm.kernel.g.DQ();
        l = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        y.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      D(localHashMap);
      if ((this.ccY == 32) || (this.ccY == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt3));
        aC(paramString1);
      }
      return;
      paramString1 = "0";
      break;
      if (!bk.bl(paramString4)) {
        localHashMap.put("desc", q.encode(paramString4, "UTF-8"));
      }
    }
  }
  
  public final int HH()
  {
    if ((this.ccY == 32) || (this.ccY == 33)) {
      return 1582;
    }
    return 1544;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    y.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2)) {
      return;
    }
    if (paramJSONObject.has("used_fee"))
    {
      this.nyJ = paramJSONObject.optDouble("used_fee");
      label66:
      this.bOT = paramJSONObject.optString("req_key");
      this.nyz = paramJSONObject.optInt("tansfering_num", 0);
      this.nyA = paramJSONObject.optString("transfer_interrupt_desc");
      this.nyB = paramJSONObject.optString("appmsgcontent");
      this.nyE = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label723;
      }
      label133:
      this.nyF = bool;
      this.nyK = paramJSONObject.optString("receiver_true_name");
      this.nyL = paramJSONObject.optString("f2f_id", "");
      this.iGK = paramJSONObject.optString("trans_id", "");
      this.iIB = paramJSONObject.optString("extend_str", "");
      this.nyM = paramJSONObject.optString("receiver_open_id", "");
      this.amount = paramJSONObject.optInt("amount", 0);
      this.bQR = paramJSONObject.optString("transfer_id", "");
      this.bMY = paramJSONObject.optString("transaction_id", "");
      this.nyQ = paramJSONObject.optString("receiver_openid", "");
      if (bk.bl(this.nyK)) {
        y.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label729;
      }
      this.nyG = paramJSONObject.optDouble("remain_fee");
      label290:
      if (!paramJSONObject.has("exceed_fee")) {
        break label740;
      }
      this.nyI = paramJSONObject.optDouble("exceed_fee");
      label311:
      if (!paramJSONObject.has("charge_fee")) {
        break label751;
      }
      this.nyC = paramJSONObject.optDouble("charge_fee");
      label332:
      if (!paramJSONObject.has("free_limit")) {
        break label762;
      }
      this.nyD = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      if (paramJSONObject.has("showmessage"))
      {
        y.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        a locala = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        locala.lRE = localJSONObject.optString("left_button_wording");
        locala.lRF = localJSONObject.optString("right_button_wording");
        locala.iHx = localJSONObject.optString("right_button_url");
        this.bZo = locala;
        this.bZo.bQZ = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.nyO = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        y.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.nyP = paramJSONObject.optString("double_check_wording");
      }
      this.nyR = paramJSONObject.optInt("scan_scene", 0);
      this.nyS = paramJSONObject.optString("placeorder_suc_sign");
      this.nyT = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.nyB)) {
        y.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.nyU = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.nyV = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.nyW = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.nyX = paramJSONObject.optString("show_paying_wording", "");
      this.nyY = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.nyZ = paramJSONObject.optInt("need_checkname", 0);
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString == null) {
        break;
      }
      this.nza = new pj();
      this.nza.title = paramString.optString("title");
      this.nza.nAu = paramString.optString("checkname_sign");
      this.nza.mPk = paramString.optString("display_name");
      this.nza.bQZ = paramString.optString("wording");
      this.nza.sNe = paramString.optInt("message_type", 0);
      return;
      y.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label66;
      label723:
      bool = false;
      break label133;
      label729:
      y.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label290;
      label740:
      y.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label311;
      label751:
      y.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label332;
      label762:
      y.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final int aEC()
  {
    return 0;
  }
  
  public final boolean bwh()
  {
    return true;
  }
  
  public final String getUri()
  {
    if ((this.ccY == 32) || (this.ccY == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.v
 * JD-Core Version:    0.7.0.1
 */