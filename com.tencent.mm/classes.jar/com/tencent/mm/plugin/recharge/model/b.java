package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static String Ku(String paramString)
  {
    AppMethodBeat.i(67093);
    if (paramString == null)
    {
      AppMethodBeat.o(67093);
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    AppMethodBeat.o(67093);
    return paramString;
  }
  
  public static ArrayList<MallRechargeProduct> a(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(67091);
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
        localArrayList2.add(k(paramString, paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      ArrayList localArrayList1 = null;
      AppMethodBeat.o(67091);
      return localArrayList1;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.MallLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(67091);
    }
    return null;
  }
  
  public static String awz(String paramString)
  {
    AppMethodBeat.i(67094);
    if (paramString == null)
    {
      AppMethodBeat.o(67094);
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
      paramString = paramString.toString();
      AppMethodBeat.o(67094);
      return paramString;
    }
    paramString = paramString.toString();
    AppMethodBeat.o(67094);
    return paramString;
  }
  
  public static void dHa()
  {
    AppMethodBeat.i(67095);
    g.ajS();
    g.ajR().ajA().set(am.a.IPG, Boolean.TRUE);
    AppMethodBeat.o(67095);
  }
  
  public static boolean g(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67096);
    if ((paramMallFunction.DsT == null) || (paramMallFunction.DsT.DqM != 1) || (bu.isNullOrNil(paramMallFunction.DsT.Dti)))
    {
      AppMethodBeat.o(67096);
      return false;
    }
    g.ajS();
    if (!((Boolean)g.ajR().ajA().get(am.a.IPG, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(67096);
      return true;
    }
    AppMethodBeat.o(67096);
    return false;
  }
  
  public static MallRechargeProduct k(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67092);
    MallRechargeProduct localMallRechargeProduct;
    if (paramJSONObject.optInt("need_getlatestinfo", 1) == 1)
    {
      bool = true;
      localMallRechargeProduct = new MallRechargeProduct(bool);
      localMallRechargeProduct.jFZ = paramString;
      localMallRechargeProduct.dpp = paramJSONObject.getString("product_id");
      localMallRechargeProduct.pSt = paramJSONObject.getString("product_name");
      localMallRechargeProduct.xDa = paramJSONObject.optString("product_desc");
      localMallRechargeProduct.xDb = (paramJSONObject.getInt("product_min_price") / 100.0F);
      localMallRechargeProduct.xDc = (paramJSONObject.getInt("product_max_price") / 100.0F);
      localMallRechargeProduct.appId = paramJSONObject.optString("app_id");
      if (paramJSONObject.getInt("is_infinite") != 1) {
        break label183;
      }
      bool = true;
      label112:
      localMallRechargeProduct.xDd = bool;
      localMallRechargeProduct.xDe = paramJSONObject.getInt("left_count");
      localMallRechargeProduct.xDf = paramJSONObject.getInt("discount");
      if (paramJSONObject.optInt("is_default_choose", 0) != 1) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool = true;; bool = false)
    {
      localMallRechargeProduct.isDefault = bool;
      localMallRechargeProduct.xDh = true;
      localMallRechargeProduct.hKr = paramJSONObject.optInt("product_type", 0);
      AppMethodBeat.o(67092);
      return localMallRechargeProduct;
      bool = false;
      break;
      bool = false;
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.b
 * JD-Core Version:    0.7.0.1
 */