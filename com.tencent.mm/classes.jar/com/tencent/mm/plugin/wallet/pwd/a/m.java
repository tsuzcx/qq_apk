package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends com.tencent.mm.wallet_core.tenpay.model.m
{
  public int OAh;
  public String OAi;
  public int OAj;
  public String OAk;
  public String OAl;
  public String OAm;
  
  public m()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.dR(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
  }
  
  public static boolean eqj()
  {
    AppMethodBeat.i(249853);
    h.aHH();
    long l = ((Long)h.aHG().aHp().get(ar.a.Vlm, Long.valueOf(0L))).longValue();
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.Vln, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
    if (l > 0L)
    {
      if (new Date().getTime() / 1000L > l + i)
      {
        AppMethodBeat.o(249853);
        return true;
      }
      AppMethodBeat.o(249853);
      return false;
    }
    AppMethodBeat.o(249853);
    return true;
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(69562);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(69562);
      return false;
    }
    int i = paramString.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0)
      {
        AppMethodBeat.o(69562);
        return true;
      }
      j = paramString.charAt(i);
    } while ((j >= 48) && (j <= 57));
    AppMethodBeat.o(69562);
    return false;
  }
  
  private static ah p(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(69561);
    ah localah = new ah();
    localah.field_is_show = paramJSONObject.optInt("show_label", 0);
    localah.field_pref_key = paramString;
    localah.field_pref_title = paramJSONObject.optString("title");
    localah.field_pref_desc = paramJSONObject.optString("desc");
    localah.field_logo_url = paramJSONObject.optString("logo_url");
    localah.field_jump_type = paramJSONObject.optInt("jump_type");
    localah.field_pref_url = paramJSONObject.optString("jump_h5_url");
    localah.field_tinyapp_username = paramJSONObject.optString("tinyapp_username");
    localah.field_tinyapp_path = paramJSONObject.optString("tinyapp_path");
    AppMethodBeat.o(69561);
    return localah;
  }
  
  public final int getFuncId()
  {
    return 1654;
  }
  
  public final int getPayCgicmd()
  {
    return 100000;
  }
  
  public final int getTenpayCgicmd()
  {
    return 0;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/paymanage";
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69560);
    Log.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    Log.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label114:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label689;
      }
      this.OAh = Util.getInt(paramString, 0);
      this.OAi = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label695;
      }
      this.OAj = Util.getInt(paramString, 0);
      this.OAk = paramJSONObject.optString("deduct_title", "");
      this.OAl = paramJSONObject.optString("realname_url", "");
      this.OAm = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new ah();
      ((ah)localObject).field_is_show = this.OAh;
      ((ah)localObject).field_pref_key = "wallet_open_auto_pay";
      ((ah)localObject).field_pref_title = this.OAk;
      ((ah)localObject).field_pref_url = this.OAi;
      ((ah)localObject).field_jump_type = 1;
      u.gJn().bhn("wallet_open_auto_pay");
      Log.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.OAj), this.OAm });
      u.gJn().insert((IAutoDBItem)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = p((JSONObject)localObject, "wallet_switch_currency");
        u.gJn().bhn("wallet_switch_currency");
        u.gJn().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = p((JSONObject)localObject, "wallet_im_mch");
        u.gJn().bhn("wallet_im_mch");
        u.gJn().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = p((JSONObject)localObject, "wallet_open_auto_pay");
        u.gJn().bhn("wallet_open_auto_pay");
        u.gJn().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label702;
      }
      h.aHH();
      h.aHG().aHp().set(ar.a.VxI, ((JSONArray)localObject).toString());
      label450:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label724;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      h.aHH();
      h.aHG().aHp().set(ar.a.Vso, paramJSONObject);
      h.aHH();
      h.aHG().aHp().set(ar.a.Vsp, localObject);
    }
    for (;;)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vlm, Long.valueOf(new Date().getTime() / 1000L));
      h.aHH();
      h.aHG().aHp().set(ar.a.Vln, Integer.valueOf(this.OAj));
      h.aHH();
      h.aHG().aHp().set(ar.a.Vlt, this.OAl);
      h.aHH();
      h.aHG().aHp().set(ar.a.VlC, this.OAm);
      if (!Util.isNullOrNil(paramString))
      {
        h.aHH();
        h.aHG().aHp().set(ar.a.VlA, paramString);
      }
      if (!Util.isNullOrNil(str))
      {
        h.aHH();
        h.aHG().aHp().set(ar.a.VlB, str);
      }
      h.aHH();
      h.aHG().aHp().hxT();
      AppMethodBeat.o(69560);
      return;
      label689:
      paramString = "0";
      break;
      label695:
      paramString = "84600";
      break label114;
      label702:
      h.aHH();
      h.aHG().aHp().set(ar.a.VxI, " ");
      break label450;
      label724:
      h.aHH();
      h.aHG().aHp().set(ar.a.Vso, "");
      h.aHH();
      h.aHG().aHp().set(ar.a.Vsp, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<ah> OAn;
    public erh OAo;
    public erh OAp;
    
    public a()
    {
      AppMethodBeat.i(192029);
      this.OAn = new LinkedList();
      AppMethodBeat.o(192029);
    }
    
    public static a bE(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(192035);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.OAn;
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            ah localah = new ah();
            if (localJSONObject != null)
            {
              localah.field_is_show = localJSONObject.optInt("show_label", 0);
              localah.field_pref_title = localJSONObject.optString("title");
              localah.field_pref_key = localah.field_pref_title;
              localah.field_pref_desc = localJSONObject.optString("desc");
              localah.field_logo_url = localJSONObject.optString("logo_url");
              localah.field_jump_type = localJSONObject.optInt("jump_type");
              localah.field_pref_url = localJSONObject.optString("jump_h5_url");
              localah.field_tinyapp_username = localJSONObject.optString("tinyapp_username");
              localah.field_tinyapp_path = localJSONObject.optString("tinyapp_path");
              u.gJn().bhn(localah.field_pref_key);
              u.gJn().insert(localah);
            }
            localLinkedList.add(localah);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.OAo = bF((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.OAp = bF(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(192035);
      return locala;
    }
    
    private static erh bF(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(192052);
      erh localerh = new erh();
      if (paramJSONObject != null)
      {
        localerh.ROQ = paramJSONObject.optString("view_id");
        paramJSONObject = paramJSONObject.optJSONArray("text");
        if (paramJSONObject != null)
        {
          int i = 0;
          for (;;)
          {
            if (i >= paramJSONObject.length()) {
              break label360;
            }
            try
            {
              LinkedList localLinkedList = localerh.Uty;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              ere localere = new ere();
              if (localJSONObject1 != null)
              {
                localere.Utp = localJSONObject1.optLong("color");
                localere.IbE = localJSONObject1.optString("font");
                localere.text = localJSONObject1.optString("text");
                localere.size = ((float)localJSONObject1.optLong("size"));
                localere.Utq = localJSONObject1.optInt("text_attr");
                localere.ROQ = localJSONObject1.optString("view_id");
                Object localObject = new eaa();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((eaa)localObject).type = localJSONObject2.optInt("type");
                  ((eaa)localObject).url = localJSONObject2.optString("url");
                  erw localerw = new erw();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localerw.username = localJSONObject2.optString("username");
                    localerw.path = localJSONObject2.optString("path");
                    localerw.version = localJSONObject2.optInt("version");
                    ((eaa)localObject).Ufp = localerw;
                  }
                }
                localere.RGh = ((eaa)localObject);
                localObject = new aim();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((aim)localObject).Stf = localJSONObject1.optLong("normal_color");
                  ((aim)localObject).Stg = localJSONObject1.optLong("dark_mode_color");
                  localere.Utr = ((aim)localObject);
                }
              }
              localLinkedList.add(localere);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Log.e("MicroMsg.NetSceneTenpayPayManager", "parseTextViewData Exception:%s", new Object[] { localJSONException.getMessage() });
              }
            }
            i += 1;
          }
        }
      }
      label360:
      AppMethodBeat.o(192052);
      return localerh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */