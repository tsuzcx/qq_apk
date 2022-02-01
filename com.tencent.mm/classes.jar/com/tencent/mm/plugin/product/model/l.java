package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.plugin.product.b.f;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  public String MQZ;
  public int MRa;
  public int MRb;
  public int MRc;
  public c MRd;
  public n MRe;
  public LinkedList<com.tencent.mm.plugin.product.b.l> MRf;
  public f MRg;
  public String MRh;
  public String MRi;
  public String ibx;
  public int status;
  
  public l()
  {
    AppMethodBeat.i(66909);
    this.MRb = 2147483647;
    this.MRc = 2147483647;
    this.status = 6;
    this.MRf = new LinkedList();
    AppMethodBeat.o(66909);
  }
  
  public static l a(l paraml, String paramString)
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
    if (paraml == null)
    {
      paraml = new l();
      try
      {
        paramString = new JSONObject(paramString);
        paraml.MQZ = paramString.getString("product_id");
        paraml.MRa = paramString.getInt("product_type");
        paraml.MRb = paramString.optInt("quantity", 2147483647);
        paraml.MRc = paramString.optInt("left_buy_quantity", 2147483647);
        paraml.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paraml.MRg = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paraml.MRg;
          localObject3 = new j();
          ((j)localObject3).eQp = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).MRz = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paraml.MRd = new c();
          paraml.MRd.name = ((JSONObject)localObject1).getString("name");
          paraml.MRd.MRm = ((JSONObject)localObject1).getInt("ori_price");
          paraml.MRd.MRn = ((JSONObject)localObject1).getInt("up_price");
          paraml.MRd.MRo = ((JSONObject)localObject1).getInt("low_price");
          paraml.MRd.MRp = new LinkedList();
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
          paraml.MRd.MRp.add(localObject3);
          break label1250;
          paraml.MRg.MRA = paramString.optString("ext_attr");
        }
        paraml.MRd.nUO = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paraml;
      }
      paraml.MRd.MEq = ((JSONObject)localObject1).getString("fee_type");
      paraml.MRd.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paraml.MRd.MRx = new k();
        paraml.MRd.MRx.icon_url = ((JSONObject)localObject2).optString("icon_url");
        paraml.MRd.MRx.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paraml.MRd.MRv = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new m();
          ((m)localObject3).MRF = ((JSONObject)localObject4).getString("id");
          ((m)localObject3).MRG = ((JSONObject)localObject4).getString("name");
          ((m)localObject3).MRH = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.dsb = true;
            ((m)localObject3).MRH.add(localh);
            j += 1;
          }
          paraml.MRd.MRv.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paraml.MRd.MRw = new LinkedList();
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
        ((a)localObject3).IGU = ((JSONObject)localObject2).getString("name");
        ((a)localObject3).vhJ = 0;
        if (!Util.isNullOrNil(((a)localObject3).IGU)) {
          paraml.MRd.MRw.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).IGU = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).MRj = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).vhJ = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).nUB = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IHo = ((JSONObject)localObject3).getString("icon_url");
          paraml.MRd.MRw.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paraml.MRf = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new com.tencent.mm.plugin.product.b.l();
          ((com.tencent.mm.plugin.product.b.l)localObject2).MRC = ((JSONObject)localObject3).getString("id_info");
          ((com.tencent.mm.plugin.product.b.l)localObject2).MRD = ((JSONObject)localObject3).getInt("price");
          ((com.tencent.mm.plugin.product.b.l)localObject2).MRb = ((JSONObject)localObject3).getInt("quantity");
          ((com.tencent.mm.plugin.product.b.l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((com.tencent.mm.plugin.product.b.l)localObject2).MRE = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((com.tencent.mm.plugin.product.b.l)localObject2).MRE.add(localObject5);
            j += 1;
          }
          paraml.MRf.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paraml.MRe = new n();
        paraml.MRe.appid = ((JSONObject)localObject1).getString("appid");
        paraml.MRe.name = ((JSONObject)localObject1).getString("name");
        paraml.MRe.username = ((JSONObject)localObject1).getString("username");
        paraml.MRe.MRI = ((JSONObject)localObject1).optString("logo");
        paraml.MRe.eQp = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paraml.MRh = paramString.optString("self_buy_button_word");
        paraml.MRi = paramString.optString("product_mixed_h5_html");
      }
      AppMethodBeat.o(66910);
      return paraml;
      break;
      label1250:
      i += 1;
      break label265;
      i += 1;
    }
  }
  
  public static l b(l paraml, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(66911);
    l locall = paraml;
    if (paraml == null) {
      locall = new l();
    }
    paramString = XmlParser.parseXml(paramString, "mallProductInfo", null);
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    locall.MQZ = Util.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    locall.MRa = Util.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    locall.MRd = new c();
    locall.MRd.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    locall.MRd.nUO = Util.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    locall.MRd.MRn = Util.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    locall.MRd.MRo = Util.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    locall.MRd.MRm = Util.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    locall.ibx = Util.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = Util.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      locall.MRd.MRp = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paraml = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paraml = Util.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!Util.isNullOrNil(paraml)) {
            locall.MRd.MRp.add(paraml);
          }
          i += 1;
          break;
        }
      }
    }
    locall.MRd.MRx = new k();
    locall.MRd.MRx.url = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    locall.MRd.MRx.icon_url = Util.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    locall.MRe = new n();
    locall.MRe.appid = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    locall.MRe.name = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    locall.MRe.username = Util.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return locall;
  }
  
  public final String gAu()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.MRd != null) && (this.MRd.MRx != null) && (!Util.isNullOrNil(this.MRd.MRx.icon_url)))
    {
      str = this.MRd.MRx.icon_url;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.MRd != null) && (this.MRd.MRp != null) && (this.MRd.MRp.size() > 0))
    {
      str = (String)this.MRd.MRp.get(0);
      AppMethodBeat.o(66912);
      return str;
    }
    AppMethodBeat.o(66912);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.l
 * JD-Core Version:    0.7.0.1
 */