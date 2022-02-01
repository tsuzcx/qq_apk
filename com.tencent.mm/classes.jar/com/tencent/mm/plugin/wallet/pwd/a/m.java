package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  public int zSn;
  public String zSo;
  public int zSp;
  public String zSq;
  public String zSr;
  public String zSs;
  
  public m()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.cG(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
  }
  
  private static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(69562);
    if (bt.isNullOrNil(paramString))
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
    ad.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    ad.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label110:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label618;
      }
      this.zSn = bt.getInt(paramString, 0);
      this.zSo = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label624;
      }
      this.zSp = bt.getInt(paramString, 0);
      this.zSq = paramJSONObject.optString("deduct_title", "");
      this.zSr = paramJSONObject.optString("realname_url", "");
      this.zSs = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new af();
      ((af)localObject).field_is_show = this.zSn;
      ((af)localObject).field_pref_key = "wallet_open_auto_pay";
      ((af)localObject).field_pref_title = this.zSq;
      ((af)localObject).field_pref_url = this.zSo;
      s.ecb().auh("wallet_open_auto_pay");
      ad.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.zSp), this.zSs });
      s.ecb().insert((c)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_switch_currency");
        s.ecb().auh("wallet_switch_currency");
        s.ecb().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_im_mch");
        s.ecb().auh("wallet_im_mch");
        s.ecb().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label631;
      }
      g.afC();
      g.afB().afk().set(ae.a.FvM, ((JSONArray)localObject).toString());
      label381:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label653;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.afC();
      g.afB().afk().set(ae.a.Frb, paramJSONObject);
      g.afC();
      g.afB().afk().set(ae.a.Frc, localObject);
    }
    for (;;)
    {
      g.afC();
      g.afB().afk().set(ae.a.FkG, Long.valueOf(new Date().getTime() / 1000L));
      g.afC();
      g.afB().afk().set(ae.a.FkH, Integer.valueOf(this.zSp));
      g.afC();
      g.afB().afk().set(ae.a.FkN, this.zSr);
      g.afC();
      g.afB().afk().set(ae.a.FkW, this.zSs);
      if (!bt.isNullOrNil(paramString))
      {
        g.afC();
        g.afB().afk().set(ae.a.FkU, paramString);
      }
      if (!bt.isNullOrNil(str))
      {
        g.afC();
        g.afB().afk().set(ae.a.FkV, str);
      }
      g.afC();
      g.afB().afk().eKy();
      AppMethodBeat.o(69560);
      return;
      label618:
      paramString = "0";
      break;
      label624:
      paramString = "84600";
      break label110;
      label631:
      g.afC();
      g.afB().afk().set(ae.a.FvM, " ");
      break label381;
      label653:
      g.afC();
      g.afB().afk().set(ae.a.Frb, "");
      g.afC();
      g.afB().afk().set(ae.a.Frc, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<af> zSt;
    public dbp zSu;
    public dbp zSv;
    
    public a()
    {
      AppMethodBeat.i(187138);
      this.zSt = new LinkedList();
      AppMethodBeat.o(187138);
    }
    
    public static a aK(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(187139);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.zSt;
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
              s.ecb().auh(localaf.field_pref_key);
              s.ecb().insert(localaf);
            }
            localLinkedList.add(localaf);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.zSu = aL((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.zSv = aL(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(187139);
      return locala;
    }
    
    private static dbp aL(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(187140);
      dbp localdbp = new dbp();
      if (paramJSONObject != null)
      {
        localdbp.CDW = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localdbp.Eth;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              dbm localdbm = new dbm();
              if (localJSONObject1 != null)
              {
                localdbm.EsY = localJSONObject1.optLong("color");
                localdbm.EsZ = localJSONObject1.optString("font");
                localdbm.text = localJSONObject1.optString("text");
                localdbm.size = ((float)localJSONObject1.optLong("size"));
                localdbm.Eta = localJSONObject1.optInt("text_attr");
                localdbm.CDW = localJSONObject1.optString("view_id");
                Object localObject = new cmc();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((cmc)localObject).type = localJSONObject2.optInt("type");
                  ((cmc)localObject).url = localJSONObject2.optString("url");
                  dca localdca = new dca();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localdca.username = localJSONObject2.optString("username");
                    localdca.path = localJSONObject2.optString("path");
                    localdca.version = localJSONObject2.optInt("version");
                    ((cmc)localObject).Ehg = localdca;
                  }
                }
                localdbm.Cvq = ((cmc)localObject);
                localObject = new acl();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((acl)localObject).DcS = localJSONObject1.optLong("normal_color");
                  ((acl)localObject).DcT = localJSONObject1.optLong("dark_mode_color");
                  localdbm.Etb = ((acl)localObject);
                }
              }
              localLinkedList.add(localdbm);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                ad.e("MicroMsg.NetSceneTenpayPayManager", "parseTextViewData Exception:%s", new Object[] { localJSONException.getMessage() });
              }
            }
            i += 1;
          }
        }
      }
      label360:
      AppMethodBeat.o(187140);
      return localdbp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */