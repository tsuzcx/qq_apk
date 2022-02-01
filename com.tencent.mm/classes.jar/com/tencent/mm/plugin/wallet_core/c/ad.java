package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.storage.al.a;
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
  public Map<String, String> CIl;
  public h CPr;
  public q CPs;
  public r CPt;
  public boolean CPu;
  public String dMS;
  public String dMT;
  public String dMU;
  public String dMV;
  public String dMW;
  public String dMX;
  public int dMY;
  public String dMZ;
  public String dNa;
  public String dNb;
  public String dNc;
  public LinkedList<String> dNd;
  public ECardInfo dNe;
  public int scene;
  public String subtitle;
  public String title;
  public Map<String, String> wyE;
  
  public ad()
  {
    this(null, 0);
  }
  
  public ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.dMX = "";
    this.dMY = 0;
    this.dMZ = "";
    this.dNa = "";
    this.dNb = "";
    this.dNc = "";
    this.subtitle = "";
    this.title = "";
    this.dNd = new LinkedList();
    this.scene = 0;
    this.CPu = false;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.wyE = new HashMap();
    this.scene = paramInt;
    this.wyE.put("req_key", paramString);
    this.wyE.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    this.wyE.put("is_root", "0");
    if (paramString != null)
    {
      this.wyE.put("is_device_open_touch", "1");
      paramString = paramString.cPy();
      if (paramString != null) {
        this.wyE.putAll(paramString);
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.wyE);
      this.CIl = new HashMap();
      g.ajD();
      paramString = (String)g.ajC().ajl().get(196612, null);
      g.ajD();
      String str = (String)g.ajC().ajl().get(196613, null);
      this.CIl.put("bind_serial", paramString);
      this.CIl.put("last_bind_serial", str);
      setWXRequestData(this.CIl);
      AppMethodBeat.o(69952);
      return;
      this.wyE.put("is_device_open_touch", "0");
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
      ECardInfo.bf((JSONObject)localObject);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject).toString() });
      this.dMS = ((JSONObject)localObject).optString("guide_flag");
      this.dMT = ((JSONObject)localObject).optString("guide_wording");
      this.dMU = ((JSONObject)localObject).optString("left_button_wording");
      this.dMV = ((JSONObject)localObject).optString("right_button_wording");
      this.dMW = ((JSONObject)localObject).optString("upload_credit_url");
      this.dMX = ((JSONObject)localObject).optString("done_button_wording");
      this.dMY = ((JSONObject)localObject).optInt("is_show_protocol", 0);
      this.dMZ = ((JSONObject)localObject).optString("left_protocol_wording");
      this.dNa = ((JSONObject)localObject).optString("new_upload_credit_url");
      this.dNb = ((JSONObject)localObject).optString("protocol_url");
      this.dNc = ((JSONObject)localObject).optString("right_protocol_wording");
      this.subtitle = ((JSONObject)localObject).optString("subtitle");
      this.title = ((JSONObject)localObject).optString("title");
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("upload_reasons");
      this.dNd.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.dNd.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject).has("ecard_info"))
      {
        localObject = ((JSONObject)localObject).optJSONObject("ecard_info");
        this.dNe = new ECardInfo();
        this.dNe.title = this.title;
        this.dNe.CVZ = new ArrayList(this.dNd);
        this.dNe.CWb = this.dNb;
        this.dNe.CWc = this.dMZ;
        this.dNe.CWd = this.dNc;
        this.dNe.CWa = this.dMX;
        this.dNe.nWh = ((JSONObject)localObject).optInt("ecard_open_scene", 0);
        this.dNe.dnV = ((JSONObject)localObject).optString("ecard_type", "");
        this.dNe.CVS = ((JSONObject)localObject).optInt("show_check_box", 0);
        this.dNe.CVT = ((JSONObject)localObject).optInt("check_box_selected", 0);
        this.dNe.CVU = ((JSONObject)localObject).optString("check_box_left_wording", "");
        this.dNe.CVW = ((JSONObject)localObject).optString("check_box_right_wording", "");
        this.dNe.CVX = ((JSONObject)localObject).optString("check_box_url", "");
        this.dNe.CVY = ((JSONObject)localObject).optInt("is_upload_credid", 0);
        this.dNe.dMW = ((JSONObject)localObject).optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject != null) {
          ac.TX(((JSONArray)localObject).toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label775;
      }
      y.setTimeStamp(String.valueOf(l));
      label576:
      com.tencent.mm.plugin.wallet_core.model.ai.a(paramJSONObject, this.scene, true, this.CPu);
      if ((com.tencent.mm.plugin.wallet_core.model.ai.VA(this.scene)) || (this.scene == 1))
      {
        localObject = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject == null) {
          break label786;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject).toString() });
        g.ajD();
        g.ajC().ajl().set(al.a.IAX, ((JSONObject)localObject).toString());
      }
      label662:
      localObject = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
      if (localObject == null) {
        break label919;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPv();
      paramInt = t.eFy().eGg();
      if (paramInt != 0) {
        break label841;
      }
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPt()) {
        break label807;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).my(t.eFy().eGe());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mz(false);
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
      this.CPr = paramString;
      AppMethodBeat.o(69953);
      return;
      ECardInfo.bf(null);
      break;
      label775:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label576;
      label786:
      g.ajD();
      g.ajC().ajl().set(al.a.IAX, "");
      break label662;
      label807:
      if (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPB()) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mz(t.eFy().eGe());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).my(false);
      break label734;
      label841:
      if ((paramInt == 1) && (((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPt()))
      {
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).my(t.eFy().eGe());
        ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mz(false);
        break label734;
      }
      if ((paramInt != 2) || (!((com.tencent.mm.plugin.fingerprint.d.a)localObject).cPB())) {
        break label734;
      }
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).mz(t.eFy().eGe());
      ((com.tencent.mm.plugin.fingerprint.d.a)localObject).my(false);
      break label734;
      label919:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label734;
      label930:
      paramString = new h();
      paramString.id = paramJSONObject.optString("id");
      paramString.dxD = paramJSONObject.optString("wording");
      paramString.hAD = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.CVO = paramJSONObject.optString("native_url");
      paramString.pkW = paramJSONObject.optString("web_url");
      paramString.CVP = paramJSONObject.optString("tiny_app_username");
      paramString.CVQ = paramJSONObject.optString("tiny_app_path");
      paramString.Cyj = paramJSONObject.optInt("entrance_type");
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
        this.CPs = paramString;
        paramString = paramJSONObject.optJSONObject("disable_block_layer");
        if (paramString == null) {
          break;
        }
        this.CPt = r.bj(paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(al.a.ICP, paramString.toString());
        AppMethodBeat.o(69953);
        return;
        label1128:
        paramString = new q();
        paramString.CXx = ((JSONObject)localObject).optInt("view_id");
        paramString.CXy = ((JSONObject)localObject).optInt("is_show_block_layer");
        paramString.CXz = ((JSONObject)localObject).optInt("waiting_time");
        paramString.CXA = ((JSONObject)localObject).optString("main_wording");
        paramString.CXB = ((JSONObject)localObject).optString("reminder_content");
        paramString.CXD = ((JSONObject)localObject).optString("repayment_tiny_app_path");
        paramString.CXC = ((JSONObject)localObject).optString("repayment_tiny_app_username");
      }
      ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(al.a.ICP, "");
    }
    AppMethodBeat.o(69953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ad
 * JD-Core Version:    0.7.0.1
 */