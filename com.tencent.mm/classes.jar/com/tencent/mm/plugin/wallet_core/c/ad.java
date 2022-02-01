package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public Map<String, String> BhX;
  public h Bpc;
  public q Bpd;
  public boolean Bpe;
  public String dAF;
  public String dAG;
  public String dAH;
  public String dAI;
  public String dAJ;
  public String dAK;
  public int dAL;
  public String dAM;
  public String dAN;
  public String dAO;
  public String dAP;
  public LinkedList<String> dAQ;
  public ECardInfo dAR;
  public int scene;
  public String subtitle;
  public String title;
  public Map<String, String> vtm;
  
  public ad()
  {
    this(null, 0);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.dAK = "";
    this.dAL = 0;
    this.dAM = "";
    this.dAN = "";
    this.dAO = "";
    this.dAP = "";
    this.subtitle = "";
    this.title = "";
    this.dAQ = new LinkedList();
    this.scene = 0;
    this.Bpe = false;
    ac.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.vtm = new HashMap();
    this.scene = paramInt;
    this.vtm.put("req_key", paramString);
    this.vtm.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (a)g.ab(a.class);
    this.vtm.put("is_root", "0");
    if (paramString != null)
    {
      this.vtm.put("is_device_open_touch", "1");
      paramString = paramString.cHj();
      if (paramString != null) {
        this.vtm.putAll(paramString);
      }
      ac.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.vtm);
      this.BhX = new HashMap();
      g.agS();
      paramString = (String)g.agR().agA().get(196612, null);
      g.agS();
      String str = (String)g.agR().agA().get(196613, null);
      this.BhX.put("bind_serial", paramString);
      this.BhX.put("last_bind_serial", str);
      setWXRequestData(this.BhX);
      AppMethodBeat.o(69952);
      return;
      this.vtm.put("is_device_open_touch", "0");
      ac.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
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
      ECardInfo.aX((JSONObject)localObject);
      ac.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject).toString() });
      this.dAF = ((JSONObject)localObject).optString("guide_flag");
      this.dAG = ((JSONObject)localObject).optString("guide_wording");
      this.dAH = ((JSONObject)localObject).optString("left_button_wording");
      this.dAI = ((JSONObject)localObject).optString("right_button_wording");
      this.dAJ = ((JSONObject)localObject).optString("upload_credit_url");
      this.dAK = ((JSONObject)localObject).optString("done_button_wording");
      this.dAL = ((JSONObject)localObject).optInt("is_show_protocol", 0);
      this.dAM = ((JSONObject)localObject).optString("left_protocol_wording");
      this.dAN = ((JSONObject)localObject).optString("new_upload_credit_url");
      this.dAO = ((JSONObject)localObject).optString("protocol_url");
      this.dAP = ((JSONObject)localObject).optString("right_protocol_wording");
      this.subtitle = ((JSONObject)localObject).optString("subtitle");
      this.title = ((JSONObject)localObject).optString("title");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("upload_reasons");
      this.dAQ.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.dAQ.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject).has("ecard_info"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("ecard_info");
        this.dAR = new ECardInfo();
        this.dAR.title = this.title;
        this.dAR.BvJ = new ArrayList(this.dAQ);
        this.dAR.BvL = this.dAO;
        this.dAR.BvM = this.dAM;
        this.dAR.BvN = this.dAP;
        this.dAR.BvK = this.dAK;
        this.dAR.nuJ = ((JSONObject)localObject).optInt("ecard_open_scene", 0);
        this.dAR.dcz = ((JSONObject)localObject).optString("ecard_type", "");
        this.dAR.BvD = ((JSONObject)localObject).optInt("show_check_box", 0);
        this.dAR.BvE = ((JSONObject)localObject).optInt("check_box_selected", 0);
        this.dAR.BvF = ((JSONObject)localObject).optString("check_box_left_wording", "");
        this.dAR.BvG = ((JSONObject)localObject).optString("check_box_right_wording", "");
        this.dAR.BvH = ((JSONObject)localObject).optString("check_box_url", "");
        this.dAR.BvI = ((JSONObject)localObject).optInt("is_upload_credid", 0);
        this.dAR.dAJ = ((JSONObject)localObject).optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject != null) {
          ab.Qs(((JSONArray)localObject).toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label774;
      }
      y.setTimeStamp(String.valueOf(l));
      label575:
      ah.a(paramJSONObject, this.scene, true, this.Bpe);
      if ((ah.TI(this.scene)) || (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject == null) {
          break label785;
        }
        ac.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject).toString() });
        g.agS();
        g.agR().agA().set(ah.a.GOC, ((JSONObject)localObject).toString());
      }
      label661:
      localObject = (a)g.ab(a.class);
      if (localObject == null) {
        break label918;
      }
      ac.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((a)localObject).cHg();
      paramInt = s.ery().esg();
      if (paramInt != 0) {
        break label840;
      }
      if (!((a)localObject).cHe()) {
        break label806;
      }
      ((a)localObject).mh(s.ery().ese());
      ((a)localObject).mi(false);
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
      this.Bpc = paramString;
      AppMethodBeat.o(69953);
      return;
      ECardInfo.aX(null);
      break;
      label774:
      ac.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label575;
      label785:
      g.agS();
      g.agR().agA().set(ah.a.GOC, "");
      break label661;
      label806:
      if (!((a)localObject).cHm()) {
        break label733;
      }
      ((a)localObject).mi(s.ery().ese());
      ((a)localObject).mh(false);
      break label733;
      label840:
      if ((paramInt == 1) && (((a)localObject).cHe()))
      {
        ((a)localObject).mh(s.ery().ese());
        ((a)localObject).mi(false);
        break label733;
      }
      if ((paramInt != 2) || (!((a)localObject).cHm())) {
        break label733;
      }
      ((a)localObject).mi(s.ery().ese());
      ((a)localObject).mh(false);
      break label733;
      label918:
      ac.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label733;
      label929:
      paramString = new h();
      paramString.id = paramJSONObject.optString("id");
      paramString.dlQ = paramJSONObject.optString("wording");
      paramString.hiu = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.Bvz = paramJSONObject.optString("native_url");
      paramString.oHs = paramJSONObject.optString("web_url");
      paramString.BvA = paramJSONObject.optString("tiny_app_username");
      paramString.BvB = paramJSONObject.optString("tiny_app_path");
      paramString.AYa = paramJSONObject.optInt("entrance_type");
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
      this.Bpd = paramString;
      AppMethodBeat.o(69953);
      return;
      label1081:
      paramString = new q();
      paramString.Bxh = paramJSONObject.optInt("view_id");
      paramString.Bxi = paramJSONObject.optInt("is_show_block_layer");
      paramString.Bxj = paramJSONObject.optInt("waiting_time");
      paramString.Bxk = paramJSONObject.optString("main_wording");
      paramString.Bxl = paramJSONObject.optString("reminder_content");
      paramString.Bxn = paramJSONObject.optString("repayment_tiny_app_path");
      paramString.Bxm = paramJSONObject.optString("repayment_tiny_app_username");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */