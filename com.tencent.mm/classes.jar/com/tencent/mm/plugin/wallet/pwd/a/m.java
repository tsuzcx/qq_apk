package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  public int DcB;
  public String DcC;
  public int DcD;
  public String DcE;
  public String DcF;
  public String DcG;
  
  public m()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.cH(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(69562);
    if (bu.isNullOrNil(paramString))
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
  
  private static ag j(JSONObject paramJSONObject, String paramString)
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
    ae.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    ae.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label110:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label665;
      }
      this.DcB = bu.getInt(paramString, 0);
      this.DcC = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label671;
      }
      this.DcD = bu.getInt(paramString, 0);
      this.DcE = paramJSONObject.optString("deduct_title", "");
      this.DcF = paramJSONObject.optString("realname_url", "");
      this.DcG = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new ag();
      ((ag)localObject).field_is_show = this.DcB;
      ((ag)localObject).field_pref_key = "wallet_open_auto_pay";
      ((ag)localObject).field_pref_title = this.DcE;
      ((ag)localObject).field_pref_url = this.DcC;
      ((ag)localObject).field_jump_type = 1;
      t.eJe().aGd("wallet_open_auto_pay");
      ae.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.DcD), this.DcG });
      t.eJe().insert((c)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_switch_currency");
        t.eJe().aGd("wallet_switch_currency");
        t.eJe().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_im_mch");
        t.eJe().aGd("wallet_im_mch");
        t.eJe().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_open_auto_pay");
        t.eJe().aGd("wallet_open_auto_pay");
        t.eJe().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label678;
      }
      g.ajS();
      g.ajR().ajA().set(am.a.JaM, ((JSONArray)localObject).toString());
      label428:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label700;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.ajS();
      g.ajR().ajA().set(am.a.IVL, paramJSONObject);
      g.ajS();
      g.ajR().ajA().set(am.a.IVM, localObject);
    }
    for (;;)
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IPl, Long.valueOf(new Date().getTime() / 1000L));
      g.ajS();
      g.ajR().ajA().set(am.a.IPm, Integer.valueOf(this.DcD));
      g.ajS();
      g.ajR().ajA().set(am.a.IPs, this.DcF);
      g.ajS();
      g.ajR().ajA().set(am.a.IPB, this.DcG);
      if (!bu.isNullOrNil(paramString))
      {
        g.ajS();
        g.ajR().ajA().set(am.a.IPz, paramString);
      }
      if (!bu.isNullOrNil(str))
      {
        g.ajS();
        g.ajR().ajA().set(am.a.IPA, str);
      }
      g.ajS();
      g.ajR().ajA().fuc();
      AppMethodBeat.o(69560);
      return;
      label665:
      paramString = "0";
      break;
      label671:
      paramString = "84600";
      break label110;
      label678:
      g.ajS();
      g.ajR().ajA().set(am.a.JaM, " ");
      break label428;
      label700:
      g.ajS();
      g.ajR().ajA().set(am.a.IVL, "");
      g.ajS();
      g.ajR().ajA().set(am.a.IVM, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<ag> DcH;
    public dnl DcI;
    public dnl DcJ;
    
    public a()
    {
      AppMethodBeat.i(190144);
      this.DcH = new LinkedList();
      AppMethodBeat.o(190144);
    }
    
    public static a aT(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(190145);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.DcH;
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
              t.eJe().aGd(localag.field_pref_key);
              t.eJe().insert(localag);
            }
            localLinkedList.add(localag);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.DcI = aU((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.DcJ = aU(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ae.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(190145);
      return locala;
    }
    
    private static dnl aU(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(190146);
      dnl localdnl = new dnl();
      if (paramJSONObject != null)
      {
        localdnl.FUn = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localdnl.HUA;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              dni localdni = new dni();
              if (localJSONObject1 != null)
              {
                localdni.HUs = localJSONObject1.optLong("color");
                localdni.ydG = localJSONObject1.optString("font");
                localdni.text = localJSONObject1.optString("text");
                localdni.size = ((float)localJSONObject1.optLong("size"));
                localdni.HUt = localJSONObject1.optInt("text_attr");
                localdni.FUn = localJSONObject1.optString("view_id");
                Object localObject = new cxk();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((cxk)localObject).type = localJSONObject2.optInt("type");
                  ((cxk)localObject).url = localJSONObject2.optString("url");
                  dny localdny = new dny();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localdny.username = localJSONObject2.optString("username");
                    localdny.path = localJSONObject2.optString("path");
                    localdny.version = localJSONObject2.optInt("version");
                    ((cxk)localObject).HHW = localdny;
                  }
                }
                localdni.FLp = ((cxk)localObject);
                localObject = new afu();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((afu)localObject).Gwc = localJSONObject1.optLong("normal_color");
                  ((afu)localObject).Gwd = localJSONObject1.optLong("dark_mode_color");
                  localdni.HUu = ((afu)localObject);
                }
              }
              localLinkedList.add(localdni);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ae.e("MicroMsg.NetSceneTenpayPayManager", "parseTextViewData Exception:%s", new Object[] { localJSONException.getMessage() });
              }
            }
            i += 1;
          }
        }
      }
      label360:
      AppMethodBeat.o(190146);
      return localdnl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */