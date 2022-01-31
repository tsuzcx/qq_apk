package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.v;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
  extends j
{
  public String ijW = null;
  public String mTimeStamp = null;
  public String nxa = null;
  public List<ElementQuery> qqW = null;
  public ElementQuery qqX = null;
  private int qqY = 3;
  private int qqZ;
  private int qra;
  public Profession[] qrb = null;
  
  public t()
  {
    this(null, null, null, null, -1, -1, (byte)0);
  }
  
  public t(String paramString1, String paramString2, PayInfo paramPayInfo)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, -1, (byte)0);
  }
  
  public t(String paramString1, String paramString2, PayInfo paramPayInfo, int paramInt)
  {
    this(paramString1, paramString2, paramPayInfo, null, -1, paramInt, (byte)0);
  }
  
  public t(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramString1, paramString2, paramPayInfo, paramString3, paramInt1, paramInt2, (byte)0);
  }
  
  private t(String paramString1, String paramString2, PayInfo paramPayInfo, String paramString3, int paramInt1, int paramInt2, byte paramByte)
  {
    this.ijW = paramString2;
    this.qqY = 3;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    a(paramPayInfo, localHashMap1, localHashMap2);
    localHashMap1.put("req_key", paramString1);
    localHashMap1.put("flag", "4");
    localHashMap1.put("card_id", paramString2);
    if (paramInt2 > 0)
    {
      localHashMap1.put("realname_scene", String.valueOf(paramInt2));
      y.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", new Object[] { Integer.valueOf(paramInt2) });
    }
    if (paramInt1 == 8) {
      localHashMap1.put("scene", "1003");
    }
    localHashMap1.put("bank_card_tag", "3");
    localHashMap1.put("token", paramString3);
    D(localHashMap1);
    if (v.cMA())
    {
      localHashMap2.put("uuid_for_bindcard", v.cMC());
      localHashMap2.put("bindcard_scene", v.cMB());
    }
    aC(localHashMap2);
  }
  
  public final int HH()
  {
    return 1505;
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.qqW = new ArrayList();
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    ElementQuery localElementQuery;
    label496:
    String str;
    try
    {
      this.mTimeStamp = paramJSONObject.optString("time_stamp");
      paramString = paramJSONObject.optString("bank_type");
      if (!bk.bl(this.nxa))
      {
        paramString = this.nxa;
        localObject1 = paramJSONObject.getJSONArray("Array");
        i = ((JSONArray)localObject1).length();
        paramInt = 0;
        if (paramInt < i)
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
          localElementQuery = new ElementQuery();
          localElementQuery.efa = ((JSONObject)localObject2);
          localElementQuery.lnT = ((JSONObject)localObject2).optString("bank_name");
          localElementQuery.mOb = ((JSONObject)localObject2).optString("bank_type");
          localElementQuery.qvg = ((JSONObject)localObject2).optString("bankacc_type_name");
          localElementQuery.qvi = ((JSONObject)localObject2).optString("bank_phone");
          localElementQuery.qvl = ((JSONObject)localObject2).optString("forbid_word");
          localElementQuery.qvk = ((JSONObject)localObject2).optString("bank_recommend_desc");
          localElementQuery.qvj = ((JSONObject)localObject2).optString("bank_app_user_name");
          localElementQuery.qvf = ((JSONObject)localObject2).optInt("bankacc_type", 1);
          localElementQuery.quX = e.o((JSONObject)localObject2, "canModifyName");
          localElementQuery.quY = e.o((JSONObject)localObject2, "canModifyCreID");
          localElementQuery.qvd = "0".equals(((JSONObject)localObject2).optString("is_sure"));
          localElementQuery.quZ = "1".equals(((JSONObject)localObject2).optString("needCVV"));
          localElementQuery.qva = "1".equals(((JSONObject)localObject2).optString("needValiDate"));
          localElementQuery.quW = ((JSONObject)localObject2).optString("time_stamp");
          localElementQuery.qvc = ((JSONObject)localObject2).optString("uesr_name");
          localElementQuery.qvh = ((JSONObject)localObject2).optString("bank_flag");
          localElementQuery.qvm = e.o((JSONObject)localObject2, "needFirstName");
          localElementQuery.qvn = e.o((JSONObject)localObject2, "needLastName");
          localElementQuery.qvo = e.o((JSONObject)localObject2, "needCountry");
          localElementQuery.qvp = e.o((JSONObject)localObject2, "needArea");
          localElementQuery.qvq = e.o((JSONObject)localObject2, "needCity");
          localElementQuery.qvr = e.o((JSONObject)localObject2, "needAddress");
          localElementQuery.qvs = e.o((JSONObject)localObject2, "needZip");
          localElementQuery.qvt = e.o((JSONObject)localObject2, "needPhone");
          localElementQuery.qvu = e.o((JSONObject)localObject2, "needEmail");
          localElementQuery.qvx = e.o((JSONObject)localObject2, "needShowProtocol");
          localElementQuery.qvv = ((JSONObject)localObject2).optString("support_cre_type");
          localElementQuery.qvb = ((JSONObject)localObject2).optString("cre_id");
          localElementQuery.qqY = ((JSONObject)localObject2).optInt("bank_card_tag", 1);
          if (localElementQuery.qqY == 1)
          {
            if (!e.o((JSONObject)localObject2, "IsSaveYfq")) {}
            for (localElementQuery.qve = 0;; localElementQuery.qve = 4)
            {
              str = ((JSONObject)localObject2).optString("support_micropay");
              if (!TextUtils.isEmpty(str)) {
                break label696;
              }
              localElementQuery.qvB = true;
              label520:
              localElementQuery.qsQ = ((JSONObject)localObject2).optString("arrive_type");
              localElementQuery.qvy = ((JSONObject)localObject2).optString("pre_auth_word");
              localElementQuery.qvz = ((JSONObject)localObject2).optInt("support_foreign_mobile", 0);
              localElementQuery.qvA = ElementQuery.aq((JSONObject)localObject2);
              if (Bankcard.eu(this.qqY, localElementQuery.qqY)) {
                this.qqW.add(localElementQuery);
              }
              if ((paramString == null) || (!paramString.equals(localElementQuery.mOb))) {
                break label994;
              }
              this.qqX = localElementQuery;
              break label994;
              if (!e.o((JSONObject)localObject2, "canReturnYfq")) {
                break;
              }
            }
            return;
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.NetSenceTenPayBase", paramString, "", new Object[0]);
    }
    label696:
    label994:
    label1008:
    label1013:
    for (;;)
    {
      localElementQuery.qve = 3;
      break label496;
      if (((JSONObject)localObject2).optInt("auth_mode") == 1)
      {
        localElementQuery.qve = 1;
        break label496;
      }
      localElementQuery.qve = 2;
      break label496;
      if ("1".equals(str))
      {
        localElementQuery.qvB = true;
        break label520;
      }
      if (!"0".equals(str)) {
        break label520;
      }
      localElementQuery.qvB = false;
      break label520;
      paramString = new SparseArray();
      localObject1 = paramJSONObject.getJSONArray("cre_type_map");
      i = ((JSONArray)localObject1).length();
      paramInt = 0;
      label760:
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
        localObject1 = o.bVA();
        localObject2 = this.qqW;
        ((q)localObject1).qyy = paramString;
        ((q)localObject1).qqW = ((List)localObject2);
        this.qqZ = paramJSONObject.optInt("need_area");
        this.qra = paramJSONObject.optInt("need_profession");
        if ((this.qqX != null) && (this.qqX.qqY != 1))
        {
          y.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
          this.qqZ = 0;
          this.qra = 0;
        }
        paramString = paramJSONObject.optJSONArray("profession_array");
        if (paramString == null) {
          continue;
        }
        this.qrb = new Profession[paramString.length()];
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt >= paramString.length()) {
          break label1013;
        }
        paramJSONObject = paramString.optJSONObject(paramInt);
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.optString("profession_name");
          i = paramJSONObject.optInt("profession_type");
          if (!bk.bl((String)localObject1))
          {
            paramJSONObject = new Profession((String)localObject1, i);
            this.qrb[paramInt] = paramJSONObject;
          }
          else
          {
            y.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
            break label1008;
            break;
            paramInt += 1;
            break label60;
            paramInt += 1;
            break label760;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  public final int aEC()
  {
    return 73;
  }
  
  public final boolean bUJ()
  {
    return this.qqZ == 1;
  }
  
  public final boolean bUK()
  {
    return this.qra == 1;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.t
 * JD-Core Version:    0.7.0.1
 */