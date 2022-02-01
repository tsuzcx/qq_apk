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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public String kqB;
  public int status;
  public String uwi;
  public int uwj;
  public int uwk;
  public int uwl;
  public c uwm;
  public n uwn;
  public LinkedList<l> uwo;
  public f uwp;
  public String uwq;
  public String uwr;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.uwk = 2147483647;
    this.uwl = 2147483647;
    this.status = 6;
    this.uwo = new LinkedList();
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
        paramm.uwi = paramString.getString("product_id");
        paramm.uwj = paramString.getInt("product_type");
        paramm.uwk = paramString.optInt("quantity", 2147483647);
        paramm.uwl = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.uwp = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.uwp;
          localObject3 = new j();
          ((j)localObject3).dtM = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).uwJ = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.uwm = new c();
          paramm.uwm.name = ((JSONObject)localObject1).getString("name");
          paramm.uwm.uww = ((JSONObject)localObject1).getInt("ori_price");
          paramm.uwm.uwx = ((JSONObject)localObject1).getInt("up_price");
          paramm.uwm.uwy = ((JSONObject)localObject1).getInt("low_price");
          paramm.uwm.uwz = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (bt.isNullOrNil((String)localObject3)) {
            break label1250;
          }
          paramm.uwm.uwz.add(localObject3);
          break label1250;
          paramm.uwp.uwK = paramString.optString("ext_attr");
        }
        paramm.uwm.gKF = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.uwm.uop = ((JSONObject)localObject1).getString("fee_type");
      paramm.uwm.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.uwm.uwH = new k();
        paramm.uwm.uwH.odo = ((JSONObject)localObject2).optString("icon_url");
        paramm.uwm.uwH.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.uwm.uwF = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).uwP = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).uwQ = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).uwR = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.fN = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).uwR.add(localh);
            j += 1;
          }
          paramm.uwm.uwF.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.uwm.uwG = new LinkedList();
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
        ((a)localObject3).mBH = 0;
        if (!bt.isNullOrNil(((a)localObject3).Name)) {
          paramm.uwm.uwG.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).uwt = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).mBH = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).gKr = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.uwm.uwG.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.uwo = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).uwM = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).uwN = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).uwk = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).uwO = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).uwO.add(localObject5);
            j += 1;
          }
          paramm.uwo.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.uwn = new n();
        paramm.uwn.dlB = ((JSONObject)localObject1).getString("appid");
        paramm.uwn.name = ((JSONObject)localObject1).getString("name");
        paramm.uwn.username = ((JSONObject)localObject1).getString("username");
        paramm.uwn.uwS = ((JSONObject)localObject1).optString("logo");
        paramm.uwn.dtM = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.uwq = paramString.optString("self_buy_button_word");
        paramm.uwr = paramString.optString("product_mixed_h5_html");
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
    paramString = bw.K(paramString, "mallProductInfo");
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    localm.uwi = bt.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.uwj = bt.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.uwm = new c();
    localm.uwm.name = bt.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.uwm.gKF = bt.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.uwm.uwx = bt.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.uwm.uwy = bt.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.uwm.uww = bt.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.kqB = bt.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bt.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.uwm.uwz = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bt.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bt.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!bt.isNullOrNil(paramm)) {
            localm.uwm.uwz.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.uwm.uwH = new k();
    localm.uwm.uwH.url = bt.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.uwm.uwH.odo = bt.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.uwn = new n();
    localm.uwn.dlB = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.uwn.name = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.uwn.username = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String dbE()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.uwm != null) && (this.uwm.uwH != null) && (!bt.isNullOrNil(this.uwm.uwH.odo)))
    {
      str = this.uwm.uwH.odo;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.uwm != null) && (this.uwm.uwz != null) && (this.uwm.uwz.size() > 0))
    {
      str = (String)this.uwm.uwz.get(0);
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