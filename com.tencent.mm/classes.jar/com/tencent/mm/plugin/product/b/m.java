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
  public String lox;
  public int status;
  public String wMh;
  public int wMi;
  public int wMj;
  public int wMk;
  public c wMl;
  public n wMm;
  public LinkedList<l> wMn;
  public f wMo;
  public String wMp;
  public String wMq;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.wMj = 2147483647;
    this.wMk = 2147483647;
    this.status = 6;
    this.wMn = new LinkedList();
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
        paramm.wMh = paramString.getString("product_id");
        paramm.wMi = paramString.getInt("product_type");
        paramm.wMj = paramString.optInt("quantity", 2147483647);
        paramm.wMk = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.wMo = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.wMo;
          localObject3 = new j();
          ((j)localObject3).dDp = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).wMI = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.wMl = new c();
          paramm.wMl.name = ((JSONObject)localObject1).getString("name");
          paramm.wMl.wMv = ((JSONObject)localObject1).getInt("ori_price");
          paramm.wMl.wMw = ((JSONObject)localObject1).getInt("up_price");
          paramm.wMl.wMx = ((JSONObject)localObject1).getInt("low_price");
          paramm.wMl.wMy = new LinkedList();
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
          paramm.wMl.wMy.add(localObject3);
          break label1250;
          paramm.wMo.wMJ = paramString.optString("ext_attr");
        }
        paramm.wMl.hDo = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        ad.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.wMl.wCF = ((JSONObject)localObject1).getString("fee_type");
      paramm.wMl.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.wMl.wMG = new k();
        paramm.wMl.wMG.pkr = ((JSONObject)localObject2).optString("icon_url");
        paramm.wMl.wMG.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.wMl.wME = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).wMO = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).wMP = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).wMQ = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.iH = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).wMQ.add(localh);
            j += 1;
          }
          paramm.wMl.wME.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.wMl.wMF = new LinkedList();
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
        ((a)localObject3).nEf = 0;
        if (!bt.isNullOrNil(((a)localObject3).Name)) {
          paramm.wMl.wMF.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).wMs = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).nEf = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).hDa = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.wMl.wMF.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.wMn = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).wML = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).wMM = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).wMj = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).wMN = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).wMN.add(localObject5);
            j += 1;
          }
          paramm.wMn.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.wMm = new n();
        paramm.wMm.duW = ((JSONObject)localObject1).getString("appid");
        paramm.wMm.name = ((JSONObject)localObject1).getString("name");
        paramm.wMm.username = ((JSONObject)localObject1).getString("username");
        paramm.wMm.wMR = ((JSONObject)localObject1).optString("logo");
        paramm.wMm.dDp = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.wMp = paramString.optString("self_buy_button_word");
        paramm.wMq = paramString.optString("product_mixed_h5_html");
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
    paramString = bw.M(paramString, "mallProductInfo");
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    localm.wMh = bt.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.wMi = bt.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.wMl = new c();
    localm.wMl.name = bt.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.wMl.hDo = bt.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.wMl.wMw = bt.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.wMl.wMx = bt.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.wMl.wMv = bt.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.lox = bt.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bt.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.wMl.wMy = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bt.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bt.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!bt.isNullOrNil(paramm)) {
            localm.wMl.wMy.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.wMl.wMG = new k();
    localm.wMl.wMG.url = bt.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.wMl.wMG.pkr = bt.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.wMm = new n();
    localm.wMm.duW = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.wMm.name = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.wMm.username = bt.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String dzO()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.wMl != null) && (this.wMl.wMG != null) && (!bt.isNullOrNil(this.wMl.wMG.pkr)))
    {
      str = this.wMl.wMG.pkr;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.wMl != null) && (this.wMl.wMy != null) && (this.wMl.wMy.size() > 0))
    {
      str = (String)this.wMl.wMy.get(0);
      AppMethodBeat.o(66912);
      return str;
    }
    AppMethodBeat.o(66912);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */