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
  public n GTA;
  public LinkedList<l> GTB;
  public f GTC;
  public String GTD;
  public String GTE;
  public String GTv;
  public int GTw;
  public int GTx;
  public int GTy;
  public c GTz;
  public String fVx;
  public int status;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.GTx = 2147483647;
    this.GTy = 2147483647;
    this.status = 6;
    this.GTB = new LinkedList();
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
        paramm.GTv = paramString.getString("product_id");
        paramm.GTw = paramString.getInt("product_type");
        paramm.GTx = paramString.optInt("quantity", 2147483647);
        paramm.GTy = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.GTC = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.GTC;
          localObject3 = new j();
          ((j)localObject3).cUP = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).GTW = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.GTz = new c();
          paramm.GTz.name = ((JSONObject)localObject1).getString("name");
          paramm.GTz.GTJ = ((JSONObject)localObject1).getInt("ori_price");
          paramm.GTz.GTK = ((JSONObject)localObject1).getInt("up_price");
          paramm.GTz.GTL = ((JSONObject)localObject1).getInt("low_price");
          paramm.GTz.GTM = new LinkedList();
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
          paramm.GTz.GTM.add(localObject3);
          break label1250;
          paramm.GTC.GTX = paramString.optString("ext_attr");
        }
        paramm.GTz.lpM = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.GTz.GHz = ((JSONObject)localObject1).getString("fee_type");
      paramm.GTz.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.GTz.GTU = new k();
        paramm.GTz.GTU.ufC = ((JSONObject)localObject2).optString("icon_url");
        paramm.GTz.GTU.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.GTz.GTS = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).GUc = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).GUd = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).GUe = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.bzb = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).GUe.add(localh);
            j += 1;
          }
          paramm.GTz.GTS.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.GTz.GTT = new LinkedList();
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
        ((a)localObject3).CMP = ((JSONObject)localObject2).getString("name");
        ((a)localObject3).rWu = 0;
        if (!Util.isNullOrNil(((a)localObject3).CMP)) {
          paramm.GTz.GTT.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).CMP = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).GTG = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).rWu = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).lpy = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).CNj = ((JSONObject)localObject3).getString("icon_url");
          paramm.GTz.GTT.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.GTB = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).GTZ = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).GUa = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).GTx = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).GUb = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).GUb.add(localObject5);
            j += 1;
          }
          paramm.GTB.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.GTA = new n();
        paramm.GTA.appid = ((JSONObject)localObject1).getString("appid");
        paramm.GTA.name = ((JSONObject)localObject1).getString("name");
        paramm.GTA.username = ((JSONObject)localObject1).getString("username");
        paramm.GTA.GUf = ((JSONObject)localObject1).optString("logo");
        paramm.GTA.cUP = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.GTD = paramString.optString("self_buy_button_word");
        paramm.GTE = paramString.optString("product_mixed_h5_html");
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
    localm.GTv = Util.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.GTw = Util.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.GTz = new c();
    localm.GTz.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.GTz.lpM = Util.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.GTz.GTK = Util.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.GTz.GTL = Util.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.GTz.GTJ = Util.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.fVx = Util.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = Util.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.GTz.GTM = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!Util.isNullOrNil(paramm)) {
            localm.GTz.GTM.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.GTz.GTU = new k();
    localm.GTz.GTU.url = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.GTz.GTU.ufC = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.GTA = new n();
    localm.GTA.appid = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.GTA.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.GTA.username = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String fpq()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.GTz != null) && (this.GTz.GTU != null) && (!Util.isNullOrNil(this.GTz.GTU.ufC)))
    {
      str = this.GTz.GTU.ufC;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.GTz != null) && (this.GTz.GTM != null) && (this.GTz.GTM.size() > 0))
    {
      str = (String)this.GTz.GTM.get(0);
      AppMethodBeat.o(66912);
      return str;
    }
    AppMethodBeat.o(66912);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */