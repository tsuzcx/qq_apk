package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class y
  extends j
{
  public String cdl;
  public String cdm;
  public String cdn;
  public String cdo;
  public String cdp;
  public String cdq = "";
  public int cdr = 0;
  public String cds = "";
  public String cdt = "";
  public String cdu = "";
  public String cdv = "";
  public String cdw = "";
  public LinkedList<String> cdx = new LinkedList();
  public ECardInfo cdy;
  public Map<String, String> mLt = new HashMap();
  public Map<String, String> qma;
  public int scene = 0;
  public String title = "";
  
  public y()
  {
    this(null, 0);
  }
  
  public y(String paramString, int paramInt)
  {
    this.scene = paramInt;
    this.mLt.put("req_key", paramString);
    this.mLt.put("bind_query_scene", String.valueOf(paramInt));
    paramString = (k)g.r(k.class);
    this.mLt.put("is_root", "0");
    if (paramString != null)
    {
      this.mLt.put("is_device_open_touch", "1");
      paramString = paramString.aSO();
      if (paramString != null) {
        this.mLt.putAll(paramString);
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is true");
    }
    for (;;)
    {
      D(this.mLt);
      this.qma = new HashMap();
      g.DQ();
      paramString = (String)g.DP().Dz().get(196612, null);
      g.DQ();
      String str = (String)g.DP().Dz().get(196613, null);
      this.qma.put("bind_serial", paramString);
      this.qma.put("last_bind_serial", str);
      aC(this.qma);
      return;
      this.mLt.put("is_device_open_touch", "0");
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "is_device_open_touch is false");
    }
  }
  
  public int HH()
  {
    return 1501;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramInt != 0) {}
    label659:
    label680:
    do
    {
      return;
      if (paramJSONObject.has("real_name_info"))
      {
        paramString = paramJSONObject.optJSONObject("real_name_info");
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "get real_name_info %s", new Object[] { paramString.toString() });
        this.cdl = paramString.optString("guide_flag");
        this.cdm = paramString.optString("guide_wording");
        this.cdn = paramString.optString("left_button_wording");
        this.cdo = paramString.optString("right_button_wording");
        this.cdp = paramString.optString("upload_credit_url");
        this.cdq = paramString.optString("done_button_wording");
        this.cdr = paramString.optInt("is_show_protocol", 0);
        this.cds = paramString.optString("left_protocol_wording");
        this.cdt = paramString.optString("new_upload_credit_url");
        this.cdu = paramString.optString("protocol_url");
        this.cdv = paramString.optString("right_protocol_wording");
        this.cdw = paramString.optString("subtitle");
        this.title = paramString.optString("title");
        JSONArray localJSONArray = paramString.optJSONArray("upload_reasons");
        this.cdx.clear();
        if (localJSONArray != null)
        {
          paramInt = 0;
          while (paramInt < localJSONArray.length())
          {
            this.cdx.add(localJSONArray.optString(paramInt));
            paramInt += 1;
          }
        }
        if (paramString.has("ecard_info"))
        {
          paramString = paramString.optJSONObject("ecard_info");
          this.cdy = new ECardInfo();
          this.cdy.title = this.title;
          this.cdy.quQ = new ArrayList(this.cdx);
          this.cdy.quS = this.cdu;
          this.cdy.quT = this.cds;
          this.cdy.quU = this.cdv;
          this.cdy.quR = this.cdq;
          this.cdy.quJ = paramString.optInt("ecard_open_scene", 0);
          this.cdy.bIM = paramString.optString("ecard_type", "");
          this.cdy.quK = paramString.optInt("show_check_box", 0);
          this.cdy.quL = paramString.optInt("check_box_selected", 0);
          this.cdy.quM = paramString.optString("check_box_left_wording", "");
          this.cdy.quN = paramString.optString("check_box_right_wording", "");
          this.cdy.quO = paramString.optString("check_box_url", "");
          this.cdy.quP = paramString.optInt("is_upload_credid", 0);
          this.cdy.cdp = paramString.optString("upload_credit_url", "");
        }
      }
      if ((paramJSONObject.has("paymenu_array")) && (this.scene == 1))
      {
        paramString = paramJSONObject.optJSONArray("paymenu_array");
        if (paramString != null) {
          w.Qr(paramString.toString());
        }
      }
      long l = paramJSONObject.optLong("time_stamp");
      if (l > 0L)
      {
        u.setTimeStamp(String.valueOf(l));
        ab.a(paramJSONObject, this.scene);
        if ((ab.AP(this.scene)) || (this.scene == 1))
        {
          paramString = paramJSONObject.optJSONObject("bind_card_menu");
          if (paramString == null) {
            break label659;
          }
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "bind card menu: %s", new Object[] { paramString.toString() });
          g.DQ();
          g.DP().Dz().c(ac.a.uxG, paramString.toString());
        }
      }
      for (;;)
      {
        paramString = (k)g.r(k.class);
        if (paramString == null) {
          break label702;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is not null");
        paramString.aSH();
        if (!paramString.aSF()) {
          break label680;
        }
        paramString.gf(o.bVs().bVP());
        return;
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.NetSceneTenpayQueryBindBankcard", "no time_stamp in bindquerynew.");
        break;
        g.DQ();
        g.DP().Dz().c(ac.a.uxG, "");
      }
    } while (!paramString.aSS());
    paramString.gg(o.bVs().bVP());
    return;
    label702:
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneTenpayQueryBindBankcard", "IFingerPrintMgr is null");
  }
  
  public int aEC()
  {
    return 72;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/bindquerynew";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */