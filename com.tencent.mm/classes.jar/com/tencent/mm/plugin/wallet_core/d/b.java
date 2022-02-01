package com.tencent.mm.plugin.wallet_core.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static Map<String, String> Dts;
  private static final String oGh;
  
  static
  {
    AppMethodBeat.i(70590);
    oGh = c.fVj();
    Dts = null;
    AppMethodBeat.o(70590);
  }
  
  public static boolean aFZ(String paramString)
  {
    AppMethodBeat.i(70582);
    try
    {
      if (Dts == null) {
        Dts = new HashMap();
      }
      ae.d("MicroMsg.WalletBankLogoStorage", "bank logo:".concat(String.valueOf(paramString)));
      SharedPreferences.Editor localEditor = ak.getContext().getSharedPreferences("bank_logo", 0).edit();
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("bank_urls_list");
      int j = localJSONArray.length();
      int i = 0;
      if (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        if (v.aAR()) {}
        for (paramString = ((JSONObject)localObject).optString("bank_desc");; paramString = ((JSONObject)localObject).optString("bank_type"))
        {
          localObject = ((JSONObject)localObject).toString();
          if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil((String)localObject))) {
            break label162;
          }
          localEditor.putString(paramString, (String)localObject);
          Dts.put(paramString, localObject);
          i += 1;
          break;
        }
      }
      label162:
      localEditor.commit();
      ae.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(70582);
      return true;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramString.getMessage() });
      ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
      AppMethodBeat.o(70582);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e aGa(String paramString)
  {
    AppMethodBeat.i(70584);
    if (Dts == null) {
      ewq();
    }
    if (!bu.isNullOrNil((String)Dts.get(paramString))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(70584);
      return null;
    }
    Object localObject = (String)Dts.get(paramString);
    if (!bu.isNullOrNil((String)localObject))
    {
      paramString = new com.tencent.mm.plugin.wallet_core.model.e();
      try
      {
        localObject = new JSONObject((String)localObject);
        long l = ((JSONObject)localObject).optLong("timestamp", 0L);
        paramString.wFJ = ((JSONObject)localObject).getString("logo2x_url");
        paramString.DmK = ((JSONObject)localObject).getString("bg2x_url");
        paramString.DmL = ((JSONObject)localObject).getString("wl2x_url");
        if (System.currentTimeMillis() / 1000L - l > 7200L) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.gnV = bool;
          paramString.DmM = avR(paramString.wFJ);
          paramString.pinyin = ((JSONObject)localObject).optString("bank_name_pinyin", "");
          paramString.timestamp = l;
          AppMethodBeat.o(70584);
          return paramString;
        }
        AppMethodBeat.o(70584);
      }
      catch (JSONException paramString)
      {
        ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "", new Object[0]);
        AppMethodBeat.o(70584);
        return null;
      }
    }
    return null;
  }
  
  public static String avR(String paramString)
  {
    AppMethodBeat.i(70589);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.WalletBankLogoStorage", "getStoragePath: but url is null");
      AppMethodBeat.o(70589);
      return null;
    }
    paramString = String.format("%s/%s", new Object[] { oGh, com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(70589);
    return paramString;
  }
  
  public static boolean ba(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(70583);
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      if (Dts == null) {
        Dts = new HashMap();
      }
      SharedPreferences.Editor localEditor = ak.getContext().getSharedPreferences("bank_logo", 0).edit();
      int j = paramLinkedList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = new JSONObject((String)paramLinkedList.get(i));
        if (v.aAR()) {}
        for (String str = ((JSONObject)localObject).optString("bank_desc");; str = ((JSONObject)localObject).optString("bank_type"))
        {
          ((JSONObject)localObject).put("timestamp", l);
          localObject = ((JSONObject)localObject).toString();
          if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject))) {
            break label165;
          }
          localEditor.putString(str, (String)localObject);
          Dts.put(str, localObject);
          i += 1;
          break;
        }
      }
      label165:
      localEditor.commit();
      ae.d("MicroMsg.WalletBankLogoStorage", "update BankLogo config file. success!");
      AppMethodBeat.o(70583);
      return true;
    }
    catch (Exception paramLinkedList)
    {
      ae.e("MicroMsg.WalletBankLogoStorage", "parse band logo error. %s", new Object[] { paramLinkedList.getMessage() });
      ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramLinkedList, "", new Object[0]);
      AppMethodBeat.o(70583);
    }
    return false;
  }
  
  private static com.tencent.mm.plugin.wallet_core.model.e bu(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(70587);
    Object localObject1;
    Object localObject2;
    int i;
    if (Dts == null)
    {
      ewq();
      localObject1 = (String)Dts.get(paramString);
      if (!bu.isNullOrNil((String)localObject1)) {
        break label402;
      }
      com.tencent.mm.kernel.g.ajS();
      if (com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(paramString);
        localObject2 = new f((LinkedList)localObject2);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a((n)localObject2, 0);
      }
      aFZ(bv(paramContext, "config/bank_logo.xml"));
      if (Dts == null) {
        break label397;
      }
      localObject1 = (String)Dts.get(paramString);
      i = 1;
    }
    for (;;)
    {
      if (!bu.isNullOrNil((String)localObject1)) {
        paramContext = new com.tencent.mm.plugin.wallet_core.model.e();
      }
      for (;;)
      {
        try
        {
          paramString = new JSONObject((String)localObject1);
          long l = paramString.optLong("timestamp", 0L);
          paramContext.wFJ = paramString.getString("logo2x_url");
          paramContext.DmK = paramString.getString("bg2x_url");
          paramContext.DmL = paramString.getString("wl2x_url");
          boolean bool1 = bool2;
          if (i == 0)
          {
            if (System.currentTimeMillis() / 1000L - l > 7200L) {
              bool1 = bool2;
            }
          }
          else
          {
            paramContext.gnV = bool1;
            paramContext.DmM = avR(paramContext.wFJ);
            paramContext.pinyin = paramString.optString("bank_name_pinyin", "");
            paramContext.timestamp = l;
            AppMethodBeat.o(70587);
            return paramContext;
            localObject2 = (String)Dts.get(paramString);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            ae.i("MicroMsg.WalletBankLogoStorage", "can not get from bankLogoCache %s", new Object[] { paramString });
            localObject2 = ak.getContext().getSharedPreferences("bank_logo", 0).getString(paramString, "");
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            ae.w("MicroMsg.WalletBankLogoStorage", "get from sp %s", new Object[] { paramString });
            Dts.put(paramString, localObject2);
            localObject1 = localObject2;
            break;
          }
          bool1 = false;
          continue;
          paramContext = null;
        }
        catch (JSONException paramContext)
        {
          ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "", new Object[0]);
          AppMethodBeat.o(70587);
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
  
  private static String bv(Context paramContext, String paramString)
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
        ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "getFromAssets", new Object[0]);
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
          ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
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
        ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramContext, "close", new Object[0]);
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
        ae.printErrStackTrace("MicroMsg.WalletBankLogoStorage", paramString, "close", new Object[0]);
      }
    }
  }
  
  public static String eKI()
  {
    return oGh;
  }
  
  private static void ewq()
  {
    AppMethodBeat.i(70585);
    Dts = new HashMap();
    Iterator localIterator = ak.getContext().getSharedPreferences("bank_logo", 0).getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Dts.put(localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(70585);
  }
  
  public static com.tencent.mm.plugin.wallet_core.model.e i(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70586);
    if (!paramBoolean)
    {
      paramContext = bu(paramContext, paramString);
      AppMethodBeat.o(70586);
      return paramContext;
    }
    Object localObject = null;
    if ("CITIC_CREDIT".equals(paramString))
    {
      com.tencent.mm.plugin.wallet_core.model.e locale = new com.tencent.mm.plugin.wallet_core.model.e();
      locale.DmO = 2131234634;
      locale.DmP = 2131234636;
      paramContext = bu(paramContext, paramString);
      localObject = locale;
      if (paramContext != null)
      {
        locale.wFJ = paramContext.wFJ;
        localObject = locale;
      }
    }
    AppMethodBeat.o(70586);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */