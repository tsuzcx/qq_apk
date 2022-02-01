package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  private int dAs;
  public String dad;
  public String djr;
  public String dlI;
  public a dwa;
  public String owt;
  public String oyO;
  public int uiK;
  public int uoa;
  public String username;
  public int wKG;
  public a wKH;
  public String wKI;
  public String wKJ;
  public double wKK;
  public double wKL;
  public String wKM;
  public boolean wKN;
  public double wKO;
  public double wKP;
  public double wKQ;
  public String wKR;
  public String wKS;
  public String wKT;
  public double wKU;
  public String wKV;
  public String wKW;
  public String wKX;
  public int wKY;
  public String wKZ;
  public String wKn;
  public ge wKo;
  public String wLa;
  public int wLb;
  public String wLc;
  public String wLd;
  public String wLe;
  public String wLf;
  public int wLg;
  public vp wLh;
  
  public w(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt4, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, ge paramge, String paramString15, String paramString16, String paramString17, String paramString18, int paramInt5, String paramString19, int paramInt6)
  {
    AppMethodBeat.i(67885);
    this.djr = null;
    this.wKG = 0;
    this.wKU = 0.0D;
    this.wKV = "";
    this.wKW = "";
    this.wKn = "";
    this.wKo = null;
    this.wLg = 0;
    this.username = "";
    ac.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4), paramString11, paramString12, paramString13, paramString14, paramString18, String.valueOf(paramInt5), paramString19, Integer.valueOf(paramInt6) });
    this.wKU = paramDouble;
    this.dAs = paramInt1;
    this.username = paramString2;
    this.wKn = paramString11;
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
    if ((paramge != null) && (paramge.dgB.dgD == 1))
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
      this.wKo = paramge;
    }
    for (;;)
    {
      try
      {
        if ((this.dAs != 33) && (this.dAs != 32)) {
          continue;
        }
        ac.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString8 });
        if (!bs.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", p.encode(paramString4, "UTF-8"));
        }
        if (!bs.isNullOrNil(paramString8)) {
          localHashMap.put("desc", p.encode(paramString8, "UTF-8"));
        }
        if (!bs.isNullOrNil(paramString11)) {
          localHashMap.put("dynamic_code_url", p.encode(paramString11, "UTF-8"));
        }
      }
      catch (UnsupportedEncodingException paramString1)
      {
        long l;
        ac.e("Micromsg.NetSceneTenpayRemittanceGen", paramString1.getMessage(), new Object[] { paramString1 });
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
        g.agS();
        l = ((Long)g.agR().agA().get(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        ac.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.dAs == 32) || (this.dAs == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt4));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(67885);
      return;
      paramString1 = "0";
      break;
      if (!bs.isNullOrNil(paramString4)) {
        localHashMap.put("desc", p.encode(paramString4, "UTF-8"));
      }
      if (bs.jl(paramInt3, 0))
      {
        if (!bs.isNullOrNil(paramString5)) {
          localHashMap.put("address_name", p.encode(paramString5, "UTF-8"));
        }
        if (!bs.isNullOrNil(paramString6)) {
          localHashMap.put("phone_num", p.encode(paramString6, "UTF-8"));
        }
        if (!bs.isNullOrNil(paramString7)) {
          localHashMap.put("address", p.encode(paramString7, "UTF-8"));
        }
      }
    }
  }
  
  public final int getFuncId()
  {
    if ((this.dAs == 32) || (this.dAs == 33)) {
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
    if ((this.dAs == 32) || (this.dAs == 33)) {
      return "/cgi-bin/mmpay-bin/f2fplaceorder";
    }
    return "/cgi-bin/mmpay-bin/transferplaceorder";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67886);
    ac.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + paramInt + " errMsg: " + paramString);
    if ((paramInt != 0) && (paramInt != 2))
    {
      AppMethodBeat.o(67886);
      return;
    }
    boolean bool;
    if (paramJSONObject.has("used_fee"))
    {
      this.wKQ = paramJSONObject.optDouble("used_fee");
      this.djr = paramJSONObject.optString("req_key");
      this.wKG = paramJSONObject.optInt("tansfering_num", 0);
      this.wKI = paramJSONObject.optString("transfer_interrupt_desc");
      this.wKJ = paramJSONObject.optString("appmsgcontent");
      this.wKM = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label893;
      }
      bool = true;
      label145:
      this.wKN = bool;
      this.wKR = paramJSONObject.optString("receiver_true_name");
      this.wKS = paramJSONObject.optString("f2f_id", "");
      this.owt = paramJSONObject.optString("trans_id", "");
      this.oyO = paramJSONObject.optString("extend_str", "");
      this.wKT = paramJSONObject.optString("receiver_open_id", "");
      this.uiK = paramJSONObject.optInt("amount", 0);
      this.dlI = paramJSONObject.optString("transfer_id", "");
      this.dad = paramJSONObject.optString("transaction_id", "");
      this.wKX = paramJSONObject.optString("receiver_openid", "");
      if (bs.isNullOrNil(this.wKR)) {
        ac.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label899;
      }
      this.wKO = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label910;
      }
      this.wKP = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label921;
      }
      this.wKK = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label932;
      }
      this.wKL = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        ac.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).unW = localJSONObject.optString("left_button_wording");
        ((a)localObject).unX = localJSONObject.optString("right_button_wording");
        ((a)localObject).oxl = localJSONObject.optString("right_button_url");
        this.dwa = ((a)localObject);
        this.dwa.dlQ = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.wKV = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        ac.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.wKW = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        ac.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.dlQ = ((JSONObject)localObject).optString("wording");
        paramString.wLi = ((JSONObject)localObject).optString("open_button");
        paramString.wLj = ((JSONObject)localObject).optString("bill_url");
        ac.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { bs.nullAsNil(paramString.dlQ), bs.nullAsNil(paramString.wLi), bs.nullAsNil(paramString.wLj) });
        this.wKH = paramString;
      }
      this.wKY = paramJSONObject.optInt("scan_scene", 0);
      this.wKZ = paramJSONObject.optString("placeorder_suc_sign");
      this.wLa = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.wKJ)) {
        ac.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.wLb = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.wLc = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.wLd = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.wLe = paramJSONObject.optString("show_paying_wording", "");
      this.wLf = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.wLg = paramJSONObject.optInt("need_checkname", 0);
      this.uoa = paramJSONObject.optInt("return_to_session", 0);
      ac.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.uoa) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.wLh = new vp();
        this.wLh.title = paramString.optString("title");
        this.wLh.wNd = paramString.optString("checkname_sign");
        this.wLh.vxw = paramString.optString("display_name");
        this.wLh.dlQ = paramString.optString("wording");
        this.wLh.EpS = paramString.optInt("message_type", 0);
      }
      AppMethodBeat.o(67886);
      return;
      ac.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break;
      label893:
      bool = false;
      break label145;
      label899:
      ac.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
      break label302;
      label910:
      ac.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
      break label323;
      label921:
      ac.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
      break label344;
      label932:
      ac.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
    }
  }
  
  public final boolean shouldResolveJsonWhenError()
  {
    return true;
  }
  
  public static final class a
  {
    public String dlQ;
    public String wLi;
    public String wLj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.w
 * JD-Core Version:    0.7.0.1
 */