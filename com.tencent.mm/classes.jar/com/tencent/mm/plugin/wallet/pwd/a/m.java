package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  public int BkH;
  public String BkI;
  public int BkJ;
  public String BkK;
  public String BkL;
  public String BkM;
  
  public m()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.cF(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(69562);
    if (bs.isNullOrNil(paramString))
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
  
  private static af j(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(69561);
    af localaf = new af();
    localaf.field_is_show = paramJSONObject.optInt("show_label", 0);
    localaf.field_pref_key = paramString;
    localaf.field_pref_title = paramJSONObject.optString("title");
    localaf.field_pref_desc = paramJSONObject.optString("desc");
    localaf.field_logo_url = paramJSONObject.optString("logo_url");
    localaf.field_jump_type = paramJSONObject.optInt("jump_type");
    localaf.field_pref_url = paramJSONObject.optString("jump_h5_url");
    localaf.field_tinyapp_username = paramJSONObject.optString("tinyapp_username");
    localaf.field_tinyapp_path = paramJSONObject.optString("tinyapp_path");
    AppMethodBeat.o(69561);
    return localaf;
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
    ac.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    ac.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label110:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label665;
      }
      this.BkH = bs.getInt(paramString, 0);
      this.BkI = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label671;
      }
      this.BkJ = bs.getInt(paramString, 0);
      this.BkK = paramJSONObject.optString("deduct_title", "");
      this.BkL = paramJSONObject.optString("realname_url", "");
      this.BkM = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new af();
      ((af)localObject).field_is_show = this.BkH;
      ((af)localObject).field_pref_key = "wallet_open_auto_pay";
      ((af)localObject).field_pref_title = this.BkK;
      ((af)localObject).field_pref_url = this.BkI;
      ((af)localObject).field_jump_type = 1;
      s.erx().azz("wallet_open_auto_pay");
      ac.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.BkJ), this.BkM });
      s.erx().insert((c)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_switch_currency");
        s.erx().azz("wallet_switch_currency");
        s.erx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_im_mch");
        s.erx().azz("wallet_im_mch");
        s.erx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_open_auto_pay");
        s.erx().azz("wallet_open_auto_pay");
        s.erx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label678;
      }
      g.agS();
      g.agR().agA().set(ah.a.GTG, ((JSONArray)localObject).toString());
      label428:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label700;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.agS();
      g.agR().agA().set(ah.a.GOR, paramJSONObject);
      g.agS();
      g.agR().agA().set(ah.a.GOS, localObject);
    }
    for (;;)
    {
      g.agS();
      g.agR().agA().set(ah.a.GIv, Long.valueOf(new Date().getTime() / 1000L));
      g.agS();
      g.agR().agA().set(ah.a.GIw, Integer.valueOf(this.BkJ));
      g.agS();
      g.agR().agA().set(ah.a.GIC, this.BkL);
      g.agS();
      g.agR().agA().set(ah.a.GIL, this.BkM);
      if (!bs.isNullOrNil(paramString))
      {
        g.agS();
        g.agR().agA().set(ah.a.GIJ, paramString);
      }
      if (!bs.isNullOrNil(str))
      {
        g.agS();
        g.agR().agA().set(ah.a.GIK, str);
      }
      g.agS();
      g.agR().agA().faa();
      AppMethodBeat.o(69560);
      return;
      label665:
      paramString = "0";
      break;
      label671:
      paramString = "84600";
      break label110;
      label678:
      g.agS();
      g.agR().agA().set(ah.a.GTG, " ");
      break label428;
      label700:
      g.agS();
      g.agR().agA().set(ah.a.GOR, "");
      g.agS();
      g.agR().agA().set(ah.a.GOS, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<af> BkN;
    public dhb BkO;
    public dhb BkP;
    
    public a()
    {
      AppMethodBeat.i(207258);
      this.BkN = new LinkedList();
      AppMethodBeat.o(207258);
    }
    
    public static a aL(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(207259);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.BkN;
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            af localaf = new af();
            if (localJSONObject != null)
            {
              localaf.field_is_show = localJSONObject.optInt("show_label", 0);
              localaf.field_pref_title = localJSONObject.optString("title");
              localaf.field_pref_key = localaf.field_pref_title;
              localaf.field_pref_desc = localJSONObject.optString("desc");
              localaf.field_logo_url = localJSONObject.optString("logo_url");
              localaf.field_jump_type = localJSONObject.optInt("jump_type");
              localaf.field_pref_url = localJSONObject.optString("jump_h5_url");
              localaf.field_tinyapp_username = localJSONObject.optString("tinyapp_username");
              localaf.field_tinyapp_path = localJSONObject.optString("tinyapp_path");
              s.erx().azz(localaf.field_pref_key);
              s.erx().insert(localaf);
            }
            localLinkedList.add(localaf);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.BkO = aM((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.BkP = aM(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ac.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(207259);
      return locala;
    }
    
    private static dhb aM(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(207260);
      dhb localdhb = new dhb();
      if (paramJSONObject != null)
      {
        localdhb.DWw = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localdhb.FQj;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              dgy localdgy = new dgy();
              if (localJSONObject1 != null)
              {
                localdgy.FQa = localJSONObject1.optLong("color");
                localdgy.FQb = localJSONObject1.optString("font");
                localdgy.text = localJSONObject1.optString("text");
                localdgy.size = ((float)localJSONObject1.optLong("size"));
                localdgy.FQc = localJSONObject1.optInt("text_attr");
                localdgy.DWw = localJSONObject1.optString("view_id");
                Object localObject = new crj();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((crj)localObject).type = localJSONObject2.optInt("type");
                  ((crj)localObject).url = localJSONObject2.optString("url");
                  dhm localdhm = new dhm();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localdhm.username = localJSONObject2.optString("username");
                    localdhm.path = localJSONObject2.optString("path");
                    localdhm.version = localJSONObject2.optInt("version");
                    ((crj)localObject).FEf = localdhm;
                  }
                }
                localdgy.DNL = ((crj)localObject);
                localObject = new adk();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((adk)localObject).EvZ = localJSONObject1.optLong("normal_color");
                  ((adk)localObject).Ewa = localJSONObject1.optLong("dark_mode_color");
                  localdgy.FQd = ((adk)localObject);
                }
              }
              localLinkedList.add(localdgy);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ac.e("MicroMsg.NetSceneTenpayPayManager", "parseTextViewData Exception:%s", new Object[] { localJSONException.getMessage() });
              }
            }
            i += 1;
          }
        }
      }
      label360:
      AppMethodBeat.o(207260);
      return localdhb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */