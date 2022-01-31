package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static String LB(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    paramString = new StringBuilder(paramString.replaceAll(" ", ""));
    int i = paramString.length();
    if (i >= 4)
    {
      paramString.insert(3, ' ');
      if (i >= 8) {
        paramString.insert(8, ' ');
      }
      return paramString.toString();
    }
    return paramString.toString();
  }
  
  public static ArrayList<MallRechargeProduct> a(String paramString, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {}
    try
    {
      ArrayList localArrayList2 = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        localArrayList1 = localArrayList2;
        if (i >= j) {
          break;
        }
        localArrayList2.add(d(paramString, paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      ArrayList localArrayList1 = null;
      return localArrayList1;
    }
    catch (JSONException paramString)
    {
      y.printErrStackTrace("MicroMsg.MallLogic", paramString, "", new Object[0]);
    }
    return null;
  }
  
  public static MallRechargeProduct d(String paramString, JSONObject paramJSONObject)
  {
    MallRechargeProduct localMallRechargeProduct;
    if (paramJSONObject.optInt("need_getlatestinfo", 1) == 1)
    {
      bool = true;
      localMallRechargeProduct = new MallRechargeProduct(bool);
      localMallRechargeProduct.npy = paramString;
      localMallRechargeProduct.bJd = paramJSONObject.getString("product_id");
      localMallRechargeProduct.jfG = paramJSONObject.getString("product_name");
      localMallRechargeProduct.npz = paramJSONObject.optString("product_desc");
      localMallRechargeProduct.npA = (paramJSONObject.getInt("product_min_price") / 100.0F);
      localMallRechargeProduct.npB = (paramJSONObject.getInt("product_max_price") / 100.0F);
      localMallRechargeProduct.appId = paramJSONObject.optString("app_id");
      if (paramJSONObject.getInt("is_infinite") != 1) {
        break label173;
      }
      bool = true;
      label107:
      localMallRechargeProduct.npC = bool;
      localMallRechargeProduct.npD = paramJSONObject.getInt("left_count");
      localMallRechargeProduct.npE = paramJSONObject.getInt("discount");
      if (paramJSONObject.optInt("is_default_choose", 0) != 1) {
        break label178;
      }
    }
    label173:
    label178:
    for (boolean bool = true;; bool = false)
    {
      localMallRechargeProduct.isDefault = bool;
      localMallRechargeProduct.npG = true;
      localMallRechargeProduct.dWX = paramJSONObject.optInt("product_type", 0);
      return localMallRechargeProduct;
      bool = false;
      break;
      bool = false;
      break label107;
    }
  }
  
  public static String qa(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replaceAll("\\D", "");
      paramString = str;
    } while (!str.startsWith("86"));
    return str.substring(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.b
 * JD-Core Version:    0.7.0.1
 */