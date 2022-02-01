package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ad
  extends m
{
  public Map<String, String> CZR;
  public h DgV;
  public q DgW;
  public r DgX;
  public boolean DgY;
  public String dOi;
  public String dOj;
  public String dOk;
  public String dOl;
  public String dOm;
  public String dOn;
  public int dOo;
  public String dOp;
  public String dOq;
  public String dOr;
  public String dOs;
  public LinkedList<String> dOt;
  public ECardInfo dOu;
  public int scene;
  public String subtitle;
  public String title;
  public Map<String, String> wOp;
  
  public ad()
  {
    this(null, 0);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.dOn = "";
    this.dOo = 0;
    this.dOp = "";
    this.dOq = "";
    this.dOr = "";
    this.dOs = "";
    this.subtitle = "";
    this.title = "";
    this.dOt = new LinkedList();
    this.scene = 0;
    this.DgY = false;
    ae.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.wOp = new HashMap();
    this.scene = paramInt;
    this.wOp.put("req_key", paramString);
    this.wOp.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    this.wOp.put("is_root", "0");
    if (paramString != null)
    {
      this.wOp.put("is_device_open_touch", "1");
      paramString = paramString.cSd();
      if (paramString != null) {
        this.wOp.putAll(paramString);
      }
      ae.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.wOp);
      this.CZR = new HashMap();
      g.ajS();
      paramString = (String)g.ajR().ajA().get(196612, null);
      g.ajS();
      String str = (String)g.ajR().ajA().get(196613, null);
      this.CZR.put("bind_serial", paramString);
      this.CZR.put("last_bind_serial", str);
      setWXRequestData(this.CZR);
      AppMethodBeat.o(69952);
      return;
      this.wOp.put("is_device_open_touch", "0");
      ae.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
    }
  }
  
  public int getFuncId()
  {
    return 1501;
  }
  
  public int getTenpayCgicmd()
  {
    return 72;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    paramString = null;
    AppMethodBeat.i(69953);
    if (paramInt != 0)
    {
      AppMethodBeat.o(69953);
      return;
    }
    Object localObject;
    if (paramJSONObject.has("real_name_info"))
    {
      localObject = paramJSONObject.optJSONObject("real_name_info");
      ECardInfo.bf((JSONObject)localObject);
      ae.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject).toString() });
      this.dOi = ((JSONObject)localObject).optString("guide_flag");
      this.dOj = ((JSONObject)localObject).optString("guide_wording");
      this.dOk = ((JSONObject)localObject).optString("left_button_wording");
      this.dOl = ((JSONObject)localObject).optString("right_button_wording");
      this.dOm = ((JSONObject)localObject).optString("upload_credit_url");
      this.dOn = ((JSONObject)localObject).optString("done_button_wording");
      this.dOo = ((JSONObject)localObject).optInt("is_show_protocol", 0);
      this.dOp = ((JSONObject)localObject).optString("left_protocol_wording");
      this.dOq = ((JSONObject)localObject).optString("new_upload_credit_url");
      this.dOr = ((JSONObject)localObject).optString("protocol_url");
      this.dOs = ((JSONObject)localObject).optString("right_protocol_wording");
      this.subtitle = ((JSONObject)localObject).optString("subtitle");
      this.title = ((JSONObject)localObject).optString("title");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("upload_reasons");
      this.dOt.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.dOt.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject).has("ecard_info"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("ecard_info");
        this.dOu = new ECardInfo();
        this.dOu.title = this.title;
        this.dOu.DnE = new ArrayList(this.dOt);
        this.dOu.DnG = this.dOr;
        this.dOu.DnH = this.dOp;
        this.dOu.DnI = this.dOs;
        this.dOu.DnF = this.dOn;
        this.dOu.obQ = ((JSONObject)localObject).optInt("ecard_open_scene", 0);
        this.dOu.dpa = ((JSONObject)localObject).optString("ecard_type", "");
        this.dOu.Dny = ((JSONObject)localObject).optInt("show_check_box", 0);
        this.dOu.Dnz = ((JSONObject)localObject).optInt("check_box_selected", 0);
        this.dOu.DnA = ((JSONObject)localObject).optString("check_box_left_wording", "");
        this.dOu.DnB = ((JSONObject)localObject).optString("check_box_right_wording", "");
        this.dOu.DnC = ((JSONObject)localObject).optString("check_box_url", "");
        this.dOu.DnD = ((JSONObject)localObject).optInt("is_upload_credid", 0);
        this.dOu.dOm = ((JSONObject)localObject).optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject != null) {
          ac.UH(((JSONArray)localObject).toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label775;
      }
      y.setTimeStamp(String.valueOf(l));
      label576:
      ai.a(paramJSONObject, this.scene, true, this.DgY);
      if ((ai.Wh(this.scene)) || (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject == null) {
          break label786;
        }
        ae.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject).toString() });
        g.ajS();
        g.ajR().ajA().set(am.a.IVw, ((JSONObject)localObject).toString());
      }
      label662:
      localObject = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (localObject == null) {
        break label919;
      }
      ae.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).cSa();
      paramInt = t.eJf().eJN();
      if (paramInt != 0) {
        break label841;
      }
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cRY()) {
        break label807;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mC(t.eJf().eJL());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mD(false);
      label734:
      if (this.scene != 10) {
        break label1040;
      }
      paramJSONObject = paramJSONObject.optJSONObject("action_entry");
      if (paramJSONObject != null) {
        break label930;
      }
      paramString = null;
    }
    for (;;)
    {
      this.DgV = paramString;
      AppMethodBeat.o(69953);
      return;
      ECardInfo.bf(null);
      break;
      label775:
      ae.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label576;
      label786:
      g.ajS();
      g.ajR().ajA().set(am.a.IVw, "");
      break label662;
      label807:
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cSg()) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mD(t.eJf().eJL());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mC(false);
      break label734;
      label841:
      if ((paramInt == 1) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject).cRY()))
      {
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mC(t.eJf().eJL());
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mD(false);
        break label734;
      }
      if ((paramInt != 2) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cSg())) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mD(t.eJf().eJL());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mC(false);
      break label734;
      label919:
      ae.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label734;
      label930:
      paramString = new h();
      paramString.id = paramJSONObject.optString("id");
      paramString.dyI = paramJSONObject.optString("wording");
      paramString.hDr = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.Dnu = paramJSONObject.optString("native_url");
      paramString.prB = paramJSONObject.optString("web_url");
      paramString.Dnv = paramJSONObject.optString("tiny_app_username");
      paramString.Dnw = paramJSONObject.optString("tiny_app_path");
      paramString.CPO = paramJSONObject.optInt("entrance_type");
    }
    label1040:
    if (this.scene == 8)
    {
      if (paramJSONObject.has("block_layer"))
      {
        localObject = paramJSONObject.optJSONObject("block_layer");
        if (localObject != null) {
          break label1128;
        }
      }
      for (;;)
      {
        this.DgW = paramString;
        paramString = paramJSONObject.optJSONObject("disable_block_layer");
        if (paramString == null) {
          break;
        }
        this.DgX = r.bj(paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXp, paramString.toString());
        AppMethodBeat.o(69953);
        return;
        label1128:
        paramString = new q();
        paramString.Dpc = ((JSONObject)localObject).optInt("view_id");
        paramString.Dpd = ((JSONObject)localObject).optInt("is_show_block_layer");
        paramString.Dpe = ((JSONObject)localObject).optInt("waiting_time");
        paramString.Dpf = ((JSONObject)localObject).optString("main_wording");
        paramString.Dpg = ((JSONObject)localObject).optString("reminder_content");
        paramString.Dpi = ((JSONObject)localObject).optString("repayment_tiny_app_path");
        paramString.Dph = ((JSONObject)localObject).optString("repayment_tiny_app_username");
      }
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXp, "");
    }
    AppMethodBeat.o(69953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */