package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.y;
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
  public Map<String, String> Kvm;
  public Map<String, String> VmJ;
  public com.tencent.mm.plugin.wallet_core.model.h Vyj;
  public q Vyk;
  public r Vyl;
  public boolean Vym;
  public String igC;
  public String igD;
  public String igE;
  public String igF;
  public String igG;
  public String igH;
  public int igI;
  public String igJ;
  public String igK;
  public String igL;
  public String igM;
  public String igN;
  public LinkedList<String> igO;
  public ECardInfo igP;
  public ArrayList<t> igY;
  public int scene;
  public String title;
  
  public ae()
  {
    this(null, 0);
  }
  
  public ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(69952);
    this.igH = "";
    this.igI = 0;
    this.igJ = "";
    this.igK = "";
    this.igL = "";
    this.igM = "";
    this.igN = "";
    this.title = "";
    this.igO = new LinkedList();
    this.scene = 0;
    this.Vym = false;
    Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "NetSceneTenpayQueryBoundBankcard scene:%s", new Object[] { Integer.valueOf(paramInt) });
    this.Kvm = new HashMap();
    this.scene = paramInt;
    this.Kvm.put("req_key", paramString);
    this.Kvm.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
    if ((paramString != null) && (paramString.isRoot()))
    {
      this.Kvm.put("is_root", "1");
      if (paramString == null) {
        break label338;
      }
      this.Kvm.put("is_device_open_touch", "1");
      paramString = paramString.ftA();
      if (paramString != null) {
        this.Kvm.putAll(paramString);
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.Kvm);
      this.VmJ = new HashMap();
      com.tencent.mm.kernel.h.baF();
      paramString = (String)com.tencent.mm.kernel.h.baE().ban().d(196612, null);
      com.tencent.mm.kernel.h.baF();
      String str = (String)com.tencent.mm.kernel.h.baE().ban().d(196613, null);
      this.VmJ.put("bind_serial", paramString);
      this.VmJ.put("last_bind_serial", str);
      setWXRequestData(this.VmJ);
      AppMethodBeat.o(69952);
      return;
      this.Kvm.put("is_root", "0");
      break;
      label338:
      this.Kvm.put("is_device_open_touch", "0");
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
    Object localObject1;
    Object localObject2;
    if (paramJSONObject.has("real_name_info"))
    {
      localObject1 = paramJSONObject.optJSONObject("real_name_info");
      ECardInfo.cl((JSONObject)localObject1);
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { ((JSONObject)localObject1).toString() });
      this.igC = ((JSONObject)localObject1).optString("guide_flag");
      this.igD = ((JSONObject)localObject1).optString("guide_wording");
      this.igE = ((JSONObject)localObject1).optString("left_button_wording");
      this.igF = ((JSONObject)localObject1).optString("right_button_wording");
      this.igG = ((JSONObject)localObject1).optString("upload_credit_url");
      this.igH = ((JSONObject)localObject1).optString("done_button_wording");
      this.igI = ((JSONObject)localObject1).optInt("is_show_protocol", 0);
      this.igJ = ((JSONObject)localObject1).optString("left_protocol_wording");
      this.igK = ((JSONObject)localObject1).optString("new_upload_credit_url");
      this.igL = ((JSONObject)localObject1).optString("protocol_url");
      this.igM = ((JSONObject)localObject1).optString("right_protocol_wording");
      this.igN = ((JSONObject)localObject1).optString("subtitle");
      this.title = ((JSONObject)localObject1).optString("title");
      localObject2 = ((JSONObject)localObject1).optJSONArray("upload_reasons");
      this.igO.clear();
      if (localObject2 != null)
      {
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject2).length())
        {
          this.igO.add(((JSONArray)localObject2).optString(paramInt));
          paramInt += 1;
        }
      }
      if (((JSONObject)localObject1).has("ecard_info"))
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("ecard_info");
        this.igP = new ECardInfo();
        this.igP.title = this.title;
        this.igP.VEQ = new ArrayList(this.igO);
        this.igP.VES = this.igL;
        this.igP.VET = this.igJ;
        this.igP.VEU = this.igM;
        this.igP.VER = this.igH;
        this.igP.vAZ = ((JSONObject)localObject1).optInt("ecard_open_scene", 0);
        this.igP.hDJ = ((JSONObject)localObject1).optString("ecard_type", "");
        this.igP.VEK = ((JSONObject)localObject1).optInt("show_check_box", 0);
        this.igP.VEL = ((JSONObject)localObject1).optInt("check_box_selected", 0);
        this.igP.VEM = ((JSONObject)localObject1).optString("check_box_left_wording", "");
        this.igP.VEN = ((JSONObject)localObject1).optString("check_box_right_wording", "");
        this.igP.VEO = ((JSONObject)localObject1).optString("check_box_url", "");
        this.igP.VEP = ((JSONObject)localObject1).optInt("is_upload_credid", 0);
        this.igP.igG = ((JSONObject)localObject1).optString("upload_credit_url", "");
      }
    }
    for (;;)
    {
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        localObject1 = paramJSONObject.optJSONArray("paymenu_array");
        if (localObject1 != null) {
          com.tencent.mm.plugin.wallet_core.model.ab.afB(((JSONArray)localObject1).toString());
        }
      }
      if (!paramJSONObject.has("pay_manage_label")) {
        break label666;
      }
      localObject1 = paramJSONObject.optJSONArray("pay_manage_label");
      if (localObject1 == null) {
        break label666;
      }
      this.igY = new ArrayList();
      paramInt = 0;
      while (paramInt < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt);
        if (localObject2 != null)
        {
          localObject2 = t.cs((JSONObject)localObject2);
          this.igY.add(localObject2);
        }
        paramInt += 1;
      }
      ECardInfo.cl(null);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acTJ, ((JSONArray)localObject1).toString());
    label666:
    long l = paramJSONObject.optLong("time_stamp");
    if (l > 0L)
    {
      y.setTimeStamp(String.valueOf(l));
      ah.a(paramJSONObject, this.scene, true, this.Vym);
      if ((ah.asl(this.scene)) || (this.scene == 1))
      {
        localObject1 = paramJSONObject.optJSONObject("bind_card_menu");
        if (localObject1 == null) {
          break label893;
        }
        Log.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { ((JSONObject)localObject1).toString() });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acTD, ((JSONObject)localObject1).toString());
      }
      label776:
      localObject1 = (com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class);
      if (localObject1 == null) {
        break label1026;
      }
      Log.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).ftx();
      paramInt = u.iiC().ijm();
      if (paramInt != 0) {
        break label948;
      }
      if (!((com.tencent.mm.plugin.fingerprint.c.a)localObject1).ftv()) {
        break label914;
      }
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vu(u.iiC().ijj());
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vv(false);
      label848:
      if (this.scene != 10) {
        break label1147;
      }
      paramJSONObject = paramJSONObject.optJSONObject("action_entry");
      if (paramJSONObject != null) {
        break label1037;
      }
      paramString = null;
    }
    for (;;)
    {
      this.Vyj = paramString;
      AppMethodBeat.o(69953);
      return;
      Log.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break;
      label893:
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acTD, "");
      break label776;
      label914:
      if (!((com.tencent.mm.plugin.fingerprint.c.a)localObject1).ftD()) {
        break label848;
      }
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vv(u.iiC().ijj());
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vu(false);
      break label848;
      label948:
      if ((paramInt == 1) && (((com.tencent.mm.plugin.fingerprint.c.a)localObject1).ftv()))
      {
        ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vu(u.iiC().ijj());
        ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vv(false);
        break label848;
      }
      if ((paramInt != 2) || (!((com.tencent.mm.plugin.fingerprint.c.a)localObject1).ftD())) {
        break label848;
      }
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vv(u.iiC().ijj());
      ((com.tencent.mm.plugin.fingerprint.c.a)localObject1).vu(false);
      break label848;
      label1026:
      Log.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label848;
      label1037:
      paramString = new com.tencent.mm.plugin.wallet_core.model.h();
      paramString.id = paramJSONObject.optString("id");
      paramString.wording = paramJSONObject.optString("wording");
      paramString.nRQ = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.VEG = paramJSONObject.optString("native_url");
      paramString.xmo = paramJSONObject.optString("web_url");
      paramString.VEH = paramJSONObject.optString("tiny_app_username");
      paramString.VEI = paramJSONObject.optString("tiny_app_path");
      paramString.VaY = paramJSONObject.optInt("entrance_type");
    }
    label1147:
    if (this.scene == 8)
    {
      if (paramJSONObject.has("block_layer"))
      {
        localObject1 = paramJSONObject.optJSONObject("block_layer");
        if (localObject1 != null) {
          break label1235;
        }
      }
      for (;;)
      {
        this.Vyk = paramString;
        paramString = paramJSONObject.optJSONObject("disable_block_layer");
        if (paramString == null) {
          break;
        }
        this.Vyl = r.cp(paramString);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.acVB, paramString.toString());
        AppMethodBeat.o(69953);
        return;
        paramString = new q();
        paramString.VGk = ((JSONObject)localObject1).optInt("view_id");
        paramString.VGl = ((JSONObject)localObject1).optInt("is_show_block_layer");
        paramString.VGm = ((JSONObject)localObject1).optInt("waiting_time");
        paramString.VGn = ((JSONObject)localObject1).optString("main_wording");
        paramString.VGo = ((JSONObject)localObject1).optString("reminder_content");
        paramString.VGq = ((JSONObject)localObject1).optString("repayment_tiny_app_path");
        paramString.VGp = ((JSONObject)localObject1).optString("repayment_tiny_app_username");
      }
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.acVB, "");
    }
    label1235:
    AppMethodBeat.o(69953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ae
 * JD-Core Version:    0.7.0.1
 */