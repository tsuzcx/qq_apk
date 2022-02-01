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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public String dJL;
  public int status;
  public String xbV;
  public int xbW;
  public int xbX;
  public int xbY;
  public c xbZ;
  public n xca;
  public LinkedList<l> xcb;
  public f xcc;
  public String xcd;
  public String xce;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.xbX = 2147483647;
    this.xbY = 2147483647;
    this.status = 6;
    this.xcb = new LinkedList();
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
        paramm.xbV = paramString.getString("product_id");
        paramm.xbW = paramString.getInt("product_type");
        paramm.xbX = paramString.optInt("quantity", 2147483647);
        paramm.xbY = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.xcc = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.xcc;
          localObject3 = new j();
          ((j)localObject3).dEu = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).xcw = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.xbZ = new c();
          paramm.xbZ.name = ((JSONObject)localObject1).getString("name");
          paramm.xbZ.xcj = ((JSONObject)localObject1).getInt("ori_price");
          paramm.xbZ.xck = ((JSONObject)localObject1).getInt("up_price");
          paramm.xbZ.xcl = ((JSONObject)localObject1).getInt("low_price");
          paramm.xbZ.xcm = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (bu.isNullOrNil((String)localObject3)) {
            break label1250;
          }
          paramm.xbZ.xcm.add(localObject3);
          break label1250;
          paramm.xcc.xcx = paramString.optString("ext_attr");
        }
        paramm.xbZ.hGg = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.xbZ.wSq = ((JSONObject)localObject1).getString("fee_type");
      paramm.xbZ.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.xbZ.xcu = new k();
        paramm.xbZ.xcu.pqW = ((JSONObject)localObject2).optString("icon_url");
        paramm.xbZ.xcu.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.xbZ.xcs = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).xcC = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).xcD = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).xcE = new LinkedList();
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
            ((com.tencent.mm.plugin.product.c.m)localObject3).xcE.add(localh);
            j += 1;
          }
          paramm.xbZ.xcs.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.xbZ.xct = new LinkedList();
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
        ((a)localObject3).nJA = 0;
        if (!bu.isNullOrNil(((a)localObject3).Name)) {
          paramm.xbZ.xct.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).xcg = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).nJA = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).hFS = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.xbZ.xct.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.xcb = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).xcz = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).xcA = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).xbX = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).xcB = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).xcB.add(localObject5);
            j += 1;
          }
          paramm.xcb.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.xca = new n();
        paramm.xca.dwb = ((JSONObject)localObject1).getString("appid");
        paramm.xca.name = ((JSONObject)localObject1).getString("name");
        paramm.xca.username = ((JSONObject)localObject1).getString("username");
        paramm.xca.xcF = ((JSONObject)localObject1).optString("logo");
        paramm.xca.dEu = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.xcd = paramString.optString("self_buy_button_word");
        paramm.xce = paramString.optString("product_mixed_h5_html");
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
    paramString = bx.M(paramString, "mallProductInfo");
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    localm.xbV = bu.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.xbW = bu.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.xbZ = new c();
    localm.xbZ.name = bu.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.xbZ.hGg = bu.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.xbZ.xck = bu.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.xbZ.xcl = bu.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.xbZ.xcj = bu.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.dJL = bu.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bu.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.xbZ.xcm = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bu.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bu.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!bu.isNullOrNil(paramm)) {
            localm.xbZ.xcm.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.xbZ.xcu = new k();
    localm.xbZ.xcu.url = bu.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.xbZ.xcu.pqW = bu.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.xca = new n();
    localm.xca.dwb = bu.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.xca.name = bu.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.xca.username = bu.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String dDf()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.xbZ != null) && (this.xbZ.xcu != null) && (!bu.isNullOrNil(this.xbZ.xcu.pqW)))
    {
      str = this.xbZ.xcu.pqW;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.xbZ != null) && (this.xbZ.xcm != null) && (this.xbZ.xcm.size() > 0))
    {
      str = (String)this.xbZ.xcm.get(0);
      AppMethodBeat.o(66912);
      return str;
    }
    AppMethodBeat.o(66912);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */