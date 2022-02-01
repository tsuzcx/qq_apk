package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.afl;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public int CKV;
  public String CKW;
  public int CKX;
  public String CKY;
  public String CKZ;
  public String CLa;
  
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
    ad.i("MicroMsg.NetSceneTenpayPayManager", "errCode:" + paramInt + ";errMsg:" + paramString);
    ad.d("MicroMsg.NetSceneTenpayPayManager", "json: %s", new Object[] { paramJSONObject.toString() });
    label110:
    String str;
    if (paramInt == 0)
    {
      paramString = paramJSONObject.optString("is_show_deduct", "0");
      if (!isNumeric(paramString)) {
        break label665;
      }
      this.CKV = bt.getInt(paramString, 0);
      this.CKW = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label671;
      }
      this.CKX = bt.getInt(paramString, 0);
      this.CKY = paramJSONObject.optString("deduct_title", "");
      this.CKZ = paramJSONObject.optString("realname_url", "");
      this.CLa = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new ag();
      ((ag)localObject).field_is_show = this.CKV;
      ((ag)localObject).field_pref_key = "wallet_open_auto_pay";
      ((ag)localObject).field_pref_title = this.CKY;
      ((ag)localObject).field_pref_url = this.CKW;
      ((ag)localObject).field_jump_type = 1;
      t.eFx().aEJ("wallet_open_auto_pay");
      ad.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.CKX), this.CLa });
      t.eFx().insert((c)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_switch_currency");
        t.eFx().aEJ("wallet_switch_currency");
        t.eFx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_im_mch");
        t.eFx().aEJ("wallet_im_mch");
        t.eFx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = j((JSONObject)localObject, "wallet_open_auto_pay");
        t.eFx().aEJ("wallet_open_auto_pay");
        t.eFx().insert((c)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label678;
      }
      g.ajD();
      g.ajC().ajl().set(al.a.IGm, ((JSONArray)localObject).toString());
      label428:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label700;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      g.ajD();
      g.ajC().ajl().set(al.a.IBm, paramJSONObject);
      g.ajD();
      g.ajC().ajl().set(al.a.IBn, localObject);
    }
    for (;;)
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IuN, Long.valueOf(new Date().getTime() / 1000L));
      g.ajD();
      g.ajC().ajl().set(al.a.IuO, Integer.valueOf(this.CKX));
      g.ajD();
      g.ajC().ajl().set(al.a.IuU, this.CKZ);
      g.ajD();
      g.ajC().ajl().set(al.a.Ivd, this.CLa);
      if (!bt.isNullOrNil(paramString))
      {
        g.ajD();
        g.ajC().ajl().set(al.a.Ivb, paramString);
      }
      if (!bt.isNullOrNil(str))
      {
        g.ajD();
        g.ajC().ajl().set(al.a.Ivc, str);
      }
      g.ajD();
      g.ajC().ajl().fqc();
      AppMethodBeat.o(69560);
      return;
      label665:
      paramString = "0";
      break;
      label671:
      paramString = "84600";
      break label110;
      label678:
      g.ajD();
      g.ajC().ajl().set(al.a.IGm, " ");
      break label428;
      label700:
      g.ajD();
      g.ajC().ajl().set(al.a.IBm, "");
      g.ajD();
      g.ajC().ajl().set(al.a.IBn, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<ag> CLb;
    public dmo CLc;
    public dmo CLd;
    
    public a()
    {
      AppMethodBeat.i(199286);
      this.CLb = new LinkedList();
      AppMethodBeat.o(199286);
    }
    
    public static a aT(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(199287);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.CLb;
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
              t.eFx().aEJ(localag.field_pref_key);
              t.eFx().insert(localag);
            }
            localLinkedList.add(localag);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.CLc = aU((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.CLd = aU(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          ad.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(199287);
      return locala;
    }
    
    private static dmo aU(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(199288);
      dmo localdmo = new dmo();
      if (paramJSONObject != null)
      {
        localdmo.FBS = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localdmo.HAN;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              dml localdml = new dml();
              if (localJSONObject1 != null)
              {
                localdml.HAF = localJSONObject1.optLong("color");
                localdml.xNN = localJSONObject1.optString("font");
                localdml.text = localJSONObject1.optString("text");
                localdml.size = ((float)localJSONObject1.optLong("size"));
                localdml.HAG = localJSONObject1.optInt("text_attr");
                localdml.FBS = localJSONObject1.optString("view_id");
                Object localObject = new cwq();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((cwq)localObject).type = localJSONObject2.optInt("type");
                  ((cwq)localObject).url = localJSONObject2.optString("url");
                  dnb localdnb = new dnb();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localdnb.username = localJSONObject2.optString("username");
                    localdnb.path = localJSONObject2.optString("path");
                    localdnb.version = localJSONObject2.optInt("version");
                    ((cwq)localObject).Hou = localdnb;
                  }
                }
                localdml.FsR = ((cwq)localObject);
                localObject = new afl();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((afl)localObject).Gdv = localJSONObject1.optLong("normal_color");
                  ((afl)localObject).Gdw = localJSONObject1.optLong("dark_mode_color");
                  localdml.HAH = ((afl)localObject);
                }
              }
              localLinkedList.add(localdml);
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
      AppMethodBeat.o(199288);
      return localdmo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.m
 * JD-Core Version:    0.7.0.1
 */