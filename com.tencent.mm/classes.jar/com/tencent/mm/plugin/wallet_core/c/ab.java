package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ab
  extends m
{
  public String cLV;
  public String cLW;
  public String cLX;
  public String cLY;
  public String cLZ;
  public String cMa;
  public int cMb;
  public String cMc;
  public String cMd;
  public String cMe;
  public String cMf;
  public LinkedList<String> cMg;
  public ECardInfo cMh;
  public Map<String, String> plK;
  public int scene;
  public String subtitle;
  public Map<String, String> tVp;
  public String title;
  public j ucb;
  
  public ab()
  {
    this(null, 0);
  }
  
  public ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(46547);
    this.cMa = "";
    this.cMb = 0;
    this.cMc = "";
    this.cMd = "";
    this.cMe = "";
    this.cMf = "";
    this.subtitle = "";
    this.title = "";
    this.cMg = new LinkedList();
    this.scene = 0;
    this.plK = new HashMap();
    this.scene = paramInt;
    this.plK.put("req_key", paramString);
    this.plK.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (l)g.E(l.class);
    this.plK.put("is_root", "0");
    if (paramString != null)
    {
      this.plK.put("is_device_open_touch", "1");
      paramString = paramString.bzj();
      if (paramString != null) {
        this.plK.putAll(paramString);
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      setRequestData(this.plK);
      this.tVp = new HashMap();
      g.RM();
      paramString = (String)g.RL().Ru().get(196612, null);
      g.RM();
      String str = (String)g.RL().Ru().get(196613, null);
      this.tVp.put("bind_serial", paramString);
      this.tVp.put("last_bind_serial", str);
      setWXRequestData(this.tVp);
      AppMethodBeat.o(46547);
      return;
      this.plK.put("is_device_open_touch", "0");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
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
    AppMethodBeat.i(46548);
    if (paramInt != 0)
    {
      AppMethodBeat.o(46548);
      return;
    }
    if (paramJSONObject.has("real_name_info"))
    {
      paramString = paramJSONObject.optJSONObject("real_name_info");
      ECardInfo.aB(paramString);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { paramString.toString() });
      this.cLV = paramString.optString("guide_flag");
      this.cLW = paramString.optString("guide_wording");
      this.cLX = paramString.optString("left_button_wording");
      this.cLY = paramString.optString("right_button_wording");
      this.cLZ = paramString.optString("upload_credit_url");
      this.cMa = paramString.optString("done_button_wording");
      this.cMb = paramString.optInt("is_show_protocol", 0);
      this.cMc = paramString.optString("left_protocol_wording");
      this.cMd = paramString.optString("new_upload_credit_url");
      this.cMe = paramString.optString("protocol_url");
      this.cMf = paramString.optString("right_protocol_wording");
      this.subtitle = paramString.optString("subtitle");
      this.title = paramString.optString("title");
      JSONArray localJSONArray = paramString.optJSONArray("upload_reasons");
      this.cMg.clear();
      if (localJSONArray != null)
      {
        paramInt = 0;
        while (paramInt < localJSONArray.length())
        {
          this.cMg.add(localJSONArray.optString(paramInt));
          paramInt += 1;
        }
      }
      if (paramString.has("ecard_info"))
      {
        paramString = paramString.optJSONObject("ecard_info");
        this.cMh = new ECardInfo();
        this.cMh.title = this.title;
        this.cMh.uhi = new ArrayList(this.cMg);
        this.cMh.uhk = this.cMe;
        this.cMh.uhl = this.cMc;
        this.cMh.uhm = this.cMf;
        this.cMh.uhj = this.cMa;
        this.cMh.kbq = paramString.optInt("ecard_open_scene", 0);
        this.cMh.cqh = paramString.optString("ecard_type", "");
        this.cMh.uhc = paramString.optInt("show_check_box", 0);
        this.cMh.uhd = paramString.optInt("check_box_selected", 0);
        this.cMh.uhe = paramString.optString("check_box_left_wording", "");
        this.cMh.uhf = paramString.optString("check_box_right_wording", "");
        this.cMh.uhg = paramString.optString("check_box_url", "");
        this.cMh.uhh = paramString.optInt("is_upload_credid", 0);
        this.cMh.cLZ = paramString.optString("upload_credit_url", "");
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        paramString = paramJSONObject.optJSONArray("paymenu_array");
        if (paramString != null) {
          com.tencent.mm.plugin.wallet_core.model.ab.afj(paramString.toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l <= 0L) {
        break label723;
      }
      w.setTimeStamp(String.valueOf(l));
      label538:
      ah.a(paramJSONObject, this.scene, true);
      if ((ah.IA(this.scene)) || (this.scene == 1))
      {
        paramString = paramJSONObject.optJSONObject("bind_card_menu");
        if (paramString == null) {
          break label734;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { paramString.toString() });
        g.RM();
        g.RL().Ru().set(ac.a.yHQ, paramString.toString());
      }
      label616:
      paramString = (l)g.E(l.class);
      if (paramString == null) {
        break label858;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
      paramString.bzc();
      paramInt = t.cTN().cUr();
      if (paramInt != 0) {
        break label786;
      }
      if (!paramString.bza()) {
        break label755;
      }
      paramString.hH(t.cTN().cUp());
      paramString.hI(false);
      label682:
      if (this.scene == 10)
      {
        paramJSONObject = paramJSONObject.optJSONObject("action_entry");
        if (paramJSONObject != null) {
          break label869;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      this.ucb = paramString;
      AppMethodBeat.o(46548);
      return;
      ECardInfo.aB(null);
      break;
      label723:
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
      break label538;
      label734:
      g.RM();
      g.RL().Ru().set(ac.a.yHQ, "");
      break label616;
      label755:
      if (!paramString.bzn()) {
        break label682;
      }
      paramString.hI(t.cTN().cUp());
      paramString.hH(false);
      break label682;
      label786:
      if ((paramInt == 1) && (paramString.bza()))
      {
        paramString.hH(t.cTN().cUp());
        paramString.hI(false);
        break label682;
      }
      if ((paramInt != 2) || (!paramString.bzn())) {
        break label682;
      }
      paramString.hI(t.cTN().cUp());
      paramString.hH(false);
      break label682;
      label858:
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
      break label682;
      label869:
      paramString = new j();
      paramString.id = paramJSONObject.optString("id");
      paramString.cyA = paramJSONObject.optString("wording");
      paramString.color = paramJSONObject.optString("color");
      paramString.type = paramJSONObject.optInt("type");
      paramString.ugX = paramJSONObject.optString("native_url");
      paramString.kXd = paramJSONObject.optString("web_url");
      paramString.ugY = paramJSONObject.optString("tiny_app_username");
      paramString.ugZ = paramJSONObject.optString("tiny_app_path");
      paramString.uha = paramJSONObject.optInt("entrance_type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.ab
 * JD-Core Version:    0.7.0.1
 */