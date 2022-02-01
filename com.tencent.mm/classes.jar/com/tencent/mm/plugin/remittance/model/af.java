package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hd;
import com.tencent.mm.autogen.a.hd.a;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.wallet_core.model.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af
  extends m
  implements j
{
  public int KuR;
  public String OiB;
  public hd OiC;
  public String OiN;
  public long Oif;
  public int OjB;
  public a OjC;
  public String OjD;
  public String OjE;
  public double OjF;
  public double OjG;
  public String OjH;
  public boolean OjI;
  public double OjJ;
  public double OjK;
  public double OjL;
  public String OjM;
  public String OjN;
  public double OjO;
  public String OjP;
  public String OjQ;
  public String OjR;
  public int OjS;
  public String OjT;
  public String OjU;
  public int OjV;
  public String OjW;
  public String OjX;
  public String OjY;
  public String OjZ;
  public String Ojy;
  public int Oka;
  public abe Okb;
  public int amount;
  public String hAU;
  public String hMy;
  public String hPj;
  public a iaV;
  private int igp;
  public String username;
  public String wXY;
  public String xas;
  
  public af(double paramDouble, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt3, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, hd paramhd, String paramString13, String paramString14, String paramString15, String paramString16, int paramInt4, String paramString17, int paramInt5, String paramString18)
  {
    AppMethodBeat.i(288805);
    this.hMy = null;
    this.OjB = 0;
    this.OjO = 0.0D;
    this.OjP = "";
    this.OjQ = "";
    this.OiB = "";
    this.OiC = null;
    this.Oka = 0;
    this.username = "";
    Log.i("Micromsg.NetSceneTenpayRemittanceGen", "payScene: %s, channel: %s dynamicCodeUrl: %s mch_name: %s nickname: %s receiver_true_name %s placeorder_reserves: %s unpayType: %s cancel_outtradeno:%s cancel_reason:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString9, paramString10, paramString11, paramString12, paramString16, String.valueOf(paramInt4), paramString17, Integer.valueOf(paramInt5) });
    this.OjO = paramDouble;
    this.igp = paramInt1;
    this.username = paramString2;
    this.OiB = paramString9;
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
    if ((paramhd != null) && (paramhd.hHR.hHT == 1))
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
      this.OiC = paramhd;
    }
    for (;;)
    {
      try
      {
        if ((this.igp != 33) && (this.igp != 32)) {
          continue;
        }
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "f2f desc: %s, recvDesc: %s", new Object[] { paramString4, paramString6 });
        if (!Util.isNullOrNil(paramString4)) {
          localHashMap.put("f2f_payer_desc", r.as(paramString4, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString6)) {
          localHashMap.put("desc", r.as(paramString6, "UTF-8"));
        }
        if (!Util.isNullOrNil(paramString9)) {
          localHashMap.put("dynamic_code_url", r.as(paramString9, "UTF-8"));
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
        h.baF();
        l = ((Long)h.baE().ban().d(147457, Long.valueOf(0L))).longValue();
        paramInt1 = 0;
        if ((0x10 & l) == 0L) {
          continue;
        }
        paramInt1 = 2;
        localHashMap.put("delay_confirm_flag", String.valueOf(paramInt1));
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "delay flag: %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      setRequestData(localHashMap);
      if ((this.igp == 32) || (this.igp == 33))
      {
        paramString1 = new HashMap();
        paramString1.put("channel", String.valueOf(paramInt3));
        setWXRequestData(paramString1);
      }
      AppMethodBeat.o(288805);
      return;
      paramString1 = "0";
      break;
      if (!Util.isNullOrNil(paramString4)) {
        localHashMap.put("desc", r.as(paramString4, "UTF-8"));
      }
      localHashMap.put("desc_has_address", String.valueOf(lw(paramString4, paramString5)));
    }
  }
  
  private static int lw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(288809);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(288809);
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
          AppMethodBeat.o(288809);
          return 1;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(288809);
    return 0;
  }
  
  public final int getFuncId()
  {
    if ((this.igp == 32) || (this.igp == 33)) {
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
    if ((this.igp == 32) || (this.igp == 33)) {
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
      this.OjL = paramJSONObject.optDouble("used_fee");
      this.hMy = paramJSONObject.optString("req_key");
      this.OjB = paramJSONObject.optInt("tansfering_num", 0);
      this.OjD = paramJSONObject.optString("transfer_interrupt_desc");
      this.OjE = paramJSONObject.optString("appmsgcontent");
      this.OjH = paramJSONObject.optString("transfer_interrupt_charge_desc");
      if (paramJSONObject.optInt("is_show_charge") != 1) {
        break label930;
      }
      bool = true;
      label145:
      this.OjI = bool;
      this.OiN = paramJSONObject.optString("receiver_true_name");
      this.OjM = paramJSONObject.optString("f2f_id", "");
      this.wXY = paramJSONObject.optString("trans_id", "");
      this.xas = paramJSONObject.optString("extend_str", "");
      this.OjN = paramJSONObject.optString("receiver_open_id", "");
      this.amount = paramJSONObject.optInt("amount", 0);
      this.hPj = paramJSONObject.optString("transfer_id", "");
      this.hAU = paramJSONObject.optString("transaction_id", "");
      this.OjR = paramJSONObject.optString("receiver_openid", "");
      if (Util.isNullOrNil(this.OiN)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
      }
      if (!paramJSONObject.has("remain_fee")) {
        break label936;
      }
      this.OjJ = paramJSONObject.optDouble("remain_fee");
      label302:
      if (!paramJSONObject.has("exceed_fee")) {
        break label947;
      }
      this.OjK = paramJSONObject.optDouble("exceed_fee");
      label323:
      if (!paramJSONObject.has("charge_fee")) {
        break label958;
      }
      this.OjF = paramJSONObject.optDouble("charge_fee");
      label344:
      if (!paramJSONObject.has("free_limit")) {
        break label969;
      }
      this.OjG = paramJSONObject.optDouble("free_limit");
    }
    for (;;)
    {
      Object localObject;
      if (paramJSONObject.has("showmessage"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
        localObject = new a();
        JSONObject localJSONObject = paramJSONObject.optJSONObject("showmessage");
        ((a)localObject).rGU = localJSONObject.optString("left_button_wording");
        ((a)localObject).right_button_wording = localJSONObject.optString("right_button_wording");
        ((a)localObject).wYO = localJSONObject.optString("right_button_url");
        this.iaV = ((a)localObject);
        this.iaV.wording = paramString;
      }
      if (paramJSONObject.has("fee")) {
        this.OjP = paramJSONObject.optString("fee");
      }
      if (paramJSONObject.has("double_check_wording"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
        this.OjQ = paramJSONObject.optString("double_check_wording");
      }
      if (paramJSONObject.has("zaitu_message"))
      {
        Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
        paramString = new a();
        localObject = paramJSONObject.optJSONObject("zaitu_message");
        paramString.wording = ((JSONObject)localObject).optString("wording");
        paramString.Okc = ((JSONObject)localObject).optString("open_button");
        paramString.Okd = ((JSONObject)localObject).optString("bill_url");
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", new Object[] { Util.nullAsNil(paramString.wording), Util.nullAsNil(paramString.Okc), Util.nullAsNil(paramString.Okd) });
        this.OjC = paramString;
      }
      this.OjS = paramJSONObject.optInt("scan_scene", 0);
      this.OjT = paramJSONObject.optString("placeorder_suc_sign");
      this.OjU = paramJSONObject.optString("pay_suc_extend");
      if (TextUtils.isEmpty(this.OjE)) {
        Log.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
      }
      this.OjV = paramJSONObject.optInt("get_dynamic_code_flag", 0);
      this.OjW = paramJSONObject.optString("get_dynamic_code_sign", "");
      this.OjX = paramJSONObject.optString("get_dynamic_code_extend", "");
      this.OjY = paramJSONObject.optString("show_paying_wording", "");
      this.OjZ = paramJSONObject.optString("dynamic_code_spam_wording", "");
      this.Oka = paramJSONObject.optInt("need_checkname", 0);
      this.KuR = paramJSONObject.optInt("return_to_session", 0);
      Log.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", new Object[] { Integer.valueOf(this.KuR) });
      paramString = paramJSONObject.optJSONObject("namemessage");
      if (paramString != null)
      {
        this.Okb = new abe();
        this.Okb.title = paramString.optString("title");
        this.Okb.Omk = paramString.optString("checkname_sign");
        this.Okb.MEz = paramString.optString("display_name");
        this.Okb.wording = paramString.optString("wording");
        this.Okb.ZjH = paramString.optInt("message_type", 0);
      }
      paramString = paramJSONObject.optJSONObject("msg_check_info");
      if (paramString != null)
      {
        this.Oif = paramString.optLong("msg_check_sec", 0L);
        this.Ojy = paramString.optString("msg_check_str", "");
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
    public String Okc;
    public String Okd;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.af
 * JD-Core Version:    0.7.0.1
 */