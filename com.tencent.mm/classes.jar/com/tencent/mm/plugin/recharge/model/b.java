package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static String XL(String paramString)
  {
    AppMethodBeat.i(44186);
    if (paramString == null)
    {
      AppMethodBeat.o(44186);
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
      AppMethodBeat.o(44186);
      return paramString;
    }
    paramString = paramString.toString();
    AppMethodBeat.o(44186);
    return paramString;
  }
  
  public static ArrayList<MallRechargeProduct> a(String paramString, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(44183);
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
        localArrayList2.add(f(paramString, paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      ArrayList localArrayList1 = null;
      AppMethodBeat.o(44183);
      return localArrayList1;
    }
    catch (JSONException paramString)
    {
      ab.printErrStackTrace("MicroMsg.MallLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(44183);
    }
    return null;
  }
  
  public static boolean c(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(44188);
    if ((paramMallFunction.umh == null) || (paramMallFunction.umh.uki != 1) || (bo.isNullOrNil(paramMallFunction.umh.umw)))
    {
      AppMethodBeat.o(44188);
      return false;
    }
    g.RM();
    if (!((Boolean)g.RL().Ru().get(ac.a.yCF, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(44188);
      return true;
    }
    AppMethodBeat.o(44188);
    return false;
  }
  
  public static void cfp()
  {
    AppMethodBeat.i(44187);
    g.RM();
    g.RL().Ru().set(ac.a.yCF, Boolean.TRUE);
    AppMethodBeat.o(44187);
  }
  
  public static MallRechargeProduct f(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(44184);
    MallRechargeProduct localMallRechargeProduct;
    if (paramJSONObject.optInt("need_getlatestinfo", 1) == 1)
    {
      bool = true;
      localMallRechargeProduct = new MallRechargeProduct(bool);
      localMallRechargeProduct.pUM = paramString;
      localMallRechargeProduct.cqx = paramJSONObject.getString("product_id");
      localMallRechargeProduct.loz = paramJSONObject.getString("product_name");
      localMallRechargeProduct.pUN = paramJSONObject.optString("product_desc");
      localMallRechargeProduct.pUO = (paramJSONObject.getInt("product_min_price") / 100.0F);
      localMallRechargeProduct.pUP = (paramJSONObject.getInt("product_max_price") / 100.0F);
      localMallRechargeProduct.appId = paramJSONObject.optString("app_id");
      if (paramJSONObject.getInt("is_infinite") != 1) {
        break label183;
      }
      bool = true;
      label112:
      localMallRechargeProduct.pUQ = bool;
      localMallRechargeProduct.pUR = paramJSONObject.getInt("left_count");
      localMallRechargeProduct.pUS = paramJSONObject.getInt("discount");
      if (paramJSONObject.optInt("is_default_choose", 0) != 1) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool = true;; bool = false)
    {
      localMallRechargeProduct.isDefault = bool;
      localMallRechargeProduct.pUU = true;
      localMallRechargeProduct.fnf = paramJSONObject.optInt("product_type", 0);
      AppMethodBeat.o(44184);
      return localMallRechargeProduct;
      bool = false;
      break;
      bool = false;
      break label112;
    }
  }
  
  public static String xw(String paramString)
  {
    AppMethodBeat.i(44185);
    if (paramString == null)
    {
      AppMethodBeat.o(44185);
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    AppMethodBeat.o(44185);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.b
 * JD-Core Version:    0.7.0.1
 */