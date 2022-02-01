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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
  public Map<String, String> AJV;
  public Map<String, String> HFF;
  public h HQo;
  public q HQp;
  public r HQq;
  public boolean HQr;
  public String egd;
  public String ege;
  public String egf;
  public String egg;
  public String egh;
  public String egi;
  public int egj;
  public String egk;
  public String egm;
  public String egn;
  public String ego;
  public LinkedList<String> egp;
  public ECardInfo egq;
  public int scene;
  public String subtitle;
  public String title;
  
  public ad()
  {
    this(null, 0);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.egi = "";
    this.egj = 0;
    this.egk = "";
    this.egm = "";
    this.egn = "";
    this.ego = "";
    this.subtitle = "";
    this.title = "";
    this.egp = new LinkedList();
    this.scene = 0;
    this.HQr = false;
    Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.AJV = new HashMap();
    this.scene = paramInt;
    this.AJV.put("req_key", paramString);
    this.AJV.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
    this.AJV.put("is_root", "0");
    if (paramString != null)
    {
      this.AJV.put("is_device_open_touch", "1");
      paramString = paramString.dJY();
      if (paramString != null) {
        this.AJV.putAll(paramString);
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.AJV);
      this.HFF = new HashMap();
      g.aAi();
      paramString = (String)g.aAh().azQ().get(196612, null);
      g.aAi();
      String str = (String)g.aAh().azQ().get(196613, null);
      this.HFF.put("bind_serial", paramString);
      this.HFF.put("last_bind_serial", str);
      setWXRequestData(this.HFF);
      AppMethodBeat.o(69952);
      return;
      this.AJV.put("is_device_open_touch", "0");
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
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
      ECardInfo.bF((JSONObject)localObject);
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject).toString() });
      this.egd = ((JSONObject)localObject).optString("guide_flag");
      this.ege = ((JSONObject)localObject).optString("guide_wording");
      this.egf = ((JSONObject)localObject).optString("left_button_wording");
      this.egg = ((JSONObject)localObject).optString("right_button_wording");
      this.egh = ((JSONObject)localObject).optString("upload_credit_url");
      this.egi = ((JSONObject)localObject).optString("done_button_wording");
      this.egj = ((JSONObject)localObject).optInt("is_show_protocol", 0);
      this.egk = ((JSONObject)localObject).optString("left_protocol_wording");
      this.egm = ((JSONObject)localObject).optString("new_upload_credit_url");
      this.egn = ((JSONObject)localObject).optString("protocol_url");
      this.ego = ((JSONObject)localObject).optString("right_protocol_wording");
      this.subtitle = ((JSONObject)localObject).optString("subtitle");
      this.title = ((JSONObject)localObject).optString("title");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("upload_reasons");
      this.egp.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.egp.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject).has("ecard_info"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("ecard_info");
        this.egq = new ECardInfo();
        this.egq.title = this.title;
        this.egq.HWW = new ArrayList(this.egp);
        this.egq.HWY = this.egn;
        this.egq.HWZ = this.egk;
        this.egq.HXa = this.ego;
        this.egq.HWX = this.egi;
        this.egq.pmM = ((JSONObject)localObject).optInt("ecard_open_scene", 0);
        this.egq.dGp = ((JSONObject)localObject).optString("ecard_type", "");
        this.egq.HWQ = ((JSONObject)localObject).optInt("show_check_box", 0);
        this.egq.HWR = ((JSONObject)localObject).optInt("check_box_selected", 0);
        this.egq.HWS = ((JSONObject)localObject).optString("check_box_left_wording", "");
        this.egq.HWT = ((JSONObject)localObject).optString("check_box_right_wording", "");
        this.egq.HWU = ((JSONObject)localObject).optString("check_box_url", "");
        this.egq.HWV = ((JSONObject)localObject).optInt("is_upload_credid", 0);
        this.egq.egh = ((JSONObject)localObject).optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject != null) {
          ac.aev(((JSONArray)localObject).toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label775;
      }
      y.setTimeStamp(String.valueOf(l));
      label576:
      ai.a(paramJSONObject, this.scene, true, this.HQr);
      if ((ai.aeL(this.scene)) || (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject == null) {
          break label786;
        }
        Log.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject).toString() });
        g.aAi();
        g.aAh().azQ().set(ar.a.OdO, ((JSONObject)localObject).toString());
      }
      label662:
      localObject = (com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (localObject == null) {
        break label919;
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).dJV();
      paramInt = t.fQI().fRq();
      if (paramInt != 0) {
        break label841;
      }
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).dJT()) {
        break label807;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pj(t.fQI().fRo());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pk(false);
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
      this.HQo = paramString;
      AppMethodBeat.o(69953);
      return;
      ECardInfo.bF(null);
      break;
      label775:
      Log.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label576;
      label786:
      g.aAi();
      g.aAh().azQ().set(ar.a.OdO, "");
      break label662;
      label807:
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).dKb()) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pk(t.fQI().fRo());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pj(false);
      break label734;
      label841:
      if ((paramInt == 1) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject).dJT()))
      {
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pj(t.fQI().fRo());
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pk(false);
        break label734;
      }
      if ((paramInt != 2) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).dKb())) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pk(t.fQI().fRo());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).pj(false);
      break label734;
      label919:
      Log.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label734;
      label930:
      paramString = new h();
      paramString.id = paramJSONObject.optString("id");
      paramString.dQx = paramJSONObject.optString("wording");
      paramString.ixw = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.HWM = paramJSONObject.optString("native_url");
      paramString.qHg = paramJSONObject.optString("web_url");
      paramString.HWN = paramJSONObject.optString("tiny_app_username");
      paramString.HWO = paramJSONObject.optString("tiny_app_path");
      paramString.HuF = paramJSONObject.optInt("entrance_type");
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
        this.HQp = paramString;
        paramString = paramJSONObject.optJSONObject("disable_block_layer");
        if (paramString == null) {
          break;
        }
        this.HQq = r.bJ(paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.OfI, paramString.toString());
        AppMethodBeat.o(69953);
        return;
        label1128:
        paramString = new q();
        paramString.HYq = ((JSONObject)localObject).optInt("view_id");
        paramString.HYr = ((JSONObject)localObject).optInt("is_show_block_layer");
        paramString.HYs = ((JSONObject)localObject).optInt("waiting_time");
        paramString.HYt = ((JSONObject)localObject).optString("main_wording");
        paramString.HYu = ((JSONObject)localObject).optString("reminder_content");
        paramString.HYw = ((JSONObject)localObject).optString("repayment_tiny_app_path");
        paramString.HYv = ((JSONObject)localObject).optString("repayment_tiny_app_username");
      }
      ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.OfI, "");
    }
    AppMethodBeat.o(69953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */