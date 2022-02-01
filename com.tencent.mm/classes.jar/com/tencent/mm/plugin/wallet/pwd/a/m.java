package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.ehc;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehu;
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
  public int HIp;
  public String HIq;
  public int HIr;
  public String HIs;
  public String HIt;
  public String HIu;
  
  public m()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.dr(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
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
  
  private static ag n(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(69561);
    ag localag = new ag();
    localag.field_is_show = paramJSONObject.optInt("show_label", 0);
    localag.field_pref_key = paramString;
    localag.field_pref_title = paramJSONObject.optString("title");
    localag.field_pref_desc = paramJSONObject.optString("desc");
    localag.field_logo_url = paramJSONObject.optString("logo_url");
    localag.field_jump_type = paramJSONObject.optInt("jump_type");
    localag.field_pref_url = paramJSONObject.optString("jump_h5_url");
    localag.field_tinyapp_username = paramJSONObject.optString("tinyapp_username");
    localag.field_tinyapp_path = paramJSONObject.optString("tinyapp_path");
    AppMethodBeat.o(69561);
    return localag;
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
    label110:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label665;
      }
      this.HIp = Util.getInt(paramString, 0);
      this.HIq = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label671;
      }
      this.HIr = Util.getInt(paramString, 0);
      this.HIs = paramJSONObject.optString("deduct_title", "");
      this.HIt = paramJSONObject.optString("realname_url", "");
      this.HIu = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new ag();
      ((ag)localObject).field_is_show = this.HIp;
      ((ag)localObject).field_pref_key = "wallet_open_auto_pay";
      ((ag)localObject).field_pref_title = this.HIs;
      ((ag)localObject).field_pref_url = this.HIq;
      ((ag)localObject).field_jump_type = 1;
      t.fQH().aVE("wallet_open_auto_pay");
      Log.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.HIr), this.HIu });
      t.fQH().insert((IAutoDBItem)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = n((JSONObject)localObject, "wallet_switch_currency");
        t.fQH().aVE("wallet_switch_currency");
        t.fQH().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = n((JSONObject)localObject, "wallet_im_mch");
        t.fQH().aVE("wallet_im_mch");
        t.fQH().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = n((JSONObject)localObject, "wallet_open_auto_pay");
        t.fQH().aVE("wallet_open_auto_pay");
        t.fQH().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label678;
      }
      g.aAi();
      g.aAh().azQ().set(ar.a.Ojs, ((JSONArray)localObject).toString());
      label428:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label700;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.aAi();
      g.aAh().azQ().set(ar.a.Oed, paramJSONObject);
      g.aAi();
      g.aAh().azQ().set(ar.a.Oee, localObject);
    }
    for (;;)
    {
      g.aAi();
      g.aAh().azQ().set(ar.a.NXm, Long.valueOf(new Date().getTime() / 1000L));
      g.aAi();
      g.aAh().azQ().set(ar.a.NXn, Integer.valueOf(this.HIr));
      g.aAi();
      g.aAh().azQ().set(ar.a.NXt, this.HIt);
      g.aAi();
      g.aAh().azQ().set(ar.a.NXC, this.HIu);
      if (!Util.isNullOrNil(paramString))
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.NXA, paramString);
      }
      if (!Util.isNullOrNil(str))
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.NXB, str);
      }
      g.aAi();
      g.aAh().azQ().gBI();
      AppMethodBeat.o(69560);
      return;
      label665:
      paramString = "0";
      break;
      label671:
      paramString = "84600";
      break label110;
      label678:
      g.aAi();
      g.aAh().azQ().set(ar.a.Ojs, " ");
      break label428;
      label700:
      g.aAi();
      g.aAh().azQ().set(ar.a.Oed, "");
      g.aAi();
      g.aAh().azQ().set(ar.a.Oee, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<ag> HIv;
    public ehf HIw;
    public ehf HIx;
    
    public a()
    {
      AppMethodBeat.i(214059);
      this.HIv = new LinkedList();
      AppMethodBeat.o(214059);
    }
    
    public static a bt(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(214060);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.HIv;
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            ag localag = new ag();
            if (localJSONObject != null)
            {
              localag.field_is_show = localJSONObject.optInt("show_label", 0);
              localag.field_pref_title = localJSONObject.optString("title");
              localag.field_pref_key = localag.field_pref_title;
              localag.field_pref_desc = localJSONObject.optString("desc");
              localag.field_logo_url = localJSONObject.optString("logo_url");
              localag.field_jump_type = localJSONObject.optInt("jump_type");
              localag.field_pref_url = localJSONObject.optString("jump_h5_url");
              localag.field_tinyapp_username = localJSONObject.optString("tinyapp_username");
              localag.field_tinyapp_path = localJSONObject.optString("tinyapp_path");
              t.fQH().aVE(localag.field_pref_key);
              t.fQH().insert(localag);
            }
            localLinkedList.add(localag);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.HIw = bu((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.HIx = bu(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(214060);
      return locala;
    }
    
    private static ehf bu(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(214061);
      ehf localehf = new ehf();
      if (paramJSONObject != null)
      {
        localehf.KNW = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localehf.NgT;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              ehc localehc = new ehc();
              if (localJSONObject1 != null)
              {
                localehc.NgL = localJSONObject1.optLong("color");
                localehc.CeI = localJSONObject1.optString("font");
                localehc.text = localJSONObject1.optString("text");
                localehc.size = ((float)localJSONObject1.optLong("size"));
                localehc.NgM = localJSONObject1.optInt("text_attr");
                localehc.KNW = localJSONObject1.optString("view_id");
                Object localObject = new dqe();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((dqe)localObject).type = localJSONObject2.optInt("type");
                  ((dqe)localObject).url = localJSONObject2.optString("url");
                  ehu localehu = new ehu();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localehu.username = localJSONObject2.optString("username");
                    localehu.path = localJSONObject2.optString("path");
                    localehu.version = localJSONObject2.optInt("version");
                    ((dqe)localObject).MTh = localehu;
                  }
                }
                localehc.KEP = ((dqe)localObject);
                localObject = new aib();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((aib)localObject).LrI = localJSONObject1.optLong("normal_color");
                  ((aib)localObject).LrJ = localJSONObject1.optLong("dark_mode_color");
                  localehc.NgN = ((aib)localObject);
                }
              }
              localLinkedList.add(localehc);
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
      AppMethodBeat.o(214061);
      return localehf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */