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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public String kRU;
  public int status;
  public String vFb;
  public int vFc;
  public int vFd;
  public int vFe;
  public c vFf;
  public n vFg;
  public LinkedList<l> vFh;
  public f vFi;
  public String vFj;
  public String vFk;
  
  public m()
  {
    AppMethodBeat.i(66909);
    this.vFd = 2147483647;
    this.vFe = 2147483647;
    this.status = 6;
    this.vFh = new LinkedList();
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
        paramm.vFb = paramString.getString("product_id");
        paramm.vFc = paramString.getInt("product_type");
        paramm.vFd = paramString.optInt("quantity", 2147483647);
        paramm.vFe = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.vFi = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label302;
          }
          localObject2 = paramm.vFi;
          localObject3 = new j();
          ((j)localObject3).drx = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).vFC = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label874;
          }
          paramm.vFf = new c();
          paramm.vFf.name = ((JSONObject)localObject1).getString("name");
          paramm.vFf.vFp = ((JSONObject)localObject1).getInt("ori_price");
          paramm.vFf.vFq = ((JSONObject)localObject1).getInt("up_price");
          paramm.vFf.vFr = ((JSONObject)localObject1).getInt("low_price");
          paramm.vFf.vFs = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (bs.isNullOrNil((String)localObject3)) {
            break label1250;
          }
          paramm.vFf.vFs.add(localObject3);
          break label1250;
          paramm.vFi.vFD = paramString.optString("ext_attr");
        }
        paramm.vFf.hlf = ((JSONObject)localObject1).getString("digest");
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(66910);
        return paramm;
      }
      paramm.vFf.vxl = ((JSONObject)localObject1).getString("fee_type");
      paramm.vFf.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.vFf.vFA = new k();
        paramm.vFf.vFA.oGN = ((JSONObject)localObject2).optString("icon_url");
        paramm.vFf.vFA.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.vFf.vFy = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).vFI = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).vFJ = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).vFK = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.gM = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).vFK.add(localh);
            j += 1;
          }
          paramm.vFf.vFy.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.vFf.vFz = new LinkedList();
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
        ((a)localObject3).ndI = 0;
        if (!bs.isNullOrNil(((a)localObject3).Name)) {
          paramm.vFf.vFz.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).Name = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).vFm = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).ndI = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).hkR = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).IconUrl = ((JSONObject)localObject3).getString("icon_url");
          paramm.vFf.vFz.add(localObject4);
          j += 1;
        }
      }
      label874:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.vFh = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).vFF = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).vFG = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).vFd = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).vFH = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).vFH.add(localObject5);
            j += 1;
          }
          paramm.vFh.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.vFg = new n();
        paramm.vFg.djj = ((JSONObject)localObject1).getString("appid");
        paramm.vFg.name = ((JSONObject)localObject1).getString("name");
        paramm.vFg.username = ((JSONObject)localObject1).getString("username");
        paramm.vFg.vFL = ((JSONObject)localObject1).optString("logo");
        paramm.vFg.drx = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString != null)
      {
        paramm.vFj = paramString.optString("self_buy_button_word");
        paramm.vFk = paramString.optString("product_mixed_h5_html");
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
    paramString = bv.L(paramString, "mallProductInfo");
    if (paramString == null)
    {
      AppMethodBeat.o(66911);
      return null;
    }
    localm.vFb = bs.nullAsNil((String)paramString.get(".mallProductInfo.id"));
    localm.vFc = bs.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.vFf = new c();
    localm.vFf.name = bs.nullAsNil((String)paramString.get(".mallProductInfo.name"));
    localm.vFf.hlf = bs.nullAsNil((String)paramString.get(".mallProductInfo.digest"));
    localm.vFf.vFq = bs.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.vFf.vFr = bs.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.vFf.vFp = bs.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.kRU = bs.nullAsNil((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bs.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.vFf.vFs = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bs.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bs.nullAsNil((String)paramString.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i)))))
        {
          if (!bs.isNullOrNil(paramm)) {
            localm.vFf.vFs.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.vFf.vFA = new k();
    localm.vFf.vFA.url = bs.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.vFf.vFA.oGN = bs.nullAsNil((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.vFg = new n();
    localm.vFg.djj = bs.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.vFg.name = bs.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.vFg.username = bs.nullAsNil((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    AppMethodBeat.o(66911);
    return localm;
  }
  
  public final String dpm()
  {
    AppMethodBeat.i(66912);
    String str;
    if ((this.vFf != null) && (this.vFf.vFA != null) && (!bs.isNullOrNil(this.vFf.vFA.oGN)))
    {
      str = this.vFf.vFA.oGN;
      AppMethodBeat.o(66912);
      return str;
    }
    if ((this.vFf != null) && (this.vFf.vFs != null) && (this.vFf.vFs.size() > 0))
    {
      str = (String)this.vFf.vFs.get(0);
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