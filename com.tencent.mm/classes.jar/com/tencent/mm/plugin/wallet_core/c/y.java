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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public List<ElementQuery> DgL;
  public ElementQuery DgM;
  private int DgN;
  private int DgO;
  private int DgP;
  public int DgQ;
  public String[] DgR;
  public ArrayList<a> DgS;
  public String mBankType;
  public Profession[] mProfessions;
  public String mTimeStamp;
  public String oCY;
  
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
    this.DgL = null;
    this.DgM = null;
    this.mTimeStamp = null;
    this.oCY = null;
    this.mBankType = null;
    this.DgN = 3;
    this.mProfessions = null;
    this.DgR = null;
    this.oCY = paramString2;
    this.DgN = 3;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
    localHashMap1.put("req_key", paramString1);
    localHashMap1.put("flag", "4");
    localHashMap1.put("card_id", paramString2);
    if (paramInt2 > 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt2));
      ae.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 == 8) {
      localHashMap1.put("scene", "1003");
    }
    localHashMap1.put("bank_card_tag", "3");
    localHashMap1.put("token", paramString3);
    localHashMap1.put("newrealname", String.valueOf(paramInt3));
    setRequestData(localHashMap1);
    if (z.fVT())
    {
      localHashMap2.put("uuid_for_bindcard", z.getBindCardUuid());
      localHashMap2.put("bindcard_scene", z.fVU());
    }
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(69943);
  }
  
  public final boolean eIp()
  {
    return this.DgO == 1;
  }
  
  public final boolean eIq()
  {
    return this.DgP == 1;
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
    this.DgL = new ArrayList();
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
        if (bu.isNullOrNil(this.mBankType)) {
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
        ((ElementQuery)localObject3).cRf = ((JSONObject)localObject2);
        ((ElementQuery)localObject3).uVs = ((JSONObject)localObject2).optString("bank_name");
        ((ElementQuery)localObject3).dlT = ((JSONObject)localObject2).optString("bank_type");
        ((ElementQuery)localObject3).DnU = ((JSONObject)localObject2).optString("bankacc_type_name");
        ((ElementQuery)localObject3).DnW = ((JSONObject)localObject2).optString("bank_phone");
        ((ElementQuery)localObject3).DnZ = ((JSONObject)localObject2).optString("forbid_word");
        ((ElementQuery)localObject3).DnY = ((JSONObject)localObject2).optString("bank_recommend_desc");
        ((ElementQuery)localObject3).DnX = ((JSONObject)localObject2).optString("bank_app_user_name");
        ((ElementQuery)localObject3).DnT = ((JSONObject)localObject2).optInt("bankacc_type", 1);
        ((ElementQuery)localObject3).DnL = f.m((JSONObject)localObject2, "canModifyName");
        ((ElementQuery)localObject3).DnM = f.m((JSONObject)localObject2, "canModifyCreID");
        ((ElementQuery)localObject3).DnR = "0".equals(((JSONObject)localObject2).optString("is_sure"));
        ((ElementQuery)localObject3).DnN = "1".equals(((JSONObject)localObject2).optString("needCVV"));
        ((ElementQuery)localObject3).DnO = "1".equals(((JSONObject)localObject2).optString("needValiDate"));
        ((ElementQuery)localObject3).DnK = ((JSONObject)localObject2).optString("time_stamp");
        ((ElementQuery)localObject3).DnQ = ((JSONObject)localObject2).optString("uesr_name");
        ((ElementQuery)localObject3).DnV = ((JSONObject)localObject2).optString("bank_flag");
        ((ElementQuery)localObject3).Doa = f.m((JSONObject)localObject2, "needFirstName");
        ((ElementQuery)localObject3).Dob = f.m((JSONObject)localObject2, "needLastName");
        ((ElementQuery)localObject3).Doc = f.m((JSONObject)localObject2, "needCountry");
        ((ElementQuery)localObject3).Dod = f.m((JSONObject)localObject2, "needArea");
        ((ElementQuery)localObject3).Doe = f.m((JSONObject)localObject2, "needCity");
        ((ElementQuery)localObject3).Dof = f.m((JSONObject)localObject2, "needAddress");
        ((ElementQuery)localObject3).Dog = f.m((JSONObject)localObject2, "needZip");
        ((ElementQuery)localObject3).Doh = f.m((JSONObject)localObject2, "needPhone");
        ((ElementQuery)localObject3).Doi = f.m((JSONObject)localObject2, "needEmail");
        ((ElementQuery)localObject3).Dol = f.m((JSONObject)localObject2, "needShowProtocol");
        ((ElementQuery)localObject3).Doj = ((JSONObject)localObject2).optString("support_cre_type");
        ((ElementQuery)localObject3).DnP = ((JSONObject)localObject2).optString("cre_id");
        ((ElementQuery)localObject3).DgN = ((JSONObject)localObject2).optInt("bank_card_tag", 1);
        if (((ElementQuery)localObject3).DgN != 1) {
          break label682;
        }
        if (!f.m((JSONObject)localObject2, "IsSaveYfq"))
        {
          ((ElementQuery)localObject3).DnS = 0;
          str = ((JSONObject)localObject2).optString("support_micropay");
          if (!TextUtils.isEmpty(str)) {
            break label712;
          }
          ((ElementQuery)localObject3).Dop = true;
          ((ElementQuery)localObject3).DlB = ((JSONObject)localObject2).optString("arrive_type");
          ((ElementQuery)localObject3).Dom = ((JSONObject)localObject2).optString("pre_auth_word");
          ((ElementQuery)localObject3).Don = ((JSONObject)localObject2).optInt("support_foreign_mobile", 0);
          ((ElementQuery)localObject3).Doo = ElementQuery.bg((JSONObject)localObject2);
          if (Bankcard.iN(this.DgN, ((ElementQuery)localObject3).DgN)) {
            this.DgL.add(localObject3);
          }
          if ((paramString == null) || (!paramString.equals(((ElementQuery)localObject3).dlT))) {
            break label1215;
          }
          this.DgM = ((ElementQuery)localObject3);
          break label1215;
        }
        if (f.m((JSONObject)localObject2, "canReturnYfq"))
        {
          ((ElementQuery)localObject3).DnS = 4;
          continue;
        }
        ((ElementQuery)localObject3).DnS = 3;
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("MicroMsg.NetSenceTenPayBase", paramString, "", new Object[0]);
        AppMethodBeat.o(69944);
        return;
      }
      continue;
      label682:
      if (((JSONObject)localObject2).optInt("auth_mode") == 1)
      {
        ((ElementQuery)localObject3).DnS = 1;
      }
      else
      {
        ((ElementQuery)localObject3).DnS = 2;
        continue;
        label712:
        if ("1".equals(str)) {
          ((ElementQuery)localObject3).Dop = true;
        } else if ("0".equals(str)) {
          ((ElementQuery)localObject3).Dop = false;
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
      this.DgO = paramJSONObject.optInt("need_area");
      this.DgP = paramJSONObject.optInt("need_profession");
      if ((this.DgM != null) && (this.DgM.DgN != 1))
      {
        ae.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
        this.DgO = 0;
        this.DgP = 0;
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
          if (!bu.isNullOrNil((String)localObject3))
          {
            localObject2 = new Profession((String)localObject3, i);
            this.mProfessions[paramInt] = localObject2;
            break label1229;
          }
          ae.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
          break label1229;
        }
      }
      this.DgQ = paramJSONObject.optInt("need_nationality", 0);
      localObject1 = paramJSONObject.optJSONArray("nationality_exclude_array");
      if (localObject1 != null)
      {
        this.DgR = new String[((JSONArray)localObject1).length()];
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(paramInt);
          this.DgR[paramInt] = localObject2;
          paramInt += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("bank_card_info");
      if (paramJSONObject != null)
      {
        this.DgS = new ArrayList();
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
          ((a)localObject2).dlT = ((JSONObject)localObject1).optString("bank_type");
          ((a)localObject2).Dki = ((JSONObject)localObject1).optString("mobile_hint");
          ((a)localObject2).Dkj = ((JSONObject)localObject1).optString("mobile_tips");
          this.DgS.add(localObject2);
        }
      }
      else
      {
        paramJSONObject = t.eJn();
        localObject1 = this.DgL;
        localObject2 = this.DgS;
        paramJSONObject.DrT = paramString;
        paramJSONObject.DgL = ((List)localObject1);
        paramJSONObject.DrU = ((List)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.y
 * JD-Core Version:    0.7.0.1
 */