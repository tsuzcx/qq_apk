package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static String GG(String paramString)
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
        localArrayList2.add(j(paramString, paramJSONArray.getJSONObject(i)));
        i += 1;
      }
      ArrayList localArrayList1 = null;
      AppMethodBeat.o(67091);
      return localArrayList1;
    }
    catch (JSONException paramString)
    {
      ac.printErrStackTrace("MicroMsg.MallLogic", paramString, "", new Object[0]);
      AppMethodBeat.o(67091);
    }
    return null;
  }
  
  public static String aql(String paramString)
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
  
  public static boolean c(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(67096);
    if ((paramMallFunction.BAX == null) || (paramMallFunction.BAX.ByO != 1) || (bs.isNullOrNil(paramMallFunction.BAX.BBm)))
    {
      AppMethodBeat.o(67096);
      return false;
    }
    g.agS();
    if (!((Boolean)g.agR().agA().get(ah.a.GIQ, Boolean.FALSE)).booleanValue())
    {
      AppMethodBeat.o(67096);
      return true;
    }
    AppMethodBeat.o(67096);
    return false;
  }
  
  public static void dtm()
  {
    AppMethodBeat.i(67095);
    g.agS();
    g.agR().agA().set(ah.a.GIQ, Boolean.TRUE);
    AppMethodBeat.o(67095);
  }
  
  public static MallRechargeProduct j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(67092);
    MallRechargeProduct localMallRechargeProduct;
    if (paramJSONObject.optInt("need_getlatestinfo", 1) == 1)
    {
      bool = true;
      localMallRechargeProduct = new MallRechargeProduct(bool);
      localMallRechargeProduct.wfu = paramString;
      localMallRechargeProduct.dcO = paramJSONObject.getString("product_id");
      localMallRechargeProduct.pio = paramJSONObject.getString("product_name");
      localMallRechargeProduct.wfv = paramJSONObject.optString("product_desc");
      localMallRechargeProduct.wfw = (paramJSONObject.getInt("product_min_price") / 100.0F);
      localMallRechargeProduct.wfx = (paramJSONObject.getInt("product_max_price") / 100.0F);
      localMallRechargeProduct.appId = paramJSONObject.optString("app_id");
      if (paramJSONObject.getInt("is_infinite") != 1) {
        break label183;
      }
      bool = true;
      label112:
      localMallRechargeProduct.wfy = bool;
      localMallRechargeProduct.wfz = paramJSONObject.getInt("left_count");
      localMallRechargeProduct.wfA = paramJSONObject.getInt("discount");
      if (paramJSONObject.optInt("is_default_choose", 0) != 1) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool = true;; bool = false)
    {
      localMallRechargeProduct.isDefault = bool;
      localMallRechargeProduct.wfC = true;
      localMallRechargeProduct.hph = paramJSONObject.optInt("product_type", 0);
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