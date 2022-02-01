package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fnf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends m
{
  public int Vpu;
  public String Vpv;
  public int Vpw;
  public String Vpx;
  public String Vpy;
  public String Vpz;
  
  public l()
  {
    AppMethodBeat.i(69559);
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceid", q.eD(false));
    setRequestData(localHashMap);
    AppMethodBeat.o(69559);
  }
  
  public static boolean dgl()
  {
    AppMethodBeat.i(315582);
    h.baF();
    long l = ((Long)h.baE().ban().get(at.a.acMG, Long.valueOf(0L))).longValue();
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acMH, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(i + l) });
    if (l > 0L)
    {
      if (new Date().getTime() / 1000L > l + i)
      {
        AppMethodBeat.o(315582);
        return true;
      }
      AppMethodBeat.o(315582);
      return false;
    }
    AppMethodBeat.o(315582);
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
  
  private static af q(JSONObject paramJSONObject, String paramString)
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
      this.Vpu = Util.getInt(paramString, 0);
      this.Vpv = paramJSONObject.optString("deduct_show_url", "");
      paramString = paramJSONObject.optString("deduct_cache_time", "");
      if (!isNumeric(paramString)) {
        break label695;
      }
      this.Vpw = Util.getInt(paramString, 0);
      this.Vpx = paramJSONObject.optString("deduct_title", "");
      this.Vpy = paramJSONObject.optString("realname_url", "");
      this.Vpz = paramJSONObject.optString("forget_pwd_url", "");
      paramString = paramJSONObject.optString("payway_select_wording", "");
      str = paramJSONObject.optString("payway_change_wording", "");
      Object localObject = new af();
      ((af)localObject).field_is_show = this.Vpu;
      ((af)localObject).field_pref_key = "wallet_open_auto_pay";
      ((af)localObject).field_pref_title = this.Vpx;
      ((af)localObject).field_pref_url = this.Vpv;
      ((af)localObject).field_jump_type = 1;
      u.iiB().bgX("wallet_open_auto_pay");
      Log.i("MicroMsg.NetSceneTenpayPayManager", "deductCacheTime %s forget_pwd_url %s", new Object[] { Integer.valueOf(this.Vpw), this.Vpz });
      u.iiB().insert((IAutoDBItem)localObject);
      localObject = paramJSONObject.optJSONObject("switch_wallet");
      if (localObject != null)
      {
        localObject = q((JSONObject)localObject, "wallet_switch_currency");
        u.iiB().bgX("wallet_switch_currency");
        u.iiB().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("im_mch");
      if (localObject != null)
      {
        localObject = q((JSONObject)localObject, "wallet_im_mch");
        u.iiB().bgX("wallet_im_mch");
        u.iiB().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONObject("deduct_manage");
      if (localObject != null)
      {
        localObject = q((JSONObject)localObject, "wallet_open_auto_pay");
        u.iiB().bgX("wallet_open_auto_pay");
        u.iiB().insert((IAutoDBItem)localObject);
      }
      localObject = paramJSONObject.optJSONArray("extra_sections");
      if (localObject == null) {
        break label702;
      }
      h.baF();
      h.baE().ban().set(at.a.acZv, ((JSONArray)localObject).toString());
      label450:
      localObject = paramJSONObject.optJSONObject("unreg_info");
      if (localObject == null) {
        break label724;
      }
      paramJSONObject = ((JSONObject)localObject).optString("unreg_title", "");
      localObject = ((JSONObject)localObject).optString("unreg_url", "");
      h.baF();
      h.baE().ban().set(at.a.acTT, paramJSONObject);
      h.baF();
      h.baE().ban().set(at.a.acTU, localObject);
    }
    for (;;)
    {
      h.baF();
      h.baE().ban().set(at.a.acMG, Long.valueOf(new Date().getTime() / 1000L));
      h.baF();
      h.baE().ban().set(at.a.acMH, Integer.valueOf(this.Vpw));
      h.baF();
      h.baE().ban().set(at.a.acMN, this.Vpy);
      h.baF();
      h.baE().ban().set(at.a.acMW, this.Vpz);
      if (!Util.isNullOrNil(paramString))
      {
        h.baF();
        h.baE().ban().set(at.a.acMU, paramString);
      }
      if (!Util.isNullOrNil(str))
      {
        h.baF();
        h.baE().ban().set(at.a.acMV, str);
      }
      h.baF();
      h.baE().ban().iZy();
      AppMethodBeat.o(69560);
      return;
      label689:
      paramString = "0";
      break;
      label695:
      paramString = "84600";
      break label114;
      label702:
      h.baF();
      h.baE().ban().set(at.a.acZv, " ");
      break label450;
      label724:
      h.baF();
      h.baE().ban().set(at.a.acTT, "");
      h.baF();
      h.baE().ban().set(at.a.acTU, "");
    }
  }
  
  public static final class a
  {
    public LinkedList<af> VpA;
    public fmp VpB;
    public fmp VpC;
    
    public a()
    {
      AppMethodBeat.i(315592);
      this.VpA = new LinkedList();
      AppMethodBeat.o(315592);
    }
    
    public static a bZ(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(315596);
      a locala = new a();
      try
      {
        Object localObject = paramJSONObject.optJSONArray("extra_labels");
        if (localObject != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            LinkedList localLinkedList = locala.VpA;
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
              u.iiB().bgX(localaf.field_pref_key);
              u.iiB().insert(localaf);
            }
            localLinkedList.add(localaf);
            i += 1;
          }
        }
        localObject = paramJSONObject.optJSONObject("header");
        if (localObject != null) {
          locala.VpB = ca((JSONObject)localObject);
        }
        paramJSONObject = paramJSONObject.optJSONObject("footer");
        if (paramJSONObject != null) {
          locala.VpC = ca(paramJSONObject);
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          Log.e("MicroMsg.NetSceneTenpayPayManager", " PayManageExtraSectionsData dcreateFromJSONObject Exception:%s", new Object[] { paramJSONObject.getMessage() });
        }
      }
      AppMethodBeat.o(315596);
      return locala;
    }
    
    private static fmp ca(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(315599);
      fmp localfmp = new fmp();
      if (paramJSONObject != null)
      {
        localfmp.YMe = paramJSONObject.optString("view_id");
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
              LinkedList localLinkedList = localfmp.abMT;
              JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
              fml localfml = new fml();
              if (localJSONObject1 != null)
              {
                localfml.ayn = localJSONObject1.optLong("color");
                localfml.mAD = localJSONObject1.optString("font");
                localfml.text = localJSONObject1.optString("text");
                localfml.size = ((float)localJSONObject1.optLong("size"));
                localfml.abMH = localJSONObject1.optInt("text_attr");
                localfml.YMe = localJSONObject1.optString("view_id");
                Object localObject = new etg();
                JSONObject localJSONObject2 = localJSONObject1.optJSONObject("route_info");
                if (localJSONObject2 != null)
                {
                  ((etg)localObject).type = localJSONObject2.optInt("type");
                  ((etg)localObject).url = localJSONObject2.optString("url");
                  fnf localfnf = new fnf();
                  localJSONObject2 = localJSONObject2.optJSONObject("tiny_app_uri");
                  if (localJSONObject2 != null)
                  {
                    localfnf.username = localJSONObject2.optString("username");
                    localfnf.path = localJSONObject2.optString("path");
                    localfnf.version = localJSONObject2.optInt("version");
                    ((etg)localObject).abwC = localfnf;
                  }
                }
                localfml.YCV = ((etg)localObject);
                localObject = new alg();
                localJSONObject1 = localJSONObject1.optJSONObject("dynamic_color");
                if (localJSONObject1 != null)
                {
                  ((alg)localObject).Zss = localJSONObject1.optLong("normal_color");
                  ((alg)localObject).Zst = localJSONObject1.optLong("dark_mode_color");
                  localfml.abMI = ((alg)localObject);
                }
              }
              localLinkedList.add(localfml);
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
      AppMethodBeat.o(315599);
      return localfmp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.l
 * JD-Core Version:    0.7.0.1
 */