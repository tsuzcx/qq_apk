package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.storage.ae.a;
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
  public String dCT;
  public String dCU;
  public String dCV;
  public String dCW;
  public String dCX;
  public String dCY;
  public int dCZ;
  public String dDa;
  public String dDb;
  public String dDc;
  public String dDd;
  public LinkedList<String> dDe;
  public ECardInfo dDf;
  public int scene;
  public String subtitle;
  public String title;
  public Map<String, String> ukq;
  public Map<String, String> zPD;
  public h zWI;
  public q zWJ;
  public boolean zWK;
  
  public ad()
  {
    this(null, 0);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.dCY = "";
    this.dCZ = 0;
    this.dDa = "";
    this.dDb = "";
    this.dDc = "";
    this.dDd = "";
    this.subtitle = "";
    this.title = "";
    this.dDe = new LinkedList();
    this.scene = 0;
    this.zWK = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.ukq = new HashMap();
    this.scene = paramInt;
    this.ukq.put("req_key", paramString);
    this.ukq.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (a)g.ab(a.class);
    this.ukq.put("is_root", "0");
    if (paramString != null)
    {
      this.ukq.put("is_device_open_touch", "1");
      paramString = paramString.ctX();
      if (paramString != null) {
        this.ukq.putAll(paramString);
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.ukq);
      this.zPD = new HashMap();
      g.afC();
      paramString = (String)g.afB().afk().get(196612, null);
      g.afC();
      String str = (String)g.afB().afk().get(196613, null);
      this.zPD.put("bind_serial", paramString);
      this.zPD.put("last_bind_serial", str);
      setWXRequestData(this.zPD);
      AppMethodBeat.o(69952);
      return;
      this.ukq.put("is_device_open_touch", "0");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
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
      ECardInfo.aW((JSONObject)localObject);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject).toString() });
      this.dCT = ((JSONObject)localObject).optString("guide_flag");
      this.dCU = ((JSONObject)localObject).optString("guide_wording");
      this.dCV = ((JSONObject)localObject).optString("left_button_wording");
      this.dCW = ((JSONObject)localObject).optString("right_button_wording");
      this.dCX = ((JSONObject)localObject).optString("upload_credit_url");
      this.dCY = ((JSONObject)localObject).optString("done_button_wording");
      this.dCZ = ((JSONObject)localObject).optInt("is_show_protocol", 0);
      this.dDa = ((JSONObject)localObject).optString("left_protocol_wording");
      this.dDb = ((JSONObject)localObject).optString("new_upload_credit_url");
      this.dDc = ((JSONObject)localObject).optString("protocol_url");
      this.dDd = ((JSONObject)localObject).optString("right_protocol_wording");
      this.subtitle = ((JSONObject)localObject).optString("subtitle");
      this.title = ((JSONObject)localObject).optString("title");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("upload_reasons");
      this.dDe.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.dDe.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject).has("ecard_info"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("ecard_info");
        this.dDf = new ECardInfo();
        this.dDf.title = this.title;
        this.dDf.Adp = new ArrayList(this.dDe);
        this.dDf.Adr = this.dDc;
        this.dDf.Ads = this.dDa;
        this.dDf.Adt = this.dDd;
        this.dDf.Adq = this.dCY;
        this.dDf.mSu = ((JSONObject)localObject).optInt("ecard_open_scene", 0);
        this.dDf.dfe = ((JSONObject)localObject).optString("ecard_type", "");
        this.dDf.Adj = ((JSONObject)localObject).optInt("show_check_box", 0);
        this.dDf.Adk = ((JSONObject)localObject).optInt("check_box_selected", 0);
        this.dDf.Adl = ((JSONObject)localObject).optString("check_box_left_wording", "");
        this.dDf.Adm = ((JSONObject)localObject).optString("check_box_right_wording", "");
        this.dDf.Adn = ((JSONObject)localObject).optString("check_box_url", "");
        this.dDf.Ado = ((JSONObject)localObject).optInt("is_upload_credid", 0);
        this.dDf.dCX = ((JSONObject)localObject).optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject != null) {
          com.tencent.mm.plugin.wallet_core.model.ab.Ml(((JSONArray)localObject).toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label774;
      }
      y.setTimeStamp(String.valueOf(l));
      label575:
      ah.a(paramJSONObject, this.scene, true, this.zWK);
      if ((ah.Rz(this.scene)) || (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject == null) {
          break label785;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject).toString() });
        g.afC();
        g.afB().afk().set(ae.a.FqM, ((JSONObject)localObject).toString());
      }
      label661:
      localObject = (a)g.ab(a.class);
      if (localObject == null) {
        break label918;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((a)localObject).ctU();
      paramInt = s.ecc().ecL();
      if (paramInt != 0) {
        break label840;
      }
      if (!((a)localObject).ctS()) {
        break label806;
      }
      ((a)localObject).lp(s.ecc().ecJ());
      ((a)localObject).lq(false);
      label733:
      if (this.scene != 10) {
        break label1039;
      }
      paramJSONObject = paramJSONObject.optJSONObject("action_entry");
      if (paramJSONObject != null) {
        break label929;
      }
      paramString = null;
    }
    for (;;)
    {
      this.zWI = paramString;
      AppMethodBeat.o(69953);
      return;
      ECardInfo.aW(null);
      break;
      label774:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label575;
      label785:
      g.afC();
      g.afB().afk().set(ae.a.FqM, "");
      break label661;
      label806:
      if (!((a)localObject).cua()) {
        break label733;
      }
      ((a)localObject).lq(s.ecc().ecJ());
      ((a)localObject).lp(false);
      break label733;
      label840:
      if ((paramInt == 1) && (((a)localObject).ctS()))
      {
        ((a)localObject).lp(s.ecc().ecJ());
        ((a)localObject).lq(false);
        break label733;
      }
      if ((paramInt != 2) || (!((a)localObject).cua())) {
        break label733;
      }
      ((a)localObject).lq(s.ecc().ecJ());
      ((a)localObject).lp(false);
      break label733;
      label918:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label733;
      label929:
      paramString = new h();
      paramString.id = paramJSONObject.optString("id");
      paramString.doh = paramJSONObject.optString("wording");
      paramString.gHT = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.Adf = paramJSONObject.optString("native_url");
      paramString.odT = paramJSONObject.optString("web_url");
      paramString.Adg = paramJSONObject.optString("tiny_app_username");
      paramString.Adh = paramJSONObject.optString("tiny_app_path");
      paramString.zFN = paramJSONObject.optInt("entrance_type");
    }
    label1039:
    if ((this.scene == 8) && (paramJSONObject.has("block_layer")))
    {
      paramJSONObject = paramJSONObject.optJSONObject("block_layer");
      if (paramJSONObject != null) {
        break label1081;
      }
    }
    for (;;)
    {
      this.zWJ = paramString;
      AppMethodBeat.o(69953);
      return;
      label1081:
      paramString = new q();
      paramString.AeN = paramJSONObject.optInt("view_id");
      paramString.AeO = paramJSONObject.optInt("is_show_block_layer");
      paramString.AeP = paramJSONObject.optInt("waiting_time");
      paramString.AeQ = paramJSONObject.optString("main_wording");
      paramString.AeR = paramJSONObject.optString("reminder_content");
      paramString.AeT = paramJSONObject.optString("repayment_tiny_app_path");
      paramString.AeS = paramJSONObject.optString("repayment_tiny_app_username");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */