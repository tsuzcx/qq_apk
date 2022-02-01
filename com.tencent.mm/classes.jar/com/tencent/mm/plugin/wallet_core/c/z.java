package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.aa;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends m
{
  public List<ElementQuery> VxZ;
  public ElementQuery Vya;
  private int Vyb;
  private int Vyc;
  private int Vyd;
  public int Vye;
  public String[] Vyf;
  public ArrayList<a> Vyg;
  public String mBankType;
  public Profession[] mProfessions;
  public String mTimeStamp;
  public String wrg;
  
  public z()
  {
    this(null, null, null, null, -1, -1, 0, (byte)0);
  }
  
  public z(String paramString1, String paramString2, PayInfo paramPayInfo)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, -1, 0, (byte)0);
  }
  
  public z(String paramString1, String paramString2, PayInfo paramPayInfo, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, paramInt1, paramInt2, (byte)0);
  }
  
  public z(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString1, paramString2, paramPayInfo, paramString3, paramInt1, paramInt2, paramInt3, (byte)0);
  }
  
  private z(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    AppMethodBeat.i(69943);
    this.VxZ = null;
    this.Vya = null;
    this.mTimeStamp = null;
    this.wrg = null;
    this.mBankType = null;
    this.Vyb = 3;
    this.mProfessions = null;
    this.Vyf = null;
    this.wrg = paramString2;
    this.Vyb = 3;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
    localHashMap1.put("req_key", paramString1);
    localHashMap1.put("flag", "4");
    localHashMap1.put("card_id", paramString2);
    if (paramInt2 > 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt2));
      Log.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 == 8) {
      localHashMap1.put("scene", "1003");
    }
    localHashMap1.put("bank_card_tag", "3");
    localHashMap1.put("token", paramString3);
    localHashMap1.put("newrealname", String.valueOf(paramInt3));
    setRequestData(localHashMap1);
    if (aa.jOO())
    {
      localHashMap2.put("uuid_for_bindcard", aa.getBindCardUuid());
      localHashMap2.put("bindcard_scene", aa.jOP());
    }
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69943);
  }
  
  public final int getFuncId()
  {
    return 1505;
  }
  
  public final int getTenpayCgicmd()
  {
    return 73;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
  }
  
  public final boolean ihM()
  {
    return this.Vyc == 1;
  }
  
  public final boolean ihN()
  {
    return this.Vyd == 1;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69944);
    this.VxZ = new ArrayList();
    label65:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      String str;
      try
      {
        this.mTimeStamp = paramJSONObject.optString("time_stamp");
        paramString = paramJSONObject.optString("bank_type");
        if (Util.isNullOrNil(this.mBankType)) {
          break label1212;
        }
        paramString = this.mBankType;
        localObject1 = paramJSONObject.getJSONArray("Array");
        i = ((JSONArray)localObject1).length();
        paramInt = 0;
        if (paramInt >= i) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
        localObject3 = new ElementQuery();
        ((ElementQuery)localObject3).hcG = ((JSONObject)localObject2);
        ((ElementQuery)localObject3).JFk = ((JSONObject)localObject2).optString("bank_name");
        ((ElementQuery)localObject3).hAk = ((JSONObject)localObject2).optString("bank_type");
        ((ElementQuery)localObject3).VFg = ((JSONObject)localObject2).optString("bankacc_type_name");
        ((ElementQuery)localObject3).VFi = ((JSONObject)localObject2).optString("bank_phone");
        ((ElementQuery)localObject3).VFl = ((JSONObject)localObject2).optString("forbid_word");
        ((ElementQuery)localObject3).VFk = ((JSONObject)localObject2).optString("bank_recommend_desc");
        ((ElementQuery)localObject3).VFj = ((JSONObject)localObject2).optString("bank_app_user_name");
        ((ElementQuery)localObject3).VFf = ((JSONObject)localObject2).optInt("bankacc_type", 1);
        ((ElementQuery)localObject3).VEX = i.u((JSONObject)localObject2, "canModifyName");
        ((ElementQuery)localObject3).VEY = i.u((JSONObject)localObject2, "canModifyCreID");
        ((ElementQuery)localObject3).VFd = "0".equals(((JSONObject)localObject2).optString("is_sure"));
        ((ElementQuery)localObject3).VEZ = "1".equals(((JSONObject)localObject2).optString("needCVV"));
        ((ElementQuery)localObject3).VFa = "1".equals(((JSONObject)localObject2).optString("needValiDate"));
        ((ElementQuery)localObject3).VEW = ((JSONObject)localObject2).optString("time_stamp");
        ((ElementQuery)localObject3).VFc = ((JSONObject)localObject2).optString("uesr_name");
        ((ElementQuery)localObject3).VFh = ((JSONObject)localObject2).optString("bank_flag");
        ((ElementQuery)localObject3).VFm = i.u((JSONObject)localObject2, "needFirstName");
        ((ElementQuery)localObject3).VFn = i.u((JSONObject)localObject2, "needLastName");
        ((ElementQuery)localObject3).VFo = i.u((JSONObject)localObject2, "needCountry");
        ((ElementQuery)localObject3).VFp = i.u((JSONObject)localObject2, "needArea");
        ((ElementQuery)localObject3).VFq = i.u((JSONObject)localObject2, "needCity");
        ((ElementQuery)localObject3).VFr = i.u((JSONObject)localObject2, "needAddress");
        ((ElementQuery)localObject3).VFs = i.u((JSONObject)localObject2, "needZip");
        ((ElementQuery)localObject3).VFt = i.u((JSONObject)localObject2, "needPhone");
        ((ElementQuery)localObject3).VFu = i.u((JSONObject)localObject2, "needEmail");
        ((ElementQuery)localObject3).VFx = i.u((JSONObject)localObject2, "needShowProtocol");
        ((ElementQuery)localObject3).VFv = ((JSONObject)localObject2).optString("support_cre_type");
        ((ElementQuery)localObject3).VFb = ((JSONObject)localObject2).optString("cre_id");
        ((ElementQuery)localObject3).Vyb = ((JSONObject)localObject2).optInt("bank_card_tag", 1);
        if (((ElementQuery)localObject3).Vyb != 1) {
          break label682;
        }
        if (!i.u((JSONObject)localObject2, "IsSaveYfq"))
        {
          ((ElementQuery)localObject3).VFe = 0;
          str = ((JSONObject)localObject2).optString("support_micropay");
          if (!TextUtils.isEmpty(str)) {
            break label712;
          }
          ((ElementQuery)localObject3).VFB = true;
          ((ElementQuery)localObject3).VCG = ((JSONObject)localObject2).optString("arrive_type");
          ((ElementQuery)localObject3).VFy = ((JSONObject)localObject2).optString("pre_auth_word");
          ((ElementQuery)localObject3).VFz = ((JSONObject)localObject2).optInt("support_foreign_mobile", 0);
          ((ElementQuery)localObject3).VFA = ElementQuery.cm((JSONObject)localObject2);
          if (Bankcard.mU(this.Vyb, ((ElementQuery)localObject3).Vyb)) {
            this.VxZ.add(localObject3);
          }
          if ((paramString == null) || (!paramString.equals(((ElementQuery)localObject3).hAk))) {
            break label1215;
          }
          this.Vya = ((ElementQuery)localObject3);
          break label1215;
        }
        if (i.u((JSONObject)localObject2, "canReturnYfq"))
        {
          ((ElementQuery)localObject3).VFe = 4;
          continue;
        }
        ((ElementQuery)localObject3).VFe = 3;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.NetSenceTenPayBase", paramString, "", new Object[0]);
        AppMethodBeat.o(69944);
        return;
      }
      continue;
      label682:
      if (((JSONObject)localObject2).optInt("auth_mode") == 1)
      {
        ((ElementQuery)localObject3).VFe = 1;
      }
      else
      {
        ((ElementQuery)localObject3).VFe = 2;
        continue;
        label712:
        if ("1".equals(str)) {
          ((ElementQuery)localObject3).VFB = true;
        } else if ("0".equals(str)) {
          ((ElementQuery)localObject3).VFB = false;
        }
      }
    }
    paramString = new SparseArray();
    Object localObject1 = paramJSONObject.getJSONArray("cre_type_map");
    int i = ((JSONArray)localObject1).length();
    paramInt = 0;
    label778:
    if (paramInt < i)
    {
      localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
      int j = ((JSONObject)localObject2).optInt("key", 0);
      if (j > 0) {
        paramString.put(j, ((JSONObject)localObject2).getString("val"));
      }
    }
    else
    {
      this.Vyc = paramJSONObject.optInt("need_area");
      this.Vyd = paramJSONObject.optInt("need_profession");
      if ((this.Vya != null) && (this.Vya.Vyb != 1))
      {
        Log.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
        this.Vyc = 0;
        this.Vyd = 0;
      }
      localObject1 = paramJSONObject.optJSONArray("profession_array");
      if (localObject1 != null)
      {
        this.mProfessions = new Profession[((JSONArray)localObject1).length()];
        paramInt = 0;
        label911:
        if (paramInt < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt);
          if (localObject2 == null) {
            break label1229;
          }
          localObject3 = ((JSONObject)localObject2).optString("profession_name");
          i = ((JSONObject)localObject2).optInt("profession_type");
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject2 = new Profession((String)localObject3, i);
            this.mProfessions[paramInt] = localObject2;
            break label1229;
          }
          Log.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
          break label1229;
        }
      }
      this.Vye = paramJSONObject.optInt("need_nationality", 0);
      localObject1 = paramJSONObject.optJSONArray("nationality_exclude_array");
      if (localObject1 != null)
      {
        this.Vyf = new String[((JSONArray)localObject1).length()];
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(paramInt);
          this.Vyf[paramInt] = localObject2;
          paramInt += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("bank_card_info");
      if (paramJSONObject != null)
      {
        this.Vyg = new ArrayList();
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (paramInt < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.optJSONObject(paramInt);
        if (localObject1 != null)
        {
          localObject2 = new a();
          ((a)localObject2).hAk = ((JSONObject)localObject1).optString("bank_type");
          ((a)localObject2).VBu = ((JSONObject)localObject1).optString("mobile_hint");
          ((a)localObject2).VBv = ((JSONObject)localObject1).optString("mobile_tips");
          this.Vyg.add(localObject2);
        }
      }
      else
      {
        paramJSONObject = u.iiK();
        localObject1 = this.VxZ;
        localObject2 = this.Vyg;
        paramJSONObject.VJx = paramString;
        paramJSONObject.VxZ = ((List)localObject1);
        paramJSONObject.VJy = ((List)localObject2);
        AppMethodBeat.o(69944);
        return;
        label1212:
        break;
        label1215:
        paramInt += 1;
        break label65;
        paramInt += 1;
        break label778;
        label1229:
        paramInt += 1;
        break label911;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.z
 * JD-Core Version:    0.7.0.1
 */