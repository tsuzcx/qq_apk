package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y
  extends m
{
  public List<ElementQuery> HQe;
  public ElementQuery HQf;
  private int HQg;
  private int HQh;
  private int HQi;
  public int HQj;
  public String[] HQk;
  public ArrayList<a> HQl;
  public String mBankType;
  public Profession[] mProfessions;
  public String mTimeStamp;
  public String pQH;
  
  public y()
  {
    this(null, null, null, null, -1, -1, 0, (byte)0);
  }
  
  public y(String paramString1, String paramString2, PayInfo paramPayInfo)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, -1, 0, (byte)0);
  }
  
  public y(String paramString1, String paramString2, PayInfo paramPayInfo, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, paramInt1, paramInt2, (byte)0);
  }
  
  public y(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString1, paramString2, paramPayInfo, paramString3, paramInt1, paramInt2, paramInt3, (byte)0);
  }
  
  private y(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    AppMethodBeat.i(69943);
    this.HQe = null;
    this.HQf = null;
    this.mTimeStamp = null;
    this.pQH = null;
    this.mBankType = null;
    this.HQg = 3;
    this.mProfessions = null;
    this.HQk = null;
    this.pQH = paramString2;
    this.HQg = 3;
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
    if (z.hhq())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.hhr());
    }
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69943);
  }
  
  public final boolean fPS()
  {
    return this.HQh == 1;
  }
  
  public final boolean fPT()
  {
    return this.HQi == 1;
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
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(69944);
    this.HQe = new ArrayList();
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
        ((ElementQuery)localObject3).dhz = ((JSONObject)localObject2);
        ((ElementQuery)localObject3).ynT = ((JSONObject)localObject2).optString("bank_name");
        ((ElementQuery)localObject3).dDj = ((JSONObject)localObject2).optString("bank_type");
        ((ElementQuery)localObject3).HXm = ((JSONObject)localObject2).optString("bankacc_type_name");
        ((ElementQuery)localObject3).HXo = ((JSONObject)localObject2).optString("bank_phone");
        ((ElementQuery)localObject3).HXr = ((JSONObject)localObject2).optString("forbid_word");
        ((ElementQuery)localObject3).HXq = ((JSONObject)localObject2).optString("bank_recommend_desc");
        ((ElementQuery)localObject3).HXp = ((JSONObject)localObject2).optString("bank_app_user_name");
        ((ElementQuery)localObject3).HXl = ((JSONObject)localObject2).optInt("bankacc_type", 1);
        ((ElementQuery)localObject3).HXd = f.q((JSONObject)localObject2, "canModifyName");
        ((ElementQuery)localObject3).HXe = f.q((JSONObject)localObject2, "canModifyCreID");
        ((ElementQuery)localObject3).HXj = "0".equals(((JSONObject)localObject2).optString("is_sure"));
        ((ElementQuery)localObject3).HXf = "1".equals(((JSONObject)localObject2).optString("needCVV"));
        ((ElementQuery)localObject3).HXg = "1".equals(((JSONObject)localObject2).optString("needValiDate"));
        ((ElementQuery)localObject3).HXc = ((JSONObject)localObject2).optString("time_stamp");
        ((ElementQuery)localObject3).HXi = ((JSONObject)localObject2).optString("uesr_name");
        ((ElementQuery)localObject3).HXn = ((JSONObject)localObject2).optString("bank_flag");
        ((ElementQuery)localObject3).HXs = f.q((JSONObject)localObject2, "needFirstName");
        ((ElementQuery)localObject3).HXt = f.q((JSONObject)localObject2, "needLastName");
        ((ElementQuery)localObject3).HXu = f.q((JSONObject)localObject2, "needCountry");
        ((ElementQuery)localObject3).HXv = f.q((JSONObject)localObject2, "needArea");
        ((ElementQuery)localObject3).HXw = f.q((JSONObject)localObject2, "needCity");
        ((ElementQuery)localObject3).HXx = f.q((JSONObject)localObject2, "needAddress");
        ((ElementQuery)localObject3).HXy = f.q((JSONObject)localObject2, "needZip");
        ((ElementQuery)localObject3).HXz = f.q((JSONObject)localObject2, "needPhone");
        ((ElementQuery)localObject3).HXA = f.q((JSONObject)localObject2, "needEmail");
        ((ElementQuery)localObject3).HXD = f.q((JSONObject)localObject2, "needShowProtocol");
        ((ElementQuery)localObject3).HXB = ((JSONObject)localObject2).optString("support_cre_type");
        ((ElementQuery)localObject3).HXh = ((JSONObject)localObject2).optString("cre_id");
        ((ElementQuery)localObject3).HQg = ((JSONObject)localObject2).optInt("bank_card_tag", 1);
        if (((ElementQuery)localObject3).HQg != 1) {
          break label682;
        }
        if (!f.q((JSONObject)localObject2, "IsSaveYfq"))
        {
          ((ElementQuery)localObject3).HXk = 0;
          str = ((JSONObject)localObject2).optString("support_micropay");
          if (!TextUtils.isEmpty(str)) {
            break label712;
          }
          ((ElementQuery)localObject3).HXH = true;
          ((ElementQuery)localObject3).HUU = ((JSONObject)localObject2).optString("arrive_type");
          ((ElementQuery)localObject3).HXE = ((JSONObject)localObject2).optString("pre_auth_word");
          ((ElementQuery)localObject3).HXF = ((JSONObject)localObject2).optInt("support_foreign_mobile", 0);
          ((ElementQuery)localObject3).HXG = ElementQuery.bG((JSONObject)localObject2);
          if (Bankcard.jT(this.HQg, ((ElementQuery)localObject3).HQg)) {
            this.HQe.add(localObject3);
          }
          if ((paramString == null) || (!paramString.equals(((ElementQuery)localObject3).dDj))) {
            break label1215;
          }
          this.HQf = ((ElementQuery)localObject3);
          break label1215;
        }
        if (f.q((JSONObject)localObject2, "canReturnYfq"))
        {
          ((ElementQuery)localObject3).HXk = 4;
          continue;
        }
        ((ElementQuery)localObject3).HXk = 3;
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
        ((ElementQuery)localObject3).HXk = 1;
      }
      else
      {
        ((ElementQuery)localObject3).HXk = 2;
        continue;
        label712:
        if ("1".equals(str)) {
          ((ElementQuery)localObject3).HXH = true;
        } else if ("0".equals(str)) {
          ((ElementQuery)localObject3).HXH = false;
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
      this.HQh = paramJSONObject.optInt("need_area");
      this.HQi = paramJSONObject.optInt("need_profession");
      if ((this.HQf != null) && (this.HQf.HQg != 1))
      {
        Log.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
        this.HQh = 0;
        this.HQi = 0;
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
      this.HQj = paramJSONObject.optInt("need_nationality", 0);
      localObject1 = paramJSONObject.optJSONArray("nationality_exclude_array");
      if (localObject1 != null)
      {
        this.HQk = new String[((JSONArray)localObject1).length()];
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(paramInt);
          this.HQk[paramInt] = localObject2;
          paramInt += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("bank_card_info");
      if (paramJSONObject != null)
      {
        this.HQl = new ArrayList();
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
          ((a)localObject2).dDj = ((JSONObject)localObject1).optString("bank_type");
          ((a)localObject2).HTB = ((JSONObject)localObject1).optString("mobile_hint");
          ((a)localObject2).HTC = ((JSONObject)localObject1).optString("mobile_tips");
          this.HQl.add(localObject2);
        }
      }
      else
      {
        paramJSONObject = t.fQQ();
        localObject1 = this.HQe;
        localObject2 = this.HQl;
        paramJSONObject.Ibf = paramString;
        paramJSONObject.HQe = ((List)localObject1);
        paramJSONObject.Ibg = ((List)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */