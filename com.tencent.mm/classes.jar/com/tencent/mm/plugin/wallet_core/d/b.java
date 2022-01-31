package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final String inc = com.tencent.mm.compatible.util.e.bkH + "wallet";
  private static Map<String, String> qzW = null;
  
  public static String KR(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
      return null;
    }
    return String.format("%s/%s", new Object[] { inc, com.tencent.mm.a.g.o(paramString.getBytes()) });
  }
  
  public static boolean QA(String paramString)
  {
    try
    {
      if (qzW == null) {
        qzW = new HashMap();
      }
      y.d("MicroMsg.WalletBankLogoStorage", "bank logo:" + paramString);
      SharedPreferences.Editor localEditor = ae.getContext().getSharedPreferences("bank_logo", 0).edit();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("bank_urls_list");
      int j = localJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        if (q.Gw()) {}
        for (paramString = ((JSONObject)localObject).optString("bank_desc");; paramString = ((JSONObject)localObject).optString("bank_type"))
        {
          localObject = ((JSONObject)localObject).toString();
          if ((bk.bl(paramString)) || (bk.bl((String)localObject))) {
            break label164;
          }
          localEditor.putString(paramString, (String)localObject);
          qzW.put(paramString, localObject);
          i += 1;
          break;
        }
      }
      label164:
      localEditor.commit();
      y.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      return true;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramString.getMessage() });
      y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e QB(String paramString)
  {
    if (qzW == null) {
      bWm();
    }
    if (!bk.bl((String)qzW.get(paramString))) {}
    for (int i = 1; i == 0; i = 0) {
      return null;
    }
    Object localObject = (String)qzW.get(paramString);
    if (!bk.bl((String)localObject))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.model.e();
      try
      {
        localObject = new JSONObject((String)localObject);
        long l = ((JSONObject)localObject).optLong("timestamp", 0L);
        paramString.mEi = ((JSONObject)localObject).getString("logo2x_url");
        paramString.qtS = ((JSONObject)localObject).getString("bg2x_url");
        paramString.qtT = ((JSONObject)localObject).getString("wl2x_url");
        if (System.currentTimeMillis() / 1000L - l > 7200L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.bgQ = bool;
          paramString.qtU = KR(paramString.mEi);
          paramString.ndQ = ((JSONObject)localObject).optString("bank_name_pinyin", "");
          paramString.timestamp = l;
          return paramString;
        }
        return null;
      }
      catch (JSONException paramString)
      {
        y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
        return null;
      }
    }
  }
  
  private static com.tencent.mm.plugin.wallet_core.model.e aR(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (qzW == null)
    {
      bWm();
      localObject1 = (String)qzW.get(paramString);
      if (!bk.bl((String)localObject1)) {
        break label384;
      }
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DP().isSDCardAvailable())
      {
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(paramString);
        localObject2 = new c((LinkedList)localObject2);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a((m)localObject2, 0);
      }
      QA(aS(paramContext, "config/bank_logo.xml"));
      if (qzW == null) {
        break label379;
      }
      localObject1 = (String)qzW.get(paramString);
      i = 1;
    }
    for (;;)
    {
      if (!bk.bl((String)localObject1)) {
        paramContext = new com.tencent.mm.plugin.wallet_core.model.e();
      }
      for (;;)
      {
        try
        {
          paramString = new JSONObject((String)localObject1);
          long l = paramString.optLong("timestamp", 0L);
          paramContext.mEi = paramString.getString("logo2x_url");
          paramContext.qtS = paramString.getString("bg2x_url");
          paramContext.qtT = paramString.getString("wl2x_url");
          boolean bool1 = bool2;
          if (i == 0)
          {
            if (System.currentTimeMillis() / 1000L - l > 7200L) {
              bool1 = bool2;
            }
          }
          else
          {
            paramContext.bgQ = bool1;
            paramContext.qtU = KR(paramContext.mEi);
            paramContext.ndQ = paramString.optString("bank_name_pinyin", "");
            paramContext.timestamp = l;
            return paramContext;
            localObject2 = (String)qzW.get(paramString);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            y.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", new Object[] { paramString });
            localObject2 = ae.getContext().getSharedPreferences("bank_logo", 0).getString(paramString, "");
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            y.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", new Object[] { paramString });
            qzW.put(paramString, localObject2);
            localObject1 = localObject2;
            break;
          }
          bool1 = false;
          continue;
          paramContext = null;
        }
        catch (JSONException paramContext)
        {
          y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "", new Object[0]);
          return null;
        }
      }
      label379:
      i = 1;
      continue;
      label384:
      i = 0;
    }
  }
  
  private static String aS(Context paramContext, String paramString)
  {
    String str = "";
    Object localObject = null;
    Context localContext = null;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open(paramString);
        localContext = paramContext;
        localObject = paramContext;
        paramString = new byte[paramContext.available()];
        localContext = paramContext;
        localObject = paramContext;
        paramContext.read(paramString);
        localContext = paramContext;
        localObject = paramContext;
        paramString = EncodingUtils.getString(paramString, "UTF-8");
        localObject = paramString;
      }
      catch (Exception paramContext)
      {
        localObject = localContext;
        y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "getFromAssets", new Object[0]);
        localObject = str;
        if (localContext == null) {
          continue;
        }
        try
        {
          localContext.close();
          return "";
        }
        catch (Exception paramContext)
        {
          y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
          return "";
        }
      }
      finally
      {
        if (localObject == null) {
          break label136;
        }
      }
      try
      {
        paramContext.close();
        localObject = paramString;
        return localObject;
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
        return paramString;
      }
    }
    try
    {
      ((InputStream)localObject).close();
      label136:
      throw paramContext;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "close", new Object[0]);
      }
    }
  }
  
  public static boolean aq(LinkedList<String> paramLinkedList)
  {
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      if (qzW == null) {
        qzW = new HashMap();
      }
      SharedPreferences.Editor localEditor = ae.getContext().getSharedPreferences("bank_logo", 0).edit();
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = new JSONObject((String)paramLinkedList.get(i));
        if (q.Gw()) {}
        for (String str = ((JSONObject)localObject).optString("bank_desc");; str = ((JSONObject)localObject).optString("bank_type"))
        {
          ((JSONObject)localObject).put("timestamp", l);
          localObject = ((JSONObject)localObject).toString();
          if ((bk.bl(str)) || (bk.bl((String)localObject))) {
            break label160;
          }
          localEditor.putString(str, (String)localObject);
          qzW.put(str, localObject);
          i += 1;
          break;
        }
      }
      label160:
      localEditor.commit();
      y.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      return true;
    }
    catch (Exception paramLinkedList)
    {
      y.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramLinkedList.getMessage() });
      y.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramLinkedList, "", new Object[0]);
    }
    return false;
  }
  
  private static void bWm()
  {
    qzW = new HashMap();
    Iterator localIterator = ae.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      qzW.put(localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public static String bWn()
  {
    return inc;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e h(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean) {
      localObject = aR(paramContext, paramString);
    }
    com.tencent.mm.plugin.wallet_core.model.e locale;
    do
    {
      do
      {
        return localObject;
        localObject = null;
      } while (!"CITIC_CREDIT".equals(paramString));
      locale = new com.tencent.mm.plugin.wallet_core.model.e();
      locale.qtW = a.e.wallet_bankcard_white_bg;
      locale.qtX = a.e.wallet_bankcard_wxcredit_citic_water_mask;
      paramContext = aR(paramContext, paramString);
      localObject = locale;
    } while (paramContext == null);
    locale.mEi = paramContext.mEi;
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */