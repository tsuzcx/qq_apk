package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
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

public class ae
  extends m
{
  public Map<String, String> ECl;
  public boolean OIA;
  public com.tencent.mm.plugin.wallet_core.model.h OIx;
  public q OIy;
  public r OIz;
  public Map<String, String> Oxy;
  public String gaA;
  public String gaB;
  public String gaC;
  public String gaD;
  public LinkedList<String> gaE;
  public ECardInfo gaF;
  public ArrayList<t> gaO;
  public String gat;
  public String gau;
  public String gav;
  public String gaw;
  public String gax;
  public String gay;
  public int gaz;
  public int scene;
  public String subtitle;
  public String title;
  
  public ae()
  {
    this(null, 0);
  }
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.gay = "";
    this.gaz = 0;
    this.gaA = "";
    this.gaB = "";
    this.gaC = "";
    this.gaD = "";
    this.subtitle = "";
    this.title = "";
    this.gaE = new LinkedList();
    this.scene = 0;
    this.OIA = false;
    Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.ECl = new HashMap();
    this.scene = paramInt;
    this.ECl.put("req_key", paramString);
    this.ECl.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
    this.ECl.put("is_root", "0");
    if (paramString != null)
    {
      this.ECl.put("is_device_open_touch", "1");
      paramString = paramString.eox();
      if (paramString != null) {
        this.ECl.putAll(paramString);
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.ECl);
      this.Oxy = new HashMap();
      com.tencent.mm.kernel.h.aHH();
      paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196612, null);
      com.tencent.mm.kernel.h.aHH();
      String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(196613, null);
      this.Oxy.put("bind_serial", paramString);
      this.Oxy.put("last_bind_serial", str);
      setWXRequestData(this.Oxy);
      AppMethodBeat.o(69952);
      return;
      this.ECl.put("is_device_open_touch", "0");
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
    Object localObject = null;
    JSONObject localJSONObject1 = null;
    AppMethodBeat.i(69953);
    if (paramInt != 0)
    {
      AppMethodBeat.o(69953);
      return;
    }
    label563:
    JSONObject localJSONObject2;
    if (paramJSONObject.has("real_name_info"))
    {
      paramString = paramJSONObject.optJSONObject("real_name_info");
      ECardInfo.bQ(paramString);
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { paramString.toString() });
      this.gat = paramString.optString("guide_flag");
      this.gau = paramString.optString("guide_wording");
      this.gav = paramString.optString("left_button_wording");
      this.gaw = paramString.optString("right_button_wording");
      this.gax = paramString.optString("upload_credit_url");
      this.gay = paramString.optString("done_button_wording");
      this.gaz = paramString.optInt("is_show_protocol", 0);
      this.gaA = paramString.optString("left_protocol_wording");
      this.gaB = paramString.optString("new_upload_credit_url");
      this.gaC = paramString.optString("protocol_url");
      this.gaD = paramString.optString("right_protocol_wording");
      this.subtitle = paramString.optString("subtitle");
      this.title = paramString.optString("title");
      JSONArray localJSONArray = paramString.optJSONArray("upload_reasons");
      this.gaE.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.gaE.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (paramString.has("ecard_info"))
      {
        paramString = paramString.optJSONObject("ecard_info");
        this.gaF = new ECardInfo();
        this.gaF.title = this.title;
        this.gaF.OOW = new ArrayList(this.gaE);
        this.gaF.OOY = this.gaC;
        this.gaF.OOZ = this.gaA;
        this.gaF.OPa = this.gaD;
        this.gaF.OOX = this.gay;
        this.gaF.svv = paramString.optInt("ecard_open_scene", 0);
        this.gaF.fza = paramString.optString("ecard_type", "");
        this.gaF.OOQ = paramString.optInt("show_check_box", 0);
        this.gaF.OOR = paramString.optInt("check_box_selected", 0);
        this.gaF.OOS = paramString.optString("check_box_left_wording", "");
        this.gaF.OOT = paramString.optString("check_box_right_wording", "");
        this.gaF.OOU = paramString.optString("check_box_url", "");
        this.gaF.OOV = paramString.optInt("is_upload_credid", 0);
        this.gaF.gax = paramString.optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        paramString = paramJSONObject.optJSONArray("paymenu_array");
        if (paramString != null) {
          ad.amp(paramString.toString());
        }
      }
      if (!paramJSONObject.has("pay_manage_label")) {
        break label711;
      }
      localJSONArray = paramJSONObject.optJSONArray("pay_manage_label");
      if (localJSONArray == null) {
        break label711;
      }
      this.gaO = new ArrayList();
      paramInt = 0;
      if (paramInt >= localJSONArray.length()) {
        break label711;
      }
      localJSONObject2 = localJSONArray.optJSONObject(paramInt);
      if (localJSONObject2 != null)
      {
        if (localJSONObject2 != null) {
          break label615;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      this.gaO.add(paramString);
      paramInt += 1;
      break label563;
      ECardInfo.bQ(null);
      break;
      label615:
      paramString = new t();
      paramString.title = localJSONObject2.optString("title");
      paramString.desc = localJSONObject2.optString("desc");
      paramString.GtW = localJSONObject2.optString("logo_url");
      paramString.jumpType = localJSONObject2.optInt("jump_type", 0);
      paramString.jumpUrl = localJSONObject2.optString("jump_url");
      paramString.username = localJSONObject2.optString("username");
      paramString.path = localJSONObject2.optString("path");
    }
    label711:
    long l = paramJSONObject.optLong("time_stamp");
    if (l > 0L)
    {
      y.setTimeStamp(String.valueOf(l));
      aj.a(paramJSONObject, this.scene, true, this.OIA);
      if ((aj.amy(this.scene)) || (this.scene == 1))
      {
        paramString = paramJSONObject.optJSONObject("bind_card_menu");
        if (paramString == null) {
          break label929;
        }
        Log.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { paramString.toString() });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrZ, paramString.toString());
      }
      label817:
      paramString = (com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (paramString == null) {
        break label1053;
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      paramString.eou();
      paramInt = u.gJo().gJW();
      if (paramInt != 0) {
        break label981;
      }
      if (!paramString.eos()) {
        break label950;
      }
      paramString.rD(u.gJo().gJU());
      paramString.rE(false);
      label883:
      if (this.scene != 10) {
        break label1174;
      }
      paramJSONObject = paramJSONObject.optJSONObject("action_entry");
      if (paramJSONObject != null) {
        break label1064;
      }
      paramString = localJSONObject1;
    }
    for (;;)
    {
      this.OIx = paramString;
      AppMethodBeat.o(69953);
      return;
      Log.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break;
      label929:
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VrZ, "");
      break label817;
      label950:
      if (!paramString.eoA()) {
        break label883;
      }
      paramString.rE(u.gJo().gJU());
      paramString.rD(false);
      break label883;
      label981:
      if ((paramInt == 1) && (paramString.eos()))
      {
        paramString.rD(u.gJo().gJU());
        paramString.rE(false);
        break label883;
      }
      if ((paramInt != 2) || (!paramString.eoA())) {
        break label883;
      }
      paramString.rE(u.gJo().gJU());
      paramString.rD(false);
      break label883;
      label1053:
      Log.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label883;
      label1064:
      paramString = new com.tencent.mm.plugin.wallet_core.model.h();
      paramString.id = paramJSONObject.optString("id");
      paramString.wording = paramJSONObject.optString("wording");
      paramString.lmL = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.OOM = paramJSONObject.optString("native_url");
      paramString.ugh = paramJSONObject.optString("web_url");
      paramString.OON = paramJSONObject.optString("tiny_app_username");
      paramString.OOO = paramJSONObject.optString("tiny_app_path");
      paramString.Oms = paramJSONObject.optInt("entrance_type");
    }
    label1174:
    if (this.scene == 8)
    {
      if (paramJSONObject.has("block_layer"))
      {
        localJSONObject1 = paramJSONObject.optJSONObject("block_layer");
        if (localJSONObject1 != null) {
          break label1265;
        }
        paramString = localObject;
      }
      for (;;)
      {
        this.OIy = paramString;
        paramString = paramJSONObject.optJSONObject("disable_block_layer");
        if (paramString == null) {
          break;
        }
        this.OIz = r.bU(paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VtW, paramString.toString());
        AppMethodBeat.o(69953);
        return;
        label1265:
        paramString = new q();
        paramString.OQq = localJSONObject1.optInt("view_id");
        paramString.OQr = localJSONObject1.optInt("is_show_block_layer");
        paramString.OQs = localJSONObject1.optInt("waiting_time");
        paramString.OQt = localJSONObject1.optString("main_wording");
        paramString.OQu = localJSONObject1.optString("reminder_content");
        paramString.OQw = localJSONObject1.optString("repayment_tiny_app_path");
        paramString.OQv = localJSONObject1.optString("repayment_tiny_app_username");
      }
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.VtW, "");
    }
    AppMethodBeat.o(69953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */