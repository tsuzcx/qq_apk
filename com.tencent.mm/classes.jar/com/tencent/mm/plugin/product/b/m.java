package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public c puA;
  public n puB;
  public LinkedList<l> puC;
  public f puD;
  public String puE;
  public String puF;
  public String puG;
  public String puw;
  public int pux;
  public int puy;
  public int puz;
  public int status;
  
  public m()
  {
    AppMethodBeat.i(44003);
    this.puy = 2147483647;
    this.puz = 2147483647;
    this.status = 6;
    this.puC = new LinkedList();
    AppMethodBeat.o(44003);
  }
  
  public static m a(m paramm, String paramString)
  {
    AppMethodBeat.i(44004);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    label265:
    label302:
    int k;
    Object localObject4;
    int m;
    Object localObject5;
    if (paramm == null)
    {
      paramm = new m();
      try
      {
        paramString = new JSONObject(paramString);
        paramm.puw = paramString.getString("product_id");
        paramm.pux = paramString.getInt("product_type");
        paramm.puy = paramString.optInt("quantity", 2147483647);
        paramm.puz = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.puD = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.puD;
          localObject3 = new j();
          ((j)localObject3).bsY = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).puY = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.puA = new c();
          paramm.puA.name = ((JSONObject)localObject1).getString("name");
          paramm.puA.puL = ((JSONObject)localObject1).getInt("ori_price");
          paramm.puA.puM = ((JSONObject)localObject1).getInt("up_price");
          paramm.puA.puN = ((JSONObject)localObject1).getInt("low_price");
          paramm.puA.puO = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (bo.isNullOrNil((String)localObject3)) {
            break label1250;
          }
          paramm.puA.puO.add(localObject3);
          break label1250;
          paramm.puD.puZ = paramString.optString("ext_attr");
        }
        paramm.puA.fjL = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(44004);
        return paramm;
      }
      paramm.puA.ppp = ((JSONObject)localObject1).getString("fee_type");
      paramm.puA.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.puA.puW = new k();
        paramm.puA.puW.kWy = ((JSONObject)localObject2).optString("icon_url");
        paramm.puA.puW.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.puA.puU = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).pvf = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).pvg = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).pvh = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.pva = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).pvh.add(localh);
            j += 1;
          }
          paramm.puA.puU.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.puA.puV = new LinkedList();
        k = ((JSONArray)localObject1).length();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localObject3 = new a();
        ((a)localObject3).Name = ((JSONObject)localObject2).getString("name");
        ((a)localObject3).jKs = 0;
        if (!bo.isNullOrNil(((a)localObject3).Name)) {
          paramm.puA.puV.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).puI = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).jKs = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).ntu = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.puA.puV.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.puC = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).pvc = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).pvd = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).puy = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).pve = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).pve.add(localObject5);
            j += 1;
          }
          paramm.puC.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.puB = new n();
        paramm.puB.cwc = ((JSONObject)localObject1).getString("appid");
        paramm.puB.name = ((JSONObject)localObject1).getString("name");
        paramm.puB.username = ((JSONObject)localObject1).getString("username");
        paramm.puB.pvi = ((JSONObject)localObject1).optString("logo");
        paramm.puB.bsY = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.puF = paramString.optString("self_buy_button_word");
        paramm.puG = paramString.optString("product_mixed_h5_html");
      }
      AppMethodBeat.o(44004);
      return paramm;
      break;
      label1250:
      i += 1;
      break label265;
      i += 1;
    }
  }
  
  public static m b(m paramm, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(44005);
    m localm = paramm;
    if (paramm == null) {
      localm = new m();
    }
    paramString = br.F(paramString, "mallProductInfo");
    if (paramString == null)
    {
      AppMethodBeat.o(44005);
      return null;
    }
    localm.puw = bo.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.pux = bo.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.puA = new c();
    localm.puA.name = bo.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.puA.fjL = bo.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.puA.puM = bo.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.puA.puN = bo.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.puA.puL = bo.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.puE = bo.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bo.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.puA.puO = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bo.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bo.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!bo.isNullOrNil(paramm)) {
            localm.puA.puO.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.puA.puW = new k();
    localm.puA.puW.url = bo.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.puA.puW.kWy = bo.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.puB = new n();
    localm.puB.cwc = bo.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.puB.name = bo.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.puB.username = bo.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(44005);
    return localm;
  }
  
  public final String cbp()
  {
    AppMethodBeat.i(44006);
    String str;
    if ((this.puA != null) && (this.puA.puW != null) && (!bo.isNullOrNil(this.puA.puW.kWy)))
    {
      str = this.puA.puW.kWy;
      AppMethodBeat.o(44006);
      return str;
    }
    if ((this.puA != null) && (this.puA.puO != null) && (this.puA.puO.size() > 0))
    {
      str = (String)this.puA.puO.get(0);
      AppMethodBeat.o(44006);
      return str;
    }
    AppMethodBeat.o(44006);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */