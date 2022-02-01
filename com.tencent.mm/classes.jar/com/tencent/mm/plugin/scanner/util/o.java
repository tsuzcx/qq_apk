package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  public static String wbl = "title";
  public static String wbm = "tip";
  public static String wbn = "buttonTitle";
  private static Boolean wbo = null;
  private static Boolean wbp = null;
  
  public static boolean Lu(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 8) || (paramInt == 4);
  }
  
  public static void aX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(52076);
    com.tencent.mm.ui.base.h.a(paramContext, paramString, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(52071);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(52071);
      }
    });
    AppMethodBeat.o(52076);
  }
  
  public static boolean am(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(52075);
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      ad.e("MicroMsg.ScannerUtil", "list == null || list.size() == 0");
      AppMethodBeat.o(52075);
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      a locala = (a)paramArrayList.get(i);
      if ((locala != null) && (yQ(locala.lpz)))
      {
        AppMethodBeat.o(52075);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(52075);
    return false;
  }
  
  public static a amQ(String paramString)
  {
    AppMethodBeat.i(52073);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52073);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      a locala = new a();
      locala.nrr = paramString.optString("card_tp_id");
      locala.lpz = paramString.optInt("card_type");
      locala.dyd = paramString.optString("card_ext");
      AppMethodBeat.o(52073);
      return locala;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52073);
    }
    return null;
  }
  
  public static ArrayList<a> amR(String paramString)
  {
    AppMethodBeat.i(52074);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(52074);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("card_list");
      if ((paramString == null) || (paramString.length() == 0))
      {
        ad.e("MicroMsg.ScannerUtil", "parseCardListItemArray cardItemListJson is null");
        AppMethodBeat.o(52074);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        a locala = new a();
        locala.nrr = localJSONObject.optString("card_tp_id");
        locala.lpz = localJSONObject.optInt("card_type");
        locala.dyd = localJSONObject.optString("card_ext");
        localArrayList.add(locala);
        i += 1;
      }
      AppMethodBeat.o(52074);
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScannerUtil", paramString, "", new Object[0]);
      AppMethodBeat.o(52074);
    }
    return null;
  }
  
  public static boolean dnn()
  {
    AppMethodBeat.i(52078);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("EnableNewOCRTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerUtil", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.eFu() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.eFu()))) {
        break;
      }
      AppMethodBeat.o(52078);
      return true;
    }
    AppMethodBeat.o(52078);
    return false;
  }
  
  public static void dno()
  {
    AppMethodBeat.i(195440);
    dnq();
    dns();
    AppMethodBeat.o(195440);
  }
  
  public static boolean dnp()
  {
    AppMethodBeat.i(52079);
    ad.i("MicroMsg.ScannerUtil", "alvinluo showScanGoodsTab %b", new Object[] { wbo });
    if (wbo == null) {
      dnq();
    }
    boolean bool = wbo.booleanValue();
    AppMethodBeat.o(52079);
    return bool;
  }
  
  private static void dnq()
  {
    AppMethodBeat.i(52080);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psp, 0);
    if (i != 1) {}
    for (boolean bool = true;; bool = false)
    {
      wbo = Boolean.valueOf(bool);
      ad.i("MicroMsg.ScannerUtil", "alvinluo updateShowScanGoodsTabSwitch clicfg_disable_scan_goods_tab config: %d, show: %b", new Object[] { Integer.valueOf(i), wbo });
      AppMethodBeat.o(52080);
      return;
    }
  }
  
  public static boolean dnr()
  {
    AppMethodBeat.i(195441);
    if (wbp == null) {
      dns();
    }
    boolean bool = wbp.booleanValue();
    AppMethodBeat.o(195441);
    return bool;
  }
  
  private static void dns()
  {
    AppMethodBeat.i(195442);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psB, 0);
    if ((i != 0) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      wbp = Boolean.valueOf(bool);
      ad.i("MicroMsg.ScannerUtil", "alvinluo updateEnableMultiCode clicfg_scan_code_multi_code_enable config: %d, enable: %b", new Object[] { Integer.valueOf(i), wbp });
      AppMethodBeat.o(195442);
      return;
    }
  }
  
  public static String it(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52077);
    Object localObject2 = com.tencent.mm.m.g.Zd().getValue("ScanBookWording");
    ad.i("MicroMsg.ScannerUtil", "scan image dynamic wording: " + bt.nullAsNil((String)localObject2));
    Object localObject1 = paramString2;
    if (!bt.isNullOrNil((String)localObject2))
    {
      localObject2 = ((String)localObject2).split("&");
      localObject1 = paramString2;
      if (localObject2 != null)
      {
        localObject1 = new HashMap();
        int i = 0;
        while (i < localObject2.length)
        {
          String[] arrayOfString = localObject2[i].split("=");
          if (arrayOfString.length == 2) {
            ((Map)localObject1).put(arrayOfString[0], arrayOfString[1]);
          }
          i += 1;
        }
        paramString1 = (String)((Map)localObject1).get(paramString1);
        localObject1 = paramString2;
        if (!bt.isNullOrNil(paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    AppMethodBeat.o(52077);
    return localObject1;
  }
  
  public static boolean yQ(int paramInt)
  {
    AppMethodBeat.i(52072);
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      boolean bool = localb.yQ(paramInt);
      AppMethodBeat.o(52072);
      return bool;
    }
    AppMethodBeat.o(52072);
    return false;
  }
  
  public static final class a
  {
    public String dyd;
    public int lpz;
    public String nrr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */