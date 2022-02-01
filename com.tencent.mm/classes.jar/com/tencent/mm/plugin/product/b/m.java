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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public int AZA;
  public c AZB;
  public n AZC;
  public LinkedList<l> AZD;
  public f AZE;
  public String AZF;
  public String AZG;
  public String AZx;
  public int AZy;
  public int AZz;
  public String eby;
  public int status;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.AZz = 2147483647;
    this.AZA = 2147483647;
    this.status = 6;
    this.AZD = new LinkedList();
    AppMethodBeat.o(66909);
  }
  
  public static m a(m paramm, String paramString)
  {
    AppMethodBeat.i(66910);
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
        paramm.AZx = paramString.getString("product_id");
        paramm.AZy = paramString.getInt("product_type");
        paramm.AZz = paramString.optInt("quantity", 2147483647);
        paramm.AZA = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.AZE = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.AZE;
          localObject3 = new j();
          ((j)localObject3).cSx = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).AZY = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.AZB = new c();
          paramm.AZB.name = ((JSONObject)localObject1).getString("name");
          paramm.AZB.AZL = ((JSONObject)localObject1).getInt("ori_price");
          paramm.AZB.AZM = ((JSONObject)localObject1).getInt("up_price");
          paramm.AZB.AZN = ((JSONObject)localObject1).getInt("low_price");
          paramm.AZB.AZO = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (Util.isNullOrNil((String)localObject3)) {
            break label1250;
          }
          paramm.AZB.AZO.add(localObject3);
          break label1250;
          paramm.AZE.AZZ = paramString.optString("ext_attr");
        }
        paramm.AZB.iAq = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.AZB.AOl = ((JSONObject)localObject1).getString("fee_type");
      paramm.AZB.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.AZB.AZW = new k();
        paramm.AZB.AZW.qGB = ((JSONObject)localObject2).optString("icon_url");
        paramm.AZB.AZW.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.AZB.AZU = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).Bae = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).Baf = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).Bag = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.iJ = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).Bag.add(localh);
            j += 1;
          }
          paramm.AZB.AZU.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.AZB.AZV = new LinkedList();
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
        ((a)localObject3).oUv = 0;
        if (!Util.isNullOrNil(((a)localObject3).Name)) {
          paramm.AZB.AZV.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).AZI = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).oUv = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).iAc = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.AZB.AZV.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.AZD = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).Bab = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).Bac = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).AZz = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).Bad = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).Bad.add(localObject5);
            j += 1;
          }
          paramm.AZD.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.AZC = new n();
        paramm.AZC.dNI = ((JSONObject)localObject1).getString("appid");
        paramm.AZC.name = ((JSONObject)localObject1).getString("name");
        paramm.AZC.username = ((JSONObject)localObject1).getString("username");
        paramm.AZC.Bah = ((JSONObject)localObject1).optString("logo");
        paramm.AZC.cSx = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.AZF = paramString.optString("self_buy_button_word");
        paramm.AZG = paramString.optString("product_mixed_h5_html");
      }
      AppMethodBeat.o(66910);
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
    AppMethodBeat.i(66911);
    m localm = paramm;
    if (paramm == null) {
      localm = new m();
    }
    paramString = XmlParser.parseXml(paramString, "mallProductInfo", null);
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    localm.AZx = Util.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.AZy = Util.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.AZB = new c();
    localm.AZB.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.AZB.iAq = Util.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.AZB.AZM = Util.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.AZB.AZN = Util.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.AZB.AZL = Util.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.eby = Util.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = Util.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.AZB.AZO = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!Util.isNullOrNil(paramm)) {
            localm.AZB.AZO.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.AZB.AZW = new k();
    localm.AZB.AZW.url = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.AZB.AZW.qGB = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.AZC = new n();
    localm.AZC.dNI = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.AZC.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.AZC.username = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String eDx()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.AZB != null) && (this.AZB.AZW != null) && (!Util.isNullOrNil(this.AZB.AZW.qGB)))
    {
      str = this.AZB.AZW.qGB;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.AZB != null) && (this.AZB.AZO != null) && (this.AZB.AZO.size() > 0))
    {
      str = (String)this.AZB.AZO.get(0);
      AppMethodBeat.o(66912);
      return str;
    }
    AppMethodBeat.o(66912);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */