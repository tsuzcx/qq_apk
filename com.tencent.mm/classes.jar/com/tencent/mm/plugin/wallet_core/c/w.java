package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class w
  extends m
{
  public String kkW;
  public Profession[] mProfessions;
  public String mTimeStamp;
  public String qib;
  public List<ElementQuery> ubS;
  public ElementQuery ubT;
  private int ubU;
  private int ubV;
  private int ubW;
  public int ubX;
  public String[] ubY;
  
  public w()
  {
    this(null, null, null, null, -1, -1, 0, (byte)0);
  }
  
  public w(String paramString1, String paramString2, PayInfo paramPayInfo)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, -1, 0, (byte)0);
  }
  
  public w(String paramString1, String paramString2, PayInfo paramPayInfo, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, paramInt1, paramInt2, (byte)0);
  }
  
  public w(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramString1, paramString2, paramPayInfo, paramString3, paramInt1, paramInt2, paramInt3, (byte)0);
  }
  
  private w(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    AppMethodBeat.i(155637);
    this.ubS = null;
    this.ubT = null;
    this.mTimeStamp = null;
    this.kkW = null;
    this.qib = null;
    this.ubU = 3;
    this.mProfessions = null;
    this.ubY = null;
    this.kkW = paramString2;
    this.ubU = 3;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    setPayInfo(paramPayInfo, localHashMap1, localHashMap2);
    localHashMap1.put("req_key", paramString1);
    localHashMap1.put("flag", "4");
    localHashMap1.put("card_id", paramString2);
    if (paramInt2 > 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt2));
      ab.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 == 8) {
      localHashMap1.put("scene", "1003");
    }
    localHashMap1.put("bank_card_tag", "3");
    localHashMap1.put("token", paramString3);
    localHashMap1.put("newrealname", String.valueOf(paramInt3));
    setRequestData(localHashMap1);
    if (x.dSp())
    {
      localHashMap2.put("uuid_for_bindcard", x.dSr());
      localHashMap2.put("bindcard_scene", x.dSq());
    }
    setWXRequestData(localHashMap2);
    AppMethodBeat.o(155637);
  }
  
  public final boolean cSY()
  {
    return this.ubV == 1;
  }
  
  public final boolean cSZ()
  {
    return this.ubW == 1;
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
    AppMethodBeat.i(46539);
    this.ubS = new ArrayList();
    label65:
    Object localObject2;
    for (;;)
    {
      ElementQuery localElementQuery;
      String str;
      try
      {
        this.mTimeStamp = paramJSONObject.optString("time_stamp");
        paramString = paramJSONObject.optString("bank_type");
        if (bo.isNullOrNil(this.qib)) {
          break label1086;
        }
        paramString = this.qib;
        localObject1 = paramJSONObject.getJSONArray("Array");
        i = ((JSONArray)localObject1).length();
        paramInt = 0;
        if (paramInt >= i) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
        localElementQuery = new ElementQuery();
        localElementQuery.fvc = ((JSONObject)localObject2);
        localElementQuery.nLq = ((JSONObject)localObject2).optString("bank_name");
        localElementQuery.poq = ((JSONObject)localObject2).optString("bank_type");
        localElementQuery.uhy = ((JSONObject)localObject2).optString("bankacc_type_name");
        localElementQuery.uhA = ((JSONObject)localObject2).optString("bank_phone");
        localElementQuery.uhD = ((JSONObject)localObject2).optString("forbid_word");
        localElementQuery.uhC = ((JSONObject)localObject2).optString("bank_recommend_desc");
        localElementQuery.uhB = ((JSONObject)localObject2).optString("bank_app_user_name");
        localElementQuery.uhx = ((JSONObject)localObject2).optInt("bankacc_type", 1);
        localElementQuery.uhp = e.n((JSONObject)localObject2, "canModifyName");
        localElementQuery.uhq = e.n((JSONObject)localObject2, "canModifyCreID");
        localElementQuery.uhv = "0".equals(((JSONObject)localObject2).optString("is_sure"));
        localElementQuery.uhr = "1".equals(((JSONObject)localObject2).optString("needCVV"));
        localElementQuery.uhs = "1".equals(((JSONObject)localObject2).optString("needValiDate"));
        localElementQuery.uho = ((JSONObject)localObject2).optString("time_stamp");
        localElementQuery.uhu = ((JSONObject)localObject2).optString("uesr_name");
        localElementQuery.uhz = ((JSONObject)localObject2).optString("bank_flag");
        localElementQuery.uhE = e.n((JSONObject)localObject2, "needFirstName");
        localElementQuery.uhF = e.n((JSONObject)localObject2, "needLastName");
        localElementQuery.uhG = e.n((JSONObject)localObject2, "needCountry");
        localElementQuery.uhH = e.n((JSONObject)localObject2, "needArea");
        localElementQuery.uhI = e.n((JSONObject)localObject2, "needCity");
        localElementQuery.uhJ = e.n((JSONObject)localObject2, "needAddress");
        localElementQuery.uhK = e.n((JSONObject)localObject2, "needZip");
        localElementQuery.uhL = e.n((JSONObject)localObject2, "needPhone");
        localElementQuery.uhM = e.n((JSONObject)localObject2, "needEmail");
        localElementQuery.uhP = e.n((JSONObject)localObject2, "needShowProtocol");
        localElementQuery.uhN = ((JSONObject)localObject2).optString("support_cre_type");
        localElementQuery.uht = ((JSONObject)localObject2).optString("cre_id");
        localElementQuery.ubU = ((JSONObject)localObject2).optInt("bank_card_tag", 1);
        if (localElementQuery.ubU != 1) {
          break label682;
        }
        if (!e.n((JSONObject)localObject2, "IsSaveYfq"))
        {
          localElementQuery.uhw = 0;
          str = ((JSONObject)localObject2).optString("support_micropay");
          if (!TextUtils.isEmpty(str)) {
            break label712;
          }
          localElementQuery.uhT = true;
          localElementQuery.ufd = ((JSONObject)localObject2).optString("arrive_type");
          localElementQuery.uhQ = ((JSONObject)localObject2).optString("pre_auth_word");
          localElementQuery.uhR = ((JSONObject)localObject2).optInt("support_foreign_mobile", 0);
          localElementQuery.uhS = ElementQuery.aC((JSONObject)localObject2);
          if (Bankcard.gx(this.ubU, localElementQuery.ubU)) {
            this.ubS.add(localElementQuery);
          }
          if ((paramString == null) || (!paramString.equals(localElementQuery.poq))) {
            break label1089;
          }
          this.ubT = localElementQuery;
          break label1089;
        }
        if (e.n((JSONObject)localObject2, "canReturnYfq"))
        {
          localElementQuery.uhw = 4;
          continue;
        }
        localElementQuery.uhw = 3;
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.NetSenceTenPayBase", paramString, "", new Object[0]);
        AppMethodBeat.o(46539);
        return;
      }
      continue;
      label682:
      if (((JSONObject)localObject2).optInt("auth_mode") == 1)
      {
        localElementQuery.uhw = 1;
      }
      else
      {
        localElementQuery.uhw = 2;
        continue;
        label712:
        if ("1".equals(str)) {
          localElementQuery.uhT = true;
        } else if ("0".equals(str)) {
          localElementQuery.uhT = false;
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
      localObject1 = t.cTV();
      localObject2 = this.ubS;
      ((v)localObject1).ulh = paramString;
      ((v)localObject1).ubS = ((List)localObject2);
      this.ubV = paramJSONObject.optInt("need_area");
      this.ubW = paramJSONObject.optInt("need_profession");
      if ((this.ubT != null) && (this.ubT.ubU != 1))
      {
        ab.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
        this.ubV = 0;
        this.ubW = 0;
      }
      paramString = paramJSONObject.optJSONArray("profession_array");
      if (paramString != null)
      {
        this.mProfessions = new Profession[paramString.length()];
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        localObject1 = paramString.optJSONObject(paramInt);
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("profession_name");
          i = ((JSONObject)localObject1).optInt("profession_type");
          if (!bo.isNullOrNil((String)localObject2))
          {
            localObject1 = new Profession((String)localObject2, i);
            this.mProfessions[paramInt] = localObject1;
          }
          else
          {
            ab.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
          }
        }
      }
      else
      {
        this.ubX = paramJSONObject.optInt("need_nationality", 0);
        paramString = paramJSONObject.optJSONArray("nationality_exclude_array");
        if (paramString != null)
        {
          this.ubY = new String[paramString.length()];
          paramInt = 0;
          while (paramInt < paramString.length())
          {
            paramJSONObject = paramString.optString(paramInt);
            this.ubY[paramInt] = paramJSONObject;
            paramInt += 1;
          }
        }
        AppMethodBeat.o(46539);
        return;
        label1086:
        break;
        label1089:
        paramInt += 1;
        break label65;
        paramInt += 1;
        break label778;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.w
 * JD-Core Version:    0.7.0.1
 */