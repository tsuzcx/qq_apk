package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c;
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
  private static Map<String, String> IcD;
  private static final String pTN;
  
  static
  {
    AppMethodBeat.i(70590);
    pTN = c.hgG();
    IcD = null;
    AppMethodBeat.o(70590);
  }
  
  public static String aKj(String paramString)
  {
    AppMethodBeat.i(70589);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
      AppMethodBeat.o(70589);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { pTN, com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(70589);
    return paramString;
  }
  
  public static boolean aVy(String paramString)
  {
    AppMethodBeat.i(70582);
    try
    {
      if (IcD == null) {
        IcD = new HashMap();
      }
      Log.d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(paramString)));
      SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).edit();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("bank_urls_list");
      int j = localJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        if (z.aUo()) {}
        for (paramString = ((JSONObject)localObject).optString("bank_desc");; paramString = ((JSONObject)localObject).optString("bank_type"))
        {
          localObject = ((JSONObject)localObject).toString();
          if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil((String)localObject))) {
            break label162;
          }
          localEditor.putString(paramString, (String)localObject);
          IcD.put(paramString, localObject);
          i += 1;
          break;
        }
      }
      label162:
      localEditor.commit();
      Log.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(70582);
      return true;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramString.getMessage() });
      Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(70582);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e aVz(String paramString)
  {
    AppMethodBeat.i(70584);
    if (IcD == null) {
      fCp();
    }
    if (!Util.isNullOrNil((String)IcD.get(paramString))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(70584);
      return null;
    }
    Object localObject = (String)IcD.get(paramString);
    if (!Util.isNullOrNil((String)localObject))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.model.e();
      try
      {
        localObject = new JSONObject((String)localObject);
        long l = ((JSONObject)localObject).optLong("timestamp", 0L);
        paramString.AAU = ((JSONObject)localObject).getString("logo2x_url");
        paramString.HWc = ((JSONObject)localObject).getString("bg2x_url");
        paramString.HWd = ((JSONObject)localObject).getString("wl2x_url");
        if (System.currentTimeMillis() / 1000L - l > 7200L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.needUpdate = bool;
          paramString.HWe = aKj(paramString.AAU);
          paramString.pinyin = ((JSONObject)localObject).optString("bank_name_pinyin", "");
          paramString.timestamp = l;
          AppMethodBeat.o(70584);
          return paramString;
        }
        AppMethodBeat.o(70584);
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
        AppMethodBeat.o(70584);
        return null;
      }
    }
    return null;
  }
  
  private static com.tencent.mm.plugin.wallet_core.model.e bO(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(70587);
    Object localObject1;
    Object localObject2;
    int i;
    if (IcD == null)
    {
      fCp();
      localObject1 = (String)IcD.get(paramString);
      if (!Util.isNullOrNil((String)localObject1)) {
        break label399;
      }
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(paramString);
        localObject2 = new f((LinkedList)localObject2);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject2, 0);
      }
      aVy(bP(paramContext, "config/bank_logo.xml"));
      if (IcD == null) {
        break label394;
      }
      localObject1 = (String)IcD.get(paramString);
      i = 1;
    }
    for (;;)
    {
      if (!Util.isNullOrNil((String)localObject1)) {
        paramContext = new com.tencent.mm.plugin.wallet_core.model.e();
      }
      for (;;)
      {
        try
        {
          paramString = new JSONObject((String)localObject1);
          long l = paramString.optLong("timestamp", 0L);
          paramContext.AAU = paramString.getString("logo2x_url");
          paramContext.HWc = paramString.getString("bg2x_url");
          paramContext.HWd = paramString.getString("wl2x_url");
          boolean bool1 = bool2;
          if (i == 0)
          {
            if (System.currentTimeMillis() / 1000L - l > 7200L) {
              bool1 = bool2;
            }
          }
          else
          {
            paramContext.needUpdate = bool1;
            paramContext.HWe = aKj(paramContext.AAU);
            paramContext.pinyin = paramString.optString("bank_name_pinyin", "");
            paramContext.timestamp = l;
            AppMethodBeat.o(70587);
            return paramContext;
            localObject2 = (String)IcD.get(paramString);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            Log.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", new Object[] { paramString });
            localObject2 = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).getString(paramString, "");
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            Log.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", new Object[] { paramString });
            IcD.put(paramString, localObject2);
            localObject1 = localObject2;
            break;
          }
          bool1 = false;
          continue;
          paramContext = null;
        }
        catch (JSONException paramContext)
        {
          Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "", new Object[0]);
          AppMethodBeat.o(70587);
          return null;
        }
      }
      label394:
      i = 1;
      continue;
      label399:
      i = 0;
    }
  }
  
  private static String bP(Context paramContext, String paramString)
  {
    AppMethodBeat.i(70588);
    String str = "";
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open(paramString);
        localObject1 = paramContext;
        localObject2 = paramContext;
        paramString = new byte[paramContext.available()];
        localObject1 = paramContext;
        localObject2 = paramContext;
        paramContext.read(paramString);
        localObject1 = paramContext;
        localObject2 = paramContext;
        paramString = EncodingUtils.getString(paramString, "UTF-8");
        localObject1 = paramString;
        paramString = (String)localObject1;
      }
      catch (Exception paramContext)
      {
        localObject2 = localObject1;
        Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "getFromAssets", new Object[0]);
        paramString = str;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          paramString = str;
        }
        catch (Exception paramContext)
        {
          Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
          paramString = str;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label159;
        }
      }
      try
      {
        paramContext.close();
        paramString = (String)localObject1;
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
        paramString = (String)localObject1;
      }
    }
    AppMethodBeat.o(70588);
    return paramString;
    try
    {
      ((InputStream)localObject2).close();
      label159:
      AppMethodBeat.o(70588);
      throw paramContext;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "close", new Object[0]);
      }
    }
  }
  
  public static boolean bw(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(70583);
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      if (IcD == null) {
        IcD = new HashMap();
      }
      SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).edit();
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = new JSONObject((String)paramLinkedList.get(i));
        if (z.aUo()) {}
        for (String str = ((JSONObject)localObject).optString("bank_desc");; str = ((JSONObject)localObject).optString("bank_type"))
        {
          ((JSONObject)localObject).put("timestamp", l);
          localObject = ((JSONObject)localObject).toString();
          if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject))) {
            break label166;
          }
          localEditor.putString(str, (String)localObject);
          IcD.put(str, localObject);
          i += 1;
          break;
        }
      }
      label166:
      localEditor.commit();
      Log.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(70583);
      return true;
    }
    catch (Exception paramLinkedList)
    {
      Log.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramLinkedList.getMessage() });
      Log.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramLinkedList, "", new Object[0]);
      AppMethodBeat.o(70583);
    }
    return false;
  }
  
  private static void fCp()
  {
    AppMethodBeat.i(70585);
    IcD = new HashMap();
    Iterator localIterator = MMApplicationContext.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      IcD.put(localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(70585);
  }
  
  public static String fSn()
  {
    return pTN;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e j(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70586);
    if (!paramBoolean)
    {
      paramContext = bO(paramContext, paramString);
      AppMethodBeat.o(70586);
      return paramContext;
    }
    Object localObject = null;
    if ("CITIC_CREDIT".equals(paramString))
    {
      com.tencent.mm.plugin.wallet_core.model.e locale = new com.tencent.mm.plugin.wallet_core.model.e();
      locale.HWg = 2131235596;
      locale.HWh = 2131235598;
      paramContext = bO(paramContext, paramString);
      localObject = locale;
      if (paramContext != null)
      {
        locale.AAU = paramContext.AAU;
        localObject = locale;
      }
    }
    AppMethodBeat.o(70586);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */