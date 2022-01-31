package com.tencent.mm.plugin.product.b;

import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
{
  public String mSA;
  public String mSq;
  public int mSr;
  public int mSs = 2147483647;
  public int mSt = 2147483647;
  public c mSu;
  public n mSv;
  public LinkedList<l> mSw = new LinkedList();
  public f mSx;
  public String mSy;
  public String mSz;
  public int status = 6;
  
  public static m a(m paramm, String paramString)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    label260:
    label297:
    label326:
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
        paramm.mSq = paramString.getString("product_id");
        paramm.mSr = paramString.getInt("product_type");
        paramm.mSs = paramString.optInt("quantity", 2147483647);
        paramm.mSt = paramString.optInt("left_buy_quantity", 2147483647);
        paramm.status = paramString.optInt("status", 6);
        localObject1 = paramString.optJSONObject("ext_attr");
        if (localObject1 != null)
        {
          paramm.mSx = new f();
          localObject1 = ((JSONObject)localObject1).optJSONObject("product_ext");
          if (localObject1 == null) {
            break label297;
          }
          localObject2 = paramm.mSx;
          localObject3 = new j();
          ((j)localObject3).bcw = ((JSONObject)localObject1).getInt("flag");
          ((f)localObject2).mSS = ((j)localObject3);
        }
        for (;;)
        {
          localObject1 = paramString.optJSONObject("base_attr");
          if (localObject1 == null) {
            break label864;
          }
          paramm.mSu = new c();
          paramm.mSu.name = ((JSONObject)localObject1).getString("name");
          paramm.mSu.mSF = ((JSONObject)localObject1).getInt("ori_price");
          paramm.mSu.mSG = ((JSONObject)localObject1).getInt("up_price");
          paramm.mSu.mSH = ((JSONObject)localObject1).getInt("low_price");
          paramm.mSu.mSI = new LinkedList();
          localObject2 = ((JSONObject)localObject1).getJSONArray("img_info");
          j = ((JSONArray)localObject2).length();
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = ((JSONArray)localObject2).getString(i);
          if (bk.bl((String)localObject3)) {
            break label1235;
          }
          paramm.mSu.mSI.add(localObject3);
          break label1235;
          paramm.mSx.mST = paramString.optString("ext_attr");
        }
        return paramm;
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.ProductInfo", paramString, "", new Object[0]);
      }
      paramm.mSu.dTF = ((JSONObject)localObject1).getString("digest");
      paramm.mSu.mOZ = ((JSONObject)localObject1).getString("fee_type");
      paramm.mSu.detail = ((JSONObject)localObject1).getString("detail");
      localObject2 = ((JSONObject)localObject1).optJSONObject("share_info");
      if (localObject2 != null)
      {
        paramm.mSu.mSQ = new k();
        paramm.mSu.mSQ.iQn = ((JSONObject)localObject2).optString("icon_url");
        paramm.mSu.mSQ.url = ((JSONObject)localObject2).optString("url");
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("sku_table");
      if (localObject2 != null)
      {
        paramm.mSu.mSO = new LinkedList();
        k = ((JSONArray)localObject2).length();
        i = 0;
        while (i < k)
        {
          localObject4 = ((JSONArray)localObject2).getJSONObject(i);
          localObject3 = new com.tencent.mm.plugin.product.c.m();
          ((com.tencent.mm.plugin.product.c.m)localObject3).mSZ = ((JSONObject)localObject4).getString("id");
          ((com.tencent.mm.plugin.product.c.m)localObject3).mTa = ((JSONObject)localObject4).getString("name");
          ((com.tencent.mm.plugin.product.c.m)localObject3).mTb = new LinkedList();
          localObject4 = ((JSONObject)localObject4).getJSONArray("value_list");
          m = ((JSONArray)localObject4).length();
          j = 0;
          while (j < m)
          {
            localObject5 = ((JSONArray)localObject4).getJSONObject(j);
            h localh = new h();
            localh.id = ((JSONObject)localObject5).getString("id");
            localh.name = ((JSONObject)localObject5).getString("name");
            localh.mSU = true;
            ((com.tencent.mm.plugin.product.c.m)localObject3).mTb.add(localh);
            j += 1;
          }
          paramm.mSu.mSO.add(localObject3);
          i += 1;
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("actiongroup_attr");
      if (localObject1 != null)
      {
        paramm.mSu.mSP = new LinkedList();
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
        ((a)localObject3).kRZ = ((JSONObject)localObject2).getString("name");
        ((a)localObject3).hQR = 0;
        if (!bk.bl(((a)localObject3).kRZ)) {
          paramm.mSu.mSP.add(localObject3);
        }
        localObject2 = ((JSONObject)localObject2).getJSONArray("action_list");
        m = ((JSONArray)localObject2).length();
        j = 0;
        while (j < m)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          localObject4 = new a();
          ((a)localObject4).kRZ = ((JSONObject)localObject3).getString("name");
          ((a)localObject4).mSC = ((JSONObject)localObject3).getString("tips");
          ((a)localObject4).hQR = ((JSONObject)localObject3).getInt("type");
          ((a)localObject4).kVs = ((JSONObject)localObject3).getString("content");
          ((a)localObject4).kSy = ((JSONObject)localObject3).getString("icon_url");
          paramm.mSu.mSP.add(localObject4);
          j += 1;
        }
      }
      label864:
      localObject1 = paramString.optJSONArray("available_sku_list");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        paramm.mSw = new LinkedList();
        i = 0;
        while (i < k)
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = new l();
          ((l)localObject2).mSW = ((JSONObject)localObject3).getString("id_info");
          ((l)localObject2).mSX = ((JSONObject)localObject3).getInt("price");
          ((l)localObject2).mSs = ((JSONObject)localObject3).getInt("quantity");
          ((l)localObject2).url = ((JSONObject)localObject3).getString("icon_url");
          localObject3 = ((JSONObject)localObject3).getJSONArray("express_fee");
          m = ((JSONArray)localObject3).length();
          ((l)localObject2).mSY = new LinkedList();
          j = 0;
          while (j < m)
          {
            localObject4 = ((JSONArray)localObject3).getJSONObject(j);
            localObject5 = new e();
            ((e)localObject5).id = ((JSONObject)localObject4).getInt("id");
            ((e)localObject5).name = ((JSONObject)localObject4).getString("name");
            ((e)localObject5).value = ((JSONObject)localObject4).getInt("price");
            ((l)localObject2).mSY.add(localObject5);
            j += 1;
          }
          paramm.mSw.add(localObject2);
          i += 1;
        }
      }
      localObject1 = paramString.optJSONObject("seller_attr");
      if (localObject1 != null)
      {
        paramm.mSv = new n();
        paramm.mSv.bOL = ((JSONObject)localObject1).getString("appid");
        paramm.mSv.name = ((JSONObject)localObject1).getString("name");
        paramm.mSv.username = ((JSONObject)localObject1).getString("username");
        paramm.mSv.mTc = ((JSONObject)localObject1).optString("logo");
        paramm.mSv.bcw = ((JSONObject)localObject1).optInt("flag", 0);
      }
      paramString = paramString.optJSONObject("oss_info");
      if (paramString == null) {
        break label326;
      }
      paramm.mSz = paramString.optString("self_buy_button_word");
      paramm.mSA = paramString.optString("product_mixed_h5_html");
      return paramm;
      break;
      label1235:
      i += 1;
      break label260;
      i += 1;
    }
  }
  
  public static m b(m paramm, String paramString)
  {
    int i = 0;
    m localm = paramm;
    if (paramm == null) {
      localm = new m();
    }
    paramString = bn.s(paramString, "mallProductInfo");
    if (paramString == null) {
      return null;
    }
    localm.mSq = bk.pm((String)paramString.get(".mallProductInfo.id"));
    localm.mSr = bk.getInt((String)paramString.get(".mallProductInfo.type"), 0);
    localm.mSu = new c();
    localm.mSu.name = bk.pm((String)paramString.get(".mallProductInfo.name"));
    localm.mSu.dTF = bk.pm((String)paramString.get(".mallProductInfo.digest"));
    localm.mSu.mSG = bk.getInt((String)paramString.get(".mallProductInfo.highPrice"), 0);
    localm.mSu.mSH = bk.getInt((String)paramString.get(".mallProductInfo.lowPrice"), 0);
    localm.mSu.mSF = bk.getInt((String)paramString.get(".mallProductInfo.originPrice"), 0);
    localm.mSy = bk.pm((String)paramString.get(".mallProductInfo.sourceUrl"));
    int j = bk.getInt((String)paramString.get(".mallProductInfo.imgCount"), 0);
    if (j > 0)
    {
      localm.mSu.mSI = new LinkedList();
      if (i < j)
      {
        if (i == 0) {}
        for (paramm = bk.pm((String)paramString.get(".mallProductInfo.imgList.imgUrl"));; paramm = bk.pm((String)paramString.get(".mallProductInfo.imgList.imgUrl" + i)))
        {
          if (!bk.bl(paramm)) {
            localm.mSu.mSI.add(paramm);
          }
          i += 1;
          break;
        }
      }
    }
    localm.mSu.mSQ = new k();
    localm.mSu.mSQ.url = bk.pm((String)paramString.get(".mallProductInfo.shareInfo.shareUrl"));
    localm.mSu.mSQ.iQn = bk.pm((String)paramString.get(".mallProductInfo.shareInfo.shareThumbUrl"));
    localm.mSv = new n();
    localm.mSv.bOL = bk.pm((String)paramString.get(".mallProductInfo.sellerInfo.appID"));
    localm.mSv.name = bk.pm((String)paramString.get(".mallProductInfo.sellerInfo.appName"));
    localm.mSv.username = bk.pm((String)paramString.get(".mallProductInfo.sellerInfo.usrName"));
    return localm;
  }
  
  public final String bsj()
  {
    if ((this.mSu != null) && (this.mSu.mSQ != null) && (!bk.bl(this.mSu.mSQ.iQn))) {
      return this.mSu.mSQ.iQn;
    }
    if ((this.mSu != null) && (this.mSu.mSI != null) && (this.mSu.mSI.size() > 0)) {
      return (String)this.mSu.mSI.get(0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.m
 * JD-Core Version:    0.7.0.1
 */