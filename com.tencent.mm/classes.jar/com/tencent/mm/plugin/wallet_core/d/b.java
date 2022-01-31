package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final String knX;
  private static Map<String, String> umG;
  
  static
  {
    AppMethodBeat.i(47058);
    knX = com.tencent.mm.compatible.util.e.eQz + "wallet";
    umG = null;
    AppMethodBeat.o(47058);
  }
  
  public static String WX(String paramString)
  {
    AppMethodBeat.i(47057);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
      AppMethodBeat.o(47057);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { knX, com.tencent.mm.a.g.w(paramString.getBytes()) });
    AppMethodBeat.o(47057);
    return paramString;
  }
  
  public static boolean afu(String paramString)
  {
    AppMethodBeat.i(47050);
    try
    {
      if (umG == null) {
        umG = new HashMap();
      }
      ab.d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(paramString)));
      SharedPreferences.Editor localEditor = ah.getContext().getSharedPreferences("bank_logo", 0).edit();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("bank_urls_list");
      int j = localJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        if (r.ZB()) {}
        for (paramString = ((JSONObject)localObject).optString("bank_desc");; paramString = ((JSONObject)localObject).optString("bank_type"))
        {
          localObject = ((JSONObject)localObject).toString();
          if ((bo.isNullOrNil(paramString)) || (bo.isNullOrNil((String)localObject))) {
            break label162;
          }
          localEditor.putString(paramString, (String)localObject);
          umG.put(paramString, localObject);
          i += 1;
          break;
        }
      }
      label162:
      localEditor.commit();
      ab.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(47050);
      return true;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramString.getMessage() });
      ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(47050);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.g afv(String paramString)
  {
    AppMethodBeat.i(47052);
    if (umG == null) {
      cVe();
    }
    if (!bo.isNullOrNil((String)umG.get(paramString))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(47052);
      return null;
    }
    Object localObject = (String)umG.get(paramString);
    if (!bo.isNullOrNil((String)localObject))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.model.g();
      try
      {
        localObject = new JSONObject((String)localObject);
        long l = ((JSONObject)localObject).optLong("timestamp", 0L);
        paramString.pek = ((JSONObject)localObject).getString("logo2x_url");
        paramString.ugn = ((JSONObject)localObject).getString("bg2x_url");
        paramString.ugo = ((JSONObject)localObject).getString("wl2x_url");
        if (System.currentTimeMillis() / 1000L - l > 7200L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.bxr = bool;
          paramString.ugp = WX(paramString.pek);
          paramString.pJg = ((JSONObject)localObject).optString("bank_name_pinyin", "");
          paramString.timestamp = l;
          AppMethodBeat.o(47052);
          return paramString;
        }
        AppMethodBeat.o(47052);
      }
      catch (JSONException paramString)
      {
        ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
        AppMethodBeat.o(47052);
        return null;
      }
    }
    return null;
  }
  
  public static boolean az(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(47051);
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      if (umG == null) {
        umG = new HashMap();
      }
      SharedPreferences.Editor localEditor = ah.getContext().getSharedPreferences("bank_logo", 0).edit();
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = new JSONObject((String)paramLinkedList.get(i));
        if (r.ZB()) {}
        for (String str = ((JSONObject)localObject).optString("bank_desc");; str = ((JSONObject)localObject).optString("bank_type"))
        {
          ((JSONObject)localObject).put("timestamp", l);
          localObject = ((JSONObject)localObject).toString();
          if ((bo.isNullOrNil(str)) || (bo.isNullOrNil((String)localObject))) {
            break label166;
          }
          localEditor.putString(str, (String)localObject);
          umG.put(str, localObject);
          i += 1;
          break;
        }
      }
      label166:
      localEditor.commit();
      ab.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(47051);
      return true;
    }
    catch (Exception paramLinkedList)
    {
      ab.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramLinkedList.getMessage() });
      ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramLinkedList, "", new Object[0]);
      AppMethodBeat.o(47051);
    }
    return false;
  }
  
  private static com.tencent.mm.plugin.wallet_core.model.g bb(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47055);
    Object localObject1;
    Object localObject2;
    int i;
    if (umG == null)
    {
      cVe();
      localObject1 = (String)umG.get(paramString);
      if (!bo.isNullOrNil((String)localObject1)) {
        break label402;
      }
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(paramString);
        localObject2 = new f((LinkedList)localObject2);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a((m)localObject2, 0);
      }
      afu(bc(paramContext, "config/bank_logo.xml"));
      if (umG == null) {
        break label397;
      }
      localObject1 = (String)umG.get(paramString);
      i = 1;
    }
    for (;;)
    {
      if (!bo.isNullOrNil((String)localObject1)) {
        paramContext = new com.tencent.mm.plugin.wallet_core.model.g();
      }
      for (;;)
      {
        try
        {
          paramString = new JSONObject((String)localObject1);
          long l = paramString.optLong("timestamp", 0L);
          paramContext.pek = paramString.getString("logo2x_url");
          paramContext.ugn = paramString.getString("bg2x_url");
          paramContext.ugo = paramString.getString("wl2x_url");
          boolean bool1 = bool2;
          if (i == 0)
          {
            if (System.currentTimeMillis() / 1000L - l > 7200L) {
              bool1 = bool2;
            }
          }
          else
          {
            paramContext.bxr = bool1;
            paramContext.ugp = WX(paramContext.pek);
            paramContext.pJg = paramString.optString("bank_name_pinyin", "");
            paramContext.timestamp = l;
            AppMethodBeat.o(47055);
            return paramContext;
            localObject2 = (String)umG.get(paramString);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            ab.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", new Object[] { paramString });
            localObject2 = ah.getContext().getSharedPreferences("bank_logo", 0).getString(paramString, "");
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            ab.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", new Object[] { paramString });
            umG.put(paramString, localObject2);
            localObject1 = localObject2;
            break;
          }
          bool1 = false;
          continue;
          paramContext = null;
        }
        catch (JSONException paramContext)
        {
          ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "", new Object[0]);
          AppMethodBeat.o(47055);
          return null;
        }
      }
      label397:
      i = 1;
      continue;
      label402:
      i = 0;
    }
  }
  
  private static String bc(Context paramContext, String paramString)
  {
    AppMethodBeat.i(47056);
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
        ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "getFromAssets", new Object[0]);
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
          ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
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
        ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
        paramString = (String)localObject1;
      }
    }
    AppMethodBeat.o(47056);
    return paramString;
    try
    {
      ((InputStream)localObject2).close();
      label159:
      AppMethodBeat.o(47056);
      throw paramContext;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "close", new Object[0]);
      }
    }
  }
  
  private static void cVe()
  {
    AppMethodBeat.i(47053);
    umG = new HashMap();
    Iterator localIterator = ah.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      umG.put(localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(47053);
  }
  
  public static String cVf()
  {
    return knX;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.g h(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47054);
    if (!paramBoolean)
    {
      paramContext = bb(paramContext, paramString);
      AppMethodBeat.o(47054);
      return paramContext;
    }
    Object localObject = null;
    if ("CITIC_CREDIT".equals(paramString))
    {
      com.tencent.mm.plugin.wallet_core.model.g localg = new com.tencent.mm.plugin.wallet_core.model.g();
      localg.ugr = 2130840813;
      localg.ugs = 2130840815;
      paramContext = bb(paramContext, paramString);
      localObject = localg;
      if (paramContext != null)
      {
        localg.pek = paramContext.pek;
        localObject = localg;
      }
    }
    AppMethodBeat.o(47054);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */